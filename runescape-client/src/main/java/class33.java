import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public final class class33 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("k")
   final int[] field464;

   class33() {
      this.field464 = new int[4096];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lar;B)V",
      garbageValue = "5"
   )
   final void method407(class44 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field464[var2 * 64 + var3] = var1.method655(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-47"
   )
   final int method402(int var1, int var2) {
      return this.field464[var1 * 64 + var2];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;B)V",
      garbageValue = "-3"
   )
   public static void method409(IndexDataBase var0) {
      Enum.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   static final void method408() {
      if(!class132.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class132.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class132.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class132.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class132.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2779(var7, var4, var1, var0);
         int var11 = Graphics3D.method2803(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2779(var9, var5, var1, var0);
         int var12 = Graphics3D.method2803(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2800(var6, var11, var3, var2);
         var11 = Graphics3D.method2812(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2800(var8, var12, var3, var2);
         var12 = Graphics3D.method2812(var8, var12, var3, var2);
         class132.field1919 = (var6 + var10) / 2;
         class132.field1923 = (var7 + var9) / 2;
         class132.field1924 = (var11 + var12) / 2;
         class132.field1925 = (var10 - var6) / 2;
         class37.field502 = (var9 - var7) / 2;
         Resampler.field1629 = (var12 - var11) / 2;
         class20.field336 = Math.abs(class132.field1925);
         class132.field1926 = Math.abs(class37.field502);
         IndexStoreActionHandler.field3399 = Math.abs(Resampler.field1629);
      }
   }
}
