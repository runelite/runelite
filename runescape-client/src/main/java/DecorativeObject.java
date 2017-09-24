import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1114128343
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 172717535
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 394124291
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -960312351
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 340330103
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1312772935
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1293886131
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1728847277
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 93609811
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
