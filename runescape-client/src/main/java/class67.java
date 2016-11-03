import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class67 extends class69 {
   @ObfuscatedName("l")
   boolean field1306;
   @ObfuscatedName("j")
   int field1307;
   @ObfuscatedName("f")
   int field1308;
   @ObfuscatedName("b")
   int field1309;
   @ObfuscatedName("v")
   int field1310;
   @ObfuscatedName("g")
   int field1311;
   @ObfuscatedName("m")
   int field1312;
   @ObfuscatedName("c")
   int field1313;
   @ObfuscatedName("u")
   int field1314;
   @ObfuscatedName("h")
   int field1315;
   @ObfuscatedName("q")
   int field1316;
   @ObfuscatedName("y")
   int field1317;
   @ObfuscatedName("k")
   int field1318;
   @ObfuscatedName("e")
   int field1319;
   @ObfuscatedName("p")
   int field1320;

   @ObfuscatedName("q")
   static int method1341(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ac")
   static int method1342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1318 = var4;
      return var5;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1322 = var1;
      this.field1314 = var1.field1291;
      this.field1315 = var1.field1289;
      this.field1306 = var1.field1293;
      this.field1316 = var2;
      this.field1308 = var3;
      this.field1313 = 8192;
      this.field1318 = 0;
      this.method1364();
   }

   @ObfuscatedName("m")
   protected class69 vmethod3755() {
      return null;
   }

   @ObfuscatedName("s")
   public synchronized int method1346() {
      return this.field1313 < 0?-1:this.field1313;
   }

   @ObfuscatedName("h")
   public synchronized void method1347(int var1) {
      this.field1317 = var1;
   }

   @ObfuscatedName("b")
   public synchronized void method1348(int var1) {
      this.method1383(var1 << 6, this.method1346());
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1349(int var1) {
      this.method1383(var1, this.method1346());
   }

   @ObfuscatedName("bz")
   static int method1352(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1310 -= var13.field1311 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var16 << 8) + (var2[var1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1310 += var13.field1311 * var5;
      var13.field1307 = var6;
      var13.field1312 = var7;
      var13.field1318 = var4;
      return var5;
   }

   @ObfuscatedName("w")
   public synchronized void method1353(int var1) {
      int var2 = ((class65)super.field1322).field1292.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1318 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1354() {
      this.field1316 = (this.field1316 ^ this.field1316 >> 31) + (this.field1316 >>> 31);
      this.field1316 = -this.field1316;
   }

   @ObfuscatedName("r")
   void method1355() {
      if(this.field1309 != 0) {
         if(this.field1308 == Integer.MIN_VALUE) {
            this.field1308 = 0;
         }

         this.field1309 = 0;
         this.method1364();
      }

   }

   @ObfuscatedName("a")
   public synchronized void method1356(int var1, int var2) {
      this.method1357(var1, var2, this.method1346());
   }

   @ObfuscatedName("n")
   public synchronized void method1357(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1383(var2, var3);
      } else {
         int var4 = method1470(var2, var3);
         int var5 = method1341(var2, var3);
         if(this.field1307 == var4 && this.field1312 == var5) {
            this.field1309 = 0;
         } else {
            int var6 = var2 - this.field1310;
            if(this.field1310 - var2 > var6) {
               var6 = this.field1310 - var2;
            }

            if(var4 - this.field1307 > var6) {
               var6 = var4 - this.field1307;
            }

            if(this.field1307 - var4 > var6) {
               var6 = this.field1307 - var4;
            }

            if(var5 - this.field1312 > var6) {
               var6 = var5 - this.field1312;
            }

            if(this.field1312 - var5 > var6) {
               var6 = this.field1312 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1309 = var1;
            this.field1308 = var2;
            this.field1313 = var3;
            this.field1311 = (var2 - this.field1310) / var1;
            this.field1319 = (var4 - this.field1307) / var1;
            this.field1320 = (var5 - this.field1312) / var1;
         }
      }
   }

   @ObfuscatedName("z")
   public synchronized void method1358(int var1) {
      if(var1 == 0) {
         this.method1349(0);
         this.unlink();
      } else if(this.field1307 == 0 && this.field1312 == 0) {
         this.field1309 = 0;
         this.field1308 = 0;
         this.field1310 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1310;
         if(this.field1310 > var2) {
            var2 = this.field1310;
         }

         if(-this.field1307 > var2) {
            var2 = -this.field1307;
         }

         if(this.field1307 > var2) {
            var2 = this.field1307;
         }

         if(-this.field1312 > var2) {
            var2 = -this.field1312;
         }

         if(this.field1312 > var2) {
            var2 = this.field1312;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1309 = var1;
         this.field1308 = Integer.MIN_VALUE;
         this.field1311 = -this.field1310 / var1;
         this.field1319 = -this.field1307 / var1;
         this.field1320 = -this.field1312 / var1;
      }
   }

   @ObfuscatedName("x")
   public synchronized void method1359(int var1) {
      if(this.field1316 < 0) {
         this.field1316 = -var1;
      } else {
         this.field1316 = var1;
      }

   }

   @ObfuscatedName("d")
   public synchronized int method1360() {
      return this.field1316 < 0?-this.field1316:this.field1316;
   }

   @ObfuscatedName("t")
   public boolean method1361() {
      return this.field1318 < 0 || this.field1318 >= ((class65)super.field1322).field1292.length << 8;
   }

   @ObfuscatedName("j")
   protected class69 vmethod3751() {
      return null;
   }

   @ObfuscatedName("v")
   void method1364() {
      this.field1310 = this.field1308;
      this.field1307 = method1470(this.field1308, this.field1313);
      this.field1312 = method1341(this.field1308, this.field1313);
   }

   @ObfuscatedName("y")
   protected int vmethod3758() {
      return this.field1308 == 0 && this.field1309 == 0?0:1;
   }

   @ObfuscatedName("u")
   public synchronized void vmethod3766(int[] var1, int var2, int var3) {
      if(this.field1308 == 0 && this.field1309 == 0) {
         this.vmethod3754(var3);
      } else {
         class65 var4 = (class65)super.field1322;
         int var5 = this.field1314 << 8;
         int var6 = this.field1315 << 8;
         int var7 = var4.field1292.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1317 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1318 < 0) {
            if(this.field1316 <= 0) {
               this.method1355();
               this.unlink();
               return;
            }

            this.field1318 = 0;
         }

         if(this.field1318 >= var7) {
            if(this.field1316 >= 0) {
               this.method1355();
               this.unlink();
               return;
            }

            this.field1318 = var7 - 1;
         }

         if(this.field1317 < 0) {
            if(this.field1306) {
               if(this.field1316 < 0) {
                  var9 = this.method1452(var1, var2, var5, var3, var4.field1292[this.field1314]);
                  if(this.field1318 >= var5) {
                     return;
                  }

                  this.field1318 = var5 + var5 - 1 - this.field1318;
                  this.field1316 = -this.field1316;
               }

               while(true) {
                  var9 = this.method1420(var1, var9, var6, var3, var4.field1292[this.field1315 - 1]);
                  if(this.field1318 < var6) {
                     return;
                  }

                  this.field1318 = var6 + var6 - 1 - this.field1318;
                  this.field1316 = -this.field1316;
                  var9 = this.method1452(var1, var9, var5, var3, var4.field1292[this.field1314]);
                  if(this.field1318 >= var5) {
                     return;
                  }

                  this.field1318 = var5 + var5 - 1 - this.field1318;
                  this.field1316 = -this.field1316;
               }
            } else if(this.field1316 < 0) {
               while(true) {
                  var9 = this.method1452(var1, var9, var5, var3, var4.field1292[this.field1315 - 1]);
                  if(this.field1318 >= var5) {
                     return;
                  }

                  this.field1318 = var6 - 1 - (var6 - 1 - this.field1318) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1420(var1, var9, var6, var3, var4.field1292[this.field1314]);
                  if(this.field1318 < var6) {
                     return;
                  }

                  this.field1318 = var5 + (this.field1318 - var5) % var8;
               }
            }
         } else {
            if(this.field1317 > 0) {
               if(this.field1306) {
                  label173: {
                     if(this.field1316 < 0) {
                        var9 = this.method1452(var1, var2, var5, var3, var4.field1292[this.field1314]);
                        if(this.field1318 >= var5) {
                           return;
                        }

                        this.field1318 = var5 + var5 - 1 - this.field1318;
                        this.field1316 = -this.field1316;
                        if(--this.field1317 == 0) {
                           break label173;
                        }
                     }

                     do {
                        var9 = this.method1420(var1, var9, var6, var3, var4.field1292[this.field1315 - 1]);
                        if(this.field1318 < var6) {
                           return;
                        }

                        this.field1318 = var6 + var6 - 1 - this.field1318;
                        this.field1316 = -this.field1316;
                        if(--this.field1317 == 0) {
                           break;
                        }

                        var9 = this.method1452(var1, var9, var5, var3, var4.field1292[this.field1314]);
                        if(this.field1318 >= var5) {
                           return;
                        }

                        this.field1318 = var5 + var5 - 1 - this.field1318;
                        this.field1316 = -this.field1316;
                     } while(--this.field1317 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1316 < 0) {
                     while(true) {
                        var9 = this.method1452(var1, var9, var5, var3, var4.field1292[this.field1315 - 1]);
                        if(this.field1318 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1318) / var8;
                        if(var10 >= this.field1317) {
                           this.field1318 += var8 * this.field1317;
                           this.field1317 = 0;
                           break;
                        }

                        this.field1318 += var8 * var10;
                        this.field1317 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1420(var1, var9, var6, var3, var4.field1292[this.field1314]);
                        if(this.field1318 < var6) {
                           return;
                        }

                        var10 = (this.field1318 - var5) / var8;
                        if(var10 >= this.field1317) {
                           this.field1318 -= var8 * this.field1317;
                           this.field1317 = 0;
                           break;
                        }

                        this.field1318 -= var8 * var10;
                        this.field1317 -= var10;
                     }
                  }
               }
            }

            if(this.field1316 < 0) {
               this.method1452(var1, var9, 0, var3, 0);
               if(this.field1318 < 0) {
                  this.field1318 = -1;
                  this.method1355();
                  this.unlink();
               }
            } else {
               this.method1420(var1, var9, var7, var3, 0);
               if(this.field1318 >= var7) {
                  this.field1318 = var7;
                  this.method1355();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("bl")
   static int method1367(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1310 += var12.field1311 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1307 = var5 >> 2;
      var12.field1312 = var6 >> 2;
      var12.field1318 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("af")
   static int method1372(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1318 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("an")
   static int method1373(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field1318 = var2 << 8;
      return var3;
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1322 = var1;
      this.field1314 = var1.field1291;
      this.field1315 = var1.field1289;
      this.field1306 = var1.field1293;
      this.field1316 = var2;
      this.field1308 = var3;
      this.field1313 = var4;
      this.field1318 = 0;
      this.method1364();
   }

   @ObfuscatedName("ae")
   static int method1375(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1318 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ah")
   static int method1377(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var14 << 8) + (var2[var1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1318 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ab")
   static int method1379(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1310 += var12.field1311 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1307 = var5 >> 2;
      var12.field1312 = var6 >> 2;
      var12.field1318 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   static int method1380(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1307 += var9.field1319 * (var6 - var3);
      var9.field1312 += var9.field1320 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field1310 = var4 >> 2;
      var9.field1318 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("e")
   synchronized void method1383(int var1, int var2) {
      this.field1308 = var1;
      this.field1313 = var2;
      this.field1309 = 0;
      this.method1364();
   }

   @ObfuscatedName("bk")
   static int method1384(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1307 -= var11.field1319 * var5;
      var11.field1312 -= var11.field1320 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1307 += var11.field1319 * var5;
      var11.field1312 += var11.field1320 * var5;
      var11.field1310 = var6;
      var11.field1318 = var4;
      return var5;
   }

   @ObfuscatedName("ao")
   int vmethod1511() {
      int var1 = this.field1310 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1317 == 0) {
         var1 -= var1 * this.field1318 / (((class65)super.field1322).field1292.length << 8);
      } else if(this.field1317 >= 0) {
         var1 -= var1 * this.field1314 / ((class65)super.field1322).field1292.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("au")
   static int method1393(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1318 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aa")
   public boolean method1394() {
      return this.field1309 != 0;
   }

   @ObfuscatedName("aw")
   boolean method1395() {
      int var1 = this.field1308;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1470(var1, this.field1313);
         var3 = method1341(var1, this.field1313);
      }

      if(this.field1310 == var1 && this.field1307 == var2 && this.field1312 == var3) {
         if(this.field1308 == Integer.MIN_VALUE) {
            this.field1308 = 0;
            this.field1312 = 0;
            this.field1307 = 0;
            this.field1310 = 0;
            this.unlink();
            return true;
         } else {
            this.method1364();
            return false;
         }
      } else {
         if(this.field1310 < var1) {
            this.field1311 = 1;
            this.field1309 = var1 - this.field1310;
         } else if(this.field1310 > var1) {
            this.field1311 = -1;
            this.field1309 = this.field1310 - var1;
         } else {
            this.field1311 = 0;
         }

         if(this.field1307 < var2) {
            this.field1319 = 1;
            if(this.field1309 == 0 || this.field1309 > var2 - this.field1307) {
               this.field1309 = var2 - this.field1307;
            }
         } else if(this.field1307 > var2) {
            this.field1319 = -1;
            if(this.field1309 == 0 || this.field1309 > this.field1307 - var2) {
               this.field1309 = this.field1307 - var2;
            }
         } else {
            this.field1319 = 0;
         }

         if(this.field1312 < var3) {
            this.field1320 = 1;
            if(this.field1309 == 0 || this.field1309 > var3 - this.field1312) {
               this.field1309 = var3 - this.field1312;
            }
         } else if(this.field1312 > var3) {
            this.field1320 = -1;
            if(this.field1309 == 0 || this.field1309 > this.field1312 - var3) {
               this.field1309 = this.field1312 - var3;
            }
         } else {
            this.field1320 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("p")
   public synchronized int method1399() {
      return this.field1308 == Integer.MIN_VALUE?0:this.field1308;
   }

   @ObfuscatedName("bq")
   static int method1414(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1307 -= var11.field1319 * var5;
      var11.field1312 -= var11.field1320 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1307 += var11.field1319 * var5;
      var11.field1312 += var11.field1320 * var5;
      var11.field1310 = var6;
      var11.field1318 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   int method1420(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1309 > 0) {
            int var6 = var2 + this.field1309;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1309 += var2;
            if(this.field1316 == 256 && (this.field1318 & 255) == 0) {
               if(class59.field1238) {
                  var2 = method1379(0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, this.field1319, this.field1320, 0, var6, var3, this);
               } else {
                  var2 = method1471(((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, this.field1311, 0, var6, var3, this);
               }
            } else if(class59.field1238) {
               var2 = method1427(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, this.field1319, this.field1320, 0, var6, var3, this, this.field1316, var5);
            } else {
               var2 = method1414(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, this.field1311, 0, var6, var3, this, this.field1316, var5);
            }

            this.field1309 -= var2;
            if(this.field1309 != 0) {
               return var2;
            }

            if(!this.method1395()) {
               continue;
            }

            return var4;
         }

         if(this.field1316 == 256 && (this.field1318 & 255) == 0) {
            if(class59.field1238) {
               return method1372(0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, 0, var4, var3, this);
            }

            return method1437(((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, 0, var4, var3, this);
         }

         if(class59.field1238) {
            return method1375(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, 0, var4, var3, this, this.field1316, var5);
         }

         return method1342(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, 0, var4, var3, this, this.field1316, var5);
      }
   }

   @ObfuscatedName("f")
   public static class67 method1425(class65 var0, int var1, int var2) {
      return var0.field1292 != null && var0.field1292.length != 0?new class67(var0, (int)((long)var0.field1290 * 256L * (long)var1 / (long)(class59.field1249 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bg")
   static int method1427(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1310 -= var13.field1311 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1310 += var13.field1311 * var5;
      var13.field1307 = var6;
      var13.field1312 = var7;
      var13.field1318 = var4;
      return var5;
   }

   @ObfuscatedName("ai")
   static int method1437(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field1318 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   int method1452(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1309 > 0) {
            int var6 = var2 + this.field1309;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1309 += var2;
            if(this.field1316 == -256 && (this.field1318 & 255) == 0) {
               if(class59.field1238) {
                  var2 = method1367(0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, this.field1319, this.field1320, 0, var6, var3, this);
               } else {
                  var2 = method1380(((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, this.field1311, 0, var6, var3, this);
               }
            } else if(class59.field1238) {
               var2 = method1352(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, this.field1319, this.field1320, 0, var6, var3, this, this.field1316, var5);
            } else {
               var2 = method1384(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, this.field1311, 0, var6, var3, this, this.field1316, var5);
            }

            this.field1309 -= var2;
            if(this.field1309 != 0) {
               return var2;
            }

            if(!this.method1395()) {
               continue;
            }

            return var4;
         }

         if(this.field1316 == -256 && (this.field1318 & 255) == 0) {
            if(class59.field1238) {
               return method1393(0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, 0, var4, var3, this);
            }

            return method1373(((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, 0, var4, var3, this);
         }

         if(class59.field1238) {
            return method1377(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1307, this.field1312, 0, var4, var3, this, this.field1316, var5);
         }

         return method1465(0, 0, ((class65)super.field1322).field1292, var1, this.field1318, var2, this.field1310, 0, var4, var3, this, this.field1316, var5);
      }
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3754(int var1) {
      if(this.field1309 > 0) {
         if(var1 >= this.field1309) {
            if(this.field1308 == Integer.MIN_VALUE) {
               this.field1308 = 0;
               this.field1312 = 0;
               this.field1307 = 0;
               this.field1310 = 0;
               this.unlink();
               var1 = this.field1309;
            }

            this.field1309 = 0;
            this.method1364();
         } else {
            this.field1310 += this.field1311 * var1;
            this.field1307 += this.field1319 * var1;
            this.field1312 += this.field1320 * var1;
            this.field1309 -= var1;
         }
      }

      class65 var2 = (class65)super.field1322;
      int var3 = this.field1314 << 8;
      int var4 = this.field1315 << 8;
      int var5 = var2.field1292.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1317 = 0;
      }

      if(this.field1318 < 0) {
         if(this.field1316 <= 0) {
            this.method1355();
            this.unlink();
            return;
         }

         this.field1318 = 0;
      }

      if(this.field1318 >= var5) {
         if(this.field1316 >= 0) {
            this.method1355();
            this.unlink();
            return;
         }

         this.field1318 = var5 - 1;
      }

      this.field1318 += this.field1316 * var1;
      if(this.field1317 < 0) {
         if(!this.field1306) {
            if(this.field1316 < 0) {
               if(this.field1318 >= var3) {
                  return;
               }

               this.field1318 = var4 - 1 - (var4 - 1 - this.field1318) % var6;
            } else {
               if(this.field1318 < var4) {
                  return;
               }

               this.field1318 = var3 + (this.field1318 - var3) % var6;
            }

         } else {
            if(this.field1316 < 0) {
               if(this.field1318 >= var3) {
                  return;
               }

               this.field1318 = var3 + var3 - 1 - this.field1318;
               this.field1316 = -this.field1316;
            }

            while(this.field1318 >= var4) {
               this.field1318 = var4 + var4 - 1 - this.field1318;
               this.field1316 = -this.field1316;
               if(this.field1318 >= var3) {
                  return;
               }

               this.field1318 = var3 + var3 - 1 - this.field1318;
               this.field1316 = -this.field1316;
            }

         }
      } else {
         if(this.field1317 > 0) {
            if(this.field1306) {
               label168: {
                  if(this.field1316 < 0) {
                     if(this.field1318 >= var3) {
                        return;
                     }

                     this.field1318 = var3 + var3 - 1 - this.field1318;
                     this.field1316 = -this.field1316;
                     if(--this.field1317 == 0) {
                        break label168;
                     }
                  }

                  do {
                     if(this.field1318 < var4) {
                        return;
                     }

                     this.field1318 = var4 + var4 - 1 - this.field1318;
                     this.field1316 = -this.field1316;
                     if(--this.field1317 == 0) {
                        break;
                     }

                     if(this.field1318 >= var3) {
                        return;
                     }

                     this.field1318 = var3 + var3 - 1 - this.field1318;
                     this.field1316 = -this.field1316;
                  } while(--this.field1317 != 0);
               }
            } else {
               label200: {
                  int var7;
                  if(this.field1316 < 0) {
                     if(this.field1318 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1318) / var6;
                     if(var7 >= this.field1317) {
                        this.field1318 += var6 * this.field1317;
                        this.field1317 = 0;
                        break label200;
                     }

                     this.field1318 += var6 * var7;
                     this.field1317 -= var7;
                  } else {
                     if(this.field1318 < var4) {
                        return;
                     }

                     var7 = (this.field1318 - var3) / var6;
                     if(var7 >= this.field1317) {
                        this.field1318 -= var6 * this.field1317;
                        this.field1317 = 0;
                        break label200;
                     }

                     this.field1318 -= var6 * var7;
                     this.field1317 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1316 < 0) {
            if(this.field1318 < 0) {
               this.field1318 = -1;
               this.method1355();
               this.unlink();
            }
         } else if(this.field1318 >= var5) {
            this.field1318 = var5;
            this.method1355();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("c")
   public static class67 method1463(class65 var0, int var1, int var2, int var3) {
      return var0.field1292 != null && var0.field1292.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("az")
   static int method1465(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1318 = var4;
      return var5;
   }

   @ObfuscatedName("k")
   static int method1470(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("as")
   static int method1471(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1307 += var9.field1319 * (var6 - var3);
      var9.field1312 += var9.field1320 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field1310 = var4 >> 2;
      var9.field1318 = var2 << 8;
      return var3;
   }
}
