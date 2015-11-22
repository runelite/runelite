package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fq")
public class class159 extends class207 {
   @ObfuscatedName("ag")
   String field2588;
   @ObfuscatedName("aj")
   String field2589;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 179172347
   )
   int field2592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 920973171
   )
   int field2595;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 966431039
   )
   int field2598;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -570530499
   )
   int field2599;
   @ObfuscatedName("ak")
   String field2600;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -317153303
   )
   int field2601;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1004247535
   )
   int field2602;
   @ObfuscatedName("h")
   boolean field2603;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1407897903
   )
   int field2604;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -430965297
   )
   int field2606;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1251128055
   )
   int field2607;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2016352209
   )
   int field2608;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1479100585
   )
   int field2610;
   @ObfuscatedName("aq")
   String field2611;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -919287917
   )
   int field2612;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1897058015
   )
   int field2613;
   @ObfuscatedName("az")
   boolean field2614;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -223233747
   )
   int field2615;
   @ObfuscatedName("ah")
   String field2616;
   @ObfuscatedName("ab")
   String field2617;
   @ObfuscatedName("an")
   int[] field2618 = new int[3];
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -369489369
   )
   int field2619;

   @ObfuscatedName("j")
   void method3213() {
      if(this.field2616.length() > 40) {
         this.field2616 = this.field2616.substring(0, 40);
      }

      if(this.field2600.length() > 40) {
         this.field2600 = this.field2600.substring(0, 40);
      }

      if(this.field2588.length() > 10) {
         this.field2588 = this.field2588.substring(0, 10);
      }

      if(this.field2611.length() > 10) {
         this.field2611 = this.field2611.substring(0, 10);
      }

   }

   @ObfuscatedName("m")
   public void method3214(class118 var1) {
      var1.method2521(6);
      var1.method2521(this.field2595);
      var1.method2521(this.field2603?1:0);
      var1.method2521(this.field2598);
      var1.method2521(this.field2599);
      var1.method2521(this.field2592);
      var1.method2521(this.field2601);
      var1.method2521(this.field2602);
      var1.method2521(this.field2614?1:0);
      var1.method2522(this.field2604);
      var1.method2521(this.field2610);
      var1.method2523(this.field2606);
      var1.method2522(this.field2607);
      var1.method2528(this.field2616);
      var1.method2528(this.field2600);
      var1.method2528(this.field2588);
      var1.method2528(this.field2611);
      var1.method2521(this.field2613);
      var1.method2522(this.field2612);
      var1.method2528(this.field2589);
      var1.method2528(this.field2617);
      var1.method2521(this.field2608);
      var1.method2521(this.field2615);

      for(int var2 = 0; var2 < this.field2618.length; ++var2) {
         var1.method2524(this.field2618[var2]);
      }

      var1.method2524(this.field2619);
   }

   @ObfuscatedName("f")
   public int method3215() {
      byte var1 = 38;
      String var4 = this.field2616;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2600;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2588;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2611;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2589;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2617;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("f")
   public static void method3222() {
      class136 var0 = class136.field2100;
      synchronized(class136.field2100) {
         ++class136.field2094;
         class136.field2109 = class136.field2111;
         class136.field2108 = 0;
         int var1;
         if(class136.field2104 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class136.field2114[var1] = false;
            }

            class136.field2104 = class136.field2103;
         } else {
            while(class136.field2103 != class136.field2104) {
               var1 = class136.field2105[class136.field2103];
               class136.field2103 = 1 + class136.field2103 & 127;
               if(var1 < 0) {
                  class136.field2114[~var1] = false;
               } else {
                  if(!class136.field2114[var1] && class136.field2108 < class136.field2107.length - 1) {
                     class136.field2107[++class136.field2108 - 1] = var1;
                  }

                  class136.field2114[var1] = true;
               }
            }
         }

         class136.field2111 = class136.field2110;
      }
   }

   public class159(boolean var1) {
      if(class1.field29.startsWith("win")) {
         this.field2595 = 1;
      } else if(class1.field29.startsWith("mac")) {
         this.field2595 = 2;
      } else if(class1.field29.startsWith("linux")) {
         this.field2595 = 3;
      } else {
         this.field2595 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var11) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var10) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var9) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field2603 = false;
      } else {
         this.field2603 = true;
      }

      if(1 == this.field2595) {
         if(var3.indexOf("4.0") != -1) {
            this.field2598 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2598 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2598 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2598 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2598 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2598 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2598 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2598 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2598 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2598 = 10;
         }
      } else if(2 == this.field2595) {
         if(var3.indexOf("10.4") != -1) {
            this.field2598 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2598 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2598 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2598 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2598 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2598 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2598 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2599 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2599 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2599 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2599 = 5;
      } else {
         this.field2599 = 4;
      }

      int var6 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2592 = var7;
      var6 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var6;
         }
      } catch (Exception var13) {
         ;
      }

      this.field2601 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var12) {
         ;
      }

      this.field2602 = var7;
      this.field2614 = false;
      this.field2604 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2592 > 3) {
         this.field2610 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2610 = 0;
      }

      this.field2606 = 0;
      if(null == this.field2616) {
         this.field2616 = "";
      }

      if(this.field2600 == null) {
         this.field2600 = "";
      }

      if(null == this.field2588) {
         this.field2588 = "";
      }

      if(null == this.field2611) {
         this.field2611 = "";
      }

      if(null == this.field2589) {
         this.field2589 = "";
      }

      if(this.field2617 == null) {
         this.field2617 = "";
      }

      this.method3213();
   }
}
