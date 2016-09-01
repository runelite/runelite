import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public final class class146 implements Runnable {
   @ObfuscatedName("z")
   boolean field2233 = false;
   @ObfuscatedName("r")
   OutputStream field2234;
   @ObfuscatedName("j")
   Socket field2235;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 65610613
   )
   int field2236 = 0;
   @ObfuscatedName("x")
   InputStream field2237;
   @ObfuscatedName("b")
   class149 field2238;
   @ObfuscatedName("l")
   byte[] field2239;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -875233799
   )
   int field2240 = 0;
   @ObfuscatedName("f")
   boolean field2241 = false;
   @ObfuscatedName("i")
   class139 field2243;

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2243 = var2;
      this.field2235 = var1;
      this.field2235.setSoTimeout(30000);
      this.field2235.setTcpNoDelay(true);
      this.field2235.setReceiveBufferSize(16384);
      this.field2235.setSendBufferSize(16384);
      this.field2237 = this.field2235.getInputStream();
      this.field2234 = this.field2235.getOutputStream();
   }

   protected void finalize() {
      this.method3044();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "921206184"
   )
   public int method3040() throws IOException {
      return this.field2233?0:this.field2237.read();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1743276933"
   )
   public int method3041() throws IOException {
      return this.field2233?0:this.field2237.available();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1813097385"
   )
   public void method3042(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2233) {
         while(var3 > 0) {
            int var4 = this.field2237.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-90738214"
   )
   public void method3043(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2233) {
         if(this.field2241) {
            this.field2241 = false;
            throw new IOException();
         } else {
            if(this.field2239 == null) {
               this.field2239 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2239[this.field2236] = var1[var2 + var5];
                  this.field2236 = (this.field2236 + 1) % 5000;
                  if((this.field2240 + 4900) % 5000 == this.field2236) {
                     throw new IOException();
                  }
               }

               if(null == this.field2238) {
                  this.field2238 = this.field2243.method2927(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1482540007"
   )
   public void method3044() {
      if(!this.field2233) {
         synchronized(this) {
            this.field2233 = true;
            this.notifyAll();
         }

         if(this.field2238 != null) {
            while(this.field2238.field2266 == 0) {
               class125.method2820(1L);
            }

            if(this.field2238.field2266 == 1) {
               try {
                  ((Thread)this.field2238.field2270).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2238 = null;
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2236 == this.field2240) {
                     if(this.field2233) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2240;
                  if(this.field2236 >= this.field2240) {
                     var1 = this.field2236 - this.field2240;
                  } else {
                     var1 = 5000 - this.field2240;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2234.write(this.field2239, var2, var1);
               } catch (IOException var9) {
                  this.field2241 = true;
               }

               this.field2240 = (this.field2240 + var1) % 5000;

               try {
                  if(this.field2240 == this.field2236) {
                     this.field2234.flush();
                  }
               } catch (IOException var8) {
                  this.field2241 = true;
               }
               continue;
            }

            try {
               if(this.field2237 != null) {
                  this.field2237.close();
               }

               if(this.field2234 != null) {
                  this.field2234.close();
               }

               if(null != this.field2235) {
                  this.field2235.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2239 = null;
            break;
         }
      } catch (Exception var12) {
         class107.method2357((String)null, var12);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-19"
   )
   static final int method3060(int var0, int var1) {
      int var2 = World.method592(var0 + '넵', 91923 + var1, 4) - 128 + (World.method592(10294 + var0, '鎽' + var1, 2) - 128 >> 1) + (World.method592(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)(0.3D * (double)var2);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
