import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class146 implements Runnable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 158742017
   )
   int field2238 = 0;
   @ObfuscatedName("r")
   Socket field2239;
   @ObfuscatedName("l")
   InputStream field2240;
   @ObfuscatedName("e")
   boolean field2241 = false;
   @ObfuscatedName("h")
   class139 field2242;
   @ObfuscatedName("s")
   class149 field2243;
   @ObfuscatedName("k")
   byte[] field2244;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1488155481
   )
   int field2245 = 0;
   @ObfuscatedName("b")
   boolean field2247 = false;
   @ObfuscatedName("g")
   OutputStream field2248;

   protected void finalize() {
      this.method3131();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1292375190"
   )
   public void method3131() {
      if(!this.field2241) {
         synchronized(this) {
            this.field2241 = true;
            this.notifyAll();
         }

         if(this.field2243 != null) {
            while(this.field2243.field2276 == 0) {
               class22.method594(1L);
            }

            if(this.field2243.field2276 == 1) {
               try {
                  ((Thread)this.field2243.field2272).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2243 = null;
      }

   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2245 == this.field2238) {
                     if(this.field2241) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2245;
                  if(this.field2238 >= this.field2245) {
                     var1 = this.field2238 - this.field2245;
                  } else {
                     var1 = 5000 - this.field2245;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2248.write(this.field2244, var2, var1);
               } catch (IOException var8) {
                  this.field2247 = true;
               }

               this.field2245 = (this.field2245 + var1) % 5000;

               try {
                  if(this.field2245 == this.field2238) {
                     this.field2248.flush();
                  }
               } catch (IOException var7) {
                  this.field2247 = true;
               }
               continue;
            }

            try {
               if(null != this.field2240) {
                  this.field2240.close();
               }

               if(null != this.field2248) {
                  this.field2248.close();
               }

               if(null != this.field2239) {
                  this.field2239.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2244 = null;
            break;
         }
      } catch (Exception var11) {
         class13.method176((String)null, var11);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1789714128"
   )
   public void method3132(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2241) {
         while(var3 > 0) {
            int var4 = this.field2240.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1534269861"
   )
   public void method3135(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2241) {
         if(this.field2247) {
            this.field2247 = false;
            throw new IOException();
         }

         if(null == this.field2244) {
            this.field2244 = new byte[5000];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.field2244[this.field2238] = var1[var2 + var5];
               this.field2238 = (1 + this.field2238) % 5000;
               if(this.field2238 == (this.field2245 + 4900) % 5000) {
                  throw new IOException();
               }
            }

            if(this.field2243 == null) {
               this.field2243 = this.field2242.method3029(this, 3);
            }

            this.notifyAll();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-715913074"
   )
   public int method3140() throws IOException {
      return this.field2241?0:this.field2240.read();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1074972346"
   )
   public int method3141() throws IOException {
      return this.field2241?0:this.field2240.available();
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2242 = var2;
      this.field2239 = var1;
      this.field2239.setSoTimeout(30000);
      this.field2239.setTcpNoDelay(true);
      this.field2239.setReceiveBufferSize(16384);
      this.field2239.setSendBufferSize(16384);
      this.field2240 = this.field2239.getInputStream();
      this.field2248 = this.field2239.getOutputStream();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;I)Z",
      garbageValue = "-888882777"
   )
   static final boolean method3153(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1941[var7][var8] = 99;
      class109.field1938[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1935[var11] = var0;
      int var13 = var11 + 1;
      class109.field1942[var11] = var1;
      int[][] var14 = var4.flags;

      label204:
      while(var12 != var13) {
         var5 = class109.field1935[var12];
         var6 = class109.field1942[var12];
         var12 = var12 + 1 & 4095;
         int var19 = var5 - var9;
         int var20 = var6 - var10;
         int var15 = var5 - var4.x;
         int var16 = var6 - var4.y;
         if(var3.vmethod2486(var2, var5, var6, var4)) {
            class93.field1634 = var5;
            class109.field1937 = var6;
            return true;
         }

         int var17 = class109.field1938[var19][var20] + 1;
         int var18;
         if(var19 > 0 && class109.field1941[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var2 + var16 - 1] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class109.field1935[var13] = var5 - 1;
                  class109.field1942[var13] = var6;
                  var13 = 1 + var13 & 4095;
                  class109.field1941[var19 - 1][var20] = 2;
                  class109.field1938[var19 - 1][var20] = var17;
                  break;
               }

               if((var14[var15 - 1][var16 + var18] & 19136830) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && class109.field1941[var19 + 1][var20] == 0 && (var14[var2 + var15][var16] & 19136899) == 0 && (var14[var15 + var2][var2 + var16 - 1] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class109.field1935[var13] = var5 + 1;
                  class109.field1942[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class109.field1941[var19 + 1][var20] = 8;
                  class109.field1938[var19 + 1][var20] = var17;
                  break;
               }

               if((var14[var2 + var15][var18 + var16] & 19136995) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 > 0 && class109.field1941[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class109.field1935[var13] = var5;
                  class109.field1942[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class109.field1941[var19][var20 - 1] = 1;
                  class109.field1938[var19][var20 - 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 < 128 - var2 && class109.field1941[var19][1 + var20] == 0 && (var14[var15][var2 + var16] & 19136824) == 0 && (var14[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class109.field1935[var13] = var5;
                  class109.field1942[var13] = 1 + var6;
                  var13 = var13 + 1 & 4095;
                  class109.field1941[var19][var20 + 1] = 4;
                  class109.field1938[var19][var20 + 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var2 + var16] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 > 0 && class109.field1941[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class109.field1935[var13] = var5 - 1;
                  class109.field1942[var13] = var6 - 1;
                  var13 = 1 + var13 & 4095;
                  class109.field1941[var19 - 1][var20 - 1] = 3;
                  class109.field1938[var19 - 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var15 - 1 + var18][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 > 0 && class109.field1941[var19 + 1][var20 - 1] == 0 && (var14[var2 + var15][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class109.field1935[var13] = 1 + var5;
                  class109.field1942[var13] = var6 - 1;
                  var13 = 1 + var13 & 4095;
                  class109.field1941[var19 + 1][var20 - 1] = 9;
                  class109.field1938[var19 + 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var2 + var15][var18 + (var16 - 1)] & 19136995) != 0 || (var14[var15 + var18][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 < 128 - var2 && class109.field1941[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var2 + var16] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class109.field1935[var13] = var5 - 1;
                  class109.field1942[var13] = var6 + 1;
                  var13 = 1 + var13 & 4095;
                  class109.field1941[var19 - 1][var20 + 1] = 6;
                  class109.field1938[var19 - 1][var20 + 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + var16] & 19136830) != 0 || (var14[var15 - 1 + var18][var2 + var16] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 < 128 - var2 && class109.field1941[var19 + 1][1 + var20] == 0 && (var14[var15 + var2][var16 + var2] & 19136992) == 0) {
            for(var18 = 1; var18 < var2; ++var18) {
               if((var14[var15 + var18][var2 + var16] & 19137016) != 0 || (var14[var2 + var15][var16 + var18] & 19136995) != 0) {
                  continue label204;
               }
            }

            class109.field1935[var13] = 1 + var5;
            class109.field1942[var13] = 1 + var6;
            var13 = var13 + 1 & 4095;
            class109.field1941[1 + var19][1 + var20] = 12;
            class109.field1938[var19 + 1][var20 + 1] = var17;
         }
      }

      class93.field1634 = var5;
      class109.field1937 = var6;
      return false;
   }
}
