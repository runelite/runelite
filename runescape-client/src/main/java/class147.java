import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class147 implements Runnable {
   @ObfuscatedName("s")
   volatile boolean field2181;
   @ObfuscatedName("q")
   Queue field2183;
   @ObfuscatedName("w")
   final Thread field2182;

   public class147() {
      this.field2183 = new LinkedList();
      this.field2182 = new Thread(this);
      this.field2182.setPriority(1);
      this.field2182.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1453213737"
   )
   public void method2927() {
      this.field2181 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2182.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lex;",
      garbageValue = "-953503801"
   )
   public class148 method2932(URL var1) {
      class148 var2 = new class148(var1);
      synchronized(this) {
         this.field2183.add(var2);
         this.notify();
         return var2;
      }
   }

   public void run() {
      while(!this.field2181) {
         try {
            class148 var1;
            synchronized(this) {
               var1 = (class148)this.field2183.poll();
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
               var3 = var1.field2188.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2190 = var5;
               }

               var1.field2192 = true;
            } catch (IOException var14) {
               var1.field2192 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            class46.method680((String)null, var17);
         }
      }

   }
}
