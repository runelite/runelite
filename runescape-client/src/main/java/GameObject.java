import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -415524067
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2015304177
   )
   @Export("height")
   int height;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1875135455
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1107775953
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1002981227
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -898980511
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 654730907
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1827831145
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1974564541
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -365421721
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1769629895
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1467533485
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -66541605
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljs;IB)V",
      garbageValue = "75"
   )
   static void method3166(IndexData var0, int var1) {
      if(class20.NetCache_reference != null) {
         class20.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = class20.NetCache_reference.readInt();
         int var3 = class20.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         class229.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class264.NetCache_indexCaches[var1] = var0;
      }
   }
}
