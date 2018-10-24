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

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ControlMOM service. Represents a row in the &quot;pdca_controlmom&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOMModel
 * @see com.astra.anblicks.pdca.model.impl.ControlMOMImpl
 * @see com.astra.anblicks.pdca.model.impl.ControlMOMModelImpl
 * @generated
 */
@ImplementationClassName("com.astra.anblicks.pdca.model.impl.ControlMOMImpl")
@ProviderType
public interface ControlMOM extends ControlMOMModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.astra.anblicks.pdca.model.impl.ControlMOMImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ControlMOM, Long> CONTROL_MOM_ID_ACCESSOR = new Accessor<ControlMOM, Long>() {
			@Override
			public Long get(ControlMOM controlMOM) {
				return controlMOM.getControlMOMId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ControlMOM> getTypeClass() {
				return ControlMOM.class;
			}
		};
}