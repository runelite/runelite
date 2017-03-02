import java.awt.Canvas;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class0 implements Comparator {
   @ObfuscatedName("v")
   public static String field1;
   @ObfuscatedName("qm")
   @Export("canvas")
   public static Canvas canvas;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1873431683"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field24 < var2.field24?-1:(var2.field24 == var1.field24?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)[Lclass214;",
      garbageValue = "0"
   )
   public static class214[] method8() {
      return new class214[]{class214.field3172, class214.field3163, class214.field3156, class214.field3159, class214.field3166, class214.field3167, class214.field3164, class214.field3161, class214.field3169, class214.field3165, class214.field3168, class214.field3157, class214.field3170, class214.field3171, class214.field3160};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-369829580"
   )
   public static int method10(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IS)V",
      garbageValue = "22700"
   )
   static void method11(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method664()?1:0;
                     var12 = var8.method664()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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
                     var11 = var0[var5].method664()?1:0;
                     var12 = var8.method664()?1:0;
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

         method11(var0, var1, var6, var3, var4);
         method11(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   static void method13() {
      class225.field3229 = null;
      class155.field2105 = null;
      class172.field2351 = null;
      class225.field3230 = null;
      class225.field3231 = null;
      class225.field3232 = null;
   }
}
