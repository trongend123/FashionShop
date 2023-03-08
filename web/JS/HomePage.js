/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function () {
    $.post("/FashionShop_1TestTing/setUpHomePage", function (data) {
        console.log(data);
        let substrings = data.split('\r\n');
        $(function () {
            var availableTags = substrings;
            $("#search-input").autocomplete({
                source: availableTags
            });
        });
    });
});