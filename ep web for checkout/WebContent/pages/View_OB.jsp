<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Параметры для расчета каскада</title>
<LINK href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet"
	type="text/css">
<LINK href="<%=request.getContextPath()%>/css/print.css" rel="stylesheet"
	type="text/css">
<LINK href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet"
	type="text/css">
<LINK href="<%=request.getContextPath()%>/css/typography.css" rel="stylesheet"
	type="text/css">
<LINK href="<%=request.getContextPath()%>/css/ie.css" rel="stylesheet"
	type="text/css">
	
</head>
<body>
	<f:view>
	<div id="dataViewOB">
		<div class="dataGiven lft">
			<h:form>

				<h:outputLabel value="Параметры для расчета каскада" styleClass="header"></h:outputLabel>

				<table>
					<tr>
					<th colspan="2"><h:outputText value="Вариант:  #{mainService.obManager.given.var }"></h:outputText></th>
					</tr>
					<tr class="even">
						<td><h:outputLabel value="Cн, нФ"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.cn} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Ег, мВ"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.eg} "></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="Iк, мА"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.ik} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Rг, кОм"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.rg} "></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="Rн, кОм"></h:outputLabel></td>
						<td><h:outputLabel value="#{mainService.obManager.given.rn} "></h:outputLabel></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Тип"></h:outputLabel></td>
						<td><h:outputLabel
								value="#{mainService.obManager.given.type} "></h:outputLabel></td>
					</tr>

					<tr class="even">
						<td><h:outputLabel value="Uкэ0, В"></h:outputLabel></td>
						<td><h:outputLabel
								value="#{mainService.obManager.given.uka0} "></h:outputLabel></td>
					</tr>

				</table>

			</h:form>
		</div>
		<div class="dataGiven lft">
			<table>
				<tr>
				<th colspan="2"><h:outputText value="Параметры"></h:outputText></th>
				</tr>
				<tr class="even">
					<td><h:outputLabel value="Ca"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.ca} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Ck"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.ck} "></h:outputLabel></td>
				</tr>

				<tr class="even">
					<td><h:outputLabel value="Fn"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.fn} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Fv"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.fv} "></h:outputLabel></td>
				</tr>

				<tr class="even">
					<td><h:outputLabel value="H11a"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h11a} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="H21a"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21a} "></h:outputLabel></td>
				</tr>

				<tr class="even">
					<td><h:outputLabel value="H21max"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21max} "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="H21min"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.h21min} "></h:outputLabel></td>
				</tr>

				<tr class="even">
					<td><h:outputLabel value="Тип"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.obManager.given.ob_Transistor.type} "></h:outputLabel></td>
				</tr>

			</table>

		</div>
</div>
	</f:view>
</body>
</html>