import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public final class class143 implements Runnable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1773747371
   )
   int field2158 = 0;
   @ObfuscatedName("m")
   Socket field2159;
   @ObfuscatedName("z")
   boolean field2160 = false;
   @ObfuscatedName("h")
   OutputStream field2161;
   @ObfuscatedName("e")
   class146 field2162;
   @ObfuscatedName("x")
   class136 field2163;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1623625217
   )
   int field2164 = 0;
   @ObfuscatedName("i")
   byte[] field2165;
   @ObfuscatedName("l")
   boolean field2167 = false;
   @ObfuscatedName("j")
   InputStream field2169;
   @ObfuscatedName("in")
   static class173 field2170;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "74"
   )
   public void method2964() {
      if(!this.field2160) {
         synchronized(this) {
            this.field2160 = true;
            this.notifyAll();
         }

         if(this.field2162 != null) {
            while(this.field2162.field2195 == 0) {
               class14.method170(1L);
            }

            if(1 == this.field2162.field2195) {
               try {
                  ((Thread)this.field2162.field2194).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2162 = null;
      }
   }

   protected void finalize() {
      this.method2964();
   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2163 = var2;
      this.field2159 = var1;
      this.field2159.setSoTimeout(30000);
      this.field2159.setTcpNoDelay(true);
      this.field2159.setReceiveBufferSize(16384);
      this.field2159.setSendBufferSize(16384);
      this.field2169 = this.field2159.getInputStream();
      this.field2161 = this.field2159.getOutputStream();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1161576945"
   )
   public void method2966(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2160) {
         while(var3 > 0) {
            int var4 = this.field2169.read(var1, var2, var3);
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
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method2967(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2160) {
         if(this.field2167) {
            this.field2167 = false;
            throw new IOException();
         } else {
            if(null == this.field2165) {
               this.field2165 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2165[this.field2158] = var1[var2 + var5];
                  this.field2158 = (1 + this.field2158) % 5000;
                  if((4900 + this.field2164) % 5000 == this.field2158) {
                     throw new IOException();
                  }
               }

               if(null == this.field2162) {
                  this.field2162 = this.field2163.method2851(this, 3);
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
                  if(this.field2164 == this.field2158) {
                     if(this.field2160) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2164;
                  if(this.field2158 >= this.field2164) {
                     var1 = this.field2158 - this.field2164;
                  } else {
                     var1 = 5000 - this.field2164;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2161.write(this.field2165, var2, var1);
               } catch (IOException var8) {
                  this.field2167 = true;
               }

               this.field2164 = (var1 + this.field2164) % 5000;

               try {
                  if(this.field2164 == this.field2158) {
                     this.field2161.flush();
                  }
               } catch (IOException var7) {
                  this.field2167 = true;
               }
               continue;
            }

            try {
               if(null != this.field2169) {
                  this.field2169.close();
               }

               if(null != this.field2161) {
                  this.field2161.close();
               }

               if(null != this.field2159) {
                  this.field2159.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2165 = null;
            break;
         }
      } catch (Exception var11) {
         class6.method102((String)null, var11);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-48"
   )
   public int method2968() throws IOException {
      return this.field2160?0:this.field2169.read();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1547433881"
   )
   public int method2972() throws IOException {
      return this.field2160?0:this.field2169.available();
   }
}
