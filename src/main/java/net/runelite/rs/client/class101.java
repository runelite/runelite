package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
public class class101 extends class207 {
   @ObfuscatedName("f")
   int[] field1742;
   @ObfuscatedName("l")
   int[][] field1743;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1292743475
   )
   int field1745;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1792353691
   )
   int field1746;
   @ObfuscatedName("an")
   static class80[] field1748;

   @ObfuscatedName("f")
   static void method2310(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         class25 var8 = var0[var7];
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
                     var11 = var0[var6].field627;
                     var12 = var8.field627;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field629;
                     var12 = var8.field629;
                     if(-1 == var11 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var6].method660()?1:0;
                     var12 = var8.method660()?1:0;
                  } else {
                     var11 = var0[var6].field621;
                     var12 = var8.field621;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field627;
                     var12 = var8.field627;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var5].field629;
                     var12 = var8.field629;
                     if(-1 == var11 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var5].method660()?1:0;
                     var12 = var8.method660()?1:0;
                  } else {
                     var11 = var0[var5].field621;
                     var12 = var8.field621;
                  }

                  if(var12 != var11) {
                     if((1 != var4[var10] || var11 >= var12) && (0 != var4[var10] || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2310(var0, var1, var6, var3, var4);
         method2310(var0, 1 + var6, var2, var3, var4);
      }

   }

   class101(int var1, byte[] var2) {
      this.field1746 = var1;
      class118 var3 = new class118(var2);
      this.field1745 = var3.method2536();
      this.field1742 = new int[this.field1745];
      this.field1743 = new int[this.field1745][];

      int var4;
      for(var4 = 0; var4 < this.field1745; ++var4) {
         this.field1742[var4] = var3.method2536();
      }

      for(var4 = 0; var4 < this.field1745; ++var4) {
         this.field1743[var4] = new int[var3.method2536()];
      }

      for(var4 = 0; var4 < this.field1745; ++var4) {
         for(int var5 = 0; var5 < this.field1743[var4].length; ++var5) {
            this.field1743[var4][var5] = var3.method2536();
         }
      }

   }
}
