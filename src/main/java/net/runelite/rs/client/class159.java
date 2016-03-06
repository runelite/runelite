package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fu")
public class class159 extends class207 {
   @ObfuscatedName("o")
   boolean field2611;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -415796859
   )
   int field2616;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1863781613
   )
   int field2617;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1227628359
   )
   int field2618;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2097745275
   )
   int field2619;
   @ObfuscatedName("aj")
   int[] field2621 = new int[3];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -255196403
   )
   int field2622;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1013214557
   )
   int field2624;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1030322641
   )
   int field2626;
   @ObfuscatedName("ar")
   boolean field2627;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1410570915
   )
   int field2629;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 99982827
   )
   int field2630;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 8430583
   )
   int field2631;
   @ObfuscatedName("al")
   String field2633;
   @ObfuscatedName("aq")
   String field2634;
   @ObfuscatedName("ae")
   String field2635;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1647355601
   )
   int field2636;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -108422089
   )
   int field2637;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1117388785
   )
   int field2638;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1970963883
   )
   int field2639;
   @ObfuscatedName("av")
   String field2640;
   @ObfuscatedName("ah")
   String field2641;
   @ObfuscatedName("at")
   String field2642;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1595308681
   )
   int field2643;

   @ObfuscatedName("j")
   void method3127() {
      if(this.field2642.length() > 40) {
         this.field2642 = this.field2642.substring(0, 40);
      }

      if(this.field2633.length() > 40) {
         this.field2633 = this.field2633.substring(0, 40);
      }

      if(this.field2634.length() > 10) {
         this.field2634 = this.field2634.substring(0, 10);
      }

      if(this.field2635.length() > 10) {
         this.field2635 = this.field2635.substring(0, 10);
      }

   }

   @ObfuscatedName("l")
   public void method3128(class118 var1) {
      var1.method2438(6);
      var1.method2438(this.field2616);
      var1.method2438(this.field2611?1:0);
      var1.method2438(this.field2622);
      var1.method2438(this.field2637);
      var1.method2438(this.field2624);
      var1.method2438(this.field2643);
      var1.method2438(this.field2626);
      var1.method2438(this.field2627?1:0);
      var1.method2541(this.field2619);
      var1.method2438(this.field2629);
      var1.method2457(this.field2630);
      var1.method2541(this.field2631);
      var1.method2498(this.field2642);
      var1.method2498(this.field2633);
      var1.method2498(this.field2634);
      var1.method2498(this.field2635);
      var1.method2438(this.field2617);
      var1.method2541(this.field2636);
      var1.method2498(this.field2640);
      var1.method2498(this.field2641);
      var1.method2438(this.field2638);
      var1.method2438(this.field2639);

      for(int var2 = 0; var2 < this.field2621.length; ++var2) {
         var1.method2441(this.field2621[var2]);
      }

      var1.method2441(this.field2618);
   }

   @ObfuscatedName("a")
   public int method3129() {
      byte var1 = 38;
      int var2 = var1 + class120.method2684(this.field2642);
      var2 += class120.method2684(this.field2633);
      var2 += class120.method2684(this.field2634);
      var2 += class120.method2684(this.field2635);
      var2 += class120.method2684(this.field2640);
      var2 += class120.method2684(this.field2641);
      return var2;
   }

   public class159(boolean var1) {
      if(class35.field790.startsWith("win")) {
         this.field2616 = 1;
      } else if(class35.field790.startsWith("mac")) {
         this.field2616 = 2;
      } else if(class35.field790.startsWith("linux")) {
         this.field2616 = 3;
      } else {
         this.field2616 = 4;
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
         this.field2611 = false;
      } else {
         this.field2611 = true;
      }

      if(this.field2616 == 1) {
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
      } else if(this.field2616 == 2) {
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
         this.field2637 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2637 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2637 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2637 = 5;
      } else {
         this.field2637 = 4;
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

      this.field2624 = var7;
      var6 = var5.indexOf(46, 2) + 1;
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

      this.field2626 = var7;
      this.field2627 = false;
      this.field2619 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2624 > 3) {
         this.field2629 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2629 = 0;
      }

      this.field2630 = 0;
      if(this.field2642 == null) {
         this.field2642 = "";
      }

      if(this.field2633 == null) {
         this.field2633 = "";
      }

      if(null == this.field2634) {
         this.field2634 = "";
      }

      if(this.field2635 == null) {
         this.field2635 = "";
      }

      if(this.field2640 == null) {
         this.field2640 = "";
      }

      if(this.field2641 == null) {
         this.field2641 = "";
      }

      this.method3127();
   }

   @ObfuscatedName("j")
   public static String method3132(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var8 = var0[var1];
         return var8 == null?"null":var8.toString();
      } else {
         int var3 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var3; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var3; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   @ObfuscatedName("bx")
   static final void method3134(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field491; ++var4) {
         if(client.field498[var4] + client.field496[var4] > var0 && client.field496[var4] < var2 + var0 && client.field499[var4] + client.field456[var4] > var1 && client.field456[var4] < var1 + var3) {
            client.field493[var4] = true;
         }
      }

   }
}
