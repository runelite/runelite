import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("d")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("o")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("ax")
   static ModIcon[] field221;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("p")
   static int[] field223;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1206046192"
   )
   static final void method201(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field579 == -1) {
            Client.field579 = var0.textureId;
            Client.field580 = var0.field2338 * -1;
         }

         if(Client.field432.isFemale) {
            var0.textureId = Client.field579;
         } else {
            var0.textureId = Client.field580 * -1;
         }

      } else if(var1 == 325) {
         if(Client.field579 == -1) {
            Client.field579 = var0.textureId;
            Client.field580 = var0.field2338 * -1;
         }

         if(Client.field432.isFemale) {
            var0.textureId = Client.field580 * -1;
         } else {
            var0.textureId = Client.field579;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1728518527"
   )
   static final void method202() {
      try {
         if(Client.field518 == 0) {
            if(null != class149.field2036) {
               class149.field2036.method2118();
               class149.field2036 = null;
            }

            XItemContainer.field143 = null;
            Client.field387 = false;
            Client.field361 = 0;
            Client.field518 = 1;
         }

         if(Client.field518 == 1) {
            if(null == XItemContainer.field143) {
               XItemContainer.field143 = class33.field775.method2024(class101.host, class142.field1999);
            }

            if(XItemContainer.field143.field1671 == 2) {
               throw new IOException();
            }

            if(XItemContainer.field143.field1671 == 1) {
               class149.field2036 = new class110((Socket)XItemContainer.field143.field1672, class33.field775);
               XItemContainer.field143 = null;
               Client.field518 = 2;
            }
         }

         if(Client.field518 == 2) {
            Client.field348.offset = 0;
            Client.field348.method2918(14);
            class149.field2036.method2114(Client.field348.payload, 0, 1);
            Client.field350.offset = 0;
            Client.field518 = 3;
         }

         int var0;
         if(Client.field518 == 3) {
            if(null != class44.field914) {
               class44.field914.method1112();
            }

            if(class167.field2189 != null) {
               class167.field2189.method1112();
            }

            var0 = class149.field2036.method2116();
            if(null != class44.field914) {
               class44.field914.method1112();
            }

            if(class167.field2189 != null) {
               class167.field2189.method1112();
            }

            if(var0 != 0) {
               class185.method3426(var0);
               return;
            }

            Client.field350.offset = 0;
            Client.field518 = 5;
         }

         int var1;
         int var2;
         if(Client.field518 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field348.offset = 0;
            Client.field348.method2918(1);
            Client.field348.method2918(class41.field865.vmethod4101());
            Client.field348.method2821(var7[0]);
            Client.field348.method2821(var7[1]);
            Client.field348.method2821(var7[2]);
            Client.field348.method2821(var7[3]);
            switch(class41.field865.field1637) {
            case 0:
               Client.field348.offset += 8;
               break;
            case 1:
               Client.field348.method2821(((Integer)class184.field2735.field717.get(Integer.valueOf(Player.method250(class41.username)))).intValue());
               Client.field348.offset += 4;
               break;
            case 2:
            case 3:
               Client.field348.method2961(class105.field1728);
               Client.field348.offset += 5;
            }

            Client.field348.method2824(class41.field864);
            Client.field348.method2828(class39.field825, class39.field827);
            Client.field457.offset = 0;
            if(Client.gameState == 40) {
               Client.field457.method2918(18);
            } else {
               Client.field457.method2918(16);
            }

            Client.field457.method2831(0);
            var1 = Client.field457.offset;
            Client.field457.method2821(135);
            Client.field457.method2827(Client.field348.payload, 0, Client.field348.offset);
            var2 = Client.field457.offset;
            Client.field457.method2824(class41.username);
            Client.field457.method2918((Client.isResized?1:0) << 1 | (Client.field308?1:0));
            Client.field457.method2831(class32.field758);
            Client.field457.method2831(class47.field950);
            class159 var3 = Client.field457;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class104.field1692.method1453(0L);
               class104.field1692.method1446(var4);

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

            var3.method2827(var4, 0, 24);
            Client.field457.method2824(Client.field310);
            Client.field457.method2821(class11.field133);
            Buffer var17 = new Buffer(class116.field1825.method4300());
            class116.field1825.method4298(var17);
            Client.field457.method2827(var17.payload, 0, var17.payload.length);
            Client.field457.method2918(Client.field438);
            Client.field457.method2821(0);
            Client.field457.method2821(class20.field228.field2721);
            Client.field457.method2821(class1.field23.field2721);
            Client.field457.method2821(class40.field833.field2721);
            Client.field457.method2821(class116.field1819.field2721);
            Client.field457.method2821(Client.field336.field2721);
            Client.field457.method2821(Client.field337.field2721);
            Client.field457.method2821(class11.field127.field2721);
            Client.field457.method2821(class10.field111.field2721);
            Client.field457.method2821(class165.field2167.field2721);
            Client.field457.method2821(class107.field1738.field2721);
            Client.field457.method2821(class38.field821.field2721);
            Client.field457.method2821(class150.field2044.field2721);
            Client.field457.method2821(class145.field2013.field2721);
            Client.field457.method2821(class0.field0.field2721);
            Client.field457.method2821(class22.field254.field2721);
            Client.field457.method2821(XItemContainer.field137.field2721);
            Client.field457.method2852(var7, var2, Client.field457.offset);
            Client.field457.method2829(Client.field457.offset - var1);
            class149.field2036.method2114(Client.field457.payload, 0, Client.field457.offset);
            Client.field348.method3070(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field350.method3070(var7);
            Client.field518 = 6;
         }

         if(Client.field518 == 6 && class149.field2036.method2128() > 0) {
            var0 = class149.field2036.method2116();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field518 = 7;
            } else if(var0 == 2) {
               Client.field518 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field351 = -1;
               Client.field518 = 13;
            } else if(var0 == 23 && Client.field341 < 1) {
               ++Client.field341;
               Client.field518 = 0;
            } else {
               if(var0 != 29) {
                  class185.method3426(var0);
                  return;
               }

               Client.field518 = 11;
            }
         }

         if(Client.field518 == 7 && class149.field2036.method2128() > 0) {
            Client.field342 = (class149.field2036.method2116() + 3) * 60;
            Client.field518 = 8;
         }

         if(Client.field518 == 8) {
            Client.field361 = 0;
            class138.method2536("You have only just left another world.", "Your profile will be transferred in:", Client.field342 / 60 + " seconds.");
            if(--Client.field342 <= 0) {
               Client.field518 = 0;
            }

         } else {
            boolean var15;
            if(Client.field518 == 9 && class149.field2036.method2128() >= 13) {
               boolean var14 = class149.field2036.method2116() == 1;
               class149.field2036.method2117(Client.field350.payload, 0, 4);
               Client.field350.offset = 0;
               var15 = false;
               if(var14) {
                  var1 = Client.field350.method3069() << 24;
                  var1 |= Client.field350.method3069() << 16;
                  var1 |= Client.field350.method3069() << 8;
                  var1 |= Client.field350.method3069();
                  var2 = Player.method250(class41.username);
                  if(class184.field2735.field717.size() >= 10 && !class184.field2735.field717.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class184.field2735.field717.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class184.field2735.field717.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class99.method1996();
               }

               Client.field472 = class149.field2036.method2116();
               Client.field474 = class149.field2036.method2116() == 1;
               Client.localInteractingIndex = class149.field2036.method2116();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class149.field2036.method2116();
               Client.field427 = class149.field2036.method2116();
               class149.field2036.method2117(Client.field350.payload, 0, 1);
               Client.field350.offset = 0;
               Client.packetOpcode = Client.field350.method3069();
               class149.field2036.method2117(Client.field350.payload, 0, 2);
               Client.field350.offset = 0;
               Client.field351 = Client.field350.readUnsignedShort();

               try {
                  class100.method2003(Client.field508, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field518 = 10;
            }

            if(Client.field518 == 10) {
               if(class149.field2036.method2128() >= Client.field351) {
                  Client.field350.offset = 0;
                  class149.field2036.method2117(Client.field350.payload, 0, Client.field351);
                  Client.field315 = 1L;
                  Client.field464 = -1;
                  Client.field316.field226 = 0;
                  class63.field1108 = true;
                  Client.field320 = true;
                  Client.field419 = -1L;
                  class227.field3245 = new CombatInfoList();
                  Client.field348.offset = 0;
                  Client.field350.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field355 = -1;
                  Client.field356 = -1;
                  Client.field574 = -1;
                  Client.field559 = 0;
                  Client.field322 = 0;
                  Client.field358 = 0;
                  Client.field551 = 0;
                  class152.method2814();
                  class115.mouseIdleTicks = 0;
                  class179.method3290();
                  Client.field458 = 0;
                  Client.field511 = false;
                  Client.field547 = 0;
                  Client.field481 = (int)(Math.random() * 100.0D) - 50;
                  Client.field371 = (int)(Math.random() * 110.0D) - 55;
                  Client.field339 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field564 = 0;
                  Client.field534 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field331 = class40.field836;
                  Client.field332 = class40.field836;
                  Client.field340 = 0;
                  class45.field921 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class45.field920[var0] = null;
                     class45.field923[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field434 = -1;
                  Client.projectiles.method2452();
                  Client.field418.method2452();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field436 = new Deque();
                  Client.field573 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class187.field2782; ++var0) {
                     class187 var21 = class182.method3356(var0);
                     if(var21 != null) {
                        class165.settings[var0] = 0;
                        class165.widgetSettings[var0] = 0;
                     }
                  }

                  class20.chatMessages.method911();
                  Client.field514 = -1;
                  if(Client.widgetRoot != -1) {
                     var0 = Client.widgetRoot;
                     if(var0 != -1 && Widget.validInterfaces[var0]) {
                        Widget.field2271.method3315(var0);
                        if(null != Widget.widgets[var0]) {
                           var15 = true;

                           for(var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                              if(null != Widget.widgets[var0][var2]) {
                                 if(Widget.widgets[var0][var2].type != 2) {
                                    Widget.widgets[var0][var2] = null;
                                 } else {
                                    var15 = false;
                                 }
                              }
                           }

                           if(var15) {
                              Widget.widgets[var0] = null;
                           }

                           Widget.validInterfaces[var0] = false;
                        }
                     }
                  }

                  for(WidgetNode var19 = (WidgetNode)Client.componentTable.method2403(); null != var19; var19 = (WidgetNode)Client.componentTable.method2411()) {
                     World.method672(var19, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field469 = null;
                  class152.method2814();
                  Client.field432.method3170((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerOptions[var0] = null;
                     Client.playerOptionsPriority[var0] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  Client.field373 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field510[var0] = true;
                  }

                  class8.method96();
                  Client.field532 = null;
                  Player.clanChatCount = 0;
                  class72.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class105.field1703 = null;
                  Item.method879(Client.field350);
                  class149.field2035 = -1;
                  Player.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field518 == 11 && class149.field2036.method2128() >= 2) {
                  Client.field350.offset = 0;
                  class149.field2036.method2117(Client.field350.payload, 0, 2);
                  Client.field350.offset = 0;
                  class99.field1648 = Client.field350.readUnsignedShort();
                  Client.field518 = 12;
               }

               if(Client.field518 == 12 && class149.field2036.method2128() >= class99.field1648) {
                  Client.field350.offset = 0;
                  class149.field2036.method2117(Client.field350.payload, 0, class99.field1648);
                  Client.field350.offset = 0;
                  String var18 = Client.field350.method2868();
                  String var10 = Client.field350.method2868();
                  String var9 = Client.field350.method2868();
                  class138.method2536(var18, var10, var9);
                  class8.setGameState(10);
               }

               if(Client.field518 != 13) {
                  ++Client.field361;
                  if(Client.field361 > 2000) {
                     if(Client.field341 < 1) {
                        if(class142.field1999 == class16.field187) {
                           class142.field1999 = class164.field2158;
                        } else {
                           class142.field1999 = class16.field187;
                        }

                        ++Client.field341;
                        Client.field518 = 0;
                     } else {
                        class185.method3426(-3);
                     }
                  }
               } else {
                  if(Client.field351 == -1) {
                     if(class149.field2036.method2128() < 2) {
                        return;
                     }

                     class149.field2036.method2117(Client.field350.payload, 0, 2);
                     Client.field350.offset = 0;
                     Client.field351 = Client.field350.readUnsignedShort();
                  }

                  if(class149.field2036.method2128() >= Client.field351) {
                     class149.field2036.method2117(Client.field350.payload, 0, Client.field351);
                     Client.field350.offset = 0;
                     var0 = Client.field351;
                     Client.field348.offset = 0;
                     Client.field350.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field355 = -1;
                     Client.field356 = -1;
                     Client.field574 = -1;
                     Client.field351 = 0;
                     Client.field559 = 0;
                     Client.field322 = 0;
                     class152.method2814();
                     Client.field564 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class36.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var20 = Client.cachedNPCs[var1];
                        if(var20 != null) {
                           var20.interacting = -1;
                           var20.field650 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     class8.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field510[var1] = true;
                     }

                     class8.method96();
                     Item.method879(Client.field350);
                     if(Client.field350.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field341 < 1) {
            if(class142.field1999 == class16.field187) {
               class142.field1999 = class164.field2158;
            } else {
               class142.field1999 = class16.field187;
            }

            ++Client.field341;
            Client.field518 = 0;
         } else {
            class185.method3426(-2);
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1903086208"
   )
   static final void method203(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class175.field2651.method3895(var0, 250);
      int var6 = class175.field2651.method3970(var0, 250) * 13;
      Rasterizer2D.method4011(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.method4017(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class175.field2651.method3902(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class63.method1215(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = GameObject.canvas.getGraphics();
            CombatInfo1.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            GameObject.canvas.repaint();
         }
      } else {
         class31.method710(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1832551191"
   )
   static final void method204(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class30.method696(var0)) {
         class114.field1786 = null;
         class183.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class114.field1786 != null) {
            class183.gameDraw(class114.field1786, -1412584499, var1, var2, var3, var4, class118.field1843, class176.field2661, var7);
            class114.field1786 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field510[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field510[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1231744508"
   )
   public static Object method205(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2120) {
            try {
               class151 var2 = new class151();
               var2.vmethod3045(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2120 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-80"
   )
   static boolean method206(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = GroundObject.method1594(var0, MessageNode.field244);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(GroundObject.method1594(var3.name, MessageNode.field244))) {
               return true;
            }

            if(var1.equalsIgnoreCase(GroundObject.method1594(var3.previousName, MessageNode.field244))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-957424020"
   )
   static byte[] method207(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1809055266"
   )
   public static void method208() {
      PlayerComposition.field2176.reset();
   }
}
