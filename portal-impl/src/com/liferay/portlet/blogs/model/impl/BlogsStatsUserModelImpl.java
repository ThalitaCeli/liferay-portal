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

package com.liferay.portlet.blogs.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.blogs.kernel.model.BlogsStatsUser;
import com.liferay.blogs.kernel.model.BlogsStatsUserModel;
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
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the BlogsStatsUser service. Represents a row in the &quot;BlogsStatsUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>BlogsStatsUserModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlogsStatsUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsStatsUserImpl
 * @generated
 */
@ProviderType
public class BlogsStatsUserModelImpl
	extends BaseModelImpl<BlogsStatsUser> implements BlogsStatsUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a blogs stats user model instance should use the <code>BlogsStatsUser</code> interface instead.
	 */
	public static final String TABLE_NAME = "BlogsStatsUser";

	public static final Object[][] TABLE_COLUMNS = {
		{"statsUserId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"entryCount", Types.INTEGER}, {"lastPostDate", Types.TIMESTAMP},
		{"ratingsTotalEntries", Types.INTEGER},
		{"ratingsTotalScore", Types.DOUBLE},
		{"ratingsAverageScore", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("statsUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entryCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPostDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ratingsTotalEntries", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("ratingsTotalScore", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("ratingsAverageScore", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BlogsStatsUser (statsUserId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,entryCount INTEGER,lastPostDate DATE null,ratingsTotalEntries INTEGER,ratingsTotalScore DOUBLE,ratingsAverageScore DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table BlogsStatsUser";

	public static final String ORDER_BY_JPQL =
		" ORDER BY blogsStatsUser.entryCount DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BlogsStatsUser.entryCount DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.blogs.kernel.model.BlogsStatsUser"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.blogs.kernel.model.BlogsStatsUser"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.blogs.kernel.model.BlogsStatsUser"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long ENTRYCOUNT_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long LASTPOSTDATE_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.blogs.kernel.model.BlogsStatsUser"));

	public BlogsStatsUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatsUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BlogsStatsUser.class;
	}

	@Override
	public String getModelClassName() {
		return BlogsStatsUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BlogsStatsUser)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BlogsStatsUser, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BlogsStatsUser, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BlogsStatsUser)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BlogsStatsUser, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BlogsStatsUser, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BlogsStatsUser>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BlogsStatsUser.class.getClassLoader(), BlogsStatsUser.class,
			ModelWrapper.class);

		try {
			Constructor<BlogsStatsUser> constructor =
				(Constructor<BlogsStatsUser>)proxyClass.getConstructor(
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

	private static final Map<String, Function<BlogsStatsUser, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BlogsStatsUser, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BlogsStatsUser, Object>>();
		Map<String, BiConsumer<BlogsStatsUser, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BlogsStatsUser, ?>>();

		attributeGetterFunctions.put(
			"statsUserId",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getStatsUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statsUserId",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object statsUserId) {

					blogsStatsUser.setStatsUserId((Long)statsUserId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object groupId) {

					blogsStatsUser.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object companyId) {

					blogsStatsUser.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object userId) {

					blogsStatsUser.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"entryCount",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getEntryCount();
				}

			});
		attributeSetterBiConsumers.put(
			"entryCount",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object entryCount) {

					blogsStatsUser.setEntryCount((Integer)entryCount);
				}

			});
		attributeGetterFunctions.put(
			"lastPostDate",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getLastPostDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPostDate",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object lastPostDate) {

					blogsStatsUser.setLastPostDate((Date)lastPostDate);
				}

			});
		attributeGetterFunctions.put(
			"ratingsTotalEntries",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getRatingsTotalEntries();
				}

			});
		attributeSetterBiConsumers.put(
			"ratingsTotalEntries",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object ratingsTotalEntries) {

					blogsStatsUser.setRatingsTotalEntries(
						(Integer)ratingsTotalEntries);
				}

			});
		attributeGetterFunctions.put(
			"ratingsTotalScore",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getRatingsTotalScore();
				}

			});
		attributeSetterBiConsumers.put(
			"ratingsTotalScore",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object ratingsTotalScore) {

					blogsStatsUser.setRatingsTotalScore(
						(Double)ratingsTotalScore);
				}

			});
		attributeGetterFunctions.put(
			"ratingsAverageScore",
			new Function<BlogsStatsUser, Object>() {

				@Override
				public Object apply(BlogsStatsUser blogsStatsUser) {
					return blogsStatsUser.getRatingsAverageScore();
				}

			});
		attributeSetterBiConsumers.put(
			"ratingsAverageScore",
			new BiConsumer<BlogsStatsUser, Object>() {

				@Override
				public void accept(
					BlogsStatsUser blogsStatsUser, Object ratingsAverageScore) {

					blogsStatsUser.setRatingsAverageScore(
						(Double)ratingsAverageScore);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStatsUserId() {
		return _statsUserId;
	}

	@Override
	public void setStatsUserId(long statsUserId) {
		_statsUserId = statsUserId;
	}

	@Override
	public String getStatsUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatsUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatsUserUuid(String statsUserUuid) {
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	public int getEntryCount() {
		return _entryCount;
	}

	@Override
	public void setEntryCount(int entryCount) {
		_columnBitmask = -1L;

		if (!_setOriginalEntryCount) {
			_setOriginalEntryCount = true;

			_originalEntryCount = _entryCount;
		}

		_entryCount = entryCount;
	}

	public int getOriginalEntryCount() {
		return _originalEntryCount;
	}

	@Override
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public void setLastPostDate(Date lastPostDate) {
		_columnBitmask |= LASTPOSTDATE_COLUMN_BITMASK;

		if (_originalLastPostDate == null) {
			_originalLastPostDate = _lastPostDate;
		}

		_lastPostDate = lastPostDate;
	}

	public Date getOriginalLastPostDate() {
		return _originalLastPostDate;
	}

	@Override
	public int getRatingsTotalEntries() {
		return _ratingsTotalEntries;
	}

	@Override
	public void setRatingsTotalEntries(int ratingsTotalEntries) {
		_ratingsTotalEntries = ratingsTotalEntries;
	}

	@Override
	public double getRatingsTotalScore() {
		return _ratingsTotalScore;
	}

	@Override
	public void setRatingsTotalScore(double ratingsTotalScore) {
		_ratingsTotalScore = ratingsTotalScore;
	}

	@Override
	public double getRatingsAverageScore() {
		return _ratingsAverageScore;
	}

	@Override
	public void setRatingsAverageScore(double ratingsAverageScore) {
		_ratingsAverageScore = ratingsAverageScore;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), BlogsStatsUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BlogsStatsUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BlogsStatsUserImpl blogsStatsUserImpl = new BlogsStatsUserImpl();

		blogsStatsUserImpl.setStatsUserId(getStatsUserId());
		blogsStatsUserImpl.setGroupId(getGroupId());
		blogsStatsUserImpl.setCompanyId(getCompanyId());
		blogsStatsUserImpl.setUserId(getUserId());
		blogsStatsUserImpl.setEntryCount(getEntryCount());
		blogsStatsUserImpl.setLastPostDate(getLastPostDate());
		blogsStatsUserImpl.setRatingsTotalEntries(getRatingsTotalEntries());
		blogsStatsUserImpl.setRatingsTotalScore(getRatingsTotalScore());
		blogsStatsUserImpl.setRatingsAverageScore(getRatingsAverageScore());

		blogsStatsUserImpl.resetOriginalValues();

		return blogsStatsUserImpl;
	}

	@Override
	public int compareTo(BlogsStatsUser blogsStatsUser) {
		int value = 0;

		if (getEntryCount() < blogsStatsUser.getEntryCount()) {
			value = -1;
		}
		else if (getEntryCount() > blogsStatsUser.getEntryCount()) {
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

		if (!(obj instanceof BlogsStatsUser)) {
			return false;
		}

		BlogsStatsUser blogsStatsUser = (BlogsStatsUser)obj;

		long primaryKey = blogsStatsUser.getPrimaryKey();

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
		BlogsStatsUserModelImpl blogsStatsUserModelImpl = this;

		blogsStatsUserModelImpl._originalGroupId =
			blogsStatsUserModelImpl._groupId;

		blogsStatsUserModelImpl._setOriginalGroupId = false;

		blogsStatsUserModelImpl._originalCompanyId =
			blogsStatsUserModelImpl._companyId;

		blogsStatsUserModelImpl._setOriginalCompanyId = false;

		blogsStatsUserModelImpl._originalUserId =
			blogsStatsUserModelImpl._userId;

		blogsStatsUserModelImpl._setOriginalUserId = false;

		blogsStatsUserModelImpl._originalEntryCount =
			blogsStatsUserModelImpl._entryCount;

		blogsStatsUserModelImpl._setOriginalEntryCount = false;

		blogsStatsUserModelImpl._originalLastPostDate =
			blogsStatsUserModelImpl._lastPostDate;

		blogsStatsUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BlogsStatsUser> toCacheModel() {
		BlogsStatsUserCacheModel blogsStatsUserCacheModel =
			new BlogsStatsUserCacheModel();

		blogsStatsUserCacheModel.statsUserId = getStatsUserId();

		blogsStatsUserCacheModel.groupId = getGroupId();

		blogsStatsUserCacheModel.companyId = getCompanyId();

		blogsStatsUserCacheModel.userId = getUserId();

		blogsStatsUserCacheModel.entryCount = getEntryCount();

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			blogsStatsUserCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			blogsStatsUserCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		blogsStatsUserCacheModel.ratingsTotalEntries = getRatingsTotalEntries();

		blogsStatsUserCacheModel.ratingsTotalScore = getRatingsTotalScore();

		blogsStatsUserCacheModel.ratingsAverageScore = getRatingsAverageScore();

		return blogsStatsUserCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((BlogsStatsUser)this));
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
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BlogsStatsUser)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, BlogsStatsUser>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _statsUserId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private int _entryCount;
	private int _originalEntryCount;
	private boolean _setOriginalEntryCount;
	private Date _lastPostDate;
	private Date _originalLastPostDate;
	private int _ratingsTotalEntries;
	private double _ratingsTotalScore;
	private double _ratingsAverageScore;
	private long _columnBitmask;
	private BlogsStatsUser _escapedModel;

}