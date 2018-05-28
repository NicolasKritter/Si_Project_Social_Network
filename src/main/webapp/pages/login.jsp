<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet"  type="text/css" href="/resources/css/main.css" />
</head>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<body>



	<section >
	<div class="form-style">
		  <h2 >${message}</h2>
	<form id="formulaire" class="pure-form" method="post">
    <fieldset>


        <input id="txtNewPassword" type="password" onchange="validatePassword()" placeholder="Password" name="password"  required>
        <input id="txtConfirmPassword"  type="password" onchange="validatePassword()" placeholder="Confirm Password" required>
		<span id='message'></span>
		<input type="number" value="${id}" name="id" hidden style="display:none">

        <button id="submit" type="submit" class="pure-button pure-button-primary" onclick="validatePassword()">Submit New Password</button>
    </fieldset>
	 <div id="globalError" 
          ></div>
</form>
</div>
          </section>
<script>
var isDone=${done};
if(isDone){
	document.getElementById("submit").disabled = true;
	document.getElementById("txtNewPassword").disabled = true;
	document.getElementById("txtConfirmPassword").disabled = true;
	document.getElementById("formulaire").style.display="none";
}
document.getElementById("submit").disabled = true;

function validatePassword(){
	var passwordMain = document.getElementById("txtNewPassword").value;
	var passwordCheck = document.getElementById("txtConfirmPassword").value;
	var btnSubmit =  document.getElementById("submit")
	var errorTxt = document.getElementById("globalError");
	if (passwordMain ===passwordCheck){
		errorTxt.textContent="";
		document.getElementById("submit").disabled = false;
	}else{
		errorTxt.textContent="Password must match";
		document.getElementById("submit").disabled = true;
	}
}
</script>

</body>
</html>
</html>
