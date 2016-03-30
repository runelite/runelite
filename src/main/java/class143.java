import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public final class class143 implements Runnable {
   @ObfuscatedName("t")
   Socket field2199;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1285618683
   )
   int field2200 = 0;
   @ObfuscatedName("x")
   OutputStream field2201;
   @ObfuscatedName("p")
   boolean field2202 = false;
   @ObfuscatedName("eu")
   static class78 field2203;
   @ObfuscatedName("y")
   class146 field2204;
   @ObfuscatedName("m")
   byte[] field2205;
   @ObfuscatedName("l")
   boolean field2206 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1386236665
   )
   int field2207 = 0;
   @ObfuscatedName("e")
   class136 field2208;
   @ObfuscatedName("w")
   InputStream field2210;

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2208 = var2;
      this.field2199 = var1;
      this.field2199.setSoTimeout(30000);
      this.field2199.setTcpNoDelay(true);
      this.field2199.setReceiveBufferSize(16384);
      this.field2199.setSendBufferSize(16384);
      this.field2210 = this.field2199.getInputStream();
      this.field2201 = this.field2199.getOutputStream();
   }

   protected void finalize() {
      this.method3005();
   }

   @ObfuscatedName("t")
   public int method2999() throws IOException {
      return this.field2202?0:this.field2210.read();
   }

   @ObfuscatedName("p")
   public int method3000() throws IOException {
      return this.field2202?0:this.field2210.available();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "8"
   )
   public void method3001(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2202) {
         while(var3 > 0) {
            int var4 = this.field2210.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "252880127"
   )
   public void method3002(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2202) {
         if(this.field2206) {
            this.field2206 = false;
            throw new IOException();
         } else {
            if(null == this.field2205) {
               this.field2205 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2205[this.field2207] = var1[var2 + var5];
                  this.field2207 = (this.field2207 + 1) % 5000;
                  if((4900 + this.field2200) % 5000 == this.field2207) {
                     throw new IOException();
                  }
               }

               if(null == this.field2204) {
                  this.field2204 = this.field2208.method2889(this, 3);
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
                  if(this.field2200 == this.field2207) {
                     if(this.field2202) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2200;
                  if(this.field2207 >= this.field2200) {
                     var1 = this.field2207 - this.field2200;
                  } else {
                     var1 = 5000 - this.field2200;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2201.write(this.field2205, var2, var1);
               } catch (IOException var8) {
                  this.field2206 = true;
               }

               this.field2200 = (var1 + this.field2200) % 5000;

               try {
                  if(this.field2207 == this.field2200) {
                     this.field2201.flush();
                  }
               } catch (IOException var7) {
                  this.field2206 = true;
               }
               continue;
            }

            try {
               if(null != this.field2210) {
                  this.field2210.close();
               }

               if(null != this.field2201) {
                  this.field2201.close();
               }

               if(this.field2199 != null) {
                  this.field2199.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2205 = null;
            break;
         }
      } catch (Exception var11) {
         class0.method0((String)null, var11);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "120"
   )
   public void method3005() {
      if(!this.field2202) {
         synchronized(this) {
            this.field2202 = true;
            this.notifyAll();
         }

         if(this.field2204 != null) {
            while(0 == this.field2204.field2235) {
               class104.method2291(1L);
            }

            if(this.field2204.field2235 == 1) {
               try {
                  ((Thread)this.field2204.field2234).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2204 = null;
      }
   }

   @ObfuscatedName("w")
   public static int method3010(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(2 == var2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("i")
   static final boolean method3020(int var0, int var1) {
      class40 var2 = class22.method592(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method825(var1);
   }
}
