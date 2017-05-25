import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class257 implements class178 {
   @ObfuscatedName("i")
   static final class257 field3536;
   @ObfuscatedName("h")
   static final class257 field3537;
   @ObfuscatedName("u")
   static final class257 field3538;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -480217525
   )
   public final int field3539;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 957979787
   )
   final int field3541;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1591020969
   )
   static int field3542;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3541;
   }

   static {
      field3536 = new class257(1, 0);
      field3537 = new class257(2, 1);
      field3538 = new class257(0, 2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class257(int var1, int var2) {
      this.field3539 = var1;
      this.field3541 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;IB)V",
      garbageValue = "2"
   )
   static void method4698(PacketBuffer var0, int var1) {
      boolean var2 = var0.method3470(1) == 1;
      if(var2) {
         class96.field1495[++class96.field1487 - 1] = var1;
      }

      int var3 = var0.method3470(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field876 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class96.field1491[var1] = (var4.pathY[0] + class146.baseY >> 13) + (var4.field874 << 28) + (class166.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1230 != -1) {
               class96.field1492[var1] = var4.field1230;
            } else {
               class96.field1492[var1] = var4.field1247;
            }

            class96.field1493[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3470(1) != 0) {
               Player.method1166(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3470(3);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field876 = true;
                  var4.field877 = var6;
                  var4.field861 = var7;
               } else {
                  var4.field876 = false;
                  var4.method1145(var6, var7, class96.field1485[var1]);
               }
            } else {
               var4.method1146(var6, var7);
               var4.field876 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3470(4);
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

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1146(var6, var7);
               var4.field876 = false;
            } else if(var2) {
               var4.field876 = true;
               var4.field877 = var6;
               var4.field861 = var7;
            } else {
               var4.field876 = false;
               var4.method1145(var6, var7, class96.field1485[var1]);
            }

         } else {
            var5 = var0.method3470(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3470(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field876 = true;
                     var4.field877 = var10;
                     var4.field861 = var11;
                  } else {
                     var4.field876 = false;
                     var4.method1145(var10, var11, class96.field1485[var1]);
                  }
               } else {
                  var4.method1146(var10, var11);
                  var4.field876 = false;
               }

               var4.field874 = (byte)(var7 + var4.field874 & 3);
               if(Client.localInteractingIndex == var1) {
                  Sequence.plane = var4.field874;
               }

            } else {
               var6 = var0.method3470(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class166.baseX + var4.pathX[0] + var8 & 16383) - class166.baseX;
               var11 = (class146.baseY + var4.pathY[0] + var9 & 16383) - class146.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field876 = true;
                     var4.field877 = var10;
                     var4.field861 = var11;
                  } else {
                     var4.field876 = false;
                     var4.method1145(var10, var11, class96.field1485[var1]);
                  }
               } else {
                  var4.method1146(var10, var11);
                  var4.field876 = false;
               }

               var4.field874 = (byte)(var7 + var4.field874 & 3);
               if(var1 == Client.localInteractingIndex) {
                  Sequence.plane = var4.field874;
               }

            }
         }
      }
   }
}
