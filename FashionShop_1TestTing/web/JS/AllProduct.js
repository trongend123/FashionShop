/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {

    $("#buttonFilter").click(function () {
       
        var season = $('#seasonId').val();

        var price = $('#priceId').val();

        var gender = $('#genderId').val();

        var size = $('#sizeId').val();

        var categoryId = $('#buttonFilter').val();

        console.log({season: season, price: price, gender: gender, size: size, categoryId: categoryId});
        
         // Using the core $.ajax() method
        $.ajax({

            // The URL for the request
            url: "/FashionShop_1TestTing/category",

            // set data to send to servlet
            data: {season: season, price: price, gender: gender, size: size, categoryId: categoryId},

            // Whether this is a POST or GET request
            type: "POST"
        })
                // Code to run if the request succeeds (is done);
                // The response is passed to the function
                .done(function (data) {
                    console.log(data);
            
                    $("#product-box").html(data);

                })
                // Code to run if the request fails; the raw request and
                // status codes are passed to the function
                .fail(function (xhr, status, errorThrown) {
                    alert("Sorry, there was a problem!");
                    console.log("Error: " + errorThrown);
                    console.log("Status: " + status);
                    console.dir(xhr);
                })

    })


});