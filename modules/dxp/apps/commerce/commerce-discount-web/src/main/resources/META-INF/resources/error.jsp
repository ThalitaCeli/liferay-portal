<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchDiscountException.class %>" message="the-discount-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchDiscountRelException.class %>" message="the-discount-rel-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchDiscountRuleException.class %>" message="the-discount-rule-could-not-be-found" />

<liferay-ui:error-principal />