import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class174 {
   @ObfuscatedName("c")
   public static final boolean[] field2354 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("n")
   public static int[] field2355 = new int[99];

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2355[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   static final void method3260() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      Item var5;
      if(Client.packetOpcode == 193) {
         var0 = Client.secretCipherBuffer2.readUnsignedByte();
         var1 = class215.field3157 + (var0 >> 4 & 7);
         var2 = class39.field802 + (var0 & 7);
         var3 = Client.secretCipherBuffer2.method2419();
         var4 = Client.secretCipherBuffer2.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var5 = new Item();
            var5.id = var4;
            var5.quantity = var3;
            if(Client.groundItemDeque[Client.plane][var1][var2] == null) {
               Client.groundItemDeque[Client.plane][var1][var2] = new Deque();
            }

            Client.groundItemDeque[Client.plane][var1][var2].method2824(var5);
            class40.groundItemSpawned(var1, var2);
         }

      } else {
         int var6;
         int var7;
         int var9;
         int var29;
         if(Client.packetOpcode == 85) {
            var0 = Client.secretCipherBuffer2.method2409();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field345[var1];
            var4 = Client.secretCipherBuffer2.method2410();
            var29 = (var4 >> 4 & 7) + class215.field3157;
            var6 = (var4 & 7) + class39.field802;
            var7 = Client.secretCipherBuffer2.method2420();
            if(var29 >= 0 && var6 >= 0 && var29 < 103 && var6 < 103) {
               if(var3 == 0) {
                  WallObject var8 = class172.region.method1743(Client.plane, var29, var6);
                  if(var8 != null) {
                     var9 = var8.hash >> 14 & 32767;
                     if(var1 == 2) {
                        var8.renderable1 = new class49(var9, 2, var2 + 4, Client.plane, var29, var6, var7, false, var8.renderable1);
                        var8.renderable2 = new class49(var9, 2, var2 + 1 & 3, Client.plane, var29, var6, var7, false, var8.renderable2);
                     } else {
                        var8.renderable1 = new class49(var9, var1, var2, Client.plane, var29, var6, var7, false, var8.renderable1);
                     }
                  }
               }

               if(var3 == 1) {
                  DecorativeObject var37 = class172.region.method1744(Client.plane, var29, var6);
                  if(var37 != null) {
                     var9 = var37.hash >> 14 & 32767;
                     if(var1 != 4 && var1 != 5) {
                        if(var1 == 6) {
                           var37.renderable1 = new class49(var9, 4, var2 + 4, Client.plane, var29, var6, var7, false, var37.renderable1);
                        } else if(var1 == 7) {
                           var37.renderable1 = new class49(var9, 4, (var2 + 2 & 3) + 4, Client.plane, var29, var6, var7, false, var37.renderable1);
                        } else if(var1 == 8) {
                           var37.renderable1 = new class49(var9, 4, var2 + 4, Client.plane, var29, var6, var7, false, var37.renderable1);
                           var37.renderable2 = new class49(var9, 4, (var2 + 2 & 3) + 4, Client.plane, var29, var6, var7, false, var37.renderable2);
                        }
                     } else {
                        var37.renderable1 = new class49(var9, 4, var2, Client.plane, var29, var6, var7, false, var37.renderable1);
                     }
                  }
               }

               if(var3 == 2) {
                  GameObject var38 = class172.region.method1745(Client.plane, var29, var6);
                  if(var1 == 11) {
                     var1 = 10;
                  }

                  if(var38 != null) {
                     var38.renderable = new class49(var38.hash >> 14 & 32767, var1, var2, Client.plane, var29, var6, var7, false, var38.renderable);
                  }
               }

               if(var3 == 3) {
                  GroundObject var39 = class172.region.method1726(Client.plane, var29, var6);
                  if(var39 != null) {
                     var39.renderable = new class49(var39.hash >> 14 & 32767, 22, var2, Client.plane, var29, var6, var7, false, var39.renderable);
                  }
               }
            }

         } else if(Client.packetOpcode == 158) {
            var0 = Client.secretCipherBuffer2.readUnsignedByte();
            var1 = (var0 >> 4 & 7) + class215.field3157;
            var2 = (var0 & 7) + class39.field802;
            var3 = Client.secretCipherBuffer2.readUnsignedShort();
            var4 = Client.secretCipherBuffer2.readUnsignedByte();
            var29 = Client.secretCipherBuffer2.readUnsignedShort();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = var1 * 128 + 64;
               var2 = var2 * 128 + 64;
               class33 var41 = new class33(var3, Client.plane, var1, var2, CombatInfo1.method600(var1, var2, Client.plane) - var4, var29, Client.gameCycle);
               Client.field531.method2824(var41);
            }

         } else if(Client.packetOpcode == 119) {
            var0 = Client.secretCipherBuffer2.method2558();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field345[var1];
            var4 = Client.secretCipherBuffer2.readUnsignedByte();
            var29 = (var4 >> 4 & 7) + class215.field3157;
            var6 = (var4 & 7) + class39.field802;
            var7 = Client.secretCipherBuffer2.method2420();
            if(var29 >= 0 && var6 >= 0 && var29 < 104 && var6 < 104) {
               class20.method212(Client.plane, var29, var6, var3, var7, var1, var2, 0, -1);
            }

         } else {
            int var10;
            int var11;
            int var12;
            int var30;
            if(Client.packetOpcode == 102) {
               var0 = Client.secretCipherBuffer2.readUnsignedByte();
               var1 = class215.field3157 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + class39.field802;
               var3 = var1 + Client.secretCipherBuffer2.readByte();
               var4 = var2 + Client.secretCipherBuffer2.readByte();
               var29 = Client.secretCipherBuffer2.readShort();
               var6 = Client.secretCipherBuffer2.readUnsignedShort();
               var7 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
               var30 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
               var9 = Client.secretCipherBuffer2.readUnsignedShort();
               var10 = Client.secretCipherBuffer2.readUnsignedShort();
               var11 = Client.secretCipherBuffer2.readUnsignedByte();
               var12 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                  var1 = var1 * 128 + 64;
                  var2 = var2 * 128 + 64;
                  var3 = var3 * 128 + 64;
                  var4 = var4 * 128 + 64;
                  Projectile var33 = new Projectile(var6, Client.plane, var1, var2, CombatInfo1.method600(var1, var2, Client.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var29, var30);
                  var33.method818(var3, var4, CombatInfo1.method600(var3, var4, Client.plane) - var30, var9 + Client.gameCycle);
                  Client.projectiles.method2824(var33);
               }

            } else if(Client.packetOpcode == 151) {
               var0 = Client.secretCipherBuffer2.method2409();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = Client.field345[var1];
               var4 = Client.secretCipherBuffer2.readUnsignedByte();
               var29 = class215.field3157 + (var4 >> 4 & 7);
               var6 = (var4 & 7) + class39.field802;
               if(var29 >= 0 && var6 >= 0 && var29 < 104 && var6 < 104) {
                  class20.method212(Client.plane, var29, var6, var3, -1, var1, var2, 0, -1);
               }

            } else {
               if(Client.packetOpcode == 86) {
                  var0 = Client.secretCipherBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + class215.field3157;
                  var2 = (var0 & 7) + class39.field802;
                  var3 = Client.secretCipherBuffer2.readUnsignedShort();
                  var4 = Client.secretCipherBuffer2.readUnsignedByte();
                  var29 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = Client.secretCipherBuffer2.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var30 = var29 + 1;
                     if(class22.localPlayer.pathX[0] >= var1 - var30 && class22.localPlayer.pathX[0] <= var1 + var30 && class22.localPlayer.pathY[0] >= var2 - var30 && class22.localPlayer.pathY[0] <= var2 + var30 && Client.field527 != 0 && var6 > 0 && Client.field528 < 50) {
                        Client.field529[Client.field528] = var3;
                        Client.field530[Client.field528] = var6;
                        Client.field442[Client.field528] = var7;
                        Client.field504[Client.field528] = null;
                        Client.field493[Client.field528] = var29 + (var1 << 16) + (var2 << 8);
                        ++Client.field528;
                     }
                  }
               }

               if(Client.packetOpcode == 97) {
                  var0 = Client.secretCipherBuffer2.readUnsignedByte();
                  var1 = class215.field3157 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class39.field802;
                  var3 = Client.secretCipherBuffer2.method2418();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var31 = Client.groundItemDeque[Client.plane][var1][var2];
                     if(var31 != null) {
                        for(var5 = (Item)var31.method2828(); var5 != null; var5 = (Item)var31.method2830()) {
                           if(var5.id == (var3 & 32767)) {
                              var5.unlink();
                              break;
                           }
                        }

                        if(var31.method2828() == null) {
                           Client.groundItemDeque[Client.plane][var1][var2] = null;
                        }

                        class40.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  if(Client.packetOpcode == 232) {
                     var0 = Client.secretCipherBuffer2.readUnsignedShort();
                     byte var35 = Client.secretCipherBuffer2.method2515();
                     byte var36 = Client.secretCipherBuffer2.readByte();
                     var3 = Client.secretCipherBuffer2.method2558();
                     var4 = var3 >> 2;
                     var29 = var3 & 3;
                     var6 = Client.field345[var4];
                     var7 = Client.secretCipherBuffer2.readUnsignedShort();
                     byte var40 = Client.secretCipherBuffer2.method2412();
                     var9 = Client.secretCipherBuffer2.method2419();
                     var10 = Client.secretCipherBuffer2.method2409();
                     var11 = class215.field3157 + (var10 >> 4 & 7);
                     var12 = class39.field802 + (var10 & 7);
                     byte var13 = Client.secretCipherBuffer2.method2501();
                     int var14 = Client.secretCipherBuffer2.method2418();
                     Player var15;
                     if(var7 == Client.localInteractingIndex) {
                        var15 = class22.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var7];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = class26.getObjectDefinition(var9);
                        int var17;
                        int var18;
                        if(var29 != 1 && var29 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var11 + (var17 >> 1);
                        int var20 = var11 + (var17 + 1 >> 1);
                        int var21 = var12 + (var18 >> 1);
                        int var22 = var12 + (var18 + 1 >> 1);
                        int[][] var23 = class10.tileHeights[Client.plane];
                        int var24 = var23[var20][var22] + var23[var19][var21] + var23[var20][var21] + var23[var19][var22] >> 2;
                        int var25 = (var17 << 6) + (var11 << 7);
                        int var26 = (var18 << 6) + (var12 << 7);
                        Model var27 = var16.method3685(var4, var29, var23, var25, var24, var26);
                        if(var27 != null) {
                           class20.method212(Client.plane, var11, var12, var6, -1, 0, 0, var0 + 1, var14 + 1);
                           var15.totalLevel = var0 + Client.gameCycle;
                           var15.field258 = Client.gameCycle + var14;
                           var15.model = var27;
                           var15.field245 = var17 * 64 + var11 * 128;
                           var15.field247 = var12 * 128 + var18 * 64;
                           var15.field239 = var24;
                           byte var28;
                           if(var40 > var35) {
                              var28 = var40;
                              var40 = var35;
                              var35 = var28;
                           }

                           if(var36 > var13) {
                              var28 = var36;
                              var36 = var13;
                              var13 = var28;
                           }

                           var15.field249 = var40 + var11;
                           var15.field251 = var11 + var35;
                           var15.field252 = var12 + var36;
                           var15.field254 = var13 + var12;
                        }
                     }
                  }

                  if(Client.packetOpcode == 87) {
                     var0 = Client.secretCipherBuffer2.readUnsignedByte();
                     var1 = class215.field3157 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + class39.field802;
                     var3 = Client.secretCipherBuffer2.readUnsignedShort();
                     var4 = Client.secretCipherBuffer2.readUnsignedShort();
                     var29 = Client.secretCipherBuffer2.readUnsignedShort();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        Deque var32 = Client.groundItemDeque[Client.plane][var1][var2];
                        if(var32 != null) {
                           for(Item var34 = (Item)var32.method2828(); var34 != null; var34 = (Item)var32.method2830()) {
                              if(var34.id == (var3 & 32767) && var34.quantity == var4) {
                                 var34.quantity = var29;
                                 break;
                              }
                           }

                           class40.groundItemSpawned(var1, var2);
                        }
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZB)V",
      garbageValue = "50"
   )
   static void method3261(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class183 var8 = (class183)class187.field2772.method2773(var6);
      if(var8 == null) {
         var8 = (class183)class187.field2756.method2773(var6);
         if(var8 == null) {
            var8 = (class183)class187.field2771.method2773(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2851();
                  class187.field2772.method2774(var8, var6);
                  --class187.field2767;
                  ++class187.field2755;
               }

            } else {
               if(!var5) {
                  var8 = (class183)class187.field2761.method2773(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class183();
               var8.field2704 = var0;
               var8.field2707 = var3;
               var8.field2705 = var4;
               if(var5) {
                  class187.field2772.method2774(var8, var6);
                  ++class187.field2755;
               } else {
                  class187.field2758.method2712(var8);
                  class187.field2771.method2774(var8, var6);
                  ++class187.field2767;
               }

            }
         }
      }
   }

   class174() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-277931436"
   )
   static final void method3262() {
      for(int var0 = 0; var0 < Client.field528; ++var0) {
         --Client.field442[var0];
         if(Client.field442[var0] >= -10) {
            SoundEffect var9 = Client.field504[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.method993(class199.field2882, Client.field529[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field442[var0] += var9.method992();
               Client.field504[var0] = var9;
            }

            if(Client.field442[var0] < 0) {
               int var2;
               if(Client.field493[var0] != 0) {
                  int var3 = (Client.field493[var0] & 255) * 128;
                  int var4 = Client.field493[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class22.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field493[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class22.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field442[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field527 / var3;
               } else {
                  var2 = Client.field551;
               }

               if(var2 > 0) {
                  class55 var10 = var9.method991().method1036(class118.field1848);
                  class66 var11 = class66.method1286(var10, 100, var2);
                  var11.method1281(Client.field530[var0] - 1);
                  class114.field1791.method935(var11);
               }

               Client.field442[var0] = -100;
            }
         } else {
            --Client.field528;

            for(int var1 = var0; var1 < Client.field528; ++var1) {
               Client.field529[var1] = Client.field529[var1 + 1];
               Client.field504[var1] = Client.field504[var1 + 1];
               Client.field530[var1] = Client.field530[var1 + 1];
               Client.field442[var1] = Client.field442[var1 + 1];
               Client.field493[var1] = Client.field493[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field525) {
         boolean var12;
         if(class159.field2063 != 0) {
            var12 = true;
         } else {
            var12 = class159.field2066.method2913();
         }

         if(!var12) {
            if(Client.field501 != 0 && Client.field524 != -1) {
               Script.method911(class18.indexTrack1, Client.field524, 0, Client.field501, false);
            }

            Client.field525 = false;
         }
      }

   }
}
