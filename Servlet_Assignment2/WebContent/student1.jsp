<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
    <title>Student Registration System</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        let id, user, x, ide;

        function validate() {

            var firstname = document.getElementById('firstName').value;
            var lastname = document.getElementById('lastName').value;
            var fathername = document.getElementById('fatherName').value;
            var empemail = document.getElementById('2').value;
            var class1 = document.getElementById('class').value;
            var age = document.getElementById('age').value;

            user = firstname;

            var patt1 = /[0-9]/g;
            var result = firstname.match(patt1);
            var result2 = lastname.match(patt1);
            var result3 = fathername.match(patt1);

            var atpos = empemail.indexOf("@");
            var dotpos = empemail.lastIndexOf(".");

            if (firstname == null || firstname == "") {
                alert(" first name cant be blank");
                return false;
            } else if (firstname.length < 2) {
                alert("first name must be min of 2 letters");
                return false;
            } else if (result != null) {
                alert("no numbers for first name");
                return false;
            } else if (lastname == null || lastname == "") {
                alert(" last name cant be blank");
                return false;
            } else if (lastname.length < 2) {
                alert("last name must be min of 2 letters");
                return false;
            } else if (result2 != null) {
                alert("no numbers for last name");
                return false;
            } else if (fathername == null || fathername == "") {
                alert(" father's name cant be blank");
                return false;
            } else if (fathername.length < 2) {
                alert("father's name must be min of 2 letters");
                return false;
            } else if (result3 != null) {
                alert("no numbers for father's name");
                return false;
            } else if (empemail == null || empemail == "") {
                alert("email cant be blank");
                return false;
            } else if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= empemail.length) {
                alert("Please enter valid email address");
                return false;
            } else if (class1 == null || class1 == "") {
                alert("class cant be blank");
                return false;
            } else if (isNaN(class1)) {
                alert("class must contains numbers");
                return false;
            } else if (age == null || age == "") {
                alert("age cant be blank");
                return false;
            } else if (isNaN(age)) {
                alert("age must contains numbers");
                return false;
            } else {
                return true;
            }

        }

        function studentRegister() {

            if (validate() == true) {
                console.log("aa");
                document.getElementById('AddStudentForm').style.display = 'none';
                swal("Successful submission", {
                    icon: "success",
                });
              //  document.location.href = "student2.html";
                document.getElementById('AddStudentForm').submit();
            }

        }
    </script>
</head>

<body>

    <form id="AddStudentForm" action="add">
        <h2>Add Student Form</h2>
        <label> <input id="firstName" type="text" name="firstName" placeholder=" First Name" required /><br/></label>
        <label> <input id="lastName" type="text" name="lastName" placeholder="Last Name" required /><br/></label>
        <label> <input id="fatherName" type="text" name="fatherName" placeholder="Father's Name" required /><br/></label>
        <label><input type="email" id="2" placeholder="Email" name="email"required/><br/></label>
        <label><input type="text" id="class" name="class" placeholder="Class" required/><br/></label>
        <label> <input id="age" type="text" name="age"placeholder="Age" required /><br/></label>
        <label><input type="button" id="1" value="Submit" onclick="studentRegister()" /></label>
    </form>

</body>

</html>