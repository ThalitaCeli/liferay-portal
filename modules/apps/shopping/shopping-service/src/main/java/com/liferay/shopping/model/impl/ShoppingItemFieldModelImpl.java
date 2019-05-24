/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.shopping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.ShoppingItemFieldModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ShoppingItemField service. Represents a row in the &quot;ShoppingItemField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ShoppingItemFieldModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingItemFieldImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemFieldImpl
 * @generated
 */
@ProviderType
public class ShoppingItemFieldModelImpl
	extends BaseModelImpl<ShoppingItemField> implements ShoppingItemFieldModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping item field model instance should use the <code>ShoppingItemField</code> interface instead.
	 */
	public static final String TABLE_NAME = "ShoppingItemField";

	public static final Object[][] TABLE_COLUMNS = {
		{"itemFieldId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"itemId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"values_", Types.VARCHAR}, {"description", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("itemFieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("itemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("values_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ShoppingItemField (itemFieldId LONG not null primary key,companyId LONG,itemId LONG,name VARCHAR(75) null,values_ STRING null,description STRING null)";

	public static final String TABLE_SQL_DROP = "drop table ShoppingItemField";

	public static final String ORDER_BY_JPQL =
		" ORDER BY shoppingItemField.itemId ASC, shoppingItemField.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ShoppingItemField.itemId ASC, ShoppingItemField.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.shopping.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.shopping.model.ShoppingItemField"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.shopping.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.shopping.model.ShoppingItemField"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.shopping.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.shopping.model.ShoppingItemField"),
		true);

	public static final long ITEMID_COLUMN_BITMASK = 1L;

	public static final long NAME_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.shopping.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.shopping.model.ShoppingItemField"));

	public ShoppingItemFieldModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _itemFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingItemField.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingItemField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ShoppingItemField, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ShoppingItemField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShoppingItemField, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ShoppingItemField)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ShoppingItemField, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ShoppingItemField, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ShoppingItemField)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ShoppingItemField, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ShoppingItemField, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ShoppingItemField>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ShoppingItemField.class.getClassLoader(), ShoppingItemField.class,
			ModelWrapper.class);

		try {
			Constructor<ShoppingItemField> constructor =
				(Constructor<ShoppingItemField>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<ShoppingItemField, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ShoppingItemField, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ShoppingItemField, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ShoppingItemField, Object>>();
		Map<String, BiConsumer<ShoppingItemField, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ShoppingItemField, ?>>();

		attributeGetterFunctions.put(
			"itemFieldId",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getItemFieldId();
				}

			});
		attributeSetterBiConsumers.put(
			"itemFieldId",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object itemFieldId) {

					shoppingItemField.setItemFieldId((Long)itemFieldId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object companyId) {

					shoppingItemField.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"itemId",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"itemId",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object itemId) {

					shoppingItemField.setItemId((Long)itemId);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object name) {

					shoppingItemField.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"values",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getValues();
				}

			});
		attributeSetterBiConsumers.put(
			"values",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object values) {

					shoppingItemField.setValues((String)values);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<ShoppingItemField, Object>() {

				@Override
				public Object apply(ShoppingItemField shoppingItemField) {
					return shoppingItemField.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<ShoppingItemField, Object>() {

				@Override
				public void accept(
					ShoppingItemField shoppingItemField, Object description) {

					shoppingItemField.setDescription((String)description);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getItemFieldId() {
		return _itemFieldId;
	}

	@Override
	public void setItemFieldId(long itemFieldId) {
		_itemFieldId = itemFieldId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_columnBitmask = -1L;

		if (!_setOriginalItemId) {
			_setOriginalItemId = true;

			_originalItemId = _itemId;
		}

		_itemId = itemId;
	}

	public long getOriginalItemId() {
		return _originalItemId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public String getValues() {
		if (_values == null) {
			return "";
		}
		else {
			return _values;
		}
	}

	@Override
	public void setValues(String values) {
		_values = values;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ShoppingItemField.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ShoppingItemField toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShoppingItemFieldImpl shoppingItemFieldImpl =
			new ShoppingItemFieldImpl();

		shoppingItemFieldImpl.setItemFieldId(getItemFieldId());
		shoppingItemFieldImpl.setCompanyId(getCompanyId());
		shoppingItemFieldImpl.setItemId(getItemId());
		shoppingItemFieldImpl.setName(getName());
		shoppingItemFieldImpl.setValues(getValues());
		shoppingItemFieldImpl.setDescription(getDescription());

		shoppingItemFieldImpl.resetOriginalValues();

		return shoppingItemFieldImpl;
	}

	@Override
	public int compareTo(ShoppingItemField shoppingItemField) {
		int value = 0;

		if (getItemId() < shoppingItemField.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemField.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareToIgnoreCase(shoppingItemField.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingItemField)) {
			return false;
		}

		ShoppingItemField shoppingItemField = (ShoppingItemField)obj;

		long primaryKey = shoppingItemField.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ShoppingItemFieldModelImpl shoppingItemFieldModelImpl = this;

		shoppingItemFieldModelImpl._originalItemId =
			shoppingItemFieldModelImpl._itemId;

		shoppingItemFieldModelImpl._setOriginalItemId = false;

		shoppingItemFieldModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ShoppingItemField> toCacheModel() {
		ShoppingItemFieldCacheModel shoppingItemFieldCacheModel =
			new ShoppingItemFieldCacheModel();

		shoppingItemFieldCacheModel.itemFieldId = getItemFieldId();

		shoppingItemFieldCacheModel.companyId = getCompanyId();

		shoppingItemFieldCacheModel.itemId = getItemId();

		shoppingItemFieldCacheModel.name = getName();

		String name = shoppingItemFieldCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			shoppingItemFieldCacheModel.name = null;
		}

		shoppingItemFieldCacheModel.values = getValues();

		String values = shoppingItemFieldCacheModel.values;

		if ((values != null) && (values.length() == 0)) {
			shoppingItemFieldCacheModel.values = null;
		}

		shoppingItemFieldCacheModel.description = getDescription();

		String description = shoppingItemFieldCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			shoppingItemFieldCacheModel.description = null;
		}

		return shoppingItemFieldCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ShoppingItemField, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ShoppingItemField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShoppingItemField, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ShoppingItemField)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ShoppingItemField, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ShoppingItemField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShoppingItemField, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ShoppingItemField)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, ShoppingItemField>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _itemFieldId;
	private long _companyId;
	private long _itemId;
	private long _originalItemId;
	private boolean _setOriginalItemId;
	private String _name;
	private String _values;
	private String _description;
	private long _columnBitmask;
	private ShoppingItemField _escapedModel;

}