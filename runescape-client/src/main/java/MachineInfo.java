import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("li")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -472789311
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("l")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -130449583
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1518784391
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1575862295
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 24517999
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1138388643
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("as")
   boolean field4012;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -624573891
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1736758083
   )
   int field4009;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -545451195
   )
   int field4004;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 479772139
   )
   int field4006;
   @ObfuscatedName("ac")
   String field3989;
   @ObfuscatedName("ay")
   String field4013;
   @ObfuscatedName("at")
   String field4011;
   @ObfuscatedName("aa")
   String field4015;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1810182875
   )
   int field4010;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1913324837
   )
   int field3993;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1616807787
   )
   int field4018;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1279549729
   )
   int field4019;
   @ObfuscatedName("an")
   String field4020;
   @ObfuscatedName("bh")
   String field4021;
   @ObfuscatedName("bx")
   int[] field4022;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 2087334055
   )
   int field4023;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4022 = new int[3];
      if(class188.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class188.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class188.osNameLC.startsWith("linux")) {
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

            var7 = var7 * 10 + (var8 - '0');
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field4012 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4009 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4009 = 0;
      }

      this.field4004 = 0;
      if(this.field3989 == null) {
         this.field3989 = "";
      }

      if(this.field4013 == null) {
         this.field4013 = "";
      }

      if(this.field4011 == null) {
         this.field4011 = "";
      }

      if(this.field4015 == null) {
         this.field4015 = "";
      }

      if(this.field4020 == null) {
         this.field4020 = "";
      }

      if(this.field4021 == null) {
         this.field4021 = "";
      }

      this.method6161();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1988292565"
   )
   void method6161() {
      if(this.field3989.length() > 40) {
         this.field3989 = this.field3989.substring(0, 40);
      }

      if(this.field4013.length() > 40) {
         this.field4013 = this.field4013.substring(0, 40);
      }

      if(this.field4011.length() > 10) {
         this.field4011 = this.field4011.substring(0, 10);
      }

      if(this.field4015.length() > 10) {
         this.field4015 = this.field4015.substring(0, 10);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-316579386"
   )
   public void method6154(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4012?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4009);
      var1.put24bitInt(this.field4004);
      var1.putShort(this.field4006);
      var1.putJagString(this.field3989);
      var1.putJagString(this.field4013);
      var1.putJagString(this.field4011);
      var1.putJagString(this.field4015);
      var1.putByte(this.field3993);
      var1.putShort(this.field4010);
      var1.putJagString(this.field4020);
      var1.putJagString(this.field4021);
      var1.putByte(this.field4018);
      var1.putByte(this.field4019);

      for(int var2 = 0; var2 < this.field4022.length; ++var2) {
         var1.putInt(this.field4022[var2]);
      }

      var1.putInt(this.field4023);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "22075830"
   )
   public int method6155() {
      byte var1 = 38;
      int var2 = var1 + class156.method3161(this.field3989);
      var2 += class156.method3161(this.field4013);
      var2 += class156.method3161(this.field4011);
      var2 += class156.method3161(this.field4015);
      var2 += class156.method3161(this.field4020);
      var2 += class156.method3161(this.field4021);
      return var2;
   }
}
