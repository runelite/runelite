import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class2 implements class0 {
   @ObfuscatedName("y")
   static int[] field10;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-480015952"
   )
   public static void method2(String var0, String var1, int var2, int var3) throws IOException {
      class155.field2223 = var3;
      class155.field2230 = var2;

      try {
         class73.field847 = System.getProperty("os.name");
      } catch (Exception var12) {
         class73.field847 = "Unknown";
      }

      WallObject.field2113 = class73.field847.toLowerCase();

      try {
         class60.field735 = System.getProperty("user.home");
         if(class60.field735 != null) {
            class60.field735 = class60.field735 + "/";
         }
      } catch (Exception var11) {
         ;
      }

      try {
         if(WallObject.field2113.startsWith("win")) {
            if(class60.field735 == null) {
               class60.field735 = System.getenv("USERPROFILE");
            }
         } else if(class60.field735 == null) {
            class60.field735 = System.getenv("HOME");
         }

         if(class60.field735 != null) {
            class60.field735 = class60.field735 + "/";
         }
      } catch (Exception var10) {
         ;
      }

      if(class60.field735 == null) {
         class60.field735 = "~/";
      }

      class60.field736 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class60.field735, "/tmp/", ""};
      class155.field2227 = new String[]{".jagex_cache_" + class155.field2230, ".file_store_" + class155.field2230};
      int var9 = 0;

      label88:
      while(var9 < 4) {
         class155.field2224 = Preferences.method1592(var0, var1, var9);
         if(!class155.field2224.exists()) {
            class155.field2224.mkdirs();
         }

         File[] var5 = class155.field2224.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label88;
            }

            File var8 = var6[var7];
            if(!MessageNode.method1131(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      class92.method1778(class155.field2224);
      class36.method499();
      class155.field2231 = new class123(new FileOnDisk(class28.method215("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class155.field2229 = new class123(new FileOnDisk(class28.method215("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      VertexNormal.field1994 = new class123[class155.field2223];

      for(var9 = 0; var9 < class155.field2223; ++var9) {
         VertexNormal.field1994[var9] = new class123(new FileOnDisk(class28.method215("main_file_cache.idx" + var9), "rw", 1048576L), 6000, 0);
      }

   }
}
