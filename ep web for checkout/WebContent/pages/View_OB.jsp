<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Параметры для расчета каскада</title>
</head>
<body>
	<f:view>
		<div>
			<h:form>

				<h:outputLabel value="Параметры для расчета каскада"></h:outputLabel>
				<br></br>
				<h:outputLabel value="Вариант:  #{mainService.obManager.given.var }"></h:outputLabel>
				<br></br>

				<table>
					<tr>
						<td><h:outputLabel value="Cн, нФ"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.cn} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Ег, мВ"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.eg} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Iк, мА"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.ik} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Rг, кОм"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.rg} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Rн, кОм"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.rn} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Тип"></h:outputLabel></td>
						<td><h:outputLabel
								value="#{mainService.obManager.given.type} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Uкэ0, В"></h:outputLabel></td>
						<td><h:outputLabel
								value="#{mainService.obManager.given.uka0} "></h:outputLabel></td>
					</tr>

				</table>

			</h:form>
		</div>

		<div>
			<h:outputLabel value="Параметра "></h:outputLabel>

			<table>
				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.ca} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.ck} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.fn} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.fv} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h11a} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21a} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21max} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21min} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="дописать владу!!!!!!!!!!!!"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.type} "></h:outputLabel></td>
				</tr>

			</table>

		</div>

	</f:view>
</body>
</html>