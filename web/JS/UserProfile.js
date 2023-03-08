

$(document).ready(function () {
    $(".editProfile-submit-button").on("click", () => {
        checkForm()
    });

    checkName = () => {
        // name empty
        if ($("#editNameId").val() == "") {
            $("#textDanger-Name").text("Name could not be empty!")
        } else {
            $("#textDanger-name").text("")
            return 1;
        }
    }

    checUserName = () => {
        // user name empty
        if ($("#editUserNameId").val() == "") {
            $("#textDanger-userName").text("User name could not be empty!")
        } else if ($("#editUserNameId").val() != "") {
            $("#textDanger-userName").text("")
        }
        //  length of user name > 10
        if ($("#editUserNameId").val().length < 8) {
            $("#textDanger-userName").text("Length of user name must be >=8")
        } else {
            return 1;
        }
    }

    checkEmail = () => {
        // email empty
        if ($("#editEmailId").val() == "") {
            $("#textDanger-email").text("Email could not be empty!")
        } else if ($("#editEmailId").val() != "") {
            $("#textDanger-email").text("")
            // email must be right format
            if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($("#editEmailId").val())) {
                $("#textDanger-email").text("Email must be like 'name@example'")
            } else {
                return 1;
            }
        }
    }

    checkPhoneNumber = () => {
        if ($("#editPhoneNumberId").val() == "") {
            $("#textDanger-phone").text("Phone could not be empty!")
        } else if ($("#editPhoneNumberId").val() != "") {
            $("#textDanger-phone").text("")
            // email must be right format
            if (!/(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test($("#editPhoneNumberId").val())) {
                $("#textDanger-phone").text("This not is phone number")
            } else {
                return 1;
            }
        }
    };

    checkAddressDetails = () => {
        // address name empty
        if ($("#editAddressId").val() == "") {
            $("#textDanger-addressDetails").text("Address could not be empty!")
        } else if ($("#editAddressId").val() != "") {
            $("#textDanger-addressDetails").text("");
        }
        //  length of address > 10
//        if ($("#editAddressId").val().length < 10) {
//            $("#textDanger-addressDetails").text("Length of address must be >= 10")
//        } else if ($("#editAddressId").val().length >= 10) {x
//            $("#textDanger-addressDetails").text("");
//        } else {
//            return 1;
//        }  
        if ($("#editAddressId").val().length < 10) {
            $("#textDanger-addressDetails").text("Length of address must be >= 10")
        } else {
            return 1;
        }
    };

    checkForm = () => {
        let name = checkName();
        let userName = checUserName();
        let email = checkEmail();
        let phoneNumber = checkPhoneNumber();
        let address = checkAddressDetails();
        // all fileds are equ al format and not empty
        if (name == 1 && userName == 1 && email == 1 && phoneNumber == 1 && address == 1) {
            $("#formEditProfile").submit();
        }
    };


    var renderData = (array, select) => {
        let row = ' <option value="">chọn</option>';
        // display all province
        array.forEach(element => {
            row += `<option value="${element.code}">${element.name}</option>`
        });
        document.querySelector("#" + select).innerHTML = row
    }

    var callAPI = (api) => {
        return axios.get(api)
                .then((response) => {
                    renderData(response.data, "editCityId");
                });
    }

    callAPI('https://provinces.open-api.vn/api/?depth=1');
    var callApiDistrict = (api) => {
        return axios.get(api)
                .then((response) => {
                    renderData(response.data.districts, "editDistrictId");
                });
    }

    // url to get API
    const host = "https://provinces.open-api.vn/api/";

    $("#editCityId").change(() => {
        callApiDistrict(host + "p/" + $("#editCityId").val() + "?depth=2");
    });

    $("#editDistrictId").change(() => {
        printResult();
    });


    var printResult = () => {
        if ($("#editDistrictId").val() != "" && $("#editCityId").val()) {
            let city = $("#editCityId option:selected").text();
            let distric = $("#editDistrictId option:selected").text();
            // $("#result").text(pro + ", " + distric)
            document.getElementById('city').value = city;
            document.getElementById('district').value = distric;
            console.log(city)
            console.log(distric)

        }
    }
});
