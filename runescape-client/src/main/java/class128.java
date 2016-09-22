import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public abstract class class128 {
   @ObfuscatedName("d")
   static boolean field2113 = false;
   @ObfuscatedName("bp")
   static class171 field2118;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-298012552"
   )
   abstract byte[] vmethod2825();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-345387204"
   )
   abstract void vmethod2826(byte[] var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1313842343"
   )
   public static int method2842() {
      return class140.keyboardIdleTicks;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2136598614"
   )
   public static void method2843(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            var2 = class109.method2400(var1);
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
         if(null == class151.field2291) {
            return;
         }

         URL var3 = new URL(class151.field2291.getCodeBase(), "clienterror.ws?c=" + class151.field2293 + "&u=" + class151.field2290 + "&v1=" + class139.field2162 + "&v2=" + class139.field2161 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }
}
