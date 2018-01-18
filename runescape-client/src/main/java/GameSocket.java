import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("n")
   Thread field2218;
   @ObfuscatedName("v")
   OutputStream field2212;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -279611569
   )
   int field2213;
   @ObfuscatedName("r")
   byte[] field2216;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1136614461
   )
   int field2215;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1232100071
   )
   int field2217;
   @ObfuscatedName("s")
   IOException field2211;
   @ObfuscatedName("b")
   boolean field2219;

   GameSocket(OutputStream var1, int var2) {
      this.field2215 = 0;
      this.field2217 = 0;
      this.field2212 = var1;
      this.field2213 = var2 + 1;
      this.field2216 = new byte[this.field2213];
      this.field2218 = new Thread(this);
      this.field2218.setDaemon(true);
      this.field2218.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1676547654"
   )
   boolean method3193() {
      if(this.field2219) {
         try {
            this.field2212.close();
            if(this.field2211 == null) {
               this.field2211 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2211 == null) {
               this.field2211 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-55"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2211 != null) {
               throw new IOException(this.field2211.toString());
            } else {
               int var5;
               if(this.field2215 <= this.field2217) {
                  var5 = this.field2213 - this.field2217 + this.field2215 - 1;
               } else {
                  var5 = this.field2215 - this.field2217 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2217 <= this.field2213) {
                     System.arraycopy(var1, var2, this.field2216, this.field2217, var3);
                  } else {
                     int var6 = this.field2213 - this.field2217;
                     System.arraycopy(var1, var2, this.field2216, this.field2217, var6);
                     System.arraycopy(var1, var6 + var2, this.field2216, 0, var3 - var6);
                  }

                  this.field2217 = (var3 + this.field2217) % this.field2213;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   void method3183() {
      synchronized(this) {
         this.field2219 = true;
         this.notifyAll();
      }

      try {
         this.field2218.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2211 != null) {
                  return;
               }

               if(this.field2215 <= this.field2217) {
                  var1 = this.field2217 - this.field2215;
               } else {
                  var1 = this.field2213 - this.field2215 + this.field2217;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2212.flush();
               } catch (IOException var11) {
                  this.field2211 = var11;
                  return;
               }

               if(this.method3193()) {
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var12) {
                  ;
               }
            }
         }

         try {
            if(var1 + this.field2215 <= this.field2213) {
               this.field2212.write(this.field2216, this.field2215, var1);
            } else {
               int var7 = this.field2213 - this.field2215;
               this.field2212.write(this.field2216, this.field2215, var7);
               this.field2212.write(this.field2216, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2211 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2215 = (var1 + this.field2215) % this.field2213;
         }
      } while(!this.method3193());

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILfv;Lif;I)V",
      garbageValue = "-2142913328"
   )
   static void method3180(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3299;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.load(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.read(var0);
         var2.load(var1, var0, var8, true);
      }
   }
}
