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

@ObfuscatedName("ft")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -312521567
   )
   int field2246;
   @ObfuscatedName("i")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("u")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("h")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("g")
   class154 field2250;
   @ObfuscatedName("q")
   boolean field2251;
   @ObfuscatedName("t")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("v")
   class153 field2253;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1018449025
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("a")
   boolean field2255;
   @ObfuscatedName("au")
   static SpritePixels[] field2257;

   public RSSocket(Socket var1, class154 var2) throws IOException {
      this.field2251 = false;
      this.field2246 = 0;
      this.outbufLen = 0;
      this.field2255 = false;
      this.field2250 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   protected void finalize() {
      this.method3048();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-147085461"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2251) {
         if(this.field2255) {
            this.field2255 = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if((this.field2246 + 4900) % 5000 == this.outbufLen) {
                     throw new IOException();
                  }
               }

               if(this.field2253 == null) {
                  this.field2253 = this.field2250.method2969(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-72"
   )
   @Export("available")
   public int available() throws IOException {
      return this.field2251?0:this.inputStream.available();
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "76"
   )
   static final void method3039(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class14.method75(var0)) {
         class37.method510(class90.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1507308868"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2251) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-329358441"
   )
   public void method3048() {
      if(!this.field2251) {
         synchronized(this) {
            this.field2251 = true;
            this.notifyAll();
         }

         if(this.field2253 != null) {
            while(this.field2253.field2209 == 0) {
               class19.method145(1L);
            }

            if(this.field2253.field2209 == 1) {
               try {
                  ((Thread)this.field2253.field2211).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2253 = null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1012790610"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.field2251?0:this.inputStream.read();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "0"
   )
   static int method3054(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class83.field1311:Buffer.field2384;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class83.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4062(var4, class83.scriptStringStack[--ChatMessages.scriptStringStackSize]);
            return 1;
         } else {
            --ChatMessages.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class83.intStackSize -= 2;
         var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.dragParent = class66.method1099(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2720 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2718 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2687 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2721 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.outbufLen == this.field2246) {
                     if(this.field2251) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2246;
                  if(this.outbufLen >= this.field2246) {
                     var1 = this.outbufLen - this.field2246;
                  } else {
                     var1 = 5000 - this.field2246;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field2255 = true;
               }

               this.field2246 = (this.field2246 + var1) % 5000;

               try {
                  if(this.field2246 == this.outbufLen) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field2255 = true;
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
         class232.method4169((String)null, var12);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "99724276"
   )
   public static String method3056(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class96.method1813(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }
}
