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
import net.runelite.rs.Opcodes;

@ObfuscatedName("fe")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("ak")
   protected static boolean field2267;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 260987813
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("o")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -925728497
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("x")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("w")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("p")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("s")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("q")
   @Export("socket")
   Socket socket;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lem;)V"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-80"
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
               class94.method1823(1L);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1115953745"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "124"
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
      signature = "([BIII)V",
      garbageValue = "-893314037"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1184455604"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.closed?0:this.inputStream.read();
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
               if(this.outbufLen == this.streamOffset) {
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
                  if(this.outbufLen == this.streamOffset) {
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
         class46.method680((String)null, var12);
      }

   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1184698418"
   )
   static final void method3056(String var0) {
      if(GraphicsObject.clanMembers != null) {
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_178);
         Client.secretPacketBuffer1.putByte(class86.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }
}
