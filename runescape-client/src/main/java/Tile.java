import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("z")
   int[] field1905;
   @ObfuscatedName("o")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1069686959
   )
   int field1907;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 768199681
   )
   int field1908;
   @ObfuscatedName("s")
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("r")
   SceneTileModel field1910;
   @ObfuscatedName("v")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1895705223
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 137325067
   )
   int field1914;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 413710941
   )
   int field1915;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 180766603
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1475565547
   )
   int field1918;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1103038989
   )
   int field1919;
   @ObfuscatedName("m")
   boolean field1920;
   @ObfuscatedName("f")
   boolean field1921;
   @ObfuscatedName("k")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("b")
   boolean field1923;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -726971605
   )
   int field1924;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 760069959
   )
   int field1925;
   @ObfuscatedName("y")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("d")
   Tile field1927;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 587710695
   )
   @Export("plane")
   int plane;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1905 = new int[5];
      this.field1918 = 0;
      this.field1908 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1222404465"
   )
   static int method2485(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
