import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("t")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("q")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("cachedTask")
   Task cachedTask;
   @ObfuscatedName("l")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("b")
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20397"
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
      signature = "(IIILjava/lang/Object;I)Lfb;",
      garbageValue = "-158789734"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lfb;",
      garbageValue = "-1431825632"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lfb;",
      garbageValue = "1525855689"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfy;ZB)V",
      garbageValue = "119"
   )
   public static void method3223(class169 var0, boolean var1) {
      if(SoundTaskDataProvider.NetCache_socket != null) {
         try {
            SoundTaskDataProvider.NetCache_socket.vmethod3339();
         } catch (Exception var6) {
            ;
         }

         SoundTaskDataProvider.NetCache_socket = null;
      }

      SoundTaskDataProvider.NetCache_socket = var0;
      JagexGame.sendConInfo(var1);
      class264.NetCache_responseHeaderBuffer.offset = 0;
      currentRequest = null;
      CacheFile.NetCache_responseArchiveBuffer = null;
      class264.field3424 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class264.NetCache_pendingPriorityResponses.first();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class264.NetCache_pendingResponses.first();
               if(var2 == null) {
                  if(class264.field3427 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class264.field3427);
                        var7.putShort(0);
                        SoundTaskDataProvider.NetCache_socket.vmethod3340(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           SoundTaskDataProvider.NetCache_socket.vmethod3339();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class264.field3413;
                        SoundTaskDataProvider.NetCache_socket = null;
                     }
                  }

                  class264.field3417 = 0;
                  class151.field2101 = WorldMapRegion.method465();
                  return;
               }

               class264.NetCache_pendingWritesQueue.setHead(var2);
               class264.NetCache_pendingWrites.put(var2, var2.hash);
               ++class264.NetCache_pendingWritesCount;
               --class264.NetCache_pendingResponsesCount;
            }
         }

         class264.NetCache_pendingPriorityWrites.put(var2, var2.hash);
         ++class264.NetCache_pendingPriorityWritesCount;
         --class264.NetCache_pendingPriorityResponsesCount;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lju;IIIBZI)V",
      garbageValue = "1973532283"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class264.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class264.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class264.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class264.NetCache_pendingPriorityWritesCount;
               } else {
                  class264.NetCache_pendingWritesQueue.push(var8);
                  class264.NetCache_pendingWrites.put(var8, var6);
                  ++class264.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "17419889"
   )
   static int method3237(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "509896006"
   )
   static int method3242(int var0, Script var1, boolean var2) {
      Widget var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      if(var0 == 2600) {
         class81.intStack[++class5.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class81.intStack[++class5.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class81.intStack[++class5.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class81.intStack[++class5.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class81.intStack[++class5.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class81.intStack[++class5.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class81.intStack[++class5.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class81.intStack[++class5.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class81.intStack[++class5.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class81.intStack[++class5.intStackSize - 1] = var3.field2952;
         return 1;
      } else if(var0 == 2611) {
         class81.intStack[++class5.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class81.intStack[++class5.intStackSize - 1] = var3.field2879;
         return 1;
      } else if(var0 == 2613) {
         class81.intStack[++class5.intStackSize - 1] = var3.field2808.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
