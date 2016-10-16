import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class14 {
   @ObfuscatedName("ah")
   static int[] field191;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1128606731
   )
   int field192 = -1;
   @ObfuscatedName("t")
   int[] field193;
   @ObfuscatedName("bp")
   static ModIcon[] field195;
   @ObfuscatedName("y")
   String[] field196;
   @ObfuscatedName("pk")
   static short[] field197;
   @ObfuscatedName("z")
   class23 field198;
   @ObfuscatedName("qq")
   protected static class136 field199;

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "4"
   )
   static final void method168(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field401.method3808(); null != var10; var10 = (class16)Client.field401.method3810()) {
         if(var10.field215 == var0 && var10.field209 == var1 && var10.field221 == var2 && var3 == var10.field208) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field215 = var0;
         var9.field208 = var3;
         var9.field209 = var1;
         var9.field221 = var2;
         MessageNode.method753(var9);
         Client.field401.method3801(var9);
      }

      var9.field214 = var4;
      var9.field218 = var5;
      var9.field217 = var6;
      var9.field210 = var7;
      var9.field211 = var8;
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-1382076518"
   )
   static final void method169(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         Widget.field2788.method3262(var2);
         if(null != Widget.widgets[var2]) {
            boolean var4 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               Widget.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      class116.method2417(var2);
      Widget var6 = class92.method2078(var3);
      if(null != var6) {
         class32.method685(var6);
      }

      class0.method2();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class174.method3393(var5)) {
            class112.method2393(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-58106060"
   )
   static final void method170(int var0, int var1, int var2, int var3) {
      Client.field363 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field743;
      int[] var7 = class34.field739;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field309; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field399) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field307[var8 - var6]];
         }

         class1.method5((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class1.method5(Client.cachedPlayers[Client.field399], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field363; ++var8) {
         int var18 = Client.field365[var8];
         int var10 = Client.field366[var8];
         int var11 = Client.field368[var8];
         int var12 = Client.field367[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var19 = 0; var19 < var8; ++var19) {
               if(2 + var10 > Client.field366[var19] - Client.field367[var19] && var10 - var12 < 2 + Client.field366[var19] && var18 - var11 < Client.field365[var19] + Client.field368[var19] && var11 + var18 > Client.field365[var19] - Client.field368[var19] && Client.field366[var19] - Client.field367[var19] < var10) {
                  var10 = Client.field366[var19] - Client.field367[var19];
                  var13 = true;
               }
            }
         }

         Client.field375 = Client.field365[var8];
         Client.field376 = Client.field366[var8] = var10;
         String var14 = Client.field351[var8];
         if(Client.field430 == 0) {
            int var15 = 16776960;
            if(Client.field413[var8] < 6) {
               var15 = Client.field442[Client.field413[var8]];
            }

            if(Client.field413[var8] == 6) {
               var15 = Client.field374 % 20 < 10?16711680:16776960;
            }

            if(Client.field413[var8] == 7) {
               var15 = Client.field374 % 20 < 10?255:'\uffff';
            }

            if(Client.field413[var8] == 8) {
               var15 = Client.field374 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field413[var8] == 9) {
               var16 = 150 - Client.field371[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 5 * (var16 - 100) + '\uff00';
               }
            }

            if(Client.field413[var8] == 10) {
               var16 = 150 - Client.field371[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 255 + (var16 - 100) * 327680 - 5 * (var16 - 100);
               }
            }

            if(Client.field413[var8] == 11) {
               var16 = 150 - Client.field371[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = '\uff00' + (var16 - 50) * 327685;
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field370[var8] == 0) {
               class117.field2001.method4072(var14, Client.field375 + var0, Client.field376 + var1, var15, 0);
            }

            if(Client.field370[var8] == 1) {
               class117.field2001.method4036(var14, Client.field375 + var0, var1 + Client.field376, var15, 0, Client.field374);
            }

            if(Client.field370[var8] == 2) {
               class117.field2001.method4037(var14, var0 + Client.field375, Client.field376 + var1, var15, 0, Client.field374);
            }

            if(Client.field370[var8] == 3) {
               class117.field2001.method4039(var14, Client.field375 + var0, var1 + Client.field376, var15, 0, Client.field374, 150 - Client.field371[var8]);
            }

            if(Client.field370[var8] == 4) {
               var16 = (150 - Client.field371[var8]) * (class117.field2001.method4027(var14) + 100) / 150;
               class82.method1796(Client.field375 + var0 - 50, var1, Client.field375 + var0 + 50, var3 + var1);
               class117.field2001.method4032(var14, 50 + Client.field375 + var0 - var16, Client.field376 + var1, var15, 0);
               class82.method1795(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field370[var8] == 5) {
               var16 = 150 - Client.field371[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1796(var0, Client.field376 + var1 - class117.field2001.field3238 - 1, var0 + var2, 5 + var1 + Client.field376);
               class117.field2001.method4072(var14, Client.field375 + var0, Client.field376 + var1 + var17, var15, 0);
               class82.method1795(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class117.field2001.method4072(var14, var0 + Client.field375, Client.field376 + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "965328798"
   )
   static final void method171() {
      for(int var0 = 0; var0 < Client.field308; ++var0) {
         int var1 = Client.field418[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field312.method2481();
         if((var3 & 4) != 0) {
            var2.interacting = Client.field312.method2668();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.overhead = Client.field312.method2503();
            var2.field817 = 100;
         }

         int var4;
         int var5;
         int var6;
         if((var3 & 32) != 0) {
            var4 = Client.field312.method2668();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field312.method2481();
            if(var2.animation == var4 && var4 != -1) {
               var6 = class4.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field835 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field837 = 0;
               }

               if(var6 == 2) {
                  var2.field837 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class4.getAnimation(var4).field970 >= class4.getAnimation(var2.animation).field970) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field835 = 0;
               var2.actionAnimationDisable = var5;
               var2.field837 = 0;
               var2.field821 = var2.field855;
            }
         }

         if((var3 & 2) != 0) {
            var2.composition = class127.getNpcDefinition(Client.field312.method2517());
            var2.field805 = var2.composition.field902;
            var2.field854 = var2.composition.field896;
            var2.field813 = var2.composition.field899;
            var2.field802 = var2.composition.field879;
            var2.field808 = var2.composition.field888;
            var2.field861 = var2.composition.field882;
            var2.idlePoseAnimation = var2.composition.field876;
            var2.field807 = var2.composition.field877;
            var2.field806 = var2.composition.field878;
         }

         int var7;
         if((var3 & 1) != 0) {
            var4 = Client.field312.method2554();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field312.method2654();
                  if(var6 == 32767) {
                     var6 = Client.field312.method2654();
                     var8 = Client.field312.method2654();
                     var7 = Client.field312.method2654();
                     var9 = Client.field312.method2654();
                  } else if(var6 != 32766) {
                     var8 = Client.field312.method2654();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field312.method2654();
                  var2.method770(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field312.method2554();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field312.method2654();
                  var8 = Client.field312.method2654();
                  if(var8 != 32767) {
                     var9 = Client.field312.method2654();
                     var10 = Client.field312.method2481();
                     int var11 = var8 > 0?Client.field312.method2554():var10;
                     var2.method779(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method772(var7);
                  }
               }
            }
         }

         if((var3 & 16) != 0) {
            var4 = Client.field312.method2517();
            var5 = Client.field312.method2516();
            var6 = var2.x - (var4 - class23.baseX - class23.baseX) * 64;
            var7 = var2.y - 64 * (var5 - class8.baseY - class8.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field850 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var2.graphic = Client.field312.method2516();
            var4 = Client.field312.method2644();
            var2.field839 = var4 >> 16;
            var2.field853 = Client.gameCycle + (var4 & '\uffff');
            var2.field811 = 0;
            var2.field840 = 0;
            if(var2.field853 > Client.gameCycle) {
               var2.field811 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;I)Z",
      garbageValue = "524844043"
   )
   public static final boolean method172(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1905[var6][var7] = 99;
      class109.field1906[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1912[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1915[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class109.field1912[var11];
         var5 = class109.field1915[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2357(1, var4, var5, var3)) {
            class109.field1907 = var4;
            class109.field1908 = var5;
            return true;
         }

         int var15 = 1 + class109.field1906[var16][var17];
         if(var16 > 0 && class109.field1905[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1912[var18] = var4 - 1;
            class109.field1915[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1905[var16 - 1][var17] = 2;
            class109.field1906[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1905[1 + var16][var17] == 0 && (var12[1 + var13][var14] & 19136896) == 0) {
            class109.field1912[var18] = 1 + var4;
            class109.field1915[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1905[1 + var16][var17] = 8;
            class109.field1906[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1905[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1912[var18] = var4;
            class109.field1915[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1905[var16][var17 - 1] = 1;
            class109.field1906[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1905[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1912[var18] = var4;
            class109.field1915[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1905[var16][1 + var17] = 4;
            class109.field1906[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1905[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1912[var18] = var4 - 1;
            class109.field1915[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1905[var16 - 1][var17 - 1] = 3;
            class109.field1906[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1905[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1912[var18] = var4 + 1;
            class109.field1915[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1905[var16 + 1][var17 - 1] = 9;
            class109.field1906[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1905[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1912[var18] = var4 - 1;
            class109.field1915[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class109.field1905[var16 - 1][1 + var17] = 6;
            class109.field1906[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1905[1 + var16][1 + var17] == 0 && (var12[1 + var13][1 + var14] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1912[var18] = 1 + var4;
            class109.field1915[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1905[1 + var16][1 + var17] = 12;
            class109.field1906[var16 + 1][1 + var17] = var15;
         }
      }

      class109.field1907 = var4;
      class109.field1908 = var5;
      return false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "232158799"
   )
   static int method173(int var0) {
      MessageNode var1 = (MessageNode)class11.field168.method3792((long)var0);
      return var1 == null?-1:(var1.next == class11.field165.field3150?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1641094086"
   )
   static final void method174(boolean var0) {
      class12.method162();
      ++Client.field316;
      if(Client.field316 >= 50 || var0) {
         Client.field316 = 0;
         if(!Client.field533 && class32.field695 != null) {
            Client.field300.method2748(91);

            try {
               class32.field695.method2987(Client.field300.payload, 0, Client.field300.offset);
               Client.field300.offset = 0;
            } catch (IOException var2) {
               Client.field533 = true;
            }
         }

      }
   }
}
