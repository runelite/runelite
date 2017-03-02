import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class3 implements Comparator {
   @ObfuscatedName("db")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("ny")
   static class57 field30;
   @ObfuscatedName("cn")
   public static char field32;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method41((class2)var1, (class2)var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-2128788130"
   )
   static final void method32(Widget var0, int var1, int var2) {
      if(Client.field558 == 0 || Client.field558 == 3) {
         if(class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4) {
            class164 var3 = var0.method3293(true);
            if(var3 == null) {
               return;
            }

            int var4 = class115.field1808 - var1;
            int var5 = class115.field1798 - var2;
            if(var3.method3211(var4, var5)) {
               var4 -= var3.field2148 / 2;
               var5 -= var3.field2146 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class84.field1435[var6];
               int var8 = class84.field1432[var6];
               var7 = (Client.mapScaleDelta + 256) * var7 >> 8;
               var8 = (256 + Client.mapScaleDelta) * var8 >> 8;
               int var9 = var5 * var7 + var4 * var8 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + class9.localPlayer.x >> 7;
               int var12 = class9.localPlayer.y - var10 >> 7;
               Client.field327.method3124(124);
               Client.field327.method3010(18);
               Client.field327.method2887(class2.baseY + var12);
               Client.field327.method3048(class105.field1700[82]?(class105.field1700[81]?2:1):0);
               Client.field327.method2889(var11 + MessageNode.baseX);
               Client.field327.method3010(var4);
               Client.field327.method3010(var5);
               Client.field327.method2842(Client.mapAngle);
               Client.field327.method3010(57);
               Client.field327.method3010(Client.mapScale);
               Client.field327.method3010(Client.mapScaleDelta);
               Client.field327.method3010(89);
               Client.field327.method2842(class9.localPlayer.x);
               Client.field327.method2842(class9.localPlayer.y);
               Client.field327.method3010(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-75"
   )
   public static String method36(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = Varbit.method3627(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "-1783440209"
   )
   static World method40() {
      World.field681 = 0;
      return ItemLayer.method1520();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2077188309"
   )
   int method41(class2 var1, class2 var2) {
      return var1.field17.totalQuantity < var2.field17.totalQuantity?-1:(var2.field17.totalQuantity == var1.field17.totalQuantity?0:1);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   static final void method42() {
      int var0;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var9;
      int var11;
      int var12;
      int var29;
      if(Client.packetOpcode == 114) {
         var0 = Client.field329.method3020();
         byte var1 = Client.field329.method3029();
         var2 = Client.field329.readUnsignedByte();
         var3 = (var2 >> 4 & 7) + Renderable.field1530;
         var4 = (var2 & 7) + CombatInfo2.field2845;
         var5 = Client.field329.readUnsignedByte();
         var6 = var5 >> 2;
         var7 = var5 & 3;
         var29 = Client.field348[var6];
         var9 = Client.field329.readUnsignedShort();
         byte var10 = Client.field329.method2841();
         var11 = Client.field329.method3020();
         var12 = Client.field329.readUnsignedShort();
         byte var13 = Client.field329.method3029();
         byte var14 = Client.field329.method2888();
         Player var15;
         if(var11 == Client.localInteractingIndex) {
            var15 = class9.localPlayer;
         } else {
            var15 = Client.cachedPlayers[var11];
         }

         if(var15 != null) {
            ObjectComposition var16 = class196.getObjectDefinition(var0);
            int var17;
            int var18;
            if(var7 != 1 && var7 != 3) {
               var17 = var16.sizeX;
               var18 = var16.sizeY;
            } else {
               var17 = var16.sizeY;
               var18 = var16.sizeX;
            }

            int var19 = (var17 >> 1) + var3;
            int var20 = (var17 + 1 >> 1) + var3;
            int var21 = var4 + (var18 >> 1);
            int var22 = var4 + (1 + var18 >> 1);
            int[][] var23 = class10.tileHeights[class156.plane];
            int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
            int var25 = (var17 << 6) + (var3 << 7);
            int var26 = (var4 << 7) + (var18 << 6);
            Model var27 = var16.method3706(var6, var7, var23, var25, var24, var26);
            if(null != var27) {
               Script.method963(class156.plane, var3, var4, var29, -1, 0, 0, var9 + 1, var12 + 1);
               var15.totalLevel = var9 + Client.gameCycle;
               var15.field239 = var12 + Client.gameCycle;
               var15.model = var27;
               var15.field249 = var17 * 64 + 128 * var3;
               var15.field251 = var18 * 64 + 128 * var4;
               var15.field247 = var24;
               byte var28;
               if(var1 > var10) {
                  var28 = var1;
                  var1 = var10;
                  var10 = var28;
               }

               if(var14 > var13) {
                  var28 = var14;
                  var14 = var13;
                  var13 = var28;
               }

               var15.field253 = var1 + var3;
               var15.field255 = var3 + var10;
               var15.field254 = var14 + var4;
               var15.field250 = var4 + var13;
            }
         }
      }

      Item var33;
      int var35;
      if(Client.packetOpcode == 136) {
         var0 = Client.field329.method2907();
         var35 = (var0 >> 4 & 7) + Renderable.field1530;
         var2 = (var0 & 7) + CombatInfo2.field2845;
         var3 = Client.field329.method3057();
         if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
            Deque var32 = Client.groundItemDeque[class156.plane][var35][var2];
            if(null != var32) {
               for(var33 = (Item)var32.method2472(); var33 != null; var33 = (Item)var32.method2479()) {
                  if(var33.id == (var3 & 32767)) {
                     var33.unlink();
                     break;
                  }
               }

               if(var32.method2472() == null) {
                  Client.groundItemDeque[class156.plane][var35][var2] = null;
               }

               Script.groundItemSpawned(var35, var2);
            }
         }

      } else if(Client.packetOpcode == 193) {
         var0 = Client.field329.readUnsignedByte();
         var35 = Renderable.field1530 + (var0 >> 4 & 7);
         var2 = CombatInfo2.field2845 + (var0 & 7);
         var3 = var35 + Client.field329.readByte();
         var4 = var2 + Client.field329.readByte();
         var5 = Client.field329.readShort();
         var6 = Client.field329.readUnsignedShort();
         var7 = Client.field329.readUnsignedByte() * 4;
         var29 = Client.field329.readUnsignedByte() * 4;
         var9 = Client.field329.readUnsignedShort();
         int var39 = Client.field329.readUnsignedShort();
         var11 = Client.field329.readUnsignedByte();
         var12 = Client.field329.readUnsignedByte();
         if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
            var35 = var35 * 128 + 64;
            var2 = 64 + 128 * var2;
            var3 = 64 + var3 * 128;
            var4 = 64 + 128 * var4;
            Projectile var34 = new Projectile(var6, class156.plane, var35, var2, class65.method1224(var35, var2, class156.plane) - var7, Client.gameCycle + var9, Client.gameCycle + var39, var11, var12, var5, var29);
            var34.method858(var3, var4, class65.method1224(var3, var4, class156.plane) - var29, Client.gameCycle + var9);
            Client.projectiles.method2468(var34);
         }

      } else {
         if(Client.packetOpcode == 188) {
            var0 = Client.field329.readUnsignedByte();
            var35 = (var0 >> 4 & 7) + Renderable.field1530;
            var2 = CombatInfo2.field2845 + (var0 & 7);
            var3 = Client.field329.readUnsignedShort();
            var4 = Client.field329.readUnsignedByte();
            var5 = var4 >> 4 & 15;
            var6 = var4 & 7;
            var7 = Client.field329.readUnsignedByte();
            if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
               var29 = 1 + var5;
               if(class9.localPlayer.pathX[0] >= var35 - var29 && class9.localPlayer.pathX[0] <= var29 + var35 && class9.localPlayer.pathY[0] >= var2 - var29 && class9.localPlayer.pathY[0] <= var29 + var2 && Client.field526 != 0 && var6 > 0 && Client.field527 < 50) {
                  Client.field552[Client.field527] = var3;
                  Client.field529[Client.field527] = var6;
                  Client.field530[Client.field527] = var7;
                  Client.field351[Client.field527] = null;
                  Client.field531[Client.field527] = var5 + (var2 << 8) + (var35 << 16);
                  ++Client.field527;
               }
            }
         }

         if(Client.packetOpcode == 94) {
            var0 = Client.field329.readUnsignedByte();
            var35 = Renderable.field1530 + (var0 >> 4 & 7);
            var2 = CombatInfo2.field2845 + (var0 & 7);
            var3 = Client.field329.readUnsignedShort();
            var4 = Client.field329.readUnsignedShort();
            var5 = Client.field329.readUnsignedShort();
            if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
               Deque var40 = Client.groundItemDeque[class156.plane][var35][var2];
               if(null != var40) {
                  for(Item var31 = (Item)var40.method2472(); var31 != null; var31 = (Item)var40.method2479()) {
                     if(var31.id == (var3 & 32767) && var4 == var31.quantity) {
                        var31.quantity = var5;
                        break;
                     }
                  }

                  Script.groundItemSpawned(var35, var2);
               }
            }

         } else if(Client.packetOpcode != 37) {
            if(Client.packetOpcode == 97) {
               var0 = Client.field329.readUnsignedByte();
               var35 = var0 >> 2;
               var2 = var0 & 3;
               var3 = Client.field348[var35];
               var4 = Client.field329.method2907();
               var5 = Renderable.field1530 + (var4 >> 4 & 7);
               var6 = CombatInfo2.field2845 + (var4 & 7);
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  Script.method963(class156.plane, var5, var6, var3, -1, var35, var2, 0, -1);
               }

            } else if(Client.packetOpcode == 251) {
               var0 = Client.field329.readUnsignedByte();
               var35 = (var0 >> 4 & 7) + Renderable.field1530;
               var2 = CombatInfo2.field2845 + (var0 & 7);
               var3 = Client.field329.readUnsignedShort();
               var4 = Client.field329.readUnsignedByte();
               var5 = Client.field329.readUnsignedShort();
               if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                  var35 = var35 * 128 + 64;
                  var2 = 64 + 128 * var2;
                  class33 var30 = new class33(var3, class156.plane, var35, var2, class65.method1224(var35, var2, class156.plane) - var4, var5, Client.gameCycle);
                  Client.field418.method2468(var30);
               }

            } else if(Client.packetOpcode == 21) {
               var0 = Client.field329.readUnsignedShort();
               var35 = Client.field329.readUnsignedByte();
               var2 = var35 >> 2;
               var3 = var35 & 3;
               var4 = Client.field348[var2];
               var5 = Client.field329.readUnsignedByte();
               var6 = Renderable.field1530 + (var5 >> 4 & 7);
               var7 = (var5 & 7) + CombatInfo2.field2845;
               if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                  Script.method963(class156.plane, var6, var7, var4, var0, var2, var3, 0, -1);
               }

            } else if(Client.packetOpcode == 206) {
               var0 = Client.field329.method2894();
               var35 = Client.field329.method3020();
               var2 = Client.field329.readUnsignedByte();
               var3 = Renderable.field1530 + (var2 >> 4 & 7);
               var4 = CombatInfo2.field2845 + (var2 & 7);
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var33 = new Item();
                  var33.id = var0;
                  var33.quantity = var35;
                  if(Client.groundItemDeque[class156.plane][var3][var4] == null) {
                     Client.groundItemDeque[class156.plane][var3][var4] = new Deque();
                  }

                  Client.groundItemDeque[class156.plane][var3][var4].method2468(var33);
                  Script.groundItemSpawned(var3, var4);
               }

            }
         } else {
            var0 = Client.field329.method2907();
            var35 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field348[var35];
            var4 = Client.field329.method2885();
            var5 = (var4 >> 4 & 7) + Renderable.field1530;
            var6 = (var4 & 7) + CombatInfo2.field2845;
            var7 = Client.field329.method3057();
            if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
               if(var3 == 0) {
                  WallObject var8 = Varbit.region.method1828(class156.plane, var5, var6);
                  if(null != var8) {
                     var9 = var8.hash >> 14 & 32767;
                     if(var35 == 2) {
                        var8.renderable1 = new class49(var9, 2, var2 + 4, class156.plane, var5, var6, var7, false, var8.renderable1);
                        var8.renderable2 = new class49(var9, 2, var2 + 1 & 3, class156.plane, var5, var6, var7, false, var8.renderable2);
                     } else {
                        var8.renderable1 = new class49(var9, var35, var2, class156.plane, var5, var6, var7, false, var8.renderable1);
                     }
                  }
               }

               if(var3 == 1) {
                  DecorativeObject var36 = Varbit.region.method1779(class156.plane, var5, var6);
                  if(null != var36) {
                     var9 = var36.hash >> 14 & 32767;
                     if(var35 != 4 && var35 != 5) {
                        if(var35 == 6) {
                           var36.renderable1 = new class49(var9, 4, var2 + 4, class156.plane, var5, var6, var7, false, var36.renderable1);
                        } else if(var35 == 7) {
                           var36.renderable1 = new class49(var9, 4, 4 + (2 + var2 & 3), class156.plane, var5, var6, var7, false, var36.renderable1);
                        } else if(var35 == 8) {
                           var36.renderable1 = new class49(var9, 4, 4 + var2, class156.plane, var5, var6, var7, false, var36.renderable1);
                           var36.renderable2 = new class49(var9, 4, 4 + (var2 + 2 & 3), class156.plane, var5, var6, var7, false, var36.renderable2);
                        }
                     } else {
                        var36.renderable1 = new class49(var9, 4, var2, class156.plane, var5, var6, var7, false, var36.renderable1);
                     }
                  }
               }

               if(var3 == 2) {
                  GameObject var37 = Varbit.region.method1780(class156.plane, var5, var6);
                  if(var35 == 11) {
                     var35 = 10;
                  }

                  if(null != var37) {
                     var37.renderable = new class49(var37.hash >> 14 & 32767, var35, var2, class156.plane, var5, var6, var7, false, var37.renderable);
                  }
               }

               if(var3 == 3) {
                  GroundObject var38 = Varbit.region.method1781(class156.plane, var5, var6);
                  if(var38 != null) {
                     var38.renderable = new class49(var38.hash >> 14 & 32767, 22, var2, class156.plane, var5, var6, var7, false, var38.renderable);
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-64"
   )
   static void method43(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2425(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
