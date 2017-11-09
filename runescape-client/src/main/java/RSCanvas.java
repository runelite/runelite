import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("lv")
   @ObfuscatedSignature(
      signature = "[Lhk;"
   )
   static Widget[] field630;
   @ObfuscatedName("c")
   static int[] field632;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("m")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "77"
   )
   static int method857() {
      return ++class96.field1428 - 1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "283616092"
   )
   public static int method851(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1230371872"
   )
   static final void method855() {
      if(Ignore.plane != Client.field1078) {
         Client.field1078 = Ignore.plane;
         int var0 = Ignore.plane;
         int[] var1 = class39.field507.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
                  class56.region.method2815(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class56.region.method2815(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class39.field507.method5269();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
                  class39.method586(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  class39.method586(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field1079 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class56.region.method2942(Ignore.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class24.getObjectDefinition(var7).mapIconId;
                  if(var8 >= 0) {
                     Client.mapIcons[Client.field1079] = Area.field3358[var8].method4485(false);
                     Client.field1120[Client.field1079] = var5;
                     Client.field969[Client.field1079] = var6;
                     ++Client.field1079;
                  }
               }
            }
         }

         class66.field779.setRaster();
      }

   }
}
