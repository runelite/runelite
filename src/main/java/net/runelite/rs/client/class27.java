package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ao")
public class class27 {
   @ObfuscatedName("ab")
   static class80[] field648;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -158640867
   )
   int field650;
   @ObfuscatedName("m")
   class35[] field656 = new class35[100];

   @ObfuscatedName("r")
   static void method680() {
      client.field287 = 1L;
      client.field550 = -1;
      class161.field2632.field190 = 0;
      class86.field1516 = true;
      client.field291 = true;
      client.field273 = -1L;
      class210.field3116 = new class201();
      client.field318.field1981 = 0;
      client.field320.field1981 = 0;
      client.field446 = -1;
      client.field325 = 1;
      client.field326 = -1;
      client.field327 = -1;
      client.field323 = 0;
      client.field486 = 0;
      client.field400 = 0;
      client.field429 = 0;
      client.field416 = 0;
      client.field500 = false;
      class26.method679(0);
      class11.field171.clear();
      class11.field166.method3853();
      class11.field172.method3898();
      class11.field167 = 0;
      client.field398 = 0;
      client.field546 = false;
      client.field516 = 0;
      client.field522 = (int)(Math.random() * 100.0D) - 50;
      client.field341 = (int)(Math.random() * 110.0D) - 55;
      client.field343 = (int)(Math.random() * 80.0D) - 40;
      client.field346 = (int)(Math.random() * 120.0D) - 60;
      client.field348 = (int)(Math.random() * 30.0D) - 20;
      client.field434 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field510 = 0;
      client.field503 = 1;
      client.field537 = 0;
      client.field294 = 0;
      client.field276 = class20.field559;
      client.field303 = class20.field559;
      client.field314 = 0;
      class32.field733 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class32.field732[var0] = null;
         class32.field731[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         client.field397[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field313[var0] = null;
      }

      client.field406 = -1;
      client.field409.method3865();
      client.field491.method3865();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               client.field407[var0][var1][var2] = null;
            }
         }
      }

      client.field408 = new class198();
      client.field542 = 0;
      client.field541 = 0;
      client.field354 = 0;

      for(var0 = 0; var0 < class52.field1143; ++var0) {
         class52 var3 = class39.method833(var0);
         if(var3 != null) {
            class175.field2887[var0] = 0;
            class175.field2884[var0] = 0;
         }
      }

      class83.field1439.method253();
      client.field463 = -1;
      if(client.field438 != -1) {
         class120.method2780(client.field438);
      }

      for(class3 var4 = (class3)client.field304.method3835(); null != var4; var4 = (class3)client.field304.method3840()) {
         class7.method125(var4, true);
      }

      client.field438 = -1;
      client.field304 = new class195(8);
      client.field545 = null;
      client.field500 = false;
      client.field416 = 0;
      client.field547.method3537((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field328[var0] = null;
         client.field404[var0] = false;
      }

      class15.field216 = new class195(32);
      client.field532 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field370[var0] = true;
      }

      class19.method256();
      client.field501 = null;
      class41.field964 = 0;
      class98.field1667 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field499[var0] = new class219();
      }

      class143.field2193 = null;
   }

   @ObfuscatedName("m")
   class35 method681(int var1) {
      return var1 >= 0 && var1 < this.field650?this.field656[var1]:null;
   }

   @ObfuscatedName("f")
   int method682() {
      return this.field650;
   }

   @ObfuscatedName("l")
   static void method686(class121 var0, int var1) {
      boolean var2 = var0.method2786(1) == 1;
      if(var2) {
         class32.field741[++class32.field740 - 1] = var1;
      }

      int var3 = var0.method2786(2);
      class2 var4 = client.field397[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field54 = false;
         } else if(client.field523 == var1) {
            throw new RuntimeException();
         } else {
            class32.field737[var1] = (class161.field2629 + var4.field816[0] >> 6) + (class47.field1053 + var4.field809[0] >> 6 << 14) + (var4.field56 << 28);
            if(var4.field825 != -1) {
               class32.field738[var1] = var4.field825;
            } else {
               class32.field738[var1] = var4.field848;
            }

            class32.field735[var1] = var4.field823;
            client.field397[var1] = null;
            if(var0.method2786(1) != 0) {
               class12.method184(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2786(3);
            var6 = var4.field809[0];
            var7 = var4.field816[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(1 == var5) {
               --var7;
            } else if(2 == var5) {
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
            } else if(7 == var5) {
               ++var6;
               ++var7;
            }

            if(client.field523 == var1 && (var4.field846 < 1536 || var4.field834 < 1536 || var4.field846 >= 11776 || var4.field834 >= 11776)) {
               var4.method26(var6, var7);
               var4.field54 = false;
            } else if(var2) {
               var4.field54 = true;
               var4.field55 = var6;
               var4.field51 = var7;
            } else {
               var4.field54 = false;
               var4.method32(var6, var7, class32.field731[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2786(4);
            var6 = var4.field809[0];
            var7 = var4.field816[0];
            if(0 == var5) {
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
            } else if(6 == var5) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(9 == var5) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(11 == var5) {
               var6 -= 2;
               var7 += 2;
            } else if(12 == var5) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(14 == var5) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field523 == var1 && (var4.field846 < 1536 || var4.field834 < 1536 || var4.field846 >= 11776 || var4.field834 >= 11776)) {
               var4.method26(var6, var7);
               var4.field54 = false;
            } else if(var2) {
               var4.field54 = true;
               var4.field55 = var6;
               var4.field51 = var7;
            } else {
               var4.field54 = false;
               var4.method32(var6, var7, class32.field731[var1]);
            }

         } else {
            var5 = var0.method2786(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(0 == var5) {
               var6 = var0.method2786(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field809[0] + var8;
               var11 = var9 + var4.field816[0];
               if(client.field523 != var1 || var4.field846 >= 1536 && var4.field834 >= 1536 && var4.field846 < 11776 && var4.field834 < 11776) {
                  if(var2) {
                     var4.field54 = true;
                     var4.field55 = var10;
                     var4.field51 = var11;
                  } else {
                     var4.field54 = false;
                     var4.method32(var10, var11, class32.field731[var1]);
                  }
               } else {
                  var4.method26(var10, var11);
                  var4.field54 = false;
               }

               var4.field56 = (byte)(var4.field56 + var7 & 3);
               if(var1 == client.field523) {
                  class8.field134 = var4.field56;
               }

            } else {
               var6 = var0.method2786(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.field809[0] + class47.field1053 & 16383) - class47.field1053;
               var11 = (var9 + class161.field2629 + var4.field816[0] & 16383) - class161.field2629;
               if(client.field523 != var1 || var4.field846 >= 1536 && var4.field834 >= 1536 && var4.field846 < 11776 && var4.field834 < 11776) {
                  if(var2) {
                     var4.field54 = true;
                     var4.field55 = var10;
                     var4.field51 = var11;
                  } else {
                     var4.field54 = false;
                     var4.method32(var10, var11, class32.field731[var1]);
                  }
               } else {
                  var4.method26(var10, var11);
                  var4.field54 = false;
               }

               var4.field56 = (byte)(var4.field56 + var7 & 3);
               if(client.field523 == var1) {
                  class8.field134 = var4.field56;
               }

            }
         }
      }
   }

   @ObfuscatedName("j")
   class35 method687(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field656[99];

      for(int var6 = this.field650; var6 > 0; --var6) {
         if(100 != var6) {
            this.field656[var6] = this.field656[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3965();
         var5.method3945();
         var5.method776(var1, var2, var4, var3);
      }

      this.field656[0] = var5;
      if(this.field650 < 100) {
         ++this.field650;
      }

      return var5;
   }

   @ObfuscatedName("as")
   static int method688() {
      return client.field426?2:1;
   }
}
