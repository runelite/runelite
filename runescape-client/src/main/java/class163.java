import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class163 extends class211 {
   @ObfuscatedName("as")
   String field2668;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 2064512577
   )
   int field2672;
   @ObfuscatedName("ak")
   String field2673;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 505760419
   )
   int field2676;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2074296781
   )
   int field2678;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1767287307
   )
   int field2679;
   @ObfuscatedName("j")
   boolean field2680;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -700381773
   )
   int field2681;
   @ObfuscatedName("ad")
   boolean field2682;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 958209643
   )
   int field2683;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1423303019
   )
   int field2684;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1948471219
   )
   int field2685;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 2114675687
   )
   int field2686;
   @ObfuscatedName("ah")
   String field2687;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1936080399
   )
   int field2688;
   @ObfuscatedName("al")
   String field2689;
   @ObfuscatedName("ac")
   String field2690;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 116146955
   )
   int field2692;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1263502057
   )
   int field2693;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -995215139
   )
   int field2694;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -325669803
   )
   int field2695;
   @ObfuscatedName("az")
   String field2696;
   @ObfuscatedName("ae")
   int[] field2697 = new int[3];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 79632579
   )
   int field2698;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1568586825
   )
   @Export("menuX")
   static int field2699;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass146;ZB)V",
      garbageValue = "51"
   )
   public static void method3222(class146 var0, boolean var1) {
      if(class174.field2766 != null) {
         try {
            class174.field2766.method3050();
         } catch (Exception var6) {
            ;
         }

         class174.field2766 = null;
      }

      class174.field2766 = var0;
      class13.method156(var1);
      class174.field2772.field2045 = 0;
      class174.field2771 = null;
      class117.field2020 = null;
      class174.field2775 = 0;

      while(true) {
         class175 var2 = (class175)class174.field2778.method3847();
         if(var2 == null) {
            while(true) {
               var2 = (class175)class174.field2760.method3847();
               if(var2 == null) {
                  if(class174.field2776 != 0) {
                     try {
                        class122 var7 = new class122(4);
                        var7.method2557(4);
                        var7.method2557(class174.field2776);
                        var7.method2558(0);
                        class174.field2766.method3045(var7.field2047, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class174.field2766.method3050();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class174.field2767;
                        class174.field2766 = null;
                     }
                  }

                  class174.field2761 = 0;
                  class221.field3213 = class193.method3805();
                  return;
               }

               class174.field2764.method3942(var2);
               class174.field2773.method3849(var2, var2.field3167);
               ++class174.field2768;
               --class174.field2770;
            }
         }

         class174.field2762.method3849(var2, var2.field3167);
         ++class174.field2763;
         --class174.field2765;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   void method3224() {
      if(this.field2687.length() > 40) {
         this.field2687 = this.field2687.substring(0, 40);
      }

      if(this.field2689.length() > 40) {
         this.field2689 = this.field2689.substring(0, 40);
      }

      if(this.field2668.length() > 10) {
         this.field2668 = this.field2668.substring(0, 10);
      }

      if(this.field2690.length() > 10) {
         this.field2690 = this.field2690.substring(0, 10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-60682464"
   )
   public int method3225() {
      byte var1 = 38;
      String var4 = this.field2687;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2689;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2668;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2690;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2696;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2673;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-25"
   )
   public void method3226(class122 var1) {
      var1.method2557(6);
      var1.method2557(this.field2676);
      var1.method2557(this.field2680?1:0);
      var1.method2557(this.field2698);
      var1.method2557(this.field2678);
      var1.method2557(this.field2679);
      var1.method2557(this.field2695);
      var1.method2557(this.field2681);
      var1.method2557(this.field2682?1:0);
      var1.method2558(this.field2683);
      var1.method2557(this.field2684);
      var1.method2559(this.field2685);
      var1.method2558(this.field2686);
      var1.method2659(this.field2687);
      var1.method2659(this.field2689);
      var1.method2659(this.field2668);
      var1.method2659(this.field2690);
      var1.method2557(this.field2692);
      var1.method2558(this.field2694);
      var1.method2659(this.field2696);
      var1.method2659(this.field2673);
      var1.method2557(this.field2693);
      var1.method2557(this.field2688);

      for(int var2 = 0; var2 < this.field2697.length; ++var2) {
         var1.method2560(this.field2697[var2]);
      }

      var1.method2560(this.field2672);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(class98.field1693.startsWith("win")) {
         this.field2676 = 1;
      } else if(class98.field1693.startsWith("mac")) {
         this.field2676 = 2;
      } else if(class98.field1693.startsWith("linux")) {
         this.field2676 = 3;
      } else {
         this.field2676 = 4;
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
         this.field2680 = false;
      } else {
         this.field2680 = true;
      }

      if(this.field2676 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2698 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2698 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2698 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2698 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2698 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2698 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2698 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2698 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2698 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2698 = 10;
         }
      } else if(this.field2676 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2698 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2698 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2698 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2698 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2698 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2698 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2698 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2678 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2678 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2678 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2678 = 5;
      } else {
         this.field2678 = 4;
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

      this.field2679 = var7;
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

      this.field2695 = var7;
      var9 = var5.indexOf(95, 4) + 1;
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
      } catch (Exception var14) {
         ;
      }

      this.field2681 = var7;
      this.field2682 = false;
      this.field2683 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2679 > 3) {
         this.field2684 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2684 = 0;
      }

      this.field2685 = 0;
      if(this.field2687 == null) {
         this.field2687 = "";
      }

      if(null == this.field2689) {
         this.field2689 = "";
      }

      if(this.field2668 == null) {
         this.field2668 = "";
      }

      if(null == this.field2690) {
         this.field2690 = "";
      }

      if(null == this.field2696) {
         this.field2696 = "";
      }

      if(this.field2673 == null) {
         this.field2673 = "";
      }

      this.method3224();
   }
}
