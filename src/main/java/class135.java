import java.awt.FontMetrics;
import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class135 {
   @ObfuscatedName("nt")
   static class55 field2074;
   @ObfuscatedName("w")
   static File field2075;
   @ObfuscatedName("bf")
   protected static FontMetrics field2076;
   @ObfuscatedName("q")
   static String field2077;
   @ObfuscatedName("e")
   static boolean field2078 = false;
   @ObfuscatedName("f")
   static Hashtable field2079 = new Hashtable(16);

   @ObfuscatedName("dr")
   static class173 method2869(class173 var0) {
      int var2 = class75.method1642(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class148.method3129(var0.field2774);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("bx")
   static void method2870() {
      if(client.field433) {
         class173 var0 = class40.method837(class39.field859, client.field416);
         if(var0 != null && var0.field2847 != null) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field11 = var0.field2847;
            class93.method2183(var1);
         }

         client.field433 = false;
         class9.method133(var0);
      }
   }
}
