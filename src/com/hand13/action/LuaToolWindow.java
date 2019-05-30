package com.hand13.action;

import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class LuaToolWindow {
    private JPanel content;
    private JTextField locationField;
    private JButton runButton;
    private TextFieldWithBrowseButton fileButton;
    private ToolWindow toolWindow;

    public LuaToolWindow(ToolWindow toolWindow) {
        this.toolWindow = toolWindow;
        fileButton.addActionListener(e -> locationField.setText(fileButton.getText()));
        runButton.addActionListener(e -> {
            String location = locationField.getText();
            if (location != null && !location.equals("")) {
                try {
                    LuaUtils.runScript(location, null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getContent() {
        return content;
    }
}
