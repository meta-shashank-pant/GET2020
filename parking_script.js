var name, gender, email, password, contactNumber, vehiclename, vehicleType, vehiclenumber, Identification, currencyType, price;
var idOfInput;
var daily = 5;
var monthly = 100;
var yearly = 500;

function hideFullName(event) {

    var char = event.keyCode;
    idOfInput = event.target.id;
    if (char == '13') {
        switchcase(idOfInput);

    }

}

function mygender(event) {
    gender = event.target.value;
    idOfInput = event.target.id;

    switchcase(idOfInput);

}

function Type(event) {

    idOfInput = event.target.id;
    switchcase(idOfInput);
}

function validatePassword(event) {
    password = document.getElementById("mypassword").value;
    document.getElementById("mypassword").style.borderWidth = "thick";
    if (password.length < 7) {

        document.getElementById("mypassword").style.borderColor = "red";
        document.getElementById("error").innerHTML = "Password should be of min 8 characters";

    } else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{7,}/.test(password))) {

        document.getElementById("mypassword").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "Password should contains Uppercase, Lowercase, Numeric";

    } else {
        document.getElementById("error").innerHTML = "Strong Password";
        document.getElementById("mypassword").style.borderColor = "green";
        if (event.keyCode == '13') {
            var string = "Hi " + name + "( " + gender + " ), Please confirm your password.";
            document.getElementById("data").innerHTML = string;

            var e = document.getElementById("yourPassword"); //Get the element
            e.setAttribute("id", "yourConfirmPassword");

            var x = document.createElement("INPUT");
            x.setAttribute("type", "password");
            x.setAttribute("id", "confirmpassword");
            x.setAttribute("class", "w-25");
            x.setAttribute("onkeypress", "hideFullName(event)");
            e.appendChild(x);
            document.getElementById("confirmpassword").focus();

            var child = document.getElementById("mypassword")
            e.removeChild(child);
            document.getElementById("error").innerHTML = "";
        }


    }
}
function myPlan(event) {

    document.getElementById("data").innerHTML = "";

    var plan = event.target.value;

    var x = document.createElement("Label");
    x.setAttribute("id", "Price");
    x.setAttribute("class", "display-4");

    if (plan == "Daily") {
        x.innerHTML = "Price of Plan of type :"+plan + " is : " + daily + " Rs";
    } else if (plan == "Montly") {        
        x.innerHTML = "Price of Plan of type :" + plan + " is : " + monthly + " Rs";
    } else if(plan == "yearly"){
        x.innerHTML = "Price of Plan of type :" + plan + " is : " + yearly + " Rs";
    }

    var e = document.getElementById("planOption");
    var child = document.getElementById("dailyPL")
    e.removeChild(child);

    var child = document.getElementById("montlyPL")
    e.removeChild(child);

    var child = document.getElementById("yearlyPL")
    e.removeChild(child);

    var child = document.getElementById("dailyP")
    e.removeChild(child);

    var child = document.getElementById("montlyP")
    e.removeChild(child);

    var child = document.getElementById("yearlyP")
    e.removeChild(child);

    var e = document.getElementById("planOption");
    e.appendChild(x);


}

function onload() {
    document.getElementById("name").focus();
}

