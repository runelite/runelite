import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class67 extends class69 {
   @ObfuscatedName("g")
   int field1301;
   @ObfuscatedName("h")
   int field1302;
   @ObfuscatedName("n")
   int field1303;
   @ObfuscatedName("j")
   int field1304;
   @ObfuscatedName("r")
   int field1305;
   @ObfuscatedName("u")
   int field1306;
   @ObfuscatedName("d")
   int field1307;
   @ObfuscatedName("l")
   int field1308;
   @ObfuscatedName("m")
   int field1309;
   @ObfuscatedName("i")
   int field1310;
   @ObfuscatedName("y")
   boolean field1311;
   @ObfuscatedName("s")
   int field1312;
   @ObfuscatedName("p")
   int field1313;
   @ObfuscatedName("v")
   int field1314;
   @ObfuscatedName("e")
   int field1315;

   @ObfuscatedName("y")
   public synchronized void vmethod3743(int var1) {
      if(this.field1312 > 0) {
         if(var1 >= this.field1312) {
            if(this.field1315 == Integer.MIN_VALUE) {
               this.field1315 = 0;
               this.field1307 = 0;
               this.field1306 = 0;
               this.field1303 = 0;
               this.unlink();
               var1 = this.field1312;
            }

            this.field1312 = 0;
            this.method1409();
         } else {
            this.field1303 += this.field1313 * var1;
            this.field1306 += this.field1314 * var1;
            this.field1307 += this.field1305 * var1;
            this.field1312 -= var1;
         }
      }

      class65 var2 = (class65)super.field1317;
      int var3 = this.field1309 << 8;
      int var4 = this.field1304 << 8;
      int var5 = var2.field1288.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1308 = 0;
      }

      if(this.field1310 < 0) {
         if(this.field1302 <= 0) {
            this.method1425();
            this.unlink();
            return;
         }

         this.field1310 = 0;
      }

      if(this.field1310 >= var5) {
         if(this.field1302 >= 0) {
            this.method1425();
            this.unlink();
            return;
         }

         this.field1310 = var5 - 1;
      }

      this.field1310 += this.field1302 * var1;
      if(this.field1308 < 0) {
         if(!this.field1311) {
            if(this.field1302 < 0) {
               if(this.field1310 >= var3) {
                  return;
               }

               this.field1310 = var4 - 1 - (var4 - 1 - this.field1310) % var6;
            } else {
               if(this.field1310 < var4) {
                  return;
               }

               this.field1310 = var3 + (this.field1310 - var3) % var6;
            }

         } else {
            if(this.field1302 < 0) {
               if(this.field1310 >= var3) {
                  return;
               }

               this.field1310 = var3 + var3 - 1 - this.field1310;
               this.field1302 = -this.field1302;
            }

            while(this.field1310 >= var4) {
               this.field1310 = var4 + var4 - 1 - this.field1310;
               this.field1302 = -this.field1302;
               if(this.field1310 >= var3) {
                  return;
               }

               this.field1310 = var3 + var3 - 1 - this.field1310;
               this.field1302 = -this.field1302;
            }

         }
      } else {
         if(this.field1308 > 0) {
            if(this.field1311) {
               label167: {
                  if(this.field1302 < 0) {
                     if(this.field1310 >= var3) {
                        return;
                     }

                     this.field1310 = var3 + var3 - 1 - this.field1310;
                     this.field1302 = -this.field1302;
                     if(--this.field1308 == 0) {
                        break label167;
                     }
                  }

                  do {
                     if(this.field1310 < var4) {
                        return;
                     }

                     this.field1310 = var4 + var4 - 1 - this.field1310;
                     this.field1302 = -this.field1302;
                     if(--this.field1308 == 0) {
                        break;
                     }

                     if(this.field1310 >= var3) {
                        return;
                     }

                     this.field1310 = var3 + var3 - 1 - this.field1310;
                     this.field1302 = -this.field1302;
                  } while(--this.field1308 != 0);
               }
            } else {
               int var7;
               if(this.field1302 < 0) {
                  if(this.field1310 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1310) / var6;
                  if(var7 < this.field1308) {
                     this.field1310 += var6 * var7;
                     this.field1308 -= var7;
                     return;
                  }

                  this.field1310 += var6 * this.field1308;
                  this.field1308 = 0;
               } else {
                  if(this.field1310 < var4) {
                     return;
                  }

                  var7 = (this.field1310 - var3) / var6;
                  if(var7 < this.field1308) {
                     this.field1310 -= var6 * var7;
                     this.field1308 -= var7;
                     return;
                  }

                  this.field1310 -= var6 * this.field1308;
                  this.field1308 = 0;
               }
            }
         }

         if(this.field1302 < 0) {
            if(this.field1310 < 0) {
               this.field1310 = -1;
               this.method1425();
               this.unlink();
            }
         } else if(this.field1310 >= var5) {
            this.field1310 = var5;
            this.method1425();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("v")
   synchronized void method1345(int var1, int var2) {
      this.field1315 = var1;
      this.field1301 = var2;
      this.field1312 = 0;
      this.method1409();
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1317 = var1;
      this.field1309 = var1.field1286;
      this.field1304 = var1.field1287;
      this.field1311 = var1.field1284;
      this.field1302 = var2;
      this.field1315 = var3;
      this.field1301 = var4;
      this.field1310 = 0;
      this.method1409();
   }

   @ObfuscatedName("e")
   public static class67 method1347(class65 var0, int var1, int var2) {
      return var0.field1288 != null && var0.field1288.length != 0?new class67(var0, (int)((long)var0.field1285 * 256L * (long)var1 / (long)(class59.field1239 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("g")
   public static class67 method1348(class65 var0, int var1, int var2, int var3) {
      return var0.field1288 != null && var0.field1288.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ap")
   static int method1349(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1310 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ag")
   public boolean method1350() {
      return this.field1310 < 0 || this.field1310 >= ((class65)super.field1317).field1288.length << 8;
   }

   @ObfuscatedName("s")
   public synchronized void method1351(int var1) {
      this.method1345(var1 << 6, this.method1491());
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1352(int var1) {
      this.method1345(var1, this.method1491());
   }

   @ObfuscatedName("r")
   public synchronized int method1354() {
      return this.field1315 == Integer.MIN_VALUE?0:this.field1315;
   }

   @ObfuscatedName("w")
   public synchronized void method1356(int var1) {
      int var2 = ((class65)super.field1317).field1288.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1310 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1357() {
      this.field1302 = (this.field1302 ^ this.field1302 >> 31) + (this.field1302 >>> 31);
      this.field1302 = -this.field1302;
   }

   @ObfuscatedName("bc")
   static int method1359(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1306 += var9.field1314 * (var6 - var3);
      var9.field1307 += var9.field1305 * (var6 - var3);

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

      var9.field1303 = var4 >> 2;
      var9.field1310 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("q")
   public synchronized void method1360(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1345(var2, var3);
      } else {
         int var4 = method1370(var2, var3);
         int var5 = method1422(var2, var3);
         if(this.field1306 == var4 && this.field1307 == var5) {
            this.field1312 = 0;
         } else {
            int var6 = var2 - this.field1303;
            if(this.field1303 - var2 > var6) {
               var6 = this.field1303 - var2;
            }

            if(var4 - this.field1306 > var6) {
               var6 = var4 - this.field1306;
            }

            if(this.field1306 - var4 > var6) {
               var6 = this.field1306 - var4;
            }

            if(var5 - this.field1307 > var6) {
               var6 = var5 - this.field1307;
            }

            if(this.field1307 - var5 > var6) {
               var6 = this.field1307 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1312 = var1;
            this.field1315 = var2;
            this.field1301 = var3;
            this.field1313 = (var2 - this.field1303) / var1;
            this.field1314 = (var4 - this.field1306) / var1;
            this.field1305 = (var5 - this.field1307) / var1;
         }
      }
   }

   @ObfuscatedName("o")
   public synchronized void method1361(int var1) {
      if(var1 == 0) {
         this.method1352(0);
         this.unlink();
      } else if(this.field1306 == 0 && this.field1307 == 0) {
         this.field1312 = 0;
         this.field1315 = 0;
         this.field1303 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1303;
         if(this.field1303 > var2) {
            var2 = this.field1303;
         }

         if(-this.field1306 > var2) {
            var2 = -this.field1306;
         }

         if(this.field1306 > var2) {
            var2 = this.field1306;
         }

         if(-this.field1307 > var2) {
            var2 = -this.field1307;
         }

         if(this.field1307 > var2) {
            var2 = this.field1307;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1312 = var1;
         this.field1315 = Integer.MIN_VALUE;
         this.field1313 = -this.field1303 / var1;
         this.field1314 = -this.field1306 / var1;
         this.field1305 = -this.field1307 / var1;
      }
   }

   @ObfuscatedName("b")
   public synchronized int method1363() {
      return this.field1302 < 0?-this.field1302:this.field1302;
   }

   @ObfuscatedName("aw")
   public boolean method1365() {
      return this.field1312 != 0;
   }

   @ObfuscatedName("l")
   protected int vmethod3745() {
      return this.field1315 == 0 && this.field1312 == 0?0:1;
   }

   @ObfuscatedName("m")
   public synchronized void vmethod3746(int[] var1, int var2, int var3) {
      if(this.field1315 == 0 && this.field1312 == 0) {
         this.vmethod3743(var3);
      } else {
         class65 var4 = (class65)super.field1317;
         int var5 = this.field1309 << 8;
         int var6 = this.field1304 << 8;
         int var7 = var4.field1288.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1308 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1310 < 0) {
            if(this.field1302 <= 0) {
               this.method1425();
               this.unlink();
               return;
            }

            this.field1310 = 0;
         }

         if(this.field1310 >= var7) {
            if(this.field1302 >= 0) {
               this.method1425();
               this.unlink();
               return;
            }

            this.field1310 = var7 - 1;
         }

         if(this.field1308 < 0) {
            if(this.field1311) {
               if(this.field1302 < 0) {
                  var9 = this.method1372(var1, var2, var5, var3, var4.field1288[this.field1309]);
                  if(this.field1310 >= var5) {
                     return;
                  }

                  this.field1310 = var5 + var5 - 1 - this.field1310;
                  this.field1302 = -this.field1302;
               }

               while(true) {
                  var9 = this.method1371(var1, var9, var6, var3, var4.field1288[this.field1304 - 1]);
                  if(this.field1310 < var6) {
                     return;
                  }

                  this.field1310 = var6 + var6 - 1 - this.field1310;
                  this.field1302 = -this.field1302;
                  var9 = this.method1372(var1, var9, var5, var3, var4.field1288[this.field1309]);
                  if(this.field1310 >= var5) {
                     return;
                  }

                  this.field1310 = var5 + var5 - 1 - this.field1310;
                  this.field1302 = -this.field1302;
               }
            } else if(this.field1302 < 0) {
               while(true) {
                  var9 = this.method1372(var1, var9, var5, var3, var4.field1288[this.field1304 - 1]);
                  if(this.field1310 >= var5) {
                     return;
                  }

                  this.field1310 = var6 - 1 - (var6 - 1 - this.field1310) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1371(var1, var9, var6, var3, var4.field1288[this.field1309]);
                  if(this.field1310 < var6) {
                     return;
                  }

                  this.field1310 = var5 + (this.field1310 - var5) % var8;
               }
            }
         } else {
            if(this.field1308 > 0) {
               if(this.field1311) {
                  label182: {
                     if(this.field1302 < 0) {
                        var9 = this.method1372(var1, var2, var5, var3, var4.field1288[this.field1309]);
                        if(this.field1310 >= var5) {
                           return;
                        }

                        this.field1310 = var5 + var5 - 1 - this.field1310;
                        this.field1302 = -this.field1302;
                        if(--this.field1308 == 0) {
                           break label182;
                        }
                     }

                     do {
                        var9 = this.method1371(var1, var9, var6, var3, var4.field1288[this.field1304 - 1]);
                        if(this.field1310 < var6) {
                           return;
                        }

                        this.field1310 = var6 + var6 - 1 - this.field1310;
                        this.field1302 = -this.field1302;
                        if(--this.field1308 == 0) {
                           break;
                        }

                        var9 = this.method1372(var1, var9, var5, var3, var4.field1288[this.field1309]);
                        if(this.field1310 >= var5) {
                           return;
                        }

                        this.field1310 = var5 + var5 - 1 - this.field1310;
                        this.field1302 = -this.field1302;
                     } while(--this.field1308 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1302 < 0) {
                     while(true) {
                        var9 = this.method1372(var1, var9, var5, var3, var4.field1288[this.field1304 - 1]);
                        if(this.field1310 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1310) / var8;
                        if(var10 >= this.field1308) {
                           this.field1310 += var8 * this.field1308;
                           this.field1308 = 0;
                           break;
                        }

                        this.field1310 += var8 * var10;
                        this.field1308 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1371(var1, var9, var6, var3, var4.field1288[this.field1309]);
                        if(this.field1310 < var6) {
                           return;
                        }

                        var10 = (this.field1310 - var5) / var8;
                        if(var10 >= this.field1308) {
                           this.field1310 -= var8 * this.field1308;
                           this.field1308 = 0;
                           break;
                        }

                        this.field1310 -= var8 * var10;
                        this.field1308 -= var10;
                     }
                  }
               }
            }

            if(this.field1302 < 0) {
               this.method1372(var1, var9, 0, var3, 0);
               if(this.field1310 < 0) {
                  this.field1310 = -1;
                  this.method1425();
                  this.unlink();
               }
            } else {
               this.method1371(var1, var9, var7, var3, 0);
               if(this.field1310 >= var7) {
                  this.field1310 = var7;
                  this.method1425();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   static int method1370(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ao")
   int method1371(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1312 > 0) {
            int var6 = var2 + this.field1312;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1312 += var2;
            if(this.field1302 == 256 && (this.field1310 & 255) == 0) {
               if(class222.field3221) {
                  var2 = method1373(0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, this.field1314, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1382(((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, this.field1313, 0, var6, var3, this);
               }
            } else if(class222.field3221) {
               var2 = method1431(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, this.field1314, this.field1305, 0, var6, var3, this, this.field1302, var5);
            } else {
               var2 = method1386(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, this.field1313, 0, var6, var3, this, this.field1302, var5);
            }

            this.field1312 -= var2;
            if(this.field1312 != 0) {
               return var2;
            }

            if(!this.method1445()) {
               continue;
            }

            return var4;
         }

         if(this.field1302 == 256 && (this.field1310 & 255) == 0) {
            if(class222.field3221) {
               return method1349(0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, 0, var4, var3, this);
            }

            return method1374(((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, 0, var4, var3, this);
         }

         if(class222.field3221) {
            return method1379(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, 0, var4, var3, this, this.field1302, var5);
         }

         return method1387(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, 0, var4, var3, this, this.field1302, var5);
      }
   }

   @ObfuscatedName("ax")
   int method1372(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1312 > 0) {
            int var6 = var2 + this.field1312;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1312 += var2;
            if(this.field1302 == -256 && (this.field1310 & 255) == 0) {
               if(class222.field3221) {
                  var2 = method1385(0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, this.field1314, this.field1305, 0, var6, var3, this);
               } else {
                  var2 = method1359(((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, this.field1313, 0, var6, var3, this);
               }
            } else if(class222.field3221) {
               var2 = method1389(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, this.field1314, this.field1305, 0, var6, var3, this, this.field1302, var5);
            } else {
               var2 = method1428(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, this.field1313, 0, var6, var3, this, this.field1302, var5);
            }

            this.field1312 -= var2;
            if(this.field1312 != 0) {
               return var2;
            }

            if(!this.method1445()) {
               continue;
            }

            return var4;
         }

         if(this.field1302 == -256 && (this.field1310 & 255) == 0) {
            if(class222.field3221) {
               return method1377(0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, 0, var4, var3, this);
            }

            return method1375(((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, 0, var4, var3, this);
         }

         if(class222.field3221) {
            return method1381(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1306, this.field1307, 0, var4, var3, this, this.field1302, var5);
         }

         return method1380(0, 0, ((class65)super.field1317).field1288, var1, this.field1310, var2, this.field1303, 0, var4, var3, this, this.field1302, var5);
      }
   }

   @ObfuscatedName("at")
   static int method1373(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1303 += var12.field1313 * (var9 - var4);
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

      var12.field1306 = var5 >> 2;
      var12.field1307 = var6 >> 2;
      var12.field1310 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   static int method1374(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1310 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aa")
   static int method1375(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1310 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("j")
   public synchronized void method1376(int var1) {
      this.field1308 = var1;
   }

   @ObfuscatedName("ay")
   static int method1377(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1310 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   static int method1379(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1310 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("az")
   static int method1380(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("av")
   static int method1381(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1310 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ae")
   static int method1382(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1306 += var9.field1314 * (var6 - var3);
      var9.field1307 += var9.field1305 * (var6 - var3);

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

      var9.field1303 = var4 >> 2;
      var9.field1310 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bv")
   static int method1385(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1303 += var12.field1313 * (var9 - var4);
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

      var12.field1306 = var5 >> 2;
      var12.field1307 = var6 >> 2;
      var12.field1310 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   static int method1386(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1306 -= var11.field1314 * var5;
      var11.field1307 -= var11.field1305 * var5;
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

      var11.field1306 += var11.field1314 * var5;
      var11.field1307 += var11.field1305 * var5;
      var11.field1303 = var6;
      var11.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("ab")
   static int method1387(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("u")
   protected class69 vmethod3756() {
      return null;
   }

   @ObfuscatedName("bb")
   static int method1389(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1303 -= var13.field1313 * var5;
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
      var13.field1303 += var13.field1313 * var5;
      var13.field1306 = var6;
      var13.field1307 = var7;
      var13.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("z")
   public synchronized void method1396(int var1, int var2) {
      this.method1360(var1, var2, this.method1491());
   }

   @ObfuscatedName("n")
   void method1409() {
      this.field1303 = this.field1315;
      this.field1306 = method1370(this.field1315, this.field1301);
      this.field1307 = method1422(this.field1315, this.field1301);
   }

   @ObfuscatedName("f")
   public synchronized void method1411(int var1) {
      if(this.field1302 < 0) {
         this.field1302 = -var1;
      } else {
         this.field1302 = var1;
      }

   }

   @ObfuscatedName("d")
   protected class69 vmethod3744() {
      return null;
   }

   @ObfuscatedName("h")
   static int method1422(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("k")
   void method1425() {
      if(this.field1312 != 0) {
         if(this.field1315 == Integer.MIN_VALUE) {
            this.field1315 = 0;
         }

         this.field1312 = 0;
         this.method1409();
      }

   }

   @ObfuscatedName("bu")
   static int method1428(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1306 -= var11.field1314 * var5;
      var11.field1307 -= var11.field1305 * var5;
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

      var11.field1306 += var11.field1314 * var5;
      var11.field1307 += var11.field1305 * var5;
      var11.field1303 = var6;
      var11.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   static int method1431(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1303 -= var13.field1313 * var5;
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
      var13.field1303 += var13.field1313 * var5;
      var13.field1306 = var6;
      var13.field1307 = var7;
      var13.field1310 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   boolean method1445() {
      int var1 = this.field1315;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1370(var1, this.field1301);
         var3 = method1422(var1, this.field1301);
      }

      if(this.field1303 == var1 && this.field1306 == var2 && this.field1307 == var3) {
         if(this.field1315 == Integer.MIN_VALUE) {
            this.field1315 = 0;
            this.field1307 = 0;
            this.field1306 = 0;
            this.field1303 = 0;
            this.unlink();
            return true;
         } else {
            this.method1409();
            return false;
         }
      } else {
         if(this.field1303 < var1) {
            this.field1313 = 1;
            this.field1312 = var1 - this.field1303;
         } else if(this.field1303 > var1) {
            this.field1313 = -1;
            this.field1312 = this.field1303 - var1;
         } else {
            this.field1313 = 0;
         }

         if(this.field1306 < var2) {
            this.field1314 = 1;
            if(this.field1312 == 0 || this.field1312 > var2 - this.field1306) {
               this.field1312 = var2 - this.field1306;
            }
         } else if(this.field1306 > var2) {
            this.field1314 = -1;
            if(this.field1312 == 0 || this.field1312 > this.field1306 - var2) {
               this.field1312 = this.field1306 - var2;
            }
         } else {
            this.field1314 = 0;
         }

         if(this.field1307 < var3) {
            this.field1305 = 1;
            if(this.field1312 == 0 || this.field1312 > var3 - this.field1307) {
               this.field1312 = var3 - this.field1307;
            }
         } else if(this.field1307 > var3) {
            this.field1305 = -1;
            if(this.field1312 == 0 || this.field1312 > this.field1307 - var3) {
               this.field1312 = this.field1307 - var3;
            }
         } else {
            this.field1305 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ah")
   int vmethod1502() {
      int var1 = this.field1303 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1308 == 0) {
         var1 -= var1 * this.field1310 / (((class65)super.field1317).field1288.length << 8);
      } else if(this.field1308 >= 0) {
         var1 -= var1 * this.field1309 / ((class65)super.field1317).field1288.length;
      }

      return var1 > 255?255:var1;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1317 = var1;
      this.field1309 = var1.field1286;
      this.field1304 = var1.field1287;
      this.field1311 = var1.field1284;
      this.field1302 = var2;
      this.field1315 = var3;
      this.field1301 = 8192;
      this.field1310 = 0;
      this.method1409();
   }

   @ObfuscatedName("c")
   public synchronized int method1491() {
      return this.field1301 < 0?-1:this.field1301;
   }
}
