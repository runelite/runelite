import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public final class class94 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2073614017
   )
   int field1565;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1625609089
   )
   int field1566;
   @ObfuscatedName("pb")
   static short[] field1567;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 973414377
   )
   int field1568;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1152444737
   )
   int field1569;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2147468519
   )
   int field1570;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1513365771
   )
   int field1571;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1558053887
   )
   int field1572;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -447976541
   )
   int field1573;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1932016999
   )
   int field1574;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 945143399
   )
   int field1575;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -876840859
   )
   int field1576;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 837844691
   )
   int field1577;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1471492805
   )
   static int field1578;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1866826615
   )
   int field1579;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -673121387
   )
   int field1580;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -446721761
   )
   int field1581;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -336016663
   )
   int field1582;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1102936453
   )
   int field1583;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1199073885
   )
   int field1584;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1053383875"
   )
   static int method1889(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "61"
   )
   static void method1890(Widget var0) {
      if(Client.field490 == var0.field2340) {
         Client.field524[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "657904338"
   )
   static int method1891(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method620()?(var1.method620()?0:1):(var1.method620()?-1:0)):(var2 == 5?(var0.method592()?(var1.method592()?0:1):(var1.method592()?-1:0)):(var2 == 6?(var0.method593()?(var1.method593()?0:1):(var1.method593()?-1:0)):(var2 == 7?(var0.method591()?(var1.method591()?0:1):(var1.method591()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "18"
   )
   static final void method1892(int var0, int var1, int var2, int var3) {
      ++Client.field312;
      MessageNode.method202(class15.field158);
      boolean var4 = false;
      int var7;
      int var28;
      if(Client.field418 >= 0) {
         var28 = class45.field908;
         int[] var6 = class45.field903;

         for(var7 = 0; var7 < var28; ++var7) {
            if(var6[var7] == Client.field418) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         MessageNode.method202(class15.field159);
      }

      class179.method3202(true);
      MessageNode.method202(var4?class15.field161:class15.field160);
      class179.method3202(false);
      class10.method147();

      for(class33 var5 = (class33)Client.field422.method2359(); null != var5; var5 = (class33)Client.field422.method2361()) {
         if(class171.plane == var5.field738 && !var5.field747) {
            if(Client.gameCycle >= var5.field734) {
               var5.method660(Client.field364);
               if(var5.field747) {
                  var5.unlink();
               } else {
                  Client.region.method1739(var5.field738, var5.field736, var5.field737, var5.field748, 60, var5, 0, -1, false);
               }
            }
         } else {
            var5.unlink();
         }
      }

      class39.method709(var0, var1, var2, var3, true);
      var0 = Client.field548;
      var1 = Client.field549;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class219.method3889(var0, var1, var0 + var2, var3 + var1);
      class84.method1626();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      int var18;
      int var30;
      if(!Client.field534) {
         var28 = Client.field371;
         if(Client.field380 / 256 > var28) {
            var28 = Client.field380 / 256;
         }

         if(Client.field535[4] && 128 + Client.field393[4] > var28) {
            var28 = 128 + Client.field393[4];
         }

         var30 = Client.field356 + Client.mapAngle & 2047;
         var7 = class37.field785;
         var8 = class85.method1686(class39.localPlayer.x, class39.localPlayer.y, class171.plane) - Client.field377;
         var9 = Player.field266;
         var10 = 3 * var28 + 600;
         var11 = 2048 - var28 & 2047;
         var12 = 2048 - var30 & 2047;
         var13 = 0;
         int var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = class84.field1453[var11];
            var17 = class84.field1454[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var16 * var14 + var10 * var17 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class84.field1453[var12];
            var17 = class84.field1454[var12];
            var18 = var16 * var15 + var17 * var13 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         WidgetNode.cameraX = var7 - var13;
         MessageNode.cameraZ = var8 - var14;
         class2.cameraY = var9 - var15;
         Buffer.cameraPitch = var28;
         class39.cameraYaw = var30;
      }

      if(!Client.field534) {
         var28 = class38.method706();
      } else {
         if(class149.field2044.field689) {
            var30 = class171.plane;
         } else {
            var7 = class85.method1686(WidgetNode.cameraX, class2.cameraY, class171.plane);
            if(var7 - MessageNode.cameraZ < 800 && (class10.tileSettings[class171.plane][WidgetNode.cameraX >> 7][class2.cameraY >> 7] & 4) != 0) {
               var30 = class171.plane;
            } else {
               var30 = 3;
            }
         }

         var28 = var30;
      }

      var30 = WidgetNode.cameraX;
      var7 = MessageNode.cameraZ;
      var8 = class2.cameraY;
      var9 = Buffer.cameraPitch;
      var10 = class39.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field535[var11]) {
            var12 = (int)(Math.random() * (double)(1 + 2 * Client.field420[var11]) - (double)Client.field420[var11] + Math.sin((double)Client.field539[var11] * ((double)Client.field538[var11] / 100.0D)) * (double)Client.field393[var11]);
            if(var11 == 0) {
               WidgetNode.cameraX += var12;
            }

            if(var11 == 1) {
               MessageNode.cameraZ += var12;
            }

            if(var11 == 2) {
               class2.cameraY += var12;
            }

            if(var11 == 3) {
               class39.cameraYaw = class39.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               Buffer.cameraPitch += var12;
               if(Buffer.cameraPitch < 128) {
                  Buffer.cameraPitch = 128;
               }

               if(Buffer.cameraPitch > 383) {
                  Buffer.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1794;
      var12 = class115.field1797;
      if(class115.field1802 != 0) {
         var11 = class115.field1803;
         var12 = class115.field1804;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1410 = true;
         Model.field1395 = 0;
         Model.field1392 = var11 - var0;
         Model.field1418 = var12 - var1;
      } else {
         Model.field1410 = false;
         Model.field1395 = 0;
      }

      class115.method2194();
      class219.method3910(var0, var1, var2, var3, 0);
      class115.method2194();
      var13 = class84.field1439;
      class84.field1439 = Client.scale;
      Client.region.method1729(WidgetNode.cameraX, MessageNode.cameraZ, class2.cameraY, Buffer.cameraPitch, class39.cameraYaw, var28);
      class84.field1439 = var13;
      class115.method2194();
      Client.region.method1705();
      Client.field381 = 0;
      boolean var33 = false;
      var15 = -1;
      var16 = class45.field908;
      int[] var31 = class45.field903;

      for(var18 = 0; var18 < Client.field322 + var16; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = Client.cachedPlayers[var31[var18]];
            if(Client.field418 == var31[var18]) {
               var33 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = Client.cachedNPCs[Client.field323[var18 - var16]];
         }

         WidgetNode.method183((Actor)var19, var18, var0, var1, var2, var3);
      }

      if(var33) {
         WidgetNode.method183(Client.cachedPlayers[Client.field418], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field381; ++var18) {
         int var32 = Client.field383[var18];
         int var20 = Client.field384[var18];
         int var21 = Client.field330[var18];
         int var22 = Client.field385[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var29 = 0; var29 < var18; ++var29) {
               if(2 + var20 > Client.field384[var29] - Client.field385[var29] && var20 - var22 < Client.field384[var29] + 2 && var32 - var21 < Client.field383[var29] + Client.field330[var29] && var32 + var21 > Client.field383[var29] - Client.field330[var29] && Client.field384[var29] - Client.field385[var29] < var20) {
                  var20 = Client.field384[var29] - Client.field385[var29];
                  var23 = true;
               }
            }
         }

         Client.field387 = Client.field383[var18];
         Client.field536 = Client.field384[var18] = var20;
         String var24 = Client.field390[var18];
         if(Client.field448 == 0) {
            int var25 = 16776960;
            if(Client.field334[var18] < 6) {
               var25 = Client.field438[Client.field334[var18]];
            }

            if(Client.field334[var18] == 6) {
               var25 = Client.field312 % 20 < 10?16711680:16776960;
            }

            if(Client.field334[var18] == 7) {
               var25 = Client.field312 % 20 < 10?255:'\uffff';
            }

            if(Client.field334[var18] == 8) {
               var25 = Client.field312 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field334[var18] == 9) {
               var26 = 150 - Client.field299[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 1280 * var26;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = '\uff00' + (var26 - 100) * 5;
               }
            }

            if(Client.field334[var18] == 10) {
               var26 = 150 - Client.field299[var18];
               if(var26 < 50) {
                  var25 = 16711680 + var26 * 5;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = 255 + 327680 * (var26 - 100) - (var26 - 100) * 5;
               }
            }

            if(Client.field334[var18] == 11) {
               var26 = 150 - Client.field299[var18];
               if(var26 < 50) {
                  var25 = 16777215 - 327685 * var26;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field530[var18] == 0) {
               class11.field119.method3782(var24, var0 + Client.field387, Client.field536 + var1, var25, 0);
            }

            if(Client.field530[var18] == 1) {
               class11.field119.method3784(var24, var0 + Client.field387, Client.field536 + var1, var25, 0, Client.field312);
            }

            if(Client.field530[var18] == 2) {
               class11.field119.method3849(var24, var0 + Client.field387, var1 + Client.field536, var25, 0, Client.field312);
            }

            if(Client.field530[var18] == 3) {
               class11.field119.method3786(var24, Client.field387 + var0, var1 + Client.field536, var25, 0, Client.field312, 150 - Client.field299[var18]);
            }

            if(Client.field530[var18] == 4) {
               var26 = (150 - Client.field299[var18]) * (class11.field119.method3774(var24) + 100) / 150;
               class219.method3890(var0 + Client.field387 - 50, var1, Client.field387 + var0 + 50, var1 + var3);
               class11.field119.method3779(var24, var0 + Client.field387 + 50 - var26, Client.field536 + var1, var25, 0);
               class219.method3889(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field530[var18] == 5) {
               var26 = 150 - Client.field299[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               class219.method3890(var0, var1 + Client.field536 - class11.field119.field3097 - 1, var0 + var2, Client.field536 + var1 + 5);
               class11.field119.method3782(var24, Client.field387 + var0, var27 + Client.field536 + var1, var25, 0);
               class219.method3889(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class11.field119.method3782(var24, Client.field387 + var0, Client.field536 + var1, 16776960, 0);
         }
      }

      if(Client.field489 == 2) {
         class159.method2992(Client.field335 + (Client.field304 - class15.baseX << 7), (Client.field402 - class20.baseY << 7) + Client.field308, Client.field306 * 2);
         if(Client.field387 > -1 && Client.gameCycle % 20 < 10) {
            class9.field85[0].method4032(Client.field387 + var0 - 12, var1 + Client.field536 - 28);
         }
      }

      ((TextureProvider)class84.field1450).method1419(Client.field364);
      Ignore.method188(var0, var1, var2, var3);
      WidgetNode.cameraX = var30;
      MessageNode.cameraZ = var7;
      class2.cameraY = var8;
      Buffer.cameraPitch = var9;
      class39.cameraYaw = var10;
      if(Client.field292) {
         byte var34 = 0;
         var15 = var34 + class185.field2765 + class185.field2748;
         if(var15 == 0) {
            Client.field292 = false;
         }
      }

      if(Client.field292) {
         class219.method3910(var0, var1, var2, var3, 0);
         Frames.method1868("Loading - please wait.", false);
      }

   }
}
