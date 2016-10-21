import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("World")
public class World {
   @ObfuscatedName("bm")
   @Export("host")
   static String host;
   @ObfuscatedName("v")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1193228183
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -983803907
   )
   static int field651 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 319774897
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("c")
   static int[] field654 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -126916651
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 354348207
   )
   @Export("index")
   int index;
   @ObfuscatedName("u")
   @Export("address")
   String address;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1230208285
   )
   static int field659 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2012239157
   )
   @Export("location")
   int location;
   @ObfuscatedName("k")
   static int[] field663 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("ra")
   protected static boolean field665;
   @ObfuscatedName("x")
   @Export("activity")
   String activity;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;B)V",
      garbageValue = "35"
   )
   static void method616(class227 var0, class227 var1) {
      if(null == class18.field259) {
         class18.field259 = class158.method3189(Item.field690, "sl_back", "");
      }

      if(class47.field1045 == null) {
         class47.field1045 = class51.method1062(Item.field690, "sl_flags", "");
      }

      if(class33.field756 == null) {
         class33.field756 = class51.method1062(Item.field690, "sl_arrows", "");
      }

      if(class14.field213 == null) {
         class14.field213 = class51.method1062(Item.field690, "sl_stars", "");
      }

      class82.method1861(class33.field720, 23, 765, 480, 0);
      class82.method1851(class33.field720, 0, 125, 23, 12425273, 9135624);
      class82.method1851(class33.field720 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4099("Select a world", class33.field720 + 62, 15, 0, -1);
      if(class14.field213 != null) {
         class14.field213[1].method1913(140 + class33.field720, 1);
         var1.method4096("Members only world", 152 + class33.field720, 10, 16777215, -1);
         class14.field213[0].method1913(140 + class33.field720, 12);
         var1.method4096("Free world", 152 + class33.field720, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class33.field756) {
         int var2 = 280 + class33.field720;
         if(field654[0] == 0 && field663[0] == 0) {
            class33.field756[2].method1913(var2, 4);
         } else {
            class33.field756[0].method1913(var2, 4);
         }

         if(field654[0] == 0 && field663[0] == 1) {
            class33.field756[3].method1913(var2 + 15, 4);
         } else {
            class33.field756[1].method1913(15 + var2, 4);
         }

         var0.method4096("World", 32 + var2, 17, 16777215, -1);
         int var3 = class33.field720 + 390;
         if(field654[0] == 1 && field663[0] == 0) {
            class33.field756[2].method1913(var3, 4);
         } else {
            class33.field756[0].method1913(var3, 4);
         }

         if(field654[0] == 1 && field663[0] == 1) {
            class33.field756[3].method1913(var3 + 15, 4);
         } else {
            class33.field756[1].method1913(var3 + 15, 4);
         }

         var0.method4096("Players", var3 + 32, 17, 16777215, -1);
         var4 = 500 + class33.field720;
         if(field654[0] == 2 && field663[0] == 0) {
            class33.field756[2].method1913(var4, 4);
         } else {
            class33.field756[0].method1913(var4, 4);
         }

         if(field654[0] == 2 && field663[0] == 1) {
            class33.field756[3].method1913(15 + var4, 4);
         } else {
            class33.field756[1].method1913(15 + var4, 4);
         }

         var0.method4096("Location", var4 + 32, 17, 16777215, -1);
         var5 = class33.field720 + 610;
         if(field654[0] == 3 && field663[0] == 0) {
            class33.field756[2].method1913(var5, 4);
         } else {
            class33.field756[0].method1913(var5, 4);
         }

         if(field654[0] == 3 && field663[0] == 1) {
            class33.field756[3].method1913(var5 + 15, 4);
         } else {
            class33.field756[1].method1913(15 + var5, 4);
         }

         var0.method4096("Type", var5 + 32, 17, 16777215, -1);
      }

      class82.method1861(class33.field720 + 708, 4, 50, 16, 0);
      var1.method4099("Cancel", 708 + class33.field720 + 25, 16, 16777215, -1);
      class33.field752 = -1;
      if(null != class18.field259) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= field651) {
               --var4;
            }

            if(var4 * (var5 - 1) >= field651) {
               --var5;
            }

            if((var5 - 1) * var4 >= field651) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class33.field720;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < field651; ++var14) {
            World var15 = worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method638()) {
               if(var15.method636()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method620()) {
               var19 = 16711680;
               if(var15.method636()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method618()) {
               if(var15.method636()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method636()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class143.field2192 >= var11 && class143.field2199 >= var10 && class143.field2192 < var23 + var11 && class143.field2199 < var10 + var24 && var16) {
               class33.field752 = var14;
               class18.field259[var18].method1766(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class18.field259[var18].method1761(var11, var10);
            }

            if(class47.field1045 != null) {
               class47.field1045[(var15.method636()?8:0) + var15.location].method1913(29 + var11, var10);
            }

            var0.method4099(Integer.toString(var15.id), 15 + var11, 5 + var24 / 2 + var10, var19, -1);
            var1.method4099(var17, var11 + 60, var10 + var24 / 2 + 5, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4091(worldList[class33.field752].activity) + 6;
            int var20 = var1.field3245 + 8;
            class82.method1861(class143.field2192 - var14 / 2, 5 + 20 + class143.field2199, var14, var20, 16777120);
            class82.method1852(class143.field2192 - var14 / 2, 5 + 20 + class143.field2199, var14, var20, 0);
            var1.method4099(worldList[class33.field752].activity, class143.field2192, 5 + 20 + class143.field2199 + var1.field3245 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = GameObject.canvas.getGraphics();
         XClanMember.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         GameObject.canvas.repaint();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-25"
   )
   boolean method617() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1285544898"
   )
   boolean method618() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1253924203"
   )
   boolean method619() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1522800474"
   )
   boolean method620() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "620708545"
   )
   static int method622(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method659();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1132760390"
   )
   boolean method636() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-35"
   )
   boolean method638() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1467868453"
   )
   static void method648(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2795 == 0) {
         var0.width = var0.field2799;
      } else if(var0.field2795 == 1) {
         var0.width = var1 - var0.field2799;
      } else if(var0.field2795 == 2) {
         var0.width = var0.field2799 * var1 >> 14;
      }

      if(var0.field2796 == 0) {
         var0.height = var0.field2800;
      } else if(var0.field2796 == 1) {
         var0.height = var2 - var0.field2800;
      } else if(var0.field2796 == 2) {
         var0.height = var2 * var0.field2800 >> 14;
      }

      if(var0.field2795 == 4) {
         var0.width = var0.field2805 * var0.height / var0.field2806;
      }

      if(var0.field2796 == 4) {
         var0.height = var0.field2806 * var0.width / var0.field2805;
      }

      if(Client.field449 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field451 = var0;
      }

      if(var3 && null != var0.field2791 && (var0.width != var4 || var5 != var0.height)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field1 = var0.field2791;
         Client.field379.method3886(var6);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-617908197"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field885.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field906.method3304(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method794(new Buffer(var2));
         }

         var1.method797();
         NPCComposition.field885.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-2035337766"
   )
   static final void method651(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2787 || var9.type == 0 || var9.field2817 || class93.method2130(var9) != 0 || Client.field453 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2787 || !class178.method3504(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var32;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var32 = var9.width + var10;
               var19 = var11 + var9.height;
               if(var32 < var10) {
                  var16 = var32;
                  var32 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var32;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var32 < var4?var32:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field452 == var9) {
               Client.field508 = true;
               Client.field461 = var10;
               Client.field462 = var11;
            }

            if(!var9.field2787 || var12 < var14 && var13 < var15) {
               var16 = class143.field2192;
               var17 = class143.field2199;
               if(class143.field2198 != 0) {
                  var16 = class143.field2197;
                  var17 = class143.field2207;
               }

               int var22;
               int var23;
               int var51;
               if(var9.contentType == 1337) {
                  if(!Client.field527 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field432 == 0 && !Client.field434) {
                        Player.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var32 = -1;
                     var19 = -1;

                     int var43;
                     for(var43 = 0; var43 < Model.field1917; ++var43) {
                        var51 = Model.field1892[var43];
                        var22 = var51 & 127;
                        var23 = var51 >> 7 & 127;
                        int var35 = var51 >> 29 & 3;
                        int var25 = var51 >> 14 & 32767;
                        if(var19 != var51) {
                           var19 = var51;
                           if(var35 == 2 && class9.region.method1994(XItemContainer.plane, var22, var23, var51) >= 0) {
                              ObjectComposition var26 = class8.getObjectDefinition(var25);
                              if(var26.impostorIds != null) {
                                 var26 = var26.getImpostor();
                              }

                              if(null == var26) {
                                 continue;
                              }

                              if(Client.field432 == 1) {
                                 Player.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class92.method2126('\uffff') + var26.name, 1, var51, var22, var23);
                              } else if(Client.field434) {
                                 if((class221.field3210 & 4) == 4) {
                                    Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + class92.method2126('\uffff') + var26.name, 2, var51, var22, var23);
                                 }
                              } else {
                                 String[] var37 = var26.actions;
                                 if(Client.field450) {
                                    var37 = class8.method111(var37);
                                 }

                                 if(null != var37) {
                                    for(int var36 = 4; var36 >= 0; --var36) {
                                       if(null != var37[var36]) {
                                          short var29 = 0;
                                          if(var36 == 0) {
                                             var29 = 3;
                                          }

                                          if(var36 == 1) {
                                             var29 = 4;
                                          }

                                          if(var36 == 2) {
                                             var29 = 5;
                                          }

                                          if(var36 == 3) {
                                             var29 = 6;
                                          }

                                          if(var36 == 4) {
                                             var29 = 1001;
                                          }

                                          Player.addMenuEntry(var37[var36], class92.method2126('\uffff') + var26.name, var29, var51, var22, var23);
                                       }
                                    }
                                 }

                                 Player.addMenuEntry("Examine", class92.method2126('\uffff') + var26.name, 1002, var26.field928 << 14, var22, var23);
                              }
                           }

                           int var27;
                           NPC var28;
                           Player var30;
                           int[] var47;
                           int var49;
                           if(var35 == 1) {
                              NPC var44 = Client.cachedNPCs[var25];
                              if(null == var44) {
                                 continue;
                              }

                              if(var44.composition.field894 == 1 && (var44.x & 127) == 64 && (var44.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field321; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field405[var27]];
                                    if(var28 != null && var28 != var44 && var28.composition.field894 == 1 && var28.x == var44.x && var44.y == var28.y) {
                                       DecorativeObject.method2205(var28.composition, Client.field405[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field763;
                                 var47 = class34.field758;

                                 for(var49 = 0; var49 < var27; ++var49) {
                                    var30 = Client.cachedPlayers[var47[var49]];
                                    if(null != var30 && var44.x == var30.x && var44.y == var30.y) {
                                       class126.method2797(var30, var47[var49], var22, var23);
                                    }
                                 }
                              }

                              DecorativeObject.method2205(var44.composition, var25, var22, var23);
                           }

                           if(var35 == 0) {
                              Player var45 = Client.cachedPlayers[var25];
                              if(var45 == null) {
                                 continue;
                              }

                              if((var45.x & 127) == 64 && (var45.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field321; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field405[var27]];
                                    if(var28 != null && var28.composition.field894 == 1 && var28.x == var45.x && var28.y == var45.y) {
                                       DecorativeObject.method2205(var28.composition, Client.field405[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field763;
                                 var47 = class34.field758;

                                 for(var49 = 0; var49 < var27; ++var49) {
                                    var30 = Client.cachedPlayers[var47[var49]];
                                    if(var30 != null && var45 != var30 && var30.x == var45.x && var45.y == var30.y) {
                                       class126.method2797(var30, var47[var49], var22, var23);
                                    }
                                 }
                              }

                              if(var25 != Client.field471) {
                                 class126.method2797(var45, var25, var22, var23);
                              } else {
                                 var32 = var51;
                              }
                           }

                           if(var35 == 3) {
                              Deque var46 = Client.groundItemDeque[XItemContainer.plane][var22][var23];
                              if(var46 != null) {
                                 for(Item var52 = (Item)var46.method3891(); var52 != null; var52 = (Item)var46.method3893()) {
                                    ItemComposition var48 = class45.getItemDefinition(var52.id);
                                    if(Client.field432 == 1) {
                                       Player.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class92.method2126(16748608) + var48.name, 16, var52.id, var22, var23);
                                    } else if(Client.field434) {
                                       if((class221.field3210 & 1) == 1) {
                                          Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + class92.method2126(16748608) + var48.name, 17, var52.id, var22, var23);
                                       }
                                    } else {
                                       String[] var39 = var48.groundActions;
                                       if(Client.field450) {
                                          var39 = class8.method111(var39);
                                       }

                                       for(int var38 = 4; var38 >= 0; --var38) {
                                          if(var39 != null && var39[var38] != null) {
                                             byte var31 = 0;
                                             if(var38 == 0) {
                                                var31 = 18;
                                             }

                                             if(var38 == 1) {
                                                var31 = 19;
                                             }

                                             if(var38 == 2) {
                                                var31 = 20;
                                             }

                                             if(var38 == 3) {
                                                var31 = 21;
                                             }

                                             if(var38 == 4) {
                                                var31 = 22;
                                             }

                                             Player.addMenuEntry(var39[var38], class92.method2126(16748608) + var48.name, var31, var52.id, var22, var23);
                                          } else if(var38 == 2) {
                                             Player.addMenuEntry("Take", class92.method2126(16748608) + var48.name, 20, var52.id, var22, var23);
                                          }
                                       }

                                       Player.addMenuEntry("Examine", class92.method2126(16748608) + var48.name, 1004, var52.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var32 != -1) {
                        var43 = var32 & 127;
                        var51 = var32 >> 7 & 127;
                        Player var53 = Client.cachedPlayers[Client.field471];
                        class126.method2797(var53, Client.field471, var43, var51);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  XItemContainer.method181(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class132.method2840(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2787 && class178.method3504(var9) && class113.field1973 != var9) {
                        continue;
                     }

                     method651(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method651(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var18 = (WidgetNode)Client.componentTable.method3849((long)var9.id);
                     if(null != var18) {
                        if(var18.field58 == 0 && class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15 && !Client.isMenuOpen && !Client.field449) {
                           for(class0 var34 = (class0)Client.field379.method3890(); null != var34; var34 = (class0)Client.field379.method3892()) {
                              if(var34.field7) {
                                 var34.unlink();
                                 var34.field2.field2913 = false;
                              }
                           }

                           if(GameEngine.field2256 == 0) {
                              Client.field452 = null;
                              Client.field453 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var18.id;
                        if(class171.method3404(var19)) {
                           method651(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2787) {
                     class0 var41;
                     if(!var9.field2921) {
                        if(var9.field2877 && class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15) {
                           for(var41 = (class0)Client.field379.method3890(); var41 != null; var41 = (class0)Client.field379.method3892()) {
                              if(var41.field7 && var41.field2.field2865 == var41.field1) {
                                 var41.unlink();
                              }
                           }
                        }
                     } else if(class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15) {
                        for(var41 = (class0)Client.field379.method3890(); null != var41; var41 = (class0)Client.field379.method3892()) {
                           if(var41.field7) {
                              var41.unlink();
                              var41.field2.field2913 = false;
                           }
                        }

                        if(GameEngine.field2256 == 0) {
                           Client.field452 = null;
                           Client.field453 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var50;
                     if(class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15) {
                        var50 = true;
                     } else {
                        var50 = false;
                     }

                     boolean var42 = false;
                     if((class143.field2205 == 1 || !ChatMessages.field276 && class143.field2205 == 4) && var50) {
                        var42 = true;
                     }

                     boolean var20 = false;
                     if((class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4) && class143.field2197 >= var12 && class143.field2207 >= var13 && class143.field2197 < var14 && class143.field2207 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class79.method1695(var9, class143.field2197 - var10, class143.field2207 - var11);
                     }

                     if(null != Client.field452 && Client.field452 != var9 && var50) {
                        var22 = class93.method2130(var9);
                        boolean var33 = (var22 >> 20 & 1) != 0;
                        if(var33) {
                           Client.field370 = var9;
                        }
                     }

                     if(var9 == Client.field453) {
                        Client.field396 = true;
                        Client.field400 = var10;
                        Client.field459 = var11;
                     }

                     if(var9.field2817) {
                        class0 var21;
                        if(var50 && Client.field477 != 0 && null != var9.field2865) {
                           var21 = new class0();
                           var21.field7 = true;
                           var21.field2 = var9;
                           var21.field5 = Client.field477;
                           var21.field1 = var9.field2865;
                           Client.field379.method3886(var21);
                        }

                        if(null != Client.field452 || Projectile.field124 != null || Client.isMenuOpen) {
                           var20 = false;
                           var42 = false;
                           var50 = false;
                        }

                        if(!var9.field2914 && var20) {
                           var9.field2914 = true;
                           if(var9.field2870 != null) {
                              var21 = new class0();
                              var21.field7 = true;
                              var21.field2 = var9;
                              var21.field3 = class143.field2197 - var10;
                              var21.field5 = class143.field2207 - var11;
                              var21.field1 = var9.field2870;
                              Client.field379.method3886(var21);
                           }
                        }

                        if(var9.field2914 && var42 && var9.field2871 != null) {
                           var21 = new class0();
                           var21.field7 = true;
                           var21.field2 = var9;
                           var21.field3 = class143.field2192 - var10;
                           var21.field5 = class143.field2199 - var11;
                           var21.field1 = var9.field2871;
                           Client.field379.method3886(var21);
                        }

                        if(var9.field2914 && !var42) {
                           var9.field2914 = false;
                           if(var9.field2872 != null) {
                              var21 = new class0();
                              var21.field7 = true;
                              var21.field2 = var9;
                              var21.field3 = class143.field2192 - var10;
                              var21.field5 = class143.field2199 - var11;
                              var21.field1 = var9.field2872;
                              Client.field334.method3886(var21);
                           }
                        }

                        if(var42 && var9.field2886 != null) {
                           var21 = new class0();
                           var21.field7 = true;
                           var21.field2 = var9;
                           var21.field3 = class143.field2192 - var10;
                           var21.field5 = class143.field2199 - var11;
                           var21.field1 = var9.field2886;
                           Client.field379.method3886(var21);
                        }

                        if(!var9.field2913 && var50) {
                           var9.field2913 = true;
                           if(var9.field2874 != null) {
                              var21 = new class0();
                              var21.field7 = true;
                              var21.field2 = var9;
                              var21.field3 = class143.field2192 - var10;
                              var21.field5 = class143.field2199 - var11;
                              var21.field1 = var9.field2874;
                              Client.field379.method3886(var21);
                           }
                        }

                        if(var9.field2913 && var50 && null != var9.field2875) {
                           var21 = new class0();
                           var21.field7 = true;
                           var21.field2 = var9;
                           var21.field3 = class143.field2192 - var10;
                           var21.field5 = class143.field2199 - var11;
                           var21.field1 = var9.field2875;
                           Client.field379.method3886(var21);
                        }

                        if(var9.field2913 && !var50) {
                           var9.field2913 = false;
                           if(null != var9.field2876) {
                              var21 = new class0();
                              var21.field7 = true;
                              var21.field2 = var9;
                              var21.field3 = class143.field2192 - var10;
                              var21.field5 = class143.field2199 - var11;
                              var21.field1 = var9.field2876;
                              Client.field334.method3886(var21);
                           }
                        }

                        if(null != var9.field2779) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2779;
                           Client.field479.method3886(var21);
                        }

                        class0 var24;
                        if(var9.field2881 != null && Client.field435 > var9.field2843) {
                           if(null != var9.field2882 && Client.field435 - var9.field2843 <= 32) {
                              label1115:
                              for(var51 = var9.field2843; var51 < Client.field435; ++var51) {
                                 var22 = Client.field465[var51 & 31];

                                 for(var23 = 0; var23 < var9.field2882.length; ++var23) {
                                    if(var22 == var9.field2882[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field1 = var9.field2881;
                                       Client.field379.method3886(var24);
                                       break label1115;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field1 = var9.field2881;
                              Client.field379.method3886(var21);
                           }

                           var9.field2843 = Client.field435;
                        }

                        if(null != var9.field2883 && Client.field468 > var9.field2917) {
                           if(var9.field2884 != null && Client.field468 - var9.field2917 <= 32) {
                              label1091:
                              for(var51 = var9.field2917; var51 < Client.field468; ++var51) {
                                 var22 = Client.field550[var51 & 31];

                                 for(var23 = 0; var23 < var9.field2884.length; ++var23) {
                                    if(var22 == var9.field2884[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field1 = var9.field2883;
                                       Client.field379.method3886(var24);
                                       break label1091;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field1 = var9.field2883;
                              Client.field379.method3886(var21);
                           }

                           var9.field2917 = Client.field468;
                        }

                        if(null != var9.field2811 && Client.field444 > var9.field2918) {
                           if(null != var9.field2784 && Client.field444 - var9.field2918 <= 32) {
                              label1067:
                              for(var51 = var9.field2918; var51 < Client.field444; ++var51) {
                                 var22 = Client.field469[var51 & 31];

                                 for(var23 = 0; var23 < var9.field2784.length; ++var23) {
                                    if(var9.field2784[var23] == var22) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field1 = var9.field2811;
                                       Client.field379.method3886(var24);
                                       break label1067;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field1 = var9.field2811;
                              Client.field379.method3886(var21);
                           }

                           var9.field2918 = Client.field444;
                        }

                        if(Client.field325 > var9.field2804 && null != var9.field2847) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2847;
                           Client.field379.method3886(var21);
                        }

                        if(Client.field472 > var9.field2804 && var9.field2892 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2892;
                           Client.field379.method3886(var21);
                        }

                        if(Client.field281 > var9.field2804 && null != var9.field2893) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2893;
                           Client.field379.method3886(var21);
                        }

                        if(Client.field474 > var9.field2804 && var9.field2873 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2873;
                           Client.field379.method3886(var21);
                        }

                        if(Client.field475 > var9.field2804 && var9.field2899 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2899;
                           Client.field379.method3886(var21);
                        }

                        if(Client.field480 > var9.field2804 && var9.field2894 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field1 = var9.field2894;
                           Client.field379.method3886(var21);
                        }

                        var9.field2804 = Client.field295;
                        if(null != var9.field2852) {
                           for(var51 = 0; var51 < Client.field502; ++var51) {
                              class0 var40 = new class0();
                              var40.field2 = var9;
                              var40.field11 = Client.field504[var51];
                              var40.field8 = Client.field503[var51];
                              var40.field1 = var9.field2852;
                              Client.field379.method3886(var40);
                           }
                        }
                     }
                  }

                  if(!var9.field2787 && Client.field452 == null && null == Projectile.field124 && !Client.isMenuOpen) {
                     if((var9.field2903 >= 0 || var9.field2853 != 0) && class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15) {
                        if(var9.field2903 >= 0) {
                           class113.field1973 = var0[var9.field2903];
                        } else {
                           class113.field1973 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2192 >= var12 && class143.field2199 >= var13 && class143.field2192 < var14 && class143.field2199 < var15) {
                        DecorativeObject.field1672 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class14.method159(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class143.field2192, class143.field2199);
                     }
                  }
               }
            }
         }
      }

   }
}
