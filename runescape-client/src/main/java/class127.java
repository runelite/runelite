import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class127 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 8946201004192759819L
   )
   static long field2109;
   @ObfuscatedName("m")
   public static short[][] field2112;

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "117"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field342 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field342) {
         var1 = Client.field325.method2565();
         var2 = Client.field325.method2566();
         var3 = Client.field325.method2717();
         Friend.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Friend.xteaKeys[var4][var5] = Client.field325.method2533();
            }
         }

         class20.mapRegions = new int[var3];
         class47.field1067 = new int[var3];
         class48.field1089 = new int[var3];
         class28.field688 = new byte[var3][];
         SecondaryBufferProvider.field1446 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (6 + var2) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (6 + var1) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class20.mapRegions[var3] = var7;
                  class47.field1067[var3] = class1.field18.method3324("m" + var5 + "_" + var6);
                  class48.field1089[var3] = class1.field18.method3324("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Ignore.method110(var2, var1);
      } else {
         var1 = Client.field325.method2731();
         var2 = Client.field325.method2566();
         var3 = Client.field325.method2717();
         Client.field325.method2784();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field325.method2792(1);
                  if(var7 == 1) {
                     Client.field475[var4][var5][var6] = Client.field325.method2792(26);
                  } else {
                     Client.field475[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field325.method2805();
         Friend.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Friend.xteaKeys[var4][var5] = Client.field325.method2533();
            }
         }

         class20.mapRegions = new int[var3];
         class47.field1067 = new int[var3];
         class48.field1089 = new int[var3];
         class28.field688 = new byte[var3][];
         SecondaryBufferProvider.field1446 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field475[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class20.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class20.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class47.field1067[var3] = class1.field18.method3324("m" + var11 + "_" + var12);
                        class48.field1089[var3] = class1.field18.method3324("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         Ignore.method110(var2, var1);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-85012579"
   )
   static final void method2819(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field859 > Client.gameCycle) {
         var2 = var0.field859 - Client.gameCycle;
         var3 = var0.field843 * 64 + var0.field882 * 128;
         var4 = var0.field883 * 128 + var0.field843 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field897 = 0;
         var0.field891 = var0.field839;
      } else if(var0.field845 >= Client.gameCycle) {
         if(var0.field845 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field881 > Friend.getAnimation(var0.animation).field1015[var0.actionFrame]) {
            var2 = var0.field845 - var0.field859;
            var3 = Client.gameCycle - var0.field859;
            var4 = var0.field882 * 128 + var0.field843 * 64;
            int var5 = var0.field883 * 128 + var0.field843 * 64;
            int var6 = var0.field843 * 64 + var0.field854 * 128;
            int var7 = var0.field843 * 64 + var0.field884 * 128;
            var0.x = (var6 * var3 + (var2 - var3) * var4) / var2;
            var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
         }

         var0.field897 = 0;
         var0.field891 = var0.field839;
         var0.angle = var0.field891;
      } else {
         MessageNode.method770(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field859 = 0;
         var0.field845 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field843 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field843 * 64;
         var0.method784();
      }

      if(WidgetNode.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field859 = 0;
         var0.field845 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field843 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field843 * 64;
         var0.method784();
      }

      if(var0.field892 != 0) {
         if(var0.interacting != -1) {
            Object var8 = null;
            if(var0.interacting < '耀') {
               var8 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var8 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var8) {
               var3 = var0.x - ((Actor)var8).x;
               var4 = var0.y - ((Actor)var8).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field891 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field866) {
               var0.interacting = -1;
               var0.field866 = false;
            }
         }

         if(var0.field885 != -1 && (var0.field893 == 0 || var0.field897 > 0)) {
            var0.field891 = var0.field885;
            var0.field885 = -1;
         }

         var2 = var0.field891 - var0.angle & 2047;
         if(var2 == 0 && var0.field866) {
            var0.interacting = -1;
            var0.field866 = false;
         }

         if(var2 != 0) {
            ++var0.field844;
            boolean var10;
            if(var2 > 1024) {
               var0.angle -= var0.field892;
               var10 = true;
               if(var2 < var0.field892 || var2 > 2048 - var0.field892) {
                  var0.angle = var0.field891;
                  var10 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field844 > 25 || var10)) {
                  if(var0.field849 != -1) {
                     var0.poseAnimation = var0.field849;
                  } else {
                     var0.poseAnimation = var0.field847;
                  }
               }
            } else {
               var0.angle += var0.field892;
               var10 = true;
               if(var2 < var0.field892 || var2 > 2048 - var0.field892) {
                  var0.angle = var0.field891;
                  var10 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field844 > 25 || var10)) {
                  if(var0.field890 != -1) {
                     var0.poseAnimation = var0.field890;
                  } else {
                     var0.poseAnimation = var0.field847;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field844 = 0;
         }
      }

      class143.method3004(var0);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1026525215"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1051.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1059.method3309(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method952(new Buffer(var2));
         }

         KitDefinition.field1051.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-748829345"
   )
   public static void method2823(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2823(var0, var1, var2, var5 - 1);
         method2823(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2063682396"
   )
   public static void method2824(Component var0) {
      var0.removeMouseListener(class143.mouse);
      var0.removeMouseMotionListener(class143.mouse);
      var0.removeFocusListener(class143.mouse);
      class143.field2217 = 0;
   }
}
