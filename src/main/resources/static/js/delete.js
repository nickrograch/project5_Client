

function deleteUser(id) {
    $.ajax({
        url: "http://localhost:8075/api/v1/admin/delete/" + id,
        headers: {
            'Authorization': token,
        },
        type: 'Delete',
        contentType: 'application/json;',
        async: true,
        cache: false,
        success: function () {
            getTable();
        },
        error: function (error) {
            console.log(error);
        }
})}