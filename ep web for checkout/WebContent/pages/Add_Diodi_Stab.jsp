<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавление и просмотр стабилизатора напряжения</title>

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
		<div class="dataReceive">
			<h:form>

				<h:messages layout="table"
					showSummary="true" showDetail="false"></h:messages>

				<table>
					<tr>
						<th colspan="3"><h:outputText value="Исходные данные" /></th>
					</tr>
					<tr class="even">
						<td><h:outputText value="Номер варианта" /></td>
						<td><h:inputText id="var" value="#{addDiodiandStab.var }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
								<f:validator
									validatorId="com.validators.StabilizAddVariantValid" />
							</h:inputText></td>
						<td><h:message for="var"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Выходное напряжение" /></td>
						<td><h:inputText id="napr" value="#{addDiodiandStab.napr }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="napr"></h:message></td>
					</tr>

					<tr class="even">
						<td><h:outputText value="Ток нагрузки" /></td>
						<td><h:inputText id="tok" value="#{addDiodiandStab.tok }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="tok"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText
								value="Амплитуда пульсаций выходного напряжения" /></td>
						<td><h:inputText id="ampl" value="#{addDiodiandStab.ampl }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ampl"></h:message></td>
					</tr>

				</table>

				<br></br>

				<div>
					<table>
						<tr>
							<th colspan="3"><h:outputLabel
									value="Параметры стабилитрона"></h:outputLabel></th>
						</tr>
						<tr class="even">
							<td><h:outputLabel value="Тип стабилитрона" /></td>
							<td><h:inputText id="type" value="#{addDiodiandStab.type }"
									required="true">
								</h:inputText></td>
							<td><h:message for="type"></h:message></td>
						</tr>

						<tr>
							<td><h:outputLabel value="Ucт, В" /></td>
							<td><h:inputText id="stNapr"
									value="#{addDiodiandStab.stNapr }" required="true">
									<f:validator validatorId="com.validators.StringDataValidator" />
								</h:inputText></td>
							<td><h:message for="stNapr"></h:message></td>
						</tr>

						<tr class="even">
							<td><h:outputLabel value="Icт min, мА" /></td>
							<td><h:inputText id="tokMin"
									value="#{addDiodiandStab.tokMin }" required="true">
									<f:validator validatorId="com.validators.StringDataValidator" />
								</h:inputText></td>
							<td><h:message for="tokMin"></h:message></td>
						</tr>

						<tr>
							<td><h:outputLabel value="Icт max, мА" /></td>
							<td><h:inputText id="tokMax"
									value="#{addDiodiandStab.tokMax }" required="true">
									<f:validator validatorId="com.validators.StringDataValidator" />
								</h:inputText></td>
							<td><h:message for="tokMax"></h:message></td>
						</tr>

						<tr class="even">
							<td><h:outputLabel value="r cm, Ом" /></td>
							<td><h:inputText id="r" value="#{addDiodiandStab.r}"
									required="true">
									<f:validator validatorId="com.validators.StringDataValidator" />
								</h:inputText></td>
							<td><h:message for="r"></h:message></td>
						</tr>

						<tr>
							<td><h:outputLabel value="α Ucт, %/C°" /></td>
							<td><h:inputText id="alpha"
									value="#{addDiodiandStab.alpha }" required="true">
									<f:validator validatorId="com.validators.StringDataValidator" />
								</h:inputText></td>
							<td><h:message for="alpha"></h:message>
						</tr>
					</table>
				</div>

				<h:panelGrid columns="3">

					<f:facet name="header">
						<h:outputText value="Параметры Диода"></h:outputText>
					</f:facet>

					<h:outputText value="Тип диода"></h:outputText>
					<h:inputText id="diod_type" value="#{addDiodiandStab.typeDiod }"
						required="true">
						<f:validator validatorId="com.validators.DiodAddValidator" />
					</h:inputText>
					<h:message for="diod_type"></h:message>


					<h:outputText value="I пр max, А"></h:outputText>
					<h:inputText id="i_pr" value="#{addDiodiandStab.i_pr }"
						required="true">
						<f:validator validatorId="com.validators.StringDataValidator" />
					</h:inputText>
					<h:message for="i_pr"></h:message>

					<h:outputText value="I пр и max, А"></h:outputText>
					<h:inputText id="i_pr_i" value="#{addDiodiandStab.i_pr_i_max }"
						required="true">
						<f:validator validatorId="com.validators.StringDataValidator" />
					</h:inputText>
					<h:message for="i_pr_i"></h:message>

					<h:outputText value="U обр max, В"></h:outputText>
					<h:inputText id="u_obr" value="#{addDiodiandStab.u_obr }"
						required="true">
						<f:validator validatorId="com.validators.StringDataValidator" />
					</h:inputText>
					<h:message for="u_obr"></h:message>

					<h:outputText value="T обр вос, мкс"></h:outputText>
					<h:inputText id="t_obr" value="#{addDiodiandStab.t_obr_vos }"
						required="true">
						<f:validator validatorId="com.validators.StringDataValidator" />
					</h:inputText>
					<h:message for="t_obr"></h:message>
				</h:panelGrid>

				<h:commandButton actionListener="#{addDiodiandStab.add }"
					value="Добавить"></h:commandButton>
			</h:form>
		</div>
		<div class="dataReceive tp">
			<h:form>
				<h:dataTable value="#{addDiodiandStab.list }" var="given">

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.var }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Выходное напряжение" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.naprWihodnoe }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Ток нагрузки" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.tok }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Амплитуда пульсаций выходного напряжения" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.deltaNaprWihodnoe }"></h:outputText>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Тип стабилитрона" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.type}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Ucт, В" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.napr }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Icт min, А" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.tokMin }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Icт max, А" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.tokMax }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="r cm, Ом" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.sopr }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="α Ucт, %/C°" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.stabilitron.temperCoef}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Тип диода" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.diod.name}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="I пр max, А" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.diod.tok_maks}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="I пр и max, А" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.diod.tok_i_maks}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="U обр max, В" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.diod.napr_maks}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="T обр вос, мкс" />
							</h:column>
						</f:facet>
						<h:outputText value="#{given.diod.t_obr}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Действие°" />
							</h:column>
						</f:facet>
						<h:commandButton value="Удалить"
							actionListener="#{addDiodiandStab.delete}">
							<f:param name="client" value="#{given}"></f:param>
						</h:commandButton>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Действие°" />
							</h:column>
						</f:facet>
						<h:commandButton value="Обновить"
							actionListener="#{addDiodiandStab.update}">
							<f:param name="client" value="#{given}"></f:param>
						</h:commandButton>
					</h:column>
				</h:dataTable>
			</h:form>
		</div>
	</f:view>
</body>
</html>