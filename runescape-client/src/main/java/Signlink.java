import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("e")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("k")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("w")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("cachedTask")
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      class276.javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         class276.javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Ley;",
      garbageValue = "-75756706"
   )
   final Task method2979(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2212 = var2;
      var5.field2209 = var4;
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Ley;",
      garbageValue = "-893444424"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2979(2, var2, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1935362821"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Ley;",
      garbageValue = "-1469298355"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2979(1, var2, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ley;",
      garbageValue = "1"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2979(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2209), var1.field2212);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2209);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2212);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2209).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2212 >> 24 & 255) + "." + (var1.field2212 >> 16 & 255) + "." + (var1.field2212 >> 8 & 255) + "." + (var1.field2212 & 255);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-3500"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = class21.field339.method1097(new URL(class66.field805));
         } else if(World.listFetcher.method1622()) {
            byte[] var0 = World.listFetcher.method1623();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class51.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class51.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class164.method3096(class51.worldList, 0, class51.worldList.length - 1, World.field1281, World.field1291);
            World.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "253"
   )
   public static boolean method2963(int var0, int var1) {
      return 0 != (var0 >> var1 + 1 & 1);
   }
}
