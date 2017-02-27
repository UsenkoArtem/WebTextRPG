<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="file">Upload a file</label>
            <div class="col-md-7">
                <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="file" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Upload" class="btn btn-primary btn-sm">
        </div>
    </div>
</form:form>

</body>
</html>