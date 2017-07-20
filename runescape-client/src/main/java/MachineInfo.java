import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("ae")
   String field3874;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -942935985
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("ao")
   int[] field3884;
   @ObfuscatedName("ah")
   String field3875;
   @ObfuscatedName("s")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("ax")
   String field3876;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 998393273
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 924190309
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ai")
   String field3877;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 350274147
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -743233099
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("az")
   String field3882;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1940038487
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ay")
   String field3883;
   @ObfuscatedName("ak")
   boolean field3869;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 184811789
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1956347043
   )
   int field3871;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 659791019
   )
   int field3857;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1238256961
   )
   int field3873;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 447080095
   )
   int field3879;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -110150713
   )
   int field3878;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 825721259
   )
   int field3867;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 861247815
   )
   int field3881;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -477721775
   )
   int field3885;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3884 = new int[3];
      if(class155.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(class155.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(class155.osNameLC.startsWith("linux")) {
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

            var7 = var8 - 48 + var7 * 10;
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
         this.field3871 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3871 = 0;
      }

      this.field3857 = 0;
      if(this.field3874 == null) {
         this.field3874 = "";
      }

      if(this.field3875 == null) {
         this.field3875 = "";
      }

      if(this.field3876 == null) {
         this.field3876 = "";
      }

      if(this.field3877 == null) {
         this.field3877 = "";
      }

      if(this.field3882 == null) {
         this.field3882 = "";
      }

      if(this.field3883 == null) {
         this.field3883 = "";
      }

      this.method5266();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1259585576"
   )
   void method5266() {
      if(this.field3874.length() > 40) {
         this.field3874 = this.field3874.substring(0, 40);
      }

      if(this.field3875.length() > 40) {
         this.field3875 = this.field3875.substring(0, 40);
      }

      if(this.field3876.length() > 10) {
         this.field3876 = this.field3876.substring(0, 10);
      }

      if(this.field3877.length() > 10) {
         this.field3877 = this.field3877.substring(0, 10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-256255020"
   )
   public int method5268() {
      byte var1 = 38;
      int var2 = var1 + class47.method672(this.field3874);
      var2 += class47.method672(this.field3875);
      var2 += class47.method672(this.field3876);
      var2 += class47.method672(this.field3877);
      var2 += class47.method672(this.field3882);
      var2 += class47.method672(this.field3883);
      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1791555583"
   )
   public void method5267(Buffer var1) {
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
      var1.putByte(this.field3871);
      var1.put24bitInt(this.field3857);
      var1.putShort(this.field3873);
      var1.putJagString(this.field3874);
      var1.putJagString(this.field3875);
      var1.putJagString(this.field3876);
      var1.putJagString(this.field3877);
      var1.putByte(this.field3879);
      var1.putShort(this.field3878);
      var1.putJagString(this.field3882);
      var1.putJagString(this.field3883);
      var1.putByte(this.field3867);
      var1.putByte(this.field3881);

      for(int var2 = 0; var2 < this.field3884.length; ++var2) {
         var1.putInt(this.field3884[var2]);
      }

      var1.putInt(this.field3885);
   }
}
