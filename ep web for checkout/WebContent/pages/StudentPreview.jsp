<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Просмотр успеваемости студентов</title>
</head>

<body>
	<f:view>
		<h:form id="group_form">
			<div>
				<h:outputText value="Группы студентов" />
				<h:selectOneListbox value="#{studentService.curGroup }"
					onchange="submit()">
					<f:selectItems value="#{studentService.strGroupList }" />
					<f:valueChangeListener type="com.service.changeListener" />
				</h:selectOneListbox>
			</div>

			<p></p>

			<div>
				<h:outputText value="Информация о студентах группы" />
				<p></p>
				<h:dataTable value="#{studentService.studGroupList}" var="student">
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Фамилия"></h:outputText>
							</h:column>
						</f:facet>
						<h:outputText value="#{student.surname }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Имя"></h:outputText>
							</h:column>
						</f:facet>
						<h:outputText value="#{student.name }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Отчество"></h:outputText>
							</h:column>
						</f:facet>
						<h:outputText value="#{student.fathersName }"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Данные по лабораторным"></h:outputText>
							</h:column>
						</f:facet>
						<h:dataTable value="#{student.doneLabs }" var="lab">
							<h:column>
								<f:facet name="header">
									<h:column>
										<h:outputText value="Тема"></h:outputText>
									</h:column>
								</f:facet>
								<h:outputText value="#{lab.theme }"></h:outputText>
							</h:column>

							<h:column>
								<f:facet name="header">
									<h:column>
										<h:outputText value="Оценка"></h:outputText>
									</h:column>
								</f:facet>
								<h:outputText value="#{lab.mark }"></h:outputText>
							</h:column>
						</h:dataTable>
					</h:column>

				</h:dataTable>
			</div>

		</h:form>
	</f:view>
</body>
</html>