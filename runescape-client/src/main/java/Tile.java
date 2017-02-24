import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1547307829
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1871319677
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 780044059
   )
   int field1350;
   @ObfuscatedName("j")
   class85 field1351;
   @ObfuscatedName("l")
   Tile field1352;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -88527635
   )
   int field1353 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1852374485
   )
   int field1354;
   @ObfuscatedName("ea")
   static SpritePixels[] field1355;
   @ObfuscatedName("o")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("t")
   boolean field1357;
   @ObfuscatedName("s")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("u")
   int[] field1359 = new int[5];
   @ObfuscatedName("c")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -537721721
   )
   int field1361;
   @ObfuscatedName("f")
   boolean field1362;
   @ObfuscatedName("z")
   boolean field1363;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 494947857
   )
   int field1364;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1293561549
   )
   int field1365;
   @ObfuscatedName("i")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1448155057
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 581824433
   )
   int field1368;
   @ObfuscatedName("r")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1673789417
   )
   int field1371;
   @ObfuscatedName("n")
   class77 field1372;

   Tile(int var1, int var2, int var3) {
      this.field1350 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "1564473022"
   )
   static final void method1610(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1468[var6];
            int var9 = class84.field1462[var6];
            var8 = 256 * var8 / (Client.mapScaleDelta + 256);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var9 * var2 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4196(var5.field2156 / 2 + var10 - var4.maxWidth / 2, var5.field2157 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2156, var5.field2157, var5.field2155, var5.field2154);
            } else {
               var4.method4173(var0 + var5.field2156 / 2 + var10 - var4.maxWidth / 2, var1 + var5.field2157 / 2 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
