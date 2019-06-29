import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("pcmStreamMixer")
   static PcmStreamMixer pcmStreamMixer;
   @ObfuscatedName("m")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("f")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("current")
   Task current;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("task0")
   Task task0;
   @ObfuscatedName("o")
   @Export("thread")
   Thread thread;
   @ObfuscatedName("u")
   @Export("isClosed")
   boolean isClosed;

   public TaskHandler() {
      this.current = null;
      this.task0 = null;
      this.isClosed = false;
      javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.isClosed = false;
      this.thread = new Thread(this);
      this.thread.setPriority(10);
      this.thread.setDaemon(true);
      this.thread.start();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-341374627"
   )
   @Export("close")
   public final void close() {
      synchronized(this) {
         this.isClosed = true;
         this.notifyAll();
      }

      try {
         this.thread.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lfm;",
      garbageValue = "558028939"
   )
   @Export("newTask")
   final Task newTask(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.intArgument = var2;
      var5.objectArgument = var4;
      synchronized(this) {
         if(this.task0 != null) {
            this.task0.next = var5;
            this.task0 = var5;
         } else {
            this.task0 = this.current = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lfm;",
      garbageValue = "-1376691915"
   )
   @Export("newSocketTask")
   public final Task newSocketTask(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lfm;",
      garbageValue = "-909980487"
   )
   @Export("newThreadTask")
   public final Task newThreadTask(Runnable var1, int var2) {
      return this.newTask(2, var2, 0, var1);
   }

   @Export("run")
   @ObfuscatedName("run")
   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if(this.isClosed) {
                  return;
               }

               if(this.current != null) {
                  var1 = this.current;
                  this.current = this.current.next;
                  if(this.current == null) {
                     this.task0 = null;
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
               var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.objectArgument);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.intArgument);
               var1.result = var3;
            } else if(var5 == 4) {
               var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
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
