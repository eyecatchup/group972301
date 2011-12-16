<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please login</title>

<%-- <LINK href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet"
	type="text/css"> --%>

</head>
<body>
	<f:view>

		<div id="header">
			<h:form styleClass="loginForm">
				<p>
					<h:messages styleClass="errorMessage" layout="table"
						showSummary="true" showDetail="false"></h:messages>
				</p>
			</h:form>
		</div>

		<div id="login" align="center">



			<h:form id="login_form">
				<table>
					<tr>
						<td width="100px"><h:outputText value="Имя"></h:outputText></td>
						<td><h:inputText value="#{loginService.studName }"></h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Фамилия"></h:outputText></td>
						<td><h:inputText value="#{loginService.studSurName }"></h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Номер группы"></h:outputText></td>
						<td><h:inputText value="#{loginService.group }"></h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Пароль"></h:outputText></td>
						<td><h:inputSecret id="pswd" value="#{loginService.password}"
								required="true"></h:inputSecret></td>
					</tr>

				</table>
				<h:commandButton id="loginBtn" value="Войти" styleClass="submit"
					action="#{loginService.LogIn }"></h:commandButton>
			</h:form>

			<h:form>

				<h:commandButton value="Зарегистрироваться" id="show_hide"
					actionListener="#{loginService.displayAddForm }"></h:commandButton>
			</h:form>

			<h:form binding="#{loginService.addForm }"
				rendered="#{loginService.show }">
				<table>
					<tr>
						<td width="100px"><h:outputText value="Имя"></h:outputText></td>
						<td><h:inputText value="#{loginService.studName }">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Фамилия"></h:outputText></td>
						<td><h:inputText value="#{loginService.studSurName }">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Отчество"></h:outputText></td>
						<td><h:inputText value="#{loginService.fathersName }">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Номер группы"></h:outputText></td>
						<td><h:inputText value="#{loginService.group }">
							</h:inputText></td>
					</tr>

					<tr>
						<td><h:outputText value="Пароль"></h:outputText></td>
						<td><h:inputSecret id="pswd" value="#{loginService.password}"
								required="true">
							</h:inputSecret></td>
					</tr>
				</table>

				<h:commandButton id="loginBtn" value="Добавить" styleClass="submit"
					actionListener="#{loginService.addStudent }"></h:commandButton>
			</h:form>
		</div>



	</f:view>
</body>
</html>