package org.moreunit.elements;

/**
 * @author vera
 *
 * 23.05.2006 21:09:05
 */

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.moreunit.ProjectTestCase;
import org.moreunit.elements.TypeFacade;
import org.moreunit.util.StringConstants;

public class TypeFacadeTest extends ProjectTestCase {
	
	public void testIsTestCase() throws CoreException {
		IPackageFragment comPaket = testProject.createPackage("com");
		IType helloType = testProject.createType(comPaket, "Hello.java", getJavaFileSource1());
		
		IPackageFragmentRoot junitSourceRoot = testProject.createAdditionalSourceFolder("junit");
		IPackageFragment junitComPaket = testProject.createPackage(junitSourceRoot, "com");
		IType testHelloType = testProject.createType(junitComPaket, "HelloTest.java", getTestCaseSource1());
		
		assertTrue(TypeFacade.isTestCase(testHelloType));
		assertFalse(TypeFacade.isTestCase(helloType));
	}
	
	private String getJavaFileSource1() {
		StringBuffer source = new StringBuffer();
		source.append("package com;").append(StringConstants.NEWLINE);
		source.append("public class Hello {").append(StringConstants.NEWLINE);
		source.append("public int getOne() { return 1; }").append(StringConstants.NEWLINE);
		source.append("}");
		
		return source.toString();
	}
	
	private String getTestCaseSource1() {
		StringBuffer source = new StringBuffer();
		source.append("package com;").append(StringConstants.NEWLINE);
		source.append("import junit.framework.TestCase;").append(StringConstants.NEWLINE);
		source.append("public class HelloTest extends TestCase{").append(StringConstants.NEWLINE);
		source.append("public void testGetOne() {").append(StringConstants.NEWLINE);
		source.append("assertTrue(true);").append(StringConstants.NEWLINE);
		source.append("}").append(StringConstants.NEWLINE);
		source.append("}");
		
		return source.toString();		
	}	

}