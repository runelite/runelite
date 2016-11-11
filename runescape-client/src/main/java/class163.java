import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class163 extends Node {
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1271647983
   )
   int field2653;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 943932745
   )
   int field2657;
   @ObfuscatedName("d")
   boolean field2660;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 932955345
   )
   int field2664;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -410670405
   )
   int field2665;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -303955699
   )
   int field2667;
   @ObfuscatedName("ai")
   String field2668;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1159462387
   )
   int field2670;
   @ObfuscatedName("al")
   boolean field2671;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -899896707
   )
   int field2672;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 478608563
   )
   int field2673;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2056156279
   )
   int field2674;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1668536125
   )
   int field2675;
   @ObfuscatedName("ac")
   String field2676;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1831102197
   )
   int field2677;
   @ObfuscatedName("ap")
   String field2678;
   @ObfuscatedName("aa")
   String field2679;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 872000563
   )
   int field2680;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1392202077
   )
   int field2682;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -609489843
   )
   int field2683;
   @ObfuscatedName("av")
   String field2684;
   @ObfuscatedName("ae")
   String field2685;
   @ObfuscatedName("at")
   int[] field2686 = new int[3];
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1378100777
   )
   int field2687;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1181738237"
   )
   public void method3201(Buffer var1) {
      var1.method2529(6);
      var1.method2529(this.field2657);
      var1.method2529(this.field2660?1:0);
      var1.method2529(this.field2665);
      var1.method2529(this.field2667);
      var1.method2529(this.field2653);
      var1.method2529(this.field2680);
      var1.method2529(this.field2670);
      var1.method2529(this.field2671?1:0);
      var1.method2701(this.field2672);
      var1.method2529(this.field2673);
      var1.method2531(this.field2674);
      var1.method2701(this.field2675);
      var1.method2536(this.field2676);
      var1.method2536(this.field2668);
      var1.method2536(this.field2678);
      var1.method2536(this.field2679);
      var1.method2529(this.field2677);
      var1.method2701(this.field2682);
      var1.method2536(this.field2684);
      var1.method2536(this.field2685);
      var1.method2529(this.field2683);
      var1.method2529(this.field2664);

      for(int var2 = 0; var2 < this.field2686.length; ++var2) {
         var1.method2709(this.field2686[var2]);
      }

      var1.method2709(this.field2687);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1856435600"
   )
   public int method3202() {
      byte var1 = 38;
      String var4 = this.field2676;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2668;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2678;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2679;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2684;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2685;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-70"
   )
   void method3212() {
      if(this.field2676.length() > 40) {
         this.field2676 = this.field2676.substring(0, 40);
      }

      if(this.field2668.length() > 40) {
         this.field2668 = this.field2668.substring(0, 40);
      }

      if(this.field2678.length() > 10) {
         this.field2678 = this.field2678.substring(0, 10);
      }

      if(this.field2679.length() > 10) {
         this.field2679 = this.field2679.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(DecorativeObject.field1657.startsWith("win")) {
         this.field2657 = 1;
      } else if(DecorativeObject.field1657.startsWith("mac")) {
         this.field2657 = 2;
      } else if(DecorativeObject.field1657.startsWith("linux")) {
         this.field2657 = 3;
      } else {
         this.field2657 = 4;
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
         this.field2660 = false;
      } else {
         this.field2660 = true;
      }

      if(this.field2657 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2665 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2665 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2665 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2665 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2665 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2665 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2665 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2665 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2665 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2665 = 10;
         }
      } else if(this.field2657 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2665 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2665 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2665 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2665 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2665 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2665 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2665 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2667 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2667 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2667 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2667 = 5;
      } else {
         this.field2667 = 4;
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

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2653 = var7;
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

      this.field2680 = var7;
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

      this.field2670 = var7;
      this.field2671 = false;
      this.field2672 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2653 > 3) {
         this.field2673 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2673 = 0;
      }

      this.field2674 = 0;
      if(null == this.field2676) {
         this.field2676 = "";
      }

      if(null == this.field2668) {
         this.field2668 = "";
      }

      if(null == this.field2678) {
         this.field2678 = "";
      }

      if(null == this.field2679) {
         this.field2679 = "";
      }

      if(null == this.field2684) {
         this.field2684 = "";
      }

      if(null == this.field2685) {
         this.field2685 = "";
      }

      this.method3212();
   }
}
