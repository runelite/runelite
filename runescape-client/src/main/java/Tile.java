import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1772743249
   )
   int field1914;
   @ObfuscatedName("f")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -45521239
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1800328599
   )
   int field1917;
   @ObfuscatedName("b")
   class137 field1918;
   @ObfuscatedName("y")
   class128 field1919;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1852317203
   )
   int field1920;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1451408085
   )
   int field1921;
   @ObfuscatedName("x")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("n")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("h")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("o")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("z")
   int[] field1926;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 229219513
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 466785007
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   boolean field1929;
   @ObfuscatedName("r")
   boolean field1930;
   @ObfuscatedName("m")
   boolean field1931;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 445072241
   )
   int field1932;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1671406139
   )
   int field1933;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2107987587
   )
   int field1934;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2144286367
   )
   int field1935;
   @ObfuscatedName("p")
   Tile field1936;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1708742426"
   )
   static SpritePixels method2488() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class286.field3790;
      var0.maxHeight = class286.field3792;
      var0.offsetX = class286.field3793[0];
      var0.offsetY = class266.field3657[0];
      var0.width = class233.field3205[0];
      var0.height = ScriptState.field779[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = IndexFile.field2307[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class4.field33[var2[var3] & 255];
      }

      class251.method4451();
      return var0;
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(B)LRenderOverview;",
      garbageValue = "-48"
   )
   static RenderOverview method2489() {
      return class1.field14;
   }

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1926 = new int[5];
      this.field1921 = 0;
      this.field1917 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
