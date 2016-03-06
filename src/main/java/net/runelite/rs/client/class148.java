import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class148 {
   @ObfuscatedName("f")
   static File field2236;
   @ObfuscatedName("i")
   static File field2237;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1043612833
   )
   public static int field2239;
   @ObfuscatedName("q")
   public static class227 field2240 = null;
   @ObfuscatedName("r")
   public static class227 field2241 = null;
   @ObfuscatedName("b")
   public static class227 field2243 = null;
   @ObfuscatedName("w")
   static String field2246;
   @ObfuscatedName("hi")
   @Export("localPlayer")
   static class2 field2249;

   @ObfuscatedName("f")
   static Class method3099(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("j")
   static int method3100() {
      return 9;
   }

   @ObfuscatedName("j")
   public static void method3101(class166 var0) {
      class52.field1172 = var0;
      class52.field1166 = class52.field1172.method3224(16);
   }
}
