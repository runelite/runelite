import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1167078251
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("s")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1712637733
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -143865485
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1094030281
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1505864847
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1994239177
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ad")
   boolean field4104;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1778811141
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 287602989
   )
   int field4097;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -40762937
   )
   int field4081;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1302663189
   )
   int field4102;
   @ObfuscatedName("au")
   String field4101;
   @ObfuscatedName("ap")
   String field4099;
   @ObfuscatedName("at")
   String field4089;
   @ObfuscatedName("am")
   String field4082;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 418757589
   )
   int field4105;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -102569589
   )
   int field4106;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1505149411
   )
   int field4107;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1214843411
   )
   int field4108;
   @ObfuscatedName("aq")
   String field4109;
   @ObfuscatedName("bq")
   String field4110;
   @ObfuscatedName("bi")
   int[] field4111;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1436759453
   )
   int field4112;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4111 = new int[3];
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
      this.field4104 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4097 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4097 = 0;
      }

      this.field4081 = 0;
      if(this.field4101 == null) {
         this.field4101 = "";
      }

      if(this.field4099 == null) {
         this.field4099 = "";
      }

      if(this.field4089 == null) {
         this.field4089 = "";
      }

      if(this.field4082 == null) {
         this.field4082 = "";
      }

      if(this.field4109 == null) {
         this.field4109 = "";
      }

      if(this.field4110 == null) {
         this.field4110 = "";
      }

      this.method6279();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1992810010"
   )
   void method6279() {
      if(this.field4101.length() > 40) {
         this.field4101 = this.field4101.substring(0, 40);
      }

      if(this.field4099.length() > 40) {
         this.field4099 = this.field4099.substring(0, 40);
      }

      if(this.field4089.length() > 10) {
         this.field4089 = this.field4089.substring(0, 10);
      }

      if(this.field4082.length() > 10) {
         this.field4082 = this.field4082.substring(0, 10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "-72"
   )
   public void method6281(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4104?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4097);
      var1.put24bitInt(this.field4081);
      var1.putShort(this.field4102);
      var1.putJagString(this.field4101);
      var1.putJagString(this.field4099);
      var1.putJagString(this.field4089);
      var1.putJagString(this.field4082);
      var1.putByte(this.field4106);
      var1.putShort(this.field4105);
      var1.putJagString(this.field4109);
      var1.putJagString(this.field4110);
      var1.putByte(this.field4107);
      var1.putByte(this.field4108);

      for(int var2 = 0; var2 < this.field4111.length; ++var2) {
         var1.putInt(this.field4111[var2]);
      }

      var1.putInt(this.field4112);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-739490278"
   )
   public int method6288() {
      byte var1 = 38;
      int var2 = var1 + GrandExchangeOffer.method122(this.field4101);
      var2 += GrandExchangeOffer.method122(this.field4099);
      var2 += GrandExchangeOffer.method122(this.field4089);
      var2 += GrandExchangeOffer.method122(this.field4082);
      var2 += GrandExchangeOffer.method122(this.field4109);
      var2 += GrandExchangeOffer.method122(this.field4110);
      return var2;
   }
}
