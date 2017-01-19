import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class60 {
   @ObfuscatedName("s")
   class182 field1081;
   @ObfuscatedName("h")
   XHashTable field1082 = new XHashTable(256);
   @ObfuscatedName("f")
   XHashTable field1083 = new XHashTable(256);
   @ObfuscatedName("c")
   class182 field1084;
   @ObfuscatedName("g")
   static class182 field1086;

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "593038026"
   )
   static final void method1078() {
      int var1;
      int var3;
      int var4;
      Item var5;
      int var35;
      int var36;
      if(Client.packetOpcode == 52) {
         var35 = Client.field352.readUnsignedByte();
         var1 = class25.field587 + (var35 >> 4 & 7);
         var36 = class138.field1924 + (var35 & 7);
         var3 = Client.field352.method2757();
         var4 = Client.field352.readUnsignedShort();
         if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
            var5 = new Item();
            var5.id = var3;
            var5.quantity = var4;
            if(null == Client.groundItemDeque[class118.plane][var1][var36]) {
               Client.groundItemDeque[class118.plane][var1][var36] = new Deque();
            }

            Client.groundItemDeque[class118.plane][var1][var36].method2333(var5);
            ItemComposition.groundItemSpawned(var1, var36);
         }

      } else {
         int var9;
         int var29;
         int var30;
         int var38;
         if(Client.packetOpcode == 169) {
            var35 = Client.field352.readUnsignedByte();
            var1 = var35 >> 2;
            var36 = var35 & 3;
            var3 = Client.field356[var1];
            var4 = Client.field352.method2757();
            var29 = Client.field352.method2915();
            var30 = (var29 >> 4 & 7) + class25.field587;
            var38 = class138.field1924 + (var29 & 7);
            if(var30 >= 0 && var38 >= 0 && var30 < 103 && var38 < 103) {
               if(var3 == 0) {
                  WallObject var31 = class0.region.method1680(class118.plane, var30, var38);
                  if(null != var31) {
                     var9 = var31.hash >> 14 & 32767;
                     if(var1 == 2) {
                        var31.renderable1 = new class49(var9, 2, 4 + var36, class118.plane, var30, var38, var4, false, var31.renderable1);
                        var31.renderable2 = new class49(var9, 2, var36 + 1 & 3, class118.plane, var30, var38, var4, false, var31.renderable2);
                     } else {
                        var31.renderable1 = new class49(var9, var1, var36, class118.plane, var30, var38, var4, false, var31.renderable1);
                     }
                  }
               }

               if(var3 == 1) {
                  DecorativeObject var39 = class0.region.method1681(class118.plane, var30, var38);
                  if(var39 != null) {
                     var9 = var39.hash >> 14 & 32767;
                     if(var1 != 4 && var1 != 5) {
                        if(var1 == 6) {
                           var39.renderable1 = new class49(var9, 4, 4 + var36, class118.plane, var30, var38, var4, false, var39.renderable1);
                        } else if(var1 == 7) {
                           var39.renderable1 = new class49(var9, 4, 4 + (var36 + 2 & 3), class118.plane, var30, var38, var4, false, var39.renderable1);
                        } else if(var1 == 8) {
                           var39.renderable1 = new class49(var9, 4, 4 + var36, class118.plane, var30, var38, var4, false, var39.renderable1);
                           var39.renderable2 = new class49(var9, 4, 4 + (var36 + 2 & 3), class118.plane, var30, var38, var4, false, var39.renderable2);
                        }
                     } else {
                        var39.renderable1 = new class49(var9, 4, var36, class118.plane, var30, var38, var4, false, var39.renderable1);
                     }
                  }
               }

               if(var3 == 2) {
                  GameObject var40 = class0.region.method1791(class118.plane, var30, var38);
                  if(var1 == 11) {
                     var1 = 10;
                  }

                  if(null != var40) {
                     var40.renderable = new class49(var40.hash >> 14 & 32767, var1, var36, class118.plane, var30, var38, var4, false, var40.renderable);
                  }
               }

               if(var3 == 3) {
                  GroundObject var41 = class0.region.method1683(class118.plane, var30, var38);
                  if(null != var41) {
                     var41.renderable = new class49(var41.hash >> 14 & 32767, 22, var36, class118.plane, var30, var38, var4, false, var41.renderable);
                  }
               }
            }

         } else {
            int var8;
            int var10;
            int var11;
            int var12;
            if(Client.packetOpcode == 233) {
               byte var0 = Client.field352.method2752();
               var1 = Client.field352.method2757();
               byte var2 = Client.field352.method2752();
               var3 = Client.field352.method2763();
               var4 = var3 >> 2;
               var29 = var3 & 3;
               var30 = Client.field356[var4];
               byte var7 = Client.field352.readByte();
               var8 = Client.field352.method2757();
               var9 = Client.field352.method2763();
               var10 = (var9 >> 4 & 7) + class25.field587;
               var11 = (var9 & 7) + class138.field1924;
               var12 = Client.field352.readUnsignedShort();
               byte var13 = Client.field352.method2725();
               int var14 = Client.field352.method2757();
               Player var15;
               if(Client.localInteractingIndex == var8) {
                  var15 = XItemContainer.localPlayer;
               } else {
                  var15 = Client.cachedPlayers[var8];
               }

               if(var15 != null) {
                  ObjectComposition var16 = class143.getObjectDefinition(var12);
                  int var17;
                  int var18;
                  if(var29 != 1 && var29 != 3) {
                     var17 = var16.sizeX;
                     var18 = var16.sizeY;
                  } else {
                     var17 = var16.sizeY;
                     var18 = var16.sizeX;
                  }

                  int var19 = (var17 >> 1) + var10;
                  int var20 = var10 + (var17 + 1 >> 1);
                  int var21 = (var18 >> 1) + var11;
                  int var22 = var11 + (var18 + 1 >> 1);
                  int[][] var23 = class10.tileHeights[class118.plane];
                  int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                  int var25 = (var17 << 6) + (var10 << 7);
                  int var26 = (var11 << 7) + (var18 << 6);
                  Model var27 = var16.method3488(var4, var29, var23, var25, var24, var26);
                  if(var27 != null) {
                     CollisionData.method2178(class118.plane, var10, var11, var30, -1, 0, 0, var14 + 1, var1 + 1);
                     var15.totalLevel = var14 + Client.gameCycle;
                     var15.field265 = var1 + Client.gameCycle;
                     var15.model = var27;
                     var15.field256 = 128 * var10 + 64 * var17;
                     var15.field268 = 64 * var18 + 128 * var11;
                     var15.field276 = var24;
                     byte var28;
                     if(var13 > var0) {
                        var28 = var13;
                        var13 = var0;
                        var0 = var28;
                     }

                     if(var7 > var2) {
                        var28 = var7;
                        var7 = var2;
                        var2 = var28;
                     }

                     var15.field275 = var13 + var10;
                     var15.field269 = var10 + var0;
                     var15.field263 = var11 + var7;
                     var15.field273 = var2 + var11;
                  }
               }
            }

            if(Client.packetOpcode == 198) {
               var35 = Client.field352.method2751();
               var1 = (var35 >> 4 & 7) + class25.field587;
               var36 = class138.field1924 + (var35 & 7);
               var3 = Client.field352.method2915();
               var4 = var3 >> 2;
               var29 = var3 & 3;
               var30 = Client.field356[var4];
               if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
                  CollisionData.method2178(class118.plane, var1, var36, var30, -1, var4, var29, 0, -1);
               }

            } else if(Client.packetOpcode == 100) {
               var35 = Client.field352.readUnsignedByte();
               var1 = class25.field587 + (var35 >> 4 & 7);
               var36 = class138.field1924 + (var35 & 7);
               var3 = Client.field352.readUnsignedShort();
               var4 = Client.field352.readUnsignedShort();
               var29 = Client.field352.readUnsignedShort();
               if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
                  Deque var37 = Client.groundItemDeque[class118.plane][var1][var36];
                  if(var37 != null) {
                     for(Item var32 = (Item)var37.method2330(); var32 != null; var32 = (Item)var37.method2346()) {
                        if(var32.id == (var3 & 32767) && var32.quantity == var4) {
                           var32.quantity = var29;
                           break;
                        }
                     }

                     ItemComposition.groundItemSpawned(var1, var36);
                  }
               }

            } else if(Client.packetOpcode == 69) {
               var35 = Client.field352.readUnsignedByte();
               var1 = (var35 >> 4 & 7) + class25.field587;
               var36 = class138.field1924 + (var35 & 7);
               var3 = var1 + Client.field352.readByte();
               var4 = var36 + Client.field352.readByte();
               var29 = Client.field352.readShort();
               var30 = Client.field352.readUnsignedShort();
               var38 = Client.field352.readUnsignedByte() * 4;
               var8 = Client.field352.readUnsignedByte() * 4;
               var9 = Client.field352.readUnsignedShort();
               var10 = Client.field352.readUnsignedShort();
               var11 = Client.field352.readUnsignedByte();
               var12 = Client.field352.readUnsignedByte();
               if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var30 != '\uffff') {
                  var1 = 128 * var1 + 64;
                  var36 = var36 * 128 + 64;
                  var3 = 64 + var3 * 128;
                  var4 = 64 + var4 * 128;
                  Projectile var33 = new Projectile(var30, class118.plane, var1, var36, XClanMember.method223(var1, var36, class118.plane) - var38, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var29, var8);
                  var33.method759(var3, var4, XClanMember.method223(var3, var4, class118.plane) - var8, Client.gameCycle + var9);
                  Client.projectiles.method2333(var33);
               }

            } else if(Client.packetOpcode == 207) {
               var35 = Client.field352.readUnsignedByte();
               var1 = class25.field587 + (var35 >> 4 & 7);
               var36 = class138.field1924 + (var35 & 7);
               var3 = Client.field352.readUnsignedShort();
               var4 = Client.field352.readUnsignedByte();
               var29 = Client.field352.readUnsignedShort();
               if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
                  var1 = 128 * var1 + 64;
                  var36 = 64 + var36 * 128;
                  class33 var6 = new class33(var3, class118.plane, var1, var36, XClanMember.method223(var1, var36, class118.plane) - var4, var29, Client.gameCycle);
                  Client.field426.method2333(var6);
               }

            } else {
               if(Client.packetOpcode == 21) {
                  var35 = Client.field352.readUnsignedByte();
                  var1 = class25.field587 + (var35 >> 4 & 7);
                  var36 = (var35 & 7) + class138.field1924;
                  var3 = Client.field352.readUnsignedShort();
                  var4 = Client.field352.readUnsignedByte();
                  var29 = var4 >> 4 & 15;
                  var30 = var4 & 7;
                  var38 = Client.field352.readUnsignedByte();
                  if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
                     var8 = 1 + var29;
                     if(XItemContainer.localPlayer.pathX[0] >= var1 - var8 && XItemContainer.localPlayer.pathX[0] <= var8 + var1 && XItemContainer.localPlayer.pathY[0] >= var36 - var8 && XItemContainer.localPlayer.pathY[0] <= var36 + var8 && Client.field551 != 0 && var30 > 0 && Client.field505 < 50) {
                        Client.field565[Client.field505] = var3;
                        Client.field502[Client.field505] = var30;
                        Client.field537[Client.field505] = var38;
                        Client.field420[Client.field505] = null;
                        Client.field538[Client.field505] = var29 + (var1 << 16) + (var36 << 8);
                        ++Client.field505;
                     }
                  }
               }

               if(Client.packetOpcode != 167) {
                  if(Client.packetOpcode == 94) {
                     var35 = Client.field352.method2758();
                     var1 = Client.field352.method2915();
                     var36 = (var1 >> 4 & 7) + class25.field587;
                     var3 = class138.field1924 + (var1 & 7);
                     var4 = Client.field352.method2751();
                     var29 = var4 >> 2;
                     var30 = var4 & 3;
                     var38 = Client.field356[var29];
                     if(var36 >= 0 && var3 >= 0 && var36 < 104 && var3 < 104) {
                        CollisionData.method2178(class118.plane, var36, var3, var38, var35, var29, var30, 0, -1);
                     }

                  }
               } else {
                  var35 = Client.field352.readUnsignedShort();
                  var1 = Client.field352.method2751();
                  var36 = (var1 >> 4 & 7) + class25.field587;
                  var3 = class138.field1924 + (var1 & 7);
                  if(var36 >= 0 && var3 >= 0 && var36 < 104 && var3 < 104) {
                     Deque var34 = Client.groundItemDeque[class118.plane][var36][var3];
                     if(null != var34) {
                        for(var5 = (Item)var34.method2330(); var5 != null; var5 = (Item)var34.method2346()) {
                           if(var5.id == (var35 & 32767)) {
                              var5.unlink();
                              break;
                           }
                        }

                        if(var34.method2330() == null) {
                           Client.groundItemDeque[class118.plane][var36][var3] = null;
                        }

                        ItemComposition.groundItemSpawned(var36, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-1496347649"
   )
   class55 method1080(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1082.method2274(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1083.method2274(var5);
         if(null == var8) {
            var8 = class54.method951(this.field1084, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1083.method2282(var8, var5);
         }

         var7 = var8.method934(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1082.method2282(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1913392262"
   )
   public class55 method1081(int var1, int[] var2) {
      if(this.field1081.method3205() == 1) {
         return this.method1087(0, var1, var2);
      } else if(this.field1081.method3192(var1) == 1) {
         return this.method1087(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "2143009280"
   )
   public class55 method1082(int var1, int[] var2) {
      if(this.field1084.method3205() == 1) {
         return this.method1080(0, var1, var2);
      } else if(this.field1084.method3192(var1) == 1) {
         return this.method1080(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-1583621863"
   )
   class55 method1087(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1082.method2274(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method921(this.field1081, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method918();
            this.field1082.method2282(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1020.length;
            }

            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1081 = var1;
      this.field1084 = var2;
   }
}
