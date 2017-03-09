import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("h")
   class77 field1338;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 157691647
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("w")
   class85 field1342;
   @ObfuscatedName("p")
   Tile field1343;
   @ObfuscatedName("q")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("k")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("g")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("y")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 139497815
   )
   int field1348;
   @ObfuscatedName("v")
   int[] field1350 = new int[5];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -760259793
   )
   int field1351 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 131151877
   )
   int field1352;
   @ObfuscatedName("r")
   boolean field1353;
   @ObfuscatedName("m")
   boolean field1354;
   @ObfuscatedName("i")
   boolean field1355;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -685245619
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 755960019
   )
   int field1357;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1787129067
   )
   int field1358;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1715335911
   )
   int field1359;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1983689157
   )
   int field1360;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 61045823
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1609120347
   )
   int field1362;
   @ObfuscatedName("gq")
   static Widget field1363;

   Tile(int var1, int var2, int var3) {
      this.field1360 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
