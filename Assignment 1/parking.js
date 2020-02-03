        let ID = 0;
        let Daily , Monthly , Yearly ;
        let USD = 0.013, YEN = 1.54;

        function registration(){
      
            ID = Math.floor((Math.random() * 10000) + 1);;
            var name = document.getElementById('Name').value;
            var namePattern = /^[A-Za-z ]{2,}$/;
            if(!namePattern.test(name)){
                alert("Enter valid Name");
                return;
            }

            var email= document.getElementById("EmailID").value;
            var emailPattern = /^[A-za-z_.0-9]{3,}@[A-za-z]{3,10}[.]{1}[A-za-z.]{2,6}$/;
            if(!emailPattern.test(email)){
                alert("Enter valid Email ID");
                return;
            }

            var password = document.getElementById('Password').value;
            var ConfirmPassword = document.getElementById('ConfirmPassword').value;
            if(password != ConfirmPassword){
                alert("Password does not match");
                return;
            }

            var number = document.getElementById("MobileNumber").value;
            var numberPattern = /^[0-9]{10,14}$/;
            if(!numberPattern.test(number)){
                alert("Enter valid Number");
                return;
            }

            
            document.getElementById('containRegistrationForm').style.display = 'none';
            swal("1st step done",{
                icon: "success",
            });
            document.getElementById('VehicleForm').style.display = 'block';
            document.getElementById('empId').placeholder = ID;
        }

        function getPass(){

            var vehiclePass = document.getElementById('VehicleName');
            var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text; 
            var vehiclePrice = document.getElementById('VehicleCurrency');
            var vehiclePriceType = vehiclePrice.options[vehiclePrice.selectedIndex].text; 
            if(vehiclePassType == 'Cycle'){
                document.getElementById("heading").innerHTML = "Cycle Pass";
                Daily = 5;
                Monthly = 100;
                Yearly = 500;
            }
            else if(vehiclePassType == 'MotorCycle'){
                document.getElementById("heading").innerHTML = "MotorCycle Pass";
                Daily = 10;
                Monthly = 200;
                Yearly = 1000;
            }
            else if(vehiclePassType == 'Four Wheelers'){
                document.getElementById("heading").innerHTML = "Four Wheelers Pass";
                Daily = 20;
                Monthly = 500;
                Yearly = 3500;
            }
            if(vehiclePriceType == 'INR'){
                document.getElementById("myButton1").value = Daily ;
                document.getElementById("myButton2").value = Monthly ;
                document.getElementById("myButton3").value = Yearly;
            }
            else if(vehiclePriceType == 'USD'){
                document.getElementById("myButton1").value = Daily * USD;
                document.getElementById("myButton2").value = Monthly * USD ;
                document.getElementById("myButton3").value = Yearly * USD;
            }
            else if(vehiclePriceType == 'YEN'){
                document.getElementById("myButton1").value = Daily * YEN;
                document.getElementById("myButton2").value = Monthly * YEN;
                document.getElementById("myButton3").value = Yearly * YEN;
            }
            document.getElementById('VehicleForm').style.display = 'none';
            swal("2nd step done",{
                icon: "success",
            });
            document.getElementById('pass').style.display = 'block';

        }

        function result(answer){
            
            document.getElementById("idInReceipt").innerHTML = document.getElementById("empId").placeholder ;
            var name = document.getElementById('Name').value;
            document.getElementById("nameInReceipt").innerHTML = name ;
            var eID = document.getElementById("gender");
            var gender = eID.options[eID.selectedIndex].value;
            document.getElementById("genderInReceipt").innerHTML = gender ; 
            var mobileNumber = document.getElementById('MobileNumber').value ; 
            document.getElementById("numberInReceipt").innerHTML =  mobileNumber;
            var vehiclePass = document.getElementById('VehicleName');
            var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text;
            document.getElementById("vehicleTypeInReceipt").innerHTML = vehiclePassType;
            var vahicleNameReceipt = document.getElementById('inputVehicleName').value ;
            document.getElementById("vehicleNameInReceipt").innerHTML = vahicleNameReceipt ; 
            var vahicleNumber = document.getElementById('VehicleNumber').value;
            document.getElementById("vehicleNumberInReceipt").innerHTML = vahicleNumber ; 
            document.getElementById("priceInReceipt").innerHTML = answer ; 
            
            document.getElementById('pass').style.display = 'none';
            swal("3rd step done",{
                icon: "success",
            });
            document.getElementById('receipt').style.display = 'block';

            
        }