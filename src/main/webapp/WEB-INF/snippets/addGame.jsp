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
                            <label for="release">Release Date</label>
                            <input type="date" class="form-control" name="release" required>
                        </div>
                        <div class="form-group">
                          <label for="pegi">Select PEGI</label>
                          <select class="form-control" name="pegi">
                            <option>PEGI-3</option>
                            <option>PEGI-7</option>
                            <option>PEGI-12</option>
                            <option>PEGI-16</option>
                            <option>PEGI-18</option>
                          </select>
                        </div>
                        <div class="form-group">
                            <label for="img">Image URL</label>
                            <input type="url" class="form-control" name="img">
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


