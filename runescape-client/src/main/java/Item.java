import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("lc")
   static class216 field889;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1256245593
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -148942375
   )
   static int field891;
   @ObfuscatedName("ri")
   protected static String field892;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -111146433
   )
   @Export("id")
   int id;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 499553183
   )
   protected static int field896;
   @ObfuscatedName("a")
   public static int[] field897;

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1109344576"
   )
   static final void method775() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(Client.packetOpcode == 51) {
         var0 = Client.field544.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class36.field777;
         var2 = GameObject.field1599 + (var0 & 7);
         var3 = Client.field544.readUnsignedShort();
         var4 = Client.field544.readUnsignedByte();
         var5 = var4 >> 4 & 15;
         var6 = var4 & 7;
         var7 = Client.field544.readUnsignedByte();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var8 = 1 + var5;
            if(class39.localPlayer.pathX[0] >= var1 - var8 && class39.localPlayer.pathX[0] <= var1 + var8 && class39.localPlayer.pathY[0] >= var2 - var8 && class39.localPlayer.pathY[0] <= var2 + var8 && Client.field527 != 0 && var6 > 0 && Client.field528 < 50) {
               Client.field529[Client.field528] = var3;
               Client.field409[Client.field528] = var6;
               Client.field439[Client.field528] = var7;
               Client.field533[Client.field528] = null;
               Client.field483[Client.field528] = var5 + (var1 << 16) + (var2 << 8);
               ++Client.field528;
            }
         }
      }

      Item var30;
      if(Client.packetOpcode == 83) {
         var0 = Client.field544.method2750();
         var1 = Client.field544.readUnsignedShort();
         var2 = Client.field544.method2786();
         var3 = class36.field777 + (var2 >> 4 & 7);
         var4 = (var2 & 7) + GameObject.field1599;
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            var30 = new Item();
            var30.id = var1;
            var30.quantity = var0;
            if(Client.groundItemDeque[class171.plane][var3][var4] == null) {
               Client.groundItemDeque[class171.plane][var3][var4] = new Deque();
            }

            Client.groundItemDeque[class171.plane][var3][var4].method2376(var30);
            class6.groundItemSpawned(var3, var4);
         }

      } else if(Client.packetOpcode == 218) {
         var0 = Client.field544.method2788();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = Client.field491[var1];
         var4 = Client.field544.method2923();
         var5 = class36.field777 + (var4 >> 4 & 7);
         var6 = GameObject.field1599 + (var4 & 7);
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            class60.method1114(class171.plane, var5, var6, var3, -1, var1, var2, 0, -1);
         }

      } else if(Client.packetOpcode == 203) {
         var0 = Client.field544.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class36.field777;
         var2 = (var0 & 7) + GameObject.field1599;
         var3 = Client.field544.readUnsignedShort();
         var4 = Client.field544.readUnsignedShort();
         var5 = Client.field544.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var42 = Client.groundItemDeque[class171.plane][var1][var2];
            if(null != var42) {
               for(Item var29 = (Item)var42.method2359(); var29 != null; var29 = (Item)var42.method2361()) {
                  if((var3 & 32767) == var29.id && var29.quantity == var4) {
                     var29.quantity = var5;
                     break;
                  }
               }

               class6.groundItemSpawned(var1, var2);
            }
         }

      } else if(Client.packetOpcode == 16) {
         var0 = Client.field544.readUnsignedByte();
         var1 = class36.field777 + (var0 >> 4 & 7);
         var2 = GameObject.field1599 + (var0 & 7);
         var3 = Client.field544.readUnsignedShort();
         var4 = Client.field544.readUnsignedByte();
         var5 = Client.field544.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var1 = 128 * var1 + 64;
            var2 = 64 + var2 * 128;
            class33 var33 = new class33(var3, class171.plane, var1, var2, class85.method1686(var1, var2, class171.plane) - var4, var5, Client.gameCycle);
            Client.field422.method2376(var33);
         }

      } else if(Client.packetOpcode == 216) {
         var0 = Client.field544.method2750();
         var1 = Client.field544.method2788();
         var2 = class36.field777 + (var1 >> 4 & 7);
         var3 = GameObject.field1599 + (var1 & 7);
         if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
            Deque var34 = Client.groundItemDeque[class171.plane][var2][var3];
            if(var34 != null) {
               for(var30 = (Item)var34.method2359(); null != var30; var30 = (Item)var34.method2361()) {
                  if(var30.id == (var0 & 32767)) {
                     var30.unlink();
                     break;
                  }
               }

               if(var34.method2359() == null) {
                  Client.groundItemDeque[class171.plane][var2][var3] = null;
               }

               class6.groundItemSpawned(var2, var3);
            }
         }

      } else {
         int var9;
         int var11;
         int var12;
         if(Client.packetOpcode == 215) {
            var0 = Client.field544.readUnsignedByte();
            var1 = class36.field777 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + GameObject.field1599;
            var3 = var1 + Client.field544.readByte();
            var4 = var2 + Client.field544.readByte();
            var5 = Client.field544.method2762();
            var6 = Client.field544.readUnsignedShort();
            var7 = Client.field544.readUnsignedByte() * 4;
            var8 = Client.field544.readUnsignedByte() * 4;
            var9 = Client.field544.readUnsignedShort();
            int var38 = Client.field544.readUnsignedShort();
            var11 = Client.field544.readUnsignedByte();
            var12 = Client.field544.readUnsignedByte();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var1 = 128 * var1 + 64;
               var2 = 64 + 128 * var2;
               var3 = 128 * var3 + 64;
               var4 = var4 * 128 + 64;
               Projectile var32 = new Projectile(var6, class171.plane, var1, var2, class85.method1686(var1, var2, class171.plane) - var7, Client.gameCycle + var9, var38 + Client.gameCycle, var11, var12, var5, var8);
               var32.method765(var3, var4, class85.method1686(var3, var4, class171.plane) - var8, Client.gameCycle + var9);
               Client.projectiles.method2376(var32);
            }

         } else if(Client.packetOpcode == 192) {
            var0 = Client.field544.method2923();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field491[var1];
            var4 = Client.field544.readUnsignedShort();
            var5 = Client.field544.method2788();
            var6 = class36.field777 + (var5 >> 4 & 7);
            var7 = GameObject.field1599 + (var5 & 7);
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class60.method1114(class171.plane, var6, var7, var3, var4, var1, var2, 0, -1);
            }

         } else if(Client.packetOpcode == 155) {
            var0 = Client.field544.method2750();
            var1 = Client.field544.method2786();
            var2 = var1 >> 2;
            var3 = var1 & 3;
            var4 = Client.field491[var2];
            var5 = Client.field544.method2786();
            var6 = class36.field777 + (var5 >> 4 & 7);
            var7 = (var5 & 7) + GameObject.field1599;
            if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
               if(var4 == 0) {
                  WallObject var31 = Client.region.method1713(class171.plane, var6, var7);
                  if(var31 != null) {
                     var9 = var31.hash >> 14 & 32767;
                     if(var2 == 2) {
                        var31.renderable1 = new class49(var9, 2, 4 + var3, class171.plane, var6, var7, var0, false, var31.renderable1);
                        var31.renderable2 = new class49(var9, 2, var3 + 1 & 3, class171.plane, var6, var7, var0, false, var31.renderable2);
                     } else {
                        var31.renderable1 = new class49(var9, var2, var3, class171.plane, var6, var7, var0, false, var31.renderable1);
                     }
                  }
               }

               if(var4 == 1) {
                  DecorativeObject var39 = Client.region.method1714(class171.plane, var6, var7);
                  if(null != var39) {
                     var9 = var39.hash >> 14 & 32767;
                     if(var2 != 4 && var2 != 5) {
                        if(var2 == 6) {
                           var39.renderable1 = new class49(var9, 4, var3 + 4, class171.plane, var6, var7, var0, false, var39.renderable1);
                        } else if(var2 == 7) {
                           var39.renderable1 = new class49(var9, 4, 4 + (var3 + 2 & 3), class171.plane, var6, var7, var0, false, var39.renderable1);
                        } else if(var2 == 8) {
                           var39.renderable1 = new class49(var9, 4, var3 + 4, class171.plane, var6, var7, var0, false, var39.renderable1);
                           var39.renderable2 = new class49(var9, 4, (var3 + 2 & 3) + 4, class171.plane, var6, var7, var0, false, var39.renderable2);
                        }
                     } else {
                        var39.renderable1 = new class49(var9, 4, var3, class171.plane, var6, var7, var0, false, var39.renderable1);
                     }
                  }
               }

               if(var4 == 2) {
                  GameObject var40 = Client.region.method1832(class171.plane, var6, var7);
                  if(var2 == 11) {
                     var2 = 10;
                  }

                  if(null != var40) {
                     var40.renderable = new class49(var40.hash >> 14 & 32767, var2, var3, class171.plane, var6, var7, var0, false, var40.renderable);
                  }
               }

               if(var4 == 3) {
                  GroundObject var41 = Client.region.method1784(class171.plane, var6, var7);
                  if(null != var41) {
                     var41.renderable = new class49(var41.hash >> 14 & 32767, 22, var3, class171.plane, var6, var7, var0, false, var41.renderable);
                  }
               }
            }

         } else {
            if(Client.packetOpcode == 18) {
               byte var35 = Client.field544.method2831();
               var1 = Client.field544.method2797();
               var2 = Client.field544.method2750();
               byte var36 = Client.field544.readByte();
               byte var37 = Client.field544.method2920();
               var5 = Client.field544.method2788();
               var6 = class36.field777 + (var5 >> 4 & 7);
               var7 = GameObject.field1599 + (var5 & 7);
               var8 = Client.field544.readUnsignedShort();
               var9 = Client.field544.method2750();
               byte var10 = Client.field544.method2779();
               var11 = Client.field544.method2923();
               var12 = var11 >> 2;
               int var13 = var11 & 3;
               int var14 = Client.field491[var12];
               Player var15;
               if(var2 == Client.localInteractingIndex) {
                  var15 = class39.localPlayer;
               } else {
                  var15 = Client.cachedPlayers[var2];
               }

               if(null != var15) {
                  ObjectComposition var16 = ItemLayer.getObjectDefinition(var1);
                  int var17;
                  int var18;
                  if(var13 != 1 && var13 != 3) {
                     var17 = var16.field2907;
                     var18 = var16.field2908;
                  } else {
                     var17 = var16.field2908;
                     var18 = var16.field2907;
                  }

                  int var19 = (var17 >> 1) + var6;
                  int var20 = var6 + (1 + var17 >> 1);
                  int var21 = var7 + (var18 >> 1);
                  int var22 = (1 + var18 >> 1) + var7;
                  int[][] var23 = class10.tileHeights[class171.plane];
                  int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
                  int var25 = (var6 << 7) + (var17 << 6);
                  int var26 = (var18 << 6) + (var7 << 7);
                  Model var27 = var16.method3574(var12, var13, var23, var25, var24, var26);
                  if(null != var27) {
                     class60.method1114(class171.plane, var6, var7, var14, -1, 0, 0, var8 + 1, 1 + var9);
                     var15.totalLevel = var8 + Client.gameCycle;
                     var15.field249 = var9 + Client.gameCycle;
                     var15.model = var27;
                     var15.field250 = var6 * 128 + 64 * var17;
                     var15.field252 = var7 * 128 + var18 * 64;
                     var15.field251 = var24;
                     byte var28;
                     if(var36 > var10) {
                        var28 = var36;
                        var36 = var10;
                        var10 = var28;
                     }

                     if(var37 > var35) {
                        var28 = var37;
                        var37 = var35;
                        var35 = var28;
                     }

                     var15.field254 = var6 + var36;
                     var15.field239 = var6 + var10;
                     var15.field255 = var37 + var7;
                     var15.field257 = var35 + var7;
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      return class7.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;I)V",
      garbageValue = "1618114042"
   )
   static void method778(class208 var0, class208 var1) {
      if(class41.field860 == null) {
         class41.field860 = class57.method1024(Client.field314, "sl_back", "");
      }

      if(null == class0.field2) {
         class0.field2 = class15.method175(Client.field314, "sl_flags", "");
      }

      if(class184.field2743 == null) {
         class184.field2743 = class15.method175(Client.field314, "sl_arrows", "");
      }

      if(class20.field216 == null) {
         class20.field216 = class15.method175(Client.field314, "sl_stars", "");
      }

      class219.method3910(class41.field824, 23, 765, 480, 0);
      class219.method3900(class41.field824, 0, 125, 23, 12425273, 9135624);
      class219.method3900(125 + class41.field824, 0, 640, 23, 5197647, 2697513);
      var0.method3782("Select a world", 62 + class41.field824, 15, 0, -1);
      if(null != class20.field216) {
         class20.field216[1].method3979(140 + class41.field824, 1);
         var1.method3779("Members only world", 152 + class41.field824, 10, 16777215, -1);
         class20.field216[0].method3979(140 + class41.field824, 12);
         var1.method3779("Free world", 152 + class41.field824, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class184.field2743 != null) {
         int var2 = class41.field824 + 280;
         if(World.field678[0] == 0 && World.field674[0] == 0) {
            class184.field2743[2].method3979(var2, 4);
         } else {
            class184.field2743[0].method3979(var2, 4);
         }

         if(World.field678[0] == 0 && World.field674[0] == 1) {
            class184.field2743[3].method3979(var2 + 15, 4);
         } else {
            class184.field2743[1].method3979(15 + var2, 4);
         }

         var0.method3779("World", 32 + var2, 17, 16777215, -1);
         int var3 = 390 + class41.field824;
         if(World.field678[0] == 1 && World.field674[0] == 0) {
            class184.field2743[2].method3979(var3, 4);
         } else {
            class184.field2743[0].method3979(var3, 4);
         }

         if(World.field678[0] == 1 && World.field674[0] == 1) {
            class184.field2743[3].method3979(15 + var3, 4);
         } else {
            class184.field2743[1].method3979(var3 + 15, 4);
         }

         var0.method3779("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class41.field824;
         if(World.field678[0] == 2 && World.field674[0] == 0) {
            class184.field2743[2].method3979(var4, 4);
         } else {
            class184.field2743[0].method3979(var4, 4);
         }

         if(World.field678[0] == 2 && World.field674[0] == 1) {
            class184.field2743[3].method3979(var4 + 15, 4);
         } else {
            class184.field2743[1].method3979(var4 + 15, 4);
         }

         var0.method3779("Location", var4 + 32, 17, 16777215, -1);
         var5 = 610 + class41.field824;
         if(World.field678[0] == 3 && World.field674[0] == 0) {
            class184.field2743[2].method3979(var5, 4);
         } else {
            class184.field2743[0].method3979(var5, 4);
         }

         if(World.field678[0] == 3 && World.field674[0] == 1) {
            class184.field2743[3].method3979(var5 + 15, 4);
         } else {
            class184.field2743[1].method3979(var5 + 15, 4);
         }

         var0.method3779("Type", var5 + 32, 17, 16777215, -1);
      }

      class219.method3910(class41.field824 + 708, 4, 50, 16, 0);
      var1.method3782("Cancel", 25 + 708 + class41.field824, 16, 16777215, -1);
      class41.field858 = -1;
      if(class41.field860 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.field672) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field672) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.field672) {
               --var5;
            }
         } while(var6 != var5 || var7 != var4);

         var6 = (765 - var23 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = class41.field824 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field672; ++var14) {
            World var15 = class107.worldList[var14];
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
            if(var15.method596()) {
               if(var15.method591()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method595()) {
               var19 = 16711680;
               if(var15.method591()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method593()) {
               if(var15.method591()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method591()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1794 >= var11 && class115.field1797 >= var10 && class115.field1794 < var23 + var11 && class115.field1797 < var10 + var24 && var16) {
               class41.field858 = var14;
               class41.field860[var18].method4085(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class41.field860[var18].method4071(var11, var10);
            }

            if(class0.field2 != null) {
               class0.field2[(var15.method591()?8:0) + var15.location].method3979(var11 + 29, var10);
            }

            var0.method3782(Integer.toString(var15.id), 15 + var11, 5 + var24 / 2 + var10, var19, -1);
            var1.method3782(var17, var11 + 60, var10 + var24 / 2 + 5, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var23 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3774(class107.worldList[class41.field858].activity) + 6;
            int var20 = 8 + var1.field3097;
            class219.method3910(class115.field1794 - var14 / 2, 5 + class115.field1797 + 20, var14, var20, 16777120);
            class219.method3932(class115.field1794 - var14 / 2, class115.field1797 + 20 + 5, var14, var20, 0);
            var1.method3782(class107.worldList[class41.field858].activity, class115.field1794, 4 + var1.field3097 + 5 + class115.field1797 + 20, 0, -1);
         }
      }

      try {
         Graphics var21 = class110.canvas.getGraphics();
         ChatMessages.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class110.canvas.repaint();
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "31"
   )
   static final void method779(Widget var0, int var1, int var2) {
      if(Client.field522 == 0 || Client.field522 == 3) {
         if(class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4) {
            class164 var3 = var0.method3111(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1803 - var1;
            int var5 = class115.field1804 - var2;
            if(var3.method3053(var4, var5)) {
               var4 -= var3.field2159 / 2;
               var5 -= var3.field2167 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class84.field1453[var6];
               int var8 = class84.field1454[var6];
               var7 = (256 + Client.mapScaleDelta) * var7 >> 8;
               var8 = var8 * (256 + Client.mapScaleDelta) >> 8;
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + class39.localPlayer.x >> 7;
               int var12 = class39.localPlayer.y - var10 >> 7;
               Client.field294.method2976(254);
               Client.field294.method2932(18);
               Client.field294.method2932(class105.field1693[82]?(class105.field1693[81]?2:1):0);
               Client.field294.method2792(class20.baseY + var12);
               Client.field294.method2763(class15.baseX + var11);
               Client.field294.method2932(var4);
               Client.field294.method2932(var5);
               Client.field294.method2746(Client.mapAngle);
               Client.field294.method2932(57);
               Client.field294.method2932(Client.mapScale);
               Client.field294.method2932(Client.mapScaleDelta);
               Client.field294.method2932(89);
               Client.field294.method2746(class39.localPlayer.x);
               Client.field294.method2746(class39.localPlayer.y);
               Client.field294.method2932(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }
}
