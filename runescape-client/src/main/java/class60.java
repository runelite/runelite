import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class60 {
   @ObfuscatedName("i")
   IndexDataBase field1101;
   @ObfuscatedName("u")
   XHashTable field1102 = new XHashTable(256);
   @ObfuscatedName("h")
   XHashTable field1103 = new XHashTable(256);
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1356061259
   )
   static int field1104;
   @ObfuscatedName("f")
   IndexDataBase field1108;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-270007527"
   )
   class55 method1172(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1103.method2417(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1013(this.field1108, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1008();
            this.field1103.method2418(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1044.length;
            }

            return var7;
         }
      }
   }

   public class60(IndexDataBase var1, IndexDataBase var2) {
      this.field1108 = var1;
      this.field1101 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "44541103"
   )
   public class55 method1173(int var1, int[] var2) {
      if(this.field1108.method3357() == 1) {
         return this.method1172(0, var1, var2);
      } else if(this.field1108.method3346(var1) == 1) {
         return this.method1172(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1481017047"
   )
   static boolean method1174(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-2052454751"
   )
   class55 method1175(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1103.method2417(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1102.method2417(var5);
         if(var8 == null) {
            var8 = class54.method1026(this.field1101, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1102.method2418(var8, var5);
         }

         var7 = var8.method1028(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1103.method2418(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1763688924"
   )
   public class55 method1178(int var1, int[] var2) {
      if(this.field1101.method3357() == 1) {
         return this.method1175(0, var1, var2);
      } else if(this.field1101.method3346(var1) == 1) {
         return this.method1175(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-11"
   )
   static final void method1179() {
      int var0;
      int var1;
      int var2;
      int var3;
      Item var4;
      int var5;
      if(Client.packetOpcode == 181) {
         var5 = Client.secretCipherBuffer2.readUnsignedByte();
         var0 = class119.field1880 + (var5 >> 4 & 7);
         var1 = MessageNode.field250 + (var5 & 7);
         var2 = Client.secretCipherBuffer2.method2853();
         var3 = Client.secretCipherBuffer2.readUnsignedShort();
         if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
            var4 = new Item();
            var4.id = var3;
            var4.quantity = var2;
            if(Client.groundItemDeque[Sequence.plane][var0][var1] == null) {
               Client.groundItemDeque[Sequence.plane][var0][var1] = new Deque();
            }

            Client.groundItemDeque[Sequence.plane][var0][var1].method2459(var4);
            Client.groundItemSpawned(var0, var1);
         }
      } else {
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         if(Client.packetOpcode == 205) {
            byte var12 = Client.secretCipherBuffer2.method2898();
            var0 = Client.secretCipherBuffer2.method2853();
            var1 = Client.secretCipherBuffer2.readUnsignedByte();
            var2 = var1 >> 2;
            var3 = var1 & 3;
            var10 = Client.field450[var2];
            byte var13 = Client.secretCipherBuffer2.method2898();
            var11 = Client.secretCipherBuffer2.method2853();
            byte var14 = Client.secretCipherBuffer2.method2898();
            var6 = Client.secretCipherBuffer2.method2921();
            var7 = class119.field1880 + (var6 >> 4 & 7);
            var8 = MessageNode.field250 + (var6 & 7);
            var9 = Client.secretCipherBuffer2.method2903();
            int var15 = Client.secretCipherBuffer2.method2904();
            byte var16 = Client.secretCipherBuffer2.method2960();
            Player var17;
            if(var0 == Client.localInteractingIndex) {
               var17 = Projectile.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var0];
            }

            if(var17 != null) {
               ObjectComposition var18 = class140.getObjectDefinition(var15);
               int var19;
               int var20;
               if(var3 != 1 && var3 != 3) {
                  var19 = var18.sizeX;
                  var20 = var18.sizeY;
               } else {
                  var19 = var18.sizeY;
                  var20 = var18.sizeX;
               }

               int var21 = var7 + (var19 >> 1);
               int var22 = (var19 + 1 >> 1) + var7;
               int var23 = (var20 >> 1) + var8;
               int var24 = (var20 + 1 >> 1) + var8;
               int[][] var25 = class10.tileHeights[Sequence.plane];
               int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
               int var27 = (var7 << 7) + (var19 << 6);
               int var28 = (var20 << 6) + (var8 << 7);
               Model var29 = var18.method3644(var2, var3, var25, var27, var26, var28);
               if(var29 != null) {
                  ISAACCipher.method3134(Sequence.plane, var7, var8, var10, -1, 0, 0, var9 + 1, var11 + 1);
                  var17.totalLevel = var9 + Client.gameCycle;
                  var17.field264 = var11 + Client.gameCycle;
                  var17.model = var29;
                  var17.field280 = var7 * 128 + var19 * 64;
                  var17.field267 = var20 * 64 + var8 * 128;
                  var17.field268 = var26;
                  byte var30;
                  if(var16 > var14) {
                     var30 = var16;
                     var16 = var14;
                     var14 = var30;
                  }

                  if(var13 > var12) {
                     var30 = var13;
                     var13 = var12;
                     var12 = var30;
                  }

                  var17.field269 = var16 + var7;
                  var17.field271 = var7 + var14;
                  var17.field270 = var13 + var8;
                  var17.field272 = var8 + var12;
               }
            }
         }

         int var31;
         int var32;
         if(Client.packetOpcode == 162) {
            var5 = Client.secretCipherBuffer2.readUnsignedByte();
            var0 = (var5 >> 4 & 7) + class119.field1880;
            var1 = MessageNode.field250 + (var5 & 7);
            var2 = Client.secretCipherBuffer2.readUnsignedShort();
            var3 = Client.secretCipherBuffer2.readUnsignedByte();
            var10 = var3 >> 4 & 15;
            var31 = var3 & 7;
            var11 = Client.secretCipherBuffer2.readUnsignedByte();
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               var32 = var10 + 1;
               if(Projectile.localPlayer.pathX[0] >= var0 - var32 && Projectile.localPlayer.pathX[0] <= var0 + var32 && Projectile.localPlayer.pathY[0] >= var1 - var32 && Projectile.localPlayer.pathY[0] <= var32 + var1 && Client.field544 != 0 && var31 > 0 && Client.field545 < 50) {
                  Client.field546[Client.field545] = var2;
                  Client.field547[Client.field545] = var31;
                  Client.field334[Client.field545] = var11;
                  Client.field550[Client.field545] = null;
                  Client.field464[Client.field545] = var10 + (var1 << 8) + (var0 << 16);
                  ++Client.field545;
               }
            }
         }

         if(Client.packetOpcode == 12) {
            var5 = Client.secretCipherBuffer2.readUnsignedByte();
            var0 = (var5 >> 4 & 7) + class119.field1880;
            var1 = MessageNode.field250 + (var5 & 7);
            var2 = Client.secretCipherBuffer2.readUnsignedShort();
            var3 = Client.secretCipherBuffer2.readUnsignedByte();
            var10 = Client.secretCipherBuffer2.readUnsignedShort();
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               var0 = var0 * 128 + 64;
               var1 = var1 * 128 + 64;
               class33 var33 = new class33(var2, Sequence.plane, var0, var1, class103.method2025(var0, var1, Sequence.plane) - var3, var10, Client.gameCycle);
               Client.field391.method2459(var33);
            }
         } else {
            Deque var34;
            if(Client.packetOpcode == 77) {
               var5 = Client.secretCipherBuffer2.readUnsignedByte();
               var0 = class119.field1880 + (var5 >> 4 & 7);
               var1 = (var5 & 7) + MessageNode.field250;
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               var3 = Client.secretCipherBuffer2.readUnsignedShort();
               var10 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
                  var34 = Client.groundItemDeque[Sequence.plane][var0][var1];
                  if(var34 != null) {
                     for(Item var35 = (Item)var34.method2464(); var35 != null; var35 = (Item)var34.method2472()) {
                        if((var2 & 32767) == var35.id && var3 == var35.quantity) {
                           var35.quantity = var10;
                           break;
                        }
                     }

                     Client.groundItemSpawned(var0, var1);
                  }
               }
            } else if(Client.packetOpcode == 94) {
               var5 = Client.secretCipherBuffer2.method2903();
               var0 = Client.secretCipherBuffer2.method3015();
               var1 = class119.field1880 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + MessageNode.field250;
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var34 = Client.groundItemDeque[Sequence.plane][var1][var2];
                  if(var34 != null) {
                     for(var4 = (Item)var34.method2464(); var4 != null; var4 = (Item)var34.method2472()) {
                        if(var4.id == (var5 & 32767)) {
                           var4.unlink();
                           break;
                        }
                     }

                     if(var34.method2464() == null) {
                        Client.groundItemDeque[Sequence.plane][var1][var2] = null;
                     }

                     Client.groundItemSpawned(var1, var2);
                  }
               }
            } else if(Client.packetOpcode == 147) {
               var5 = Client.secretCipherBuffer2.method3015();
               var0 = var5 >> 2;
               var1 = var5 & 3;
               var2 = Client.field450[var0];
               var3 = Client.secretCipherBuffer2.method3015();
               var10 = (var3 >> 4 & 7) + class119.field1880;
               var31 = MessageNode.field250 + (var3 & 7);
               if(var10 >= 0 && var31 >= 0 && var10 < 104 && var31 < 104) {
                  ISAACCipher.method3134(Sequence.plane, var10, var31, var2, -1, var0, var1, 0, -1);
               }
            } else if(Client.packetOpcode == 36) {
               var5 = Client.secretCipherBuffer2.readUnsignedShort();
               var0 = Client.secretCipherBuffer2.readUnsignedByte();
               var1 = (var0 >> 4 & 7) + class119.field1880;
               var2 = MessageNode.field250 + (var0 & 7);
               var3 = Client.secretCipherBuffer2.readUnsignedByte();
               var10 = var3 >> 2;
               var31 = var3 & 3;
               var11 = Client.field450[var10];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  ISAACCipher.method3134(Sequence.plane, var1, var2, var11, var5, var10, var31, 0, -1);
               }
            } else if(Client.packetOpcode != 245) {
               if(Client.packetOpcode == 194) {
                  var5 = Client.secretCipherBuffer2.readUnsignedByte();
                  var0 = class119.field1880 + (var5 >> 4 & 7);
                  var1 = MessageNode.field250 + (var5 & 7);
                  var2 = var0 + Client.secretCipherBuffer2.readByte();
                  var3 = var1 + Client.secretCipherBuffer2.readByte();
                  var10 = Client.secretCipherBuffer2.readShort();
                  var31 = Client.secretCipherBuffer2.readUnsignedShort();
                  var11 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
                  var32 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
                  var6 = Client.secretCipherBuffer2.readUnsignedShort();
                  var7 = Client.secretCipherBuffer2.readUnsignedShort();
                  var8 = Client.secretCipherBuffer2.readUnsignedByte();
                  var9 = Client.secretCipherBuffer2.readUnsignedByte();
                  if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104 && var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104 && var31 != '\uffff') {
                     var0 = var0 * 128 + 64;
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     var3 = var3 * 128 + 64;
                     Projectile var36 = new Projectile(var31, Sequence.plane, var0, var1, class103.method2025(var0, var1, Sequence.plane) - var11, Client.gameCycle + var6, Client.gameCycle + var7, var8, var9, var10, var32);
                     var36.method816(var2, var3, class103.method2025(var2, var3, Sequence.plane) - var32, var6 + Client.gameCycle);
                     Client.projectiles.method2459(var36);
                  }
               }
            } else {
               var5 = Client.secretCipherBuffer2.method2921();
               var0 = class119.field1880 + (var5 >> 4 & 7);
               var1 = (var5 & 7) + MessageNode.field250;
               var2 = Client.secretCipherBuffer2.method3051();
               var3 = var2 >> 2;
               var10 = var2 & 3;
               var31 = Client.field450[var3];
               var11 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var0 >= 0 && var1 >= 0 && var0 < 103 && var1 < 103) {
                  if(var31 == 0) {
                     WallObject var37 = CombatInfo1.region.method1837(Sequence.plane, var0, var1);
                     if(var37 != null) {
                        var6 = var37.hash >> 14 & 32767;
                        if(var3 == 2) {
                           var37.renderable1 = new class49(var6, 2, var10 + 4, Sequence.plane, var0, var1, var11, false, var37.renderable1);
                           var37.renderable2 = new class49(var6, 2, var10 + 1 & 3, Sequence.plane, var0, var1, var11, false, var37.renderable2);
                        } else {
                           var37.renderable1 = new class49(var6, var3, var10, Sequence.plane, var0, var1, var11, false, var37.renderable1);
                        }
                     }
                  }

                  if(var31 == 1) {
                     DecorativeObject var38 = CombatInfo1.region.method1759(Sequence.plane, var0, var1);
                     if(var38 != null) {
                        var6 = var38.hash >> 14 & 32767;
                        if(var3 != 4 && var3 != 5) {
                           if(var3 == 6) {
                              var38.renderable1 = new class49(var6, 4, var10 + 4, Sequence.plane, var0, var1, var11, false, var38.renderable1);
                           } else if(var3 == 7) {
                              var38.renderable1 = new class49(var6, 4, (var10 + 2 & 3) + 4, Sequence.plane, var0, var1, var11, false, var38.renderable1);
                           } else if(var3 == 8) {
                              var38.renderable1 = new class49(var6, 4, var10 + 4, Sequence.plane, var0, var1, var11, false, var38.renderable1);
                              var38.renderable2 = new class49(var6, 4, (var10 + 2 & 3) + 4, Sequence.plane, var0, var1, var11, false, var38.renderable2);
                           }
                        } else {
                           var38.renderable1 = new class49(var6, 4, var10, Sequence.plane, var0, var1, var11, false, var38.renderable1);
                        }
                     }
                  }

                  if(var31 == 2) {
                     GameObject var39 = CombatInfo1.region.method1760(Sequence.plane, var0, var1);
                     if(var3 == 11) {
                        var3 = 10;
                     }

                     if(var39 != null) {
                        var39.renderable = new class49(var39.hash >> 14 & 32767, var3, var10, Sequence.plane, var0, var1, var11, false, var39.renderable);
                     }
                  }

                  if(var31 == 3) {
                     GroundObject var40 = CombatInfo1.region.method1761(Sequence.plane, var0, var1);
                     if(var40 != null) {
                        var40.renderable = new class49(var40.hash >> 14 & 32767, 22, var10, Sequence.plane, var0, var1, var11, false, var40.renderable);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   public static boolean method1180() {
      try {
         if(class138.field1940 == 2) {
            if(class138.field1944 == null) {
               class138.field1944 = Track1.method2790(class149.field2061, class138.field1941, RSCanvas.field1777);
               if(class138.field1944 == null) {
                  return false;
               }
            }

            if(XClanMember.field285 == null) {
               XClanMember.field285 = new class60(class138.field1942, class146.field2037);
            }

            if(class138.field1939.method2638(class138.field1944, class138.field1945, XClanMember.field285, 22050)) {
               class138.field1939.method2556();
               class138.field1939.method2564(NPC.field783);
               class138.field1939.method2558(class138.field1944, class138.field1938);
               class138.field1940 = 0;
               class138.field1944 = null;
               XClanMember.field285 = null;
               class149.field2061 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class138.field1939.method2591();
         class138.field1940 = 0;
         class138.field1944 = null;
         XClanMember.field285 = null;
         class149.field2061 = null;
      }

      return false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;IS)Z",
      garbageValue = "-11737"
   )
   static boolean method1182(CipherBuffer var0, int var1) {
      int var2 = var0.method3111(2);
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(var2 == 0) {
         if(var0.method3111(1) != 0) {
            method1182(var0, var1);
         }

         var3 = var0.method3111(13);
         var4 = var0.method3111(13);
         boolean var11 = var0.method3111(1) == 1;
         if(var11) {
            class45.field931[++class45.field930 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var12 = Client.cachedPlayers[var1] = new Player();
            var12.field266 = var1;
            if(class45.field919[var1] != null) {
               var12.method206(class45.field919[var1]);
            }

            var12.field669 = class45.field928[var1];
            var12.interacting = class45.field929[var1];
            var5 = class45.field927[var1];
            var6 = var5 >> 28;
            var7 = var5 >> 14 & 255;
            var8 = var5 & 255;
            var12.field675[0] = class45.field921[var1];
            var12.field276 = (byte)var6;
            var12.method216((var7 << 13) + var3 - class119.baseX, (var8 << 13) + var4 - class187.baseY);
            var12.field259 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3111(2);
         var4 = class45.field927[var1];
         class45.field927[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var9;
         int var10;
         if(var2 == 2) {
            var3 = var0.method3111(5);
            var4 = var3 >> 3;
            var9 = var3 & 7;
            var10 = class45.field927[var1];
            var5 = (var10 >> 28) + var4 & 3;
            var6 = var10 >> 14 & 255;
            var7 = var10 & 255;
            if(var9 == 0) {
               --var6;
               --var7;
            }

            if(var9 == 1) {
               --var7;
            }

            if(var9 == 2) {
               ++var6;
               --var7;
            }

            if(var9 == 3) {
               --var6;
            }

            if(var9 == 4) {
               ++var6;
            }

            if(var9 == 5) {
               --var6;
               ++var7;
            }

            if(var9 == 6) {
               ++var7;
            }

            if(var9 == 7) {
               ++var6;
               ++var7;
            }

            class45.field927[var1] = var7 + (var6 << 14) + (var5 << 28);
            return false;
         } else {
            var3 = var0.method3111(18);
            var4 = var3 >> 16;
            var9 = var3 >> 8 & 255;
            var10 = var3 & 255;
            var5 = class45.field927[var1];
            var6 = (var5 >> 28) + var4 & 3;
            var7 = var9 + (var5 >> 14) & 255;
            var8 = var10 + var5 & 255;
            class45.field927[var1] = var8 + (var7 << 14) + (var6 << 28);
            return false;
         }
      }
   }
}
