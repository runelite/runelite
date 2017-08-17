import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("ap")
   String field3874;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1023990761
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("bi")
   int[] field3884;
   @ObfuscatedName("ad")
   String field3875;
   @ObfuscatedName("c")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("aa")
   String field3856;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1256964667
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("aw")
   String field3877;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 16923101
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 190952727
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ay")
   String field3882;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1333481979
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("bk")
   String field3854;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -649438823
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("as")
   boolean field3873;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1225269703
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 270487441
   )
   int field3871;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1945318467
   )
   int field3862;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 128622519
   )
   int field3883;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1046123763
   )
   int field3879;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1994240393
   )
   int field3872;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 892690509
   )
   int field3880;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 884111823
   )
   int field3881;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1718014217
   )
   int field3885;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3884 = new int[3];
      if(class13.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class13.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class13.osNameLC.startsWith("linux")) {
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

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3873 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3871 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3871 = 0;
      }

      this.field3862 = 0;
      if(this.field3874 == null) {
         this.field3874 = "";
      }

      if(this.field3875 == null) {
         this.field3875 = "";
      }

      if(this.field3856 == null) {
         this.field3856 = "";
      }

      if(this.field3877 == null) {
         this.field3877 = "";
      }

      if(this.field3882 == null) {
         this.field3882 = "";
      }

      if(this.field3854 == null) {
         this.field3854 = "";
      }

      this.method5420();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1167911889"
   )
   void method5420() {
      if(this.field3874.length() > 40) {
         this.field3874 = this.field3874.substring(0, 40);
      }

      if(this.field3875.length() > 40) {
         this.field3875 = this.field3875.substring(0, 40);
      }

      if(this.field3856.length() > 10) {
         this.field3856 = this.field3856.substring(0, 10);
      }

      if(this.field3877.length() > 10) {
         this.field3877 = this.field3877.substring(0, 10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1321313703"
   )
   public int method5421() {
      byte var1 = 38;
      String var4 = this.field3874;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3875;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3856;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3877;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3882;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3854;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1119555820"
   )
   public void method5419(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3873?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3871);
      var1.put24bitInt(this.field3862);
      var1.putShort(this.field3883);
      var1.putJagString(this.field3874);
      var1.putJagString(this.field3875);
      var1.putJagString(this.field3856);
      var1.putJagString(this.field3877);
      var1.putByte(this.field3879);
      var1.putShort(this.field3872);
      var1.putJagString(this.field3882);
      var1.putJagString(this.field3854);
      var1.putByte(this.field3880);
      var1.putByte(this.field3881);

      for(int var2 = 0; var2 < this.field3884.length; ++var2) {
         var1.putInt(this.field3884[var2]);
      }

      var1.putInt(this.field3885);
   }
}
