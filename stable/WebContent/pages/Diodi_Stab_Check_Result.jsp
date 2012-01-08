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
		<div class="dataReceive border">
			<h:form>

				<h1>
					<h:outputText value="#{diodiAndStabilitrManager.ERROR_MESSAGE }"></h:outputText>
				</h1>

				<h3>
					<h:outputLabel value="Проверка вычислений"></h:outputLabel>
				</h3>
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
						<th width="400px"><h:outputLabel value="Эталонный результат"></h:outputLabel></th>
					</tr>

					<tr>
						<td><h:outputLabel value="U вх m"></h:outputLabel>
						<td><h:inputText id="uvxm"
								value="#{diodiAndStabilitrManager.uvxm}" required="true">
							</h:inputText></td>
						<td><h:message for="uvxm"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resUvxm }"></h:outputLabel></td>
						<td><h:outputText
								value="#{diodiAndStabilitrManager.viprymitel.naprVxod}"
								rendered="#{loginService.IS_ROOT }"></h:outputText></td>
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
						<td><h:outputText
								value="#{diodiAndStabilitrManager.mainUvxst }"></h:outputText></td>
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
						<td><h:outputText
								value="#{diodiAndStabilitrManager.maindeltaUvxSt}"></h:outputText></td>
					</tr>
					
					<tr class="even">
						<td><h:outputLabel value="U вых, В мод"></h:outputLabel>
						<td><h:inputText id="modUvix"
								value="#{diodiAndStabilitrManager.modUvix}" required="true">
							</h:inputText></td>
						<td><h:message for="modUvix"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.modResUvix }"></h:outputLabel></td>
						<td><h:outputText
								value="#{diodiAndStabilitrManager.given.naprWihodnoe }"
								rendered="#{loginService.IS_ROOT }"></h:outputText></td>
					</tr>

					<tr>
						<td><h:outputLabel value="ΔU вых, В мод"></h:outputLabel>
						<td><h:inputText id="deltamodUvix"
								value="#{diodiAndStabilitrManager.modDelataUvix}"
								required="true">
							</h:inputText></td>
						<td><h:message for="deltamodUvix"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.modeResDeltaUvix }"></h:outputLabel></td>
						<td><h:outputText
								value="#{diodiAndStabilitrManager.given.deltaNaprWihodnoe }"
								rendered="#{loginService.IS_ROOT }"></h:outputText></td>
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
						<td><h:outputText
								value="#{diodiAndStabilitrManager.maindeltaUtemper}"></h:outputText></td>
					</tr>

					<tr>
						<td><h:outputLabel value="I r, мА"></h:outputLabel>
						<td><h:inputText id="ir"
								value="#{diodiAndStabilitrManager.ir}" required="true"></h:inputText></td>
						<td><h:message for="ir"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resIr }"></h:outputLabel></td>
						<td><h:outputText value="#{diodiAndStabilitrManager.mainIr}"></h:outputText></td>
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
						<td><h:outputText value="#{diodiAndStabilitrManager.mainIst}"></h:outputText></td>
					</tr>

					<tr>
						<td><h:outputLabel value="С, мкФ"></h:outputLabel>
						<td><h:inputText id="c" value="#{diodiAndStabilitrManager.c}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="c"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resC }"></h:outputLabel></td>
						<td><h:outputText value="#{diodiAndStabilitrManager.mainC}"></h:outputText></td>
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
						<td><h:outputText value="#{diodiAndStabilitrManager.mainKst}"></h:outputText></td>
					</tr>

					<tr>
						<td><h:outputLabel value="R н, Ом"></h:outputLabel>
						<td><h:inputText id="rn"
								value="#{diodiAndStabilitrManager.rn}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rn"></h:message></td>
						<td><h:outputLabel value="#{diodiAndStabilitrManager.resRn }"></h:outputLabel></td>
						<td><h:outputText value="#{diodiAndStabilitrManager.mainRn}"></h:outputText></td>
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
						<td><h:outputText
								value="#{diodiAndStabilitrManager.mainRgen}"></h:outputText></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Тип Диода"></h:outputLabel>
						<td><h:inputText id="diod"
								value="#{diodiAndStabilitrManager.diodType}" required="true">

							</h:inputText></td>
						<td><h:message for="diod"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resDiod }"></h:outputLabel></td>
						<td><h:outputText
								value="#{diodiAndStabilitrManager.mainDiod }"></h:outputText></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="Тип Стабилитрона"></h:outputLabel>
						<td><h:inputText id="stab_"
								value="#{diodiAndStabilitrManager.stabType}" required="true">
							</h:inputText></td>
						<td><h:message for="stab_"></h:message></td>
						<td><h:outputLabel
								value="#{diodiAndStabilitrManager.resStabType }"></h:outputLabel></td>
						<td><h:outputText
								value="#{diodiAndStabilitrManager.given.stabilitron.type }"
								rendered="#{loginService.IS_ROOT }"></h:outputText></td>
					</tr>



				</table>

				<h:outputLabel
					value="Студент #{loginService.student.surname} #{loginService.student.name } ваша оценка:"></h:outputLabel>
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