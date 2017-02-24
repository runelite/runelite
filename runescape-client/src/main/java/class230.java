import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class230 extends Node {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1761052127
   )
   int field3261;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1647865529
   )
   int field3262;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1418550489
   )
   int field3265;
   @ObfuscatedName("r")
   boolean field3267;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -302321889
   )
   int field3268;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 549933203
   )
   int field3271;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1125634969
   )
   int field3272;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -609581577
   )
   int field3274;
   @ObfuscatedName("al")
   String field3275;
   @ObfuscatedName("ao")
   boolean field3276;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2078813499
   )
   int field3277;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 222717851
   )
   int field3278;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1569070685
   )
   int field3279;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 196164221
   )
   int field3280;
   @ObfuscatedName("ak")
   String field3281;
   @ObfuscatedName("ag")
   String field3282;
   @ObfuscatedName("an")
   String field3284;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1107672475
   )
   int field3285;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -130420503
   )
   int field3286;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 2050222821
   )
   int field3287;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -999829833
   )
   int field3288;
   @ObfuscatedName("av")
   String field3289;
   @ObfuscatedName("af")
   String field3290;
   @ObfuscatedName("ax")
   int[] field3291 = new int[3];

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-451347261"
   )
   void method4297() {
      if(this.field3281.length() > 40) {
         this.field3281 = this.field3281.substring(0, 40);
      }

      if(this.field3282.length() > 40) {
         this.field3282 = this.field3282.substring(0, 40);
      }

      if(this.field3275.length() > 10) {
         this.field3275 = this.field3275.substring(0, 10);
      }

      if(this.field3284.length() > 10) {
         this.field3284 = this.field3284.substring(0, 10);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-144598683"
   )
   public void method4298(Buffer var1) {
      var1.method2918(6);
      var1.method2918(this.field3268);
      var1.method2918(this.field3267?1:0);
      var1.method2918(this.field3271);
      var1.method2918(this.field3272);
      var1.method2918(this.field3287);
      var1.method2918(this.field3274);
      var1.method2918(this.field3261);
      var1.method2918(this.field3276?1:0);
      var1.method2831(this.field3277);
      var1.method2918(this.field3278);
      var1.method2961(this.field3279);
      var1.method2831(this.field3280);
      var1.method2825(this.field3281);
      var1.method2825(this.field3282);
      var1.method2825(this.field3275);
      var1.method2825(this.field3284);
      var1.method2918(this.field3286);
      var1.method2831(this.field3285);
      var1.method2825(this.field3289);
      var1.method2825(this.field3290);
      var1.method2918(this.field3262);
      var1.method2918(this.field3288);

      for(int var2 = 0; var2 < this.field3291.length; ++var2) {
         var1.method2821(this.field3291[var2]);
      }

      var1.method2821(this.field3265);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1891861446"
   )
   public int method4300() {
      byte var1 = 38;
      String var4 = this.field3281;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3282;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3275;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3284;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3289;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3290;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(TextureProvider.field1212.startsWith("win")) {
         this.field3268 = 1;
      } else if(TextureProvider.field1212.startsWith("mac")) {
         this.field3268 = 2;
      } else if(TextureProvider.field1212.startsWith("linux")) {
         this.field3268 = 3;
      } else {
         this.field3268 = 4;
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
         this.field3267 = false;
      } else {
         this.field3267 = true;
      }

      if(this.field3268 == 1) {
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
      } else if(this.field3268 == 2) {
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
         this.field3272 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3272 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3272 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3272 = 5;
      } else {
         this.field3272 = 4;
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

      this.field3287 = var7;
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

      this.field3274 = var7;
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

      this.field3261 = var7;
      this.field3276 = false;
      this.field3277 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3287 > 3) {
         this.field3278 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3278 = 0;
      }

      this.field3279 = 0;
      if(this.field3281 == null) {
         this.field3281 = "";
      }

      if(null == this.field3282) {
         this.field3282 = "";
      }

      if(null == this.field3275) {
         this.field3275 = "";
      }

      if(null == this.field3284) {
         this.field3284 = "";
      }

      if(null == this.field3289) {
         this.field3289 = "";
      }

      if(this.field3290 == null) {
         this.field3290 = "";
      }

      this.method4297();
   }
}
