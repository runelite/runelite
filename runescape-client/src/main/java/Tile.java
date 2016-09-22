import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("i")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1484426985
   )
   int field1820;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1058711825
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("z")
   class92 field1823;
   @ObfuscatedName("t")
   class100 field1824;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -727967135
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1440784289
   )
   int field1826;
   @ObfuscatedName("g")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("m")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1307646449
   )
   int field1829;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1004703945
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("u")
   int[] field1831 = new int[5];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 298843603
   )
   int field1832 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 158876327
   )
   int field1833;
   @ObfuscatedName("w")
   boolean field1834;
   @ObfuscatedName("b")
   boolean field1835;
   @ObfuscatedName("p")
   boolean field1836;
   @ObfuscatedName("x")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 659256635
   )
   int field1838;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1599758921
   )
   int field1839;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -417590005
   )
   int field1840;
   @ObfuscatedName("h")
   Tile field1841;

   Tile(int var1, int var2, int var3) {
      this.field1820 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
