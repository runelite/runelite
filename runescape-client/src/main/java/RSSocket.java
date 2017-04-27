import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
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

@ObfuscatedName("dx")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("q")
   boolean field1739 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 359273835
   )
   @Export("outbufLen")
   int outbufLen = 0;
   @ObfuscatedName("n")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("c")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("t")
   class103 field1743;
   @ObfuscatedName("u")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1907040309
   )
   int field1746 = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -701752941
   )
   static int field1747;
   @ObfuscatedName("d")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("v")
   boolean field1749 = false;
   @ObfuscatedName("p")
   class102 field1751;

   protected void finalize() {
      this.method2093();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1241032807"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1739) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1672751373"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1739) {
         if(this.field1749) {
            this.field1749 = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var2 + var5];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if(this.outbufLen == (this.field1746 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field1751 == null) {
                  this.field1751 = this.field1743.method1968(this, 3);
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
                  if(this.field1746 == this.outbufLen) {
                     if(this.field1739) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1746;
                  if(this.outbufLen >= this.field1746) {
                     var1 = this.outbufLen - this.field1746;
                  } else {
                     var1 = 5000 - this.field1746;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field1749 = true;
               }

               this.field1746 = (var1 + this.field1746) % 5000;

               try {
                  if(this.outbufLen == this.field1746) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field1749 = true;
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
         class173.method3259((String)null, var12);
      }

   }

   public RSSocket(Socket var1, class103 var2) throws IOException {
      this.field1743 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2127310482"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.field1739?0:this.inputStream.read();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1695040740"
   )
   @Export("available")
   public int available() throws IOException {
      return this.field1739?0:this.inputStream.available();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   public void method2093() {
      if(!this.field1739) {
         synchronized(this) {
            this.field1739 = true;
            this.notifyAll();
         }

         if(this.field1751 != null) {
            while(this.field1751.field1653 == 0) {
               class0.method14(1L);
            }

            if(this.field1751.field1653 == 1) {
               try {
                  ((Thread)this.field1751.field1657).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1751 = null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-207172115"
   )
   static void method2095() {
      int var0 = GameEngine.field1766;
      int var1 = GameEngine.field1783;
      int var2 = GroundObject.field1285 - class187.field2760 - var0;
      int var3 = class20.field221 - IndexDataBase.field2726 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field279.method2130();
            int var5 = 0;
            int var6 = 0;
            if(class3.field26 == var4) {
               Insets var7 = class3.field26.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class20.field221);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, GroundObject.field1285, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + GroundObject.field1285 - var2, var6, var2, class20.field221);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class20.field221 + var6 - var3, GroundObject.field1285, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "1585322880"
   )
   public static class189 method2096(int var0) {
      class189 var1 = (class189)class189.field2784.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class189.field2786.getConfigData(16, var0);
         var1 = new class189();
         if(var2 != null) {
            var1.method3437(new Buffer(var2));
         }

         class189.field2784.put(var1, (long)var0);
         return var1;
      }
   }
}
