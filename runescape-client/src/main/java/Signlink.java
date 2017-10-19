import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("w")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1027755043
   )
   static int field2230;
   @ObfuscatedName("c")
   static int[] field2231;
   @ObfuscatedName("v")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("g")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("cachedTask")
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      class18.javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         class18.javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Let;",
      garbageValue = "-1698095252"
   )
   final Task method2977(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2222 = var2;
      var5.field2223 = var4;
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Let;",
      garbageValue = "-1094648036"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2977(2, var2, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "94442798"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Let;",
      garbageValue = "1571435179"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2977(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Let;",
      garbageValue = "31658"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2977(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2223), var1.field2222);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2223);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2222);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2223).openStream());
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILfc;Lfw;I)Z",
      garbageValue = "1512527763"
   )
   static final boolean method2991(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2302[var6][var7] = 99;
      class162.field2295[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2298[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2299[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class162.field2298[var11];
         var5 = class162.field2299[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3126(2, var4, var5, var3)) {
            class162.field2296 = var4;
            class162.field2292 = var5;
            return true;
         }

         int var15 = class162.field2295[var16][var17] + 1;
         if(var16 > 0 && class162.field2302[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17] = 2;
            class162.field2295[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class162.field2302[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17] = 8;
            class162.field2295[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2302[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class162.field2298[var18] = var4;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16][var17 - 1] = 1;
            class162.field2295[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class162.field2302[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class162.field2298[var18] = var4;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16][var17 + 1] = 4;
            class162.field2295[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2302[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17 - 1] = 3;
            class162.field2295[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class162.field2302[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17 - 1] = 9;
            class162.field2295[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class162.field2302[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17 + 1] = 6;
            class162.field2295[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class162.field2302[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17 + 1] = 12;
            class162.field2295[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2296 = var4;
      class162.field2292 = var5;
      return false;
   }
}
