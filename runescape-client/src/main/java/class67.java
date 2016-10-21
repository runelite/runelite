import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class67 extends class69 {
   @ObfuscatedName("e")
   int field1294;
   @ObfuscatedName("n")
   int field1295;
   @ObfuscatedName("i")
   int field1296;
   @ObfuscatedName("t")
   int field1297;
   @ObfuscatedName("v")
   int field1298;
   @ObfuscatedName("f")
   int field1299;
   @ObfuscatedName("m")
   int field1300;
   @ObfuscatedName("k")
   int field1301;
   @ObfuscatedName("c")
   int field1302;
   @ObfuscatedName("l")
   int field1303;
   @ObfuscatedName("h")
   boolean field1304;
   @ObfuscatedName("d")
   int field1305;
   @ObfuscatedName("u")
   int field1306;
   @ObfuscatedName("x")
   int field1307;
   @ObfuscatedName("b")
   int field1308;

   @ObfuscatedName("e")
   static int method1352(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("a")
   public synchronized void method1353(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1361(var2, var3);
      } else {
         int var4 = method1463(var2, var3);
         int var5 = method1352(var2, var3);
         if(this.field1308 == var4 && this.field1300 == var5) {
            this.field1296 = 0;
         } else {
            int var6 = var2 - this.field1298;
            if(this.field1298 - var2 > var6) {
               var6 = this.field1298 - var2;
            }

            if(var4 - this.field1308 > var6) {
               var6 = var4 - this.field1308;
            }

            if(this.field1308 - var4 > var6) {
               var6 = this.field1308 - var4;
            }

            if(var5 - this.field1300 > var6) {
               var6 = var5 - this.field1300;
            }

            if(this.field1300 - var5 > var6) {
               var6 = this.field1300 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1296 = var1;
            this.field1295 = var2;
            this.field1297 = var3;
            this.field1306 = (var2 - this.field1298) / var1;
            this.field1307 = (var4 - this.field1308) / var1;
            this.field1305 = (var5 - this.field1300) / var1;
         }
      }
   }

   class67(class65 var1, int var2, int var3) {
      super.field1312 = var1;
      this.field1302 = var1.field1277;
      this.field1303 = var1.field1280;
      this.field1304 = var1.field1281;
      this.field1294 = var2;
      this.field1295 = var3;
      this.field1297 = 8192;
      this.field1299 = 0;
      this.method1357();
   }

   @ObfuscatedName("av")
   static int method1354(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1299 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("n")
   public static class67 method1355(class65 var0, int var1, int var2) {
      return var0.field1278 != null && var0.field1278.length != 0?new class67(var0, (int)((long)var0.field1279 * 256L * (long)var1 / (long)(class59.field1235 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("t")
   public static class67 method1356(class65 var0, int var1, int var2, int var3) {
      return var0.field1278 != null && var0.field1278.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("v")
   void method1357() {
      this.field1298 = this.field1295;
      this.field1308 = method1463(this.field1295, this.field1297);
      this.field1300 = method1352(this.field1295, this.field1297);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1358() {
      this.field1294 = (this.field1294 ^ this.field1294 >> 31) + (this.field1294 >>> 31);
      this.field1294 = -this.field1294;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1360(int var1) {
      this.method1361(var1, this.method1363());
   }

   @ObfuscatedName("u")
   synchronized void method1361(int var1, int var2) {
      this.field1295 = var1;
      this.field1297 = var2;
      this.field1296 = 0;
      this.method1357();
   }

   @ObfuscatedName("x")
   public synchronized int method1362() {
      return this.field1295 == Integer.MIN_VALUE?0:this.field1295;
   }

   @ObfuscatedName("d")
   public synchronized int method1363() {
      return this.field1297 < 0?-1:this.field1297;
   }

   @ObfuscatedName("o")
   public synchronized void method1364(int var1) {
      int var2 = ((class65)super.field1312).field1278.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1299 = var1;
   }

   @ObfuscatedName("ag")
   static int method1366(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1299 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ab")
   static int method1369(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1299 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("p")
   public synchronized void method1370(int var1) {
      if(this.field1294 < 0) {
         this.field1294 = -var1;
      } else {
         this.field1294 = var1;
      }

   }

   @ObfuscatedName("y")
   public synchronized int method1371() {
      return this.field1294 < 0?-this.field1294:this.field1294;
   }

   @ObfuscatedName("s")
   public boolean method1372() {
      return this.field1299 < 0 || this.field1299 >= ((class65)super.field1312).field1278.length << 8;
   }

   @ObfuscatedName("g")
   public boolean method1373() {
      return this.field1296 != 0;
   }

   @ObfuscatedName("k")
   protected int vmethod3778() {
      return this.field1295 == 0 && this.field1296 == 0?0:1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod3796(int[] var1, int var2, int var3) {
      if(this.field1295 == 0 && this.field1296 == 0) {
         this.vmethod3780(var3);
      } else {
         class65 var4 = (class65)super.field1312;
         int var5 = this.field1302 << 8;
         int var6 = this.field1303 << 8;
         int var7 = var4.field1278.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1301 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1299 < 0) {
            if(this.field1294 <= 0) {
               this.method1487();
               this.unlink();
               return;
            }

            this.field1299 = 0;
         }

         if(this.field1299 >= var7) {
            if(this.field1294 >= 0) {
               this.method1487();
               this.unlink();
               return;
            }

            this.field1299 = var7 - 1;
         }

         if(this.field1301 < 0) {
            if(this.field1304) {
               if(this.field1294 < 0) {
                  var9 = this.method1380(var1, var2, var5, var3, var4.field1278[this.field1302]);
                  if(this.field1299 >= var5) {
                     return;
                  }

                  this.field1299 = var5 + var5 - 1 - this.field1299;
                  this.field1294 = -this.field1294;
               }

               while(true) {
                  var9 = this.method1507(var1, var9, var6, var3, var4.field1278[this.field1303 - 1]);
                  if(this.field1299 < var6) {
                     return;
                  }

                  this.field1299 = var6 + var6 - 1 - this.field1299;
                  this.field1294 = -this.field1294;
                  var9 = this.method1380(var1, var9, var5, var3, var4.field1278[this.field1302]);
                  if(this.field1299 >= var5) {
                     return;
                  }

                  this.field1299 = var5 + var5 - 1 - this.field1299;
                  this.field1294 = -this.field1294;
               }
            } else if(this.field1294 < 0) {
               while(true) {
                  var9 = this.method1380(var1, var9, var5, var3, var4.field1278[this.field1303 - 1]);
                  if(this.field1299 >= var5) {
                     return;
                  }

                  this.field1299 = var6 - 1 - (var6 - 1 - this.field1299) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1507(var1, var9, var6, var3, var4.field1278[this.field1302]);
                  if(this.field1299 < var6) {
                     return;
                  }

                  this.field1299 = var5 + (this.field1299 - var5) % var8;
               }
            }
         } else {
            if(this.field1301 > 0) {
               if(this.field1304) {
                  label178: {
                     if(this.field1294 < 0) {
                        var9 = this.method1380(var1, var2, var5, var3, var4.field1278[this.field1302]);
                        if(this.field1299 >= var5) {
                           return;
                        }

                        this.field1299 = var5 + var5 - 1 - this.field1299;
                        this.field1294 = -this.field1294;
                        if(--this.field1301 == 0) {
                           break label178;
                        }
                     }

                     do {
                        var9 = this.method1507(var1, var9, var6, var3, var4.field1278[this.field1303 - 1]);
                        if(this.field1299 < var6) {
                           return;
                        }

                        this.field1299 = var6 + var6 - 1 - this.field1299;
                        this.field1294 = -this.field1294;
                        if(--this.field1301 == 0) {
                           break;
                        }

                        var9 = this.method1380(var1, var9, var5, var3, var4.field1278[this.field1302]);
                        if(this.field1299 >= var5) {
                           return;
                        }

                        this.field1299 = var5 + var5 - 1 - this.field1299;
                        this.field1294 = -this.field1294;
                     } while(--this.field1301 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1294 < 0) {
                     while(true) {
                        var9 = this.method1380(var1, var9, var5, var3, var4.field1278[this.field1303 - 1]);
                        if(this.field1299 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1299) / var8;
                        if(var10 >= this.field1301) {
                           this.field1299 += var8 * this.field1301;
                           this.field1301 = 0;
                           break;
                        }

                        this.field1299 += var8 * var10;
                        this.field1301 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1507(var1, var9, var6, var3, var4.field1278[this.field1302]);
                        if(this.field1299 < var6) {
                           return;
                        }

                        var10 = (this.field1299 - var5) / var8;
                        if(var10 >= this.field1301) {
                           this.field1299 -= var8 * this.field1301;
                           this.field1301 = 0;
                           break;
                        }

                        this.field1299 -= var8 * var10;
                        this.field1301 -= var10;
                     }
                  }
               }
            }

            if(this.field1294 < 0) {
               this.method1380(var1, var9, 0, var3, 0);
               if(this.field1299 < 0) {
                  this.field1299 = -1;
                  this.method1487();
                  this.unlink();
               }
            } else {
               this.method1507(var1, var9, var7, var3, 0);
               if(this.field1299 >= var7) {
                  this.field1299 = var7;
                  this.method1487();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3780(int var1) {
      if(this.field1296 > 0) {
         if(var1 >= this.field1296) {
            if(this.field1295 == Integer.MIN_VALUE) {
               this.field1295 = 0;
               this.field1300 = 0;
               this.field1308 = 0;
               this.field1298 = 0;
               this.unlink();
               var1 = this.field1296;
            }

            this.field1296 = 0;
            this.method1357();
         } else {
            this.field1298 += this.field1306 * var1;
            this.field1308 += this.field1307 * var1;
            this.field1300 += this.field1305 * var1;
            this.field1296 -= var1;
         }
      }

      class65 var2 = (class65)super.field1312;
      int var3 = this.field1302 << 8;
      int var4 = this.field1303 << 8;
      int var5 = var2.field1278.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1301 = 0;
      }

      if(this.field1299 < 0) {
         if(this.field1294 <= 0) {
            this.method1487();
            this.unlink();
            return;
         }

         this.field1299 = 0;
      }

      if(this.field1299 >= var5) {
         if(this.field1294 >= 0) {
            this.method1487();
            this.unlink();
            return;
         }

         this.field1299 = var5 - 1;
      }

      this.field1299 += this.field1294 * var1;
      if(this.field1301 < 0) {
         if(!this.field1304) {
            if(this.field1294 < 0) {
               if(this.field1299 >= var3) {
                  return;
               }

               this.field1299 = var4 - 1 - (var4 - 1 - this.field1299) % var6;
            } else {
               if(this.field1299 < var4) {
                  return;
               }

               this.field1299 = var3 + (this.field1299 - var3) % var6;
            }

         } else {
            if(this.field1294 < 0) {
               if(this.field1299 >= var3) {
                  return;
               }

               this.field1299 = var3 + var3 - 1 - this.field1299;
               this.field1294 = -this.field1294;
            }

            while(this.field1299 >= var4) {
               this.field1299 = var4 + var4 - 1 - this.field1299;
               this.field1294 = -this.field1294;
               if(this.field1299 >= var3) {
                  return;
               }

               this.field1299 = var3 + var3 - 1 - this.field1299;
               this.field1294 = -this.field1294;
            }

         }
      } else {
         if(this.field1301 > 0) {
            if(this.field1304) {
               label168: {
                  if(this.field1294 < 0) {
                     if(this.field1299 >= var3) {
                        return;
                     }

                     this.field1299 = var3 + var3 - 1 - this.field1299;
                     this.field1294 = -this.field1294;
                     if(--this.field1301 == 0) {
                        break label168;
                     }
                  }

                  do {
                     if(this.field1299 < var4) {
                        return;
                     }

                     this.field1299 = var4 + var4 - 1 - this.field1299;
                     this.field1294 = -this.field1294;
                     if(--this.field1301 == 0) {
                        break;
                     }

                     if(this.field1299 >= var3) {
                        return;
                     }

                     this.field1299 = var3 + var3 - 1 - this.field1299;
                     this.field1294 = -this.field1294;
                  } while(--this.field1301 != 0);
               }
            } else {
               label200: {
                  int var7;
                  if(this.field1294 < 0) {
                     if(this.field1299 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1299) / var6;
                     if(var7 >= this.field1301) {
                        this.field1299 += var6 * this.field1301;
                        this.field1301 = 0;
                        break label200;
                     }

                     this.field1299 += var6 * var7;
                     this.field1301 -= var7;
                  } else {
                     if(this.field1299 < var4) {
                        return;
                     }

                     var7 = (this.field1299 - var3) / var6;
                     if(var7 >= this.field1301) {
                        this.field1299 -= var6 * this.field1301;
                        this.field1301 = 0;
                        break label200;
                     }

                     this.field1299 -= var6 * var7;
                     this.field1301 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1294 < 0) {
            if(this.field1299 < 0) {
               this.field1299 = -1;
               this.method1487();
               this.unlink();
            }
         } else if(this.field1299 >= var5) {
            this.field1299 = var5;
            this.method1487();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("ba")
   static int method1379(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1308 -= var11.field1307 * var5;
      var11.field1300 -= var11.field1305 * var5;
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

      var11.field1308 += var11.field1307 * var5;
      var11.field1300 += var11.field1305 * var5;
      var11.field1298 = var6;
      var11.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("ay")
   int method1380(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1296 > 0) {
            int var6 = var2 + this.field1296;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1296 += var2;
            if(this.field1294 == -256 && (this.field1299 & 255) == 0) {
               if(class59.field1219) {
                  var2 = method1393(0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, this.field1307, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1450(((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, this.field1306, 0, var6, var3, this);
               }
            } else if(class59.field1219) {
               var2 = method1475(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, this.field1307, this.field1305, 0, var6, var3, this, this.field1294, var5);
            } else {
               var2 = method1396(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, this.field1306, 0, var6, var3, this, this.field1294, var5);
            }

            this.field1296 -= var2;
            if(this.field1296 != 0) {
               return var2;
            }

            if(!this.method1508()) {
               continue;
            }

            return var4;
         }

         if(this.field1294 == -256 && (this.field1299 & 255) == 0) {
            if(class59.field1219) {
               return method1447(0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, 0, var4, var3, this);
            }

            return method1366(((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, 0, var4, var3, this);
         }

         if(class59.field1219) {
            return method1369(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, 0, var4, var3, this, this.field1294, var5);
         }

         return method1400(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, 0, var4, var3, this, this.field1294, var5);
      }
   }

   @ObfuscatedName("ax")
   static int method1382(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1299 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("w")
   public synchronized void method1384(int var1) {
      this.field1301 = var1;
   }

   @ObfuscatedName("r")
   public synchronized void method1385(int var1, int var2) {
      this.method1353(var1, var2, this.method1363());
   }

   @ObfuscatedName("bk")
   static int method1391(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1298 += var12.field1306 * (var9 - var4);
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

      var12.field1308 = var5 >> 2;
      var12.field1300 = var6 >> 2;
      var12.field1299 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bv")
   static int method1393(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1298 += var12.field1306 * (var9 - var4);
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

      var12.field1308 = var5 >> 2;
      var12.field1300 = var6 >> 2;
      var12.field1299 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("al")
   static int method1395(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1396(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1308 -= var11.field1307 * var5;
      var11.field1300 -= var11.field1305 * var5;
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

      var11.field1308 += var11.field1307 * var5;
      var11.field1300 += var11.field1305 * var5;
      var11.field1298 = var6;
      var11.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("an")
   static int method1400(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("b")
   protected class69 vmethod3776() {
      return null;
   }

   @ObfuscatedName("ad")
   int vmethod1511() {
      int var1 = this.field1298 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1301 == 0) {
         var1 -= var1 * this.field1299 / (((class65)super.field1312).field1278.length << 8);
      } else if(this.field1301 >= 0) {
         var1 -= var1 * this.field1302 / ((class65)super.field1312).field1278.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("h")
   public synchronized void method1424(int var1) {
      this.method1361(var1 << 6, this.method1363());
   }

   @ObfuscatedName("z")
   public synchronized void method1433(int var1) {
      if(var1 == 0) {
         this.method1360(0);
         this.unlink();
      } else if(this.field1308 == 0 && this.field1300 == 0) {
         this.field1296 = 0;
         this.field1295 = 0;
         this.field1298 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1298;
         if(this.field1298 > var2) {
            var2 = this.field1298;
         }

         if(-this.field1308 > var2) {
            var2 = -this.field1308;
         }

         if(this.field1308 > var2) {
            var2 = this.field1308;
         }

         if(-this.field1300 > var2) {
            var2 = -this.field1300;
         }

         if(this.field1300 > var2) {
            var2 = this.field1300;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1296 = var1;
         this.field1295 = Integer.MIN_VALUE;
         this.field1306 = -this.field1298 / var1;
         this.field1307 = -this.field1308 / var1;
         this.field1305 = -this.field1300 / var1;
      }
   }

   @ObfuscatedName("af")
   static int method1447(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1299 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bs")
   static int method1450(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1308 += var9.field1307 * (var6 - var3);
      var9.field1300 += var9.field1305 * (var6 - var3);

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

      var9.field1298 = var4 >> 2;
      var9.field1299 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("f")
   static int method1463(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bb")
   static int method1465(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1298 -= var13.field1306 * var5;
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
      var13.field1298 += var13.field1306 * var5;
      var13.field1308 = var6;
      var13.field1300 = var7;
      var13.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method1475(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1298 -= var13.field1306 * var5;
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
      var13.field1298 += var13.field1306 * var5;
      var13.field1308 = var6;
      var13.field1300 = var7;
      var13.field1299 = var4;
      return var5;
   }

   @ObfuscatedName("m")
   protected class69 vmethod3777() {
      return null;
   }

   @ObfuscatedName("q")
   void method1487() {
      if(this.field1296 != 0) {
         if(this.field1295 == Integer.MIN_VALUE) {
            this.field1295 = 0;
         }

         this.field1296 = 0;
         this.method1357();
      }

   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1312 = var1;
      this.field1302 = var1.field1277;
      this.field1303 = var1.field1280;
      this.field1304 = var1.field1281;
      this.field1294 = var2;
      this.field1295 = var3;
      this.field1297 = var4;
      this.field1299 = 0;
      this.method1357();
   }

   @ObfuscatedName("ak")
   static int method1495(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1299 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   static int method1500(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1308 += var9.field1307 * (var6 - var3);
      var9.field1300 += var9.field1305 * (var6 - var3);

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

      var9.field1298 = var4 >> 2;
      var9.field1299 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aj")
   int method1507(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1296 > 0) {
            int var6 = var2 + this.field1296;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1296 += var2;
            if(this.field1294 == 256 && (this.field1299 & 255) == 0) {
               if(class59.field1219) {
                  var2 = method1391(0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, this.field1307, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1500(((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, this.field1306, 0, var6, var3, this);
               }
            } else if(class59.field1219) {
               var2 = method1465(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, this.field1307, this.field1305, 0, var6, var3, this, this.field1294, var5);
            } else {
               var2 = method1379(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, this.field1306, 0, var6, var3, this, this.field1294, var5);
            }

            this.field1296 -= var2;
            if(this.field1296 != 0) {
               return var2;
            }

            if(!this.method1508()) {
               continue;
            }

            return var4;
         }

         if(this.field1294 == 256 && (this.field1299 & 255) == 0) {
            if(class59.field1219) {
               return method1495(0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, 0, var4, var3, this);
            }

            return method1382(((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, 0, var4, var3, this);
         }

         if(class59.field1219) {
            return method1354(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1308, this.field1300, 0, var4, var3, this, this.field1294, var5);
         }

         return method1395(0, 0, ((class65)super.field1312).field1278, var1, this.field1299, var2, this.field1298, 0, var4, var3, this, this.field1294, var5);
      }
   }

   @ObfuscatedName("ah")
   boolean method1508() {
      int var1 = this.field1295;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1463(var1, this.field1297);
         var3 = method1352(var1, this.field1297);
      }

      if(this.field1298 == var1 && this.field1308 == var2 && this.field1300 == var3) {
         if(this.field1295 == Integer.MIN_VALUE) {
            this.field1295 = 0;
            this.field1300 = 0;
            this.field1308 = 0;
            this.field1298 = 0;
            this.unlink();
            return true;
         } else {
            this.method1357();
            return false;
         }
      } else {
         if(this.field1298 < var1) {
            this.field1306 = 1;
            this.field1296 = var1 - this.field1298;
         } else if(this.field1298 > var1) {
            this.field1306 = -1;
            this.field1296 = this.field1298 - var1;
         } else {
            this.field1306 = 0;
         }

         if(this.field1308 < var2) {
            this.field1307 = 1;
            if(this.field1296 == 0 || this.field1296 > var2 - this.field1308) {
               this.field1296 = var2 - this.field1308;
            }
         } else if(this.field1308 > var2) {
            this.field1307 = -1;
            if(this.field1296 == 0 || this.field1296 > this.field1308 - var2) {
               this.field1296 = this.field1308 - var2;
            }
         } else {
            this.field1307 = 0;
         }

         if(this.field1300 < var3) {
            this.field1305 = 1;
            if(this.field1296 == 0 || this.field1296 > var3 - this.field1300) {
               this.field1296 = var3 - this.field1300;
            }
         } else if(this.field1300 > var3) {
            this.field1305 = -1;
            if(this.field1296 == 0 || this.field1296 > this.field1300 - var3) {
               this.field1296 = this.field1300 - var3;
            }
         } else {
            this.field1305 = 0;
         }

         return false;
      }
   }
}
