import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("DesktopPlatformInfoProvider")
public class DesktopPlatformInfoProvider implements PlatformInfoProvider {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Llb;",
      garbageValue = "-843739713"
   )
   public PlatformInfo get() {
      byte var1;
      if(WorldMapSection3.osNameLowerCase.startsWith("win")) {
         var1 = 1;
      } else if(WorldMapSection3.osNameLowerCase.startsWith("mac")) {
         var1 = 2;
      } else if(WorldMapSection3.osNameLowerCase.startsWith("linux")) {
         var1 = 3;
      } else {
         var1 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var25) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var24) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var23) {
         ;
      }

      boolean var6;
      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         var6 = false;
      } else {
         var6 = true;
      }

      byte var7 = 0;
      if(var1 == 1) {
         if(var3.indexOf("4.0") != -1) {
            var7 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            var7 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            var7 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            var7 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            var7 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            var7 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            var7 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            var7 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            var7 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            var7 = 10;
         } else if(var3.indexOf("10.0") != -1) {
            var7 = 11;
         }
      } else if(var1 == 2) {
         if(var3.indexOf("10.4") != -1) {
            var7 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            var7 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            var7 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            var7 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            var7 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            var7 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            var7 = 26;
         } else if(var3.indexOf("10.11") != -1) {
            var7 = 27;
         } else if(var3.indexOf("10.12") != -1) {
            var7 = 28;
         } else if(var3.indexOf("10.13") != -1) {
            var7 = 29;
         }
      }

      byte var8;
      if(var4.toLowerCase().indexOf("sun") != -1) {
         var8 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         var8 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         var8 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         var8 = 5;
      } else {
         var8 = 4;
      }

      int var9 = 2;
      int var10 = 0;

      try {
         while(var9 < var5.length()) {
            char var11 = var5.charAt(var9);
            if(var11 < '0' || var11 > '9') {
               break;
            }

            var10 = var10 * 10 + (var11 - '0');
            ++var9;
         }
      } catch (Exception var28) {
         ;
      }

      int var29 = var10;
      var9 = var5.indexOf(46, 2) + 1;
      var10 = 0;

      try {
         while(var9 < var5.length()) {
            char var12 = var5.charAt(var9);
            if(var12 < '0' || var12 > '9') {
               break;
            }

            var10 = var12 - '0' + var10 * 10;
            ++var9;
         }
      } catch (Exception var27) {
         ;
      }

      int var30 = var10;
      var9 = var5.indexOf(95, 4) + 1;
      var10 = 0;

      try {
         while(var9 < var5.length()) {
            char var13 = var5.charAt(var9);
            if(var13 < '0' || var13 > '9') {
               break;
            }

            var10 = var13 - '0' + var10 * 10;
            ++var9;
         }
      } catch (Exception var26) {
         ;
      }

      Runtime.getRuntime();
      int var31 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      int var14;
      if(var29 > 3) {
         var14 = Runtime.getRuntime().availableProcessors();
      } else {
         var14 = 0;
      }

      byte var15 = 0;
      String var16 = "";
      String var17 = "";
      String var18 = "";
      String var19 = "";
      String var20 = "";
      String var21 = "";
      int[] var22 = new int[3];
      return new PlatformInfo(var1, var6, var7, var8, var29, var30, var10, false, var31, var14, var15, 0, var16, var17, var18, var19, 0, 0, 0, 0, var20, var21, var22, 0, "");
   }
}
