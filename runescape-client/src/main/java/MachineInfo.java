import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -883492797
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("e")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -561427525
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -777075451
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -249646965
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 374452325
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1233310201
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("an")
   boolean field3955;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 287893915
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -335262205
   )
   int field3946;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -446712393
   )
   int field3949;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1535962367
   )
   int field3941;
   @ObfuscatedName("ac")
   String field3933;
   @ObfuscatedName("ai")
   String field3950;
   @ObfuscatedName("ax")
   String field3930;
   @ObfuscatedName("af")
   String field3952;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1361090121
   )
   int field3953;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1191588243
   )
   int field3954;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1987377633
   )
   int field3928;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2102845449
   )
   int field3956;
   @ObfuscatedName("ar")
   String field3957;
   @ObfuscatedName("bu")
   String field3958;
   @ObfuscatedName("bk")
   int[] field3944;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 865177625
   )
   int field3927;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3944 = new int[3];
      if(class87.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class87.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class87.osNameLC.startsWith("linux")) {
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

            var7 = var8 - '0' + var7 * 10;
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
      this.field3955 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3946 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3946 = 0;
      }

      this.field3949 = 0;
      if(this.field3933 == null) {
         this.field3933 = "";
      }

      if(this.field3950 == null) {
         this.field3950 = "";
      }

      if(this.field3930 == null) {
         this.field3930 = "";
      }

      if(this.field3952 == null) {
         this.field3952 = "";
      }

      if(this.field3957 == null) {
         this.field3957 = "";
      }

      if(this.field3958 == null) {
         this.field3958 = "";
      }

      this.method5601();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   void method5601() {
      if(this.field3933.length() > 40) {
         this.field3933 = this.field3933.substring(0, 40);
      }

      if(this.field3950.length() > 40) {
         this.field3950 = this.field3950.substring(0, 40);
      }

      if(this.field3930.length() > 10) {
         this.field3930 = this.field3930.substring(0, 10);
      }

      if(this.field3952.length() > 10) {
         this.field3952 = this.field3952.substring(0, 10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "1337376280"
   )
   public void method5602(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3955?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3946);
      var1.put24bitInt(this.field3949);
      var1.putShort(this.field3941);
      var1.putJagString(this.field3933);
      var1.putJagString(this.field3950);
      var1.putJagString(this.field3930);
      var1.putJagString(this.field3952);
      var1.putByte(this.field3954);
      var1.putShort(this.field3953);
      var1.putJagString(this.field3957);
      var1.putJagString(this.field3958);
      var1.putByte(this.field3928);
      var1.putByte(this.field3956);

      for(int var2 = 0; var2 < this.field3944.length; ++var2) {
         var1.putInt(this.field3944[var2]);
      }

      var1.putInt(this.field3927);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "543792298"
   )
   public int method5603() {
      byte var1 = 38;
      int var2 = var1 + class13.method77(this.field3933);
      var2 += class13.method77(this.field3950);
      var2 += class13.method77(this.field3930);
      var2 += class13.method77(this.field3952);
      var2 += class13.method77(this.field3957);
      var2 += class13.method77(this.field3958);
      return var2;
   }
}
