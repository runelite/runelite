import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public final class class10 {
   @ObfuscatedName("s")
   static int[] field91;
   @ObfuscatedName("c")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1266720679
   )
   static int field93 = 99;
   @ObfuscatedName("p")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 834241767
   )
   static int field95;
   @ObfuscatedName("w")
   static int[] field96;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1193248593
   )
   static int field97;
   @ObfuscatedName("g")
   static int[] field98;
   @ObfuscatedName("a")
   static final int[] field99 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("h")
   static final int[] field100 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("x")
   static final int[] field101 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("d")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("o")
   static final int[] field103 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -81851943
   )
   static int field104 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1186614485
   )
   static int field105 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1963323273
   )
   static int field106;
   @ObfuscatedName("b")
   static final int[] field107 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("f")
   static final int[] field110 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1368130663
   )
   static int field111;

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1910467727"
   )
   static void method148(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class7.method102(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method148(var0, var7 - 1, var2, var3, var4, var5);
         method148(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "959793904"
   )
   public static void method149() {
      try {
         if(class159.field2063 == 1) {
            int var0 = class159.field2066.method2958();
            if(var0 > 0 && class159.field2066.method2913()) {
               var0 -= WallObject.field1543;
               if(var0 < 0) {
                  var0 = 0;
               }

               class159.field2066.method3002(var0);
               return;
            }

            class159.field2066.method2939();
            class159.field2066.method2911();
            if(class159.field2067 != null) {
               class159.field2063 = 2;
            } else {
               class159.field2063 = 0;
            }

            class13.field145 = null;
            class3.field32 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class159.field2066.method2939();
         class159.field2063 = 0;
         class13.field145 = null;
         class3.field32 = null;
         class159.field2067 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-6329764"
   )
   static final int method150(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class160.method3022(var3, var5);
      int var8 = class160.method3022(var3 + 1, var5);
      int var9 = class160.method3022(var3, var5 + 1);
      int var10 = class160.method3022(var3 + 1, var5 + 1);
      int var12 = 65536 - class84.field1441[var4 * 1024 / var2] >> 1;
      int var11 = (var7 * (65536 - var12) >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class84.field1441[var4 * 1024 / var2] >> 1;
      int var13 = (var9 * (65536 - var14) >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - class84.field1441[var6 * 1024 / var2] >> 1;
      int var15 = (var16 * var13 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }
}
