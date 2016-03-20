import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aw")
@Implements("Item")
public final class class28 extends class84 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1652614887
   )
   @Export("quantity")
   int field677;
   @ObfuscatedName("gb")
   static class172 field679;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1746317977
   )
   @Export("id")
   int field681;
   @ObfuscatedName("qy")
   static class132 field682;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 242990325
   )
   static int field683;

   @ObfuscatedName("a")
   public static void method651(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            var2 = class22.method579(var1);
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class147.field2211) {
            return;
         }

         URL var3 = new URL(class147.field2211.getCodeBase(), "clienterror.ws?c=" + class147.field2210 + "&u=" + class147.field2209 + "&v1=" + class135.field2080 + "&v2=" + class108.field1900 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      return class75.method1648(this.field681).method1048(this.field677);
   }

   @ObfuscatedName("y")
   static Class method655(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("cy")
   static final void method656(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class103.method2303(var0)) {
         class51.method1091(class172.field2850[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
