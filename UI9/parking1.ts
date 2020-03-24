var idOfInput;

class employeeDetails {
    private name: string;
    private gender: string;
    private email: string;
    private password: string;
    private contactNumber: number;

    public get getname():string
    {
        return this.name;
    }

    public get getgender():string
    {
        return this.gender;
    }

    public get getemail():string
    {
        return this.email;
    }

    public get getpassword():string
    {
        return this.password;
    }

    public get getcontactNumber():number
    {
        return this.contactNumber;
    }

 
    public set setname(value:string)
    {
        this.name = value;
    }

    public set setgender(value:string)
    {
        this.gender = value;
    }

    public set setemail(value:string)
    {
        this.email = value;
    }

    public set setpassword(value:string)
    {
        this.password = value;
    }

    public set setcontactNumber(value:number)
    {
        this.contactNumber = value;
    }
}

class vehicleDeatails {
    private vehiclename: string;
    private vehicleType: string;
    private vehiclenumber: number;
    private Identification:string;

    public get getvehiclename():string
    {
        return this.vehiclename;
    }

    public get getvehicleType():string
    {
        return this.vehicleType;
    }

    public get getvehiclenumber():number
    {
        return this.vehiclenumber;
    }

    public get getIdentification():string
    {
        return this.Identification;
    }


    public set setvehiclename(value:string)
    {
        this.vehiclename = value;
    }

    public set setvehicleType(value:string)
    {
        this.vehicleType = value;
    }

    public set setvehiclenumber(value:number)
    {
        this.vehiclenumber = value;
    }

    public set setIdentification(value:string)
    {
        this.Identification = value;
    }

}

class planDetails {
    private currencyType: string;
    private plan: string;
    private price: number;

    public get getcurrencyType():string
    {
        return this.currencyType;
    }

    public get getprice():number
    {
        return this.price;
    }

    public get getplan():string
    {
        return this.plan;
    }


    public set setcurrencyType(value:string)
    {
        this.currencyType = value;
    }

    public set setplan(value:string)
    {
        this.plan = value;
    }

    public set setprice(value:number)
    {
        this.price = value;
    }
}

class planValue {
    private daily: number;
    private monthly: number;
    private yearly: number;

    constructor() {
        this.daily = 5;
        this.monthly = 100;
        this.yearly = 500;
    }

    public get getdaily():number
    {
        return this.daily;
    }

    public get getmonthly():number
    {
        return this.monthly;
    }

    public get getyearly():number
    {
        return this.yearly;
    }
}

let employeeOne = new employeeDetails();
let vehicleOne = new vehicleDeatails();
let planOne = new planDetails();
let planValueOne = new planValue();

function hideFullName(event: any){

    var char = event.keyCode;
    idOfInput = event.target.id;
    if (char == '13') {
        switchcase(idOfInput, event);

    }

}

function mygender(event) {
    employeeOne.setgender = event.target.value;
    idOfInput = event.target.id;

    switchcase(idOfInput, event);

}

function Type(event) {

    idOfInput = event.target.id;
    switchcase(idOfInput, event);
}

