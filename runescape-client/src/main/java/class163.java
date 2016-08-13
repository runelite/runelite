import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class163 extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 373940027
   )
   int field2670;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1575217485
   )
   int field2671;
   @ObfuscatedName("an")
   String field2672;
   @ObfuscatedName("aj")
   String field2673;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1726198877
   )
   int field2674;
   @ObfuscatedName("k")
   boolean field2677;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 459463001
   )
   int field2678;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1436555447
   )
   int field2679;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -329918479
   )
   int field2681;
   @ObfuscatedName("ag")
   boolean field2682;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1340209441
   )
   int field2683;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1705402691
   )
   int field2684;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 304337499
   )
   int field2685;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -685937187
   )
   int field2686;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1904610959
   )
   int field2687;
   @ObfuscatedName("ae")
   String field2688;
   @ObfuscatedName("ar")
   String field2689;
   @ObfuscatedName("at")
   String field2690;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1298989155
   )
   int field2691;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 13261855
   )
   int field2693;
   @ObfuscatedName("al")
   String field2695;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1517912861
   )
   int field2696;
   @ObfuscatedName("aa")
   int[] field2697 = new int[3];
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -2042499025
   )
   int field2698;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1903695107"
   )
   void method3320() {
      if(this.field2673.length() > 40) {
         this.field2673 = this.field2673.substring(0, 40);
      }

      if(this.field2688.length() > 40) {
         this.field2688 = this.field2688.substring(0, 40);
      }

      if(this.field2689.length() > 10) {
         this.field2689 = this.field2689.substring(0, 10);
      }

      if(this.field2690.length() > 10) {
         this.field2690 = this.field2690.substring(0, 10);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1007770800"
   )
   public void method3322(Buffer var1) {
      var1.method2783(6);
      var1.method2783(this.field2670);
      var1.method2783(this.field2677?1:0);
      var1.method2783(this.field2681);
      var1.method2783(this.field2678);
      var1.method2783(this.field2679);
      var1.method2783(this.field2693);
      var1.method2783(this.field2696);
      var1.method2783(this.field2682?1:0);
      var1.method2619(this.field2683);
      var1.method2783(this.field2684);
      var1.method2849(this.field2685);
      var1.method2619(this.field2686);
      var1.method2625(this.field2673);
      var1.method2625(this.field2688);
      var1.method2625(this.field2689);
      var1.method2625(this.field2690);
      var1.method2783(this.field2687);
      var1.method2619(this.field2691);
      var1.method2625(this.field2695);
      var1.method2625(this.field2672);
      var1.method2783(this.field2674);
      var1.method2783(this.field2671);

      for(int var2 = 0; var2 < this.field2697.length; ++var2) {
         var1.method2728(this.field2697[var2]);
      }

      var1.method2728(this.field2698);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-86"
   )
   public int method3323() {
      byte var1 = 38;
      String var2 = this.field2673;
      int var3 = var2.length() + 2;
      int var4 = var1 + var3;
      String var5 = this.field2688;
      int var6 = var5.length() + 2;
      var4 += var6;
      String var7 = this.field2689;
      int var8 = var7.length() + 2;
      var4 += var8;
      String var9 = this.field2690;
      int var10 = var9.length() + 2;
      var4 += var10;
      String var11 = this.field2695;
      int var12 = var11.length() + 2;
      var4 += var12;
      String var13 = this.field2672;
      int var14 = var13.length() + 2;
      var4 += var14;
      return var4;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(GameObject.field1746.startsWith("win")) {
         this.field2670 = 1;
      } else if(GameObject.field1746.startsWith("mac")) {
         this.field2670 = 2;
      } else if(GameObject.field1746.startsWith("linux")) {
         this.field2670 = 3;
      } else {
         this.field2670 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var12) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var11) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var10) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field2677 = false;
      } else {
         this.field2677 = true;
      }

      if(this.field2670 == 1) {
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
      } else if(this.field2670 == 2) {
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

      int var6 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = 10 * var7 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2679 = var7;
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
      } catch (Exception var14) {
         ;
      }

      this.field2693 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var6;
         }
      } catch (Exception var13) {
         ;
      }

      this.field2696 = var7;
      this.field2682 = false;
      this.field2683 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2679 > 3) {
         this.field2684 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2684 = 0;
      }

      this.field2685 = 0;
      if(this.field2673 == null) {
         this.field2673 = "";
      }

      if(this.field2688 == null) {
         this.field2688 = "";
      }

      if(this.field2689 == null) {
         this.field2689 = "";
      }

      if(null == this.field2690) {
         this.field2690 = "";
      }

      if(null == this.field2695) {
         this.field2695 = "";
      }

      if(null == this.field2672) {
         this.field2672 = "";
      }

      this.method3320();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-22787"
   )
   public static void method3329(int var0) {
      if(var0 != -1 && Widget.validInterfaces[var0]) {
         Widget.field2798.method3407(var0);
         if(Widget.widgets[var0] != null) {
            boolean var1 = true;

            for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
               if(Widget.widgets[var0][var2] != null) {
                  if(Widget.widgets[var0][var2].type != 2) {
                     Widget.widgets[var0][var2] = null;
                  } else {
                     var1 = false;
                  }
               }
            }

            if(var1) {
               Widget.widgets[var0] = null;
            }

            Widget.validInterfaces[var0] = false;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-341510156"
   )
   public static void method3330() {
      class43.field1000.reset();
   }
}
