import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class160 extends class208 {
   @ObfuscatedName("aj")
   String field2617;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1441234011
   )
   int field2618;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -2019473545
   )
   int field2619;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 178342119
   )
   int field2623;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -261890369
   )
   int field2624;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 592369831
   )
   int field2625;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -108689297
   )
   int field2626;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 941955399
   )
   int field2627;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1880696061
   )
   int field2628;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1834075513
   )
   int field2629;
   @ObfuscatedName("o")
   boolean field2630;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1639384013
   )
   int field2631;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -107434265
   )
   int field2632;
   @ObfuscatedName("ar")
   String field2635;
   @ObfuscatedName("aw")
   String field2636;
   @ObfuscatedName("at")
   String field2637;
   @ObfuscatedName("as")
   boolean field2638;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1035981147
   )
   int field2639;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1395834373
   )
   int field2640;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 847765965
   )
   int field2641;
   @ObfuscatedName("ak")
   String field2642;
   @ObfuscatedName("av")
   String field2643;
   @ObfuscatedName("az")
   int[] field2644 = new int[3];
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 39466961
   )
   int field2645;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1544912267
   )
   static int field2646;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1430778181"
   )
   public int method3156() {
      byte var1 = 38;
      String var4 = this.field2617;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2635;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2636;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2637;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2642;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2643;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1959765560"
   )
   void method3157() {
      if(this.field2617.length() > 40) {
         this.field2617 = this.field2617.substring(0, 40);
      }

      if(this.field2635.length() > 40) {
         this.field2635 = this.field2635.substring(0, 40);
      }

      if(this.field2636.length() > 10) {
         this.field2636 = this.field2636.substring(0, 10);
      }

      if(this.field2637.length() > 10) {
         this.field2637 = this.field2637.substring(0, 10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2082747066"
   )
   public void method3158(class119 var1) {
      var1.method2477(6);
      var1.method2477(this.field2618);
      var1.method2477(this.field2630?1:0);
      var1.method2477(this.field2623);
      var1.method2477(this.field2624);
      var1.method2477(this.field2626);
      var1.method2477(this.field2627);
      var1.method2477(this.field2628);
      var1.method2477(this.field2638?1:0);
      var1.method2661(this.field2629);
      var1.method2477(this.field2631);
      var1.method2606(this.field2632);
      var1.method2661(this.field2625);
      var1.method2489(this.field2617);
      var1.method2489(this.field2635);
      var1.method2489(this.field2636);
      var1.method2489(this.field2637);
      var1.method2477(this.field2645);
      var1.method2661(this.field2639);
      var1.method2489(this.field2642);
      var1.method2489(this.field2643);
      var1.method2477(this.field2640);
      var1.method2477(this.field2641);

      for(int var2 = 0; var2 < this.field2644.length; ++var2) {
         var1.method2480(this.field2644[var2]);
      }

      var1.method2480(this.field2619);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class149.field2246.startsWith("win")) {
         this.field2618 = 1;
      } else if(class149.field2246.startsWith("mac")) {
         this.field2618 = 2;
      } else if(class149.field2246.startsWith("linux")) {
         this.field2618 = 3;
      } else {
         this.field2618 = 4;
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
         this.field2630 = false;
      } else {
         this.field2630 = true;
      }

      if(this.field2618 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2623 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2623 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2623 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2623 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2623 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2623 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2623 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2623 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2623 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2623 = 10;
         }
      } else if(2 == this.field2618) {
         if(var3.indexOf("10.4") != -1) {
            this.field2623 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2623 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2623 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2623 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2623 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2623 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2623 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2624 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2624 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2624 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2624 = 5;
      } else {
         this.field2624 = 4;
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

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2626 = var7;
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

      this.field2627 = var7;
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

      this.field2628 = var7;
      this.field2638 = false;
      this.field2629 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2626 > 3) {
         this.field2631 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2631 = 0;
      }

      this.field2632 = 0;
      if(this.field2617 == null) {
         this.field2617 = "";
      }

      if(this.field2635 == null) {
         this.field2635 = "";
      }

      if(null == this.field2636) {
         this.field2636 = "";
      }

      if(this.field2637 == null) {
         this.field2637 = "";
      }

      if(this.field2642 == null) {
         this.field2642 = "";
      }

      if(null == this.field2643) {
         this.field2643 = "";
      }

      this.method3157();
   }
}
