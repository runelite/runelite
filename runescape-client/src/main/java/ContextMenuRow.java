import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 646856391
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1944728291
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1589756195
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -104128971
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("n")
   @Export("option")
   String option;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lee;IIII)Z",
      garbageValue = "165579990"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class132.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         int var5;
         int var6;
         int var7;
         int var8;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         if(!class132.Viewport_false0) {
            var5 = Region.pitchSin;
            var6 = Region.pitchCos;
            var7 = Region.yawSin;
            var8 = Region.yawCos;
            byte var9 = 50;
            short var10 = 3500;
            var11 = (class132.Viewport_mouseX - Graphics3D.centerX) * var9 / Graphics3D.Rasterizer3D_zoom;
            var12 = (class132.Viewport_mouseY - Graphics3D.centerY) * var9 / Graphics3D.Rasterizer3D_zoom;
            var13 = (class132.Viewport_mouseX - Graphics3D.centerX) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var14 = (class132.Viewport_mouseY - Graphics3D.centerY) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var15 = Graphics3D.method2899(var12, var9, var6, var5);
            var16 = Graphics3D.method2916(var12, var9, var6, var5);
            var12 = var15;
            var15 = Graphics3D.method2899(var14, var10, var6, var5);
            var17 = Graphics3D.method2916(var14, var10, var6, var5);
            var14 = var15;
            var15 = Graphics3D.method2897(var11, var16, var8, var7);
            var16 = Graphics3D.method2898(var11, var16, var8, var7);
            var11 = var15;
            var15 = Graphics3D.method2897(var13, var17, var8, var7);
            var17 = Graphics3D.method2898(var13, var17, var8, var7);
            class132.field1895 = (var11 + var15) / 2;
            class154.field2123 = (var14 + var12) / 2;
            class132.field1896 = (var17 + var16) / 2;
            class3.field20 = (var15 - var11) / 2;
            class132.field1891 = (var14 - var12) / 2;
            class132.field1904 = (var17 - var16) / 2;
            class294.field3827 = Math.abs(class3.field20);
            class132.field1899 = Math.abs(class132.field1891);
            FloorUnderlayDefinition.field3503 = Math.abs(class132.field1904);
         }

         var5 = var0.centerX + var1;
         var6 = var2 + var0.centerY;
         var7 = var3 + var0.centerZ;
         var8 = var0.extremeX;
         var16 = var0.extremeY;
         var17 = var0.extremeZ;
         var11 = class132.field1895 - var5;
         var12 = class154.field2123 - var6;
         var13 = class132.field1896 - var7;
         return Math.abs(var11) > var8 + class294.field3827?false:(Math.abs(var12) > var16 + class132.field1899?false:(Math.abs(var13) > var17 + FloorUnderlayDefinition.field3503?false:(Math.abs(var13 * class132.field1891 - var12 * class132.field1904) > var16 * FloorUnderlayDefinition.field3503 + var17 * class132.field1899?false:(Math.abs(var11 * class132.field1904 - var13 * class3.field20) > var8 * FloorUnderlayDefinition.field3503 + var17 * class294.field3827?false:Math.abs(var12 * class3.field20 - var11 * class132.field1891) <= var16 * class294.field3827 + var8 * class132.field1899))));
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1894807383"
   )
   public static int method1967(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
