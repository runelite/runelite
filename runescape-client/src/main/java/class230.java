import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class230 extends Node {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 564398271
   )
   int field3254;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2121048427
   )
   int field3255;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2060118725
   )
   int field3256;
   @ObfuscatedName("q")
   boolean field3257;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 760625007
   )
   int field3259;
   @ObfuscatedName("ak")
   String field3260;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1494339271
   )
   int field3261;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1932597987
   )
   int field3262;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -511198795
   )
   int field3263;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1349320849
   )
   int field3264;
   @ObfuscatedName("aj")
   boolean field3265;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 227304745
   )
   int field3267;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -901091797
   )
   int field3268;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2016881547
   )
   int field3269;
   @ObfuscatedName("ag")
   String field3270;
   @ObfuscatedName("at")
   String field3271;
   @ObfuscatedName("au")
   String field3272;
   @ObfuscatedName("ax")
   String field3273;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1952663371
   )
   int field3274;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 971193815
   )
   int field3275;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1784029395
   )
   int field3276;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1075484435
   )
   int field3277;
   @ObfuscatedName("av")
   String field3278;
   @ObfuscatedName("an")
   int[] field3280 = new int[3];

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   void method4251() {
      if(this.field3270.length() > 40) {
         this.field3270 = this.field3270.substring(0, 40);
      }

      if(this.field3271.length() > 40) {
         this.field3271 = this.field3271.substring(0, 40);
      }

      if(this.field3272.length() > 10) {
         this.field3272 = this.field3272.substring(0, 10);
      }

      if(this.field3273.length() > 10) {
         this.field3273 = this.field3273.substring(0, 10);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-66"
   )
   public int method4253() {
      byte var1 = 38;
      String var4 = this.field3270;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3271;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3272;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3273;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3278;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3260;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(FileOnDisk.field1195.startsWith("win")) {
         this.field3256 = 1;
      } else if(FileOnDisk.field1195.startsWith("mac")) {
         this.field3256 = 2;
      } else if(FileOnDisk.field1195.startsWith("linux")) {
         this.field3256 = 3;
      } else {
         this.field3256 = 4;
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
         this.field3257 = false;
      } else {
         this.field3257 = true;
      }

      if(this.field3256 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3274 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3274 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3274 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3274 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3274 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3274 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3274 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3274 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3274 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3274 = 10;
         }
      } else if(this.field3256 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3274 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3274 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3274 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3274 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3274 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3274 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3274 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3261 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3261 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3261 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3261 = 5;
      } else {
         this.field3261 = 4;
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

      this.field3255 = var7;
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

      this.field3263 = var7;
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

      this.field3264 = var7;
      this.field3265 = false;
      this.field3259 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3255 > 3) {
         this.field3262 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3262 = 0;
      }

      this.field3268 = 0;
      if(this.field3270 == null) {
         this.field3270 = "";
      }

      if(this.field3271 == null) {
         this.field3271 = "";
      }

      if(null == this.field3272) {
         this.field3272 = "";
      }

      if(this.field3273 == null) {
         this.field3273 = "";
      }

      if(null == this.field3278) {
         this.field3278 = "";
      }

      if(this.field3260 == null) {
         this.field3260 = "";
      }

      this.method4251();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "148940690"
   )
   public void method4257(Buffer var1) {
      var1.method2912(6);
      var1.method2912(this.field3256);
      var1.method2912(this.field3257?1:0);
      var1.method2912(this.field3274);
      var1.method2912(this.field3261);
      var1.method2912(this.field3255);
      var1.method2912(this.field3263);
      var1.method2912(this.field3264);
      var1.method2912(this.field3265?1:0);
      var1.method3094(this.field3259);
      var1.method2912(this.field3262);
      var1.method2914(this.field3268);
      var1.method3094(this.field3269);
      var1.method2919(this.field3270);
      var1.method2919(this.field3271);
      var1.method2919(this.field3272);
      var1.method2919(this.field3273);
      var1.method2912(this.field3275);
      var1.method3094(this.field3254);
      var1.method2919(this.field3278);
      var1.method2919(this.field3260);
      var1.method2912(this.field3267);
      var1.method2912(this.field3277);

      for(int var2 = 0; var2 < this.field3280.length; ++var2) {
         var1.method3057(this.field3280[var2]);
      }

      var1.method3057(this.field3276);
   }
}
