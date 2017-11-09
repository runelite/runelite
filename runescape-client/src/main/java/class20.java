import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class20 {
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 994960527
   )
   static int field325;
   @ObfuscatedName("v")
   public static File field328;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field320;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lbn;B)V",
      garbageValue = "-85"
   )
   static void method173(GameEngine var0) {
      if(MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4) {
         int var1 = class91.field1332 + 280;
         if(MouseInput.field714 >= var1 && MouseInput.field714 <= var1 + 14 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(0, 0);
            return;
         }

         if(MouseInput.field714 >= var1 + 15 && MouseInput.field714 <= var1 + 80 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(0, 1);
            return;
         }

         int var2 = class91.field1332 + 390;
         if(MouseInput.field714 >= var2 && MouseInput.field714 <= var2 + 14 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(1, 0);
            return;
         }

         if(MouseInput.field714 >= var2 + 15 && MouseInput.field714 <= var2 + 80 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(1, 1);
            return;
         }

         int var3 = class91.field1332 + 500;
         if(MouseInput.field714 >= var3 && MouseInput.field714 <= var3 + 14 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(2, 0);
            return;
         }

         if(MouseInput.field714 >= var3 + 15 && MouseInput.field714 <= var3 + 80 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(2, 1);
            return;
         }

         int var4 = class91.field1332 + 610;
         if(MouseInput.field714 >= var4 && MouseInput.field714 <= var4 + 14 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(3, 0);
            return;
         }

         if(MouseInput.field714 >= var4 + 15 && MouseInput.field714 <= var4 + 80 && MouseInput.field715 >= 4 && MouseInput.field715 <= 18) {
            class47.method770(3, 1);
            return;
         }

         if(MouseInput.field714 >= class91.field1332 + 708 && MouseInput.field715 >= 4 && MouseInput.field714 <= class91.field1332 + 708 + 50 && MouseInput.field715 <= 20) {
            class91.worldSelectShown = false;
            class91.field1336.method5276(class91.field1332, 0);
            class91.field1368.method5276(class91.field1332 + 382, 0);
            class91.logoSprite.method5246(class91.field1332 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1355 != -1) {
            World var5 = Coordinates.worldList[class91.field1355];
            class74.method1222(var5);
            class91.worldSelectShown = false;
            class91.field1336.method5276(class91.field1332, 0);
            class91.field1368.method5276(class91.field1332 + 382, 0);
            class91.logoSprite.method5246(class91.field1332 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "758642053"
   )
   static final void method174(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var6 + var13;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1932372306"
   )
   static void method172(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3543; ++var4) {
         ItemComposition var5 = class250.getItemDefinition(var4);
         if((!var1 || var5.field3590) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class43.field551 = -1;
               class54.field635 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class54.field635 = var2;
      Player.field843 = 0;
      class43.field551 = var3;
      String[] var8 = new String[class43.field551];

      for(int var9 = 0; var9 < class43.field551; ++var9) {
         var8[var9] = class250.getItemDefinition(var2[var9]).name;
      }

      class24.method192(var8, class54.field635);
   }
}
