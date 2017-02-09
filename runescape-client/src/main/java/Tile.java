import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("t")
   boolean field1327;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1634730239
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1451832763
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -775313813
   )
   int field1330;
   @ObfuscatedName("j")
   class77 field1332;
   @ObfuscatedName("w")
   class85 field1333;
   @ObfuscatedName("d")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("n")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -845558449
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -357308593
   )
   int field1337;
   @ObfuscatedName("g")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 962963345
   )
   int field1339;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -564546753
   )
   int field1340 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1770489849
   )
   int field1341;
   @ObfuscatedName("h")
   boolean field1342;
   @ObfuscatedName("p")
   boolean field1343;
   @ObfuscatedName("i")
   int[] field1344 = new int[5];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -50302689
   )
   int field1345;
   @ObfuscatedName("c")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -319242145
   )
   int field1347;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -58047795
   )
   int field1348;
   @ObfuscatedName("m")
   Tile field1349;
   @ObfuscatedName("q")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("qs")
   protected static java.awt.Frame field1351;

   Tile(int var1, int var2, int var3) {
      this.field1339 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "17282205"
   )
   public static int method1561(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
