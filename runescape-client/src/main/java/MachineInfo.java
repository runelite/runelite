import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1114730691
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("t")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 253656673
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -463573235
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -97471889
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 66935007
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 948155509
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ai")
   boolean field4001;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 274000351
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -719810411
   )
   int field3994;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 382172943
   )
   int field3996;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -335657107
   )
   int field3980;
   @ObfuscatedName("ao")
   String field3998;
   @ObfuscatedName("av")
   String field3999;
   @ObfuscatedName("aj")
   String field4005;
   @ObfuscatedName("ap")
   String field3990;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 717289799
   )
   int field4002;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 774259687
   )
   int field4003;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1109116151
   )
   int field4004;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -957364871
   )
   int field3993;
   @ObfuscatedName("ac")
   String field3988;
   @ObfuscatedName("bj")
   String field4000;
   @ObfuscatedName("bo")
   int[] field4008;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -2018968331
   )
   int field4009;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4008 = new int[3];
      if(class35.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class35.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class35.osNameLC.startsWith("linux")) {
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
      this.field4001 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3994 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3994 = 0;
      }

      this.field3996 = 0;
      if(this.field3998 == null) {
         this.field3998 = "";
      }

      if(this.field3999 == null) {
         this.field3999 = "";
      }

      if(this.field4005 == null) {
         this.field4005 = "";
      }

      if(this.field3990 == null) {
         this.field3990 = "";
      }

      if(this.field3988 == null) {
         this.field3988 = "";
      }

      if(this.field4000 == null) {
         this.field4000 = "";
      }

      this.method6010();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1727976110"
   )
   void method6010() {
      if(this.field3998.length() > 40) {
         this.field3998 = this.field3998.substring(0, 40);
      }

      if(this.field3999.length() > 40) {
         this.field3999 = this.field3999.substring(0, 40);
      }

      if(this.field4005.length() > 10) {
         this.field4005 = this.field4005.substring(0, 10);
      }

      if(this.field3990.length() > 10) {
         this.field3990 = this.field3990.substring(0, 10);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1907557470"
   )
   public void method6011(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4001?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3994);
      var1.put24bitInt(this.field3996);
      var1.putShort(this.field3980);
      var1.putJagString(this.field3998);
      var1.putJagString(this.field3999);
      var1.putJagString(this.field4005);
      var1.putJagString(this.field3990);
      var1.putByte(this.field4003);
      var1.putShort(this.field4002);
      var1.putJagString(this.field3988);
      var1.putJagString(this.field4000);
      var1.putByte(this.field4004);
      var1.putByte(this.field3993);

      for(int var2 = 0; var2 < this.field4008.length; ++var2) {
         var1.putInt(this.field4008[var2]);
      }

      var1.putInt(this.field4009);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-28"
   )
   public int method6012() {
      byte var1 = 38;
      String var4 = this.field3998;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3999;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field4005;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3990;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3988;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field4000;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
