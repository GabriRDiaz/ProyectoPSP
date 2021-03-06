<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Game List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="./games.css">
    <script src="https://kit.fontawesome.com/7d83f7c8f5.js" crossorigin="anonymous"></script>
</head>

<body class="bg-secondary">

    <div class="centeredTitle bg-dark">
        <div class="col-md-4">
        <h1><i class="fas fa-gamepad"></i> Games List <i class="fas fa-gamepad"></i></h1>
        
<button type="button" class="btn btn-dark" data-toggle="modal" data-target="#addGames">
  Add Game <i class="fas fa-plus"></i>
</button>
<br/>
<jsp:include page="WEB-INF/snippets/addGame.jsp"></jsp:include>
<!--        <a href="#" class="btn btn-dark btn-block"
        data-toggle="modal" data-target="#addGame">
        
        </a>-->
        <br/>
        </div>
    </div>
    <jsp:include page="WEB-INF/snippets/gamelist.jsp"></jsp:include>
    
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