<#macro modalConfirmAction actionTitle, actionUrl>
    <div class="modal fade" id="clearAllModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
                </div>
                <div class="modal-body">
                    <form method="post" action="${actionUrl}">
                        <br>
                        <input class="btn btn-primary" type="submit" value="${actionTitle}">
                    </form>
                </div>
            </div>
        </div>
    </div>
</#macro>
