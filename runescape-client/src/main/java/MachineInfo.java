import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 458916853
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("b")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1937140007
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1863978913
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1750432265
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 628955833
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1574529329
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("am")
   boolean field3928;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -677656475
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1724104549
   )
   int field3941;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1121381813
   )
   int field3942;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1035705031
   )
   int field3925;
   @ObfuscatedName("ay")
   String field3944;
   @ObfuscatedName("ar")
   String field3945;
   @ObfuscatedName("ac")
   String field3933;
   @ObfuscatedName("af")
   String field3947;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -14628357
   )
   int field3943;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1822587431
   )
   int field3949;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -838944783
   )
   int field3950;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 756049433
   )
   int field3936;
   @ObfuscatedName("at")
   String field3952;
   @ObfuscatedName("bj")
   String field3953;
   @ObfuscatedName("bq")
   int[] field3954;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -881230983
   )
   int field3955;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3954 = new int[3];
      if(class45.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class45.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class45.osNameLC.startsWith("linux")) {
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
         this.os64Bit = false;
      } else {
         this.os64Bit = true;
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
         } else if(var3.indexOf("10.0") != -1) {
            this.osVersionType = 11;
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
         } else if(var3.indexOf("10.11") != -1) {
            this.osVersionType = 27;
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
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
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
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var7 * 10 + (var8 - '0');
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
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3928 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3941 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3941 = 0;
      }

      this.field3942 = 0;
      if(this.field3944 == null) {
         this.field3944 = "";
      }

      if(this.field3945 == null) {
         this.field3945 = "";
      }

      if(this.field3933 == null) {
         this.field3933 = "";
      }

      if(this.field3947 == null) {
         this.field3947 = "";
      }

      if(this.field3952 == null) {
         this.field3952 = "";
      }

      if(this.field3953 == null) {
         this.field3953 = "";
      }

      this.method5588();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-20226"
   )
   void method5588() {
      if(this.field3944.length() > 40) {
         this.field3944 = this.field3944.substring(0, 40);
      }

      if(this.field3945.length() > 40) {
         this.field3945 = this.field3945.substring(0, 40);
      }

      if(this.field3933.length() > 10) {
         this.field3933 = this.field3933.substring(0, 10);
      }

      if(this.field3947.length() > 10) {
         this.field3947 = this.field3947.substring(0, 10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1857668112"
   )
   public void method5589(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3928?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3941);
      var1.put24bitInt(this.field3942);
      var1.putShort(this.field3925);
      var1.putJagString(this.field3944);
      var1.putJagString(this.field3945);
      var1.putJagString(this.field3933);
      var1.putJagString(this.field3947);
      var1.putByte(this.field3949);
      var1.putShort(this.field3943);
      var1.putJagString(this.field3952);
      var1.putJagString(this.field3953);
      var1.putByte(this.field3950);
      var1.putByte(this.field3936);

      for(int var2 = 0; var2 < this.field3954.length; ++var2) {
         var1.putInt(this.field3954[var2]);
      }

      var1.putInt(this.field3955);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-37"
   )
   public int method5587() {
      byte var1 = 38;
      int var2 = var1 + SceneTilePaint.method2795(this.field3944);
      var2 += SceneTilePaint.method2795(this.field3945);
      var2 += SceneTilePaint.method2795(this.field3933);
      var2 += SceneTilePaint.method2795(this.field3947);
      var2 += SceneTilePaint.method2795(this.field3952);
      var2 += SceneTilePaint.method2795(this.field3953);
      return var2;
   }
}
