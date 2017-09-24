import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("i")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("n")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("o")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("cachedTask")
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      class170.javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         class170.javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lez;",
      garbageValue = "-698890676"
   )
   final Task method3006(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2238 = var2;
      var5.field2234 = var4;
      synchronized(this) {
         if(this.cachedTask != null) {
            this.cachedTask.task = var5;
            this.cachedTask = var5;
         } else {
            this.cachedTask = this.currentTask = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lez;",
      garbageValue = "1583845240"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method3006(2, var2, 0, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-635246963"
   )
   @Export("join")
   public final void join() {
      synchronized(this) {
         this.closed = true;
         this.notifyAll();
      }

      try {
         this.sysEventQueue.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lez;",
      garbageValue = "-53"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method3006(1, var2, 0, var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lez;",
      garbageValue = "1044300206"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method3006(3, var1, 0, (Object)null);
   }

   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if(this.closed) {
                  return;
               }

               if(this.currentTask != null) {
                  var1 = this.currentTask;
                  this.currentTask = this.currentTask.task;
                  if(this.currentTask == null) {
                     this.cachedTask = null;
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
            int var5 = var1.type;
            if(var5 == 1) {
               var1.value = new Socket(InetAddress.getByName((String)var1.field2234), var1.field2238);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2234);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2238);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2234).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2238 >> 24 & 255) + "." + (var1.field2238 >> 16 & 255) + "." + (var1.field2238 >> 8 & 255) + "." + (var1.field2238 & 255);
               var1.value = InetAddress.getByName(var10).getHostName();
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;IIB)[Ljx;",
      garbageValue = "99"
   )
   static IndexedSprite[] method3029(IndexDataBase var0, int var1, int var2) {
      return !class178.method3474(var0, var1, var2)?null:class41.method592();
   }
}
