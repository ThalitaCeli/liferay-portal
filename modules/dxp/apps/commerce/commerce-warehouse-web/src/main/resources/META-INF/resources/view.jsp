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

<%
CommerceWarehousesDisplayContext commerceWarehousesDisplayContext = (CommerceWarehousesDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

long commerceCountryId = commerceWarehousesDisplayContext.getCommerceCountryId();
List<ManagementBarFilterItem> managementBarFilterItems = commerceWarehousesDisplayContext.getManagementBarFilterItems();

String managementBarFilterValue = null;

for (ManagementBarFilterItem managementBarFilterItem : managementBarFilterItems) {
	if (commerceCountryId == Long.valueOf(managementBarFilterItem.getId())) {
		managementBarFilterValue = managementBarFilterItem.getLabel();

		break;
	}
}
%>

<liferay-ui:error exception="<%= CommerceGeocoderException.class %>">
	<liferay-ui:message arguments="<%= errorException %>" key="an-unexpected-error-occurred-while-invoking-the-geolocation-service-x" translateArguments="<%= false %>" />
</liferay-ui:error>

<liferay-frontend:management-bar
	searchContainerId="commerceWarehouses"
>
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-filter
			label="country"
			managementBarFilterItems="<%= managementBarFilterItems %>"
			value="<%= managementBarFilterValue %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= commerceWarehousesDisplayContext.getOrderByCol() %>"
			orderByType="<%= commerceWarehousesDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"city", "name"} %>'
			portletURL="<%= commerceWarehousesDisplayContext.getPortletURL() %>"
		/>

		<li>
			<aui:form action="<%= String.valueOf(commerceWarehousesDisplayContext.getPortletURL()) %>" name="searchFm">
				<liferay-ui:input-search
					markupView="lexicon"
				/>
			</aui:form>
		</li>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= commerceWarehousesDisplayContext.getPortletURL() %>"
			selectedDisplayStyle="list"
		/>

		<c:if test="<%= commerceWarehousesDisplayContext.isShowAddButton() %>">
			<portlet:renderURL var="addCommerceWarehouseURL">
				<portlet:param name="mvcRenderCommandName" value="editCommerceWarehouse" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="commerceCountryId" value="<%= String.valueOf(commerceCountryId) %>" />
			</portlet:renderURL>

			<liferay-frontend:add-menu
				inline="<%= true %>"
			>
				<liferay-frontend:add-menu-item
					title='<%= LanguageUtil.get(request, "add-warehouse") %>'
					url="<%= addCommerceWarehouseURL.toString() %>"
				/>
			</liferay-frontend:add-menu>
		</c:if>
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		id="commerceWarehouses"
		searchContainer="<%= commerceWarehousesDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.commerce.model.CommerceWarehouse"
			keyProperty="commerceWarehouseId"
			modelVar="commerceWarehouse"
		>

			<%
			PortletURL rowURL = renderResponse.createRenderURL();

			rowURL.setParameter("mvcRenderCommandName", "editCommerceWarehouse");
			rowURL.setParameter("redirect", currentURL);
			rowURL.setParameter("commerceWarehouseId", String.valueOf(commerceWarehouse.getCommerceWarehouseId()));
			%>

			<liferay-ui:search-container-column-text
				cssClass="important table-cell-content"
				href="<%= rowURL %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				property="city"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="active"
				value='<%= LanguageUtil.get(request, commerceWarehouse.isActive() ? "yes" : "no") %>'
			/>

			<liferay-ui:search-container-column-jsp
				cssClass="entry-action-column"
				path="/warehouse_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>