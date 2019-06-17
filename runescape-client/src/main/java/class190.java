import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class190 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2346;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2352;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2342;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2341;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2344;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2345;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2350;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2347;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2343;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static final class190 field2349;
   @ObfuscatedName("ge")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "7"
   )
   class190(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lbt;",
      garbageValue = "-68901151"
   )
   static World method3672() {
      World.__bt_g = 0;
      return Fonts.method5647();
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "0"
   )
   static final void method3669(int var0, int var1, int var2, int var3, int var4, int var5) {
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
         var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
         var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var13 + var6;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Rasterizer3D.method2985(var17, var18, var19);
         Rasterizer3D.method3020(var21, var22, var23, var17, var18, var19, var4);
         Rasterizer3D.method2985(var17, var19, var20);
         Rasterizer3D.method3020(var21, var23, var24, var17, var19, var20, var4);
      }

   }

   static {
      field2346 = new class190(7);
      field2352 = new class190(15);
      field2342 = new class190(14);
      field2341 = new class190(6);
      field2344 = new class190(4);
      field2345 = new class190(5);
      field2350 = new class190(2);
      field2347 = new class190(3);
      field2343 = new class190(5);
      field2349 = new class190(4);
   }
}
