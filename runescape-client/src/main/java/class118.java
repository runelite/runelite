import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class118 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4016271253659228945L
   )
   static long field2029;
   @ObfuscatedName("rs")
   protected static String field2030;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 7678208967150448219L
   )
   static long field2031;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1629925407"
   )
   static byte[] method2561(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   static final void method2567() {
      try {
         if(Client.field349 == 0) {
            if(class40.field904 != null) {
               class40.field904.method3131();
               class40.field904 = null;
            }

            class50.field1123 = null;
            Client.field348 = false;
            Client.field411 = 0;
            Client.field349 = 1;
         }

         if(Client.field349 == 1) {
            if(null == class50.field1123) {
               class50.field1123 = class125.field2070.method3028(FrameMap.host, class109.field1943);
            }

            if(class50.field1123.field2276 == 2) {
               throw new IOException();
            }

            if(class50.field1123.field2276 == 1) {
               class40.field904 = new class146((Socket)class50.field1123.field2272, class125.field2070);
               class50.field1123 = null;
               Client.field349 = 2;
            }
         }

         if(Client.field349 == 2) {
            Client.field337.offset = 0;
            Client.field337.method2783(14);
            class40.field904.method3135(Client.field337.payload, 0, 1);
            Client.field339.offset = 0;
            Client.field349 = 3;
         }

         int var0;
         if(Client.field349 == 3) {
            if(null != Projectile.field127) {
               Projectile.field127.method1292();
            }

            if(class125.field2069 != null) {
               class125.field2069.method1292();
            }

            var0 = class40.field904.method3140();
            if(null != Projectile.field127) {
               Projectile.field127.method1292();
            }

            if(null != class125.field2069) {
               class125.field2069.method1292();
            }

            if(var0 != 0) {
               Item.method686(var0);
               return;
            }

            Client.field339.offset = 0;
            Client.field349 = 5;
         }

         int var1;
         int var2;
         if(Client.field349 == 5) {
            int[] var3 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field337.offset = 0;
            Client.field337.method2783(1);
            Client.field337.method2783(class33.field766.vmethod3316());
            Client.field337.method2728(var3[0]);
            Client.field337.method2728(var3[1]);
            Client.field337.method2728(var3[2]);
            Client.field337.method2728(var3[3]);
            switch(class33.field766.field2663) {
            case 0:
               Client.field337.method2728(((Integer)class136.field2123.field147.get(Integer.valueOf(ItemComposition.method1234(class33.username)))).intValue());
               Client.field337.offset += 4;
               break;
            case 1:
            case 3:
               Client.field337.method2849(class174.field2788);
               Client.field337.offset += 5;
               break;
            case 2:
               Client.field337.offset += 8;
            }

            Client.field337.method2703(class33.field765);
            Client.field337.method2781(class4.field76, class4.field73);
            Client.field333.offset = 0;
            if(Client.gameState == 40) {
               Client.field333.method2783(18);
            } else {
               Client.field333.method2783(16);
            }

            Client.field333.method2619(0);
            var1 = Client.field333.offset;
            Client.field333.method2728(120);
            Client.field333.method2627(Client.field337.payload, 0, Client.field337.offset);
            var2 = Client.field333.offset;
            Client.field333.method2703(class33.username);
            Client.field333.method2783((Client.isResized?1:0) << 1 | (Client.field301?1:0));
            Client.field333.method2619(class189.field3056);
            Client.field333.method2619(Actor.field892);
            class125 var4 = Client.field333;
            byte[] var5 = new byte[24];

            int var6;
            try {
               class152.field2301.method4293(0L);
               class152.field2301.method4297(var5);

               for(var6 = 0; var6 < 24 && var5[var6] == 0; ++var6) {
                  ;
               }

               if(var6 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var10) {
               for(int var8 = 0; var8 < 24; ++var8) {
                  var5[var8] = -1;
               }
            }

            var4.method2627(var5, 0, 24);
            Client.field333.method2703(class48.field1097);
            Client.field333.method2728(class133.field2112);
            Buffer var7 = new Buffer(WidgetNode.field69.method3323());
            WidgetNode.field69.method3322(var7);
            Client.field333.method2627(var7.payload, 0, var7.payload.length);
            Client.field333.method2783(class165.field2705);
            Client.field333.method2728(class16.field240.field2737);
            Client.field333.method2728(class56.field1236.field2737);
            Client.field333.method2728(SecondaryBufferProvider.field1448.field2737);
            Client.field333.method2728(class164.field2699.field2737);
            Client.field333.method2728(class119.field2039.field2737);
            Client.field333.method2728(BufferProvider.field1476.field2737);
            Client.field333.method2728(class188.field3051.field2737);
            Client.field333.method2728(Ignore.field137.field2737);
            Client.field333.method2728(Client.field451.field2737);
            Client.field333.method2728(ObjectComposition.field964.field2737);
            Client.field333.method2728(XClanMember.field644.field2737);
            Client.field333.method2728(class0.field12.field2737);
            Client.field333.method2728(class20.field581.field2737);
            Client.field333.method2728(Tile.field1811.field2737);
            Client.field333.method2728(class10.field172.field2737);
            Client.field333.method2728(class138.field2139.field2737);
            Client.field333.method2681(var3, var2, Client.field333.offset);
            Client.field333.method2629(Client.field333.offset - var1);
            class40.field904.method3135(Client.field333.payload, 0, Client.field333.offset);
            Client.field337.method2908(var3);

            for(var6 = 0; var6 < 4; ++var6) {
               var3[var6] += 50;
            }

            Client.field339.method2908(var3);
            Client.field349 = 6;
         }

         if(Client.field349 == 6 && class40.field904.method3141() > 0) {
            var0 = class40.field904.method3140();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field349 = 7;
            } else if(var0 == 2) {
               Client.field349 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field340 = -1;
               Client.field349 = 13;
            } else if(var0 == 23 && Client.field308 < 1) {
               ++Client.field308;
               Client.field349 = 0;
            } else {
               if(var0 != 29) {
                  Item.method686(var0);
                  return;
               }

               Client.field349 = 11;
            }
         }

         if(Client.field349 == 7 && class40.field904.method3141() > 0) {
            Client.field450 = (class40.field904.method3140() + 3) * 60;
            Client.field349 = 8;
         }

         if(Client.field349 == 8) {
            Client.field411 = 0;
            MessageNode.method781("You have only just left another world.", "Your profile will be transferred in:", Client.field450 / 60 + " seconds.");
            if(--Client.field450 <= 0) {
               Client.field349 = 0;
            }
         } else {
            if(Client.field349 == 9 && class40.field904.method3141() >= 13) {
               boolean var12 = class40.field904.method3140() == 1;
               class40.field904.method3132(Client.field339.payload, 0, 4);
               Client.field339.offset = 0;
               boolean var15 = false;
               if(var12) {
                  var1 = Client.field339.method2898() << 24;
                  var1 |= Client.field339.method2898() << 16;
                  var1 |= Client.field339.method2898() << 8;
                  var1 |= Client.field339.method2898();
                  var2 = ItemComposition.method1234(class33.username);
                  if(class136.field2123.field147.size() >= 10 && !class136.field2123.field147.containsKey(Integer.valueOf(var2))) {
                     Iterator var17 = class136.field2123.field147.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class136.field2123.field147.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  ObjectComposition.method886();
               }

               Client.field460 = class40.field904.method3140();
               Client.field506 = class40.field904.method3140() == 1;
               Client.localInteractingIndex = class40.field904.method3140();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class40.field904.method3140();
               Client.field418 = class40.field904.method3140();
               class40.field904.method3132(Client.field339.payload, 0, 1);
               Client.field339.offset = 0;
               Client.packetOpcode = Client.field339.method2898();
               class40.field904.method3132(Client.field339.payload, 0, 2);
               Client.field339.offset = 0;
               Client.field340 = Client.field339.method2635();

               try {
                  class135.method2990(Client.field477, "zap");
               } catch (Throwable var9) {
                  ;
               }

               Client.field349 = 10;
            }

            if(Client.field349 == 10) {
               if(class40.field904.method3141() >= Client.field340) {
                  Client.field339.offset = 0;
                  class40.field904.method3132(Client.field339.payload, 0, Client.field340);
                  class212.method4079();
                  Item.method685(Client.field339);
                  class48.field1092 = -1;
                  Player.xteaChanged(false);
                  Client.packetOpcode = -1;
               }
            } else {
               if(Client.field349 == 11 && class40.field904.method3141() >= 2) {
                  Client.field339.offset = 0;
                  class40.field904.method3132(Client.field339.payload, 0, 2);
                  Client.field339.offset = 0;
                  class10.field171 = Client.field339.method2635();
                  Client.field349 = 12;
               }

               if(Client.field349 == 12 && class40.field904.method3141() >= class10.field171) {
                  Client.field339.offset = 0;
                  class40.field904.method3132(Client.field339.payload, 0, class10.field171);
                  Client.field339.offset = 0;
                  String var13 = Client.field339.method2663();
                  String var16 = Client.field339.method2663();
                  String var18 = Client.field339.method2663();
                  MessageNode.method781(var13, var16, var18);
                  class138.setGameState(10);
               }

               if(Client.field349 != 13) {
                  ++Client.field411;
                  if(Client.field411 > 2000) {
                     if(Client.field308 < 1) {
                        if(class109.field1943 == class12.field198) {
                           class109.field1943 = class56.field1235;
                        } else {
                           class109.field1943 = class12.field198;
                        }

                        ++Client.field308;
                        Client.field349 = 0;
                     } else {
                        Item.method686(-3);
                     }
                  }
               } else {
                  if(Client.field340 == -1) {
                     if(class40.field904.method3141() < 2) {
                        return;
                     }

                     class40.field904.method3132(Client.field339.payload, 0, 2);
                     Client.field339.offset = 0;
                     Client.field340 = Client.field339.method2635();
                  }

                  if(class40.field904.method3141() >= Client.field340) {
                     class40.field904.method3132(Client.field339.payload, 0, Client.field340);
                     Client.field339.offset = 0;
                     var0 = Client.field340;
                     Client.field337.offset = 0;
                     Client.field339.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field344 = 1;
                     Client.field345 = -1;
                     Client.field311 = -1;
                     Client.field340 = 0;
                     Client.field378 = 0;
                     Client.field312 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field530 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     WidgetNode.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var14 = Client.cachedNPCs[var1];
                        if(null != var14) {
                           var14.interacting = -1;
                           var14.field865 = false;
                        }
                     }

                     class21.method581();
                     class138.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field498[var1] = true;
                     }

                     Projectile.method103();
                     Item.method685(Client.field339);
                     if(var0 != Client.field339.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var11) {
         if(Client.field308 < 1) {
            if(class109.field1943 == class12.field198) {
               class109.field1943 = class56.field1235;
            } else {
               class109.field1943 = class12.field198;
            }

            ++Client.field308;
            Client.field349 = 0;
         } else {
            Item.method686(-2);
         }
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1921486415"
   )
   static final void method2568(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field418 == 1) && Client.friendCount < 400) {
            String var1 = class156.method3300(var0, Client.field518);
            if(var1 != null) {
               int var2;
               String var3;
               String var4;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var5 = Client.friends[var2];
                  var3 = class156.method3300(var5.name, Client.field518);
                  if(var3 != null && var3.equals(var1)) {
                     SecondaryBufferProvider.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var5.previousName != null) {
                     var4 = class156.method3300(var5.previousName, Client.field518);
                     if(null != var4 && var4.equals(var1)) {
                        SecondaryBufferProvider.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var3 = class156.method3300(var6.name, Client.field518);
                  if(null != var3 && var3.equals(var1)) {
                     SecondaryBufferProvider.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var4 = class156.method3300(var6.previousName, Client.field518);
                     if(var4 != null && var4.equals(var1)) {
                        SecondaryBufferProvider.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class156.method3300(WidgetNode.localPlayer.name, Client.field518).equals(var1)) {
                  SecondaryBufferProvider.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field337.method2903(189);
                  Client.field337.method2783(class54.method1165(var0));
                  Client.field337.method2703(var0);
               }
            }
         } else {
            SecondaryBufferProvider.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "-88"
   )
   static MessageNode method2569(int var0) {
      return (MessageNode)class11.field174.method3950((long)var0);
   }
}
