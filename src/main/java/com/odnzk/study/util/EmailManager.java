package com.odnzk.study.util;

import com.odnzk.study.exception.EmailSendingException;
import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
@PropertySource("classpath:todolister.properties")
@RequiredArgsConstructor
public class EmailManager {
    private final static String API_KEY_QUERY = "apikey";
    private final static String FTLH_TEMPLATE_FILE = "restore_password_form";

    private final FreeMarkerConfigurer freeMarkerConfigurer;
    private final UserRepository repository;

    @Value("${email.api.key}")
    private String apiKey;
    @Value("${email.base.url}")
    private String url;

    private final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
        Request originalRequest = chain.request();
        HttpUrl modifiedUrl = originalRequest.url().newBuilder().addQueryParameter(API_KEY_QUERY, apiKey).build();
        Request modifiedRequest = originalRequest.newBuilder().url(modifiedUrl).build();
        return chain.proceed(modifiedRequest);
    }).build();

    public void sendEmail(String username) throws IOException {
        UserEntity user = repository.findByUsername(username).orElseThrow(() -> new EntityDoesNotExistException("User with this username does not exist"));
        String htmlTemplate = generateResetPasswordForm(username);
        RequestBody formBody = new FormBody.Builder()
                .add("to", user.getEmail())
                .add("from", "TodoLister")
                .add("subject", "Restore your password")
                .add("bodyHtml", htmlTemplate).build();
        Request request = new Request.Builder().url(url).post(formBody).build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            // todo
            log.warn("ERROR while sending email");
            throw new EmailSendingException("Error while sending an email");
        }
    }

    private String generateResetPasswordForm(String username) {
        try {
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template tmpl = configuration.getTemplate(FTLH_TEMPLATE_FILE);
            Map<String, Object> model = new HashMap<>();
            model.put("username", username);
            StringWriter out = new StringWriter();
            tmpl.process(model, out);
            return out.toString();
        } catch (TemplateException | IOException e) {
            throw new EmailSendingException("Cannot create template to reset password");
        }
    }
}
