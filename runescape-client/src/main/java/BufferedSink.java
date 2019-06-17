import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("BufferedSink")
public class BufferedSink implements Runnable {
   @ObfuscatedName("m")
   @Export("thread")
   Thread thread;
   @ObfuscatedName("f")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1805563727
   )
   @Export("capacity")
   int capacity;
   @ObfuscatedName("w")
   @Export("buffer")
   byte[] buffer;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 315461309
   )
   @Export("position")
   int position;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1028856279
   )
   @Export("limit")
   int limit;
   @ObfuscatedName("g")
   @Export("exception")
   IOException exception;
   @ObfuscatedName("l")
   @Export("isClosed0")
   boolean isClosed0;

   BufferedSink(OutputStream var1, int var2) {
      this.position = 0;
      this.limit = 0;
      this.outputStream = var1;
      this.capacity = var2 + 1;
      this.buffer = new byte[this.capacity];
      this.thread = new Thread(this);
      this.thread.setDaemon(true);
      this.thread.start();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1720378212"
   )
   @Export("isClosed")
   boolean isClosed() {
      if(this.isClosed0) {
         try {
            this.outputStream.close();
            if(this.exception == null) {
               this.exception = new IOException("");
            }
         } catch (IOException var2) {
            if(this.exception == null) {
               this.exception = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   @Export("write")
   void write(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.exception != null) {
               throw new IOException(this.exception.toString());
            } else {
               int var5;
               if(this.position <= this.limit) {
                  var5 = this.capacity - this.limit + this.position - 1;
               } else {
                  var5 = this.position - this.limit - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.limit <= this.capacity) {
                     System.arraycopy(var1, var2, this.buffer, this.limit, var3);
                  } else {
                     int var6 = this.capacity - this.limit;
                     System.arraycopy(var1, var2, this.buffer, this.limit, var6);
                     System.arraycopy(var1, var6 + var2, this.buffer, 0, var3 - var6);
                  }

                  this.limit = (var3 + this.limit) % this.capacity;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2015413947"
   )
   @Export("close")
   void close() {
      synchronized(this) {
         this.isClosed0 = true;
         this.notifyAll();
      }

      try {
         this.thread.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      while(true) {
         synchronized(this){}

         while(true) {
            boolean var13 = false;

            int var1;
            try {
               var13 = true;
               if(this.exception != null) {
                  return;
               }

               if(this.position <= this.limit) {
                  var1 = this.limit - this.position;
               } else {
                  var1 = this.capacity - this.position + this.limit;
               }

               if(var1 <= 0) {
                  try {
                     this.outputStream.flush();
                  } catch (IOException var17) {
                     this.exception = var17;
                     return;
                  }

                  if(this.isClosed()) {
                     return;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException var18) {
                     ;
                  }
                  continue;
               }

               var13 = false;
            } finally {
               if(var13) {
                  ;
               }
            }

            try {
               if(var1 + this.position <= this.capacity) {
                  this.outputStream.write(this.buffer, this.position, var1);
               } else {
                  int var2 = this.capacity - this.position;
                  this.outputStream.write(this.buffer, this.position, var2);
                  this.outputStream.write(this.buffer, 0, var1 - var2);
               }
            } catch (IOException var16) {
               IOException var3 = var16;
               synchronized(this) {
                  this.exception = var3;
                  return;
               }
            }

            synchronized(this) {
               this.position = (var1 + this.position) % this.capacity;
            }

            if(!this.isClosed()) {
               break;
            }

            return;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "449588720"
   )
   static void method3603() {
      Tiles.__bq_w = (byte[][][])null;
      Fonts.__kz_o = (byte[][][])null;
      class32.__ay_u = (byte[][][])null;
      class307.__kc_g = (byte[][][])null;
      Tiles.__bq_a = (int[][][])null;
      Tiles.__bq_l = (byte[][][])null;
      Huffman.__gd_e = (int[][])null;
      class13.__i_x = null;
      Formatting.__cy_d = null;
      class214.__hf_k = null;
      WorldMapSectionType.__h_n = null;
      Message.__bm_i = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lho;I[B[BI)V",
      garbageValue = "-1337774818"
   )
   static final void method3595(Widget var0, int var1, byte[] var2, byte[] var3) {
      if(var0.__cf == null) {
         if(var2 == null) {
            return;
         }

         var0.__cf = new byte[11][];
         var0.__cp = new byte[11][];
         var0.__cc = new int[11];
         var0.__ci = new int[11];
      }

      var0.__cf[var1] = var2;
      if(var2 != null) {
         var0.__cg = true;
      } else {
         var0.__cg = false;

         for(int var4 = 0; var4 < var0.__cf.length; ++var4) {
            if(var0.__cf[var4] != null) {
               var0.__cg = true;
               break;
            }
         }
      }

      var0.__cp[var1] = var3;
   }
}
