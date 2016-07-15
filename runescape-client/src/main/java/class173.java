import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class173 implements Runnable {
   @ObfuscatedName("e")
   static class202 field2750 = new class202();
   @ObfuscatedName("l")
   static class202 field2751 = new class202();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1708398493
   )
   public static int field2752 = 0;
   @ObfuscatedName("h")
   public static Object field2753 = new Object();

   public void run() {
      try {
         while(true) {
            class202 var2 = field2750;
            class172 var1;
            synchronized(field2750) {
               var1 = (class172)field2750.method3899();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2745 == 0) {
                  var1.field2742.method2981((int)var1.field3161, var1.field2747, var1.field2747.length);
                  var2 = field2750;
                  synchronized(field2750) {
                     var1.method4000();
                  }
               } else if(var1.field2745 == 1) {
                  var1.field2747 = var1.field2742.method2980((int)var1.field3161);
                  var2 = field2750;
                  synchronized(field2750) {
                     field2751.method3895(var1);
                  }
               }

               var14 = field2753;
               synchronized(field2753) {
                  if(field2752 <= 1) {
                     field2752 = 0;
                     field2753.notifyAll();
                     return;
                  }

                  field2752 = 600;
               }
            } else {
               class125.method2881(100L);
               var14 = field2753;
               synchronized(field2753) {
                  if(field2752 <= 1) {
                     field2752 = 0;
                     field2753.notifyAll();
                     return;
                  }

                  --field2752;
               }
            }
         }
      } catch (Exception var13) {
         class46.method1008((String)null, var13);
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "194128844"
   )
   static final void method3472(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class79.field1453.method2029(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var12;
      int var17;
      if(var5 != 0) {
         var6 = class79.field1453.method2039(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class33.field793.field1476;
         var17 = 24624 + 4 * var1 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         class42 var18 = class146.method3102(var12);
         if(var18.field988 != -1) {
            class83 var14 = class51.field1135[var18.field988];
            if(var14 != null) {
               int var15 = (var18.field959 * 4 - var14.field1486) / 2;
               int var16 = (var18.field1000 * 4 - var14.field1489) / 2;
               var14.method1952(var15 + 48 + 4 * var1, var16 + 48 + (104 - var2 - var18.field1000) * 4);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var17] = var9;
                  var10[var17 + 512] = var9;
                  var10[var17 + 1024] = var9;
                  var10[1536 + var17] = var9;
               } else if(var7 == 1) {
                  var10[var17] = var9;
                  var10[1 + var17] = var9;
                  var10[2 + var17] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var17] = var9;
                  var10[512 + 3 + var17] = var9;
                  var10[1024 + 3 + var17] = var9;
                  var10[var17 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var17 + 1536] = var9;
                  var10[1 + 1536 + var17] = var9;
                  var10[1536 + var17 + 2] = var9;
                  var10[var17 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var17] = var9;
               } else if(var7 == 1) {
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var17] = var9;
               } else if(var7 == 3) {
                  var10[var17 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var17] = var9;
                  var10[512 + var17] = var9;
                  var10[var17 + 1024] = var9;
                  var10[var17 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var17] = var9;
                  var10[1 + var17] = var9;
                  var10[var17 + 2] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var17 + 3] = var9;
                  var10[512 + var17 + 3] = var9;
                  var10[1024 + 3 + var17] = var9;
                  var10[3 + var17 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var17] = var9;
                  var10[var17 + 1536 + 1] = var9;
                  var10[var17 + 1536 + 2] = var9;
                  var10[3 + var17 + 1536] = var9;
               }
            }
         }
      }

      var5 = class79.field1453.method2152(var0, var1, var2);
      if(var5 != 0) {
         var6 = class79.field1453.method2039(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class42 var23 = class146.method3102(var9);
         int var13;
         if(var23.field988 != -1) {
            class83 var11 = class51.field1135[var23.field988];
            if(var11 != null) {
               var12 = (var23.field959 * 4 - var11.field1486) / 2;
               var13 = (var23.field1000 * 4 - var11.field1489) / 2;
               var11.method1952(48 + var1 * 4 + var12, 48 + 4 * (104 - var2 - var23.field1000) + var13);
            }
         } else if(var8 == 9) {
            var17 = 15658734;
            if(var5 > 0) {
               var17 = 15597568;
            }

            int[] var19 = class33.field793.field1476;
            var13 = 2048 * (103 - var2) + var1 * 4 + 24624;
            if(var7 != 0 && var7 != 2) {
               var19[var13] = var17;
               var19[1 + var13 + 512] = var17;
               var19[2 + var13 + 1024] = var17;
               var19[3 + var13 + 1536] = var17;
            } else {
               var19[var13 + 1536] = var17;
               var19[var13 + 1024 + 1] = var17;
               var19[2 + var13 + 512] = var17;
               var19[var13 + 3] = var17;
            }
         }
      }

      var5 = class79.field1453.method2165(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class42 var21 = class146.method3102(var6);
         if(var21.field988 != -1) {
            class83 var20 = class51.field1135[var21.field988];
            if(var20 != null) {
               var9 = (var21.field959 * 4 - var20.field1486) / 2;
               int var22 = (var21.field1000 * 4 - var20.field1489) / 2;
               var20.method1952(var9 + 48 + 4 * var1, 48 + (104 - var2 - var21.field1000) * 4 + var22);
            }
         }
      }

   }
}
