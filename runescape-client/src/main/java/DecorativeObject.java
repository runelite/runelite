import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static IndexData field2071;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -709771743
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1100633511
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1155502211
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -24500925
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1468225421
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1799942529
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 694678045
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1762523273
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1665608597
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)Lhx;",
      garbageValue = "69"
   )
   public static Widget method2896(int var0, int var1) {
      Widget var2 = class64.method1017(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
