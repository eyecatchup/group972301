<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
						<td><h:inputText id="var" value="#{addObService.var }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
								<f:validator validatorId="com.validators.ObVariantValidator" />
							</h:inputText></td>
						<td><h:message for="var"></h:message></td>
					</tr>

					<%-- <tr>
						<td><h:outputText value="Тип транзистора" /></td>
						<td><h:inputText id="type" value="#{addObService.type }"
								required="true">
							</h:inputText></td>
						<td><h:message for="type"></h:message></td>
					</tr> --%>

					<tr>
						<td><h:outputText value="Ukэ0, В" /></td>
						<td><h:inputText id="uka0" value="#{addObService.uka0 }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="uka0"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Сн, Ф" /></td>
						<td><h:inputText id="cn" value="#{addObService.cn }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="cn"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Ег, Ом" /></td>
						<td><h:inputText id="eg" value="#{addObService.eg }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="eg"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Ik, А" /></td>
						<td><h:inputText id="ik" value="#{addObService.ik }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ik"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Rг, Ом" /></td>
						<td><h:inputText id="rg" value="#{addObService.rg }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rg"></h:message></td>
					</tr>


					<tr>
						<td><h:outputText value="Rн, Ом" /></td>
						<td><h:inputText id="rn" value="#{addObService.rn }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="rn"></h:message></td>
					</tr>

				</table>

				<table>
					<tr>
						<th colspan="3"><h:outputText value="Параметры транзистора" /></th>
					</tr>

					<tr>
						<td><h:outputText value="Тип" /></td>
						<td><h:inputText id="tran_type"
								value="#{addObService.tran_type }" required="true">
							</h:inputText></td>
						<td><h:message for="tran_type"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="h21мин" /></td>
						<td><h:inputText id="h21min" value="#{addObService.h21min }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h21min"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="h21макс" /></td>
						<td><h:inputText id="h21max" value="#{addObService.h21max }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h21max"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="h11э" /></td>
						<td><h:inputText id="h11a" value="#{addObService.h11a }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h11a"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="h21э" /></td>
						<td><h:inputText id="h21a" value="#{addObService.h21a }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="h21a"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="fн, Гц" /></td>
						<td><h:inputText id="fn" value="#{addObService.fn }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fn"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="fв, Гц" /></td>
						<td><h:inputText id="fv" value="#{addObService.fv }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="fv"></h:message></td>
					</tr>


					<tr>
						<td><h:outputText value="Cк, Ф" /></td>
						<td><h:inputText id="ck" value="#{addObService.ck }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ck"></h:message></td>
					</tr>

					<tr>
						<td><h:outputText value="Cэ, Ф" /></td>
						<td><h:inputText id="ca" value="#{addObService.ca }"
								required="true">
								<f:validator validatorId="com.validators.StringDataValidator" />
							</h:inputText></td>
						<td><h:message for="ca"></h:message></td>
					</tr>

				</table>

				<h:commandButton value="Добавить"
					actionListener="#{addObService.add }"></h:commandButton>
			</h:form>

			<h:form>
				<h:dataTable value="#{addObService.list }" var="var">
					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Номер варианта"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.var }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Uкэ0, В"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.uka0 }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Iк, А"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ik}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Ег, В"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.eg}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Rг, Ом"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.rg}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Rн, Ом"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.rn}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Cн, Ф"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.cn}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Cн, Ф"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.cn}"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Тип транзистора"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.type }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="h21мин"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.h21min }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="h21макс"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.h21max }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="h11э"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.h11a }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="h21э"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.h21a }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="fн, Гц"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.fn }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="fв, Гц"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.fv }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Cк, Ф"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.ck }"></h:outputText>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Cэ, Ф"></h:outputText>
							</h:column>
						</f:facet>

						<h:outputText value="#{var.ob_Transistor.ca }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Действие"></h:outputText>
								<f:param value="#{var }"></f:param>
							</h:column>
						</f:facet>

						<h:commandButton value="Обновить"
							actionListener="#{addObService.update }">
							<f:param value="#{var }"></f:param>
						</h:commandButton>
					</h:column>

					<h:column>

						<f:facet name="header">
							<h:column>
								<h:outputText value="Действие"></h:outputText>
							</h:column>
						</f:facet>

						<h:commandButton value="Удаление"
							actionListener="#{addObService.delete }">
							<f:param value="#{var }"></f:param>
						</h:commandButton>
					</h:column>

				</h:dataTable>
			</h:form>
		</div>
	</f:view>
</body>
</html>