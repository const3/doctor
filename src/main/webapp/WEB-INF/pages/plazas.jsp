<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="plazaList.title"/></title>
    <meta name="menu" content="PlazaMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='plazaList.heading'/></h2>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/plazaform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="plazaList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="plazaList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="plazaform" media="html"
                        paramId="id" paramProperty="id" titleKey="plaza.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="plaza.id"/>
        <display:column property="nombre" sortable="true" titleKey="plaza.nombre"/>
        <display:column property="hubicacione" sortable="true" titleKey="plaza.hubicacion"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="plazaList.plaza"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="plazaList.plaza"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="plazaList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="plazaList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="plazaList.title"/>.pdf</display:setProperty>
    </display:table>
</div>