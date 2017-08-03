import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("d")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("q")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("f")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("e")
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Ley;",
      garbageValue = "1685094141"
   )
   final Task method2955(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2202 = var2;
      var5.field2200 = var4;
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Ley;",
      garbageValue = "21"
   )
   @Export("createURL")
   public final Task createURL(URL var1) {
      return this.method2955(4, 0, 0, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Ley;",
      garbageValue = "561315781"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2955(2, var2, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "243"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Ley;",
      garbageValue = "1954047012"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2955(1, var2, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ley;",
      garbageValue = "-774373192"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2955(3, var1, 0, (Object)null);
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
               var1.value = new Socket(InetAddress.getByName((String)var1.field2200), var1.field2202);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2200);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2202);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2200).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2202 >> 24 & 255) + "." + (var1.field2202 >> 16 & 255) + "." + (var1.field2202 >> 8 & 255) + "." + (var1.field2202 & 255);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-51"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lhn;III)V",
      garbageValue = "539093290"
   )
   static final void method2952(Widget var0, int var1, int var2) {
      if(Client.field1118 == 0 || Client.field1118 == 3) {
         if(MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4) {
            class210 var3 = var0.method4012(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field709 - var1;
            int var5 = MouseInput.field713 - var2;
            if(var3.method3933(var4, var5)) {
               var4 -= var3.field2580 / 2;
               var5 -= var3.field2581 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var7 * var5 + var8 * var4 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + class224.localPlayer.x >> 7;
               int var12 = class224.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(147);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.putLEInt(var12 + class17.baseY);
               Client.secretPacketBuffer1.putShortLE(var11 + class33.baseX);
               Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?(KeyFocusListener.field604[81]?2:1):0);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(class224.localPlayer.x);
               Client.secretPacketBuffer1.putShort(class224.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-1864030730"
   )
   static int method2974(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class83.intStackSize -= 3;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var5 = class83.intStack[class83.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = WallObject.method2901(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class214.field2615 = var12;
               } else {
                  class73.field851 = var12;
               }

               class48.method732(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class214.field2615:class73.field851;
            Widget var10 = WallObject.method2901(var9.id);
            var10.children[var9.index] = null;
            class48.method732(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
            var9.children = null;
            class48.method732(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++class83.intStackSize - 1] = 1;
                  if(var2) {
                     class214.field2615 = var9;
                  } else {
                     class73.field851 = var9;
                  }
               } else {
                  class83.intStack[++class83.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            Widget var11 = GZipDecompressor.method3133(var3, var4);
            if(var11 != null && var4 != -1) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class214.field2615 = var11;
               } else {
                  class73.field851 = var11;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
