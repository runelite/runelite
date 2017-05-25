import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class96 {
   @ObfuscatedName("o")
   static Buffer field1483;
   @ObfuscatedName("u")
   static byte[] field1484;
   @ObfuscatedName("q")
   static byte[] field1485;
   @ObfuscatedName("g")
   static Buffer[] field1486;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 276340127
   )
   static int field1487;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 360925447
   )
   static int field1489;
   @ObfuscatedName("l")
   static int[] field1490;
   @ObfuscatedName("a")
   static int[] field1491;
   @ObfuscatedName("k")
   static int[] field1492;
   @ObfuscatedName("r")
   static int[] field1493;
   @ObfuscatedName("x")
   static int[] field1495;
   @ObfuscatedName("t")
   static int[] field1496;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -381518517
   )
   static int field1499;

   static {
      field1484 = new byte[2048];
      field1485 = new byte[2048];
      field1486 = new Buffer[2048];
      field1489 = 0;
      field1496 = new int[2048];
      field1499 = 0;
      field1490 = new int[2048];
      field1491 = new int[2048];
      field1492 = new int[2048];
      field1493 = new int[2048];
      field1487 = 0;
      field1495 = new int[2048];
      field1483 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-482778162"
   )
   static final void method1809() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var29;
      int var31;
      if(Client.field936 == 130) {
         var0 = Client.secretPacketBuffer2.readUnsignedByte();
         var1 = GroundObject.field1858 + (var0 >> 4 & 7);
         var2 = (var0 & 7) + class242.field3277;
         var3 = var1 + Client.secretPacketBuffer2.readByte();
         var4 = var2 + Client.secretPacketBuffer2.readByte();
         var5 = Client.secretPacketBuffer2.readShort();
         var29 = Client.secretPacketBuffer2.readUnsignedShort();
         var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
         var31 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
         var9 = Client.secretPacketBuffer2.readUnsignedShort();
         var10 = Client.secretPacketBuffer2.readUnsignedShort();
         int var41 = Client.secretPacketBuffer2.readUnsignedByte();
         int var42 = Client.secretPacketBuffer2.readUnsignedByte();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var29 != '\uffff') {
            var1 = var1 * 128 + 64;
            var2 = var2 * 128 + 64;
            var3 = var3 * 128 + 64;
            var4 = var4 * 128 + 64;
            Projectile var13 = new Projectile(var29, Sequence.plane, var1, var2, Ignore.method1119(var1, var2, Sequence.plane) - var7, Client.gameCycle + var9, var10 + Client.gameCycle, var41, var42, var5, var31);
            var13.method1782(var3, var4, Ignore.method1119(var3, var4, Sequence.plane) - var31, var9 + Client.gameCycle);
            Client.projectiles.method3655(var13);
         }

      } else if(Client.field936 == 143) {
         var0 = Client.secretPacketBuffer2.method3260();
         var1 = (var0 >> 4 & 7) + GroundObject.field1858;
         var2 = (var0 & 7) + class242.field3277;
         var3 = Client.secretPacketBuffer2.readUnsignedByte();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var29 = Client.field953[var4];
         var7 = Client.secretPacketBuffer2.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class20.method146(Sequence.plane, var1, var2, var29, var7, var4, var5, 0, -1);
         }

      } else {
         Item var32;
         if(Client.field936 == 103) {
            var0 = Client.secretPacketBuffer2.method3236();
            var1 = Client.secretPacketBuffer2.method3189();
            var2 = Client.secretPacketBuffer2.method3227();
            var3 = (var2 >> 4 & 7) + GroundObject.field1858;
            var4 = class242.field3277 + (var2 & 7);
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var32 = new Item();
               var32.id = var1;
               var32.quantity = var0;
               if(Client.groundItemDeque[Sequence.plane][var3][var4] == null) {
                  Client.groundItemDeque[Sequence.plane][var3][var4] = new Deque();
               }

               Client.groundItemDeque[Sequence.plane][var3][var4].method3655(var32);
               class37.groundItemSpawned(var3, var4);
            }

         } else if(Client.field936 == 74) {
            var0 = Client.secretPacketBuffer2.method3227();
            var1 = GroundObject.field1858 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class242.field3277;
            var3 = Client.secretPacketBuffer2.method3260();
            var4 = var3 >> 2;
            var5 = var3 & 3;
            var29 = Client.field953[var4];
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class20.method146(Sequence.plane, var1, var2, var29, -1, var4, var5, 0, -1);
            }

         } else if(Client.field936 == 239) {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var1 = (var0 >> 4 & 7) + GroundObject.field1858;
            var2 = class242.field3277 + (var0 & 7);
            var3 = Client.secretPacketBuffer2.readUnsignedShort();
            var4 = Client.secretPacketBuffer2.readUnsignedByte();
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = var1 * 128 + 64;
               var2 = var2 * 128 + 64;
               class84 var37 = new class84(var3, Sequence.plane, var1, var2, Ignore.method1119(var1, var2, Sequence.plane) - var4, var5, Client.gameCycle);
               Client.field1023.method3655(var37);
            }

         } else {
            if(Client.field936 == 191) {
               var0 = Client.secretPacketBuffer2.readUnsignedByte();
               var1 = (var0 >> 4 & 7) + GroundObject.field1858;
               var2 = (var0 & 7) + class242.field3277;
               var3 = Client.secretPacketBuffer2.readUnsignedShort();
               var4 = Client.secretPacketBuffer2.readUnsignedByte();
               var5 = var4 >> 4 & 15;
               var29 = var4 & 7;
               var7 = Client.secretPacketBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var31 = var5 + 1;
                  if(XGrandExchangeOffer.localPlayer.pathX[0] >= var1 - var31 && XGrandExchangeOffer.localPlayer.pathX[0] <= var1 + var31 && XGrandExchangeOffer.localPlayer.pathY[0] >= var2 - var31 && XGrandExchangeOffer.localPlayer.pathY[0] <= var31 + var2 && Client.field1130 != 0 && var29 > 0 && Client.field1131 < 50) {
                     Client.field1132[Client.field1131] = var3;
                     Client.field1009[Client.field1131] = var29;
                     Client.field1134[Client.field1131] = var7;
                     Client.field1136[Client.field1131] = null;
                     Client.field1135[Client.field1131] = var5 + (var1 << 16) + (var2 << 8);
                     ++Client.field1131;
                  }
               }
            }

            if(Client.field936 == 94) {
               var0 = Client.secretPacketBuffer2.method3245();
               var1 = Client.secretPacketBuffer2.readUnsignedByte();
               var2 = GroundObject.field1858 + (var1 >> 4 & 7);
               var3 = (var1 & 7) + class242.field3277;
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  Deque var33 = Client.groundItemDeque[Sequence.plane][var2][var3];
                  if(var33 != null) {
                     for(var32 = (Item)var33.method3660(); var32 != null; var32 = (Item)var33.method3661()) {
                        if(var32.id == (var0 & 32767)) {
                           var32.unlink();
                           break;
                        }
                     }

                     if(var33.method3660() == null) {
                        Client.groundItemDeque[Sequence.plane][var2][var3] = null;
                     }

                     class37.groundItemSpawned(var2, var3);
                  }
               }

            } else {
               if(Client.field936 == 193) {
                  byte var35 = Client.secretPacketBuffer2.method3230();
                  var1 = Client.secretPacketBuffer2.method3227();
                  var2 = var1 >> 2;
                  var3 = var1 & 3;
                  var4 = Client.field953[var2];
                  byte var36 = Client.secretPacketBuffer2.readByte();
                  var29 = Client.secretPacketBuffer2.method3227();
                  var7 = GroundObject.field1858 + (var29 >> 4 & 7);
                  var31 = class242.field3277 + (var29 & 7);
                  var9 = Client.secretPacketBuffer2.readUnsignedShort();
                  var10 = Client.secretPacketBuffer2.readUnsignedShort();
                  byte var11 = Client.secretPacketBuffer2.method3231();
                  byte var12 = Client.secretPacketBuffer2.method3347();
                  int var34 = Client.secretPacketBuffer2.method3236();
                  int var14 = Client.secretPacketBuffer2.method3245();
                  Player var15;
                  if(var34 == Client.localInteractingIndex) {
                     var15 = XGrandExchangeOffer.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var34];
                  }

                  if(var15 != null) {
                     ObjectComposition var16 = class43.getObjectDefinition(var10);
                     int var17;
                     int var18;
                     if(var3 != 1 && var3 != 3) {
                        var17 = var16.sizeX;
                        var18 = var16.sizeY;
                     } else {
                        var17 = var16.sizeY;
                        var18 = var16.sizeX;
                     }

                     int var19 = var7 + (var17 >> 1);
                     int var20 = (var17 + 1 >> 1) + var7;
                     int var21 = (var18 >> 1) + var31;
                     int var22 = var31 + (var18 + 1 >> 1);
                     int[][] var23 = class61.tileHeights[Sequence.plane];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
                     int var25 = (var17 << 6) + (var7 << 7);
                     int var26 = (var18 << 6) + (var31 << 7);
                     Model var27 = var16.method4585(var2, var3, var23, var25, var24, var26);
                     if(var27 != null) {
                        class20.method146(Sequence.plane, var7, var31, var4, -1, 0, 0, var14 + 1, var9 + 1);
                        var15.totalLevel = Client.gameCycle + var14;
                        var15.field873 = Client.gameCycle + var9;
                        var15.model = var27;
                        var15.field863 = var7 * 128 + var17 * 64;
                        var15.field865 = var18 * 64 + var31 * 128;
                        var15.field864 = var24;
                        byte var28;
                        if(var12 > var11) {
                           var28 = var12;
                           var12 = var11;
                           var11 = var28;
                        }

                        if(var35 > var36) {
                           var28 = var35;
                           var35 = var36;
                           var36 = var28;
                        }

                        var15.field856 = var12 + var7;
                        var15.field869 = var11 + var7;
                        var15.field860 = var35 + var31;
                        var15.field870 = var31 + var36;
                     }
                  }
               }

               if(Client.field936 == 19) {
                  var0 = Client.secretPacketBuffer2.method3227();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field953[var1];
                  var4 = Client.secretPacketBuffer2.method3245();
                  var5 = Client.secretPacketBuffer2.readUnsignedByte();
                  var29 = (var5 >> 4 & 7) + GroundObject.field1858;
                  var7 = (var5 & 7) + class242.field3277;
                  if(var29 >= 0 && var7 >= 0 && var29 < 103 && var7 < 103) {
                     if(var3 == 0) {
                        WallObject var8 = class46.region.method2879(Sequence.plane, var29, var7);
                        if(var8 != null) {
                           var9 = var8.hash >> 14 & 32767;
                           if(var1 == 2) {
                              var8.renderable1 = new class100(var9, 2, var2 + 4, Sequence.plane, var29, var7, var4, false, var8.renderable1);
                              var8.renderable2 = new class100(var9, 2, var2 + 1 & 3, Sequence.plane, var29, var7, var4, false, var8.renderable2);
                           } else {
                              var8.renderable1 = new class100(var9, var1, var2, Sequence.plane, var29, var7, var4, false, var8.renderable1);
                           }
                        }
                     }

                     if(var3 == 1) {
                        DecorativeObject var38 = class46.region.method2730(Sequence.plane, var29, var7);
                        if(var38 != null) {
                           var9 = var38.hash >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var38.renderable1 = new class100(var9, 4, var2 + 4, Sequence.plane, var29, var7, var4, false, var38.renderable1);
                              } else if(var1 == 7) {
                                 var38.renderable1 = new class100(var9, 4, (var2 + 2 & 3) + 4, Sequence.plane, var29, var7, var4, false, var38.renderable1);
                              } else if(var1 == 8) {
                                 var38.renderable1 = new class100(var9, 4, var2 + 4, Sequence.plane, var29, var7, var4, false, var38.renderable1);
                                 var38.renderable2 = new class100(var9, 4, (var2 + 2 & 3) + 4, Sequence.plane, var29, var7, var4, false, var38.renderable2);
                              }
                           } else {
                              var38.renderable1 = new class100(var9, 4, var2, Sequence.plane, var29, var7, var4, false, var38.renderable1);
                           }
                        }
                     }

                     if(var3 == 2) {
                        GameObject var39 = class46.region.method2731(Sequence.plane, var29, var7);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(var39 != null) {
                           var39.renderable = new class100(var39.hash >> 14 & 32767, var1, var2, Sequence.plane, var29, var7, var4, false, var39.renderable);
                        }
                     }

                     if(var3 == 3) {
                        GroundObject var40 = class46.region.method2732(Sequence.plane, var29, var7);
                        if(var40 != null) {
                           var40.renderable = new class100(var40.hash >> 14 & 32767, 22, var2, Sequence.plane, var29, var7, var4, false, var40.renderable);
                        }
                     }
                  }

               } else if(Client.field936 == 178) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + GroundObject.field1858;
                  var2 = class242.field3277 + (var0 & 7);
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var6 = Client.groundItemDeque[Sequence.plane][var1][var2];
                     if(var6 != null) {
                        for(Item var30 = (Item)var6.method3660(); var30 != null; var30 = (Item)var6.method3661()) {
                           if(var30.id == (var3 & 32767) && var30.quantity == var4) {
                              var30.quantity = var5;
                              break;
                           }
                        }

                        class37.groundItemSpawned(var1, var2);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   public static String method1813(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3669[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-1694867897"
   )
   public static Overlay method1819(int var0) {
      Overlay var1 = (Overlay)Overlay.field3590.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3581.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method4742(new Buffer(var2), var0);
         }

         var1.method4748();
         Overlay.field3590.put(var1, (long)var0);
         return var1;
      }
   }
}
