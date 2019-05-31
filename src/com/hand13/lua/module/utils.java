package com.hand13.lua.module;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.Messages;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class utils extends TwoArgFunction {
    public static Logger logger = Logger.getInstance(utils.class);

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        LuaValue library = tableOf();
        library.set("messagebox", new messagebox());
        library.set("logger",new logger());
        env.set("utils", library);
        return library;

    }

    public static class messagebox extends ZeroArgFunction {
        @Override
        public LuaValue call() {
            String result = Messages.showInputDialog("username", "Get", Messages.getQuestionIcon());
            if(result == null) {
                return LuaValue.valueOf(0);
            }
            logger.info(result);
            return LuaValue.valueOf(result);
        }
    }
    public static class logger extends OneArgFunction {
        @Override
        public LuaValue call(LuaValue arg) {
            String args = arg.strvalue().tojstring();
            logger.info(args);
            return LuaValue.valueOf(0);
        }
    }
}
