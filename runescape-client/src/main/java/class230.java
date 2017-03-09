import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class230 extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2091704115
   )
   int field3269;
   @ObfuscatedName("u")
   boolean field3270;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1537231629
   )
   int field3272;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -763707307
   )
   int field3275;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1192881109
   )
   int field3276;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -292566649
   )
   int field3277;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1840158937
   )
   int field3278;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 785574721
   )
   int field3279;
   @ObfuscatedName("ab")
   boolean field3280;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1739557059
   )
   int field3282;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1371837613
   )
   int field3283;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2138635069
   )
   int field3284;
   @ObfuscatedName("ac")
   String field3285;
   @ObfuscatedName("ap")
   String field3286;
   @ObfuscatedName("ai")
   String field3287;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -930920023
   )
   int field3288;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1284761963
   )
   int field3289;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -999059483
   )
   int field3290;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -685003635
   )
   int field3291;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1661256191
   )
   int field3292;
   @ObfuscatedName("aw")
   String field3293;
   @ObfuscatedName("ad")
   String field3294;
   @ObfuscatedName("au")
   int[] field3295 = new int[3];
   @ObfuscatedName("aj")
   String field3296;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1571447101"
   )
   public void method4292(Buffer var1) {
      var1.method2843(6);
      var1.method2843(this.field3269);
      var1.method2843(this.field3270?1:0);
      var1.method2843(this.field3275);
      var1.method2843(this.field3290);
      var1.method2843(this.field3291);
      var1.method2843(this.field3278);
      var1.method2843(this.field3279);
      var1.method2843(this.field3280?1:0);
      var1.method2817(this.field3282);
      var1.method2843(this.field3288);
      var1.method2818(this.field3283);
      var1.method2817(this.field3284);
      var1.method2823(this.field3296);
      var1.method2823(this.field3286);
      var1.method2823(this.field3287);
      var1.method2823(this.field3285);
      var1.method2843(this.field3277);
      var1.method2817(this.field3276);
      var1.method2823(this.field3293);
      var1.method2823(this.field3294);
      var1.method2843(this.field3289);
      var1.method2843(this.field3292);

      for(int var2 = 0; var2 < this.field3295.length; ++var2) {
         var1.method2819(this.field3295[var2]);
      }

      var1.method2819(this.field3272);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method4293() {
      byte var1 = 38;
      int var2 = var1 + Ignore.method219(this.field3296);
      var2 += Ignore.method219(this.field3286);
      var2 += Ignore.method219(this.field3287);
      var2 += Ignore.method219(this.field3285);
      var2 += Ignore.method219(this.field3293);
      var2 += Ignore.method219(this.field3294);
      return var2;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class104.field1694.startsWith("win")) {
         this.field3269 = 1;
      } else if(class104.field1694.startsWith("mac")) {
         this.field3269 = 2;
      } else if(class104.field1694.startsWith("linux")) {
         this.field3269 = 3;
      } else {
         this.field3269 = 4;
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

      if(this.field3269 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3275 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3275 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3275 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3275 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3275 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3275 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3275 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3275 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3275 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3275 = 10;
         }
      } else if(this.field3269 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3275 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3275 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3275 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3275 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3275 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3275 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3275 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3290 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3290 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3290 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3290 = 5;
      } else {
         this.field3290 = 4;
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

      this.field3291 = var7;
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

      this.field3278 = var7;
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

      this.field3279 = var7;
      this.field3280 = false;
      this.field3282 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3291 > 3) {
         this.field3288 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3288 = 0;
      }

      this.field3283 = 0;
      if(this.field3296 == null) {
         this.field3296 = "";
      }

      if(this.field3286 == null) {
         this.field3286 = "";
      }

      if(null == this.field3287) {
         this.field3287 = "";
      }

      if(null == this.field3285) {
         this.field3285 = "";
      }

      if(null == this.field3293) {
         this.field3293 = "";
      }

      if(this.field3294 == null) {
         this.field3294 = "";
      }

      this.method4298();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "257728408"
   )
   void method4298() {
      if(this.field3296.length() > 40) {
         this.field3296 = this.field3296.substring(0, 40);
      }

      if(this.field3286.length() > 40) {
         this.field3286 = this.field3286.substring(0, 40);
      }

      if(this.field3287.length() > 10) {
         this.field3287 = this.field3287.substring(0, 10);
      }

      if(this.field3285.length() > 10) {
         this.field3285 = this.field3285.substring(0, 10);
      }

   }
}
