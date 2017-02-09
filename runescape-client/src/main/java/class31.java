import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class31 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -664450721
   )
   int field692;
   @ObfuscatedName("k")
   static Deque field693 = new Deque();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 125872917
   )
   int field694;
   @ObfuscatedName("i")
   int[] field695;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -483968771
   )
   int field696;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -148933199
   )
   int field697;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1976087025
   )
   int field698;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 195194635
   )
   int field699;
   @ObfuscatedName("c")
   class66 field700;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -84669411
   )
   int field701;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1196471495
   )
   int field702;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -801429027
   )
   int field703;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 399487663
   )
   int field704;
   @ObfuscatedName("a")
   class66 field705;
   @ObfuscatedName("r")
   ObjectComposition field706;
   @ObfuscatedName("rr")
   protected static String field707;
   @ObfuscatedName("gv")
   static Widget field708;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method699() {
      int var1 = this.field694;
      ObjectComposition var2 = this.field706.getImpostor();
      if(null != var2) {
         this.field694 = var2.ambientSoundId;
         this.field698 = var2.field2919 * 128;
         this.field701 = var2.field2874;
         this.field702 = var2.field2921;
         this.field695 = var2.field2922;
      } else {
         this.field694 = -1;
         this.field698 = 0;
         this.field701 = 0;
         this.field702 = 0;
         this.field695 = null;
      }

      if(this.field694 != var1 && this.field700 != null) {
         class164.field2290.method919(this.field700);
         this.field700 = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1099295885"
   )
   static final void method703() {
      try {
         if(Client.field546 == 0) {
            if(null != class177.field2657) {
               class177.field2657.method2064();
               class177.field2657 = null;
            }

            PlayerComposition.field2023 = null;
            Client.field332 = false;
            Client.field312 = 0;
            Client.field546 = 1;
         }

         if(Client.field546 == 1) {
            if(null == PlayerComposition.field2023) {
               PlayerComposition.field2023 = class63.field1093.method1944(class10.host, Client.field492);
            }

            if(PlayerComposition.field2023.field1667 == 2) {
               throw new IOException();
            }

            if(PlayerComposition.field2023.field1667 == 1) {
               class177.field2657 = new class110((Socket)PlayerComposition.field2023.field1675, class63.field1093);
               PlayerComposition.field2023 = null;
               Client.field546 = 2;
            }
         }

         if(Client.field546 == 2) {
            Client.field321.offset = 0;
            Client.field321.method2912(14);
            class177.field2657.method2054(Client.field321.payload, 0, 1);
            Client.field323.offset = 0;
            Client.field546 = 3;
         }

         int var0;
         if(Client.field546 == 3) {
            if(class139.field1944 != null) {
               class139.field1944.method1096();
            }

            if(null != CombatInfoListHolder.field760) {
               CombatInfoListHolder.field760.method1096();
            }

            var0 = class177.field2657.method2049();
            if(null != class139.field1944) {
               class139.field1944.method1096();
            }

            if(null != CombatInfoListHolder.field760) {
               CombatInfoListHolder.field760.method1096();
            }

            if(var0 != 0) {
               class107.method2031(var0);
               return;
            }

            Client.field323.offset = 0;
            Client.field546 = 5;
         }

         int var1;
         int var2;
         if(Client.field546 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field321.offset = 0;
            Client.field321.method2912(1);
            Client.field321.method2912(class41.field854.vmethod4057());
            Client.field321.method3057(var5[0]);
            Client.field321.method3057(var5[1]);
            Client.field321.method3057(var5[2]);
            Client.field321.method3057(var5[3]);
            switch(class41.field854.field1626) {
            case 0:
            case 2:
               Client.field321.method2914(class2.field27);
               Client.field321.offset += 5;
               break;
            case 1:
               Client.field321.method3057(((Integer)class85.field1456.field688.get(Integer.valueOf(Tile.method1561(class41.username)))).intValue());
               Client.field321.offset += 4;
               break;
            case 3:
               Client.field321.offset += 8;
            }

            Client.field321.method3097(class41.field844);
            Client.field321.method3104(class39.field806, class39.field799);
            Client.field322.offset = 0;
            if(Client.gameState == 40) {
               Client.field322.method2912(18);
            } else {
               Client.field322.method2912(16);
            }

            Client.field322.method3094(0);
            var1 = Client.field322.offset;
            Client.field322.method3057(133);
            Client.field322.method2921(Client.field321.payload, 0, Client.field321.offset);
            var2 = Client.field322.offset;
            Client.field322.method3097(class41.username);
            Client.field322.method2912((Client.isResized?1:0) << 1 | (Client.field278?1:0));
            Client.field322.method3094(XItemContainer.field123);
            Client.field322.method3094(class143.field1999);
            class49.method901(Client.field322);
            Client.field322.method3097(class1.field12);
            Client.field322.method3057(class103.field1685);
            Buffer var3 = new Buffer(Sequence.field3052.method4253());
            Sequence.field3052.method4257(var3);
            Client.field322.method2921(var3.payload, 0, var3.payload.length);
            Client.field322.method2912(class206.field3084);
            Client.field322.method3057(0);
            Client.field322.method3057(class152.field2191.field2706);
            Client.field322.method3057(class0.field2.field2706);
            Client.field322.method3057(Client.field353.field2706);
            Client.field322.method3057(class166.field2297.field2706);
            Client.field322.method3057(Friend.field152.field2706);
            Client.field322.method3057(class37.field786.field2706);
            Client.field322.method3057(ChatMessages.field923.field2706);
            Client.field322.method3057(class171.field2330.field2706);
            Client.field322.method3057(Friend.field147.field2706);
            Client.field322.method3057(class171.field2324.field2706);
            Client.field322.method3057(class174.field2628.field2706);
            Client.field322.method3057(class11.field109.field2706);
            Client.field322.method3057(class112.field1763.field2706);
            Client.field322.method3057(class25.field574.field2706);
            Client.field322.method3057(class119.field1849.field2706);
            Client.field322.method3057(class103.field1686.field2706);
            Client.field322.method2945(var5, var2, Client.field322.offset);
            Client.field322.method3056(Client.field322.offset - var1);
            class177.field2657.method2054(Client.field322.payload, 0, Client.field322.offset);
            Client.field321.method3174(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field323.method3174(var5);
            Client.field546 = 6;
         }

         if(Client.field546 == 6 && class177.field2657.method2052() > 0) {
            var0 = class177.field2657.method2049();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field546 = 7;
            } else if(var0 == 2) {
               Client.field546 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field324 = -1;
               Client.field546 = 13;
            } else if(var0 == 23 && Client.field313 < 1) {
               ++Client.field313;
               Client.field546 = 0;
            } else {
               if(var0 != 29) {
                  class107.method2031(var0);
                  return;
               }

               Client.field546 = 11;
            }
         }

         if(Client.field546 == 7 && class177.field2657.method2052() > 0) {
            Client.field319 = (class177.field2657.method2049() + 3) * 60;
            Client.field546 = 8;
         }

         if(Client.field546 == 8) {
            Client.field312 = 0;
            PlayerComposition.method2762("You have only just left another world.", "Your profile will be transferred in:", Client.field319 / 60 + " seconds.");
            if(--Client.field319 <= 0) {
               Client.field546 = 0;
            }

         } else {
            if(Client.field546 == 9 && class177.field2657.method2052() >= 13) {
               boolean var10 = class177.field2657.method2049() == 1;
               class177.field2657.method2053(Client.field323.payload, 0, 4);
               Client.field323.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field323.method3190() << 24;
                  var1 |= Client.field323.method3190() << 16;
                  var1 |= Client.field323.method3190() << 8;
                  var1 |= Client.field323.method3190();
                  var2 = Tile.method1561(class41.username);
                  if(class85.field1456.field688.size() >= 10 && !class85.field1456.field688.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = class85.field1456.field688.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  class85.field1456.field688.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class3.method39();
               }

               Client.field396 = class177.field2657.method2049();
               Client.field446 = class177.field2657.method2049() == 1;
               Client.localInteractingIndex = class177.field2657.method2049();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class177.field2657.method2049();
               Client.field503 = class177.field2657.method2049();
               class177.field2657.method2053(Client.field323.payload, 0, 1);
               Client.field323.offset = 0;
               Client.packetOpcode = Client.field323.method3190();
               class177.field2657.method2053(Client.field323.payload, 0, 2);
               Client.field323.offset = 0;
               Client.field324 = Client.field323.readUnsignedShort();

               try {
                  class100.method1929(Client.field277, "zap");
               } catch (Throwable var8) {
                  ;
               }

               Client.field546 = 10;
            }

            if(Client.field546 == 10) {
               if(class177.field2657.method2052() >= Client.field324) {
                  Client.field323.offset = 0;
                  class177.field2657.method2053(Client.field323.payload, 0, Client.field324);
                  Client.field289 = -1L;
                  Client.field365 = -1;
                  WallObject.field1557.field211 = 0;
                  class97.field1630 = true;
                  Client.field449 = true;
                  Client.field336 = -1L;
                  class227.field3232 = new CombatInfoList();
                  Client.field321.offset = 0;
                  Client.field323.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field284 = 1;
                  Client.field329 = -1;
                  Client.field330 = -1;
                  Client.field326 = 0;
                  Client.field325 = 0;
                  Client.field331 = 0;
                  Client.field296 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class115.mouseIdleTicks = 0;
                  class47.chatLineMap.clear();
                  class47.field925.method2302();
                  class47.field926.method2446();
                  class47.field928 = 0;
                  Client.field525 = 0;
                  Client.field432 = false;
                  Client.field461 = 0;
                  Client.field342 = (int)(Math.random() * 100.0D) - 50;
                  Client.field442 = (int)(Math.random() * 110.0D) - 55;
                  Client.field346 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field514 = 0;
                  Client.field382 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field304 = class40.field810;
                  Client.field305 = class40.field810;
                  Client.field317 = 0;
                  class45.field901 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class45.field900[var0] = null;
                     class45.field899[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field407 = -1;
                  Client.projectiles.method2379();
                  Client.field411.method2379();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field300 = new Deque();
                  Client.field333 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class187.field2755; ++var0) {
                     class187 var18 = class109.method2046(var0);
                     if(null != var18) {
                        class146.settings[var0] = 0;
                        class146.widgetSettings[var0] = 0;
                     }
                  }

                  class45.chatMessages.method864();
                  Client.field445 = -1;
                  if(Client.widgetRoot != -1) {
                     Ignore.method205(Client.widgetRoot);
                  }

                  for(WidgetNode var14 = (WidgetNode)Client.componentTable.method2334(); null != var14; var14 = (WidgetNode)Client.componentTable.method2335()) {
                     class39.method768(var14, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field309 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field551.method2733((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerOptions[var0] = null;
                     Client.playerOptionsPriority[var0] = false;
                  }

                  ChatMessages.method846();
                  Client.field287 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field482[var0] = true;
                  }

                  Client.field321.method3195(245);
                  class166 var16 = Client.field321;
                  var1 = Client.isResized?2:1;
                  var16.method2912(var1);
                  Client.field321.method3094(XItemContainer.field123);
                  Client.field321.method3094(class143.field1999);
                  Client.field299 = null;
                  class72.clanChatCount = 0;
                  class85.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class26.field576 = null;
                  class26.method621(Client.field323);
                  Actor.field650 = -1;
                  ChatLineBuffer.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field546 == 11 && class177.field2657.method2052() >= 2) {
                  Client.field323.offset = 0;
                  class177.field2657.method2053(Client.field323.payload, 0, 2);
                  Client.field323.offset = 0;
                  class184.field2716 = Client.field323.readUnsignedShort();
                  Client.field546 = 12;
               }

               if(Client.field546 == 12 && class177.field2657.method2052() >= class184.field2716) {
                  Client.field323.offset = 0;
                  class177.field2657.method2053(Client.field323.payload, 0, class184.field2716);
                  Client.field323.offset = 0;
                  String var13 = Client.field323.method2934();
                  String var7 = Client.field323.method2934();
                  String var6 = Client.field323.method2934();
                  PlayerComposition.method2762(var13, var7, var6);
                  class11.setGameState(10);
               }

               if(Client.field546 != 13) {
                  ++Client.field312;
                  if(Client.field312 > 2000) {
                     if(Client.field313 < 1) {
                        if(class157.field2216 == Client.field492) {
                           Client.field492 = class6.field54;
                        } else {
                           Client.field492 = class157.field2216;
                        }

                        ++Client.field313;
                        Client.field546 = 0;
                     } else {
                        class107.method2031(-3);
                     }
                  }
               } else {
                  if(Client.field324 == -1) {
                     if(class177.field2657.method2052() < 2) {
                        return;
                     }

                     class177.field2657.method2053(Client.field323.payload, 0, 2);
                     Client.field323.offset = 0;
                     Client.field324 = Client.field323.readUnsignedShort();
                  }

                  if(class177.field2657.method2052() >= Client.field324) {
                     class177.field2657.method2053(Client.field323.payload, 0, Client.field324);
                     Client.field323.offset = 0;
                     var0 = Client.field324;
                     Client.field321.offset = 0;
                     Client.field323.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field284 = 1;
                     Client.field329 = -1;
                     Client.field330 = -1;
                     Client.field324 = 0;
                     Client.field326 = 0;
                     Client.field325 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field514 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     VertexNormal.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var15 = Client.cachedNPCs[var1];
                        if(var15 != null) {
                           var15.interacting = -1;
                           var15.field617 = false;
                        }
                     }

                     ChatMessages.method846();
                     class11.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field482[var1] = true;
                     }

                     Client.field321.method3195(245);
                     class166 var17 = Client.field321;
                     var2 = Client.isResized?2:1;
                     var17.method2912(var2);
                     Client.field321.method3094(XItemContainer.field123);
                     Client.field321.method3094(class143.field1999);
                     class26.method621(Client.field323);
                     if(Client.field323.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field313 < 1) {
            if(Client.field492 == class157.field2216) {
               Client.field492 = class6.field54;
            } else {
               Client.field492 = class157.field2216;
            }

            ++Client.field313;
            Client.field546 = 0;
         } else {
            class107.method2031(-2);
         }
      }
   }
}
