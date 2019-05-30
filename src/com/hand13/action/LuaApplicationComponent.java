package com.hand13.action;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class LuaApplicationComponent implements ApplicationComponent {
    private static final Logger LOG = Logger.getInstance(LuaApplicationComponent.class);
    @Override
    public void initComponent() {
        LOG.info("component init");
    }

    @Override
    public void disposeComponent() {
        LOG.info("component depose");
    }
}
