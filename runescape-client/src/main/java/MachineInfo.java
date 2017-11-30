import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("MachineInfo")
public class MachineInfo extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -571571871
   )
   @Export("osType")
   int osType;
   @ObfuscatedName("t")
   @Export("os64Bit")
   boolean os64Bit;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1520683389
   )
   @Export("osVersionType")
   int osVersionType;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -317574963
   )
   @Export("javaVendorType")
   int javaVendorType;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 465222985
   )
   @Export("javaVersionMajor")
   int javaVersionMajor;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -383063131
   )
   @Export("javaVersionMinor")
   int javaVersionMinor;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 504078667
   )
   @Export("javaVersionPatch")
   int javaVersionPatch;
   @ObfuscatedName("ac")
   boolean field3958;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -789804035
   )
   @Export("maxMemoryMB")
   int maxMemoryMB;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1923517421
   )
   int field3960;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 730353507
   )
   int field3961;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2014321921
   )
   int field3951;
   @ObfuscatedName("az")
   String field3970;
   @ObfuscatedName("av")
   String field3964;
   @ObfuscatedName("ae")
   String field3965;
   @ObfuscatedName("am")
   String field3963;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 811410231
   )
   int field3967;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 834182019
   )
   int field3968;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -464356223
   )
   int field3969;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -578099205
   )
   int field3962;
   @ObfuscatedName("au")
   String field3966;
   @ObfuscatedName("bb")
   String field3955;
   @ObfuscatedName("bc")
   int[] field3973;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -487415615
   )
   int field3974;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public MachineInfo(boolean var1) {
      this.field3973 = new int[3];
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

      int var6 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
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

            var7 = var7 * 10 + (var8 - '0');
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
      this.field3958 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.field3960 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3960 = 0;
      }

      this.field3961 = 0;
      if(this.field3970 == null) {
         this.field3970 = "";
      }

      if(this.field3964 == null) {
         this.field3964 = "";
      }

      if(this.field3965 == null) {
         this.field3965 = "";
      }

      if(this.field3963 == null) {
         this.field3963 = "";
      }

      if(this.field3966 == null) {
         this.field3966 = "";
      }

      if(this.field3955 == null) {
         this.field3955 = "";
      }

      this.method5530();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1832944836"
   )
   void method5530() {
      if(this.field3970.length() > 40) {
         this.field3970 = this.field3970.substring(0, 40);
      }

      if(this.field3964.length() > 40) {
         this.field3964 = this.field3964.substring(0, 40);
      }

      if(this.field3965.length() > 10) {
         this.field3965 = this.field3965.substring(0, 10);
      }

      if(this.field3963.length() > 10) {
         this.field3963 = this.field3963.substring(0, 10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "1"
   )
   public void method5532(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field3958?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.field3960);
      var1.put24bitInt(this.field3961);
      var1.putShort(this.field3951);
      var1.putJagString(this.field3970);
      var1.putJagString(this.field3964);
      var1.putJagString(this.field3965);
      var1.putJagString(this.field3963);
      var1.putByte(this.field3968);
      var1.putShort(this.field3967);
      var1.putJagString(this.field3966);
      var1.putJagString(this.field3955);
      var1.putByte(this.field3969);
      var1.putByte(this.field3962);

      for(int var2 = 0; var2 < this.field3973.length; ++var2) {
         var1.putInt(this.field3973[var2]);
      }

      var1.putInt(this.field3974);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-12267"
   )
   public int method5531() {
      byte var1 = 38;
      int var2 = var1 + ScriptVarType.method19(this.field3970);
      var2 += ScriptVarType.method19(this.field3964);
      var2 += ScriptVarType.method19(this.field3965);
      var2 += ScriptVarType.method19(this.field3963);
      var2 += ScriptVarType.method19(this.field3966);
      var2 += ScriptVarType.method19(this.field3955);
      return var2;
   }
}
