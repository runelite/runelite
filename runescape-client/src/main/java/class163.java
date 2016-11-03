import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class163 extends Node {
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 698757933
   )
   int field2650;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1008121031
   )
   int field2651;
   @ObfuscatedName("ah")
   String field2652;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 991527317
   )
   int field2654;
   @ObfuscatedName("m")
   boolean field2655;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -25007013
   )
   int field2656;
   @ObfuscatedName("af")
   String field2657;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 2090813159
   )
   int field2658;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1716723061
   )
   int field2660;
   @ObfuscatedName("ag")
   boolean field2661;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1117019045
   )
   int field2662;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2010276545
   )
   int field2663;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 688590575
   )
   int field2664;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 192247087
   )
   int field2665;
   @ObfuscatedName("ai")
   String field2667;
   @ObfuscatedName("an")
   String field2669;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -425415365
   )
   int field2670;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -516506565
   )
   int field2671;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1795377355
   )
   int field2672;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1677117265
   )
   int field2673;
   @ObfuscatedName("as")
   String field2674;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 558889811
   )
   int field2675;
   @ObfuscatedName("ab")
   int[] field2676 = new int[3];
   @ObfuscatedName("aw")
   String field2677;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int method3203() {
      byte var1 = 38;
      int var2 = var1 + class20.method572(this.field2677);
      var2 += class20.method572(this.field2667);
      var2 += class20.method572(this.field2657);
      var2 += class20.method572(this.field2669);
      var2 += class20.method572(this.field2652);
      var2 += class20.method572(this.field2674);
      return var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   public void method3205(Buffer var1) {
      var1.method2556(6);
      var1.method2556(this.field2654);
      var1.method2556(this.field2655?1:0);
      var1.method2556(this.field2656);
      var1.method2556(this.field2675);
      var1.method2556(this.field2673);
      var1.method2556(this.field2665);
      var1.method2556(this.field2660);
      var1.method2556(this.field2661?1:0);
      var1.method2638(this.field2662);
      var1.method2556(this.field2663);
      var1.method2558(this.field2664);
      var1.method2638(this.field2651);
      var1.method2563(this.field2677);
      var1.method2563(this.field2667);
      var1.method2563(this.field2657);
      var1.method2563(this.field2669);
      var1.method2556(this.field2671);
      var1.method2638(this.field2670);
      var1.method2563(this.field2652);
      var1.method2563(this.field2674);
      var1.method2556(this.field2672);
      var1.method2556(this.field2650);

      for(int var2 = 0; var2 < this.field2676.length; ++var2) {
         var1.method2559(this.field2676[var2]);
      }

      var1.method2559(this.field2658);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1250055159"
   )
   void method3206() {
      if(this.field2677.length() > 40) {
         this.field2677 = this.field2677.substring(0, 40);
      }

      if(this.field2667.length() > 40) {
         this.field2667 = this.field2667.substring(0, 40);
      }

      if(this.field2657.length() > 10) {
         this.field2657 = this.field2657.substring(0, 10);
      }

      if(this.field2669.length() > 10) {
         this.field2669 = this.field2669.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(SecondaryBufferProvider.field1431.startsWith("win")) {
         this.field2654 = 1;
      } else if(SecondaryBufferProvider.field1431.startsWith("mac")) {
         this.field2654 = 2;
      } else if(SecondaryBufferProvider.field1431.startsWith("linux")) {
         this.field2654 = 3;
      } else {
         this.field2654 = 4;
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
         this.field2655 = false;
      } else {
         this.field2655 = true;
      }

      if(this.field2654 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2656 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2656 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2656 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2656 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2656 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2656 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2656 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2656 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2656 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2656 = 10;
         }
      } else if(this.field2654 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2656 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2656 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2656 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2656 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2656 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2656 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2656 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2675 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2675 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2675 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2675 = 5;
      } else {
         this.field2675 = 4;
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

      this.field2673 = var7;
      var9 = var5.indexOf(46, 2) + 1;
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
      } catch (Exception var15) {
         ;
      }

      this.field2665 = var7;
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

      this.field2660 = var7;
      this.field2661 = false;
      this.field2662 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2673 > 3) {
         this.field2663 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2663 = 0;
      }

      this.field2664 = 0;
      if(null == this.field2677) {
         this.field2677 = "";
      }

      if(this.field2667 == null) {
         this.field2667 = "";
      }

      if(this.field2657 == null) {
         this.field2657 = "";
      }

      if(this.field2669 == null) {
         this.field2669 = "";
      }

      if(this.field2652 == null) {
         this.field2652 = "";
      }

      if(this.field2674 == null) {
         this.field2674 = "";
      }

      this.method3206();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass146;ZB)V",
      garbageValue = "-77"
   )
   public static void method3209(class146 var0, boolean var1) {
      if(null != class174.field2769) {
         try {
            class174.field2769.method3020();
         } catch (Exception var6) {
            ;
         }

         class174.field2769 = null;
      }

      class174.field2769 = var0;
      class125.method2808(var1);
      class174.field2772.offset = 0;
      class221.field3215 = null;
      class18.field261 = null;
      class174.field2773 = 0;

      while(true) {
         class175 var2 = (class175)class174.field2765.method3825();
         if(var2 == null) {
            while(true) {
               var2 = (class175)class174.field2764.method3825();
               if(null == var2) {
                  if(class174.field2766 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2556(4);
                        var7.method2556(class174.field2766);
                        var7.method2638(0);
                        class174.field2769.method3027(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class174.field2769.method3020();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class174.field2778;
                        class174.field2769 = null;
                     }
                  }

                  class174.field2761 = 0;
                  class174.field2762 = class169.method3276();
                  return;
               }

               class174.field2767.method3916(var2);
               class174.field2768.method3822(var2, var2.hash);
               ++class174.field2779;
               --class174.field2771;
            }
         }

         class174.field2776.method3822(var2, var2.hash);
         ++class174.field2774;
         --class174.field2775;
      }
   }
}
