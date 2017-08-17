import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1092241013
   )
   static int field1873;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 963964035
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2143716025
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1683917683
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1707891905
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1076409371
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;III)[Ljr;",
      garbageValue = "-2036909767"
   )
   static IndexedSprite[] method2508(IndexDataBase var0, int var1, int var2) {
      return !FileOnDisk.method2386(var0, var1, var2)?null:class258.method4663();
   }
}
