import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("as")
   String field3879;
   @ObfuscatedName("af")
   int[] field3896;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 879230059
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("av")
   String field3887;
   @ObfuscatedName("l")
   @Export("os32Bit")
   boolean os32Bit;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 503870261
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ab")
   String field3888;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2110903779
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2040853991
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("at")
   String field3889;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1143535097
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ao")
   String field3866;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1487376091
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("aq")
   boolean field3881;
   @ObfuscatedName("ac")
   String field3895;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -910911793
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1643544223
   )
   int field3883;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 708047703
   )
   int field3884;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1840139
   )
   int field3885;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -186975453
   )
   int field3871;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1148416601
   )
   int field3873;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 520549645
   )
   int field3892;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1181616815
   )
   int field3893;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -720178165
   )
   int field3897;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3896 = new int[3];
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

            var7 = var8 - 48 + 10 * var7;
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
      this.field3881 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3883 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3883 = 0;
      }

      this.field3884 = 0;
      if(this.field3879 == null) {
         this.field3879 = "";
      }

      if(this.field3887 == null) {
         this.field3887 = "";
      }

      if(this.field3888 == null) {
         this.field3888 = "";
      }

      if(this.field3889 == null) {
         this.field3889 = "";
      }

      if(this.field3866 == null) {
         this.field3866 = "";
      }

      if(this.field3895 == null) {
         this.field3895 = "";
      }

      this.method5281();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   void method5281() {
      if(this.field3879.length() > 40) {
         this.field3879 = this.field3879.substring(0, 40);
      }

      if(this.field3887.length() > 40) {
         this.field3887 = this.field3887.substring(0, 40);
      }

      if(this.field3888.length() > 10) {
         this.field3888 = this.field3888.substring(0, 10);
      }

      if(this.field3889.length() > 10) {
         this.field3889 = this.field3889.substring(0, 10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-66423710"
   )
   public int method5283() {
      byte var1 = 38;
      int var2 = var1 + class83.method1641(this.field3879);
      var2 += class83.method1641(this.field3887);
      var2 += class83.method1641(this.field3888);
      var2 += class83.method1641(this.field3889);
      var2 += class83.method1641(this.field3866);
      var2 += class83.method1641(this.field3895);
      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-910438586"
   )
   public void method5282(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os32Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3881?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3883);
      var1.put24bitInt(this.field3884);
      var1.putShort(this.field3885);
      var1.putJagString(this.field3879);
      var1.putJagString(this.field3887);
      var1.putJagString(this.field3888);
      var1.putJagString(this.field3889);
      var1.putByte(this.field3871);
      var1.putShort(this.field3873);
      var1.putJagString(this.field3866);
      var1.putJagString(this.field3895);
      var1.putByte(this.field3892);
      var1.putByte(this.field3893);

      for(int var2 = 0; var2 < this.field3896.length; ++var2) {
         var1.putInt(this.field3896[var2]);
      }

      var1.putInt(this.field3897);
   }
}
