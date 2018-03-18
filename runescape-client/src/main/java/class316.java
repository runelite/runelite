import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public final class class316 {
   @ObfuscatedName("t")
   static final char[] field3924;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 434713985
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;

   static {
      field3924 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4096"
   )
   static void method5605() {
      class90.indexedSpriteOffsetXs = null;
      class153.indexedSpriteOffsetYs = null;
      class332.indexSpriteWidths = null;
      GrandExchangeOffer.indexedSpriteHeights = null;
      class332.indexedSpritePalette = null;
      ClassInfo.spritePixels = null;
   }
}
