/*******************************************************************************
 * Copyright (c) 2012, 2016, 2017 PDT Extension Group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     PDT Extension Group - initial API and implementation
 *     Kaloyan Raev - [501269] externalize strings
 *******************************************************************************/
package org.eclipse.php.composer.core.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	protected static final Pattern NS_PATTERN = Pattern.compile("^[a-zA-Z_\\\\]+$"); //$NON-NLS-1$

	public static boolean validateNamespace(String namespace) {
		Matcher matcher = NS_PATTERN.matcher(namespace);
		return matcher.matches();
	}
}
