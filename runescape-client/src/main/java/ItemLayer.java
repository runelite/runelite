import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("j")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("m")
   @Export("top")
   Renderable top;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1234389007
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1006042321
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1304367951
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("f")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1107764061
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -206948245
   )
   @Export("height")
   int height;
   @ObfuscatedName("cg")
   static boolean field1798;
}
