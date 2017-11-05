import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 711393113
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("p")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 346699729
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1693993181
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1843007815
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 817199065
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1341242037
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("av")
   boolean field3899;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1494189539
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1421897631
   )
   int field3900;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -839580973
   )
   int field3902;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1474171127
   )
   int field3903;
   @ObfuscatedName("am")
   String field3892;
   @ObfuscatedName("ah")
   String field3905;
   @ObfuscatedName("ak")
   String field3912;
   @ObfuscatedName("ar")
   String field3890;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1512070695
   )
   int field3908;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1860541795
   )
   int field3909;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 427866337
   )
   int field3884;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1819444627
   )
   int field3889;
   @ObfuscatedName("as")
   String field3893;
   @ObfuscatedName("br")
   String field3913;
   @ObfuscatedName("bj")
   int[] field3914;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 181973077
   )
   int field3915;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3914 = new int[3];
      if(GraphicsObject.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(GraphicsObject.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(GraphicsObject.osNameLC.startsWith("linux")) {
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

            var7 = var7 * 10 + (var8 - '0');
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3899 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3900 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3900 = 0;
      }

      this.field3902 = 0;
      if(this.field3892 == null) {
         this.field3892 = "";
      }

      if(this.field3905 == null) {
         this.field3905 = "";
      }

      if(this.field3912 == null) {
         this.field3912 = "";
      }

      if(this.field3890 == null) {
         this.field3890 = "";
      }

      if(this.field3893 == null) {
         this.field3893 = "";
      }

      if(this.field3913 == null) {
         this.field3913 = "";
      }

      this.method5501();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1346663773"
   )
   void method5501() {
      if(this.field3892.length() > 40) {
         this.field3892 = this.field3892.substring(0, 40);
      }

      if(this.field3905.length() > 40) {
         this.field3905 = this.field3905.substring(0, 40);
      }

      if(this.field3912.length() > 10) {
         this.field3912 = this.field3912.substring(0, 10);
      }

      if(this.field3890.length() > 10) {
         this.field3890 = this.field3890.substring(0, 10);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-467109270"
   )
   public void method5500(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3899?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3900);
      var1.put24bitInt(this.field3902);
      var1.putShort(this.field3903);
      var1.putJagString(this.field3892);
      var1.putJagString(this.field3905);
      var1.putJagString(this.field3912);
      var1.putJagString(this.field3890);
      var1.putByte(this.field3909);
      var1.putShort(this.field3908);
      var1.putJagString(this.field3893);
      var1.putJagString(this.field3913);
      var1.putByte(this.field3884);
      var1.putByte(this.field3889);

      for(int var2 = 0; var2 < this.field3914.length; ++var2) {
         var1.putInt(this.field3914[var2]);
      }

      var1.putInt(this.field3915);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-571738487"
   )
   public int method5502() {
      byte var1 = 38;
      String var4 = this.field3892;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3905;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3912;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3890;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3893;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3913;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
