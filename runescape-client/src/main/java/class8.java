import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public final class class8 extends class9 {
   @ObfuscatedName("re")
   @Export("settings")
   static Preferences settings;
   @ObfuscatedName("gk")
   static ModIcon[] field246;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 95643145
   )
   final int field245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -358101561
   )
   final int field240;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1660793731
   )
   final int field242;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1436936651
   )
   final int field243;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2075352045
   )
   final int field244;

   public class8(int var1, int var2, int var3, int var4, int var5) {
      this.field245 = var1;
      this.field240 = var2;
      this.field242 = var3;
      this.field243 = var4;
      this.field244 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "366399750"
   )
   final void vmethod50() {
      Rasterizer2D.drawRectangle(this.field245 + Rasterizer2D.draw_region_x, this.field240 + Rasterizer2D.drawingAreaTop, this.field242 - this.field245, this.field243 - this.field240, this.field244);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIS)[LSpritePixels;",
      garbageValue = "9254"
   )
   static SpritePixels[] method43(IndexDataBase var0, int var1, int var2) {
      return !class223.method4073(var0, var1, var2)?null:FileOnDisk.method2382();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-935931769"
   )
   static void method44() {
      class98.chatLineMap.clear();
      class98.field1546.method3480();
      class98.field1548.method3645();
      class98.field1549 = 0;
   }
}
