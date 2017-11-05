import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class3 implements class0 {
   @ObfuscatedName("rc")
   static short[] field31;
   @ObfuscatedName("t")
   static int[] field25;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("region")
   static Region region;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;I)Ljava/lang/String;",
      garbageValue = "-382224339"
   )
   public static String method7(Buffer var0) {
      return Coordinates.method4026(var0, 32767);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2012933959"
   )
   public static void method5(int var0) {
      if(var0 != -1) {
         if(FileSystem.validInterfaces[var0]) {
            class89.widgetIndex.method4203(var0);
            if(class215.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class215.widgets[var0].length; ++var2) {
                  if(class215.widgets[var0][var2] != null) {
                     if(class215.widgets[var0][var2].type != 2) {
                        class215.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class215.widgets[var0] = null;
               }

               FileSystem.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1999937398"
   )
   static final void method6(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = (Client.field1167 - Client.field1166) * var5 / 100 + Client.field1166;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field998) {
         var15 = Client.field998;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1140) {
            var6 = Client.field1140;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5045(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5045(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1173) {
         var15 = Client.field1173;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1003) {
            var6 = Client.field1003;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5045(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5045(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1147 - Client.field993) * var5 / 100 + Client.field993;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2752(var14, 500, 800, var2, var3);
      }

      Client.field923 = var0;
      Client.field1175 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
