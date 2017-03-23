import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1073499789
   )
   int field1349;
   @ObfuscatedName("y")
   boolean field1350;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 915725407
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -567262073
   )
   int field1352;
   @ObfuscatedName("r")
   class85 field1353;
   @ObfuscatedName("o")
   class77 field1354;
   @ObfuscatedName("n")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1101195085
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("l")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -781024521
   )
   int field1359;
   @ObfuscatedName("s")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("q")
   int[] field1361 = new int[5];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -685754885
   )
   int field1362 = 0;
   @ObfuscatedName("k")
   Tile field1363;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 418977285
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1999933341
   )
   int field1366;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -57642577
   )
   int field1367;
   @ObfuscatedName("w")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 586850071
   )
   int field1369;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2125701625
   )
   int field1370;
   @ObfuscatedName("a")
   boolean field1371;
   @ObfuscatedName("ec")
   static ModIcon[] field1372;
   @ObfuscatedName("eb")
   static ModIcon[] field1373;
   @ObfuscatedName("v")
   boolean field1374;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "2042438220"
   )
   public static int method1580(CharSequence var0, int var1) {
      return FloorUnderlayDefinition.method3548(var0, var1, true);
   }

   Tile(int var1, int var2, int var3) {
      this.field1352 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "79244708"
   )
   static final int method1581(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
