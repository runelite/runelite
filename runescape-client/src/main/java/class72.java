import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ba")
public class class72 extends class163 {
   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field882;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILfw;B)Z",
      garbageValue = "66"
   )
   protected boolean vmethod3126(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2307 && var3 == super.field2306;
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "69"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class7.clientInstance.method878();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field957 = 0;
            Client.field1184 = 0;
            Client.field979.method4993(var0);
            if(var0 != 20) {
               World.method1577(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class17.field324 != null) {
            class17.field324.close();
            class17.field324 = null;
         }

         if(Client.gameState == 25) {
            Client.field985 = 0;
            Client.field981 = 0;
            Client.field982 = 1;
            Client.field983 = 0;
            Client.field984 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               ScriptVarType.method27(class89.field1409, class3.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               ScriptVarType.method27(class89.field1409, class3.indexSprites, false, 4);
            } else {
               class19.method150();
            }
         } else {
            ScriptVarType.method27(class89.field1409, class3.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   static final void method1109() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var29;
      int var30;
      int var31;
      if(Client.packetType == Opcodes.PACKET_SERVER_18) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var3 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = (var0 >> 4 & 7) + class44.field596;
            var2 = (var0 & 7) + World.field1296;
         } else {
            var0 = Client.secretPacketBuffer2.method3248();
            var1 = (var0 >> 4 & 7) + class44.field596;
            var2 = (var0 & 7) + World.field1296;
            var3 = Client.secretPacketBuffer2.method3248();
         }

         var29 = var3 >> 2;
         var30 = var3 & 3;
         var31 = Client.field989[var29];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class39.method522(class46.plane, var1, var2, var31, -1, var29, var30, 0, -1);
         }

      } else {
         Item var5;
         if(Client.packetType == Opcodes.PACKET_SERVER_35) {
            if(Client.RUNELITE_PACKET) {
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
               var3 = Client.secretPacketBuffer2.runeliteReadInt();
               var1 = (var0 >> 4 & 7) + class44.field596;
               var2 = (var0 & 7) + World.field1296;
            } else {
               var0 = Client.secretPacketBuffer2.method3250();
               var1 = (var0 >> 4 & 7) + class44.field596;
               var2 = (var0 & 7) + World.field1296;
               var3 = Client.secretPacketBuffer2.method3258();
            }

            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var4 = Client.groundItemDeque[class46.plane][var1][var2];
               if(var4 != null) {
                  for(var5 = (Item)var4.getFront(); var5 != null; var5 = (Item)var4.getNext()) {
                     if((var3 & 32767) == var5.id) {
                        var5.unlink();
                        break;
                     }
                  }

                  if(var4.getFront() == null) {
                     Client.groundItemDeque[class46.plane][var1][var2] = null;
                  }

                  class87.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var9;
            int var32;
            if(Client.packetType == Opcodes.PACKET_SERVER_75) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var32 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class44.field596;
                  var2 = (var0 & 7) + World.field1296;
                  var29 = var3 >> 2;
                  var30 = var3 & 3;
                  var31 = Client.field989[var29];
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var1 = (var0 >> 4 & 7) + class44.field596;
                  var2 = (var0 & 7) + World.field1296;
                  var3 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var29 = var3 >> 2;
                  var30 = var3 & 3;
                  var31 = Client.field989[var29];
                  var32 = Client.secretPacketBuffer2.method3258();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                  if(var31 == 0) {
                     WallObject var34 = class3.region.method2730(class46.plane, var1, var2);
                     if(var34 != null) {
                        var9 = var34.hash >> 14 & 32767;
                        if(var29 == 2) {
                           var34.renderable1 = new DynamicObject(var9, 2, var30 + 4, class46.plane, var1, var2, var32, false, var34.renderable1);
                           var34.renderable2 = new DynamicObject(var9, 2, var30 + 1 & 3, class46.plane, var1, var2, var32, false, var34.renderable2);
                        } else {
                           var34.renderable1 = new DynamicObject(var9, var29, var30, class46.plane, var1, var2, var32, false, var34.renderable1);
                        }
                     }
                  }

                  if(var31 == 1) {
                     DecorativeObject var40 = class3.region.method2740(class46.plane, var1, var2);
                     if(var40 != null) {
                        var9 = var40.hash >> 14 & 32767;
                        if(var29 != 4 && var29 != 5) {
                           if(var29 == 6) {
                              var40.renderable1 = new DynamicObject(var9, 4, var30 + 4, class46.plane, var1, var2, var32, false, var40.renderable1);
                           } else if(var29 == 7) {
                              var40.renderable1 = new DynamicObject(var9, 4, (var30 + 2 & 3) + 4, class46.plane, var1, var2, var32, false, var40.renderable1);
                           } else if(var29 == 8) {
                              var40.renderable1 = new DynamicObject(var9, 4, var30 + 4, class46.plane, var1, var2, var32, false, var40.renderable1);
                              var40.renderable2 = new DynamicObject(var9, 4, (var30 + 2 & 3) + 4, class46.plane, var1, var2, var32, false, var40.renderable2);
                           }
                        } else {
                           var40.renderable1 = new DynamicObject(var9, 4, var30, class46.plane, var1, var2, var32, false, var40.renderable1);
                        }
                     }
                  }

                  if(var31 == 2) {
                     GameObject var41 = class3.region.method2741(class46.plane, var1, var2);
                     if(var29 == 11) {
                        var29 = 10;
                     }

                     if(var41 != null) {
                        var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, var29, var30, class46.plane, var1, var2, var32, false, var41.renderable);
                     }
                  }

                  if(var31 == 3) {
                     GroundObject var42 = class3.region.method2854(class46.plane, var1, var2);
                     if(var42 != null) {
                        var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, 22, var30, class46.plane, var1, var2, var32, false, var42.renderable);
                     }
                  }
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_173) {
               if(Client.RUNELITE_PACKET) {
                  var1 = Client.secretPacketBuffer2.runeliteReadInt();
                  var29 = Client.secretPacketBuffer2.runeliteReadInt();
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var2 = (var1 >> 4 & 7) + class44.field596;
                  var3 = (var1 & 7) + World.field1296;
               } else {
                  var0 = Client.secretPacketBuffer2.method3344();
                  var1 = Client.secretPacketBuffer2.method3250();
                  var2 = (var1 >> 4 & 7) + class44.field596;
                  var3 = (var1 & 7) + World.field1296;
                  var29 = Client.secretPacketBuffer2.readUnsignedShortOb1();
               }

               var30 = var29 >> 2;
               var31 = var29 & 3;
               var32 = Client.field989[var30];
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  class39.method522(class46.plane, var2, var3, var32, var0, var30, var31, 0, -1);
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_210) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var29 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class44.field596;
                  var2 = (var0 & 7) + World.field1296;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var1 = (var0 >> 4 & 7) + class44.field596;
                  var2 = (var0 & 7) + World.field1296;
                  var3 = Client.secretPacketBuffer2.method3344();
                  var29 = Client.secretPacketBuffer2.method3258();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var5 = new Item();
                  var5.id = var3;
                  var5.quantity = var29;
                  if(Client.groundItemDeque[class46.plane][var1][var2] == null) {
                     Client.groundItemDeque[class46.plane][var1][var2] = new Deque();
                  }

                  Client.groundItemDeque[class46.plane][var1][var2].addFront(var5);
                  class87.groundItemSpawned(var1, var2);
               }

            } else {
               int var8;
               if(Client.packetType == Opcodes.PACKET_SERVER_45) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var32 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                     var30 = var29 >> 4 & 15;
                     var31 = var29 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedByte();
                     var30 = var29 >> 4 & 15;
                     var31 = var29 & 7;
                     var32 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var30 + 1;
                     if(class66.localPlayer.pathX[0] >= var1 - var8 && class66.localPlayer.pathX[0] <= var8 + var1 && class66.localPlayer.pathY[0] >= var2 - var8 && class66.localPlayer.pathY[0] <= var8 + var2 && Client.field922 != 0 && var31 > 0 && Client.field1154 < 50) {
                        Client.field1098[Client.field1154] = var3;
                        Client.field1156[Client.field1154] = var31;
                        Client.field1136[Client.field1154] = var32;
                        Client.audioEffects[Client.field1154] = null;
                        Client.field1040[Client.field1154] = var30 + (var2 << 8) + (var1 << 16);
                        ++Client.field1154;
                     }
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_87) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var30 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedByte();
                     var30 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var36 = new GraphicsObject(var3, class46.plane, var1, var2, class41.getTileHeight(var1, var2, class46.plane) - var29, var30, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var36);
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_44) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var30 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedShort();
                     var30 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var6 = Client.groundItemDeque[class46.plane][var1][var2];
                     if(var6 != null) {
                        for(Item var7 = (Item)var6.getFront(); var7 != null; var7 = (Item)var6.getNext()) {
                           if((var3 & 32767) == var7.id && var29 == var7.quantity) {
                              var7.quantity = var30;
                              break;
                           }
                        }

                        class87.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == Opcodes.PACKET_SERVER_146) {
                     int var14;
                     int var33;
                     byte var35;
                     byte var37;
                     byte var38;
                     byte var39;
                     if(Client.RUNELITE_PACKET) {
                        var29 = Client.secretPacketBuffer2.runeliteReadInt();
                        var10 = Client.secretPacketBuffer2.runeliteReadInt();
                        var3 = Client.secretPacketBuffer2.runeliteReadInt();
                        var0 = Client.secretPacketBuffer2.runeliteReadInt();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var2 = Client.secretPacketBuffer2.runeliteReadInt();
                        var14 = Client.secretPacketBuffer2.runeliteReadInt();
                        var38 = Client.secretPacketBuffer2.runeliteReadByte();
                        var37 = Client.secretPacketBuffer2.runeliteReadByte();
                        var39 = Client.secretPacketBuffer2.runeliteReadByte();
                        var30 = (var29 >> 4 & 7) + class44.field596;
                        var31 = (var29 & 7) + World.field1296;
                        var11 = var10 >> 2;
                        var12 = var10 & 3;
                        var33 = Client.field989[var11];
                     } else {
                        var0 = Client.secretPacketBuffer2.method3258();
                        var35 = Client.secretPacketBuffer2.method3252();
                        var2 = Client.secretPacketBuffer2.method3259();
                        var3 = Client.secretPacketBuffer2.method3259();
                        var29 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                        var30 = (var29 >> 4 & 7) + class44.field596;
                        var31 = (var29 & 7) + World.field1296;
                        var39 = Client.secretPacketBuffer2.method3252();
                        var37 = Client.secretPacketBuffer2.method3252();
                        var38 = Client.secretPacketBuffer2.method3251();
                        var10 = Client.secretPacketBuffer2.readUnsignedByte();
                        var11 = var10 >> 2;
                        var12 = var10 & 3;
                        var33 = Client.field989[var11];
                        var14 = Client.secretPacketBuffer2.method3258();
                     }

                     Player var15;
                     if(var3 == Client.localInteractingIndex) {
                        var15 = class66.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var3];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = CollisionData.getObjectDefinition(var0);
                        int var17;
                        int var18;
                        if(var12 != 1 && var12 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var30 + (var17 >> 1);
                        int var20 = var30 + (var17 + 1 >> 1);
                        int var21 = var31 + (var18 >> 1);
                        int var22 = var31 + (var18 + 1 >> 1);
                        int[][] var23 = class61.tileHeights[class46.plane];
                        int var24 = var23[var20][var22] + var23[var19][var21] + var23[var20][var21] + var23[var19][var22] >> 2;
                        int var25 = (var30 << 7) + (var17 << 6);
                        int var26 = (var31 << 7) + (var18 << 6);
                        Model var27 = var16.method4606(var11, var12, var23, var25, var24, var26);
                        if(var27 != null) {
                           class39.method522(class46.plane, var30, var31, var33, -1, 0, 0, var14 + 1, var2 + 1);
                           var15.field895 = var14 + Client.gameCycle;
                           var15.field903 = var2 + Client.gameCycle;
                           var15.model = var27;
                           var15.field909 = var30 * 128 + var17 * 64;
                           var15.field897 = var31 * 128 + var18 * 64;
                           var15.field898 = var24;
                           byte var28;
                           if(var39 > var35) {
                              var28 = var39;
                              var39 = var35;
                              var35 = var28;
                           }

                           if(var38 > var37) {
                              var28 = var38;
                              var38 = var37;
                              var37 = var28;
                           }

                           var15.field901 = var39 + var30;
                           var15.field892 = var30 + var35;
                           var15.field902 = var38 + var31;
                           var15.field904 = var37 + var31;
                        }
                     }

                  } else if(Client.packetType == Opcodes.PACKET_SERVER_194) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class44.field596;
                     var2 = (var0 & 7) + World.field1296;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var29 = var2 + Client.secretPacketBuffer2.readByte();
                     var30 = Client.secretPacketBuffer2.readShort();
                     var31 = Client.secretPacketBuffer2.readUnsignedShort();
                     var32 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var29 >= 0 && var3 < 104 && var29 < 104 && var31 != 65535) {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var29 = var29 * 128 + 64;
                        Projectile var13 = new Projectile(var31, class46.plane, var1, var2, class41.getTileHeight(var1, var2, class46.plane) - var32, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var30, var8);
                        var13.method1777(var3, var29, class41.getTileHeight(var3, var29, class46.plane) - var8, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var13);
                     }

                  }
               }
            }
         }
      }
   }
}
