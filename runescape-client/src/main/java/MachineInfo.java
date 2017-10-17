import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("ao")
   String field3909;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1380707143
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("bf")
   int[] field3914;
   @ObfuscatedName("at")
   String field3905;
   @ObfuscatedName("r")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("aw")
   String field3906;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1119466773
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 15948615
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ax")
   String field3910;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1219270535
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ak")
   String field3904;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1043485221
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("bj")
   String field3887;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1053131059
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("az")
   boolean field3898;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -44835545
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 442651245
   )
   int field3896;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1300392573
   )
   int field3902;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -584767631
   )
   int field3903;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1757678113
   )
   int field3913;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 970838719
   )
   int field3891;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1733069527
   )
   int field3908;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 446376749
   )
   int field3911;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1701117803
   )
   int field3912;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3914 = new int[3];
      if(class110.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class110.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class110.osNameLC.startsWith("linux")) {
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
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
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

            var7 = var8 - 48 + var7 * 10;
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

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3898 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3896 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3896 = 0;
      }

      this.field3902 = 0;
      if(this.field3909 == null) {
         this.field3909 = "";
      }

      if(this.field3905 == null) {
         this.field3905 = "";
      }

      if(this.field3906 == null) {
         this.field3906 = "";
      }

      if(this.field3910 == null) {
         this.field3910 = "";
      }

      if(this.field3904 == null) {
         this.field3904 = "";
      }

      if(this.field3887 == null) {
         this.field3887 = "";
      }

      this.method5498();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "515269448"
   )
   void method5498() {
      if(this.field3909.length() > 40) {
         this.field3909 = this.field3909.substring(0, 40);
      }

      if(this.field3905.length() > 40) {
         this.field3905 = this.field3905.substring(0, 40);
      }

      if(this.field3906.length() > 10) {
         this.field3906 = this.field3906.substring(0, 10);
      }

      if(this.field3910.length() > 10) {
         this.field3910 = this.field3910.substring(0, 10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-115"
   )
   public int method5500() {
      byte var1 = 38;
      String var4 = this.field3909;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3905;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3906;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3910;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3904;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3887;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-1572137413"
   )
   public void method5508(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3898?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3896);
      var1.put24bitInt(this.field3902);
      var1.putShort(this.field3903);
      var1.putJagString(this.field3909);
      var1.putJagString(this.field3905);
      var1.putJagString(this.field3906);
      var1.putJagString(this.field3910);
      var1.putByte(this.field3913);
      var1.putShort(this.field3891);
      var1.putJagString(this.field3904);
      var1.putJagString(this.field3887);
      var1.putByte(this.field3908);
      var1.putByte(this.field3911);

      for(int var2 = 0; var2 < this.field3914.length; ++var2) {
         var1.putInt(this.field3914[var2]);
      }

      var1.putInt(this.field3912);
   }
}
