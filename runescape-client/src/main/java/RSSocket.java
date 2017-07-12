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

@ObfuscatedName("fs")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("w")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("a")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("t")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("s")
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("r")
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("v")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 284893093
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -93596341
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("k")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-7241"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "887996245"
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
               XItemContainer.method1113(1L);
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

   protected void finalize() {
      this.close();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.streamOffset == this.outbufLen) {
                     if(this.closed) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
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

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var8) {
                  this.throwException = true;
               }

               this.streamOffset = (this.streamOffset + var1) % 5000;

               try {
                  if(this.outbufLen == this.streamOffset) {
                     this.outputStream.flush();
                  }
               } catch (IOException var7) {
                  this.throwException = true;
               }
               continue;
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
            } catch (IOException var6) {
               ;
            }

            this.outbuffer = null;
            break;
         }
      } catch (Exception var11) {
         MilliTimer.method2912((String)null, var11);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "475822035"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1962797063"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.closed?0:this.inputStream.read();
   }

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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1814947852"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.closed) {
         if(this.throwException) {
            this.throwException = false;
            throw new IOException();
         }

         if(this.outbuffer == null) {
            this.outbuffer = new byte[5000];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.outbuffer[this.outbufLen] = var1[var5 + var2];
               this.outbufLen = (this.outbufLen + 1) % 5000;
               if(this.outbufLen == (this.streamOffset + 4900) % 5000) {
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
