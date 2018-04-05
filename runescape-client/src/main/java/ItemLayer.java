import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2046117059
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -689535023
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -381189999
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1741793213
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 431171731
   )
   @Export("height")
   int height;
}
