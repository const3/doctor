<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="solicitudInternadoDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='solicitudInternadoDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="solicitudInternadoList.solicitudInternado"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="solicitudInternadoDetail.heading"/></h2>
    <fmt:message key="solicitudInternadoDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="solicitudInternado" method="post" action="solicitudInternadoform" cssClass="well"
           id="solicitudInternadoForm" onsubmit="return validateSolicitudInternado(this)">
<form:hidden path="id"/>
    <spring:bind path="solicitudInternado.apMaterno">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.apMaterno" styleClass="control-label"/>
        <form:input cssClass="form-control" path="apMaterno" id="apMaterno"  maxlength="50" placeholder="lol"/>
        <form:errors path="apMaterno" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.apPaterno"> 
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.apPaterno" styleClass="control-label"/>
        <form:input cssClass="form-control" path="apPaterno" id="apPaterno"  maxlength="50"/>
        <form:errors path="apPaterno" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.celular">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.celular" styleClass="control-label"/>
        <form:input cssClass="form-control" path="celular" id="celular"  maxlength="255"/>
        <form:errors path="celular" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.correo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.correo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="correo" id="correo"  maxlength="255"/>
        <form:errors path="correo" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.direccion">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.direccion" styleClass="control-label"/>
        <form:input cssClass="form-control" path="direccion" id="direccion"  maxlength="255"/>
        <form:errors path="direccion" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.foraneo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.foraneo" styleClass="control-label"/>
        <form:checkbox path="foraneo" id="foraneo" cssClass="checkbox"/>
        <form:errors path="foraneo" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.foraneo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.foraneo" styleClass="control-label"/>
        <form:checkbox path="foraneo" id="foraneo" cssClass="checkbox"/>
        <form:errors path="foraneo" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.matricula">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.matricula" styleClass="control-label"/>
        <form:input cssClass="form-control" path="matricula" id="matricula"  maxlength="7"/>
        <form:errors path="matricula" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.nombre">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.nombre" styleClass="control-label"/>
        <form:input cssClass="form-control" path="nombre" id="nombre"  maxlength="50"/>
        <form:errors path="nombre" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.pruebas">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.pruebas" styleClass="control-label"/>
        <form:input cssClass="form-control" path="pruebas" id="pruebas"  maxlength="255"/>
        <form:errors path="pruebas" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.telefono">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.telefono" styleClass="control-label"/>
        <form:input cssClass="form-control" path="telefono" id="telefono"  maxlength="255"/>
        <form:errors path="telefono" cssClass="help-block"/>
    </div>
    <spring:bind path="solicitudInternado.version">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="solicitudInternado.version" styleClass="control-label"/>
        <form:input cssClass="form-control" path="version" id="version"  maxlength="255"/>
        <form:errors path="version" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty solicitudInternado.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="solicitudInternado" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['solicitudInternadoForm']).focus();
    });
</script>
