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
   @ObfuscatedName("w")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("r")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("a")
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("s")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("t")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)LTask;",
      garbageValue = "-1334399042"
   )
   final Task method2925(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2245 = var2;
      var5.field2246 = var4;
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
      signature = "(Ljava/net/URL;B)LTask;",
      garbageValue = "25"
   )
   @Export("createURL")
   public final Task createURL(URL var1) {
      return this.method2925(4, 0, 0, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)LTask;",
      garbageValue = "-1975001180"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2925(2, var2, 0, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
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
      signature = "(Ljava/lang/String;II)LTask;",
      garbageValue = "-718440342"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2925(1, var2, 0, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LTask;",
      garbageValue = "1927296735"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2925(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2246), var1.field2245);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2246);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2245);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2246).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2245 >> 24 & 255) + "." + (var1.field2245 >> 16 & 255) + "." + (var1.field2245 >> 8 & 255) + "." + (var1.field2245 & 255);
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

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "17"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class66.loadWidget(var0)) {
         class262.field3641 = null;
         WallObject.gameDraw(class46.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class262.field3641 != null) {
            WallObject.gameDraw(class262.field3641, -1412584499, var1, var2, var3, var4, class77.field1237, class270.field3689, var7);
            class262.field3641 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1132[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1132[var8] = true;
            }
         }

      }
   }
}
