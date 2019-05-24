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

package com.liferay.counter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.counter.kernel.model.Counter;
import com.liferay.counter.kernel.model.CounterModel;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
 * The base model implementation for the Counter service. Represents a row in the &quot;Counter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CounterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CounterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CounterImpl
 * @generated
 */
@ProviderType
public class CounterModelImpl
	extends BaseModelImpl<Counter> implements CounterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a counter model instance should use the <code>Counter</code> interface instead.
	 */
	public static final String TABLE_NAME = "Counter";

	public static final Object[][] TABLE_COLUMNS = {
		{"name", Types.VARCHAR}, {"currentId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("currentId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Counter (name VARCHAR(75) not null primary key,currentId LONG)";

	public static final String TABLE_SQL_DROP = "drop table Counter";

	public static final String ORDER_BY_JPQL = " ORDER BY counter.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Counter.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.counter.kernel.model.Counter"),
		false);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.counter.kernel.model.Counter"),
		false);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.counter.kernel.model.Counter"));

	public CounterModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _name;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _name;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Counter.class;
	}

	@Override
	public String getModelClassName() {
		return Counter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Counter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Counter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Counter, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Counter)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Counter, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Counter, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Counter)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Counter, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Counter, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Counter>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Counter.class.getClassLoader(), Counter.class, ModelWrapper.class);

		try {
			Constructor<Counter> constructor =
				(Constructor<Counter>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Counter, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Counter, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Counter, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Counter, Object>>();
		Map<String, BiConsumer<Counter, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Counter, ?>>();

		attributeGetterFunctions.put(
			"name",
			new Function<Counter, Object>() {

				@Override
				public Object apply(Counter counter) {
					return counter.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<Counter, Object>() {

				@Override
				public void accept(Counter counter, Object name) {
					counter.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"currentId",
			new Function<Counter, Object>() {

				@Override
				public Object apply(Counter counter) {
					return counter.getCurrentId();
				}

			});
		attributeSetterBiConsumers.put(
			"currentId",
			new BiConsumer<Counter, Object>() {

				@Override
				public void accept(Counter counter, Object currentId) {
					counter.setCurrentId((Long)currentId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
		_name = name;
	}

	@Override
	public long getCurrentId() {
		return _currentId;
	}

	@Override
	public void setCurrentId(long currentId) {
		_currentId = currentId;
	}

	@Override
	public Counter toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CounterImpl counterImpl = new CounterImpl();

		counterImpl.setName(getName());
		counterImpl.setCurrentId(getCurrentId());

		counterImpl.resetOriginalValues();

		return counterImpl;
	}

	@Override
	public int compareTo(Counter counter) {
		String primaryKey = counter.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Counter)) {
			return false;
		}

		Counter counter = (Counter)obj;

		String primaryKey = counter.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
	}

	@Override
	public CacheModel<Counter> toCacheModel() {
		CounterCacheModel counterCacheModel = new CounterCacheModel();

		counterCacheModel.name = getName();

		String name = counterCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			counterCacheModel.name = null;
		}

		counterCacheModel.currentId = getCurrentId();

		return counterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Counter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Counter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Counter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Counter)this));
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
		Map<String, Function<Counter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Counter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Counter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Counter)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Counter>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _name;
	private long _currentId;
	private Counter _escapedModel;

}