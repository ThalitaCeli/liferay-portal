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

package com.liferay.portal.workflow.kaleo.model.impl;

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoNodeModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the KaleoNode service. Represents a row in the &quot;KaleoNode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>KaleoNodeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoNodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNodeImpl
 * @generated
 */
@ProviderType
public class KaleoNodeModelImpl
	extends BaseModelImpl<KaleoNode> implements KaleoNodeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo node model instance should use the <code>KaleoNode</code> interface instead.
	 */
	public static final String TABLE_NAME = "KaleoNode";

	public static final Object[][] TABLE_COLUMNS = {
		{"kaleoNodeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"kaleoDefinitionId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"metadata", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"type_", Types.VARCHAR},
		{"initial_", Types.BOOLEAN}, {"terminal", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("kaleoNodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metadata", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("initial_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("terminal", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table KaleoNode (kaleoNodeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionId LONG,name VARCHAR(200) null,metadata STRING null,description STRING null,type_ VARCHAR(20) null,initial_ BOOLEAN,terminal BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table KaleoNode";

	public static final String ORDER_BY_JPQL =
		" ORDER BY kaleoNode.kaleoNodeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY KaleoNode.kaleoNodeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long KALEODEFINITIONID_COLUMN_BITMASK = 2L;

	public static final long KALEONODEID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoNode"));

	public KaleoNodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoNodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoNodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoNodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoNode.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoNode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KaleoNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KaleoNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((KaleoNode)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KaleoNode, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KaleoNode, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(KaleoNode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<KaleoNode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KaleoNode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, KaleoNode>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			KaleoNode.class.getClassLoader(), KaleoNode.class,
			ModelWrapper.class);

		try {
			Constructor<KaleoNode> constructor =
				(Constructor<KaleoNode>)proxyClass.getConstructor(
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

	private static final Map<String, Function<KaleoNode, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<KaleoNode, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<KaleoNode, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<KaleoNode, Object>>();
		Map<String, BiConsumer<KaleoNode, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<KaleoNode, ?>>();

		attributeGetterFunctions.put(
			"kaleoNodeId",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getKaleoNodeId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoNodeId",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object kaleoNodeId) {
					kaleoNode.setKaleoNodeId((Long)kaleoNodeId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object groupId) {
					kaleoNode.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object companyId) {
					kaleoNode.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object userId) {
					kaleoNode.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object userName) {
					kaleoNode.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object createDate) {
					kaleoNode.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object modifiedDate) {
					kaleoNode.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"kaleoDefinitionId",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getKaleoDefinitionId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoDefinitionId",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(
					KaleoNode kaleoNode, Object kaleoDefinitionId) {

					kaleoNode.setKaleoDefinitionId((Long)kaleoDefinitionId);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object name) {
					kaleoNode.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"metadata",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getMetadata();
				}

			});
		attributeSetterBiConsumers.put(
			"metadata",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object metadata) {
					kaleoNode.setMetadata((String)metadata);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object description) {
					kaleoNode.setDescription((String)description);
				}

			});
		attributeGetterFunctions.put(
			"type",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getType();
				}

			});
		attributeSetterBiConsumers.put(
			"type",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object type) {
					kaleoNode.setType((String)type);
				}

			});
		attributeGetterFunctions.put(
			"initial",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getInitial();
				}

			});
		attributeSetterBiConsumers.put(
			"initial",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object initial) {
					kaleoNode.setInitial((Boolean)initial);
				}

			});
		attributeGetterFunctions.put(
			"terminal",
			new Function<KaleoNode, Object>() {

				@Override
				public Object apply(KaleoNode kaleoNode) {
					return kaleoNode.getTerminal();
				}

			});
		attributeSetterBiConsumers.put(
			"terminal",
			new BiConsumer<KaleoNode, Object>() {

				@Override
				public void accept(KaleoNode kaleoNode, Object terminal) {
					kaleoNode.setTerminal((Boolean)terminal);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getKaleoNodeId() {
		return _kaleoNodeId;
	}

	@Override
	public void setKaleoNodeId(long kaleoNodeId) {
		_columnBitmask = -1L;

		_kaleoNodeId = kaleoNodeId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	@Override
	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
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
	public String getMetadata() {
		if (_metadata == null) {
			return "";
		}
		else {
			return _metadata;
		}
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;
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

	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public boolean getInitial() {
		return _initial;
	}

	@Override
	public boolean isInitial() {
		return _initial;
	}

	@Override
	public void setInitial(boolean initial) {
		_initial = initial;
	}

	@Override
	public boolean getTerminal() {
		return _terminal;
	}

	@Override
	public boolean isTerminal() {
		return _terminal;
	}

	@Override
	public void setTerminal(boolean terminal) {
		_terminal = terminal;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), KaleoNode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoNode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KaleoNodeImpl kaleoNodeImpl = new KaleoNodeImpl();

		kaleoNodeImpl.setKaleoNodeId(getKaleoNodeId());
		kaleoNodeImpl.setGroupId(getGroupId());
		kaleoNodeImpl.setCompanyId(getCompanyId());
		kaleoNodeImpl.setUserId(getUserId());
		kaleoNodeImpl.setUserName(getUserName());
		kaleoNodeImpl.setCreateDate(getCreateDate());
		kaleoNodeImpl.setModifiedDate(getModifiedDate());
		kaleoNodeImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoNodeImpl.setName(getName());
		kaleoNodeImpl.setMetadata(getMetadata());
		kaleoNodeImpl.setDescription(getDescription());
		kaleoNodeImpl.setType(getType());
		kaleoNodeImpl.setInitial(isInitial());
		kaleoNodeImpl.setTerminal(isTerminal());

		kaleoNodeImpl.resetOriginalValues();

		return kaleoNodeImpl;
	}

	@Override
	public int compareTo(KaleoNode kaleoNode) {
		int value = 0;

		if (getKaleoNodeId() < kaleoNode.getKaleoNodeId()) {
			value = -1;
		}
		else if (getKaleoNodeId() > kaleoNode.getKaleoNodeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof KaleoNode)) {
			return false;
		}

		KaleoNode kaleoNode = (KaleoNode)obj;

		long primaryKey = kaleoNode.getPrimaryKey();

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
		KaleoNodeModelImpl kaleoNodeModelImpl = this;

		kaleoNodeModelImpl._originalCompanyId = kaleoNodeModelImpl._companyId;

		kaleoNodeModelImpl._setOriginalCompanyId = false;

		kaleoNodeModelImpl._setModifiedDate = false;

		kaleoNodeModelImpl._originalKaleoDefinitionId =
			kaleoNodeModelImpl._kaleoDefinitionId;

		kaleoNodeModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoNodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoNode> toCacheModel() {
		KaleoNodeCacheModel kaleoNodeCacheModel = new KaleoNodeCacheModel();

		kaleoNodeCacheModel.kaleoNodeId = getKaleoNodeId();

		kaleoNodeCacheModel.groupId = getGroupId();

		kaleoNodeCacheModel.companyId = getCompanyId();

		kaleoNodeCacheModel.userId = getUserId();

		kaleoNodeCacheModel.userName = getUserName();

		String userName = kaleoNodeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoNodeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoNodeCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoNodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoNodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoNodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoNodeCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoNodeCacheModel.name = getName();

		String name = kaleoNodeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoNodeCacheModel.name = null;
		}

		kaleoNodeCacheModel.metadata = getMetadata();

		String metadata = kaleoNodeCacheModel.metadata;

		if ((metadata != null) && (metadata.length() == 0)) {
			kaleoNodeCacheModel.metadata = null;
		}

		kaleoNodeCacheModel.description = getDescription();

		String description = kaleoNodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoNodeCacheModel.description = null;
		}

		kaleoNodeCacheModel.type = getType();

		String type = kaleoNodeCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			kaleoNodeCacheModel.type = null;
		}

		kaleoNodeCacheModel.initial = isInitial();

		kaleoNodeCacheModel.terminal = isTerminal();

		return kaleoNodeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KaleoNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<KaleoNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KaleoNode)this));
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
		Map<String, Function<KaleoNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KaleoNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KaleoNode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, KaleoNode>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _kaleoNodeId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private String _name;
	private String _metadata;
	private String _description;
	private String _type;
	private boolean _initial;
	private boolean _terminal;
	private long _columnBitmask;
	private KaleoNode _escapedModel;

}