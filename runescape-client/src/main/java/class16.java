import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class16 extends class131 {
   @ObfuscatedName("m")
   String field174;
   @ObfuscatedName("b")
   short field176;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1500081839
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 949808185
   )
   int field178 = (int)(class114.method2154() / 1000L);
   @ObfuscatedName("du")
   @Export("mapRegions")
   static int[] mapRegions;

   class16(String var1, int var2) {
      this.field174 = var1;
      this.field176 = (short)var2;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-206493659"
   )
   static final void method180() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.packetOpcode == 236) {
         var0 = Client.field332.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class97.field1633;
         var2 = (var0 & 7) + WidgetNode.field182;
         var3 = Client.field332.readUnsignedShort();
         var4 = Client.field332.readUnsignedShort();
         var5 = Client.field332.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var41 = Client.groundItemDeque[class63.plane][var1][var2];
            if(var41 != null) {
               for(Item var7 = (Item)var41.method2349(); null != var7; var7 = (Item)var41.method2351()) {
                  if(var7.id == (var3 & 32767) && var7.quantity == var4) {
                     var7.quantity = var5;
                     break;
                  }
               }

               class161.groundItemSpawned(var1, var2);
            }
         }

      } else {
         int var6;
         int var31;
         if(Client.packetOpcode == 105) {
            var0 = Client.field332.method2755();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field528[var1];
            var4 = Client.field332.method2870();
            var5 = Client.field332.method2753();
            var6 = class97.field1633 + (var5 >> 4 & 7);
            var31 = (var5 & 7) + WidgetNode.field182;
            if(var6 >= 0 && var31 >= 0 && var6 < 104 && var31 < 104) {
               class40.method736(class63.plane, var6, var31, var3, var4, var1, var2, 0, -1);
            }

         } else {
            int var32;
            if(Client.packetOpcode == 77) {
               var0 = Client.field332.readUnsignedByte();
               var1 = (var0 >> 4 & 7) + class97.field1633;
               var2 = WidgetNode.field182 + (var0 & 7);
               var3 = Client.field332.readUnsignedShort();
               var4 = Client.field332.readUnsignedByte();
               var5 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var31 = Client.field332.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var32 = 1 + var5;
                  if(class5.localPlayer.pathX[0] >= var1 - var32 && class5.localPlayer.pathX[0] <= var32 + var1 && class5.localPlayer.pathY[0] >= var2 - var32 && class5.localPlayer.pathY[0] <= var32 + var2 && Client.field525 != 0 && var6 > 0 && Client.field526 < 50) {
                     Client.field527[Client.field526] = var3;
                     Client.field351[Client.field526] = var6;
                     Client.field529[Client.field526] = var31;
                     Client.field531[Client.field526] = null;
                     Client.field349[Client.field526] = (var2 << 8) + (var1 << 16) + var5;
                     ++Client.field526;
                  }
               }
            }

            int var9;
            int var10;
            int var11;
            int var12;
            if(Client.packetOpcode == 240) {
               var0 = Client.field332.readUnsignedByte();
               var1 = class97.field1633 + (var0 >> 4 & 7);
               var2 = WidgetNode.field182 + (var0 & 7);
               var3 = var1 + Client.field332.readByte();
               var4 = var2 + Client.field332.readByte();
               var5 = Client.field332.method2729();
               var6 = Client.field332.readUnsignedShort();
               var31 = Client.field332.readUnsignedByte() * 4;
               var32 = Client.field332.readUnsignedByte() * 4;
               var9 = Client.field332.readUnsignedShort();
               var10 = Client.field332.readUnsignedShort();
               var11 = Client.field332.readUnsignedByte();
               var12 = Client.field332.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                  var1 = 64 + var1 * 128;
                  var2 = 128 * var2 + 64;
                  var3 = 128 * var3 + 64;
                  var4 = 64 + var4 * 128;
                  Projectile var33 = new Projectile(var6, class63.plane, var1, var2, ChatLineBuffer.method896(var1, var2, class63.plane) - var31, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var32);
                  var33.method766(var3, var4, ChatLineBuffer.method896(var3, var4, class63.plane) - var32, var9 + Client.gameCycle);
                  Client.projectiles.method2361(var33);
               }

            } else {
               if(Client.packetOpcode == 93) {
                  var0 = Client.field332.method2751();
                  byte var35 = Client.field332.method2757();
                  var2 = Client.field332.method2870();
                  byte var36 = Client.field332.readByte();
                  var4 = Client.field332.readUnsignedShort();
                  var5 = Client.field332.method2751();
                  byte var37 = Client.field332.readByte();
                  var31 = Client.field332.method2892();
                  var32 = var31 >> 2;
                  var9 = var31 & 3;
                  var10 = Client.field528[var32];
                  var11 = Client.field332.readUnsignedByte();
                  var12 = (var11 >> 4 & 7) + class97.field1633;
                  int var13 = WidgetNode.field182 + (var11 & 7);
                  byte var14 = Client.field332.readByte();
                  Player var15;
                  if(Client.localInteractingIndex == var0) {
                     var15 = class5.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var0];
                  }

                  if(var15 != null) {
                     ObjectComposition var16 = class143.getObjectDefinition(var4);
                     int var17;
                     int var18;
                     if(var9 != 1 && var9 != 3) {
                        var17 = var16.field2905;
                        var18 = var16.field2938;
                     } else {
                        var17 = var16.field2938;
                        var18 = var16.field2905;
                     }

                     int var19 = var12 + (var17 >> 1);
                     int var20 = var12 + (1 + var17 >> 1);
                     int var21 = var13 + (var18 >> 1);
                     int var22 = (1 + var18 >> 1) + var13;
                     int[][] var23 = class10.tileHeights[class63.plane];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
                     int var25 = (var12 << 7) + (var17 << 6);
                     int var26 = (var13 << 7) + (var18 << 6);
                     Model var27 = var16.method3526(var32, var9, var23, var25, var24, var26);
                     if(var27 != null) {
                        class40.method736(class63.plane, var12, var13, var10, -1, 0, 0, 1 + var5, 1 + var2);
                        var15.totalLevel = var5 + Client.gameCycle;
                        var15.field257 = var2 + Client.gameCycle;
                        var15.model = var27;
                        var15.field258 = var12 * 128 + 64 * var17;
                        var15.field260 = var13 * 128 + 64 * var18;
                        var15.field259 = var24;
                        byte var28;
                        if(var35 > var37) {
                           var28 = var35;
                           var35 = var37;
                           var37 = var28;
                        }

                        if(var14 > var36) {
                           var28 = var14;
                           var14 = var36;
                           var36 = var28;
                        }

                        var15.field262 = var35 + var12;
                        var15.field264 = var12 + var37;
                        var15.field247 = var13 + var14;
                        var15.field265 = var36 + var13;
                     }
                  }
               }

               Item var29;
               if(Client.packetOpcode == 96) {
                  var0 = Client.field332.readUnsignedShort();
                  var1 = Client.field332.readUnsignedByte();
                  var2 = (var1 >> 4 & 7) + class97.field1633;
                  var3 = WidgetNode.field182 + (var1 & 7);
                  if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                     Deque var34 = Client.groundItemDeque[class63.plane][var2][var3];
                     if(var34 != null) {
                        for(var29 = (Item)var34.method2349(); null != var29; var29 = (Item)var34.method2351()) {
                           if(var29.id == (var0 & 32767)) {
                              var29.unlink();
                              break;
                           }
                        }

                        if(var34.method2349() == null) {
                           Client.groundItemDeque[class63.plane][var2][var3] = null;
                        }

                        class161.groundItemSpawned(var2, var3);
                     }
                  }

               } else if(Client.packetOpcode != 228) {
                  if(Client.packetOpcode == 195) {
                     var0 = Client.field332.method2751();
                     var1 = Client.field332.method2870();
                     var2 = Client.field332.readUnsignedByte();
                     var3 = (var2 >> 4 & 7) + class97.field1633;
                     var4 = WidgetNode.field182 + (var2 & 7);
                     if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                        var29 = new Item();
                        var29.id = var0;
                        var29.quantity = var1;
                        if(Client.groundItemDeque[class63.plane][var3][var4] == null) {
                           Client.groundItemDeque[class63.plane][var3][var4] = new Deque();
                        }

                        Client.groundItemDeque[class63.plane][var3][var4].method2361(var29);
                        class161.groundItemSpawned(var3, var4);
                     }

                  } else if(Client.packetOpcode == 238) {
                     var0 = Client.field332.method2892();
                     var1 = var0 >> 2;
                     var2 = var0 & 3;
                     var3 = Client.field528[var1];
                     var4 = Client.field332.method2892();
                     var5 = class97.field1633 + (var4 >> 4 & 7);
                     var6 = WidgetNode.field182 + (var4 & 7);
                     if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                        class40.method736(class63.plane, var5, var6, var3, -1, var1, var2, 0, -1);
                     }

                  } else if(Client.packetOpcode == 209) {
                     var0 = Client.field332.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class97.field1633;
                     var2 = (var0 & 7) + WidgetNode.field182;
                     var3 = Client.field332.readUnsignedShort();
                     var4 = Client.field332.readUnsignedByte();
                     var5 = Client.field332.readUnsignedShort();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        class33 var30 = new class33(var3, class63.plane, var1, var2, ChatLineBuffer.method896(var1, var2, class63.plane) - var4, var5, Client.gameCycle);
                        Client.field511.method2361(var30);
                     }

                  }
               } else {
                  var0 = Client.field332.method2753();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field528[var1];
                  var4 = Client.field332.method2892();
                  var5 = (var4 >> 4 & 7) + class97.field1633;
                  var6 = (var4 & 7) + WidgetNode.field182;
                  var31 = Client.field332.method2770();
                  if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
                     if(var3 == 0) {
                        WallObject var8 = class159.region.method1688(class63.plane, var5, var6);
                        if(null != var8) {
                           var9 = var8.hash >> 14 & 32767;
                           if(var1 == 2) {
                              var8.renderable1 = new class49(var9, 2, var2 + 4, class63.plane, var5, var6, var31, false, var8.renderable1);
                              var8.renderable2 = new class49(var9, 2, 1 + var2 & 3, class63.plane, var5, var6, var31, false, var8.renderable2);
                           } else {
                              var8.renderable1 = new class49(var9, var1, var2, class63.plane, var5, var6, var31, false, var8.renderable1);
                           }
                        }
                     }

                     if(var3 == 1) {
                        DecorativeObject var38 = class159.region.method1689(class63.plane, var5, var6);
                        if(null != var38) {
                           var9 = var38.hash >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var38.renderable1 = new class49(var9, 4, 4 + var2, class63.plane, var5, var6, var31, false, var38.renderable1);
                              } else if(var1 == 7) {
                                 var38.renderable1 = new class49(var9, 4, 4 + (var2 + 2 & 3), class63.plane, var5, var6, var31, false, var38.renderable1);
                              } else if(var1 == 8) {
                                 var38.renderable1 = new class49(var9, 4, 4 + var2, class63.plane, var5, var6, var31, false, var38.renderable1);
                                 var38.renderable2 = new class49(var9, 4, (2 + var2 & 3) + 4, class63.plane, var5, var6, var31, false, var38.renderable2);
                              }
                           } else {
                              var38.renderable1 = new class49(var9, 4, var2, class63.plane, var5, var6, var31, false, var38.renderable1);
                           }
                        }
                     }

                     if(var3 == 2) {
                        GameObject var39 = class159.region.method1801(class63.plane, var5, var6);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(var39 != null) {
                           var39.renderable = new class49(var39.hash >> 14 & 32767, var1, var2, class63.plane, var5, var6, var31, false, var39.renderable);
                        }
                     }

                     if(var3 == 3) {
                        GroundObject var40 = class159.region.method1692(class63.plane, var5, var6);
                        if(null != var40) {
                           var40.renderable = new class49(var40.hash >> 14 & 32767, 22, var2, class63.plane, var5, var6, var31, false, var40.renderable);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-592648435"
   )
   static final void method181(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field409 == 1) && Client.friendCount < 400) {
            String var1 = class162.method3013(var0, Friend.field155);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class162.method3013(var3.name, Friend.field155);
                  if(null != var4 && var4.equals(var1)) {
                     method183(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class162.method3013(var3.previousName, Friend.field155);
                     if(null != var5 && var5.equals(var1)) {
                        method183(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class162.method3013(var6.name, Friend.field155);
                  if(var4 != null && var4.equals(var1)) {
                     method183(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class162.method3013(var6.previousName, Friend.field155);
                     if(null != var5 && var5.equals(var1)) {
                        method183(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class162.method3013(class5.localPlayer.name, Friend.field155).equals(var1)) {
                  method183(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field330.method2967(206);
                  Client.field330.method2815(class112.method2050(var0));
                  Client.field330.method2717(var0);
               }
            }
         } else {
            method183(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1323875878"
   )
   static String method182(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-20"
   )
   static void method183(int var0, String var1, String var2) {
      class119.addChatMessage(var0, var1, var2, (String)null);
   }
}
