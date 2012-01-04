<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Проверка результатов</title>

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

	<%-- <script type="text/javascript"
					src="<%=request.getContextPath()%>/js/backfix.min.js"></script>
				<script type="text/javascript">
		/* bajb_backdetect.OnBack = function() {
			alert(window.location.protocol + "//" + window.location.host
					+ "/EP_web/faces/pages/PreviewAvailableThemes.jsp"); */
			/* window.location = window.location.protocol + "://"
					+ window.location.host
					+ "/EP_web/faces/pages/PreviewAvailableThemes.jsp"; */
		/* 	location.replace(window.location.protocol + "://"
					+ window.location.host
					+ "/EP_web/faces/pages/PreviewAvailableThemes.jsp"); */
	<%System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()
					+ "/faces/pages/PreviewAvailableThemes.jsp");%>
		
	</script> --%>

	<f:view>
		<div class="dataReceive">
			<h:form>

				<h1>
					<h:outputText value="#{diodiAndStabilitrManager.ERROR_MESSAGE }"></h:outputText>
				</h1>

				<h:outputLabel value="Проверка вычислений"></h:outputLabel>
				<br></br>
				<b><h:outputLabel
						value="Вариант:  #{diodiAndStabilitrManager.given.var }"></h:outputLabel></b>
				<br></br>
			</h:form>

			<h:form>

				<table id="table">
					<tr class="header">
						<th width="400px"><h:outputLabel value="Обозначение" /></th>
						<th width="200px"><h:outputLabel value="Значение" /></th>
						<th></th>
						<th width="400px"><h:outputLabel value="Результат" /></th>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="U вх ст, В"></h:outputLabel>
						<td><h:inputText id="u"
								value="#{diodiAndStabilitrManager.uvxst}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="u"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resdeltaUvxSt}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="ΔU вх ст, В"></h:outputLabel>
						<td><h:inputText id="delta"
								value="#{diodiAndStabilitrManager.deltaUvxSt}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="delta"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resdeltaUvxSt }"></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="ΔU выхТ, В"></h:outputLabel>
						<td><h:inputText id="delta_u"
								value="#{diodiAndStabilitrManager.deltaUtemper}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="delta_u"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resdeltaUtemper}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="I r, мА"></h:outputLabel>
						<td><h:inputText id="ir"
								value="#{diodiAndStabilitrManager.ir}" required="true"></h:inputText></td>
						<td><h:message for="ir"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resIr }"></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="I ст, мА"></h:outputLabel>
						<td><h:inputText id="ist"
								value="#{diodiAndStabilitrManager.ist}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ist"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resIst }"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="С, мкФ"></h:outputLabel>
						<td><h:inputText id="c" value="#{diodiAndStabilitrManager.c}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="c"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resC }"></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="К ст"></h:outputLabel>
						<td><h:inputText id="kst"
								value="#{diodiAndStabilitrManager.kst}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="kst"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resKst }"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="R н, Ом"></h:outputLabel>
						<td><h:inputText id="rn"
								value="#{diodiAndStabilitrManager.rn}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rn"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resRn }"></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="R г, Ом"></h:outputLabel>
						<td><h:inputText id="r"
								value="#{diodiAndStabilitrManager.rgen}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="r"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resRgen }"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Тип Диода"></h:outputLabel>
						<td><h:inputText id="diod"
								value="#{diodiAndStabilitrManager.diodType}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="diod"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resDiod }"></h:outputLabel></td>
					</tr>


				</table>

				<h:outputLabel
					value="Студент #{loginService.student.fathersName} #{loginService.student.name } ваша оценка:"></h:outputLabel>
				<h:outputLabel value="#{diodiAndStabilitrManager.resultMark }"></h:outputLabel>
				<br>

				<h:commandButton value="Проверить вычисления"
					actionListener="#{diodiAndStabilitrManager.chechResult }"></h:commandButton>
			</h:form>

			<h:form>
				<h:commandButton value="Назад"
					action="#{mainService.backToAvailableThemes }"></h:commandButton>
			</h:form>

		</div>

	</f:view>
</body>
</html>