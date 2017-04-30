import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class234 extends Node {
   @ObfuscatedName("ar")
   String field3281;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -490263455
   )
   int field3284;
   @ObfuscatedName("u")
   boolean field3285;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1379842905
   )
   int field3287;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 547712827
   )
   int field3288;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1950981719
   )
   int field3289;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1359113323
   )
   int field3292;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1014962507
   )
   int field3294;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1362891721
   )
   int field3295;
   @ObfuscatedName("ay")
   boolean field3296;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1465648655
   )
   int field3297;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1852410501
   )
   int field3299;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1101505929
   )
   int field3300;
   @ObfuscatedName("ab")
   String field3302;
   @ObfuscatedName("as")
   String field3303;
   @ObfuscatedName("ai")
   String field3304;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 722206763
   )
   int field3305;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1392918223
   )
   int field3306;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 734875343
   )
   int field3307;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1761772603
   )
   int field3308;
   @ObfuscatedName("ah")
   String field3309;
   @ObfuscatedName("ap")
   String field3310;
   @ObfuscatedName("au")
   int[] field3311;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1715044749
   )
   int field3312;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1659336836"
   )
   public void method4341(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3284);
      var1.putByte(this.field3285?1:0);
      var1.putByte(this.field3305);
      var1.putByte(this.field3292);
      var1.putByte(this.field3300);
      var1.putByte(this.field3294);
      var1.putByte(this.field3295);
      var1.putByte(this.field3296?1:0);
      var1.putShort(this.field3297);
      var1.putByte(this.field3312);
      var1.put24bitInt(this.field3299);
      var1.putShort(this.field3288);
      var1.method2447(this.field3281);
      var1.method2447(this.field3302);
      var1.method2447(this.field3303);
      var1.method2447(this.field3304);
      var1.putByte(this.field3289);
      var1.putShort(this.field3306);
      var1.method2447(this.field3309);
      var1.method2447(this.field3310);
      var1.putByte(this.field3307);
      var1.putByte(this.field3308);

      for(int var2 = 0; var2 < this.field3311.length; ++var2) {
         var1.putInt(this.field3311[var2]);
      }

      var1.putInt(this.field3287);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-115"
   )
   void method4342() {
      if(this.field3281.length() > 40) {
         this.field3281 = this.field3281.substring(0, 40);
      }

      if(this.field3302.length() > 40) {
         this.field3302 = this.field3302.substring(0, 40);
      }

      if(this.field3303.length() > 10) {
         this.field3303 = this.field3303.substring(0, 10);
      }

      if(this.field3304.length() > 10) {
         this.field3304 = this.field3304.substring(0, 10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2007763772"
   )
   public int method4344() {
      byte var1 = 38;
      int var2 = var1 + Tile.method1565(this.field3281);
      var2 += Tile.method1565(this.field3302);
      var2 += Tile.method1565(this.field3303);
      var2 += Tile.method1565(this.field3304);
      var2 += Tile.method1565(this.field3309);
      var2 += Tile.method1565(this.field3310);
      return var2;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class234(boolean var1) {
      this.field3311 = new int[3];
      if(Frames.field1553.startsWith("win")) {
         this.field3284 = 1;
      } else if(Frames.field1553.startsWith("mac")) {
         this.field3284 = 2;
      } else if(Frames.field1553.startsWith("linux")) {
         this.field3284 = 3;
      } else {
         this.field3284 = 4;
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
         this.field3285 = false;
      } else {
         this.field3285 = true;
      }

      if(this.field3284 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3305 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3305 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3305 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3305 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3305 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3305 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3305 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3305 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3305 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3305 = 10;
         }
      } else if(this.field3284 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3305 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3305 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3305 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3305 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3305 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3305 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3305 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3292 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3292 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3292 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3292 = 5;
      } else {
         this.field3292 = 4;
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

      this.field3300 = var7;
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

      this.field3294 = var7;
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

      this.field3295 = var7;
      this.field3296 = false;
      Runtime.getRuntime();
      this.field3297 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3300 > 3) {
         this.field3312 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3312 = 0;
      }

      this.field3299 = 0;
      if(this.field3281 == null) {
         this.field3281 = "";
      }

      if(this.field3302 == null) {
         this.field3302 = "";
      }

      if(this.field3303 == null) {
         this.field3303 = "";
      }

      if(this.field3304 == null) {
         this.field3304 = "";
      }

      if(this.field3309 == null) {
         this.field3309 = "";
      }

      if(this.field3310 == null) {
         this.field3310 = "";
      }

      this.method4342();
   }
}
