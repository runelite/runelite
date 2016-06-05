import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class76 {
   @ObfuscatedName("r")
   static int[] field1385;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1995467229
   )
   static int field1386;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1742782457
   )
   static int field1387;
   @ObfuscatedName("h")
   static int[] field1388;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1917249081
   )
   static int field1390;
   @ObfuscatedName("y")
   static int[] field1391;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1821102753
   )
   static int field1392;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1419368529"
   )
   static final void method1629() {
      for(class29 var0 = (class29)client.field446.method3797(); var0 != null; var0 = (class29)client.field446.method3779()) {
         if(class32.field754 == var0.field684 && !var0.field691) {
            if(client.field332 >= var0.field683) {
               var0.method642(client.field330);
               if(var0.field691) {
                  var0.method3870();
               } else {
                  class214.field3161.method1903(var0.field684, var0.field685, var0.field693, var0.field687, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3870();
         }
      }

   }

   @ObfuscatedName("i")
   public static String method1631(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class162.field2674[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "0"
   )
   static final void method1632(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class82.field1440.method4019(var0, 250);
      int var6 = class82.field1440.method3981(var0, 250) * 13;
      class79.method1785(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
      class79.method1772(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class82.field1440.method3985(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class31.method675(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      class99.method2157(var3, var4, var5, var6);
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-118"
   )
   static final void method1635(int var0) {
      class15.method160();
      class84.method1859();
      int var1 = class21.method557(var0).field1171;
      if(var1 != 0) {
         int var2 = class176.field2923[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class91.method2055(0.9D);
               ((class95)class91.field1599).method2138(0.9D);
            }

            if(var2 == 2) {
               class91.method2055(0.8D);
               ((class95)class91.field1599).method2138(0.8D);
            }

            if(var2 == 3) {
               class91.method2055(0.7D);
               ((class95)class91.field1599).method2138(0.7D);
            }

            if(var2 == 4) {
               class91.method2055(0.6D);
               ((class95)class91.field1599).method2138(0.6D);
            }

            class43.method889();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(client.field519 != var3) {
               if(client.field519 == 0 && client.field520 != -1) {
                  class101.method2235(class103.field1783, client.field520, 0, var3, false);
                  client.field521 = false;
               } else if(var3 == 0) {
                  class172.method3364();
                  client.field521 = false;
               } else if(class183.field2981 != 0) {
                  class151.field2286 = var3;
               } else {
                  class183.field2976.method3613(var3);
               }

               client.field519 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field560 = 127;
            }

            if(var2 == 1) {
               client.field560 = 96;
            }

            if(var2 == 2) {
               client.field560 = 64;
            }

            if(var2 == 3) {
               client.field560 = 32;
            }

            if(var2 == 4) {
               client.field560 = 0;
            }
         }

         if(var1 == 5) {
            client.field422 = var2;
         }

         if(var1 == 6) {
            client.field444 = var2;
         }

         if(var1 == 9) {
            client.field450 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field374 = 127;
            }

            if(var2 == 1) {
               client.field374 = 96;
            }

            if(var2 == 2) {
               client.field374 = 64;
            }

            if(var2 == 3) {
               client.field374 = 32;
            }

            if(var2 == 4) {
               client.field374 = 0;
            }
         }

         if(var1 == 17) {
            client.field370 = var2 & '\uffff';
         }

         class20[] var4;
         if(var1 == 18) {
            var4 = new class20[]{class20.field569, class20.field571, class20.field573, class20.field570};
            client.field309 = (class20)class30.method651(var4, var2);
            if(null == client.field309) {
               client.field309 = class20.field569;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field484 = -1;
            } else {
               client.field484 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class20[]{class20.field569, class20.field571, class20.field573, class20.field570};
            client.field458 = (class20)class30.method651(var4, var2);
            if(null == client.field458) {
               client.field458 = class20.field569;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZIZI)I",
      garbageValue = "603312569"
   )
   static int method1636(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class17.method168(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class17.method168(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1616105972"
   )
   static final void method1637(class37 var0) {
      if(var0.field849 == client.field332 || var0.field834 == -1 || var0.field824 != 0 || 1 + var0.field818 > class18.method177(var0.field834).field987[var0.field819]) {
         int var1 = var0.field849 - var0.field848;
         int var2 = client.field332 - var0.field848;
         int var3 = var0.field813 * 128 + var0.field807 * 64;
         int var4 = var0.field807 * 64 + var0.field846 * 128;
         int var5 = var0.field845 * 128 + var0.field807 * 64;
         int var6 = var0.field855 * 128 + var0.field807 * 64;
         var0.field809 = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.field804 = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field860 = 0;
      var0.field831 = var0.field850;
      var0.field805 = var0.field831;
   }
}
