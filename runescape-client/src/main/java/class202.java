import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class202 {
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "3"
   )
   static final void method3707(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = Client.field538 + (Client.field539 - Client.field538) * var5 / 100;
      int var7 = var6 * var3 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field544) {
         var15 = Client.field544;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 > Client.field462) {
            var6 = Client.field462;
            var8 = 512 * var3 * var6 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class219.method3891();
               class219.method3899(var0, var1, var9, var3, -16777216);
               class219.method3899(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field510) {
         var15 = Client.field510;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 < Client.field397) {
            var6 = Client.field397;
            var8 = 334 * var2 * var15 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class219.method3891();
               class219.method3899(var0, var1, var2, var9, -16777216);
               class219.method3899(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field394 - Client.field366) * var5 / 100 + Client.field366;
      Client.scale = var8 * var6 * var3 / 85504 << 1;
      if(var2 != Client.camera2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 32 * var10 + 128;
            int var12 = 600 + var11 * 3;
            int var13 = class84.field1435[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1681(var14, 500, 800, var2, var3);
      }

      Client.field546 = var0;
      Client.field547 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }
}
