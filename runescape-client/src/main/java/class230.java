import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class230 extends Node {
   @ObfuscatedName("ag")
   String field3249;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1173830061
   )
   int field3251;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 726943575
   )
   int field3252;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1649190907
   )
   int field3253;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -634690239
   )
   int field3260;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -578851035
   )
   int field3261;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -40289243
   )
   int field3262;
   @ObfuscatedName("ap")
   String field3263;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1996167709
   )
   int field3264;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -835281513
   )
   int field3265;
   @ObfuscatedName("an")
   boolean field3266;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1528859051
   )
   int field3267;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -219980515
   )
   int field3268;
   @ObfuscatedName("af")
   String field3269;
   @ObfuscatedName("aj")
   String field3270;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1189682979
   )
   int field3271;
   @ObfuscatedName("ac")
   String field3272;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1956654391
   )
   int field3273;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1701503799
   )
   int field3274;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1053664613
   )
   int field3276;
   @ObfuscatedName("au")
   String field3277;
   @ObfuscatedName("k")
   boolean field3278;
   @ObfuscatedName("ab")
   int[] field3279 = new int[3];
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -62372543
   )
   int field3280;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1053932098"
   )
   void method4102() {
      if(this.field3269.length() > 40) {
         this.field3269 = this.field3269.substring(0, 40);
      }

      if(this.field3270.length() > 40) {
         this.field3270 = this.field3270.substring(0, 40);
      }

      if(this.field3263.length() > 10) {
         this.field3263 = this.field3263.substring(0, 10);
      }

      if(this.field3272.length() > 10) {
         this.field3272 = this.field3272.substring(0, 10);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1926735609"
   )
   public void method4103(Buffer var1) {
      var1.method2708(6);
      var1.method2708(this.field3267);
      var1.method2708(this.field3278?1:0);
      var1.method2708(this.field3271);
      var1.method2708(this.field3260);
      var1.method2708(this.field3253);
      var1.method2708(this.field3261);
      var1.method2708(this.field3262);
      var1.method2708(this.field3266?1:0);
      var1.method2709(this.field3264);
      var1.method2708(this.field3265);
      var1.method2710(this.field3252);
      var1.method2709(this.field3268);
      var1.method2715(this.field3269);
      var1.method2715(this.field3270);
      var1.method2715(this.field3263);
      var1.method2715(this.field3272);
      var1.method2708(this.field3274);
      var1.method2709(this.field3273);
      var1.method2715(this.field3277);
      var1.method2715(this.field3249);
      var1.method2708(this.field3251);
      var1.method2708(this.field3276);

      for(int var2 = 0; var2 < this.field3279.length; ++var2) {
         var1.method2711(this.field3279[var2]);
      }

      var1.method2711(this.field3280);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class195.field2869.startsWith("win")) {
         this.field3267 = 1;
      } else if(class195.field2869.startsWith("mac")) {
         this.field3267 = 2;
      } else if(class195.field2869.startsWith("linux")) {
         this.field3267 = 3;
      } else {
         this.field3267 = 4;
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
         this.field3278 = false;
      } else {
         this.field3278 = true;
      }

      if(this.field3267 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3271 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3271 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3271 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3271 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3271 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3271 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3271 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3271 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3271 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3271 = 10;
         }
      } else if(this.field3267 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3271 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3271 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3271 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3271 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3271 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3271 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3271 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3260 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3260 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3260 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3260 = 5;
      } else {
         this.field3260 = 4;
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

      this.field3253 = var7;
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

      this.field3261 = var7;
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

      this.field3262 = var7;
      this.field3266 = false;
      this.field3264 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3253 > 3) {
         this.field3265 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3265 = 0;
      }

      this.field3252 = 0;
      if(this.field3269 == null) {
         this.field3269 = "";
      }

      if(null == this.field3270) {
         this.field3270 = "";
      }

      if(null == this.field3263) {
         this.field3263 = "";
      }

      if(null == this.field3272) {
         this.field3272 = "";
      }

      if(null == this.field3277) {
         this.field3277 = "";
      }

      if(null == this.field3249) {
         this.field3249 = "";
      }

      this.method4102();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-57"
   )
   public int method4111() {
      byte var1 = 38;
      int var2 = var1 + XItemContainer.method147(this.field3269);
      var2 += XItemContainer.method147(this.field3270);
      var2 += XItemContainer.method147(this.field3263);
      var2 += XItemContainer.method147(this.field3272);
      var2 += XItemContainer.method147(this.field3277);
      var2 += XItemContainer.method147(this.field3249);
      return var2;
   }
}
