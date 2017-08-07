import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class153 extends RuntimeException {
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   static class72 field2205;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1237259861
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("e")
   public static Applet field2201;
   @ObfuscatedName("n")
   public static String field2200;
   @ObfuscatedName("y")
   String field2202;
   @ObfuscatedName("w")
   Throwable field2203;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-775165894"
   )
   public static void method2960(String var0, String var1, int var2, int var3) throws IOException {
      class156.field2229 = var3;
      class141.field2111 = var2;

      try {
         class156.osName = System.getProperty("os.name");
      } catch (Exception var12) {
         class156.osName = "Unknown";
      }

      class15.osNameLC = class156.osName.toLowerCase();

      try {
         class33.userHome = System.getProperty("user.home");
         if(class33.userHome != null) {
            class33.userHome = class33.userHome + "/";
         }
      } catch (Exception var11) {
         ;
      }

      try {
         if(class15.osNameLC.startsWith("win")) {
            if(class33.userHome == null) {
               class33.userHome = System.getenv("USERPROFILE");
            }
         } else if(class33.userHome == null) {
            class33.userHome = System.getenv("HOME");
         }

         if(class33.userHome != null) {
            class33.userHome = class33.userHome + "/";
         }
      } catch (Exception var10) {
         ;
      }

      if(class33.userHome == null) {
         class33.userHome = "~/";
      }

      class156.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class33.userHome, "/tmp/", ""};
      class262.field3617 = new String[]{".jagex_cache_" + class141.field2111, ".file_store_" + class141.field2111};
      int var4 = 0;

      label87:
      while(var4 < 4) {
         class294.field3885 = KeyFocusListener.method767(var0, var1, var4);
         if(!class294.field3885.exists()) {
            class294.field3885.mkdirs();
         }

         File[] var5 = class294.field3885.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label87;
            }

            File var8 = var6[var7];
            if(!class74.method1141(var8, false)) {
               ++var4;
               break;
            }

            ++var7;
         }
      }

      class96.method1807(class294.field3885);
      DynamicObject.method1899();
      class156.field2231 = new CacheFile(new FileOnDisk(MessageNode.method1133("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class156.field2232 = new CacheFile(new FileOnDisk(MessageNode.method1133("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class156.field2227 = new CacheFile[class156.field2229];

      for(var4 = 0; var4 < class156.field2229; ++var4) {
         class156.field2227[var4] = new CacheFile(new FileOnDisk(MessageNode.method1133("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }
}
