document.addEventListener('DOMContentLoaded', event => {

    const confirmUserAction = (actionMethod, actionUrl) => {
        if (confirm('Are you sure?')) {
            fetch(actionUrl, {
                method: actionMethod,
                headers: {'Content-Type': 'application/json'}
            })
                .catch(error => {
                    console.log("Error")
                });
        } else {
            window.location.href = '/profile';
        }
    };

    document.addEventListener('click', event => {
        switch (event.target.id) {
            case 'logout':
                if (confirm('You really want to logout?')) {
                    window.location.href = '/logout';
                }
                break;
            case 'delete':
                confirmUserAction('DELETE', '/profile');
                break;
            default:
                break;
        }
    });
});

