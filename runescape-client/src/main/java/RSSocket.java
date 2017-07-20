import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1572924235
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("u")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -596375455
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("k")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("c")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("s")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("o")
   @Export("socket")
   Socket socket;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lew;)V"
   )
   public RSSocket(Socket var1, Signlink var2) throws IOException {
      this.closed = false;
      this.streamOffset = 0;
      this.outbufLen = 0;
      this.throwException = false;
      this.manager = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112917472"
   )
   @Export("close")
   public void close() {
      if(!this.closed) {
         synchronized(this) {
            this.closed = true;
            this.notifyAll();
         }

         if(this.socketThread != null) {
            while(this.socketThread.status == 0) {
               Occluder.method2829(1L);
            }

            if(this.socketThread.status == 1) {
               try {
                  ((Thread)this.socketThread.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.socketThread = null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1328764489"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-63"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.closed) {
         while(var3 > 0) {
            int var4 = this.inputStream.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-24"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.closed) {
         if(this.throwException) {
            this.throwException = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if((this.streamOffset + 4900) % 5000 == this.outbufLen) {
                     throw new IOException();
                  }
               }

               if(this.socketThread == null) {
                  this.socketThread = this.manager.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "403672251"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.closed?0:this.inputStream.read();
   }

   public void run() {
      try {
         while(true) {
            int var1;
            int var2;
            synchronized(this) {
               if(this.streamOffset == this.outbufLen) {
                  if(this.closed) {
                     break;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException var10) {
                     ;
                  }
               }

               var2 = this.streamOffset;
               if(this.outbufLen >= this.streamOffset) {
                  var1 = this.outbufLen - this.streamOffset;
               } else {
                  var1 = 5000 - this.streamOffset;
               }
            }

            if(var1 > 0) {
               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.throwException = true;
               }

               this.streamOffset = (var1 + this.streamOffset) % 5000;

               try {
                  if(this.streamOffset == this.outbufLen) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.throwException = true;
               }
            }
         }

         try {
            if(this.inputStream != null) {
               this.inputStream.close();
            }

            if(this.outputStream != null) {
               this.outputStream.close();
            }

            if(this.socket != null) {
               this.socket.close();
            }
         } catch (IOException var7) {
            ;
         }

         this.outbuffer = null;
      } catch (Exception var12) {
         WorldMapType2.method495((String)null, var12);
      }

   }

   protected void finalize() {
      this.close();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-1"
   )
   public static boolean method2936(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
