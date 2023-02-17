function setQuantity() {
    var choseValue = document.getElementById("selectsize").value;
    var quantity = choseValue.split("-")[1];
    if (parseInt(quantity) == 0) {
        document.getElementById("disableCart").style.display = "block";
    } else {
        document.getElementById("addCart").style.display = "block";
    }
    document.getElementById("selectQuantity").max = parseInt(quantity);

}

