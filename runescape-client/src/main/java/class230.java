import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class230 extends Node {
   @ObfuscatedName("aq")
   String field3247;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1302280319
   )
   int field3250;
   @ObfuscatedName("d")
   boolean field3251;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1401833017
   )
   int field3255;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 258278471
   )
   int field3259;
   @ObfuscatedName("ac")
   String field3260;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -630753131
   )
   int field3262;
   @ObfuscatedName("ah")
   boolean field3263;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1737022577
   )
   int field3264;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1887116925
   )
   int field3265;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -24436023
   )
   int field3267;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 98594295
   )
   int field3268;
   @ObfuscatedName("ae")
   String field3269;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1865828449
   )
   int field3270;
   @ObfuscatedName("am")
   String field3271;
   @ObfuscatedName("ay")
   String field3272;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1784182391
   )
   int field3273;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1538243859
   )
   int field3274;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -268166019
   )
   int field3275;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 423585935
   )
   int field3276;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1688233011
   )
   int field3277;
   @ObfuscatedName("ao")
   String field3278;
   @ObfuscatedName("au")
   int[] field3279 = new int[3];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 672439349
   )
   int field3280;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(Ignore.field207.startsWith("win")) {
         this.field3250 = 1;
      } else if(Ignore.field207.startsWith("mac")) {
         this.field3250 = 2;
      } else if(Ignore.field207.startsWith("linux")) {
         this.field3250 = 3;
      } else {
         this.field3250 = 4;
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
         this.field3251 = false;
      } else {
         this.field3251 = true;
      }

      if(this.field3250 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3280 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3280 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3280 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3280 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3280 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3280 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3280 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3280 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3280 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3280 = 10;
         }
      } else if(this.field3250 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3280 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3280 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3280 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3280 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3280 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3280 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3280 = 26;
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

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field3275 = var7;
      var9 = var5.indexOf(46, 2) + 1;
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
      } catch (Exception var15) {
         ;
      }

      this.field3270 = var7;
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

      this.field3262 = var7;
      this.field3263 = false;
      this.field3264 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3275 > 3) {
         this.field3277 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3277 = 0;
      }

      this.field3255 = 0;
      if(this.field3247 == null) {
         this.field3247 = "";
      }

      if(null == this.field3260) {
         this.field3260 = "";
      }

      if(null == this.field3271) {
         this.field3271 = "";
      }

      if(this.field3272 == null) {
         this.field3272 = "";
      }

      if(this.field3269 == null) {
         this.field3269 = "";
      }

      if(null == this.field3278) {
         this.field3278 = "";
      }

      this.method4240();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1301384945"
   )
   void method4240() {
      if(this.field3247.length() > 40) {
         this.field3247 = this.field3247.substring(0, 40);
      }

      if(this.field3260.length() > 40) {
         this.field3260 = this.field3260.substring(0, 40);
      }

      if(this.field3271.length() > 10) {
         this.field3271 = this.field3271.substring(0, 10);
      }

      if(this.field3272.length() > 10) {
         this.field3272 = this.field3272.substring(0, 10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1233250370"
   )
   public void method4243(Buffer var1) {
      var1.method2760(6);
      var1.method2760(this.field3250);
      var1.method2760(this.field3251?1:0);
      var1.method2760(this.field3280);
      var1.method2760(this.field3259);
      var1.method2760(this.field3275);
      var1.method2760(this.field3270);
      var1.method2760(this.field3262);
      var1.method2760(this.field3263?1:0);
      var1.method2918(this.field3264);
      var1.method2760(this.field3277);
      var1.method2914(this.field3255);
      var1.method2918(this.field3268);
      var1.method2767(this.field3247);
      var1.method2767(this.field3260);
      var1.method2767(this.field3271);
      var1.method2767(this.field3272);
      var1.method2760(this.field3274);
      var1.method2918(this.field3273);
      var1.method2767(this.field3269);
      var1.method2767(this.field3278);
      var1.method2760(this.field3267);
      var1.method2760(this.field3276);

      for(int var2 = 0; var2 < this.field3279.length; ++var2) {
         var1.method2763(this.field3279[var2]);
      }

      var1.method2763(this.field3265);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1014477699"
   )
   public int method4246() {
      byte var1 = 38;
      int var2 = var1 + CollisionData.method2265(this.field3247);
      var2 += CollisionData.method2265(this.field3260);
      var2 += CollisionData.method2265(this.field3271);
      var2 += CollisionData.method2265(this.field3272);
      var2 += CollisionData.method2265(this.field3269);
      var2 += CollisionData.method2265(this.field3278);
      return var2;
   }
}
