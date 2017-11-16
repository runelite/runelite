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

@ObfuscatedName("fx")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("b")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("s")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("r")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("g")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("u")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1113059485
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -193026283
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("n")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1043292193
   )
   final int field2175;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1844046861
   )
   final int field2174;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Leq;I)V"
   )
   public RSSocket(Socket var1, Signlink var2, int var3) throws IOException {
      this.closed = false;
      this.streamOffset = 0;
      this.outbufLen = 0;
      this.throwException = false;
      this.manager = var2;
      this.socket = var1;
      this.field2175 = var3;
      this.field2174 = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2042172724"
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
               GZipDecompressor.method3129(1L);
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-276399181"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.closed?0:this.inputStream.read();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "2000"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "112"
   )
   public boolean method3003(int var1) throws IOException {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-278554636"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1484328630"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.closed) {
         if(this.throwException) {
            this.throwException = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[this.field2175];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % this.field2175;
                  if((this.streamOffset + this.field2174) % this.field2175 == this.outbufLen) {
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
                  var1 = this.field2175 - this.streamOffset;
               }
            }

            if(var1 > 0) {
               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.throwException = true;
               }

               this.streamOffset = (var1 + this.streamOffset) % this.field2175;

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
         class48.method690((String)null, var12);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method3027(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class268.method4746(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
