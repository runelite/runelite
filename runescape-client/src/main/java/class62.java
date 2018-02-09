import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public final class class62 {
   @ObfuscatedName("s")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("g")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -926824295
   )
   static int field736;
   @ObfuscatedName("h")
   static byte[][][] field724;
   @ObfuscatedName("t")
   static byte[][][] field725;
   @ObfuscatedName("z")
   static int[][] field726;
   @ObfuscatedName("o")
   static int[] field727;
   @ObfuscatedName("b")
   static final int[] field729;
   @ObfuscatedName("p")
   static final int[] field728;
   @ObfuscatedName("y")
   static final int[] field731;
   @ObfuscatedName("n")
   static final int[] field732;
   @ObfuscatedName("j")
   static final int[] field738;
   @ObfuscatedName("e")
   static final int[] field733;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -121187741
   )
   static int field735;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1465670069
   )
   static int field723;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field736 = 99;
      field729 = new int[]{1, 2, 4, 8};
      field728 = new int[]{16, 32, 64, 128};
      field731 = new int[]{1, 0, -1, 0};
      field732 = new int[]{0, -1, 0, 1};
      field738 = new int[]{1, -1, -1, 1};
      field733 = new int[]{-1, -1, 1, 1};
      field735 = (int)(Math.random() * 17.0D) - 8;
      field723 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lkm;",
      garbageValue = "1899123637"
   )
   public static Parameters[] method1033() {
      return new Parameters[]{Parameters.field3840, Parameters.field3825, Parameters.field3833, Parameters.field3835, Parameters.field3839, Parameters.field3831, Parameters.field3830, Parameters.field3827, Parameters.field3836, Parameters.field3837, Parameters.field3829, Parameters.field3828, Parameters.field3838, Parameters.field3834, Parameters.field3832, Parameters.field3826};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lbs;Lbs;IZI)I",
      garbageValue = "-1985803148"
   )
   static int method1029(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1624()?(var1.method1624()?0:1):(var1.method1624()?-1:0)):(var2 == 5?(var0.method1656()?(var1.method1656()?0:1):(var1.method1656()?-1:0)):(var2 == 6?(var0.method1635()?(var1.method1635()?0:1):(var1.method1635()?-1:0)):(var2 == 7?(var0.method1621()?(var1.method1621()?0:1):(var1.method1621()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2094104948"
   )
   static final void method1032(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var13 + var6;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var7 + var15 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }
}
