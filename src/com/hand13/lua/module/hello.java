package com.hand13.lua.module;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class hello extends TwoArgFunction {
    public static AnActionEvent anActionEvent;
    public static Logger logger =  Logger.getInstance(hello.class);

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        LuaValue library = tableOf();
        library.set("envs",new envs());
        library.set("logger",new logger());
        env.set("hello",library);
        return library;

    }
    public static class envs extends ZeroArgFunction{

        @Override
        public LuaValue call() {
            LuaTable luaTable = tableOf();
            for(String key : System.getenv().keySet()) {
                luaTable.set(key,System.getenv().get(key));
            }
            return luaTable;
        }
    }
    public static class logger extends OneArgFunction{
        @Override
        public LuaValue call(LuaValue arg) {
            String args = arg.strvalue().tojstring();
            logger.info(args);
            return LuaValue.valueOf(0);
        }
    }
}
