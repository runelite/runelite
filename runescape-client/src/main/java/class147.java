import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class147 implements Runnable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static class47 field2194;
   @ObfuscatedName("k")
   volatile boolean field2193;
   @ObfuscatedName("e")
   Queue field2195;
   @ObfuscatedName("d")
   final Thread field2197;

   public class147() {
      this.field2195 = new LinkedList();
      this.field2197 = new Thread(this);
      this.field2197.setPriority(1);
      this.field2197.start();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   public void method2970() {
      this.field2193 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2197.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Len;",
      garbageValue = "9"
   )
   public class148 method2969(URL var1) {
      class148 var2 = new class148(var1);
      synchronized(this) {
         this.field2195.add(var2);
         this.notify();
         return var2;
      }
   }

   public void run() {
      while(!this.field2193) {
         try {
            class148 var1;
            synchronized(this) {
               var1 = (class148)this.field2195.poll();
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
               var3 = var1.field2201.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2204 = var5;
               }

               var1.field2199 = true;
            } catch (IOException var14) {
               var1.field2199 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            DynamicObject.method1932((String)null, var17);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "496632162"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2421) {
         class175.field2419 += class175.field2421 - var0;
      }

      class175.field2421 = var0;
      return var0 + class175.field2419;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1916203893"
   )
   public static void method2976() {
      Widget.field2652.reset();
      Widget.field2735.reset();
      Widget.field2654.reset();
      Widget.field2759.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lis;",
      garbageValue = "621221673"
   )
   public static InvType method2981(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3283.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   static final int method2980(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
