<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="solicitudInternadoList.title"/></title>
    <meta name="menu" content="SolicitudInternadoMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="solicitudInternadoList.heading"/></h2>

    <form method="get" action="${ctx}/solicitudInternadoes" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="solicitudInternadoList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/solicitudInternadoform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="solicitudInternadoList" class="table table-condensed table-striped table-hover" requestURI="" id="solicitudInternadoList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="solicitudInternadoform" media="html"
        paramId="id" paramProperty="id" titleKey="solicitudInternado.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="solicitudInternado.id"/>
    <display:column property="apMaterno" sortable="true" titleKey="solicitudInternado.apMaterno"/>
    <display:column property="apPaterno" sortable="true" titleKey="solicitudInternado.apPaterno"/>
    <display:column property="celular" sortable="true" titleKey="solicitudInternado.celular"/>
    <display:column property="correo" sortable="true" titleKey="solicitudInternado.correo"/>
    <display:column property="direccion" sortable="true" titleKey="solicitudInternado.direccion"/>
    <display:column property="foraneo" sortable="true" titleKey="solicitudInternado.foraneo"/>
    <display:column property="foraneo" sortable="true" titleKey="solicitudInternado.foraneo"/>
    <display:column property="matricula" sortable="true" titleKey="solicitudInternado.matricula"/>
    <display:column property="nombre" sortable="true" titleKey="solicitudInternado.nombre"/>
    <display:column property="pruebas" sortable="true" titleKey="solicitudInternado.pruebas"/>
    <display:column property="telefono" sortable="true" titleKey="solicitudInternado.telefono"/>
    <display:column property="version" sortable="true" titleKey="solicitudInternado.version"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="solicitudInternadoList.solicitudInternado"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="solicitudInternadoList.solicitudInternadoes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="solicitudInternadoList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="solicitudInternadoList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="solicitudInternadoList.title"/>.pdf</display:setProperty>
</display:table>
