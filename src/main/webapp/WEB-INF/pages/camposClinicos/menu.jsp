<%-- 
    Document   : menu
    Created on : 22/10/2014, 05:17:25 PM
    Author     : develop
--%>

<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
    <div class="collapse navbar-collapse" id="navbar">
        <ul class="nav navbar-nav">
            <c:if test="${empty pageContext.request.remoteUser}">
                <li class="active">
                    <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
                </li>
            </c:if>
          
            <menu:displayMenu name="PlazaMenu"/>
           
        </ul>
    </div>
</menu:useMenuDisplayer>
