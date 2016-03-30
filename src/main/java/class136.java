import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class136 implements Runnable {
   @ObfuscatedName("rj")
   protected static boolean field2103;
   @ObfuscatedName("t")
   class53 field2104;
   @ObfuscatedName("m")
   boolean field2105 = false;
   @ObfuscatedName("e")
   class146 field2106 = null;
   @ObfuscatedName("y")
   Thread field2107;
   @ObfuscatedName("p")
   class146 field2108 = null;
   @ObfuscatedName("c")
   public EventQueue field2109;
   @ObfuscatedName("w")
   public static String field2112;

   @ObfuscatedName("p")
   public final class146 method2885(String var1, int var2) {
      return this.method2887(1, var2, var1);
   }

   @ObfuscatedName("x")
   final void method2886() {
      synchronized(this) {
         this.field2105 = true;
         this.notifyAll();
      }

      try {
         this.field2107.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2105) {
                  return;
               }

               if(this.field2108 != null) {
                  var1 = this.field2108;
                  this.field2108 = this.field2108.field2231;
                  if(this.field2108 == null) {
                     this.field2106 = null;
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
            int var2 = var1.field2236;
            if(var2 == 1) {
               var1.field2234 = new Socket(InetAddress.getByName((String)var1.field2238), var1.field2237);
            } else if(var2 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2238);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2237);
               var1.field2234 = var3;
            } else if(var2 == 4) {
               var1.field2234 = new DataInputStream(((URL)var1.field2238).openStream());
            } else if(3 == var2) {
               String var9 = (var1.field2237 >> 24 & 255) + "." + (var1.field2237 >> 16 & 255) + "." + (var1.field2237 >> 8 & 255) + "." + (var1.field2237 & 255);
               var1.field2234 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2235 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2235 = 2;
         }
      }
   }

   @ObfuscatedName("t")
   final class146 method2887(int var1, int var2, Object var3) {
      class146 var4 = new class146();
      var4.field2236 = var1;
      var4.field2237 = var2;
      var4.field2238 = var3;
      synchronized(this) {
         if(this.field2106 != null) {
            this.field2106.field2231 = var4;
            this.field2106 = var4;
         } else {
            this.field2106 = this.field2108 = var4;
         }

         this.notify();
         return var4;
      }
   }

   @ObfuscatedName("m")
   public final class146 method2888(URL var1) {
      return this.method2887(4, 0, var1);
   }

   @ObfuscatedName("e")
   public final class146 method2889(Runnable var1, int var2) {
      return this.method2887(2, var2, var1);
   }

   @ObfuscatedName("c")
   public final class53 method2896() {
      return this.field2104;
   }

   @ObfuscatedName("y")
   public final class146 method2897(int var1) {
      return this.method2887(3, var1, (Object)null);
   }

   class136() {
      field2112 = "Unknown";
      class34.field786 = "1.1";

      try {
         field2112 = System.getProperty("java.vendor");
         class34.field786 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2109 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2105 = false;
      this.field2107 = new Thread(this);
      this.field2107.setPriority(10);
      this.field2107.setDaemon(true);
      this.field2107.start();
   }

   @ObfuscatedName("z")
   static class80 method2901() {
      class80 var0 = new class80();
      var0.field1426 = class76.field1387;
      var0.field1422 = class76.field1385;
      var0.field1424 = class76.field1392[0];
      var0.field1420 = class76.field1388[0];
      var0.field1425 = class76.field1389[0];
      var0.field1423 = class76.field1390[0];
      var0.field1421 = class76.field1391;
      var0.field1427 = class10.field180[0];
      class21.method582();
      return var0;
   }
}
