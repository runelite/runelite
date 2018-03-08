import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class44 {
   @ObfuscatedName("f")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1678594259
   )
   int field548;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 311466183
   )
   int field549;
   @ObfuscatedName("i")
   int[][] field547;
   @ObfuscatedName("a")
   int[][] field546;
   @ObfuscatedName("l")
   int[][] field545;
   @ObfuscatedName("b")
   int[][] field550;

   class44(int var1, int var2) {
      this.field548 = var1;
      this.field549 = var2;
      this.field547 = new int[var1][var2];
      this.field546 = new int[var1][var2];
      this.field545 = new int[var1][var2];
      this.field550 = new int[var1][var2];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILjs;I)V",
      garbageValue = "-1741362680"
   )
   void method672(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field548 && var2 - var3 <= this.field549) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field548, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field549, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field547[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field546[var9][var10] += var4.saturation;
                     this.field545[var9][var10] += var4.lightness;
                     ++this.field550[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-21"
   )
   int method673(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field548 && var2 < this.field549) {
         if(this.field545[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field547[var1][var2] / this.field550[var1][var2];
            int var4 = this.field546[var1][var2] / this.field550[var1][var2];
            int var5 = this.field545[var1][var2] / this.field550[var1][var2];
            return BoundingBox3DDrawMode.method62((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1110314485"
   )
   static final void method681() {
      int var0 = TextureProvider.menuX;
      int var1 = class90.menuY;
      int var2 = class23.field331;
      int var3 = MapIconReference.field571;
      int var4 = 6116423;
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class5.fontBold12.method5500("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.mouseLastX;
      int var6 = MouseInput.mouseLastY;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class5.fontBold12.method5500(method677(var7), var0 + 3, var8, var9, 0);
      }

      ItemContainer.method1148(TextureProvider.menuX, class90.menuY, class23.field331, MapIconReference.field571);
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1081732051"
   )
   static String method677(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lig;IIZI)V",
      garbageValue = "434713985"
   )
   static void method674(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.height * var0.field2834 / var0.field2835;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2835 / var0.field2834;
      }

      if(var0.contentType == 1337) {
         Client.field1061 = var0;
      }

      if(var3 && var0.field2926 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.field2926;
         Client.field1045.addFront(var6);
      }

   }
}
