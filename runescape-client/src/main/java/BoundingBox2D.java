import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2043323419
   )
   static int field235;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1739205817
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1811040767
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -710978531
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1190502023
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -714743463
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 955236265
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "980177459"
   )
   final void draw() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;S)V",
      garbageValue = "-3438"
   )
   public static void method38(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "49"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
