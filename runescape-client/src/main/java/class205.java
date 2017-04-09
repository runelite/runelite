import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public final class class205 {
   @ObfuscatedName("f")
   public static final char[] field3092 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("bj")
   @Export("indexMaps")
   static IndexData indexMaps;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "680743072"
   )
   static void method3844(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2765.method2417(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2767.method2417(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2762.method2417(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2495();
                  class185.field2765.method2418(var8, var6);
                  --class185.field2771;
                  ++class185.field2774;
               }
            } else {
               if(!var5) {
                  var8 = (class181)class185.field2772.method2417(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2723 = var0;
               var8.field2722 = var3;
               var8.field2721 = var4;
               if(var5) {
                  class185.field2765.method2418(var8, var6);
                  ++class185.field2774;
               } else {
                  class185.field2768.method2368(var8);
                  class185.field2762.method2418(var8, var6);
                  ++class185.field2771;
               }
            }
         }
      }

   }

   class205() throws Throwable {
      throw new Error();
   }
}
