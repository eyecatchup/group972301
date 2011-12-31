<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:view>

		<div>
			<h:form>
				<h1>
					<h:messages layout="list" showSummary="true" showDetail="true"></h:messages>
				</h1>

				<h:outputLabel value="Проверка вычислений"></h:outputLabel>
				<br></br>
				<h:outputLabel value="Вариант:  #{oBManager.given.var }"></h:outputLabel>
				<br></br>
			</h:form>

			<h:form>
				<table>
					<tr class="header">
						<td width="400px"><h:outputLabel value="Обозначение" /></td>
						<td width="400px"><h:outputLabel value="Значение" /></td>
						<td width="400px"><h:outputLabel value="Результат" /></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.c1}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.c1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.c2}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.c2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ca}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.caStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.cb}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.cbStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fn1}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fn1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fn2}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fn2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fn3}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fn3Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fv1}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fv1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fv2}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fv2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.fv3}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.fv3Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ib}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.ibStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ki}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.kiStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ku}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.kuStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.mnN}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.mnNStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.mvN}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.mvNStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.r1}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.r1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.r2}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.r2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ra}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.raStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.rb}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.rbStrStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.rk}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.rkStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.rvh}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.rvhStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.rvih}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.rvihStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ua}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.uaStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.ub}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.ubStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText value="#{oBManager.uip}" required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:outputLabel value="#{oBManager.uipStr}"></h:outputLabel></td>
					</tr>
				</table>


				<h:commandButton value="Проверить вычисления"
					actionListener="#{oBManager.checkResult }"></h:commandButton>

				<h:outputLabel
					value="Студент #{loginService.student.fathersName} #{loginService.student.name } ваша оценка:"></h:outputLabel>
				<h:outputLabel value="#{oBManager.result }"></h:outputLabel>


			</h:form>

		</div>

	</f:view>
</body>
</html>