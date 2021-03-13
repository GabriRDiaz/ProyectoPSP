<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<div class="mainContainer">
    <br/>
    <div class="displayRow">
        <c:forEach var="games" items="${games}" varStatus="status"> 
            <span class="alignedItems">
                <c:if test="${not empty games.getImg()}">
                <img src="${games.getImg()}" height="200" width="200"></img>
                </c:if>
                <c:if test="${empty games.getImg()}">
                <img src="https://i.imgur.com/eUfgE5Z.jpg" height="200" width="200"></img>
                </c:if>
                <button type="button" class="btn btn-dark marginButton">${games.getTitle()}</button>
                <button type="button" class="btn btn-dark marginButton">Editar</button>
            </span>
        </c:forEach>
<!--    <div class="displayRow"><Button type="button" class="btn btn-warning marginButton"
                onsubmit="ServletSC">Submit</Button></div>-->
    </div>
</div>