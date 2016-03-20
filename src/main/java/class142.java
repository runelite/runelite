import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class142 implements Runnable {
   @ObfuscatedName("s")
   boolean field2168 = false;
   @ObfuscatedName("f")
   Socket field2169;
   @ObfuscatedName("r")
   OutputStream field2170;
   @ObfuscatedName("y")
   class135 field2171;
   @ObfuscatedName("e")
   class145 field2172;
   @ObfuscatedName("a")
   InputStream field2173;
   @ObfuscatedName("g")
   byte[] field2174;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1257202073
   )
   int field2175 = 0;
   @ObfuscatedName("n")
   boolean field2176 = false;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -664298029
   )
   int field2177 = 0;

   public class142(Socket var1, class135 var2) throws IOException {
      this.field2171 = var2;
      this.field2169 = var1;
      this.field2169.setSoTimeout(30000);
      this.field2169.setTcpNoDelay(true);
      this.field2169.setReceiveBufferSize(16384);
      this.field2169.setSendBufferSize(16384);
      this.field2173 = this.field2169.getInputStream();
      this.field2170 = this.field2169.getOutputStream();
   }

   @ObfuscatedName("y")
   public int method3001() throws IOException {
      return this.field2168?0:this.field2173.available();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "127"
   )
   public void method3002(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2168) {
         while(var3 > 0) {
            int var4 = this.field2173.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1780779311"
   )
   public void method3003(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2168) {
         if(this.field2176) {
            this.field2176 = false;
            throw new IOException();
         } else {
            if(this.field2174 == null) {
               this.field2174 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2174[this.field2175] = var1[var2 + var5];
                  this.field2175 = (1 + this.field2175) % 5000;
                  if(this.field2175 == (this.field2177 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field2172 == null) {
                  this.field2172 = this.field2171.method2893(this, 3);
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
                  if(this.field2177 == this.field2175) {
                     if(this.field2168) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2177;
                  if(this.field2175 >= this.field2177) {
                     var1 = this.field2175 - this.field2177;
                  } else {
                     var1 = 5000 - this.field2177;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2170.write(this.field2174, var2, var1);
               } catch (IOException var8) {
                  this.field2176 = true;
               }

               this.field2177 = (var1 + this.field2177) % 5000;

               try {
                  if(this.field2175 == this.field2177) {
                     this.field2170.flush();
                  }
               } catch (IOException var7) {
                  this.field2176 = true;
               }
               continue;
            }

            try {
               if(this.field2173 != null) {
                  this.field2173.close();
               }

               if(null != this.field2170) {
                  this.field2170.close();
               }

               if(null != this.field2169) {
                  this.field2169.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2174 = null;
            break;
         }
      } catch (Exception var11) {
         class28.method651((String)null, var11);
      }

   }

   protected void finalize() {
      this.method3019();
   }

   @ObfuscatedName("s")
   public int method3005() throws IOException {
      return this.field2168?0:this.field2173.read();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass85;[Lclass107;I)V",
      garbageValue = "308089656"
   )
   static final void method3018(class85 var0, class107[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if(1 == (class5.field90[var2][var3][var4] & 1)) {
                  var5 = var2;
                  if(2 == (class5.field90[1][var3][var4] & 2)) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2399(var3, var4);
                  }
               }
            }
         }
      }

      class5.field87 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field87 < -8) {
         class5.field87 = -8;
      }

      if(class5.field87 > 8) {
         class5.field87 = 8;
      }

      class5.field88 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field88 < -16) {
         class5.field88 = -16;
      }

      if(class5.field88 > 16) {
         class5.field88 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class5.field78[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field86[var2][var12 + 1][var11] - class5.field86[var2][var12 - 1][var11];
               var14 = class5.field86[var2][var12][var11 + 1] - class5.field86[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var13 * var13));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + -10 * var17) / var10 + 96;
               var20 = (var42[var12][1 + var11] >> 3) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12][var11] >> 1);
               class5.field71[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class72.field1351[var11] = 0;
            class169.field2697[var11] = 0;
            class209.field3119[var11] = 0;
            class16.field240[var11] = 0;
            class219.field3166[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field74[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class41 var46 = (class41)class41.field981.method3792((long)var16);
                     class41 var43;
                     if(var46 != null) {
                        var43 = var46;
                     } else {
                        byte[] var47 = class41.field975.method3263(1, var16);
                        var46 = new class41();
                        if(null != var47) {
                           var46.method851(new class118(var47));
                        }

                        var46.method850();
                        class41.field981.method3794(var46, (long)var16);
                        var43 = var46;
                     }

                     class72.field1351[var12] += var43.field974;
                     class169.field2697[var12] += var43.field978;
                     class209.field3119[var12] += var43.field979;
                     class16.field240[var12] += var43.field977;
                     ++class219.field3166[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field74[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class41 var48 = (class41)class41.field981.method3792((long)var17);
                     class41 var44;
                     if(null != var48) {
                        var44 = var48;
                     } else {
                        byte[] var49 = class41.field975.method3263(1, var17);
                        var48 = new class41();
                        if(null != var49) {
                           var48.method851(new class118(var49));
                        }

                        var48.method850();
                        class41.field981.method3794(var48, (long)var17);
                        var44 = var48;
                     }

                     class72.field1351[var12] -= var44.field974;
                     class169.field2697[var12] -= var44.field978;
                     class209.field3119[var12] -= var44.field979;
                     class16.field240[var12] -= var44.field977;
                     --class219.field3166[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class72.field1351[var18];
                     var13 += class169.field2697[var18];
                     var14 += class209.field3119[var18];
                     var15 += class16.field240[var18];
                     var16 += class219.field3166[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class72.field1351[var19];
                     var13 -= class169.field2697[var19];
                     var14 -= class209.field3119[var19];
                     var15 -= class16.field240[var19];
                     var16 -= class219.field3166[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field297 || (class5.field90[0][var11][var17] & 2) != 0 || (class5.field90[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field72) {
                        class5.field72 = var2;
                     }

                     var20 = class5.field74[var2][var11][var17] & 255;
                     int var21 = class5.field75[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field86[var2][var11][var17];
                        int var23 = class5.field86[var2][var11 + 1][var17];
                        int var24 = class5.field86[var2][1 + var11][var17 + 1];
                        int var25 = class5.field86[var2][var11][var17 + 1];
                        int var26 = class5.field71[var11][var17];
                        int var27 = class5.field71[1 + var11][var17];
                        int var28 = class5.field71[1 + var11][1 + var17];
                        int var29 = class5.field71[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class42.method904(var32, var33, var34);
                           var32 = var32 + class5.field87 & 255;
                           var34 += class5.field88;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class42.method904(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var50 = true;
                           if(var20 == 0 && class5.field76[var2][var11][var17] != 0) {
                              var50 = false;
                           }

                           if(var21 > 0 && !class47.method1007(var21 - 1).field1056) {
                              var50 = false;
                           }

                           if(var50 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class5.field80[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class90.field1573[class126.method2826(var31, 96)];
                        }

                        if(0 == var21) {
                           var0.method1927(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class126.method2826(var30, var26), class126.method2826(var30, var27), class126.method2826(var30, var28), class126.method2826(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class5.field76[var2][var11][var17] + 1;
                           byte var51 = class5.field73[var2][var11][var17];
                           class46 var35 = class47.method1007(var21 - 1);
                           int var36 = var35.field1047;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class90.field1574.vmethod2187(var36);
                              var37 = -1;
                           } else if(16711935 == var35.field1049) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class42.method904(var35.field1053, var35.field1054, var35.field1055);
                              var39 = class5.field87 + var35.field1053 & 255;
                              var40 = var35.field1055 + class5.field88;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class42.method904(var39, var35.field1054, var40);
                           }

                           var39 = 0;
                           if(-2 != var38) {
                              var39 = class90.field1573[class92.method2177(var38, 96)];
                           }

                           if(-1 != var35.field1052) {
                              var40 = class5.field87 + var35.field1050 & 255;
                              int var41 = class5.field88 + var35.field1051;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class42.method904(var40, var35.field1048, var41);
                              var39 = class90.field1573[class92.method2177(var38, 96)];
                           }

                           var0.method1927(var2, var11, var17, var33, var51, var36, var22, var23, var24, var25, class126.method2826(var30, var26), class126.method2826(var30, var27), class126.method2826(var30, var28), class126.method2826(var30, var29), class92.method2177(var37, var26), class92.method2177(var37, var27), class92.method2177(var37, var28), class92.method2177(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2000(var2, var12, var11, class15.method192(var2, var12, var11));
            }
         }

         class5.field74[var2] = (byte[][])null;
         class5.field75[var2] = (byte[][])null;
         class5.field76[var2] = (byte[][])null;
         class5.field73[var2] = (byte[][])null;
         class5.field78[var2] = (byte[][])null;
      }

      var0.method1953(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field90[1][var2][var3] & 2) == 2) {
               var0.method1923(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class5.field80[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field80[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class5.field80[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label530:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class5.field80[var11 - 1][var8][var13] & var2)) {
                              break label530;
                           }
                        }

                        --var11;
                     }

                     label519:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field80[1 + var12][var8][var13] & var2) == 0) {
                              break label519;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field86[var12][var8][var9] - var45;
                        var16 = class5.field86[var11][var8][var9];
                        class85.method1925(var5, 1, var8 * 128, var8 * 128, 128 * var9, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class5.field80[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class5.field80[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field80[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class5.field80[var6][var10 + 1][var7] & var3)) {
                        ++var10;
                     }

                     label583:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class5.field80[var11 - 1][var13][var7] & var3)) {
                              break label583;
                           }
                        }

                        --var11;
                     }

                     label572:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field80[var12 + 1][var13][var7] & var3) == 0) {
                              break label572;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field86[var12][var9][var7] - var45;
                        var16 = class5.field86[var11][var9][var7];
                        class85.method1925(var5, 2, 128 * var9, 128 + var10 * 128, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class5.field80[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class5.field80[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class5.field80[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class5.field80[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label636:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class5.field80[var6][var9 - 1][var13] & var4) == 0) {
                              break label636;
                           }
                        }

                        --var9;
                     }

                     label625:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class5.field80[var6][var10 + 1][var13] & var4)) {
                              break label625;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var10 - var9)) * (var12 - var11 + 1) >= 4) {
                        var13 = class5.field86[var6][var9][var11];
                        class85.method1925(var5, 4, 128 * var9, 128 + var10 * 128, 128 * var11, 128 * var12 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class5.field80[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1679327693"
   )
   public void method3019() {
      if(!this.field2168) {
         synchronized(this) {
            this.field2168 = true;
            this.notifyAll();
         }

         if(this.field2172 != null) {
            while(this.field2172.field2202 == 0) {
               class103.method2301(1L);
            }

            if(1 == this.field2172.field2202) {
               try {
                  ((Thread)this.field2172.field2206).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2172 = null;
      }
   }
}
