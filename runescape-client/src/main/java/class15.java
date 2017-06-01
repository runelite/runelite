import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class15 implements Comparator {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "913367846"
   )
   static int method75(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2407[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "1"
   )
   int method76(class14 var1, class14 var2) {
      return var1.field286.totalQuantity < var2.field286.totalQuantity?-1:(var2.field286.totalQuantity == var1.field286.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method76((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "2062496886"
   )
   static void method79(PacketBuffer var0, int var1) {
      boolean var2 = var0.method3397(1) == 1;
      if(var2) {
         class96.field1517[++class96.field1514 - 1] = var1;
      }

      int var3 = var0.method3397(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field890 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class96.field1511[var1] = (var4.field911 << 28) + (class41.baseX + var4.pathX[0] >> 13 << 14) + (WorldMapType3.baseY + var4.pathY[0] >> 13);
            if(var4.field1270 != -1) {
               class96.field1512[var1] = var4.field1270;
            } else {
               class96.field1512[var1] = var4.field1259;
            }

            class96.field1513[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3397(1) != 0) {
               class51.method759(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3397(3);
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
                  var4.field890 = true;
                  var4.field914 = var6;
                  var4.field915 = var7;
               } else {
                  var4.field890 = false;
                  var4.method1119(var6, var7, class96.field1503[var1]);
               }
            } else {
               var4.method1120(var6, var7);
               var4.field890 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3397(4);
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
                  var4.field890 = true;
                  var4.field914 = var6;
                  var4.field915 = var7;
               } else {
                  var4.field890 = false;
                  var4.method1119(var6, var7, class96.field1503[var1]);
               }
            } else {
               var4.method1120(var6, var7);
               var4.field890 = false;
            }

         } else {
            var5 = var0.method3397(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3397(12);
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
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1120(var10, var11);
                  var4.field890 = false;
               } else if(var2) {
                  var4.field890 = true;
                  var4.field914 = var10;
                  var4.field915 = var11;
               } else {
                  var4.field890 = false;
                  var4.method1119(var10, var11, class96.field1503[var1]);
               }

               var4.field911 = (byte)(var7 + var4.field911 & 3);
               if(Client.localInteractingIndex == var1) {
                  FaceNormal.plane = var4.field911;
               }

            } else {
               var6 = var0.method3397(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class41.baseX + var4.pathX[0] & 16383) - class41.baseX;
               var11 = (var9 + var4.pathY[0] + WorldMapType3.baseY & 16383) - WorldMapType3.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field890 = true;
                     var4.field914 = var10;
                     var4.field915 = var11;
                  } else {
                     var4.field890 = false;
                     var4.method1119(var10, var11, class96.field1503[var1]);
                  }
               } else {
                  var4.method1120(var10, var11);
                  var4.field890 = false;
               }

               var4.field911 = (byte)(var4.field911 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  FaceNormal.plane = var4.field911;
               }

            }
         }
      }
   }
}
