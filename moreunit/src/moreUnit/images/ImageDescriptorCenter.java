package moreUnit.images;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author vera
 * 20.11.2005
 */
public class ImageDescriptorCenter {
	
	private static ImageDescriptor testCaseLabelDescriptor;
	
	public static ImageDescriptor getTestCaseLabelImageDescriptor() {
		if(testCaseLabelDescriptor == null)
			testCaseLabelDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("moreUnit", "icons/classHasTest.gif");
		
		return testCaseLabelDescriptor;
	}
}