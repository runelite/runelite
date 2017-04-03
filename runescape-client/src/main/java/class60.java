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
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1013(this.field1108, var1, var2);
         if(null == var8) {
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
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1102.method2417(var5);
         if(null == var8) {
            var8 = class54.method1026(this.field1101, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1102.method2418(var8, var5);
         }

         var7 = var8.method1028(var3);
         if(null == var7) {
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
      int var1;
      int var2;
      int var3;
      int var4;
      Item var5;
      int var35;
      if(Client.packetOpcode == 181) {
         var35 = Client.secretCipherBuffer2.readUnsignedByte();
         var1 = class119.field1880 + (var35 >> 4 & 7);
         var2 = MessageNode.field250 + (var35 & 7);
         var3 = Client.secretCipherBuffer2.method2853();
         var4 = Client.secretCipherBuffer2.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var5 = new Item();
            var5.id = var4;
            var5.quantity = var3;
            if(Client.groundItemDeque[Sequence.plane][var1][var2] == null) {
               Client.groundItemDeque[Sequence.plane][var1][var2] = new Deque();
            }

            Client.groundItemDeque[Sequence.plane][var1][var2].method2459(var5);
            Client.groundItemSpawned(var1, var2);
         }

      } else {
         int var9;
         int var10;
         int var11;
         int var12;
         int var29;
         int var31;
         if(Client.packetOpcode == 205) {
            byte var0 = Client.secretCipherBuffer2.method2898();
            var1 = Client.secretCipherBuffer2.method2853();
            var2 = Client.secretCipherBuffer2.readUnsignedByte();
            var3 = var2 >> 2;
            var4 = var2 & 3;
            var29 = Client.field450[var3];
            byte var6 = Client.secretCipherBuffer2.method2898();
            var31 = Client.secretCipherBuffer2.method2853();
            byte var32 = Client.secretCipherBuffer2.method2898();
            var9 = Client.secretCipherBuffer2.method2921();
            var10 = class119.field1880 + (var9 >> 4 & 7);
            var11 = MessageNode.field250 + (var9 & 7);
            var12 = Client.secretCipherBuffer2.method2903();
            int var13 = Client.secretCipherBuffer2.method2904();
            byte var14 = Client.secretCipherBuffer2.method2960();
            Player var15;
            if(var1 == Client.localInteractingIndex) {
               var15 = Projectile.localPlayer;
            } else {
               var15 = Client.cachedPlayers[var1];
            }

            if(var15 != null) {
               ObjectComposition var16 = class140.getObjectDefinition(var13);
               int var17;
               int var18;
               if(var4 != 1 && var4 != 3) {
                  var17 = var16.sizeX;
                  var18 = var16.sizeY;
               } else {
                  var17 = var16.sizeY;
                  var18 = var16.sizeX;
               }

               int var19 = var10 + (var17 >> 1);
               int var20 = (1 + var17 >> 1) + var10;
               int var21 = (var18 >> 1) + var11;
               int var22 = (1 + var18 >> 1) + var11;
               int[][] var23 = class10.tileHeights[Sequence.plane];
               int var24 = var23[var20][var22] + var23[var20][var21] + var23[var19][var21] + var23[var19][var22] >> 2;
               int var25 = (var10 << 7) + (var17 << 6);
               int var26 = (var18 << 6) + (var11 << 7);
               Model var27 = var16.method3644(var3, var4, var23, var25, var24, var26);
               if(var27 != null) {
                  ISAACCipher.method3134(Sequence.plane, var10, var11, var29, -1, 0, 0, 1 + var12, var31 + 1);
                  var15.totalLevel = var12 + Client.gameCycle;
                  var15.field264 = var31 + Client.gameCycle;
                  var15.model = var27;
                  var15.field280 = var10 * 128 + var17 * 64;
                  var15.field267 = var18 * 64 + 128 * var11;
                  var15.field268 = var24;
                  byte var28;
                  if(var14 > var32) {
                     var28 = var14;
                     var14 = var32;
                     var32 = var28;
                  }

                  if(var6 > var0) {
                     var28 = var6;
                     var6 = var0;
                     var0 = var28;
                  }

                  var15.field269 = var14 + var10;
                  var15.field271 = var10 + var32;
                  var15.field270 = var6 + var11;
                  var15.field272 = var11 + var0;
               }
            }
         }

         int var36;
         int var40;
         if(Client.packetOpcode == 162) {
            var35 = Client.secretCipherBuffer2.readUnsignedByte();
            var1 = (var35 >> 4 & 7) + class119.field1880;
            var2 = MessageNode.field250 + (var35 & 7);
            var3 = Client.secretCipherBuffer2.readUnsignedShort();
            var4 = Client.secretCipherBuffer2.readUnsignedByte();
            var29 = var4 >> 4 & 15;
            var36 = var4 & 7;
            var31 = Client.secretCipherBuffer2.readUnsignedByte();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var40 = var29 + 1;
               if(Projectile.localPlayer.pathX[0] >= var1 - var40 && Projectile.localPlayer.pathX[0] <= var1 + var40 && Projectile.localPlayer.pathY[0] >= var2 - var40 && Projectile.localPlayer.pathY[0] <= var40 + var2 && Client.field544 != 0 && var36 > 0 && Client.field545 < 50) {
                  Client.field546[Client.field545] = var3;
                  Client.field547[Client.field545] = var36;
                  Client.field334[Client.field545] = var31;
                  Client.field550[Client.field545] = null;
                  Client.field464[Client.field545] = var29 + (var2 << 8) + (var1 << 16);
                  ++Client.field545;
               }
            }
         }

         if(Client.packetOpcode == 12) {
            var35 = Client.secretCipherBuffer2.readUnsignedByte();
            var1 = (var35 >> 4 & 7) + class119.field1880;
            var2 = MessageNode.field250 + (var35 & 7);
            var3 = Client.secretCipherBuffer2.readUnsignedShort();
            var4 = Client.secretCipherBuffer2.readUnsignedByte();
            var29 = Client.secretCipherBuffer2.readUnsignedShort();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = 64 + var1 * 128;
               var2 = 64 + 128 * var2;
               class33 var41 = new class33(var3, Sequence.plane, var1, var2, class103.method2025(var1, var2, Sequence.plane) - var4, var29, Client.gameCycle);
               Client.field391.method2459(var41);
            }

         } else if(Client.packetOpcode == 77) {
            var35 = Client.secretCipherBuffer2.readUnsignedByte();
            var1 = class119.field1880 + (var35 >> 4 & 7);
            var2 = (var35 & 7) + MessageNode.field250;
            var3 = Client.secretCipherBuffer2.readUnsignedShort();
            var4 = Client.secretCipherBuffer2.readUnsignedShort();
            var29 = Client.secretCipherBuffer2.readUnsignedShort();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var33 = Client.groundItemDeque[Sequence.plane][var1][var2];
               if(var33 != null) {
                  for(Item var7 = (Item)var33.method2464(); var7 != null; var7 = (Item)var33.method2472()) {
                     if((var3 & 32767) == var7.id && var4 == var7.quantity) {
                        var7.quantity = var29;
                        break;
                     }
                  }

                  Client.groundItemSpawned(var1, var2);
               }
            }

         } else if(Client.packetOpcode == 94) {
            var35 = Client.secretCipherBuffer2.method2903();
            var1 = Client.secretCipherBuffer2.method3015();
            var2 = class119.field1880 + (var1 >> 4 & 7);
            var3 = (var1 & 7) + MessageNode.field250;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var30 = Client.groundItemDeque[Sequence.plane][var2][var3];
               if(null != var30) {
                  for(var5 = (Item)var30.method2464(); null != var5; var5 = (Item)var30.method2472()) {
                     if(var5.id == (var35 & 32767)) {
                        var5.unlink();
                        break;
                     }
                  }

                  if(var30.method2464() == null) {
                     Client.groundItemDeque[Sequence.plane][var2][var3] = null;
                  }

                  Client.groundItemSpawned(var2, var3);
               }
            }

         } else if(Client.packetOpcode == 147) {
            var35 = Client.secretCipherBuffer2.method3015();
            var1 = var35 >> 2;
            var2 = var35 & 3;
            var3 = Client.field450[var1];
            var4 = Client.secretCipherBuffer2.method3015();
            var29 = (var4 >> 4 & 7) + class119.field1880;
            var36 = MessageNode.field250 + (var4 & 7);
            if(var29 >= 0 && var36 >= 0 && var29 < 104 && var36 < 104) {
               ISAACCipher.method3134(Sequence.plane, var29, var36, var3, -1, var1, var2, 0, -1);
            }

         } else if(Client.packetOpcode == 36) {
            var35 = Client.secretCipherBuffer2.readUnsignedShort();
            var1 = Client.secretCipherBuffer2.readUnsignedByte();
            var2 = (var1 >> 4 & 7) + class119.field1880;
            var3 = MessageNode.field250 + (var1 & 7);
            var4 = Client.secretCipherBuffer2.readUnsignedByte();
            var29 = var4 >> 2;
            var36 = var4 & 3;
            var31 = Client.field450[var29];
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               ISAACCipher.method3134(Sequence.plane, var2, var3, var31, var35, var29, var36, 0, -1);
            }

         } else if(Client.packetOpcode != 245) {
            if(Client.packetOpcode == 194) {
               var35 = Client.secretCipherBuffer2.readUnsignedByte();
               var1 = class119.field1880 + (var35 >> 4 & 7);
               var2 = MessageNode.field250 + (var35 & 7);
               var3 = var1 + Client.secretCipherBuffer2.readByte();
               var4 = var2 + Client.secretCipherBuffer2.readByte();
               var29 = Client.secretCipherBuffer2.readShort();
               var36 = Client.secretCipherBuffer2.readUnsignedShort();
               var31 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
               var40 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
               var9 = Client.secretCipherBuffer2.readUnsignedShort();
               var10 = Client.secretCipherBuffer2.readUnsignedShort();
               var11 = Client.secretCipherBuffer2.readUnsignedByte();
               var12 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var36 != '\uffff') {
                  var1 = 64 + 128 * var1;
                  var2 = var2 * 128 + 64;
                  var3 = var3 * 128 + 64;
                  var4 = var4 * 128 + 64;
                  Projectile var34 = new Projectile(var36, Sequence.plane, var1, var2, class103.method2025(var1, var2, Sequence.plane) - var31, Client.gameCycle + var9, Client.gameCycle + var10, var11, var12, var29, var40);
                  var34.method816(var3, var4, class103.method2025(var3, var4, Sequence.plane) - var40, var9 + Client.gameCycle);
                  Client.projectiles.method2459(var34);
               }

            }
         } else {
            var35 = Client.secretCipherBuffer2.method2921();
            var1 = class119.field1880 + (var35 >> 4 & 7);
            var2 = (var35 & 7) + MessageNode.field250;
            var3 = Client.secretCipherBuffer2.method3051();
            var4 = var3 >> 2;
            var29 = var3 & 3;
            var36 = Client.field450[var4];
            var31 = Client.secretCipherBuffer2.readUnsignedShort();
            if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
               if(var36 == 0) {
                  WallObject var8 = CombatInfo1.region.method1837(Sequence.plane, var1, var2);
                  if(var8 != null) {
                     var9 = var8.hash >> 14 & 32767;
                     if(var4 == 2) {
                        var8.renderable1 = new class49(var9, 2, var29 + 4, Sequence.plane, var1, var2, var31, false, var8.renderable1);
                        var8.renderable2 = new class49(var9, 2, var29 + 1 & 3, Sequence.plane, var1, var2, var31, false, var8.renderable2);
                     } else {
                        var8.renderable1 = new class49(var9, var4, var29, Sequence.plane, var1, var2, var31, false, var8.renderable1);
                     }
                  }
               }

               if(var36 == 1) {
                  DecorativeObject var37 = CombatInfo1.region.method1759(Sequence.plane, var1, var2);
                  if(var37 != null) {
                     var9 = var37.hash >> 14 & 32767;
                     if(var4 != 4 && var4 != 5) {
                        if(var4 == 6) {
                           var37.renderable1 = new class49(var9, 4, 4 + var29, Sequence.plane, var1, var2, var31, false, var37.renderable1);
                        } else if(var4 == 7) {
                           var37.renderable1 = new class49(var9, 4, (2 + var29 & 3) + 4, Sequence.plane, var1, var2, var31, false, var37.renderable1);
                        } else if(var4 == 8) {
                           var37.renderable1 = new class49(var9, 4, 4 + var29, Sequence.plane, var1, var2, var31, false, var37.renderable1);
                           var37.renderable2 = new class49(var9, 4, 4 + (2 + var29 & 3), Sequence.plane, var1, var2, var31, false, var37.renderable2);
                        }
                     } else {
                        var37.renderable1 = new class49(var9, 4, var29, Sequence.plane, var1, var2, var31, false, var37.renderable1);
                     }
                  }
               }

               if(var36 == 2) {
                  GameObject var38 = CombatInfo1.region.method1760(Sequence.plane, var1, var2);
                  if(var4 == 11) {
                     var4 = 10;
                  }

                  if(var38 != null) {
                     var38.renderable = new class49(var38.hash >> 14 & 32767, var4, var29, Sequence.plane, var1, var2, var31, false, var38.renderable);
                  }
               }

               if(var36 == 3) {
                  GroundObject var39 = CombatInfo1.region.method1761(Sequence.plane, var1, var2);
                  if(var39 != null) {
                     var39.renderable = new class49(var39.hash >> 14 & 32767, 22, var29, Sequence.plane, var1, var2, var31, false, var39.renderable);
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

            if(null == XClanMember.field285) {
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
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3111(1) != 0) {
            method1182(var0, var1);
         }

         var3 = var0.method3111(13);
         var4 = var0.method3111(13);
         boolean var12 = var0.method3111(1) == 1;
         if(var12) {
            class45.field931[++class45.field930 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field266 = var1;
            if(null != class45.field919[var1]) {
               var11.method206(class45.field919[var1]);
            }

            var11.field669 = class45.field928[var1];
            var11.interacting = class45.field929[var1];
            var7 = class45.field927[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field675[0] = class45.field921[var1];
            var11.field276 = (byte)var8;
            var11.method216((var9 << 13) + var3 - class119.baseX, (var10 << 13) + var4 - class187.baseY);
            var11.field259 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3111(2);
         var4 = class45.field927[var1];
         class45.field927[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method3111(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class45.field927[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field927[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method3111(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class45.field927[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var6 + var7 & 255;
            class45.field927[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }
}
