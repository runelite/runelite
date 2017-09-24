import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("ah")
   String field3892;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -554689299
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("bd")
   int[] field3902;
   @ObfuscatedName("an")
   String field3883;
   @ObfuscatedName("q")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("af")
   String field3894;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1521172187
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2092439035
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ak")
   String field3895;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1060682771
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1604852659
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("au")
   String field3900;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 599517651
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("bp")
   String field3901;
   @ObfuscatedName("ac")
   boolean field3882;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1654935755
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 573337081
   )
   int field3889;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 905436055
   )
   int field3873;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 463451325
   )
   int field3869;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1339234933
   )
   int field3897;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1712708657
   )
   int field3881;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1041916685
   )
   int field3886;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -688026769
   )
   int field3899;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2060686141
   )
   int field3903;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3902 = new int[3];
      if(Parameters.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(Parameters.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(Parameters.osNameLC.startsWith("linux")) {
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
         this.os32Bit = false;
      } else {
         this.os32Bit = true;
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

            var7 = var7 * 10 + (var8 - 48);
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

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3882 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3889 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3889 = 0;
      }

      this.field3873 = 0;
      if(this.field3892 == null) {
         this.field3892 = "";
      }

      if(this.field3883 == null) {
         this.field3883 = "";
      }

      if(this.field3894 == null) {
         this.field3894 = "";
      }

      if(this.field3895 == null) {
         this.field3895 = "";
      }

      if(this.field3900 == null) {
         this.field3900 = "";
      }

      if(this.field3901 == null) {
         this.field3901 = "";
      }

      this.method5343();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1770018539"
   )
   void method5343() {
      if(this.field3892.length() > 40) {
         this.field3892 = this.field3892.substring(0, 40);
      }

      if(this.field3883.length() > 40) {
         this.field3883 = this.field3883.substring(0, 40);
      }

      if(this.field3894.length() > 10) {
         this.field3894 = this.field3894.substring(0, 10);
      }

      if(this.field3895.length() > 10) {
         this.field3895 = this.field3895.substring(0, 10);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-933251585"
   )
   public int method5345() {
      byte var1 = 38;
      int var2 = var1 + MouseInput.method1048(this.field3892);
      var2 += MouseInput.method1048(this.field3883);
      var2 += MouseInput.method1048(this.field3894);
      var2 += MouseInput.method1048(this.field3895);
      var2 += MouseInput.method1048(this.field3900);
      var2 += MouseInput.method1048(this.field3901);
      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1097921951"
   )
   public void method5342(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3882?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3889);
      var1.put24bitInt(this.field3873);
      var1.putShort(this.field3869);
      var1.putJagString(this.field3892);
      var1.putJagString(this.field3883);
      var1.putJagString(this.field3894);
      var1.putJagString(this.field3895);
      var1.putByte(this.field3897);
      var1.putShort(this.field3881);
      var1.putJagString(this.field3900);
      var1.putJagString(this.field3901);
      var1.putByte(this.field3886);
      var1.putByte(this.field3899);

      for(int var2 = 0; var2 < this.field3902.length; ++var2) {
         var1.putInt(this.field3902[var2]);
      }

      var1.putInt(this.field3903);
   }
}
