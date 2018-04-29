import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("g")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("e")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("i")
   public static boolean field2193;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -866153811
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("n")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("l")
   @Export("closed")
   boolean closed;

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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "43"
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
      signature = "(IIILjava/lang/Object;B)Lfi;",
      garbageValue = "89"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lfi;",
      garbageValue = "677218124"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lfi;",
      garbageValue = "-771913685"
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

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1665454409"
   )
   static void method3322() {
      class3.method6();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-531002656"
   )
   static final void method3323() {
      PacketNode var0 = AbstractSoundSystem.method2350(ClientPacket.field2400, Client.field911.field1460);
      Client.field911.method2135(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            IndexFile.closeWidget(var1, true);
         }
      }

      if(Client.field1017 != null) {
         TotalQuantityComparator.method100(Client.field1017);
         Client.field1017 = null;
      }

   }
}
