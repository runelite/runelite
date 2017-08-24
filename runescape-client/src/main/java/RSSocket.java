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

@ObfuscatedName("ff")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1154687407
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("r")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2096938191
   )
   @Export("streamOffset")
   int streamOffset;
   @ObfuscatedName("s")
   @Export("throwException")
   boolean throwException;
   @ObfuscatedName("j")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("q")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("socketThread")
   Task socketThread;
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("manager")
   Signlink manager;
   @ObfuscatedName("a")
   @Export("socket")
   Socket socket;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Leo;)V"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-92"
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
               NPC.method1702(1L);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "158537241"
   )
   @Export("available")
   public int available() throws IOException {
      return this.closed?0:this.inputStream.available();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1180424989"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-1"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1147661076"
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
         class150.method2975((String)null, var12);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2029816994"
   )
   public static boolean method3080(int var0) {
      return var0 >= class222.field2819.field2842 && var0 <= class222.field2830.field2842 || var0 == class222.field2837.field2842;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZIS)V",
      garbageValue = "24603"
   )
   public static final void method3082(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class73.sampleRate = var0;
         AbstractSoundSystem.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lbg;I)V",
      garbageValue = "-1135495407"
   )
   static final void method3081(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1287 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class216.getAnimation(var0.animation);
            if(var0.field1249 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1287;
               return;
            }

            if(var0.field1249 <= 0 && var1.priority == 0) {
               ++var0.field1287;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field1233 * 64 + var0.pathX[var0.queueSize - 1] * 128;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1233 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.orientation = 1280;
            } else if(var2 > var4) {
               var0.orientation = 1792;
            } else {
               var0.orientation = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.orientation = 768;
            } else if(var2 > var4) {
               var0.orientation = 256;
            } else {
               var0.orientation = 512;
            }
         } else if(var2 < var4) {
            var0.orientation = 1024;
         } else if(var2 > var4) {
            var0.orientation = 0;
         }

         byte var5 = var0.field1286[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1238;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1268;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1230;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1288;
            }

            if(var7 == -1) {
               var7 = var0.field1268;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1282 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1287 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1287;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1287 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1287;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field1268 == var0.poseAnimation && var0.field1272 != -1) {
               var0.poseAnimation = var0.field1272;
            }

            if(var10 != var3 || var4 != var2) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var4 == var0.y) {
               --var0.queueSize;
               if(var0.field1249 > 0) {
                  --var0.field1249;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1249 > 0) {
               --var0.field1249;
            }

         }
      }
   }
}
