import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class230 extends Node {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 306430517
   )
   int field3251;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2052935495
   )
   int field3252;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1847661833
   )
   int field3253;
   @ObfuscatedName("l")
   boolean field3254;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 797206543
   )
   int field3257;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1617416971
   )
   int field3258;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1552662393
   )
   int field3259;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1433990945
   )
   int field3260;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1740811457
   )
   int field3261;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 270429259
   )
   int field3262;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -184984435
   )
   int field3263;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1119092997
   )
   int field3264;
   @ObfuscatedName("ad")
   int[] field3265 = new int[3];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1268050547
   )
   int field3266;
   @ObfuscatedName("ar")
   String field3267;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1993325333
   )
   int field3268;
   @ObfuscatedName("al")
   String field3269;
   @ObfuscatedName("ax")
   String field3270;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1674902279
   )
   int field3271;
   @ObfuscatedName("at")
   String field3272;
   @ObfuscatedName("ak")
   boolean field3274;
   @ObfuscatedName("aq")
   String field3275;
   @ObfuscatedName("as")
   String field3276;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1540401359
   )
   int field3278;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1479408996"
   )
   public int method4174() {
      byte var1 = 38;
      String var4 = this.field3267;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3272;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3269;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3270;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3275;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3276;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class229.field3248.startsWith("win")) {
         this.field3264 = 1;
      } else if(class229.field3248.startsWith("mac")) {
         this.field3264 = 2;
      } else if(class229.field3248.startsWith("linux")) {
         this.field3264 = 3;
      } else {
         this.field3264 = 4;
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
         this.field3254 = false;
      } else {
         this.field3254 = true;
      }

      if(this.field3264 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3257 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3257 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3257 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3257 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3257 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3257 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3257 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3257 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3257 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3257 = 10;
         }
      } else if(this.field3264 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3257 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3257 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3257 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3257 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3257 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3257 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3257 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3258 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3258 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3258 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3258 = 5;
      } else {
         this.field3258 = 4;
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

      this.field3259 = var7;
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

      this.field3260 = var7;
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

      this.field3261 = var7;
      this.field3274 = false;
      this.field3263 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3259 > 3) {
         this.field3271 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3271 = 0;
      }

      this.field3268 = 0;
      if(this.field3267 == null) {
         this.field3267 = "";
      }

      if(this.field3272 == null) {
         this.field3272 = "";
      }

      if(null == this.field3269) {
         this.field3269 = "";
      }

      if(this.field3270 == null) {
         this.field3270 = "";
      }

      if(null == this.field3275) {
         this.field3275 = "";
      }

      if(this.field3276 == null) {
         this.field3276 = "";
      }

      this.method4183();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1359457610"
   )
   public void method4175(Buffer var1) {
      var1.method2815(6);
      var1.method2815(this.field3264);
      var1.method2815(this.field3254?1:0);
      var1.method2815(this.field3257);
      var1.method2815(this.field3258);
      var1.method2815(this.field3259);
      var1.method2815(this.field3260);
      var1.method2815(this.field3261);
      var1.method2815(this.field3274?1:0);
      var1.method2712(this.field3263);
      var1.method2815(this.field3271);
      var1.method2713(this.field3268);
      var1.method2712(this.field3266);
      var1.method2718(this.field3267);
      var1.method2718(this.field3272);
      var1.method2718(this.field3269);
      var1.method2718(this.field3270);
      var1.method2815(this.field3251);
      var1.method2712(this.field3252);
      var1.method2718(this.field3275);
      var1.method2718(this.field3276);
      var1.method2815(this.field3253);
      var1.method2815(this.field3262);

      for(int var2 = 0; var2 < this.field3265.length; ++var2) {
         var1.method2714(this.field3265[var2]);
      }

      var1.method2714(this.field3278);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1019867381"
   )
   void method4183() {
      if(this.field3267.length() > 40) {
         this.field3267 = this.field3267.substring(0, 40);
      }

      if(this.field3272.length() > 40) {
         this.field3272 = this.field3272.substring(0, 40);
      }

      if(this.field3269.length() > 10) {
         this.field3269 = this.field3269.substring(0, 10);
      }

      if(this.field3270.length() > 10) {
         this.field3270 = this.field3270.substring(0, 10);
      }

   }
}
