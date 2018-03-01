import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("k")
   static int[] field242;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1528121143
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -700136715
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 947793869
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1094701557
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 131224179
   )
   @Export("color")
   final int color;

   BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void vmethod59() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1044588911"
   )
   public static boolean method45(int var0) {
      return (var0 & 1) != 0;
   }
}
