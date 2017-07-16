import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class8 extends class9 {
   @ObfuscatedName("bn")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static SpritePixels field245;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Task field244;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -771388521
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1322926929
   )
   final int field243;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1027723515
   )
   final int field241;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -836407165
   )
   final int field238;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -562792679
   )
   final int field239;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1450104789
   )
   final int field242;

   public class8(int var1, int var2, int var3, int var4, int var5) {
      this.field243 = var1;
      this.field241 = var2;
      this.field238 = var3;
      this.field239 = var4;
      this.field242 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void vmethod54() {
      Rasterizer2D.drawRectangle(this.field243 + Rasterizer2D.draw_region_x, this.field241 + Rasterizer2D.drawingAreaTop, this.field238 - this.field243, this.field239 - this.field241, this.field242);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "102"
   )
   public static boolean method42() {
      ClassInfo var0 = (ClassInfo)class280.field3753.method3558();
      return var0 != null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lfv;I)V",
      garbageValue = "-607441205"
   )
   static final void method41(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var20 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  class96.loadTerrain(var20, var1, var2 + var16, var3 + class174.method3347(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class96.loadTerrain(var20, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2142502801"
   )
   public static int method43() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
