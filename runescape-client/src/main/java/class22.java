import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;
import java.util.Comparator;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class22 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -7559077509820360181L
   )
   static long field574;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -1981705145
   )
   static int field575;
   @ObfuscatedName("nd")
   static class59 field576;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1545499962"
   )
   static final void method552(int var0, int var1, int var2, int var3) {
      if(Client.field421 == 0 && !Client.field270) {
         class10.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1896; ++var6) {
         var7 = Model.field1897[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class114.region.method1945(class59.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class40.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field421 == 1) {
                  class10.addMenuEntry("Use", Client.field416 + " " + "->" + " " + class188.method3706('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field270) {
                  if((class124.field2042 & 4) == 4) {
                     class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + class188.method3706('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field439) {
                     var13 = MessageNode.method755(var13);
                  }

                  if(null != var13) {
                     for(int var18 = 4; var18 >= 0; --var18) {
                        if(var13[var18] != null) {
                           short var15 = 0;
                           if(var18 == 0) {
                              var15 = 3;
                           }

                           if(var18 == 1) {
                              var15 = 4;
                           }

                           if(var18 == 2) {
                              var15 = 5;
                           }

                           if(var18 == 3) {
                              var15 = 6;
                           }

                           if(var18 == 4) {
                              var15 = 1001;
                           }

                           class10.addMenuEntry(var13[var18], class188.method3706('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class10.addMenuEntry("Examine", class188.method3706('\uffff') + var12.name, 1002, var12.field940 << 14, var8, var9);
               }
            }

            NPC var14;
            int var20;
            Player var21;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field902 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field309; ++var20) {
                     var14 = Client.cachedNPCs[Client.field307[var20]];
                     if(null != var14 && var14 != var23 && var14.composition.field902 == 1 && var23.x == var14.x && var23.y == var14.y) {
                        class8.method118(var14.composition, Client.field307[var20], var8, var9);
                     }
                  }

                  var20 = class34.field743;
                  var27 = class34.field739;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var21 = Client.cachedPlayers[var27[var29]];
                     if(var21 != null && var23.x == var21.x && var21.y == var23.y) {
                        ClassInfo.method3926(var21, var27[var29], var8, var9);
                     }
                  }
               }

               class8.method118(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field309; ++var20) {
                     var14 = Client.cachedNPCs[Client.field307[var20]];
                     if(var14 != null && var14.composition.field902 == 1 && var24.x == var14.x && var24.y == var14.y) {
                        class8.method118(var14.composition, Client.field307[var20], var8, var9);
                     }
                  }

                  var20 = class34.field743;
                  var27 = class34.field739;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var21 = Client.cachedPlayers[var27[var29]];
                     if(null != var21 && var21 != var24 && var21.x == var24.x && var21.y == var24.y) {
                        ClassInfo.method3926(var21, var27[var29], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field399) {
                  ClassInfo.method3926(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class59.plane][var8][var9];
               if(null != var25) {
                  for(Item var26 = (Item)var25.method3823(); var26 != null; var26 = (Item)var25.method3828()) {
                     ItemComposition var28 = class174.getItemDefinition(var26.id);
                     if(Client.field421 == 1) {
                        class10.addMenuEntry("Use", Client.field416 + " " + "->" + " " + class188.method3706(16748608) + var28.name, 16, var26.id, var8, var9);
                     } else if(Client.field270) {
                        if((class124.field2042 & 1) == 1) {
                           class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + class188.method3706(16748608) + var28.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var22 = var28.groundActions;
                        if(Client.field439) {
                           var22 = MessageNode.method755(var22);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(var22 != null && null != var22[var16]) {
                              byte var17 = 0;
                              if(var16 == 0) {
                                 var17 = 18;
                              }

                              if(var16 == 1) {
                                 var17 = 19;
                              }

                              if(var16 == 2) {
                                 var17 = 20;
                              }

                              if(var16 == 3) {
                                 var17 = 21;
                              }

                              if(var16 == 4) {
                                 var17 = 22;
                              }

                              class10.addMenuEntry(var22[var16], class188.method3706(16748608) + var28.name, var17, var26.id, var8, var9);
                           } else if(var16 == 2) {
                              class10.addMenuEntry("Take", class188.method3706(16748608) + var28.name, 20, var26.id, var8, var9);
                           }
                        }

                        class10.addMenuEntry("Examine", class188.method3706(16748608) + var28.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var19 = Client.cachedPlayers[Client.field399];
         ClassInfo.method3926(var19, Client.field399, var6, var7);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1410988561"
   )
   int method553(class217 var1, class217 var2) {
      if(var2.field3199 == var1.field3199) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3199 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field3199) {
               return 1;
            }
         }

         return var1.field3199 < var2.field3199?-1:1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1222100991"
   )
   static final void method555(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class218.field3204.method4029(var0, 250);
      int var6 = class218.field3204.method4071(var0, 250) * 13;
      class82.method1801(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      class82.method1815(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6, 16777215);
      class218.field3204.method4035(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class124.method2745(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = Frames.canvas.getGraphics();
            Player.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            Frames.canvas.repaint();
         }
      } else {
         class48.method961(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "47"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method607() != Client.isMembers) {
         Client.isMembers = var0.method607();
         boolean var1 = var0.method607();
         if(class49.isMembersWorld != var1) {
            class167.method3224();
            class49.isMembersWorld = var1;
         }
      }

      class38.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class20.field558 = Client.field267 == 0?'ꩊ':var0.id + '鱀';
      class156.field2318 = Client.field267 == 0?443:'썐' + var0.id;
      ItemLayer.field1726 = class20.field558;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;S)I",
      garbageValue = "-15163"
   )
   public static int method564(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = BufferProvider.method1693(var1);
      var0.method2479(var3.length);
      var0.offset += class225.field3230.method2407(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-832200073"
   )
   static final void method565() {
      try {
         if(Client.field420 == 0) {
            if(class32.field695 != null) {
               class32.field695.method2986();
               class32.field695 = null;
            }

            class12.field181 = null;
            Client.field533 = false;
            Client.field352 = 0;
            Client.field420 = 1;
         }

         if(Client.field420 == 1) {
            if(class12.field181 == null) {
               class12.field181 = class8.field121.method2891(class38.host, ItemLayer.field1726);
            }

            if(class12.field181.field2257 == 2) {
               throw new IOException();
            }

            if(class12.field181.field2257 == 1) {
               class32.field695 = new class146((Socket)class12.field181.field2261, class8.field121);
               class12.field181 = null;
               Client.field420 = 2;
            }
         }

         if(Client.field420 == 2) {
            Client.field300.offset = 0;
            Client.field300.method2467(14);
            class32.field695.method2987(Client.field300.payload, 0, 1);
            Client.field312.offset = 0;
            Client.field420 = 3;
         }

         int var0;
         if(Client.field420 == 3) {
            if(field576 != null) {
               field576.method1229();
            }

            if(null != Client.field527) {
               Client.field527.method1229();
            }

            var0 = class32.field695.method2991();
            if(null != field576) {
               field576.method1229();
            }

            if(Client.field527 != null) {
               Client.field527.method1229();
            }

            if(var0 != 0) {
               class8.method108(var0);
               return;
            }

            Client.field312.offset = 0;
            Client.field420 = 5;
         }

         int var1;
         int var2;
         if(Client.field420 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field300.offset = 0;
            Client.field300.method2467(1);
            Client.field300.method2467(class33.field736.vmethod3162());
            Client.field300.method2642(var7[0]);
            Client.field300.method2642(var7[1]);
            Client.field300.method2642(var7[2]);
            Client.field300.method2642(var7[3]);
            switch(class33.field736.field2647) {
            case 0:
               Client.field300.offset += 8;
               break;
            case 1:
            case 2:
               Client.field300.method2523(Tile.field1787);
               Client.field300.offset += 5;
               break;
            case 3:
               Client.field300.method2642(((Integer)Sequence.field984.field126.get(Integer.valueOf(Renderable.method1905(class33.username)))).intValue());
               Client.field300.offset += 4;
            }

            Client.field300.method2472(class33.field726);
            Client.field300.method2525(class4.field61, class4.field64);
            Client.field311.offset = 0;
            if(Client.gameState == 40) {
               Client.field311.method2467(18);
            } else {
               Client.field311.method2467(16);
            }

            Client.field311.method2468(0);
            var1 = Client.field311.offset;
            Client.field311.method2642(123);
            Client.field311.method2475(Client.field300.payload, 0, Client.field300.offset);
            var2 = Client.field311.offset;
            Client.field311.method2472(class33.username);
            Client.field311.method2467((Client.isResized?1:0) << 1 | (Client.field271?1:0));
            Client.field311.method2468(class50.field1069);
            Client.field311.method2468(class139.field2143);
            class125 var3 = Client.field311;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2276.method4142(0L);
               class152.field2276.method4144(var4);

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

            var3.method2475(var4, 0, 24);
            Client.field311.method2472(Client.field273);
            Client.field311.method2642(class75.field1395);
            Buffer var17 = new Buffer(FaceNormal.field1500.method3167());
            FaceNormal.field1500.method3169(var17);
            Client.field311.method2475(var17.payload, 0, var17.payload.length);
            Client.field311.method2467(World.field642);
            Client.field311.method2642(class23.field583.field2731);
            Client.field311.method2642(Sequence.field983.field2731);
            Client.field311.method2642(class10.field154.field2731);
            Client.field311.method2642(class124.field2043.field2731);
            Client.field311.method2642(Client.field443.field2731);
            Client.field311.method2642(class24.field603.field2731);
            Client.field311.method2642(class47.field1024.field2731);
            Client.field311.method2642(class192.field3101.field2731);
            Client.field311.method2642(class152.field2281.field2731);
            Client.field311.method2642(class154.field2299.field2731);
            Client.field311.method2642(class128.field2074.field2731);
            Client.field311.method2642(Buffer.field2033.field2731);
            Client.field311.method2642(class188.field3046.field2731);
            Client.field311.method2642(Client.field299.field2731);
            Client.field311.method2642(class18.field236.field2731);
            Client.field311.method2642(class143.field2200.field2731);
            Client.field311.method2500(var7, var2, Client.field311.offset);
            Client.field311.method2632(Client.field311.offset - var1);
            class32.field695.method2987(Client.field311.payload, 0, Client.field311.offset);
            Client.field300.method2747(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field312.method2747(var7);
            Client.field420 = 6;
         }

         if(Client.field420 == 6 && class32.field695.method2988() > 0) {
            var0 = class32.field695.method2991();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field420 = 7;
            } else if(var0 == 2) {
               Client.field420 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field313 = -1;
               Client.field420 = 13;
            } else if(var0 == 23 && Client.field268 < 1) {
               ++Client.field268;
               Client.field420 = 0;
            } else {
               if(var0 != 29) {
                  class8.method108(var0);
                  return;
               }

               Client.field420 = 11;
            }
         }

         if(Client.field420 == 7 && class32.field695.method2988() > 0) {
            Client.field304 = (class32.field695.method2991() + 3) * 60;
            Client.field420 = 8;
         }

         if(Client.field420 == 8) {
            Client.field352 = 0;
            class79.method1681("You have only just left another world.", "Your profile will be transferred in:", Client.field304 / 60 + " seconds.");
            if(--Client.field304 <= 0) {
               Client.field420 = 0;
            }

         } else {
            boolean var15;
            if(Client.field420 == 9 && class32.field695.method2988() >= 13) {
               boolean var14 = class32.field695.method2991() == 1;
               class32.field695.method2996(Client.field312.payload, 0, 4);
               Client.field312.offset = 0;
               var15 = false;
               if(var14) {
                  var1 = Client.field312.method2749() << 24;
                  var1 |= Client.field312.method2749() << 16;
                  var1 |= Client.field312.method2749() << 8;
                  var1 |= Client.field312.method2749();
                  var2 = Renderable.method1905(class33.username);
                  if(Sequence.field984.field126.size() >= 10 && !Sequence.field984.field126.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = Sequence.field984.field126.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  Sequence.field984.field126.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class129.method2815();
               }

               Client.field435 = class32.field695.method2991();
               Client.field437 = class32.field695.method2991() == 1;
               Client.localInteractingIndex = class32.field695.method2991();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class32.field695.method2991();
               Client.field387 = class32.field695.method2991();
               class32.field695.method2996(Client.field312.payload, 0, 1);
               Client.field312.offset = 0;
               Client.packetOpcode = Client.field312.method2749();
               class32.field695.method2996(Client.field312.payload, 0, 2);
               Client.field312.offset = 0;
               Client.field313 = Client.field312.method2668();

               try {
                  class135.method2844(Client.field389, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field420 = 10;
            }

            if(Client.field420 == 10) {
               if(class32.field695.method2988() >= Client.field313) {
                  Client.field312.offset = 0;
                  class32.field695.method2996(Client.field312.payload, 0, Client.field313);
                  Client.field277 = 1L;
                  Client.field471 = -1;
                  class18.field244.field187 = 0;
                  class85.field1475 = true;
                  Client.field475 = true;
                  Client.field494 = -1L;
                  class214.field3181 = new class205();
                  Client.field300.offset = 0;
                  Client.field312.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field345 = -1;
                  Client.field318 = -1;
                  Client.field319 = -1;
                  Client.field272 = 0;
                  Client.field290 = 0;
                  Client.field548 = 0;
                  Client.field310 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class143.mouseIdleTicks = 0;
                  class141.method2922();
                  Client.field421 = 0;
                  Client.field270 = false;
                  Client.field510 = 0;
                  Client.field485 = (int)(Math.random() * 100.0D) - 50;
                  Client.field447 = (int)(Math.random() * 110.0D) - 55;
                  Client.field337 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field326 = 0;
                  Client.field451 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field292 = class21.field564;
                  Client.field293 = class21.field564;
                  Client.field309 = 0;
                  class26.method604();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field399 = -1;
                  Client.projectiles.method3802();
                  Client.field403.method3802();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field401 = new Deque();
                  Client.field536 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class232.field3277; ++var0) {
                     class56 var21 = class125.method2774(var0);
                     if(var21 != null) {
                        class179.settings[var0] = 0;
                        class179.widgetSettings[var0] = 0;
                     }
                  }

                  class141.chatMessages.method205();
                  Client.field436 = -1;
                  if(Client.widgetRoot != -1) {
                     var0 = Client.widgetRoot;
                     if(var0 != -1 && Widget.validInterfaces[var0]) {
                        Widget.field2788.method3262(var0);
                        if(Widget.widgets[var0] != null) {
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

                  for(WidgetNode var19 = (WidgetNode)Client.componentTable.method3780(); var19 != null; var19 = (WidgetNode)Client.componentTable.method3785()) {
                     class14.method169(var19, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field432 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field541.method3474((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field396[var0] = null;
                     Client.field513[var0] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  Client.field275 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field379[var0] = true;
                  }

                  Player.method39();
                  Client.field495 = null;
                  NPC.field764 = 0;
                  Frames.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class117.field2004 = null;
                  Ignore.method105(Client.field312);
                  class54.field1132 = -1;
                  class152.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field420 == 11 && class32.field695.method2988() >= 2) {
                  Client.field312.offset = 0;
                  class32.field695.method2996(Client.field312.payload, 0, 2);
                  Client.field312.offset = 0;
                  class109.field1910 = Client.field312.method2668();
                  Client.field420 = 12;
               }

               if(Client.field420 == 12 && class32.field695.method2988() >= class109.field1910) {
                  Client.field312.offset = 0;
                  class32.field695.method2996(Client.field312.payload, 0, class109.field1910);
                  Client.field312.offset = 0;
                  String var18 = Client.field312.method2503();
                  String var10 = Client.field312.method2503();
                  String var9 = Client.field312.method2503();
                  class79.method1681(var18, var10, var9);
                  class112.setGameState(10);
               }

               if(Client.field420 != 13) {
                  ++Client.field352;
                  if(Client.field352 > 2000) {
                     if(Client.field268 < 1) {
                        if(ItemLayer.field1726 == class20.field558) {
                           ItemLayer.field1726 = class156.field2318;
                        } else {
                           ItemLayer.field1726 = class20.field558;
                        }

                        ++Client.field268;
                        Client.field420 = 0;
                     } else {
                        class8.method108(-3);
                     }
                  }
               } else {
                  if(Client.field313 == -1) {
                     if(class32.field695.method2988() < 2) {
                        return;
                     }

                     class32.field695.method2996(Client.field312.payload, 0, 2);
                     Client.field312.offset = 0;
                     Client.field313 = Client.field312.method2668();
                  }

                  if(class32.field695.method2988() >= Client.field313) {
                     class32.field695.method2996(Client.field312.payload, 0, Client.field313);
                     Client.field312.offset = 0;
                     var0 = Client.field313;
                     Client.field300.offset = 0;
                     Client.field312.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field345 = -1;
                     Client.field318 = -1;
                     Client.field319 = -1;
                     Client.field313 = 0;
                     Client.field272 = 0;
                     Client.field290 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field326 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     TextureProvider.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var20 = Client.cachedNPCs[var1];
                        if(null != var20) {
                           var20.interacting = -1;
                           var20.field828 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     class112.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field379[var1] = true;
                     }

                     Player.method39();
                     Ignore.method105(Client.field312);
                     if(Client.field312.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field268 < 1) {
            if(ItemLayer.field1726 == class20.field558) {
               ItemLayer.field1726 = class156.field2318;
            } else {
               ItemLayer.field1726 = class20.field558;
            }

            ++Client.field268;
            Client.field420 = 0;
         } else {
            class8.method108(-2);
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "-218997446"
   )
   static void method566(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class216.field3195) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1867();
         byte[] var5 = var1.method3273("title.jpg", "");
         class33.field725 = new SpritePixels(var5, var0);
         class129.field2078 = class33.field725.method1770();
         if((Client.flags & 536870912) != 0) {
            class33.field704 = class225.method4021(var2, "logo_deadman_mode", "");
         } else {
            class33.field704 = class225.method4021(var2, "logo", "");
         }

         class33.field721 = class225.method4021(var2, "titlebox", "");
         class116.field1995 = class225.method4021(var2, "titlebutton", "");
         class33.field702 = ChatLineBuffer.method670(var2, "runes", "");
         class33.field705 = ChatLineBuffer.method670(var2, "title_mute", "");
         class47.field1030 = class225.method4021(var2, "options_radio_buttons,0", "");
         class124.field2045 = class225.method4021(var2, "options_radio_buttons,2", "");
         class52.field1114 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class52.field1114[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class52.field1114[var6 + 64] = 16711680 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class52.field1114[var6 + 128] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class52.field1114[192 + var6] = 16777215;
         }

         class33.field727 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field727[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field727[64 + var6] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field727[var6 + 128] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field727[var6 + 192] = 16777215;
         }

         MessageNode.field780 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            MessageNode.field780[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            MessageNode.field780[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            MessageNode.field780[128 + var6] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            MessageNode.field780[192 + var6] = 16777215;
         }

         ChatLineBuffer.field665 = new int[256];
         class33.field710 = new int['耀'];
         class33.field701 = new int['耀'];
         XItemContainer.method182((ModIcon)null);
         class38.field799 = new int['耀'];
         class14.field191 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field726 = "";
         }

         Tile.field1787 = 0;
         class51.authCode = "";
         class33.field728 = true;
         class33.worldSelectShown = false;
         if(!Sequence.field984.field124) {
            class171 var9 = class47.field1024;
            int var7 = var9.method3265("scape main");
            int var8 = var9.method3266(var7, "");
            class77.method1614(2, var9, var7, var8, 255, false);
         } else {
            class52.method1044(2);
         }

         class157.method3155(false);
         class216.field3195 = true;
         class33.field715 = (class50.field1069 - Client.field483) / 2;
         class33.loginWindowX = 202 + class33.field715;
         class33.field725.method1710(class33.field715, 0);
         class129.field2078.method1710(382 + class33.field715, 0);
         class33.field704.method1871(382 + class33.field715 - class33.field704.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIB)V",
      garbageValue = "107"
   )
   static final void method567(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2797 || var9.type == 0 || var9.field2916 || class11.method138(var9) != 0 || Client.field391 == var9 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.field2797 || !class13.method164(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var19 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field441 == var9) {
               Client.field449 = true;
               Client.field450 = var10;
               Client.field474 = var11;
            }

            if(!var9.field2797 || var12 < var14 && var13 < var15) {
               var16 = class143.field2192;
               var17 = class143.field2189;
               if(class143.field2198 != 0) {
                  var16 = class143.field2188;
                  var17 = class143.field2196;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field275 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     method552(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class12.method160(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     GameEngine.method3095(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2797 && class13.method164(var9) && ItemComposition.field1196 != var9) {
                        continue;
                     }

                     method567(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method567(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var28 = (WidgetNode)Client.componentTable.method3775((long)var9.id);
                     if(var28 != null) {
                        if(var28.field54 == 0 && class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15 && !Client.isMenuOpen && !Client.field438) {
                           for(class0 var29 = (class0)Client.field467.method3808(); var29 != null; var29 = (class0)Client.field467.method3810()) {
                              if(var29.field0) {
                                 var29.unlink();
                                 var29.field2.field2863 = false;
                              }
                           }

                           if(class155.field2311 == 0) {
                              Client.field441 = null;
                              Client.field391 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var28.id;
                        if(class174.method3393(var19)) {
                           method567(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  int var23;
                  int var27;
                  int var34;
                  if(var9.field2797) {
                     class0 var35;
                     if(!var9.field2931) {
                        if(var9.field2932 && class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15) {
                           for(var35 = (class0)Client.field467.method3808(); null != var35; var35 = (class0)Client.field467.method3810()) {
                              if(var35.field0 && var35.field2.field2899 == var35.field5) {
                                 var35.unlink();
                              }
                           }
                        }
                     } else if(class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15) {
                        for(var35 = (class0)Client.field467.method3808(); null != var35; var35 = (class0)Client.field467.method3810()) {
                           if(var35.field0) {
                              var35.unlink();
                              var35.field2.field2863 = false;
                           }
                        }

                        if(class155.field2311 == 0) {
                           Client.field441 = null;
                           Client.field391 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var31;
                     if(class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15) {
                        var31 = true;
                     } else {
                        var31 = false;
                     }

                     boolean var32 = false;
                     if((class143.field2184 == 1 || !class18.field245 && class143.field2184 == 4) && var31) {
                        var32 = true;
                     }

                     boolean var20 = false;
                     if((class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4) && class143.field2188 >= var12 && class143.field2196 >= var13 && class143.field2188 < var14 && class143.field2196 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class5.method52(var9, class143.field2188 - var10, class143.field2196 - var11);
                     }

                     if(null != Client.field441 && Client.field441 != var9 && var31) {
                        var27 = class11.method138(var9);
                        boolean var26 = (var27 >> 20 & 1) != 0;
                        if(var26) {
                           Client.field283 = var9;
                        }
                     }

                     if(var9 == Client.field391) {
                        Client.field446 = true;
                        Client.field404 = var10;
                        Client.field336 = var11;
                     }

                     if(var9.field2916) {
                        class0 var21;
                        if(var31 && Client.field335 != 0 && var9.field2899 != null) {
                           var21 = new class0();
                           var21.field0 = true;
                           var21.field2 = var9;
                           var21.field1 = Client.field335;
                           var21.field5 = var9.field2899;
                           Client.field467.method3801(var21);
                        }

                        if(null != Client.field441 || SecondaryBufferProvider.field1414 != null || Client.isMenuOpen) {
                           var20 = false;
                           var32 = false;
                           var31 = false;
                        }

                        if(!var9.field2875 && var20) {
                           var9.field2875 = true;
                           if(var9.field2880 != null) {
                              var21 = new class0();
                              var21.field0 = true;
                              var21.field2 = var9;
                              var21.field10 = class143.field2188 - var10;
                              var21.field1 = class143.field2196 - var11;
                              var21.field5 = var9.field2880;
                              Client.field467.method3801(var21);
                           }
                        }

                        if(var9.field2875 && var32 && var9.field2881 != null) {
                           var21 = new class0();
                           var21.field0 = true;
                           var21.field2 = var9;
                           var21.field10 = class143.field2192 - var10;
                           var21.field1 = class143.field2189 - var11;
                           var21.field5 = var9.field2881;
                           Client.field467.method3801(var21);
                        }

                        if(var9.field2875 && !var32) {
                           var9.field2875 = false;
                           if(var9.field2860 != null) {
                              var21 = new class0();
                              var21.field0 = true;
                              var21.field2 = var9;
                              var21.field10 = class143.field2192 - var10;
                              var21.field1 = class143.field2189 - var11;
                              var21.field5 = var9.field2860;
                              Client.field469.method3801(var21);
                           }
                        }

                        if(var32 && var9.field2882 != null) {
                           var21 = new class0();
                           var21.field0 = true;
                           var21.field2 = var9;
                           var21.field10 = class143.field2192 - var10;
                           var21.field1 = class143.field2189 - var11;
                           var21.field5 = var9.field2882;
                           Client.field467.method3801(var21);
                        }

                        if(!var9.field2863 && var31) {
                           var9.field2863 = true;
                           if(null != var9.field2927) {
                              var21 = new class0();
                              var21.field0 = true;
                              var21.field2 = var9;
                              var21.field10 = class143.field2192 - var10;
                              var21.field1 = class143.field2189 - var11;
                              var21.field5 = var9.field2927;
                              Client.field467.method3801(var21);
                           }
                        }

                        if(var9.field2863 && var31 && null != var9.field2885) {
                           var21 = new class0();
                           var21.field0 = true;
                           var21.field2 = var9;
                           var21.field10 = class143.field2192 - var10;
                           var21.field1 = class143.field2189 - var11;
                           var21.field5 = var9.field2885;
                           Client.field467.method3801(var21);
                        }

                        if(var9.field2863 && !var31) {
                           var9.field2863 = false;
                           if(null != var9.field2814) {
                              var21 = new class0();
                              var21.field0 = true;
                              var21.field2 = var9;
                              var21.field10 = class143.field2192 - var10;
                              var21.field1 = class143.field2189 - var11;
                              var21.field5 = var9.field2814;
                              Client.field469.method3801(var21);
                           }
                        }

                        if(null != var9.field2897) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2897;
                           Client.field301.method3801(var21);
                        }

                        class0 var24;
                        if(var9.field2822 != null && Client.field455 > var9.field2926) {
                           if(var9.field2892 != null && Client.field455 - var9.field2926 <= 32) {
                              label866:
                              for(var34 = var9.field2926; var34 < Client.field455; ++var34) {
                                 var27 = Client.field472[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2892.length; ++var23) {
                                    if(var27 == var9.field2892[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field5 = var9.field2822;
                                       Client.field467.method3801(var24);
                                       break label866;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field5 = var9.field2822;
                              Client.field467.method3801(var21);
                           }

                           var9.field2926 = Client.field455;
                        }

                        if(null != var9.field2893 && Client.field457 > var9.field2864) {
                           if(var9.field2846 != null && Client.field457 - var9.field2864 <= 32) {
                              label842:
                              for(var34 = var9.field2864; var34 < Client.field457; ++var34) {
                                 var27 = Client.field456[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2846.length; ++var23) {
                                    if(var27 == var9.field2846[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field5 = var9.field2893;
                                       Client.field467.method3801(var24);
                                       break label842;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field5 = var9.field2893;
                              Client.field467.method3801(var21);
                           }

                           var9.field2864 = Client.field457;
                        }

                        if(var9.field2887 != null && Client.field459 > var9.field2928) {
                           if(null != var9.field2896 && Client.field459 - var9.field2928 <= 32) {
                              label818:
                              for(var34 = var9.field2928; var34 < Client.field459; ++var34) {
                                 var27 = Client.field321[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2896.length; ++var23) {
                                    if(var9.field2896[var23] == var27) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field5 = var9.field2887;
                                       Client.field467.method3801(var24);
                                       break label818;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field5 = var9.field2887;
                              Client.field467.method3801(var21);
                           }

                           var9.field2928 = Client.field459;
                        }

                        if(Client.field460 > var9.field2925 && var9.field2900 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2900;
                           Client.field467.method3801(var21);
                        }

                        if(Client.field461 > var9.field2925 && var9.field2902 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2902;
                           Client.field467.method3801(var21);
                        }

                        if(Client.field462 > var9.field2925 && var9.field2903 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2903;
                           Client.field467.method3801(var21);
                        }

                        if(Client.field284 > var9.field2925 && var9.field2890 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2890;
                           Client.field467.method3801(var21);
                        }

                        if(Client.field464 > var9.field2925 && null != var9.field2894) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2894;
                           Client.field467.method3801(var21);
                        }

                        if(Client.field332 > var9.field2925 && var9.field2904 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field5 = var9.field2904;
                           Client.field467.method3801(var21);
                        }

                        var9.field2925 = Client.field453;
                        if(var9.field2901 != null) {
                           for(var34 = 0; var34 < Client.field491; ++var34) {
                              class0 var22 = new class0();
                              var22.field2 = var9;
                              var22.field4 = Client.field493[var34];
                              var22.field8 = Client.field492[var34];
                              var22.field5 = var9.field2901;
                              Client.field467.method3801(var22);
                           }
                        }
                     }
                  }

                  if(!var9.field2797 && null == Client.field441 && SecondaryBufferProvider.field1414 == null && !Client.isMenuOpen) {
                     if((var9.field2913 >= 0 || var9.field2825 != 0) && class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15) {
                        if(var9.field2913 >= 0) {
                           ItemComposition.field1196 = var0[var9.field2913];
                        } else {
                           ItemComposition.field1196 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2192 >= var12 && class143.field2189 >= var13 && class143.field2192 < var14 && class143.field2189 < var15) {
                        class38.field793 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var9.width + var10;
                        var19 = var9.height;
                        int var33 = var9.scrollHeight;
                        var34 = class143.field2192;
                        var27 = class143.field2189;
                        if(Client.field382) {
                           Client.field423 = 32;
                        } else {
                           Client.field423 = 0;
                        }

                        Client.field382 = false;
                        if(class143.field2184 == 1 || !class18.field245 && class143.field2184 == 4) {
                           if(var34 >= var18 && var34 < var18 + 16 && var27 >= var11 && var27 < 16 + var11) {
                              var9.scrollY -= 4;
                              class32.method685(var9);
                           } else if(var34 >= var18 && var34 < 16 + var18 && var27 >= var11 + var19 - 16 && var27 < var19 + var11) {
                              var9.scrollY += 4;
                              class32.method685(var9);
                           } else if(var34 >= var18 - Client.field423 && var34 < 16 + var18 + Client.field423 && var27 >= 16 + var11 && var27 < var11 + var19 - 16) {
                              var23 = var19 * (var19 - 32) / var33;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              int var30 = var27 - var11 - 16 - var23 / 2;
                              int var25 = var19 - 32 - var23;
                              var9.scrollY = (var33 - var19) * var30 / var25;
                              class32.method685(var9);
                              Client.field382 = true;
                           }
                        }

                        if(Client.field335 != 0) {
                           var23 = var9.width;
                           if(var34 >= var18 - var23 && var27 >= var11 && var34 < 16 + var18 && var27 <= var19 + var11) {
                              var9.scrollY += Client.field335 * 45;
                              class32.method685(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "111"
   )
   static void method568() {
      for(class24 var0 = (class24)class24.field590.method3808(); null != var0; var0 = (class24)class24.field590.method3810()) {
         if(null != var0.field598) {
            class75.field1389.method1144(var0.field598);
            var0.field598 = null;
         }

         if(null != var0.field599) {
            class75.field1389.method1144(var0.field599);
            var0.field599 = null;
         }
      }

      class24.field590.method3802();
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "2084238921"
   )
   static final void method569(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field271 && var0 != class59.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class114.region.method2004(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class114.region.method1942(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class114.region.method1943(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class114.region.method1944(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class114.region.method1945(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class114.region.method2057(var0, var2, var3);
               var12 = class40.getObjectDefinition(var34);
               if(var12.field914 != 0) {
                  Client.collisionMaps[var0].method2366(var2, var3, var35, var36, var12.field951);
               }
            }

            if(var1 == 1) {
               class114.region.method1933(var0, var2, var3);
            }

            if(var1 == 2) {
               class114.region.method1934(var0, var2, var3);
               var12 = class40.getObjectDefinition(var34);
               if(var12.field923 + var2 > 103 || var3 + var12.field923 > 103 || var2 + var12.field924 > 103 || var3 + var12.field924 > 103) {
                  return;
               }

               if(var12.field914 != 0) {
                  Client.collisionMaps[var0].method2367(var2, var3, var12.field923, var12.field924, var36, var12.field951);
               }
            }

            if(var1 == 3) {
               class114.region.method1972(var0, var2, var3);
               var12 = class40.getObjectDefinition(var34);
               if(var12.field914 == 1) {
                  Client.collisionMaps[var0].method2369(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class114.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class40.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field923;
               var16 = var14.field924;
            } else {
               var15 = var14.field924;
               var16 = var14.field923;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = (var15 + 1 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.tileHeights[var11];
            int var22 = var21[var17][var20] + var21[var17][var19] + var21[var18][var19] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var4 << 14) + (var3 << 7) + var2 + 1073741824;
            if(var14.field927 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field948 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field932 == -1 && var14.impostorIds == null) {
                  var27 = var14.method819(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field914 == 1) {
                  var13.method2377(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field932 == -1 && var14.impostorIds == null) {
                     var27 = var14.method819(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                  }

                  var37.method2007(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field914 != 0) {
                     var13.method2362(var2, var3, var15, var16, var14.field951);
                  }
               } else if(var6 == 0) {
                  if(var14.field932 == -1 && null == var14.impostorIds) {
                     var27 = var14.method819(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                  }

                  var37.method2020(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field74[var5], 0, var25, var26);
                  if(var14.field914 != 0) {
                     var13.method2361(var2, var3, var6, var5, var14.field951);
                  }
               } else if(var6 == 1) {
                  if(var14.field932 == -1 && var14.impostorIds == null) {
                     var27 = var14.method819(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                  }

                  var37.method2020(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field84[var5], 0, var25, var26);
                  if(var14.field914 != 0) {
                     var13.method2361(var2, var3, var6, var5, var14.field951);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var33;
                     if(var14.field932 == -1 && var14.impostorIds == null) {
                        var33 = var14.method819(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method819(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field932, true, (Renderable)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field932, true, (Renderable)null);
                     }

                     var37.method2020(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class5.field74[var5], class5.field74[var32], var25, var26);
                     if(var14.field914 != 0) {
                        var13.method2361(var2, var3, var6, var5, var14.field951);
                     }
                  } else if(var6 == 3) {
                     if(var14.field932 == -1 && null == var14.impostorIds) {
                        var27 = var14.method819(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                     }

                     var37.method2020(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field84[var5], 0, var25, var26);
                     if(var14.field914 != 0) {
                        var13.method2361(var2, var3, var6, var5, var14.field951);
                     }
                  } else if(var6 == 9) {
                     if(var14.field932 == -1 && null == var14.impostorIds) {
                        var27 = var14.method819(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                     }

                     var37.method2007(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field914 != 0) {
                        var13.method2362(var2, var3, var15, var16, var14.field951);
                     }
                  } else if(var6 == 4) {
                     if(var14.field932 == -1 && null == var14.impostorIds) {
                        var27 = var14.method819(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                     }

                     var37.method1924(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field74[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method2004(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class40.getObjectDefinition(var28 >> 14 & 32767).field915;
                        }

                        if(var14.field932 == -1 && var14.impostorIds == null) {
                           var29 = var14.method819(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                        }

                        var37.method1924(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class5.field74[var5], 0, var32 * class5.field76[var5], class5.field77[var5] * var32, var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method2004(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class40.getObjectDefinition(var28 >> 14 & 32767).field915 / 2;
                        }

                        if(var14.field932 == -1 && var14.impostorIds == null) {
                           var29 = var14.method819(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                        }

                        var37.method1924(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class5.field78[var5], var32 * class5.field71[var5], var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field932 == -1 && var14.impostorIds == null) {
                           var27 = var14.method819(4, 4 + var28, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, 4 + var28, var11, var2, var3, var14.field932, true, (Renderable)null);
                        }

                        var37.method1924(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method2004(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class40.getObjectDefinition(var28 >> 14 & 32767).field915 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field932 == -1 && var14.impostorIds == null) {
                           var29 = var14.method819(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method819(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field932, true, (Renderable)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field932, true, (Renderable)null);
                        }

                        var37.method1924(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class5.field78[var5] * var32, var32 * class5.field71[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field932 == -1 && var14.impostorIds == null) {
                  var27 = var14.method819(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field932, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2007(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field914 != 0) {
                  var13.method2362(var2, var3, var15, var16, var14.field951);
               }
            }
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method553((class217)var1, (class217)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZI)V",
      garbageValue = "-170065985"
   )
   public static void method570(class170 var0, class170 var1, boolean var2) {
      ObjectComposition.field921 = var0;
      class180.field2953 = var1;
      ObjectComposition.field920 = var2;
   }
}
