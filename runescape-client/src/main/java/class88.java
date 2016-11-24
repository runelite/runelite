import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class88 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "-1031969230"
   )
   static void method1906(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2748.method2405(var6);
      if(null == var8) {
         var8 = (class181)class185.field2750.method2405(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2753.method2405(var6);
            if(null != var8) {
               if(var5) {
                  var8.method2483();
                  class185.field2748.method2406(var8, var6);
                  --class185.field2754;
                  ++class185.field2749;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2755.method2405(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2703 = var0;
               var8.field2704 = var3;
               var8.field2705 = var4;
               if(var5) {
                  class185.field2748.method2406(var8, var6);
                  ++class185.field2749;
               } else {
                  class185.field2752.method2352(var8);
                  class185.field2753.method2406(var8, var6);
                  ++class185.field2754;
               }

            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-208608992"
   )
   static void method1907(File var0) {
      class107.field1726 = var0;
      if(!class107.field1726.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1735 = true;
      }
   }
}
