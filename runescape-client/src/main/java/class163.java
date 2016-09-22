import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class163 extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1304845491
   )
   int field2677;
   @ObfuscatedName("n")
   boolean field2678;
   @ObfuscatedName("ai")
   String field2680;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 270926289
   )
   int field2681;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1802316553
   )
   int field2682;
   @ObfuscatedName("ad")
   String field2683;
   @ObfuscatedName("ah")
   String field2684;
   @ObfuscatedName("ao")
   boolean field2686;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2079787721
   )
   int field2687;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -760056147
   )
   int field2688;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -132773001
   )
   int field2689;
   @ObfuscatedName("an")
   String field2690;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -662515991
   )
   int field2691;
   @ObfuscatedName("aj")
   int[] field2692 = new int[3];
   @ObfuscatedName("ak")
   String field2693;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1377866053
   )
   int field2694;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1097204467
   )
   int field2695;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -2115350815
   )
   int field2696;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -341334959
   )
   int field2697;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1005426313
   )
   int field2698;
   @ObfuscatedName("ae")
   String field2699;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 273255667
   )
   int field2700;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -639469271
   )
   int field2701;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -720041467
   )
   int field2702;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2088048328"
   )
   public static void method3216(boolean var0) {
      if(null != class174.field2781) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2513(var0?2:3);
            var1.method2743(0);
            class174.field2781.method3025(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2781.method3039();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2789;
            class174.field2781 = null;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1445805591"
   )
   public int method3219() {
      byte var1 = 38;
      int var2 = var1 + NPCComposition.method835(this.field2683);
      var2 += NPCComposition.method835(this.field2684);
      var2 += NPCComposition.method835(this.field2693);
      var2 += NPCComposition.method835(this.field2680);
      var2 += NPCComposition.method835(this.field2699);
      var2 += NPCComposition.method835(this.field2690);
      return var2;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(class152.field2306.startsWith("win")) {
         this.field2677 = 1;
      } else if(class152.field2306.startsWith("mac")) {
         this.field2677 = 2;
      } else if(class152.field2306.startsWith("linux")) {
         this.field2677 = 3;
      } else {
         this.field2677 = 4;
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
         this.field2678 = false;
      } else {
         this.field2678 = true;
      }

      if(this.field2677 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2681 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2681 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2681 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2681 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2681 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2681 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2681 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2681 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2681 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2681 = 10;
         }
      } else if(this.field2677 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2681 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2681 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2681 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2681 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2681 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2681 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2681 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2698 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2698 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2698 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2698 = 5;
      } else {
         this.field2698 = 4;
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

      this.field2700 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2682 = var7;
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

      this.field2701 = var7;
      this.field2686 = false;
      this.field2687 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2700 > 3) {
         this.field2688 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2688 = 0;
      }

      this.field2689 = 0;
      if(null == this.field2683) {
         this.field2683 = "";
      }

      if(null == this.field2684) {
         this.field2684 = "";
      }

      if(null == this.field2693) {
         this.field2693 = "";
      }

      if(null == this.field2680) {
         this.field2680 = "";
      }

      if(null == this.field2699) {
         this.field2699 = "";
      }

      if(this.field2690 == null) {
         this.field2690 = "";
      }

      this.method3227();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-911031819"
   )
   public void method3224(Buffer var1) {
      var1.method2513(6);
      var1.method2513(this.field2677);
      var1.method2513(this.field2678?1:0);
      var1.method2513(this.field2681);
      var1.method2513(this.field2698);
      var1.method2513(this.field2700);
      var1.method2513(this.field2682);
      var1.method2513(this.field2701);
      var1.method2513(this.field2686?1:0);
      var1.method2514(this.field2687);
      var1.method2513(this.field2688);
      var1.method2743(this.field2689);
      var1.method2514(this.field2691);
      var1.method2520(this.field2683);
      var1.method2520(this.field2684);
      var1.method2520(this.field2693);
      var1.method2520(this.field2680);
      var1.method2513(this.field2696);
      var1.method2514(this.field2695);
      var1.method2520(this.field2699);
      var1.method2520(this.field2690);
      var1.method2513(this.field2697);
      var1.method2513(this.field2694);

      for(int var2 = 0; var2 < this.field2692.length; ++var2) {
         var1.method2600(this.field2692[var2]);
      }

      var1.method2600(this.field2702);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2084941724"
   )
   void method3227() {
      if(this.field2683.length() > 40) {
         this.field2683 = this.field2683.substring(0, 40);
      }

      if(this.field2684.length() > 40) {
         this.field2684 = this.field2684.substring(0, 40);
      }

      if(this.field2693.length() > 10) {
         this.field2693 = this.field2693.substring(0, 10);
      }

      if(this.field2680.length() > 10) {
         this.field2680 = this.field2680.substring(0, 10);
      }

   }
}
