import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class184 extends Node {
   @ObfuscatedName("v")
   byte[] field2980 = new byte[128];
   @ObfuscatedName("q")
   class65[] field2981 = new class65[128];
   @ObfuscatedName("f")
   short[] field2982 = new short[128];
   @ObfuscatedName("c")
   byte[] field2983 = new byte[128];
   @ObfuscatedName("m")
   byte[] field2984 = new byte[128];
   @ObfuscatedName("j")
   class188[] field2985 = new class188[128];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -925921013
   )
   int field2986;
   @ObfuscatedName("y")
   int[] field2987 = new int[128];
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      longValue = -1297747604899162703L
   )
   static long field2990;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[II)Z",
      garbageValue = "633463569"
   )
   boolean method3556(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2987[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1296(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1298(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2981[var7] = var6;
                  this.field2987[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-936217380"
   )
   void method3557() {
      this.field2987 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "571183135"
   )
   static final void method3560() {
      try {
         if(Client.field313 == 0) {
            if(null != class28.field671) {
               class28.field671.method3020();
               class28.field671 = null;
            }

            Client.field277 = null;
            Client.field335 = false;
            Client.field529 = 0;
            Client.field313 = 1;
         }

         if(Client.field313 == 1) {
            if(null == Client.field277) {
               Client.field277 = Item.field699.method2917(class124.host, class119.field2041);
            }

            if(Client.field277.field2268 == 2) {
               throw new IOException();
            }

            if(Client.field277.field2268 == 1) {
               class28.field671 = new class146((Socket)Client.field277.field2262, Item.field699);
               Client.field277 = null;
               Client.field313 = 2;
            }
         }

         if(Client.field313 == 2) {
            Client.field324.offset = 0;
            Client.field324.method2556(14);
            class28.field671.method3027(Client.field324.payload, 0, 1);
            Client.field314.offset = 0;
            Client.field313 = 3;
         }

         int var0;
         if(Client.field313 == 3) {
            if(class141.field2184 != null) {
               class141.field2184.method1264();
            }

            if(class178.field2948 != null) {
               class178.field2948.method1264();
            }

            var0 = class28.field671.method3021();
            if(class141.field2184 != null) {
               class141.field2184.method1264();
            }

            if(null != class178.field2948) {
               class178.field2948.method1264();
            }

            if(var0 != 0) {
               class23.method587(var0);
               return;
            }

            Client.field314.offset = 0;
            Client.field313 = 5;
         }

         int var1;
         int var2;
         if(Client.field313 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field324.offset = 0;
            Client.field324.method2556(1);
            Client.field324.method2556(class33.field758.vmethod3197());
            Client.field324.method2559(var5[0]);
            Client.field324.method2559(var5[1]);
            Client.field324.method2559(var5[2]);
            Client.field324.method2559(var5[3]);
            switch(class33.field758.field2645) {
            case 0:
               Client.field324.method2559(((Integer)class130.field2102.field139.get(Integer.valueOf(class118.method2512(class33.username)))).intValue());
               Client.field324.offset += 4;
               break;
            case 1:
            case 3:
               Client.field324.method2558(class33.field756);
               Client.field324.offset += 5;
               break;
            case 2:
               Client.field324.offset += 8;
            }

            Client.field324.method2562(class33.field754);
            Client.field324.method2592(class4.field65, class4.field66);
            Client.field340.offset = 0;
            if(Client.gameState == 40) {
               Client.field340.method2556(18);
            } else {
               Client.field340.method2556(16);
            }

            Client.field340.method2638(0);
            var1 = Client.field340.offset;
            Client.field340.method2559(125);
            Client.field340.method2565(Client.field324.payload, 0, Client.field324.offset);
            var2 = Client.field340.offset;
            Client.field340.method2562(class33.username);
            Client.field340.method2556((Client.isResized?1:0) << 1 | (Client.field282?1:0));
            Client.field340.method2638(GroundObject.field1652);
            Client.field340.method2638(VertexNormal.field1689);
            class114.method2489(Client.field340);
            Client.field340.method2562(Client.field285);
            Client.field340.method2559(SecondaryBufferProvider.field1430);
            Buffer var3 = new Buffer(class144.field2218.method3203());
            class144.field2218.method3205(var3);
            Client.field340.method2565(var3.payload, 0, var3.payload.length);
            Client.field340.method2556(XItemContainer.field219);
            Client.field340.method2559(class35.field789.field2718);
            Client.field340.method2559(class158.field2336.field2718);
            Client.field340.method2559(class13.field200.field2718);
            Client.field340.method2559(Buffer.field2060.field2718);
            Client.field340.method2559(class13.field195.field2718);
            Client.field340.method2559(class38.field820.field2718);
            Client.field340.method2559(Client.field423.field2718);
            Client.field340.method2559(class1.field13.field2718);
            Client.field340.method2559(class127.field2092.field2718);
            Client.field340.method2559(class59.field1254.field2718);
            Client.field340.method2559(class158.field2343.field2718);
            Client.field340.method2559(class9.field151.field2718);
            Client.field340.method2559(Client.field311.field2718);
            Client.field340.method2559(MessageNode.field802.field2718);
            Client.field340.method2559(FrameMap.field1829.field2718);
            Client.field340.method2559(class109.field1932.field2718);
            Client.field340.method2590(var5, var2, Client.field340.offset);
            Client.field340.method2754(Client.field340.offset - var1);
            class28.field671.method3027(Client.field340.payload, 0, Client.field340.offset);
            Client.field324.method2804(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field314.method2804(var5);
            Client.field313 = 6;
         }

         if(Client.field313 == 6 && class28.field671.method3022() > 0) {
            var0 = class28.field671.method3021();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field313 = 7;
            } else if(var0 == 2) {
               Client.field313 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field276 = -1;
               Client.field313 = 13;
            } else if(var0 == 23 && Client.field310 < 1) {
               ++Client.field310;
               Client.field313 = 0;
            } else {
               if(var0 != 29) {
                  class23.method587(var0);
                  return;
               }

               Client.field313 = 11;
            }
         }

         if(Client.field313 == 7 && class28.field671.method3022() > 0) {
            Client.field322 = (class28.field671.method3021() + 3) * 60;
            Client.field313 = 8;
         }

         if(Client.field313 == 8) {
            Client.field529 = 0;
            class51.method1075("You have only just left another world.", "Your profile will be transferred in:", Client.field322 / 60 + " seconds.");
            if(--Client.field322 <= 0) {
               Client.field313 = 0;
            }

         } else {
            if(Client.field313 == 9 && class28.field671.method3022() >= 13) {
               boolean var10 = class28.field671.method3021() == 1;
               class28.field671.method3024(Client.field314.payload, 0, 4);
               Client.field314.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field314.method2820() << 24;
                  var1 |= Client.field314.method2820() << 16;
                  var1 |= Client.field314.method2820() << 8;
                  var1 |= Client.field314.method2820();
                  var2 = class118.method2512(class33.username);
                  if(class130.field2102.field139.size() >= 10 && !class130.field2102.field139.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = class130.field2102.field139.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  class130.field2102.field139.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class216.method3980();
               }

               Client.field447 = class28.field671.method3021();
               Client.field449 = class28.field671.method3021() == 1;
               Client.localInteractingIndex = class28.field671.method3021();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class28.field671.method3021();
               Client.field521 = class28.field671.method3021();
               class28.field671.method3024(Client.field314.payload, 0, 1);
               Client.field314.offset = 0;
               Client.packetOpcode = Client.field314.method2820();
               class28.field671.method3024(Client.field314.payload, 0, 2);
               Client.field314.offset = 0;
               Client.field276 = Client.field314.method2691();

               try {
                  class135.method2888(Client.field480, "zap");
               } catch (Throwable var8) {
                  ;
               }

               Client.field313 = 10;
            }

            if(Client.field313 != 10) {
               if(Client.field313 == 11 && class28.field671.method3022() >= 2) {
                  Client.field314.offset = 0;
                  class28.field671.method3024(Client.field314.payload, 0, 2);
                  Client.field314.offset = 0;
                  class93.field1625 = Client.field314.method2691();
                  Client.field313 = 12;
               }

               if(Client.field313 == 12 && class28.field671.method3022() >= class93.field1625) {
                  Client.field314.offset = 0;
                  class28.field671.method3024(Client.field314.payload, 0, class93.field1625);
                  Client.field314.offset = 0;
                  String var14 = Client.field314.method2579();
                  String var15 = Client.field314.method2579();
                  String var6 = Client.field314.method2579();
                  class51.method1075(var14, var15, var6);
                  class127.setGameState(10);
               }

               if(Client.field313 == 13) {
                  if(Client.field276 == -1) {
                     if(class28.field671.method3022() < 2) {
                        return;
                     }

                     class28.field671.method3024(Client.field314.payload, 0, 2);
                     Client.field314.offset = 0;
                     Client.field276 = Client.field314.method2691();
                  }

                  if(class28.field671.method3022() >= Client.field276) {
                     class28.field671.method3024(Client.field314.payload, 0, Client.field276);
                     Client.field314.offset = 0;
                     var0 = Client.field276;
                     class168.method3270();
                     ItemComposition.method1162(Client.field314);
                     if(var0 != Client.field314.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field529;
                  if(Client.field529 > 2000) {
                     if(Client.field310 < 1) {
                        if(class119.field2041 == Client.field317) {
                           class119.field2041 = MessageNode.field803;
                        } else {
                           class119.field2041 = Client.field317;
                        }

                        ++Client.field310;
                        Client.field313 = 0;
                     } else {
                        class23.method587(-3);
                     }
                  }
               }
            } else {
               if(class28.field671.method3022() >= Client.field276) {
                  Client.field314.offset = 0;
                  class28.field671.method3024(Client.field314.payload, 0, Client.field276);
                  Client.field289 = -1L;
                  Client.field292 = -1;
                  class161.field2639.field191 = 0;
                  class107.field1854 = true;
                  Client.field293 = true;
                  Client.field506 = -1L;
                  class214.field3183 = new class205();
                  Client.field324.offset = 0;
                  Client.field314.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field331 = 1;
                  Client.field332 = -1;
                  Client.field430 = -1;
                  Client.field329 = 0;
                  Client.field304 = 0;
                  Client.field397 = 0;
                  Client.field278 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class143.mouseIdleTicks = 0;
                  class11.chatLineMap.clear();
                  class11.field167.method3838();
                  class11.field164.method3873();
                  class11.field166 = 0;
                  Client.field497 = 0;
                  Client.field435 = false;
                  Client.field522 = 0;
                  Client.field378 = (int)(Math.random() * 100.0D) - 50;
                  Client.field347 = (int)(Math.random() * 110.0D) - 55;
                  Client.field349 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field516 = 0;
                  Client.field509 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field559 = class21.field573;
                  Client.field305 = class21.field573;
                  Client.field319 = 0;
                  class34.field777 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class34.field771[var0] = null;
                     class34.field770[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field411 = -1;
                  Client.projectiles.method3850();
                  Client.field415.method3850();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field413 = new Deque();
                  Client.field534 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class56.field1222; ++var0) {
                     class56 var7 = class26.method606(var0);
                     if(var7 != null) {
                        class179.settings[var0] = 0;
                        class179.widgetSettings[var0] = 0;
                     }
                  }

                  class50.chatMessages.method205();
                  Client.field315 = -1;
                  if(Client.widgetRoot != -1) {
                     class0.method3(Client.widgetRoot);
                  }

                  for(WidgetNode var13 = (WidgetNode)Client.componentTable.method3825(); var13 != null; var13 = (WidgetNode)Client.componentTable.method3826()) {
                     class16.method175(var13, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field361 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field553.method3508((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field408[var0] = null;
                     Client.field409[var0] = false;
                  }

                  class144.method3014();
                  Client.field287 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field485[var0] = true;
                  }

                  class23.method590();
                  Client.field455 = null;
                  class16.field235 = 0;
                  class114.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  Tile.field1816 = null;
                  ItemComposition.method1162(Client.field314);
                  Projectile.field117 = -1;
                  class10.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            }
         }
      } catch (IOException var9) {
         if(Client.field310 < 1) {
            if(class119.field2041 == Client.field317) {
               class119.field2041 = MessageNode.field803;
            } else {
               class119.field2041 = Client.field317;
            }

            ++Client.field310;
            Client.field313 = 0;
         } else {
            class23.method587(-2);
         }
      }
   }

   class184(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var2.offset + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2572();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2572();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var2.offset + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2572();
      }

      ++var2.offset;
      ++var9;
      byte[] var37 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var37[1] = 1;
         int var38 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2571();
            if(var15 == 0) {
               var38 = var12++;
            } else {
               if(var15 <= var38) {
                  --var15;
               }

               var38 = var15;
            }

            var37[var14] = (byte)var38;
         }
      } else {
         var12 = var9;
      }

      class188[] var13 = new class188[var12];

      class188 var40;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var40 = var13[var14] = new class188();
         int var39 = var2.method2571();
         if(var39 > 0) {
            var40.field3054 = new byte[var39 * 2];
         }

         var39 = var2.method2571();
         if(var39 > 0) {
            var40.field3045 = new byte[2 + var39 * 2];
            var40.field3045[1] = 64;
         }
      }

      var14 = var2.method2571();
      byte[] var47 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.method2571();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2572();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2571();
         this.field2982[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2571();
         this.field2982[var20] = (short)(this.field2982[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2587();
         }

         this.field2982[var23] = (short)(this.field2982[var23] + ((var22 - 1 & 2) << 14));
         this.field2987[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2987[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2984[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2987[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2980[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2987[var26] != 0) {
            if(var20 == 0) {
               var41 = var13[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2985[var26] = var41;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2987[var27] > 0) {
               var26 = var2.method2571() + 1;
            }
         }

         this.field2983[var27] = (byte)var26;
         --var20;
      }

      this.field2986 = var2.method2571() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3054) {
            for(var29 = 1; var29 < var28.field3054.length; var29 += 2) {
               var28.field3054[var29] = var2.method2572();
            }
         }

         if(null != var28.field3045) {
            for(var29 = 3; var29 < var28.field3045.length - 2; var29 += 2) {
               var28.field3045[var29] = var2.method2572();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.method2572();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.method2572();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3045) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3045.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2571();
               var28.field3045[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3054) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3054.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2571();
               var28.field3054[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var43;
      byte var45;
      if(null != var47) {
         var19 = var2.method2571();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2571();
            var47[var27] = (byte)var19;
         }

         var45 = var47[0];
         byte var36 = var47[1];

         for(var29 = 0; var29 < var45; ++var29) {
            this.field2983[var29] = (byte)(32 + this.field2983[var29] * var36 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[1 + var29];
            var32 = (var30 - var45) / 2 + var36 * (var30 - var45);

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class1.method4(var32, var30 - var45);
               this.field2983[var33] = (byte)(var34 * this.field2983[var33] + 32 >> 6);
               var32 += var31 - var36;
            }

            var45 = var30;
            var36 = var31;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            this.field2983[var43] = (byte)(var36 * this.field2983[var43] + 32 >> 6);
         }

         var40 = null;
      }

      if(null != var16) {
         var19 = var2.method2571();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2571();
            var16[var27] = (byte)var19;
         }

         var45 = var16[0];
         int var46 = var16[1] << 1;

         for(var29 = 0; var29 < var45; ++var29) {
            var43 = var46 + (this.field2980[var29] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2980[var29] = (byte)var43;
         }

         int var44;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var44 = var16[var29 + 1] << 1;
            var32 = (var30 - var45) * var46 + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class1.method4(var32, var30 - var45);
               int var35 = var34 + (this.field2980[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2980[var33] = (byte)var35;
               var32 += var44 - var46;
            }

            var45 = var30;
            var46 = var44;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            var44 = var46 + (this.field2980[var43] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2980[var43] = (byte)var44;
         }

         Object var42 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3047 = var2.method2571();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3054) {
            var28.field3048 = var2.method2571();
         }

         if(null != var28.field3045) {
            var28.field3049 = var2.method2571();
         }

         if(var28.field3047 > 0) {
            var28.field3050 = var2.method2571();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3046 = var2.method2571();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3046 > 0) {
            var28.field3051 = var2.method2571();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3051 > 0) {
            var28.field3053 = var2.method2571();
         }
      }

   }
}
