import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class1 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field11;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field5;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field7;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field3;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field4;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field0;
   @ObfuscatedName("dy")
   @Export("host")
   static String host;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field6;
   @ObfuscatedName("cm")
   public static char field8;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1534308755
   )
   final int field1;

   static {
      field11 = new class1(0);
      field5 = new class1(1);
      field7 = new class1(3);
      field3 = new class1(4);
      field4 = new class1(2);
      field0 = new class1(6);
      field6 = new class1(5);
   }

   class1(int var1) {
      this.field1 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfy;II)V",
      garbageValue = "-452723443"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class96.field1478[++class96.field1477 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field879 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class96.field1476[var1] = (var4.field881 << 28) + (var4.pathX[0] + class33.baseX >> 13 << 14) + (var4.pathY[0] + class17.baseY >> 13);
            if(var4.field1209 != -1) {
               class96.field1475[var1] = var4.field1209;
            } else {
               class96.field1475[var1] = var4.orientation;
            }

            class96.field1466[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class88.decodeRegionHash(var0, var1);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field879 = true;
                  var4.field868 = var6;
                  var4.field882 = var7;
               } else {
                  var4.field879 = false;
                  var4.method1149(var6, var7, class96.field1467[var1]);
               }
            } else {
               var4.method1169(var6, var7);
               var4.field879 = false;
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
               var4.method1169(var6, var7);
               var4.field879 = false;
            } else if(var2) {
               var4.field879 = true;
               var4.field868 = var6;
               var4.field882 = var7;
            } else {
               var4.field879 = false;
               var4.method1149(var6, var7, class96.field1467[var1]);
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
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1169(var10, var11);
                  var4.field879 = false;
               } else if(var2) {
                  var4.field879 = true;
                  var4.field868 = var10;
                  var4.field882 = var11;
               } else {
                  var4.field879 = false;
                  var4.method1149(var10, var11, class96.field1467[var1]);
               }

               var4.field881 = (byte)(var7 + var4.field881 & 3);
               if(Client.localInteractingIndex == var1) {
                  class8.plane = var4.field881;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class33.baseX & 16383) - class33.baseX;
               var11 = (var9 + var4.pathY[0] + class17.baseY & 16383) - class17.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field879 = true;
                     var4.field868 = var10;
                     var4.field882 = var11;
                  } else {
                     var4.field879 = false;
                     var4.method1149(var10, var11, class96.field1467[var1]);
                  }
               } else {
                  var4.method1169(var10, var11);
                  var4.field879 = false;
               }

               var4.field881 = (byte)(var7 + var4.field881 & 3);
               if(Client.localInteractingIndex == var1) {
                  class8.plane = var4.field881;
               }

            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "-26"
   )
   static int method1(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class214.field2615:class73.field851;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class83.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4013(var4, class83.scriptStringStack[--Timer.scriptStringStackSize]);
            return 1;
         } else {
            --Timer.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class83.intStackSize -= 2;
         var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.dragParent = GZipDecompressor.method3133(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2652 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2709 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2706 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--Timer.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class83.scriptStringStack[--Timer.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
