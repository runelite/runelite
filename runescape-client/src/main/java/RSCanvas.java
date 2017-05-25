import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("bd")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("ck")
   static class153 field659;
   @ObfuscatedName("i")
   Component field661;
   @ObfuscatedName("fr")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   public final void update(Graphics var1) {
      this.field661.update(var1);
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1649844806"
   )
   static void method776() {
      Client.menuOptionCount = 0;
      Client.field1037 = -1;
      Client.isMenuOpen = false;
   }

   public final void paint(Graphics var1) {
      this.field661.paint(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1619750150"
   )
   static void method779() {
      class90.underlayIds = null;
      class61.overlayIds = null;
      class61.overlayPaths = null;
      class61.overlayRotations = null;
      class61.field754 = null;
      class18.field315 = null;
      class61.field746 = null;
      class89.field1387 = null;
      class51.field650 = null;
      class249.field3371 = null;
      class11.field264 = null;
      class61.field745 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-52"
   )
   static final int method782(int var0, int var1) {
      int var2 = class223.method4146(var0 - 1, var1 - 1) + class223.method4146(var0 + 1, var1 - 1) + class223.method4146(var0 - 1, var1 + 1) + class223.method4146(var0 + 1, var1 + 1);
      int var3 = class223.method4146(var0 - 1, var1) + class223.method4146(var0 + 1, var1) + class223.method4146(var0, var1 - 1) + class223.method4146(var0, var1 + 1);
      int var4 = class223.method4146(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1605742391"
   )
   static final void method783(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.hasScript || !class149.method2945(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class149.method2945(var3) && Player.field868 != var3) {
                  continue;
               }

               method783(var0, var3.id);
               if(var3.children != null) {
                  method783(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3615((long)var3.id);
               if(var4 != null) {
                  class252.method4506(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2689 != -1 || var3.field2675 != -1) {
                  boolean var7 = class46.method710(var3);
                  if(var7) {
                     var5 = var3.field2675;
                  } else {
                     var5 = var3.field2689;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class165.getAnimation(var5);

                     for(var3.field2765 += Client.field966; var3.field2765 > var6.frameLenghts[var3.field2773]; class219.method4130(var3)) {
                        var3.field2765 -= var6.frameLenghts[var3.field2773];
                        ++var3.field2773;
                        if(var3.field2773 >= var6.frameIDs.length) {
                           var3.field2773 -= var6.frameStep;
                           if(var3.field2773 < 0 || var3.field2773 >= var6.frameIDs.length) {
                              var3.field2773 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2698 != 0 && !var3.hasScript) {
                  int var8 = var3.field2698 >> 16;
                  var5 = var3.field2698 << 16 >> 16;
                  var8 *= Client.field966;
                  var5 *= Client.field966;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class219.method4130(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lclass91;",
      garbageValue = "-1696409999"
   )
   static class91[] method784() {
      return new class91[]{class91.field1410, class91.field1405, class91.field1407, class91.field1406};
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1325576080"
   )
   static void method785(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1131 < 50 && Client.field1130 != 0) {
         if(var0.field3603 != null && var1 < var0.field3603.length) {
            int var4 = var0.field3603[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1132[Client.field1131] = var5;
               Client.field1009[Client.field1131] = var6;
               Client.field1134[Client.field1131] = 0;
               Client.field1136[Client.field1131] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1135[Client.field1131] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field1131;
            }
         }
      }
   }

   RSCanvas(Component var1) {
      this.field661 = var1;
   }
}
