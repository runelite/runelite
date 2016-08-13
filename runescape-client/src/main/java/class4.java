import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class4 {
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -926053843
   )
   static int field72;
   @ObfuscatedName("g")
   static final BigInteger field73 = new BigInteger("933b301ae163f99ef4c9c2e7f60f1b818dcd3bef2024fb767d39fc4c02e356c1dbb66645a53e3aefc1604d08f4c7dd6cd1e95d6fa7dbebd63e9c98dc5c21fae2202e34cd6cb0eeb9616c78e4966f9cf02292d56a7f71a66e075fc38ae6f601b0640358e0f4ff9153dd9ca8481c59812299941e5090b91e503c2836bab93ed5e5", 16);
   @ObfuscatedName("mh")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("l")
   static final BigInteger field76 = new BigInteger("10001", 16);

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static void method44() {
      int var0 = class189.field3056;
      int var1 = Actor.field892;
      if(SecondaryBufferProvider.field1450 < var0) {
         var0 = SecondaryBufferProvider.field1450;
      }

      if(class144.field2220 < var1) {
         var1 = class144.field2220;
      }

      if(null != class136.field2123) {
         try {
            class135.method2991(Client.field477, "resize", new Object[]{Integer.valueOf(class53.method1139())});
         } catch (Throwable var3) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Lclass8;",
      garbageValue = "79"
   )
   static class8 method45() {
      FileOnDisk var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class114.method2540("", Client.field298.field2346, false);
         byte[] var2 = new byte[(int)var0.method4273()];

         int var3;
         for(int var4 = 0; var4 < var2.length; var4 += var3) {
            var3 = var0.method4274(var2, var4, var2.length - var4);
            if(var3 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4283();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-178407864"
   )
   static final void method46(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field418 == 1) && Client.ignoreCount < 400) {
            String var2 = class156.method3300(var0, Client.field518);
            if(null != var2) {
               int var3;
               String var4;
               String var5;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var6 = Client.ignores[var3];
                  var4 = class156.method3300(var6.name, Client.field518);
                  if(var4 != null && var4.equals(var2)) {
                     SecondaryBufferProvider.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class156.method3300(var6.previousName, Client.field518);
                     if(var5 != null && var5.equals(var2)) {
                        SecondaryBufferProvider.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var4 = class156.method3300(var7.name, Client.field518);
                  if(null != var4 && var4.equals(var2)) {
                     SecondaryBufferProvider.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.previousName) {
                     var5 = class156.method3300(var7.previousName, Client.field518);
                     if(var5 != null && var5.equals(var2)) {
                        SecondaryBufferProvider.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class156.method3300(WidgetNode.localPlayer.name, Client.field518).equals(var2)) {
                  SecondaryBufferProvider.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field337.method2903(93);
                  Client.field337.method2783(class54.method1165(var0));
                  Client.field337.method2703(var0);
               }
            }
         } else {
            SecondaryBufferProvider.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "1733204283"
   )
   public static SpritePixels method47(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      return class32.method699(var0, var3, var4);
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Ljava/lang/String;",
      garbageValue = "-15"
   )
   static String method48(Widget var0) {
      return class215.method4089(Player.method39(var0)) == 0?null:(null != var0.field2835 && var0.field2835.trim().length() != 0?var0.field2835:null);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "-268789609"
   )
   public static boolean method49(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3411(var1, var2);
      if(null == var3) {
         return false;
      } else {
         Player.method28(var3);
         return true;
      }
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "-16101"
   )
   static void method50(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field1180; ++var4) {
         ItemComposition var5 = class1.getItemDefinition(var4);
         if((!var1 || var5.field1224) && var5.field1178 == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               SecondaryBufferProvider.field1452 = -1;
               class8.field151 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class8.field151 = var2;
      class110.field1954 = 0;
      SecondaryBufferProvider.field1452 = var3;
      String[] var8 = new String[SecondaryBufferProvider.field1452];

      for(int var9 = 0; var9 < SecondaryBufferProvider.field1452; ++var9) {
         var8[var9] = class1.getItemDefinition(var2[var9]).name;
      }

      class12.method172(var8, class8.field151);
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "2090838217"
   )
   static final void method51(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2855 || var9.type == 0 || var9.field2817 || Player.method39(var9) != 0 || Client.field397 == var9 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.field2855 || !class9.method132(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var9.relativeY + var7;
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
               var18 = var9.width + var10;
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

            if(Client.field466 == var9) {
               Client.field474 = true;
               Client.field347 = var10;
               Client.field476 = var11;
            }

            if(!var9.field2855 || var12 < var14 && var13 < var15) {
               var16 = class143.field2206;
               var17 = class143.field2209;
               if(class143.field2217 != 0) {
                  var16 = class143.field2215;
                  var17 = class143.field2216;
               }

               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               if(var9.contentType == 1337) {
                  if(!Client.field304 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field439 == 0 && !Client.field448) {
                        class107.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < Model.field1931; ++var20) {
                        var21 = Model.field1876[var20];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        int var38 = var21 >> 14 & 32767;
                        if(var21 != var19) {
                           var19 = var21;
                           if(var24 == 2 && class136.region.method2081(VertexNormal.plane, var22, var23, var21) >= 0) {
                              ObjectComposition var43 = class160.getObjectDefinition(var38);
                              if(null != var43.impostorIds) {
                                 var43 = var43.getImpostor();
                              }

                              if(null == var43) {
                                 continue;
                              }

                              if(Client.field439 == 1) {
                                 class107.addMenuEntry("Use", Client.field447 + " " + "->" + " " + class16.method205('\uffff') + var43.name, 1, var21, var22, var23);
                              } else if(Client.field448) {
                                 if((World.field675 & 4) == 4) {
                                    class107.addMenuEntry(Client.field306, Client.field452 + " " + "->" + " " + class16.method205('\uffff') + var43.name, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var50 = var43.actions;
                                 if(Client.field464) {
                                    var50 = ChatMessages.method241(var50);
                                 }

                                 if(null != var50) {
                                    for(int var55 = 4; var55 >= 0; --var55) {
                                       if(var50[var55] != null) {
                                          short var57 = 0;
                                          if(var55 == 0) {
                                             var57 = 3;
                                          }

                                          if(var55 == 1) {
                                             var57 = 4;
                                          }

                                          if(var55 == 2) {
                                             var57 = 5;
                                          }

                                          if(var55 == 3) {
                                             var57 = 6;
                                          }

                                          if(var55 == 4) {
                                             var57 = 1001;
                                          }

                                          class107.addMenuEntry(var50[var55], class16.method205('\uffff') + var43.name, var57, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class107.addMenuEntry("Examine", class16.method205('\uffff') + var43.name, 1002, var43.field952 << 14, var22, var23);
                              }
                           }

                           NPC var44;
                           Player var51;
                           int[] var56;
                           int var58;
                           if(var24 == 1) {
                              NPC var46 = Client.cachedNPCs[var38];
                              if(null == var46) {
                                 continue;
                              }

                              if(var46.composition.field913 == 1 && (var46.x & 127) == 64 && (var46.y & 127) == 64) {
                                 for(var25 = 0; var25 < Client.field486; ++var25) {
                                    var44 = Client.cachedNPCs[Client.field334[var25]];
                                    if(var44 != null && var46 != var44 && var44.composition.field913 == 1 && var46.x == var44.x && var44.y == var46.y) {
                                       class93.method2163(var44.composition, Client.field334[var25], var22, var23);
                                    }
                                 }

                                 var25 = class34.field783;
                                 var56 = class34.field784;

                                 for(var58 = 0; var58 < var25; ++var58) {
                                    var51 = Client.cachedPlayers[var56[var58]];
                                    if(var51 != null && var51.x == var46.x && var51.y == var46.y) {
                                       GameObject.generateMenuActionsForPlayer(var51, var56[var58], var22, var23);
                                    }
                                 }
                              }

                              class93.method2163(var46.composition, var38, var22, var23);
                           }

                           if(var24 == 0) {
                              Player var47 = Client.cachedPlayers[var38];
                              if(var47 == null) {
                                 continue;
                              }

                              if((var47.x & 127) == 64 && (var47.y & 127) == 64) {
                                 for(var25 = 0; var25 < Client.field486; ++var25) {
                                    var44 = Client.cachedNPCs[Client.field334[var25]];
                                    if(var44 != null && var44.composition.field913 == 1 && var44.x == var47.x && var47.y == var44.y) {
                                       class93.method2163(var44.composition, Client.field334[var25], var22, var23);
                                    }
                                 }

                                 var25 = class34.field783;
                                 var56 = class34.field784;

                                 for(var58 = 0; var58 < var25; ++var58) {
                                    var51 = Client.cachedPlayers[var56[var58]];
                                    if(var51 != null && var47 != var51 && var51.x == var47.x && var51.y == var47.y) {
                                       GameObject.generateMenuActionsForPlayer(var51, var56[var58], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field425 != var38) {
                                 GameObject.generateMenuActionsForPlayer(var47, var38, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              Deque var49 = Client.groundItemDeque[VertexNormal.plane][var22][var23];
                              if(var49 != null) {
                                 for(Item var48 = (Item)var49.method3969(); var48 != null; var48 = (Item)var49.method3971()) {
                                    ItemComposition var33 = class1.getItemDefinition(var48.id);
                                    if(Client.field439 == 1) {
                                       class107.addMenuEntry("Use", Client.field447 + " " + "->" + " " + class16.method205(16748608) + var33.name, 16, var48.id, var22, var23);
                                    } else if(Client.field448) {
                                       if((World.field675 & 1) == 1) {
                                          class107.addMenuEntry(Client.field306, Client.field452 + " " + "->" + " " + class16.method205(16748608) + var33.name, 17, var48.id, var22, var23);
                                       }
                                    } else {
                                       String[] var34 = var33.groundActions;
                                       if(Client.field464) {
                                          var34 = ChatMessages.method241(var34);
                                       }

                                       for(int var35 = 4; var35 >= 0; --var35) {
                                          if(null != var34 && null != var34[var35]) {
                                             byte var36 = 0;
                                             if(var35 == 0) {
                                                var36 = 18;
                                             }

                                             if(var35 == 1) {
                                                var36 = 19;
                                             }

                                             if(var35 == 2) {
                                                var36 = 20;
                                             }

                                             if(var35 == 3) {
                                                var36 = 21;
                                             }

                                             if(var35 == 4) {
                                                var36 = 22;
                                             }

                                             class107.addMenuEntry(var34[var35], class16.method205(16748608) + var33.name, var36, var48.id, var22, var23);
                                          } else if(var35 == 2) {
                                             class107.addMenuEntry("Take", class16.method205(16748608) + var33.name, 20, var48.id, var22, var23);
                                          }
                                       }

                                       class107.addMenuEntry("Examine", class16.method205(16748608) + var33.name, 1004, var48.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var20 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        Player var40 = Client.cachedPlayers[Client.field425];
                        GameObject.generateMenuActionsForPlayer(var40, Client.field425, var20, var21);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  class128.method2955(var9, var10, var11);
               } else {
                  boolean var26;
                  boolean var41;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2810 == 1) {
                        class107.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var27;
                     if(var9.field2810 == 2 && !Client.field448) {
                        var27 = method48(var9);
                        if(null != var27) {
                           class107.addMenuEntry(var27, class16.method205('\uff00') + var9.field2809, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2810 == 3) {
                        class107.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2810 == 4) {
                        class107.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2810 == 5) {
                        class107.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2810 == 6 && Client.field376 == null) {
                        class107.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var21 = 0; var21 < var9.height; ++var21) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = var22 * (var9.field2873 + 32);
                              var24 = (32 + var9.field2874) * var21;
                              if(var20 < 20) {
                                 var23 += var9.field2875[var20];
                                 var24 += var9.field2876[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < var24 + 32) {
                                 Client.field484 = var20;
                                 class132.field2104 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var28 = class1.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field439 == 1 && class126.method2929(Player.method39(var9))) {
                                       if(DecorativeObject.field1688 != var9.id || class23.field618 != var20) {
                                          class107.addMenuEntry("Use", Client.field447 + " " + "->" + " " + class16.method205(16748608) + var28.name, 31, var28.id, var20, var9.id);
                                       }
                                    } else if(Client.field448 && class126.method2929(Player.method39(var9))) {
                                       if((World.field675 & 16) == 16) {
                                          class107.addMenuEntry(Client.field306, Client.field452 + " " + "->" + " " + class16.method205(16748608) + var28.name, 32, var28.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var29 = var28.inventoryActions;
                                       if(Client.field464) {
                                          var29 = ChatMessages.method241(var29);
                                       }

                                       byte var30;
                                       if(class126.method2929(Player.method39(var9))) {
                                          for(var25 = 4; var25 >= 3; --var25) {
                                             if(var29 != null && var29[var25] != null) {
                                                if(var25 == 3) {
                                                   var30 = 36;
                                                } else {
                                                   var30 = 37;
                                                }

                                                class107.addMenuEntry(var29[var25], class16.method205(16748608) + var28.name, var30, var28.id, var20, var9.id);
                                             } else if(var25 == 4) {
                                                class107.addMenuEntry("Drop", class16.method205(16748608) + var28.name, 37, var28.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       if(class51.method1117(Player.method39(var9))) {
                                          class107.addMenuEntry("Use", class16.method205(16748608) + var28.name, 38, var28.id, var20, var9.id);
                                       }

                                       if(class126.method2929(Player.method39(var9)) && null != var29) {
                                          for(var25 = 2; var25 >= 0; --var25) {
                                             if(var29[var25] != null) {
                                                var30 = 0;
                                                if(var25 == 0) {
                                                   var30 = 33;
                                                }

                                                if(var25 == 1) {
                                                   var30 = 34;
                                                }

                                                if(var25 == 2) {
                                                   var30 = 35;
                                                }

                                                class107.addMenuEntry(var29[var25], class16.method205(16748608) + var28.name, var30, var28.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var29 = var9.field2878;
                                       if(Client.field464) {
                                          var29 = ChatMessages.method241(var29);
                                       }

                                       if(var29 != null) {
                                          for(var25 = 4; var25 >= 0; --var25) {
                                             if(null != var29[var25]) {
                                                var30 = 0;
                                                if(var25 == 0) {
                                                   var30 = 39;
                                                }

                                                if(var25 == 1) {
                                                   var30 = 40;
                                                }

                                                if(var25 == 2) {
                                                   var30 = 41;
                                                }

                                                if(var25 == 3) {
                                                   var30 = 42;
                                                }

                                                if(var25 == 4) {
                                                   var30 = 43;
                                                }

                                                class107.addMenuEntry(var29[var25], class16.method205(16748608) + var28.name, var30, var28.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class107.addMenuEntry("Examine", class16.method205(16748608) + var28.name, 1005, var28.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.field2855) {
                        if(Client.field448) {
                           var21 = Player.method39(var9);
                           var26 = (var21 >> 21 & 1) != 0;
                           if(var26 && (World.field675 & 32) == 32) {
                              class107.addMenuEntry(Client.field306, Client.field452 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           String var45;
                           for(var20 = 9; var20 >= 5; --var20) {
                              var23 = Player.method39(var9);
                              var41 = (var23 >> 1 + var20 & 1) != 0;
                              if(!var41 && var9.field2907 == null) {
                                 var45 = null;
                              } else if(null != var9.actions && var9.actions.length > var20 && null != var9.actions[var20] && var9.actions[var20].trim().length() != 0) {
                                 var45 = var9.actions[var20];
                              } else {
                                 var45 = null;
                              }

                              if(var45 != null) {
                                 class107.addMenuEntry(var45, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           var27 = method48(var9);
                           if(null != var27) {
                              class107.addMenuEntry(var27, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              var24 = Player.method39(var9);
                              var41 = (var24 >> 1 + var21 & 1) != 0;
                              if(!var41 && null == var9.field2907) {
                                 var45 = null;
                              } else if(null != var9.actions && var9.actions.length > var21 && null != var9.actions[var21] && var9.actions[var21].trim().length() != 0) {
                                 var45 = var9.actions[var21];
                              } else {
                                 var45 = null;
                              }

                              if(null != var45) {
                                 class107.addMenuEntry(var45, var9.name, 57, var21 + 1, var9.index, var9.id);
                              }
                           }

                           if(class128.method2956(Player.method39(var9))) {
                              class107.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.field2855 && class9.method132(var9) && var9 != class11.field177) {
                        continue;
                     }

                     method51(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(null != var9.children) {
                        method51(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var37 = (WidgetNode)Client.componentTable.method3936((long)var9.id);
                     if(null != var37) {
                        if(var37.field60 == 0 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15 && !Client.isMenuOpen && !Client.field471) {
                           for(class0 var42 = (class0)Client.field353.method3980(); null != var42; var42 = (class0)Client.field353.method3970()) {
                              if(var42.field1) {
                                 var42.unlink();
                                 var42.field2.field2932 = false;
                              }
                           }

                           if(class188.field3055 == 0) {
                              Client.field466 = null;
                              Client.field397 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var37.id;
                        if(class14.method179(var19)) {
                           method51(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2855) {
                     class0 var39;
                     if(!var9.field2940) {
                        if(var9.field2913 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                           for(var39 = (class0)Client.field353.method3980(); null != var39; var39 = (class0)Client.field353.method3970()) {
                              if(var39.field1 && var39.field2.field2838 == var39.field8) {
                                 var39.unlink();
                              }
                           }
                        }
                     } else if(class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        for(var39 = (class0)Client.field353.method3980(); null != var39; var39 = (class0)Client.field353.method3970()) {
                           if(var39.field1) {
                              var39.unlink();
                              var39.field2.field2932 = false;
                           }
                        }

                        if(class188.field3055 == 0) {
                           Client.field466 = null;
                           Client.field397 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        var41 = true;
                     } else {
                        var41 = false;
                     }

                     boolean var52 = false;
                     if((class143.field2207 == 1 || !class214.field3188 && class143.field2207 == 4) && var41) {
                        var52 = true;
                     }

                     var26 = false;
                     if((class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) && class143.field2215 >= var12 && class143.field2216 >= var13 && class143.field2215 < var14 && class143.field2216 < var15) {
                        var26 = true;
                     }

                     if(var26) {
                        class13.method175(var9, class143.field2215 - var10, class143.field2216 - var11);
                     }

                     if(Client.field466 != null && var9 != Client.field466 && var41) {
                        var22 = Player.method39(var9);
                        boolean var53 = (var22 >> 20 & 1) != 0;
                        if(var53) {
                           Client.field470 = var9;
                        }
                     }

                     if(var9 == Client.field397) {
                        Client.field346 = true;
                        Client.field543 = var10;
                        Client.field295 = var11;
                     }

                     if(var9.field2817) {
                        class0 var54;
                        if(var41 && Client.field491 != 0 && null != var9.field2838) {
                           var54 = new class0();
                           var54.field1 = true;
                           var54.field2 = var9;
                           var54.field4 = Client.field491;
                           var54.field8 = var9.field2838;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field466 != null || class23.field614 != null || Client.isMenuOpen) {
                           var26 = false;
                           var52 = false;
                           var41 = false;
                        }

                        if(!var9.field2887 && var26) {
                           var9.field2887 = true;
                           if(null != var9.field2889) {
                              var54 = new class0();
                              var54.field1 = true;
                              var54.field2 = var9;
                              var54.field5 = class143.field2215 - var10;
                              var54.field4 = class143.field2216 - var11;
                              var54.field8 = var9.field2889;
                              Client.field353.method3963(var54);
                           }
                        }

                        if(var9.field2887 && var52 && var9.field2890 != null) {
                           var54 = new class0();
                           var54.field1 = true;
                           var54.field2 = var9;
                           var54.field5 = class143.field2206 - var10;
                           var54.field4 = class143.field2209 - var11;
                           var54.field8 = var9.field2890;
                           Client.field353.method3963(var54);
                        }

                        if(var9.field2887 && !var52) {
                           var9.field2887 = false;
                           if(null != var9.field2891) {
                              var54 = new class0();
                              var54.field1 = true;
                              var54.field2 = var9;
                              var54.field5 = class143.field2206 - var10;
                              var54.field4 = class143.field2209 - var11;
                              var54.field8 = var9.field2891;
                              Client.field494.method3963(var54);
                           }
                        }

                        if(var52 && null != var9.field2828) {
                           var54 = new class0();
                           var54.field1 = true;
                           var54.field2 = var9;
                           var54.field5 = class143.field2206 - var10;
                           var54.field4 = class143.field2209 - var11;
                           var54.field8 = var9.field2828;
                           Client.field353.method3963(var54);
                        }

                        if(!var9.field2932 && var41) {
                           var9.field2932 = true;
                           if(var9.field2893 != null) {
                              var54 = new class0();
                              var54.field1 = true;
                              var54.field2 = var9;
                              var54.field5 = class143.field2206 - var10;
                              var54.field4 = class143.field2209 - var11;
                              var54.field8 = var9.field2893;
                              Client.field353.method3963(var54);
                           }
                        }

                        if(var9.field2932 && var41 && null != var9.field2894) {
                           var54 = new class0();
                           var54.field1 = true;
                           var54.field2 = var9;
                           var54.field5 = class143.field2206 - var10;
                           var54.field4 = class143.field2209 - var11;
                           var54.field8 = var9.field2894;
                           Client.field353.method3963(var54);
                        }

                        if(var9.field2932 && !var41) {
                           var9.field2932 = false;
                           if(var9.field2895 != null) {
                              var54 = new class0();
                              var54.field1 = true;
                              var54.field2 = var9;
                              var54.field5 = class143.field2206 - var10;
                              var54.field4 = class143.field2209 - var11;
                              var54.field8 = var9.field2895;
                              Client.field494.method3963(var54);
                           }
                        }

                        if(var9.field2881 != null) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2881;
                           Client.field335.method3963(var54);
                        }

                        class0 var31;
                        if(var9.field2833 != null && Client.field366 > var9.field2935) {
                           if(var9.field2901 != null && Client.field366 - var9.field2935 <= 32) {
                              label931:
                              for(var21 = var9.field2935; var21 < Client.field366; ++var21) {
                                 var22 = Client.field479[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2901.length; ++var23) {
                                    if(var22 == var9.field2901[var23]) {
                                       var31 = new class0();
                                       var31.field2 = var9;
                                       var31.field8 = var9.field2833;
                                       Client.field353.method3963(var31);
                                       break label931;
                                    }
                                 }
                              }
                           } else {
                              var54 = new class0();
                              var54.field2 = var9;
                              var54.field8 = var9.field2833;
                              Client.field353.method3963(var54);
                           }

                           var9.field2935 = Client.field366;
                        }

                        if(null != var9.field2906 && Client.field482 > var9.field2936) {
                           if(null != var9.field2805 && Client.field482 - var9.field2936 <= 32) {
                              label907:
                              for(var21 = var9.field2936; var21 < Client.field482; ++var21) {
                                 var22 = Client.field481[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2805.length; ++var23) {
                                    if(var9.field2805[var23] == var22) {
                                       var31 = new class0();
                                       var31.field2 = var9;
                                       var31.field8 = var9.field2906;
                                       Client.field353.method3963(var31);
                                       break label907;
                                    }
                                 }
                              }
                           } else {
                              var54 = new class0();
                              var54.field2 = var9;
                              var54.field8 = var9.field2906;
                              Client.field353.method3963(var54);
                           }

                           var9.field2936 = Client.field482;
                        }

                        if(null != var9.field2904 && Client.field328 > var9.field2937) {
                           if(var9.field2871 != null && Client.field328 - var9.field2937 <= 32) {
                              label883:
                              for(var21 = var9.field2937; var21 < Client.field328; ++var21) {
                                 var22 = Client.field483[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2871.length; ++var23) {
                                    if(var22 == var9.field2871[var23]) {
                                       var31 = new class0();
                                       var31.field2 = var9;
                                       var31.field8 = var9.field2904;
                                       Client.field353.method3963(var31);
                                       break label883;
                                    }
                                 }
                              }
                           } else {
                              var54 = new class0();
                              var54.field2 = var9;
                              var54.field8 = var9.field2904;
                              Client.field353.method3963(var54);
                           }

                           var9.field2937 = Client.field328;
                        }

                        if(Client.field485 > var9.field2934 && null != var9.field2870) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2870;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field385 > var9.field2934 && var9.field2911 != null) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2911;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field487 > var9.field2934 && var9.field2912 != null) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2912;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field488 > var9.field2934 && null != var9.field2900) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2900;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field416 > var9.field2934 && var9.field2918 != null) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2918;
                           Client.field353.method3963(var54);
                        }

                        if(Client.field490 > var9.field2934 && null != var9.field2903) {
                           var54 = new class0();
                           var54.field2 = var9;
                           var54.field8 = var9.field2903;
                           Client.field353.method3963(var54);
                        }

                        var9.field2934 = Client.field478;
                        if(var9.field2858 != null) {
                           for(var21 = 0; var21 < Client.field318; ++var21) {
                              class0 var32 = new class0();
                              var32.field2 = var9;
                              var32.field3 = Client.field512[var21];
                              var32.field9 = Client.field473[var21];
                              var32.field8 = var9.field2858;
                              Client.field353.method3963(var32);
                           }
                        }
                     }
                  }

                  if(!var9.field2855 && null == Client.field466 && class23.field614 == null && !Client.isMenuOpen) {
                     if((var9.field2896 >= 0 || var9.field2834 != 0) && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        if(var9.field2896 >= 0) {
                           class11.field177 = var0[var9.field2896];
                        } else {
                           class11.field177 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        ChatMessages.field278 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        NPC.method778(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class143.field2206, class143.field2209);
                     }
                  }
               }
            }
         }
      }

   }
}
