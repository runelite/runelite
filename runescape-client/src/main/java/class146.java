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
                     } catch (InterruptedException var10) {
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
               } catch (IOException var9) {
                  this.field2247 = true;
               }

               this.field2245 = (this.field2245 + var1) % 5000;

               try {
                  if(this.field2245 == this.field2238) {
                     this.field2248.flush();
                  }
               } catch (IOException var8) {
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
            } catch (IOException var7) {
               ;
            }

            this.field2244 = null;
            break;
         }
      } catch (Exception var12) {
         class13.method176((String)null, var12);
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
         } else {
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
      signature = "(IIILclass110;Lclass111;I)Z",
      garbageValue = "-888882777"
   )
   static final boolean method3153(int var0, int var1, int var2, class110 var3, class111 var4) {
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
      int var20 = var11 + 1;
      class109.field1942[var11] = var1;
      int[][] var13 = var4.field1969;

      while(true) {
         label358:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label335:
                     do {
                        if(var12 == var20) {
                           class93.field1634 = var5;
                           class109.field1937 = var6;
                           return false;
                        }

                        var5 = class109.field1935[var12];
                        var6 = class109.field1942[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1965;
                        var15 = var6 - var4.field1966;
                        if(var3.vmethod2486(var2, var5, var6, var4)) {
                           class93.field1634 = var5;
                           class109.field1937 = var6;
                           return true;
                        }

                        var16 = class109.field1938[var18][var19] + 1;
                        if(var18 > 0 && class109.field1941[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1935[var20] = var5 - 1;
                                 class109.field1942[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1941[var18 - 1][var19] = 2;
                                 class109.field1938[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1941[var18 + 1][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1935[var20] = var5 + 1;
                                 class109.field1942[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1941[var18 + 1][var19] = 8;
                                 class109.field1938[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1941[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1935[var20] = var5;
                                 class109.field1942[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1941[var18][var19 - 1] = 1;
                                 class109.field1938[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1941[var18][1 + var19] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1935[var20] = var5;
                                 class109.field1942[var20] = 1 + var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1941[var18][var19 + 1] = 4;
                                 class109.field1938[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1941[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1935[var20] = var5 - 1;
                                 class109.field1942[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1941[var18 - 1][var19 - 1] = 3;
                                 class109.field1938[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1941[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1935[var20] = 1 + var5;
                                 class109.field1942[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1941[var18 + 1][var19 - 1] = 9;
                                 class109.field1938[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1941[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var2 + var15] & 19137016) != 0) {
                                 continue label335;
                              }
                           }

                           class109.field1935[var20] = var5 - 1;
                           class109.field1942[var20] = var6 + 1;
                           var20 = 1 + var20 & 4095;
                           class109.field1941[var18 - 1][var19 + 1] = 6;
                           class109.field1938[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1941[var18 + 1][1 + var19] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                  continue label358;
               }
            }

            class109.field1935[var20] = 1 + var5;
            class109.field1942[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class109.field1941[1 + var18][1 + var19] = 12;
            class109.field1938[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
