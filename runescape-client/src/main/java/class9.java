import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public final class class9 {
   @ObfuscatedName("eg")
   static ModIcon[] field73;
   @ObfuscatedName("bn")
   static class184 field74;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1129739529
   )
   static int field75;
   @ObfuscatedName("w")
   public static String[] field77;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass184;II)V",
      garbageValue = "-1340022602"
   )
   static void method110(class184 var0, int var1) {
      if(class185.field2762 != null) {
         class185.field2762.offset = 5 + var1 * 8;
         int var2 = class185.field2762.readInt();
         int var3 = class185.field2762.readInt();
         var0.method3446(var2, var3);
      } else {
         class44.method884((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2760[var1] = var0;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   static void method111() {
      int var0 = GameEngine.field1776;
      int var1 = GameEngine.field1777;
      int var2 = class63.field1106 - RSCanvas.field1756 - var0;
      int var3 = Friend.field149 - class65.field1128 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field556.method2202();
            int var5 = 0;
            int var6 = 0;
            if(var4 == CollisionData.field1835) {
               Insets var7 = CollisionData.field1835.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, Friend.field149);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class63.field1106, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class63.field1106 - var2, var6, var2, Friend.field149);
            }

            if(var3 > 0) {
               var9.fillRect(var5, Friend.field149 + var6 - var3, class63.field1106, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-41"
   )
   static void method112(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2438(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-31094"
   )
   static final void method113(int var0, int var1) {
      int var2 = class217.field3188.method3904("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         Font var4 = class217.field3188;
         String var7;
         if(var3 < 0) {
            var7 = "";
         } else if(Client.menuTargets[var3].length() > 0) {
            var7 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var7 = Client.menuOptions[var3];
         }

         int var6 = var4.method3904(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + Client.menuOptionCount * 15;
      int var8 = var0 - var2 / 2;
      if(var2 + var8 > RSCanvas.field1756) {
         var8 = RSCanvas.field1756 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class65.field1128) {
         var5 = class65.field1128 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Friend.region.method1826(CollisionData.plane, var0, var1, false);
      Client.isMenuOpen = true;
      class162.menuX = var8;
      class160.menuY = var5;
      class41.menuWidth = var2;
      XItemContainer.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-983472229"
   )
   static boolean method114(Widget var0) {
      if(Client.field470) {
         if(MessageNode.method220(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
