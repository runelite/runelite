import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class230 extends Node {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 54477397
   )
   int field3249;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1899949341
   )
   int field3252;
   @ObfuscatedName("ad")
   String field3253;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 410211807
   )
   int field3255;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -906843269
   )
   int field3256;
   @ObfuscatedName("aa")
   String field3258;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 157103563
   )
   int field3259;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 863123917
   )
   int field3260;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 72480717
   )
   int field3262;
   @ObfuscatedName("ag")
   boolean field3263;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1421263361
   )
   int field3264;
   @ObfuscatedName("ar")
   String field3265;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -999987377
   )
   int field3266;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1843925385
   )
   int field3267;
   @ObfuscatedName("al")
   String field3269;
   @ObfuscatedName("c")
   boolean field3270;
   @ObfuscatedName("ao")
   int[] field3271 = new int[3];
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2134262155
   )
   int field3272;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -555070081
   )
   int field3273;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -594203353
   )
   int field3274;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 247631853
   )
   int field3275;
   @ObfuscatedName("aj")
   String field3277;
   @ObfuscatedName("ah")
   String field3278;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1818158869
   )
   int field3279;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-552704590"
   )
   void method4329() {
      if(this.field3253.length() > 40) {
         this.field3253 = this.field3253.substring(0, 40);
      }

      if(this.field3278.length() > 40) {
         this.field3278 = this.field3278.substring(0, 40);
      }

      if(this.field3269.length() > 10) {
         this.field3269 = this.field3269.substring(0, 10);
      }

      if(this.field3258.length() > 10) {
         this.field3258 = this.field3258.substring(0, 10);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "89"
   )
   public void method4330(Buffer var1) {
      var1.method2975(6);
      var1.method2975(this.field3252);
      var1.method2975(this.field3270?1:0);
      var1.method2975(this.field3267);
      var1.method2975(this.field3259);
      var1.method2975(this.field3260);
      var1.method2975(this.field3255);
      var1.method2975(this.field3262);
      var1.method2975(this.field3263?1:0);
      var1.method2976(this.field3264);
      var1.method2975(this.field3256);
      var1.method2977(this.field3266);
      var1.method2976(this.field3249);
      var1.method2982(this.field3253);
      var1.method2982(this.field3278);
      var1.method2982(this.field3269);
      var1.method2982(this.field3258);
      var1.method2975(this.field3273);
      var1.method2976(this.field3272);
      var1.method2982(this.field3265);
      var1.method2982(this.field3277);
      var1.method2975(this.field3274);
      var1.method2975(this.field3275);

      for(int var2 = 0; var2 < this.field3271.length; ++var2) {
         var1.method2978(this.field3271[var2]);
      }

      var1.method2978(this.field3279);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "20661624"
   )
   public int method4331() {
      byte var1 = 38;
      String var4 = this.field3253;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3278;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3269;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3258;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3265;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3277;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class26.field591.startsWith("win")) {
         this.field3252 = 1;
      } else if(class26.field591.startsWith("mac")) {
         this.field3252 = 2;
      } else if(class26.field591.startsWith("linux")) {
         this.field3252 = 3;
      } else {
         this.field3252 = 4;
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
         this.field3270 = false;
      } else {
         this.field3270 = true;
      }

      if(this.field3252 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3267 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3267 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3267 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3267 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3267 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3267 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3267 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3267 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3267 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3267 = 10;
         }
      } else if(this.field3252 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3267 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3267 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3267 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3267 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3267 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3267 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3267 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3259 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3259 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3259 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3259 = 5;
      } else {
         this.field3259 = 4;
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

      this.field3260 = var7;
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

      this.field3255 = var7;
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

      this.field3262 = var7;
      this.field3263 = false;
      this.field3264 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3260 > 3) {
         this.field3256 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3256 = 0;
      }

      this.field3266 = 0;
      if(this.field3253 == null) {
         this.field3253 = "";
      }

      if(null == this.field3278) {
         this.field3278 = "";
      }

      if(null == this.field3269) {
         this.field3269 = "";
      }

      if(null == this.field3258) {
         this.field3258 = "";
      }

      if(null == this.field3265) {
         this.field3265 = "";
      }

      if(this.field3277 == null) {
         this.field3277 = "";
      }

      this.method4329();
   }
}
