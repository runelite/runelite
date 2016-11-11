import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class153 {
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1566613729"
   )
   static final void method3179(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field297 - Client.field318) / 100 + Client.field318;
      int var7 = 512 * var6 * var3 / (var2 * 334);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field561) {
         var15 = Client.field561;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 > Client.field394) {
            var6 = Client.field394;
            var8 = 512 * var6 * var3 / (var15 * 334);
            var14 = (var2 - var8) / 2;
            if(var4) {
               class82.method1830();
               class82.method1853(var0, var1, var14, var3, -16777216);
               class82.method1853(var2 + var0 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= 2 * var14;
         }
      } else if(var7 > Client.field560) {
         var15 = Client.field560;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < Client.field559) {
            var6 = Client.field559;
            var8 = 334 * var15 * var2 / (512 * var6);
            var14 = (var3 - var8) / 2;
            if(var4) {
               class82.method1830();
               class82.method1853(var0, var1, var2, var14, -16777216);
               class82.method1853(var0, var1 + var3 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = (Client.field558 - Client.field557) * var5 / 100 + Client.field557;
      Client.scale = var6 * var3 * var8 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + 32 * var10;
            int var12 = 600 + 3 * var11;
            int var13 = class94.field1623[var11];
            var9[var10] = var13 * var12 >> 16;
         }

         Region.method1987(var9, 500, 800, var2, var3);
      }

      Client.field337 = var0;
      Client.field564 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-102"
   )
   static final boolean method3180(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
