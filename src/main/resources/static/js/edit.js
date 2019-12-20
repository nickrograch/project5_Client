function updateForm(id) {
    let user = {
        'id': $(`#updateId${id}`).val(),
        'name': $(`#updateName${id}`).val(),
        'password': $(`#updatePassword${id}`).val(),
        'email': $(`#updateEmail${id}`).val()
    };

    let role = $(`#updateRole${id}`).val();
    $.ajax({
        type: 'PUT',
        url: "http://localhost:8075/api/v1/admin/edit/" + role,
        contentType: 'application/json;',
        data: JSON.stringify(user),
        headers: {
            'Authorization': token,
        },
        async: false,
        cache: false,
        success: function () {
             $('.modal-backdrop').remove();
            getTable();
        },
        error: function (error) {
            console.log(error);
        }
    })};
