import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class67 extends class69 {
   @ObfuscatedName("a")
   int field1289;
   @ObfuscatedName("z")
   int field1290;
   @ObfuscatedName("m")
   int field1291;
   @ObfuscatedName("r")
   boolean field1292;
   @ObfuscatedName("p")
   int field1293;
   @ObfuscatedName("g")
   int field1294;
   @ObfuscatedName("y")
   int field1295;
   @ObfuscatedName("f")
   int field1296;
   @ObfuscatedName("t")
   int field1297;
   @ObfuscatedName("h")
   int field1298;
   @ObfuscatedName("d")
   int field1299;
   @ObfuscatedName("u")
   int field1300;
   @ObfuscatedName("n")
   int field1301;
   @ObfuscatedName("k")
   int field1302;
   @ObfuscatedName("s")
   int field1303;

   @ObfuscatedName("z")
   static int method1306(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   int vmethod1472() {
      int var1 = this.field1293 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1296 == 0) {
         var1 -= var1 * this.field1303 / (((class65)super.field1305).field1273.length << 8);
      } else if(this.field1296 >= 0) {
         var1 -= var1 * this.field1302 / ((class65)super.field1305).field1273.length;
      }

      return var1 > 255?255:var1;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1305 = var1;
      this.field1302 = var1.field1274;
      this.field1298 = var1.field1275;
      this.field1292 = var1.field1272;
      this.field1290 = var2;
      this.field1297 = var3;
      this.field1295 = 8192;
      this.field1303 = 0;
      this.method1310();
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1305 = var1;
      this.field1302 = var1.field1274;
      this.field1298 = var1.field1275;
      this.field1292 = var1.field1272;
      this.field1290 = var2;
      this.field1297 = var3;
      this.field1295 = var4;
      this.field1303 = 0;
      this.method1310();
   }

   @ObfuscatedName("t")
   public static class67 method1308(class65 var0, int var1, int var2) {
      return var0.field1273 != null && var0.field1273.length != 0?new class67(var0, (int)((long)var0.field1276 * 256L * (long)var1 / (long)(class59.field1219 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("y")
   public static class67 method1309(class65 var0, int var1, int var2, int var3) {
      return var0.field1273 != null && var0.field1273.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("p")
   void method1310() {
      this.field1293 = this.field1297;
      this.field1294 = method1340(this.field1297, this.field1295);
      this.field1291 = method1306(this.field1297, this.field1295);
   }

   @ObfuscatedName("h")
   public synchronized void method1311(int var1) {
      this.field1296 = var1;
   }

   @ObfuscatedName("w")
   public synchronized void method1312(int var1) {
      this.method1314(var1 << 6, this.method1439());
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1313(int var1) {
      this.method1314(var1, this.method1439());
   }

   @ObfuscatedName("n")
   synchronized void method1314(int var1, int var2) {
      this.field1297 = var1;
      this.field1295 = var2;
      this.field1300 = 0;
      this.method1310();
   }

   @ObfuscatedName("d")
   public synchronized int method1315() {
      return this.field1297 == Integer.MIN_VALUE?0:this.field1297;
   }

   @ObfuscatedName("b")
   public synchronized void method1316(int var1) {
      int var2 = ((class65)super.field1305).field1273.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1303 = var1;
   }

   @ObfuscatedName("ad")
   static int method1317(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1303 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("o")
   void method1319() {
      if(this.field1300 != 0) {
         if(this.field1297 == Integer.MIN_VALUE) {
            this.field1297 = 0;
         }

         this.field1300 = 0;
         this.method1310();
      }

   }

   @ObfuscatedName("i")
   public synchronized void method1321(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1314(var2, var3);
      } else {
         int var4 = method1340(var2, var3);
         int var5 = method1306(var2, var3);
         if(this.field1294 == var4 && this.field1291 == var5) {
            this.field1300 = 0;
         } else {
            int var6 = var2 - this.field1293;
            if(this.field1293 - var2 > var6) {
               var6 = this.field1293 - var2;
            }

            if(var4 - this.field1294 > var6) {
               var6 = var4 - this.field1294;
            }

            if(this.field1294 - var4 > var6) {
               var6 = this.field1294 - var4;
            }

            if(var5 - this.field1291 > var6) {
               var6 = var5 - this.field1291;
            }

            if(this.field1291 - var5 > var6) {
               var6 = this.field1291 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1300 = var1;
            this.field1297 = var2;
            this.field1295 = var3;
            this.field1301 = (var2 - this.field1293) / var1;
            this.field1299 = (var4 - this.field1294) / var1;
            this.field1289 = (var5 - this.field1291) / var1;
         }
      }
   }

   @ObfuscatedName("x")
   public synchronized void method1322(int var1) {
      if(var1 == 0) {
         this.method1313(0);
         this.unlink();
      } else if(this.field1294 == 0 && this.field1291 == 0) {
         this.field1300 = 0;
         this.field1297 = 0;
         this.field1293 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1293;
         if(this.field1293 > var2) {
            var2 = this.field1293;
         }

         if(-this.field1294 > var2) {
            var2 = -this.field1294;
         }

         if(this.field1294 > var2) {
            var2 = this.field1294;
         }

         if(-this.field1291 > var2) {
            var2 = -this.field1291;
         }

         if(this.field1291 > var2) {
            var2 = this.field1291;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1300 = var1;
         this.field1297 = Integer.MIN_VALUE;
         this.field1301 = -this.field1293 / var1;
         this.field1299 = -this.field1294 / var1;
         this.field1289 = -this.field1291 / var1;
      }
   }

   @ObfuscatedName("aa")
   public synchronized void method1323(int var1) {
      if(this.field1290 < 0) {
         this.field1290 = -var1;
      } else {
         this.field1290 = var1;
      }

   }

   @ObfuscatedName("ag")
   public synchronized int method1325() {
      return this.field1290 < 0?-this.field1290:this.field1290;
   }

   @ObfuscatedName("ao")
   public boolean method1326() {
      return this.field1300 != 0;
   }

   @ObfuscatedName("g")
   protected class69 vmethod3708() {
      return null;
   }

   @ObfuscatedName("m")
   protected class69 vmethod3709() {
      return null;
   }

   @ObfuscatedName("f")
   protected int vmethod3707() {
      return this.field1297 == 0 && this.field1300 == 0?0:1;
   }

   @ObfuscatedName("ap")
   int method1333(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1300 > 0) {
            int var6 = var2 + this.field1300;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1300 += var2;
            if(this.field1290 == -256 && (this.field1303 & 255) == 0) {
               if(class59.field1222) {
                  var2 = method1442(0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, this.field1299, this.field1289, 0, var6, var3, this);
               } else {
                  var2 = method1345(((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, this.field1301, 0, var6, var3, this);
               }
            } else if(class59.field1222) {
               var2 = method1350(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, this.field1299, this.field1289, 0, var6, var3, this, this.field1290, var5);
            } else {
               var2 = method1349(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, this.field1301, 0, var6, var3, this, this.field1290, var5);
            }

            this.field1300 -= var2;
            if(this.field1300 != 0) {
               return var2;
            }

            if(!this.method1346()) {
               continue;
            }

            return var4;
         }

         if(this.field1290 == -256 && (this.field1303 & 255) == 0) {
            if(class59.field1222) {
               return method1338(0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, 0, var4, var3, this);
            }

            return method1337(((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, 0, var4, var3, this);
         }

         if(class59.field1222) {
            return method1342(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, 0, var4, var3, this, this.field1290, var5);
         }

         return method1455(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, 0, var4, var3, this, this.field1290, var5);
      }
   }

   @ObfuscatedName("bp")
   static int method1335(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1294 -= var11.field1299 * var5;
      var11.field1291 -= var11.field1289 * var5;
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

      var11.field1294 += var11.field1299 * var5;
      var11.field1291 += var11.field1289 * var5;
      var11.field1293 = var6;
      var11.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3711(int[] var1, int var2, int var3) {
      if(this.field1297 == 0 && this.field1300 == 0) {
         this.vmethod3712(var3);
      } else {
         class65 var4 = (class65)super.field1305;
         int var5 = this.field1302 << 8;
         int var6 = this.field1298 << 8;
         int var7 = var4.field1273.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1296 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1303 < 0) {
            if(this.field1290 <= 0) {
               this.method1319();
               this.unlink();
               return;
            }

            this.field1303 = 0;
         }

         if(this.field1303 >= var7) {
            if(this.field1290 >= 0) {
               this.method1319();
               this.unlink();
               return;
            }

            this.field1303 = var7 - 1;
         }

         if(this.field1296 < 0) {
            if(this.field1292) {
               if(this.field1290 < 0) {
                  var9 = this.method1333(var1, var2, var5, var3, var4.field1273[this.field1302]);
                  if(this.field1303 >= var5) {
                     return;
                  }

                  this.field1303 = var5 + var5 - 1 - this.field1303;
                  this.field1290 = -this.field1290;
               }

               while(true) {
                  var9 = this.method1449(var1, var9, var6, var3, var4.field1273[this.field1298 - 1]);
                  if(this.field1303 < var6) {
                     return;
                  }

                  this.field1303 = var6 + var6 - 1 - this.field1303;
                  this.field1290 = -this.field1290;
                  var9 = this.method1333(var1, var9, var5, var3, var4.field1273[this.field1302]);
                  if(this.field1303 >= var5) {
                     return;
                  }

                  this.field1303 = var5 + var5 - 1 - this.field1303;
                  this.field1290 = -this.field1290;
               }
            } else if(this.field1290 < 0) {
               while(true) {
                  var9 = this.method1333(var1, var9, var5, var3, var4.field1273[this.field1298 - 1]);
                  if(this.field1303 >= var5) {
                     return;
                  }

                  this.field1303 = var6 - 1 - (var6 - 1 - this.field1303) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1449(var1, var9, var6, var3, var4.field1273[this.field1302]);
                  if(this.field1303 < var6) {
                     return;
                  }

                  this.field1303 = var5 + (this.field1303 - var5) % var8;
               }
            }
         } else {
            if(this.field1296 > 0) {
               if(this.field1292) {
                  label184: {
                     if(this.field1290 < 0) {
                        var9 = this.method1333(var1, var2, var5, var3, var4.field1273[this.field1302]);
                        if(this.field1303 >= var5) {
                           return;
                        }

                        this.field1303 = var5 + var5 - 1 - this.field1303;
                        this.field1290 = -this.field1290;
                        if(--this.field1296 == 0) {
                           break label184;
                        }
                     }

                     do {
                        var9 = this.method1449(var1, var9, var6, var3, var4.field1273[this.field1298 - 1]);
                        if(this.field1303 < var6) {
                           return;
                        }

                        this.field1303 = var6 + var6 - 1 - this.field1303;
                        this.field1290 = -this.field1290;
                        if(--this.field1296 == 0) {
                           break;
                        }

                        var9 = this.method1333(var1, var9, var5, var3, var4.field1273[this.field1302]);
                        if(this.field1303 >= var5) {
                           return;
                        }

                        this.field1303 = var5 + var5 - 1 - this.field1303;
                        this.field1290 = -this.field1290;
                     } while(--this.field1296 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1290 < 0) {
                     while(true) {
                        var9 = this.method1333(var1, var9, var5, var3, var4.field1273[this.field1298 - 1]);
                        if(this.field1303 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1303) / var8;
                        if(var10 >= this.field1296) {
                           this.field1303 += var8 * this.field1296;
                           this.field1296 = 0;
                           break;
                        }

                        this.field1303 += var8 * var10;
                        this.field1296 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1449(var1, var9, var6, var3, var4.field1273[this.field1302]);
                        if(this.field1303 < var6) {
                           return;
                        }

                        var10 = (this.field1303 - var5) / var8;
                        if(var10 >= this.field1296) {
                           this.field1303 -= var8 * this.field1296;
                           this.field1296 = 0;
                           break;
                        }

                        this.field1303 -= var8 * var10;
                        this.field1296 -= var10;
                     }
                  }
               }
            }

            if(this.field1290 < 0) {
               this.method1333(var1, var9, 0, var3, 0);
               if(this.field1303 < 0) {
                  this.field1303 = -1;
                  this.method1319();
                  this.unlink();
               }
            } else {
               this.method1449(var1, var9, var7, var3, 0);
               if(this.field1303 >= var7) {
                  this.field1303 = var7;
                  this.method1319();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("ai")
   static int method1337(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
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

      var8.field1303 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   static int method1338(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1303 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("s")
   static int method1340(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("aw")
   static int method1342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1303 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ak")
   static int method1343(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1294 += var9.field1299 * (var6 - var3);
      var9.field1291 += var9.field1289 * (var6 - var3);

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

      var9.field1293 = var4 >> 2;
      var9.field1303 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aq")
   static int method1345(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1294 += var9.field1299 * (var6 - var3);
      var9.field1291 += var9.field1289 * (var6 - var3);

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

      var9.field1293 = var4 >> 2;
      var9.field1303 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   boolean method1346() {
      int var1 = this.field1297;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1340(var1, this.field1295);
         var3 = method1306(var1, this.field1295);
      }

      if(this.field1293 == var1 && this.field1294 == var2 && this.field1291 == var3) {
         if(this.field1297 == Integer.MIN_VALUE) {
            this.field1297 = 0;
            this.field1291 = 0;
            this.field1294 = 0;
            this.field1293 = 0;
            this.unlink();
            return true;
         } else {
            this.method1310();
            return false;
         }
      } else {
         if(this.field1293 < var1) {
            this.field1301 = 1;
            this.field1300 = var1 - this.field1293;
         } else if(this.field1293 > var1) {
            this.field1301 = -1;
            this.field1300 = this.field1293 - var1;
         } else {
            this.field1301 = 0;
         }

         if(this.field1294 < var2) {
            this.field1299 = 1;
            if(this.field1300 == 0 || this.field1300 > var2 - this.field1294) {
               this.field1300 = var2 - this.field1294;
            }
         } else if(this.field1294 > var2) {
            this.field1299 = -1;
            if(this.field1300 == 0 || this.field1300 > this.field1294 - var2) {
               this.field1300 = this.field1294 - var2;
            }
         } else {
            this.field1299 = 0;
         }

         if(this.field1291 < var3) {
            this.field1289 = 1;
            if(this.field1300 == 0 || this.field1300 > var3 - this.field1291) {
               this.field1300 = var3 - this.field1291;
            }
         } else if(this.field1291 > var3) {
            this.field1289 = -1;
            if(this.field1300 == 0 || this.field1300 > this.field1291 - var3) {
               this.field1300 = this.field1291 - var3;
            }
         } else {
            this.field1289 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3712(int var1) {
      if(this.field1300 > 0) {
         if(var1 >= this.field1300) {
            if(this.field1297 == Integer.MIN_VALUE) {
               this.field1297 = 0;
               this.field1291 = 0;
               this.field1294 = 0;
               this.field1293 = 0;
               this.unlink();
               var1 = this.field1300;
            }

            this.field1300 = 0;
            this.method1310();
         } else {
            this.field1293 += this.field1301 * var1;
            this.field1294 += this.field1299 * var1;
            this.field1291 += this.field1289 * var1;
            this.field1300 -= var1;
         }
      }

      class65 var2 = (class65)super.field1305;
      int var3 = this.field1302 << 8;
      int var4 = this.field1298 << 8;
      int var5 = var2.field1273.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1296 = 0;
      }

      if(this.field1303 < 0) {
         if(this.field1290 <= 0) {
            this.method1319();
            this.unlink();
            return;
         }

         this.field1303 = 0;
      }

      if(this.field1303 >= var5) {
         if(this.field1290 >= 0) {
            this.method1319();
            this.unlink();
            return;
         }

         this.field1303 = var5 - 1;
      }

      this.field1303 += this.field1290 * var1;
      if(this.field1296 < 0) {
         if(!this.field1292) {
            if(this.field1290 < 0) {
               if(this.field1303 >= var3) {
                  return;
               }

               this.field1303 = var4 - 1 - (var4 - 1 - this.field1303) % var6;
            } else {
               if(this.field1303 < var4) {
                  return;
               }

               this.field1303 = var3 + (this.field1303 - var3) % var6;
            }

         } else {
            if(this.field1290 < 0) {
               if(this.field1303 >= var3) {
                  return;
               }

               this.field1303 = var3 + var3 - 1 - this.field1303;
               this.field1290 = -this.field1290;
            }

            while(this.field1303 >= var4) {
               this.field1303 = var4 + var4 - 1 - this.field1303;
               this.field1290 = -this.field1290;
               if(this.field1303 >= var3) {
                  return;
               }

               this.field1303 = var3 + var3 - 1 - this.field1303;
               this.field1290 = -this.field1290;
            }

         }
      } else {
         if(this.field1296 > 0) {
            if(this.field1292) {
               label172: {
                  if(this.field1290 < 0) {
                     if(this.field1303 >= var3) {
                        return;
                     }

                     this.field1303 = var3 + var3 - 1 - this.field1303;
                     this.field1290 = -this.field1290;
                     if(--this.field1296 == 0) {
                        break label172;
                     }
                  }

                  do {
                     if(this.field1303 < var4) {
                        return;
                     }

                     this.field1303 = var4 + var4 - 1 - this.field1303;
                     this.field1290 = -this.field1290;
                     if(--this.field1296 == 0) {
                        break;
                     }

                     if(this.field1303 >= var3) {
                        return;
                     }

                     this.field1303 = var3 + var3 - 1 - this.field1303;
                     this.field1290 = -this.field1290;
                  } while(--this.field1296 != 0);
               }
            } else {
               int var7;
               if(this.field1290 < 0) {
                  if(this.field1303 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1303) / var6;
                  if(var7 < this.field1296) {
                     this.field1303 += var6 * var7;
                     this.field1296 -= var7;
                     return;
                  }

                  this.field1303 += var6 * this.field1296;
                  this.field1296 = 0;
               } else {
                  if(this.field1303 < var4) {
                     return;
                  }

                  var7 = (this.field1303 - var3) / var6;
                  if(var7 < this.field1296) {
                     this.field1303 -= var6 * var7;
                     this.field1296 -= var7;
                     return;
                  }

                  this.field1303 -= var6 * this.field1296;
                  this.field1296 = 0;
               }
            }
         }

         if(this.field1290 < 0) {
            if(this.field1303 < 0) {
               this.field1303 = -1;
               this.method1319();
               this.unlink();
            }
         } else if(this.field1303 >= var5) {
            this.field1303 = var5;
            this.method1319();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("bh")
   static int method1348(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1293 -= var13.field1301 * var5;
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
      var13.field1293 += var13.field1301 * var5;
      var13.field1294 = var6;
      var13.field1291 = var7;
      var13.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method1349(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1294 -= var11.field1299 * var5;
      var11.field1291 -= var11.field1289 * var5;
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

      var11.field1294 += var11.field1299 * var5;
      var11.field1291 += var11.field1289 * var5;
      var11.field1293 = var6;
      var11.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("bg")
   static int method1350(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1293 -= var13.field1301 * var5;
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
      var13.field1293 += var13.field1301 * var5;
      var13.field1294 = var6;
      var13.field1291 = var7;
      var13.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("as")
   static int method1370(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1293 += var12.field1301 * (var9 - var4);
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

      var12.field1294 = var5 >> 2;
      var12.field1291 = var6 >> 2;
      var12.field1303 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1384() {
      this.field1290 = (this.field1290 ^ this.field1290 >> 31) + (this.field1290 >>> 31);
      this.field1290 = -this.field1290;
   }

   @ObfuscatedName("at")
   static int method1395(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
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

      var11.field1303 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ay")
   static int method1396(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("ab")
   public boolean method1433() {
      return this.field1303 < 0 || this.field1303 >= ((class65)super.field1305).field1273.length << 8;
   }

   @ObfuscatedName("a")
   public synchronized int method1439() {
      return this.field1295 < 0?-1:this.field1295;
   }

   @ObfuscatedName("af")
   static int method1442(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1293 += var12.field1301 * (var9 - var4);
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

      var12.field1294 = var5 >> 2;
      var12.field1291 = var6 >> 2;
      var12.field1303 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("c")
   public synchronized void method1448(int var1, int var2) {
      this.method1321(var1, var2, this.method1439());
   }

   @ObfuscatedName("av")
   int method1449(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1300 > 0) {
            int var6 = var2 + this.field1300;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1300 += var2;
            if(this.field1290 == 256 && (this.field1303 & 255) == 0) {
               if(class59.field1222) {
                  var2 = method1370(0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, this.field1299, this.field1289, 0, var6, var3, this);
               } else {
                  var2 = method1343(((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, this.field1301, 0, var6, var3, this);
               }
            } else if(class59.field1222) {
               var2 = method1348(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, this.field1299, this.field1289, 0, var6, var3, this, this.field1290, var5);
            } else {
               var2 = method1335(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, this.field1301, 0, var6, var3, this, this.field1290, var5);
            }

            this.field1300 -= var2;
            if(this.field1300 != 0) {
               return var2;
            }

            if(!this.method1346()) {
               continue;
            }

            return var4;
         }

         if(this.field1290 == 256 && (this.field1303 & 255) == 0) {
            if(class59.field1222) {
               return method1469(0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, 0, var4, var3, this);
            }

            return method1317(((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, 0, var4, var3, this);
         }

         if(class59.field1222) {
            return method1395(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1294, this.field1291, 0, var4, var3, this, this.field1290, var5);
         }

         return method1396(0, 0, ((class65)super.field1305).field1273, var1, this.field1303, var2, this.field1293, 0, var4, var3, this, this.field1290, var5);
      }
   }

   @ObfuscatedName("al")
   static int method1455(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
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

      var10.field1303 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   static int method1469(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
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

      var10.field1303 = var3 << 8;
      return var4 >> 1;
   }
}
