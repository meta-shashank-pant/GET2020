function registration(){
      
            ID = Math.floor((Math.random() * 10000) + 1);;
            var name = document.getElementById('Name').value;
            var namePattern = /^[A-Za-z0-9. ]{2,}$/;
            if(!namePattern.test(name)){
                alert("Enter valid Name");
                return;
            }

            var email= document.getElementById("EmailID").value;
            var emailPattern = /^[A-Za-z_.0-9]{2,}@[A-Za-z_]{3,10}[.]{1}[A-Za-z.]{2,6}$/;
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

            
            swal("1st step done",{
                icon: "success",
            });
            
        }
