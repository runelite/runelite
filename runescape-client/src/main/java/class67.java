import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class67 extends class69 {
   @ObfuscatedName("z")
   int field1319;
   @ObfuscatedName("d")
   int field1320;
   @ObfuscatedName("v")
   int field1321;
   @ObfuscatedName("u")
   int field1322;
   @ObfuscatedName("r")
   int field1323;
   @ObfuscatedName("t")
   int field1324;
   @ObfuscatedName("n")
   int field1325;
   @ObfuscatedName("i")
   int field1326;
   @ObfuscatedName("q")
   int field1327;
   @ObfuscatedName("m")
   int field1328;
   @ObfuscatedName("k")
   boolean field1329;
   @ObfuscatedName("x")
   int field1330;
   @ObfuscatedName("a")
   int field1331;
   @ObfuscatedName("j")
   int field1332;
   @ObfuscatedName("g")
   int field1333;

   @ObfuscatedName("aj")
   static int method1346(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1331 = var4;
      return var5;
   }

   @ObfuscatedName("ay")
   int vmethod1513() {
      int var1 = this.field1319 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1326 == 0) {
         var1 -= var1 * this.field1331 / (((class65)super.field1335).field1305.length << 8);
      } else if(this.field1326 >= 0) {
         var1 -= var1 * this.field1333 / ((class65)super.field1335).field1305.length;
      }

      return var1 > 255?255:var1;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1335 = var1;
      this.field1333 = var1.field1304;
      this.field1328 = var1.field1306;
      this.field1329 = var1.field1302;
      this.field1320 = var2;
      this.field1321 = var3;
      this.field1323 = 8192;
      this.field1331 = 0;
      this.method1351();
   }

   @ObfuscatedName("r")
   public static class67 method1350(class65 var0, int var1, int var2, int var3) {
      return var0.field1305 != null && var0.field1305.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("z")
   void method1351() {
      this.field1319 = this.field1321;
      this.field1324 = method1376(this.field1321, this.field1323);
      this.field1325 = method1497(this.field1321, this.field1323);
   }

   @ObfuscatedName("h")
   public synchronized void method1352(int var1) {
      if(this.field1320 < 0) {
         this.field1320 = -var1;
      } else {
         this.field1320 = var1;
      }

   }

   @ObfuscatedName("x")
   public synchronized void method1353(int var1) {
      this.method1362(var1 << 6, this.method1357());
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1354(int var1) {
      this.method1362(var1, this.method1357());
   }

   @ObfuscatedName("w")
   public synchronized int method1357() {
      return this.field1323 < 0?-1:this.field1323;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1359() {
      this.field1320 = (this.field1320 ^ this.field1320 >> 31) + (this.field1320 >>> 31);
      this.field1320 = -this.field1320;
   }

   @ObfuscatedName("o")
   void method1360() {
      if(this.field1330 != 0) {
         if(this.field1321 == Integer.MIN_VALUE) {
            this.field1321 = 0;
         }

         this.field1330 = 0;
         this.method1351();
      }

   }

   @ObfuscatedName("y")
   public synchronized void method1361(int var1, int var2) {
      this.method1404(var1, var2, this.method1357());
   }

   @ObfuscatedName("j")
   synchronized void method1362(int var1, int var2) {
      this.field1321 = var1;
      this.field1323 = var2;
      this.field1330 = 0;
      this.method1351();
   }

   @ObfuscatedName("l")
   public synchronized int method1365() {
      return this.field1320 < 0?-this.field1320:this.field1320;
   }

   @ObfuscatedName("c")
   public boolean method1366() {
      return this.field1331 < 0 || this.field1331 >= ((class65)super.field1335).field1305.length << 8;
   }

   @ObfuscatedName("f")
   public boolean method1367() {
      return this.field1330 != 0;
   }

   @ObfuscatedName("t")
   protected class69 vmethod3745() {
      return null;
   }

   @ObfuscatedName("i")
   protected int vmethod3747() {
      return this.field1321 == 0 && this.field1330 == 0?0:1;
   }

   @ObfuscatedName("g")
   public synchronized void vmethod3751(int[] var1, int var2, int var3) {
      if(this.field1321 == 0 && this.field1330 == 0) {
         this.vmethod3749(var3);
      } else {
         class65 var4 = (class65)super.field1335;
         int var5 = this.field1333 << 8;
         int var6 = this.field1328 << 8;
         int var7 = var4.field1305.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1326 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1331 < 0) {
            if(this.field1320 <= 0) {
               this.method1360();
               this.unlink();
               return;
            }

            this.field1331 = 0;
         }

         if(this.field1331 >= var7) {
            if(this.field1320 >= 0) {
               this.method1360();
               this.unlink();
               return;
            }

            this.field1331 = var7 - 1;
         }

         if(this.field1326 < 0) {
            if(this.field1329) {
               if(this.field1320 < 0) {
                  var9 = this.method1484(var1, var2, var5, var3, var4.field1305[this.field1333]);
                  if(this.field1331 >= var5) {
                     return;
                  }

                  this.field1331 = var5 + var5 - 1 - this.field1331;
                  this.field1320 = -this.field1320;
               }

               while(true) {
                  var9 = this.method1373(var1, var9, var6, var3, var4.field1305[this.field1328 - 1]);
                  if(this.field1331 < var6) {
                     return;
                  }

                  this.field1331 = var6 + var6 - 1 - this.field1331;
                  this.field1320 = -this.field1320;
                  var9 = this.method1484(var1, var9, var5, var3, var4.field1305[this.field1333]);
                  if(this.field1331 >= var5) {
                     return;
                  }

                  this.field1331 = var5 + var5 - 1 - this.field1331;
                  this.field1320 = -this.field1320;
               }
            } else if(this.field1320 < 0) {
               while(true) {
                  var9 = this.method1484(var1, var9, var5, var3, var4.field1305[this.field1328 - 1]);
                  if(this.field1331 >= var5) {
                     return;
                  }

                  this.field1331 = var6 - 1 - (var6 - 1 - this.field1331) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1373(var1, var9, var6, var3, var4.field1305[this.field1333]);
                  if(this.field1331 < var6) {
                     return;
                  }

                  this.field1331 = var5 + (this.field1331 - var5) % var8;
               }
            }
         } else {
            if(this.field1326 > 0) {
               if(this.field1329) {
                  label179: {
                     if(this.field1320 < 0) {
                        var9 = this.method1484(var1, var2, var5, var3, var4.field1305[this.field1333]);
                        if(this.field1331 >= var5) {
                           return;
                        }

                        this.field1331 = var5 + var5 - 1 - this.field1331;
                        this.field1320 = -this.field1320;
                        if(--this.field1326 == 0) {
                           break label179;
                        }
                     }

                     do {
                        var9 = this.method1373(var1, var9, var6, var3, var4.field1305[this.field1328 - 1]);
                        if(this.field1331 < var6) {
                           return;
                        }

                        this.field1331 = var6 + var6 - 1 - this.field1331;
                        this.field1320 = -this.field1320;
                        if(--this.field1326 == 0) {
                           break;
                        }

                        var9 = this.method1484(var1, var9, var5, var3, var4.field1305[this.field1333]);
                        if(this.field1331 >= var5) {
                           return;
                        }

                        this.field1331 = var5 + var5 - 1 - this.field1331;
                        this.field1320 = -this.field1320;
                     } while(--this.field1326 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1320 < 0) {
                     while(true) {
                        var9 = this.method1484(var1, var9, var5, var3, var4.field1305[this.field1328 - 1]);
                        if(this.field1331 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1331) / var8;
                        if(var10 >= this.field1326) {
                           this.field1331 += var8 * this.field1326;
                           this.field1326 = 0;
                           break;
                        }

                        this.field1331 += var8 * var10;
                        this.field1326 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1373(var1, var9, var6, var3, var4.field1305[this.field1333]);
                        if(this.field1331 < var6) {
                           return;
                        }

                        var10 = (this.field1331 - var5) / var8;
                        if(var10 >= this.field1326) {
                           this.field1331 -= var8 * this.field1326;
                           this.field1326 = 0;
                           break;
                        }

                        this.field1331 -= var8 * var10;
                        this.field1326 -= var10;
                     }
                  }
               }
            }

            if(this.field1320 < 0) {
               this.method1484(var1, var9, 0, var3, 0);
               if(this.field1331 < 0) {
                  this.field1331 = -1;
                  this.method1360();
                  this.unlink();
               }
            } else {
               this.method1373(var1, var9, var7, var3, 0);
               if(this.field1331 >= var7) {
                  this.field1331 = var7;
                  this.method1360();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3749(int var1) {
      if(this.field1330 > 0) {
         if(var1 >= this.field1330) {
            if(this.field1321 == Integer.MIN_VALUE) {
               this.field1321 = 0;
               this.field1325 = 0;
               this.field1324 = 0;
               this.field1319 = 0;
               this.unlink();
               var1 = this.field1330;
            }

            this.field1330 = 0;
            this.method1351();
         } else {
            this.field1319 += this.field1322 * var1;
            this.field1324 += this.field1332 * var1;
            this.field1325 += this.field1327 * var1;
            this.field1330 -= var1;
         }
      }

      class65 var2 = (class65)super.field1335;
      int var3 = this.field1333 << 8;
      int var4 = this.field1328 << 8;
      int var5 = var2.field1305.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1326 = 0;
      }

      if(this.field1331 < 0) {
         if(this.field1320 <= 0) {
            this.method1360();
            this.unlink();
            return;
         }

         this.field1331 = 0;
      }

      if(this.field1331 >= var5) {
         if(this.field1320 >= 0) {
            this.method1360();
            this.unlink();
            return;
         }

         this.field1331 = var5 - 1;
      }

      this.field1331 += this.field1320 * var1;
      if(this.field1326 < 0) {
         if(!this.field1329) {
            if(this.field1320 < 0) {
               if(this.field1331 >= var3) {
                  return;
               }

               this.field1331 = var4 - 1 - (var4 - 1 - this.field1331) % var6;
            } else {
               if(this.field1331 < var4) {
                  return;
               }

               this.field1331 = var3 + (this.field1331 - var3) % var6;
            }

         } else {
            if(this.field1320 < 0) {
               if(this.field1331 >= var3) {
                  return;
               }

               this.field1331 = var3 + var3 - 1 - this.field1331;
               this.field1320 = -this.field1320;
            }

            while(this.field1331 >= var4) {
               this.field1331 = var4 + var4 - 1 - this.field1331;
               this.field1320 = -this.field1320;
               if(this.field1331 >= var3) {
                  return;
               }

               this.field1331 = var3 + var3 - 1 - this.field1331;
               this.field1320 = -this.field1320;
            }

         }
      } else {
         if(this.field1326 > 0) {
            if(this.field1329) {
               label175: {
                  if(this.field1320 < 0) {
                     if(this.field1331 >= var3) {
                        return;
                     }

                     this.field1331 = var3 + var3 - 1 - this.field1331;
                     this.field1320 = -this.field1320;
                     if(--this.field1326 == 0) {
                        break label175;
                     }
                  }

                  do {
                     if(this.field1331 < var4) {
                        return;
                     }

                     this.field1331 = var4 + var4 - 1 - this.field1331;
                     this.field1320 = -this.field1320;
                     if(--this.field1326 == 0) {
                        break;
                     }

                     if(this.field1331 >= var3) {
                        return;
                     }

                     this.field1331 = var3 + var3 - 1 - this.field1331;
                     this.field1320 = -this.field1320;
                  } while(--this.field1326 != 0);
               }
            } else {
               int var7;
               if(this.field1320 < 0) {
                  if(this.field1331 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1331) / var6;
                  if(var7 < this.field1326) {
                     this.field1331 += var6 * var7;
                     this.field1326 -= var7;
                     return;
                  }

                  this.field1331 += var6 * this.field1326;
                  this.field1326 = 0;
               } else {
                  if(this.field1331 < var4) {
                     return;
                  }

                  var7 = (this.field1331 - var3) / var6;
                  if(var7 < this.field1326) {
                     this.field1331 -= var6 * var7;
                     this.field1326 -= var7;
                     return;
                  }

                  this.field1331 -= var6 * this.field1326;
                  this.field1326 = 0;
               }
            }
         }

         if(this.field1320 < 0) {
            if(this.field1331 < 0) {
               this.field1331 = -1;
               this.method1360();
               this.unlink();
            }
         } else if(this.field1331 >= var5) {
            this.field1331 = var5;
            this.method1360();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("at")
   int method1373(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1330 > 0) {
            int var6 = var2 + this.field1330;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1330 += var2;
            if(this.field1320 == 256 && (this.field1331 & 255) == 0) {
               if(class59.field1262) {
                  var2 = method1474(0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, this.field1332, this.field1327, 0, var6, var3, this);
               } else {
                  var2 = method1384(((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, this.field1322, 0, var6, var3, this);
               }
            } else if(class59.field1262) {
               var2 = method1490(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, this.field1332, this.field1327, 0, var6, var3, this, this.field1320, var5);
            } else {
               var2 = method1388(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, this.field1322, 0, var6, var3, this, this.field1320, var5);
            }

            this.field1330 -= var2;
            if(this.field1330 != 0) {
               return var2;
            }

            if(!this.method1375()) {
               continue;
            }

            return var4;
         }

         if(this.field1320 == 256 && (this.field1331 & 255) == 0) {
            if(class59.field1262) {
               return method1433(0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, 0, var4, var3, this);
            }

            return method1475(((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, 0, var4, var3, this);
         }

         if(class59.field1262) {
            return method1381(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, 0, var4, var3, this, this.field1320, var5);
         }

         return method1418(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, 0, var4, var3, this, this.field1320, var5);
      }
   }

   @ObfuscatedName("ab")
   boolean method1375() {
      int var1 = this.field1321;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1376(var1, this.field1323);
         var3 = method1497(var1, this.field1323);
      }

      if(this.field1319 == var1 && this.field1324 == var2 && this.field1325 == var3) {
         if(this.field1321 == Integer.MIN_VALUE) {
            this.field1321 = 0;
            this.field1325 = 0;
            this.field1324 = 0;
            this.field1319 = 0;
            this.unlink();
            return true;
         } else {
            this.method1351();
            return false;
         }
      } else {
         if(this.field1319 < var1) {
            this.field1322 = 1;
            this.field1330 = var1 - this.field1319;
         } else if(this.field1319 > var1) {
            this.field1322 = -1;
            this.field1330 = this.field1319 - var1;
         } else {
            this.field1322 = 0;
         }

         if(this.field1324 < var2) {
            this.field1332 = 1;
            if(this.field1330 == 0 || this.field1330 > var2 - this.field1324) {
               this.field1330 = var2 - this.field1324;
            }
         } else if(this.field1324 > var2) {
            this.field1332 = -1;
            if(this.field1330 == 0 || this.field1330 > this.field1324 - var2) {
               this.field1330 = this.field1324 - var2;
            }
         } else {
            this.field1332 = 0;
         }

         if(this.field1325 < var3) {
            this.field1327 = 1;
            if(this.field1330 == 0 || this.field1330 > var3 - this.field1325) {
               this.field1330 = var3 - this.field1325;
            }
         } else if(this.field1325 > var3) {
            this.field1327 = -1;
            if(this.field1330 == 0 || this.field1330 > this.field1325 - var3) {
               this.field1330 = this.field1325 - var3;
            }
         } else {
            this.field1327 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("a")
   static int method1376(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   static int method1378(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1331 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   static int method1381(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1331 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bg")
   static int method1383(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1331 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bf")
   static int method1384(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1324 += var9.field1332 * (var6 - var3);
      var9.field1325 += var9.field1327 * (var6 - var3);

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

      var9.field1319 = var4 >> 2;
      var9.field1331 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   static int method1386(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1324 += var9.field1332 * (var6 - var3);
      var9.field1325 += var9.field1327 * (var6 - var3);

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

      var9.field1319 = var4 >> 2;
      var9.field1331 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   static int method1387(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1319 += var12.field1322 * (var9 - var4);
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

      var12.field1324 = var5 >> 2;
      var12.field1325 = var6 >> 2;
      var12.field1331 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   static int method1388(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1324 -= var11.field1332 * var5;
      var11.field1325 -= var11.field1327 * var5;
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

      var11.field1324 += var11.field1332 * var5;
      var11.field1325 += var11.field1327 * var5;
      var11.field1319 = var6;
      var11.field1331 = var4;
      return var5;
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1335 = var1;
      this.field1333 = var1.field1304;
      this.field1328 = var1.field1306;
      this.field1329 = var1.field1302;
      this.field1320 = var2;
      this.field1321 = var3;
      this.field1323 = var4;
      this.field1331 = 0;
      this.method1351();
   }

   @ObfuscatedName("s")
   public synchronized void method1404(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1362(var2, var3);
      } else {
         int var4 = method1376(var2, var3);
         int var5 = method1497(var2, var3);
         if(this.field1324 == var4 && this.field1325 == var5) {
            this.field1330 = 0;
         } else {
            int var6 = var2 - this.field1319;
            if(this.field1319 - var2 > var6) {
               var6 = this.field1319 - var2;
            }

            if(var4 - this.field1324 > var6) {
               var6 = var4 - this.field1324;
            }

            if(this.field1324 - var4 > var6) {
               var6 = this.field1324 - var4;
            }

            if(var5 - this.field1325 > var6) {
               var6 = var5 - this.field1325;
            }

            if(this.field1325 - var5 > var6) {
               var6 = this.field1325 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1330 = var1;
            this.field1321 = var2;
            this.field1323 = var3;
            this.field1322 = (var2 - this.field1319) / var1;
            this.field1332 = (var4 - this.field1324) / var1;
            this.field1327 = (var5 - this.field1325) / var1;
         }
      }
   }

   @ObfuscatedName("ae")
   static int method1418(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1331 = var4;
      return var5;
   }

   @ObfuscatedName("ag")
   static int method1420(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1331 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("n")
   protected class69 vmethod3756() {
      return null;
   }

   @ObfuscatedName("bp")
   static int method1424(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1324 -= var11.field1332 * var5;
      var11.field1325 -= var11.field1327 * var5;
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

      var11.field1324 += var11.field1332 * var5;
      var11.field1325 += var11.field1327 * var5;
      var11.field1319 = var6;
      var11.field1331 = var4;
      return var5;
   }

   @ObfuscatedName("b")
   public synchronized void method1426(int var1) {
      int var2 = ((class65)super.field1335).field1305.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1331 = var1;
   }

   @ObfuscatedName("m")
   public synchronized void method1430(int var1) {
      this.field1326 = var1;
   }

   @ObfuscatedName("az")
   static int method1433(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1331 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("e")
   public synchronized void method1453(int var1) {
      if(var1 == 0) {
         this.method1354(0);
         this.unlink();
      } else if(this.field1324 == 0 && this.field1325 == 0) {
         this.field1330 = 0;
         this.field1321 = 0;
         this.field1319 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1319;
         if(this.field1319 > var2) {
            var2 = this.field1319;
         }

         if(-this.field1324 > var2) {
            var2 = -this.field1324;
         }

         if(this.field1324 > var2) {
            var2 = this.field1324;
         }

         if(-this.field1325 > var2) {
            var2 = -this.field1325;
         }

         if(this.field1325 > var2) {
            var2 = this.field1325;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1330 = var1;
         this.field1321 = Integer.MIN_VALUE;
         this.field1322 = -this.field1319 / var1;
         this.field1332 = -this.field1324 / var1;
         this.field1327 = -this.field1325 / var1;
      }
   }

   @ObfuscatedName("v")
   public static class67 method1468(class65 var0, int var1, int var2) {
      return var0.field1305 != null && var0.field1305.length != 0?new class67(var0, (int)((long)var0.field1303 * 256L * (long)var1 / (long)(class59.field1265 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bl")
   static int method1474(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1319 += var12.field1322 * (var9 - var4);
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

      var12.field1324 = var5 >> 2;
      var12.field1325 = var6 >> 2;
      var12.field1331 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   static int method1475(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1331 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("q")
   public synchronized int method1476() {
      return this.field1321 == Integer.MIN_VALUE?0:this.field1321;
   }

   @ObfuscatedName("aw")
   int method1484(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1330 > 0) {
            int var6 = var2 + this.field1330;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1330 += var2;
            if(this.field1320 == -256 && (this.field1331 & 255) == 0) {
               if(class59.field1262) {
                  var2 = method1387(0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, this.field1332, this.field1327, 0, var6, var3, this);
               } else {
                  var2 = method1386(((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, this.field1322, 0, var6, var3, this);
               }
            } else if(class59.field1262) {
               var2 = method1503(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, this.field1332, this.field1327, 0, var6, var3, this, this.field1320, var5);
            } else {
               var2 = method1424(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, this.field1322, 0, var6, var3, this, this.field1320, var5);
            }

            this.field1330 -= var2;
            if(this.field1330 != 0) {
               return var2;
            }

            if(!this.method1375()) {
               continue;
            }

            return var4;
         }

         if(this.field1320 == -256 && (this.field1331 & 255) == 0) {
            if(class59.field1262) {
               return method1420(0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, 0, var4, var3, this);
            }

            return method1378(((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, 0, var4, var3, this);
         }

         if(class59.field1262) {
            return method1383(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1324, this.field1325, 0, var4, var3, this, this.field1320, var5);
         }

         return method1346(0, 0, ((class65)super.field1335).field1305, var1, this.field1331, var2, this.field1319, 0, var4, var3, this, this.field1320, var5);
      }
   }

   @ObfuscatedName("bq")
   static int method1490(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1319 -= var13.field1322 * var5;
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
      var13.field1319 += var13.field1322 * var5;
      var13.field1324 = var6;
      var13.field1325 = var7;
      var13.field1331 = var4;
      return var5;
   }

   @ObfuscatedName("d")
   static int method1497(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bo")
   static int method1503(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1319 -= var13.field1322 * var5;
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
      var13.field1319 += var13.field1322 * var5;
      var13.field1324 = var6;
      var13.field1325 = var7;
      var13.field1331 = var4;
      return var5;
   }
}
