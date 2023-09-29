<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="common/header.jspf"%>
    <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <title>AddTodo  Page!</title>
</head>
<body>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
        <hr>
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo">

                <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <form:input type="hidden" path="id" required="required"/>

                <form:input type="hidden" path="done" required="required"/>

                <input type="submit" class="btn-success" />
            </form:form>
    </div>
<%@ include file="common/footer.jspf"%>

<!--        webjars/bootstrap/5.3.0/css/bootstrap.min.css-->
<!--        webjars/bootstrap/5.3.0/js/bootstrap.min.js-->

<!--        /META-INF/resources/webjars/jquery/3.6.4/jquery.min.js-->



