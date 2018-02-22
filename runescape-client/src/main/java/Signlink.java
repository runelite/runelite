import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("b")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("a")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("h")
   @Export("closed")
   boolean closed;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      class21.javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         class21.javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1687765368"
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
      signature = "(IIILjava/lang/Object;I)Lfk;",
      garbageValue = "-1152163308"
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
      signature = "(Ljava/lang/String;II)Lfk;",
      garbageValue = "-873563611"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lfk;",
      garbageValue = "-1"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)Llm;",
      garbageValue = "-492596146"
   )
   public static final SpritePixels method3249(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lia;IB)V",
      garbageValue = "-56"
   )
   static void method3246(IndexData var0, int var1) {
      if(FontName.NetCache_reference != null) {
         FontName.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = FontName.NetCache_reference.readInt();
         int var3 = FontName.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         DynamicObject.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class258.NetCache_indexCaches[var1] = var0;
      }
   }
}
