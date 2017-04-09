import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class230 extends Node {
   @ObfuscatedName("ay")
   String field3268;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1777767443
   )
   int field3272;
   @ObfuscatedName("ad")
   String field3273;
   @ObfuscatedName("af")
   int[] field3275 = new int[3];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 52484099
   )
   int field3276;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 418618499
   )
   int field3278;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2057216859
   )
   int field3279;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -721312797
   )
   int field3280;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1905783903
   )
   int field3281;
   @ObfuscatedName("ar")
   boolean field3282;
   @ObfuscatedName("l")
   boolean field3283;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 907460025
   )
   int field3284;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 362852809
   )
   int field3286;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -763017519
   )
   int field3287;
   @ObfuscatedName("av")
   String field3288;
   @ObfuscatedName("ao")
   String field3289;
   @ObfuscatedName("ae")
   String field3290;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1334635117
   )
   int field3291;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -930700523
   )
   int field3293;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -716535233
   )
   int field3294;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1787599439
   )
   int field3295;
   @ObfuscatedName("ac")
   String field3296;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -477860471
   )
   int field3297;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 302708527
   )
   int field3298;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   void method4269() {
      if(this.field3273.length() > 40) {
         this.field3273 = this.field3273.substring(0, 40);
      }

      if(this.field3288.length() > 40) {
         this.field3288 = this.field3288.substring(0, 40);
      }

      if(this.field3289.length() > 10) {
         this.field3289 = this.field3289.substring(0, 10);
      }

      if(this.field3290.length() > 10) {
         this.field3290 = this.field3290.substring(0, 10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1387210476"
   )
   public void method4270(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3272);
      var1.putByte(this.field3283?1:0);
      var1.putByte(this.field3297);
      var1.putByte(this.field3278);
      var1.putByte(this.field3279);
      var1.putByte(this.field3298);
      var1.putByte(this.field3276);
      var1.putByte(this.field3282?1:0);
      var1.putShort(this.field3295);
      var1.putByte(this.field3284);
      var1.put24bitInt(this.field3287);
      var1.putShort(this.field3286);
      var1.method2933(this.field3273);
      var1.method2933(this.field3288);
      var1.method2933(this.field3289);
      var1.method2933(this.field3290);
      var1.putByte(this.field3280);
      var1.putShort(this.field3291);
      var1.method2933(this.field3268);
      var1.method2933(this.field3296);
      var1.putByte(this.field3281);
      var1.putByte(this.field3294);

      for(int var2 = 0; var2 < this.field3275.length; ++var2) {
         var1.putInt(this.field3275[var2]);
      }

      var1.putInt(this.field3293);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "4878"
   )
   public int method4271() {
      byte var1 = 38;
      String var2 = this.field3273;
      int var3 = var2.length() + 2;
      int var4 = var1 + var3;
      String var5 = this.field3288;
      int var6 = var5.length() + 2;
      var4 += var6;
      String var7 = this.field3289;
      int var8 = var7.length() + 2;
      var4 += var8;
      String var9 = this.field3290;
      int var10 = var9.length() + 2;
      var4 += var10;
      String var11 = this.field3268;
      int var12 = var11.length() + 2;
      var4 += var12;
      String var13 = this.field3296;
      int var14 = var13.length() + 2;
      var4 += var14;
      return var4;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class49.field972.startsWith("win")) {
         this.field3272 = 1;
      } else if(class49.field972.startsWith("mac")) {
         this.field3272 = 2;
      } else if(class49.field972.startsWith("linux")) {
         this.field3272 = 3;
      } else {
         this.field3272 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var12) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var11) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var10) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field3283 = false;
      } else {
         this.field3283 = true;
      }

      if(this.field3272 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3297 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3297 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3297 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3297 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3297 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3297 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3297 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3297 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3297 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3297 = 10;
         }
      } else if(this.field3272 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3297 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3297 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3297 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3297 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3297 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3297 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3297 = 26;
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

      int var6 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var15) {
         ;
      }

      this.field3279 = var7;
      var6 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3298 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var13) {
         ;
      }

      this.field3276 = var7;
      this.field3282 = false;
      this.field3295 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3279 > 3) {
         this.field3284 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3284 = 0;
      }

      this.field3287 = 0;
      if(this.field3273 == null) {
         this.field3273 = "";
      }

      if(this.field3288 == null) {
         this.field3288 = "";
      }

      if(this.field3289 == null) {
         this.field3289 = "";
      }

      if(this.field3290 == null) {
         this.field3290 = "";
      }

      if(this.field3268 == null) {
         this.field3268 = "";
      }

      if(this.field3296 == null) {
         this.field3296 = "";
      }

      this.method4269();
   }
}
