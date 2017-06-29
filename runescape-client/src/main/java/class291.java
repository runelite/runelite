import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
public class class291 extends Node {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1872568457
   )
   int field3865;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -881272937
   )
   int field3868;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 348433117
   )
   int field3869;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1239595131
   )
   int field3873;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -408433477
   )
   int field3876;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -705103463
   )
   int field3877;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1294713205
   )
   int field3878;
   @ObfuscatedName("am")
   String field3879;
   @ObfuscatedName("af")
   String field3880;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1599747685
   )
   int field3881;
   @ObfuscatedName("v")
   boolean field3882;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1764738387
   )
   int field3883;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1634486215
   )
   int field3884;
   @ObfuscatedName("aa")
   String field3885;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 910908765
   )
   int field3886;
   @ObfuscatedName("av")
   String field3887;
   @ObfuscatedName("az")
   String field3888;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -151518771
   )
   int field3889;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -802335381
   )
   int field3890;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1740957405
   )
   int field3891;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 526220469
   )
   int field3892;
   @ObfuscatedName("ap")
   String field3893;
   @ObfuscatedName("ao")
   boolean field3894;
   @ObfuscatedName("aj")
   int[] field3895;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-25"
   )
   public int method5370() {
      byte var1 = 38;
      int var2 = var1 + Area.method4313(this.field3887);
      var2 += Area.method4313(this.field3885);
      var2 += Area.method4313(this.field3879);
      var2 += Area.method4313(this.field3888);
      var2 += Area.method4313(this.field3893);
      var2 += Area.method4313(this.field3880);
      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1790534427"
   )
   void method5371() {
      if(this.field3887.length() > 40) {
         this.field3887 = this.field3887.substring(0, 40);
      }

      if(this.field3885.length() > 40) {
         this.field3885 = this.field3885.substring(0, 40);
      }

      if(this.field3879.length() > 10) {
         this.field3879 = this.field3879.substring(0, 10);
      }

      if(this.field3888.length() > 10) {
         this.field3888 = this.field3888.substring(0, 10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "85"
   )
   public void method5372(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3868);
      var1.putByte(this.field3882?1:0);
      var1.putByte(this.field3886);
      var1.putByte(this.field3865);
      var1.putByte(this.field3876);
      var1.putByte(this.field3869);
      var1.putByte(this.field3878);
      var1.putByte(this.field3894?1:0);
      var1.putShort(this.field3873);
      var1.putByte(this.field3881);
      var1.put24bitInt(this.field3883);
      var1.putShort(this.field3884);
      var1.method3138(this.field3887);
      var1.method3138(this.field3885);
      var1.method3138(this.field3879);
      var1.method3138(this.field3888);
      var1.putByte(this.field3890);
      var1.putShort(this.field3889);
      var1.method3138(this.field3893);
      var1.method3138(this.field3880);
      var1.putByte(this.field3891);
      var1.putByte(this.field3892);

      for(int var2 = 0; var2 < this.field3895.length; ++var2) {
         var1.putInt(this.field3895[var2]);
      }

      var1.putInt(this.field3877);
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class291(boolean var1) {
      this.field3895 = new int[3];
      if(class155.field2261.startsWith("win")) {
         this.field3868 = 1;
      } else if(class155.field2261.startsWith("mac")) {
         this.field3868 = 2;
      } else if(class155.field2261.startsWith("linux")) {
         this.field3868 = 3;
      } else {
         this.field3868 = 4;
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
         this.field3882 = false;
      } else {
         this.field3882 = true;
      }

      if(this.field3868 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3886 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3886 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3886 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3886 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3886 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3886 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3886 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3886 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3886 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3886 = 10;
         }
      } else if(this.field3868 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3886 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3886 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3886 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3886 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3886 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3886 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3886 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3865 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3865 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3865 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3865 = 5;
      } else {
         this.field3865 = 4;
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
      } catch (Exception var16) {
         ;
      }

      this.field3876 = var7;
      var6 = var5.indexOf(46, 2) + 1;
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
      } catch (Exception var15) {
         ;
      }

      this.field3869 = var7;
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
      } catch (Exception var14) {
         ;
      }

      this.field3878 = var7;
      this.field3894 = false;
      Runtime.getRuntime();
      this.field3873 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3876 > 3) {
         this.field3881 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3881 = 0;
      }

      this.field3883 = 0;
      if(this.field3887 == null) {
         this.field3887 = "";
      }

      if(this.field3885 == null) {
         this.field3885 = "";
      }

      if(this.field3879 == null) {
         this.field3879 = "";
      }

      if(this.field3888 == null) {
         this.field3888 = "";
      }

      if(this.field3893 == null) {
         this.field3893 = "";
      }

      if(this.field3880 == null) {
         this.field3880 = "";
      }

      this.method5371();
   }
}
