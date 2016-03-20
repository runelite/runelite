import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class159 extends class207 {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 297538569
   )
   int field2592;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1266954491
   )
   int field2593;
   @ObfuscatedName("aj")
   String field2594;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 856584411
   )
   int field2595;
   @ObfuscatedName("g")
   boolean field2596;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1517876327
   )
   int field2597;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1116441335
   )
   int field2599;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2059924539
   )
   int field2600;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -516317281
   )
   int field2602;
   @ObfuscatedName("ao")
   boolean field2603;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -825417215
   )
   int field2604;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -296944035
   )
   int field2605;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1333330203
   )
   int field2608;
   @ObfuscatedName("ag")
   String field2609;
   @ObfuscatedName("an")
   String field2610;
   @ObfuscatedName("av")
   String field2611;
   @ObfuscatedName("pt")
   static Clipboard field2614;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 20714469
   )
   int field2615;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 846081923
   )
   int field2616;
   @ObfuscatedName("au")
   String field2617;
   @ObfuscatedName("az")
   String field2618;
   @ObfuscatedName("ae")
   int[] field2619 = new int[3];
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -253565649
   )
   int field2620;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1899118357
   )
   int field2621;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 71401623
   )
   int field2622;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-353021718"
   )
   void method3186() {
      if(this.field2609.length() > 40) {
         this.field2609 = this.field2609.substring(0, 40);
      }

      if(this.field2610.length() > 40) {
         this.field2610 = this.field2610.substring(0, 40);
      }

      if(this.field2611.length() > 10) {
         this.field2611 = this.field2611.substring(0, 10);
      }

      if(this.field2594.length() > 10) {
         this.field2594 = this.field2594.substring(0, 10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass118;I)V",
      garbageValue = "1980766002"
   )
   public void method3187(class118 var1) {
      var1.method2497(6);
      var1.method2497(this.field2595);
      var1.method2497(this.field2596?1:0);
      var1.method2497(this.field2597);
      var1.method2497(this.field2599);
      var1.method2497(this.field2600);
      var1.method2497(this.field2592);
      var1.method2497(this.field2602);
      var1.method2497(this.field2603?1:0);
      var1.method2498(this.field2604);
      var1.method2497(this.field2605);
      var1.method2499(this.field2593);
      var1.method2498(this.field2608);
      var1.method2504(this.field2609);
      var1.method2504(this.field2610);
      var1.method2504(this.field2611);
      var1.method2504(this.field2594);
      var1.method2497(this.field2622);
      var1.method2498(this.field2621);
      var1.method2504(this.field2617);
      var1.method2504(this.field2618);
      var1.method2497(this.field2615);
      var1.method2497(this.field2616);

      for(int var2 = 0; var2 < this.field2619.length; ++var2) {
         var1.method2663(this.field2619[var2]);
      }

      var1.method2663(this.field2620);
   }

   @ObfuscatedName("f")
   public int method3188() {
      byte var1 = 38;
      String var4 = this.field2609;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field2610;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2611;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2594;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2617;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2618;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class159(boolean var1) {
      if(class118.field1986.startsWith("win")) {
         this.field2595 = 1;
      } else if(class118.field1986.startsWith("mac")) {
         this.field2595 = 2;
      } else if(class118.field1986.startsWith("linux")) {
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
         this.field2596 = false;
      } else {
         this.field2596 = true;
      }

      if(1 == this.field2595) {
         if(var3.indexOf("4.0") != -1) {
            this.field2597 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2597 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2597 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2597 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2597 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2597 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2597 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2597 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2597 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2597 = 10;
         }
      } else if(2 == this.field2595) {
         if(var3.indexOf("10.4") != -1) {
            this.field2597 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2597 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2597 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2597 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2597 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2597 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2597 = 26;
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

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2600 = var7;
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

      this.field2592 = var7;
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
      this.field2603 = false;
      this.field2604 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2600 > 3) {
         this.field2605 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2605 = 0;
      }

      this.field2593 = 0;
      if(this.field2609 == null) {
         this.field2609 = "";
      }

      if(null == this.field2610) {
         this.field2610 = "";
      }

      if(this.field2611 == null) {
         this.field2611 = "";
      }

      if(this.field2594 == null) {
         this.field2594 = "";
      }

      if(this.field2617 == null) {
         this.field2617 = "";
      }

      if(null == this.field2618) {
         this.field2618 = "";
      }

      this.method3186();
   }
}
