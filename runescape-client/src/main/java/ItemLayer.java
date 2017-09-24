import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1569125743
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 298893263
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -435890039
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -712696633
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1801481297
   )
   @Export("height")
   int height;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "6033"
   )
   public static void method2412() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }
}
