import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class160 extends class208 {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -354900119
   )
   int field2597;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1556659137
   )
   int field2598;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 776295087
   )
   int field2600;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 853752161
   )
   int field2601;
   @ObfuscatedName("am")
   String field2606;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 351683553
   )
   int field2608;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -233377431
   )
   int field2612;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -593941303
   )
   int field2613;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1324161709
   )
   int field2614;
   @ObfuscatedName("az")
   boolean field2615;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 950764763
   )
   int field2616;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1654884899
   )
   int field2618;
   @ObfuscatedName("r")
   boolean field2619;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 121712585
   )
   int field2620;
   @ObfuscatedName("au")
   String field2621;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1791753641
   )
   int field2622;
   @ObfuscatedName("aj")
   String field2623;
   @ObfuscatedName("aq")
   String field2624;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 631531451
   )
   int field2625;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1568686319
   )
   int field2626;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 973686379
   )
   int field2628;
   @ObfuscatedName("aa")
   String field2629;
   @ObfuscatedName("av")
   String field2630;
   @ObfuscatedName("aw")
   int[] field2631 = new int[3];

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   void method3271() {
      if(this.field2621.length() > 40) {
         this.field2621 = this.field2621.substring(0, 40);
      }

      if(this.field2606.length() > 40) {
         this.field2606 = this.field2606.substring(0, 40);
      }

      if(this.field2623.length() > 10) {
         this.field2623 = this.field2623.substring(0, 10);
      }

      if(this.field2624.length() > 10) {
         this.field2624 = this.field2624.substring(0, 10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "3"
   )
   public void method3272(class119 var1) {
      var1.method2603(6);
      var1.method2603(this.field2600);
      var1.method2603(this.field2619?1:0);
      var1.method2603(this.field2622);
      var1.method2603(this.field2618);
      var1.method2603(this.field2612);
      var1.method2603(this.field2613);
      var1.method2603(this.field2614);
      var1.method2603(this.field2615?1:0);
      var1.method2599(this.field2608);
      var1.method2603(this.field2601);
      var1.method2675(this.field2597);
      var1.method2599(this.field2616);
      var1.method2605(this.field2621);
      var1.method2605(this.field2606);
      var1.method2605(this.field2623);
      var1.method2605(this.field2624);
      var1.method2603(this.field2626);
      var1.method2599(this.field2598);
      var1.method2605(this.field2629);
      var1.method2605(this.field2630);
      var1.method2603(this.field2625);
      var1.method2603(this.field2628);

      for(int var2 = 0; var2 < this.field2631.length; ++var2) {
         var1.method2786(this.field2631[var2]);
      }

      var1.method2786(this.field2620);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass44;",
      garbageValue = "68"
   )
   public static class44 method3275(int var0) {
      class44 var1 = (class44)class44.field1042.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1039.method3403(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method1013(new class119(var2));
         }

         class44.field1042.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class32.field773.startsWith("win")) {
         this.field2600 = 1;
      } else if(class32.field773.startsWith("mac")) {
         this.field2600 = 2;
      } else if(class32.field773.startsWith("linux")) {
         this.field2600 = 3;
      } else {
         this.field2600 = 4;
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
         this.field2619 = false;
      } else {
         this.field2619 = true;
      }

      if(1 == this.field2600) {
         if(var3.indexOf("4.0") != -1) {
            this.field2622 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2622 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2622 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2622 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2622 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2622 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2622 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2622 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2622 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2622 = 10;
         }
      } else if(2 == this.field2600) {
         if(var3.indexOf("10.4") != -1) {
            this.field2622 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2622 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2622 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2622 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2622 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2622 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2622 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2618 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2618 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2618 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2618 = 5;
      } else {
         this.field2618 = 4;
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

      this.field2612 = var7;
      var6 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var13) {
         ;
      }

      this.field2613 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var12) {
         ;
      }

      this.field2614 = var7;
      this.field2615 = false;
      this.field2608 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2612 > 3) {
         this.field2601 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2601 = 0;
      }

      this.field2597 = 0;
      if(null == this.field2621) {
         this.field2621 = "";
      }

      if(null == this.field2606) {
         this.field2606 = "";
      }

      if(this.field2623 == null) {
         this.field2623 = "";
      }

      if(this.field2624 == null) {
         this.field2624 = "";
      }

      if(null == this.field2629) {
         this.field2629 = "";
      }

      if(null == this.field2630) {
         this.field2630 = "";
      }

      this.method3271();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "1"
   )
   public static boolean method3282(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(45 == var8) {
                  var3 = true;
                  continue;
               }

               if(43 == var8) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-645908565"
   )
   public int method3283() {
      byte var1 = 38;
      String var4 = this.field2621;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field2606;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2623;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2624;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2629;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2630;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
