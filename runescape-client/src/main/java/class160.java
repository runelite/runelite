import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class160 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1648823863"
   )
   static final byte[] method3192(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2656();
      int var3 = var1.method2538();
      if(var3 >= 0 && (class170.field2719 == 0 || var3 <= class170.field2719)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2698(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2538();
            if(var6 < 0 || class170.field2719 != 0 && var6 > class170.field2719) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class120.method2481(var5, var6, var0, var3, 9);
               } else {
                  class170.field2715.method2478(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "-297203825"
   )
   public static String method3193(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - var3 * 10;
               if(var9 >= 10) {
                  var6[var7] = (char)(87 + var9);
               } else {
                  var6[var7] = (char)(48 + var9);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1231412790"
   )
   static final void method3194() {
      try {
         if(Client.field556 == 0) {
            if(null != class23.field604) {
               class23.field604.method3010();
               class23.field604 = null;
            }

            class28.field679 = null;
            Client.field336 = false;
            Client.field317 = 0;
            Client.field556 = 1;
         }

         if(Client.field556 == 1) {
            if(class28.field679 == null) {
               class28.field679 = class54.field1146.method2909(World.host, class114.field2013);
            }

            if(class28.field679.field2262 == 2) {
               throw new IOException();
            }

            if(class28.field679.field2262 == 1) {
               class23.field604 = new class146((Socket)class28.field679.field2266, class54.field1146);
               class28.field679 = null;
               Client.field556 = 2;
            }
         }

         if(Client.field556 == 2) {
            Client.field397.offset = 0;
            Client.field397.method2518(14);
            class23.field604.method3009(Client.field397.payload, 0, 1);
            Client.field327.offset = 0;
            Client.field556 = 3;
         }

         int var0;
         if(Client.field556 == 3) {
            if(class0.field14 != null) {
               class0.field14.method1223();
            }

            if(class134.field2119 != null) {
               class134.field2119.method1223();
            }

            var0 = class23.field604.method3029();
            if(null != class0.field14) {
               class0.field14.method1223();
            }

            if(class134.field2119 != null) {
               class134.field2119.method1223();
            }

            if(var0 != 0) {
               class11.method138(var0);
               return;
            }

            Client.field327.offset = 0;
            Client.field556 = 5;
         }

         int var1;
         int var2;
         if(Client.field556 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field397.offset = 0;
            Client.field397.method2518(1);
            Client.field397.method2518(class33.field726.vmethod3196());
            Client.field397.method2521(var7[0]);
            Client.field397.method2521(var7[1]);
            Client.field397.method2521(var7[2]);
            Client.field397.method2521(var7[3]);
            switch(class33.field726.field2634) {
            case 0:
               Client.field397.offset += 8;
               break;
            case 1:
            case 3:
               Client.field397.method2520(class47.field1049);
               Client.field397.offset += 5;
               break;
            case 2:
               Client.field397.method2521(((Integer)class16.field232.field140.get(Integer.valueOf(SecondaryBufferProvider.method1664(class33.username)))).intValue());
               Client.field397.offset += 4;
            }

            Client.field397.method2524(class33.field724);
            Client.field397.method2554(class4.field69, class4.field67);
            Client.field425.offset = 0;
            if(Client.gameState == 40) {
               Client.field425.method2518(18);
            } else {
               Client.field425.method2518(16);
            }

            Client.field425.method2519(0);
            var1 = Client.field425.offset;
            Client.field425.method2521(124);
            Client.field425.method2527(Client.field397.payload, 0, Client.field397.offset);
            var2 = Client.field425.offset;
            Client.field425.method2524(class33.username);
            Client.field425.method2518((Client.isResized?1:0) << 1 | (Client.field286?1:0));
            Client.field425.method2519(class153.field2296);
            Client.field425.method2519(class93.field1616);
            class125 var3 = Client.field425;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2275.method4212(0L);
               class152.field2275.method4229(var4);

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

            var3.method2527(var4, 0, 24);
            Client.field425.method2524(XItemContainer.field219);
            Client.field425.method2521(class75.field1401);
            Buffer var17 = new Buffer(class0.field12.method3201());
            class0.field12.method3200(var17);
            Client.field425.method2527(var17.payload, 0, var17.payload.length);
            Client.field425.method2518(NPC.field788);
            Client.field425.method2521(class0.field16.field2716);
            Client.field425.method2521(class22.field589.field2716);
            Client.field425.method2521(Client.field312.field2716);
            Client.field425.method2521(class56.field1207.field2716);
            Client.field425.method2521(class5.field77.field2716);
            Client.field425.method2521(class62.field1267.field2716);
            Client.field425.method2521(class47.field1050.field2716);
            Client.field425.method2521(XItemContainer.field223.field2716);
            Client.field425.method2521(Item.field690.field2716);
            Client.field425.method2521(class133.field2113.field2716);
            Client.field425.method2521(XItemContainer.field226.field2716);
            Client.field425.method2521(class21.field585.field2716);
            Client.field425.method2521(Client.field531.field2716);
            Client.field425.method2521(class154.field2301.field2716);
            Client.field425.method2521(class167.field2694.field2716);
            Client.field425.method2521(Client.field314.field2716);
            Client.field425.method2545(var7, var2, Client.field425.offset);
            Client.field425.method2529(Client.field425.offset - var1);
            class23.field604.method3009(Client.field425.payload, 0, Client.field425.offset);
            Client.field397.method2767(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field327.method2767(var7);
            Client.field556 = 6;
         }

         if(Client.field556 == 6 && class23.field604.method3013() > 0) {
            var0 = class23.field604.method3029();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field556 = 7;
            } else if(var0 == 2) {
               Client.field556 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field328 = -1;
               Client.field556 = 13;
            } else if(var0 == 23 && Client.field318 < 1) {
               ++Client.field318;
               Client.field556 = 0;
            } else {
               if(var0 != 29) {
                  class11.method138(var0);
                  return;
               }

               Client.field556 = 11;
            }
         }

         if(Client.field556 == 7 && class23.field604.method3013() > 0) {
            Client.field429 = (class23.field604.method3029() + 3) * 60;
            Client.field556 = 8;
         }

         if(Client.field556 == 8) {
            Client.field317 = 0;
            class59.method1273("You have only just left another world.", "Your profile will be transferred in:", Client.field429 / 60 + " seconds.");
            if(--Client.field429 <= 0) {
               Client.field556 = 0;
            }

         } else {
            if(Client.field556 == 9 && class23.field604.method3013() >= 13) {
               boolean var14 = class23.field604.method3029() == 1;
               class23.field604.method3014(Client.field327.payload, 0, 4);
               Client.field327.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field327.method2782() << 24;
                  var1 |= Client.field327.method2782() << 16;
                  var1 |= Client.field327.method2782() << 8;
                  var1 |= Client.field327.method2782();
                  var2 = SecondaryBufferProvider.method1664(class33.username);
                  if(class16.field232.field140.size() >= 10 && !class16.field232.field140.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class16.field232.field140.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class16.field232.field140.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class18.method193();
               }

               Client.field446 = class23.field604.method3029();
               Client.field448 = class23.field604.method3029() == 1;
               Client.localInteractingIndex = class23.field604.method3029();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class23.field604.method3029();
               Client.field404 = class23.field604.method3029();
               class23.field604.method3014(Client.field327.payload, 0, 1);
               Client.field327.offset = 0;
               Client.packetOpcode = Client.field327.method2782();
               class23.field604.method3014(Client.field327.payload, 0, 2);
               Client.field327.offset = 0;
               Client.field328 = Client.field327.method2535();

               try {
                  class135.method2861(Client.field442, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field556 = 10;
            }

            if(Client.field556 == 10) {
               if(class23.field604.method3013() >= Client.field328) {
                  Client.field327.offset = 0;
                  class23.field604.method3014(Client.field327.payload, 0, Client.field328);
                  class26.method614();
                  XClanMember.method604(Client.field327);
                  ItemLayer.field1737 = -1;
                  class130.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field556 == 11 && class23.field604.method3013() >= 2) {
                  Client.field327.offset = 0;
                  class23.field604.method3014(Client.field327.payload, 0, 2);
                  Client.field327.offset = 0;
                  class192.field3100 = Client.field327.method2535();
                  Client.field556 = 12;
               }

               if(Client.field556 == 12 && class23.field604.method3013() >= class192.field3100) {
                  Client.field327.offset = 0;
                  class23.field604.method3014(Client.field327.payload, 0, class192.field3100);
                  Client.field327.offset = 0;
                  String var18 = Client.field327.method2541();
                  String var10 = Client.field327.method2541();
                  String var9 = Client.field327.method2541();
                  class59.method1273(var18, var10, var9);
                  KitDefinition.setGameState(10);
               }

               if(Client.field556 != 13) {
                  ++Client.field317;
                  if(Client.field317 > 2000) {
                     if(Client.field318 < 1) {
                        if(class114.field2013 == class28.field673) {
                           class114.field2013 = class35.field781;
                        } else {
                           class114.field2013 = class28.field673;
                        }

                        ++Client.field318;
                        Client.field556 = 0;
                     } else {
                        class11.method138(-3);
                     }
                  }
               } else {
                  if(Client.field328 == -1) {
                     if(class23.field604.method3013() < 2) {
                        return;
                     }

                     class23.field604.method3014(Client.field327.payload, 0, 2);
                     Client.field327.offset = 0;
                     Client.field328 = Client.field327.method2535();
                  }

                  if(class23.field604.method3013() >= Client.field328) {
                     class23.field604.method3014(Client.field327.payload, 0, Client.field328);
                     Client.field327.offset = 0;
                     var0 = Client.field328;
                     Client.field397.offset = 0;
                     Client.field327.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field326 = -1;
                     Client.field333 = -1;
                     Client.field289 = -1;
                     Client.field328 = 0;
                     Client.field330 = 0;
                     Client.field457 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field369 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class34.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var19 = Client.cachedNPCs[var1];
                        if(var19 != null) {
                           var19.interacting = -1;
                           var19.field877 = false;
                        }
                     }

                     class151.method3149();
                     KitDefinition.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field526[var1] = true;
                     }

                     class14.method158();
                     XClanMember.method604(Client.field327);
                     if(Client.field327.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field318 < 1) {
            if(class114.field2013 == class28.field673) {
               class114.field2013 = class35.field781;
            } else {
               class114.field2013 = class28.field673;
            }

            ++Client.field318;
            Client.field556 = 0;
         } else {
            class11.method138(-2);
         }
      }
   }
}
