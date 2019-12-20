function addUser() {
    let user = {
        'name': $('#addName').val(),
        'password': $('#addPassword').val(),
        'email': $('#addEmail').val()
    };
    let role = $('#addRole').val();

    $.ajax({
        url: "http://localhost:8075/api/v1/admin/add/" + role,
        headers: {
            'Authorization': token,
        },
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(user),
        async: false,
        success: function () {
            $('[href="#tab1"]').tab('show');
            getTable();
        },
        error: function (error) {
            console.log(error);
        }
    })}