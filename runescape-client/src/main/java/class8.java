import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class8 extends class9 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1325455491
   )
   static int field244;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -199563967
   )
   static int field237;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1381564151
   )
   final int field240;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 755981053
   )
   final int field243;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1011487289
   )
   final int field238;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 466005939
   )
   final int field242;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -390770533
   )
   final int field239;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field240 = var1;
      this.field243 = var2;
      this.field238 = var3;
      this.field242 = var4;
      this.field239 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383927671"
   )
   final void vmethod47() {
      Rasterizer2D.drawRectangle(this.field240 + Rasterizer2D.draw_region_x, this.field243 + Rasterizer2D.drawingAreaTop, this.field238 - this.field240, this.field242 - this.field243, this.field239);
   }
}
