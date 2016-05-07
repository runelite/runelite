import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class188 {
   @ObfuscatedName("gs")
   public static final int[] field3063 = new int[]{0, 0, 0, 0, 0, 0, 1, 20, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 6, -2, 0, 5, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 7, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 8, 0, 4, -1, 0, 0, 0, 14, 4, -2, 0, 0, 0, 0, -2, 0, 0, 0, 0, -2, 0, 3, 0, 6, 0, 0, 1, 0, -1, -2, 0, 0, -1, 0, 0, 0, 7, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 8, 0, 6, -2, 10, 0, 0, 0, 0, 0, 0, 0, 6, 0, 15, 0, 0, -2, -2, -2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, -2, 0, 0, 0, 28, 0, -2, 4, 0, 0, 0, -2, 0, -1, 0, 8, 1, 0, 0, 0, 10, 2, 0, 5, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 12, 6, 0, 0, 0, 0, 0, 0, 5, 8, 0, 0, 2, 2, 0, 0, -2, 0, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0, -2, 0, 0, 0, 6, 6, 0, 2, 2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, -2, 0, 0, 0, -1, 0};

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "635428944"
   )
   public static boolean method3731(int var0) {
      if(class173.field2838[var0]) {
         return true;
      } else if(!class173.field2755.method3294(var0)) {
         return false;
      } else {
         int var1 = class173.field2755.method3249(var0);
         if(var1 == 0) {
            class173.field2838[var0] = true;
            return true;
         } else {
            if(null == class217.field3171[var0]) {
               class217.field3171[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class217.field3171[var0][var2]) {
                  byte[] var3 = class173.field2755.method3239(var0, var2);
                  if(var3 != null) {
                     class217.field3171[var0][var2] = new class173();
                     class217.field3171[var0][var2].field2826 = var2 + (var0 << 16);
                     if(-1 == var3[0]) {
                        class217.field3171[var0][var2].method3376(new class119(var3));
                     } else {
                        class217.field3171[var0][var2].method3406(new class119(var3));
                     }
                  }
               }
            }

            class173.field2838[var0] = true;
            return true;
         }
      }
   }
}
