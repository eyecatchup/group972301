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
					<h:outputText value="#{oBManager.ERROR_MESSAGE }"></h:outputText>
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
						<td width="200px"><h:outputLabel value="Значение" /></td>
						<td></td>
						<td width="400px"><h:outputLabel value="Результат" /></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="c_1" value="#{oBManager.c1}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="c_1"></h:message></td>
						<td><h:outputLabel value="#{oBManager.c1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="c_2" value="#{oBManager.c2}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="c_2"></h:message></td>
						<td><h:outputLabel value="#{oBManager.c2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ca" value="#{oBManager.ca}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ca"></h:message></td>
						<td><h:outputLabel value="#{oBManager.caStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="cb" value="#{oBManager.cb}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="cb"></h:message></td>
						<td><h:outputLabel value="#{oBManager.cbStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fn_1" value="#{oBManager.fn1}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fn_1"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fn1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fn_2" value="#{oBManager.fn2}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fn_2"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fn2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fn_3" value="#{oBManager.fn3}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fn_3"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fn3Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fv_1" value="#{oBManager.fv1}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fv_1"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fv1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fv_2" value="#{oBManager.fv2}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fv_2"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fv2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="fv_3" value="#{oBManager.fv3}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fv_3"></h:message></td>
						<td><h:outputLabel value="#{oBManager.fv3Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ib" value="#{oBManager.ib}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ib"></h:message></td>
						<td><h:outputLabel value="#{oBManager.ibStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ki" value="#{oBManager.ki}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ki"></h:message></td>
						<td><h:outputLabel value="#{oBManager.kiStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ku" value="#{oBManager.ku}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ku"></h:message></td>
						<td><h:outputLabel value="#{oBManager.kuStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="mnn" value="#{oBManager.mnN}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="mnn"></h:message></td>
						<td><h:outputLabel value="#{oBManager.mnNStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="mvn" value="#{oBManager.mvN}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="mvn"></h:message></td>
						<td><h:outputLabel value="#{oBManager.mvNStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="r_1" value="#{oBManager.r1}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="r_1"></h:message></td>
						<td><h:outputLabel value="#{oBManager.r1Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="r_2" value="#{oBManager.r2}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="r_2"></h:message></td>
						<td><h:outputLabel value="#{oBManager.r2Str}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ra" value="#{oBManager.ra}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ra"></h:message></td>
						<td><h:outputLabel value="#{oBManager.raStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="rb" value="#{oBManager.rb}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rb"></h:message></td>
						<td><h:outputLabel value="#{oBManager.rbStrStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="rk" value="#{oBManager.rk}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rk"></h:message></td>
						<td><h:outputLabel value="#{oBManager.rkStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="rvh" value="#{oBManager.rvh}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rvh"></h:message></td>
						<td><h:outputLabel value="#{oBManager.rvhStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="rvih" value="#{oBManager.rvih}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rvih"></h:message></td>
						<td><h:outputLabel value="#{oBManager.rvihStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ua" value="#{oBManager.ua}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ua"></h:message></td>
						<td><h:outputLabel value="#{oBManager.uaStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="ub" value="#{oBManager.ub}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ub"></h:message></td>
						<td><h:outputLabel value="#{oBManager.ubStr}"></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Поправить владу!!!!!!!!!!!!"></h:outputLabel>
						<td><h:inputText id="uip" value="#{oBManager.uip}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="uip"></h:message></td>
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