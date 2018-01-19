import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -165469907
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("s")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1585000727
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2025860265
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -930952985
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1773440301
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2038013029
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ax")
   boolean field3977;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -193276725
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1947513491
   )
   int field3956;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -183740501
   )
   int field3964;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1785203255
   )
   int field3965;
   @ObfuscatedName("ay")
   String field3966;
   @ObfuscatedName("aq")
   String field3967;
   @ObfuscatedName("ak")
   String field3946;
   @ObfuscatedName("as")
   String field3969;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 457081583
   )
   int field3951;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -623909899
   )
   int field3971;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -519833497
   )
   int field3972;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1796641583
   )
   int field3973;
   @ObfuscatedName("ar")
   String field3970;
   @ObfuscatedName("bg")
   String field3975;
   @ObfuscatedName("bq")
   int[] field3976;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1126288799
   )
   int field3947;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3976 = new int[3];
      if(class157.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class157.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class157.osNameLC.startsWith("linux")) {
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

            var7 = var8 - '0' + var7 * 10;
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

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3977 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3956 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3956 = 0;
      }

      this.field3964 = 0;
      if(this.field3966 == null) {
         this.field3966 = "";
      }

      if(this.field3967 == null) {
         this.field3967 = "";
      }

      if(this.field3946 == null) {
         this.field3946 = "";
      }

      if(this.field3969 == null) {
         this.field3969 = "";
      }

      if(this.field3970 == null) {
         this.field3970 = "";
      }

      if(this.field3975 == null) {
         this.field3975 = "";
      }

      this.method5607();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1516619306"
   )
   void method5607() {
      if(this.field3966.length() > 40) {
         this.field3966 = this.field3966.substring(0, 40);
      }

      if(this.field3967.length() > 40) {
         this.field3967 = this.field3967.substring(0, 40);
      }

      if(this.field3946.length() > 10) {
         this.field3946 = this.field3946.substring(0, 10);
      }

      if(this.field3969.length() > 10) {
         this.field3969 = this.field3969.substring(0, 10);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-1164526832"
   )
   public void method5612(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3977?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3956);
      var1.put24bitInt(this.field3964);
      var1.putShort(this.field3965);
      var1.putJagString(this.field3966);
      var1.putJagString(this.field3967);
      var1.putJagString(this.field3946);
      var1.putJagString(this.field3969);
      var1.putByte(this.field3971);
      var1.putShort(this.field3951);
      var1.putJagString(this.field3970);
      var1.putJagString(this.field3975);
      var1.putByte(this.field3972);
      var1.putByte(this.field3973);

      for(int var2 = 0; var2 < this.field3976.length; ++var2) {
         var1.putInt(this.field3976[var2]);
      }

      var1.putInt(this.field3947);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   public int method5610() {
      byte var1 = 38;
      String var4 = this.field3966;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3967;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3946;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3969;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3970;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3975;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
