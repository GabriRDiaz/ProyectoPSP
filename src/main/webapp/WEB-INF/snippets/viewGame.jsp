<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=request.getAttribute("title")%></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7d83f7c8f5.js" crossorigin="anonymous"></script>
</head>

<body class="bg-secondary">
    <div class="centeredTitle bg-dark">
        <div class="col-md-4">
            <h1><i class="fas fa-gamepad"></i> Games List <i class="fas fa-gamepad"></i></h1>
        </div>
    </div>
    <div>
        <table class="table">
            <tbody>
                <tr>
                    <th scope="row">
                        <td>Genre</td>
                        <td><%=request.getAttribute("genre")%></td>
                    </th>
                </tr>
                <tr>
                    <th scope="row">
                        <td>Release Date</td>
                        <td><%=request.getAttribute("release")%></td>
                    </th>
                </tr>
                <tr>
                    <th scope="row">
                        <td>PEGI</td>
                        <td><%=request.getAttribute("pegi")%></td>
                    </th>
                </tr>
                <tr>
                    <th scope="row">
                        <td>Multiplayer</td>
                        <td><%=request.getAttribute("multiplayer")%></td>
                    </th>
                </tr>
            </tbody>
        </table>
    </div>
    <div>
         <a href="${pageContext.request.contextPath}/GamesController?action=main"
                class="btn btn-dark marginButton">
         Close  <i class="fas fa-arrow-left"></i></a>
        <!--<button type="button" class="btn btn-dark">Close</button>-->
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>