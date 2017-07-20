import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 342140687
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 737810837
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1486925155
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1912436045
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1030190021
   )
   @Export("height")
   int height;
}
