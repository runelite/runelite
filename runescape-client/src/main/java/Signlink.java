import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("b")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("s")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("cy")
   static boolean field2142;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("x")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("f")
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lex;",
      garbageValue = "520385044"
   )
   final Task method2953(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2129 = var2;
      var5.field2131 = var4;
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
      signature = "(Ljava/lang/String;IB)Lex;",
      garbageValue = "0"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2953(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lex;",
      garbageValue = "1054312576"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2953(2, var2, 0, var1);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2131), var1.field2129);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2131);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2129);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2131).openStream());
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "664356566"
   )
   static int method2955(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--class82.intStackSize];
         var4 = class64.method1017(var3);
      } else {
         var4 = var2?class234.field3210:class82.field1253;
      }

      if(var0 == 1000) {
         class82.intStackSize -= 4;
         var4.originalX = class82.intStack[class82.intStackSize];
         var4.originalY = class82.intStack[class82.intStackSize + 1];
         var4.field2718 = class82.intStack[class82.intStackSize + 2];
         var4.field2721 = class82.intStack[class82.intStackSize + 3];
         ScriptEvent.method1038(var4);
         class289.clientInstance.method1340(var4);
         if(var3 != -1 && var4.type == 0) {
            class90.method1686(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class82.intStackSize -= 4;
         var4.originalWidth = class82.intStack[class82.intStackSize];
         var4.field2725 = class82.intStack[class82.intStackSize + 1];
         var4.field2720 = class82.intStack[class82.intStackSize + 2];
         var4.buttonType = class82.intStack[class82.intStackSize + 3];
         ScriptEvent.method1038(var4);
         class289.clientInstance.method1340(var4);
         if(var3 != -1 && var4.type == 0) {
            class90.method1686(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--class82.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            ScriptEvent.method1038(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2847 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "-1404353204"
   )
   static final boolean method2969(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class133.field1906 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class133.field1906 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class133.field1900 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class133.field1900 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-70"
   )
   public static boolean method2968(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
