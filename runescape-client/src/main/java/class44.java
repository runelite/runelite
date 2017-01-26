import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
final class class44 implements Comparator {
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -686452241
   )
   static int field891;
   @ObfuscatedName("p")
   public static class182 field892;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1415439269"
   )
   int method790(class2 var1, class2 var2) {
      if(var2.field24 == var1.field24) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field24 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field24) {
               return 1;
            }
         }

         return var1.field24 < var2.field24?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method790((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "1028301770"
   )
   public static boolean method803(CharSequence var0) {
      return Tile.method1550(var0, 10, true);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1974481475"
   )
   static final void method804() {
      int var0;
      int var1;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var35;
      int var36;
      int var37;
      if(Client.packetOpcode == 236) {
         var0 = Client.field323.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class107.field1729;
         var35 = (var0 & 7) + class183.field2721;
         var36 = var1 + Client.field323.readByte();
         var37 = var35 + Client.field323.readByte();
         var5 = Client.field323.readShort();
         var6 = Client.field323.readUnsignedShort();
         var7 = Client.field323.readUnsignedByte() * 4;
         var8 = Client.field323.readUnsignedByte() * 4;
         var9 = Client.field323.readUnsignedShort();
         var10 = Client.field323.readUnsignedShort();
         var11 = Client.field323.readUnsignedByte();
         var12 = Client.field323.readUnsignedByte();
         if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104 && var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104 && var6 != '\uffff') {
            var1 = var1 * 128 + 64;
            var35 = 128 * var35 + 64;
            var36 = 64 + var36 * 128;
            var37 = var37 * 128 + 64;
            Projectile var13 = new Projectile(var6, WallObject.plane, var1, var35, class65.method1153(var1, var35, WallObject.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var8);
            var13.method774(var36, var37, class65.method1153(var36, var37, WallObject.plane) - var8, Client.gameCycle + var9);
            Client.projectiles.method2407(var13);
         }

      } else if(Client.packetOpcode == 51) {
         var0 = Client.field323.readUnsignedByte();
         var1 = var0 >> 2;
         var35 = var0 & 3;
         var36 = Client.field341[var1];
         var37 = Client.field323.readUnsignedByte();
         var5 = class107.field1729 + (var37 >> 4 & 7);
         var6 = (var37 & 7) + class183.field2721;
         var7 = Client.field323.method2827();
         if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
            if(var36 == 0) {
               WallObject var30 = Renderable.region.method1712(WallObject.plane, var5, var6);
               if(null != var30) {
                  var9 = var30.hash >> 14 & 32767;
                  if(var1 == 2) {
                     var30.renderable1 = new class49(var9, 2, 4 + var35, WallObject.plane, var5, var6, var7, false, var30.renderable1);
                     var30.renderable2 = new class49(var9, 2, 1 + var35 & 3, WallObject.plane, var5, var6, var7, false, var30.renderable2);
                  } else {
                     var30.renderable1 = new class49(var9, var1, var35, WallObject.plane, var5, var6, var7, false, var30.renderable1);
                  }
               }
            }

            if(var36 == 1) {
               DecorativeObject var38 = Renderable.region.method1793(WallObject.plane, var5, var6);
               if(var38 != null) {
                  var9 = var38.hash >> 14 & 32767;
                  if(var1 != 4 && var1 != 5) {
                     if(var1 == 6) {
                        var38.renderable1 = new class49(var9, 4, 4 + var35, WallObject.plane, var5, var6, var7, false, var38.renderable1);
                     } else if(var1 == 7) {
                        var38.renderable1 = new class49(var9, 4, (2 + var35 & 3) + 4, WallObject.plane, var5, var6, var7, false, var38.renderable1);
                     } else if(var1 == 8) {
                        var38.renderable1 = new class49(var9, 4, 4 + var35, WallObject.plane, var5, var6, var7, false, var38.renderable1);
                        var38.renderable2 = new class49(var9, 4, (var35 + 2 & 3) + 4, WallObject.plane, var5, var6, var7, false, var38.renderable2);
                     }
                  } else {
                     var38.renderable1 = new class49(var9, 4, var35, WallObject.plane, var5, var6, var7, false, var38.renderable1);
                  }
               }
            }

            if(var36 == 2) {
               GameObject var39 = Renderable.region.method1723(WallObject.plane, var5, var6);
               if(var1 == 11) {
                  var1 = 10;
               }

               if(var39 != null) {
                  var39.renderable = new class49(var39.hash >> 14 & 32767, var1, var35, WallObject.plane, var5, var6, var7, false, var39.renderable);
               }
            }

            if(var36 == 3) {
               GroundObject var40 = Renderable.region.method1779(WallObject.plane, var5, var6);
               if(null != var40) {
                  var40.renderable = new class49(var40.hash >> 14 & 32767, 22, var35, WallObject.plane, var5, var6, var7, false, var40.renderable);
               }
            }
         }

      } else {
         if(Client.packetOpcode == 156) {
            var0 = Client.field323.readUnsignedShort();
            var1 = Client.field323.method2827();
            byte var2 = Client.field323.method2974();
            byte var3 = Client.field323.readByte();
            byte var4 = Client.field323.readByte();
            var5 = Client.field323.method2848();
            var6 = (var5 >> 4 & 7) + class107.field1729;
            var7 = (var5 & 7) + class183.field2721;
            var8 = Client.field323.method2933();
            var9 = Client.field323.method2954();
            var10 = var9 >> 2;
            var11 = var9 & 3;
            var12 = Client.field341[var10];
            byte var32 = Client.field323.method2974();
            int var14 = Client.field323.readUnsignedShort();
            Player var15;
            if(Client.localInteractingIndex == var8) {
               var15 = class16.localPlayer;
            } else {
               var15 = Client.cachedPlayers[var8];
            }

            if(null != var15) {
               ObjectComposition var16 = class217.getObjectDefinition(var1);
               int var17;
               int var18;
               if(var11 != 1 && var11 != 3) {
                  var17 = var16.sizeX;
                  var18 = var16.sizeY;
               } else {
                  var17 = var16.sizeY;
                  var18 = var16.sizeX;
               }

               int var19 = var6 + (var17 >> 1);
               int var20 = var6 + (1 + var17 >> 1);
               int var21 = var7 + (var18 >> 1);
               int var22 = (var18 + 1 >> 1) + var7;
               int[][] var23 = class10.tileHeights[WallObject.plane];
               int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
               int var25 = (var6 << 7) + (var17 << 6);
               int var26 = (var18 << 6) + (var7 << 7);
               Model var27 = var16.method3608(var10, var11, var23, var25, var24, var26);
               if(null != var27) {
                  class180.method3267(WallObject.plane, var6, var7, var12, -1, 0, 0, 1 + var0, var14 + 1);
                  var15.totalLevel = var0 + Client.gameCycle;
                  var15.field247 = var14 + Client.gameCycle;
                  var15.model = var27;
                  var15.field248 = var6 * 128 + var17 * 64;
                  var15.field250 = 128 * var7 + var18 * 64;
                  var15.field261 = var24;
                  byte var28;
                  if(var3 > var2) {
                     var28 = var3;
                     var3 = var2;
                     var2 = var28;
                  }

                  if(var32 > var4) {
                     var28 = var32;
                     var32 = var4;
                     var4 = var28;
                  }

                  var15.field252 = var6 + var3;
                  var15.field264 = var2 + var6;
                  var15.field258 = var32 + var7;
                  var15.field255 = var7 + var4;
               }
            }
         }

         if(Client.packetOpcode == 231) {
            var0 = Client.field323.method2954();
            var1 = class107.field1729 + (var0 >> 4 & 7);
            var35 = (var0 & 7) + class183.field2721;
            var36 = Client.field323.method2954();
            var37 = var36 >> 2;
            var5 = var36 & 3;
            var6 = Client.field341[var37];
            if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
               class180.method3267(WallObject.plane, var1, var35, var6, -1, var37, var5, 0, -1);
            }

         } else {
            Item var31;
            if(Client.packetOpcode == 241) {
               var0 = Client.field323.method2827();
               var1 = Client.field323.readUnsignedByte();
               var35 = (var1 >> 4 & 7) + class107.field1729;
               var36 = class183.field2721 + (var1 & 7);
               if(var35 >= 0 && var36 >= 0 && var35 < 104 && var36 < 104) {
                  Deque var34 = Client.groundItemDeque[WallObject.plane][var35][var36];
                  if(var34 != null) {
                     for(var31 = (Item)var34.method2412(); null != var31; var31 = (Item)var34.method2426()) {
                        if((var0 & 32767) == var31.id) {
                           var31.unlink();
                           break;
                        }
                     }

                     if(var34.method2412() == null) {
                        Client.groundItemDeque[WallObject.plane][var35][var36] = null;
                     }

                     class15.groundItemSpawned(var35, var36);
                  }
               }

            } else if(Client.packetOpcode != 7) {
               if(Client.packetOpcode == 37) {
                  var0 = Client.field323.readUnsignedShort();
                  var1 = Client.field323.readUnsignedShort();
                  var35 = Client.field323.method2954();
                  var36 = (var35 >> 4 & 7) + class107.field1729;
                  var37 = class183.field2721 + (var35 & 7);
                  if(var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104) {
                     var31 = new Item();
                     var31.id = var1;
                     var31.quantity = var0;
                     if(Client.groundItemDeque[WallObject.plane][var36][var37] == null) {
                        Client.groundItemDeque[WallObject.plane][var36][var37] = new Deque();
                     }

                     Client.groundItemDeque[WallObject.plane][var36][var37].method2407(var31);
                     class15.groundItemSpawned(var36, var37);
                  }

               } else {
                  if(Client.packetOpcode == 92) {
                     var0 = Client.field323.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class107.field1729;
                     var35 = class183.field2721 + (var0 & 7);
                     var36 = Client.field323.readUnsignedShort();
                     var37 = Client.field323.readUnsignedByte();
                     var5 = var37 >> 4 & 15;
                     var6 = var37 & 7;
                     var7 = Client.field323.readUnsignedByte();
                     if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
                        var8 = var5 + 1;
                        if(class16.localPlayer.pathX[0] >= var1 - var8 && class16.localPlayer.pathX[0] <= var1 + var8 && class16.localPlayer.pathY[0] >= var35 - var8 && class16.localPlayer.pathY[0] <= var8 + var35 && Client.field518 != 0 && var6 > 0 && Client.field370 < 50) {
                           Client.field520[Client.field370] = var36;
                           Client.field521[Client.field370] = var6;
                           Client.field522[Client.field370] = var7;
                           Client.field302[Client.field370] = null;
                           Client.field523[Client.field370] = var5 + (var35 << 8) + (var1 << 16);
                           ++Client.field370;
                        }
                     }
                  }

                  if(Client.packetOpcode == 136) {
                     var0 = Client.field323.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class107.field1729;
                     var35 = class183.field2721 + (var0 & 7);
                     var36 = Client.field323.readUnsignedShort();
                     var37 = Client.field323.readUnsignedByte();
                     var5 = Client.field323.readUnsignedShort();
                     if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
                        var1 = 128 * var1 + 64;
                        var35 = var35 * 128 + 64;
                        class33 var41 = new class33(var36, WallObject.plane, var1, var35, class65.method1153(var1, var35, WallObject.plane) - var37, var5, Client.gameCycle);
                        Client.field412.method2407(var41);
                     }

                  } else if(Client.packetOpcode == 219) {
                     var0 = Client.field323.method2848();
                     var1 = var0 >> 2;
                     var35 = var0 & 3;
                     var36 = Client.field341[var1];
                     var37 = Client.field323.method2850();
                     var5 = Client.field323.method2954();
                     var6 = class107.field1729 + (var5 >> 4 & 7);
                     var7 = (var5 & 7) + class183.field2721;
                     if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                        class180.method3267(WallObject.plane, var6, var7, var36, var37, var1, var35, 0, -1);
                     }

                  }
               }
            } else {
               var0 = Client.field323.readUnsignedByte();
               var1 = class107.field1729 + (var0 >> 4 & 7);
               var35 = (var0 & 7) + class183.field2721;
               var36 = Client.field323.readUnsignedShort();
               var37 = Client.field323.readUnsignedShort();
               var5 = Client.field323.readUnsignedShort();
               if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
                  Deque var33 = Client.groundItemDeque[WallObject.plane][var1][var35];
                  if(null != var33) {
                     for(Item var29 = (Item)var33.method2412(); null != var29; var29 = (Item)var33.method2426()) {
                        if(var29.id == (var36 & 32767) && var37 == var29.quantity) {
                           var29.quantity = var5;
                           break;
                        }
                     }

                     class15.groundItemSpawned(var1, var35);
                  }
               }

            }
         }
      }
   }
}
