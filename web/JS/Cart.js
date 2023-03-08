/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function checkSubmitForm() {
    var form = document.getElementById("btnSubmitFormCart");
    form.addEventListener("click", function (event) {
        const checkboxes = document.querySelectorAll('input[type=checkbox]:checked');
        if (checkboxes.length < 1) {
            document.getElementById("textDanger-cart").innerHTML = "Please choose at least one product";
            event.preventDefault();
        } else if (checkboxes.length >= 1) {
            document.getElementById("form-cart").submit();
        }
    });
}