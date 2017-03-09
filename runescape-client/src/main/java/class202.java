import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class202 {
   @ObfuscatedName("ay")
   static boolean field3076;

   class202() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-825837590"
   )
   public static String method3802(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3080[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[Lclass179;",
      garbageValue = "15"
   )
   public static class179[] method3803() {
      return new class179[]{class179.field2675, class179.field2671, class179.field2674, class179.field2673, class179.field2676, class179.field2672};
   }
}
