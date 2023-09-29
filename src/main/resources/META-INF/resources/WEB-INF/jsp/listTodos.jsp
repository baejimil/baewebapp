<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <hr>
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>is Done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a> </td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf"%>
<!--        webjars/bootstrap/5.3.0/css/bootstrap.min.css-->
<!--        webjars/bootstrap/5.3.0/js/bootstrap.min.js-->

<!--        /META-INF/resources/webjars/jquery/3.6.4/jquery.min.js-->
