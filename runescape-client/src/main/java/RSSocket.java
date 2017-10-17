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

@ObfuscatedName("fi")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1871572789
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("p")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 927880139
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("t")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("d")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("r")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("k")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("e")
   @Export("socket")
   Socket socket;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lez;)V"
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "43"
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
               class211.method4044(1L);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "16156"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "994485765"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-6"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "42"
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
         DynamicObject.method1932((String)null, var12);
      }

   }

   protected void finalize() {
      this.close();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "2134912325"
   )
   public static String method3088(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = 65533;
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfd;IB)Z",
      garbageValue = "103"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1487[++class94.field1486 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field886 = var1;
            if(class94.field1478[var1] != null) {
               var6.decodeApperance(class94.field1478[var1]);
            }

            var6.orientation = class94.field1475[var1];
            var6.interacting = class94.field1481[var1];
            var7 = class94.field1483[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1264[0] = class94.field1477[var1];
            var6.field894 = (byte)var8;
            var6.method1173((var9 << 13) + var3 - WallObject.baseX, (var10 << 13) + var4 - Varcs.baseY);
            var6.field887 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.field1483[var1];
         class94.field1483[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.field1483[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class94.field1483[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.field1483[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class94.field1483[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
