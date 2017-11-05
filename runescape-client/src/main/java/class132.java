import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class132 {
   @ObfuscatedName("w")
   public static boolean field1988;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1821659089
   )
   public static int field1993;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task field1990;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1985377155
   )
   public static int field1986;
   @ObfuscatedName("o")
   public static boolean field1983;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 645147759
   )
   public static int field1981;
   @ObfuscatedName("a")
   public static int[] field1989;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1368271539
   )
   static int field1984;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1617312235
   )
   static int field1987;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1139816195
   )
   static int field1980;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 912514527
   )
   static int field1985;

   static {
      field1988 = false;
      field1993 = 0;
      field1986 = 0;
      field1983 = false;
      field1981 = 0;
      field1989 = new int[1000];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-1742685257"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1486[++class94.field1496 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field886 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.field1493[var1] = (var4.field908 << 28) + (class273.baseY + var4.pathY[0] >> 13) + (class22.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1249 != -1) {
               class94.field1494[var1] = var4.field1249;
            } else {
               class94.field1494[var1] = var4.orientation;
            }

            class94.field1495[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               Huffman.decodeRegionHash(var0, var1);
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
               var4.method1114(var6, var7);
               var4.field886 = false;
            } else if(var2) {
               var4.field886 = true;
               var4.field911 = var6;
               var4.field899 = var7;
            } else {
               var4.field886 = false;
               var4.method1118(var6, var7, class94.field1487[var1]);
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
               var4.method1114(var6, var7);
               var4.field886 = false;
            } else if(var2) {
               var4.field886 = true;
               var4.field911 = var6;
               var4.field899 = var7;
            } else {
               var4.field886 = false;
               var4.method1118(var6, var7, class94.field1487[var1]);
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
                  var4.method1114(var10, var11);
                  var4.field886 = false;
               } else if(var2) {
                  var4.field886 = true;
                  var4.field911 = var10;
                  var4.field899 = var11;
               } else {
                  var4.field886 = false;
                  var4.method1118(var10, var11, class94.field1487[var1]);
               }

               var4.field908 = (byte)(var7 + var4.field908 & 3);
               if(Client.localInteractingIndex == var1) {
                  class46.plane = var4.field908;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class22.baseX + var4.pathX[0] & 16383) - class22.baseX;
               var11 = (var9 + class273.baseY + var4.pathY[0] & 16383) - class273.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field886 = true;
                     var4.field911 = var10;
                     var4.field899 = var11;
                  } else {
                     var4.field886 = false;
                     var4.method1118(var10, var11, class94.field1487[var1]);
                  }
               } else {
                  var4.method1114(var10, var11);
                  var4.field886 = false;
               }

               var4.field908 = (byte)(var7 + var4.field908 & 3);
               if(Client.localInteractingIndex == var1) {
                  class46.plane = var4.field908;
               }

            }
         }
      }
   }
}
