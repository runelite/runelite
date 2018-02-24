import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1827351905
   )
   @Export("cameraPitchCopy")
   static int cameraPitchCopy;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1133145525
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -68836251
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -934692401
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 966345835
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1763567835
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 306936149
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -470928395
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 17347691
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 666771189
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1294638615"
   )
   public static void method3071() {
      class317.classInfos = new CombatInfoList();
   }
}
