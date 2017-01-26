import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1472581175
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1114154059
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2111293497
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1871223021
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2039527463
   )
   @Export("y")
   int y;
}
