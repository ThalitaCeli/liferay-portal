/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import ClayButton from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import {ClayTooltipProvider} from '@clayui/tooltip';
import EditAppContext from 'app-builder-web/js/pages/apps/edit/EditAppContext.es';
import {Sidebar} from 'data-engine-taglib';
import React, {useContext, useEffect, useState} from 'react';

import {AutocompleteMultiSelect} from '../../../../components/autocomplete/AutocompleteMultiSelect.es';
import ButtonInfo from '../../../../components/button-info/ButtonInfo.es';
import {UPDATE_STEP} from '../configReducer.es';
import ActionsTab from './ActionsTab.es';
import DataAndViewsTab from './DataAndViewsTab.es';

export default function EditAppSidebar({assigneeRoles}) {
	const {
		config: {
			currentStep,
			dataObject,
			formView,
			stepIndex,
			steps,
			tableView,
		},
		dispatchConfig,
	} = useContext(EditAppContext);

	const [currentTab, setCurrentTab] = useState();

	const {
		appWorkflowTransitions: [primaryAction, secondaryAction] = [],
		appWorkflowDataLayoutLinks: [stepFormView] = [{}],
	} = currentStep;

	const actionsInfo = [];

	if (primaryAction) {
		actionsInfo.push({
			label: Liferay.Language.get('primary-action'),
			name: `${primaryAction.name} → ${primaryAction.transitionTo}`,
		});
	}

	if (secondaryAction) {
		actionsInfo.push({
			label: Liferay.Language.get('secondary-action'),
			name: `${secondaryAction.name} → ${secondaryAction.transitionTo}`,
		});
	}

	const tabs = [
		{
			content: DataAndViewsTab,
			disabled: stepIndex > 0 && !dataObject.id,
			infoItems:
				stepIndex === 0
					? [
							{
								...dataObject,
								label: Liferay.Language.get('data-object'),
							},
							{
								...formView,
								label: Liferay.Language.get('form-view'),
							},
							{
								...tableView,
								label: Liferay.Language.get('table-view'),
							},
					  ]
					: [
							{
								...stepFormView,
								label: Liferay.Language.get('form-view'),
							},
					  ],
			show: stepIndex !== steps.length - 1,
			title: Liferay.Language.get('data-and-views'),
		},
		{
			content: ActionsTab,
			infoItems: actionsInfo,
			show: stepIndex !== steps.length - 1,
			title: Liferay.Language.get('actions'),
		},
	];

	const onChangeAssignees = (assignees) => {
		dispatchConfig({
			step: {
				...currentStep,
				appWorkflowRoleAssignments: assignees.map(({id, name}) => ({
					roleId: id,
					roleName: name,
				})),
			},
			stepIndex,
			type: UPDATE_STEP,
		});
	};

	const onChangeStepName = ({target}) => {
		dispatchConfig({
			step: {...currentStep, name: target.value},
			stepIndex,
			type: UPDATE_STEP,
		});
	};

	useEffect(() => {
		setCurrentTab(null);
	}, [currentStep]);

	return (
		<Sidebar className="app-builder-workflow-app__sidebar">
			<Sidebar.Header>
				{!currentTab ? (
					<h3 className="title">
						{Liferay.Language.get('step-configuration')}
					</h3>
				) : (
					<div className="tab-title">
						<ClayButton
							data-testid="back-button"
							displayType="secondary"
							onClick={() => setCurrentTab(null)}
							small
						>
							<span className="icon-monospaced">
								<ClayIcon symbol="angle-left" />
							</span>
						</ClayButton>

						<h3>{currentTab.title}</h3>
					</div>
				)}
			</Sidebar.Header>

			<Sidebar.Body>
				{!currentTab ? (
					<>
						<ClayForm.Group className="form-group-outlined">
							<label>
								{Liferay.Language.get('step-name')}

								<span className="reference-mark">
									<ClayIcon symbol="asterisk" />
								</span>
							</label>

							<ClayInput
								onChange={onChangeStepName}
								type="text"
								value={currentStep.name}
							/>

							{currentStep.initial === undefined && (
								<>
									<label className="mt-4">
										{Liferay.Language.get('assignee')}

										<span className="reference-mark">
											<ClayIcon symbol="asterisk" />
										</span>
									</label>

									<ClayTooltipProvider>
										<ClayIcon
											className="ml-2 text-muted tooltip-icon"
											data-tooltip-align="top"
											data-tooltip-delay="0"
											symbol="question-circle-full"
											title={Liferay.Language.get(
												'assignees-are-the-roles-responsible-to-transition-this-workflow-step'
											)}
										/>
									</ClayTooltipProvider>

									<AutocompleteMultiSelect
										emptyMessage={Liferay.Language.get(
											'no-roles-were-found'
										)}
										emptyResultMessage={Liferay.Language.get(
											'no-roles-were-found-with-this-name-try-a-different-one'
										)}
										items={assigneeRoles}
										onChange={onChangeAssignees}
										placeholder={Liferay.Language.get(
											'select-assignees'
										)}
										selectedItems={currentStep.appWorkflowRoleAssignments.map(
											({roleId, roleName}) => ({
												id: roleId,
												name: roleName,
											})
										)}
									/>
								</>
							)}
						</ClayForm.Group>

						{tabs.map(
							({disabled, infoItems, show, title}, index) =>
								show && (
									<ClayButton
										className="mb-3 tab-button"
										disabled={disabled}
										displayType="secondary"
										key={index}
										onClick={() =>
											setCurrentTab(tabs[index])
										}
									>
										<div className="text-dark">
											<span>{title}</span>

											<ButtonInfo items={infoItems} />
										</div>

										<ClayIcon
											className="dropdown-button-asset"
											symbol="angle-right"
										/>
									</ClayButton>
								)
						)}
					</>
				) : (
					currentTab.content()
				)}
			</Sidebar.Body>
		</Sidebar>
	);
}
