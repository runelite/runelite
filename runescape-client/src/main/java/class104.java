import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class104 {
   @ObfuscatedName("l")
   public static class72 field1666 = null;
   @ObfuscatedName("h")
   public static class72 field1668 = null;
   @ObfuscatedName("k")
   static File field1669;
   @ObfuscatedName("g")
   static File field1670;
   @ObfuscatedName("p")
   public static class72 field1673 = null;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1484467417
   )
   protected static int field1679;
   @ObfuscatedName("nt")
   static class57 field1680;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "208571617"
   )
   public static void method1974(String var0, String var1, int var2, int var3) throws IOException {
      class40.field819 = var3;
      class143.field2006 = var2;

      try {
         class36.field767 = System.getProperty("os.name");
      } catch (Exception var13) {
         class36.field767 = "Unknown";
      }

      class85.field1462 = class36.field767.toLowerCase();

      try {
         class39.field805 = System.getProperty("user.home");
         if(null != class39.field805) {
            class39.field805 = class39.field805 + "/";
         }
      } catch (Exception var12) {
         ;
      }

      try {
         if(class85.field1462.startsWith("win")) {
            if(class39.field805 == null) {
               class39.field805 = System.getenv("USERPROFILE");
            }
         } else if(null == class39.field805) {
            class39.field805 = System.getenv("HOME");
         }

         if(class39.field805 != null) {
            class39.field805 = class39.field805 + "/";
         }
      } catch (Exception var11) {
         ;
      }

      if(class39.field805 == null) {
         class39.field805 = "~/";
      }

      MessageNode.field231 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class39.field805, "/tmp/", ""};
      class157.field2123 = new String[]{".jagex_cache_" + class143.field2006, ".file_store_" + class143.field2006};
      int var9 = 0;

      label93:
      while(var9 < 4) {
         field1670 = class16.method179(var0, var1, var9);
         if(!field1670.exists()) {
            field1670.mkdirs();
         }

         File[] var5 = field1670.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label93;
            }

            File var8 = var6[var7];
            if(!MessageNode.method200(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      File var4 = field1670;
      class107.field1717 = var4;
      if(!class107.field1717.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1711 = true;
         class0.method2();
         field1673 = new class72(new FileOnDisk(class40.method714("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         field1666 = new class72(new FileOnDisk(class40.method714("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class9.field84 = new class72[class40.field819];

         for(int var10 = 0; var10 < class40.field819; ++var10) {
            class9.field84[var10] = new class72(new FileOnDisk(class40.method714("main_file_cache.idx" + var10), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   static void method1975() {
      Object var0 = class183.field2727;
      synchronized(class183.field2727) {
         if(class183.field2728 == 0) {
            class41.field855.method1932(new class183(), 5);
         }

         class183.field2728 = 600;
      }
   }
}
