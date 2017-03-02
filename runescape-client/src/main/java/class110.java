import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class110 implements Runnable {
   @ObfuscatedName("n")
   byte[] field1735;
   @ObfuscatedName("l")
   OutputStream field1736;
   @ObfuscatedName("i")
   Socket field1737;
   @ObfuscatedName("k")
   class103 field1739;
   @ObfuscatedName("h")
   class102 field1740;
   @ObfuscatedName("t")
   boolean field1741 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -529474391
   )
   int field1742 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2121527071
   )
   int field1743 = 0;
   @ObfuscatedName("r")
   boolean field1744 = false;
   @ObfuscatedName("b")
   InputStream field1745;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-245532468"
   )
   public void method2109() {
      if(!this.field1741) {
         synchronized(this) {
            this.field1741 = true;
            this.notifyAll();
         }

         if(this.field1740 != null) {
            while(this.field1740.field1655 == 0) {
               class115.method2301(1L);
            }

            if(this.field1740.field1655 == 1) {
               try {
                  ((Thread)this.field1740.field1659).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1740 = null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "53"
   )
   public void method2113(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1741) {
         while(var3 > 0) {
            int var4 = this.field1745.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1749168833"
   )
   public void method2114(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1741) {
         if(this.field1744) {
            this.field1744 = false;
            throw new IOException();
         } else {
            if(null == this.field1735) {
               this.field1735 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1735[this.field1743] = var1[var2 + var5];
                  this.field1743 = (this.field1743 + 1) % 5000;
                  if(this.field1743 == (this.field1742 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field1740) {
                  this.field1740 = this.field1739.method2031(this, 3);
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
                  if(this.field1742 == this.field1743) {
                     if(this.field1741) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1742;
                  if(this.field1743 >= this.field1742) {
                     var1 = this.field1743 - this.field1742;
                  } else {
                     var1 = 5000 - this.field1742;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1736.write(this.field1735, var2, var1);
               } catch (IOException var9) {
                  this.field1744 = true;
               }

               this.field1742 = (var1 + this.field1742) % 5000;

               try {
                  if(this.field1742 == this.field1743) {
                     this.field1736.flush();
                  }
               } catch (IOException var8) {
                  this.field1744 = true;
               }
               continue;
            }

            try {
               if(this.field1745 != null) {
                  this.field1745.close();
               }

               if(null != this.field1736) {
                  this.field1736.close();
               }

               if(null != this.field1737) {
                  this.field1737.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1735 = null;
            break;
         }
      } catch (Exception var12) {
         FaceNormal.method1950((String)null, var12);
      }

   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1739 = var2;
      this.field1737 = var1;
      this.field1737.setSoTimeout(30000);
      this.field1737.setTcpNoDelay(true);
      this.field1737.setReceiveBufferSize(16384);
      this.field1737.setSendBufferSize(16384);
      this.field1745 = this.field1737.getInputStream();
      this.field1736 = this.field1737.getOutputStream();
   }

   protected void finalize() {
      this.method2109();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "43229362"
   )
   public int method2131() throws IOException {
      return this.field1741?0:this.field1745.available();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "789841888"
   )
   public int method2133() throws IOException {
      return this.field1741?0:this.field1745.read();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-936784415"
   )
   public static int method2135() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[IB)I",
      garbageValue = "-120"
   )
   public static int method2136(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1839[var8][var9] = 0;
            class118.field1837[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var28 = class39.method811(var0, var1, var3, var4);
      } else {
         byte var12;
         byte var16;
         int[][] var18;
         boolean var29;
         if(var2 == 2) {
            var10 = var0;
            var11 = var1;
            var12 = 64;
            var13 = 64;
            var14 = var0 - var12;
            var15 = var1 - var13;
            class118.field1839[var12][var13] = 99;
            class118.field1837[var12][var13] = 0;
            var16 = 0;
            var17 = 0;
            class118.field1843[var16] = var0;
            var33 = var16 + 1;
            class118.field1844[var16] = var1;
            var18 = var4.flags;

            while(true) {
               if(var17 == var33) {
                  class118.field1841 = var10;
                  class118.field1840 = var11;
                  var29 = false;
                  break;
               }

               var10 = class118.field1843[var17];
               var11 = class118.field1844[var17];
               var17 = 1 + var17 & 4095;
               var30 = var10 - var14;
               var31 = var11 - var15;
               var19 = var10 - var4.x;
               var20 = var11 - var4.y;
               if(var3.vmethod2360(2, var10, var11, var4)) {
                  class118.field1841 = var10;
                  class118.field1840 = var11;
                  var29 = true;
                  break;
               }

               var21 = 1 + class118.field1837[var30][var31];
               if(var30 > 0 && class118.field1839[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
                  class118.field1843[var33] = var10 - 1;
                  class118.field1844[var33] = var11;
                  var33 = var33 + 1 & 4095;
                  class118.field1839[var30 - 1][var31] = 2;
                  class118.field1837[var30 - 1][var31] = var21;
               }

               if(var30 < 126 && class118.field1839[var30 + 1][var31] == 0 && (var18[2 + var19][var20] & 19136899) == 0 && (var18[2 + var19][var20 + 1] & 19136992) == 0) {
                  class118.field1843[var33] = var10 + 1;
                  class118.field1844[var33] = var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[var30 + 1][var31] = 8;
                  class118.field1837[var30 + 1][var31] = var21;
               }

               if(var31 > 0 && class118.field1839[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0) {
                  class118.field1843[var33] = var10;
                  class118.field1844[var33] = var11 - 1;
                  var33 = var33 + 1 & 4095;
                  class118.field1839[var30][var31 - 1] = 1;
                  class118.field1837[var30][var31 - 1] = var21;
               }

               if(var31 < 126 && class118.field1839[var30][var31 + 1] == 0 && (var18[var19][2 + var20] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
                  class118.field1843[var33] = var10;
                  class118.field1844[var33] = 1 + var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[var30][1 + var31] = 4;
                  class118.field1837[var30][1 + var31] = var21;
               }

               if(var30 > 0 && var31 > 0 && class118.field1839[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
                  class118.field1843[var33] = var10 - 1;
                  class118.field1844[var33] = var11 - 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[var30 - 1][var31 - 1] = 3;
                  class118.field1837[var30 - 1][var31 - 1] = var21;
               }

               if(var30 < 126 && var31 > 0 && class118.field1839[1 + var30][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
                  class118.field1843[var33] = var10 + 1;
                  class118.field1844[var33] = var11 - 1;
                  var33 = var33 + 1 & 4095;
                  class118.field1839[var30 + 1][var31 - 1] = 9;
                  class118.field1837[var30 + 1][var31 - 1] = var21;
               }

               if(var30 > 0 && var31 < 126 && class118.field1839[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][2 + var20] & 19137016) == 0) {
                  class118.field1843[var33] = var10 - 1;
                  class118.field1844[var33] = var11 + 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[var30 - 1][var31 + 1] = 6;
                  class118.field1837[var30 - 1][1 + var31] = var21;
               }

               if(var30 < 126 && var31 < 126 && class118.field1839[var30 + 1][1 + var31] == 0 && (var18[1 + var19][var20 + 2] & 19137016) == 0 && (var18[2 + var19][2 + var20] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
                  class118.field1843[var33] = 1 + var10;
                  class118.field1844[var33] = var11 + 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[var30 + 1][var31 + 1] = 12;
                  class118.field1837[var30 + 1][var31 + 1] = var21;
               }
            }

            var28 = var29;
         } else {
            var10 = var0;
            var11 = var1;
            var12 = 64;
            var13 = 64;
            var14 = var0 - var12;
            var15 = var1 - var13;
            class118.field1839[var12][var13] = 99;
            class118.field1837[var12][var13] = 0;
            var16 = 0;
            var17 = 0;
            class118.field1843[var16] = var0;
            var33 = var16 + 1;
            class118.field1844[var16] = var1;
            var18 = var4.flags;

            label722:
            while(true) {
               label720:
               while(true) {
                  do {
                     do {
                        do {
                           label697:
                           do {
                              if(var17 == var33) {
                                 class118.field1841 = var10;
                                 class118.field1840 = var11;
                                 var29 = false;
                                 break label722;
                              }

                              var10 = class118.field1843[var17];
                              var11 = class118.field1844[var17];
                              var17 = var17 + 1 & 4095;
                              var30 = var10 - var14;
                              var31 = var11 - var15;
                              var19 = var10 - var4.x;
                              var20 = var11 - var4.y;
                              if(var3.vmethod2360(var2, var10, var11, var4)) {
                                 class118.field1841 = var10;
                                 class118.field1840 = var11;
                                 var29 = true;
                                 break label722;
                              }

                              var21 = 1 + class118.field1837[var30][var31];
                              if(var30 > 0 && class118.field1839[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1843[var33] = var10 - 1;
                                       class118.field1844[var33] = var11;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1839[var30 - 1][var31] = 2;
                                       class118.field1837[var30 - 1][var31] = var21;
                                       break;
                                    }

                                    if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 < 128 - var2 && class118.field1839[1 + var30][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1843[var33] = var10 + 1;
                                       class118.field1844[var33] = var11;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1839[var30 + 1][var31] = 8;
                                       class118.field1837[var30 + 1][var31] = var21;
                                       break;
                                    }

                                    if((var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var31 > 0 && class118.field1839[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var2 + var19 - 1][var20 - 1] & 19136899) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1843[var33] = var10;
                                       class118.field1844[var33] = var11 - 1;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1839[var30][var31 - 1] = 1;
                                       class118.field1837[var30][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var31 < 128 - var2 && class118.field1839[var30][1 + var31] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var2 + var19 - 1][var20 + var2] & 19136992) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1843[var33] = var10;
                                       class118.field1844[var33] = var11 + 1;
                                       var33 = var33 + 1 & 4095;
                                       class118.field1839[var30][1 + var31] = 4;
                                       class118.field1837[var30][1 + var31] = var21;
                                       break;
                                    }

                                    if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 > 0 && var31 > 0 && class118.field1839[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2) {
                                       class118.field1843[var33] = var10 - 1;
                                       class118.field1844[var33] = var11 - 1;
                                       var33 = var33 + 1 & 4095;
                                       class118.field1839[var30 - 1][var31 - 1] = 3;
                                       class118.field1837[var30 - 1][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var19 - 1][var20 - 1 + var22] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 < 128 - var2 && var31 > 0 && class118.field1839[1 + var30][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2) {
                                       class118.field1843[var33] = var10 + 1;
                                       class118.field1844[var33] = var11 - 1;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1839[1 + var30][var31 - 1] = 9;
                                       class118.field1837[var30 + 1][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var2 + var19][var20 - 1 + var22] & 19136995) != 0 || (var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 > 0 && var31 < 128 - var2 && class118.field1839[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                                 for(var22 = 1; var22 < var2; ++var22) {
                                    if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 + var2] & 19137016) != 0) {
                                       continue label697;
                                    }
                                 }

                                 class118.field1843[var33] = var10 - 1;
                                 class118.field1844[var33] = 1 + var11;
                                 var33 = var33 + 1 & 4095;
                                 class118.field1839[var30 - 1][1 + var31] = 6;
                                 class118.field1837[var30 - 1][1 + var31] = var21;
                              }
                           } while(var30 >= 128 - var2);
                        } while(var31 >= 128 - var2);
                     } while(class118.field1839[var30 + 1][var31 + 1] != 0);
                  } while((var18[var19 + var2][var2 + var20] & 19136992) != 0);

                  for(var22 = 1; var22 < var2; ++var22) {
                     if((var18[var22 + var19][var20 + var2] & 19137016) != 0 || (var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                        continue label720;
                     }
                  }

                  class118.field1843[var33] = var10 + 1;
                  class118.field1844[var33] = 1 + var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1839[1 + var30][var31 + 1] = 12;
                  class118.field1837[var30 + 1][1 + var31] = var21;
               }
            }

            var28 = var29;
         }
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1841;
      var30 = class118.field1840;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1854;
         var17 = var3.field1849;
         int var27 = var3.field1850;
         var19 = var3.field1851;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1837[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class118.field1837[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1837[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class118.field1843[var13] = var11;
         var31 = var13 + 1;
         class118.field1844[var13] = var30;

         for(var14 = var15 = class118.field1839[var11 - var9][var30 - var10]; var0 != var11 || var1 != var30; var14 = class118.field1839[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class118.field1843[var31] = var11;
               class118.field1844[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1843[var31];
            var7[var33++] = class118.field1844[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "-506967852"
   )
   public static class187 method2137(int var0) {
      class187 var1 = (class187)class187.field2769.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2770.getConfigData(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3510(new Buffer(var2));
         }

         class187.field2769.put(var1, (long)var0);
         return var1;
      }
   }
}
