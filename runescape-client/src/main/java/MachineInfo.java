import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1214044975
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("e")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 273601499
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2073241261
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1222379773
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -975809235
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1056142899
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ax")
   boolean field4097;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 974373687
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1186973187
   )
   int field4098;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 786270027
   )
   int field4100;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1440698199
   )
   int field4101;
   @ObfuscatedName("as")
   String field4111;
   @ObfuscatedName("aw")
   String field4103;
   @ObfuscatedName("aq")
   String field4104;
   @ObfuscatedName("aa")
   String field4110;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 524753977
   )
   int field4088;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1105569475
   )
   int field4107;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -813787331
   )
   int field4108;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1193127941
   )
   int field4109;
   @ObfuscatedName("ad")
   String field4105;
   @ObfuscatedName("bg")
   String field4096;
   @ObfuscatedName("br")
   int[] field4112;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1874065581
   )
   int field4113;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4112 = new int[3];
      if(class167.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class167.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class167.osNameLC.startsWith("linux")) {
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

            var7 = var8 - '0' + var7 * 10;
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

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field4097 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4098 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4098 = 0;
      }

      this.field4100 = 0;
      if(this.field4111 == null) {
         this.field4111 = "";
      }

      if(this.field4103 == null) {
         this.field4103 = "";
      }

      if(this.field4104 == null) {
         this.field4104 = "";
      }

      if(this.field4110 == null) {
         this.field4110 = "";
      }

      if(this.field4105 == null) {
         this.field4105 = "";
      }

      if(this.field4096 == null) {
         this.field4096 = "";
      }

      this.method6189();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1149220729"
   )
   void method6189() {
      if(this.field4111.length() > 40) {
         this.field4111 = this.field4111.substring(0, 40);
      }

      if(this.field4103.length() > 40) {
         this.field4103 = this.field4103.substring(0, 40);
      }

      if(this.field4104.length() > 10) {
         this.field4104 = this.field4104.substring(0, 10);
      }

      if(this.field4110.length() > 10) {
         this.field4110 = this.field4110.substring(0, 10);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1426231948"
   )
   public void method6183(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4097?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4098);
      var1.put24bitInt(this.field4100);
      var1.putShort(this.field4101);
      var1.putJagString(this.field4111);
      var1.putJagString(this.field4103);
      var1.putJagString(this.field4104);
      var1.putJagString(this.field4110);
      var1.putByte(this.field4107);
      var1.putShort(this.field4088);
      var1.putJagString(this.field4105);
      var1.putJagString(this.field4096);
      var1.putByte(this.field4108);
      var1.putByte(this.field4109);

      for(int var2 = 0; var2 < this.field4112.length; ++var2) {
         var1.putInt(this.field4112[var2]);
      }

      var1.putInt(this.field4113);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2119758480"
   )
   public int method6190() {
      byte var1 = 38;
      int var2 = var1 + class253.method4541(this.field4111);
      var2 += class253.method4541(this.field4103);
      var2 += class253.method4541(this.field4104);
      var2 += class253.method4541(this.field4110);
      var2 += class253.method4541(this.field4105);
      var2 += class253.method4541(this.field4096);
      return var2;
   }
}
