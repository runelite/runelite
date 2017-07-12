import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("t")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -164313745
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -203665753
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -462915027
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1616879843
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("s")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("r")
   @Export("top")
   Renderable top;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1489572101
   )
   @Export("height")
   int height;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1375879559"
   )
   public static void method2407() {
      class254.field3421.reset();
      class254.field3422.reset();
      class254.field3423.reset();
   }
}
