<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <title>Metacube Parking System</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        let id, user, x, ide;

        function validate() {

            var firstname = document.getElementById('firstname').value;
            var lastname = document.getElementById('lastname').value;

            user = firstname;

            var patt1 = /[0-9]/g;
            var result = firstname.match(patt1);
            var result2 = lastname.match(patt1);

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
            } else {
                return true;
            }

        }

        function display() {
            if (validate() == true) {
                swal("Successful Login", {
                    icon: "success",
                });
                document.getElementById('searchForm').style.display = 'none';
                document.getElementById('searchForm').submit();
            }
        }
    </script>
</head>

<body>

    <form id="searchForm" action="sad">
        <h2>Search Student</h2>
        <label> <input id="firstname" type="text" name="firstname" placeholder="First Name" required /><br/></label>
        <label><input type="text" id ="lastname" name="lastname" placeholder="Last Name" required/><br/></label>
        <label> <input type="button" value="Submit" onclick="display()" /></label>
    </form>

</body>

</html>