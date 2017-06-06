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

@ObfuscatedName("fp")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("c")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1567018067
   )
   static int field2290;
   @ObfuscatedName("v")
   boolean field2292;
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("y")
   class153 field2294;
   @ObfuscatedName("h")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -992111631
   )
   int field2296;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1310380629
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("n")
   boolean field2298;
   @ObfuscatedName("b")
   class154 field2299;
   @ObfuscatedName("e")
   @Export("socket")
   Socket socket;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-623851410"
   )
   public void method2981() {
      if(!this.field2292) {
         synchronized(this) {
            this.field2292 = true;
            this.notifyAll();
         }

         if(this.field2294 != null) {
            while(this.field2294.field2244 == 0) {
               class4.method9(1L);
            }

            if(this.field2294.field2244 == 1) {
               try {
                  ((Thread)this.field2294.field2248).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2294 = null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.field2292?0:this.inputStream.read();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2292) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "93"
   )
   public static boolean method2986(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2686.method4112(var0)) {
         return false;
      } else {
         int var1 = Widget.field2686.method4187(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(CombatInfo1.widgets[var0] == null) {
               CombatInfo1.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(CombatInfo1.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2686.getConfigData(var0, var2);
                  if(var3 != null) {
                     CombatInfo1.widgets[var0][var2] = new Widget();
                     CombatInfo1.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        CombatInfo1.widgets[var0][var2].method3995(new Buffer(var3));
                     } else {
                        CombatInfo1.widgets[var0][var2].method3978(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
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
                  if(this.outbufLen == this.field2296) {
                     if(this.field2292) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2296;
                  if(this.outbufLen >= this.field2296) {
                     var1 = this.outbufLen - this.field2296;
                  } else {
                     var1 = 5000 - this.field2296;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field2298 = true;
               }

               this.field2296 = (this.field2296 + var1) % 5000;

               try {
                  if(this.outbufLen == this.field2296) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field2298 = true;
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
         class21.method138((String)null, var12);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2145684202"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2292) {
         if(this.field2298) {
            this.field2298 = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var2 + var5];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if(this.outbufLen == (this.field2296 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field2294 == null) {
                  this.field2294 = this.field2299.method2936(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "7"
   )
   @Export("available")
   public int available() throws IOException {
      return this.field2292?0:this.inputStream.available();
   }

   public RSSocket(Socket var1, class154 var2) throws IOException {
      this.field2292 = false;
      this.field2296 = 0;
      this.outbufLen = 0;
      this.field2298 = false;
      this.field2299 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   protected void finalize() {
      this.method2981();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "0"
   )
   static char method3005(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1673027194"
   )
   static void method3006(Widget var0, int var1, int var2) {
      if(var0.field2656 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2656 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2656 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2656 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2656 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var1 * var0.originalX >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2643 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2643 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2643 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2643 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2643 == 4) {
         var0.relativeY = (var0.originalY * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1100 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
