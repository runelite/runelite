import java.awt.Component;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class20 implements Runnable {
   @ObfuscatedName("q")
   int[] field214 = new int[500];
   @ObfuscatedName("c")
   Object field215 = new Object();
   @ObfuscatedName("f")
   public static String field216;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 631976301
   )
   int field217 = 0;
   @ObfuscatedName("t")
   int[] field218 = new int[500];
   @ObfuscatedName("d")
   boolean field219 = true;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1887149107
   )
   protected static int field221;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1600711749"
   )
   static final void method205(Actor var0) {
      var0.field602 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = NPCComposition.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field611;
            if(var0.poseFrame < var1.frameIDs.length && var0.field611 > var1.frameLenghts[var0.poseFrame]) {
               var0.field611 = 1;
               ++var0.poseFrame;
               World.method641(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field611 = 0;
               var0.poseFrame = 0;
               World.method641(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field639) {
         if(var0.field637 < 0) {
            var0.field637 = 0;
         }

         int var3 = class190.method3462(var0.graphic).field2811;
         if(var3 != -1) {
            Sequence var2 = NPCComposition.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field631;
               if(var0.field637 < var2.frameIDs.length && var0.field631 > var2.frameLenghts[var0.field637]) {
                  var0.field631 = 1;
                  ++var0.field637;
                  World.method641(var2, var0.field637, var0.x, var0.y);
               }

               if(var0.field637 >= var2.frameIDs.length && (var0.field637 < 0 || var0.field637 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = NPCComposition.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field658 > 0 && var0.field638 <= Client.gameCycle && var0.field646 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = NPCComposition.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field633;
            if(var0.actionFrame < var1.frameIDs.length && var0.field633 > var1.frameLenghts[var0.actionFrame]) {
               var0.field633 = 1;
               ++var0.actionFrame;
               World.method641(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field635;
               if(var0.field635 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  World.method641(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field602 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   static final void method211() {
      try {
         if(Client.loginState == 0) {
            if(Friend.rssocket != null) {
               Friend.rssocket.method2093();
               Friend.rssocket = null;
            }

            class122.field1884 = null;
            Client.field336 = false;
            Client.field315 = 0;
            Client.loginState = 1;
         }

         if(Client.loginState == 1) {
            if(class122.field1884 == null) {
               class122.field1884 = class45.field896.method1975(Script.host, class109.field1736);
            }

            if(class122.field1884.field1653 == 2) {
               throw new IOException();
            }

            if(class122.field1884.field1653 == 1) {
               Friend.rssocket = new RSSocket((Socket)class122.field1884.field1657, class45.field896);
               class122.field1884 = null;
               Client.loginState = 2;
            }
         }

         if(Client.loginState == 2) {
            Client.egressBuffer.offset = 0;
            Client.egressBuffer.putByte(14);
            Friend.rssocket.queueForWrite(Client.egressBuffer.payload, 0, 1);
            Client.ingressBuffer.offset = 0;
            Client.loginState = 3;
         }

         int var0;
         if(Client.loginState == 3) {
            if(class8.field70 != null) {
               class8.field70.method1067();
            }

            if(class6.field56 != null) {
               class6.field56.method1067();
            }

            var0 = Friend.rssocket.readByte();
            if(class8.field70 != null) {
               class8.field70.method1067();
            }

            if(class6.field56 != null) {
               class6.field56.method1067();
            }

            if(var0 != 0) {
               class8.method103(var0);
               return;
            }

            Client.ingressBuffer.offset = 0;
            Client.loginState = 4;
         }

         if(Client.loginState == 4) {
            if(Client.ingressBuffer.offset < 8) {
               var0 = Friend.rssocket.available();
               if(var0 > 8 - Client.ingressBuffer.offset) {
                  var0 = 8 - Client.ingressBuffer.offset;
               }

               if(var0 > 0) {
                  Friend.rssocket.read(Client.ingressBuffer.payload, Client.ingressBuffer.offset, var0);
                  Client.ingressBuffer.offset += var0;
               }
            }

            if(Client.ingressBuffer.offset == 8) {
               Client.ingressBuffer.offset = 0;
               GameEngine.field1784 = Client.ingressBuffer.readLong();
               Client.loginState = 5;
            }
         }

         int var1;
         int var2;
         if(Client.loginState == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(GameEngine.field1784 >> 32), (int)(GameEngine.field1784 & -1L)};
            Client.egressBuffer.offset = 0;
            Client.egressBuffer.putByte(1);
            Client.egressBuffer.putByte(class41.field837.vmethod4163());
            Client.egressBuffer.putInt(var5[0]);
            Client.egressBuffer.putInt(var5[1]);
            Client.egressBuffer.putInt(var5[2]);
            Client.egressBuffer.putInt(var5[3]);
            switch(class41.field837.field1622) {
            case 0:
            case 2:
               Client.egressBuffer.put24bitInt(class122.authCodeForLogin);
               Client.egressBuffer.offset += 5;
               break;
            case 1:
               Client.egressBuffer.putInt(((Integer)Actor.field656.preferences.get(Integer.valueOf(class36.method755(class41.username)))).intValue());
               Client.egressBuffer.offset += 4;
               break;
            case 3:
               Client.egressBuffer.offset += 8;
            }

            Client.egressBuffer.method2504(class41.password);
            Client.egressBuffer.method2483(class39.rsaKeyExponent, class39.rsaKeyModulus);
            Client.loginBuffer.offset = 0;
            if(Client.gameState == 40) {
               Client.loginBuffer.putByte(18);
            } else {
               Client.loginBuffer.putByte(16);
            }

            Client.loginBuffer.putShort(0);
            var1 = Client.loginBuffer.offset;
            Client.loginBuffer.putInt(140);
            Client.loginBuffer.putBytes(Client.egressBuffer.payload, 0, Client.egressBuffer.offset);
            var2 = Client.loginBuffer.offset;
            Client.loginBuffer.method2504(class41.username);
            Client.loginBuffer.putByte((Client.isResized?1:0) << 1 | (Client.field285?1:0));
            Client.loginBuffer.putShort(class187.field2760);
            Client.loginBuffer.putShort(IndexDataBase.field2726);
            class65.method1195(Client.loginBuffer);
            Client.loginBuffer.method2504(Client.field287);
            Client.loginBuffer.putInt(class10.field97);
            Buffer var3 = new Buffer(class5.field49.method4344());
            class5.field49.method4341(var3);
            Client.loginBuffer.putBytes(var3.payload, 0, var3.payload.length);
            Client.loginBuffer.putByte(class10.field106);
            Client.loginBuffer.putInt(0);
            Client.loginBuffer.putInt(class122.indexInterfaces.field2721);
            Client.loginBuffer.putInt(class33.indexSoundEffects.field2721);
            Client.loginBuffer.putInt(class213.field3150.field2721);
            Client.loginBuffer.putInt(class8.field78.field2721);
            Client.loginBuffer.putInt(class199.field2882.field2721);
            Client.loginBuffer.putInt(FileOnDisk.indexMaps.field2721);
            Client.loginBuffer.putInt(class18.indexTrack1.field2721);
            Client.loginBuffer.putInt(class45.indexModels.field2721);
            Client.loginBuffer.putInt(WallObject.indexSprites.field2721);
            Client.loginBuffer.putInt(class214.indexTextures.field2721);
            Client.loginBuffer.putInt(Client.field312.field2721);
            Client.loginBuffer.putInt(KitDefinition.indexTrack2.field2721);
            Client.loginBuffer.putInt(class107.indexScripts.field2721);
            Client.loginBuffer.putInt(DecorativeObject.field1584.field2721);
            Client.loginBuffer.putInt(class9.field84.field2721);
            Client.loginBuffer.putInt(class16.field177.field2721);
            Client.loginBuffer.encryptXtea(var5, var2, Client.loginBuffer.offset);
            Client.loginBuffer.method2379(Client.loginBuffer.offset - var1);
            Friend.rssocket.queueForWrite(Client.loginBuffer.payload, 0, Client.loginBuffer.offset);
            Client.egressBuffer.seed(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.ingressBuffer.seed(var5);
            Client.loginState = 6;
         }

         if(Client.loginState == 6 && Friend.rssocket.available() > 0) {
            var0 = Friend.rssocket.readByte();
            if(var0 == 21 && Client.gameState == 20) {
               Client.loginState = 7;
            } else if(var0 == 2) {
               Client.loginState = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.packetLength = -1;
               Client.loginState = 13;
            } else if(var0 == 23 && Client.field316 < 1) {
               ++Client.field316;
               Client.loginState = 0;
            } else {
               if(var0 != 29) {
                  class8.method103(var0);
                  return;
               }

               Client.loginState = 11;
            }
         }

         if(Client.loginState == 7 && Friend.rssocket.available() > 0) {
            Client.field317 = (Friend.rssocket.readByte() + 3) * 60;
            Client.loginState = 8;
         }

         if(Client.loginState == 8) {
            Client.field315 = 0;
            class45.method854("You have only just left another world.", "Your profile will be transferred in:", Client.field317 / 60 + " seconds.");
            if(--Client.field317 <= 0) {
               Client.loginState = 0;
            }

         } else {
            if(Client.loginState == 9 && Friend.rssocket.available() >= 13) {
               boolean var11 = Friend.rssocket.readByte() == 1;
               Friend.rssocket.read(Client.ingressBuffer.payload, 0, 4);
               Client.ingressBuffer.offset = 0;
               boolean var10 = false;
               if(var11) {
                  var1 = Client.ingressBuffer.readOpcode() << 24;
                  var1 |= Client.ingressBuffer.readOpcode() << 16;
                  var1 |= Client.ingressBuffer.readOpcode() << 8;
                  var1 |= Client.ingressBuffer.readOpcode();
                  var2 = class36.method755(class41.username);
                  if(Actor.field656.preferences.size() >= 10 && !Actor.field656.preferences.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = Actor.field656.preferences.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  Actor.field656.preferences.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  Renderable.method1896();
               }

               Client.field517 = Friend.rssocket.readByte();
               Client.field278 = Friend.rssocket.readByte() == 1;
               Client.localInteractingIndex = Friend.rssocket.readByte();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += Friend.rssocket.readByte();
               Client.field406 = Friend.rssocket.readByte();
               Friend.rssocket.read(Client.ingressBuffer.payload, 0, 1);
               Client.ingressBuffer.offset = 0;
               Client.packetOpcode = Client.ingressBuffer.readOpcode();
               Friend.rssocket.read(Client.ingressBuffer.payload, 0, 2);
               Client.ingressBuffer.offset = 0;
               Client.packetLength = Client.ingressBuffer.readUnsignedShort();

               try {
                  class100.method1950(Client.field279, "zap");
               } catch (Throwable var8) {
                  ;
               }

               Client.loginState = 10;
            }

            if(Client.loginState == 10) {
               if(Friend.rssocket.available() >= Client.packetLength) {
                  Client.ingressBuffer.offset = 0;
                  Friend.rssocket.read(Client.ingressBuffer.payload, 0, Client.packetLength);
                  Client.field405 = -1L;
                  Client.field555 = -1;
                  class180.field2678.field217 = 0;
                  KitDefinition.field2831 = true;
                  Client.field295 = true;
                  Client.field511 = -1L;
                  ItemLayer.method1477();
                  Client.egressBuffer.offset = 0;
                  Client.ingressBuffer.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field538 = -1;
                  Client.field417 = -1;
                  Client.field466 = -1;
                  Client.field330 = 0;
                  Client.field495 = 0;
                  Client.field489 = 0;
                  Client.field298 = 0;
                  Client.menuOptionCount = 0;
                  Client.field431 = -1;
                  Client.isMenuOpen = false;
                  class49.method915(0);
                  class47.method902();
                  Client.field351 = 0;
                  Client.field440 = false;
                  Client.field528 = 0;
                  Client.field346 = (int)(Math.random() * 100.0D) - 50;
                  Client.field526 = (int)(Math.random() * 110.0D) - 55;
                  Client.field425 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field522 = 0;
                  Client.field515 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field306 = class40.field807;
                  Client.field307 = class40.field807;
                  Client.field321 = 0;
                  class45.field891 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class45.field890[var0] = null;
                     class45.field889[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field472 = -1;
                  Client.projectiles.method2823();
                  Client.field531.method2823();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field415 = new Deque();
                  Client.field554 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class189.field2783; ++var0) {
                     class189 var16 = RSSocket.method2096(var0);
                     if(var16 != null) {
                        class167.settings[var0] = 0;
                        class167.widgetSettings[var0] = 0;
                     }
                  }

                  XClanMember.chatMessages.method861();
                  Client.field310 = -1;
                  if(Client.widgetRoot != -1) {
                     Actor.method594(Client.widgetRoot);
                  }

                  for(WidgetNode var14 = (WidgetNode)Client.componentTable.method2776(); var14 != null; var14 = (WidgetNode)Client.componentTable.method2777()) {
                     FrameMap.method1718(var14, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field449 = null;
                  Client.menuOptionCount = 0;
                  Client.field431 = -1;
                  Client.isMenuOpen = false;
                  Client.field559.method3146((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerOptions[var0] = null;
                     Client.playerOptionsPriorities[var0] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  Client.field289 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field368[var0] = true;
                  }

                  Actor.method593();
                  Client.field485 = null;
                  class85.clanChatCount = 0;
                  Client.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  IndexData.field2745 = null;
                  class5.method76(Client.ingressBuffer);
                  Actor.field619 = -1;
                  class9.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.loginState == 11 && Friend.rssocket.available() >= 2) {
                  Client.ingressBuffer.offset = 0;
                  Friend.rssocket.read(Client.ingressBuffer.payload, 0, 2);
                  Client.ingressBuffer.offset = 0;
                  class10.field111 = Client.ingressBuffer.readUnsignedShort();
                  Client.loginState = 12;
               }

               if(Client.loginState == 12 && Friend.rssocket.available() >= class10.field111) {
                  Client.ingressBuffer.offset = 0;
                  Friend.rssocket.read(Client.ingressBuffer.payload, 0, class10.field111);
                  Client.ingressBuffer.offset = 0;
                  String var13 = Client.ingressBuffer.readString();
                  String var7 = Client.ingressBuffer.readString();
                  String var6 = Client.ingressBuffer.readString();
                  class45.method854(var13, var7, var6);
                  class9.setGameState(10);
               }

               if(Client.loginState != 13) {
                  ++Client.field315;
                  if(Client.field315 > 2000) {
                     if(Client.field316 < 1) {
                        if(class109.field1736 == class18.field194) {
                           class109.field1736 = RSSocket.field1747;
                        } else {
                           class109.field1736 = class18.field194;
                        }

                        ++Client.field316;
                        Client.loginState = 0;
                     } else {
                        class8.method103(-3);
                     }
                  }
               } else {
                  if(Client.packetLength == -1) {
                     if(Friend.rssocket.available() < 2) {
                        return;
                     }

                     Friend.rssocket.read(Client.ingressBuffer.payload, 0, 2);
                     Client.ingressBuffer.offset = 0;
                     Client.packetLength = Client.ingressBuffer.readUnsignedShort();
                  }

                  if(Friend.rssocket.available() >= Client.packetLength) {
                     Friend.rssocket.read(Client.ingressBuffer.payload, 0, Client.packetLength);
                     Client.ingressBuffer.offset = 0;
                     var0 = Client.packetLength;
                     Client.egressBuffer.offset = 0;
                     Client.ingressBuffer.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field538 = -1;
                     Client.field417 = -1;
                     Client.field466 = -1;
                     Client.packetLength = 0;
                     Client.field330 = 0;
                     Client.field495 = 0;
                     Client.menuOptionCount = 0;
                     Client.field431 = -1;
                     Client.isMenuOpen = false;
                     Client.field522 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class22.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var15 = Client.cachedNPCs[var1];
                        if(var15 != null) {
                           var15.interacting = -1;
                           var15.field614 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     class9.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field368[var1] = true;
                     }

                     Actor.method593();
                     class5.method76(Client.ingressBuffer);
                     if(var0 != Client.ingressBuffer.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field316 < 1) {
            if(class18.field194 == class109.field1736) {
               class109.field1736 = RSSocket.field1747;
            } else {
               class109.field1736 = class18.field194;
            }

            ++Client.field316;
            Client.loginState = 0;
         } else {
            class8.method103(-2);
         }
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-457734676"
   )
   static final void method212(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field415.method2828(); var10 != null; var10 = (class25)Client.field415.method2830()) {
         if(var0 == var10.field579 && var10.field573 == var1 && var2 == var10.field574 && var3 == var10.field572) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field579 = var0;
         var9.field572 = var3;
         var9.field573 = var1;
         var9.field574 = var2;
         class105.method2020(var9);
         Client.field415.method2824(var9);
      }

      var9.field577 = var4;
      var9.field580 = var5;
      var9.field578 = var6;
      var9.field581 = var7;
      var9.field582 = var8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "2031713147"
   )
   static void method213(GameEngine var0) {
      int var1;
      int var12;
      int var13;
      int var15;
      if(class41.worldSelectShown) {
         if(class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4) {
            var1 = class41.field821 + 280;
            if(class115.field1802 >= var1 && class115.field1802 <= var1 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
               WidgetNode.method194(0, 0);
            } else if(class115.field1802 >= var1 + 15 && class115.field1802 <= var1 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
               WidgetNode.method194(0, 1);
            } else {
               var12 = class41.field821 + 390;
               if(class115.field1802 >= var12 && class115.field1802 <= var12 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                  WidgetNode.method194(1, 0);
               } else if(class115.field1802 >= var12 + 15 && class115.field1802 <= var12 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                  WidgetNode.method194(1, 1);
               } else {
                  var13 = class41.field821 + 500;
                  if(class115.field1802 >= var13 && class115.field1802 <= var13 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                     WidgetNode.method194(2, 0);
                  } else if(class115.field1802 >= var13 + 15 && class115.field1802 <= var13 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                     WidgetNode.method194(2, 1);
                  } else {
                     var15 = class41.field821 + 610;
                     if(class115.field1802 >= var15 && class115.field1802 <= var15 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                        WidgetNode.method194(3, 0);
                     } else if(class115.field1802 >= var15 + 15 && class115.field1802 <= var15 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                        WidgetNode.method194(3, 1);
                     } else if(class115.field1802 >= class41.field821 + 708 && class115.field1813 >= 4 && class115.field1802 <= class41.field821 + 708 + 50 && class115.field1813 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field815.method4295(class41.field821, 0);
                        class41.field816.method4295(class41.field821 + 382, 0);
                        class41.field844.method4170(class41.field821 + 382 - class41.field844.originalWidth / 2, 18);
                     } else if(class41.field812 != -1) {
                        World var9 = World.worldList[class41.field812];
                        class7.method100(var9);
                        class41.worldSelectShown = false;
                        class41.field815.method4295(class41.field821, 0);
                        class41.field816.method4295(class41.field821 + 382, 0);
                        class41.field844.method4170(class41.field821 + 382 - class41.field844.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4) && class115.field1802 >= class41.field821 + 765 - 50 && class115.field1813 >= 453) {
            Actor.field656.field691 = !Actor.field656.field691;
            Renderable.method1896();
            if(!Actor.field656.field691) {
               ISAACCipher.method2662(class18.indexTrack1, "scape main", "", 255, false);
            } else {
               MessageNode.method218();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field826;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field286 == 0) {
                  if(class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4) {
                     var1 = class41.field821 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class115.field1802 >= var1 && class115.field1802 <= var1 + var3 && class115.field1813 >= var2 && class115.field1813 <= var2 + var4) {
                        if(class199.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class132.worldServersDownload != null && class199.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1811;
               var12 = class115.field1802;
               var13 = class115.field1813;
               if(!CombatInfo1.field662 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class41.loginIndex == 0) {
                  boolean var14 = false;

                  while(ChatLineBuffer.method925()) {
                     if(class177.field2652 == 84) {
                        var14 = true;
                     }
                  }

                  var5 = class41.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var12 >= var5 - 75 && var12 <= var5 + 75 && var13 >= var6 - 20 && var13 <= var6 + 20) {
                     String var7 = Friend.method184("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class128.method2366(var7, true, "openjs", false);
                  }

                  var5 = class41.loginWindowX + 180 + 80;
                  if(var1 == 1 && var12 >= var5 - 75 && var12 <= var5 + 75 && var13 >= var6 - 20 && var13 <= var6 + 20 || var14) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field840 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field840 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field840 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var17;
                  if(class41.loginIndex != 1) {
                     short var16;
                     if(class41.loginIndex == 2) {
                        var16 = 231;
                        var15 = var16 + 30;
                        if(var1 == 1 && var13 >= var15 - 15 && var13 < var15) {
                           class41.loginIndex2 = 0;
                        }

                        var15 += 15;
                        if(var1 == 1 && var13 >= var15 - 15 && var13 < var15) {
                           class41.loginIndex2 = 1;
                        }

                        var15 += 15;
                        var16 = 361;
                        if(var1 == 1 && var13 >= var16 - 15 && var13 < var16) {
                           class45.method854("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var5 = class41.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var12 >= var5 - 75 && var12 <= var5 + 75 && var13 >= var6 - 20 && var13 <= var6 + 20) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class45.method854("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.password.length() == 0) {
                              class45.method854("", "Please enter your password.", "");
                              return;
                           }

                           class45.method854("", "Connecting to server...", "");
                           class41.field837 = Actor.field656.preferences.containsKey(Integer.valueOf(class36.method755(class41.username)))?class97.field1621:class97.field1620;
                           class9.setGameState(20);
                           return;
                        }

                        var5 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var12 >= var5 - 75 && var12 <= var5 + 75 && var13 >= var6 - 20 && var13 <= var6 + 20) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.password = "";
                           class122.authCodeForLogin = 0;
                           class94.authCode = "";
                           class41.field843 = true;
                        }

                        while(true) {
                           while(ChatLineBuffer.method925()) {
                              boolean var10 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class25.field571 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(class177.field2652 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.password = "";
                                 class122.authCodeForLogin = 0;
                                 class94.authCode = "";
                                 class41.field843 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class177.field2652 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class177.field2652 == 84 || class177.field2652 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var10 && class41.username.length() < 320) {
                                    class41.username = class41.username + class25.field571;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class177.field2652 == 85 && class41.password.length() > 0) {
                                    class41.password = class41.password.substring(0, class41.password.length() - 1);
                                 }

                                 if(class177.field2652 == 84 || class177.field2652 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class177.field2652 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class45.method854("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.password.length() == 0) {
                                       class45.method854("", "Please enter your password.", "");
                                       return;
                                    }

                                    class45.method854("", "Connecting to server...", "");
                                    class41.field837 = Actor.field656.preferences.containsKey(Integer.valueOf(class36.method755(class41.username)))?class97.field1621:class97.field1620;
                                    class9.setGameState(20);
                                    return;
                                 }

                                 if(var10 && class41.password.length() < 20) {
                                    class41.password = class41.password + class25.field571;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var15 = class41.loginWindowX + 180;
                        var17 = 276;
                        if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var15 = class41.loginWindowX + 180;
                        var17 = 326;
                        if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                           class45.method854("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var18;
                        int var19;
                        if(class41.loginIndex == 4) {
                           var15 = class41.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                              class94.authCode.trim();
                              if(class94.authCode.length() != 6) {
                                 class45.method854("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class122.authCodeForLogin = Integer.parseInt(class94.authCode);
                              class94.authCode = "";
                              class41.field837 = class41.field843?class97.field1619:class97.field1626;
                              class45.method854("", "Connecting to server...", "");
                              class9.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var12 >= class41.loginWindowX + 180 - 9 && var12 <= class41.loginWindowX + 180 + 130 && var13 >= 263 && var13 <= 296) {
                              class41.field843 = !class41.field843;
                           }

                           if(var1 == 1 && var12 >= class41.loginWindowX + 180 - 34 && var12 <= class41.loginWindowX + 180 + 34 && var13 >= 351 && var13 <= 363) {
                              String var11 = Friend.method184("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              class128.method2366(var11, true, "openjs", false);
                           }

                           var15 = class41.loginWindowX + 180 + 80;
                           if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.password = "";
                              class122.authCodeForLogin = 0;
                              class94.authCode = "";
                           }

                           while(ChatLineBuffer.method925()) {
                              var18 = false;

                              for(var19 = 0; var19 < "1234567890".length(); ++var19) {
                                 if(class25.field571 == "1234567890".charAt(var19)) {
                                    var18 = true;
                                    break;
                                 }
                              }

                              if(class177.field2652 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.password = "";
                                 class122.authCodeForLogin = 0;
                                 class94.authCode = "";
                              } else {
                                 if(class177.field2652 == 85 && class94.authCode.length() > 0) {
                                    class94.authCode = class94.authCode.substring(0, class94.authCode.length() - 1);
                                 }

                                 if(class177.field2652 == 84) {
                                    class94.authCode.trim();
                                    if(class94.authCode.length() != 6) {
                                       class45.method854("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class122.authCodeForLogin = Integer.parseInt(class94.authCode);
                                    class94.authCode = "";
                                    class41.field837 = class41.field843?class97.field1619:class97.field1626;
                                    class45.method854("", "Connecting to server...", "");
                                    class9.setGameState(20);
                                    return;
                                 }

                                 if(var18 && class94.authCode.length() < 6) {
                                    class94.authCode = class94.authCode + class25.field571;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var15 = class41.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                              class112.method2114();
                              return;
                           }

                           var15 = class41.loginWindowX + 180 + 80;
                           if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.password = "";
                           }

                           while(ChatLineBuffer.method925()) {
                              var18 = false;

                              for(var19 = 0; var19 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var19) {
                                 if(class25.field571 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var19)) {
                                    var18 = true;
                                    break;
                                 }
                              }

                              if(class177.field2652 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.password = "";
                              } else {
                                 if(class177.field2652 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class177.field2652 == 84) {
                                    class112.method2114();
                                    return;
                                 }

                                 if(var18 && class41.username.length() < 320) {
                                    class41.username = class41.username + class25.field571;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!ChatLineBuffer.method925()) {
                                    var16 = 321;
                                    if(var1 == 1 && var13 >= var16 - 20 && var13 <= var16 + 20) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.password = "";
                                    }

                                    return;
                                 }
                              } while(class177.field2652 != 84 && class177.field2652 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.password = "";
                           }
                        }
                     }
                  } else {
                     while(ChatLineBuffer.method925()) {
                        if(class177.field2652 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class177.field2652 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var15 = class41.loginWindowX + 180 - 80;
                     var17 = 321;
                     if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var15 = class41.loginWindowX + 180 + 80;
                     if(var1 == 1 && var12 >= var15 - 75 && var12 <= var15 + 75 && var13 >= var17 - 20 && var13 <= var17 + 20) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "2"
   )
   public static void method214(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   public void run() {
      for(; this.field219; class0.method14(50L)) {
         Object var1 = this.field215;
         synchronized(this.field215) {
            if(this.field217 < 500) {
               this.field214[this.field217] = class115.field1805;
               this.field218[this.field217] = class115.field1806;
               ++this.field217;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "80"
   )
   public static byte[] method215() {
      byte[] var0 = new byte[24];

      try {
         class104.field1679.method1395(0L);
         class104.field1679.method1397(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
