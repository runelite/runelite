import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class136 implements Runnable {
   @ObfuscatedName("z")
   class146 field2111 = null;
   @ObfuscatedName("r")
   Thread field2112;
   @ObfuscatedName("h")
   class146 field2113 = null;
   @ObfuscatedName("t")
   static String field2114;
   @ObfuscatedName("g")
   class53 field2115;
   @ObfuscatedName("f")
   boolean field2116 = false;
   @ObfuscatedName("s")
   EventQueue field2117;
   @ObfuscatedName("i")
   static String field2124;

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2116) {
                  return;
               }

               if(null != this.field2113) {
                  var1 = this.field2113;
                  this.field2113 = this.field2113.field2245;
                  if(this.field2113 == null) {
                     this.field2111 = null;
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
            int var5 = var1.field2250;
            if(var5 == 1) {
               var1.field2246 = new Socket(InetAddress.getByName((String)var1.field2252), var1.field2251);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2252);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2251);
               var1.field2246 = var3;
            } else if(var5 == 4) {
               var1.field2246 = new DataInputStream(((URL)var1.field2252).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2251 >> 24 & 255) + "." + (var1.field2251 >> 16 & 255) + "." + (var1.field2251 >> 8 & 255) + "." + (var1.field2251 & 255);
               var1.field2246 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2249 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2249 = 2;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass146;",
      garbageValue = "-964479697"
   )
   public final class146 method2857(int var1) {
      return this.method2870(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass146;",
      garbageValue = "1867547872"
   )
   public final class146 method2858(URL var1) {
      return this.method2870(4, 0, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lclass53;",
      garbageValue = "111"
   )
   public final class53 method2859() {
      return this.field2115;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   final void method2861() {
      synchronized(this) {
         this.field2116 = true;
         this.notifyAll();
      }

      try {
         this.field2112.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1002689859"
   )
   public static void method2864() {
      Object var0 = class170.field2739;
      synchronized(class170.field2739) {
         if(class170.field2736 != 0) {
            class170.field2736 = 1;

            try {
               class170.field2739.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass146;",
      garbageValue = "1572197336"
   )
   public final class146 method2867(String var1, int var2) {
      return this.method2870(1, var2, 0, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass146;",
      garbageValue = "-1289085290"
   )
   public final class146 method2868(Runnable var1, int var2) {
      return this.method2870(2, var2, 0, var1);
   }

   class136() {
      field2114 = "Unknown";
      field2124 = "1.1";

      try {
         field2114 = System.getProperty("java.vendor");
         field2124 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2117 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2116 = false;
      this.field2112 = new Thread(this);
      this.field2112.setPriority(10);
      this.field2112.setDaemon(true);
      this.field2112.start();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass146;",
      garbageValue = "2"
   )
   final class146 method2870(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2250 = var1;
      var5.field2251 = var2;
      var5.field2252 = var4;
      synchronized(this) {
         if(null != this.field2111) {
            this.field2111.field2245 = var5;
            this.field2111 = var5;
         } else {
            this.field2111 = this.field2113 = var5;
         }

         this.notify();
         return var5;
      }
   }
}
