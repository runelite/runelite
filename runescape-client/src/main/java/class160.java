import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class160 extends class208 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1489441979
   )
   int field2635;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1083161455
   )
   int field2636;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 766063253
   )
   int field2638;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -174389841
   )
   int field2639;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1937277073
   )
   int field2642;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -511886187
   )
   int field2643;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1996878647
   )
   int field2644;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 886923273
   )
   int field2645;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 943536929
   )
   int field2646;
   @ObfuscatedName("ai")
   boolean field2647;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1262944961
   )
   int field2649;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -139330561
   )
   int field2651;
   @ObfuscatedName("aj")
   String field2652;
   @ObfuscatedName("ah")
   String field2653;
   @ObfuscatedName("ae")
   String field2654;
   @ObfuscatedName("aa")
   String field2655;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 114299359
   )
   int field2656;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 440993487
   )
   int field2657;
   @ObfuscatedName("f")
   boolean field2658;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1076955275
   )
   int field2659;
   @ObfuscatedName("az")
   String field2660;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -953891841
   )
   int field2661;
   @ObfuscatedName("ax")
   int[] field2662 = new int[3];
   @ObfuscatedName("af")
   String field2663;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-114093166"
   )
   void method3148() {
      if(this.field2652.length() > 40) {
         this.field2652 = this.field2652.substring(0, 40);
      }

      if(this.field2653.length() > 40) {
         this.field2653 = this.field2653.substring(0, 40);
      }

      if(this.field2654.length() > 10) {
         this.field2654 = this.field2654.substring(0, 10);
      }

      if(this.field2655.length() > 10) {
         this.field2655 = this.field2655.substring(0, 10);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3150() {
      byte var1 = 38;
      int var2 = var1 + class40.method829(this.field2652);
      var2 += class40.method829(this.field2653);
      var2 += class40.method829(this.field2654);
      var2 += class40.method829(this.field2655);
      var2 += class40.method829(this.field2660);
      var2 += class40.method829(this.field2663);
      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1529148773"
   )
   public void method3153(class119 var1) {
      var1.method2453(6);
      var1.method2453(this.field2638);
      var1.method2453(this.field2658?1:0);
      var1.method2453(this.field2642);
      var1.method2453(this.field2643);
      var1.method2453(this.field2644);
      var1.method2453(this.field2645);
      var1.method2453(this.field2646);
      var1.method2453(this.field2647?1:0);
      var1.method2454(this.field2639);
      var1.method2453(this.field2661);
      var1.method2455(this.field2659);
      var1.method2454(this.field2651);
      var1.method2535(this.field2652);
      var1.method2535(this.field2653);
      var1.method2535(this.field2654);
      var1.method2535(this.field2655);
      var1.method2453(this.field2657);
      var1.method2454(this.field2656);
      var1.method2535(this.field2660);
      var1.method2535(this.field2663);
      var1.method2453(this.field2635);
      var1.method2453(this.field2649);

      for(int var2 = 0; var2 < this.field2662.length; ++var2) {
         var1.method2456(this.field2662[var2]);
      }

      var1.method2456(this.field2636);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class102.field1776.startsWith("win")) {
         this.field2638 = 1;
      } else if(class102.field1776.startsWith("mac")) {
         this.field2638 = 2;
      } else if(class102.field1776.startsWith("linux")) {
         this.field2638 = 3;
      } else {
         this.field2638 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var11) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field2658 = false;
      } else {
         this.field2658 = true;
      }

      if(this.field2638 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2642 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2642 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2642 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2642 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2642 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2642 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2642 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2642 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2642 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2642 = 10;
         }
      } else if(this.field2638 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2642 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2642 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2642 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2642 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2642 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2642 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2642 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2643 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2643 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2643 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2643 = 5;
      } else {
         this.field2643 = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2644 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2645 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2646 = var7;
      this.field2647 = false;
      this.field2639 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2644 > 3) {
         this.field2661 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2661 = 0;
      }

      this.field2659 = 0;
      if(null == this.field2652) {
         this.field2652 = "";
      }

      if(null == this.field2653) {
         this.field2653 = "";
      }

      if(null == this.field2654) {
         this.field2654 = "";
      }

      if(null == this.field2655) {
         this.field2655 = "";
      }

      if(null == this.field2660) {
         this.field2660 = "";
      }

      if(null == this.field2663) {
         this.field2663 = "";
      }

      this.method3148();
   }
}
