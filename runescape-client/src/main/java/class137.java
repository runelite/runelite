import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("er")
public class class137 {
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1939447479
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("l")
   byte[] field1898;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1024275963
   )
   int field1899;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1279657727
   )
   int field1900;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -839027437
   )
   int field1901;
   @ObfuscatedName("b")
   byte[] field1902;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1711547373
   )
   int field1904;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 332301369
   )
   int field1905;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1128877757
   )
   int field1907;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1240401031
   )
   static int field1908;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 356299893
   )
   int field1911;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "604529939"
   )
   public static void method2534() {
      PlayerComposition.field2169.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1136273282"
   )
   static final void method2536() {
      try {
         if(Client.field317 == 0) {
            if(class5.field46 != null) {
               class5.field46.method2109();
               class5.field46 = null;
            }

            Varbit.field2856 = null;
            Client.field338 = false;
            Client.field318 = 0;
            Client.field317 = 1;
         }

         if(Client.field317 == 1) {
            if(null == Varbit.field2856) {
               Varbit.field2856 = class25.field579.method2020(class105.host, class31.field713);
            }

            if(Varbit.field2856.field1655 == 2) {
               throw new IOException();
            }

            if(Varbit.field2856.field1655 == 1) {
               class5.field46 = new class110((Socket)Varbit.field2856.field1659, class25.field579);
               Varbit.field2856 = null;
               Client.field317 = 2;
            }
         }

         if(Client.field317 == 2) {
            Client.field327.offset = 0;
            Client.field327.method3010(14);
            class5.field46.method2114(Client.field327.payload, 0, 1);
            Client.field329.offset = 0;
            Client.field317 = 3;
         }

         int var0;
         if(Client.field317 == 3) {
            if(null != class3.field30) {
               class3.field30.method1120();
            }

            if(null != Client.field568) {
               Client.field568.method1120();
            }

            var0 = class5.field46.method2133();
            if(class3.field30 != null) {
               class3.field30.method1120();
            }

            if(null != Client.field568) {
               Client.field568.method1120();
            }

            if(var0 != 0) {
               class164.method3212(var0);
               return;
            }

            Client.field329.offset = 0;
            Client.field317 = 4;
         }

         if(Client.field317 == 4) {
            if(Client.field329.offset < 8) {
               var0 = class5.field46.method2131();
               if(var0 > 8 - Client.field329.offset) {
                  var0 = 8 - Client.field329.offset;
               }

               if(var0 > 0) {
                  class5.field46.method2113(Client.field329.payload, Client.field329.offset, var0);
                  Client.field329.offset += var0;
               }
            }

            if(Client.field329.offset == 8) {
               Client.field329.offset = 0;
               class1.field5 = Client.field329.method2947();
               Client.field317 = 5;
            }
         }

         int var1;
         int var2;
         if(Client.field317 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class1.field5 >> 32), (int)(class1.field5 & -1L)};
            Client.field327.offset = 0;
            Client.field327.method3010(1);
            Client.field327.method3010(class41.field842.vmethod4183());
            Client.field327.method2844(var5[0]);
            Client.field327.method2844(var5[1]);
            Client.field327.method2844(var5[2]);
            Client.field327.method2844(var5[3]);
            switch(class41.field842.field1627) {
            case 0:
               Client.field327.method2844(((Integer)WallObject.field1551.field688.get(Integer.valueOf(class10.method163(class41.username)))).intValue());
               Client.field327.offset += 4;
               break;
            case 1:
               Client.field327.offset += 8;
               break;
            case 2:
            case 3:
               Client.field327.method2862(class41.field843);
               Client.field327.offset += 5;
            }

            Client.field327.method2893(class41.field841);
            Client.field327.method2877(class39.field802, class39.field801);
            Client.field388.offset = 0;
            if(Client.gameState == 40) {
               Client.field388.method3010(18);
            } else {
               Client.field388.method3010(16);
            }

            Client.field388.method2842(0);
            var1 = Client.field388.offset;
            Client.field388.method2844(137);
            Client.field388.method2850(Client.field327.payload, 0, Client.field327.offset);
            var2 = Client.field388.offset;
            Client.field388.method2893(class41.username);
            Client.field388.method3010((Client.isResized?1:0) << 1 | (Client.field404?1:0));
            Client.field388.method2842(class2.field21);
            Client.field388.method2842(class20.field216);
            class33.method764(Client.field388);
            Client.field388.method2893(MessageNode.field226);
            Client.field388.method2844(class175.field2644);
            Buffer var3 = new Buffer(class88.field1524.method4381());
            class88.field1524.method4387(var3);
            Client.field388.method2850(var3.payload, 0, var3.payload.length);
            Client.field388.method3010(class9.field78);
            Client.field388.method2844(0);
            Client.field388.method2844(class22.field238.field2723);
            Client.field388.method2844(ChatMessages.field911.field2723);
            Client.field388.method2844(Client.field313.field2723);
            Client.field388.method2844(Client.field314.field2723);
            Client.field388.method2844(class1.field13.field2723);
            Client.field388.method2844(class26.field588.field2723);
            Client.field388.method2844(XItemContainer.field122.field2723);
            Client.field388.method2844(XClanMember.field266.field2723);
            Client.field388.method2844(class114.field1790.field2723);
            Client.field388.method2844(class40.field814.field2723);
            Client.field388.method2844(WallObject.field1545.field2723);
            Client.field388.method2844(class114.field1789.field2723);
            Client.field388.method2844(class143.field2004.field2723);
            Client.field388.method2844(Client.field533.field2723);
            Client.field388.method2844(class195.field2871.field2723);
            Client.field388.method2844(FrameMap.field1458.field2723);
            Client.field388.method2875(var5, var2, Client.field388.offset);
            Client.field388.method2852(Client.field388.offset - var1);
            class5.field46.method2114(Client.field388.payload, 0, Client.field388.offset);
            Client.field327.method3120(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field329.method3120(var5);
            Client.field317 = 6;
         }

         if(Client.field317 == 6 && class5.field46.method2131() > 0) {
            var0 = class5.field46.method2133();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field317 = 7;
            } else if(var0 == 2) {
               Client.field317 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field330 = -1;
               Client.field317 = 13;
            } else if(var0 == 23 && Client.field319 < 1) {
               ++Client.field319;
               Client.field317 = 0;
            } else {
               if(var0 != 29) {
                  class164.method3212(var0);
                  return;
               }

               Client.field317 = 11;
            }
         }

         if(Client.field317 == 7 && class5.field46.method2131() > 0) {
            Client.field320 = (class5.field46.method2133() + 3) * 60;
            Client.field317 = 8;
         }

         if(Client.field317 == 8) {
            Client.field318 = 0;
            class108.method2095("You have only just left another world.", "Your profile will be transferred in:", Client.field320 / 60 + " seconds.");
            if(--Client.field320 <= 0) {
               Client.field317 = 0;
            }

         } else {
            if(Client.field317 == 9 && class5.field46.method2131() >= 13) {
               boolean var11 = class5.field46.method2133() == 1;
               class5.field46.method2113(Client.field329.payload, 0, 4);
               Client.field329.offset = 0;
               boolean var10 = false;
               if(var11) {
                  var1 = Client.field329.method3122() << 24;
                  var1 |= Client.field329.method3122() << 16;
                  var1 |= Client.field329.method3122() << 8;
                  var1 |= Client.field329.method3122();
                  var2 = class10.method163(class41.username);
                  if(WallObject.field1551.field688.size() >= 10 && !WallObject.field1551.field688.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = WallObject.field1551.field688.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  WallObject.field1551.field688.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  DecorativeObject.method1977();
               }

               Client.field370 = class5.field46.method2133();
               Client.field454 = class5.field46.method2133() == 1;
               Client.localInteractingIndex = class5.field46.method2133();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class5.field46.method2133();
               Client.field407 = class5.field46.method2133();
               class5.field46.method2113(Client.field329.payload, 0, 1);
               Client.field329.offset = 0;
               Client.packetOpcode = Client.field329.method3122();
               class5.field46.method2113(Client.field329.payload, 0, 2);
               Client.field329.offset = 0;
               Client.field330 = Client.field329.readUnsignedShort();

               try {
                  Client var6 = Client.field279;
                  JSObject.getWindow(var6).call("zap", (Object[])null);
               } catch (Throwable var8) {
                  ;
               }

               Client.field317 = 10;
            }

            if(Client.field317 == 10) {
               if(class5.field46.method2131() >= Client.field330) {
                  Client.field329.offset = 0;
                  class5.field46.method2113(Client.field329.payload, 0, Client.field330);
                  Client.field293 = -1L;
                  Client.field296 = -1;
                  GameObject.field1621.field207 = 0;
                  class85.field1447 = true;
                  Client.field297 = true;
                  Client.field511 = -1L;
                  class227.field3246 = new CombatInfoList();
                  Client.field327.offset = 0;
                  Client.field329.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field540 = 1;
                  Client.field288 = -1;
                  Client.field310 = -1;
                  Client.field385 = 0;
                  Client.field504 = 0;
                  Client.field337 = 0;
                  Client.field300 = 0;
                  Client.menuOptionCount = 0;
                  Client.field432 = -1;
                  Client.isMenuOpen = false;
                  FileOnDisk.method1485(0);
                  class97.method1987();
                  Client.field438 = 0;
                  Client.field549 = false;
                  Client.field527 = 0;
                  Client.field349 = (int)(Math.random() * 100.0D) - 50;
                  Client.field449 = (int)(Math.random() * 110.0D) - 55;
                  Client.field353 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field558 = 0;
                  Client.field514 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field359 = class40.field808;
                  Client.field416 = class40.field808;
                  Client.field323 = 0;
                  class2.method26();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field414 = -1;
                  Client.projectiles.method2467();
                  Client.field418.method2467();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field467 = new Deque();
                  Client.field553 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class187.field2768; ++var0) {
                     class187 var17 = class110.method2137(var0);
                     if(null != var17) {
                        class165.field2154[var0] = 0;
                        class165.widgetSettings[var0] = 0;
                     }
                  }

                  class9.chatMessages.method908();
                  Client.field453 = -1;
                  if(Client.widgetRoot != -1) {
                     class108.method2097(Client.widgetRoot);
                  }

                  for(WidgetNode var14 = (WidgetNode)Client.componentTable.method2423(); null != var14; var14 = (WidgetNode)Client.componentTable.method2424()) {
                     class30.method683(var14, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field546 = null;
                  Client.menuOptionCount = 0;
                  Client.field432 = -1;
                  Client.isMenuOpen = false;
                  Client.field562.method3223((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerOptions[var0] = null;
                     Client.playerOptionsPriority[var0] = false;
                  }

                  class165.method3219();
                  Client.field547 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field490[var0] = true;
                  }

                  Client.field327.method3124(166);
                  Client.field327.method3010(Actor.method632());
                  Client.field327.method2842(class2.field21);
                  Client.field327.method2842(class20.field216);
                  Client.field512 = null;
                  class1.clanChatCount = 0;
                  ObjectComposition.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class143.field2002 = null;
                  Ignore.method207(Client.field329);
                  Renderable.field1528 = -1;
                  class40.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field317 == 11 && class5.field46.method2131() >= 2) {
                  Client.field329.offset = 0;
                  class5.field46.method2113(Client.field329.payload, 0, 2);
                  Client.field329.offset = 0;
                  RSCanvas.field1749 = Client.field329.readUnsignedShort();
                  Client.field317 = 12;
               }

               if(Client.field317 == 12 && class5.field46.method2131() >= RSCanvas.field1749) {
                  Client.field329.offset = 0;
                  class5.field46.method2113(Client.field329.payload, 0, RSCanvas.field1749);
                  Client.field329.offset = 0;
                  String var13 = Client.field329.readString();
                  String var7 = Client.field329.readString();
                  String var15 = Client.field329.readString();
                  class108.method2095(var13, var7, var15);
                  GameObject.setGameState(10);
               }

               if(Client.field317 != 13) {
                  ++Client.field318;
                  if(Client.field318 > 2000) {
                     if(Client.field319 < 1) {
                        if(VertexNormal.field1406 == class31.field713) {
                           class31.field713 = class44.field890;
                        } else {
                           class31.field713 = VertexNormal.field1406;
                        }

                        ++Client.field319;
                        Client.field317 = 0;
                     } else {
                        class164.method3212(-3);
                     }
                  }
               } else {
                  if(Client.field330 == -1) {
                     if(class5.field46.method2131() < 2) {
                        return;
                     }

                     class5.field46.method2113(Client.field329.payload, 0, 2);
                     Client.field329.offset = 0;
                     Client.field330 = Client.field329.readUnsignedShort();
                  }

                  if(class5.field46.method2131() >= Client.field330) {
                     class5.field46.method2113(Client.field329.payload, 0, Client.field330);
                     Client.field329.offset = 0;
                     var0 = Client.field330;
                     Client.field327.offset = 0;
                     Client.field329.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field540 = 1;
                     Client.field288 = -1;
                     Client.field310 = -1;
                     Client.field330 = 0;
                     Client.field385 = 0;
                     Client.field504 = 0;
                     Client.menuOptionCount = 0;
                     Client.field432 = -1;
                     Client.isMenuOpen = false;
                     Client.field558 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class9.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var16 = Client.cachedNPCs[var1];
                        if(var16 != null) {
                           var16.interacting = -1;
                           var16.field650 = false;
                        }
                     }

                     class165.method3219();
                     GameObject.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field490[var1] = true;
                     }

                     Client.field327.method3124(166);
                     Client.field327.method3010(Actor.method632());
                     Client.field327.method2842(class2.field21);
                     Client.field327.method2842(class20.field216);
                     Ignore.method207(Client.field329);
                     if(Client.field329.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field319 < 1) {
            if(class31.field713 == VertexNormal.field1406) {
               class31.field713 = class44.field890;
            } else {
               class31.field713 = VertexNormal.field1406;
            }

            ++Client.field319;
            Client.field317 = 0;
         } else {
            class164.method3212(-2);
         }
      }
   }
}
