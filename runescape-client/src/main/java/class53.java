import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class53 extends CacheableNode {
   @ObfuscatedName("k")
   static class170 field1152;
   @ObfuscatedName("q")
   static NodeCache field1153 = new NodeCache(64);
   @ObfuscatedName("f")
   public boolean field1154 = false;
   @ObfuscatedName("y")
   static byte[][][] field1155;
   @ObfuscatedName("gt")
   static Widget field1157;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "13"
   )
   void method1084(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1086(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1369459575"
   )
   public static int method1085(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "548663182"
   )
   void method1086(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1154 = true;
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1662384491"
   )
   static final void method1091() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var9;
      int var10;
      int var11;
      int var12;
      if(Client.packetOpcode == 218) {
         var0 = Client.field314.method2691();
         var1 = Client.field314.method2598();
         var2 = (var1 >> 4 & 7) + class146.field2240;
         var3 = class138.field2142 + (var1 & 7);
         var4 = Client.field314.method2586();
         var5 = Client.field314.method2691();
         byte var6 = Client.field314.method2602();
         byte var7 = Client.field314.method2602();
         byte var8 = Client.field314.method2572();
         var9 = Client.field314.method2608();
         var10 = Client.field314.method2571();
         var11 = var10 >> 2;
         var12 = var10 & 3;
         int var13 = Client.field517[var11];
         byte var14 = Client.field314.method2602();
         Player var15;
         if(var0 == Client.localInteractingIndex) {
            var15 = class165.localPlayer;
         } else {
            var15 = Client.cachedPlayers[var0];
         }

         if(var15 != null) {
            ObjectComposition var16 = Projectile.getObjectDefinition(var5);
            int var17;
            int var18;
            if(var12 != 1 && var12 != 3) {
               var17 = var16.field950;
               var18 = var16.field948;
            } else {
               var17 = var16.field948;
               var18 = var16.field950;
            }

            int var19 = (var17 >> 1) + var2;
            int var20 = var2 + (1 + var17 >> 1);
            int var21 = var3 + (var18 >> 1);
            int var22 = var3 + (var18 + 1 >> 1);
            int[][] var23 = class5.tileHeights[class145.plane];
            int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
            int var25 = (var2 << 7) + (var17 << 6);
            int var26 = (var18 << 6) + (var3 << 7);
            Model var27 = var16.method841(var11, var12, var23, var25, var24, var26);
            if(null != var27) {
               class162.method3201(class145.plane, var2, var3, var13, -1, 0, 0, var9 + 1, 1 + var4);
               var15.totalLevel = Client.gameCycle + var9;
               var15.field38 = Client.gameCycle + var4;
               var15.model = var27;
               var15.field39 = 128 * var2 + 64 * var17;
               var15.field50 = var3 * 128 + var18 * 64;
               var15.field54 = var24;
               byte var28;
               if(var14 > var8) {
                  var28 = var14;
                  var14 = var8;
                  var8 = var28;
               }

               if(var6 > var7) {
                  var28 = var6;
                  var6 = var7;
                  var7 = var28;
               }

               var15.field43 = var2 + var14;
               var15.field45 = var2 + var8;
               var15.field41 = var3 + var6;
               var15.field40 = var7 + var3;
            }
         }
      }

      if(Client.packetOpcode == 209) {
         var0 = Client.field314.method2571();
         var1 = (var0 >> 4 & 7) + class146.field2240;
         var2 = class138.field2142 + (var0 & 7);
         var3 = Client.field314.method2691();
         var4 = Client.field314.method2691();
         var5 = Client.field314.method2691();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var38 = Client.groundItemDeque[class145.plane][var1][var2];
            if(null != var38) {
               for(Item var30 = (Item)var38.method3864(); var30 != null; var30 = (Item)var38.method3851()) {
                  if(var30.id == (var3 & 32767) && var4 == var30.quantity) {
                     var30.quantity = var5;
                     break;
                  }
               }

               BufferProvider.groundItemSpawned(var1, var2);
            }
         }

      } else {
         Item var34;
         if(Client.packetOpcode == 31) {
            var0 = Client.field314.method2691();
            var1 = Client.field314.method2571();
            var2 = class146.field2240 + (var1 >> 4 & 7);
            var3 = (var1 & 7) + class138.field2142;
            var4 = Client.field314.method2606();
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               var34 = new Item();
               var34.id = var4;
               var34.quantity = var0;
               if(Client.groundItemDeque[class145.plane][var2][var3] == null) {
                  Client.groundItemDeque[class145.plane][var2][var3] = new Deque();
               }

               Client.groundItemDeque[class145.plane][var2][var3].method3844(var34);
               BufferProvider.groundItemSpawned(var2, var3);
            }

         } else {
            int var35;
            if(Client.packetOpcode == 111) {
               var0 = Client.field314.method2571();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = Client.field517[var1];
               var4 = Client.field314.method2571();
               var5 = class146.field2240 + (var4 >> 4 & 7);
               var35 = (var4 & 7) + class138.field2142;
               if(var5 >= 0 && var35 >= 0 && var5 < 104 && var35 < 104) {
                  class162.method3201(class145.plane, var5, var35, var3, -1, var1, var2, 0, -1);
               }

            } else if(Client.packetOpcode == 242) {
               var0 = Client.field314.method2619();
               var1 = class146.field2240 + (var0 >> 4 & 7);
               var2 = class138.field2142 + (var0 & 7);
               var3 = Client.field314.method2691();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  Deque var32 = Client.groundItemDeque[class145.plane][var1][var2];
                  if(null != var32) {
                     for(var34 = (Item)var32.method3864(); null != var34; var34 = (Item)var32.method3851()) {
                        if((var3 & 32767) == var34.id) {
                           var34.unlink();
                           break;
                        }
                     }

                     if(var32.method3864() == null) {
                        Client.groundItemDeque[class145.plane][var1][var2] = null;
                     }

                     BufferProvider.groundItemSpawned(var1, var2);
                  }
               }

            } else {
               int var36;
               int var37;
               if(Client.packetOpcode == 233) {
                  var0 = Client.field314.method2571();
                  var1 = class146.field2240 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class138.field2142;
                  var3 = var1 + Client.field314.method2572();
                  var4 = var2 + Client.field314.method2572();
                  var5 = Client.field314.method2574();
                  var35 = Client.field314.method2691();
                  var36 = Client.field314.method2571() * 4;
                  var37 = Client.field314.method2571() * 4;
                  var9 = Client.field314.method2691();
                  var10 = Client.field314.method2691();
                  var11 = Client.field314.method2571();
                  var12 = Client.field314.method2571();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var35 != '\uffff') {
                     var1 = 64 + var1 * 128;
                     var2 = 128 * var2 + 64;
                     var3 = 64 + 128 * var3;
                     var4 = var4 * 128 + 64;
                     Projectile var33 = new Projectile(var35, class145.plane, var1, var2, class109.method2439(var1, var2, class145.plane) - var36, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var37);
                     var33.method85(var3, var4, class109.method2439(var3, var4, class145.plane) - var37, var9 + Client.gameCycle);
                     Client.projectiles.method3844(var33);
                  }

               } else if(Client.packetOpcode == 88) {
                  var0 = Client.field314.method2571();
                  var1 = (var0 >> 4 & 7) + class146.field2240;
                  var2 = class138.field2142 + (var0 & 7);
                  var3 = Client.field314.method2691();
                  var4 = Client.field314.method2571();
                  var5 = Client.field314.method2691();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 64 + 128 * var1;
                     var2 = 64 + 128 * var2;
                     class31 var29 = new class31(var3, class145.plane, var1, var2, class109.method2439(var1, var2, class145.plane) - var4, var5, Client.gameCycle);
                     Client.field415.method3844(var29);
                  }

               } else {
                  if(Client.packetOpcode == 25) {
                     var0 = Client.field314.method2571();
                     var1 = class146.field2240 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + class138.field2142;
                     var3 = Client.field314.method2691();
                     var4 = Client.field314.method2571();
                     var5 = var4 >> 4 & 15;
                     var35 = var4 & 7;
                     var36 = Client.field314.method2571();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var37 = var5 + 1;
                        if(class165.localPlayer.pathX[0] >= var1 - var37 && class165.localPlayer.pathX[0] <= var37 + var1 && class165.localPlayer.pathY[0] >= var2 - var37 && class165.localPlayer.pathY[0] <= var37 + var2 && Client.field518 != 0 && var35 > 0 && Client.field522 < 50) {
                           Client.field523[Client.field522] = var3;
                           Client.field524[Client.field522] = var35;
                           Client.field327[Client.field522] = var36;
                           Client.field527[Client.field522] = null;
                           Client.field392[Client.field522] = (var1 << 16) + (var2 << 8) + var5;
                           ++Client.field522;
                        }
                     }
                  }

                  if(Client.packetOpcode == 35) {
                     var0 = Client.field314.method2598();
                     var1 = var0 >> 2;
                     var2 = var0 & 3;
                     var3 = Client.field517[var1];
                     var4 = Client.field314.method2586();
                     var5 = Client.field314.method2619();
                     var35 = (var5 >> 4 & 7) + class146.field2240;
                     var36 = (var5 & 7) + class138.field2142;
                     if(var35 >= 0 && var36 >= 0 && var35 < 104 && var36 < 104) {
                        class162.method3201(class145.plane, var35, var36, var3, var4, var1, var2, 0, -1);
                     }

                  } else if(Client.packetOpcode == 189) {
                     var0 = Client.field314.method2619();
                     var1 = var0 >> 2;
                     var2 = var0 & 3;
                     var3 = Client.field517[var1];
                     var4 = Client.field314.method2586();
                     var5 = Client.field314.method2571();
                     var35 = class146.field2240 + (var5 >> 4 & 7);
                     var36 = class138.field2142 + (var5 & 7);
                     if(var35 >= 0 && var36 >= 0 && var35 < 103 && var36 < 103) {
                        if(var3 == 0) {
                           WallObject var31 = Frames.region.method2007(class145.plane, var35, var36);
                           if(var31 != null) {
                              var9 = var31.hash >> 14 & 32767;
                              if(var1 == 2) {
                                 var31.renderable1 = new class12(var9, 2, var2 + 4, class145.plane, var35, var36, var4, false, var31.renderable1);
                                 var31.renderable2 = new class12(var9, 2, 1 + var2 & 3, class145.plane, var35, var36, var4, false, var31.renderable2);
                              } else {
                                 var31.renderable1 = new class12(var9, var1, var2, class145.plane, var35, var36, var4, false, var31.renderable1);
                              }
                           }
                        }

                        if(var3 == 1) {
                           DecorativeObject var39 = Frames.region.method2036(class145.plane, var35, var36);
                           if(null != var39) {
                              var9 = var39.hash >> 14 & 32767;
                              if(var1 != 4 && var1 != 5) {
                                 if(var1 == 6) {
                                    var39.renderable1 = new class12(var9, 4, var2 + 4, class145.plane, var35, var36, var4, false, var39.renderable1);
                                 } else if(var1 == 7) {
                                    var39.renderable1 = new class12(var9, 4, (2 + var2 & 3) + 4, class145.plane, var35, var36, var4, false, var39.renderable1);
                                 } else if(var1 == 8) {
                                    var39.renderable1 = new class12(var9, 4, var2 + 4, class145.plane, var35, var36, var4, false, var39.renderable1);
                                    var39.renderable2 = new class12(var9, 4, 4 + (var2 + 2 & 3), class145.plane, var35, var36, var4, false, var39.renderable2);
                                 }
                              } else {
                                 var39.renderable1 = new class12(var9, 4, var2, class145.plane, var35, var36, var4, false, var39.renderable1);
                              }
                           }
                        }

                        if(var3 == 2) {
                           GameObject var40 = Frames.region.method1984(class145.plane, var35, var36);
                           if(var1 == 11) {
                              var1 = 10;
                           }

                           if(null != var40) {
                              var40.renderable = new class12(var40.hash >> 14 & 32767, var1, var2, class145.plane, var35, var36, var4, false, var40.renderable);
                           }
                        }

                        if(var3 == 3) {
                           GroundObject var41 = Frames.region.method1985(class145.plane, var35, var36);
                           if(null != var41) {
                              var41.renderable = new class12(var41.hash >> 14 & 32767, 22, var2, class145.plane, var35, var36, var4, false, var41.renderable);
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-19720"
   )
   static final void method1097() {
      Client.field324.method2828(59);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3825(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3826()) {
         if(var0.field57 == 0 || var0.field57 == 3) {
            class16.method175(var0, true);
         }
      }

      if(Client.field361 != null) {
         class166.method3253(Client.field361);
         Client.field361 = null;
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "86"
   )
   static final void method1098(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class85.method1938(var0)) {
         ChatMessages.field272 = null;
         class134.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(ChatMessages.field272 != null) {
            class134.gameDraw(ChatMessages.field272, -1412584499, var1, var2, var3, var4, class134.field2120, class162.field2649, var7);
            ChatMessages.field272 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field485[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field485[var8] = true;
            }
         }

      }
   }
}
