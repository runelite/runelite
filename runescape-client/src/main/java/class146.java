import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public final class class146 implements Runnable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1224548615
   )
   int field2240 = 0;
   @ObfuscatedName("w")
   OutputStream field2241;
   @ObfuscatedName("m")
   InputStream field2242;
   @ObfuscatedName("o")
   boolean field2243 = false;
   @ObfuscatedName("g")
   class139 field2244;
   @ObfuscatedName("e")
   Socket field2245;
   @ObfuscatedName("l")
   class149 field2246;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1385688907
   )
   int field2247 = 0;
   @ObfuscatedName("j")
   byte[] field2248;
   @ObfuscatedName("k")
   boolean field2249 = false;
   @ObfuscatedName("dp")
   static int[] field2251;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1935911454"
   )
   static final int method3041(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1303573146"
   )
   public int method3042() throws IOException {
      return this.field2243?0:this.field2242.read();
   }

   protected void finalize() {
      this.method3050();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int method3044() throws IOException {
      return this.field2243?0:this.field2242.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2240 == this.field2247) {
                     if(this.field2243) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2247;
                  if(this.field2240 >= this.field2247) {
                     var1 = this.field2240 - this.field2247;
                  } else {
                     var1 = 5000 - this.field2247;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2241.write(this.field2248, var2, var1);
               } catch (IOException var9) {
                  this.field2249 = true;
               }

               this.field2247 = (this.field2247 + var1) % 5000;

               try {
                  if(this.field2247 == this.field2240) {
                     this.field2241.flush();
                  }
               } catch (IOException var8) {
                  this.field2249 = true;
               }
               continue;
            }

            try {
               if(null != this.field2242) {
                  this.field2242.close();
               }

               if(this.field2241 != null) {
                  this.field2241.close();
               }

               if(this.field2245 != null) {
                  this.field2245.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2248 = null;
            break;
         }
      } catch (Exception var12) {
         class54.method1130((String)null, var12);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1195186161"
   )
   public void method3045(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2243) {
         if(this.field2249) {
            this.field2249 = false;
            throw new IOException();
         } else {
            if(this.field2248 == null) {
               this.field2248 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2248[this.field2240] = var1[var2 + var5];
                  this.field2240 = (this.field2240 + 1) % 5000;
                  if(this.field2240 == (4900 + this.field2247) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field2246) {
                  this.field2246 = this.field2244.method2937(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   public void method3050() {
      if(!this.field2243) {
         synchronized(this) {
            this.field2243 = true;
            this.notifyAll();
         }

         if(this.field2246 != null) {
            while(this.field2246.field2278 == 0) {
               class141.method2993(1L);
            }

            if(this.field2246.field2278 == 1) {
               try {
                  ((Thread)this.field2246.field2282).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2246 = null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "24"
   )
   public void method3061(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2243) {
         while(var3 > 0) {
            int var4 = this.field2242.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "68"
   )
   static final void method3064(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field369.method3882(); null != var10; var10 = (class16)client.field369.method3891()) {
         if(var0 == var10.field213 && var1 == var10.field209 && var2 == var10.field210 && var10.field208 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field213 = var0;
         var9.field208 = var3;
         var9.field209 = var1;
         var9.field210 = var2;
         class44.method922(var9);
         client.field369.method3877(var9);
      }

      var9.field218 = var4;
      var9.field207 = var5;
      var9.field215 = var6;
      var9.field217 = var7;
      var9.field221 = var8;
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2244 = var2;
      this.field2245 = var1;
      this.field2245.setSoTimeout(30000);
      this.field2245.setTcpNoDelay(true);
      this.field2245.setReceiveBufferSize(16384);
      this.field2245.setSendBufferSize(16384);
      this.field2242 = this.field2245.getInputStream();
      this.field2241 = this.field2245.getOutputStream();
   }
}