function validatePassword(event) {
    employeeOne.setpassword = event.target.value;

    document.getElementById("mypassword").style.borderWidth = "thick";
    if (employeeOne.getpassword.length < 7) {

        document.getElementById("mypassword").style.borderColor = "red";
        document.getElementById("error").innerHTML = "password should be of min 8 characters";

    } else if (!(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/.test(employeeOne.getpassword))) {

        document.getElementById("mypassword").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "password should contains Uppercase, Lowercase, Numeric";

    } else {
        document.getElementById("error").innerHTML = "Strong Password";
        document.getElementById("mypassword").style.borderColor = "green";
        if (event.keyCode == '13') {
            var string = "Hi " + employeeOne.getname + "( " + employeeOne.getgender + " ) can You confirm your password ";
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
        x.innerHTML = "Price of Plan of type :"+plan + " is : " + planValueOne.getdaily + " Rs";
    } else if (plan == "Montly") {        
        x.innerHTML = "Price of Plan of type :" + plan + " is : " + planValueOne.getmonthly + " Rs";
    } else if(plan == "yearly"){
        x.innerHTML = "Price of Plan of type :" + plan + " is : " + planValueOne.getyearly + " Rs";
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

function onloaad() {
    document.body.style.backgroundColor = "#577284";
    document.getElementById("name").focus();
}

function switchcase(idOfInput, event) {

    switch (idOfInput) {
        case 'name':
            {
                employeeOne.setname = event.target.value; 

                if (!(/^[A-z ]{2,}$/.test(employeeOne.getname))) {
                    document.getElementById("error").innerHTML = "Please enter valid name!";
                } else {
                    document.getElementById("error").innerHTML = "";
                    var string = "Hi " + employeeOne.getname + " ,Please select your gender.";

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
                employeeOne.setgender = event.target.value;
                var string = "Hi " + employeeOne.getname + "( " + employeeOne.getgender + " ) ,Please enter your email.";
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
                employeeOne.setgender = event.target.value;
                var string = "Hi " + employeeOne.getname + "( " + employeeOne.getgender + " ) ,Please enter your email.";
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
                employeeOne.setemail = event.target.value;

                if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(employeeOne.getemail))) {
                    document.getElementById("error").innerHTML = "Please enter valid email address.";
                } else {
                    document.getElementById("error").innerHTML = "";
                    var string = "Hi " + employeeOne.getname + "( " + employeeOne.getgender + " ), Please enter your password: " + employeeOne.getemail;
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
                var employeeMatchPassword = event.target.value
                if (employeeMatchPassword == employeeOne.getpassword) {
                    var string = "Hi " + employeeOne.getname + "( " + employeeOne.getgender + " ), Please enter your contact number.";
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
                    document.getElementById("error").innerHTML = "Password Don't match.";
                }

            }
            break;
        case 'contactNumber':
            {
                employeeOne.setcontactNumber = event.target.value;
                var string = "Hi " + employeeOne.getname + ", Please enter your vehicle number.";
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
                vehicleOne.setvehiclename = event.target.value;
                var string = "Hi " + employeeOne.getname + " with vehicle number:" + vehicleOne.getvehiclename + " , Please select vehicle name.";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourVehicleName"); //Get the element
                e.setAttribute("id", "yourVehicleType");

                x = document.createElement("select");
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
                vehicleOne.setvehicleType = event.target.value;
                var string = "Hi " + employeeOne.getname + " with vehicle name: " + vehicleOne.getvehiclename + " and vehicle type: " + vehicleOne.getvehicleType + ", Please enter your type of vehicle.";
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
                vehicleOne.setvehiclenumber = event.target.value;
                var string = "Hi " + employeeOne.getname + " with vehicle name: " + vehicleOne.getvehiclename + " and vehicle type: " + vehicleOne.getvehicleType + " Now you can choose currency type: ";
                document.getElementById("data").innerHTML = string;

                var e = document.getElementById("yourVehicleNumber"); //Get the element
                e.setAttribute("id", "yourCurrencyType");

                x = document.createElement("select");
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
                planOne.setcurrencyType = event.target.value;
                var string = "Hi " + employeeOne.getname + " Please choose a plan for you: ";

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
        var cur = planOne.getcurrencyType;
        switch (cur) {
            case "INR":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + planValueOne.getdaily;
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + planValueOne.getmonthly;
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + planValueOne.getyearly;
                break;
            case "USD":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + (planValueOne.getdaily / 71.74).toFixed(2);
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + (planValueOne.getmonthly / 71.74).toFixed(2);
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + (planValueOne.getyearly / 71.74).toFixed(2);
                break;
            case "YEN":
                document.getElementById("dailyPL").innerHTML = "Daily price : " + (planValueOne.getdaily / 0.68).toFixed(2);
                document.getElementById("montlyPL").innerHTML = "Monthly price : " + (planValueOne.getmonthly / 0.68).toFixed(2);
                document.getElementById("yearlyPL").innerHTML = "Yearly price : " + (planValueOne.getyearly / 0.68).toFixed(2);
                break;
        }
    }

}