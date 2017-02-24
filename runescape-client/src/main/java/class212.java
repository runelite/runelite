import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class212 {
   @ObfuscatedName("gx")
   public static final int[] field3149 = new int[]{-1, 0, -2, 0, 0, -2, 4, 0, 6, 0, 0, 0, 0, -2, -2, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 6, 0, 2, 0, 0, 5, 0, 0, 6, 0, 0, 8, 6, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 10, 0, 0, 0, 4, 0, 0, 2, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, -2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 8, 4, 4, -2, 0, 0, 0, 2, 0, -2, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, -2, 4, 2, 0, 8, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -2, 0, 0, 0, 0, 0, 5, 6, 0, 0, 0, 0, 0, 0, 5, 0, 0, 6, -1, 0, -1, 0, -2, -1, 10, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 28, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, -2, 0, 0, 0, 2, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 3, 6, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, -2, 0, 1, 0, 0, -2, 0, 20, 0, 15, 14, 0, 0, 3, 8, -1, 0, 0};

   class212() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1015851225"
   )
   static final void method3985() {
      int var0 = class45.field921;
      int[] var1 = class45.field931;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class140.method2666(var3, 1);
         }
      }

   }
}
