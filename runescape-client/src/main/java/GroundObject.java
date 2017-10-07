import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2075310097
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -867585545
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2016829895
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 486668721
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1528356439
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
}
