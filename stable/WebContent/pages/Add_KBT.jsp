<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Исходные данные ключевых схем биполярных транзисторов</title>
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
				<table>
					<tr>
						<th colspan="3"><h:outputText value="Исходные данные" /></th>
					</tr>
					<tr>

						<td><h:outputText value="Номер варианта" /></td>
						<td><h:inputText id="var" value="#{kBTService.variant }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
								<f:validator validatorId="com.validators.KbtVariantValidator" />
							</h:inputText></td>
						<td><h:message for="var"></h:message></td>
					</tr>
					<tr class="even">
						<td>Тип транзистора</td>
						<td><h:inputText id="Ttype" value="#{kBTService.ttype }"
								required="true">
							</h:inputText></td>
						<td><h:message for="Ttype"></h:message></td>
					</tr>
					<tr>
						<td>U<sub>ИП</sub></td>
						<td><h:inputText id="Uip" value="#{kBTService.uip}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Uip"></h:message></td>
					</tr>

					<tr class="even">
						<td>U<sub>см</sub></td>
						<td><h:inputText id="Ucm" value="#{kBTService.ucm}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Ucm"></h:message></td>
					</tr>

					<tr>
						<td>R<sub>н</sub></td>
						<td><h:inputText id="Rn" value="#{kBTService.rn}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Rn"></h:message></td>
					</tr>

					<tr class="even">
						<td>S</td>
						<td><h:inputText id="S" value="#{kBTService.s}"
								required="true">
							</h:inputText></td>
						<td><h:message for="S"></h:message></td>
					</tr>


					<tr class="even">
						<td>U<sup>0</sup><sub>пор</sub></td>
						<td><h:inputText id="U0por" value="#{kBTService.u0por}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="U0por"></h:message></td>
					</tr>

					<tr>
						<td>U<sup>1</sup><sub>пор</sub></td>
						<td><h:inputText id="U1por" value="#{kBTService.u1por}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="U1por"></h:message></td>
					</tr>

					<tr>
						<td>C<sub>н</sub></td>
						<td><h:inputText id="Cn" value="#{kBTService.cn}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Cn"></h:message>
					</tr>
					<tr>
						<td>C<sub>к</sub></td>
						<td><h:inputText id="Ck" value="#{kBTService.ck}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Ck"></h:message>
					</tr>
					<tr class="even">
						<td>h<sub>21Э<sub>min</sub></sub></td>
						<td><h:inputText id="h21emin" value="#{kBTService.h21emin}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h21emin"></h:message>
					</tr>
					<tr>
						<td>h<sub>21Э<sub>max</sub></sub></td>
						<td><h:inputText id="h21emax" value="#{kBTService.h21emax}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h21emax"></h:message>
					</tr>
					<tr class="even">
						<td>U<sub>бэ пор</sub></td>
						<td><h:inputText id="Ubepor" value="#{kBTService.ubepor}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Ubepor"></h:message>
					</tr>
					<tr>
						<td>I<sub>кб 0</sub></td>
						<td><h:inputText id="Ikb0" value="#{kBTService.ikb0}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Ikb0"></h:message>
					</tr>
					<tr class="even">
						<td>U<sub>вых 0</sub></td>
						<td><h:inputText id="Uvih0" value="#{kBTService.uvih0}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Uvih0"></h:message>
					</tr>
					<tr>
						<td>T<sub>h21Э</sub></td>
						<td><h:inputText id="Th21E" value="#{kBTService.th21E}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Th21E"></h:message>
					</tr>
					<tr>
						<td>U<sub>вых m</sub></td>
						<td><h:inputText id="Uvihm" value="#{kBTService.uvihm}"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="Uvihm"></h:message>
					</tr>
					<tr>
						<td colspan="3"><h:commandButton value="Обновить"
								actionListener="#{kBTService.add}">
							</h:commandButton></td>
					</tr>
				</table>

			</h:form>

			<h:form>
				<h:dataTable value="#{kBTService.kbtList }" var="entity">
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.ck }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.cn }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.h21emax }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.h21emin }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.rn }"></h:outputText>
					</h:column>


					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.s }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.th21E }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.ttype }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.ubepor }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.ucm }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.uip }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.upor0 }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.upor1 }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.uvih0 }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.uvihm }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.variant }"></h:outputText>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:outputText value="#{entity.ikbo }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:commandButton value="Удалить"
							actionListener="#{kBTService.delete }">
							<f:param name="ent" value="#{entity }"></f:param>
						</h:commandButton>
					</h:column>
					
					
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта" />
							</h:column>
						</f:facet>
						<h:commandButton value="Обновить"
							actionListener="#{kBTService.update }">
							<f:param name="ent" value="#{entity }"></f:param>
						</h:commandButton>
					</h:column>

				</h:dataTable>
			</h:form>
		</div>
	</f:view>
</body>
</html>