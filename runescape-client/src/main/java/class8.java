import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class8 {
   @ObfuscatedName("ac")
   static SpritePixels[] field73;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "966242268"
   )
   public static int method89(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;IB)V",
      garbageValue = "121"
   )
   static void method90(CipherBuffer var0, int var1) {
      boolean var2 = var0.method3111(1) == 1;
      if(var2) {
         class45.field931[++class45.field930 - 1] = var1;
      }

      int var3 = var0.method3111(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field259 = false;
         } else {
            if(var1 == Client.localInteractingIndex) {
               throw new RuntimeException();
            }

            class45.field927[var1] = (class119.baseX + var4.pathX[0] >> 13 << 14) + (var4.field276 << 28) + (var4.pathY[0] + class187.baseY >> 13);
            if(var4.field646 != -1) {
               class45.field928[var1] = var4.field646;
            } else {
               class45.field928[var1] = var4.field669;
            }

            class45.field929[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3111(1) != 0) {
               class60.method1182(var0, var1);
            }
         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3111(3);
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

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field259 = true;
                  var4.field263 = var6;
                  var4.field255 = var7;
               } else {
                  var4.field259 = false;
                  var4.method209(var6, var7, class45.field921[var1]);
               }
            } else {
               var4.method216(var6, var7);
               var4.field259 = false;
            }
         } else if(var3 == 2) {
            var5 = var0.method3111(4);
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

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field259 = true;
                  var4.field263 = var6;
                  var4.field255 = var7;
               } else {
                  var4.field259 = false;
                  var4.method209(var6, var7, class45.field921[var1]);
               }
            } else {
               var4.method216(var6, var7);
               var4.field259 = false;
            }
         } else {
            var5 = var0.method3111(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3111(12);
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
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field259 = true;
                     var4.field263 = var10;
                     var4.field255 = var11;
                  } else {
                     var4.field259 = false;
                     var4.method209(var10, var11, class45.field921[var1]);
                  }
               } else {
                  var4.method216(var10, var11);
                  var4.field259 = false;
               }

               var4.field276 = (byte)(var4.field276 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  Sequence.plane = var4.field276;
               }
            } else {
               var6 = var0.method3111(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class119.baseX + var4.pathX[0] & 16383) - class119.baseX;
               var11 = (class187.baseY + var4.pathY[0] + var9 & 16383) - class187.baseY;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method216(var10, var11);
                  var4.field259 = false;
               } else if(var2) {
                  var4.field259 = true;
                  var4.field263 = var10;
                  var4.field255 = var11;
               } else {
                  var4.field259 = false;
                  var4.method209(var10, var11, class45.field921[var1]);
               }

               var4.field276 = (byte)(var7 + var4.field276 & 3);
               if(Client.localInteractingIndex == var1) {
                  Sequence.plane = var4.field276;
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1562550314"
   )
   static final void method91() {
      Region.field1520 = false;
      Client.field306 = false;
   }

   class8() throws Throwable {
      throw new Error();
   }
}
