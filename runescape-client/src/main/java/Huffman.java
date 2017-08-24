import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("Huffman")
public class Huffman {
   @ObfuscatedName("u")
   public static String[] field2323;
   @ObfuscatedName("i")
   @Export("masks")
   int[] masks;
   @ObfuscatedName("j")
   @Export("bits")
   byte[] bits;
   @ObfuscatedName("a")
   @Export("keys")
   int[] keys;

   public Huffman(byte[] var1) {
      int var2 = var1.length;
      this.masks = new int[var2];
      this.bits = var1;
      int[] var3 = new int[33];
      this.keys = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.masks[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var8 != var11) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.keys[var10] == 0) {
                     this.keys[var10] = var4;
                  }

                  var10 = this.keys[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.keys.length) {
                  int[] var13 = new int[this.keys.length * 2];

                  for(int var14 = 0; var14 < this.keys.length; ++var14) {
                     var13[var14] = this.keys[var14];
                  }

                  this.keys = var13;
               }

               var12 >>>= 1;
            }

            this.keys[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-1530831239"
   )
   @Export("decompress")
   public int decompress(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "-89"
   )
   @Export("compress")
   public int compress(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.masks[var8];
         byte var10 = this.bits[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lem;II)V",
      garbageValue = "-728290266"
   )
   public static final void method3168(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1939; ++var2) {
         if(var0.field2000[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1983[var3];
            int var7 = Model.field1983[var4];
            int var8 = Model.field1983[var5];
            int var9 = Model.field1970[var3];
            int var10 = Model.field1970[var4];
            int var11 = Model.field1970[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            Area.method4292(var12, var14, var13, var15, -49088);
         }
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   static final void method3170() {
      for(int var0 = 0; var0 < Client.pendingNpcFlagsCount; ++var0) {
         int var1 = Client.pendingNpcFlagsIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretPacketBuffer2.readUnsignedByte();
         if((var3 & 2) != 0) {
            var2.interacting = Client.secretPacketBuffer2.method3309();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.composition = class171.getNpcDefinition(Client.secretPacketBuffer2.method3282());
            var2.field1233 = var2.composition.field3574;
            var2.field1282 = var2.composition.field3575;
            var2.field1268 = var2.composition.field3558;
            var2.field1238 = var2.composition.field3559;
            var2.field1288 = var2.composition.field3560;
            var2.field1230 = var2.composition.field3561;
            var2.idlePoseAnimation = var2.composition.field3555;
            var2.field1253 = var2.composition.field3557;
            var2.field1251 = var2.composition.field3546;
         }

         int var4;
         int var5;
         int var6;
         if((var3 & 16) != 0) {
            var4 = Client.secretPacketBuffer2.method3451();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var4 == var2.animation && var4 != -1) {
               var6 = class216.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field1263 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field1265 = 0;
               }

               if(var6 == 2) {
                  var2.field1265 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class216.getAnimation(var4).forcedPriority >= class216.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field1263 = 0;
               var2.actionAnimationDisable = var5;
               var2.field1265 = 0;
               var2.field1249 = var2.queueSize;
            }
         }

         if((var3 & 1) != 0) {
            var2.graphic = Client.secretPacketBuffer2.method3309();
            var4 = Client.secretPacketBuffer2.method3292();
            var2.field1270 = var4 >> 16;
            var2.graphicsDelay = (var4 & '\uffff') + Client.gameCycle;
            var2.field1267 = 0;
            var2.field1240 = 0;
            if(var2.graphicsDelay > Client.gameCycle) {
               var2.field1267 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         int var7;
         if((var3 & 32) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.method3309();
            var6 = var2.x - (var4 - class149.baseX - class149.baseX) * 64;
            var7 = var2.y - (var5 - class67.baseY - class67.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field1257 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 4) != 0) {
            var2.overhead = Client.secretPacketBuffer2.readString();
            var2.field1245 = 100;
         }

         if((var3 & 64) != 0) {
            var4 = Client.secretPacketBuffer2.method3276();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretPacketBuffer2.getUSmart();
                  if(var6 == 32767) {
                     var6 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var6 != 32766) {
                     var8 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretPacketBuffer2.getUSmart();
                  var2.method1525(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  if(var8 != 32767) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.method3391();
                     int var11 = var8 > 0?Client.secretPacketBuffer2.readUnsignedShortOb1():var10;
                     var2.method1522(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method1527(var7);
                  }
               }
            }
         }
      }

   }
}
