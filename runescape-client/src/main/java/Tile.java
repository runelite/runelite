import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -684987123
   )
   int field1795;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1631109823
   )
   int field1796;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1356133387
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1237918863
   )
   int field1798;
   @ObfuscatedName("v")
   class92 field1799;
   @ObfuscatedName("b")
   class100 field1800;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("c")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("h")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1122281557
   )
   int field1805;
   @ObfuscatedName("i")
   int[] field1806 = new int[5];
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -1988355533
   )
   protected static int field1807;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -430087389
   )
   int field1808 = 0;
   @ObfuscatedName("j")
   boolean field1809;
   @ObfuscatedName("d")
   boolean field1810;
   @ObfuscatedName("o")
   boolean field1811;
   @ObfuscatedName("m")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1905795603
   )
   int field1813;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1045653295
   )
   int field1815;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -77950745
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   Tile field1817;
   @ObfuscatedName("k")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("qu")
   protected static Font field1819;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -733237509
   )
   int field1820;

   Tile(int var1, int var2, int var3) {
      this.field1798 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
