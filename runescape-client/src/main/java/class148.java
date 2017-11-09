import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class148 implements Runnable {
   @ObfuscatedName("ft")
   static byte[][] field2107;
   @ObfuscatedName("m")
   final Thread field2110;
   @ObfuscatedName("p")
   volatile boolean field2109;
   @ObfuscatedName("i")
   Queue field2108;

   public class148() {
      this.field2108 = new LinkedList();
      this.field2110 = new Thread(this);
      this.field2110.setPriority(1);
      this.field2110.start();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Ley;",
      garbageValue = "1445815700"
   )
   public class149 method3006(URL var1) {
      class149 var2 = new class149(var1);
      synchronized(this) {
         this.field2108.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2050864375"
   )
   public void method3011() {
      this.field2109 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2110.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.field2109) {
         try {
            class149 var1;
            synchronized(this) {
               var1 = (class149)this.field2108.poll();
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
               var3 = var1.field2111.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2113 = var5;
               }

               var1.field2114 = true;
            } catch (IOException var14) {
               var1.field2114 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            class33.method396((String)null, var17);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2142850105"
   )
   public static boolean method3010(int var0) {
      return var0 == class228.field2903.field2887;
   }
}
