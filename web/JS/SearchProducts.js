
$(document).ready(function () {
    $("#search-input").on('input', function () {
        var productName = $('#search-input').val();

        // Using the core $.ajax() method
        $.ajax({
            // The URL for the request
            url: "/FashionShop_1TestTing/searchProduct",
            // set data to send to servlet
            data: {productName: productName},
            // Whether this is a POST or GET request
            type: "POST"
        })
                // Code to run if the request succeeds (is done);
                // The response is passed to the function
                .done(function (data) {
                    console.log(data);
                    $("#box-product-search").html(data);
                })
    })

    $("#buttonFilter").on('click', function () {

        if ($("#inputPrice-search-min").val() == "" && $("#inputPrice-search-max").val() == "") {
            $(".textDanger-productPrice-search").text("Input price to apply")
            return;
        }

        var minPrice = $("#inputPrice-search-min").val();
        var maxPrice = $("#inputPrice-search-max").val();

        var productNameInSearch = $("#search-input").val();

        // price are = 0
        if ($("#inputPrice-search-min").val() != "" || $("#inputPrice-search-max").val() != "") {
            if (isNaN(minPrice) || isNaN(maxPrice)) {
                $(".textDanger-productPrice-search").text("Not a price")
                return false;
            }
            if (minPrice.charAt(0) == '0' || maxPrice.charAt(0) == '0') {
                $(".textDanger-productPrice-search").text("Not a price")
                return false;
            }
        }
        // Using the core $.ajax() method
        $.ajax({
            // The URL for the request
            url: "/FashionShop_1TestTing/filterProductBySearch",

            // set data to send to servlet
            data: {minPrice: minPrice, maxPrice: maxPrice, productNameInSearch: productNameInSearch},

            // Whether this is a POST or GET request
            type: "POST"
        })
                // Code to run if the request succeeds (is done);
                // The response is passed to the function
                .done(function (data) {
                    console.log(data);
                    $("#box-product-search").html(data);
                })
                // Code to run if the request fails; the raw request and
                // status codes are passed to the function
                .fail(function (xhr, status, errorThrown) {
                    alert("Sorry, there was a problem!");
                    console.log("Error: " + errorThrown);
                    console.log("Status: " + status);
                    console.dir(xhr);
                });
    });
    $('body').click(function (event) {

        if (event.target.id == "buttonFilter") {
            return;
        } else {
            $(".textDanger-productPrice-search").text("");
        }
    });

    $("#search-input").on('input', function () {
        $("#btn-new-searchId").click(function () {

            var productNameInSearch = $("#search-input").val();
            // Using the core $.ajax() method
            $.ajax({

                // The URL for the request
                url: "/FashionShop_1TestTing/filterProductBySearch",

                // set data to send to servlet
                data: {productNameInSearch: productNameInSearch},

                // Whether this is a POST or GET request
                type: "GET"
            })
                    // Code to run if the request succeeds (is done);
                    // The response is passed to the function
                    .done(function (data) {
                        $("#box-product-search").html(data);
                    })
        })
    });

});


