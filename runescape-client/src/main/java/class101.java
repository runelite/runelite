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
         int var1 = Client.menuTypes[var0];
         boolean var2 = var1 == 57 || var1 == 58 || var1 == 1007 || var1 == 25 || var1 == 30;
         if(var2) {
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
      int var5;
      if(Client.packetOpcode == 95) {
         var0 = Client.field409.readUnsignedByte();
         var1 = class22.field234 + (var0 >> 4 & 7);
         var2 = class25.field580 + (var0 & 7);
         var3 = Client.field409.readUnsignedShort();
         var4 = Client.field409.readUnsignedByte();
         var5 = Client.field409.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var1 = 128 * var1 + 64;
            var2 = 64 + var2 * 128;
            class33 var6 = new class33(var3, class60.plane, var1, var2, class176.method3243(var1, var2, class60.plane) - var4, var5, Client.gameCycle);
            Client.field405.method2394(var6);
         }
      } else if(Client.packetOpcode == 225) {
         var0 = Client.field409.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class22.field234;
         var2 = (var0 & 7) + class25.field580;
         var3 = Client.field409.readUnsignedShort();
         var4 = Client.field409.readUnsignedShort();
         var5 = Client.field409.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var32 = Client.groundItemDeque[class60.plane][var1][var2];
            if(null != var32) {
               for(Item var7 = (Item)var32.method2391(); var7 != null; var7 = (Item)var32.method2393()) {
                  if((var3 & 32767) == var7.id && var4 == var7.quantity) {
                     var7.quantity = var5;
                     break;
                  }
               }

               class44.groundItemSpawned(var1, var2);
            }
         }
      } else {
         Item var33;
         if(Client.packetOpcode == 236) {
            var0 = Client.field409.method2802();
            var1 = (var0 >> 4 & 7) + class22.field234;
            var2 = (var0 & 7) + class25.field580;
            var3 = Client.field409.method2922();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var34 = Client.groundItemDeque[class60.plane][var1][var2];
               if(null != var34) {
                  for(var33 = (Item)var34.method2391(); var33 != null; var33 = (Item)var34.method2393()) {
                     if(var33.id == (var3 & 32767)) {
                        var33.unlink();
                        break;
                     }
                  }

                  if(var34.method2391() == null) {
                     Client.groundItemDeque[class60.plane][var1][var2] = null;
                  }

                  class44.groundItemSpawned(var1, var2);
               }
            }
         } else {
            int var8;
            int var35;
            if(Client.packetOpcode == 137) {
               var0 = Client.field409.readUnsignedByte();
               var1 = (var0 >> 4 & 7) + class22.field234;
               var2 = (var0 & 7) + class25.field580;
               var3 = Client.field409.method2779();
               var4 = Client.field409.readUnsignedByte();
               var5 = var4 >> 2;
               var35 = var4 & 3;
               var8 = Client.field346[var5];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class190.method3458(class60.plane, var1, var2, var8, var3, var5, var35, 0, -1);
               }
            } else {
               int var9;
               if(Client.packetOpcode == 181) {
                  var0 = Client.field409.method2803();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field346[var1];
                  var4 = Client.field409.readUnsignedShort();
                  var5 = Client.field409.readUnsignedByte();
                  var35 = (var5 >> 4 & 7) + class22.field234;
                  var8 = (var5 & 7) + class25.field580;
                  if(var35 >= 0 && var8 >= 0 && var35 < 103 && var8 < 103) {
                     if(var3 == 0) {
                        WallObject var10 = class6.region.method1760(class60.plane, var35, var8);
                        if(null != var10) {
                           var9 = var10.hash >> 14 & 32767;
                           if(var1 == 2) {
                              var10.renderable1 = new class49(var9, 2, 4 + var2, class60.plane, var35, var8, var4, false, var10.renderable1);
                              var10.renderable2 = new class49(var9, 2, 1 + var2 & 3, class60.plane, var35, var8, var4, false, var10.renderable2);
                           } else {
                              var10.renderable1 = new class49(var9, var1, var2, class60.plane, var35, var8, var4, false, var10.renderable1);
                           }
                        }
                     }

                     if(var3 == 1) {
                        DecorativeObject var36 = class6.region.method1758(class60.plane, var35, var8);
                        if(null != var36) {
                           var9 = var36.hash >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var36.renderable1 = new class49(var9, 4, 4 + var2, class60.plane, var35, var8, var4, false, var36.renderable1);
                              } else if(var1 == 7) {
                                 var36.renderable1 = new class49(var9, 4, (var2 + 2 & 3) + 4, class60.plane, var35, var8, var4, false, var36.renderable1);
                              } else if(var1 == 8) {
                                 var36.renderable1 = new class49(var9, 4, 4 + var2, class60.plane, var35, var8, var4, false, var36.renderable1);
                                 var36.renderable2 = new class49(var9, 4, 4 + (var2 + 2 & 3), class60.plane, var35, var8, var4, false, var36.renderable2);
                              }
                           } else {
                              var36.renderable1 = new class49(var9, 4, var2, class60.plane, var35, var8, var4, false, var36.renderable1);
                           }
                        }
                     }

                     if(var3 == 2) {
                        GameObject var37 = class6.region.method1715(class60.plane, var35, var8);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(null != var37) {
                           var37.renderable = new class49(var37.hash >> 14 & 32767, var1, var2, class60.plane, var35, var8, var4, false, var37.renderable);
                        }
                     }

                     if(var3 == 3) {
                        GroundObject var38 = class6.region.method1695(class60.plane, var35, var8);
                        if(null != var38) {
                           var38.renderable = new class49(var38.hash >> 14 & 32767, 22, var2, class60.plane, var35, var8, var4, false, var38.renderable);
                        }
                     }
                  }
               } else {
                  int var39;
                  if(Client.packetOpcode == 86) {
                     var0 = Client.field409.readUnsignedByte();
                     var1 = class22.field234 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + class25.field580;
                     var3 = Client.field409.readUnsignedShort();
                     var4 = Client.field409.readUnsignedByte();
                     var5 = var4 >> 4 & 15;
                     var35 = var4 & 7;
                     var8 = Client.field409.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var39 = var5 + 1;
                        if(class148.localPlayer.pathX[0] >= var1 - var39 && class148.localPlayer.pathX[0] <= var39 + var1 && class148.localPlayer.pathY[0] >= var2 - var39 && class148.localPlayer.pathY[0] <= var2 + var39 && Client.field557 != 0 && var35 > 0 && Client.field516 < 50) {
                           Client.field500[Client.field516] = var3;
                           Client.field292[Client.field516] = var35;
                           Client.field526[Client.field516] = var8;
                           Client.field528[Client.field516] = null;
                           Client.field527[Client.field516] = var5 + (var1 << 16) + (var2 << 8);
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
                        var33 = new Item();
                        var33.id = var0;
                        var33.quantity = var4;
                        if(Client.groundItemDeque[class60.plane][var2][var3] == null) {
                           Client.groundItemDeque[class60.plane][var2][var3] = new Deque();
                        }

                        Client.groundItemDeque[class60.plane][var2][var3].method2394(var33);
                        class44.groundItemSpawned(var2, var3);
                     }
                  } else {
                     int var11;
                     if(Client.packetOpcode == 132) {
                        var0 = Client.field409.method2779();
                        var1 = Client.field409.method2803();
                        var2 = (var1 >> 4 & 7) + class22.field234;
                        var3 = class25.field580 + (var1 & 7);
                        byte var12 = Client.field409.method2814();
                        var5 = Client.field409.method2762();
                        byte var13 = Client.field409.method2966();
                        var8 = Client.field409.method2803();
                        var39 = var8 >> 2;
                        var9 = var8 & 3;
                        var11 = Client.field346[var39];
                        byte var14 = Client.field409.method2966();
                        byte var15 = Client.field409.readByte();
                        int var16 = Client.field409.readUnsignedShort();
                        int var17 = Client.field409.readUnsignedShort();
                        Player var18;
                        if(Client.localInteractingIndex == var5) {
                           var18 = class148.localPlayer;
                        } else {
                           var18 = Client.cachedPlayers[var5];
                        }

                        if(null != var18) {
                           ObjectComposition var19 = Tile.getObjectDefinition(var17);
                           int var20;
                           int var21;
                           if(var9 != 1 && var9 != 3) {
                              var20 = var19.field2895;
                              var21 = var19.field2931;
                           } else {
                              var20 = var19.field2931;
                              var21 = var19.field2895;
                           }

                           int var22 = var2 + (var20 >> 1);
                           int var23 = (var20 + 1 >> 1) + var2;
                           int var24 = (var21 >> 1) + var3;
                           int var25 = (var21 + 1 >> 1) + var3;
                           int[][] var26 = class10.tileHeights[class60.plane];
                           int var27 = var26[var23][var24] + var26[var22][var24] + var26[var22][var25] + var26[var23][var25] >> 2;
                           int var28 = (var2 << 7) + (var20 << 6);
                           int var29 = (var21 << 6) + (var3 << 7);
                           Model var30 = var19.method3593(var39, var9, var26, var28, var27, var29);
                           if(var30 != null) {
                              class190.method3458(class60.plane, var2, var3, var11, -1, 0, 0, 1 + var0, 1 + var16);
                              var18.totalLevel = Client.gameCycle + var0;
                              var18.field249 = var16 + Client.gameCycle;
                              var18.model = var30;
                              var18.field250 = 128 * var2 + 64 * var20;
                              var18.field252 = 128 * var3 + var21 * 64;
                              var18.field251 = var27;
                              byte var31;
                              if(var12 > var13) {
                                 var31 = var12;
                                 var12 = var13;
                                 var13 = var31;
                              }

                              if(var15 > var14) {
                                 var31 = var15;
                                 var15 = var14;
                                 var14 = var31;
                              }

                              var18.field254 = var12 + var2;
                              var18.field256 = var13 + var2;
                              var18.field258 = var3 + var15;
                              var18.field257 = var14 + var3;
                           }
                        }
                     }

                     if(Client.packetOpcode == 46) {
                        var0 = Client.field409.readUnsignedByte();
                        var1 = var0 >> 2;
                        var2 = var0 & 3;
                        var3 = Client.field346[var1];
                        var4 = Client.field409.method2802();
                        var5 = (var4 >> 4 & 7) + class22.field234;
                        var35 = class25.field580 + (var4 & 7);
                        if(var5 >= 0 && var35 >= 0 && var5 < 104 && var35 < 104) {
                           class190.method3458(class60.plane, var5, var35, var3, -1, var1, var2, 0, -1);
                        }
                     } else if(Client.packetOpcode == 27) {
                        var0 = Client.field409.readUnsignedByte();
                        var1 = (var0 >> 4 & 7) + class22.field234;
                        var2 = class25.field580 + (var0 & 7);
                        var3 = var1 + Client.field409.readByte();
                        var4 = var2 + Client.field409.readByte();
                        var5 = Client.field409.method2968();
                        var35 = Client.field409.readUnsignedShort();
                        var8 = Client.field409.readUnsignedByte() * 4;
                        var39 = Client.field409.readUnsignedByte() * 4;
                        var9 = Client.field409.readUnsignedShort();
                        var11 = Client.field409.readUnsignedShort();
                        int var40 = Client.field409.readUnsignedByte();
                        int var41 = Client.field409.readUnsignedByte();
                        if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var35 != '\uffff') {
                           var1 = 64 + var1 * 128;
                           var2 = var2 * 128 + 64;
                           var3 = 64 + 128 * var3;
                           var4 = 64 + 128 * var4;
                           Projectile var42 = new Projectile(var35, class60.plane, var1, var2, class176.method3243(var1, var2, class60.plane) - var8, var9 + Client.gameCycle, var11 + Client.gameCycle, var40, var41, var5, var39);
                           var42.method775(var3, var4, class176.method3243(var3, var4, class60.plane) - var39, Client.gameCycle + var9);
                           Client.projectiles.method2394(var42);
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
