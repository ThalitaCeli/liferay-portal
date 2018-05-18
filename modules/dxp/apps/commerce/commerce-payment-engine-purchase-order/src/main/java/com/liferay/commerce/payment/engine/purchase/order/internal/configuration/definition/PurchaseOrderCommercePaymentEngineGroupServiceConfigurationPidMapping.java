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

package com.liferay.commerce.payment.engine.purchase.order.internal.configuration.definition;

import com.liferay.commerce.payment.engine.purchase.order.internal.configuration.PurchaseOrderCommercePaymentEngineGroupServiceConfiguration;
import com.liferay.commerce.payment.engine.purchase.order.internal.constants.PurchaseOrderCommercePaymentEngineConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Andrea Di Giorgi
 */
@Component
public class
	PurchaseOrderCommercePaymentEngineGroupServiceConfigurationPidMapping
		implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return
			PurchaseOrderCommercePaymentEngineGroupServiceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return PurchaseOrderCommercePaymentEngineConstants.SERVICE_NAME;
	}

}