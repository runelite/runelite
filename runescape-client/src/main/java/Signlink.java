import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("d")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("k")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("n")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1236774709
   )
   static int field2245;
   @ObfuscatedName("s")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("q")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leh;"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Leh;",
      garbageValue = "2123097703"
   )
   final Task method3022(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2240 = var2;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Leh;",
      garbageValue = "1220994707"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method3022(2, var2, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-881555459"
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Leh;",
      garbageValue = "-1795805114"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method3022(1, var2, 0, var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Leh;",
      garbageValue = "27"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method3022(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2234), var1.field2240);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2234);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2240);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2234).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2240 >> 24 & 255) + "." + (var1.field2240 >> 16 & 255) + "." + (var1.field2240 >> 8 & 255) + "." + (var1.field2240 & 255);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "40"
   )
   public static int method3020(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lkr;",
      garbageValue = "-2077769855"
   )
   static SpritePixels method3021() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class287.field3808;
      var0.maxHeight = class164.field2325;
      var0.offsetX = class287.field3807[0];
      var0.offsetY = World.offsetsY[0];
      var0.width = class236.field3238[0];
      var0.height = FileSystem.field3207[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class208.spritePixels[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class181.field2456[var2[var3] & 255];
      }

      Actor.method1605();
      return var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-86"
   )
   public static int method3041(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class238.field3253 + class238.field3255;
      return var3;
   }
}
