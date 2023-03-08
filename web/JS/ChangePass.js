/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {


    $("#changePass-submit-buttonId").on("click", () => {
        checkForm();
    });




    checkPassWord = () => {

        // old pass empty
        if ($("#editOldPassWordId").val() == "") {
            $("#textDanger-oldPass").text("Pass could not be empty!")
        } else if ($("#editOldPassWordId").val() != "") {
            $("#textDanger-oldPass").text("")
        }


        //new pass empty
        if ($("#editNewPassWordId").val() == "") {
            $("#textDanger-newPassWord").text("new pass could not be empty!")
        } else if ($("#editNewPassWordId").val() != "") {
            $("#textDanger-newPassWord").text("")
        }

        if ($("#editNewPassWordId").val() != '' && $("#editOldPassWordId").val() != '') {
            // new pass must be match format
            if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test($("#editNewPassWordId").val())) {
                $("#textDanger-newPassWord").text("Length 6-20 char and from a-z")
            } else {
                $("#textDanger-newPassWord").text("")
                return 1;
            }
        }
    }






    checkForm = () => {
        let passWord = checkPassWord();
        // all fileds are equal format and not empty
        if (passWord == 1) {
            $("#formChangePass").submit();
        }
    }

});
