import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("q")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 480763419
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -996344089
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 356826227
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 594772725
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -901642223
   )
   @Export("x")
   int x;
   @ObfuscatedName("eb")
   static ModIcon[] field1284;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -790056847
   )
   protected static int field1285;
}
