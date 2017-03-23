import java.awt.Component;
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

@ObfuscatedName("dr")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("r")
   class103 field1764;
   @ObfuscatedName("h")
   boolean field1765 = false;
   @ObfuscatedName("o")
   class102 field1767;
   @ObfuscatedName("l")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 165349317
   )
   int field1769 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -205896385
   )
   @Export("outbufLen")
   int outbufLen = 0;
   @ObfuscatedName("w")
   boolean field1771 = false;
   @ObfuscatedName("f")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("u")
   @Export("socket")
   Socket socket;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;B)V",
      garbageValue = "0"
   )
   static final void method2100(CipherBuffer var0) {
      var0.method3102();
      int var1 = Client.localInteractingIndex;
      Player var2 = Projectile.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field266 = var1;
      int var3 = var0.method3111(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class119.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method207() << 6);
      var2.pathY[0] = var6 - class187.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method207() << 6);
      Sequence.plane = var2.field276 = var4;
      if(null != class45.field919[var1]) {
         var2.method206(class45.field919[var1]);
      }

      class45.field923 = 0;
      class45.field918[++class45.field923 - 1] = var1;
      class45.field926[var1] = 0;
      class45.field925 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3111(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field927[var7] = var11 + (var10 << 14) + (var9 << 28);
            class45.field928[var7] = 0;
            class45.field929[var7] = -1;
            class45.field934[++class45.field925 - 1] = var7;
            class45.field926[var7] = 0;
         }
      }

      var0.method3103();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-2847"
   )
   public int method2102() throws IOException {
      return this.field1765?0:this.inputStream.read();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-426581949"
   )
   public void method2104(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1765) {
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
      signature = "([BIIB)V",
      garbageValue = "-85"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1765) {
         if(this.field1771) {
            this.field1771 = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var2 + var5];
                  this.outbufLen = (1 + this.outbufLen) % 5000;
                  if(this.outbufLen == (4900 + this.field1769) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field1767) {
                  this.field1767 = this.field1764.method2004(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.outbufLen == this.field1769) {
                     if(this.field1765) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1769;
                  if(this.outbufLen >= this.field1769) {
                     var1 = this.outbufLen - this.field1769;
                  } else {
                     var1 = 5000 - this.field1769;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field1771 = true;
               }

               this.field1769 = (var1 + this.field1769) % 5000;

               try {
                  if(this.outbufLen == this.field1769) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field1771 = true;
               }
               continue;
            }

            try {
               if(null != this.inputStream) {
                  this.inputStream.close();
               }

               if(null != this.outputStream) {
                  this.outputStream.close();
               }

               if(null != this.socket) {
                  this.socket.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.outbuffer = null;
            break;
         }
      } catch (Exception var12) {
         GameObject.method1958((String)null, var12);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "640884711"
   )
   public int method2108() throws IOException {
      return this.field1765?0:this.inputStream.available();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1041548930"
   )
   public void method2113() {
      if(!this.field1765) {
         synchronized(this) {
            this.field1765 = true;
            this.notifyAll();
         }

         if(null != this.field1767) {
            while(this.field1767.field1686 == 0) {
               class115.method2300(1L);
            }

            if(this.field1767.field1686 == 1) {
               try {
                  ((Thread)this.field1767.field1690).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1767 = null;
      }
   }

   public RSSocket(Socket var1, class103 var2) throws IOException {
      this.field1764 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1174101502"
   )
   static int method2119(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2115[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;IIB)Lclass57;",
      garbageValue = "8"
   )
   public static final class57 method2120(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1077 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1064 = new int[256 * (class57.field1078?2:1)];
            var4.field1069 = var3;
            var4.vmethod1150(var1);
            var4.field1084 = 1024 + (var3 & -1024);
            if(var4.field1084 > 16384) {
               var4.field1084 = 16384;
            }

            var4.vmethod1149(var4.field1084);
            if(class217.field3186 > 0 && null == Item.field907) {
               Item.field907 = new class63();
               Item.field907.field1115 = var0;
               var0.method2004(Item.field907, class217.field3186);
            }

            if(Item.field907 != null) {
               if(null != Item.field907.field1114[var2]) {
                  throw new IllegalArgumentException();
               }

               Item.field907.field1114[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   protected void finalize() {
      this.method2113();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "915556056"
   )
   public static boolean method2121(CharSequence var0) {
      return ChatLineBuffer.method940(var0, 10, true);
   }
}
