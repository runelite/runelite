import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("i")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("k")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("x")
   @Export("closed")
   boolean closed;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      class241.javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         class241.javaVendor = System.getProperty("java.vendor");
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1671380125"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;B)Lfy;",
      garbageValue = "121"
   )
   @Export("newTask")
   final Task newTask(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.intArgument = var2;
      var5.objectArgument = var4;
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
      signature = "(Ljava/lang/String;II)Lfy;",
      garbageValue = "-2098334584"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lfy;",
      garbageValue = "-27"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.newTask(2, var2, 0, var1);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.objectArgument);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.intArgument);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.objectArgument).openStream());
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   static final void method3246() {
      if(!class132.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class132.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class132.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class132.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class132.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2813(var7, var4, var1, var0);
         int var11 = Graphics3D.method2814(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2813(var9, var5, var1, var0);
         int var12 = Graphics3D.method2814(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2811(var6, var11, var3, var2);
         var11 = Graphics3D.method2812(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2811(var8, var12, var3, var2);
         var12 = Graphics3D.method2812(var8, var12, var3, var2);
         class132.field1915 = (var6 + var10) / 2;
         AbstractSoundSystem.field1570 = (var7 + var9) / 2;
         class132.field1918 = (var12 + var11) / 2;
         class18.field306 = (var10 - var6) / 2;
         Item.field1406 = (var9 - var7) / 2;
         class132.field1917 = (var12 - var11) / 2;
         class25.field357 = Math.abs(class18.field306);
         ChatLineBuffer.field1470 = Math.abs(Item.field1406);
         GameSocket.field2258 = Math.abs(class132.field1917);
      }
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(IIIILla;Lir;I)V",
      garbageValue = "-148931943"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2765 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         MapLabel.mapedge.method5887(var15 + (var0 + var5.field2765 / 2 - var17 / 2), var5.field2763 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         BaseVarType.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
