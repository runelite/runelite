import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public final class class143 implements Runnable {
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 553166441
   )
   static int field2208;
   @ObfuscatedName("i")
   OutputStream field2209;
   @ObfuscatedName("g")
   Socket field2210;
   @ObfuscatedName("h")
   boolean field2211 = false;
   @ObfuscatedName("r")
   class146 field2213;
   @ObfuscatedName("f")
   byte[] field2214;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1588420585
   )
   int field2215 = 0;
   @ObfuscatedName("z")
   class136 field2216;
   @ObfuscatedName("l")
   boolean field2217 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 851178089
   )
   int field2218 = 0;
   @ObfuscatedName("t")
   InputStream field2220;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 786468261
   )
   static int field2222;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass80;B)V",
      garbageValue = "2"
   )
   static final void method2959(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class162.field2678.length; ++var2) {
         class162.field2678[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class162.field2678[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class30.field700[var5] = (class162.field2678[var5 + 128] + class162.field2678[var5 - 128] + class162.field2678[var5 - 1] + class162.field2678[var5 + 1]) / 4;
            }
         }

         int[] var8 = class162.field2678;
         class162.field2678 = class30.field700;
         class30.field700 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1425; ++var3) {
            for(var4 = 0; var4 < var0.field1424; ++var4) {
               if(var0.field1428[var2++] != 0) {
                  var5 = var0.field1429 + var4 + 16;
                  int var6 = var3 + 16 + var0.field1427;
                  int var7 = var5 + (var6 << 7);
                  class162.field2678[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-619005041"
   )
   public void method2960() {
      if(!this.field2211) {
         synchronized(this) {
            this.field2211 = true;
            this.notifyAll();
         }

         if(this.field2213 != null) {
            while(this.field2213.field2249 == 0) {
               class45.method926(1L);
            }

            if(this.field2213.field2249 == 1) {
               try {
                  ((Thread)this.field2213.field2246).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2213 = null;
      }
   }

   protected void finalize() {
      this.method2960();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1548443866"
   )
   public int method2961() throws IOException {
      return this.field2211?0:this.field2220.read();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "39"
   )
   public void method2963(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2211) {
         while(var3 > 0) {
            int var4 = this.field2220.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method2964(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2211) {
         if(this.field2217) {
            this.field2217 = false;
            throw new IOException();
         } else {
            if(this.field2214 == null) {
               this.field2214 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2214[this.field2218] = var1[var2 + var5];
                  this.field2218 = (this.field2218 + 1) % 5000;
                  if((this.field2215 + 4900) % 5000 == this.field2218) {
                     throw new IOException();
                  }
               }

               if(this.field2213 == null) {
                  this.field2213 = this.field2216.method2868(this, 3);
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
                  if(this.field2218 == this.field2215) {
                     if(this.field2211) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2215;
                  if(this.field2218 >= this.field2215) {
                     var1 = this.field2218 - this.field2215;
                  } else {
                     var1 = 5000 - this.field2215;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2209.write(this.field2214, var2, var1);
               } catch (IOException var9) {
                  this.field2217 = true;
               }

               this.field2215 = (var1 + this.field2215) % 5000;

               try {
                  if(this.field2215 == this.field2218) {
                     this.field2209.flush();
                  }
               } catch (IOException var8) {
                  this.field2217 = true;
               }
               continue;
            }

            try {
               if(this.field2220 != null) {
                  this.field2220.close();
               }

               if(null != this.field2209) {
                  this.field2209.close();
               }

               if(null != this.field2210) {
                  this.field2210.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2214 = null;
            break;
         }
      } catch (Exception var12) {
         class30.method654((String)null, var12);
      }

   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2216 = var2;
      this.field2210 = var1;
      this.field2210.setSoTimeout(30000);
      this.field2210.setTcpNoDelay(true);
      this.field2210.setReceiveBufferSize(16384);
      this.field2210.setSendBufferSize(16384);
      this.field2220 = this.field2210.getInputStream();
      this.field2209 = this.field2210.getOutputStream();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1932588230"
   )
   public int method2980() throws IOException {
      return this.field2211?0:this.field2220.available();
   }
}
