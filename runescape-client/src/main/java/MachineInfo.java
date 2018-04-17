import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1920263671
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("z")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2015404033
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2088008957
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1987956341
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -753248931
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 898863761
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("az")
   boolean field4082;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1491603793
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -684522627
   )
   int field4100;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -493336115
   )
   int field4101;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 348018313
   )
   int field4114;
   @ObfuscatedName("au")
   String field4103;
   @ObfuscatedName("ar")
   String field4104;
   @ObfuscatedName("an")
   String field4105;
   @ObfuscatedName("ae")
   String field4106;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1783888145
   )
   int field4107;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1284598197
   )
   int field4111;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1300981571
   )
   int field4109;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1959580307
   )
   int field4110;
   @ObfuscatedName("ay")
   String field4087;
   @ObfuscatedName("bm")
   String field4112;
   @ObfuscatedName("bx")
   int[] field4113;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1867058053
   )
   int field4085;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4113 = new int[3];
      if(class25.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class25.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class25.osNameLC.startsWith("linux")) {
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
      this.field4082 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4100 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4100 = 0;
      }

      this.field4101 = 0;
      if(this.field4103 == null) {
         this.field4103 = "";
      }

      if(this.field4104 == null) {
         this.field4104 = "";
      }

      if(this.field4105 == null) {
         this.field4105 = "";
      }

      if(this.field4106 == null) {
         this.field4106 = "";
      }

      if(this.field4087 == null) {
         this.field4087 = "";
      }

      if(this.field4112 == null) {
         this.field4112 = "";
      }

      this.method6187();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "589435664"
   )
   void method6187() {
      if(this.field4103.length() > 40) {
         this.field4103 = this.field4103.substring(0, 40);
      }

      if(this.field4104.length() > 40) {
         this.field4104 = this.field4104.substring(0, 40);
      }

      if(this.field4105.length() > 10) {
         this.field4105 = this.field4105.substring(0, 10);
      }

      if(this.field4106.length() > 10) {
         this.field4106 = this.field4106.substring(0, 10);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "2095335438"
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
      var1.putByte(this.field4082?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4100);
      var1.put24bitInt(this.field4101);
      var1.putShort(this.field4114);
      var1.putJagString(this.field4103);
      var1.putJagString(this.field4104);
      var1.putJagString(this.field4105);
      var1.putJagString(this.field4106);
      var1.putByte(this.field4111);
      var1.putShort(this.field4107);
      var1.putJagString(this.field4087);
      var1.putJagString(this.field4112);
      var1.putByte(this.field4109);
      var1.putByte(this.field4110);

      for(int var2 = 0; var2 < this.field4113.length; ++var2) {
         var1.putInt(this.field4113[var2]);
      }

      var1.putInt(this.field4085);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-19"
   )
   public int method6184() {
      byte var1 = 38;
      int var2 = var1 + class19.method167(this.field4103);
      var2 += class19.method167(this.field4104);
      var2 += class19.method167(this.field4105);
      var2 += class19.method167(this.field4106);
      var2 += class19.method167(this.field4087);
      var2 += class19.method167(this.field4112);
      return var2;
   }
}
