import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class37 {
   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-1309667964"
   )
   static void method762(PacketBuffer var0, int var1) {
      boolean var2 = var0.method2645(1) == 1;
      if(var2) {
         class45.field899[++class45.field902 - 1] = var1;
      }

      int var3 = var0.method2645(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field255 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field895[var1] = (class108.baseX + var4.pathX[0] >> 13 << 14) + (var4.field256 << 28) + (var4.pathY[0] + GameEngine.baseY >> 13);
            if(var4.field627 != -1) {
               class45.field900[var1] = var4.field627;
            } else {
               class45.field900[var1] = var4.field650;
            }

            class45.field897[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2645(1) != 0) {
               IndexFile.method2245(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2645(3);
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
                  var4.field255 = true;
                  var4.field246 = var6;
                  var4.field260 = var7;
               } else {
                  var4.field255 = false;
                  var4.method252(var6, var7, class45.field889[var1]);
               }
            } else {
               var4.method236(var6, var7);
               var4.field255 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2645(4);
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
               var4.method236(var6, var7);
               var4.field255 = false;
            } else if(var2) {
               var4.field255 = true;
               var4.field246 = var6;
               var4.field260 = var7;
            } else {
               var4.field255 = false;
               var4.method252(var6, var7, class45.field889[var1]);
            }

         } else {
            var5 = var0.method2645(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2645(12);
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
               var11 = var4.pathY[0] + var9;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field255 = true;
                     var4.field246 = var10;
                     var4.field260 = var11;
                  } else {
                     var4.field255 = false;
                     var4.method252(var10, var11, class45.field889[var1]);
                  }
               } else {
                  var4.method236(var10, var11);
                  var4.field255 = false;
               }

               var4.field256 = (byte)(var7 + var4.field256 & 3);
               if(Client.localInteractingIndex == var1) {
                  Client.plane = var4.field256;
               }

            } else {
               var6 = var0.method2645(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class108.baseX + var4.pathX[0] + var8 & 16383) - class108.baseX;
               var11 = (var4.pathY[0] + GameEngine.baseY + var9 & 16383) - GameEngine.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field255 = true;
                     var4.field246 = var10;
                     var4.field260 = var11;
                  } else {
                     var4.field255 = false;
                     var4.method252(var10, var11, class45.field889[var1]);
                  }
               } else {
                  var4.method236(var10, var11);
                  var4.field255 = false;
               }

               var4.field256 = (byte)(var4.field256 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  Client.plane = var4.field256;
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1493328561"
   )
   public static String method764(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class41.method807(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
