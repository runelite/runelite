import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class67 extends class69 {
   @ObfuscatedName("q")
   int field1317;
   @ObfuscatedName("l")
   int field1318;
   @ObfuscatedName("c")
   int field1319;
   @ObfuscatedName("e")
   int field1320;
   @ObfuscatedName("r")
   int field1321;
   @ObfuscatedName("a")
   int field1322;
   @ObfuscatedName("x")
   int field1323;
   @ObfuscatedName("o")
   int field1324;
   @ObfuscatedName("h")
   int field1325;
   @ObfuscatedName("u")
   int field1326;
   @ObfuscatedName("i")
   boolean field1327;
   @ObfuscatedName("b")
   int field1328;
   @ObfuscatedName("g")
   int field1329;
   @ObfuscatedName("p")
   int field1330;
   @ObfuscatedName("j")
   int field1331;

   @ObfuscatedName("l")
   static int method1405(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   class67(class65 var1, int var2, int var3) {
      super.field1333 = var1;
      this.field1324 = var1.field1302;
      this.field1330 = var1.field1303;
      this.field1327 = var1.field1300;
      this.field1318 = var2;
      this.field1319 = var3;
      this.field1325 = 8192;
      this.field1320 = 0;
      this.method1499();
   }

   @ObfuscatedName("i")
   public synchronized void vmethod3807(int var1) {
      if(this.field1317 > 0) {
         if(var1 >= this.field1317) {
            if(this.field1319 == Integer.MIN_VALUE) {
               this.field1319 = 0;
               this.field1328 = 0;
               this.field1322 = 0;
               this.field1321 = 0;
               this.method4000();
               var1 = this.field1317;
            }

            this.field1317 = 0;
            this.method1499();
         } else {
            this.field1321 += this.field1329 * var1;
            this.field1322 += this.field1331 * var1;
            this.field1328 += this.field1323 * var1;
            this.field1317 -= var1;
         }
      }

      class65 var2 = (class65)super.field1333;
      int var3 = this.field1324 << 8;
      int var4 = this.field1330 << 8;
      int var5 = var2.field1304.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1326 = 0;
      }

      if(this.field1320 < 0) {
         if(this.field1318 <= 0) {
            this.method1419();
            this.method4000();
            return;
         }

         this.field1320 = 0;
      }

      if(this.field1320 >= var5) {
         if(this.field1318 >= 0) {
            this.method1419();
            this.method4000();
            return;
         }

         this.field1320 = var5 - 1;
      }

      this.field1320 += this.field1318 * var1;
      if(this.field1326 < 0) {
         if(!this.field1327) {
            if(this.field1318 < 0) {
               if(this.field1320 >= var3) {
                  return;
               }

               this.field1320 = var4 - 1 - (var4 - 1 - this.field1320) % var6;
            } else {
               if(this.field1320 < var4) {
                  return;
               }

               this.field1320 = var3 + (this.field1320 - var3) % var6;
            }

         } else {
            if(this.field1318 < 0) {
               if(this.field1320 >= var3) {
                  return;
               }

               this.field1320 = var3 + var3 - 1 - this.field1320;
               this.field1318 = -this.field1318;
            }

            while(this.field1320 >= var4) {
               this.field1320 = var4 + var4 - 1 - this.field1320;
               this.field1318 = -this.field1318;
               if(this.field1320 >= var3) {
                  return;
               }

               this.field1320 = var3 + var3 - 1 - this.field1320;
               this.field1318 = -this.field1318;
            }

         }
      } else {
         if(this.field1326 > 0) {
            if(this.field1327) {
               label163: {
                  if(this.field1318 < 0) {
                     if(this.field1320 >= var3) {
                        return;
                     }

                     this.field1320 = var3 + var3 - 1 - this.field1320;
                     this.field1318 = -this.field1318;
                     if(--this.field1326 == 0) {
                        break label163;
                     }
                  }

                  do {
                     if(this.field1320 < var4) {
                        return;
                     }

                     this.field1320 = var4 + var4 - 1 - this.field1320;
                     this.field1318 = -this.field1318;
                     if(--this.field1326 == 0) {
                        break;
                     }

                     if(this.field1320 >= var3) {
                        return;
                     }

                     this.field1320 = var3 + var3 - 1 - this.field1320;
                     this.field1318 = -this.field1318;
                  } while(--this.field1326 != 0);
               }
            } else {
               label195: {
                  int var7;
                  if(this.field1318 < 0) {
                     if(this.field1320 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1320) / var6;
                     if(var7 >= this.field1326) {
                        this.field1320 += var6 * this.field1326;
                        this.field1326 = 0;
                        break label195;
                     }

                     this.field1320 += var6 * var7;
                     this.field1326 -= var7;
                  } else {
                     if(this.field1320 < var4) {
                        return;
                     }

                     var7 = (this.field1320 - var3) / var6;
                     if(var7 >= this.field1326) {
                        this.field1320 -= var6 * this.field1326;
                        this.field1326 = 0;
                        break label195;
                     }

                     this.field1320 -= var6 * var7;
                     this.field1326 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1318 < 0) {
            if(this.field1320 < 0) {
               this.field1320 = -1;
               this.method1419();
               this.method4000();
            }
         } else if(this.field1320 >= var5) {
            this.field1320 = var5;
            this.method1419();
            this.method4000();
         }

      }
   }

   @ObfuscatedName("h")
   public static class67 method1409(class65 var0, int var1, int var2, int var3) {
      return var0.field1304 != null && var0.field1304.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("p")
   public synchronized void method1411(int var1) {
      this.field1326 = var1;
   }

   @ObfuscatedName("j")
   synchronized void method1414(int var1, int var2) {
      this.field1319 = var1;
      this.field1325 = var2;
      this.field1317 = 0;
      this.method1499();
   }

   @ObfuscatedName("at")
   int vmethod1568() {
      int var1 = this.field1321 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1326 == 0) {
         var1 -= var1 * this.field1320 / (((class65)super.field1333).field1304.length << 8);
      } else if(this.field1326 >= 0) {
         var1 -= var1 * this.field1324 / ((class65)super.field1333).field1304.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("f")
   public synchronized void method1417(int var1) {
      int var2 = ((class65)super.field1333).field1304.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1320 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1418() {
      this.field1318 = (this.field1318 ^ this.field1318 >> 31) + (this.field1318 >>> 31);
      this.field1318 = -this.field1318;
   }

   @ObfuscatedName("z")
   void method1419() {
      if(this.field1317 != 0) {
         if(this.field1319 == Integer.MIN_VALUE) {
            this.field1319 = 0;
         }

         this.field1317 = 0;
         this.method1499();
      }

   }

   @ObfuscatedName("y")
   public synchronized void method1420(int var1, int var2) {
      this.method1489(var1, var2, this.method1453());
   }

   @ObfuscatedName("k")
   public synchronized void method1423(int var1) {
      if(this.field1318 < 0) {
         this.field1318 = -var1;
      } else {
         this.field1318 = var1;
      }

   }

   @ObfuscatedName("n")
   public synchronized int method1424() {
      return this.field1318 < 0?-this.field1318:this.field1318;
   }

   @ObfuscatedName("ar")
   static int method1425(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1320 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("s")
   public boolean method1426() {
      return this.field1317 != 0;
   }

   @ObfuscatedName("v")
   public synchronized void method1428(int var1) {
      if(var1 == 0) {
         this.method1473(0);
         this.method4000();
      } else if(this.field1322 == 0 && this.field1328 == 0) {
         this.field1317 = 0;
         this.field1319 = 0;
         this.field1321 = 0;
         this.method4000();
      } else {
         int var2 = -this.field1321;
         if(this.field1321 > var2) {
            var2 = this.field1321;
         }

         if(-this.field1322 > var2) {
            var2 = -this.field1322;
         }

         if(this.field1322 > var2) {
            var2 = this.field1322;
         }

         if(-this.field1328 > var2) {
            var2 = -this.field1328;
         }

         if(this.field1328 > var2) {
            var2 = this.field1328;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1317 = var1;
         this.field1319 = Integer.MIN_VALUE;
         this.field1329 = -this.field1321 / var1;
         this.field1331 = -this.field1322 / var1;
         this.field1323 = -this.field1328 / var1;
      }
   }

   @ObfuscatedName("u")
   protected int vmethod3805() {
      return this.field1319 == 0 && this.field1317 == 0?0:1;
   }

   @ObfuscatedName("o")
   public synchronized void vmethod3806(int[] var1, int var2, int var3) {
      if(this.field1319 == 0 && this.field1317 == 0) {
         this.vmethod3807(var3);
      } else {
         class65 var4 = (class65)super.field1333;
         int var5 = this.field1324 << 8;
         int var6 = this.field1330 << 8;
         int var7 = var4.field1304.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1326 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1320 < 0) {
            if(this.field1318 <= 0) {
               this.method1419();
               this.method4000();
               return;
            }

            this.field1320 = 0;
         }

         if(this.field1320 >= var7) {
            if(this.field1318 >= 0) {
               this.method1419();
               this.method4000();
               return;
            }

            this.field1320 = var7 - 1;
         }

         if(this.field1326 < 0) {
            if(this.field1327) {
               if(this.field1318 < 0) {
                  var9 = this.method1433(var1, var2, var5, var3, var4.field1304[this.field1324]);
                  if(this.field1320 >= var5) {
                     return;
                  }

                  this.field1320 = var5 + var5 - 1 - this.field1320;
                  this.field1318 = -this.field1318;
               }

               while(true) {
                  var9 = this.method1432(var1, var9, var6, var3, var4.field1304[this.field1330 - 1]);
                  if(this.field1320 < var6) {
                     return;
                  }

                  this.field1320 = var6 + var6 - 1 - this.field1320;
                  this.field1318 = -this.field1318;
                  var9 = this.method1433(var1, var9, var5, var3, var4.field1304[this.field1324]);
                  if(this.field1320 >= var5) {
                     return;
                  }

                  this.field1320 = var5 + var5 - 1 - this.field1320;
                  this.field1318 = -this.field1318;
               }
            } else if(this.field1318 < 0) {
               while(true) {
                  var9 = this.method1433(var1, var9, var5, var3, var4.field1304[this.field1330 - 1]);
                  if(this.field1320 >= var5) {
                     return;
                  }

                  this.field1320 = var6 - 1 - (var6 - 1 - this.field1320) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1432(var1, var9, var6, var3, var4.field1304[this.field1324]);
                  if(this.field1320 < var6) {
                     return;
                  }

                  this.field1320 = var5 + (this.field1320 - var5) % var8;
               }
            }
         } else {
            if(this.field1326 > 0) {
               if(this.field1327) {
                  label181: {
                     if(this.field1318 < 0) {
                        var9 = this.method1433(var1, var2, var5, var3, var4.field1304[this.field1324]);
                        if(this.field1320 >= var5) {
                           return;
                        }

                        this.field1320 = var5 + var5 - 1 - this.field1320;
                        this.field1318 = -this.field1318;
                        if(--this.field1326 == 0) {
                           break label181;
                        }
                     }

                     do {
                        var9 = this.method1432(var1, var9, var6, var3, var4.field1304[this.field1330 - 1]);
                        if(this.field1320 < var6) {
                           return;
                        }

                        this.field1320 = var6 + var6 - 1 - this.field1320;
                        this.field1318 = -this.field1318;
                        if(--this.field1326 == 0) {
                           break;
                        }

                        var9 = this.method1433(var1, var9, var5, var3, var4.field1304[this.field1324]);
                        if(this.field1320 >= var5) {
                           return;
                        }

                        this.field1320 = var5 + var5 - 1 - this.field1320;
                        this.field1318 = -this.field1318;
                     } while(--this.field1326 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1318 < 0) {
                     while(true) {
                        var9 = this.method1433(var1, var9, var5, var3, var4.field1304[this.field1330 - 1]);
                        if(this.field1320 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1320) / var8;
                        if(var10 >= this.field1326) {
                           this.field1320 += var8 * this.field1326;
                           this.field1326 = 0;
                           break;
                        }

                        this.field1320 += var8 * var10;
                        this.field1326 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1432(var1, var9, var6, var3, var4.field1304[this.field1324]);
                        if(this.field1320 < var6) {
                           return;
                        }

                        var10 = (this.field1320 - var5) / var8;
                        if(var10 >= this.field1326) {
                           this.field1320 -= var8 * this.field1326;
                           this.field1326 = 0;
                           break;
                        }

                        this.field1320 -= var8 * var10;
                        this.field1326 -= var10;
                     }
                  }
               }
            }

            if(this.field1318 < 0) {
               this.method1433(var1, var9, 0, var3, 0);
               if(this.field1320 < 0) {
                  this.field1320 = -1;
                  this.method1419();
                  this.method4000();
               }
            } else {
               this.method1432(var1, var9, var7, var3, 0);
               if(this.field1320 >= var7) {
                  this.field1320 = var7;
                  this.method1419();
                  this.method4000();
               }
            }

         }
      }
   }

   @ObfuscatedName("ap")
   int method1432(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1317 > 0) {
            int var6 = var2 + this.field1317;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1317 += var2;
            if(this.field1318 == 256 && (this.field1320 & 255) == 0) {
               if(class59.field1242) {
                  var2 = method1470(0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, this.field1331, this.field1323, 0, var6, var3, this);
               } else {
                  var2 = method1443(((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, this.field1329, 0, var6, var3, this);
               }
            } else if(class59.field1242) {
               var2 = method1476(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, this.field1331, this.field1323, 0, var6, var3, this, this.field1318, var5);
            } else {
               var2 = method1540(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, this.field1329, 0, var6, var3, this, this.field1318, var5);
            }

            this.field1317 -= var2;
            if(this.field1317 != 0) {
               return var2;
            }

            if(!this.method1434()) {
               continue;
            }

            return var4;
         }

         if(this.field1318 == 256 && (this.field1320 & 255) == 0) {
            if(class59.field1242) {
               return method1436(0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, 0, var4, var3, this);
            }

            return method1435(((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, 0, var4, var3, this);
         }

         if(class59.field1242) {
            return method1425(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, 0, var4, var3, this, this.field1318, var5);
         }

         return method1439(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, 0, var4, var3, this, this.field1318, var5);
      }
   }

   @ObfuscatedName("an")
   int method1433(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1317 > 0) {
            int var6 = var2 + this.field1317;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1317 += var2;
            if(this.field1318 == -256 && (this.field1320 & 255) == 0) {
               if(class59.field1242) {
                  var2 = method1446(0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, this.field1331, this.field1323, 0, var6, var3, this);
               } else {
                  var2 = method1445(((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, this.field1329, 0, var6, var3, this);
               }
            } else if(class59.field1242) {
               var2 = method1450(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, this.field1331, this.field1323, 0, var6, var3, this, this.field1318, var5);
            } else {
               var2 = method1449(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, this.field1329, 0, var6, var3, this, this.field1318, var5);
            }

            this.field1317 -= var2;
            if(this.field1317 != 0) {
               return var2;
            }

            if(!this.method1434()) {
               continue;
            }

            return var4;
         }

         if(this.field1318 == -256 && (this.field1320 & 255) == 0) {
            if(class59.field1242) {
               return method1438(0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, 0, var4, var3, this);
            }

            return method1437(((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, 0, var4, var3, this);
         }

         if(class59.field1242) {
            return method1502(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1322, this.field1328, 0, var4, var3, this, this.field1318, var5);
         }

         return method1441(0, 0, ((class65)super.field1333).field1304, var1, this.field1320, var2, this.field1321, 0, var4, var3, this, this.field1318, var5);
      }
   }

   @ObfuscatedName("aa")
   boolean method1434() {
      int var1 = this.field1319;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1493(var1, this.field1325);
         var3 = method1405(var1, this.field1325);
      }

      if(this.field1321 == var1 && this.field1322 == var2 && this.field1328 == var3) {
         if(this.field1319 == Integer.MIN_VALUE) {
            this.field1319 = 0;
            this.field1328 = 0;
            this.field1322 = 0;
            this.field1321 = 0;
            this.method4000();
            return true;
         } else {
            this.method1499();
            return false;
         }
      } else {
         if(this.field1321 < var1) {
            this.field1329 = 1;
            this.field1317 = var1 - this.field1321;
         } else if(this.field1321 > var1) {
            this.field1329 = -1;
            this.field1317 = this.field1321 - var1;
         } else {
            this.field1329 = 0;
         }

         if(this.field1322 < var2) {
            this.field1331 = 1;
            if(this.field1317 == 0 || this.field1317 > var2 - this.field1322) {
               this.field1317 = var2 - this.field1322;
            }
         } else if(this.field1322 > var2) {
            this.field1331 = -1;
            if(this.field1317 == 0 || this.field1317 > this.field1322 - var2) {
               this.field1317 = this.field1322 - var2;
            }
         } else {
            this.field1331 = 0;
         }

         if(this.field1328 < var3) {
            this.field1323 = 1;
            if(this.field1317 == 0 || this.field1317 > var3 - this.field1328) {
               this.field1317 = var3 - this.field1328;
            }
         } else if(this.field1328 > var3) {
            this.field1323 = -1;
            if(this.field1317 == 0 || this.field1317 > this.field1328 - var3) {
               this.field1317 = this.field1328 - var3;
            }
         } else {
            this.field1323 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ag")
   static int method1435(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1320 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aq")
   static int method1436(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1320 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("af")
   static int method1437(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1320 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ax")
   static int method1438(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1320 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   static int method1439(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1320 = var4;
      return var5;
   }

   @ObfuscatedName("c")
   public static class67 method1440(class65 var0, int var1, int var2) {
      return var0.field1304 != null && var0.field1304.length != 0?new class67(var0, (int)((long)var0.field1301 * 256L * (long)var1 / (long)(class59.field1260 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("ab")
   static int method1441(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1320 = var4;
      return var5;
   }

   @ObfuscatedName("w")
   public synchronized int method1442() {
      return this.field1319 == Integer.MIN_VALUE?0:this.field1319;
   }

   @ObfuscatedName("au")
   static int method1443(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1322 += var9.field1331 * (var6 - var3);
      var9.field1328 += var9.field1323 * (var6 - var3);

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

      var9.field1321 = var4 >> 2;
      var9.field1320 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   static int method1445(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1322 += var9.field1331 * (var6 - var3);
      var9.field1328 += var9.field1323 * (var6 - var3);

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

      var9.field1321 = var4 >> 2;
      var9.field1320 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ay")
   static int method1446(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1321 += var12.field1329 * (var9 - var4);
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

      var12.field1322 = var5 >> 2;
      var12.field1328 = var6 >> 2;
      var12.field1320 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bu")
   static int method1449(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1322 -= var11.field1331 * var5;
      var11.field1328 -= var11.field1323 * var5;
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

      var11.field1322 += var11.field1331 * var5;
      var11.field1328 += var11.field1323 * var5;
      var11.field1321 = var6;
      var11.field1320 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1450(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1321 -= var13.field1329 * var5;
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
      var13.field1321 += var13.field1329 * var5;
      var13.field1322 = var6;
      var13.field1328 = var7;
      var13.field1320 = var4;
      return var5;
   }

   @ObfuscatedName("x")
   public synchronized int method1453() {
      return this.field1325 < 0?-1:this.field1325;
   }

   @ObfuscatedName("d")
   public boolean method1454() {
      return this.field1320 < 0 || this.field1320 >= ((class65)super.field1333).field1304.length << 8;
   }

   @ObfuscatedName("a")
   protected class69 vmethod3803() {
      return null;
   }

   @ObfuscatedName("am")
   static int method1470(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1321 += var12.field1329 * (var9 - var4);
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

      var12.field1322 = var5 >> 2;
      var12.field1328 = var6 >> 2;
      var12.field1320 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1473(int var1) {
      this.method1414(var1, this.method1453());
   }

   @ObfuscatedName("bw")
   static int method1476(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1321 -= var13.field1329 * var5;
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
      var13.field1321 += var13.field1329 * var5;
      var13.field1322 = var6;
      var13.field1328 = var7;
      var13.field1320 = var4;
      return var5;
   }

   @ObfuscatedName("m")
   public synchronized void method1489(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1414(var2, var3);
      } else {
         int var4 = method1493(var2, var3);
         int var5 = method1405(var2, var3);
         if(this.field1322 == var4 && this.field1328 == var5) {
            this.field1317 = 0;
         } else {
            int var6 = var2 - this.field1321;
            if(this.field1321 - var2 > var6) {
               var6 = this.field1321 - var2;
            }

            if(var4 - this.field1322 > var6) {
               var6 = var4 - this.field1322;
            }

            if(this.field1322 - var4 > var6) {
               var6 = this.field1322 - var4;
            }

            if(var5 - this.field1328 > var6) {
               var6 = var5 - this.field1328;
            }

            if(this.field1328 - var5 > var6) {
               var6 = this.field1328 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1317 = var1;
            this.field1319 = var2;
            this.field1325 = var3;
            this.field1329 = (var2 - this.field1321) / var1;
            this.field1331 = (var4 - this.field1322) / var1;
            this.field1323 = (var5 - this.field1328) / var1;
         }
      }
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1333 = var1;
      this.field1324 = var1.field1302;
      this.field1330 = var1.field1303;
      this.field1327 = var1.field1300;
      this.field1318 = var2;
      this.field1319 = var3;
      this.field1325 = var4;
      this.field1320 = 0;
      this.method1499();
   }

   @ObfuscatedName("e")
   static int method1493(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("b")
   protected class69 vmethod3804() {
      return null;
   }

   @ObfuscatedName("r")
   void method1499() {
      this.field1321 = this.field1319;
      this.field1322 = method1493(this.field1319, this.field1325);
      this.field1328 = method1405(this.field1319, this.field1325);
   }

   @ObfuscatedName("aj")
   static int method1502(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1320 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("q")
   public synchronized void method1530(int var1) {
      this.method1414(var1 << 6, this.method1453());
   }

   @ObfuscatedName("ac")
   static int method1540(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1322 -= var11.field1331 * var5;
      var11.field1328 -= var11.field1323 * var5;
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

      var11.field1322 += var11.field1331 * var5;
      var11.field1328 += var11.field1323 * var5;
      var11.field1321 = var6;
      var11.field1320 = var4;
      return var5;
   }
}
