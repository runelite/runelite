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

@ObfuscatedName("dc")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1265743587
   )
   @Export("outbufLen")
   int outbufLen = 0;
   @ObfuscatedName("j")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("x")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("d")
   boolean field1756 = false;
   @ObfuscatedName("w")
   class103 field1757;
   @ObfuscatedName("h")
   class102 field1758;
   @ObfuscatedName("y")
   boolean field1759 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 781981105
   )
   int field1760 = 0;
   @ObfuscatedName("u")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("c")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("bk")
   static class184 field1763;

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1760 == this.outbufLen) {
                     if(this.field1756) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1760;
                  if(this.outbufLen >= this.field1760) {
                     var1 = this.outbufLen - this.field1760;
                  } else {
                     var1 = 5000 - this.field1760;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field1759 = true;
               }

               this.field1760 = (this.field1760 + var1) % 5000;

               try {
                  if(this.field1760 == this.outbufLen) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field1759 = true;
               }
               continue;
            }

            try {
               if(null != this.inputStream) {
                  this.inputStream.close();
               }

               if(this.outputStream != null) {
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
         class31.method703((String)null, var12);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   public void method2115() {
      if(!this.field1756) {
         synchronized(this) {
            this.field1756 = true;
            this.notifyAll();
         }

         if(this.field1758 != null) {
            while(this.field1758.field1673 == 0) {
               class140.method2660(1L);
            }

            if(this.field1758.field1673 == 1) {
               try {
                  ((Thread)this.field1758.field1677).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1758 = null;
      }
   }

   protected void finalize() {
      this.method2115();
   }

   public RSSocket(Socket var1, class103 var2) throws IOException {
      this.field1757 = var2;
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
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method2116() throws IOException {
      return this.field1756?0:this.inputStream.available();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1155935127"
   )
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1756) {
         if(this.field1759) {
            this.field1759 = false;
            throw new IOException();
         } else {
            if(null == this.outbuffer) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if(this.outbufLen == (4900 + this.field1760) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field1758) {
                  this.field1758 = this.field1757.method2023(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2041487990"
   )
   public int method2118() throws IOException {
      return this.field1756?0:this.inputStream.read();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "1"
   )
   public void method2119(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1756) {
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

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-682674213"
   )
   static final void method2133(Widget var0, int var1, int var2, int var3) {
      class164 var4 = var0.method3213(false);
      if(var4 != null) {
         if(Client.field549 < 3) {
            class15.field193.method4160(var1, var2, var4.field2146, var4.field2150, 25, 25, Client.mapAngle, 256, var4.field2141, var4.field2142);
         } else {
            Rasterizer2D.method4063(var1, var2, 0, var4.field2141, var4.field2142);
         }

      }
   }
}
