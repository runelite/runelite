import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class160 extends class208 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -915972223
   )
   int field2609;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 2076190311
   )
   int field2610;
   @ObfuscatedName("aa")
   String field2615;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1043211665
   )
   int field2616;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1084526339
   )
   int field2618;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1506791711
   )
   int field2619;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1772787565
   )
   int field2620;
   @ObfuscatedName("av")
   boolean field2621;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -752482601
   )
   int field2622;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1964831265
   )
   int field2624;
   @ObfuscatedName("ap")
   int field2625;
   @ObfuscatedName("af")
   String field2626;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 689270999
   )
   int field2627;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 948619437
   )
   int field2628;
   @ObfuscatedName("aw")
   String field2629;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1211982593
   )
   int field2630;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -318810665
   )
   int field2631;
   @ObfuscatedName("n")
   boolean field2632;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -314312519
   )
   int field2633;
   @ObfuscatedName("ar")
   String field2634;
   @ObfuscatedName("at")
   String field2635;
   @ObfuscatedName("ab")
   int[] field2636 = new int[3];
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1286804841
   )
   int field2637;
   @ObfuscatedName("ay")
   String field2638;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   void method3198() {
      if(this.field2626.length() > 40) {
         this.field2626 = this.field2626.substring(0, 40);
      }

      if(this.field2615.length() > 40) {
         this.field2615 = this.field2615.substring(0, 40);
      }

      if(this.field2638.length() > 10) {
         this.field2638 = this.field2638.substring(0, 10);
      }

      if(this.field2629.length() > 10) {
         this.field2629 = this.field2629.substring(0, 10);
      }

   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-288511622"
   )
   static final void method3199(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(null != var4) {
         int var6 = client.field500 + client.field374 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1597[var6];
            int var9 = class91.field1577[var6];
            var8 = var8 * 256 / (client.field363 + 256);
            var9 = 256 * var9 / (256 + client.field363);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1750(var5.field2900 / 2 + var10 - var4.field1412 / 2, var5.field2901 / 2 - var11 - var4.field1415 / 2, var0, var1, var5.field2900, var5.field2901, var5.field2898, var5.field2899);
            } else {
               var4.method1763(var10 + var5.field2900 / 2 + var0 - var4.field1412 / 2, var1 + var5.field2901 / 2 - var11 - var4.field1415 / 2);
            }

         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class160(boolean var1) {
      if(class19.field274.startsWith("win")) {
         this.field2609 = 1;
      } else if(class19.field274.startsWith("mac")) {
         this.field2609 = 2;
      } else if(class19.field274.startsWith("linux")) {
         this.field2609 = 3;
      } else {
         this.field2609 = 4;
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
         this.field2632 = false;
      } else {
         this.field2632 = true;
      }

      if(this.field2609 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2616 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2616 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2616 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2616 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2616 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2616 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2616 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2616 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2616 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2616 = 10;
         }
      } else if(this.field2609 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2616 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2616 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2616 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2616 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2616 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2616 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2616 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2622 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2622 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2622 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2622 = 5;
      } else {
         this.field2622 = 4;
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

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2628 = var7;
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

      this.field2619 = var7;
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

      this.field2620 = var7;
      this.field2621 = false;
      this.field2627 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2628 > 3) {
         this.field2618 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2618 = 0;
      }

      this.field2624 = 0;
      if(this.field2626 == null) {
         this.field2626 = "";
      }

      if(null == this.field2615) {
         this.field2615 = "";
      }

      if(this.field2638 == null) {
         this.field2638 = "";
      }

      if(this.field2629 == null) {
         this.field2629 = "";
      }

      if(null == this.field2634) {
         this.field2634 = "";
      }

      if(this.field2635 == null) {
         this.field2635 = "";
      }

      this.method3198();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3200() {
      byte var1 = 38;
      int var2 = var1 + class35.method771(this.field2626);
      var2 += class35.method771(this.field2615);
      var2 += class35.method771(this.field2638);
      var2 += class35.method771(this.field2629);
      var2 += class35.method771(this.field2634);
      var2 += class35.method771(this.field2635);
      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-750978635"
   )
   public void method3203(class119 var1) {
      var1.method2654(6);
      var1.method2654(this.field2609);
      var1.method2654(this.field2632?1:0);
      var1.method2654(this.field2616);
      var1.method2654(this.field2622);
      var1.method2654(this.field2628);
      var1.method2654(this.field2619);
      var1.method2654(this.field2620);
      var1.method2654(this.field2621?1:0);
      var1.method2540(this.field2627);
      var1.method2654(this.field2618);
      var1.method2541(this.field2624);
      var1.method2540(this.field2625 * 147255);
      var1.method2546(this.field2626);
      var1.method2546(this.field2615);
      var1.method2546(this.field2638);
      var1.method2546(this.field2629);
      var1.method2654(this.field2631);
      var1.method2540(this.field2630);
      var1.method2546(this.field2634);
      var1.method2546(this.field2635);
      var1.method2654(this.field2610);
      var1.method2654(this.field2633);

      for(int var2 = 0; var2 < this.field2636.length; ++var2) {
         var1.method2539(this.field2636[var2]);
      }

      var1.method2539(this.field2637);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   @Export("groundItemSpawned")
   static final void method3204(int var0, int var1) {
      class199 var2 = client.field572[class14.field212][var0][var1];
      if(var2 == null) {
         class129.field2056.method1996(class14.field212, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3852(); var6 != null; var6 = (class28)var2.method3857()) {
            class51 var7 = class141.method3001(var6.field682);
            long var10 = (long)var7.field1134;
            if(var7.field1151 == 1) {
               var10 *= (long)(1 + var6.field681);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(null == var5) {
            class129.field2056.method1996(class14.field212, var0, var1);
         } else {
            var2.method3851(var5);
            class28 var12 = null;
            class28 var8 = null;

            for(var6 = (class28)var2.method3852(); null != var6; var6 = (class28)var2.method3857()) {
               if(var6.field682 != var5.field682) {
                  if(null == var12) {
                     var12 = var6;
                  }

                  if(var12.field682 != var6.field682 && null == var8) {
                     var8 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class129.field2056.method1982(class14.field212, var0, var1, class74.method1659(64 + var0 * 128, 128 * var1 + 64, class14.field212), var5, var9, var12, var8);
         }
      }
   }
}
