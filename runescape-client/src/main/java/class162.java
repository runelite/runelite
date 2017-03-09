import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class162 {
   @ObfuscatedName("x")
   static final String[][] field2134 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("j")
   static final String[] field2135 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("c")
   static Calendar field2136;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2136 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-113"
   )
   static final int method3122(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var1 / 32 << 7) + (var0 / 4 << 10);
      return var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "17691664"
   )
   static void method3123(class159 var0, int var1) {
      boolean var2 = var0.method3097(1) == 1;
      if(var2) {
         class45.field932[++class45.field919 - 1] = var1;
      }

      int var3 = var0.method3097(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field293 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field928[var1] = (class3.baseY + var4.pathY[0] >> 13) + (var4.pathX[0] + CombatInfoListHolder.baseX >> 13 << 14) + (var4.field291 << 28);
            if(var4.field653 != -1) {
               class45.field929[var1] = var4.field653;
            } else {
               class45.field929[var1] = var4.field676;
            }

            class45.field930[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3097(1) != 0) {
               class15.method201(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3097(3);
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

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method248(var6, var7);
               var4.field293 = false;
            } else if(var2) {
               var4.field293 = true;
               var4.field295 = var6;
               var4.field284 = var7;
            } else {
               var4.field293 = false;
               var4.method247(var6, var7, class45.field935[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method3097(4);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field293 = true;
                  var4.field295 = var6;
                  var4.field284 = var7;
               } else {
                  var4.field293 = false;
                  var4.method247(var6, var7, class45.field935[var1]);
               }
            } else {
               var4.method248(var6, var7);
               var4.field293 = false;
            }

         } else {
            var5 = var0.method3097(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3097(12);
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
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method248(var10, var11);
                  var4.field293 = false;
               } else if(var2) {
                  var4.field293 = true;
                  var4.field295 = var10;
                  var4.field284 = var11;
               } else {
                  var4.field293 = false;
                  var4.method247(var10, var11, class45.field935[var1]);
               }

               var4.field291 = (byte)(var4.field291 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class31.plane = var4.field291;
               }

            } else {
               var6 = var0.method3097(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + CombatInfoListHolder.baseX + var8 & 16383) - CombatInfoListHolder.baseX;
               var11 = (var9 + var4.pathY[0] + class3.baseY & 16383) - class3.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field293 = true;
                     var4.field295 = var10;
                     var4.field284 = var11;
                  } else {
                     var4.field293 = false;
                     var4.method247(var10, var11, class45.field935[var1]);
                  }
               } else {
                  var4.method248(var10, var11);
                  var4.field293 = false;
               }

               var4.field291 = (byte)(var4.field291 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class31.plane = var4.field291;
               }

            }
         }
      }
   }
}
