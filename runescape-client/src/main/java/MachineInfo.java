import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -96417789
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("h")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 757115043
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1652212793
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1684516789
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -542541621
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1887948635
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("az")
   boolean field3907;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2029600745
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -965431907
   )
   int field3909;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1937724701
   )
   int field3912;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 654100689
   )
   int field3911;
   @ObfuscatedName("ae")
   String field3893;
   @ObfuscatedName("au")
   String field3913;
   @ObfuscatedName("av")
   String field3901;
   @ObfuscatedName("ab")
   String field3898;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1507502761
   )
   int field3916;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1483977003
   )
   int field3917;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -864806749
   )
   int field3914;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1257191209
   )
   int field3921;
   @ObfuscatedName("ak")
   String field3920;
   @ObfuscatedName("bc")
   String field3905;
   @ObfuscatedName("bo")
   int[] field3922;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 971815395
   )
   int field3923;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3922 = new int[3];
      if(FaceNormal.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(FaceNormal.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(FaceNormal.osNameLC.startsWith("linux")) {
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

            var7 = var7 * 10 + (var8 - '0');
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.javaVersionPatch = var7;
      this.field3907 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3909 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3909 = 0;
      }

      this.field3912 = 0;
      if(this.field3893 == null) {
         this.field3893 = "";
      }

      if(this.field3913 == null) {
         this.field3913 = "";
      }

      if(this.field3901 == null) {
         this.field3901 = "";
      }

      if(this.field3898 == null) {
         this.field3898 = "";
      }

      if(this.field3920 == null) {
         this.field3920 = "";
      }

      if(this.field3905 == null) {
         this.field3905 = "";
      }

      this.method6254();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   void method6254() {
      if(this.field3893.length() > 40) {
         this.field3893 = this.field3893.substring(0, 40);
      }

      if(this.field3913.length() > 40) {
         this.field3913 = this.field3913.substring(0, 40);
      }

      if(this.field3901.length() > 10) {
         this.field3901 = this.field3901.substring(0, 10);
      }

      if(this.field3898.length() > 10) {
         this.field3898 = this.field3898.substring(0, 10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1370448806"
   )
   public void method6249(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3907?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3909);
      var1.put24bitInt(this.field3912);
      var1.putShort(this.field3911);
      var1.putJagString(this.field3893);
      var1.putJagString(this.field3913);
      var1.putJagString(this.field3901);
      var1.putJagString(this.field3898);
      var1.putByte(this.field3917);
      var1.putShort(this.field3916);
      var1.putJagString(this.field3920);
      var1.putJagString(this.field3905);
      var1.putByte(this.field3914);
      var1.putByte(this.field3921);

      for(int var2 = 0; var2 < this.field3922.length; ++var2) {
         var1.putInt(this.field3922[var2]);
      }

      var1.putInt(this.field3923);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1466485596"
   )
   public int method6250() {
      byte var1 = 38;
      String var4 = this.field3893;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3913;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3901;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3898;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3920;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3905;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }
}
