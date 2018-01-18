import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1884863045
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1268769797
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -854573269
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1841382633
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -697743979
   )
   @Export("height")
   int height;
}
