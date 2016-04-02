import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class136 implements Runnable {
   @ObfuscatedName("s")
   class146 field2081 = null;
   @ObfuscatedName("f")
   class53 field2082;
   @ObfuscatedName("b")
   public static String field2083;
   @ObfuscatedName("g")
   boolean field2086 = false;
   @ObfuscatedName("a")
   public EventQueue field2087;
   @ObfuscatedName("p")
   class146 field2090 = null;
   @ObfuscatedName("h")
   Thread field2091;
   @ObfuscatedName("w")
   static String field2092;

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2086) {
                  return;
               }

               if(null != this.field2081) {
                  var1 = this.field2081;
                  this.field2081 = this.field2081.field2208;
                  if(this.field2081 == null) {
                     this.field2090 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var7) {
                  ;
               }
            }
         }

         try {
            int var2 = var1.field2211;
            if(1 == var2) {
               var1.field2216 = new Socket(InetAddress.getByName((String)var1.field2215), var1.field2214);
            } else if(2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field2215);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2214);
               var1.field2216 = var3;
            } else if(var2 == 4) {
               var1.field2216 = new DataInputStream(((URL)var1.field2215).openStream());
            } else if(3 == var2) {
               String var9 = (var1.field2214 >> 24 & 255) + "." + (var1.field2214 >> 16 & 255) + "." + (var1.field2214 >> 8 & 255) + "." + (var1.field2214 & 255);
               var1.field2216 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2213 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2213 = 2;
         }
      }
   }

   @ObfuscatedName("h")
   public final class146 method2873(int var1) {
      return this.method2887(3, var1, (Object)null);
   }

   @ObfuscatedName("s")
   public final class146 method2874(String var1, int var2) {
      return this.method2887(1, var2, var1);
   }

   @ObfuscatedName("g")
   public final class146 method2877(URL var1) {
      return this.method2887(4, 0, var1);
   }

   @ObfuscatedName("a")
   public final class53 method2878() {
      return this.field2082;
   }

   @ObfuscatedName("w")
   final void method2885() {
      synchronized(this) {
         this.field2086 = true;
         this.notifyAll();
      }

      try {
         this.field2091.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("f")
   final class146 method2887(int var1, int var2, Object var3) {
      class146 var4 = new class146();
      var4.field2211 = var1;
      var4.field2214 = var2;
      var4.field2215 = var3;
      synchronized(this) {
         if(null != this.field2090) {
            this.field2090.field2208 = var4;
            this.field2090 = var4;
         } else {
            this.field2090 = this.field2081 = var4;
         }

         this.notify();
         return var4;
      }
   }

   @ObfuscatedName("p")
   public final class146 method2888(Runnable var1, int var2) {
      return this.method2887(2, var2, var1);
   }

   class136() {
      class226.field3212 = "Unknown";
      field2092 = "1.1";

      try {
         class226.field3212 = System.getProperty("java.vendor");
         field2092 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2087 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2086 = false;
      this.field2091 = new Thread(this);
      this.field2091.setPriority(10);
      this.field2091.setDaemon(true);
      this.field2091.start();
   }
}
