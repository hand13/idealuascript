package com.hand13.action;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class LuaUtils {

    private static final Logger LOG = Logger.getInstance(LuaUtils.class);

    public static void runScript(String path,LuaValue env) {
        try {
            LuaUtils.runScript(LuaUtils.getVirtualFileByPath(path).getInputStream(), null);
        }catch (IOException ioe ){
            ioe.printStackTrace();
        }
    }

    public static void runScript(InputStream in, LuaValue env) {
        Globals globals = JsePlatform.standardGlobals();
        try {
            globals.load(in,"hack","t",globals).call();
            LuaValue fun = globals.get(LuaValue.valueOf("main"));
            Varargs result = fun.invoke();
            LOG.info(result.arg1().tojstring());
        } catch (Exception e) {
            LOG.info(e.toString());
            LOG.info(e.getMessage());
            LOG.info("error while execute lua file");
        }
    }
    public static VirtualFile getVirtualFileByPath(String path) {
        File file = new File(path);
        if (file.exists()) {
            return LocalFileSystem.getInstance().findFileByIoFile(file);
        }else {
            return null;
        }
    }
}
