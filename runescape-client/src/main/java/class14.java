import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class14 {
   @ObfuscatedName("p")
   public static class62 field219;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1119480413
   )
   int field220 = -1;
   @ObfuscatedName("e")
   int[] field221;
   @ObfuscatedName("i")
   class23 field222;
   @ObfuscatedName("y")
   static ModIcon field223;
   @ObfuscatedName("mq")
   static byte field224;
   @ObfuscatedName("g")
   String[] field226;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "-26"
   )
   static void method166(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            class21.method541(var6, var2, var3, var4);
            WallObject.method2135(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class130.method2850(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "167214580"
   )
   static final void method167(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field881 > Client.gameCycle) {
         var2 = var0.field881 - Client.gameCycle;
         var3 = var0.field839 * 64 + var0.field841 * 128;
         var4 = var0.field839 * 64 + var0.field879 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field893 = 0;
         var0.field886 = var0.field892;
      } else if(var0.field882 >= Client.gameCycle) {
         if(Client.gameCycle == var0.field882 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field880 > class192.getAnimation(var0.animation).field1019[var0.actionFrame]) {
            var2 = var0.field882 - var0.field881;
            var3 = Client.gameCycle - var0.field881;
            var4 = var0.field841 * 128 + var0.field839 * 64;
            int var5 = var0.field879 * 128 + var0.field839 * 64;
            int var6 = var0.field839 * 64 + var0.field858 * 128;
            int var7 = var0.field839 * 64 + var0.field855 * 128;
            var0.x = ((var2 - var3) * var4 + var6 * var3) / var2;
            var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
         }

         var0.field893 = 0;
         var0.field886 = var0.field892;
         var0.angle = var0.field886;
      } else {
         class50.method1032(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field881 = 0;
         var0.field882 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field839 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field839 * 64;
         var0.method782();
      }

      if(var0 == class138.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field881 = 0;
         var0.field882 = 0;
         var0.x = var0.field839 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field839 * 64 + 128 * var0.pathY[0];
         var0.method782();
      }

      if(var0.field888 != 0) {
         if(var0.interacting != -1) {
            Object var8 = null;
            if(var0.interacting < '耀') {
               var8 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var8 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var8 != null) {
               var3 = var0.x - ((Actor)var8).x;
               var4 = var0.y - ((Actor)var8).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field886 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field890) {
               var0.interacting = -1;
               var0.field890 = false;
            }
         }

         if(var0.field863 != -1 && (var0.field889 == 0 || var0.field893 > 0)) {
            var0.field886 = var0.field863;
            var0.field863 = -1;
         }

         var2 = var0.field886 - var0.angle & 2047;
         if(var2 == 0 && var0.field890) {
            var0.interacting = -1;
            var0.field890 = false;
         }

         if(var2 != 0) {
            ++var0.field887;
            boolean var10;
            if(var2 > 1024) {
               var0.angle -= var0.field888;
               var10 = true;
               if(var2 < var0.field888 || var2 > 2048 - var0.field888) {
                  var0.angle = var0.field886;
                  var10 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field887 > 25 || var10)) {
                  if(var0.field862 != -1) {
                     var0.poseAnimation = var0.field862;
                  } else {
                     var0.poseAnimation = var0.field859;
                  }
               }
            } else {
               var0.angle += var0.field888;
               var10 = true;
               if(var2 < var0.field888 || var2 > 2048 - var0.field888) {
                  var0.angle = var0.field886;
                  var10 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field887 > 25 || var10)) {
                  if(var0.field842 != -1) {
                     var0.poseAnimation = var0.field842;
                  } else {
                     var0.poseAnimation = var0.field859;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field887 = 0;
         }
      }

      FrameMap.method2321(var0);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "-64"
   )
   public static int method168(CharSequence var0, int var1) {
      return class145.method3022(var0, var1, true);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass134;",
      garbageValue = "196434313"
   )
   public static class134 method169() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1413626453"
   )
   static final String method170(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class137.method2909(16711680):(var2 < -6?class137.method2909(16723968):(var2 < -3?class137.method2909(16740352):(var2 < 0?class137.method2909(16756736):(var2 > 9?class137.method2909('\uff00'):(var2 > 6?class137.method2909(4259584):(var2 > 3?class137.method2909(8453888):(var2 > 0?class137.method2909(12648192):class137.method2909(16776960))))))));
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "1214904100"
   )
   static final void method171(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field246 == 0) {
         var1 = class128.region.method1978(var0.field252, var0.field243, var0.field260);
      }

      if(var0.field246 == 1) {
         var1 = class128.region.method1979(var0.field252, var0.field243, var0.field260);
      }

      if(var0.field246 == 2) {
         var1 = class128.region.method1980(var0.field252, var0.field243, var0.field260);
      }

      if(var0.field246 == 3) {
         var1 = class128.region.method2052(var0.field252, var0.field243, var0.field260);
      }

      if(var1 != 0) {
         int var5 = class128.region.method1995(var0.field252, var0.field243, var0.field260, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field257 = var2;
      var0.field247 = var3;
      var0.field241 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "406165114"
   )
   public static boolean method172(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!CollisionData.field1945.method3354(var0)) {
         return false;
      } else {
         int var1 = CollisionData.field1945.method3299(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = CollisionData.field1945.method3292(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3427(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3433(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
