import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1764459181
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 195821065
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1425378881
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1945496319
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -677779379
   )
   @Export("height")
   int height;
}
