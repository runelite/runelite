import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class157 {
   @ObfuscatedName("cc")
   public static char field2108;

   class157() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2137427498"
   )
   public static boolean method3068(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class203.field3080;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var3 == var0) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "-189240618"
   )
   static class178[] method3071() {
      return new class178[]{class178.field2665, class178.field2669, class178.field2664, class178.field2670};
   }
}
