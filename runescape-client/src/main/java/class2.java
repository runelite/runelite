import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class2 implements class0 {
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1053906661
   )
   static int field15;
   @ObfuscatedName("v")
   static int[] field11;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1580798333
   )
   static int field13;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1926875836"
   )
   static int method4(int var0, int var1) {
      Overlay var2 = Varcs.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = FrameMap.method2686(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         int var8 = FrameMap.method2686(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;IIIZI)V",
      garbageValue = "-2029809003"
   )
   public static void method3(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class214.field2620 = 1;
      class214.field2623 = var0;
      class61.field692 = var1;
      class282.field3754 = var2;
      class214.field2625 = var3;
      IndexFile.field2181 = var4;
      Timer.field2159 = 10000;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1051441397"
   )
   static int method5(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class139.field2008:AttackOption.field1306;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--class82.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class82.scriptStringStack[--class35.scriptStringStackSize]);
            return 1;
         } else {
            --class35.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class82.intStackSize -= 2;
         var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.dragParent = TextureProvider.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2889 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2835 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2884 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--class35.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--class35.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
