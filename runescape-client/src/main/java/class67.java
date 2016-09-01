import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class67 extends class69 {
   @ObfuscatedName("v")
   int field1291;
   @ObfuscatedName("r")
   int field1292;
   @ObfuscatedName("j")
   int field1293;
   @ObfuscatedName("z")
   int field1294;
   @ObfuscatedName("i")
   int field1295;
   @ObfuscatedName("t")
   int field1296;
   @ObfuscatedName("l")
   int field1297;
   @ObfuscatedName("x")
   int field1298;
   @ObfuscatedName("p")
   int field1299;
   @ObfuscatedName("f")
   int field1300;
   @ObfuscatedName("d")
   boolean field1301;
   @ObfuscatedName("b")
   int field1302;
   @ObfuscatedName("q")
   int field1303;
   @ObfuscatedName("m")
   int field1304;
   @ObfuscatedName("g")
   int field1305;

   @ObfuscatedName("r")
   static int method1340(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   void method1341() {
      this.field1295 = this.field1293;
      this.field1302 = method1393(this.field1293, this.field1294);
      this.field1297 = method1340(this.field1293, this.field1294);
   }

   class67(class65 var1, int var2, int var3) {
      super.field1309 = var1;
      this.field1299 = var1.field1276;
      this.field1300 = var1.field1278;
      this.field1301 = var1.field1274;
      this.field1292 = var2;
      this.field1293 = var3;
      this.field1294 = 8192;
      this.field1298 = 0;
      this.method1341();
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1309 = var1;
      this.field1299 = var1.field1276;
      this.field1300 = var1.field1278;
      this.field1301 = var1.field1274;
      this.field1292 = var2;
      this.field1293 = var3;
      this.field1294 = var4;
      this.field1298 = 0;
      this.method1341();
   }

   @ObfuscatedName("j")
   public static class67 method1342(class65 var0, int var1, int var2) {
      return var0.field1275 != null && var0.field1275.length != 0?new class67(var0, (int)((long)var0.field1277 * 256L * (long)var1 / (long)(class59.field1228 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("z")
   public static class67 method1343(class65 var0, int var1, int var2, int var3) {
      return var0.field1275 != null && var0.field1275.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("f")
   public synchronized void method1345(int var1) {
      this.field1304 = var1;
   }

   @ObfuscatedName("v")
   public synchronized void method1346(int var1) {
      this.method1381(var1 << 6, this.method1471());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1350(int var1) {
      this.method1381(var1, this.method1471());
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1352() {
      this.field1292 = (this.field1292 ^ this.field1292 >> 31) + (this.field1292 >>> 31);
      this.field1292 = -this.field1292;
   }

   @ObfuscatedName("e")
   public synchronized void method1354(int var1, int var2) {
      this.method1355(var1, var2, this.method1471());
   }

   @ObfuscatedName("c")
   public synchronized void method1355(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1381(var2, var3);
      } else {
         int var4 = method1393(var2, var3);
         int var5 = method1340(var2, var3);
         if(this.field1302 == var4 && this.field1297 == var5) {
            this.field1291 = 0;
         } else {
            int var6 = var2 - this.field1295;
            if(this.field1295 - var2 > var6) {
               var6 = this.field1295 - var2;
            }

            if(var4 - this.field1302 > var6) {
               var6 = var4 - this.field1302;
            }

            if(this.field1302 - var4 > var6) {
               var6 = this.field1302 - var4;
            }

            if(var5 - this.field1297 > var6) {
               var6 = var5 - this.field1297;
            }

            if(this.field1297 - var5 > var6) {
               var6 = this.field1297 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1291 = var1;
            this.field1293 = var2;
            this.field1294 = var3;
            this.field1303 = (var2 - this.field1295) / var1;
            this.field1296 = (var4 - this.field1302) / var1;
            this.field1305 = (var5 - this.field1297) / var1;
         }
      }
   }

   @ObfuscatedName("aq")
   public synchronized void method1356(int var1) {
      if(var1 == 0) {
         this.method1350(0);
         this.unlink();
      } else if(this.field1302 == 0 && this.field1297 == 0) {
         this.field1291 = 0;
         this.field1293 = 0;
         this.field1295 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1295;
         if(this.field1295 > var2) {
            var2 = this.field1295;
         }

         if(-this.field1302 > var2) {
            var2 = -this.field1302;
         }

         if(this.field1302 > var2) {
            var2 = this.field1302;
         }

         if(-this.field1297 > var2) {
            var2 = -this.field1297;
         }

         if(this.field1297 > var2) {
            var2 = this.field1297;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1291 = var1;
         this.field1293 = Integer.MIN_VALUE;
         this.field1303 = -this.field1295 / var1;
         this.field1296 = -this.field1302 / var1;
         this.field1305 = -this.field1297 / var1;
      }
   }

   @ObfuscatedName("ax")
   public synchronized void method1357(int var1) {
      if(this.field1292 < 0) {
         this.field1292 = -var1;
      } else {
         this.field1292 = var1;
      }

   }

   @ObfuscatedName("aw")
   static int method1358(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1298 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   public boolean method1359() {
      return this.field1298 < 0 || this.field1298 >= ((class65)super.field1309).field1275.length << 8;
   }

   @ObfuscatedName("ab")
   public boolean method1360() {
      return this.field1291 != 0;
   }

   @ObfuscatedName("m")
   protected int vmethod3747() {
      return this.field1293 == 0 && this.field1291 == 0?0:1;
   }

   @ObfuscatedName("p")
   public synchronized void vmethod3748(int[] var1, int var2, int var3) {
      if(this.field1293 == 0 && this.field1291 == 0) {
         this.vmethod3749(var3);
      } else {
         class65 var4 = (class65)super.field1309;
         int var5 = this.field1299 << 8;
         int var6 = this.field1300 << 8;
         int var7 = var4.field1275.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1304 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1298 < 0) {
            if(this.field1292 <= 0) {
               this.method1465();
               this.unlink();
               return;
            }

            this.field1298 = 0;
         }

         if(this.field1298 >= var7) {
            if(this.field1292 >= 0) {
               this.method1465();
               this.unlink();
               return;
            }

            this.field1298 = var7 - 1;
         }

         if(this.field1304 < 0) {
            if(this.field1301) {
               if(this.field1292 < 0) {
                  var9 = this.method1437(var1, var2, var5, var3, var4.field1275[this.field1299]);
                  if(this.field1298 >= var5) {
                     return;
                  }

                  this.field1298 = var5 + var5 - 1 - this.field1298;
                  this.field1292 = -this.field1292;
               }

               while(true) {
                  var9 = this.method1366(var1, var9, var6, var3, var4.field1275[this.field1300 - 1]);
                  if(this.field1298 < var6) {
                     return;
                  }

                  this.field1298 = var6 + var6 - 1 - this.field1298;
                  this.field1292 = -this.field1292;
                  var9 = this.method1437(var1, var9, var5, var3, var4.field1275[this.field1299]);
                  if(this.field1298 >= var5) {
                     return;
                  }

                  this.field1298 = var5 + var5 - 1 - this.field1298;
                  this.field1292 = -this.field1292;
               }
            } else if(this.field1292 < 0) {
               while(true) {
                  var9 = this.method1437(var1, var9, var5, var3, var4.field1275[this.field1300 - 1]);
                  if(this.field1298 >= var5) {
                     return;
                  }

                  this.field1298 = var6 - 1 - (var6 - 1 - this.field1298) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1366(var1, var9, var6, var3, var4.field1275[this.field1299]);
                  if(this.field1298 < var6) {
                     return;
                  }

                  this.field1298 = var5 + (this.field1298 - var5) % var8;
               }
            }
         } else {
            if(this.field1304 > 0) {
               if(this.field1301) {
                  label178: {
                     if(this.field1292 < 0) {
                        var9 = this.method1437(var1, var2, var5, var3, var4.field1275[this.field1299]);
                        if(this.field1298 >= var5) {
                           return;
                        }

                        this.field1298 = var5 + var5 - 1 - this.field1298;
                        this.field1292 = -this.field1292;
                        if(--this.field1304 == 0) {
                           break label178;
                        }
                     }

                     do {
                        var9 = this.method1366(var1, var9, var6, var3, var4.field1275[this.field1300 - 1]);
                        if(this.field1298 < var6) {
                           return;
                        }

                        this.field1298 = var6 + var6 - 1 - this.field1298;
                        this.field1292 = -this.field1292;
                        if(--this.field1304 == 0) {
                           break;
                        }

                        var9 = this.method1437(var1, var9, var5, var3, var4.field1275[this.field1299]);
                        if(this.field1298 >= var5) {
                           return;
                        }

                        this.field1298 = var5 + var5 - 1 - this.field1298;
                        this.field1292 = -this.field1292;
                     } while(--this.field1304 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1292 < 0) {
                     while(true) {
                        var9 = this.method1437(var1, var9, var5, var3, var4.field1275[this.field1300 - 1]);
                        if(this.field1298 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1298) / var8;
                        if(var10 >= this.field1304) {
                           this.field1298 += var8 * this.field1304;
                           this.field1304 = 0;
                           break;
                        }

                        this.field1298 += var8 * var10;
                        this.field1304 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1366(var1, var9, var6, var3, var4.field1275[this.field1299]);
                        if(this.field1298 < var6) {
                           return;
                        }

                        var10 = (this.field1298 - var5) / var8;
                        if(var10 >= this.field1304) {
                           this.field1298 -= var8 * this.field1304;
                           this.field1304 = 0;
                           break;
                        }

                        this.field1298 -= var8 * var10;
                        this.field1304 -= var10;
                     }
                  }
               }
            }

            if(this.field1292 < 0) {
               this.method1437(var1, var9, 0, var3, 0);
               if(this.field1298 < 0) {
                  this.field1298 = -1;
                  this.method1465();
                  this.unlink();
               }
            } else {
               this.method1366(var1, var9, var7, var3, 0);
               if(this.field1298 >= var7) {
                  this.field1298 = var7;
                  this.method1465();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   public synchronized void vmethod3749(int var1) {
      if(this.field1291 > 0) {
         if(var1 >= this.field1291) {
            if(this.field1293 == Integer.MIN_VALUE) {
               this.field1293 = 0;
               this.field1297 = 0;
               this.field1302 = 0;
               this.field1295 = 0;
               this.unlink();
               var1 = this.field1291;
            }

            this.field1291 = 0;
            this.method1341();
         } else {
            this.field1295 += this.field1303 * var1;
            this.field1302 += this.field1296 * var1;
            this.field1297 += this.field1305 * var1;
            this.field1291 -= var1;
         }
      }

      class65 var2 = (class65)super.field1309;
      int var3 = this.field1299 << 8;
      int var4 = this.field1300 << 8;
      int var5 = var2.field1275.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1304 = 0;
      }

      if(this.field1298 < 0) {
         if(this.field1292 <= 0) {
            this.method1465();
            this.unlink();
            return;
         }

         this.field1298 = 0;
      }

      if(this.field1298 >= var5) {
         if(this.field1292 >= 0) {
            this.method1465();
            this.unlink();
            return;
         }

         this.field1298 = var5 - 1;
      }

      this.field1298 += this.field1292 * var1;
      if(this.field1304 < 0) {
         if(!this.field1301) {
            if(this.field1292 < 0) {
               if(this.field1298 >= var3) {
                  return;
               }

               this.field1298 = var4 - 1 - (var4 - 1 - this.field1298) % var6;
            } else {
               if(this.field1298 < var4) {
                  return;
               }

               this.field1298 = var3 + (this.field1298 - var3) % var6;
            }

         } else {
            if(this.field1292 < 0) {
               if(this.field1298 >= var3) {
                  return;
               }

               this.field1298 = var3 + var3 - 1 - this.field1298;
               this.field1292 = -this.field1292;
            }

            while(this.field1298 >= var4) {
               this.field1298 = var4 + var4 - 1 - this.field1298;
               this.field1292 = -this.field1292;
               if(this.field1298 >= var3) {
                  return;
               }

               this.field1298 = var3 + var3 - 1 - this.field1298;
               this.field1292 = -this.field1292;
            }

         }
      } else {
         if(this.field1304 > 0) {
            if(this.field1301) {
               label167: {
                  if(this.field1292 < 0) {
                     if(this.field1298 >= var3) {
                        return;
                     }

                     this.field1298 = var3 + var3 - 1 - this.field1298;
                     this.field1292 = -this.field1292;
                     if(--this.field1304 == 0) {
                        break label167;
                     }
                  }

                  do {
                     if(this.field1298 < var4) {
                        return;
                     }

                     this.field1298 = var4 + var4 - 1 - this.field1298;
                     this.field1292 = -this.field1292;
                     if(--this.field1304 == 0) {
                        break;
                     }

                     if(this.field1298 >= var3) {
                        return;
                     }

                     this.field1298 = var3 + var3 - 1 - this.field1298;
                     this.field1292 = -this.field1292;
                  } while(--this.field1304 != 0);
               }
            } else {
               int var7;
               if(this.field1292 < 0) {
                  if(this.field1298 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1298) / var6;
                  if(var7 < this.field1304) {
                     this.field1298 += var6 * var7;
                     this.field1304 -= var7;
                     return;
                  }

                  this.field1298 += var6 * this.field1304;
                  this.field1304 = 0;
               } else {
                  if(this.field1298 < var4) {
                     return;
                  }

                  var7 = (this.field1298 - var3) / var6;
                  if(var7 < this.field1304) {
                     this.field1298 -= var6 * var7;
                     this.field1304 -= var7;
                     return;
                  }

                  this.field1298 -= var6 * this.field1304;
                  this.field1304 = 0;
               }
            }
         }

         if(this.field1292 < 0) {
            if(this.field1298 < 0) {
               this.field1298 = -1;
               this.method1465();
               this.unlink();
            }
         } else if(this.field1298 >= var5) {
            this.field1298 = var5;
            this.method1465();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("at")
   int method1366(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1291 > 0) {
            int var6 = var2 + this.field1291;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1291 += var2;
            if(this.field1292 == 256 && (this.field1298 & 255) == 0) {
               if(class59.field1229) {
                  var2 = method1426(0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, this.field1296, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1438(((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, this.field1303, 0, var6, var3, this);
               }
            } else if(class59.field1229) {
               var2 = method1451(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, this.field1296, this.field1305, 0, var6, var3, this, this.field1292, var5);
            } else {
               var2 = method1423(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, this.field1303, 0, var6, var3, this, this.field1292, var5);
            }

            this.field1291 -= var2;
            if(this.field1291 != 0) {
               return var2;
            }

            if(!this.method1368()) {
               continue;
            }

            return var4;
         }

         if(this.field1292 == 256 && (this.field1298 & 255) == 0) {
            if(class59.field1229) {
               return method1370(0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, 0, var4, var3, this);
            }

            return method1369(((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, 0, var4, var3, this);
         }

         if(class59.field1229) {
            return method1374(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, 0, var4, var3, this, this.field1292, var5);
         }

         return method1373(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, 0, var4, var3, this, this.field1292, var5);
      }
   }

   @ObfuscatedName("av")
   static int method1367(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("ad")
   boolean method1368() {
      int var1 = this.field1293;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1393(var1, this.field1294);
         var3 = method1340(var1, this.field1294);
      }

      if(this.field1295 == var1 && this.field1302 == var2 && this.field1297 == var3) {
         if(this.field1293 == Integer.MIN_VALUE) {
            this.field1293 = 0;
            this.field1297 = 0;
            this.field1302 = 0;
            this.field1295 = 0;
            this.unlink();
            return true;
         } else {
            this.method1341();
            return false;
         }
      } else {
         if(this.field1295 < var1) {
            this.field1303 = 1;
            this.field1291 = var1 - this.field1295;
         } else if(this.field1295 > var1) {
            this.field1303 = -1;
            this.field1291 = this.field1295 - var1;
         } else {
            this.field1303 = 0;
         }

         if(this.field1302 < var2) {
            this.field1296 = 1;
            if(this.field1291 == 0 || this.field1291 > var2 - this.field1302) {
               this.field1291 = var2 - this.field1302;
            }
         } else if(this.field1302 > var2) {
            this.field1296 = -1;
            if(this.field1291 == 0 || this.field1291 > this.field1302 - var2) {
               this.field1291 = this.field1302 - var2;
            }
         } else {
            this.field1296 = 0;
         }

         if(this.field1297 < var3) {
            this.field1305 = 1;
            if(this.field1291 == 0 || this.field1291 > var3 - this.field1297) {
               this.field1291 = var3 - this.field1297;
            }
         } else if(this.field1297 > var3) {
            this.field1305 = -1;
            if(this.field1291 == 0 || this.field1291 > this.field1297 - var3) {
               this.field1291 = this.field1297 - var3;
            }
         } else {
            this.field1305 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("am")
   static int method1369(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1298 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ac")
   static int method1370(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1298 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("g")
   public synchronized int method1371() {
      return this.field1293 == Integer.MIN_VALUE?0:this.field1293;
   }

   @ObfuscatedName("ak")
   static int method1372(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1298 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ar")
   static int method1373(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   static int method1374(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1298 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aj")
   static int method1376(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1298 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ae")
   static int method1379(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1302 += var9.field1296 * (var6 - var3);
      var9.field1297 += var9.field1305 * (var6 - var3);

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

      var9.field1295 = var4 >> 2;
      var9.field1298 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("t")
   synchronized void method1381(int var1, int var2) {
      this.field1293 = var1;
      this.field1294 = var2;
      this.field1291 = 0;
      this.method1341();
   }

   @ObfuscatedName("bg")
   static int method1384(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1295 -= var13.field1303 * var5;
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
      var13.field1295 += var13.field1303 * var5;
      var13.field1302 = var6;
      var13.field1297 = var7;
      var13.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("h")
   public synchronized void method1387(int var1) {
      int var2 = ((class65)super.field1309).field1275.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1298 = var1;
   }

   @ObfuscatedName("x")
   static int method1393(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("az")
   public synchronized int method1395() {
      return this.field1292 < 0?-this.field1292:this.field1292;
   }

   @ObfuscatedName("b")
   protected class69 vmethod3753() {
      return null;
   }

   @ObfuscatedName("bf")
   static int method1408(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1295 += var12.field1303 * (var9 - var4);
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

      var12.field1302 = var5 >> 2;
      var12.field1297 = var6 >> 2;
      var12.field1298 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bx")
   static int method1423(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1302 -= var11.field1296 * var5;
      var11.field1297 -= var11.field1305 * var5;
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

      var11.field1302 += var11.field1296 * var5;
      var11.field1297 += var11.field1305 * var5;
      var11.field1295 = var6;
      var11.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("ai")
   static int method1426(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1295 += var12.field1303 * (var9 - var4);
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

      var12.field1302 = var5 >> 2;
      var12.field1297 = var6 >> 2;
      var12.field1298 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("l")
   protected class69 vmethod3746() {
      return null;
   }

   @ObfuscatedName("ay")
   int method1437(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1291 > 0) {
            int var6 = var2 + this.field1291;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1291 += var2;
            if(this.field1292 == -256 && (this.field1298 & 255) == 0) {
               if(class59.field1229) {
                  var2 = method1408(0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, this.field1296, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1379(((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, this.field1303, 0, var6, var3, this);
               }
            } else if(class59.field1229) {
               var2 = method1384(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, this.field1296, this.field1305, 0, var6, var3, this, this.field1292, var5);
            } else {
               var2 = method1466(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, this.field1303, 0, var6, var3, this, this.field1292, var5);
            }

            this.field1291 -= var2;
            if(this.field1291 != 0) {
               return var2;
            }

            if(!this.method1368()) {
               continue;
            }

            return var4;
         }

         if(this.field1292 == -256 && (this.field1298 & 255) == 0) {
            if(class59.field1229) {
               return method1372(0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, 0, var4, var3, this);
            }

            return method1358(((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, 0, var4, var3, this);
         }

         if(class59.field1229) {
            return method1376(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1302, this.field1297, 0, var4, var3, this, this.field1292, var5);
         }

         return method1367(0, 0, ((class65)super.field1309).field1275, var1, this.field1298, var2, this.field1295, 0, var4, var3, this, this.field1292, var5);
      }
   }

   @ObfuscatedName("al")
   static int method1438(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1302 += var9.field1296 * (var6 - var3);
      var9.field1297 += var9.field1305 * (var6 - var3);

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

      var9.field1295 = var4 >> 2;
      var9.field1298 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bh")
   static int method1451(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1295 -= var13.field1303 * var5;
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
      var13.field1295 += var13.field1303 * var5;
      var13.field1302 = var6;
      var13.field1297 = var7;
      var13.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   int vmethod1493() {
      int var1 = this.field1295 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1304 == 0) {
         var1 -= var1 * this.field1298 / (((class65)super.field1309).field1275.length << 8);
      } else if(this.field1304 >= 0) {
         var1 -= var1 * this.field1299 / ((class65)super.field1309).field1275.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("a")
   void method1465() {
      if(this.field1291 != 0) {
         if(this.field1293 == Integer.MIN_VALUE) {
            this.field1293 = 0;
         }

         this.field1291 = 0;
         this.method1341();
      }

   }

   @ObfuscatedName("bw")
   static int method1466(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1302 -= var11.field1296 * var5;
      var11.field1297 -= var11.field1305 * var5;
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

      var11.field1302 += var11.field1296 * var5;
      var11.field1297 += var11.field1305 * var5;
      var11.field1295 = var6;
      var11.field1298 = var4;
      return var5;
   }

   @ObfuscatedName("s")
   public synchronized int method1471() {
      return this.field1294 < 0?-1:this.field1294;
   }
}
