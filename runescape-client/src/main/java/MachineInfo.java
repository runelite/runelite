import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ln")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1071768327
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("k")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 213276607
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1095799593
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1885130535
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 786818877
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1437628309
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("aq")
   boolean field4092;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1736019619
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 345355221
   )
   int field4105;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 102047533
   )
   int field4096;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 916850593
   )
   int field4097;
   @ObfuscatedName("an")
   String field4087;
   @ObfuscatedName("ax")
   String field4099;
   @ObfuscatedName("ah")
   String field4098;
   @ObfuscatedName("ab")
   String field4091;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2142643413
   )
   int field4079;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 673685815
   )
   int field4102;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1124434615
   )
   int field4104;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 990155401
   )
   int field4101;
   @ObfuscatedName("av")
   String field4090;
   @ObfuscatedName("bc")
   String field4107;
   @ObfuscatedName("br")
   int[] field4108;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 662645347
   )
   int field4109;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4108 = new int[3];
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

            var7 = var7 * 10 + (var8 - '0');
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

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field4092 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4105 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4105 = 0;
      }

      this.field4096 = 0;
      if(this.field4087 == null) {
         this.field4087 = "";
      }

      if(this.field4099 == null) {
         this.field4099 = "";
      }

      if(this.field4098 == null) {
         this.field4098 = "";
      }

      if(this.field4091 == null) {
         this.field4091 = "";
      }

      if(this.field4090 == null) {
         this.field4090 = "";
      }

      if(this.field4107 == null) {
         this.field4107 = "";
      }

      this.method6252();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1365987246"
   )
   void method6252() {
      if(this.field4087.length() > 40) {
         this.field4087 = this.field4087.substring(0, 40);
      }

      if(this.field4099.length() > 40) {
         this.field4099 = this.field4099.substring(0, 40);
      }

      if(this.field4098.length() > 10) {
         this.field4098 = this.field4098.substring(0, 10);
      }

      if(this.field4091.length() > 10) {
         this.field4091 = this.field4091.substring(0, 10);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1750277735"
   )
   public void method6253(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4092?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4105);
      var1.put24bitInt(this.field4096);
      var1.putShort(this.field4097);
      var1.putJagString(this.field4087);
      var1.putJagString(this.field4099);
      var1.putJagString(this.field4098);
      var1.putJagString(this.field4091);
      var1.putByte(this.field4102);
      var1.putShort(this.field4079);
      var1.putJagString(this.field4090);
      var1.putJagString(this.field4107);
      var1.putByte(this.field4104);
      var1.putByte(this.field4101);

      for(int var2 = 0; var2 < this.field4108.length; ++var2) {
         var1.putInt(this.field4108[var2]);
      }

      var1.putInt(this.field4109);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "29"
   )
   public int method6251() {
      byte var1 = 38;
      int var2 = var1 + GraphicsObject.method1844(this.field4087);
      var2 += GraphicsObject.method1844(this.field4099);
      var2 += GraphicsObject.method1844(this.field4098);
      var2 += GraphicsObject.method1844(this.field4091);
      var2 += GraphicsObject.method1844(this.field4090);
      var2 += GraphicsObject.method1844(this.field4107);
      return var2;
   }
}
