package net.runelite.rs.client;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public final class class142 implements Runnable {
   @ObfuscatedName("i")
   boolean field2184 = false;
   @ObfuscatedName("l")
   OutputStream field2185;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 303057897
   )
   int field2186 = 0;
   @ObfuscatedName("a")
   Socket field2187;
   @ObfuscatedName("f")
   class135 field2188;
   @ObfuscatedName("m")
   class145 field2189;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 1512255163
   )
   public static int field2190;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1839183683
   )
   int field2191 = 0;
   @ObfuscatedName("j")
   InputStream field2192;
   @ObfuscatedName("o")
   byte[] field2193;
   @ObfuscatedName("k")
   boolean field2194 = false;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -2012461321
   )
   @Export("cameraX")
   static int field2197;

   public class142(Socket var1, class135 var2) throws IOException {
      this.field2188 = var2;
      this.field2187 = var1;
      this.field2187.setSoTimeout(30000);
      this.field2187.setTcpNoDelay(true);
      this.field2187.setReceiveBufferSize(16384);
      this.field2187.setSendBufferSize(16384);
      this.field2192 = this.field2187.getInputStream();
      this.field2185 = this.field2187.getOutputStream();
   }

   protected void finalize() {
      this.method2948();
   }

   @ObfuscatedName("f")
   public int method2929() throws IOException {
      return this.field2184?0:this.field2192.read();
   }

   @ObfuscatedName("o")
   public void method2931(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2184) {
         while(var3 > 0) {
            int var4 = this.field2192.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("h")
   public void method2932(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2184) {
         if(this.field2194) {
            this.field2194 = false;
            throw new IOException();
         } else {
            if(null == this.field2193) {
               this.field2193 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2193[this.field2186] = var1[var5 + var2];
                  this.field2186 = (this.field2186 + 1) % 5000;
                  if(this.field2186 == (4900 + this.field2191) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field2189) {
                  this.field2189 = this.field2188.method2833(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("m")
   public int method2940() throws IOException {
      return this.field2184?0:this.field2192.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2186 == this.field2191) {
                     if(this.field2184) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2191;
                  if(this.field2186 >= this.field2191) {
                     var1 = this.field2186 - this.field2191;
                  } else {
                     var1 = 5000 - this.field2191;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2185.write(this.field2193, var2, var1);
               } catch (IOException var8) {
                  this.field2194 = true;
               }

               this.field2191 = (var1 + this.field2191) % 5000;

               try {
                  if(this.field2191 == this.field2186) {
                     this.field2185.flush();
                  }
               } catch (IOException var7) {
                  this.field2194 = true;
               }
               continue;
            }

            try {
               if(this.field2192 != null) {
                  this.field2192.close();
               }

               if(null != this.field2185) {
                  this.field2185.close();
               }

               if(this.field2187 != null) {
                  this.field2187.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2193 = null;
            break;
         }
      } catch (Exception var11) {
         class16.method184((String)null, var11);
      }

   }

   @ObfuscatedName("i")
   public void method2948() {
      if(!this.field2184) {
         synchronized(this) {
            this.field2184 = true;
            this.notifyAll();
         }

         if(null != this.field2189) {
            while(this.field2189.field2222 == 0) {
               class105.method2332(1L);
            }

            if(this.field2189.field2222 == 1) {
               try {
                  ((Thread)this.field2189.field2223).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2189 = null;
      }
   }

   @ObfuscatedName("a")
   public static class172 method2954(int var0, int var1) {
      class172 var2 = class31.method698(var0);
      return var1 == -1?var2:(null != var2 && var2.field2881 != null && var1 < var2.field2881.length?var2.field2881[var1]:null);
   }

   @ObfuscatedName("l")
   public static String method2955(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(1 + var7 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class189.method3702(var3);
      if(null == var8) {
         var8 = "";
      }

      return var8;
   }
}
