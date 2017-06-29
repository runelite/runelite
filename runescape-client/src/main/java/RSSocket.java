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
   Signlink field2278;
   @ObfuscatedName("r")
   @Export("socketThread")
   class153 socketThread;
   @ObfuscatedName("v")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 284893093
   )
   int field2281;
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
                  ((Thread)this.socketThread.field2239).join();
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
            int var1;
            int var2;
            synchronized(this) {
               if(this.field2281 == this.outbufLen) {
                  if(this.closed) {
                     break;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException var10) {
                     ;
                  }
               }

               var2 = this.field2281;
               if(this.outbufLen >= this.field2281) {
                  var1 = this.outbufLen - this.field2281;
               } else {
                  var1 = 5000 - this.field2281;
               }
            }

            if(var1 > 0) {
               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.throwException = true;
               }

               this.field2281 = (this.field2281 + var1) % 5000;

               try {
                  if(this.outbufLen == this.field2281) {
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
         class151.method2912((String)null, var12);
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
      this.field2281 = 0;
      this.outbufLen = 0;
      this.throwException = false;
      this.field2278 = var2;
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
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if(this.outbufLen == (this.field2281 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.socketThread == null) {
                  this.socketThread = this.field2278.method2927(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }
}
