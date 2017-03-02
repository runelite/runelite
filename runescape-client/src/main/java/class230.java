import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class230 extends Node {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1967539647
   )
   int field3267;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -668863233
   )
   int field3270;
   @ObfuscatedName("n")
   boolean field3271;
   @ObfuscatedName("aq")
   int[] field3272 = new int[3];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1013287249
   )
   int field3277;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1323341405
   )
   int field3278;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1510993489
   )
   int field3279;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -393069183
   )
   int field3280;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2068815827
   )
   int field3281;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1252929203
   )
   int field3282;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 866724921
   )
   int field3283;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 2093269563
   )
   int field3284;
   @ObfuscatedName("au")
   boolean field3285;
   @ObfuscatedName("ar")
   String field3287;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 736063333
   )
   int field3288;
   @ObfuscatedName("ad")
   String field3289;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1222991999
   )
   int field3290;
   @ObfuscatedName("al")
   String field3291;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 518741421
   )
   int field3292;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 145351047
   )
   int field3293;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2027950455
   )
   int field3294;
   @ObfuscatedName("ao")
   String field3296;
   @ObfuscatedName("ag")
   String field3297;
   @ObfuscatedName("az")
   String field3298;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1270195677"
   )
   public int method4381() {
      byte var1 = 38;
      int var2 = var1 + class214.method4064(this.field3287);
      var2 += class214.method4064(this.field3297);
      var2 += class214.method4064(this.field3289);
      var2 += class214.method4064(this.field3291);
      var2 += class214.method4064(this.field3298);
      var2 += class214.method4064(this.field3296);
      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1529500875"
   )
   void method4382() {
      if(this.field3287.length() > 40) {
         this.field3287 = this.field3287.substring(0, 40);
      }

      if(this.field3297.length() > 40) {
         this.field3297 = this.field3297.substring(0, 40);
      }

      if(this.field3289.length() > 10) {
         this.field3289 = this.field3289.substring(0, 10);
      }

      if(this.field3291.length() > 10) {
         this.field3291 = this.field3291.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class104.field1685.startsWith("win")) {
         this.field3270 = 1;
      } else if(class104.field1685.startsWith("mac")) {
         this.field3270 = 2;
      } else if(class104.field1685.startsWith("linux")) {
         this.field3270 = 3;
      } else {
         this.field3270 = 4;
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
         this.field3271 = false;
      } else {
         this.field3271 = true;
      }

      if(this.field3270 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3277 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3277 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3277 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3277 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3277 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3277 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3277 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3277 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3277 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3277 = 10;
         }
      } else if(this.field3270 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3277 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3277 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3277 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3277 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3277 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3277 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3277 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3278 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3278 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3278 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3278 = 5;
      } else {
         this.field3278 = 4;
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

      this.field3279 = var7;
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

      this.field3280 = var7;
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

      this.field3290 = var7;
      this.field3285 = false;
      this.field3283 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3279 > 3) {
         this.field3284 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3284 = 0;
      }

      this.field3267 = 0;
      if(null == this.field3287) {
         this.field3287 = "";
      }

      if(null == this.field3297) {
         this.field3297 = "";
      }

      if(null == this.field3289) {
         this.field3289 = "";
      }

      if(null == this.field3291) {
         this.field3291 = "";
      }

      if(null == this.field3298) {
         this.field3298 = "";
      }

      if(null == this.field3296) {
         this.field3296 = "";
      }

      this.method4382();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "710523428"
   )
   public void method4387(Buffer var1) {
      var1.method3010(6);
      var1.method3010(this.field3270);
      var1.method3010(this.field3271?1:0);
      var1.method3010(this.field3277);
      var1.method3010(this.field3278);
      var1.method3010(this.field3279);
      var1.method3010(this.field3280);
      var1.method3010(this.field3290);
      var1.method3010(this.field3285?1:0);
      var1.method2842(this.field3283);
      var1.method3010(this.field3284);
      var1.method2862(this.field3267);
      var1.method2842(this.field3282);
      var1.method3055(this.field3287);
      var1.method3055(this.field3297);
      var1.method3055(this.field3289);
      var1.method3055(this.field3291);
      var1.method3010(this.field3292);
      var1.method2842(this.field3281);
      var1.method3055(this.field3298);
      var1.method3055(this.field3296);
      var1.method3010(this.field3293);
      var1.method3010(this.field3294);

      for(int var2 = 0; var2 < this.field3272.length; ++var2) {
         var1.method2844(this.field3272[var2]);
      }

      var1.method2844(this.field3288);
   }
}
