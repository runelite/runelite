import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class67 extends class197 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("listFetcher")
   static class83 listFetcher;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1739768189
   )
   int field835;
   @ObfuscatedName("h")
   String field833;
   @ObfuscatedName("f")
   short field836;

   class67(String var1, int var2) {
      this.field835 = (int)(class74.currentTimeMs() / 1000L);
      this.field833 = var1;
      this.field836 = (short)var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Leo;IIII)Z",
      garbageValue = "-1910676235"
   )
   static final boolean method1147(Model var0, int var1, int var2, int var3) {
      if(!TextureProvider.method2426()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class135.field1999) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class135.field1996 - Graphics3D.centerX) * var8 / Graphics3D.field2026;
            var11 = (class135.field1998 - Graphics3D.centerY) * var8 / Graphics3D.field2026;
            var12 = (class135.field1996 - Graphics3D.centerX) * var9 / Graphics3D.field2026;
            int var13 = (class135.field1998 - Graphics3D.centerY) * var9 / Graphics3D.field2026;
            int var14 = Graphics3D.method2636(var11, var8, var5, var4);
            var15 = Graphics3D.method2637(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2636(var13, var9, var5, var4);
            var16 = Graphics3D.method2637(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2634(var10, var15, var7, var6);
            var15 = Graphics3D.method2635(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2634(var12, var16, var7, var6);
            var16 = Graphics3D.method2635(var12, var16, var7, var6);
            class135.field2000 = (var14 + var10) / 2;
            VarPlayerType.field3274 = (var13 + var11) / 2;
            class2.field14 = (var16 + var15) / 2;
            class8.field244 = (var14 - var10) / 2;
            class61.field759 = (var13 - var11) / 2;
            class92.field1427 = (var16 - var15) / 2;
            Huffman.field2323 = Math.abs(class8.field244);
            class93.field1447 = Math.abs(class61.field759);
            class39.field547 = Math.abs(class92.field1427);
         }

         var4 = var0.field1969 + var1;
         var5 = var2 + var0.field1959;
         var6 = var3 + var0.field1987;
         var7 = var0.field1942;
         var15 = var0.field1962;
         var16 = var0.field1983;
         var10 = class135.field2000 - var4;
         var11 = VarPlayerType.field3274 - var5;
         var12 = class2.field14 - var6;
         return Math.abs(var10) > var7 + Huffman.field2323?false:(Math.abs(var11) > var15 + class93.field1447?false:(Math.abs(var12) > var16 + class39.field547?false:(Math.abs(var12 * class61.field759 - var11 * class92.field1427) > var15 * class39.field547 + var16 * class93.field1447?false:(Math.abs(var10 * class92.field1427 - var12 * class8.field244) > var7 * class39.field547 + var16 * Huffman.field2323?false:Math.abs(var11 * class8.field244 - var10 * class61.field759) <= var7 * class93.field1447 + var15 * Huffman.field2323))));
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1980265020"
   )
   static final void method1146(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = (Client.field1152 - Client.field1178) * var5 / 100 + Client.field1178;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1184) {
         var15 = Client.field1184;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1183) {
            var6 = Client.field1183;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4968(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4968(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1086) {
         var15 = Client.field1086;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1126) {
            var6 = Client.field1126;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4968(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4968(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1200 - Client.field1180) * var5 / 100 + Client.field1180;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2737(var14, 500, 800, var2, var3);
      }

      Client.field1186 = var0;
      Client.field1187 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
