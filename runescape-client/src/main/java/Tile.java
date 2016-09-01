import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1619232337
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -751631987
   )
   int field1788;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1028785569
   )
   static int field1789;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1941912059
   )
   int field1790;
   @ObfuscatedName("i")
   class92 field1791;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1490508663
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("l")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("m")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("u")
   boolean field1795;
   @ObfuscatedName("b")
   class100 field1796;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2023481085
   )
   int field1797;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2132216081
   )
   int field1798;
   @ObfuscatedName("q")
   int[] field1799 = new int[5];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 691852017
   )
   int field1800 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 47061043
   )
   int field1801;
   @ObfuscatedName("s")
   boolean field1802;
   @ObfuscatedName("h")
   boolean field1803;
   @ObfuscatedName("f")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("p")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("v")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1425585251
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1709159481
   )
   int field1808;
   @ObfuscatedName("y")
   Tile field1809;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 99041051
   )
   int field1810;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 750850559
   )
   static int field1815;

   Tile(int var1, int var2, int var3) {
      this.field1790 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1250211579"
   )
   public static String method2342(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1120060695"
   )
   static final void method2343(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class132.field2104[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "71"
   )
   public static void method2344(class170 var0) {
      class53.field1133 = var0;
   }

   @ObfuscatedName("r")
   public static String method2345(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class165.field2710[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
