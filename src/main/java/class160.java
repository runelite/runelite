import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class160 extends class208 {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1018645481
   )
   int field2632;
   @ObfuscatedName("m")
   boolean field2635;
   @ObfuscatedName("aa")
   String field2639;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 250391951
   )
   int field2640;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1753293449
   )
   int field2641;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1222705385
   )
   int field2642;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -366715095
   )
   int field2643;
   @ObfuscatedName("ah")
   boolean field2644;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1898948259
   )
   int field2645;
   @ObfuscatedName("an")
   String field2646;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 287266067
   )
   int field2647;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1033591593
   )
   int field2648;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -985012491
   )
   int field2649;
   @ObfuscatedName("ao")
   String field2650;
   @ObfuscatedName("ak")
   String field2651;
   @ObfuscatedName("at")
   String field2652;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1123459627
   )
   int field2653;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 237592339
   )
   int field2654;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1221302061
   )
   int field2655;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1152075637
   )
   int field2656;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1785849845
   )
   int field2657;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -827906519
   )
   int field2658;
   @ObfuscatedName("ap")
   int[] field2659 = new int[3];
   @ObfuscatedName("au")
   String field2662;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   void method3200() {
      if(this.field2662.length() > 40) {
         this.field2662 = this.field2662.substring(0, 40);
      }

      if(this.field2650.length() > 40) {
         this.field2650 = this.field2650.substring(0, 40);
      }

      if(this.field2651.length() > 10) {
         this.field2651 = this.field2651.substring(0, 10);
      }

      if(this.field2652.length() > 10) {
         this.field2652 = this.field2652.substring(0, 10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1859236890"
   )
   public void method3201(class119 var1) {
      var1.method2573(6);
      var1.method2573(this.field2642);
      var1.method2573(this.field2635?1:0);
      var1.method2573(this.field2658);
      var1.method2573(this.field2640);
      var1.method2573(this.field2641);
      var1.method2573(this.field2643);
      var1.method2573(this.field2632);
      var1.method2573(this.field2644?1:0);
      var1.method2492(this.field2645);
      var1.method2573(this.field2657);
      var1.method2653(this.field2647);
      var1.method2492(this.field2648);
      var1.method2569(this.field2662);
      var1.method2569(this.field2650);
      var1.method2569(this.field2651);
      var1.method2569(this.field2652);
      var1.method2573(this.field2654);
      var1.method2492(this.field2653);
      var1.method2569(this.field2646);
      var1.method2569(this.field2639);
      var1.method2573(this.field2655);
      var1.method2573(this.field2656);

      for(int var2 = 0; var2 < this.field2659.length; ++var2) {
         var1.method2494(this.field2659[var2]);
      }

      var1.method2494(this.field2649);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class52.field1168.startsWith("win")) {
         this.field2642 = 1;
      } else if(class52.field1168.startsWith("mac")) {
         this.field2642 = 2;
      } else if(class52.field1168.startsWith("linux")) {
         this.field2642 = 3;
      } else {
         this.field2642 = 4;
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
         this.field2635 = false;
      } else {
         this.field2635 = true;
      }

      if(this.field2642 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2658 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2658 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2658 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2658 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2658 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2658 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2658 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2658 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2658 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2658 = 10;
         }
      } else if(this.field2642 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2658 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2658 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2658 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2658 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2658 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2658 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2658 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2640 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2640 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2640 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2640 = 5;
      } else {
         this.field2640 = 4;
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

      this.field2641 = var7;
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

      this.field2643 = var7;
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

      this.field2632 = var7;
      this.field2644 = false;
      this.field2645 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2641 > 3) {
         this.field2657 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2657 = 0;
      }

      this.field2647 = 0;
      if(this.field2662 == null) {
         this.field2662 = "";
      }

      if(this.field2650 == null) {
         this.field2650 = "";
      }

      if(this.field2651 == null) {
         this.field2651 = "";
      }

      if(this.field2652 == null) {
         this.field2652 = "";
      }

      if(null == this.field2646) {
         this.field2646 = "";
      }

      if(this.field2639 == null) {
         this.field2639 = "";
      }

      this.method3200();
   }

   @ObfuscatedName("t")
   public int method3203() {
      byte var1 = 38;
      int var2 = var1 + class10.method132(this.field2662);
      var2 += class10.method132(this.field2650);
      var2 += class10.method132(this.field2651);
      var2 += class10.method132(this.field2652);
      var2 += class10.method132(this.field2646);
      var2 += class10.method132(this.field2639);
      return var2;
   }
}
