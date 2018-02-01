import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lce;"
   )
   @Export("soundTaskDataProvider")
   public static TaskDataProvider soundTaskDataProvider;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -831075721
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2128192441
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -132906013
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -364118175
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 528062361
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1881586091
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 758646381
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1849741509
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -159966917
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
