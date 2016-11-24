import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("s")
   boolean field1320;
   @ObfuscatedName("w")
   class85 field1321;
   @ObfuscatedName("y")
   int[] field1322 = new int[5];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -564611811
   )
   int field1323;
   @ObfuscatedName("c")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("r")
   class77 field1325;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1287388155
   )
   int field1326;
   @ObfuscatedName("p")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("g")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("z")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 349250971
   )
   int field1330;
   @ObfuscatedName("l")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("f")
   boolean field1332;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 777188321
   )
   int field1333 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1873720409
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -355143057
   )
   int field1335;
   @ObfuscatedName("k")
   Tile field1336;
   @ObfuscatedName("o")
   boolean field1337;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -433862607
   )
   int field1338;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -389924447
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -154863627
   )
   int field1340;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 127906343
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1034403833
   )
   int field1342;
   @ObfuscatedName("pz")
   static class30 field1343;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(LWidget;S)V",
      garbageValue = "17448"
   )
   static void method1577(Widget var0) {
      if(Client.field554 == var0.field2201) {
         Client.field490[var0.boundsIndex] = true;
      }

   }

   Tile(int var1, int var2, int var3) {
      this.field1323 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2096229554"
   )
   static final void method1578(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field51[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "1892781449"
   )
   static SpritePixels[] method1579() {
      SpritePixels[] var0 = new SpritePixels[class225.field3212];

      for(int var1 = 0; var1 < class225.field3212; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.field3205 = class225.field3211;
         var2.field3203 = class225.field3216;
         var2.field3201 = class225.field3213[var1];
         var2.field3202 = class225.field3214[var1];
         var2.width = class225.field3215[var1];
         var2.height = class225.field3219[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class225.field3218[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3210[var4[var5] & 255];
         }
      }

      class189.method3507();
      return var0;
   }
}
