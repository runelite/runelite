import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class67 extends class69 {
   @ObfuscatedName("s")
   int field1318;
   @ObfuscatedName("l")
   int field1319;
   @ObfuscatedName("r")
   int field1320;
   @ObfuscatedName("e")
   int field1321;
   @ObfuscatedName("h")
   int field1322;
   @ObfuscatedName("g")
   int field1323;
   @ObfuscatedName("m")
   boolean field1324;
   @ObfuscatedName("u")
   int field1325;
   @ObfuscatedName("n")
   int field1326;
   @ObfuscatedName("b")
   int field1327;
   @ObfuscatedName("o")
   int field1328;
   @ObfuscatedName("q")
   int field1329;
   @ObfuscatedName("d")
   int field1330;
   @ObfuscatedName("p")
   int field1331;
   @ObfuscatedName("k")
   int field1332;

   @ObfuscatedName("ae")
   int vmethod1597() {
      int var1 = this.field1322 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1325 == 0) {
         var1 -= var1 * this.field1319 / (((class65)super.field1334).field1304.length << 8);
      } else if(this.field1325 >= 0) {
         var1 -= var1 * this.field1326 / ((class65)super.field1334).field1304.length;
      }

      return var1 > 255?255:var1;
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1334 = var1;
      this.field1326 = var1.field1301;
      this.field1327 = var1.field1303;
      this.field1324 = var1.field1305;
      this.field1323 = var2;
      this.field1320 = var3;
      this.field1321 = var4;
      this.field1319 = 0;
      this.method1524();
   }

   @ObfuscatedName("r")
   public static class67 method1427(class65 var0, int var1, int var2) {
      return var0.field1304 != null && var0.field1304.length != 0?new class67(var0, (int)((long)var0.field1302 * 256L * (long)var1 / (long)(class59.field1254 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("e")
   public static class67 method1428(class65 var0, int var1, int var2, int var3) {
      return var0.field1304 != null && var0.field1304.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("b")
   public synchronized void method1430(int var1) {
      this.field1325 = var1;
   }

   @ObfuscatedName("x")
   public synchronized void method1431(int var1) {
      if(var1 == 0) {
         this.method1561(0);
         this.unlink();
      } else if(this.field1318 == 0 && this.field1332 == 0) {
         this.field1329 = 0;
         this.field1320 = 0;
         this.field1322 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1322;
         if(this.field1322 > var2) {
            var2 = this.field1322;
         }

         if(-this.field1318 > var2) {
            var2 = -this.field1318;
         }

         if(this.field1318 > var2) {
            var2 = this.field1318;
         }

         if(-this.field1332 > var2) {
            var2 = -this.field1332;
         }

         if(this.field1332 > var2) {
            var2 = this.field1332;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1329 = var1;
         this.field1320 = Integer.MIN_VALUE;
         this.field1331 = -this.field1322 / var1;
         this.field1328 = -this.field1318 / var1;
         this.field1330 = -this.field1332 / var1;
      }

   }

   @ObfuscatedName("w")
   synchronized void method1433(int var1, int var2) {
      this.field1320 = var1;
      this.field1321 = var2;
      this.field1329 = 0;
      this.method1524();
   }

   @ObfuscatedName("o")
   public synchronized int method1434() {
      return this.field1320 == Integer.MIN_VALUE?0:this.field1320;
   }

   @ObfuscatedName("d")
   public synchronized int method1435() {
      return this.field1321 < 0?-1:this.field1321;
   }

   @ObfuscatedName("f")
   public synchronized void method1436(int var1) {
      int var2 = ((class65)super.field1334).field1304.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1319 = var1;
   }

   @ObfuscatedName("v")
   public synchronized void method1439(int var1, int var2) {
      this.method1440(var1, var2, this.method1435());
   }

   @ObfuscatedName("j")
   public synchronized void method1440(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1433(var2, var3);
      } else {
         int var4 = method1470(var2, var3);
         int var5 = method1489(var2, var3);
         if(this.field1318 == var4 && this.field1332 == var5) {
            this.field1329 = 0;
         } else {
            int var6 = var2 - this.field1322;
            if(this.field1322 - var2 > var6) {
               var6 = this.field1322 - var2;
            }

            if(var4 - this.field1318 > var6) {
               var6 = var4 - this.field1318;
            }

            if(this.field1318 - var4 > var6) {
               var6 = this.field1318 - var4;
            }

            if(var5 - this.field1332 > var6) {
               var6 = var5 - this.field1332;
            }

            if(this.field1332 - var5 > var6) {
               var6 = this.field1332 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1329 = var1;
            this.field1320 = var2;
            this.field1321 = var3;
            this.field1331 = (var2 - this.field1322) / var1;
            this.field1328 = (var4 - this.field1318) / var1;
            this.field1330 = (var5 - this.field1332) / var1;
         }
      }

   }

   @ObfuscatedName("af")
   public synchronized void method1442(int var1) {
      if(this.field1323 < 0) {
         this.field1323 = -var1;
      } else {
         this.field1323 = var1;
      }

   }

   @ObfuscatedName("ar")
   public boolean method1445() {
      return this.field1329 != 0;
   }

   @ObfuscatedName("s")
   protected class69 vmethod3870() {
      return null;
   }

   @ObfuscatedName("k")
   protected class69 vmethod3871() {
      return null;
   }

   @ObfuscatedName("u")
   protected int vmethod3872() {
      return this.field1320 == 0 && this.field1329 == 0?0:1;
   }

   @ObfuscatedName("m")
   public synchronized void vmethod3874(int var1) {
      if(this.field1329 > 0) {
         if(var1 >= this.field1329) {
            if(this.field1320 == Integer.MIN_VALUE) {
               this.field1320 = 0;
               this.field1332 = 0;
               this.field1318 = 0;
               this.field1322 = 0;
               this.unlink();
               var1 = this.field1329;
            }

            this.field1329 = 0;
            this.method1524();
         } else {
            this.field1322 += this.field1331 * var1;
            this.field1318 += this.field1328 * var1;
            this.field1332 += this.field1330 * var1;
            this.field1329 -= var1;
         }
      }

      class65 var2 = (class65)super.field1334;
      int var3 = this.field1326 << 8;
      int var4 = this.field1327 << 8;
      int var5 = var2.field1304.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1325 = 0;
      }

      if(this.field1319 < 0) {
         if(this.field1323 <= 0) {
            this.method1481();
            this.unlink();
            return;
         }

         this.field1319 = 0;
      }

      if(this.field1319 >= var5) {
         if(this.field1323 >= 0) {
            this.method1481();
            this.unlink();
            return;
         }

         this.field1319 = var5 - 1;
      }

      this.field1319 += this.field1323 * var1;
      if(this.field1325 < 0) {
         if(!this.field1324) {
            if(this.field1323 < 0) {
               if(this.field1319 >= var3) {
                  return;
               }

               this.field1319 = var4 - 1 - (var4 - 1 - this.field1319) % var6;
            } else {
               if(this.field1319 < var4) {
                  return;
               }

               this.field1319 = var3 + (this.field1319 - var3) % var6;
            }
         } else {
            if(this.field1323 < 0) {
               if(this.field1319 >= var3) {
                  return;
               }

               this.field1319 = var3 + var3 - 1 - this.field1319;
               this.field1323 = -this.field1323;
            }

            while(this.field1319 >= var4) {
               this.field1319 = var4 + var4 - 1 - this.field1319;
               this.field1323 = -this.field1323;
               if(this.field1319 >= var3) {
                  return;
               }

               this.field1319 = var3 + var3 - 1 - this.field1319;
               this.field1323 = -this.field1323;
            }
         }
      } else {
         if(this.field1325 > 0) {
            if(this.field1324) {
               label117: {
                  if(this.field1323 < 0) {
                     if(this.field1319 >= var3) {
                        return;
                     }

                     this.field1319 = var3 + var3 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                     if(--this.field1325 == 0) {
                        break label117;
                     }
                  }

                  do {
                     if(this.field1319 < var4) {
                        return;
                     }

                     this.field1319 = var4 + var4 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                     if(--this.field1325 == 0) {
                        break;
                     }

                     if(this.field1319 >= var3) {
                        return;
                     }

                     this.field1319 = var3 + var3 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                  } while(--this.field1325 != 0);
               }
            } else {
               label149: {
                  int var7;
                  if(this.field1323 < 0) {
                     if(this.field1319 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1319) / var6;
                     if(var7 >= this.field1325) {
                        this.field1319 += var6 * this.field1325;
                        this.field1325 = 0;
                        break label149;
                     }

                     this.field1319 += var6 * var7;
                     this.field1325 -= var7;
                  } else {
                     if(this.field1319 < var4) {
                        return;
                     }

                     var7 = (this.field1319 - var3) / var6;
                     if(var7 >= this.field1325) {
                        this.field1319 -= var6 * this.field1325;
                        this.field1325 = 0;
                        break label149;
                     }

                     this.field1319 -= var6 * var7;
                     this.field1325 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1323 < 0) {
            if(this.field1319 < 0) {
               this.field1319 = -1;
               this.method1481();
               this.unlink();
            }
         } else if(this.field1319 >= var5) {
            this.field1319 = var5;
            this.method1481();
            this.unlink();
         }
      }

   }

   @ObfuscatedName("at")
   int method1451(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1329 > 0) {
            int var6 = var2 + this.field1329;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1329 += var2;
            if(this.field1323 == 256 && (this.field1319 & 255) == 0) {
               if(class59.field1264) {
                  var2 = method1504(0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, this.field1328, this.field1330, 0, var6, var3, this);
               } else {
                  var2 = method1507(((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, this.field1331, 0, var6, var3, this);
               }
            } else if(class59.field1264) {
               var2 = method1467(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, this.field1328, this.field1330, 0, var6, var3, this, this.field1323, var5);
            } else {
               var2 = method1518(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, this.field1331, 0, var6, var3, this, this.field1323, var5);
            }

            this.field1329 -= var2;
            if(this.field1329 != 0) {
               return var2;
            }

            if(!this.method1453()) {
               continue;
            }

            return var4;
         }

         if(this.field1323 == 256 && (this.field1319 & 255) == 0) {
            if(class59.field1264) {
               return method1455(0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, 0, var4, var3, this);
            }

            return method1454(((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, 0, var4, var3, this);
         }

         if(class59.field1264) {
            return method1459(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, 0, var4, var3, this, this.field1323, var5);
         }

         return method1458(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, 0, var4, var3, this, this.field1323, var5);
      }
   }

   @ObfuscatedName("av")
   int method1452(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1329 > 0) {
            int var6 = var2 + this.field1329;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1329 += var2;
            if(this.field1323 == -256 && (this.field1319 & 255) == 0) {
               if(class59.field1264) {
                  var2 = method1465(0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, this.field1328, this.field1330, 0, var6, var3, this);
               } else {
                  var2 = method1464(((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, this.field1331, 0, var6, var3, this);
               }
            } else if(class59.field1264) {
               var2 = method1469(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, this.field1328, this.field1330, 0, var6, var3, this, this.field1323, var5);
            } else {
               var2 = method1525(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, this.field1331, 0, var6, var3, this, this.field1323, var5);
            }

            this.field1329 -= var2;
            if(this.field1329 != 0) {
               return var2;
            }

            if(!this.method1453()) {
               continue;
            }

            return var4;
         }

         if(this.field1323 == -256 && (this.field1319 & 255) == 0) {
            if(class59.field1264) {
               return method1457(0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, 0, var4, var3, this);
            }

            return method1456(((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, 0, var4, var3, this);
         }

         if(class59.field1264) {
            return method1461(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1318, this.field1332, 0, var4, var3, this, this.field1323, var5);
         }

         return method1509(0, 0, ((class65)super.field1334).field1304, var1, this.field1319, var2, this.field1322, 0, var4, var3, this, this.field1323, var5);
      }
   }

   @ObfuscatedName("aw")
   boolean method1453() {
      int var1 = this.field1320;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1470(var1, this.field1321);
         var3 = method1489(var1, this.field1321);
      }

      if(this.field1322 == var1 && this.field1318 == var2 && this.field1332 == var3) {
         if(this.field1320 == Integer.MIN_VALUE) {
            this.field1320 = 0;
            this.field1332 = 0;
            this.field1318 = 0;
            this.field1322 = 0;
            this.unlink();
            return true;
         } else {
            this.method1524();
            return false;
         }
      } else {
         if(this.field1322 < var1) {
            this.field1331 = 1;
            this.field1329 = var1 - this.field1322;
         } else if(this.field1322 > var1) {
            this.field1331 = -1;
            this.field1329 = this.field1322 - var1;
         } else {
            this.field1331 = 0;
         }

         if(this.field1318 < var2) {
            this.field1328 = 1;
            if(this.field1329 == 0 || this.field1329 > var2 - this.field1318) {
               this.field1329 = var2 - this.field1318;
            }
         } else if(this.field1318 > var2) {
            this.field1328 = -1;
            if(this.field1329 == 0 || this.field1329 > this.field1318 - var2) {
               this.field1329 = this.field1318 - var2;
            }
         } else {
            this.field1328 = 0;
         }

         if(this.field1332 < var3) {
            this.field1330 = 1;
            if(this.field1329 == 0 || this.field1329 > var3 - this.field1332) {
               this.field1329 = var3 - this.field1332;
            }
         } else if(this.field1332 > var3) {
            this.field1330 = -1;
            if(this.field1329 == 0 || this.field1329 > this.field1332 - var3) {
               this.field1329 = this.field1332 - var3;
            }
         } else {
            this.field1330 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("au")
   static int method1454(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
      }

      var8.field1319 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ax")
   static int method1455(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field1319 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("al")
   static int method1456(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
      }

      var8.field1319 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   static int method1457(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field1319 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aa")
   static int method1458(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var14;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   static int method1459(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var15;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      var11.field1319 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   static int method1461(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var14;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var0 = (var15 << 8) + (var2[var1] - var15) * (var4 & 255);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      var11.field1319 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bo")
   static int method1464(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1318 += var9.field1328 * (var6 - var3);
      var9.field1332 += var9.field1330 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      var9.field1322 = var4 >> 2;
      var9.field1319 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bu")
   static int method1465(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1322 += var12.field1331 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1318 = var5 >> 2;
      var12.field1332 = var6 >> 2;
      var12.field1319 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("q")
   public synchronized void method1466(int var1) {
      this.method1433(var1 << 6, this.method1435());
   }

   @ObfuscatedName("be")
   static int method1467(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1322 -= var13.field1331 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var17;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1322 += var13.field1331 * var5;
      var13.field1318 = var6;
      var13.field1332 = var7;
      var13.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method1469(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1322 -= var13.field1331 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var16;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var17 = var2[var1 - 1];
         var0 = (var17 << 8) + (var2[var1] - var17) * (var4 & 255);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1322 += var13.field1331 * var5;
      var13.field1318 = var6;
      var13.field1332 = var7;
      var13.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("l")
   static int method1470(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   void method1481() {
      if(this.field1329 != 0) {
         if(this.field1320 == Integer.MIN_VALUE) {
            this.field1320 = 0;
         }

         this.field1329 = 0;
         this.method1524();
      }

   }

   @ObfuscatedName("g")
   static int method1489(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1495() {
      this.field1323 = (this.field1323 ^ this.field1323 >> 31) + (this.field1323 >>> 31);
      this.field1323 = -this.field1323;
   }

   @ObfuscatedName("bn")
   static int method1504(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1322 += var12.field1331 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1318 = var5 >> 2;
      var12.field1332 = var6 >> 2;
      var12.field1319 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1507(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1318 += var9.field1328 * (var6 - var3);
      var9.field1332 += var9.field1330 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      var9.field1322 = var4 >> 2;
      var9.field1319 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   static int method1509(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var13;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var13 = var5++;
         var3[var13] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var13 = var5++;
         var3[var13] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("bs")
   static int method1518(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1318 -= var11.field1328 * var5;
      var11.field1332 -= var11.field1330 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var15;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1318 += var11.field1328 * var5;
      var11.field1332 += var11.field1330 * var5;
      var11.field1322 = var6;
      var11.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("h")
   void method1524() {
      this.field1322 = this.field1320;
      this.field1318 = method1470(this.field1320, this.field1321);
      this.field1332 = method1489(this.field1320, this.field1321);
   }

   @ObfuscatedName("by")
   static int method1525(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1318 -= var11.field1328 * var5;
      var11.field1332 -= var11.field1330 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var14;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var14 = var5++;
         var3[var14] += ((var15 << 8) + (var2[var1] - var15) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var14 = var5++;
         var3[var14] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1318 += var11.field1328 * var5;
      var11.field1332 += var11.field1330 * var5;
      var11.field1322 = var6;
      var11.field1319 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   public boolean method1528() {
      return this.field1319 < 0 || this.field1319 >= ((class65)super.field1334).field1304.length << 8;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1334 = var1;
      this.field1326 = var1.field1301;
      this.field1327 = var1.field1303;
      this.field1324 = var1.field1305;
      this.field1323 = var2;
      this.field1320 = var3;
      this.field1321 = 8192;
      this.field1319 = 0;
      this.method1524();
   }

   @ObfuscatedName("n")
   public synchronized void vmethod3873(int[] var1, int var2, int var3) {
      if(this.field1320 == 0 && this.field1329 == 0) {
         this.vmethod3874(var3);
      } else {
         class65 var4 = (class65)super.field1334;
         int var5 = this.field1326 << 8;
         int var6 = this.field1327 << 8;
         int var7 = var4.field1304.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1325 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1319 < 0) {
            if(this.field1323 <= 0) {
               this.method1481();
               this.unlink();
               return;
            }

            this.field1319 = 0;
         }

         if(this.field1319 >= var7) {
            if(this.field1323 >= 0) {
               this.method1481();
               this.unlink();
               return;
            }

            this.field1319 = var7 - 1;
         }

         if(this.field1325 < 0) {
            if(this.field1324) {
               if(this.field1323 < 0) {
                  var9 = this.method1452(var1, var2, var5, var3, var4.field1304[this.field1326]);
                  if(this.field1319 >= var5) {
                     return;
                  }

                  this.field1319 = var5 + var5 - 1 - this.field1319;
                  this.field1323 = -this.field1323;
               }

               while(true) {
                  var9 = this.method1451(var1, var9, var6, var3, var4.field1304[this.field1327 - 1]);
                  if(this.field1319 < var6) {
                     return;
                  }

                  this.field1319 = var6 + var6 - 1 - this.field1319;
                  this.field1323 = -this.field1323;
                  var9 = this.method1452(var1, var9, var5, var3, var4.field1304[this.field1326]);
                  if(this.field1319 >= var5) {
                     return;
                  }

                  this.field1319 = var5 + var5 - 1 - this.field1319;
                  this.field1323 = -this.field1323;
               }
            }

            if(this.field1323 < 0) {
               while(true) {
                  var9 = this.method1452(var1, var9, var5, var3, var4.field1304[this.field1327 - 1]);
                  if(this.field1319 >= var5) {
                     return;
                  }

                  this.field1319 = var6 - 1 - (var6 - 1 - this.field1319) % var8;
               }
            }

            while(true) {
               var9 = this.method1451(var1, var9, var6, var3, var4.field1304[this.field1326]);
               if(this.field1319 < var6) {
                  return;
               }

               this.field1319 = var5 + (this.field1319 - var5) % var8;
            }
         }

         if(this.field1325 > 0) {
            if(this.field1324) {
               label118: {
                  if(this.field1323 < 0) {
                     var9 = this.method1452(var1, var2, var5, var3, var4.field1304[this.field1326]);
                     if(this.field1319 >= var5) {
                        return;
                     }

                     this.field1319 = var5 + var5 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                     if(--this.field1325 == 0) {
                        break label118;
                     }
                  }

                  do {
                     var9 = this.method1451(var1, var9, var6, var3, var4.field1304[this.field1327 - 1]);
                     if(this.field1319 < var6) {
                        return;
                     }

                     this.field1319 = var6 + var6 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                     if(--this.field1325 == 0) {
                        break;
                     }

                     var9 = this.method1452(var1, var9, var5, var3, var4.field1304[this.field1326]);
                     if(this.field1319 >= var5) {
                        return;
                     }

                     this.field1319 = var5 + var5 - 1 - this.field1319;
                     this.field1323 = -this.field1323;
                  } while(--this.field1325 != 0);
               }
            } else {
               int var10;
               if(this.field1323 < 0) {
                  while(true) {
                     var9 = this.method1452(var1, var9, var5, var3, var4.field1304[this.field1327 - 1]);
                     if(this.field1319 >= var5) {
                        return;
                     }

                     var10 = (var6 - 1 - this.field1319) / var8;
                     if(var10 >= this.field1325) {
                        this.field1319 += var8 * this.field1325;
                        this.field1325 = 0;
                        break;
                     }

                     this.field1319 += var8 * var10;
                     this.field1325 -= var10;
                  }
               } else {
                  while(true) {
                     var9 = this.method1451(var1, var9, var6, var3, var4.field1304[this.field1326]);
                     if(this.field1319 < var6) {
                        return;
                     }

                     var10 = (this.field1319 - var5) / var8;
                     if(var10 >= this.field1325) {
                        this.field1319 -= var8 * this.field1325;
                        this.field1325 = 0;
                        break;
                     }

                     this.field1319 -= var8 * var10;
                     this.field1325 -= var10;
                  }
               }
            }
         }

         if(this.field1323 < 0) {
            this.method1452(var1, var9, 0, var3, 0);
            if(this.field1319 < 0) {
               this.field1319 = -1;
               this.method1481();
               this.unlink();
            }
         } else {
            this.method1451(var1, var9, var7, var3, 0);
            if(this.field1319 >= var7) {
               this.field1319 = var7;
               this.method1481();
               this.unlink();
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1561(int var1) {
      this.method1433(var1, this.method1435());
   }

   @ObfuscatedName("ai")
   public synchronized int method1566() {
      return this.field1323 < 0?-this.field1323:this.field1323;
   }
}
