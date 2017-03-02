import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("dh")
public class class114 {
   @ObfuscatedName("b")
   static Applet field1783 = null;
   @ObfuscatedName("l")
   public static String field1787 = null;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -109499341
   )
   static int field1788;
   @ObfuscatedName("bm")
   static class184 field1789;
   @ObfuscatedName("bi")
   static class184 field1790;

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1030875889"
   )
   static Class method2267(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1356956063"
   )
   public static void method2269() {
      ObjectComposition.field2899.reset();
      ObjectComposition.field2900.reset();
      ObjectComposition.field2934.reset();
      ObjectComposition.field2945.reset();
   }
}
