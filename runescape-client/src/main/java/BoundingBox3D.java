import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("nw")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static SpritePixels field250;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 707237587
   )
   static int field253;
   @ObfuscatedName("g")
   public static short[] field245;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1399164583
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1793077055
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1975799011
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1467756151
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1302896507
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 839033671
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 840368185
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Lef;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.field1842 - var1.field1845;
      this.int2 = var3 + var1.field1843 - var1.field1824;
      this.int3 = var4 + var1.field1844 - var1.field1847;
      this.int4 = var2 + var1.field1842 + var1.field1845;
      this.int5 = var3 + var1.field1824 + var1.field1843;
      this.int6 = var4 + var1.field1844 + var1.field1847;
      this.color = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781276934"
   )
   public final void draw() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class89.method1664(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class89.method1664(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class89.method1664(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "419184294"
   )
   public static String method51(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class280.field3743[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class280.field3743[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class280.field3743[(var6 & 15) << 2 | var7 >>> 6]).append(class280.field3743[var7 & 63]);
            } else {
               var3.append(class280.field3743[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class280.field3743[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1644248776"
   )
   static final void method47(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = (Client.field1081 - Client.field1080) * var5 / 100 + Client.field1080;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1086) {
         var15 = Client.field1086;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field867) {
            var6 = Client.field867;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1006) {
         var15 = Client.field1006;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1084) {
            var6 = Client.field1084;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1083 - Client.field878) * var5 / 100 + Client.field878;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2725(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
