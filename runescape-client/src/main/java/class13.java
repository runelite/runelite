import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class13 {
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 781436261
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)[LModIcon;",
      garbageValue = "-27"
   )
   static ModIcon[] method148(class182 var0, int var1, int var2) {
      if(!class37.method718(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class225.field3221];

         for(int var5 = 0; var5 < class225.field3221; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class225.field3218;
            var6.originalHeight = class225.field3219;
            var6.offsetX = class181.field2710[var5];
            var6.offsetY = class225.field3220[var5];
            var6.originalWidth = class119.field1865[var5];
            var6.height = class109.field1742[var5];
            var6.palette = class225.field3217;
            var6.pixels = class44.field888[var5];
         }

         class30.method648();
         return var4;
      }
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-64"
   )
   static boolean method149(Widget var0) {
      if(Client.field461) {
         if(class170.method3147(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1554836778"
   )
   static final void method150(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field404; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field294[var4] = true;
         }
      }

   }
}
