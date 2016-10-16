import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 456667941
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1010014287
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1647944459
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 288083649
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2133269533
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1982442285
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -462164429
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 715863145
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 275875435
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2129482095
   )
   int field1708;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1444904125
   )
   int field1709;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1559209305
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1750959551
   )
   @Export("hash")
   public int hash = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIIB)V",
      garbageValue = "8"
   )
   static final void method2179(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2481();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class5.tileHeights[0][var2];
                  int var11 = var2 + 932731 + var4;
                  int var12 = var5 + 556238 + var3;
                  int var13 = class59.method1227('넵' + var11, 91923 + var12, 4) - 128 + (class59.method1227(var11 + 10294, '鎽' + var12, 2) - 128 >> 1) + (class59.method1227(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)((double)var13 * 0.3D);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = 8 * -var13;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method2481();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 8 * var14;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field67[var1][var2][var3] = var0.method2601();
               class5.field69[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class62.field1261[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class220.field3213[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2481();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2481();
               break;
            }

            if(var7 <= 49) {
               var0.method2481();
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-3"
   )
   public static int method2180(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
