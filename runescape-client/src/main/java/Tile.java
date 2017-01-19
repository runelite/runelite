import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("q")
   Tile field1330;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1403884563
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -122839183
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("a")
   class85 field1334;
   @ObfuscatedName("g")
   class77 field1335;
   @ObfuscatedName("i")
   boolean field1336;
   @ObfuscatedName("u")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("b")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("x")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2043132939
   )
   int field1340;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1718105385
   )
   int field1341;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1239253775
   )
   int field1343 = 0;
   @ObfuscatedName("m")
   int[] field1344 = new int[5];
   @ObfuscatedName("p")
   boolean field1345;
   @ObfuscatedName("o")
   boolean field1346;
   @ObfuscatedName("k")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 558943629
   )
   int field1348;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 62837171
   )
   int field1349;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 205328521
   )
   int field1350;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -966575019
   )
   int field1351;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1254344297
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2026239027
   )
   int field1354;

   Tile(int var1, int var2, int var3) {
      this.field1341 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2075747333"
   )
   static int method1515() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1677497841"
   )
   public static void method1516() {
      Varbit.field2852.reset();
   }
}
