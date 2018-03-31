import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1145737203
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("z")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -973316379
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -611426277
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -48698859
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1809530315
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1671855805
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("am")
   boolean field4096;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1371046327
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -910570483
   )
   int field4078;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1805549821
   )
   int field4110;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 561914257
   )
   int field4100;
   @ObfuscatedName("ay")
   String field4099;
   @ObfuscatedName("ad")
   String field4104;
   @ObfuscatedName("at")
   String field4095;
   @ObfuscatedName("av")
   String field4093;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1567645335
   )
   int field4105;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1426090425
   )
   int field4106;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -240530697
   )
   int field4107;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 2090071101
   )
   int field4108;
   @ObfuscatedName("an")
   String field4101;
   @ObfuscatedName("bv")
   String field4102;
   @ObfuscatedName("bw")
   int[] field4112;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -538922323
   )
   int field4086;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4112 = new int[3];
      if(class185.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class185.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class185.osNameLC.startsWith("linux")) {
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

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.javaVersionMajor = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var7 * 10 + (var8 - '0');
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.javaVersionMinor = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var7 * 10 + (var8 - '0');
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field4096 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4078 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4078 = 0;
      }

      this.field4110 = 0;
      if(this.field4099 == null) {
         this.field4099 = "";
      }

      if(this.field4104 == null) {
         this.field4104 = "";
      }

      if(this.field4095 == null) {
         this.field4095 = "";
      }

      if(this.field4093 == null) {
         this.field4093 = "";
      }

      if(this.field4101 == null) {
         this.field4101 = "";
      }

      if(this.field4102 == null) {
         this.field4102 = "";
      }

      this.method6227();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1976710595"
   )
   void method6227() {
      if(this.field4099.length() > 40) {
         this.field4099 = this.field4099.substring(0, 40);
      }

      if(this.field4104.length() > 40) {
         this.field4104 = this.field4104.substring(0, 40);
      }

      if(this.field4095.length() > 10) {
         this.field4095 = this.field4095.substring(0, 10);
      }

      if(this.field4093.length() > 10) {
         this.field4093 = this.field4093.substring(0, 10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-1182035128"
   )
   public void method6228(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4096?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4078);
      var1.put24bitInt(this.field4110);
      var1.putShort(this.field4100);
      var1.putJagString(this.field4099);
      var1.putJagString(this.field4104);
      var1.putJagString(this.field4095);
      var1.putJagString(this.field4093);
      var1.putByte(this.field4106);
      var1.putShort(this.field4105);
      var1.putJagString(this.field4101);
      var1.putJagString(this.field4102);
      var1.putByte(this.field4107);
      var1.putByte(this.field4108);

      for(int var2 = 0; var2 < this.field4112.length; ++var2) {
         var1.putInt(this.field4112[var2]);
      }

      var1.putInt(this.field4086);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-70303840"
   )
   public int method6238() {
      byte var1 = 38;
      int var2 = var1 + UnitPriceComparator.method139(this.field4099);
      var2 += UnitPriceComparator.method139(this.field4104);
      var2 += UnitPriceComparator.method139(this.field4095);
      var2 += UnitPriceComparator.method139(this.field4093);
      var2 += UnitPriceComparator.method139(this.field4101);
      var2 += UnitPriceComparator.method139(this.field4102);
      return var2;
   }
}
