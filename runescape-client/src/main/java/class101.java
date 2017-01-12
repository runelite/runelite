import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class101 extends RuntimeException {
   @ObfuscatedName("u")
   static Applet field1639;
   @ObfuscatedName("a")
   String field1640;
   @ObfuscatedName("f")
   Throwable field1641;
   @ObfuscatedName("ra")
   protected static String field1642;
   @ObfuscatedName("cj")
   static class110 field1643;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "878641963"
   )
   static void method1909() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                  Client.menuTargets[var3] = Client.menuTargets[1 + var3];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[1 + var3];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1172273696"
   )
   static final void method1910() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var29;
      if(Client.packetOpcode == 95) {
         var0 = Client.field409.readUnsignedByte();
         var1 = class22.field234 + (var0 >> 4 & 7);
         var2 = class25.field580 + (var0 & 7);
         var3 = Client.field409.readUnsignedShort();
         var4 = Client.field409.readUnsignedByte();
         var29 = Client.field409.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var1 = 128 * var1 + 64;
            var2 = 64 + var2 * 128;
            class33 var42 = new class33(var3, class60.plane, var1, var2, class176.method3243(var1, var2, class60.plane) - var4, var29, Client.gameCycle);
            Client.field405.method2394(var42);
         }

      } else if(Client.packetOpcode == 225) {
         var0 = Client.field409.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class22.field234;
         var2 = (var0 & 7) + class25.field580;
         var3 = Client.field409.readUnsignedShort();
         var4 = Client.field409.readUnsignedShort();
         var29 = Client.field409.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var31 = Client.groundItemDeque[class60.plane][var1][var2];
            if(null != var31) {
               for(Item var7 = (Item)var31.method2391(); var7 != null; var7 = (Item)var31.method2393()) {
                  if((var3 & 32767) == var7.id && var4 == var7.quantity) {
                     var7.quantity = var29;
                     break;
                  }
               }

               class44.groundItemSpawned(var1, var2);
            }
         }

      } else {
         Item var5;
         if(Client.packetOpcode == 236) {
            var0 = Client.field409.method2802();
            var1 = (var0 >> 4 & 7) + class22.field234;
            var2 = (var0 & 7) + class25.field580;
            var3 = Client.field409.method2922();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var33 = Client.groundItemDeque[class60.plane][var1][var2];
               if(null != var33) {
                  for(var5 = (Item)var33.method2391(); var5 != null; var5 = (Item)var33.method2393()) {
                     if(var5.id == (var3 & 32767)) {
                        var5.unlink();
                        break;
                     }
                  }

                  if(var33.method2391() == null) {
                     Client.groundItemDeque[class60.plane][var1][var2] = null;
                  }

                  class44.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var6;
            int var30;
            if(Client.packetOpcode == 137) {
               var0 = Client.field409.readUnsignedByte();
               var1 = (var0 >> 4 & 7) + class22.field234;
               var2 = (var0 & 7) + class25.field580;
               var3 = Client.field409.method2779();
               var4 = Client.field409.readUnsignedByte();
               var29 = var4 >> 2;
               var6 = var4 & 3;
               var30 = Client.field346[var29];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class190.method3458(class60.plane, var1, var2, var30, var3, var29, var6, 0, -1);
               }

            } else {
               int var9;
               if(Client.packetOpcode == 181) {
                  var0 = Client.field409.method2803();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field346[var1];
                  var4 = Client.field409.readUnsignedShort();
                  var29 = Client.field409.readUnsignedByte();
                  var6 = (var29 >> 4 & 7) + class22.field234;
                  var30 = (var29 & 7) + class25.field580;
                  if(var6 >= 0 && var30 >= 0 && var6 < 103 && var30 < 103) {
                     if(var3 == 0) {
                        WallObject var8 = class6.region.method1760(class60.plane, var6, var30);
                        if(null != var8) {
                           var9 = var8.hash >> 14 & 32767;
                           if(var1 == 2) {
                              var8.renderable1 = new class49(var9, 2, 4 + var2, class60.plane, var6, var30, var4, false, var8.renderable1);
                              var8.renderable2 = new class49(var9, 2, 1 + var2 & 3, class60.plane, var6, var30, var4, false, var8.renderable2);
                           } else {
                              var8.renderable1 = new class49(var9, var1, var2, class60.plane, var6, var30, var4, false, var8.renderable1);
                           }
                        }
                     }

                     if(var3 == 1) {
                        DecorativeObject var37 = class6.region.method1758(class60.plane, var6, var30);
                        if(null != var37) {
                           var9 = var37.hash >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var37.renderable1 = new class49(var9, 4, 4 + var2, class60.plane, var6, var30, var4, false, var37.renderable1);
                              } else if(var1 == 7) {
                                 var37.renderable1 = new class49(var9, 4, (var2 + 2 & 3) + 4, class60.plane, var6, var30, var4, false, var37.renderable1);
                              } else if(var1 == 8) {
                                 var37.renderable1 = new class49(var9, 4, 4 + var2, class60.plane, var6, var30, var4, false, var37.renderable1);
                                 var37.renderable2 = new class49(var9, 4, 4 + (var2 + 2 & 3), class60.plane, var6, var30, var4, false, var37.renderable2);
                              }
                           } else {
                              var37.renderable1 = new class49(var9, 4, var2, class60.plane, var6, var30, var4, false, var37.renderable1);
                           }
                        }
                     }

                     if(var3 == 2) {
                        GameObject var38 = class6.region.method1715(class60.plane, var6, var30);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(null != var38) {
                           var38.renderable = new class49(var38.hash >> 14 & 32767, var1, var2, class60.plane, var6, var30, var4, false, var38.renderable);
                        }
                     }

                     if(var3 == 3) {
                        GroundObject var39 = class6.region.method1695(class60.plane, var6, var30);
                        if(null != var39) {
                           var39.renderable = new class49(var39.hash >> 14 & 32767, 22, var2, class60.plane, var6, var30, var4, false, var39.renderable);
                        }
                     }
                  }

               } else {
                  int var32;
                  if(Client.packetOpcode == 86) {
                     var0 = Client.field409.readUnsignedByte();
                     var1 = class22.field234 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + class25.field580;
                     var3 = Client.field409.readUnsignedShort();
                     var4 = Client.field409.readUnsignedByte();
                     var29 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var30 = Client.field409.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var32 = var29 + 1;
                        if(class148.localPlayer.pathX[0] >= var1 - var32 && class148.localPlayer.pathX[0] <= var32 + var1 && class148.localPlayer.pathY[0] >= var2 - var32 && class148.localPlayer.pathY[0] <= var2 + var32 && Client.field557 != 0 && var6 > 0 && Client.field516 < 50) {
                           Client.field500[Client.field516] = var3;
                           Client.field292[Client.field516] = var6;
                           Client.field526[Client.field516] = var30;
                           Client.field528[Client.field516] = null;
                           Client.field527[Client.field516] = var29 + (var1 << 16) + (var2 << 8);
                           ++Client.field516;
                        }
                     }
                  }

                  if(Client.packetOpcode == 51) {
                     var0 = Client.field409.method2762();
                     var1 = Client.field409.method2803();
                     var2 = (var1 >> 4 & 7) + class22.field234;
                     var3 = class25.field580 + (var1 & 7);
                     var4 = Client.field409.method2922();
                     if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                        var5 = new Item();
                        var5.id = var0;
                        var5.quantity = var4;
                        if(Client.groundItemDeque[class60.plane][var2][var3] == null) {
                           Client.groundItemDeque[class60.plane][var2][var3] = new Deque();
                        }

                        Client.groundItemDeque[class60.plane][var2][var3].method2394(var5);
                        class44.groundItemSpawned(var2, var3);
                     }

                  } else {
                     int var10;
                     if(Client.packetOpcode == 132) {
                        var0 = Client.field409.method2779();
                        var1 = Client.field409.method2803();
                        var2 = (var1 >> 4 & 7) + class22.field234;
                        var3 = class25.field580 + (var1 & 7);
                        byte var35 = Client.field409.method2814();
                        var29 = Client.field409.method2762();
                        byte var36 = Client.field409.method2966();
                        var30 = Client.field409.method2803();
                        var32 = var30 >> 2;
                        var9 = var30 & 3;
                        var10 = Client.field346[var32];
                        byte var11 = Client.field409.method2966();
                        byte var12 = Client.field409.readByte();
                        int var13 = Client.field409.readUnsignedShort();
                        int var14 = Client.field409.readUnsignedShort();
                        Player var15;
                        if(Client.localInteractingIndex == var29) {
                           var15 = class148.localPlayer;
                        } else {
                           var15 = Client.cachedPlayers[var29];
                        }

                        if(null != var15) {
                           ObjectComposition var16 = Tile.getObjectDefinition(var14);
                           int var17;
                           int var18;
                           if(var9 != 1 && var9 != 3) {
                              var17 = var16.field2895;
                              var18 = var16.field2931;
                           } else {
                              var17 = var16.field2931;
                              var18 = var16.field2895;
                           }

                           int var19 = var2 + (var17 >> 1);
                           int var20 = (var17 + 1 >> 1) + var2;
                           int var21 = (var18 >> 1) + var3;
                           int var22 = (var18 + 1 >> 1) + var3;
                           int[][] var23 = class10.tileHeights[class60.plane];
                           int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                           int var25 = (var2 << 7) + (var17 << 6);
                           int var26 = (var18 << 6) + (var3 << 7);
                           Model var27 = var16.method3593(var32, var9, var23, var25, var24, var26);
                           if(var27 != null) {
                              class190.method3458(class60.plane, var2, var3, var10, -1, 0, 0, 1 + var0, 1 + var13);
                              var15.totalLevel = Client.gameCycle + var0;
                              var15.field249 = var13 + Client.gameCycle;
                              var15.model = var27;
                              var15.field250 = 128 * var2 + 64 * var17;
                              var15.field252 = 128 * var3 + var18 * 64;
                              var15.field251 = var24;
                              byte var28;
                              if(var35 > var36) {
                                 var28 = var35;
                                 var35 = var36;
                                 var36 = var28;
                              }

                              if(var12 > var11) {
                                 var28 = var12;
                                 var12 = var11;
                                 var11 = var28;
                              }

                              var15.field254 = var35 + var2;
                              var15.field256 = var36 + var2;
                              var15.field258 = var3 + var12;
                              var15.field257 = var11 + var3;
                           }
                        }
                     }

                     if(Client.packetOpcode == 46) {
                        var0 = Client.field409.readUnsignedByte();
                        var1 = var0 >> 2;
                        var2 = var0 & 3;
                        var3 = Client.field346[var1];
                        var4 = Client.field409.method2802();
                        var29 = (var4 >> 4 & 7) + class22.field234;
                        var6 = class25.field580 + (var4 & 7);
                        if(var29 >= 0 && var6 >= 0 && var29 < 104 && var6 < 104) {
                           class190.method3458(class60.plane, var29, var6, var3, -1, var1, var2, 0, -1);
                        }

                     } else if(Client.packetOpcode == 27) {
                        var0 = Client.field409.readUnsignedByte();
                        var1 = (var0 >> 4 & 7) + class22.field234;
                        var2 = class25.field580 + (var0 & 7);
                        var3 = var1 + Client.field409.readByte();
                        var4 = var2 + Client.field409.readByte();
                        var29 = Client.field409.method2968();
                        var6 = Client.field409.readUnsignedShort();
                        var30 = Client.field409.readUnsignedByte() * 4;
                        var32 = Client.field409.readUnsignedByte() * 4;
                        var9 = Client.field409.readUnsignedShort();
                        var10 = Client.field409.readUnsignedShort();
                        int var40 = Client.field409.readUnsignedByte();
                        int var41 = Client.field409.readUnsignedByte();
                        if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                           var1 = 64 + var1 * 128;
                           var2 = var2 * 128 + 64;
                           var3 = 64 + 128 * var3;
                           var4 = 64 + 128 * var4;
                           Projectile var34 = new Projectile(var6, class60.plane, var1, var2, class176.method3243(var1, var2, class60.plane) - var30, var9 + Client.gameCycle, var10 + Client.gameCycle, var40, var41, var29, var32);
                           var34.method775(var3, var4, class176.method3243(var3, var4, class60.plane) - var32, Client.gameCycle + var9);
                           Client.projectiles.method2394(var34);
                        }

                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1687708617"
   )
   public static int method1911(int var0) {
      class194 var1 = class65.method1124(var0);
      int var2 = var1.field2833;
      int var3 = var1.field2831;
      int var4 = var1.field2835;
      int var5 = class165.field2149[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }
}
