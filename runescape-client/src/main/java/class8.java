import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public final class class8 extends class9 {
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 873639989
   )
   final int field255;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1517281733
   )
   final int field250;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 275445029
   )
   final int field251;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -504121345
   )
   final int field252;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -569233929
   )
   final int field253;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field255 = var1;
      this.field250 = var2;
      this.field251 = var3;
      this.field252 = var4;
      this.field253 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1657577440"
   )
   public final void vmethod57() {
      Rasterizer2D.drawRectangle(this.field255 + Rasterizer2D.draw_region_x, this.field250 + Rasterizer2D.drawingAreaTop, this.field251 - this.field255, this.field252 - this.field250, this.field253);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-7013568"
   )
   public static int method46(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
