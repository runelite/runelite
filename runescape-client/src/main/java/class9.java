import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public final class class9 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1817019611
   )
   static int field70;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -277301171
   )
   static int field73;
   @ObfuscatedName("bm")
   static class184 field75;
   @ObfuscatedName("qj")
   protected static class109 field77;
   @ObfuscatedName("o")
   public static class145 field78;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   static final void method100() {
      try {
         if(Client.field514 == 0) {
            if(class6.field46 != null) {
               class6.field46.method2027();
               class6.field46 = null;
            }

            ChatMessages.field926 = null;
            Client.field341 = false;
            Client.field322 = 0;
            Client.field514 = 1;
         }

         if(Client.field514 == 1) {
            if(ChatMessages.field926 == null) {
               ChatMessages.field926 = Tile.field1346.method1918(class139.host, class206.field3087);
            }

            if(ChatMessages.field926.field1664 == 2) {
               throw new IOException();
            }

            if(ChatMessages.field926.field1664 == 1) {
               class6.field46 = new class110((Socket)ChatMessages.field926.field1662, Tile.field1346);
               ChatMessages.field926 = null;
               Client.field514 = 2;
            }
         }

         if(Client.field514 == 2) {
            Client.field330.offset = 0;
            Client.field330.method2815(14);
            class6.field46.method2016(Client.field330.payload, 0, 1);
            Client.field332.offset = 0;
            Client.field514 = 3;
         }

         int var0;
         if(Client.field514 == 3) {
            if(null != class88.field1527) {
               class88.field1527.method1021();
            }

            if(class8.field62 != null) {
               class8.field62.method1021();
            }

            var0 = class6.field46.method2013();
            if(class88.field1527 != null) {
               class88.field1527.method1021();
            }

            if(class8.field62 != null) {
               class8.field62.method1021();
            }

            if(var0 != 0) {
               GroundObject.method1507(var0);
               return;
            }

            Client.field332.offset = 0;
            Client.field514 = 5;
         }

         int var1;
         int var2;
         if(Client.field514 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field330.offset = 0;
            Client.field330.method2815(1);
            Client.field330.method2815(class41.field844.vmethod3989());
            Client.field330.method2714(var7[0]);
            Client.field330.method2714(var7[1]);
            Client.field330.method2714(var7[2]);
            Client.field330.method2714(var7[3]);
            switch(class41.field844.field1626) {
            case 0:
            case 2:
               Client.field330.method2713(class206.field3091);
               Client.field330.offset += 5;
               break;
            case 1:
               Client.field330.method2714(((Integer)XGrandExchangeOffer.field35.field706.get(Integer.valueOf(Friend.method172(class41.username)))).intValue());
               Client.field330.offset += 4;
               break;
            case 3:
               Client.field330.offset += 8;
            }

            Client.field330.method2717(class41.field850);
            Client.field330.method2747(class39.field813, class39.field814);
            Client.field331.offset = 0;
            if(Client.gameState == 40) {
               Client.field331.method2815(18);
            } else {
               Client.field331.method2815(16);
            }

            Client.field331.method2712(0);
            var1 = Client.field331.offset;
            Client.field331.method2714(128);
            Client.field331.method2813(Client.field330.payload, 0, Client.field330.offset);
            var2 = Client.field331.offset;
            Client.field331.method2717(class41.username);
            Client.field331.method2815((Client.isResized?1:0) << 1 | (Client.field314?1:0));
            Client.field331.method2712(TextureProvider.field1200);
            Client.field331.method2712(class94.field1584);
            class159 var3 = Client.field331;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class104.field1687.method1353(0L);
               class104.field1687.method1381(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2813(var4, 0, 24);
            Client.field331.method2717(class112.field1776);
            Client.field331.method2714(Ignore.field215);
            Buffer var17 = new Buffer(class118.field1854.method4174());
            class118.field1854.method4175(var17);
            Client.field331.method2813(var17.payload, 0, var17.payload.length);
            Client.field331.method2815(class228.field3240);
            Client.field331.method2714(class45.field915.field2728);
            Client.field331.method2714(class18.field192.field2728);
            Client.field331.method2714(class165.field2178.field2728);
            Client.field331.method2714(field75.field2728);
            Client.field331.method2714(class103.field1665.field2728);
            Client.field331.method2714(ChatLineBuffer.field970.field2728);
            Client.field331.method2714(class119.field1864.field2728);
            Client.field331.method2714(class217.field3168.field2728);
            Client.field331.method2714(class206.field3086.field2728);
            Client.field331.method2714(class13.field142.field2728);
            Client.field331.method2714(class25.field587.field2728);
            Client.field331.method2714(Friend.field160.field2728);
            Client.field331.method2714(CombatInfo2.field2844.field2728);
            Client.field331.method2714(class45.field907.field2728);
            Client.field331.method2714(class204.field3076.field2728);
            Client.field331.method2714(class25.field583.field2728);
            Client.field331.method2745(var7, var2, Client.field331.offset);
            Client.field331.method2722(Client.field331.offset - var1);
            class6.field46.method2016(Client.field331.payload, 0, Client.field331.offset);
            Client.field330.method2975(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field332.method2975(var7);
            Client.field514 = 6;
         }

         if(Client.field514 == 6 && class6.field46.method2014() > 0) {
            var0 = class6.field46.method2013();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field514 = 7;
            } else if(var0 == 2) {
               Client.field514 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field523 = -1;
               Client.field514 = 13;
            } else if(var0 == 23 && Client.field323 < 1) {
               ++Client.field323;
               Client.field514 = 0;
            } else {
               if(var0 != 29) {
                  GroundObject.method1507(var0);
                  return;
               }

               Client.field514 = 11;
            }
         }

         if(Client.field514 == 7 && class6.field46.method2014() > 0) {
            Client.field372 = (class6.field46.method2013() + 3) * 60;
            Client.field514 = 8;
         }

         if(Client.field514 == 8) {
            Client.field322 = 0;
            class47.method861("You have only just left another world.", "Your profile will be transferred in:", Client.field372 / 60 + " seconds.");
            if(--Client.field372 <= 0) {
               Client.field514 = 0;
            }

         } else {
            if(Client.field514 == 9 && class6.field46.method2014() >= 13) {
               boolean var14 = class6.field46.method2013() == 1;
               class6.field46.method2015(Client.field332.payload, 0, 4);
               Client.field332.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field332.method2968() << 24;
                  var1 |= Client.field332.method2968() << 16;
                  var1 |= Client.field332.method2968() << 8;
                  var1 |= Client.field332.method2968();
                  var2 = Friend.method172(class41.username);
                  if(XGrandExchangeOffer.field35.field706.size() >= 10 && !XGrandExchangeOffer.field35.field706.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = XGrandExchangeOffer.field35.field706.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  XGrandExchangeOffer.field35.field706.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class119.method2234();
               }

               Client.field451 = class6.field46.method2013();
               Client.field453 = class6.field46.method2013() == 1;
               Client.localInteractingIndex = class6.field46.method2013();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class6.field46.method2013();
               Client.field409 = class6.field46.method2013();
               class6.field46.method2015(Client.field332.payload, 0, 1);
               Client.field332.offset = 0;
               Client.packetOpcode = Client.field332.method2968();
               class6.field46.method2015(Client.field332.payload, 0, 2);
               Client.field332.offset = 0;
               Client.field523 = Client.field332.readUnsignedShort();

               try {
                  class100.method1902(Client.field540, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field514 = 10;
            }

            if(Client.field514 != 10) {
               if(Client.field514 == 11 && class6.field46.method2014() >= 2) {
                  Client.field332.offset = 0;
                  class6.field46.method2015(Client.field332.payload, 0, 2);
                  Client.field332.offset = 0;
                  class165.field2174 = Client.field332.readUnsignedShort();
                  Client.field514 = 12;
               }

               if(Client.field514 == 12 && class6.field46.method2014() >= class165.field2174) {
                  Client.field332.offset = 0;
                  class6.field46.method2015(Client.field332.payload, 0, class165.field2174);
                  Client.field332.offset = 0;
                  String var19 = Client.field332.method2780();
                  String var20 = Client.field332.method2780();
                  String var9 = Client.field332.method2780();
                  class47.method861(var19, var20, var9);
                  class20.setGameState(10);
               }

               if(Client.field514 == 13) {
                  if(Client.field523 == -1) {
                     if(class6.field46.method2014() < 2) {
                        return;
                     }

                     class6.field46.method2015(Client.field332.payload, 0, 2);
                     Client.field332.offset = 0;
                     Client.field523 = Client.field332.readUnsignedShort();
                  }

                  if(class6.field46.method2014() >= Client.field523) {
                     class6.field46.method2015(Client.field332.payload, 0, Client.field523);
                     Client.field332.offset = 0;
                     var0 = Client.field523;
                     class2.method26();
                     class41.method764(Client.field332);
                     if(var0 != Client.field332.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field322;
                  if(Client.field322 > 2000) {
                     if(Client.field323 < 1) {
                        if(MessageNode.field237 == class206.field3087) {
                           class206.field3087 = class38.field812;
                        } else {
                           class206.field3087 = MessageNode.field237;
                        }

                        ++Client.field323;
                        Client.field514 = 0;
                     } else {
                        GroundObject.method1507(-3);
                     }
                  }
               }
            } else {
               if(class6.field46.method2014() >= Client.field523) {
                  Client.field332.offset = 0;
                  class6.field46.method2015(Client.field332.payload, 0, Client.field523);
                  Client.field299 = -1L;
                  Client.field543 = -1;
                  World.field695.field224 = 0;
                  Player.field270 = true;
                  Client.field350 = true;
                  Client.field406 = -1L;
                  class227.field3228 = new CombatInfoList();
                  Client.field330.offset = 0;
                  Client.field332.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field337 = -1;
                  Client.field410 = -1;
                  Client.field339 = -1;
                  Client.field335 = 0;
                  Client.field305 = 0;
                  Client.field340 = 0;
                  Client.field306 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class15.method177(0);
                  class47.chatLineMap.clear();
                  class47.field945.method2260();
                  class47.field939.method2408();
                  class47.field940 = 0;
                  Client.field437 = 0;
                  Client.field439 = false;
                  Client.field526 = 0;
                  Client.field505 = (int)(Math.random() * 100.0D) - 50;
                  Client.field515 = (int)(Math.random() * 110.0D) - 55;
                  Client.field365 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field520 = 0;
                  Client.field513 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field376 = class40.field824;
                  Client.field315 = class40.field824;
                  Client.field492 = 0;
                  class195.method3470();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field416 = -1;
                  Client.projectiles.method2348();
                  Client.field511.method2348();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field300 = new Deque();
                  Client.field312 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class150.field2057; ++var0) {
                     class187 var10 = class177.method3187(var0);
                     if(var10 != null) {
                        class165.settings[var0] = 0;
                        class165.widgetSettings[var0] = 0;
                     }
                  }

                  class109.chatMessages.method826();
                  Client.field452 = -1;
                  if(Client.widgetRoot != -1) {
                     class44.method792(Client.widgetRoot);
                  }

                  for(WidgetNode var18 = (WidgetNode)Client.componentTable.method2296(); null != var18; var18 = (WidgetNode)Client.componentTable.method2300()) {
                     class44.method783(var18, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field448 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field495.method3060((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field413[var0] = null;
                     Client.field373[var0] = false;
                  }

                  class45.method802();
                  Client.field297 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field308[var0] = true;
                  }

                  class1.method12();
                  Client.field290 = null;
                  class177.field2678 = 0;
                  class110.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class109.field1748 = null;
                  class41.method764(Client.field332);
                  class7.field54 = -1;
                  class38.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            }
         }
      } catch (IOException var13) {
         if(Client.field323 < 1) {
            if(class206.field3087 == MessageNode.field237) {
               class206.field3087 = class38.field812;
            } else {
               class206.field3087 = MessageNode.field237;
            }

            ++Client.field323;
            Client.field514 = 0;
         } else {
            GroundObject.method1507(-2);
         }
      }
   }
}
