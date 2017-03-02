import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class5 implements Comparator {
   @ObfuscatedName("cn")
   static class110 field46;
   @ObfuscatedName("ek")
   static ModIcon[] field47;
   @ObfuscatedName("gs")
   static Widget field50;
   @ObfuscatedName("aj")
   static int[] field51;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "310111899"
   )
   int method72(class2 var1, class2 var2) {
      return var1.field17.price < var2.field17.price?-1:(var2.field17.price == var1.field17.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method72((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "285687313"
   )
   public static void method79(Applet var0, String var1) {
      class114.field1783 = var0;
      class114.field1787 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1427107361"
   )
   public static void method81() {
      if(null != class105.keyboard) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1366556029"
   )
   static boolean method82(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class9.method122(var0, Client.field286);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class9.method122(var3.name, Client.field286))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class9.method122(var3.previousName, Client.field286))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2031211692"
   )
   static final void method83(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field647 > Client.gameCycle) {
         var2 = var0.field647 - Client.gameCycle;
         var3 = var0.field634 * 64 + var0.field643 * 128;
         var4 = var0.field634 * 64 + var0.field645 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field601 = 0;
         var0.field652 = var0.field649;
      } else if(var0.field633 >= Client.gameCycle) {
         WidgetNode.method204(var0);
      } else {
         ItemComposition.method3742(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field647 = 0;
         var0.field633 = 0;
         var0.x = var0.field634 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field634 * 64 + 128 * var0.pathY[0];
         var0.method622();
      }

      if(var0 == class9.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field647 = 0;
         var0.field633 = 0;
         var0.x = var0.field634 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field634 * 64 + var0.pathY[0] * 128;
         var0.method622();
      }

      if(var0.field654 != 0) {
         if(var0.interacting != -1) {
            Object var5 = null;
            if(var0.interacting < '耀') {
               var5 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var5 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var5) {
               var3 = var0.x - ((Actor)var5).x;
               var4 = var0.y - ((Actor)var5).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field652 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field650) {
               var0.interacting = -1;
               var0.field650 = false;
            }
         }

         if(var0.field610 != -1 && (var0.field655 == 0 || var0.field601 > 0)) {
            var0.field652 = var0.field610;
            var0.field610 = -1;
         }

         var2 = var0.field652 - var0.angle & 2047;
         if(var2 == 0 && var0.field650) {
            var0.interacting = -1;
            var0.field650 = false;
         }

         if(var2 != 0) {
            ++var0.field659;
            boolean var7;
            if(var2 > 1024) {
               var0.angle -= var0.field654;
               var7 = true;
               if(var2 < var0.field654 || var2 > 2048 - var0.field654) {
                  var0.angle = var0.field652;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field659 > 25 || var7)) {
                  if(var0.field607 != -1) {
                     var0.poseAnimation = var0.field607;
                  } else {
                     var0.poseAnimation = var0.field627;
                  }
               }
            } else {
               var0.angle += var0.field654;
               var7 = true;
               if(var2 < var0.field654 || var2 > 2048 - var0.field654) {
                  var0.angle = var0.field652;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field659 > 25 || var7)) {
                  if(var0.field608 != -1) {
                     var0.poseAnimation = var0.field608;
                  } else {
                     var0.poseAnimation = var0.field627;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field659 = 0;
         }
      }

      class44.method884(var0);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Z",
      garbageValue = "-51"
   )
   public static boolean method84(String var0, int var1) {
      return ChatMessages.method934(var0, var1, "openjs");
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-10640"
   )
   static final void method85(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         WallObject.field1551.field689 = !WallObject.field1551.field689;
         DecorativeObject.method1977();
         if(WallObject.field1551.field689) {
            class140.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class140.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field298 = !Client.field298;
      }

      if(Client.field370 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field298 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field298 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class7.method109();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field295 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field327.method3124(87);
      Client.field327.method3010(var0.length() + 1);
      Client.field327.method2893(var0);
   }
}
