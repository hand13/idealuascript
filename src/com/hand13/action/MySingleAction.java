package com.hand13.action;

import com.hand13.lua.module.hello;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class MySingleAction extends AnAction {
    private static final Logger LOG = Logger.getInstance(MySingleAction.class);

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        hello.anActionEvent = anActionEvent;
        if (anActionEvent.getProject() != null) {
            Project project = anActionEvent.getProject();
            if (project.getWorkspaceFile() != null) {
                LOG.info(project.getWorkspaceFile().getExtension());
            }
            LOG.info(anActionEvent.getProject().getBasePath());
            String contextPath = anActionEvent.getProject().getBasePath();
            String filePath = contextPath + "/main.lua";
            LuaUtils.runScript(filePath,null);
        } else {
            LOG.info("no message");
        }
    }
}
