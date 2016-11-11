import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1930745275
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1088917083
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   class100 field1794;
   @ObfuscatedName("j")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("n")
   class92 field1796;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 41583457
   )
   static int field1797;
   @ObfuscatedName("d")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("l")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1023792013
   )
   int field1800;
   @ObfuscatedName("f")
   Tile field1801;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1733777815
   )
   int field1802;
   @ObfuscatedName("m")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("p")
   int[] field1804 = new int[5];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1626619985
   )
   int field1805 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1292200299
   )
   int field1806;
   @ObfuscatedName("c")
   boolean field1807;
   @ObfuscatedName("w")
   boolean field1808;
   @ObfuscatedName("x")
   boolean field1809;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1545246933
   )
   int field1810;
   @ObfuscatedName("s")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -703589195
   )
   int field1812;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -76844867
   )
   int field1813;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1076894471
   )
   int field1814;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1328899965
   )
   @Export("y")
   int y;

   Tile(int var1, int var2, int var3) {
      this.plane = var1 * -1930745275;
      this.field1800 = var1;
      this.x = var2;
      this.y = var3;
   }
}
