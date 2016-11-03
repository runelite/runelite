import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class139 implements Runnable {
   @ObfuscatedName("m")
   EventQueue field2143;
   @ObfuscatedName("k")
   public static String field2144;
   @ObfuscatedName("f")
   class149 field2145 = null;
   @ObfuscatedName("c")
   class149 field2146 = null;
   @ObfuscatedName("v")
   Thread field2147;
   @ObfuscatedName("q")
   static String field2148;
   @ObfuscatedName("j")
   boolean field2151 = false;

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2151) {
                  return;
               }

               if(this.field2145 != null) {
                  var1 = this.field2145;
                  this.field2145 = this.field2145.field2267;
                  if(null == this.field2145) {
                     this.field2146 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.field2265;
            if(var5 == 1) {
               var1.field2262 = new Socket(InetAddress.getByName((String)var1.field2264), var1.field2260);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2264);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2260);
               var1.field2262 = var3;
            } else if(var5 == 4) {
               var1.field2262 = new DataInputStream(((URL)var1.field2264).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2260 >> 24 & 255) + "." + (var1.field2260 >> 16 & 255) + "." + (var1.field2260 >> 8 & 255) + "." + (var1.field2260 & 255);
               var1.field2262 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2268 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2268 = 2;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "-1300406397"
   )
   final class149 method2916(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2265 = var1;
      var5.field2260 = var2;
      var5.field2264 = var4;
      synchronized(this) {
         if(null != this.field2146) {
            this.field2146.field2267 = var5;
            this.field2146 = var5;
         } else {
            this.field2146 = this.field2145 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass149;",
      garbageValue = "1"
   )
   public final class149 method2917(String var1, int var2) {
      return this.method2916(1, var2, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "342914590"
   )
   public final class149 method2918(Runnable var1, int var2) {
      return this.method2916(2, var2, 0, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "-719234410"
   )
   public final class149 method2919(int var1) {
      return this.method2916(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "-648607067"
   )
   public final class149 method2920(URL var1) {
      return this.method2916(4, 0, 0, var1);
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "836109363"
   )
   static void method2930(int var0) {
      for(class204 var1 = (class204)Client.widgetFlags.method3825(); var1 != null; var1 = (class204)Client.widgetFlags.method3826()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }

   class139() {
      field2144 = "Unknown";
      field2148 = "1.1";

      try {
         field2144 = System.getProperty("java.vendor");
         field2148 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2143 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2151 = false;
      this.field2147 = new Thread(this);
      this.field2147.setPriority(10);
      this.field2147.setDaemon(true);
      this.field2147.start();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   final void method2937() {
      synchronized(this) {
         this.field2151 = true;
         this.notifyAll();
      }

      try {
         this.field2147.join();
      } catch (InterruptedException var3) {
         ;
      }

   }
}
