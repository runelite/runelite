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

@ObfuscatedName("fa")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("d")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("x")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("k")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("z")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("b")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -434084447
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -918097731
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("r")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1326327729
   )
   final int field2172;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -636044789
   )
   final int field2178;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lel;I)V"
   )
   public RSSocket(Socket var1, Signlink var2, int var3) throws IOException {
      this.closed = false;
      this.streamOffset = 0;
      this.outbufLen = 0;
      this.throwException = false;
      this.manager = var2;
      this.socket = var1;
      this.field2172 = var3;
      this.field2178 = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "734"
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
               BaseVarType.method12(1L);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1914910833"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.closed?0:this.inputStream.read();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2140883812"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-127"
   )
   public boolean method3119(int var1) throws IOException {
      if(this.closed) {
         return false;
      } else {
         try {
            return this.inputStream.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-9304624"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1239279461"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.closed) {
         if(this.throwException) {
            this.throwException = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[this.field2172];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % this.field2172;
                  if((this.streamOffset + this.field2178) % this.field2172 == this.outbufLen) {
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

   protected void finalize() {
      this.close();
   }

   public void run() {
      try {
         while(true) {
            label79: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.streamOffset == this.outbufLen) {
                     if(this.closed) {
                        break label79;
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
                     var1 = this.field2172 - this.streamOffset;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.throwException = true;
               }

               this.streamOffset = (var1 + this.streamOffset) % this.field2172;

               try {
                  if(this.outbufLen == this.streamOffset) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
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
            } catch (IOException var7) {
               ;
            }

            this.outbuffer = null;
            break;
         }
      } catch (Exception var12) {
         Item.method1829((String)null, var12);
      }

   }
}
