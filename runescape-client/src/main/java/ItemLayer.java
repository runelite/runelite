import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1329167205
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 813439287
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 594162243
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 554011731
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 14426789
   )
   @Export("height")
   int height;
}
