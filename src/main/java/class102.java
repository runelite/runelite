import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("XClanMember")
public class class102 extends class208 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 850591371
   )
   int field1738;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -770933493
   )
   int field1739;
   @ObfuscatedName("s")
   int[][] field1740;
   @ObfuscatedName("f")
   int[] field1742;

   @ObfuscatedName("dt")
   static final void method2310(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field350 + client.field368 & 2047;
         int var8 = class91.field1568[var7];
         int var9 = class91.field1554[var7];
         var8 = 256 * var8 / (256 + client.field352);
         var9 = var9 * 256 / (client.field352 + 256);
         int var10 = var3 * var8 + var2 * var9 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class158.field2596.method1724(4 + var0 + 94 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class150.method3148(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "351422917"
   )
   static final void method2311(int var0) {
      int[] var1 = class141.field2160.field1379;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if(0 == (class5.field80[var0][var5][var3] & 24)) {
               class151.field2250.method1960(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && 0 != (class5.field80[var0 + 1][var5][var3] & 8)) {
               class151.field2250.method1960(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class141.field2160.method1702();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if(0 == (class5.field80[var0][var6][var5] & 24)) {
               class143.method2987(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.field80[1 + var0][var6][var5] & 8) != 0) {
               class143.method2987(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      client.field508 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class151.field2250.method1955(class48.field1063, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class26.method633(var7).field927;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(22 != var8 && 29 != var8 && var8 != 34 && var8 != 36 && 46 != var8 && var8 != 47 && var8 != 48) {
                     int[][] var13 = client.field338[class48.field1063].field1885;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && 0 == (var13[var9 - 1][var10] & 19136776)) {
                           --var9;
                        }

                        if(1 == var15 && var9 < 103 && var9 < 3 + var5 && 0 == (var13[var9 + 1][var10] & 19136896)) {
                           ++var9;
                        }

                        if(2 == var15 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && 0 == (var13[var9][1 + var10] & 19136800)) {
                           ++var10;
                        }
                     }
                  }

                  client.field530[client.field508] = class169.field2704[var8];
                  client.field499[client.field508] = var9;
                  client.field418[client.field508] = var10;
                  ++client.field508;
               }
            }
         }
      }

      class134.field2070.method1674();
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1951471476"
   )
   static final void method2312(int var0, int var1) {
      if(var0 != class5.field100 || class126.field2033 != var1) {
         class5.field100 = var0;
         class126.field2033 = var1;
         class141.method2971(25);
         class123.method2787("Loading - please wait.", true);
         int var2 = class85.field1439;
         int var3 = class6.field128;
         class85.field1439 = (var0 - 6) * 8;
         class6.field128 = (var1 - 6) * 8;
         int var4 = class85.field1439 - var2;
         int var5 = class6.field128 - var3;
         var2 = class85.field1439;
         var3 = class6.field128;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field316[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field842[var8] -= var4;
                  var7.field843[var8] -= var5;
               }

               var7.field804 -= var4 * 128;
               var7.field814 -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field387[var6];
            if(null != var18) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field842[var8] -= var4;
                  var18.field843[var8] -= var5;
               }

               var18.field804 -= var4 * 128;
               var18.field814 -= var5 * 128;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var17; var19 != var12; var12 += var20) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var12 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field410[var16][var12][var13] = client.field410[var16][var14][var15];
                  } else {
                     client.field410[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field411.method3825(); null != var21; var21 = (class16)client.field411.method3827()) {
            var21.field226 -= var4;
            var21.field227 -= var5;
            if(var21.field226 < 0 || var21.field227 < 0 || var21.field226 >= 104 || var21.field227 >= 104) {
               var21.method3913();
            }
         }

         if(client.field432 != 0) {
            client.field432 -= var4;
            client.field513 -= var5;
         }

         client.field383 = 0;
         client.field313 = false;
         client.field507 = -1;
         client.field413.method3819();
         client.field412.method3819();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field338[var13].method2407();
         }

      }
   }

   class102(int var1, byte[] var2) {
      this.field1739 = var1;
      class119 var3 = new class119(var2);
      this.field1738 = var3.method2523();
      this.field1742 = new int[this.field1738];
      this.field1740 = new int[this.field1738][];

      int var4;
      for(var4 = 0; var4 < this.field1738; ++var4) {
         this.field1742[var4] = var3.method2523();
      }

      for(var4 = 0; var4 < this.field1738; ++var4) {
         this.field1740[var4] = new int[var3.method2523()];
      }

      for(var4 = 0; var4 < this.field1738; ++var4) {
         for(int var5 = 0; var5 < this.field1740[var4].length; ++var5) {
            this.field1740[var4][var5] = var3.method2523();
         }
      }

   }

   @ObfuscatedName("cv")
   static final boolean method2313(class173 var0) {
      if(var0.field2887 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2887.length; ++var1) {
            int var2 = class115.method2468(var0, var1);
            int var3 = var0.field2808[var1];
            if(2 == var0.field2887[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2887[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2887[var1]) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
