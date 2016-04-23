import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class160 extends class208 {
   @ObfuscatedName("al")
   String field2597;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1893588801
   )
   int field2599;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -943402013
   )
   int field2601;
   @ObfuscatedName("i")
   boolean field2602;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 508936511
   )
   int field2603;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 522012613
   )
   int field2608;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -955340029
   )
   int field2612;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1306131595
   )
   int field2613;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 883130631
   )
   int field2614;
   @ObfuscatedName("ag")
   boolean field2615;
   @ObfuscatedName("ad")
   String field2616;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 795429639
   )
   int field2618;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -924438793
   )
   int field2619;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 526622901
   )
   int field2620;
   @ObfuscatedName("ai")
   String field2621;
   @ObfuscatedName("ae")
   String field2622;
   @ObfuscatedName("at")
   String field2623;
   @ObfuscatedName("ar")
   String field2624;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1785201697
   )
   int field2626;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1673871373
   )
   int field2627;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -40667419
   )
   int field2628;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1060246089
   )
   int field2629;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2054292169
   )
   int field2630;
   @ObfuscatedName("ak")
   int[] field2631 = new int[3];

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1541651094"
   )
   public int method3142() {
      byte var1 = 38;
      String var4 = this.field2621;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2622;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2623;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2624;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2597;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2616;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-423027437"
   )
   public void method3143(class119 var1) {
      var1.method2503(6);
      var1.method2503(this.field2603);
      var1.method2503(this.field2602?1:0);
      var1.method2503(this.field2608);
      var1.method2503(this.field2626);
      var1.method2503(this.field2612);
      var1.method2503(this.field2613);
      var1.method2503(this.field2614);
      var1.method2503(this.field2615?1:0);
      var1.method2486(this.field2629);
      var1.method2503(this.field2628);
      var1.method2487(this.field2619);
      var1.method2486(this.field2620);
      var1.method2492(this.field2621);
      var1.method2492(this.field2622);
      var1.method2492(this.field2623);
      var1.method2492(this.field2624);
      var1.method2503(this.field2630);
      var1.method2486(this.field2599);
      var1.method2492(this.field2597);
      var1.method2492(this.field2616);
      var1.method2503(this.field2627);
      var1.method2503(this.field2601);

      for(int var2 = 0; var2 < this.field2631.length; ++var2) {
         var1.method2488(this.field2631[var2]);
      }

      var1.method2488(this.field2618);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1079562332"
   )
   void method3145() {
      if(this.field2621.length() > 40) {
         this.field2621 = this.field2621.substring(0, 40);
      }

      if(this.field2622.length() > 40) {
         this.field2622 = this.field2622.substring(0, 40);
      }

      if(this.field2623.length() > 10) {
         this.field2623 = this.field2623.substring(0, 10);
      }

      if(this.field2624.length() > 10) {
         this.field2624 = this.field2624.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class11.field176.startsWith("win")) {
         this.field2603 = 1;
      } else if(class11.field176.startsWith("mac")) {
         this.field2603 = 2;
      } else if(class11.field176.startsWith("linux")) {
         this.field2603 = 3;
      } else {
         this.field2603 = 4;
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
         this.field2602 = false;
      } else {
         this.field2602 = true;
      }

      if(1 == this.field2603) {
         if(var3.indexOf("4.0") != -1) {
            this.field2608 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2608 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2608 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2608 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2608 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2608 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2608 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2608 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2608 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2608 = 10;
         }
      } else if(this.field2603 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2608 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2608 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2608 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2608 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2608 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2608 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2608 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2626 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2626 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2626 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2626 = 5;
      } else {
         this.field2626 = 4;
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

            var7 = var8 - 48 + var7 * 10;
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

            var7 = var7 * 10 + (var8 - 48);
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

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var12) {
         ;
      }

      this.field2614 = var7;
      this.field2615 = false;
      this.field2629 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2612 > 3) {
         this.field2628 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2628 = 0;
      }

      this.field2619 = 0;
      if(null == this.field2621) {
         this.field2621 = "";
      }

      if(this.field2622 == null) {
         this.field2622 = "";
      }

      if(this.field2623 == null) {
         this.field2623 = "";
      }

      if(this.field2624 == null) {
         this.field2624 = "";
      }

      if(null == this.field2597) {
         this.field2597 = "";
      }

      if(null == this.field2616) {
         this.field2616 = "";
      }

      this.method3145();
   }
}
