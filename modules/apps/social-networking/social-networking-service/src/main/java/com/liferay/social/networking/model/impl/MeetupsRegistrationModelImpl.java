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

package com.liferay.social.networking.model.impl;

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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.social.networking.model.MeetupsRegistration;
import com.liferay.social.networking.model.MeetupsRegistrationModel;

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
 * The base model implementation for the MeetupsRegistration service. Represents a row in the &quot;SN_MeetupsRegistration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>MeetupsRegistrationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MeetupsRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MeetupsRegistrationImpl
 * @generated
 */
@ProviderType
public class MeetupsRegistrationModelImpl
	extends BaseModelImpl<MeetupsRegistration>
	implements MeetupsRegistrationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a meetups registration model instance should use the <code>MeetupsRegistration</code> interface instead.
	 */
	public static final String TABLE_NAME = "SN_MeetupsRegistration";

	public static final Object[][] TABLE_COLUMNS = {
		{"meetupsRegistrationId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"meetupsEntryId", Types.BIGINT}, {"status", Types.INTEGER},
		{"comments", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("meetupsRegistrationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("meetupsEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SN_MeetupsRegistration (meetupsRegistrationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,meetupsEntryId LONG,status INTEGER,comments VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table SN_MeetupsRegistration";

	public static final String ORDER_BY_JPQL =
		" ORDER BY meetupsRegistration.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SN_MeetupsRegistration.modifiedDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.social.networking.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.social.networking.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.social.networking.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
		true);

	public static final long MEETUPSENTRYID_COLUMN_BITMASK = 1L;

	public static final long STATUS_COLUMN_BITMASK = 2L;

	public static final long USERID_COLUMN_BITMASK = 4L;

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.social.networking.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.social.networking.model.MeetupsRegistration"));

	public MeetupsRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeetupsRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MeetupsRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return MeetupsRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<MeetupsRegistration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<MeetupsRegistration, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MeetupsRegistration, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((MeetupsRegistration)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<MeetupsRegistration, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<MeetupsRegistration, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(MeetupsRegistration)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<MeetupsRegistration, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<MeetupsRegistration, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, MeetupsRegistration>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			MeetupsRegistration.class.getClassLoader(),
			MeetupsRegistration.class, ModelWrapper.class);

		try {
			Constructor<MeetupsRegistration> constructor =
				(Constructor<MeetupsRegistration>)proxyClass.getConstructor(
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

	private static final Map<String, Function<MeetupsRegistration, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<MeetupsRegistration, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<MeetupsRegistration, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<MeetupsRegistration, Object>>();
		Map<String, BiConsumer<MeetupsRegistration, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<MeetupsRegistration, ?>>();

		attributeGetterFunctions.put(
			"meetupsRegistrationId",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getMeetupsRegistrationId();
				}

			});
		attributeSetterBiConsumers.put(
			"meetupsRegistrationId",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration,
					Object meetupsRegistrationId) {

					meetupsRegistration.setMeetupsRegistrationId(
						(Long)meetupsRegistrationId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration, Object companyId) {

					meetupsRegistration.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration, Object userId) {

					meetupsRegistration.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration, Object userName) {

					meetupsRegistration.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration,
					Object createDate) {

					meetupsRegistration.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration,
					Object modifiedDate) {

					meetupsRegistration.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"meetupsEntryId",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getMeetupsEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"meetupsEntryId",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration,
					Object meetupsEntryId) {

					meetupsRegistration.setMeetupsEntryId((Long)meetupsEntryId);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration, Object status) {

					meetupsRegistration.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"comments",
			new Function<MeetupsRegistration, Object>() {

				@Override
				public Object apply(MeetupsRegistration meetupsRegistration) {
					return meetupsRegistration.getComments();
				}

			});
		attributeSetterBiConsumers.put(
			"comments",
			new BiConsumer<MeetupsRegistration, Object>() {

				@Override
				public void accept(
					MeetupsRegistration meetupsRegistration, Object comments) {

					meetupsRegistration.setComments((String)comments);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMeetupsRegistrationId() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setMeetupsRegistrationId(long meetupsRegistrationId) {
		_meetupsRegistrationId = meetupsRegistrationId;
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getMeetupsEntryId() {
		return _meetupsEntryId;
	}

	@Override
	public void setMeetupsEntryId(long meetupsEntryId) {
		_columnBitmask |= MEETUPSENTRYID_COLUMN_BITMASK;

		if (!_setOriginalMeetupsEntryId) {
			_setOriginalMeetupsEntryId = true;

			_originalMeetupsEntryId = _meetupsEntryId;
		}

		_meetupsEntryId = meetupsEntryId;
	}

	public long getOriginalMeetupsEntryId() {
		return _originalMeetupsEntryId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public String getComments() {
		if (_comments == null) {
			return "";
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), MeetupsRegistration.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MeetupsRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MeetupsRegistrationImpl meetupsRegistrationImpl =
			new MeetupsRegistrationImpl();

		meetupsRegistrationImpl.setMeetupsRegistrationId(
			getMeetupsRegistrationId());
		meetupsRegistrationImpl.setCompanyId(getCompanyId());
		meetupsRegistrationImpl.setUserId(getUserId());
		meetupsRegistrationImpl.setUserName(getUserName());
		meetupsRegistrationImpl.setCreateDate(getCreateDate());
		meetupsRegistrationImpl.setModifiedDate(getModifiedDate());
		meetupsRegistrationImpl.setMeetupsEntryId(getMeetupsEntryId());
		meetupsRegistrationImpl.setStatus(getStatus());
		meetupsRegistrationImpl.setComments(getComments());

		meetupsRegistrationImpl.resetOriginalValues();

		return meetupsRegistrationImpl;
	}

	@Override
	public int compareTo(MeetupsRegistration meetupsRegistration) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), meetupsRegistration.getModifiedDate());

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

		if (!(obj instanceof MeetupsRegistration)) {
			return false;
		}

		MeetupsRegistration meetupsRegistration = (MeetupsRegistration)obj;

		long primaryKey = meetupsRegistration.getPrimaryKey();

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
		MeetupsRegistrationModelImpl meetupsRegistrationModelImpl = this;

		meetupsRegistrationModelImpl._originalUserId =
			meetupsRegistrationModelImpl._userId;

		meetupsRegistrationModelImpl._setOriginalUserId = false;

		meetupsRegistrationModelImpl._setModifiedDate = false;

		meetupsRegistrationModelImpl._originalMeetupsEntryId =
			meetupsRegistrationModelImpl._meetupsEntryId;

		meetupsRegistrationModelImpl._setOriginalMeetupsEntryId = false;

		meetupsRegistrationModelImpl._originalStatus =
			meetupsRegistrationModelImpl._status;

		meetupsRegistrationModelImpl._setOriginalStatus = false;

		meetupsRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MeetupsRegistration> toCacheModel() {
		MeetupsRegistrationCacheModel meetupsRegistrationCacheModel =
			new MeetupsRegistrationCacheModel();

		meetupsRegistrationCacheModel.meetupsRegistrationId =
			getMeetupsRegistrationId();

		meetupsRegistrationCacheModel.companyId = getCompanyId();

		meetupsRegistrationCacheModel.userId = getUserId();

		meetupsRegistrationCacheModel.userName = getUserName();

		String userName = meetupsRegistrationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			meetupsRegistrationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			meetupsRegistrationCacheModel.createDate = createDate.getTime();
		}
		else {
			meetupsRegistrationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			meetupsRegistrationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			meetupsRegistrationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		meetupsRegistrationCacheModel.meetupsEntryId = getMeetupsEntryId();

		meetupsRegistrationCacheModel.status = getStatus();

		meetupsRegistrationCacheModel.comments = getComments();

		String comments = meetupsRegistrationCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			meetupsRegistrationCacheModel.comments = null;
		}

		return meetupsRegistrationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<MeetupsRegistration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<MeetupsRegistration, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MeetupsRegistration, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((MeetupsRegistration)this));
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
		Map<String, Function<MeetupsRegistration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<MeetupsRegistration, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MeetupsRegistration, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((MeetupsRegistration)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, MeetupsRegistration>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _meetupsRegistrationId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _meetupsEntryId;
	private long _originalMeetupsEntryId;
	private boolean _setOriginalMeetupsEntryId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private String _comments;
	private long _columnBitmask;
	private MeetupsRegistration _escapedModel;

}