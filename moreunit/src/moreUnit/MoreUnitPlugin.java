package moreUnit;

import moreUnit.listener.JavaCodeChangeListener;
import moreUnit.log.LogHandler;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class MoreUnitPlugin extends AbstractUIPlugin {
	
	//The shared instance.
	private static MoreUnitPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public MoreUnitPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		JavaCore.addElementChangedListener(new JavaCodeChangeListener());
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static MoreUnitPlugin getDefault() {
		if(plugin == null)
			LogHandler.getInstance().handleWarnLog("MoreUnitPlugin.getDefault() is null!");
		
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("moreUnit", path);
	}
}

// $Log: not supported by cvs2svn $
// Revision 1.10  2006/05/21 20:42:50  gianasista
// Moved initialization of preferenceStore
//
// Revision 1.9  2006/05/21 10:57:52  gianasista
// moved prefs to Preferences class
//
// Revision 1.8  2006/05/20 16:04:05  gianasista
// Integration of switchunit preferences
//
// Revision 1.7  2006/05/12 17:51:11  gianasista
// Added comments, preferences (Lists of testcase prefixes, suffixes)
//
// Revision 1.6  2006/04/30 10:20:31  gianasista
// getDefault was not null-safe
//
// Revision 1.5  2006/04/14 17:11:56  gianasista
// Suffix for testcasename ist configurable (+Tests)
//
// Revision 1.4  2006/02/19 21:48:47  gianasista
// Dialog to ask user of refactoring should be performed on corresponding tests (configurable via properties)
//
// Revision 1.3  2006/01/19 21:39:44  gianasista
// Added CVS-commit-logging to all java-files
//