function switchcase(idOfInput) {

    switch (idOfInput) {
        case 'name':
            {

                name = document.getElementById("name").value;

                if (!(/^[A-z ]{2,}$/.test(name))) {
                    var e = document.getElementById("fullname");
                    document.getElementById("error").innerHTML = "Please enter valid name!";
                } else {
                    document.getElementById("error").innerHTML = "";
                    var string = "Hi " + name + ", Please select your gender.";

                    document.getElementById("data").innerHTML = string;

                    var e = document.getElementById("fullname"); //Get the element
                    e.setAttribute("id", "gender"); //Change id to gender

                    var x = document.createElement("INPUT");
                    x.setAttribute("type", "radio");
                    x.setAttribute("value", "Male");
                    x.setAttribute("id", "genderM");
                    x.setAttribute("name", "gender");
                    x.setAttribute("onclick", "mygender(event)");
                    e.appendChild(x);
                    var x = document.createElement("Label");
                    x.setAttribute("id", "Male")
                    e.appendChild(x);
                    x.innerHTML = "Male";


                    var x = document.createElement("INPUT");
                    x.setAttribute("type", "radio");
                    x.setAttribute("value", "Female");
                    x.setAttribute("id", "genderF");
                    x.setAttribute("name", "gender");
                    x.setAttribute("onclick", "mygender(event)");
                    e.appendChild(x);
                    var x = document.createElement("Label");
                    x.setAttribute("id", "Female")
                    e.appendChild(x);
                    x.innerHTML = "Female";

                    var child = document.getElementById("name");
                    e.removeChild(child);
                }

            }
            break;
        case 'genderM':
            {
                gender = document.getElementById("genderM").value;
                var string = "Hi " + name + "( " + gender + " ), Please enter your email.";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("gender"); //Get the element
                e.setAttribute("id", "youremail"); //Change id to gender


                var x = document.createElement("INPUT");
                x.setAttribute("type", "text");
                x.setAttribute("id", "email");
                x.setAttribute("class", "w-25");
                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);
                document.getElementById("email").focus();

                var child = document.getElementById("Male")
                e.removeChild(child);

                var child = document.getElementById("Female")
                e.removeChild(child);

                var child = document.getElementById("genderM")
                e.removeChild(child);

                var child = document.getElementById("genderF")
                e.removeChild(child);
            }
            // code block
            break;
        case 'genderF':
            {
                gender = document.getElementById("genderF").value;
                var string = "Hi " + name + "( " + gender + " ), Please enter your email.";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("gender"); //Get the element
                e.setAttribute("id", "youremail"); //Change id to gender


                var x = document.createElement("INPUT");
                x.setAttribute("type", "text");
                x.setAttribute("id", "email");
                x.setAttribute("class", "w-25");
                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);

                document.getElementById("email").focus();

                var child = document.getElementById("Male")
                e.removeChild(child);

                var child = document.getElementById("Female")
                e.removeChild(child);

                var child = document.getElementById("genderM")
                e.removeChild(child);

                var child = document.getElementById("genderF")
                e.removeChild(child);
            }
            // code block
            break;
        case 'email':
            {
                email = document.getElementById("email").value;

                if (!(/^[A-z_0-9]+@[A-z]+\.[A-z]+$/.test(email))) {

                    document.getElementById("error").innerHTML = "Please enter valid email address.";
                } else {
                    document.getElementById("error").innerHTML = "";
                    var string = "Hi " + name + "( " + gender + " ), Please enter your password: " + email;
                    document.getElementById("data").innerHTML = string;

                    var e = document.getElementById("youremail"); //Get the element
                    e.setAttribute("id", "yourPassword");

                    var x = document.createElement("INPUT");
                    x.setAttribute("type", "password");
                    x.setAttribute("id", "mypassword");
                    x.setAttribute("class", "w-25");
                    x.setAttribute("onkeypress", "validatePassword(event)");
                    e.appendChild(x);
                    document.getElementById("mypassword").focus();

                    var child = document.getElementById("email")
                    e.removeChild(child);
                }
            }
            break;
        case 'confirmpassword':
            {
                var employeeMatchPassword = document.getElementById("confirmpassword").value;
                if (employeeMatchPassword == password) {
                    var string = "Hi " + name + "( " + gender + " ), Please enter your contact number.";
                    document.getElementById("data").innerHTML = string;

                    var e = document.getElementById("yourConfirmPassword"); //Get the element
                    e.setAttribute("id", "yourContactNumber");

                    var x = document.createElement("INPUT");
                    x.setAttribute("type", "tel");
                    x.setAttribute("id", "contactNumber");
                    x.setAttribute("class", "w-25");
                    x.setAttribute("onkeypress", "hideFullName(event)");
                    e.appendChild(x);
                    document.getElementById("contactNumber").focus();

                    var child = document.getElementById("confirmpassword")
                    e.removeChild(child);
                    document.getElementById("error").innerHTML = "";
                } else {
                    document.getElementById("error").innerHTML = "Password Dont match.";
                }

            }
            break;
        case 'contactNumber':
            {
                document.body.style.backgroundColor = "#9F9C99";
                contactNumber = document.getElementById("contactNumber").value;
                var string = "Hi " + name + ", Please enter your vehicle number.";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourContactNumber"); //Get the element
                e.setAttribute("id", "yourVehicleName");

                var x = document.createElement("INPUT");
                x.setAttribute("type", "text");
                x.setAttribute("id", "vehiclename");
                x.setAttribute("class", "w-25");
                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);
                document.getElementById("vehiclename").focus();

                var child = document.getElementById("contactNumber")
                e.removeChild(child);
            }
            break;
        case 'vehiclename':
            {
                vehiclename = document.getElementById("vehiclename").value;
                var string = "Hi " + name + " with vehicle number:" + vehiclename + ", Please select vehicle name.";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourVehicleName"); //Get the element
                e.setAttribute("id", "yourVehicleType");

                var x = document.createElement("select");
                x.setAttribute("id", "vehicletype");
                x.setAttribute("class", "w-25");
                x.setAttribute("onselect", "Type()");

                var option1 = document.createElement("Option")
                option1.innerHTML = "Cycle"
                option1.setAttribute("value", "Cycle");
                x.appendChild(option1);

                var option2 = document.createElement("Option")
                option2.innerHTML = "MotorCycle"
                option2.setAttribute("value", "MotorCycle");
                x.appendChild(option2);

                var option3 = document.createElement("Option")
                option3.innerHTML = "FourWheelers"
                option3.setAttribute("value", "FourWheelers");
                x.appendChild(option3);

                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);

                document.getElementById("vehicletype").focus();

                var child = document.getElementById("vehiclename")
                e.removeChild(child);
            }
            break;
        case 'vehicletype':
            {
                vehicleType = document.getElementById("vehicletype").value;
                var string = "Hi " + name + " with vehicle name:" + vehiclename + " and vehicle type: " + vehicleType + ", Please enter your type of vehicle";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourVehicleType"); //Get the element
                e.setAttribute("id", "yourVehicleNumber");

                var x = document.createElement("INPUT");
                x.setAttribute("type", "text");
                x.setAttribute("id", "vehiclenumber");
                x.setAttribute("class", "w-25");
                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);
                document.getElementById("vehiclenumber").focus();
                
                var child = document.getElementById("vehicletype")
                e.removeChild(child);
            }
            break;
        case 'vehiclenumber':
            {
                document.body.style.backgroundColor = "#DDDDDD";
                vehiclenumber = document.getElementById("vehiclenumber").value;
                var string = "Hi " + name + " with vehicle name: " + vehiclename + " and type: " + vehicleType + " Now you can choose currency type: ";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourVehicleNumber"); //Get the element
                e.setAttribute("id", "yourCurrencyType");

                var x = document.createElement("select");
                x.setAttribute("class", "w-25");
                x.setAttribute("id", "currencyType");
                x.setAttribute("onselect", "Type()");

                var option1 = document.createElement("Option")
                option1.innerHTML = "YEN"
                option1.setAttribute("value", "YEN");
                x.appendChild(option1);

                var option2 = document.createElement("Option")
                option2.innerHTML = "USD"
                option2.setAttribute("value", "USD");
                x.appendChild(option2);

                var option3 = document.createElement("Option")
                option3.innerHTML = "INR"
                option3.setAttribute("value", "INR");
                x.appendChild(option3);

                x.setAttribute("onkeypress", "hideFullName(event)");
                e.appendChild(x);

                document.getElementById("currencyType").focus();

                var child = document.getElementById("vehiclenumber")
                e.removeChild(child);
            }
            break;
        case 'currencyType':
            {
                currencyType = document.getElementById("currencyType").value;
                var string = "Hi " + name + " Please choose a plan for you: ";

                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourCurrencyType"); //Get the element
                e.setAttribute("id", "planOption"); //Change id to gender

                var x = document.createElement("INPUT");
                x.setAttribute("type", "radio");
                x.setAttribute("value", "Daily");
                x.setAttribute("id", "dailyP");
                x.setAttribute("name", "price");
                x.setAttribute("onclick", "myPlan(event)");
                e.appendChild(x);
                var x = document.createElement("Label");
                x.setAttribute("id", "dailyPL")
                e.appendChild(x);

                var x = document.createElement("INPUT");
                x.setAttribute("type", "radio");
                x.setAttribute("value", "Montly");
                x.setAttribute("id", "montlyP");
                x.setAttribute("name", "price");
                x.setAttribute("onclick", "myPlan(event)");
                e.appendChild(x);
                var x = document.createElement("Label");
                x.setAttribute("id", "montlyPL")
                e.appendChild(x);

                var x = document.createElement("INPUT");
                x.setAttribute("type", "radio");
                x.setAttribute("value", "yearly");
                x.setAttribute("id", "yearlyP");
                x.setAttribute("name", "price");
                x.setAttribute("onclick", "myPlan(event)");
                e.appendChild(x);
                var x = document.createElement("Label");
                x.setAttribute("id", "yearlyPL")
                e.appendChild(x);
                convertCurrency();

                var child = document.getElementById("currencyType");
                e.removeChild(child);
            }
            break;
        default:
        // code block
    }

    function convertCurrency() {
        var cur = currencyType;
        switch (cur) {
            case "INR":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + daily;
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + monthly;
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + yearly;
                break;
            case "USD":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + (daily / 71.74).toFixed(2);
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + (monthly / 71.74).toFixed(2);
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + (yearly / 71.74).toFixed(2);
                break;
            case "YEN":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + (daily / 0.68).toFixed(2);
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + (monthly / 0.68).toFixed(2);
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + (yearly / 0.68).toFixed(2);
                break;
        }
    }

}
