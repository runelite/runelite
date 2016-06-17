import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class16 extends class208 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 609871061
   )
   int field223;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -251472079
   )
   int field224;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1526705375
   )
   int field225;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 348167153
   )
   int field227;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1585206961
   )
   int field228;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = 1175887145
   )
   static int field229;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -733213491
   )
   int field230;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -919625615
   )
   int field231;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -86605347
   )
   int field232;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1573201347
   )
   int field233 = -1;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1229406327
   )
   @Export("menuX")
   static int field234;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 156181071
   )
   int field235;
   @ObfuscatedName("ps")
   static GarbageCollectorMXBean field238;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1111408507
   )
   static int field239;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 360152305
   )
   int field240;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -789328615
   )
   int field241 = 0;

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZB)V",
      garbageValue = "1"
   )
   static void method176(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2763;
      int var5 = var0.field2764;
      if(var0.field2818 == 0) {
         var0.field2763 = var0.field2759;
      } else if(var0.field2818 == 1) {
         var0.field2763 = var1 - var0.field2759;
      } else if(var0.field2818 == 2) {
         var0.field2763 = var1 * var0.field2759 >> 14;
      }

      if(var0.field2756 == 0) {
         var0.field2764 = var0.field2765;
      } else if(var0.field2756 == 1) {
         var0.field2764 = var2 - var0.field2765;
      } else if(var0.field2756 == 2) {
         var0.field2764 = var2 * var0.field2765 >> 14;
      }

      if(var0.field2818 == 4) {
         var0.field2763 = var0.field2821 * var0.field2764 / var0.field2766;
      }

      if(var0.field2756 == 4) {
         var0.field2764 = var0.field2763 * var0.field2766 / var0.field2821;
      }

      if(client.field336 && var0.field2833 == 0) {
         if(var0.field2764 < 5 && var0.field2763 < 5) {
            var0.field2764 = 5;
            var0.field2763 = 5;
         } else {
            if(var0.field2764 <= 0) {
               var0.field2764 = 5;
            }

            if(var0.field2763 <= 0) {
               var0.field2763 = 5;
            }
         }
      }

      if(var0.field2768 == 1337) {
         client.field459 = var0;
      }

      if(var3 && var0.field2857 != null && (var4 != var0.field2763 || var0.field2764 != var5)) {
         class0 var6 = new class0();
         var6.field10 = var0;
         var6.field12 = var0.field2857;
         client.field486.method3819(var6);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "-2085837149"
   )
   static void method177(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
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
                     var11 = var0[var6].field642;
                     var12 = var8.field642;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method627()?1:0;
                     var12 = var8.method627()?1:0;
                  } else {
                     var11 = var0[var6].field636;
                     var12 = var8.field636;
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
                     var11 = var0[var5].field642;
                     var12 = var8.field642;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method627()?1:0;
                     var12 = var8.method627()?1:0;
                  } else {
                     var11 = var0[var5].field636;
                     var12 = var8.field636;
                  }

                  if(var12 != var11) {
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
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method177(var0, var1, var6, var3, var4);
         method177(var0, 1 + var6, var2, var3, var4);
      }

   }
}
