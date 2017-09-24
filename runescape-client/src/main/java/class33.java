import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class33 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("oo")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   static class101 field479;
   @ObfuscatedName("i")
   String field475;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   class24 field474;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -573003175
   )
   int field478;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1077509491
   )
   int field476;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILg;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field475 = var1;
      this.field478 = var2;
      this.field476 = var3;
      this.field474 = var4;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "19736"
   )
   static final void method383(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = Client.field1184 + (Client.field1097 - Client.field1184) * var5 / 100;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1190) {
         var15 = Client.field1190;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1189) {
            var6 = Client.field1189;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4890(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4890(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1191) {
         var15 = Client.field1191;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1188) {
            var6 = Client.field1188;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4890(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4890(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1052 - Client.field1186) * var5 / 100 + Client.field1186;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2852(var14, 500, 800, var2, var3);
      }

      Client.field1192 = var0;
      Client.field1193 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
