import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class160 extends class208 {
   @ObfuscatedName("aj")
   boolean field2605;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1769021
   )
   int field2608;
   @ObfuscatedName("g")
   boolean field2609;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 917968943
   )
   int field2613;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1862981727
   )
   int field2614;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 857290885
   )
   int field2615;
   @ObfuscatedName("ac")
   String field2616;
   @ObfuscatedName("ad")
   String field2617;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 359309219
   )
   int field2618;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1498832329
   )
   int field2621;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1450973337
   )
   int field2622;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1183418409
   )
   int field2623;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2096915173
   )
   int field2624;
   @ObfuscatedName("aa")
   String field2625;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -384027411
   )
   int field2626;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2142717547
   )
   int field2628;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1461106043
   )
   int field2629;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1554319139
   )
   int field2630;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1469702381
   )
   int field2631;
   @ObfuscatedName("al")
   String field2632;
   @ObfuscatedName("ak")
   String field2633;
   @ObfuscatedName("as")
   int[] field2634 = new int[3];
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1017546725
   )
   int field2635;
   @ObfuscatedName("an")
   String field2636;

   @ObfuscatedName("e")
   void method3177() {
      if(this.field2617.length() > 40) {
         this.field2617 = this.field2617.substring(0, 40);
      }

      if(this.field2625.length() > 40) {
         this.field2625 = this.field2625.substring(0, 40);
      }

      if(this.field2616.length() > 10) {
         this.field2616 = this.field2616.substring(0, 10);
      }

      if(this.field2636.length() > 10) {
         this.field2636 = this.field2636.substring(0, 10);
      }

   }

   @ObfuscatedName("w")
   public void method3179(class119 var1) {
      var1.method2565(6);
      var1.method2565(this.field2608);
      var1.method2565(this.field2609?1:0);
      var1.method2565(this.field2631);
      var1.method2565(this.field2614);
      var1.method2565(this.field2615);
      var1.method2565(this.field2621);
      var1.method2565(this.field2613);
      var1.method2565(this.field2605?1:0);
      var1.method2713(this.field2624);
      var1.method2565(this.field2622);
      var1.method2510(this.field2630);
      var1.method2713(this.field2623);
      var1.method2515(this.field2617);
      var1.method2515(this.field2625);
      var1.method2515(this.field2616);
      var1.method2515(this.field2636);
      var1.method2565(this.field2629);
      var1.method2713(this.field2628);
      var1.method2515(this.field2632);
      var1.method2515(this.field2633);
      var1.method2565(this.field2618);
      var1.method2565(this.field2626);

      for(int var2 = 0; var2 < this.field2634.length; ++var2) {
         var1.method2617(this.field2634[var2]);
      }

      var1.method2617(this.field2635);
   }

   @ObfuscatedName("f")
   public int method3180() {
      byte var1 = 38;
      String var4 = this.field2617;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field2625;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2616;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2636;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2632;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2633;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("e")
   public static byte method3187(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(8364 == var0) {
         var1 = -128;
      } else if(8218 == var0) {
         var1 = -126;
      } else if(402 == var0) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(8230 == var0) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(8225 == var0) {
         var1 = -121;
      } else if(710 == var0) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(352 == var0) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(8216 == var0) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(8220 == var0) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(8212 == var0) {
         var1 = -105;
      } else if(732 == var0) {
         var1 = -104;
      } else if(8482 == var0) {
         var1 = -103;
      } else if(353 == var0) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(339 == var0) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(376 == var0) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class136.field2083.startsWith("win")) {
         this.field2608 = 1;
      } else if(class136.field2083.startsWith("mac")) {
         this.field2608 = 2;
      } else if(class136.field2083.startsWith("linux")) {
         this.field2608 = 3;
      } else {
         this.field2608 = 4;
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
         this.field2609 = false;
      } else {
         this.field2609 = true;
      }

      if(this.field2608 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2631 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2631 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2631 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2631 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2631 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2631 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2631 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2631 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2631 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2631 = 10;
         }
      } else if(this.field2608 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2631 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2631 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2631 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2631 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2631 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2631 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2631 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2614 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2614 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2614 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2614 = 5;
      } else {
         this.field2614 = 4;
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

      this.field2615 = var7;
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

      this.field2621 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = 10 * var7 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var12) {
         ;
      }

      this.field2613 = var7;
      this.field2605 = false;
      this.field2624 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2615 > 3) {
         this.field2622 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2622 = 0;
      }

      this.field2630 = 0;
      if(null == this.field2617) {
         this.field2617 = "";
      }

      if(null == this.field2625) {
         this.field2625 = "";
      }

      if(this.field2616 == null) {
         this.field2616 = "";
      }

      if(null == this.field2636) {
         this.field2636 = "";
      }

      if(null == this.field2632) {
         this.field2632 = "";
      }

      if(this.field2633 == null) {
         this.field2633 = "";
      }

      this.method3177();
   }
}
