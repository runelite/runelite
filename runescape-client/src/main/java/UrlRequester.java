import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
   @ObfuscatedName("a")
   @Export("thread")
   final Thread thread;
   @ObfuscatedName("w")
   @Export("isClosed")
   volatile boolean isClosed;
   @ObfuscatedName("e")
   @Export("requests")
   Queue requests;

   public UrlRequester() {
      this.requests = new LinkedList();
      this.thread = new Thread(this);
      this.thread.setPriority(1);
      this.thread.start();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lep;",
      garbageValue = "-531735453"
   )
   @Export("request")
   public UrlRequest request(URL var1) {
      UrlRequest var2 = new UrlRequest(var1);
      synchronized(this) {
         this.requests.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-960428971"
   )
   @Export("close")
   public void close() {
      this.isClosed = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.thread.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.isClosed) {
         try {
            UrlRequest var1;
            synchronized(this) {
               var1 = (UrlRequest)this.requests.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.url.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var7 = var3.getContentLength();
               if(var7 >= 0) {
                  byte[] var5 = new byte[var7];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.response0 = var5;
               }

               var1.isDone0 = true;
            } catch (IOException var14) {
               var1.isDone0 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            PendingSpawn.method1461((String)null, var17);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-37177235"
   )
   public static void method2917(String var0, String var1, int var2, int var3) throws IOException {
      class157.idxCount = var3;
      AbstractByteBuffer.field2534 = var2;

      try {
         GrandExchangeOffer.osName = System.getProperty("os.name");
      } catch (Exception var13) {
         GrandExchangeOffer.osName = "Unknown";
      }

      class157.osNameLC = GrandExchangeOffer.osName.toLowerCase();

      try {
         class1.userHome = System.getProperty("user.home");
         if(class1.userHome != null) {
            class1.userHome = class1.userHome + "/";
         }
      } catch (Exception var12) {
         ;
      }

      try {
         if(class157.osNameLC.startsWith("win")) {
            if(class1.userHome == null) {
               class1.userHome = System.getenv("USERPROFILE");
            }
         } else if(class1.userHome == null) {
            class1.userHome = System.getenv("HOME");
         }

         if(class1.userHome != null) {
            class1.userHome = class1.userHome + "/";
         }
      } catch (Exception var11) {
         ;
      }

      if(class1.userHome == null) {
         class1.userHome = "~/";
      }

      class115.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class1.userHome, "/tmp/", ""};
      GrandExchangeOffer.field298 = new String[]{".jagex_cache_" + AbstractByteBuffer.field2534, ".file_store_" + AbstractByteBuffer.field2534};
      int var9 = 0;

      label94:
      while(var9 < 4) {
         class157.field2138 = RunException.method2970(var0, var1, var9);
         if(!class157.field2138.exists()) {
            class157.field2138.mkdirs();
         }

         File[] var5 = class157.field2138.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label94;
            }

            File var8 = var6[var7];
            if(!AbstractSoundSystem.method2055(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      File var4 = class157.field2138;
      class160.field2148 = var4;
      if(!class160.field2148.exists()) {
         throw new RuntimeException("");
      } else {
         class160.field2150 = true;
         Tile.method2505();
         class157.dat2File = new CacheFile(new FileOnDisk(MessageNode.method1071("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class157.idx255File = new CacheFile(new FileOnDisk(MessageNode.method1071("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class157.idxFiles = new CacheFile[class157.idxCount];

         for(int var10 = 0; var10 < class157.idxCount; ++var10) {
            class157.idxFiles[var10] = new CacheFile(new FileOnDisk(MessageNode.method1071("main_file_cache.idx" + var10), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1415109720"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
