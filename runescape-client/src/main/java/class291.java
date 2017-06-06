import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public class class291 extends Node {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 118917065
   )
   int field3860;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -836965245
   )
   int field3864;
   @ObfuscatedName("h")
   boolean field3865;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -554542937
   )
   int field3866;
   @ObfuscatedName("al")
   boolean field3867;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -28578581
   )
   int field3870;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 134636861
   )
   int field3871;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -752232337
   )
   int field3872;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -956261891
   )
   int field3873;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 447953071
   )
   int field3874;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1783882999
   )
   int field3878;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -678069835
   )
   int field3879;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 697720301
   )
   int field3880;
   @ObfuscatedName("ag")
   String field3881;
   @ObfuscatedName("az")
   String field3882;
   @ObfuscatedName("ax")
   String field3884;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -383064583
   )
   int field3885;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -536966259
   )
   int field3886;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1941082207
   )
   int field3887;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1136582841
   )
   int field3888;
   @ObfuscatedName("ac")
   String field3889;
   @ObfuscatedName("ao")
   String field3890;
   @ObfuscatedName("ak")
   String field3891;
   @ObfuscatedName("am")
   int[] field3892;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1043093720"
   )
   void method5358() {
      if(this.field3881.length() > 40) {
         this.field3881 = this.field3881.substring(0, 40);
      }

      if(this.field3882.length() > 40) {
         this.field3882 = this.field3882.substring(0, 40);
      }

      if(this.field3889.length() > 10) {
         this.field3889 = this.field3889.substring(0, 10);
      }

      if(this.field3884.length() > 10) {
         this.field3884 = this.field3884.substring(0, 10);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "15"
   )
   public void method5359(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3860);
      var1.putByte(this.field3865?1:0);
      var1.putByte(this.field3866);
      var1.putByte(this.field3872);
      var1.putByte(this.field3873);
      var1.putByte(this.field3874);
      var1.putByte(this.field3871);
      var1.putByte(this.field3867?1:0);
      var1.putShort(this.field3864);
      var1.putByte(this.field3878);
      var1.put24bitInt(this.field3879);
      var1.putShort(this.field3880);
      var1.method3253(this.field3881);
      var1.method3253(this.field3882);
      var1.method3253(this.field3889);
      var1.method3253(this.field3884);
      var1.putByte(this.field3870);
      var1.putShort(this.field3885);
      var1.method3253(this.field3891);
      var1.method3253(this.field3890);
      var1.putByte(this.field3887);
      var1.putByte(this.field3888);

      for(int var2 = 0; var2 < this.field3892.length; ++var2) {
         var1.putInt(this.field3892[var2]);
      }

      var1.putInt(this.field3886);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-9"
   )
   public int method5360() {
      byte var1 = 38;
      String var4 = this.field3881;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3882;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3889;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3884;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3891;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3890;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class291(boolean var1) {
      this.field3892 = new int[3];
      if(class155.field2273.startsWith("win")) {
         this.field3860 = 1;
      } else if(class155.field2273.startsWith("mac")) {
         this.field3860 = 2;
      } else if(class155.field2273.startsWith("linux")) {
         this.field3860 = 3;
      } else {
         this.field3860 = 4;
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
         this.field3865 = false;
      } else {
         this.field3865 = true;
      }

      if(this.field3860 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3866 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3866 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3866 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3866 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3866 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3866 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3866 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3866 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3866 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3866 = 10;
         }
      } else if(this.field3860 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3866 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3866 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3866 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3866 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3866 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3866 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3866 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3872 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3872 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3872 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3872 = 5;
      } else {
         this.field3872 = 4;
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

      this.field3873 = var7;
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

      this.field3874 = var7;
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

      this.field3871 = var7;
      this.field3867 = false;
      Runtime.getRuntime();
      this.field3864 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3873 > 3) {
         this.field3878 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3878 = 0;
      }

      this.field3879 = 0;
      if(this.field3881 == null) {
         this.field3881 = "";
      }

      if(this.field3882 == null) {
         this.field3882 = "";
      }

      if(this.field3889 == null) {
         this.field3889 = "";
      }

      if(this.field3884 == null) {
         this.field3884 = "";
      }

      if(this.field3891 == null) {
         this.field3891 = "";
      }

      if(this.field3890 == null) {
         this.field3890 = "";
      }

      this.method5358();
   }
}
