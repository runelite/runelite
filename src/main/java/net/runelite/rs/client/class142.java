package net.runelite.rs.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public final class class142 implements Runnable {
   @ObfuscatedName("u")
   class135 field2162;
   @ObfuscatedName("l")
   boolean field2163 = false;
   @ObfuscatedName("f")
   Socket field2164;
   @ObfuscatedName("bc")
   static class167 field2165;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -425981213
   )
   int field2166 = 0;
   @ObfuscatedName("a")
   class145 field2167;
   @ObfuscatedName("h")
   byte[] field2168;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -367384967
   )
   int field2169 = 0;
   @ObfuscatedName("m")
   OutputStream field2170;
   @ObfuscatedName("j")
   InputStream field2171;
   @ObfuscatedName("k")
   boolean field2173 = false;

   @ObfuscatedName("m")
   public void method3022() {
      if(!this.field2163) {
         synchronized(this) {
            this.field2163 = true;
            this.notifyAll();
         }

         if(this.field2167 != null) {
            while(0 == this.field2167.field2198) {
               class29.method711(1L);
            }

            if(1 == this.field2167.field2198) {
               try {
                  ((Thread)this.field2167.field2204).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2167 = null;
      }
   }

   protected void finalize() {
      this.method3022();
   }

   @ObfuscatedName("f")
   public int method3023() throws IOException {
      return this.field2163?0:this.field2171.read();
   }

   @ObfuscatedName("l")
   public int method3024() throws IOException {
      return this.field2163?0:this.field2171.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2166 == this.field2169) {
                     if(this.field2163) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2169;
                  if(this.field2166 >= this.field2169) {
                     var1 = this.field2166 - this.field2169;
                  } else {
                     var1 = 5000 - this.field2169;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2170.write(this.field2168, var2, var1);
               } catch (IOException var8) {
                  this.field2173 = true;
               }

               this.field2169 = (this.field2169 + var1) % 5000;

               try {
                  if(this.field2166 == this.field2169) {
                     this.field2170.flush();
                  }
               } catch (IOException var7) {
                  this.field2173 = true;
               }
               continue;
            }

            try {
               if(this.field2171 != null) {
                  this.field2171.close();
               }

               if(null != this.field2170) {
                  this.field2170.close();
               }

               if(null != this.field2164) {
                  this.field2164.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2168 = null;
            break;
         }
      } catch (Exception var11) {
         class37.method803((String)null, var11);
      }

   }

   public class142(Socket var1, class135 var2) throws IOException {
      this.field2162 = var2;
      this.field2164 = var1;
      this.field2164.setSoTimeout(30000);
      this.field2164.setTcpNoDelay(true);
      this.field2164.setReceiveBufferSize(16384);
      this.field2164.setSendBufferSize(16384);
      this.field2171 = this.field2164.getInputStream();
      this.field2170 = this.field2164.getOutputStream();
   }

   @ObfuscatedName("u")
   public void method3028(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2163) {
         while(var3 > 0) {
            int var4 = this.field2171.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("j")
   public static class152[] method3039() {
      return new class152[]{class152.field2264, class152.field2265, class152.field2262, class152.field2261};
   }

   @ObfuscatedName("a")
   public void method3042(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2163) {
         if(this.field2173) {
            this.field2173 = false;
            throw new IOException();
         } else {
            if(null == this.field2168) {
               this.field2168 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2168[this.field2166] = var1[var5 + var2];
                  this.field2166 = (1 + this.field2166) % 5000;
                  if(this.field2166 == (this.field2169 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field2167 == null) {
                  this.field2167 = this.field2162.method2919(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }
}
