function reload(){
    location.reload();
}
function sweetalert_success(mess ="Thành công !"){
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: mess,
        showConfirmButton: false,
        timer: 1500
    },reload())
}
function sweetalert_err(mess ="Thất bại !"){
    Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: mess,
        showConfirmButton: false,
        timer: 1500
    })
}
/**
 * super admin update user
 */
function delete_user(id){
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if(result.value){
            var user = {
                "id" : id
            };
            $.ajax({
                url : '/admin/user/delete',
                method : 'POST',
                dataType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(user),
                success: function(res) {
                    if(res){
                        sweetalert_success("Xóa thành công !");
                    }else{
                        sweetalert_err()
                    }
                },
                error: function(request, status, error) {
                    alert("Not Call API");
                }
            })
            // location.reload();
        }

    });
}

function showuser(id){

    document.getElementById("idUpdateUser").value = id;
    document.getElementById("user_name_modal").innerHTML = document.getElementById("user_name_"+id).innerText;
    // document.getElementById("user_full_name_modal").value = document.getElementById("user_full_name_"+id).innerText;
}

/**
 * Super admin create amdin
 */
function createUser(){
    var userCreate ={
        "name":document.getElementById("username_create_frm").value,
        "salary":parseFloat(document.getElementById("fullname_create_frm").value)
    };

    $.ajax({
        url : '/api/public/addEmployee',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json; charset=utf-8',
        data : JSON.stringify(userCreate),
        success: function(res) {
            if(res.status == 1){
                sweetalert_success(res.message);
            }else{
                sweetalert_err();
            }
        },
        error: function(request, status, error) {
            alert("Not Call API");
        }
    })
};

/**
 * Super admin update amdin
 */
function updateUser(){
    var userupdate ={
        "id":document.getElementById("idUpdateUser").value,
        "fullname":document.getElementById("user_full_name_modal").value,
        "email":document.getElementById("user_email_modal").value
    }

    // $.ajax({
    //     url : '/admin/user/update',
    //     method : 'POST',
    //     dataType : 'json',
    //     contentType : 'application/json; charset=utf-8',
    //     data : JSON.stringify(userupdate),
    //     success: function(res) {
    //         if(res.status == 1){
    //             sweetalert_success(res.message);
    //         }else{
    //             sweetalert_err(res.message);
    //         }
    //     },
    //     error: function(request, status, error) {
    //         alert("Not Call API");
    //     }
    // })
};
