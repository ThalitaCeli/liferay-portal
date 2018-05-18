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

package com.liferay.commerce.organization.web.internal.portlet.action;

import com.liferay.commerce.exception.CommerceAddressCityException;
import com.liferay.commerce.exception.CommerceAddressCountryException;
import com.liferay.commerce.exception.CommerceAddressStreetException;
import com.liferay.commerce.exception.NoSuchAddressException;
import com.liferay.commerce.model.CommerceAddress;
import com.liferay.commerce.organization.service.CommerceOrganizationService;
import com.liferay.commerce.organization.web.internal.constants.CommerceOrganizationPortletKeys;
import com.liferay.commerce.service.CommerceAddressService;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CommerceOrganizationPortletKeys.COMMERCE_ORGANIZATION,
		"mvc.command.name=editCommerceAddress"
	},
	service = MVCActionCommand.class
)
public class EditCommerceAddressMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteCommerceAddresses(ActionRequest actionRequest)
		throws Exception {

		long[] deleteCommerceAddressIds = null;

		long commerceAddressId = ParamUtil.getLong(
			actionRequest, "commerceAddressId");

		if (commerceAddressId > 0) {
			deleteCommerceAddressIds = new long[] {commerceAddressId};
		}
		else {
			deleteCommerceAddressIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "deleteCommerceAddressIds"),
				0L);
		}

		for (long deleteCommerceAddressId : deleteCommerceAddressIds) {
			_commerceAddressService.deleteCommerceAddress(
				deleteCommerceAddressId);
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteCommerceAddresses(actionRequest);
			}
			else if (cmd.equals(Constants.ADD) ||
					 cmd.equals(Constants.UPDATE)) {

				updateCommerceAddress(actionRequest);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchAddressException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
			else if (e instanceof CommerceAddressCityException ||
					 e instanceof CommerceAddressCountryException ||
					 e instanceof CommerceAddressStreetException) {

				hideDefaultErrorMessage(actionRequest);

				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}

		hideDefaultSuccessMessage(actionRequest);
	}

	protected void updateCommerceAddress(ActionRequest actionRequest)
		throws Exception {

		long commerceAddressId = ParamUtil.getLong(
			actionRequest, "commerceAddressId");

		long organizationId = ParamUtil.getLong(
			actionRequest, "organizationId");

		Organization organization =
			_commerceOrganizationService.getOrganization(organizationId);

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String street2 = ParamUtil.getString(actionRequest, "street2");
		String street3 = ParamUtil.getString(actionRequest, "street3");
		String city = ParamUtil.getString(actionRequest, "city");
		String zip = ParamUtil.getString(actionRequest, "zip");
		long commerceCountryId = ParamUtil.getLong(
			actionRequest, "commerceCountryId");
		long commerceRegionId = ParamUtil.getLong(
			actionRequest, "commerceRegionId");
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
		boolean defaultBilling = ParamUtil.getBoolean(
			actionRequest, "defaultBilling");
		boolean defaultShipping = ParamUtil.getBoolean(
			actionRequest, "defaultShipping");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CommerceAddress.class.getName(), actionRequest);

		serviceContext.setScopeGroupId(organization.getGroupId());

		if (commerceAddressId <= 0) {
			_commerceAddressService.addCommerceAddress(
				Organization.class.getName(), organizationId, name, description,
				street1, street2, street3, city, zip, commerceRegionId,
				commerceCountryId, phoneNumber, defaultBilling, defaultShipping,
				serviceContext);
		}
		else {
			_commerceAddressService.updateCommerceAddress(
				commerceAddressId, name, description, street1, street2, street3,
				city, zip, commerceRegionId, commerceCountryId, phoneNumber,
				defaultBilling, defaultShipping, serviceContext);
		}
	}

	@Reference
	private CommerceAddressService _commerceAddressService;

	@Reference
	private CommerceOrganizationService _commerceOrganizationService;

}