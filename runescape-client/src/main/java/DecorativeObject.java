import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -424206917
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 617121731
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1068652143
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 199958707
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -511589499
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1260026643
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -780068063
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -146473983
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 146815971
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
