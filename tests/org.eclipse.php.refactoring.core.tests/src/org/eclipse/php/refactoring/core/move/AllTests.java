/*******************************************************************************
 * Copyright (c) 2005, 2015 Zend Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Zend Technologies - initial API and implementation
 *******************************************************************************/
package org.eclipse.php.refactoring.core.move;

import java.util.List;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.php.refactoring.core.test.TestProject;

public class AllTests {

	private static TestProject project;

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.php.refactoring.core.move");
	
		//$JUnit-BEGIN$
		suite.addTestSuite(PHPMoveProcessorTestCase.class);
		suite.addTestSuite(PHPMoveProcessorTestCase1.class);
		suite.addTestSuite(PHPMoveProcessorTestCase0027202.class);
		suite.addTestSuite(PHPMoveProcessorTestCase0029253.class);
		suite.addTestSuite(PHPMoveProcessorRunConfigTestCase.class);
		suite.addTestSuite(PHPMoveProcessorRunConfigTestCase1.class);
		suite.addTestSuite(PHPMoveProcessorRunConfigTestCase2.class);
		suite.addTestSuite(PHPMoveProcessorRunConfigTestCase0027489.class);
		suite.addTestSuite(PHPMoveProcessorBreakPointTestCase.class);

		List<TestCase> tests = new PHPMoveProcessorTest("").createTest();

		for (TestCase test : tests) {
			suite.addTest(test);
		}
		
		// Create a setup wrapper
		TestSetup setup = new TestSetup(suite) {
			@Override
			protected void setUp() throws Exception {
				setUpSuite();
			}

			@Override
			protected void tearDown() throws Exception {
				tearDownSuite();
			}
		};
		return setup;
	}

	protected static void setUpSuite() {
		project = new TestProject("RefactoringMove");
		System.setProperty("disableStartupRunner","true");
	}

	protected static void tearDownSuite() {
		try {
			project.delete();
		} catch (Exception e) {
		}
//		System.setProperty("disableStartupRunner",null);
	}
}