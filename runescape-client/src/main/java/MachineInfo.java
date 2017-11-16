import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1311559635
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("u")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1950244369
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1697101961
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1299524759
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2048625315
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1094339411
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ac")
   boolean field3939;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1247792979
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1376757839
   )
   int field3947;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1886561451
   )
   int field3952;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2145235525
   )
   int field3941;
   @ObfuscatedName("ag")
   String field3944;
   @ObfuscatedName("af")
   String field3945;
   @ObfuscatedName("ay")
   String field3946;
   @ObfuscatedName("ab")
   String field3954;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1674596925
   )
   int field3942;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -333316187
   )
   int field3932;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1246240759
   )
   int field3953;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2014004159
   )
   int field3951;
   @ObfuscatedName("ad")
   String field3949;
   @ObfuscatedName("ba")
   String field3924;
   @ObfuscatedName("bi")
   int[] field3936;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1093963295
   )
   int field3930;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3936 = new int[3];
      if(class19.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class19.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class19.osNameLC.startsWith("linux")) {
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

            var7 = var7 * 10 + (var8 - '0');
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

            var7 = var8 - '0' + var7 * 10;
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

            var7 = var8 - '0' + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3939 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3947 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3947 = 0;
      }

      this.field3952 = 0;
      if(this.field3944 == null) {
         this.field3944 = "";
      }

      if(this.field3945 == null) {
         this.field3945 = "";
      }

      if(this.field3946 == null) {
         this.field3946 = "";
      }

      if(this.field3954 == null) {
         this.field3954 = "";
      }

      if(this.field3949 == null) {
         this.field3949 = "";
      }

      if(this.field3924 == null) {
         this.field3924 = "";
      }

      this.method5425();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-589531957"
   )
   void method5425() {
      if(this.field3944.length() > 40) {
         this.field3944 = this.field3944.substring(0, 40);
      }

      if(this.field3945.length() > 40) {
         this.field3945 = this.field3945.substring(0, 40);
      }

      if(this.field3946.length() > 10) {
         this.field3946 = this.field3946.substring(0, 10);
      }

      if(this.field3954.length() > 10) {
         this.field3954 = this.field3954.substring(0, 10);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "124198222"
   )
   public void method5433(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3939?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3947);
      var1.put24bitInt(this.field3952);
      var1.putShort(this.field3941);
      var1.putJagString(this.field3944);
      var1.putJagString(this.field3945);
      var1.putJagString(this.field3946);
      var1.putJagString(this.field3954);
      var1.putByte(this.field3932);
      var1.putShort(this.field3942);
      var1.putJagString(this.field3949);
      var1.putJagString(this.field3924);
      var1.putByte(this.field3953);
      var1.putByte(this.field3951);

      for(int var2 = 0; var2 < this.field3936.length; ++var2) {
         var1.putInt(this.field3936[var2]);
      }

      var1.putInt(this.field3930);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "563284134"
   )
   public int method5427() {
      byte var1 = 38;
      String var4 = this.field3944;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3945;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3946;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3954;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3949;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3924;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
