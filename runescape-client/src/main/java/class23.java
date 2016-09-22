import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class23 extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -361826923
   )
   int field598;
   @ObfuscatedName("v")
   int[] field600;
   @ObfuscatedName("r")
   String[] field601;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1616530407
   )
   int field602;
   @ObfuscatedName("d")
   int[] field603;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -119811817
   )
   int field604;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1779070003
   )
   int field605;
   @ObfuscatedName("a")
   static NodeCache field608 = new NodeCache(128);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2022610402"
   )
   static final void method581() {
      try {
         if(Client.field290 == 0) {
            if(BufferProvider.field1475 != null) {
               BufferProvider.field1475.method3039();
               BufferProvider.field1475 = null;
            }

            class214.field3186 = null;
            Client.field334 = false;
            Client.field315 = 0;
            Client.field290 = 1;
         }

         if(Client.field290 == 1) {
            if(null == class214.field3186) {
               class214.field3186 = class126.field2103.method2928(class62.host, class50.field1115);
            }

            if(class214.field3186.field2284 == 2) {
               throw new IOException();
            }

            if(class214.field3186.field2284 == 1) {
               BufferProvider.field1475 = new class146((Socket)class214.field3186.field2287, class126.field2103);
               class214.field3186 = null;
               Client.field290 = 2;
            }
         }

         if(Client.field290 == 2) {
            Client.field323.offset = 0;
            Client.field323.method2513(14);
            BufferProvider.field1475.method3025(Client.field323.payload, 0, 1);
            Client.field325.offset = 0;
            Client.field290 = 3;
         }

         int var0;
         if(Client.field290 == 3) {
            if(Projectile.field101 != null) {
               Projectile.field101.method1236();
            }

            if(null != class13.field192) {
               class13.field192.method1236();
            }

            var0 = BufferProvider.field1475.method3022();
            if(null != Projectile.field101) {
               Projectile.field101.method1236();
            }

            if(null != class13.field192) {
               class13.field192.method1236();
            }

            if(var0 != 0) {
               BufferProvider.method1729(var0);
               return;
            }

            Client.field325.offset = 0;
            Client.field290 = 5;
         }

         int var1;
         int var2;
         if(Client.field290 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field323.offset = 0;
            Client.field323.method2513(1);
            Client.field323.method2513(class33.field759.vmethod3214());
            Client.field323.method2600(var7[0]);
            Client.field323.method2600(var7[1]);
            Client.field323.method2600(var7[2]);
            Client.field323.method2600(var7[3]);
            switch(class33.field759.field2667) {
            case 0:
            case 3:
               Client.field323.method2743(class10.field156);
               Client.field323.offset += 5;
               break;
            case 1:
               Client.field323.offset += 8;
               break;
            case 2:
               Client.field323.method2600(((Integer)class116.field2039.field136.get(Integer.valueOf(class107.method2313(class33.username)))).intValue());
               Client.field323.offset += 4;
            }

            Client.field323.method2519(class33.field758);
            Client.field323.method2612(class4.field71, class4.field70);
            Client.field324.offset = 0;
            if(Client.gameState == 40) {
               Client.field324.method2513(18);
            } else {
               Client.field324.method2513(16);
            }

            Client.field324.method2514(0);
            var1 = Client.field324.offset;
            Client.field324.method2600(122);
            Client.field324.method2667(Client.field323.payload, 0, Client.field323.offset);
            var2 = Client.field324.offset;
            Client.field324.method2519(class33.username);
            Client.field324.method2513((Client.isResized?1:0) << 1 | (Client.field285?1:0));
            Client.field324.method2514(class159.field2374);
            Client.field324.method2514(class92.field1643);
            class125 var3 = Client.field324;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2299.method4209(0L);
               class152.field2299.method4200(var4);

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

            var3.method2667(var4, 0, 24);
            Client.field324.method2519(Client.field287);
            Client.field324.method2600(class144.field2237);
            Buffer var17 = new Buffer(class155.field2338.method3219());
            class155.field2338.method3224(var17);
            Client.field324.method2667(var17.payload, 0, var17.payload.length);
            Client.field324.method2513(XClanMember.field640);
            Client.field324.method2600(class144.field2240.field2744);
            Client.field324.method2600(class50.field1121.field2744);
            Client.field324.method2600(class166.field2718.field2744);
            Client.field324.method2600(class35.field796.field2744);
            Client.field324.method2600(class47.field1065.field2744);
            Client.field324.method2600(class1.field18.field2744);
            Client.field324.method2600(class8.field140.field2744);
            Client.field324.method2600(class9.field147.field2744);
            Client.field324.method2600(ItemComposition.field1230.field2744);
            Client.field324.method2600(class128.field2118.field2744);
            Client.field324.method2600(Client.field311.field2744);
            Client.field324.method2600(class85.field1506.field2744);
            Client.field324.method2600(class190.field3083.field2744);
            Client.field324.method2600(class53.field1156.field2744);
            Client.field324.method2600(Client.field312.field2744);
            Client.field324.method2600(class113.field1993.field2744);
            Client.field324.method2547(var7, var2, Client.field324.offset);
            Client.field324.method2578(Client.field324.offset - var1);
            BufferProvider.field1475.method3025(Client.field324.payload, 0, Client.field324.offset);
            Client.field323.method2782(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field325.method2782(var7);
            Client.field290 = 6;
         }

         if(Client.field290 == 6 && BufferProvider.field1475.method3021() > 0) {
            var0 = BufferProvider.field1475.method3022();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field290 = 7;
            } else if(var0 == 2) {
               Client.field290 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field326 = -1;
               Client.field290 = 13;
            } else if(var0 == 23 && Client.field316 < 1) {
               ++Client.field316;
               Client.field290 = 0;
            } else {
               if(var0 != 29) {
                  BufferProvider.method1729(var0);
                  return;
               }

               Client.field290 = 11;
            }
         }

         if(Client.field290 == 7 && BufferProvider.field1475.method3021() > 0) {
            Client.field317 = (BufferProvider.field1475.method3022() + 3) * 60;
            Client.field290 = 8;
         }

         if(Client.field290 == 8) {
            Client.field315 = 0;
            class192.method3774("You have only just left another world.", "Your profile will be transferred in:", Client.field317 / 60 + " seconds.");
            if(--Client.field317 <= 0) {
               Client.field290 = 0;
            }

         } else {
            if(Client.field290 == 9 && BufferProvider.field1475.method3021() >= 13) {
               boolean var14 = BufferProvider.field1475.method3022() == 1;
               BufferProvider.field1475.method3035(Client.field325.payload, 0, 4);
               Client.field325.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field325.method2793() << 24;
                  var1 |= Client.field325.method2793() << 16;
                  var1 |= Client.field325.method2793() << 8;
                  var1 |= Client.field325.method2793();
                  var2 = class107.method2313(class33.username);
                  if(class116.field2039.field136.size() >= 10 && !class116.field2039.field136.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class116.field2039.field136.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class116.field2039.field136.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class79.method1710();
               }

               Client.field351 = BufferProvider.field1475.method3022();
               Client.field478 = BufferProvider.field1475.method3022() == 1;
               Client.localInteractingIndex = BufferProvider.field1475.method3022();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += BufferProvider.field1475.method3022();
               Client.field405 = BufferProvider.field1475.method3022();
               BufferProvider.field1475.method3035(Client.field325.payload, 0, 1);
               Client.field325.offset = 0;
               Client.packetOpcode = Client.field325.method2793();
               BufferProvider.field1475.method3035(Client.field325.payload, 0, 2);
               Client.field325.offset = 0;
               Client.field326 = Client.field325.method2717();

               try {
                  class135.method2889(Client.field277, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field290 = 10;
            }

            if(Client.field290 == 10) {
               if(BufferProvider.field1475.method3021() >= Client.field326) {
                  Client.field325.offset = 0;
                  BufferProvider.field1475.method3035(Client.field325.payload, 0, Client.field326);
                  Client.field291 = -1L;
                  Client.field294 = -1;
                  class165.field2714.field196 = 0;
                  XClanMember.field632 = true;
                  Client.field295 = true;
                  Client.field506 = -1L;
                  class11.method157();
                  Client.field323.offset = 0;
                  Client.field325.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field330 = 1;
                  Client.field331 = -1;
                  Client.field434 = -1;
                  Client.field328 = 0;
                  Client.field381 = 0;
                  Client.field333 = 0;
                  Client.field298 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class143.mouseIdleTicks = 0;
                  class11.chatLineMap.clear();
                  class11.field166.method3838();
                  class11.field167.method3887();
                  class11.field168 = 0;
                  Client.field524 = 0;
                  Client.field435 = false;
                  Client.field522 = 0;
                  Client.field525 = (int)(Math.random() * 100.0D) - 50;
                  Client.field352 = (int)(Math.random() * 110.0D) - 55;
                  Client.field350 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field404 = 0;
                  Client.field466 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field306 = class21.field581;
                  Client.field307 = class21.field581;
                  Client.field319 = 0;
                  class40.method803();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field555 = -1;
                  Client.projectiles.method3848();
                  Client.field416.method3848();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field425 = new Deque();
                  Client.field469 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class56.field1234; ++var0) {
                     class56 var21 = PlayerComposition.method3517(var0);
                     if(null != var21) {
                        class179.settings[var0] = 0;
                        class179.widgetSettings[var0] = 0;
                     }
                  }

                  Friend.chatMessages.method205();
                  Client.field418 = -1;
                  if(Client.widgetRoot != -1) {
                     class162.method3212(Client.widgetRoot);
                  }

                  for(WidgetNode var19 = (WidgetNode)Client.componentTable.method3820(); var19 != null; var19 = (WidgetNode)Client.componentTable.method3827()) {
                     TextureProvider.method2217(var19, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field444 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field554.method3521((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field409[var0] = null;
                     Client.field514[var0] = false;
                  }

                  Ignore.method108();
                  Client.field411 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field374[var0] = true;
                  }

                  XClanMember.method603();
                  Client.field507 = null;
                  class133.field2138 = 0;
                  class175.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class18.field260 = null;
                  class144.method3013(Client.field325);
                  class159.field2372 = -1;
                  class127.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field290 == 11 && BufferProvider.field1475.method3021() >= 2) {
                  Client.field325.offset = 0;
                  BufferProvider.field1475.method3035(Client.field325.payload, 0, 2);
                  Client.field325.offset = 0;
                  class181.field2973 = Client.field325.method2717();
                  Client.field290 = 12;
               }

               if(Client.field290 == 12 && BufferProvider.field1475.method3021() >= class181.field2973) {
                  Client.field325.offset = 0;
                  BufferProvider.field1475.method3035(Client.field325.payload, 0, class181.field2973);
                  Client.field325.offset = 0;
                  String var18 = Client.field325.method2530();
                  String var10 = Client.field325.method2530();
                  String var9 = Client.field325.method2530();
                  class192.method3774(var18, var10, var9);
                  XItemContainer.setGameState(10);
               }

               if(Client.field290 != 13) {
                  ++Client.field315;
                  if(Client.field315 > 2000) {
                     if(Client.field316 < 1) {
                        if(class50.field1115 == class21.field583) {
                           class50.field1115 = class21.field584;
                        } else {
                           class50.field1115 = class21.field583;
                        }

                        ++Client.field316;
                        Client.field290 = 0;
                     } else {
                        BufferProvider.method1729(-3);
                     }
                  }
               } else {
                  if(Client.field326 == -1) {
                     if(BufferProvider.field1475.method3021() < 2) {
                        return;
                     }

                     BufferProvider.field1475.method3035(Client.field325.payload, 0, 2);
                     Client.field325.offset = 0;
                     Client.field326 = Client.field325.method2717();
                  }

                  if(BufferProvider.field1475.method3021() >= Client.field326) {
                     BufferProvider.field1475.method3035(Client.field325.payload, 0, Client.field326);
                     Client.field325.offset = 0;
                     var0 = Client.field326;
                     Client.field323.offset = 0;
                     Client.field325.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field330 = 1;
                     Client.field331 = -1;
                     Client.field434 = -1;
                     Client.field326 = 0;
                     Client.field328 = 0;
                     Client.field381 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field404 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     WidgetNode.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var20 = Client.cachedNPCs[var1];
                        if(var20 != null) {
                           var20.interacting = -1;
                           var20.field866 = false;
                        }
                     }

                     Ignore.method108();
                     XItemContainer.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field374[var1] = true;
                     }

                     XClanMember.method603();
                     class144.method3013(Client.field325);
                     if(Client.field325.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field316 < 1) {
            if(class21.field583 == class50.field1115) {
               class50.field1115 = class21.field584;
            } else {
               class50.field1115 = class21.field583;
            }

            ++Client.field316;
            Client.field290 = 0;
         } else {
            BufferProvider.method1729(-2);
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-7"
   )
   static final int method584(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "641157631"
   )
   public static boolean method585(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "785715821"
   )
   static int method586() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2137232785"
   )
   public static boolean method587(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass54;",
      garbageValue = "82"
   )
   public static class54 method588(int var0) {
      class54 var1 = (class54)class54.field1167.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class54.field1175.method3309(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1114(new Buffer(var2));
         }

         class54.field1167.put(var1, (long)var0);
         return var1;
      }
   }
}
