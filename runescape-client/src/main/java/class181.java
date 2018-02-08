import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class181 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "712035719"
   )
   public static void method3478(String var0, String var1, int var2, int var3) throws IOException {
      FileRequest.idxCount = var3;
      class45.field565 = var2;

      try {
         class39.osName = System.getProperty("os.name");
      } catch (Exception var14) {
         class39.osName = "Unknown";
      }

      class35.osNameLC = class39.osName.toLowerCase();

      try {
         TotalQuantityComparator.userHome = System.getProperty("user.home");
         if(TotalQuantityComparator.userHome != null) {
            TotalQuantityComparator.userHome = TotalQuantityComparator.userHome + "/";
         }
      } catch (Exception var13) {
         ;
      }

      try {
         if(class35.osNameLC.startsWith("win")) {
            if(TotalQuantityComparator.userHome == null) {
               TotalQuantityComparator.userHome = System.getenv("USERPROFILE");
            }
         } else if(TotalQuantityComparator.userHome == null) {
            TotalQuantityComparator.userHome = System.getenv("HOME");
         }

         if(TotalQuantityComparator.userHome != null) {
            TotalQuantityComparator.userHome = TotalQuantityComparator.userHome + "/";
         }
      } catch (Exception var12) {
         ;
      }

      if(TotalQuantityComparator.userHome == null) {
         TotalQuantityComparator.userHome = "~/";
      }

      class279.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", TotalQuantityComparator.userHome, "/tmp/", ""};
      class84.field1281 = new String[]{".jagex_cache_" + class45.field565, ".file_store_" + class45.field565};
      int var9 = 0;

      int var7;
      File var8;
      label136:
      while(var9 < 4) {
         class150.field2091 = class63.method1035(var0, var1, var9);
         if(!class150.field2091.exists()) {
            class150.field2091.mkdirs();
         }

         File[] var5 = class150.field2091.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label136;
            }

            var8 = var6[var7];
            if(!Size.method183(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      File var4 = class150.field2091;
      class160.field2157 = var4;
      if(!class160.field2157.exists()) {
         throw new RuntimeException("");
      } else {
         class160.field2159 = true;

         try {
            File var16 = new File(TotalQuantityComparator.userHome, "random.dat");
            if(var16.exists()) {
               class157.randomDat = new CacheFile(new FileOnDisk(var16, "rw", 25L), 24, 0);
            } else {
               label116:
               for(int var10 = 0; var10 < class84.field1281.length; ++var10) {
                  for(var7 = 0; var7 < class279.cacheLocations.length; ++var7) {
                     var8 = new File(class279.cacheLocations[var7] + class84.field1281[var10] + File.separatorChar + "random.dat");
                     if(var8.exists()) {
                        class157.randomDat = new CacheFile(new FileOnDisk(var8, "rw", 25L), 24, 0);
                        break label116;
                     }
                  }
               }
            }

            if(class157.randomDat == null) {
               RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
               var7 = var17.read();
               var17.seek(0L);
               var17.write(var7);
               var17.seek(0L);
               var17.close();
               class157.randomDat = new CacheFile(new FileOnDisk(var16, "rw", 25L), 24, 0);
            }
         } catch (IOException var15) {
            ;
         }

         class157.dat2File = new CacheFile(new FileOnDisk(DecorativeObject.method3142("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class157.idx255File = new CacheFile(new FileOnDisk(DecorativeObject.method3142("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class1.idxFiles = new CacheFile[FileRequest.idxCount];

         for(int var11 = 0; var11 < FileRequest.idxCount; ++var11) {
            class1.idxFiles[var11] = new CacheFile(new FileOnDisk(DecorativeObject.method3142("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
         }

      }
   }
}
