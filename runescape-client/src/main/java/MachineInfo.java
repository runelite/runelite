import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("af")
   String field3873;
   @ObfuscatedName("aa")
   int[] field3883;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1646711257
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("am")
   String field3874;
   @ObfuscatedName("v")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -582006783
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("aq")
   String field3863;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1498383
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1544101403
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("as")
   String field3876;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1880028893
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ar")
   String field3881;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1859300701
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("az")
   boolean field3868;
   @ObfuscatedName("aj")
   String field3870;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1913108355
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -489301903
   )
   int field3880;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1268437863
   )
   int field3879;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -8721725
   )
   int field3872;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 369850263
   )
   int field3878;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 790278033
   )
   int field3877;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -123322779
   )
   int field3853;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1558125607
   )
   int field3884;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1636272663
   )
   int field3862;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3883 = new int[3];
      if(class15.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class15.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class15.osNameLC.startsWith("linux")) {
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
      this.field3868 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3880 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3880 = 0;
      }

      this.field3879 = 0;
      if(this.field3873 == null) {
         this.field3873 = "";
      }

      if(this.field3874 == null) {
         this.field3874 = "";
      }

      if(this.field3863 == null) {
         this.field3863 = "";
      }

      if(this.field3876 == null) {
         this.field3876 = "";
      }

      if(this.field3881 == null) {
         this.field3881 = "";
      }

      if(this.field3870 == null) {
         this.field3870 = "";
      }

      this.method5419();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121433555"
   )
   void method5419() {
      if(this.field3873.length() > 40) {
         this.field3873 = this.field3873.substring(0, 40);
      }

      if(this.field3874.length() > 40) {
         this.field3874 = this.field3874.substring(0, 40);
      }

      if(this.field3863.length() > 10) {
         this.field3863 = this.field3863.substring(0, 10);
      }

      if(this.field3876.length() > 10) {
         this.field3876 = this.field3876.substring(0, 10);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-745956221"
   )
   public int method5420() {
      byte var1 = 38;
      int var5 = var1 + RSCanvas.method788(this.field3873);
      var5 += RSCanvas.method788(this.field3874);
      var5 += RSCanvas.method788(this.field3863);
      String var4 = this.field3876;
      int var3 = var4.length() + 2;
      var5 += var3;
      var5 += RSCanvas.method788(this.field3881);
      var5 += RSCanvas.method788(this.field3870);
      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "1930410823"
   )
   public void method5428(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3868?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3880);
      var1.put24bitInt(this.field3879);
      var1.putShort(this.field3872);
      var1.putJagString(this.field3873);
      var1.putJagString(this.field3874);
      var1.putJagString(this.field3863);
      var1.putJagString(this.field3876);
      var1.putByte(this.field3878);
      var1.putShort(this.field3877);
      var1.putJagString(this.field3881);
      var1.putJagString(this.field3870);
      var1.putByte(this.field3853);
      var1.putByte(this.field3884);

      for(int var2 = 0; var2 < this.field3883.length; ++var2) {
         var1.putInt(this.field3883[var2]);
      }

      var1.putInt(this.field3862);
   }
}
