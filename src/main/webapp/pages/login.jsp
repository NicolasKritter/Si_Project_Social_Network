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
	<form id="formulaire" class="pure-form" method="post" action="/utilisateur/login">
    <fieldset>


        <input id="login" type="text"  placeholder="Login" name="login"  required>
        <input id="password"  type="password"  placeholder=" Password" name="password" required>
	

        <button id="submit" type="submit" class="pure-button pure-button-primary" >Login</button>
    </fieldset>

</form>
</div>
          </section>


</body>
</html>
</html>
