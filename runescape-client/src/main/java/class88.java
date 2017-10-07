import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class88 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("d")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("k")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("98571641d3f8fbc2b7a739b4950a24f4c208c5613743cc37c9e607c38cc2aaf1ea97d88c0469c348e7feca8894d52605671d23bc89ea0b9576fd82a5d1f9f19f1b4c11c3f64091fff0d9f9b029e9ca0d65858bc04573c32a7c8791b1d10b0ba9dc835d5a412c9d52da4368c1e2fd44d27f65c5d1d3792c3a032d47ee19863a39", 16);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1757218756"
   )
   public static int method1780(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1896739801"
   )
   public static int method1777(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class211.field2619[var5 - var4];
      return class211.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfd;IB)V",
      garbageValue = "-1"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1487[++class94.field1486 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field887 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.field1483[var1] = (Varcs.baseY + var4.pathY[0] >> 13) + (var4.field894 << 28) + (WallObject.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1235 != -1) {
               class94.field1475[var1] = var4.field1235;
            } else {
               class94.field1475[var1] = var4.orientation;
            }

            class94.field1481[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               RSSocket.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1173(var6, var7);
               var4.field887 = false;
            } else if(var2) {
               var4.field887 = true;
               var4.field907 = var6;
               var4.field908 = var7;
            } else {
               var4.field887 = false;
               var4.method1168(var6, var7, class94.field1477[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1173(var6, var7);
               var4.field887 = false;
            } else if(var2) {
               var4.field887 = true;
               var4.field907 = var6;
               var4.field908 = var7;
            } else {
               var4.field887 = false;
               var4.method1168(var6, var7, class94.field1477[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field887 = true;
                     var4.field907 = var10;
                     var4.field908 = var11;
                  } else {
                     var4.field887 = false;
                     var4.method1168(var10, var11, class94.field1477[var1]);
                  }
               } else {
                  var4.method1173(var10, var11);
                  var4.field887 = false;
               }

               var4.field894 = (byte)(var7 + var4.field894 & 3);
               if(Client.localInteractingIndex == var1) {
                  class5.plane = var4.field894;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + WallObject.baseX + var4.pathX[0] & 16383) - WallObject.baseX;
               var11 = (var9 + Varcs.baseY + var4.pathY[0] & 16383) - Varcs.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1173(var10, var11);
                  var4.field887 = false;
               } else if(var2) {
                  var4.field887 = true;
                  var4.field907 = var10;
                  var4.field908 = var11;
               } else {
                  var4.field887 = false;
                  var4.method1168(var10, var11, class94.field1477[var1]);
               }

               var4.field894 = (byte)(var7 + var4.field894 & 3);
               if(Client.localInteractingIndex == var1) {
                  class5.plane = var4.field894;
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lcg;",
      garbageValue = "531056121"
   )
   static World method1779() {
      return World.field1284 < World.worldCount?class138.worldList[++World.field1284 - 1]:null;
   }
}
