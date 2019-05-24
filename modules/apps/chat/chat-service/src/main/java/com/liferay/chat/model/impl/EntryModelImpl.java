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

package com.liferay.chat.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.chat.model.Entry;
import com.liferay.chat.model.EntryModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
 * The base model implementation for the Entry service. Represents a row in the &quot;Chat_Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>EntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntryImpl
 * @generated
 */
@ProviderType
public class EntryModelImpl extends BaseModelImpl<Entry> implements EntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a entry model instance should use the <code>Entry</code> interface instead.
	 */
	public static final String TABLE_NAME = "Chat_Entry";

	public static final Object[][] TABLE_COLUMNS = {
		{"entryId", Types.BIGINT}, {"createDate", Types.BIGINT},
		{"fromUserId", Types.BIGINT}, {"toUserId", Types.BIGINT},
		{"content", Types.VARCHAR}, {"flag", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("entryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fromUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("toUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("flag", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Chat_Entry (entryId LONG not null primary key,createDate LONG,fromUserId LONG,toUserId LONG,content VARCHAR(1000) null,flag INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table Chat_Entry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY entry.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Chat_Entry.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.chat.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.chat.model.Entry"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.chat.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.chat.model.Entry"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.chat.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.chat.model.Entry"),
		true);

	public static final long CONTENT_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	public static final long FROMUSERID_COLUMN_BITMASK = 4L;

	public static final long TOUSERID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.chat.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.chat.model.Entry"));

	public EntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _entryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Entry.class;
	}

	@Override
	public String getModelClassName() {
		return Entry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Entry, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Entry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Entry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Entry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Entry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Entry, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Entry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Entry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Entry.class.getClassLoader(), Entry.class, ModelWrapper.class);

		try {
			Constructor<Entry> constructor =
				(Constructor<Entry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Entry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Entry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Entry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Entry, Object>>();
		Map<String, BiConsumer<Entry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Entry, ?>>();

		attributeGetterFunctions.put(
			"entryId",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"entryId",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object entryId) {
					entry.setEntryId((Long)entryId);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object createDate) {
					entry.setCreateDate((Long)createDate);
				}

			});
		attributeGetterFunctions.put(
			"fromUserId",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getFromUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"fromUserId",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object fromUserId) {
					entry.setFromUserId((Long)fromUserId);
				}

			});
		attributeGetterFunctions.put(
			"toUserId",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getToUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"toUserId",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object toUserId) {
					entry.setToUserId((Long)toUserId);
				}

			});
		attributeGetterFunctions.put(
			"content",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getContent();
				}

			});
		attributeSetterBiConsumers.put(
			"content",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object content) {
					entry.setContent((String)content);
				}

			});
		attributeGetterFunctions.put(
			"flag",
			new Function<Entry, Object>() {

				@Override
				public Object apply(Entry entry) {
					return entry.getFlag();
				}

			});
		attributeSetterBiConsumers.put(
			"flag",
			new BiConsumer<Entry, Object>() {

				@Override
				public void accept(Entry entry, Object flag) {
					entry.setFlag((Integer)flag);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_columnBitmask = -1L;

		if (!_setOriginalCreateDate) {
			_setOriginalCreateDate = true;

			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public long getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@Override
	public long getFromUserId() {
		return _fromUserId;
	}

	@Override
	public void setFromUserId(long fromUserId) {
		_columnBitmask |= FROMUSERID_COLUMN_BITMASK;

		if (!_setOriginalFromUserId) {
			_setOriginalFromUserId = true;

			_originalFromUserId = _fromUserId;
		}

		_fromUserId = fromUserId;
	}

	@Override
	public String getFromUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getFromUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setFromUserUuid(String fromUserUuid) {
	}

	public long getOriginalFromUserId() {
		return _originalFromUserId;
	}

	@Override
	public long getToUserId() {
		return _toUserId;
	}

	@Override
	public void setToUserId(long toUserId) {
		_columnBitmask |= TOUSERID_COLUMN_BITMASK;

		if (!_setOriginalToUserId) {
			_setOriginalToUserId = true;

			_originalToUserId = _toUserId;
		}

		_toUserId = toUserId;
	}

	@Override
	public String getToUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getToUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setToUserUuid(String toUserUuid) {
	}

	public long getOriginalToUserId() {
		return _originalToUserId;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_columnBitmask |= CONTENT_COLUMN_BITMASK;

		if (_originalContent == null) {
			_originalContent = _content;
		}

		_content = content;
	}

	public String getOriginalContent() {
		return GetterUtil.getString(_originalContent);
	}

	@Override
	public int getFlag() {
		return _flag;
	}

	@Override
	public void setFlag(int flag) {
		_flag = flag;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Entry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Entry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EntryImpl entryImpl = new EntryImpl();

		entryImpl.setEntryId(getEntryId());
		entryImpl.setCreateDate(getCreateDate());
		entryImpl.setFromUserId(getFromUserId());
		entryImpl.setToUserId(getToUserId());
		entryImpl.setContent(getContent());
		entryImpl.setFlag(getFlag());

		entryImpl.resetOriginalValues();

		return entryImpl;
	}

	@Override
	public int compareTo(Entry entry) {
		int value = 0;

		if (getCreateDate() < entry.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > entry.getCreateDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof Entry)) {
			return false;
		}

		Entry entry = (Entry)obj;

		long primaryKey = entry.getPrimaryKey();

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
		EntryModelImpl entryModelImpl = this;

		entryModelImpl._originalCreateDate = entryModelImpl._createDate;

		entryModelImpl._setOriginalCreateDate = false;

		entryModelImpl._originalFromUserId = entryModelImpl._fromUserId;

		entryModelImpl._setOriginalFromUserId = false;

		entryModelImpl._originalToUserId = entryModelImpl._toUserId;

		entryModelImpl._setOriginalToUserId = false;

		entryModelImpl._originalContent = entryModelImpl._content;

		entryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Entry> toCacheModel() {
		EntryCacheModel entryCacheModel = new EntryCacheModel();

		entryCacheModel.entryId = getEntryId();

		entryCacheModel.createDate = getCreateDate();

		entryCacheModel.fromUserId = getFromUserId();

		entryCacheModel.toUserId = getToUserId();

		entryCacheModel.content = getContent();

		String content = entryCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			entryCacheModel.content = null;
		}

		entryCacheModel.flag = getFlag();

		return entryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Entry, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Entry)this));
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
		Map<String, Function<Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Entry, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Entry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Entry>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _entryId;
	private long _createDate;
	private long _originalCreateDate;
	private boolean _setOriginalCreateDate;
	private long _fromUserId;
	private long _originalFromUserId;
	private boolean _setOriginalFromUserId;
	private long _toUserId;
	private long _originalToUserId;
	private boolean _setOriginalToUserId;
	private String _content;
	private String _originalContent;
	private int _flag;
	private long _columnBitmask;
	private Entry _escapedModel;

}