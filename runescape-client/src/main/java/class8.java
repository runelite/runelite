import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class8 {
   @ObfuscatedName("m")
   static boolean field85;
   @ObfuscatedName("au")
   static class184 field86;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;IS)V",
      garbageValue = "29845"
   )
   static void method94(class159 var0, int var1) {
      boolean var2 = var0.method2973(1) == 1;
      if(var2) {
         class45.field904[++class45.field901 - 1] = var1;
      }

      int var3 = var0.method2973(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field279 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field898[var1] = (var4.pathY[0] + class103.baseY >> 6) + (var4.field277 << 28) + (class22.baseX + var4.pathX[0] >> 6 << 14);
            if(var4.field632 != -1) {
               class45.field899[var1] = var4.field632;
            } else {
               class45.field899[var1] = var4.field655;
            }

            class45.field900[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2973(1) != 0) {
               class94.method1855(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2973(3);
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
                  var4.field279 = true;
                  var4.field280 = var6;
                  var4.field281 = var7;
               } else {
                  var4.field279 = false;
                  var4.method197(var6, var7, class45.field892[var1]);
               }
            } else {
               var4.method198(var6, var7);
               var4.field279 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2973(4);
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
                  var4.field279 = true;
                  var4.field280 = var6;
                  var4.field281 = var7;
               } else {
                  var4.field279 = false;
                  var4.method197(var6, var7, class45.field892[var1]);
               }
            } else {
               var4.method198(var6, var7);
               var4.field279 = false;
            }

         } else {
            var5 = var0.method2973(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2973(12);
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
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method198(var10, var11);
                  var4.field279 = false;
               } else if(var2) {
                  var4.field279 = true;
                  var4.field280 = var10;
                  var4.field281 = var11;
               } else {
                  var4.field279 = false;
                  var4.method197(var10, var11, class45.field892[var1]);
               }

               var4.field277 = (byte)(var4.field277 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class118.plane = var4.field277;
               }

            } else {
               var6 = var0.method2973(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class22.baseX + var4.pathX[0] & 16383) - class22.baseX;
               var11 = (var4.pathY[0] + class103.baseY + var9 & 16383) - class103.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field279 = true;
                     var4.field280 = var10;
                     var4.field281 = var11;
                  } else {
                     var4.field279 = false;
                     var4.method197(var10, var11, class45.field892[var1]);
                  }
               } else {
                  var4.method198(var10, var11);
                  var4.field279 = false;
               }

               var4.field277 = (byte)(var4.field277 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class118.plane = var4.field277;
               }

            }
         }
      }
   }
}
