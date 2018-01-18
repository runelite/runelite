import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field1776;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1388982249
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2093213681
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2030736887
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2132089799
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1503278099
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([Lch;II[I[IB)V",
      garbageValue = "-46"
   )
   static void method2558(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1592()?1:0;
                     var12 = var8.method1592()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1592()?1:0;
                     var12 = var8.method1592()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2558(var0, var1, var6, var3, var4);
         method2558(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public static boolean method2559() {
      try {
         if(class214.field2631 == 2) {
            if(class72.field831 == null) {
               class72.field831 = Track1.getMusicFile(class214.field2632, Ignore.field810, class262.field3474);
               if(class72.field831 == null) {
                  return false;
               }
            }

            if(UnitPriceComparator.field299 == null) {
               UnitPriceComparator.field299 = new class111(class214.field2629, class214.field2633);
            }

            if(class214.field2630.method4003(class72.field831, class214.field2635, UnitPriceComparator.field299, 22050)) {
               class214.field2630.method3901();
               class214.field2630.method3898(class35.field477);
               class214.field2630.method3903(class72.field831, class214.field2627);
               class214.field2631 = 0;
               class72.field831 = null;
               UnitPriceComparator.field299 = null;
               class214.field2632 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class214.field2630.method3904();
         class214.field2631 = 0;
         class72.field831 = null;
         UnitPriceComparator.field299 = null;
         class214.field2632 = null;
      }

      return false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-218347175"
   )
   public static boolean method2560(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
