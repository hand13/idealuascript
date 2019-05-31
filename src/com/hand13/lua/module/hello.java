package com.hand13.lua.module;

import com.intellij.openapi.diagnostic.Logger;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class hello extends TwoArgFunction {
    public static Logger logger =  Logger.getInstance(hello.class);

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        LuaValue library = tableOf();
        library.set("envs",new envs());
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
}
