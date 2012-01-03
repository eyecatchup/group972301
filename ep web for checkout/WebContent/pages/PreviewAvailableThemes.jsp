<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Темы занятий</title>

<LINK href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet"
	type="text/css">
<LINK href="<%=request.getContextPath()%>/css/print.css"
	rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath()%>/css/reset.css"
	rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath()%>/css/typography.css"
	rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath()%>/css/ie.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<f:view>
		<div id="main_view">
			<h:form>

				<div id="theme0" class="theme">
					<h:outputLabel value="#{mainService.theme0 }"></h:outputLabel>
					<h:outputText value="Вариант: "></h:outputText>
					<!-- Drop down List with variants -->
					<h:selectOneMenu
						valueChangeListener="#{mainService.choosedTheme_0_Variant}">
						<f:selectItems value="#{mainService.variants0}" />
					</h:selectOneMenu>
					<br>

					<h:commandButton value="Просмотреть исходные данные"
						action="#{mainService.showStabData }"></h:commandButton>
					<h:commandButton value="Проверить результат"
						action="#{mainService.checkResult_0 }"></h:commandButton>

				</div>

				<div id="theme1" class="theme">
					<h:outputLabel value="#{mainService.theme1 }"></h:outputLabel>
					<!-- Drop down List with variants -->
					<h:outputText value="Вариант: "></h:outputText>
					<h:selectOneMenu
						valueChangeListener="#{mainService.choosedTheme_1_Variant }">
						<f:selectItems value="#{mainService.variants1}" />
					</h:selectOneMenu>
					<br>
					<h:commandButton value="Просмотреть исходные данные"
						action="#{mainService.showOBdata }"></h:commandButton>
					<h:commandButton value="Проверить результат"
						action="#{mainService.checkResult_1 }"></h:commandButton>

				</div>

				<div id="theme2" class="theme">
					<h:outputLabel value="#{mainService.theme2 }"></h:outputLabel>
					<!-- Drop down List with variants -->
					<h:outputText value="Вариант: "></h:outputText>
					<h:selectOneMenu
						valueChangeListener="#{mainService.choosedTheme_1_Variant }">
						<f:selectItems value="#{mainService.variants1}" />
					</h:selectOneMenu>
					<br>
					<h:commandButton value="Просмотреть исходные данные"></h:commandButton>
					<h:commandButton value="Проверить результат"></h:commandButton>

				</div>

			</h:form>
		</div>
	</f:view>
</body>
</html>