import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("u")
final class class17 implements Comparator {
   @ObfuscatedName("bz")
   static String field321;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field317;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;I)I",
      garbageValue = "432597145"
   )
   int method137(class14 var1, class14 var2) {
      return var1.field296.price < var2.field296.price?-1:(var2.field296.price == var1.field296.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method137((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1936733732"
   )
   static void method144() {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(class91.canvasWidth);
      Client.secretPacketBuffer1.putShort(class64.canvasHeight);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;S)I",
      garbageValue = "-32266"
   )
   static int method145(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4155("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4155("logo", "")) {
         ++var2;
      }

      if(var1.method4155("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4155("titlebox", "")) {
         ++var2;
      }

      if(var1.method4155("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4155("runes", "")) {
         ++var2;
      }

      if(var1.method4155("title_mute", "")) {
         ++var2;
      }

      if(var1.method4155("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4155("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.method4155("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.method4155("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.method4155("sl_back", "");
      var1.method4155("sl_flags", "");
      var1.method4155("sl_arrows", "");
      var1.method4155("sl_stars", "");
      var1.method4155("sl_button", "");
      return var2;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1314145822"
   )
   static final void method143() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == Opcodes.PACKET_SERVER_184) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var3 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = (var0 >> 4 & 7) + class21.field353;
            var2 = (var0 & 7) + class37.field529;
         } else {
            var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            var1 = (var0 >> 4 & 7) + class21.field353;
            var2 = (var0 & 7) + class37.field529;
            var3 = Client.secretPacketBuffer2.method3276();
         }

         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field1134[var4];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class61.method1097(class27.plane, var1, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         Item var30;
         if(Client.packetType == Opcodes.PACKET_SERVER_56) {
            if(Client.RUNELITE_PACKET) {
               var1 = Client.secretPacketBuffer2.runeliteReadInt();
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
            } else {
               var0 = Client.secretPacketBuffer2.method3282();
               var1 = Client.secretPacketBuffer2.readUnsignedByte();
            }

            var2 = (var1 >> 4 & 7) + class21.field353;
            var3 = (var1 & 7) + class37.field529;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var29 = Client.groundItemDeque[class27.plane][var2][var3];
               if(var29 != null) {
                  for(var30 = (Item)var29.getFront(); var30 != null; var30 = (Item)var29.getNext()) {
                     if((var0 & 32767) == var30.id) {
                        var30.unlink();
                        break;
                     }
                  }

                  if(var29.getFront() == null) {
                     Client.groundItemDeque[class27.plane][var2][var3] = null;
                  }

                  class204.groundItemSpawned(var2, var3);
               }
            }

         } else {
            int var7;
            int var9;
            if(Client.packetType == Opcodes.PACKET_SERVER_136) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
               } else {
                  var0 = Client.secretPacketBuffer2.method3276();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
                  var3 = Client.secretPacketBuffer2.method3309();
                  var4 = Client.secretPacketBuffer2.method3276();
               }

               var5 = var4 >> 2;
               var6 = var4 & 3;
               var7 = Client.field1134[var5];
               if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                  if(var7 == 0) {
                     WallObject var34 = ScriptState.region.method2734(class27.plane, var1, var2);
                     if(var34 != null) {
                        var9 = var34.hash >> 14 & 32767;
                        if(var5 == 2) {
                           var34.renderable1 = new DynamicObject(var9, 2, var6 + 4, class27.plane, var1, var2, var3, false, var34.renderable1);
                           var34.renderable2 = new DynamicObject(var9, 2, var6 + 1 & 3, class27.plane, var1, var2, var3, false, var34.renderable2);
                        } else {
                           var34.renderable1 = new DynamicObject(var9, var5, var6, class27.plane, var1, var2, var3, false, var34.renderable1);
                        }
                     }
                  }

                  if(var7 == 1) {
                     DecorativeObject var40 = ScriptState.region.method2786(class27.plane, var1, var2);
                     if(var40 != null) {
                        var9 = var40.hash >> 14 & 32767;
                        if(var5 != 4 && var5 != 5) {
                           if(var5 == 6) {
                              var40.renderable1 = new DynamicObject(var9, 4, var6 + 4, class27.plane, var1, var2, var3, false, var40.renderable1);
                           } else if(var5 == 7) {
                              var40.renderable1 = new DynamicObject(var9, 4, 4 + (var6 + 2 & 3), class27.plane, var1, var2, var3, false, var40.renderable1);
                           } else if(var5 == 8) {
                              var40.renderable1 = new DynamicObject(var9, 4, var6 + 4, class27.plane, var1, var2, var3, false, var40.renderable1);
                              var40.renderable2 = new DynamicObject(var9, 4, (var6 + 2 & 3) + 4, class27.plane, var1, var2, var3, false, var40.renderable2);
                           }
                        } else {
                           var40.renderable1 = new DynamicObject(var9, 4, var6, class27.plane, var1, var2, var3, false, var40.renderable1);
                        }
                     }
                  }

                  if(var7 == 2) {
                     GameObject var41 = ScriptState.region.method2825(class27.plane, var1, var2);
                     if(var5 == 11) {
                        var5 = 10;
                     }

                     if(var41 != null) {
                        var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, var5, var6, class27.plane, var1, var2, var3, false, var41.renderable);
                     }
                  }

                  if(var7 == 3) {
                     GroundObject var42 = ScriptState.region.method2806(class27.plane, var1, var2);
                     if(var42 != null) {
                        var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, 22, var6, class27.plane, var1, var2, var3, false, var42.renderable);
                     }
                  }
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_201) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var7 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field1134[var4];
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
                  var3 = Client.secretPacketBuffer2.method3276();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field1134[var4];
                  var7 = Client.secretPacketBuffer2.readUnsignedShort();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class61.method1097(class27.plane, var1, var2, var6, var7, var4, var5, 0, -1);
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_0) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
               } else {
                  var0 = Client.secretPacketBuffer2.method3276();
                  var1 = (var0 >> 4 & 7) + class21.field353;
                  var2 = (var0 & 7) + class37.field529;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.method3309();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var30 = new Item();
                  var30.id = var4;
                  var30.quantity = var3;
                  if(Client.groundItemDeque[class27.plane][var1][var2] == null) {
                     Client.groundItemDeque[class27.plane][var1][var2] = new Deque();
                  }

                  Client.groundItemDeque[class27.plane][var1][var2].addFront(var30);
                  class204.groundItemSpawned(var1, var2);
               }

            } else {
               int var8;
               if(Client.packetType == Opcodes.PACKET_SERVER_243) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var7 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var7 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var5 + 1;
                     if(Player.localPlayer.pathX[0] >= var1 - var8 && Player.localPlayer.pathX[0] <= var1 + var8 && Player.localPlayer.pathY[0] >= var2 - var8 && Player.localPlayer.pathY[0] <= var2 + var8 && Client.field1171 != 0 && var6 > 0 && Client.field1172 < 50) {
                        Client.field1173[Client.field1172] = var3;
                        Client.field1174[Client.field1172] = var6;
                        Client.field1001[Client.field1172] = var7;
                        Client.audioEffects[Client.field1172] = null;
                        Client.field1176[Client.field1172] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field1172;
                     }
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_157) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var39 = new GraphicsObject(var3, class27.plane, var1, var2, class227.getTileHeight(var1, var2, class27.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var39);
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_170) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedShort();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var31 = Client.groundItemDeque[class27.plane][var1][var2];
                     if(var31 != null) {
                        for(Item var32 = (Item)var31.getFront(); var32 != null; var32 = (Item)var31.getNext()) {
                           if((var3 & 32767) == var32.id && var4 == var32.quantity) {
                              var32.quantity = var5;
                              break;
                           }
                        }

                        class204.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == Opcodes.PACKET_SERVER_37) {
                     byte var35;
                     byte var36;
                     byte var37;
                     byte var38;
                     if(Client.RUNELITE_PACKET) {
                        var2 = Client.secretPacketBuffer2.runeliteReadInt();
                        var11 = Client.secretPacketBuffer2.runeliteReadInt();
                        var8 = Client.secretPacketBuffer2.runeliteReadInt();
                        var10 = Client.secretPacketBuffer2.runeliteReadInt();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var1 = Client.secretPacketBuffer2.runeliteReadInt();
                        var9 = Client.secretPacketBuffer2.runeliteReadInt();
                        var37 = Client.secretPacketBuffer2.runeliteReadByte();
                        var38 = Client.secretPacketBuffer2.runeliteReadByte();
                        var36 = Client.secretPacketBuffer2.runeliteReadByte();
                        var3 = (var2 >> 4 & 7) + class21.field353;
                        var4 = (var2 & 7) + class37.field529;
                     } else {
                        var35 = Client.secretPacketBuffer2.readByte();
                        var1 = Client.secretPacketBuffer2.method3309();
                        var2 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                        var3 = (var2 >> 4 & 7) + class21.field353;
                        var4 = (var2 & 7) + class37.field529;
                        var36 = Client.secretPacketBuffer2.method3277();
                        var37 = Client.secretPacketBuffer2.method3278();
                        var38 = Client.secretPacketBuffer2.method3277();
                        var8 = Client.secretPacketBuffer2.method3282();
                        var9 = Client.secretPacketBuffer2.readUnsignedShort();
                        var10 = Client.secretPacketBuffer2.method3451();
                        var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     }

                     var12 = var11 >> 2;
                     int var33 = var11 & 3;
                     int var14 = Client.field1134[var12];
                     Player var15;
                     if(var8 == Client.localInteractingIndex) {
                        var15 = Player.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var8];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = GameObject.getObjectDefinition(var10);
                        int var17;
                        int var18;
                        if(var33 != 1 && var33 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var3 + (var17 >> 1);
                        int var20 = var3 + (var17 + 1 >> 1);
                        int var21 = var4 + (var18 >> 1);
                        int var22 = (var18 + 1 >> 1) + var4;
                        int[][] var23 = class61.tileHeights[class27.plane];
                        int var24 = var23[var20][var22] + var23[var19][var21] + var23[var20][var21] + var23[var19][var22] >> 2;
                        int var25 = (var3 << 7) + (var17 << 6);
                        int var26 = (var4 << 7) + (var18 << 6);
                        Model var27 = var16.method4530(var12, var33, var23, var25, var24, var26);
                        if(var27 != null) {
                           class61.method1097(class27.plane, var3, var4, var14, -1, 0, 0, var1 + 1, var9 + 1);
                           var15.field929 = var1 + Client.gameCycle;
                           var15.field921 = var9 + Client.gameCycle;
                           var15.model = var27;
                           var15.field911 = var3 * 128 + var17 * 64;
                           var15.field913 = var18 * 64 + var4 * 128;
                           var15.field927 = var24;
                           byte var28;
                           if(var35 > var36) {
                              var28 = var35;
                              var35 = var36;
                              var36 = var28;
                           }

                           if(var37 > var38) {
                              var28 = var37;
                              var37 = var38;
                              var38 = var28;
                           }

                           var15.field915 = var3 + var35;
                           var15.field922 = var36 + var3;
                           var15.field916 = var37 + var4;
                           var15.field900 = var4 + var38;
                        }
                     }

                  } else if(Client.packetType == Opcodes.PACKET_SERVER_28) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class21.field353;
                     var2 = (var0 & 7) + class37.field529;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = 64 + var3 * 128;
                        var4 = var4 * 128 + 64;
                        Projectile var13 = new Projectile(var6, class27.plane, var1, var2, class227.getTileHeight(var1, var2, class27.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var8);
                        var13.method1768(var3, var4, class227.getTileHeight(var3, var4, class27.plane) - var8, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var13);
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1327252730"
   )
   static int method136(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class31.field452:class23.field366;
      if(var0 == 1700) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class82.intStack[++Ignore.intStackSize - 1] = var3.itemQuantity;
         } else {
            class82.intStack[++Ignore.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1095384199"
   )
   static int method131(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
