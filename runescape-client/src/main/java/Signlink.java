import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("w")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("m")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -717725833
   )
   static int field1980;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 1240744529
   )
   static int field1979;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("f")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("n")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1910531284"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;B)Led;",
      garbageValue = "107"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Led;",
      garbageValue = "-1394371433"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Led;",
      garbageValue = "1"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "214742600"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class83.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class83.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class83.messages.put(var5, (long)var5.id);
      class83.field1205.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lic;II)V",
      garbageValue = "-95084124"
   )
   static void method3242(IndexData var0, int var1) {
      if(class325.NetCache_reference != null) {
         class325.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = class325.NetCache_reference.readInt();
         int var3 = class325.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         class37.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class250.NetCache_indexCaches[var1] = var0;
      }
   }
}
