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
</head>

<body class="bg-secondary">

    <div class="centeredTitle bg-dark">
        <h1>Games List</h1>
    </div>
    <div class="mainContainer">
        <br>
        <div class="displayRow">
            <span class="alignedItems">
                <img src="TheBlackMarket.jpg" height="200" width="200">
                <button type="button" class="btn btn-dark marginButton">The Black Market</button>
            </span>
            <span class="alignedItems">
                <img src="Baile.jpg" height="200" width="200">
                <button type="button" class="btn btn-dark marginButton">El Baile de los Caídos</button>
            </span>
            <span class="alignedItems">
                <img src="W&D.jpg" height="200" width="200">
                <button type="button" class="btn btn-dark marginButton">Wretched And Divine</button>
            </span>
            <span class="alignedItems">
                <img src="Masquerade.jpg" height="200" width="200">
                <button type="button" class="btn btn-dark marginButton">Welcome to the Masquerade</button>
            </span>
        </div>
        <div class="displayRow"><Button type="button" class="btn btn-warning marginButton"
                onsubmit="ServletSC">Submit</Button></div>
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