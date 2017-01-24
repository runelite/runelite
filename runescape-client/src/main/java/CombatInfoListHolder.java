import java.awt.Component;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("h")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("f")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("ch")
   static class102 field756;
   @ObfuscatedName("nn")
   static class51 field758;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "151509194"
   )
   boolean method678() {
      return this.combatInfo1.method2298();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1821519995"
   )
   void method679(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2295(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2291()) {
         ++var6;
         if(var7.field670 == var1) {
            var7.method592(var1, var2, var3, var4);
            return;
         }

         if(var7.field670 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2304(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2294(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2295().unlink();
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-587842628"
   )
   CombatInfo1 method680(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2295();
      if(var2 != null && var2.field670 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2291(); null != var3 && var3.field670 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2291()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2849 + var2.field670 + var2.field669 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   static final void method687() {
      try {
         if(Client.field327 == 0) {
            if(null != class30.field698) {
               class30.field698.method2006();
               class30.field698 = null;
            }

            field756 = null;
            Client.field473 = false;
            Client.field328 = 0;
            Client.field327 = 1;
         }

         if(Client.field327 == 1) {
            if(field756 == null) {
               field756 = class22.field252.method1911(class178.host, class26.field602);
            }

            if(field756.field1663 == 2) {
               throw new IOException();
            }

            if(field756.field1663 == 1) {
               class30.field698 = new class110((Socket)field756.field1666, class22.field252);
               field756 = null;
               Client.field327 = 2;
            }
         }

         if(Client.field327 == 2) {
            Client.field336.offset = 0;
            Client.field336.method2708(14);
            class30.field698.method2015(Client.field336.payload, 0, 1);
            Client.field352.offset = 0;
            Client.field327 = 3;
         }

         int var0;
         if(Client.field327 == 3) {
            if(null != GameObject.field1626) {
               GameObject.field1626.method1019();
            }

            if(null != class47.field929) {
               class47.field929.method1019();
            }

            var0 = class30.field698.method2004();
            if(GameObject.field1626 != null) {
               GameObject.field1626.method1019();
            }

            if(class47.field929 != null) {
               class47.field929.method1019();
            }

            if(var0 != 0) {
               class18.method161(var0);
               return;
            }

            Client.field352.offset = 0;
            Client.field327 = 5;
         }

         int var1;
         int var2;
         if(Client.field327 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field336.offset = 0;
            Client.field336.method2708(1);
            Client.field336.method2708(class41.field847.vmethod3916());
            Client.field336.method2711(var7[0]);
            Client.field336.method2711(var7[1]);
            Client.field336.method2711(var7[2]);
            Client.field336.method2711(var7[3]);
            switch(class41.field847.field1633) {
            case 0:
            case 3:
               Client.field336.method2710(class10.field108);
               Client.field336.offset += 5;
               break;
            case 1:
               Client.field336.offset += 8;
               break;
            case 2:
               Client.field336.method2711(((Integer)class38.field794.field697.get(Integer.valueOf(class180.method3176(class41.username)))).intValue());
               Client.field336.offset += 4;
            }

            Client.field336.method2714(class41.field810);
            Client.field336.method2743(class39.field796, class39.field797);
            Client.field570.offset = 0;
            if(Client.gameState == 40) {
               Client.field570.method2708(18);
            } else {
               Client.field570.method2708(16);
            }

            Client.field570.method2709(0);
            var1 = Client.field570.offset;
            Client.field570.method2711(131);
            Client.field570.method2747(Client.field336.payload, 0, Client.field336.offset);
            var2 = Client.field570.offset;
            Client.field570.method2714(class41.username);
            Client.field570.method2708((Client.isResized?1:0) << 1 | (Client.field299?1:0));
            Client.field570.method2709(class16.field186);
            Client.field570.method2709(ChatMessages.field907);
            class159 var3 = Client.field570;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class104.field1684.method1348(0L);
               class104.field1684.method1347(var4);

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

            var3.method2747(var4, 0, 24);
            Client.field570.method2714(class155.field2116);
            Client.field570.method2711(class65.field1107);
            Buffer var18 = new Buffer(DecorativeObject.field1604.method4111());
            DecorativeObject.field1604.method4103(var18);
            Client.field570.method2747(var18.payload, 0, var18.payload.length);
            Client.field570.method2708(class103.field1678);
            Client.field570.method2711(class8.field86.field2717);
            Client.field570.method2711(class37.field780.field2717);
            Client.field570.method2711(ChatMessages.field919.field2717);
            Client.field570.method2711(XClanMember.field288.field2717);
            Client.field570.method2711(class5.field60.field2717);
            Client.field570.method2711(class1.field16.field2717);
            Client.field570.method2711(class164.field2170.field2717);
            Client.field570.method2711(class97.field1639.field2717);
            Client.field570.method2711(class40.field807.field2717);
            Client.field570.method2711(Client.field324.field2717);
            Client.field570.method2711(class108.field1736.field2717);
            Client.field570.method2711(Client.field325.field2717);
            Client.field570.method2711(WidgetNode.field201.field2717);
            Client.field570.method2711(class6.field68.field2717);
            Client.field570.method2711(class94.field1593.field2717);
            Client.field570.method2711(class47.field924.field2717);
            Client.field570.method2741(var7, var2, Client.field570.offset);
            Client.field570.method2885(Client.field570.offset - var1);
            class30.field698.method2015(Client.field570.payload, 0, Client.field570.offset);
            Client.field336.method2962(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field352.method2962(var7);
            Client.field327 = 6;
         }

         if(Client.field327 == 6 && class30.field698.method2007() > 0) {
            var0 = class30.field698.method2004();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field327 = 7;
            } else if(var0 == 2) {
               Client.field327 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field339 = -1;
               Client.field327 = 13;
            } else if(var0 == 23 && Client.field329 < 1) {
               ++Client.field329;
               Client.field327 = 0;
            } else {
               if(var0 != 29) {
                  class18.method161(var0);
                  return;
               }

               Client.field327 = 11;
            }
         }

         if(Client.field327 == 7 && class30.field698.method2007() > 0) {
            Client.field330 = (class30.field698.method2004() + 3) * 60;
            Client.field327 = 8;
         }

         if(Client.field327 == 8) {
            Client.field328 = 0;
            class1.method8("You have only just left another world.", "Your profile will be transferred in:", Client.field330 / 60 + " seconds.");
            if(--Client.field330 <= 0) {
               Client.field327 = 0;
            }

         } else {
            if(Client.field327 == 9 && class30.field698.method2007() >= 13) {
               boolean var14 = class30.field698.method2004() == 1;
               class30.field698.method2005(Client.field352.payload, 0, 4);
               Client.field352.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field352.method2964() << 24;
                  var1 |= Client.field352.method2964() << 16;
                  var1 |= Client.field352.method2964() << 8;
                  var1 |= Client.field352.method2964();
                  var2 = class180.method3176(class41.username);
                  if(class38.field794.field697.size() >= 10 && !class38.field794.field697.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class38.field794.field697.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class38.field794.field697.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  PlayerComposition.method3057();
               }

               Client.field458 = class30.field698.method2004();
               Client.field460 = class30.field698.method2004() == 1;
               Client.localInteractingIndex = class30.field698.method2004();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class30.field698.method2004();
               Client.field415 = class30.field698.method2004();
               class30.field698.method2005(Client.field352.payload, 0, 1);
               Client.field352.offset = 0;
               Client.packetOpcode = Client.field352.method2964();
               class30.field698.method2005(Client.field352.payload, 0, 2);
               Client.field352.offset = 0;
               Client.field339 = Client.field352.readUnsignedShort();

               try {
                  class100.method1893(class227.field3230, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field327 = 10;
            }

            if(Client.field327 != 10) {
               if(Client.field327 == 11 && class30.field698.method2007() >= 2) {
                  Client.field352.offset = 0;
                  class30.field698.method2005(Client.field352.payload, 0, 2);
                  Client.field352.offset = 0;
                  class186.field2773 = Client.field352.readUnsignedShort();
                  Client.field327 = 12;
               }

               if(Client.field327 == 12 && class30.field698.method2007() >= class186.field2773) {
                  Client.field352.offset = 0;
                  class30.field698.method2005(Client.field352.payload, 0, class186.field2773);
                  Client.field352.offset = 0;
                  String var20 = Client.field352.method2911();
                  String var22 = Client.field352.method2911();
                  String var21 = Client.field352.method2911();
                  class1.method8(var20, var22, var21);
                  class103.setGameState(10);
               }

               if(Client.field327 == 13) {
                  if(Client.field339 == -1) {
                     if(class30.field698.method2007() < 2) {
                        return;
                     }

                     class30.field698.method2005(Client.field352.payload, 0, 2);
                     Client.field352.offset = 0;
                     Client.field339 = Client.field352.readUnsignedShort();
                  }

                  if(class30.field698.method2007() >= Client.field339) {
                     class30.field698.method2005(Client.field352.payload, 0, Client.field339);
                     Client.field352.offset = 0;
                     var0 = Client.field339;
                     WidgetNode.method158();
                     class103.method1933(Client.field352);
                     if(Client.field352.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field328;
                  if(Client.field328 > 2000) {
                     if(Client.field329 < 1) {
                        if(class0.field6 == class26.field602) {
                           class26.field602 = CombatInfo2.field2843;
                        } else {
                           class26.field602 = class0.field6;
                        }

                        ++Client.field329;
                        Client.field327 = 0;
                     } else {
                        class18.method161(-3);
                     }
                  }
               }
            } else {
               if(class30.field698.method2007() >= Client.field339) {
                  Client.field352.offset = 0;
                  class30.field698.method2005(Client.field352.payload, 0, Client.field339);
                  Client.field304 = -1L;
                  Client.field307 = -1;
                  class39.field802.field230 = 0;
                  class49.field956 = true;
                  Client.field308 = true;
                  Client.field396 = -1L;
                  class227.field3231 = new CombatInfoList();
                  Client.field336.offset = 0;
                  Client.field352.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field480 = -1;
                  Client.field552 = -1;
                  Client.field345 = -1;
                  Client.field517 = 0;
                  Client.field534 = 0;
                  Client.field346 = 0;
                  Client.field311 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class115.mouseIdleTicks = 0;
                  class47.chatLineMap.clear();
                  class47.field927.method2244();
                  class47.field922.method2394();
                  class47.field921 = 0;
                  Client.field412 = 0;
                  Client.field446 = false;
                  Client.field505 = 0;
                  Client.field560 = (int)(Math.random() * 100.0D) - 50;
                  Client.field536 = (int)(Math.random() * 110.0D) - 55;
                  Client.field382 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field347 = 0;
                  Client.field369 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field319 = class40.field806;
                  Client.field320 = class40.field806;
                  Client.field332 = 0;
                  class45.field894 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class45.field893[var0] = null;
                     class45.field892[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field292 = -1;
                  Client.projectiles.method2324();
                  Client.field426.method2324();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field359 = new Deque();
                  Client.field506 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class170.field2346; ++var0) {
                     class187 var9 = (class187)class187.field2780.get((long)var0);
                     class187 var10;
                     if(var9 != null) {
                        var10 = var9;
                     } else {
                        byte[] var17 = class187.field2777.getConfigData(16, var0);
                        var9 = new class187();
                        if(null != var17) {
                           var9.method3334(new Buffer(var17));
                        }

                        class187.field2780.put(var9, (long)var0);
                        var10 = var9;
                     }

                     if(null != var10) {
                        class165.settings[var0] = 0;
                        class165.widgetSettings[var0] = 0;
                     }
                  }

                  Client.chatMessages.method804();
                  Client.field459 = -1;
                  if(Client.widgetRoot != -1) {
                     class97.method1866(Client.widgetRoot);
                  }

                  for(WidgetNode var19 = (WidgetNode)Client.componentTable.method2283(); var19 != null; var19 = (WidgetNode)Client.componentTable.method2277()) {
                     WallObject.method1832(var19, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field455 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field470.method3040((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerOptions[var0] = null;
                     Client.playerOptionsPriority[var0] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  Client.field302 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field497[var0] = true;
                  }

                  Client.field336.method2963(104);
                  Client.field336.method2708(Tile.method1515());
                  Client.field336.method2709(class16.field186);
                  Client.field336.method2709(ChatMessages.field907);
                  Client.field519 = null;
                  class162.clanChatCount = 0;
                  class57.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class15.field167 = null;
                  class103.method1933(Client.field352);
                  GroundObject.field1301 = -1;
                  World.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            }
         }
      } catch (IOException var13) {
         if(Client.field329 < 1) {
            if(class26.field602 == class0.field6) {
               class26.field602 = CombatInfo2.field2843;
            } else {
               class26.field602 = class0.field6;
            }

            ++Client.field329;
            Client.field327 = 0;
         } else {
            class18.method161(-2);
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1790081554"
   )
   static final void method691(Widget var0, int var1, int var2) {
      if(Client.field347 == 0 || Client.field347 == 3) {
         if(class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4) {
            class164 var3 = var0.method3100(true);
            if(var3 == null) {
               return;
            }

            int var4 = class115.field1809 - var1;
            int var5 = class115.field1796 - var2;
            if(var3.method3030(var4, var5)) {
               var4 -= var3.field2164 / 2;
               var5 -= var3.field2165 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class84.field1444[var6];
               int var8 = class84.field1453[var6];
               var7 = (256 + Client.mapScaleDelta) * var7 >> 8;
               var8 = var8 * (Client.mapScaleDelta + 256) >> 8;
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = XItemContainer.localPlayer.x + var9 >> 7;
               int var12 = XItemContainer.localPlayer.y - var10 >> 7;
               Client.field336.method2963(234);
               Client.field336.method2708(18);
               Client.field336.method2756(class103.baseY + var12);
               Client.field336.method2733(class105.field1709[82]?(class105.field1709[81]?2:1):0);
               Client.field336.method2756(class22.baseX + var11);
               Client.field336.method2708(var4);
               Client.field336.method2708(var5);
               Client.field336.method2709(Client.mapAngle);
               Client.field336.method2708(57);
               Client.field336.method2708(Client.mapScale);
               Client.field336.method2708(Client.mapScaleDelta);
               Client.field336.method2708(89);
               Client.field336.method2709(XItemContainer.localPlayer.x);
               Client.field336.method2709(XItemContainer.localPlayer.y);
               Client.field336.method2708(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1398900596"
   )
   static final void method692() {
      if(null != class30.field698) {
         class30.field698.method2006();
         class30.field698 = null;
      }

      class156.method2929();
      class0.region.method1658();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2179();
      }

      System.gc();
      Renderable.method1825(2);
      Client.field530 = -1;
      Client.field531 = false;
      class9.method96();
      class103.setGameState(10);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-13403"
   )
   public static void method694(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1798 = 0;
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }
}
