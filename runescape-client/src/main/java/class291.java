import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class291 extends Node {
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 616642245
   )
   int field3862;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 271295507
   )
   int field3865;
   @ObfuscatedName("c")
   boolean field3866;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -875773579
   )
   int field3867;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 520991115
   )
   int field3870;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1783578605
   )
   int field3872;
   @ObfuscatedName("av")
   String field3873;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1288914541
   )
   int field3874;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1593337135
   )
   int field3875;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1829630027
   )
   int field3877;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2050420027
   )
   int field3878;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 512790069
   )
   int field3879;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 707586687
   )
   int field3880;
   @ObfuscatedName("ax")
   String field3881;
   @ObfuscatedName("aq")
   String field3883;
   @ObfuscatedName("af")
   String field3884;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1738909475
   )
   int field3885;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -938217093
   )
   int field3886;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1227789621
   )
   int field3887;
   @ObfuscatedName("au")
   boolean field3888;
   @ObfuscatedName("ap")
   String field3889;
   @ObfuscatedName("ai")
   String field3890;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1640732941
   )
   int field3891;
   @ObfuscatedName("az")
   int[] field3892;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method5381() {
      if(this.field3881.length() > 40) {
         this.field3881 = this.field3881.substring(0, 40);
      }

      if(this.field3873.length() > 40) {
         this.field3873 = this.field3873.substring(0, 40);
      }

      if(this.field3883.length() > 10) {
         this.field3883 = this.field3883.substring(0, 10);
      }

      if(this.field3884.length() > 10) {
         this.field3884 = this.field3884.substring(0, 10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1169728668"
   )
   public void method5382(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3865);
      var1.putByte(this.field3866?1:0);
      var1.putByte(this.field3870);
      var1.putByte(this.field3872);
      var1.putByte(this.field3885);
      var1.putByte(this.field3874);
      var1.putByte(this.field3875);
      var1.putByte(this.field3888?1:0);
      var1.putShort(this.field3877);
      var1.putByte(this.field3878);
      var1.put24bitInt(this.field3879);
      var1.putShort(this.field3880);
      var1.method3151(this.field3881);
      var1.method3151(this.field3873);
      var1.method3151(this.field3883);
      var1.method3151(this.field3884);
      var1.putByte(this.field3891);
      var1.putShort(this.field3886);
      var1.method3151(this.field3889);
      var1.method3151(this.field3890);
      var1.putByte(this.field3887);
      var1.putByte(this.field3867);

      for(int var2 = 0; var2 < this.field3892.length; ++var2) {
         var1.putInt(this.field3892[var2]);
      }

      var1.putInt(this.field3862);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class291(boolean var1) {
      this.field3892 = new int[3];
      if(GameObject.field2203.startsWith("win")) {
         this.field3865 = 1;
      } else if(GameObject.field2203.startsWith("mac")) {
         this.field3865 = 2;
      } else if(GameObject.field2203.startsWith("linux")) {
         this.field3865 = 3;
      } else {
         this.field3865 = 4;
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
         this.field3866 = false;
      } else {
         this.field3866 = true;
      }

      if(this.field3865 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3870 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3870 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3870 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3870 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3870 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3870 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3870 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3870 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3870 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3870 = 10;
         }
      } else if(this.field3865 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3870 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3870 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3870 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3870 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3870 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3870 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3870 = 26;
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

      this.field3885 = var7;
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

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3875 = var7;
      this.field3888 = false;
      Runtime.getRuntime();
      this.field3877 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3885 > 3) {
         this.field3878 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3878 = 0;
      }

      this.field3879 = 0;
      if(this.field3881 == null) {
         this.field3881 = "";
      }

      if(this.field3873 == null) {
         this.field3873 = "";
      }

      if(this.field3883 == null) {
         this.field3883 = "";
      }

      if(this.field3884 == null) {
         this.field3884 = "";
      }

      if(this.field3889 == null) {
         this.field3889 = "";
      }

      if(this.field3890 == null) {
         this.field3890 = "";
      }

      this.method5381();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1416893074"
   )
   public int method5383() {
      byte var1 = 38;
      String var4 = this.field3881;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3873;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3883;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3884;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3889;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3890;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
