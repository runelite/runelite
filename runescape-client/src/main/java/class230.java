import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class230 extends Node {
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1171118661
   )
   int field3263;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1413692663
   )
   int field3267;
   @ObfuscatedName("j")
   boolean field3268;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -998383313
   )
   int field3271;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1067358779
   )
   int field3273;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1620074859
   )
   int field3274;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1172275519
   )
   int field3275;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2119943151
   )
   int field3276;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -278351233
   )
   int field3277;
   @ObfuscatedName("ak")
   int[] field3278 = new int[3];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1384117679
   )
   int field3279;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1645538115
   )
   int field3280;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1310515483
   )
   int field3281;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -592246633
   )
   int field3282;
   @ObfuscatedName("az")
   String field3284;
   @ObfuscatedName("av")
   String field3285;
   @ObfuscatedName("ap")
   String field3286;
   @ObfuscatedName("ar")
   String field3287;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -188568457
   )
   int field3288;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -308498611
   )
   int field3289;
   @ObfuscatedName("af")
   boolean field3290;
   @ObfuscatedName("ah")
   String field3291;
   @ObfuscatedName("am")
   String field3292;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -313915985
   )
   int field3294;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   void method4296() {
      if(this.field3287.length() > 40) {
         this.field3287 = this.field3287.substring(0, 40);
      }

      if(this.field3284.length() > 40) {
         this.field3284 = this.field3284.substring(0, 40);
      }

      if(this.field3285.length() > 10) {
         this.field3285 = this.field3285.substring(0, 10);
      }

      if(this.field3286.length() > 10) {
         this.field3286 = this.field3286.substring(0, 10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "75"
   )
   public void method4297(Buffer var1) {
      var1.method2873(6);
      var1.method2873(this.field3267);
      var1.method2873(this.field3268?1:0);
      var1.method2873(this.field3273);
      var1.method2873(this.field3274);
      var1.method2873(this.field3281);
      var1.method2873(this.field3276);
      var1.method2873(this.field3294);
      var1.method2873(this.field3290?1:0);
      var1.method2872(this.field3279);
      var1.method2873(this.field3271);
      var1.method2871(this.field3275);
      var1.method2872(this.field3282);
      var1.method2878(this.field3287);
      var1.method2878(this.field3284);
      var1.method2878(this.field3285);
      var1.method2878(this.field3286);
      var1.method2873(this.field3288);
      var1.method2872(this.field3277);
      var1.method2878(this.field3291);
      var1.method2878(this.field3292);
      var1.method2873(this.field3289);
      var1.method2873(this.field3280);

      for(int var2 = 0; var2 < this.field3278.length; ++var2) {
         var1.method2874(this.field3278[var2]);
      }

      var1.method2874(this.field3263);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "32"
   )
   public int method4298() {
      byte var1 = 38;
      String var4 = this.field3287;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3284;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3285;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3286;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3291;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3292;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class32.field738.startsWith("win")) {
         this.field3267 = 1;
      } else if(class32.field738.startsWith("mac")) {
         this.field3267 = 2;
      } else if(class32.field738.startsWith("linux")) {
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
         this.field3268 = false;
      } else {
         this.field3268 = true;
      }

      if(this.field3267 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3273 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3273 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3273 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3273 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3273 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3273 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3273 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3273 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3273 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3273 = 10;
         }
      } else if(this.field3267 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3273 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3273 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3273 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3273 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3273 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3273 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3273 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3274 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3274 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3274 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3274 = 5;
      } else {
         this.field3274 = 4;
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

      this.field3281 = var7;
      var9 = var5.indexOf(46, 2) + 1;
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
      } catch (Exception var15) {
         ;
      }

      this.field3276 = var7;
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

      this.field3294 = var7;
      this.field3290 = false;
      this.field3279 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3281 > 3) {
         this.field3271 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3271 = 0;
      }

      this.field3275 = 0;
      if(null == this.field3287) {
         this.field3287 = "";
      }

      if(null == this.field3284) {
         this.field3284 = "";
      }

      if(null == this.field3285) {
         this.field3285 = "";
      }

      if(null == this.field3286) {
         this.field3286 = "";
      }

      if(null == this.field3291) {
         this.field3291 = "";
      }

      if(null == this.field3292) {
         this.field3292 = "";
      }

      this.method4296();
   }
}
