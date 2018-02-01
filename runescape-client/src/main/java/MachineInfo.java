import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1554300829
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("t")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -923113227
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1923767629
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1891915849
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 426288281
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1736818733
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("am")
   boolean field3988;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 463600657
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 200786847
   )
   int field4002;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1907855625
   )
   int field3993;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1762830565
   )
   int field3994;
   @ObfuscatedName("ab")
   String field3995;
   @ObfuscatedName("aq")
   String field4003;
   @ObfuscatedName("ac")
   String field3997;
   @ObfuscatedName("ak")
   String field3998;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1597522247
   )
   int field3999;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -299628729
   )
   int field4000;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 965414359
   )
   int field3996;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2098139135
   )
   int field4001;
   @ObfuscatedName("al")
   String field3986;
   @ObfuscatedName("bw")
   String field4004;
   @ObfuscatedName("bt")
   int[] field4005;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1239305343
   )
   int field3979;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field4005 = new int[3];
      if(VertexNormal.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(VertexNormal.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(VertexNormal.osNameLC.startsWith("linux")) {
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

            var7 = var8 - '0' + var7 * 10;
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
      this.field3988 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field4002 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field4002 = 0;
      }

      this.field3993 = 0;
      if(this.field3995 == null) {
         this.field3995 = "";
      }

      if(this.field4003 == null) {
         this.field4003 = "";
      }

      if(this.field3997 == null) {
         this.field3997 = "";
      }

      if(this.field3998 == null) {
         this.field3998 = "";
      }

      if(this.field3986 == null) {
         this.field3986 = "";
      }

      if(this.field4004 == null) {
         this.field4004 = "";
      }

      this.method5853();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1501800627"
   )
   void method5853() {
      if(this.field3995.length() > 40) {
         this.field3995 = this.field3995.substring(0, 40);
      }

      if(this.field4003.length() > 40) {
         this.field4003 = this.field4003.substring(0, 40);
      }

      if(this.field3997.length() > 10) {
         this.field3997 = this.field3997.substring(0, 10);
      }

      if(this.field3998.length() > 10) {
         this.field3998 = this.field3998.substring(0, 10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-719158230"
   )
   public void method5854(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3988?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field4002);
      var1.put24bitInt(this.field3993);
      var1.putShort(this.field3994);
      var1.putJagString(this.field3995);
      var1.putJagString(this.field4003);
      var1.putJagString(this.field3997);
      var1.putJagString(this.field3998);
      var1.putByte(this.field4000);
      var1.putShort(this.field3999);
      var1.putJagString(this.field3986);
      var1.putJagString(this.field4004);
      var1.putByte(this.field3996);
      var1.putByte(this.field4001);

      for(int var2 = 0; var2 < this.field4005.length; ++var2) {
         var1.putInt(this.field4005[var2]);
      }

      var1.putInt(this.field3979);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "99"
   )
   public int method5855() {
      byte var1 = 38;
      String var4 = this.field3995;
      int var3 = var4.length() + 2;
      int var14 = var1 + var3;
      String var7 = this.field4003;
      int var6 = var7.length() + 2;
      var14 += var6;
      String var10 = this.field3997;
      int var9 = var10.length() + 2;
      var14 += var9;
      var14 += UrlRequester.method3031(this.field3998);
      String var13 = this.field3986;
      int var12 = var13.length() + 2;
      var14 += var12;
      var14 += UrlRequester.method3031(this.field4004);
      return var14;
   }
}
