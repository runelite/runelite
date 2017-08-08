import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -771840719
   )
   static int field1779;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1968758709
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1677739219
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 710018217
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1255755031
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 252038669
   )
   @Export("height")
   int height;
}
