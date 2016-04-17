import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class64 extends class66 {
   @ObfuscatedName("k")
   int field1255;
   @ObfuscatedName("d")
   int field1256;
   @ObfuscatedName("c")
   int field1257;
   @ObfuscatedName("z")
   int field1258;
   @ObfuscatedName("x")
   boolean field1259;
   @ObfuscatedName("a")
   int field1260;
   @ObfuscatedName("p")
   int field1261;
   @ObfuscatedName("q")
   int field1262;
   @ObfuscatedName("m")
   int field1263;
   @ObfuscatedName("e")
   int field1264;
   @ObfuscatedName("y")
   int field1265;
   @ObfuscatedName("r")
   int field1266;
   @ObfuscatedName("i")
   int field1267;
   @ObfuscatedName("t")
   int field1268;
   @ObfuscatedName("n")
   int field1269;

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1271 = var1;
      this.field1263 = var1.field1240;
      this.field1264 = var1.field1242;
      this.field1259 = var1.field1238;
      this.field1256 = var2;
      this.field1257 = var3;
      this.field1265 = var4;
      this.field1260 = 0;
      this.method1552();
   }

   @ObfuscatedName("am")
   int vmethod1573() {
      int var1 = this.field1255 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1262 == 0) {
         var1 -= var1 * this.field1260 / (((class62)super.field1271).field1239.length << 8);
      } else if(this.field1262 >= 0) {
         var1 -= var1 * this.field1263 / ((class62)super.field1271).field1239.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1271 = var1;
      this.field1263 = var1.field1240;
      this.field1264 = var1.field1242;
      this.field1259 = var1.field1238;
      this.field1256 = var2;
      this.field1257 = var3;
      this.field1265 = 8192;
      this.field1260 = 0;
      this.method1552();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass62;II)Lclass64;",
      garbageValue = "100"
   )
   public static class64 method1396(class62 var0, int var1, int var2) {
      return var0.field1239 != null && var0.field1239.length != 0?new class64(var0, (int)((long)var0.field1241 * 256L * (long)var1 / (long)(class40.field973 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("c")
   public static class64 method1397(class62 var0, int var1, int var2, int var3) {
      return var0.field1239 != null && var0.field1239.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("m")
   public synchronized void method1399(int var1) {
      this.field1262 = var1;
   }

   @ObfuscatedName("x")
   public synchronized void method1400(int var1) {
      this.method1528(var1 << 6, this.method1404());
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1401(int var1) {
      this.method1528(var1, this.method1404());
   }

   @ObfuscatedName("t")
   public synchronized int method1403() {
      return this.field1257 == Integer.MIN_VALUE?0:this.field1257;
   }

   @ObfuscatedName("n")
   public synchronized int method1404() {
      return this.field1265 < 0?-1:this.field1265;
   }

   @ObfuscatedName("u")
   public synchronized void method1405(int var1) {
      int var2 = ((class62)super.field1271).field1239.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1260 = var1;
   }

   @ObfuscatedName("by")
   static int method1406(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1266 -= var11.field1268 * var5;
      var11.field1261 -= var11.field1269 * var5;
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

      var11.field1266 += var11.field1268 * var5;
      var11.field1261 += var11.field1269 * var5;
      var11.field1255 = var6;
      var11.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("s")
   public synchronized void method1409(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1528(var2, var3);
      } else {
         int var4 = method1468(var2, var3);
         int var5 = method1428(var2, var3);
         if(this.field1266 == var4 && this.field1261 == var5) {
            this.field1258 = 0;
         } else {
            int var6 = var2 - this.field1255;
            if(this.field1255 - var2 > var6) {
               var6 = this.field1255 - var2;
            }

            if(var4 - this.field1266 > var6) {
               var6 = var4 - this.field1266;
            }

            if(this.field1266 - var4 > var6) {
               var6 = this.field1266 - var4;
            }

            if(var5 - this.field1261 > var6) {
               var6 = var5 - this.field1261;
            }

            if(this.field1261 - var5 > var6) {
               var6 = this.field1261 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1258 = var1;
            this.field1257 = var2;
            this.field1265 = var3;
            this.field1267 = (var2 - this.field1255) / var1;
            this.field1268 = (var4 - this.field1266) / var1;
            this.field1269 = (var5 - this.field1261) / var1;
         }
      }
   }

   @ObfuscatedName("az")
   public synchronized void method1410(int var1) {
      if(var1 == 0) {
         this.method1401(0);
         this.method3998();
      } else if(this.field1266 == 0 && this.field1261 == 0) {
         this.field1258 = 0;
         this.field1257 = 0;
         this.field1255 = 0;
         this.method3998();
      } else {
         int var2 = -this.field1255;
         if(this.field1255 > var2) {
            var2 = this.field1255;
         }

         if(-this.field1266 > var2) {
            var2 = -this.field1266;
         }

         if(this.field1266 > var2) {
            var2 = this.field1266;
         }

         if(-this.field1261 > var2) {
            var2 = -this.field1261;
         }

         if(this.field1261 > var2) {
            var2 = this.field1261;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1258 = var1;
         this.field1257 = Integer.MIN_VALUE;
         this.field1267 = -this.field1255 / var1;
         this.field1268 = -this.field1266 / var1;
         this.field1269 = -this.field1261 / var1;
      }
   }

   @ObfuscatedName("av")
   static int method1414(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1260 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("k")
   protected class66 vmethod3806() {
      return null;
   }

   @ObfuscatedName("r")
   protected class66 vmethod3797() {
      return null;
   }

   @ObfuscatedName("p")
   protected int vmethod3810() {
      return this.field1257 == 0 && this.field1258 == 0?0:1;
   }

   @ObfuscatedName("q")
   public synchronized void vmethod3796(int[] var1, int var2, int var3) {
      if(this.field1257 == 0 && this.field1258 == 0) {
         this.vmethod3800(var3);
      } else {
         class62 var4 = (class62)super.field1271;
         int var5 = this.field1263 << 8;
         int var6 = this.field1264 << 8;
         int var7 = var4.field1239.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1262 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1260 < 0) {
            if(this.field1256 <= 0) {
               this.method1521();
               this.method3998();
               return;
            }

            this.field1260 = 0;
         }

         if(this.field1260 >= var7) {
            if(this.field1256 >= 0) {
               this.method1521();
               this.method3998();
               return;
            }

            this.field1260 = var7 - 1;
         }

         if(this.field1262 < 0) {
            if(this.field1259) {
               if(this.field1256 < 0) {
                  var9 = this.method1443(var1, var2, var5, var3, var4.field1239[this.field1263]);
                  if(this.field1260 >= var5) {
                     return;
                  }

                  this.field1260 = var5 + var5 - 1 - this.field1260;
                  this.field1256 = -this.field1256;
               }

               while(true) {
                  var9 = this.method1525(var1, var9, var6, var3, var4.field1239[this.field1264 - 1]);
                  if(this.field1260 < var6) {
                     return;
                  }

                  this.field1260 = var6 + var6 - 1 - this.field1260;
                  this.field1256 = -this.field1256;
                  var9 = this.method1443(var1, var9, var5, var3, var4.field1239[this.field1263]);
                  if(this.field1260 >= var5) {
                     return;
                  }

                  this.field1260 = var5 + var5 - 1 - this.field1260;
                  this.field1256 = -this.field1256;
               }
            } else if(this.field1256 < 0) {
               while(true) {
                  var9 = this.method1443(var1, var9, var5, var3, var4.field1239[this.field1264 - 1]);
                  if(this.field1260 >= var5) {
                     return;
                  }

                  this.field1260 = var6 - 1 - (var6 - 1 - this.field1260) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1525(var1, var9, var6, var3, var4.field1239[this.field1263]);
                  if(this.field1260 < var6) {
                     return;
                  }

                  this.field1260 = var5 + (this.field1260 - var5) % var8;
               }
            }
         } else {
            if(this.field1262 > 0) {
               if(this.field1259) {
                  label188: {
                     if(this.field1256 < 0) {
                        var9 = this.method1443(var1, var2, var5, var3, var4.field1239[this.field1263]);
                        if(this.field1260 >= var5) {
                           return;
                        }

                        this.field1260 = var5 + var5 - 1 - this.field1260;
                        this.field1256 = -this.field1256;
                        if(--this.field1262 == 0) {
                           break label188;
                        }
                     }

                     do {
                        var9 = this.method1525(var1, var9, var6, var3, var4.field1239[this.field1264 - 1]);
                        if(this.field1260 < var6) {
                           return;
                        }

                        this.field1260 = var6 + var6 - 1 - this.field1260;
                        this.field1256 = -this.field1256;
                        if(--this.field1262 == 0) {
                           break;
                        }

                        var9 = this.method1443(var1, var9, var5, var3, var4.field1239[this.field1263]);
                        if(this.field1260 >= var5) {
                           return;
                        }

                        this.field1260 = var5 + var5 - 1 - this.field1260;
                        this.field1256 = -this.field1256;
                     } while(--this.field1262 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1256 < 0) {
                     while(true) {
                        var9 = this.method1443(var1, var9, var5, var3, var4.field1239[this.field1264 - 1]);
                        if(this.field1260 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1260) / var8;
                        if(var10 >= this.field1262) {
                           this.field1260 += var8 * this.field1262;
                           this.field1262 = 0;
                           break;
                        }

                        this.field1260 += var8 * var10;
                        this.field1262 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1525(var1, var9, var6, var3, var4.field1239[this.field1263]);
                        if(this.field1260 < var6) {
                           return;
                        }

                        var10 = (this.field1260 - var5) / var8;
                        if(var10 >= this.field1262) {
                           this.field1260 -= var8 * this.field1262;
                           this.field1262 = 0;
                           break;
                        }

                        this.field1260 -= var8 * var10;
                        this.field1262 -= var10;
                     }
                  }
               }
            }

            if(this.field1256 < 0) {
               this.method1443(var1, var9, 0, var3, 0);
               if(this.field1260 < 0) {
                  this.field1260 = -1;
                  this.method1521();
                  this.method3998();
               }
            } else {
               this.method1525(var1, var9, var7, var3, 0);
               if(this.field1260 >= var7) {
                  this.field1260 = var7;
                  this.method1521();
                  this.method3998();
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   public synchronized void vmethod3800(int var1) {
      if(this.field1258 > 0) {
         if(var1 >= this.field1258) {
            if(this.field1257 == Integer.MIN_VALUE) {
               this.field1257 = 0;
               this.field1261 = 0;
               this.field1266 = 0;
               this.field1255 = 0;
               this.method3998();
               var1 = this.field1258;
            }

            this.field1258 = 0;
            this.method1552();
         } else {
            this.field1255 += this.field1267 * var1;
            this.field1266 += this.field1268 * var1;
            this.field1261 += this.field1269 * var1;
            this.field1258 -= var1;
         }
      }

      class62 var2 = (class62)super.field1271;
      int var3 = this.field1263 << 8;
      int var4 = this.field1264 << 8;
      int var5 = var2.field1239.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1262 = 0;
      }

      if(this.field1260 < 0) {
         if(this.field1256 <= 0) {
            this.method1521();
            this.method3998();
            return;
         }

         this.field1260 = 0;
      }

      if(this.field1260 >= var5) {
         if(this.field1256 >= 0) {
            this.method1521();
            this.method3998();
            return;
         }

         this.field1260 = var5 - 1;
      }

      this.field1260 += this.field1256 * var1;
      if(this.field1262 < 0) {
         if(!this.field1259) {
            if(this.field1256 < 0) {
               if(this.field1260 >= var3) {
                  return;
               }

               this.field1260 = var4 - 1 - (var4 - 1 - this.field1260) % var6;
            } else {
               if(this.field1260 < var4) {
                  return;
               }

               this.field1260 = var3 + (this.field1260 - var3) % var6;
            }

         } else {
            if(this.field1256 < 0) {
               if(this.field1260 >= var3) {
                  return;
               }

               this.field1260 = var3 + var3 - 1 - this.field1260;
               this.field1256 = -this.field1256;
            }

            while(this.field1260 >= var4) {
               this.field1260 = var4 + var4 - 1 - this.field1260;
               this.field1256 = -this.field1256;
               if(this.field1260 >= var3) {
                  return;
               }

               this.field1260 = var3 + var3 - 1 - this.field1260;
               this.field1256 = -this.field1256;
            }

         }
      } else {
         if(this.field1262 > 0) {
            if(this.field1259) {
               label175: {
                  if(this.field1256 < 0) {
                     if(this.field1260 >= var3) {
                        return;
                     }

                     this.field1260 = var3 + var3 - 1 - this.field1260;
                     this.field1256 = -this.field1256;
                     if(--this.field1262 == 0) {
                        break label175;
                     }
                  }

                  do {
                     if(this.field1260 < var4) {
                        return;
                     }

                     this.field1260 = var4 + var4 - 1 - this.field1260;
                     this.field1256 = -this.field1256;
                     if(--this.field1262 == 0) {
                        break;
                     }

                     if(this.field1260 >= var3) {
                        return;
                     }

                     this.field1260 = var3 + var3 - 1 - this.field1260;
                     this.field1256 = -this.field1256;
                  } while(--this.field1262 != 0);
               }
            } else {
               int var7;
               if(this.field1256 < 0) {
                  if(this.field1260 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1260) / var6;
                  if(var7 < this.field1262) {
                     this.field1260 += var6 * var7;
                     this.field1262 -= var7;
                     return;
                  }

                  this.field1260 += var6 * this.field1262;
                  this.field1262 = 0;
               } else {
                  if(this.field1260 < var4) {
                     return;
                  }

                  var7 = (this.field1260 - var3) / var6;
                  if(var7 < this.field1262) {
                     this.field1260 -= var6 * var7;
                     this.field1262 -= var7;
                     return;
                  }

                  this.field1260 -= var6 * this.field1262;
                  this.field1262 = 0;
               }
            }
         }

         if(this.field1256 < 0) {
            if(this.field1260 < 0) {
               this.field1260 = -1;
               this.method1521();
               this.method3998();
            }
         } else if(this.field1260 >= var5) {
            this.field1260 = var5;
            this.method1521();
            this.method3998();
         }

      }
   }

   @ObfuscatedName("ap")
   static int method1424(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1260 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ak")
   static int method1425(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1260 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("as")
   static int method1426(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1260 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aa")
   static int method1427(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("w")
   static int method1428(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("aw")
   static int method1429(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   static int method1430(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1260 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bh")
   static int method1431(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1266 += var9.field1268 * (var6 - var3);
      var9.field1261 += var9.field1269 * (var6 - var3);

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

      var9.field1255 = var4 >> 2;
      var9.field1260 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bm")
   static int method1433(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1266 += var9.field1268 * (var6 - var3);
      var9.field1261 += var9.field1269 * (var6 - var3);

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

      var9.field1255 = var4 >> 2;
      var9.field1260 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ag")
   static int method1434(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1260 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bk")
   static int method1435(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1266 -= var11.field1268 * var5;
      var11.field1261 -= var11.field1269 * var5;
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

      var11.field1266 += var11.field1268 * var5;
      var11.field1261 += var11.field1269 * var5;
      var11.field1255 = var6;
      var11.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("ab")
   public boolean method1440() {
      return this.field1260 < 0 || this.field1260 >= ((class62)super.field1271).field1239.length << 8;
   }

   @ObfuscatedName("aj")
   int method1443(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1258 > 0) {
            int var6 = var2 + this.field1258;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1258 += var2;
            if(this.field1256 == -256 && (this.field1260 & 255) == 0) {
               if(class96.field1633) {
                  var2 = method1471(0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, this.field1268, this.field1269, 0, var6, var3, this);
               } else {
                  var2 = method1433(((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, this.field1267, 0, var6, var3, this);
               }
            } else if(class96.field1633) {
               var2 = method1513(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, this.field1268, this.field1269, 0, var6, var3, this, this.field1256, var5);
            } else {
               var2 = method1406(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, this.field1267, 0, var6, var3, this, this.field1256, var5);
            }

            this.field1258 -= var2;
            if(this.field1258 != 0) {
               return var2;
            }

            if(!this.method1500()) {
               continue;
            }

            return var4;
         }

         if(this.field1256 == -256 && (this.field1260 & 255) == 0) {
            if(class96.field1633) {
               return method1426(0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, 0, var4, var3, this);
            }

            return method1425(((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, 0, var4, var3, this);
         }

         if(class96.field1633) {
            return method1430(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, 0, var4, var3, this, this.field1256, var5);
         }

         return method1429(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, 0, var4, var3, this, this.field1256, var5);
      }
   }

   @ObfuscatedName("ae")
   public boolean method1451() {
      return this.field1258 != 0;
   }

   @ObfuscatedName("ac")
   public synchronized void method1465(int var1) {
      if(this.field1256 < 0) {
         this.field1256 = -var1;
      } else {
         this.field1256 = var1;
      }

   }

   @ObfuscatedName("a")
   static int method1468(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bl")
   static int method1471(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1255 += var12.field1267 * (var9 - var4);
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

      var12.field1266 = var5 >> 2;
      var12.field1261 = var6 >> 2;
      var12.field1260 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1481() {
      this.field1256 = (this.field1256 ^ this.field1256 >> 31) + (this.field1256 >>> 31);
      this.field1256 = -this.field1256;
   }

   @ObfuscatedName("bg")
   static int method1489(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1255 += var12.field1267 * (var9 - var4);
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

      var12.field1266 = var5 >> 2;
      var12.field1261 = var6 >> 2;
      var12.field1260 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("h")
   public synchronized void method1492(int var1, int var2) {
      this.method1409(var1, var2, this.method1404());
   }

   @ObfuscatedName("aq")
   boolean method1500() {
      int var1 = this.field1257;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1468(var1, this.field1265);
         var3 = method1428(var1, this.field1265);
      }

      if(this.field1255 == var1 && this.field1266 == var2 && this.field1261 == var3) {
         if(this.field1257 == Integer.MIN_VALUE) {
            this.field1257 = 0;
            this.field1261 = 0;
            this.field1266 = 0;
            this.field1255 = 0;
            this.method3998();
            return true;
         } else {
            this.method1552();
            return false;
         }
      } else {
         if(this.field1255 < var1) {
            this.field1267 = 1;
            this.field1258 = var1 - this.field1255;
         } else if(this.field1255 > var1) {
            this.field1267 = -1;
            this.field1258 = this.field1255 - var1;
         } else {
            this.field1267 = 0;
         }

         if(this.field1266 < var2) {
            this.field1268 = 1;
            if(this.field1258 == 0 || this.field1258 > var2 - this.field1266) {
               this.field1258 = var2 - this.field1266;
            }
         } else if(this.field1266 > var2) {
            this.field1268 = -1;
            if(this.field1258 == 0 || this.field1258 > this.field1266 - var2) {
               this.field1258 = this.field1266 - var2;
            }
         } else {
            this.field1268 = 0;
         }

         if(this.field1261 < var3) {
            this.field1269 = 1;
            if(this.field1258 == 0 || this.field1258 > var3 - this.field1261) {
               this.field1258 = var3 - this.field1261;
            }
         } else if(this.field1261 > var3) {
            this.field1269 = -1;
            if(this.field1258 == 0 || this.field1258 > this.field1261 - var3) {
               this.field1258 = this.field1261 - var3;
            }
         } else {
            this.field1269 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("bc")
   static int method1513(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1255 -= var13.field1267 * var5;
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
      var13.field1255 += var13.field1267 * var5;
      var13.field1266 = var6;
      var13.field1261 = var7;
      var13.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("j")
   void method1521() {
      if(this.field1258 != 0) {
         if(this.field1257 == Integer.MIN_VALUE) {
            this.field1257 = 0;
         }

         this.field1258 = 0;
         this.method1552();
      }

   }

   @ObfuscatedName("au")
   int method1525(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1258 > 0) {
            int var6 = var2 + this.field1258;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1258 += var2;
            if(this.field1256 == 256 && (this.field1260 & 255) == 0) {
               if(class96.field1633) {
                  var2 = method1489(0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, this.field1268, this.field1269, 0, var6, var3, this);
               } else {
                  var2 = method1431(((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, this.field1267, 0, var6, var3, this);
               }
            } else if(class96.field1633) {
               var2 = method1550(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, this.field1268, this.field1269, 0, var6, var3, this, this.field1256, var5);
            } else {
               var2 = method1435(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, this.field1267, 0, var6, var3, this, this.field1256, var5);
            }

            this.field1258 -= var2;
            if(this.field1258 != 0) {
               return var2;
            }

            if(!this.method1500()) {
               continue;
            }

            return var4;
         }

         if(this.field1256 == 256 && (this.field1260 & 255) == 0) {
            if(class96.field1633) {
               return method1424(0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, 0, var4, var3, this);
            }

            return method1434(((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, 0, var4, var3, this);
         }

         if(class96.field1633) {
            return method1414(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1266, this.field1261, 0, var4, var3, this, this.field1256, var5);
         }

         return method1427(0, 0, ((class62)super.field1271).field1239, var1, this.field1260, var2, this.field1255, 0, var4, var3, this, this.field1256, var5);
      }
   }

   @ObfuscatedName("i")
   synchronized void method1528(int var1, int var2) {
      this.field1257 = var1;
      this.field1265 = var2;
      this.field1258 = 0;
      this.method1552();
   }

   @ObfuscatedName("at")
   public synchronized int method1538() {
      return this.field1256 < 0?-this.field1256:this.field1256;
   }

   @ObfuscatedName("bi")
   static int method1550(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1255 -= var13.field1267 * var5;
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
      var13.field1255 += var13.field1267 * var5;
      var13.field1266 = var6;
      var13.field1261 = var7;
      var13.field1260 = var4;
      return var5;
   }

   @ObfuscatedName("y")
   void method1552() {
      this.field1255 = this.field1257;
      this.field1266 = method1468(this.field1257, this.field1265);
      this.field1261 = method1428(this.field1257, this.field1265);
   }
}
