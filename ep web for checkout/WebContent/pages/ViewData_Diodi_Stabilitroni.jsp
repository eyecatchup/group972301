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
			<h:outputLabel value="Параметры для расчета стабилизатора напряжения"></h:outputLabel>
			<br></br>
			<h:outputLabel
				value="Вариант:  #{mainService.stabilizatorNaprManager.given.var }"></h:outputLabel>
			<br></br>

			<table>
				<tr>
					<td><h:outputLabel value="Ток нагрузки, мА"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.tok } "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Выходное напряжение, В"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.naprWihodnoe } "></h:outputLabel></td>
				</tr>

				<tr>
					<td><h:outputLabel
							value="Амплитуда пульсаций выходного напряжения, мВ"></h:outputLabel></td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.deltaNaprWihodnoe } "></h:outputLabel></td>
				</tr>
			</table>
		</div>

		<br></br>

		<div>

			<h:outputLabel value="Параметры стабилитрона"></h:outputLabel>
			<br></br>

			<table>
				<tr>
					<td><h:outputLabel value="Тип стабилитрона" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.type }" /></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Ucт, В" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.napr }" /></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Icт min, мА" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.tokMin }" /></td>
				</tr>

				<tr>
					<td><h:outputLabel value="Icт max, мА" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.tokMax }" /></td>
				</tr>

				<tr>
					<td><h:outputLabel value="r cm, Ом" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.tokMax }" /></td>
				</tr>

				<tr>
					<td><h:outputLabel value="α Ucт, %/C°" />
					<td>
					<td><h:outputLabel
							value="#{mainService.stabilizatorNaprManager.given.stabilitron.temperCoef }" /></td>
				</tr>
			</table>
		</div>
	
		
	</f:view>
</body>
</html>