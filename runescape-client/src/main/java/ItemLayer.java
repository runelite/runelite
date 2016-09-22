import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1741471927
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -599128275
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -670025033
   )
   @Export("height")
   int height;
   @ObfuscatedName("z")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("t")
   @Export("top")
   Renderable top;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2079244669
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("r")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1779818211
   )
   @Export("hash")
   int hash;
}
