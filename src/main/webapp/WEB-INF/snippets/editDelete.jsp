<!DOCTYPE html>
<html lang="en">

<head>
    <title>Game List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7d83f7c8f5.js" crossorigin="anonymous"></script>
</head>
<body class="bg-secondary">
    <div class="centeredTitle bg-dark">
        <div class="col-md-4">
            <h1><i class="fas fa-gamepad"></i> Edit <%=request.getAttribute("title")%> <i class="fas fa-gamepad"></i></h1>
        </div>
    </div>
    <div class="container">
        <table class="table table-striped">
           <tbody>
              <tr>
                 <td colspan="1">
                    <form class="well form-horizontal">
                       <fieldset>
                          <div class="form-group">
                             <label class="col-md-4 control-label">Title</label>
                             <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input name="title"  class="form-control" disabled type="text" value="<%=request.getAttribute("title")%>"></div>
                             </div>
                          </div>
                          <div class="form-group">
                             <label class="col-md-4 control-label">Genre</label>
                             <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="genre"  class="form-control" disabled type="text" value="<%=request.getAttribute("genre")%>"></div>
                             </div>
                          </div>
                          <div class="form-group">
                             <label class="col-md-4 control-label">Release Date</label>
                             <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="release"  class="form-control" disabled type="text" value="<%=request.getAttribute("release")%>"></div>
                             </div>
                          </div>
                          <div class="form-group">
                             <label class="col-md-4 control-label">PEGI</label>
                             <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="pegi"  class="form-control" disabled type="text" value="<%=request.getAttribute("pegi")%>"></div>
                             </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-4 control-label">Img</label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="img"  class="form-control" disabled type="text" value="<%=request.getAttribute("img")%>"></div>
                            </div>
                         </div>
                          <div class="form-group">
                             <label class="col-md-4 control-label">Multiplayer</label>
                             <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="multiplayer"  class="form-control" disabled type="text" value="<%=request.getAttribute("multiplayer")%>"></div>
                             </div>
                          </div>
                       </fieldset>
                    </form>
                 </td>
                 <td colspan="1">
                    <form class="well form-horizontal was-validated" action="${pageContext.request.contextPath}/GamesController?action=edit&gameId=<%=request.getAttribute("id")%>" method="POST">
                        <fieldset>
                           <div class="form-group">
                              <label class="col-md-4 control-label">New Title</label>
                              <div class="col-md-8 inputGroupContainer">
                                 <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input name="title"  class="form-control" placeholder="Golden Sun" type="text" required></div>
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 control-label">New Genre</label>
                              <div class="col-md-8 inputGroupContainer">
                                 <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="genre"  class="form-control" placeholder="RPG" type="text" required></div>
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 control-label">New Release Date</label>
                              <div class="col-md-8 inputGroupContainer">
                                 <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input type="date" class="form-control" name="release" required></div>
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 control-label">New PEGI</label>
                              <div class="col-md-8 inputGroupContainer">
                                 <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><select class="form-control" name="pegi">
                                    <option>PEGI-3</option>
                                    <option>PEGI-7</option>
                                    <option>PEGI-12</option>
                                    <option>PEGI-16</option>
                                    <option>PEGI-18</option>
                                  </select></div>
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 control-label">New Img</label>
                              <div class="col-md-8 inputGroupContainer">
                                 <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input name="img"  class="form-control" placeholder="https://i.imgur.com/H3MdzT3.jpg" type="text"></div>
                              </div>
                           </div>
                           <div class="form-group">
                            <label class="col-md-4 control-label" for="multiplayer">Multiplayer</label>
                            <input type="checkbox" class="form-check-input" name="multiplayer">
                           </div>
                        </fieldset>
                        <button type="submit" class="btn btn-secondary">Save <i class="fas fa-cloud-upload-alt"></i></button>
                     </form>
                 </td>
              </tr>
           </tbody>
        </table>
     </div>
     <div>
        <a href="${pageContext.request.contextPath}/GamesController?action=main"
        class="btn btn-dark marginButton">
        Close  <i class="fas fa-arrow-left"></i></a>
        <a href="${pageContext.request.contextPath}/GamesController?action=delete&gameId=<%=request.getAttribute("id")%>"
                class="btn btn-danger marginButton">
         Delete  <i class="fas fa-trash-alt"></i></a>
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