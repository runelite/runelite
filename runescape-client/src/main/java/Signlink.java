import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("a")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("j")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 1657191825
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("e")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("n")
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("v")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("r")
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)LTask;",
      garbageValue = "-324226504"
   )
   final Task method2929(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2222 = var2;
      var5.field2219 = var4;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)LTask;",
      garbageValue = "1684174835"
   )
   @Export("createURL")
   public final Task createURL(URL var1) {
      return this.method2929(4, 0, 0, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)LTask;",
      garbageValue = "-1950293618"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2929(2, var2, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1898075126"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)LTask;",
      garbageValue = "-1909314997"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2929(1, var2, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)LTask;",
      garbageValue = "26"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2929(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2219), var1.field2222);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2219);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2222);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2219).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2222 >> 24 & 255) + "." + (var1.field2222 >> 16 & 255) + "." + (var1.field2222 >> 8 & 255) + "." + (var1.field2222 & 255);
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

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(LPendingSpawn;B)V",
      garbageValue = "46"
   )
   static final void method2953(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class29.region.method2688(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class29.region.method2693(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class29.region.method2675(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class29.region.method2747(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class29.region.method2743(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1193 = var2;
      var0.field1195 = var3;
      var0.field1201 = var4;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-48025480"
   )
   static final void method2954() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            method2953(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
