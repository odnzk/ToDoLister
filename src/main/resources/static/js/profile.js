document.addEventListener('DOMContentLoaded', event => {

    const confirmUserAction = (actionMethod, actionUrl) => {
        if (confirm('Are you sure?')) {
            const form = document.createElement('form');
            form.method = actionMethod;
            form.action = actionUrl;
            document.body.appendChild(form);
            form.submit();
        } else {
            window.location.href = '/profile';
        }
    };

    document.addEventListener('click', event => {
        switch (event.target.id) {
            case 'logout':
                confirmUserAction('GET', '/logout');
                break;
            case 'delete':
                confirmUserAction('DELETE', '/profile');
                break;
            default:
                break;
        }
    });
});

