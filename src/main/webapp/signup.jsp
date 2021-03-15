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
                    <h3>Sign Up</h3>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/SignUpController" method="POST" class="was-validated">
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text dark"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="email" class="form-control" placeholder="Mail" name="mail" value="" required>

                        </div>
                        <div class="input-group form-group">
                            <div class="input-group-prepend dark">
                                <span class="input-group-text dark"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" class="form-control" placeholder="Password" value="" name="pwd" required>
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" value="Register" class="btn btn-dark">
                        </div>
                    </form>
                <div class="card-footer">
                    <div class="d-flex justify-content-center links" method="POST">
                        <form action="<%=request.getContextPath()%>/LoginController"" method="POST">
                            <button class="btn btn-dark">Sign In</button>
                        </form>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
