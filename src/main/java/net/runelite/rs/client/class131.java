package net.runelite.rs.client;

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import netscape.javascript.JSObject;

@ObfuscatedName("ec")
public class class131 {
   @ObfuscatedName("f")
   public static Object method2877(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }

   @ObfuscatedName("j")
   public static void method2878(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }

   @ObfuscatedName("m")
   public static Object method2879(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }
}
