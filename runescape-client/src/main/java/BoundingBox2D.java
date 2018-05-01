import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   static class100 field238;
   @ObfuscatedName("ns")
   @ObfuscatedSignature(
      signature = "Llz;"
   )
   static class320 field246;
   @ObfuscatedName("ab")
   protected static String field244;
   @ObfuscatedName("cm")
   @Export("currentTypedKey")
   public static char currentTypedKey;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field241;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -566524049
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1483633439
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1917843219
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1596657605
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1829738489
   )
   @Export("color")
   final int color;

   public BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120397174"
   )
   final void vmethod51() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-758072695"
   )
   static int method42() {
      return ++class95.field1431 - 1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILiv;B)I",
      garbageValue = "-55"
   )
   public static int method40(int var0, class245 var1) {
      return (var0 << 8) + var1.field2959;
   }
}
