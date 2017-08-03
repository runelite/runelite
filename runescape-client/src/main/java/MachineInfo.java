import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("ay")
   String field3875;
   @ObfuscatedName("aj")
   int[] field3885;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -527468011
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("an")
   String field3860;
   @ObfuscatedName("v")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("af")
   String field3877;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -818245657
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("aa")
   String field3876;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1787672367
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1935825547
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("al")
   String field3883;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1838105973
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ab")
   String field3850;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1604761475
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("au")
   boolean field3869;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1137495487
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1304380395
   )
   int field3872;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 322879493
   )
   int field3873;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1202157249
   )
   int field3868;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -192891755
   )
   int field3880;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1642021977
   )
   int field3858;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 840713493
   )
   int field3867;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1508032767
   )
   int field3882;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -323058589
   )
   int field3886;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3885 = new int[3];
      if(Friend.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(Friend.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(Friend.osNameLC.startsWith("linux")) {
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

            var7 = var7 * 10 + (var8 - 48);
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
      this.field3869 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3872 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3872 = 0;
      }

      this.field3873 = 0;
      if(this.field3875 == null) {
         this.field3875 = "";
      }

      if(this.field3860 == null) {
         this.field3860 = "";
      }

      if(this.field3877 == null) {
         this.field3877 = "";
      }

      if(this.field3876 == null) {
         this.field3876 = "";
      }

      if(this.field3883 == null) {
         this.field3883 = "";
      }

      if(this.field3850 == null) {
         this.field3850 = "";
      }

      this.method5377();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1883679703"
   )
   void method5377() {
      if(this.field3875.length() > 40) {
         this.field3875 = this.field3875.substring(0, 40);
      }

      if(this.field3860.length() > 40) {
         this.field3860 = this.field3860.substring(0, 40);
      }

      if(this.field3877.length() > 10) {
         this.field3877 = this.field3877.substring(0, 10);
      }

      if(this.field3876.length() > 10) {
         this.field3876 = this.field3876.substring(0, 10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1877017400"
   )
   public int method5376() {
      byte var1 = 38;
      String var4 = this.field3875;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field3860;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3877;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3876;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3883;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3850;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "0"
   )
   public void method5379(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3869?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3872);
      var1.put24bitInt(this.field3873);
      var1.putShort(this.field3868);
      var1.putJagString(this.field3875);
      var1.putJagString(this.field3860);
      var1.putJagString(this.field3877);
      var1.putJagString(this.field3876);
      var1.putByte(this.field3880);
      var1.putShort(this.field3858);
      var1.putJagString(this.field3883);
      var1.putJagString(this.field3850);
      var1.putByte(this.field3867);
      var1.putByte(this.field3882);

      for(int var2 = 0; var2 < this.field3885.length; ++var2) {
         var1.putInt(this.field3885[var2]);
      }

      var1.putInt(this.field3886);
   }
}
