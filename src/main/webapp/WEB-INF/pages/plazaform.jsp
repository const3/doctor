
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="plazaDetail.title"/></title>
    <meta name="menu" content="PlazaMenu"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="plazaList.plaza"/></c:set>
    <script type="text/javascript">var msgDelConfirm =
            "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
    </script>

    <div class="col-sm-3">
        <h2><fmt:message key='plazaDetail.heading'/></h2>
</div>

<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="plaza" method="post" action="plazaform" id="plazaForm"
               cssClass="well" onsubmit="return validatePlaza(this)">
        <form:hidden path="id"/>
        <spring:bind path="plaza.firstName">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
            <appfuse:label styleClass="control-label" key="plaza.nombre"/>
            <form:input path="nombre" id="nombre" maxlength="50" autofocus="true" cssClass="form-control"/>
            <form:errors path="nombre" cssClass="help-inline"/>
        </div>
        <spring:bind path="plaza.hubicacion">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
            <appfuse:label styleClass="control-label" key="plaza.hubicacion"/>
            <div class="controls">
                <form:input path="hubicacion" id="lastName" maxlength="50" cssClass="form-control"/>
                <form:errors path="hubicacion" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group form-actions">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel = false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>
            <c:if test="${not empty plaza.id}">
                <button type="submit" class="btn btn-default" name="delete" onclick="bCancel = true;
                  return confirmMessage(msgDelConfirm)">
                    <i class="icon-trash"></i> <fmt:message key="button.delete"/>
                </button>
            </c:if>
            <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel = true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>

<v:javascript formName="plaza" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>
