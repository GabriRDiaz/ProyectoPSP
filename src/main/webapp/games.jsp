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
<div class="modal fade" id="addGames" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content bg-dark">
      <div class="modal-header bg-dark">
        <h4 class="modal-title">Add Game</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="was-validated" action="${pageContext.request.contextPath}/GamesController?action=add" method="POST">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" name="title" required>
                        </div>
                        <div class="form-group">
                            <label for="genre">Genre</label>
                            <input type="text" class="form-control" name="genre" required>
                        </div>
                        <div class="form-group">
                            <label for="date">Release Date</label>
                            <input type="date" class="form-control" name="date" required>
                        </div>
                        <div class="form-group">
                          <label for="pegi">Select PEGI</label>
                          <select class="form-control" id="pegi">
                            <option>PEGI-3</option>
                            <option>PEGI-7</option>
                            <option>PEGI-12</option>
                            <option>PEGI-16</option>
                            <option>PEGI-18</option>
                          </select>
                        </div>
                        <div class="form-group">
                            <label for="url">Image URL</label>
                            <input type="url" class="form-control" name="url">
                        </div>
                        <div class="form-group form-check">
                             <input type="checkbox" class="form-check-input" name="multiplayer">
                             <label for="multiplayer">Multiplayer</label>
                        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-secondary">Save changes</button>
      </div>
            </form>
      </div>
    </div>
  </div>
</div>
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