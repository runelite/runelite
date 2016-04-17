import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("XClanMember")
public class class24 extends class208 {
   @ObfuscatedName("ra")
   protected static String field628;
   @ObfuscatedName("w")
   String field630;
   @ObfuscatedName("c")
   @Export("rank")
   byte field631;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2101058571
   )
   @Export("world")
   int field633;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 44571421
   )
   static int field635;
   @ObfuscatedName("a")
   @Export("username")
   String field637;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1298560497"
   )
   public static void method673() {
      class44.field1042.method3843();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   static int method674() {
      return client.field344?2:1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "1970457626"
   )
   public static void method675(class167 var0) {
      class49.field1101 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;Z[I[II)I",
      garbageValue = "1"
   )
   public static int method676(int var0, int var1, int var2, class107 var3, class108 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class106.field1860[var8][var9] = 0;
            class106.field1862[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var27;
      int var29;
      int var30;
      int var32;
      if(1 == var2) {
         var27 = class90.method2165(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class106.field1860[var12][var13] = 99;
         class106.field1862[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class106.field1866[var16] = var0;
         var32 = var16 + 1;
         class106.field1863[var16] = var1;
         int[][] var18 = var4.field1896;

         boolean var28;
         while(true) {
            if(var17 == var32) {
               field635 = var10;
               class50.field1107 = var11;
               var28 = false;
               break;
            }

            var10 = class106.field1866[var17];
            var11 = class106.field1863[var17];
            var17 = 1 + var17 & 4095;
            var29 = var10 - var14;
            var30 = var11 - var15;
            var19 = var10 - var4.field1892;
            var20 = var11 - var4.field1893;
            if(var3.vmethod2480(2, var10, var11, var4)) {
               field635 = var10;
               class50.field1107 = var11;
               var28 = true;
               break;
            }

            var21 = class106.field1862[var29][var30] + 1;
            if(var29 > 0 && class106.field1860[var29 - 1][var30] == 0 && 0 == (var18[var19 - 1][var20] & 19136782) && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class106.field1866[var32] = var10 - 1;
               class106.field1863[var32] = var11;
               var32 = var32 + 1 & 4095;
               class106.field1860[var29 - 1][var30] = 2;
               class106.field1862[var29 - 1][var30] = var21;
            }

            if(var29 < 126 && class106.field1860[1 + var29][var30] == 0 && 0 == (var18[var19 + 2][var20] & 19136899) && 0 == (var18[var19 + 2][var20 + 1] & 19136992)) {
               class106.field1866[var32] = var10 + 1;
               class106.field1863[var32] = var11;
               var32 = var32 + 1 & 4095;
               class106.field1860[1 + var29][var30] = 8;
               class106.field1862[1 + var29][var30] = var21;
            }

            if(var30 > 0 && 0 == class106.field1860[var29][var30 - 1] && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class106.field1866[var32] = var10;
               class106.field1863[var32] = var11 - 1;
               var32 = var32 + 1 & 4095;
               class106.field1860[var29][var30 - 1] = 1;
               class106.field1862[var29][var30 - 1] = var21;
            }

            if(var30 < 126 && class106.field1860[var29][1 + var30] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][2 + var20] & 19136992) == 0) {
               class106.field1866[var32] = var10;
               class106.field1863[var32] = 1 + var11;
               var32 = 1 + var32 & 4095;
               class106.field1860[var29][var30 + 1] = 4;
               class106.field1862[var29][1 + var30] = var21;
            }

            if(var29 > 0 && var30 > 0 && class106.field1860[var29 - 1][var30 - 1] == 0 && 0 == (var18[var19 - 1][var20] & 19136830) && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class106.field1866[var32] = var10 - 1;
               class106.field1863[var32] = var11 - 1;
               var32 = var32 + 1 & 4095;
               class106.field1860[var29 - 1][var30 - 1] = 3;
               class106.field1862[var29 - 1][var30 - 1] = var21;
            }

            if(var29 < 126 && var30 > 0 && class106.field1860[var29 + 1][var30 - 1] == 0 && 0 == (var18[var19 + 1][var20 - 1] & 19136911) && 0 == (var18[2 + var19][var20 - 1] & 19136899) && 0 == (var18[2 + var19][var20] & 19136995)) {
               class106.field1866[var32] = var10 + 1;
               class106.field1863[var32] = var11 - 1;
               var32 = 1 + var32 & 4095;
               class106.field1860[1 + var29][var30 - 1] = 9;
               class106.field1862[1 + var29][var30 - 1] = var21;
            }

            if(var29 > 0 && var30 < 126 && class106.field1860[var29 - 1][1 + var30] == 0 && 0 == (var18[var19 - 1][1 + var20] & 19136830) && (var18[var19 - 1][2 + var20] & 19136824) == 0 && 0 == (var18[var19][var20 + 2] & 19137016)) {
               class106.field1866[var32] = var10 - 1;
               class106.field1863[var32] = 1 + var11;
               var32 = 1 + var32 & 4095;
               class106.field1860[var29 - 1][1 + var30] = 6;
               class106.field1862[var29 - 1][1 + var30] = var21;
            }

            if(var29 < 126 && var30 < 126 && class106.field1860[1 + var29][1 + var30] == 0 && (var18[1 + var19][2 + var20] & 19137016) == 0 && (var18[2 + var19][var20 + 2] & 19136992) == 0 && (var18[2 + var19][var20 + 1] & 19136995) == 0) {
               class106.field1866[var32] = 1 + var10;
               class106.field1863[var32] = var11 + 1;
               var32 = 1 + var32 & 4095;
               class106.field1860[var29 + 1][1 + var30] = 12;
               class106.field1862[1 + var29][1 + var30] = var21;
            }
         }

         var27 = var28;
      } else {
         var27 = class5.method70(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = field635;
      var29 = class50.field1107;
      if(!var27) {
         var30 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var31 = 10;
         var32 = var3.field1873;
         var17 = var3.field1868;
         int var33 = var3.field1869;
         var19 = var3.field1878;

         for(var20 = var32 - var31; var20 <= var32 + var31; ++var20) {
            for(var21 = var17 - var31; var21 <= var31 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class106.field1862[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var32) {
                     var24 = var32 - var20;
                  } else if(var20 > var32 + var33 - 1) {
                     var24 = var20 - (var32 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var30 || var26 == var30 && class106.field1862[var22][var23] < var14) {
                     var30 = var26;
                     var14 = class106.field1862[var22][var23];
                     var11 = var20;
                     var29 = var21;
                  }
               }
            }
         }

         if(var30 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var29 == var1) {
         return 0;
      } else {
         var13 = 0;
         class106.field1866[var13] = var11;
         var30 = var13 + 1;
         class106.field1863[var13] = var29;

         for(var14 = var15 = class106.field1860[var11 - var9][var29 - var10]; var11 != var0 || var29 != var1; var14 = class106.field1860[var11 - var9][var29 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class106.field1866[var30] = var11;
               class106.field1863[var30++] = var29;
            }

            if(0 != (var14 & 2)) {
               ++var11;
            } else if(0 != (var14 & 8)) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var29;
            } else if(0 != (var14 & 4)) {
               --var29;
            }
         }

         var32 = 0;

         while(var30-- > 0) {
            var6[var32] = class106.field1866[var30];
            var7[var32++] = class106.field1863[var30];
            if(var32 >= var6.length) {
               break;
            }
         }

         return var32;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1615278253"
   )
   static char method677(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}
