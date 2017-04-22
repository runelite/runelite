import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("i")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("u")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("f")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-79047720"
   )
   static final boolean method146(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "19136770"
   )
   static void method148() {
      Client.field339 = -1L;
      Client.field316 = -1;
      Client.field400.field234 = 0;
      class114.field1803 = true;
      Client.field554 = true;
      Client.field488 = -1L;
      CipherBuffer.method3122();
      Client.secretCipherBuffer1.offset = 0;
      Client.secretCipherBuffer2.offset = 0;
      Client.packetOpcode = -1;
      Client.field352 = 1;
      Client.field424 = -1;
      Client.field354 = -1;
      Client.field350 = 0;
      Client.field319 = 0;
      Client.field355 = 0;
      Client.field320 = 0;
      class37.method762();
      Actor.method588(0);
      class47.chatLineMap.clear();
      class47.field949.method2382();
      class47.field952.method2534();
      class47.field953 = 0;
      Client.field455 = 0;
      Client.field458 = false;
      Client.field545 = 0;
      Client.field366 = (int)(Math.random() * 100.0D) - 50;
      Client.field573 = (int)(Math.random() * 110.0D) - 55;
      Client.field370 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field539 = 0;
      Client.field459 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field328 = class40.field827;
      Client.field392 = class40.field827;
      Client.field402 = 0;
      CombatInfoListHolder.method733();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field340 = -1;
      Client.projectiles.method2458();
      Client.field391.method2458();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field461 = new Deque();
      Client.field571 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2789; ++var0) {
         class187 var3 = class109.method2096(var0);
         if(var3 != null) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      class9.chatMessages.method886();
      Client.field471 = -1;
      if(Client.widgetRoot != -1) {
         ISAACCipher.method3132(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method2420(); var4 != null; var4 = (WidgetNode)Client.componentTable.method2422()) {
         Item.method828(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field467 = null;
      class37.method762();
      Client.field509.method3231((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriority[var0] = false;
      }

      Ignore.method179();
      Client.field578 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field508[var0] = true;
      }

      class94.method1950();
      Client.field530 = null;
      VertexNormal.clanChatCount = 0;
      class156.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class13.field138 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113547086"
   )
   static final void method151() {
      try {
         if(Client.field406 == 0) {
            if(class20.rssocket != null) {
               class20.rssocket.method2113();
               class20.rssocket = null;
            }

            WidgetNode.field196 = null;
            Client.field517 = false;
            Client.field335 = 0;
            Client.field406 = 1;
         }

         if(Client.field406 == 1) {
            if(WidgetNode.field196 == null) {
               WidgetNode.field196 = class108.field1755.method2003(XGrandExchangeOffer.host, Client.field431);
            }

            if(WidgetNode.field196.field1686 == 2) {
               throw new IOException();
            }

            if(WidgetNode.field196.field1686 == 1) {
               class20.rssocket = new RSSocket((Socket)WidgetNode.field196.field1690, class108.field1755);
               WidgetNode.field196 = null;
               Client.field406 = 2;
            }
         }

         if(Client.field406 == 2) {
            Client.secretCipherBuffer1.offset = 0;
            Client.secretCipherBuffer1.putByte(14);
            class20.rssocket.queueForWrite(Client.secretCipherBuffer1.payload, 0, 1);
            Client.secretCipherBuffer2.offset = 0;
            Client.field406 = 3;
         }

         int var0;
         if(Client.field406 == 3) {
            if(class2.field23 != null) {
               class2.field23.method1083();
            }

            if(class137.field1927 != null) {
               class137.field1927.method1083();
            }

            var0 = class20.rssocket.method2102();
            if(class2.field23 != null) {
               class2.field23.method1083();
            }

            if(class137.field1927 != null) {
               class137.field1927.method1083();
            }

            if(var0 != 0) {
               class36.method755(var0);
               return;
            }

            Client.secretCipherBuffer2.offset = 0;
            Client.field406 = 4;
         }

         if(Client.field406 == 4) {
            if(Client.secretCipherBuffer2.offset < 8) {
               var0 = class20.rssocket.available();
               if(var0 > 8 - Client.secretCipherBuffer2.offset) {
                  var0 = 8 - Client.secretCipherBuffer2.offset;
               }

               if(var0 > 0) {
                  class20.rssocket.read(Client.secretCipherBuffer2.payload, Client.secretCipherBuffer2.offset, var0);
                  Client.secretCipherBuffer2.offset += var0;
               }
            }

            if(Client.secretCipherBuffer2.offset == 8) {
               Client.secretCipherBuffer2.offset = 0;
               ChatMessages.field946 = Client.secretCipherBuffer2.readLong();
               Client.field406 = 5;
            }
         }

         int var1;
         int var2;
         if(Client.field406 == 5) {
            int[] var3 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(ChatMessages.field946 >> 32), (int)(ChatMessages.field946 & -1L)};
            Client.secretCipherBuffer1.offset = 0;
            Client.secretCipherBuffer1.putByte(1);
            Client.secretCipherBuffer1.putByte(class41.field858.vmethod4085());
            Client.secretCipherBuffer1.putInt(var3[0]);
            Client.secretCipherBuffer1.putInt(var3[1]);
            Client.secretCipherBuffer1.putInt(var3[2]);
            Client.secretCipherBuffer1.putInt(var3[3]);
            switch(class41.field858.field1653) {
            case 0:
            case 2:
               Client.secretCipherBuffer1.put24bitInt(CombatInfo1.authCodeForLogin);
               Client.secretCipherBuffer1.offset += 5;
               break;
            case 1:
               Client.secretCipherBuffer1.offset += 8;
               break;
            case 3:
               Client.secretCipherBuffer1.putInt(((Integer)class148.field2058.preferences.get(Integer.valueOf(class108.method2088(class41.username)))).intValue());
               Client.secretCipherBuffer1.offset += 4;
            }

            Client.secretCipherBuffer1.method2931(class41.password);
            Client.secretCipherBuffer1.method2888(class39.rsaKeyExponent, class39.rsaKeyModulus);
            Client.field346.offset = 0;
            if(Client.gameState == 40) {
               Client.field346.putByte(18);
            } else {
               Client.field346.putByte(16);
            }

            Client.field346.putShort(0);
            var1 = Client.field346.offset;
            Client.field346.putInt(139);
            Client.field346.putBytes(Client.secretCipherBuffer1.payload, 0, Client.secretCipherBuffer1.offset);
            var2 = Client.field346.offset;
            Client.field346.method2931(class41.username);
            Client.field346.putByte((Client.isResized?1:0) << 1 | (Client.field306?1:0));
            Client.field346.putShort(class32.field755);
            Client.field346.putShort(class168.field2207);
            Actor.method571(Client.field346);
            Client.field346.method2931(class156.field2133);
            Client.field346.putInt(Client.field377);
            Buffer var4 = new Buffer(WallObject.field1573.method4271());
            WallObject.field1573.method4270(var4);
            Client.field346.putBytes(var4.payload, 0, var4.payload.length);
            Client.field346.putByte(ScriptState.field113);
            Client.field346.putInt(0);
            Client.field346.putInt(class157.field2137.field2737);
            Client.field346.putInt(ChatLineBuffer.indexConfigs.field2737);
            Client.field346.putInt(ChatLineBuffer.field990.field2737);
            Client.field346.putInt(class37.indexInterfaces.field2737);
            Client.field346.putInt(IndexFile.indexSoundEffects.field2737);
            Client.field346.putInt(class205.indexMaps.field2737);
            Client.field346.putInt(Client.indexTrack1.field2737);
            Client.field346.putInt(CollisionData.indexModels.field2737);
            Client.field346.putInt(FileOnDisk.indexSprites.field2737);
            Client.field346.putInt(class171.indexTextures.field2737);
            Client.field346.putInt(WallObject.field1581.field2737);
            Client.field346.putInt(Friend.indexTrack2.field2737);
            Client.field346.putInt(Projectile.indexScripts.field2737);
            Client.field346.putInt(class5.field56.field2737);
            Client.field346.putInt(class57.field1083.field2737);
            Client.field346.putInt(Ignore.field215.field2737);
            Client.field346.encryptXtea(var3, var2, Client.field346.offset);
            Client.field346.method3048(Client.field346.offset - var1);
            class20.rssocket.queueForWrite(Client.field346.payload, 0, Client.field346.offset);
            Client.secretCipherBuffer1.seed(var3);

            for(int var5 = 0; var5 < 4; ++var5) {
               var3[var5] += 50;
            }

            Client.secretCipherBuffer2.seed(var3);
            Client.field406 = 6;
         }

         if(Client.field406 == 6 && class20.rssocket.available() > 0) {
            var0 = class20.rssocket.method2102();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field406 = 7;
            } else if(var0 == 2) {
               Client.field406 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field348 = -1;
               Client.field406 = 13;
            } else if(var0 == 23 && Client.field336 < 1) {
               ++Client.field336;
               Client.field406 = 0;
            } else {
               if(var0 != 29) {
                  class36.method755(var0);
                  return;
               }

               Client.field406 = 11;
            }
         }

         if(Client.field406 == 7 && class20.rssocket.available() > 0) {
            Client.field409 = (class20.rssocket.method2102() + 3) * 60;
            Client.field406 = 8;
         }

         if(Client.field406 == 8) {
            Client.field335 = 0;
            class65.method1204("You have only just left another world.", "Your profile will be transferred in:", Client.field409 / 60 + " seconds.");
            if(--Client.field409 <= 0) {
               Client.field406 = 0;
            }
         } else {
            if(Client.field406 == 9 && class20.rssocket.available() >= 13) {
               boolean var8 = class20.rssocket.method2102() == 1;
               class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, 4);
               Client.secretCipherBuffer2.offset = 0;
               boolean var11 = false;
               if(var8) {
                  var1 = Client.secretCipherBuffer2.readOpcode() << 24;
                  var1 |= Client.secretCipherBuffer2.readOpcode() << 16;
                  var1 |= Client.secretCipherBuffer2.readOpcode() << 8;
                  var1 |= Client.secretCipherBuffer2.readOpcode();
                  var2 = class108.method2088(class41.username);
                  if(class148.field2058.preferences.size() >= 10 && !class148.field2058.preferences.containsKey(Integer.valueOf(var2))) {
                     Iterator var13 = class148.field2058.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class148.field2058.preferences.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class150.method2839();
               }

               Client.field470 = class20.rssocket.method2102();
               Client.field368 = class20.rssocket.method2102() == 1;
               Client.localInteractingIndex = class20.rssocket.method2102();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class20.rssocket.method2102();
               Client.field313 = class20.rssocket.method2102();
               class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, 1);
               Client.secretCipherBuffer2.offset = 0;
               Client.packetOpcode = Client.secretCipherBuffer2.readOpcode();
               class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, 2);
               Client.secretCipherBuffer2.offset = 0;
               Client.field348 = Client.secretCipherBuffer2.readUnsignedShort();

               try {
                  class100.method1988(Client.field433, "zap");
               } catch (Throwable var6) {
                  ;
               }

               Client.field406 = 10;
            }

            if(Client.field406 == 10) {
               if(class20.rssocket.available() >= Client.field348) {
                  Client.secretCipherBuffer2.offset = 0;
                  class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, Client.field348);
                  method148();
                  RSSocket.method2100(Client.secretCipherBuffer2);
                  Friend.field161 = -1;
                  IndexDataBase.xteaChanged(false);
                  Client.packetOpcode = -1;
               }
            } else {
               if(Client.field406 == 11 && class20.rssocket.available() >= 2) {
                  Client.secretCipherBuffer2.offset = 0;
                  class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, 2);
                  Client.secretCipherBuffer2.offset = 0;
                  class33.field773 = Client.secretCipherBuffer2.readUnsignedShort();
                  Client.field406 = 12;
               }

               if(Client.field406 == 12 && class20.rssocket.available() >= class33.field773) {
                  Client.secretCipherBuffer2.offset = 0;
                  class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, class33.field773);
                  Client.secretCipherBuffer2.offset = 0;
                  String var9 = Client.secretCipherBuffer2.readString();
                  String var12 = Client.secretCipherBuffer2.readString();
                  String var14 = Client.secretCipherBuffer2.readString();
                  class65.method1204(var9, var12, var14);
                  GameObject.setGameState(10);
               }

               if(Client.field406 != 13) {
                  ++Client.field335;
                  if(Client.field335 > 2000) {
                     if(Client.field336 < 1) {
                        if(Client.field431 == class99.field1671) {
                           Client.field431 = class0.field4;
                        } else {
                           Client.field431 = class99.field1671;
                        }

                        ++Client.field336;
                        Client.field406 = 0;
                     } else {
                        class36.method755(-3);
                     }
                  }
               } else {
                  if(Client.field348 == -1) {
                     if(class20.rssocket.available() < 2) {
                        return;
                     }

                     class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, 2);
                     Client.secretCipherBuffer2.offset = 0;
                     Client.field348 = Client.secretCipherBuffer2.readUnsignedShort();
                  }

                  if(class20.rssocket.available() >= Client.field348) {
                     class20.rssocket.read(Client.secretCipherBuffer2.payload, 0, Client.field348);
                     Client.secretCipherBuffer2.offset = 0;
                     var0 = Client.field348;
                     Client.secretCipherBuffer1.offset = 0;
                     Client.secretCipherBuffer2.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field352 = 1;
                     Client.field424 = -1;
                     Client.field354 = -1;
                     Client.field348 = 0;
                     Client.field350 = 0;
                     Client.field319 = 0;
                     class37.method762();
                     Client.field539 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     Projectile.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var10 = Client.cachedNPCs[var1];
                        if(var10 != null) {
                           var10.interacting = -1;
                           var10.field677 = false;
                        }
                     }

                     Ignore.method179();
                     GameObject.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field508[var1] = true;
                     }

                     class94.method1950();
                     RSSocket.method2100(Client.secretCipherBuffer2);
                     if(Client.secretCipherBuffer2.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var7) {
         if(Client.field336 < 1) {
            if(class99.field1671 == Client.field431) {
               Client.field431 = class0.field4;
            } else {
               Client.field431 = class99.field1671;
            }

            ++Client.field336;
            Client.field406 = 0;
         } else {
            class36.method755(-2);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1741037495"
   )
   static int method152(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field355 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "121"
   )
   static String method153(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1790575288"
   )
   static final void method154(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field558 - Client.field325) / 100 + Client.field325;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.field563) {
         var10 = Client.field563;
         var6 = var2 * 334 * var10 / (var3 * 512);
         if(var6 > Client.field562) {
            var6 = Client.field562;
            var8 = var6 * var3 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4000();
               Rasterizer2D.method4007(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4007(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field564) {
         var10 = Client.field564;
         var6 = var10 * 334 * var2 / (var3 * 512);
         if(var6 < Client.field505) {
            var6 = Client.field505;
            var8 = var10 * 334 * var2 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4000();
               Rasterizer2D.method4007(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4007(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = var5 * (Client.field560 - Client.field559) / 100 + Client.field559;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || var3 != Client.camera3) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = var12 * 32 + 15 + 128;
            int var14 = var13 * 3 + 600;
            int var15 = class84.field1475[var13];
            var11[var12] = var14 * var15 >> 16;
         }

         Region.method1810(var11, 500, 800, var2, var3);
      }

      Client.field565 = var0;
      Client.field566 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIB)LFont;",
      garbageValue = "-1"
   )
   public static Font method157(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      return !VertexNormal.method1667(var0, var2, var3)?null:CombatInfoListHolder.method728(var1.getConfigData(var2, var3));
   }
}
