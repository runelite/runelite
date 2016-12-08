import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1350420449
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -749194795
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 676907695
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("m")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("v")
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1598591419
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1040425173
   )
   @Export("height")
   int height;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "559506051"
   )
   static class178[] method1432() {
      return new class178[]{class178.field2684, class178.field2687, class178.field2683, class178.field2682};
   }
}
