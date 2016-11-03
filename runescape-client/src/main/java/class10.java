import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class10 extends class110 {
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -480032805
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "2099485574"
   )
   static String method118(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field279 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field279 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field279 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field279 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field279 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != Client.field285) {
         var3 = "/p=" + Client.field285;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field283 + "/a=" + SecondaryBufferProvider.field1430 + var3 + "/";
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1367605779"
   )
   static final void method119(int var0) {
      method122();
      Player.method20();
      int var1 = class26.method606(var0).field1224;
      if(var1 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2163(0.9D);
               ((TextureProvider)class94.field1647).method2241(0.9D);
            }

            if(var2 == 2) {
               class94.method2163(0.8D);
               ((TextureProvider)class94.field1647).method2241(0.8D);
            }

            if(var2 == 3) {
               class94.method2163(0.7D);
               ((TextureProvider)class94.field1647).method2241(0.7D);
            }

            if(var2 == 4) {
               class94.method2163(0.6D);
               ((TextureProvider)class94.field1647).method2241(0.6D);
            }

            class34.method736();
         }

         if(var1 == 3) {
            short var4 = 0;
            if(var2 == 0) {
               var4 = 255;
            }

            if(var2 == 1) {
               var4 = 192;
            }

            if(var2 == 2) {
               var4 = 128;
            }

            if(var2 == 3) {
               var4 = 64;
            }

            if(var2 == 4) {
               var4 = 0;
            }

            if(Client.field433 != var4) {
               if(Client.field433 == 0 && Client.field541 != -1) {
                  class140.method2961(Client.field423, Client.field541, 0, var4, false);
                  Client.field519 = false;
               } else if(var4 == 0) {
                  class186.field3008.method3735();
                  class186.field3007 = 1;
                  class133.field2114 = null;
                  Client.field519 = false;
               } else if(class186.field3007 != 0) {
                  class28.field666 = var4;
               } else {
                  class186.field3008.method3639(var4);
               }

               Client.field433 = var4;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field520 = 127;
            }

            if(var2 == 1) {
               Client.field520 = 96;
            }

            if(var2 == 2) {
               Client.field520 = 64;
            }

            if(var2 == 3) {
               Client.field520 = 32;
            }

            if(var2 == 4) {
               Client.field520 = 0;
            }
         }

         if(var1 == 5) {
            Client.field419 = var2;
         }

         if(var1 == 6) {
            Client.field442 = var2;
         }

         if(var1 == 9) {
            Client.field443 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field518 = 127;
            }

            if(var2 == 1) {
               Client.field518 = 96;
            }

            if(var2 == 2) {
               Client.field518 = 64;
            }

            if(var2 == 3) {
               Client.field518 = 32;
            }

            if(var2 == 4) {
               Client.field518 = 0;
            }
         }

         if(var1 == 17) {
            Client.field315 = var2 & '\uffff';
         }

         class21[] var3;
         if(var1 == 18) {
            var3 = new class21[]{class21.field573, class21.field570, class21.field571, class21.field577};
            Client.field559 = (class21)class77.method1656(var3, var2);
            if(Client.field559 == null) {
               Client.field559 = class21.field577;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field411 = -1;
            } else {
               Client.field411 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var3 = new class21[]{class21.field573, class21.field570, class21.field571, class21.field577};
            Client.field305 = (class21)class77.method1656(var3, var2);
            if(Client.field305 == null) {
               Client.field305 = class21.field577;
            }
         }

      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1991610736"
   )
   static void method121(int var0) {
      class4.field67 = new class32();
      class4.field67.field726 = Client.menuActionParams0[var0];
      class4.field67.field722 = Client.menuActionParams1[var0];
      class4.field67.field721 = Client.menuTypes[var0];
      class4.field67.field724 = Client.menuIdentifiers[var0];
      class4.field67.field725 = Client.menuOptions[var0];
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1623342223"
   )
   static void method122() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3825(); null != var0; var0 = (WidgetNode)Client.componentTable.method3826()) {
         int var1 = var0.id;
         if(class85.method1938(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2815;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class144.method3012(var4);
               if(var5 != null) {
                  class166.method3253(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1544821156"
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
         var1 = Client.field314.method2608();
         var2 = Client.field314.method2606();
         var3 = Client.field314.method2691();
         Sequence.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Sequence.xteaKeys[var4][var5] = Client.field314.method2576();
            }
         }

         class77.mapRegions = new int[var3];
         KitDefinition.field1060 = new int[var3];
         class12.field185 = new int[var3];
         class33.field764 = new byte[var3][];
         class45.field1049 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class77.mapRegions[var3] = var7;
                  KitDefinition.field1060[var3] = class38.field820.method3327("m" + var5 + "_" + var6);
                  class12.field185[var3] = class38.field820.method3327("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class165.method3222(var1, var2);
      } else {
         var1 = Client.field314.method2586();
         var2 = Client.field314.method2691();
         var3 = Client.field314.method2691();
         Client.field314.method2806();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field314.method2807(1);
                  if(var7 == 1) {
                     Client.field334[var4][var5][var6] = Client.field314.method2807(26);
                  } else {
                     Client.field334[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field314.method2827();
         Sequence.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Sequence.xteaKeys[var4][var5] = Client.field314.method2576();
            }
         }

         class77.mapRegions = new int[var3];
         KitDefinition.field1060 = new int[var3];
         class12.field185 = new int[var3];
         class33.field764 = new byte[var3][];
         class45.field1049 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field334[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class77.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class77.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        KitDefinition.field1060[var3] = class38.field820.method3327("m" + var11 + "_" + var12);
                        class12.field185[var3] = class38.field820.method3327("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class165.method3222(var2, var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "609278116"
   )
   static final void method124(int var0, int var1) {
      if(Client.field278 == 2) {
         class77.method1658((Client.field525 - class47.baseX << 7) + Client.field302, Client.field303 + (Client.field300 - class21.baseY << 7), Client.field301 * 2);
         if(Client.field387 > -1 && Client.gameCycle % 20 < 10) {
            XClanMember.field623[0].method1760(Client.field387 + var0 - 12, Client.field333 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "16"
   )
   static String method125(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class177.method3471(RSCanvas.method2970(var1, var2 - 1)) + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class5.field94 != null) {
               var4 = KitDefinition.method962(class5.field94.field2260);
               if(null != class5.field94.field2262) {
                  var4 = (String)class5.field94.field2262;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1416017655"
   )
   public boolean vmethod2444(int var1, int var2, int var3, CollisionData var4) {
      return super.field1938 == var2 && super.field1937 == var3;
   }
}
