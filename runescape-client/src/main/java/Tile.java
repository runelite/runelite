import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -646224267
   )
   int field1776;
   @ObfuscatedName("w")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 619877339
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   boolean field1779;
   @ObfuscatedName("p")
   class92 field1780;
   @ObfuscatedName("g")
   class100 field1781;
   @ObfuscatedName("m")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("f")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("k")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("h")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2141498065
   )
   int field1786;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 780635017
   )
   static int field1787;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -483366591
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 639630861
   )
   int field1789 = 0;
   @ObfuscatedName("u")
   int[] field1790 = new int[5];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -811753465
   )
   int field1791;
   @ObfuscatedName("b")
   boolean field1792;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -908878089
   )
   int field1793;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1821385741
   )
   int field1794;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -429890001
   )
   int field1795;
   @ObfuscatedName("a")
   boolean field1796;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 58590939
   )
   int field1797;
   @ObfuscatedName("v")
   Tile field1798;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -591225081
   )
   @Export("x")
   int x;

   Tile(int var1, int var2, int var3) {
      this.field1776 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public static int method2257() {
      return ++class143.mouseIdleTicks - 1;
   }
}
