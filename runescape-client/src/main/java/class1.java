import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class1 {
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "25"
   )
   static String method4(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1971705737"
   )
   static void method7(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field654[var5]) {
            var2[var4] = World.field654[var5];
            var3[var4] = World.field663[var5];
            ++var4;
         }
      }

      World.field654 = var2;
      World.field663 = var3;
      class56.method1168(World.worldList, 0, World.worldList.length - 1, World.field654, World.field663);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   static final boolean method11() {
      if(class23.field604 == null) {
         return false;
      } else {
         int var13;
         String var16;
         try {
            int var0 = class23.field604.method3013();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class23.field604.method3014(Client.field327.payload, 0, 1);
               Client.field327.offset = 0;
               Client.packetOpcode = Client.field327.method2782();
               Client.field328 = class191.field3098[Client.packetOpcode];
               --var0;
            }

            if(Client.field328 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class23.field604.method3014(Client.field327.payload, 0, 1);
               Client.field328 = Client.field327.payload[0] & 255;
               --var0;
            }

            if(Client.field328 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class23.field604.method3014(Client.field327.payload, 0, 2);
               Client.field327.offset = 0;
               Client.field328 = Client.field327.method2535();
               var0 -= 2;
            }

            if(var0 < Client.field328) {
               return false;
            }

            Client.field327.offset = 0;
            class23.field604.method3014(Client.field327.payload, 0, Client.field328);
            Client.field330 = 0;
            Client.field289 = Client.field333;
            Client.field333 = Client.field326;
            Client.field326 = Client.packetOpcode;
            int var1;
            if(Client.packetOpcode == 160) {
               var1 = Client.field327.method2538();
               WidgetNode var35 = (WidgetNode)Client.componentTable.method3849((long)var1);
               if(var35 != null) {
                  Player.method33(var35, true);
               }

               if(Client.field443 != null) {
                  MessageNode.method750(Client.field443);
                  Client.field443 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 142 || Client.packetOpcode == 149 || Client.packetOpcode == 153 || Client.packetOpcode == 241 || Client.packetOpcode == 107 || Client.packetOpcode == 254 || Client.packetOpcode == 50 || Client.packetOpcode == 229 || Client.packetOpcode == 81 || Client.packetOpcode == 172) {
               XClanMember.method603();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 92) {
               Client.flagX = Client.field327.method2656();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field327.method2656();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var3;
            int var4;
            int var5;
            int var6;
            int var7;
            if(Client.packetOpcode == 32) {
               var1 = Client.field327.method2538();
               var13 = Client.field327.method2535();
               if(var1 < -70000) {
                  var13 += '耀';
               }

               if(var1 >= 0) {
                  var3 = class153.method3170(var1);
               } else {
                  var3 = null;
               }

               if(null != var3) {
                  for(var4 = 0; var4 < var3.itemIds.length; ++var4) {
                     var3.itemIds[var4] = 0;
                     var3.itemQuantities[var4] = 0;
                  }
               }

               Ignore.method93(var13);
               var4 = Client.field327.method2535();

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = Client.field327.method2561();
                  if(var6 == 255) {
                     var6 = Client.field327.method2577();
                  }

                  var7 = Client.field327.method2570();
                  if(null != var3 && var5 < var3.itemIds.length) {
                     var3.itemIds[var5] = var7;
                     var3.itemQuantities[var5] = var6;
                  }

                  Ignore.method96(var13, var5, var7 - 1, var6);
               }

               if(null != var3) {
                  MessageNode.method750(var3);
               }

               Ignore.method94();
               Client.field550[++Client.field468 - 1 & 31] = var13 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            int var14;
            if(Client.packetOpcode == 245) {
               var1 = Client.field327.method2656();
               var13 = Client.field327.method2656();
               var14 = Client.field327.method2656();
               var4 = Client.field327.method2656();
               Client.field439[var1] = true;
               Client.field467[var1] = var13;
               Client.field530[var1] = var14;
               Client.field422[var1] = var4;
               Client.field532[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var54;
            if(Client.packetOpcode == 226) {
               var1 = Client.field327.method2535();
               var13 = Client.field327.method2578();
               var14 = Client.field327.method2677();
               var54 = (WidgetNode)Client.componentTable.method3849((long)var13);
               if(var54 != null) {
                  Player.method33(var54, var1 != var54.id);
               }

               class158.method3188(var13, var1, var14);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 75) {
               class130.field2100 = class23.method593(Client.field327.method2656());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 61) {
               var1 = Client.field327.method2538();
               var13 = Client.field327.method2568();
               class179.settings[var13] = var1;
               if(var1 != class179.widgetSettings[var13]) {
                  class179.widgetSettings[var13] = var1;
               }

               BufferProvider.method1745(var13);
               Client.field465[++Client.field435 - 1 & 31] = var13;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 201) {
               var1 = Client.field327.method2568();
               Client.widgetRoot = var1;
               class8.method109(Client.widgetRoot, class153.field2296, class93.field1616, false);
               class114.method2458(var1);
               class38.method765(Client.widgetRoot);

               for(var13 = 0; var13 < 100; ++var13) {
                  Client.field526[var13] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 193) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(null != Client.cachedPlayers[var1]) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(Client.cachedNPCs[var1] != null) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               Ignore.method94();
               Client.weight = Client.field327.method2633();
               Client.field480 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            long var37;
            long var41;
            long var48;
            boolean var49;
            long var61;
            if(Client.packetOpcode == 221) {
               var16 = Client.field327.method2541();
               var61 = Client.field327.method2539();
               var37 = (long)Client.field327.method2535();
               var41 = (long)Client.field327.method2537();
               class155 var42 = (class155)class168.method3262(class158.method3190(), Client.field327.method2656());
               var48 = (var37 << 32) + var41;
               var49 = false;

               for(int var12 = 0; var12 < 100; ++var12) {
                  if(var48 == Client.field544[var12]) {
                     var49 = true;
                     break;
                  }
               }

               if(var42.field2313 && class8.method104(var16)) {
                  var49 = true;
               }

               if(!var49 && Client.field401 == 0) {
                  Client.field544[Client.field501] = var48;
                  Client.field501 = (1 + Client.field501) % 100;
                  String var60 = class226.method4170(class31.method681(class189.method3797(Client.field327)));
                  if(var42.field2311 != -1) {
                     DecorativeObject.addChatMessage(9, class119.method2476(var42.field2311) + var16, var60, class93.method2128(var61));
                  } else {
                     DecorativeObject.addChatMessage(9, var16, var60, class93.method2128(var61));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 210) {
               var16 = Client.field327.method2541();
               var13 = Client.field327.method2656();
               var14 = Client.field327.method2562();
               if(var13 >= 1 && var13 <= 8) {
                  if(var16.equalsIgnoreCase("null")) {
                     var16 = null;
                  }

                  Client.field408[var13 - 1] = var16;
                  Client.field368[var13 - 1] = var14 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var30;
            if(Client.packetOpcode == 65) {
               var1 = Client.field327.method2538();
               var30 = Client.field327.method2541();
               var3 = class153.method3170(var1);
               if(!var30.equals(var3.text)) {
                  var3.text = var30;
                  MessageNode.method750(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var62;
            if(Client.packetOpcode == 5) {
               var1 = Client.field327.method2569();
               var13 = Client.field327.method2535();
               var14 = Client.field327.method2570();
               var4 = Client.field327.method2578();
               var62 = class153.method3170(var4);
               if(var14 != var62.rotationX || var13 != var62.rotationZ || var1 != var62.field2842) {
                  var62.rotationX = var14;
                  var62.rotationZ = var13;
                  var62.field2842 = var1;
                  MessageNode.method750(var62);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var47;
            if(Client.packetOpcode == 162) {
               var47 = Client.field327.method2656() == 1;
               if(var47) {
                  Client.field558 = class11.method139() - Client.field327.method2539();
                  class13.field193 = new class224(Client.field327, true);
               } else {
                  class13.field193 = null;
               }

               Client.field475 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 220) {
               var1 = Client.field327.method2569();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class14.method160(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               var1 = Client.field327.method2579();
               var13 = Client.field327.method2568();
               if(var13 == '\uffff') {
                  var13 = -1;
               }

               if(Client.field516 != 0 && var13 != -1) {
                  method16(class21.field585, var13, 0, Client.field516, false);
                  Client.field470 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 130) {
               var1 = Client.field327.method2578();
               var13 = Client.field327.method2569();
               var3 = class153.method3170(var1);
               if(var3.modelType != 2 || var3.modelId != var13) {
                  var3.modelType = 2;
                  var3.modelId = var13;
                  MessageNode.method750(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 117) {
               var1 = Client.field327.method2656();
               if(Client.field327.method2656() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field327.offset += 18;
               } else {
                  --Client.field327.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field327, false);
               }

               Client.field474 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 251) {
               RSCanvas.method2965(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 186) {
               Client.field562 = true;
               class43.field985 = Client.field327.method2656();
               class114.field2011 = Client.field327.method2656();
               class139.field2149 = Client.field327.method2535();
               Item.field693 = Client.field327.method2656();
               class134.field2121 = Client.field327.method2656();
               if(class134.field2121 >= 100) {
                  var1 = 64 + class43.field985 * 128;
                  var13 = class114.field2011 * 128 + 64;
                  var14 = Renderable.method1960(var1, var13, XItemContainer.plane) - class139.field2149;
                  var4 = var1 - class139.cameraX;
                  var5 = var14 - class172.cameraZ;
                  var6 = var13 - class77.cameraY;
                  var7 = (int)Math.sqrt((double)(var6 * var6 + var4 * var4));
                  class144.cameraPitch = (int)(Math.atan2((double)var5, (double)var7) * 325.949D) & 2047;
                  Frames.cameraYaw = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                  if(class144.cameraPitch < 128) {
                     class144.cameraPitch = 128;
                  }

                  if(class144.cameraPitch > 383) {
                     class144.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 184) {
               var1 = Client.field327.method2568();
               var13 = Client.field327.method2565();
               var14 = var1 >> 10 & 31;
               var4 = var1 >> 5 & 31;
               var5 = var1 & 31;
               var6 = (var14 << 19) + (var4 << 11) + (var5 << 3);
               Widget var70 = class153.method3170(var13);
               if(var70.textColor != var6) {
                  var70.textColor = var6;
                  MessageNode.method750(var70);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 222) {
               class130.xteaChanged(false);
               Client.field327.method2782();
               var1 = Client.field327.method2535();
               class40.method791(Client.field327, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 231) {
               World var63 = new World();
               var63.address = Client.field327.method2541();
               var63.id = Client.field327.method2535();
               var13 = Client.field327.method2538();
               var63.mask = var13;
               KitDefinition.setGameState(45);
               class23.field604.method3010();
               class23.field604 = null;
               ChatMessages.selectWorld(var63);
               Client.packetOpcode = -1;
               return false;
            }

            int var20;
            if(Client.packetOpcode == 30) {
               var1 = Client.field327.offset + Client.field328;
               var13 = Client.field327.method2535();
               var14 = Client.field327.method2535();
               if(var13 != Client.widgetRoot) {
                  Client.widgetRoot = var13;
                  class8.method109(Client.widgetRoot, class153.field2296, class93.field1616, false);
                  class114.method2458(Client.widgetRoot);
                  class38.method765(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field526[var4] = true;
                  }
               }

               WidgetNode var65;
               for(; var14-- > 0; var65.field61 = true) {
                  var4 = Client.field327.method2538();
                  var5 = Client.field327.method2535();
                  var6 = Client.field327.method2656();
                  var65 = (WidgetNode)Client.componentTable.method3849((long)var4);
                  if(var65 != null && var65.id != var5) {
                     Player.method33(var65, true);
                     var65 = null;
                  }

                  if(null == var65) {
                     var65 = class158.method3188(var4, var5, var6);
                  }
               }

               for(var54 = (WidgetNode)Client.componentTable.method3852(); var54 != null; var54 = (WidgetNode)Client.componentTable.method3857()) {
                  if(var54.field61) {
                     var54.field61 = false;
                  } else {
                     Player.method33(var54, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field327.offset < var1) {
                  var4 = Client.field327.method2538();
                  var5 = Client.field327.method2535();
                  var6 = Client.field327.method2535();
                  var7 = Client.field327.method2538();

                  for(var20 = var5; var20 <= var6; ++var20) {
                     var48 = ((long)var4 << 32) + (long)var20;
                     Client.widgetFlags.method3850(new class204(var7), var48);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var52;
            if(Client.packetOpcode == 250) {
               var1 = Client.field327.method2569();
               var13 = Client.field327.method2578();
               var14 = Client.field327.method2535();
               var52 = class153.method3170(var13);
               var52.field2887 = (var1 << 16) + var14;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               var16 = Client.field327.method2541();
               var30 = class226.method4170(class31.method681(class189.method3797(Client.field327)));
               class190.sendGameMessage(6, var16, var30);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 108) {
               for(var1 = 0; var1 < class56.field1211; ++var1) {
                  class56 var32 = FaceNormal.method1951(var1);
                  if(var32 != null) {
                     class179.settings[var1] = 0;
                     class179.widgetSettings[var1] = 0;
                  }
               }

               Ignore.method94();
               Client.field435 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            String var33;
            boolean var34;
            if(Client.packetOpcode == 102) {
               while(Client.field327.offset < Client.field328) {
                  var47 = Client.field327.method2656() == 1;
                  var30 = Client.field327.method2541();
                  var33 = Client.field327.method2541();
                  var4 = Client.field327.method2535();
                  var5 = Client.field327.method2656();
                  var6 = Client.field327.method2656();
                  boolean var44 = (var6 & 2) != 0;
                  boolean var71 = (var6 & 1) != 0;
                  if(var4 > 0) {
                     Client.field327.method2541();
                     Client.field327.method2656();
                     Client.field327.method2538();
                  }

                  Client.field327.method2541();

                  for(int var45 = 0; var45 < Client.friendCount; ++var45) {
                     Friend var46 = Client.friends[var45];
                     if(!var47) {
                        if(var30.equals(var46.name)) {
                           if(var4 != var46.world) {
                              var49 = true;

                              for(class40 var17 = (class40)Client.field316.method3846(); var17 != null; var17 = (class40)Client.field316.method3839()) {
                                 if(var17.field880.equals(var30)) {
                                    if(var4 != 0 && var17.field878 == 0) {
                                       var17.method3984();
                                       var49 = false;
                                    } else if(var4 == 0 && var17.field878 != 0) {
                                       var17.method3984();
                                       var49 = false;
                                    }
                                 }
                              }

                              if(var49) {
                                 Client.field316.method3837(new class40(var30, var4));
                              }

                              var46.world = var4;
                           }

                           var46.previousName = var33;
                           var46.rank = var5;
                           var46.field246 = var44;
                           var46.field242 = var71;
                           var30 = null;
                           break;
                        }
                     } else if(var33.equals(var46.name)) {
                        var46.name = var30;
                        var46.previousName = var33;
                        var30 = null;
                        break;
                     }
                  }

                  if(var30 != null && Client.friendCount < 400) {
                     Friend var21 = new Friend();
                     Client.friends[Client.friendCount] = var21;
                     var21.name = var30;
                     var21.previousName = var33;
                     var21.world = var4;
                     var21.rank = var5;
                     var21.field246 = var44;
                     var21.field242 = var71;
                     ++Client.friendCount;
                  }
               }

               Client.field494 = 2;
               Client.field472 = Client.field295;
               var47 = false;
               var13 = Client.friendCount;

               while(var13 > 0) {
                  var47 = true;
                  --var13;

                  for(var14 = 0; var14 < var13; ++var14) {
                     var34 = false;
                     Friend var68 = Client.friends[var14];
                     Friend var74 = Client.friends[var14 + 1];
                     if(var68.world != Client.world && Client.world == var74.world) {
                        var34 = true;
                     }

                     if(!var34 && var68.world == 0 && var74.world != 0) {
                        var34 = true;
                     }

                     if(!var34 && !var68.field246 && var74.field246) {
                        var34 = true;
                     }

                     if(!var34 && !var68.field242 && var74.field242) {
                        var34 = true;
                     }

                     if(var34) {
                        Friend var19 = Client.friends[var14];
                        Client.friends[var14] = Client.friends[var14 + 1];
                        Client.friends[var14 + 1] = var19;
                        var47 = false;
                     }
                  }

                  if(var47) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var2;
            if(Client.packetOpcode == 237) {
               var1 = Client.field327.method2538();
               var2 = class153.method3170(var1);

               for(var14 = 0; var14 < var2.itemIds.length; ++var14) {
                  var2.itemIds[var14] = -1;
                  var2.itemIds[var14] = 0;
               }

               MessageNode.method750(var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 192) {
               var1 = Client.field327.method2578();
               var13 = Client.field327.method2535();
               if(var13 == '\uffff') {
                  var13 = -1;
               }

               var14 = Client.field327.method2577();
               var52 = class153.method3170(var14);
               ItemComposition var67;
               if(!var52.field2787) {
                  if(var13 == -1) {
                     var52.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var67 = class45.getItemDefinition(var13);
                  var52.modelType = 4;
                  var52.modelId = var13;
                  var52.rotationX = var67.field1184;
                  var52.rotationZ = var67.field1174;
                  var52.field2842 = var67.field1166 * 100 / var1;
                  MessageNode.method750(var52);
               } else {
                  var52.item = var13;
                  var52.stackSize = var1;
                  var67 = class45.getItemDefinition(var13);
                  var52.rotationX = var67.field1184;
                  var52.rotationZ = var67.field1174;
                  var52.rotationY = var67.field1198;
                  var52.field2837 = var67.field1170;
                  var52.field2860 = var67.field1171;
                  var52.field2842 = var67.field1166;
                  if(var67.isStackable == 1) {
                     var52.field2846 = 1;
                  } else {
                     var52.field2846 = 2;
                  }

                  if(var52.field2844 > 0) {
                     var52.field2842 = var52.field2842 * 32 / var52.field2844;
                  } else if(var52.field2799 > 0) {
                     var52.field2842 = var52.field2842 * 32 / var52.field2799;
                  }

                  MessageNode.method750(var52);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 141) {
               Client.field457 = Client.field327.method2568() * 30;
               Client.field480 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var38;
            if(Client.packetOpcode == 90) {
               var16 = Client.field327.method2541();
               var13 = Client.field327.method2535();
               byte var58 = Client.field327.method2534();
               var34 = false;
               if(var58 == -128) {
                  var34 = true;
               }

               if(var34) {
                  if(XItemContainer.field224 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var38 = false;

                  for(var5 = 0; var5 < XItemContainer.field224 && (!TextureProvider.clanMembers[var5].username.equals(var16) || TextureProvider.clanMembers[var5].world != var13); ++var5) {
                     ;
                  }

                  if(var5 < XItemContainer.field224) {
                     while(var5 < XItemContainer.field224 - 1) {
                        TextureProvider.clanMembers[var5] = TextureProvider.clanMembers[var5 + 1];
                        ++var5;
                     }

                     --XItemContainer.field224;
                     TextureProvider.clanMembers[XItemContainer.field224] = null;
                  }
               } else {
                  Client.field327.method2541();
                  XClanMember var66 = new XClanMember();
                  var66.username = var16;
                  var66.field631 = class47.method967(var66.username, RSCanvas.field2188);
                  var66.world = var13;
                  var66.rank = var58;

                  for(var6 = XItemContainer.field224 - 1; var6 >= 0; --var6) {
                     var7 = TextureProvider.clanMembers[var6].field631.compareTo(var66.field631);
                     if(var7 == 0) {
                        TextureProvider.clanMembers[var6].world = var13;
                        TextureProvider.clanMembers[var6].rank = var58;
                        if(var16.equals(class34.localPlayer.name)) {
                           WallObject.field1592 = var58;
                        }

                        Client.field281 = Client.field295;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(XItemContainer.field224 >= TextureProvider.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var7 = XItemContainer.field224 - 1; var7 > var6; --var7) {
                     TextureProvider.clanMembers[var7 + 1] = TextureProvider.clanMembers[var7];
                  }

                  if(XItemContainer.field224 == 0) {
                     TextureProvider.clanMembers = new XClanMember[100];
                  }

                  TextureProvider.clanMembers[var6 + 1] = var66;
                  ++XItemContainer.field224;
                  if(var16.equals(class34.localPlayer.name)) {
                     WallObject.field1592 = var58;
                  }
               }

               Client.field281 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 2) {
               Client.field369 = Client.field327.method2656();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 76) {
               var1 = Client.field327.method2565();
               var13 = Client.field327.method2569();
               if(var13 == '\uffff') {
                  var13 = -1;
               }

               var14 = Client.field327.method2568();
               if(var14 == '\uffff') {
                  var14 = -1;
               }

               var4 = Client.field327.method2578();

               for(var5 = var14; var5 <= var13; ++var5) {
                  var41 = ((long)var4 << 32) + (long)var5;
                  Node var8 = Client.widgetFlags.method3849(var41);
                  if(var8 != null) {
                     var8.unlink();
                  }

                  Client.widgetFlags.method3850(new class204(var1), var41);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 249) {
               class40.method791(Client.field327, Client.field328);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 216) {
               var16 = Client.field327.method2541();
               Object[] var29 = new Object[var16.length() + 1];

               for(var14 = var16.length() - 1; var14 >= 0; --var14) {
                  if(var16.charAt(var14) == 115) {
                     var29[1 + var14] = Client.field327.method2541();
                  } else {
                     var29[1 + var14] = new Integer(Client.field327.method2538());
                  }
               }

               var29[0] = new Integer(Client.field327.method2538());
               class0 var43 = new class0();
               var43.field1 = var29;
               class112.method2452(var43);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 181) {
               var47 = Client.field327.method2561() == 1;
               var13 = Client.field327.method2565();
               var3 = class153.method3170(var13);
               if(var47 != var3.isHidden) {
                  var3.isHidden = var47;
                  MessageNode.method750(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 200) {
               class85.field1487 = Client.field327.method2561();
               ChatMessages.field274 = Client.field327.method2562();

               while(Client.field327.offset < Client.field328) {
                  Client.packetOpcode = Client.field327.method2656();
                  XClanMember.method603();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 214) {
               var1 = Client.field327.method2650();
               var13 = Client.field327.method2577();
               var3 = class153.method3170(var13);
               if(var3.field2835 != var1 || var1 == -1) {
                  var3.field2835 = var1;
                  var3.field2910 = 0;
                  var3.field2911 = 0;
                  MessageNode.method750(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               class153.method3171(Client.field327, Client.field328);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 112) {
               Client.field562 = true;
               class181.field2950 = Client.field327.method2656();
               class180.field2946 = Client.field327.method2656();
               class128.field2093 = Client.field327.method2535();
               BufferProvider.field1447 = Client.field327.method2656();
               class181.field2953 = Client.field327.method2656();
               if(class181.field2953 >= 100) {
                  class139.cameraX = 64 + class181.field2950 * 128;
                  class77.cameraY = class180.field2946 * 128 + 64;
                  class172.cameraZ = Renderable.method1960(class139.cameraX, class77.cameraY, XItemContainer.plane) - class128.field2093;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var56;
            if(Client.packetOpcode == 62) {
               while(Client.field327.offset < Client.field328) {
                  var1 = Client.field327.method2656();
                  var56 = (var1 & 1) == 1;
                  var33 = Client.field327.method2541();
                  String var55 = Client.field327.method2541();
                  Client.field327.method2541();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var73 = Client.ignores[var5];
                     if(var56) {
                        if(var55.equals(var73.name)) {
                           var73.name = var33;
                           var73.previousName = var55;
                           var33 = null;
                           break;
                        }
                     } else if(var33.equals(var73.name)) {
                        var73.name = var33;
                        var73.previousName = var55;
                        var33 = null;
                        break;
                     }
                  }

                  if(var33 != null && Client.ignoreCount < 400) {
                     Ignore var64 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var64;
                     var64.name = var33;
                     var64.previousName = var55;
                     ++Client.ignoreCount;
                  }
               }

               Client.field472 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 46) {
               class85.field1487 = Client.field327.method2677();
               ChatMessages.field274 = Client.field327.method2561();

               for(var1 = class85.field1487; var1 < class85.field1487 + 8; ++var1) {
                  for(var13 = ChatMessages.field274; var13 < ChatMessages.field274 + 8; ++var13) {
                     if(Client.groundItemDeque[XItemContainer.plane][var1][var13] != null) {
                        Client.groundItemDeque[XItemContainer.plane][var1][var13] = null;
                        class23.groundItemSpawned(var1, var13);
                     }
                  }
               }

               for(class16 var59 = (class16)Client.field413.method3890(); var59 != null; var59 = (class16)Client.field413.method3892()) {
                  if(var59.field229 >= class85.field1487 && var59.field229 < 8 + class85.field1487 && var59.field230 >= ChatMessages.field274 && var59.field230 < 8 + ChatMessages.field274 && var59.field234 == XItemContainer.plane) {
                     var59.field238 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 34) {
               var1 = Client.field327.method2535();
               var13 = Client.field327.method2656();
               var14 = Client.field327.method2535();
               Player.method39(var1, var13, var14);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 152) {
               var16 = Client.field327.method2541();
               var61 = (long)Client.field327.method2535();
               var37 = (long)Client.field327.method2537();
               class155 var72 = (class155)class168.method3262(class158.method3190(), Client.field327.method2656());
               long var40 = var37 + (var61 << 32);
               boolean var9 = false;

               for(int var75 = 0; var75 < 100; ++var75) {
                  if(var40 == Client.field544[var75]) {
                     var9 = true;
                     break;
                  }
               }

               if(class8.method104(var16)) {
                  var9 = true;
               }

               if(!var9 && Client.field401 == 0) {
                  Client.field544[Client.field501] = var40;
                  Client.field501 = (Client.field501 + 1) % 100;
                  String var10 = class226.method4170(class31.method681(class189.method3797(Client.field327)));
                  byte var11;
                  if(var72.field2312) {
                     var11 = 7;
                  } else {
                     var11 = 3;
                  }

                  if(var72.field2311 != -1) {
                     class190.sendGameMessage(var11, class119.method2476(var72.field2311) + var16, var10);
                  } else {
                     class190.sendGameMessage(var11, var16, var10);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 154) {
               class85.field1487 = Client.field327.method2656();
               ChatMessages.field274 = Client.field327.method2562();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 4) {
               var1 = Client.field327.method2565();
               var13 = Client.field327.method2578();
               WidgetNode var39 = (WidgetNode)Client.componentTable.method3849((long)var13);
               var54 = (WidgetNode)Client.componentTable.method3849((long)var1);
               if(null != var54) {
                  Player.method33(var54, null == var39 || var54.id != var39.id);
               }

               if(null != var39) {
                  var39.unlink();
                  Client.componentTable.method3850(var39, (long)var1);
               }

               var62 = class153.method3170(var13);
               if(var62 != null) {
                  MessageNode.method750(var62);
               }

               var62 = class153.method3170(var1);
               if(null != var62) {
                  MessageNode.method750(var62);
                  class174.method3428(Widget.widgets[var62.id >>> 16], var62, true);
               }

               if(Client.widgetRoot != -1) {
                  class13.method152(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 138) {
               var1 = Client.field327.method2535();
               var13 = Client.field327.method2577();
               var3 = class153.method3170(var13);
               if(null != var3 && var3.type == 0) {
                  if(var1 > var3.scrollHeight - var3.height) {
                     var1 = var3.scrollHeight - var3.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var3.scrollY != var1) {
                     var3.scrollY = var1;
                     MessageNode.method750(var3);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 33) {
               Client.field562 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field439[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 196) {
               if(Client.widgetRoot != -1) {
                  class13.method152(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 175) {
               var1 = Client.field327.method2578();
               var13 = Client.field327.method2570();
               var3 = class153.method3170(var1);
               if(var3.modelType != 1 || var3.modelId != var13) {
                  var3.modelType = 1;
                  var3.modelId = var13;
                  MessageNode.method750(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 72) {
               RSCanvas.method2965(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 137) {
               class5.method76();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 89) {
               var1 = Client.field327.method2538();
               var13 = Client.field327.method2538();
               if(ItemComposition.field1205 == null || !ItemComposition.field1205.isValid()) {
                  try {
                     Iterator var36 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var36.hasNext()) {
                        GarbageCollectorMXBean var53 = (GarbageCollectorMXBean)var36.next();
                        if(var53.isValid()) {
                           ItemComposition.field1205 = var53;
                           Client.field535 = -1L;
                           Client.field557 = -1L;
                        }
                     }
                  } catch (Throwable var26) {
                     ;
                  }
               }

               long var50 = class11.method139();
               var5 = -1;
               if(null != ItemComposition.field1205) {
                  var41 = ItemComposition.field1205.getCollectionTime();
                  if(Client.field557 != -1L) {
                     long var69 = var41 - Client.field557;
                     long var23 = var50 - Client.field535;
                     if(0L != var23) {
                        var5 = (int)(var69 * 100L / var23);
                     }
                  }

                  Client.field557 = var41;
                  Client.field535 = var50;
               }

               Client.field397.method2768(255);
               Client.field397.method2558(GameEngine.FPS);
               Client.field397.method2574(var1);
               Client.field397.method2521(var13);
               Client.field397.method2518(var5);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 128) {
               class12.method147();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               XClanMember.method604(Client.field327);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 195) {
               var1 = Client.field327.method2546();
               var56 = Client.field327.method2656() == 1;
               var33 = "";
               var34 = false;
               if(var56) {
                  var33 = Client.field327.method2541();
                  if(class8.method104(var33)) {
                     var34 = true;
                  }
               }

               String var18 = Client.field327.method2541();
               if(!var34) {
                  class190.sendGameMessage(var1, var33, var18);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 58) {
               Client.field497 = Client.field327.method2656();
               Client.field324 = Client.field327.method2656();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 169) {
               var1 = Client.field327.method2577();
               var13 = Client.field327.method2633();
               var14 = Client.field327.method2650();
               var52 = class153.method3170(var1);
               if(var13 != var52.field2797 || var14 != var52.field2798 || var52.field2793 != 0 || var52.field2794 != 0) {
                  var52.field2797 = var13;
                  var52.field2798 = var14;
                  var52.field2793 = 0;
                  var52.field2794 = 0;
                  MessageNode.method750(var52);
                  class14.method157(var52);
                  if(var52.type == 0) {
                     class174.method3428(Widget.widgets[var1 >> 16], var52, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 93) {
               class130.xteaChanged(true);
               Client.field327.method2782();
               var1 = Client.field327.method2535();
               class40.method791(Client.field327, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 25) {
               Ignore.method94();
               Client.energy = Client.field327.method2656();
               Client.field480 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 147) {
               Ignore.method94();
               var1 = Client.field327.method2565();
               var13 = Client.field327.method2562();
               var14 = Client.field327.method2677();
               Client.skillExperiences[var13] = var1;
               Client.boostedSkillLevels[var13] = var14;
               Client.realSkillLevels[var13] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var1 >= class158.field2340[var4]) {
                     Client.realSkillLevels[var13] = var4 + 2;
                  }
               }

               Client.field469[++Client.field444 - 1 & 31] = var13;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 208) {
               Client.field327.offset += 28;
               if(Client.field327.method2556()) {
                  class125 var57 = Client.field327;
                  var13 = Client.field327.offset - 28;
                  if(null != class152.field2275) {
                     try {
                        class152.field2275.method4212(0L);
                        class152.field2275.method4222(var57.payload, var13, 24);
                     } catch (Exception var25) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 67) {
               Client.field494 = 1;
               Client.field472 = Client.field295;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               Client.field298 = Client.field327.method2656();
               if(Client.field298 == 1) {
                  Client.field278 = Client.field327.method2535();
               }

               if(Client.field298 >= 2 && Client.field298 <= 6) {
                  if(Client.field298 == 2) {
                     Client.field304 = 64;
                     Client.field279 = 64;
                  }

                  if(Client.field298 == 3) {
                     Client.field304 = 0;
                     Client.field279 = 64;
                  }

                  if(Client.field298 == 4) {
                     Client.field304 = 128;
                     Client.field279 = 64;
                  }

                  if(Client.field298 == 5) {
                     Client.field304 = 64;
                     Client.field279 = 0;
                  }

                  if(Client.field298 == 6) {
                     Client.field304 = 64;
                     Client.field279 = 128;
                  }

                  Client.field298 = 2;
                  Client.field353 = Client.field327.method2535();
                  Client.field357 = Client.field327.method2535();
                  Client.field303 = Client.field327.method2656();
               }

               if(Client.field298 == 10) {
                  Client.field533 = Client.field327.method2535();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 123) {
               class40.method788(Client.field327.method2541());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 189) {
               var1 = Client.field327.method2538();
               var2 = class153.method3170(var1);
               var2.modelType = 3;
               var2.modelId = class34.localPlayer.composition.method3547();
               MessageNode.method750(var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 180) {
               Client.field281 = Client.field295;
               if(Client.field328 == 0) {
                  Client.field506 = null;
                  Client.field507 = null;
                  XItemContainer.field224 = 0;
                  TextureProvider.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field507 = Client.field327.method2541();
               long var31 = Client.field327.method2539();
               Client.field506 = class12.method142(var31);
               ObjectComposition.field970 = Client.field327.method2534();
               var14 = Client.field327.method2656();
               if(var14 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               XItemContainer.field224 = var14;
               XClanMember[] var15 = new XClanMember[100];

               for(var5 = 0; var5 < XItemContainer.field224; ++var5) {
                  var15[var5] = new XClanMember();
                  var15[var5].username = Client.field327.method2541();
                  var15[var5].field631 = class47.method967(var15[var5].username, RSCanvas.field2188);
                  var15[var5].world = Client.field327.method2535();
                  var15[var5].rank = Client.field327.method2534();
                  Client.field327.method2541();
                  if(var15[var5].username.equals(class34.localPlayer.name)) {
                     WallObject.field1592 = var15[var5].rank;
                  }
               }

               var38 = false;
               var7 = XItemContainer.field224;

               while(var7 > 0) {
                  var38 = true;
                  --var7;

                  for(var20 = 0; var20 < var7; ++var20) {
                     if(var15[var20].field631.compareTo(var15[var20 + 1].field631) > 0) {
                        XClanMember var22 = var15[var20];
                        var15[var20] = var15[1 + var20];
                        var15[1 + var20] = var22;
                        var38 = false;
                     }
                  }

                  if(var38) {
                     break;
                  }
               }

               TextureProvider.clanMembers = var15;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 12) {
               var1 = Client.field327.method2565();
               class20.field567 = class54.field1146.method2911(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               var1 = Client.field327.method2569();
               byte var51 = Client.field327.method2726();
               class179.settings[var1] = var51;
               if(class179.widgetSettings[var1] != var51) {
                  class179.widgetSettings[var1] = var51;
               }

               BufferProvider.method1745(var1);
               Client.field465[++Client.field435 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 178) {
               for(var1 = 0; var1 < class179.widgetSettings.length; ++var1) {
                  if(class179.settings[var1] != class179.widgetSettings[var1]) {
                     class179.widgetSettings[var1] = class179.settings[var1];
                     BufferProvider.method1745(var1);
                     Client.field465[++Client.field435 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 73) {
               var1 = Client.field327.method2538();
               var13 = Client.field327.method2535();
               if(var1 < -70000) {
                  var13 += '耀';
               }

               if(var1 >= 0) {
                  var3 = class153.method3170(var1);
               } else {
                  var3 = null;
               }

               for(; Client.field327.offset < Client.field328; Ignore.method96(var13, var4, var5 - 1, var6)) {
                  var4 = Client.field327.method2546();
                  var5 = Client.field327.method2535();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = Client.field327.method2656();
                     if(var6 == 255) {
                        var6 = Client.field327.method2538();
                     }
                  }

                  if(var3 != null && var4 >= 0 && var4 < var3.itemIds.length) {
                     var3.itemIds[var4] = var5;
                     var3.itemQuantities[var4] = var6;
                  }
               }

               if(null != var3) {
                  MessageNode.method750(var3);
               }

               Ignore.method94();
               Client.field550[++Client.field468 - 1 & 31] = var13 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 209) {
               var1 = Client.field327.method2568();
               ObjectComposition.method855(var1);
               Client.field550[++Client.field468 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            Frames.method2316("" + Client.packetOpcode + "," + Client.field333 + "," + Client.field289 + "," + Client.field328, (Throwable)null);
            class5.method76();
         } catch (IOException var27) {
            class56.method1159();
         } catch (Exception var28) {
            var16 = "" + Client.packetOpcode + "," + Client.field333 + "," + Client.field289 + "," + Client.field328 + "," + (class34.localPlayer.pathX[0] + class32.baseX) + "," + (class8.baseY + class34.localPlayer.pathY[0]) + ",";

            for(var13 = 0; var13 < Client.field328 && var13 < 50; ++var13) {
               var16 = var16 + Client.field327.payload[var13] + ",";
            }

            Frames.method2316(var16, var28);
            class5.method76();
         }

         return true;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1202570989"
   )
   static final boolean method12(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LSpritePixels;",
      garbageValue = "-1496766245"
   )
   public static SpritePixels method14(class170 var0, int var1, int var2) {
      byte[] var4 = var0.method3304(var1, var2);
      boolean var3;
      if(var4 == null) {
         var3 = false;
      } else {
         class13.method154(var4);
         var3 = true;
      }

      return !var3?null:SecondaryBufferProvider.method1694();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-131649890"
   )
   public static void method15() {
      if(null != class140.keyboard) {
         class140 var0 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "1535012354"
   )
   public static void method16(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3005 = 1;
      class186.field2996 = var0;
      class186.field2997 = var1;
      class175.field2777 = var2;
      class186.field2999 = var3;
      class186.field2992 = var4;
      class186.field3002 = 10000;
   }
}
