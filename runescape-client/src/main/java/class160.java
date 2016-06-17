import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class160 extends class208 {
   @ObfuscatedName("r")
   boolean field2596;
   @ObfuscatedName("ap")
   int[] field2598 = new int[3];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 363096049
   )
   int field2599;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 409854287
   )
   int field2600;
   @ObfuscatedName("ax")
   boolean field2602;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 230481665
   )
   int field2604;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1301117611
   )
   int field2605;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1756355941
   )
   int field2606;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1650831859
   )
   int field2607;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 287344205
   )
   int field2608;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1825069113
   )
   int field2610;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -316156997
   )
   int field2611;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 654840883
   )
   int field2612;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -950833241
   )
   int field2613;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -235788883
   )
   int field2614;
   @ObfuscatedName("ak")
   String field2615;
   @ObfuscatedName("av")
   String field2617;
   @ObfuscatedName("at")
   String field2618;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 80255447
   )
   int field2619;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 638059051
   )
   int field2620;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2120486907
   )
   int field2621;
   @ObfuscatedName("ao")
   String field2623;
   @ObfuscatedName("al")
   String field2624;
   @ObfuscatedName("au")
   String field2626;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1329471202"
   )
   public void method3190(class119 var1) {
      var1.method2650(6);
      var1.method2650(this.field2600);
      var1.method2650(this.field2596?1:0);
      var1.method2650(this.field2604);
      var1.method2650(this.field2606);
      var1.method2650(this.field2607);
      var1.method2650(this.field2608);
      var1.method2650(this.field2599);
      var1.method2650(this.field2602?1:0);
      var1.method2695(this.field2611);
      var1.method2650(this.field2612);
      var1.method2501(this.field2613);
      var1.method2695(this.field2614);
      var1.method2596(this.field2615);
      var1.method2596(this.field2626);
      var1.method2596(this.field2617);
      var1.method2596(this.field2618);
      var1.method2650(this.field2605);
      var1.method2695(this.field2619);
      var1.method2596(this.field2623);
      var1.method2596(this.field2624);
      var1.method2650(this.field2621);
      var1.method2650(this.field2610);

      for(int var2 = 0; var2 < this.field2598.length; ++var2) {
         var1.method2502(this.field2598[var2]);
      }

      var1.method2502(this.field2620);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1598092649"
   )
   void method3191() {
      if(this.field2615.length() > 40) {
         this.field2615 = this.field2615.substring(0, 40);
      }

      if(this.field2626.length() > 40) {
         this.field2626 = this.field2626.substring(0, 40);
      }

      if(this.field2617.length() > 10) {
         this.field2617 = this.field2617.substring(0, 10);
      }

      if(this.field2618.length() > 10) {
         this.field2618 = this.field2618.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class111.field1938.startsWith("win")) {
         this.field2600 = 1;
      } else if(class111.field1938.startsWith("mac")) {
         this.field2600 = 2;
      } else if(class111.field1938.startsWith("linux")) {
         this.field2600 = 3;
      } else {
         this.field2600 = 4;
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
         this.field2596 = false;
      } else {
         this.field2596 = true;
      }

      if(this.field2600 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2604 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2604 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2604 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2604 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2604 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2604 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2604 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2604 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2604 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2604 = 10;
         }
      } else if(this.field2600 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2604 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2604 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2604 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2604 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2604 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2604 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2604 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2606 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2606 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2606 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2606 = 5;
      } else {
         this.field2606 = 4;
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

            var7 = 10 * var7 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2607 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2608 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = 10 * var7 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2599 = var7;
      this.field2602 = false;
      this.field2611 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2607 > 3) {
         this.field2612 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2612 = 0;
      }

      this.field2613 = 0;
      if(this.field2615 == null) {
         this.field2615 = "";
      }

      if(this.field2626 == null) {
         this.field2626 = "";
      }

      if(this.field2617 == null) {
         this.field2617 = "";
      }

      if(null == this.field2618) {
         this.field2618 = "";
      }

      if(this.field2623 == null) {
         this.field2623 = "";
      }

      if(this.field2624 == null) {
         this.field2624 = "";
      }

      this.method3191();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1263438170"
   )
   public int method3192() {
      byte var1 = 38;
      int var2 = var1 + class41.method863(this.field2615);
      var2 += class41.method863(this.field2626);
      var2 += class41.method863(this.field2617);
      var2 += class41.method863(this.field2618);
      var2 += class41.method863(this.field2623);
      var2 += class41.method863(this.field2624);
      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "82"
   )
   static final int method3200(int var0, int var1) {
      int var2 = class19.method225(var0 - 1, var1 - 1) + class19.method225(var0 + 1, var1 - 1) + class19.method225(var0 - 1, var1 + 1) + class19.method225(1 + var0, var1 + 1);
      int var3 = class19.method225(var0 - 1, var1) + class19.method225(var0 + 1, var1) + class19.method225(var0, var1 - 1) + class19.method225(var0, var1 + 1);
      int var4 = class19.method225(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
