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

package com.liferay.blogs.service.http;

import com.liferay.blogs.service.BlogsEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>BlogsEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.blogs.model.BlogsEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.blogs.model.BlogsEntry</code>, that is translated to a
 * <code>com.liferay.blogs.model.BlogsEntrySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsEntryServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BlogsEntryServiceSoap {

	public static com.liferay.portal.kernel.repository.model.FolderSoap
			addAttachmentsFolder(long groupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.repository.model.Folder returnValue =
				BlogsEntryServiceUtil.addAttachmentsFolder(groupId);

			return com.liferay.portal.kernel.repository.model.FolderSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap addEntry(
			String title, String subtitle, String description, String content,
			int displayDateMonth, int displayDateDay, int displayDateYear,
			int displayDateHour, int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.addEntry(
					title, subtitle, description, content, displayDateMonth,
					displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, allowPingbacks, allowTrackbacks,
					trackbacks, coverImageCaption, coverImageImageSelector,
					smallImageImageSelector, serviceContext);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap addEntry(
			String externalReferenceCode, String title, String subtitle,
			String urlTitle, String description, String content,
			int displayDateMonth, int displayDateDay, int displayDateYear,
			int displayDateHour, int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.addEntry(
					externalReferenceCode, title, subtitle, urlTitle,
					description, content, displayDateMonth, displayDateDay,
					displayDateYear, displayDateHour, displayDateMinute,
					allowPingbacks, allowTrackbacks, trackbacks,
					coverImageCaption, coverImageImageSelector,
					smallImageImageSelector, serviceContext);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteEntry(long entryId) throws RemoteException {
		try {
			BlogsEntryServiceUtil.deleteEntry(entryId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getCompanyEntries(
			long companyId, java.util.Date displayDate, int status, int max)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getCompanyEntries(
					companyId, displayDate, status, max);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[]
			getEntriesPrevAndNext(long entryId)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry[] returnValue =
				BlogsEntryServiceUtil.getEntriesPrevAndNext(entryId);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap getEntry(long entryId)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.getEntry(entryId);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap getEntry(
			long groupId, String urlTitle)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.getEntry(groupId, urlTitle);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupEntries(
			long groupId, java.util.Date displayDate, int status, int max)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupEntries(
					groupId, displayDate, status, max);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupEntries(
			long groupId, java.util.Date displayDate, int status, int start,
			int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupEntries(
					groupId, displayDate, status, start, end);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupEntries(
			long groupId, int status, int max)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupEntries(groupId, status, max);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupEntries(
			long groupId, int status, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupEntries(
					groupId, status, start, end);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupEntries(
			long groupId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.blogs.model.BlogsEntry> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupEntries(
					groupId, status, start, end, orderByComparator);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getGroupEntriesCount(
			long groupId, java.util.Date displayDate, int status)
		throws RemoteException {

		try {
			int returnValue = BlogsEntryServiceUtil.getGroupEntriesCount(
				groupId, displayDate, status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getGroupEntriesCount(long groupId, int status)
		throws RemoteException {

		try {
			int returnValue = BlogsEntryServiceUtil.getGroupEntriesCount(
				groupId, status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupsEntries(
			long companyId, long groupId, java.util.Date displayDate,
			int status, int max)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupsEntries(
					companyId, groupId, displayDate, status, max);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupUserEntries(
			long groupId, long userId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.blogs.model.BlogsEntry> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupUserEntries(
					groupId, userId, status, start, end, orderByComparator);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[] getGroupUserEntries(
			long groupId, long userId, int[] statuses, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.blogs.model.BlogsEntry> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getGroupUserEntries(
					groupId, userId, statuses, start, end, orderByComparator);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getGroupUserEntriesCount(
			long groupId, long userId, int status)
		throws RemoteException {

		try {
			int returnValue = BlogsEntryServiceUtil.getGroupUserEntriesCount(
				groupId, userId, status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getGroupUserEntriesCount(
			long groupId, long userId, int[] statuses)
		throws RemoteException {

		try {
			int returnValue = BlogsEntryServiceUtil.getGroupUserEntriesCount(
				groupId, userId, statuses);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap[]
			getOrganizationEntries(
				long organizationId, java.util.Date displayDate, int status,
				int max)
		throws RemoteException {

		try {
			java.util.List<com.liferay.blogs.model.BlogsEntry> returnValue =
				BlogsEntryServiceUtil.getOrganizationEntries(
					organizationId, displayDate, status, max);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap moveEntryToTrash(
			long entryId)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.moveEntryToTrash(entryId);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void restoreEntryFromTrash(long entryId)
		throws RemoteException {

		try {
			BlogsEntryServiceUtil.restoreEntryFromTrash(entryId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void subscribe(long groupId) throws RemoteException {
		try {
			BlogsEntryServiceUtil.subscribe(groupId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void unsubscribe(long groupId) throws RemoteException {
		try {
			BlogsEntryServiceUtil.unsubscribe(groupId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap updateEntry(
			long entryId, String title, String subtitle, String description,
			String content, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			boolean allowPingbacks, boolean allowTrackbacks,
			String[] trackbacks, String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.updateEntry(
					entryId, title, subtitle, description, content,
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, allowPingbacks,
					allowTrackbacks, trackbacks, coverImageCaption,
					coverImageImageSelector, smallImageImageSelector,
					serviceContext);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.blogs.model.BlogsEntrySoap updateEntry(
			long entryId, String title, String subtitle, String urlTitle,
			String description, String content, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.blogs.model.BlogsEntry returnValue =
				BlogsEntryServiceUtil.updateEntry(
					entryId, title, subtitle, urlTitle, description, content,
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, allowPingbacks,
					allowTrackbacks, trackbacks, coverImageCaption,
					coverImageImageSelector, smallImageImageSelector,
					serviceContext);

			return com.liferay.blogs.model.BlogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		BlogsEntryServiceSoap.class);

}