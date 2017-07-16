import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class3 implements class0 {
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1448273015
   )
   static int field17;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1243612567
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lej;IIII)Z",
      garbageValue = "-623009937"
   )
   static final boolean method9(Model var0, int var1, int var2, int var3) {
      if(!class43.method630()) {
         return false;
      } else {
         class152.method2924();
         int var4 = var0.field1949 + var1;
         int var5 = var2 + var0.field1950;
         int var6 = var3 + var0.field1951;
         int var7 = var0.field1947;
         int var8 = var0.field1974;
         int var9 = var0.field1954;
         int var10 = class134.field1987 - var4;
         int var11 = class134.field1992 - var5;
         int var12 = class18.field322 - var6;
         return Math.abs(var10) > var7 + FileOnDisk.field1754?false:(Math.abs(var11) > var8 + class134.field1993?false:(Math.abs(var12) > var9 + class134.field1994?false:(Math.abs(var12 * class60.field737 - var11 * class181.field2435) > var8 * class134.field1994 + var9 * class134.field1993?false:(Math.abs(var10 * class181.field2435 - var12 * FileRequest.field3207) > var7 * class134.field1994 + var9 * FileOnDisk.field1754?false:Math.abs(var11 * FileRequest.field3207 - var10 * class60.field737) <= var7 * class134.field1993 + var8 * FileOnDisk.field1754))));
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "110655549"
   )
   static final void method8(int var0) {
      class7.method35();

      for(class82 var1 = (class82)class82.field1322.getFront(); var1 != null; var1 = (class82)class82.field1322.getNext()) {
         if(var1.field1311 != null) {
            var1.method1576();
         }
      }

      int var4 = class169.method3109(var0).configType;
      if(var4 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field923) {
               if(Client.field923 == 0 && Client.field1142 != -1) {
                  Friend.method1083(class182.indexTrack1, Client.field1142, 0, var3, false);
                  Client.field946 = false;
               } else if(var3 == 0) {
                  class203.field2500.method3703();
                  class203.field2501 = 1;
                  class203.field2502 = null;
                  Client.field946 = false;
               } else if(class203.field2501 != 0) {
                  class203.field2504 = var3;
               } else {
                  class203.field2500.method3697(var3);
               }

               Client.field923 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1059 = 127;
            }

            if(var2 == 1) {
               Client.field1059 = 96;
            }

            if(var2 == 2) {
               Client.field1059 = 64;
            }

            if(var2 == 3) {
               Client.field1059 = 32;
            }

            if(var2 == 4) {
               Client.field1059 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1043 = var2;
         }

         if(var4 == 6) {
            Client.field1068 = var2;
         }

         if(var4 == 9) {
            Client.field972 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1172 = 127;
            }

            if(var2 == 1) {
               Client.field1172 = 96;
            }

            if(var2 == 2) {
               Client.field1172 = 64;
            }

            if(var2 == 3) {
               Client.field1172 = 32;
            }

            if(var2 == 4) {
               Client.field1172 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1074 = var2 & '\uffff';
         }

         class91[] var5;
         if(var4 == 18) {
            var5 = new class91[]{class91.field1410, class91.field1413, class91.field1416, class91.field1409};
            Client.field931 = (class91)PendingSpawn.forOrdinal(var5, var2);
            if(Client.field931 == null) {
               Client.field931 = class91.field1410;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field925 = -1;
            } else {
               Client.field925 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class91[]{class91.field1410, class91.field1413, class91.field1416, class91.field1409};
            Client.field932 = (class91)PendingSpawn.forOrdinal(var5, var2);
            if(Client.field932 == null) {
               Client.field932 = class91.field1410;
            }
         }

      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2021723832"
   )
   static void method7() {
      Client.field916 = -1L;
      Client.field919 = -1;
      KeyFocusListener.field641.field849 = 0;
      class21.field339 = true;
      Client.field1069 = true;
      Client.field1130 = -1L;
      FloorUnderlayDefinition.method4301();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.field1090 = 0;
      Client.field986 = 0;
      Client.field958 = 0;
      Client.field1120 = 0;
      Client.menuOptionCount = 0;
      Client.field940 = -1;
      Client.isMenuOpen = false;
      MouseInput.mouseIdleTicks = 0;
      class116.method2096();
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.field1080 = 0;
      Client.field970 = (int)(Math.random() * 100.0D) - 50;
      Client.field1050 = (int)(Math.random() * 110.0D) - 55;
      Client.field969 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field1140 = 0;
      Client.field1133 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.field931 = class91.field1409;
      Client.field932 = class91.field1409;
      Client.field944 = 0;
      class96.field1499 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class96.field1490[var0] = null;
         class96.field1487[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field925 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      Client.field1056 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < VarPlayerType.field3283; ++var0) {
         VarPlayerType var3 = class169.method3109(var0);
         if(var3 != null) {
            class211.settings[var0] = 0;
            class211.widgetSettings[var0] = 0;
         }
      }

      class46.chatMessages.reset();
      Client.field1074 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && Widget.validInterfaces[var0]) {
            class11.widgetIndex.method4094(var0);
            if(Widget.widgets[var0] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3538(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3539()) {
         MilliTimer.method2909(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field1070 = null;
      Client.menuOptionCount = 0;
      Client.field940 = -1;
      Client.isMenuOpen = false;
      Client.field1177.method3934((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field987 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1111[var0] = true;
      }

      class34.method480();
      Client.clanChatOwner = null;
      Signlink.clanChatCount = 0;
      class44.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      XClanMember.field904 = null;
   }
}
