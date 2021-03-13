<div class="mainContainer">
    <br>
    <div class="displayRow">
        <c:forEach var="games" items="${game}" varStatus="status"> 
        <span class="alignedItems">
            <img src="${game.getImg()}" height="200" width="200">
            <button type="button" class="btn btn-dark marginButton">${game.getTitle()}</button>
        </span>
        </c:foreach>
<!--    <div class="displayRow"><Button type="button" class="btn btn-warning marginButton"
                onsubmit="ServletSC">Submit</Button></div>-->
</div>