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
   @Export("closed")
   boolean closed;

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
      if (this.closed) {
         try {
            this.outputStream.close();
            if (this.exception == null) {
               this.exception = new IOException("");
            }
         } catch (IOException var2) {
            if (this.exception == null) {
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
   void write(byte[] src, int srcIndex, int length) throws IOException {
      if (length >= 0 && srcIndex >= 0 && length + srcIndex <= src.length) {
         synchronized(this) {
            if (this.exception != null) {
               throw new IOException(this.exception.toString());
            } else {
               int var5;
               if (this.position <= this.limit) {
                  var5 = this.capacity - this.limit + this.position - 1;
               } else {
                  var5 = this.position - this.limit - 1;
               }

               if (var5 < length) {
                  throw new IOException("");
               } else {
                  if (length + this.limit <= this.capacity) {
                     System.arraycopy(src, srcIndex, this.buffer, this.limit, length);
                  } else {
                     int var6 = this.capacity - this.limit;
                     System.arraycopy(src, srcIndex, this.buffer, this.limit, var6);
                     System.arraycopy(src, var6 + srcIndex, this.buffer, 0, length - var6);
                  }

                  this.limit = (length + this.limit) % this.capacity;
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
         this.closed = true;
         this.notifyAll();
      }

      try {
         this.thread.join();
      } catch (InterruptedException var3) {
      }

   }

   public void run() {
      while (true) {
         synchronized(this) {
            ;
         }

         while (true) {
            boolean var1 = false;

            int var2;
            try {
               var1 = true;
               if (this.exception != null) {
                  return;
               }

               if (this.position <= this.limit) {
                  var2 = this.limit - this.position;
               } else {
                  var2 = this.capacity - this.position + this.limit;
               }

               if (var2 <= 0) {
                  try {
                     this.outputStream.flush();
                  } catch (IOException var20) {
                     this.exception = var20;
                     return;
                  }

                  if (this.isClosed()) {
                     return;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException var18) {
                  }
                  continue;
               }

               var1 = false;
            } finally {
               if (var1) {
               }

            }

            try {
               if (var2 + this.position <= this.capacity) {
                  this.outputStream.write(this.buffer, this.position, var2);
               } else {
                  int var3 = this.capacity - this.position;
                  this.outputStream.write(this.buffer, this.position, var3);
                  this.outputStream.write(this.buffer, 0, var2 - var3);
               }
            } catch (IOException var17) {
               IOException var4 = var17;
               synchronized(this) {
                  this.exception = var4;
                  return;
               }
            }

            synchronized(this) {
               this.position = (var2 + this.position) % this.capacity;
            }

            if (!this.isClosed()) {
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
      Tiles.field908 = ((byte[][][])null);
      Fonts.field350 = ((byte[][][])null);
      class32.field1157 = ((byte[][][])null);
      class307.field1155 = ((byte[][][])null);
      Tiles.field910 = ((int[][][])null);
      Tiles.field909 = ((byte[][][])null);
      Huffman.field398 = ((int[][])null);
      class13.field1112 = null;
      Formatting.field353 = null;
      class214.field1131 = null;
      WorldMapSectionType.field1104 = null;
      Message.field490 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lho;I[B[BI)V",
      garbageValue = "-1337774818"
   )
   static final void method3595(Widget var0, int var1, byte[] var2, byte[] var3) {
      if (var0.field966 == null) {
         if (var2 == null) {
            return;
         }

         var0.field966 = new byte[11][];
         var0.field967 = new byte[11][];
         var0.field968 = new int[11];
         var0.field969 = new int[11];
      }

      var0.field966[var1] = var2;
      if (var2 != null) {
         var0.field965 = true;
      } else {
         var0.field965 = false;

         for (int var4 = 0; var4 < var0.field966.length; ++var4) {
            if (var0.field966[var4] != null) {
               var0.field965 = true;
               break;
            }
         }
      }

      var0.field967[var1] = var3;
   }
}
