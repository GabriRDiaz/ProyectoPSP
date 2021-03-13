<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>

    <!--Bootsrap 4.1.3-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome 5.3.1-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!--Sweet Alert-->

    <link rel="stylesheet" type="text/css" href="./index.css">
</head>

<body>
    <div class="container">
        <div class="d-flex justify-content-center h-100">
            <div class="card">
                <div class="card-header">
                    <h3>Sign In</h3>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/LoginController" method="POST">
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text dark"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="text" class="form-control" placeholder="Mail" name="mail" value="admin@mail.com" required>

                        </div>
                        <div class="input-group form-group">
                            <div class="input-group-prepend dark">
                                <span class="input-group-text dark"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" class="form-control" placeholder="Password" value="abc123." name="pwd" required>
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" value="Login" class="btn btn-dark">
                        </div>
                    </form>
                        <c:choose>
                            <c:when test="${isIncorrect}">
                            <div class="alert alert-dark" role="alert" name="incorrect" style= "display: flex;">
                                User or password incorrect!
                            </div>
                            </c:when>
                            <c:when test="${!isIncorrect}">
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                    </c:choose>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center links">
                        Don't have an account?<a href="#">Sign Up</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>