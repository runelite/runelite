import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class163 extends Node {
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -498973611
   )
   int field2670;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1723403223
   )
   int field2672;
   @ObfuscatedName("l")
   boolean field2673;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -355046717
   )
   int field2676;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1758495085
   )
   int field2677;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1006331489
   )
   int field2678;
   @ObfuscatedName("ac")
   String field2679;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 875623441
   )
   int field2680;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -342872497
   )
   int field2681;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -230087501
   )
   int field2682;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 970506509
   )
   int field2684;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1941852005
   )
   int field2685;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -532778823
   )
   int field2687;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -229296577
   )
   int field2689;
   @ObfuscatedName("aw")
   String field2691;
   @ObfuscatedName("ak")
   String field2692;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 747772271
   )
   int field2693;
   @ObfuscatedName("ao")
   boolean field2694;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 392345045
   )
   int field2695;
   @ObfuscatedName("am")
   String field2696;
   @ObfuscatedName("al")
   String field2697;
   @ObfuscatedName("ai")
   String field2698;
   @ObfuscatedName("ae")
   int[] field2699 = new int[3];
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 482674323
   )
   int field2700;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1610194707
   )
   static int field2701;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method3212() {
      if(this.field2696.length() > 40) {
         this.field2696 = this.field2696.substring(0, 40);
      }

      if(this.field2679.length() > 40) {
         this.field2679 = this.field2679.substring(0, 40);
      }

      if(this.field2691.length() > 10) {
         this.field2691 = this.field2691.substring(0, 10);
      }

      if(this.field2692.length() > 10) {
         this.field2692 = this.field2692.substring(0, 10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "71"
   )
   public int method3214() {
      byte var1 = 38;
      String var4 = this.field2696;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field2679;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2691;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2692;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2697;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2698;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "115"
   )
   public void method3220(Buffer var1) {
      var1.method2715(6);
      var1.method2715(this.field2672);
      var1.method2715(this.field2673?1:0);
      var1.method2715(this.field2678);
      var1.method2715(this.field2676);
      var1.method2715(this.field2685);
      var1.method2715(this.field2677);
      var1.method2715(this.field2682);
      var1.method2715(this.field2694?1:0);
      var1.method2542(this.field2684);
      var1.method2715(this.field2687);
      var1.method2742(this.field2670);
      var1.method2542(this.field2681);
      var1.method2658(this.field2696);
      var1.method2658(this.field2679);
      var1.method2658(this.field2691);
      var1.method2658(this.field2692);
      var1.method2715(this.field2689);
      var1.method2542(this.field2693);
      var1.method2658(this.field2697);
      var1.method2658(this.field2698);
      var1.method2715(this.field2695);
      var1.method2715(this.field2680);

      for(int var2 = 0; var2 < this.field2699.length; ++var2) {
         var1.method2544(this.field2699[var2]);
      }

      var1.method2544(this.field2700);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(Frames.field1833.startsWith("win")) {
         this.field2672 = 1;
      } else if(Frames.field1833.startsWith("mac")) {
         this.field2672 = 2;
      } else if(Frames.field1833.startsWith("linux")) {
         this.field2672 = 3;
      } else {
         this.field2672 = 4;
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
         this.field2673 = false;
      } else {
         this.field2673 = true;
      }

      if(this.field2672 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2678 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2678 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2678 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2678 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2678 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2678 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2678 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2678 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2678 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2678 = 10;
         }
      } else if(this.field2672 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2678 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2678 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2678 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2678 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2678 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2678 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2678 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2676 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2676 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2676 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2676 = 5;
      } else {
         this.field2676 = 4;
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

      this.field2685 = var7;
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

      this.field2677 = var7;
      var9 = var5.indexOf(95, 4) + 1;
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
      } catch (Exception var14) {
         ;
      }

      this.field2682 = var7;
      this.field2694 = false;
      this.field2684 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2685 > 3) {
         this.field2687 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2687 = 0;
      }

      this.field2670 = 0;
      if(null == this.field2696) {
         this.field2696 = "";
      }

      if(null == this.field2679) {
         this.field2679 = "";
      }

      if(null == this.field2691) {
         this.field2691 = "";
      }

      if(null == this.field2692) {
         this.field2692 = "";
      }

      if(this.field2697 == null) {
         this.field2697 = "";
      }

      if(null == this.field2698) {
         this.field2698 = "";
      }

      this.method3212();
   }
}
