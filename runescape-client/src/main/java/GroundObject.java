import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -698602429
   )
   public static int field1652;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 548765055
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1913540271
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 403089725
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1921092491
   )
   int field1657;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1797157867
   )
   @Export("hash")
   public int hash;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1938002890"
   )
   public static int method2236(int var0) {
      return var0 >> 17 & 7;
   }
}
