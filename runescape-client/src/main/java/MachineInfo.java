import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("av")
   String field3887;
   @ObfuscatedName("aj")
   int[] field3895;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -881272937
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("aa")
   String field3885;
   @ObfuscatedName("v")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 910908765
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("am")
   String field3879;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1872568457
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -408433477
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("az")
   String field3888;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 348433117
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ap")
   String field3893;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1294713205
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ao")
   boolean field3894;
   @ObfuscatedName("af")
   String field3880;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1239595131
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1599747685
   )
   int field3881;
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
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -802335381
   )
   int field3890;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -151518771
   )
   int field3889;
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
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -705103463
   )
   int field3877;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3895 = new int[3];
      if(class155.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class155.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class155.osNameLC.startsWith("linux")) {
         this.osType = 3;
      } else {
         this.osType = 4;
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
         this.os32Bit = false;
      } else {
         this.os32Bit = true;
      }

      if(this.osType == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.osVersionType = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.osVersionType = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.osVersionType = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.osVersionType = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.osVersionType = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.osVersionType = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.osVersionType = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.osVersionType = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.osVersionType = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.osVersionType = 10;
         }
      } else if(this.osType == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.osVersionType = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.osVersionType = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.osVersionType = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.osVersionType = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.osVersionType = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.osVersionType = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.osVersionType = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.javaVendorType = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.javaVendorType = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.javaVendorType = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.javaVendorType = 5;
      } else {
         this.javaVendorType = 4;
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

            var7 = var8 - 48 + 10 * var7;
            ++var6;
         }
      } catch (Exception var16) {
         ;
      }

      this.javaVersionMajor = var7;
      var6 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var6;
         }
      } catch (Exception var15) {
         ;
      }

      this.javaVersionMinor = var7;
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

      this.javaVersionPatch = var7;
      this.field3894 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "85"
   )
   public void method5372(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3894?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3881);
      var1.put24bitInt(this.field3883);
      var1.putShort(this.field3884);
      var1.putJagString(this.field3887);
      var1.putJagString(this.field3885);
      var1.putJagString(this.field3879);
      var1.putJagString(this.field3888);
      var1.putByte(this.field3890);
      var1.putShort(this.field3889);
      var1.putJagString(this.field3893);
      var1.putJagString(this.field3880);
      var1.putByte(this.field3891);
      var1.putByte(this.field3892);

      for(int var2 = 0; var2 < this.field3895.length; ++var2) {
         var1.putInt(this.field3895[var2]);
      }

      var1.putInt(this.field3877);
   }
}
