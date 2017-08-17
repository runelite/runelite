import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("j")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("h")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("g")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("x")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("cachedTask")
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lea;",
      garbageValue = "787269431"
   )
   final Task method2959(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2232 = var2;
      var5.field2233 = var4;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lea;",
      garbageValue = "-1714249919"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2959(2, var2, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1260466749"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lea;",
      garbageValue = "1698657658"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2959(1, var2, 0, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lea;",
      garbageValue = "1873585617"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2959(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2233), var1.field2232);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2233);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2232);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2233).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2232 >> 24 & 255) + "." + (var1.field2232 >> 16 & 255) + "." + (var1.field2232 >> 8 & 255) + "." + (var1.field2232 & 255);
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
}
