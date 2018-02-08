import java.io.DataInputStream;
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

@ObfuscatedName("ey")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
   @ObfuscatedName("s")
   @Export("thread")
   final Thread thread;
   @ObfuscatedName("g")
   @Export("isClosed")
   volatile boolean isClosed;
   @ObfuscatedName("m")
   @Export("requests")
   Queue requests;

   public UrlRequester() {
      this.requests = new LinkedList();
      this.thread = new Thread(this);
      this.thread.setPriority(1);
      this.thread.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lea;",
      garbageValue = "-2"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1748468462"
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
            GrandExchangeEvent.method78((String)null, var17);
         }
      }

   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-125"
   )
   static final void method3145() {
      if(GrandExchangeEvent.field282) {
         if(class22.clanMemberManager != null) {
            class22.clanMemberManager.method5180();
         }

         class179.method3471();
         GrandExchangeEvent.field282 = false;
      }

   }
}
