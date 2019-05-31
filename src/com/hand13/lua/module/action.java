package com.hand13.lua.module;

import com.intellij.openapi.diagnostic.Logger;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class action extends TwoArgFunction {
    public static Logger logger =  Logger.getInstance(action.class);

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        LuaValue library = tableOf();
        library.set("envs",new logger());
        env.set("action",library);
        return library;

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
