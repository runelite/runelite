import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class163 extends Node {
   @ObfuscatedName("az")
   String field2655;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1446239657
   )
   int field2657;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1632462389
   )
   int field2658;
   @ObfuscatedName("m")
   boolean field2659;
   @ObfuscatedName("aj")
   String field2661;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1093252669
   )
   int field2666;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1638366621
   )
   int field2667;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2100739601
   )
   int field2669;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -94762819
   )
   int field2671;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 970751693
   )
   int field2672;
   @ObfuscatedName("ag")
   boolean field2673;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -937285141
   )
   int field2674;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1708026023
   )
   int field2675;
   @ObfuscatedName("as")
   String field2676;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -740435887
   )
   int field2677;
   @ObfuscatedName("ai")
   String field2679;
   @ObfuscatedName("af")
   int[] field2680 = new int[3];
   @ObfuscatedName("ay")
   String field2681;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -55023385
   )
   int field2682;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1755786479
   )
   int field2684;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1342800509
   )
   int field2685;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1862291381
   )
   int field2686;
   @ObfuscatedName("aq")
   String field2687;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2048357505
   )
   int field2688;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-62"
   )
   public int method3167() {
      byte var1 = 38;
      int var2 = var1 + class32.method686(this.field2661);
      var2 += class32.method686(this.field2679);
      var2 += class32.method686(this.field2655);
      var2 += class32.method686(this.field2681);
      var2 += class32.method686(this.field2676);
      var2 += class32.method686(this.field2687);
      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-502338628"
   )
   void method3168() {
      if(this.field2661.length() > 40) {
         this.field2661 = this.field2661.substring(0, 40);
      }

      if(this.field2679.length() > 40) {
         this.field2679 = this.field2679.substring(0, 40);
      }

      if(this.field2655.length() > 10) {
         this.field2655 = this.field2655.substring(0, 10);
      }

      if(this.field2681.length() > 10) {
         this.field2681 = this.field2681.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(class24.field606.startsWith("win")) {
         this.field2658 = 1;
      } else if(class24.field606.startsWith("mac")) {
         this.field2658 = 2;
      } else if(class24.field606.startsWith("linux")) {
         this.field2658 = 3;
      } else {
         this.field2658 = 4;
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
         this.field2659 = false;
      } else {
         this.field2659 = true;
      }

      if(this.field2658 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2667 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2667 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2667 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2667 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2667 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2667 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2667 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2667 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2667 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2667 = 10;
         }
      } else if(this.field2658 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2667 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2667 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2667 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2667 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2667 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2667 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2667 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2669 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2669 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2669 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2669 = 5;
      } else {
         this.field2669 = 4;
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

      this.field2688 = var7;
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

      this.field2671 = var7;
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

      this.field2672 = var7;
      this.field2673 = false;
      this.field2674 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2688 > 3) {
         this.field2675 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2675 = 0;
      }

      this.field2666 = 0;
      if(this.field2661 == null) {
         this.field2661 = "";
      }

      if(null == this.field2679) {
         this.field2679 = "";
      }

      if(null == this.field2655) {
         this.field2655 = "";
      }

      if(null == this.field2681) {
         this.field2681 = "";
      }

      if(this.field2676 == null) {
         this.field2676 = "";
      }

      if(null == this.field2687) {
         this.field2687 = "";
      }

      this.method3168();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "803506413"
   )
   public void method3169(Buffer var1) {
      var1.method2467(6);
      var1.method2467(this.field2658);
      var1.method2467(this.field2659?1:0);
      var1.method2467(this.field2667);
      var1.method2467(this.field2669);
      var1.method2467(this.field2688);
      var1.method2467(this.field2671);
      var1.method2467(this.field2672);
      var1.method2467(this.field2673?1:0);
      var1.method2468(this.field2674);
      var1.method2467(this.field2675);
      var1.method2523(this.field2666);
      var1.method2468(this.field2677);
      var1.method2469(this.field2661);
      var1.method2469(this.field2679);
      var1.method2469(this.field2655);
      var1.method2469(this.field2681);
      var1.method2467(this.field2686);
      var1.method2468(this.field2682);
      var1.method2469(this.field2676);
      var1.method2469(this.field2687);
      var1.method2467(this.field2684);
      var1.method2467(this.field2685);

      for(int var2 = 0; var2 < this.field2680.length; ++var2) {
         var1.method2642(this.field2680[var2]);
      }

      var1.method2642(this.field2657);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1124950300"
   )
   public static Widget method3174(int var0, int var1) {
      Widget var2 = class92.method2078(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }
}
