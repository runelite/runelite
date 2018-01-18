import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("p")
   public static boolean field286;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "138573609"
   )
   int method85(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method85((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Les;IIII)Z",
      garbageValue = "-1111697535"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class133.Viewport_containsMouse;
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
         if(!class133.Viewport_false0) {
            var5 = Region.pitchSin;
            var6 = Region.pitchCos;
            var7 = Region.yawSin;
            var8 = Region.yawCos;
            byte var9 = 50;
            short var10 = 3500;
            var11 = (class133.Viewport_mouseX - Graphics3D.centerX) * var9 / Graphics3D.Rasterizer3D_zoom;
            var12 = (class133.Viewport_mouseY - Graphics3D.centerY) * var9 / Graphics3D.Rasterizer3D_zoom;
            var13 = (class133.Viewport_mouseX - Graphics3D.centerX) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var14 = (class133.Viewport_mouseY - Graphics3D.centerY) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var15 = Graphics3D.method2690(var12, var9, var6, var5);
            var16 = Graphics3D.method2700(var12, var9, var6, var5);
            var12 = var15;
            var15 = Graphics3D.method2690(var14, var10, var6, var5);
            var17 = Graphics3D.method2700(var14, var10, var6, var5);
            var14 = var15;
            var15 = Graphics3D.method2682(var11, var16, var8, var7);
            var16 = Graphics3D.method2685(var11, var16, var8, var7);
            var11 = var15;
            var15 = Graphics3D.method2682(var13, var17, var8, var7);
            var17 = Graphics3D.method2685(var13, var17, var8, var7);
            class168.field2246 = (var15 + var11) / 2;
            class133.field1903 = (var12 + var14) / 2;
            class133.field1902 = (var17 + var16) / 2;
            BoundingBox2D.field235 = (var15 - var11) / 2;
            class139.field2022 = (var14 - var12) / 2;
            class133.field1904 = (var17 - var16) / 2;
            class133.field1905 = Math.abs(BoundingBox2D.field235);
            class133.field1906 = Math.abs(class139.field2022);
            VertexNormal.field1912 = Math.abs(class133.field1904);
         }

         var5 = var0.field1896 + var1;
         var6 = var2 + var0.field1861;
         var7 = var3 + var0.field1862;
         var8 = var0.field1863;
         var16 = var0.field1864;
         var17 = var0.field1885;
         var11 = class168.field2246 - var5;
         var12 = class133.field1903 - var6;
         var13 = class133.field1902 - var7;
         return Math.abs(var11) > var8 + class133.field1905?false:(Math.abs(var12) > var16 + class133.field1906?false:(Math.abs(var13) > var17 + VertexNormal.field1912?false:(Math.abs(var13 * class139.field2022 - var12 * class133.field1904) > var16 * VertexNormal.field1912 + var17 * class133.field1906?false:(Math.abs(var11 * class133.field1904 - var13 * BoundingBox2D.field235) > var17 * class133.field1905 + var8 * VertexNormal.field1912?false:Math.abs(var12 * BoundingBox2D.field235 - var11 * class139.field2022) <= var8 * class133.field1906 + var16 * class133.field1905))));
      }
   }
}
