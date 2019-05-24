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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.RegionModel;
import com.liferay.portal.kernel.model.RegionSoap;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Region service. Represents a row in the &quot;Region&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RegionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RegionModelImpl
	extends BaseModelImpl<Region> implements RegionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a region model instance should use the <code>Region</code> interface instead.
	 */
	public static final String TABLE_NAME = "Region";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"regionId", Types.BIGINT},
		{"countryId", Types.BIGINT}, {"regionCode", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("regionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("countryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("regionCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Region (mvccVersion LONG default 0 not null,regionId LONG not null primary key,countryId LONG,regionCode VARCHAR(75) null,name VARCHAR(75) null,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table Region";

	public static final String ORDER_BY_JPQL = " ORDER BY region.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Region.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.Region"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.Region"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.Region"),
		true);

	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	public static final long COUNTRYID_COLUMN_BITMASK = 2L;

	public static final long REGIONCODE_COLUMN_BITMASK = 4L;

	public static final long NAME_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Region toModel(RegionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Region model = new RegionImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setRegionId(soapModel.getRegionId());
		model.setCountryId(soapModel.getCountryId());
		model.setRegionCode(soapModel.getRegionCode());
		model.setName(soapModel.getName());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Region> toModels(RegionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Region> models = new ArrayList<Region>(soapModels.length);

		for (RegionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.Region"));

	public RegionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _regionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Region.class;
	}

	@Override
	public String getModelClassName() {
		return Region.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Region)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Region, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Region, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Region)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Region, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Region, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Region>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Region.class.getClassLoader(), Region.class, ModelWrapper.class);

		try {
			Constructor<Region> constructor =
				(Constructor<Region>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Region, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Region, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Region, Object>>();
		Map<String, BiConsumer<Region, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Region, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object mvccVersion) {
					region.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"regionId",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getRegionId();
				}

			});
		attributeSetterBiConsumers.put(
			"regionId",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object regionId) {
					region.setRegionId((Long)regionId);
				}

			});
		attributeGetterFunctions.put(
			"countryId",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getCountryId();
				}

			});
		attributeSetterBiConsumers.put(
			"countryId",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object countryId) {
					region.setCountryId((Long)countryId);
				}

			});
		attributeGetterFunctions.put(
			"regionCode",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getRegionCode();
				}

			});
		attributeSetterBiConsumers.put(
			"regionCode",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object regionCode) {
					region.setRegionCode((String)regionCode);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object name) {
					region.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"active",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getActive();
				}

			});
		attributeSetterBiConsumers.put(
			"active",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object active) {
					region.setActive((Boolean)active);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	@JSON
	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_columnBitmask |= COUNTRYID_COLUMN_BITMASK;

		if (!_setOriginalCountryId) {
			_setOriginalCountryId = true;

			_originalCountryId = _countryId;
		}

		_countryId = countryId;
	}

	public long getOriginalCountryId() {
		return _originalCountryId;
	}

	@JSON
	@Override
	public String getRegionCode() {
		if (_regionCode == null) {
			return "";
		}
		else {
			return _regionCode;
		}
	}

	@Override
	public void setRegionCode(String regionCode) {
		_columnBitmask |= REGIONCODE_COLUMN_BITMASK;

		if (_originalRegionCode == null) {
			_originalRegionCode = _regionCode;
		}

		_regionCode = regionCode;
	}

	public String getOriginalRegionCode() {
		return GetterUtil.getString(_originalRegionCode);
	}

	@JSON
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

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Region.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Region toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegionImpl regionImpl = new RegionImpl();

		regionImpl.setMvccVersion(getMvccVersion());
		regionImpl.setRegionId(getRegionId());
		regionImpl.setCountryId(getCountryId());
		regionImpl.setRegionCode(getRegionCode());
		regionImpl.setName(getName());
		regionImpl.setActive(isActive());

		regionImpl.resetOriginalValues();

		return regionImpl;
	}

	@Override
	public int compareTo(Region region) {
		int value = 0;

		value = getName().compareTo(region.getName());

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

		if (!(obj instanceof Region)) {
			return false;
		}

		Region region = (Region)obj;

		long primaryKey = region.getPrimaryKey();

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
		RegionModelImpl regionModelImpl = this;

		regionModelImpl._originalCountryId = regionModelImpl._countryId;

		regionModelImpl._setOriginalCountryId = false;

		regionModelImpl._originalRegionCode = regionModelImpl._regionCode;

		regionModelImpl._originalActive = regionModelImpl._active;

		regionModelImpl._setOriginalActive = false;

		regionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Region> toCacheModel() {
		RegionCacheModel regionCacheModel = new RegionCacheModel();

		regionCacheModel.mvccVersion = getMvccVersion();

		regionCacheModel.regionId = getRegionId();

		regionCacheModel.countryId = getCountryId();

		regionCacheModel.regionCode = getRegionCode();

		String regionCode = regionCacheModel.regionCode;

		if ((regionCode != null) && (regionCode.length() == 0)) {
			regionCacheModel.regionCode = null;
		}

		regionCacheModel.name = getName();

		String name = regionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			regionCacheModel.name = null;
		}

		regionCacheModel.active = isActive();

		return regionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Region)this));
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
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Region)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Region>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _mvccVersion;
	private long _regionId;
	private long _countryId;
	private long _originalCountryId;
	private boolean _setOriginalCountryId;
	private String _regionCode;
	private String _originalRegionCode;
	private String _name;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _columnBitmask;
	private Region _escapedModel;

}