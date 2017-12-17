import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1321200933
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1617776623
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -904869015
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1796622757
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -841368133
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 811326853
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781276934"
   )
   public final void draw() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "26"
   )
   static void method39(int var0, int var1, int var2, int var3) {
      Widget var4 = TextureProvider.getWidgetChild(var0, var1);
      if(var4 != null && var4.field2850 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.field2850;
         CacheFile.method2350(var5);
      }

      Client.field985 = var3;
      Client.spellSelected = true;
      JagexGame.field3297 = var0;
      Client.field984 = var1;
      class86.field1278 = var2;
      class33.method344(var4);
   }
}
