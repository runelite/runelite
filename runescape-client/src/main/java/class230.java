import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class230 extends Node {
   @ObfuscatedName("ag")
   int[] field3247 = new int[3];
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 339109603
   )
   int field3248;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1987568625
   )
   int field3249;
   @ObfuscatedName("au")
   String field3250;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1419651551
   )
   int field3251;
   @ObfuscatedName("a")
   boolean field3252;
   @ObfuscatedName("o")
   static int[] field3255;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1604426719
   )
   int field3257;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1220809009
   )
   int field3258;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2133360577
   )
   int field3259;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 729767563
   )
   int field3260;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1274080967
   )
   int field3261;
   @ObfuscatedName("am")
   boolean field3262;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -504325343
   )
   int field3263;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 53060743
   )
   int field3266;
   @ObfuscatedName("as")
   String field3268;
   @ObfuscatedName("ar")
   String field3269;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1835888691
   )
   int field3270;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -685225427
   )
   int field3271;
   @ObfuscatedName("al")
   String field3272;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -598349003
   )
   int field3273;
   @ObfuscatedName("ae")
   String field3275;
   @ObfuscatedName("at")
   String field3276;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1672464993
   )
   int field3277;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1475521063
   )
   int field3278;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "97"
   )
   void method4159() {
      if(this.field3272.length() > 40) {
         this.field3272 = this.field3272.substring(0, 40);
      }

      if(this.field3268.length() > 40) {
         this.field3268 = this.field3268.substring(0, 40);
      }

      if(this.field3269.length() > 10) {
         this.field3269 = this.field3269.substring(0, 10);
      }

      if(this.field3276.length() > 10) {
         this.field3276 = this.field3276.substring(0, 10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1228029967"
   )
   public int method4161() {
      byte var1 = 38;
      String var4 = this.field3272;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3268;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3269;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3276;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3275;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3250;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class85.field1462.startsWith("win")) {
         this.field3251 = 1;
      } else if(class85.field1462.startsWith("mac")) {
         this.field3251 = 2;
      } else if(class85.field1462.startsWith("linux")) {
         this.field3251 = 3;
      } else {
         this.field3251 = 4;
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
         this.field3252 = false;
      } else {
         this.field3252 = true;
      }

      if(this.field3251 == 1) {
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
      } else if(this.field3251 == 2) {
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

            var7 = var8 - 48 + var7 * 10;
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

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3261 = var7;
      this.field3262 = false;
      this.field3263 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3259 > 3) {
         this.field3249 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3249 = 0;
      }

      this.field3248 = 0;
      if(null == this.field3272) {
         this.field3272 = "";
      }

      if(null == this.field3268) {
         this.field3268 = "";
      }

      if(this.field3269 == null) {
         this.field3269 = "";
      }

      if(null == this.field3276) {
         this.field3276 = "";
      }

      if(null == this.field3275) {
         this.field3275 = "";
      }

      if(this.field3250 == null) {
         this.field3250 = "";
      }

      this.method4159();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "101"
   )
   public void method4166(Buffer var1) {
      var1.method2932(6);
      var1.method2932(this.field3251);
      var1.method2932(this.field3252?1:0);
      var1.method2932(this.field3257);
      var1.method2932(this.field3258);
      var1.method2932(this.field3259);
      var1.method2932(this.field3260);
      var1.method2932(this.field3261);
      var1.method2932(this.field3262?1:0);
      var1.method2746(this.field3263);
      var1.method2932(this.field3249);
      var1.method2747(this.field3248);
      var1.method2746(this.field3266);
      var1.method2751(this.field3272);
      var1.method2751(this.field3268);
      var1.method2751(this.field3269);
      var1.method2751(this.field3276);
      var1.method2932(this.field3277);
      var1.method2746(this.field3271);
      var1.method2751(this.field3275);
      var1.method2751(this.field3250);
      var1.method2932(this.field3273);
      var1.method2932(this.field3270);

      for(int var2 = 0; var2 < this.field3247.length; ++var2) {
         var1.method2748(this.field3247[var2]);
      }

      var1.method2748(this.field3278);
   }
}
