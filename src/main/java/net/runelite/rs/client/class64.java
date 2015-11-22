package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class64 extends class66 {
   @ObfuscatedName("t")
   int field1235;
   @ObfuscatedName("p")
   int field1236;
   @ObfuscatedName("f")
   int field1237;
   @ObfuscatedName("l")
   int field1238;
   @ObfuscatedName("u")
   int field1239;
   @ObfuscatedName("a")
   int field1240;
   @ObfuscatedName("h")
   int field1241;
   @ObfuscatedName("i")
   int field1242;
   @ObfuscatedName("m")
   int field1243;
   @ObfuscatedName("k")
   int field1244;
   @ObfuscatedName("s")
   boolean field1245;
   @ObfuscatedName("e")
   int field1246;
   @ObfuscatedName("z")
   int field1247;
   @ObfuscatedName("r")
   int field1248;
   @ObfuscatedName("j")
   int field1249;

   @ObfuscatedName("g")
   public synchronized void method1340(int var1) {
      int var2 = ((class62)super.field1253).field1219.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1249 = var1;
   }

   @ObfuscatedName("m")
   static int method1341(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ah")
   int vmethod1491() {
      int var1 = this.field1239 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1242 == 0) {
         var1 -= var1 * this.field1249 / (((class62)super.field1253).field1219.length << 8);
      } else if(this.field1242 >= 0) {
         var1 -= var1 * this.field1235 / ((class62)super.field1253).field1219.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("c")
   public boolean method1345() {
      return this.field1249 < 0 || this.field1249 >= ((class62)super.field1253).field1219.length << 8;
   }

   @ObfuscatedName("u")
   void method1347() {
      this.field1239 = this.field1237;
      this.field1240 = method1485(this.field1237, this.field1238);
      this.field1241 = method1341(this.field1237, this.field1238);
   }

   @ObfuscatedName("k")
   public synchronized void method1348(int var1) {
      this.field1242 = var1;
   }

   @ObfuscatedName("w")
   public synchronized void method1349(int var1) {
      this.method1486(var1 << 6, this.method1353());
   }

   @ObfuscatedName("e")
   synchronized void method1350(int var1) {
      this.method1486(var1, this.method1353());
   }

   @ObfuscatedName("p")
   public synchronized int method1352() {
      return this.field1237 == Integer.MIN_VALUE?0:this.field1237;
   }

   @ObfuscatedName("r")
   public synchronized int method1353() {
      return this.field1238 < 0?-1:this.field1238;
   }

   @ObfuscatedName("v")
   public synchronized void method1357(int var1, int var2) {
      this.method1358(var1, var2, this.method1353());
   }

   @ObfuscatedName("q")
   public synchronized void method1358(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1486(var2, var3);
      } else {
         int var4 = method1485(var2, var3);
         int var5 = method1341(var2, var3);
         if(this.field1240 == var4 && this.field1241 == var5) {
            this.field1246 = 0;
         } else {
            int var6 = var2 - this.field1239;
            if(this.field1239 - var2 > var6) {
               var6 = this.field1239 - var2;
            }

            if(var4 - this.field1240 > var6) {
               var6 = var4 - this.field1240;
            }

            if(this.field1240 - var4 > var6) {
               var6 = this.field1240 - var4;
            }

            if(var5 - this.field1241 > var6) {
               var6 = var5 - this.field1241;
            }

            if(this.field1241 - var5 > var6) {
               var6 = this.field1241 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1246 = var1;
            this.field1237 = var2;
            this.field1238 = var3;
            this.field1247 = (var2 - this.field1239) / var1;
            this.field1236 = (var4 - this.field1240) / var1;
            this.field1248 = (var5 - this.field1241) / var1;
         }
      }
   }

   @ObfuscatedName("d")
   public synchronized void method1360(int var1) {
      if(this.field1243 < 0) {
         this.field1243 = -var1;
      } else {
         this.field1243 = var1;
      }

   }

   @ObfuscatedName("ab")
   static int method1362(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1239 += var12.field1247 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var14;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var14 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var14 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
      }

      var12.field1240 = var5 >> 2;
      var12.field1241 = var6 >> 2;
      var12.field1249 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ay")
   public boolean method1363() {
      return this.field1246 != 0;
   }

   @ObfuscatedName("a")
   protected class66 vmethod3774() {
      return null;
   }

   @ObfuscatedName("h")
   protected class66 vmethod3770() {
      return null;
   }

   @ObfuscatedName("i")
   protected int vmethod3772() {
      return this.field1237 == 0 && this.field1246 == 0?0:1;
   }

   @ObfuscatedName("t")
   public synchronized void vmethod3784(int[] var1, int var2, int var3) {
      if(this.field1237 == 0 && this.field1246 == 0) {
         this.vmethod3787(var3);
      } else {
         class62 var4 = (class62)super.field1253;
         int var5 = this.field1235 << 8;
         int var6 = this.field1244 << 8;
         int var7 = var4.field1219.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1242 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1249 < 0) {
            if(this.field1243 <= 0) {
               this.method1450();
               this.method3965();
               return;
            }

            this.field1249 = 0;
         }

         if(this.field1249 >= var7) {
            if(this.field1243 >= 0) {
               this.method1450();
               this.method3965();
               return;
            }

            this.field1249 = var7 - 1;
         }

         if(this.field1242 < 0) {
            if(this.field1245) {
               if(this.field1243 < 0) {
                  var9 = this.method1370(var1, var2, var5, var3, var4.field1219[this.field1235]);
                  if(this.field1249 >= var5) {
                     return;
                  }

                  this.field1249 = var5 + var5 - 1 - this.field1249;
                  this.field1243 = -this.field1243;
               }

               while(true) {
                  var9 = this.method1481(var1, var9, var6, var3, var4.field1219[this.field1244 - 1]);
                  if(this.field1249 < var6) {
                     return;
                  }

                  this.field1249 = var6 + var6 - 1 - this.field1249;
                  this.field1243 = -this.field1243;
                  var9 = this.method1370(var1, var9, var5, var3, var4.field1219[this.field1235]);
                  if(this.field1249 >= var5) {
                     return;
                  }

                  this.field1249 = var5 + var5 - 1 - this.field1249;
                  this.field1243 = -this.field1243;
               }
            } else if(this.field1243 < 0) {
               while(true) {
                  var9 = this.method1370(var1, var9, var5, var3, var4.field1219[this.field1244 - 1]);
                  if(this.field1249 >= var5) {
                     return;
                  }

                  this.field1249 = var6 - 1 - (var6 - 1 - this.field1249) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1481(var1, var9, var6, var3, var4.field1219[this.field1235]);
                  if(this.field1249 < var6) {
                     return;
                  }

                  this.field1249 = var5 + (this.field1249 - var5) % var8;
               }
            }
         } else {
            if(this.field1242 > 0) {
               if(this.field1245) {
                  label186: {
                     if(this.field1243 < 0) {
                        var9 = this.method1370(var1, var2, var5, var3, var4.field1219[this.field1235]);
                        if(this.field1249 >= var5) {
                           return;
                        }

                        this.field1249 = var5 + var5 - 1 - this.field1249;
                        this.field1243 = -this.field1243;
                        if(--this.field1242 == 0) {
                           break label186;
                        }
                     }

                     do {
                        var9 = this.method1481(var1, var9, var6, var3, var4.field1219[this.field1244 - 1]);
                        if(this.field1249 < var6) {
                           return;
                        }

                        this.field1249 = var6 + var6 - 1 - this.field1249;
                        this.field1243 = -this.field1243;
                        if(--this.field1242 == 0) {
                           break;
                        }

                        var9 = this.method1370(var1, var9, var5, var3, var4.field1219[this.field1235]);
                        if(this.field1249 >= var5) {
                           return;
                        }

                        this.field1249 = var5 + var5 - 1 - this.field1249;
                        this.field1243 = -this.field1243;
                     } while(--this.field1242 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1243 < 0) {
                     while(true) {
                        var9 = this.method1370(var1, var9, var5, var3, var4.field1219[this.field1244 - 1]);
                        if(this.field1249 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1249) / var8;
                        if(var10 >= this.field1242) {
                           this.field1249 += var8 * this.field1242;
                           this.field1242 = 0;
                           break;
                        }

                        this.field1249 += var8 * var10;
                        this.field1242 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1481(var1, var9, var6, var3, var4.field1219[this.field1235]);
                        if(this.field1249 < var6) {
                           return;
                        }

                        var10 = (this.field1249 - var5) / var8;
                        if(var10 >= this.field1242) {
                           this.field1249 -= var8 * this.field1242;
                           this.field1242 = 0;
                           break;
                        }

                        this.field1249 -= var8 * var10;
                        this.field1242 -= var10;
                     }
                  }
               }
            }

            if(this.field1243 < 0) {
               this.method1370(var1, var9, 0, var3, 0);
               if(this.field1249 < 0) {
                  this.field1249 = -1;
                  this.method1450();
                  this.method3965();
               }
            } else {
               this.method1481(var1, var9, var7, var3, 0);
               if(this.field1249 >= var7) {
                  this.field1249 = var7;
                  this.method1450();
                  this.method3965();
               }
            }

         }
      }
   }

   @ObfuscatedName("aj")
   static int method1368(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1240 += var9.field1236 * (var6 - var3);
      var9.field1241 += var9.field1248 * (var6 - var3);

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

      var9.field1239 = var4 >> 2;
      var9.field1249 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   int method1370(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1246 > 0) {
            int var6 = var2 + this.field1246;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1246 += var2;
            if(this.field1243 == -256 && (this.field1249 & 255) == 0) {
               if(class228.field3215) {
                  var2 = method1362(0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, this.field1236, this.field1248, 0, var6, var3, this);
               } else {
                  var2 = method1368(((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, this.field1247, 0, var6, var3, this);
               }
            } else if(class228.field3215) {
               var2 = method1403(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, this.field1236, this.field1248, 0, var6, var3, this, this.field1243, var5);
            } else {
               var2 = method1385(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, this.field1247, 0, var6, var3, this, this.field1243, var5);
            }

            this.field1246 -= var2;
            if(this.field1246 != 0) {
               return var2;
            }

            if(!this.method1382()) {
               continue;
            }

            return var4;
         }

         if(this.field1243 == -256 && (this.field1249 & 255) == 0) {
            if(class228.field3215) {
               return method1375(0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, 0, var4, var3, this);
            }

            return method1374(((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, 0, var4, var3, this);
         }

         if(class228.field3215) {
            return method1379(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, 0, var4, var3, this, this.field1243, var5);
         }

         return method1449(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, 0, var4, var3, this, this.field1243, var5);
      }
   }

   @ObfuscatedName("ar")
   static int method1374(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1249 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   static int method1375(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var10001] += var12 * var6) {
         var12 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var12 * var6) {
         var12 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
      }

      var10.field1249 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ag")
   static int method1376(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var14;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("aq")
   static int method1377(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var15;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var15 = var2[var1];
         var0 = (var15 << 8) + (var2[var1 + 1] - var15) * (var4 & 255);
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
         var15 = var2[var4 >> 8];
         var0 = (var15 << 8) + (var1 - var15) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1249 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aw")
   static int method1379(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var0 = (var15 << 8) + (var2[var1] - var15) * (var4 & 255);
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

      var11.field1249 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ad")
   static int method1380(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1240 += var9.field1236 * (var6 - var3);
      var9.field1241 += var9.field1248 * (var6 - var3);

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

      var9.field1239 = var4 >> 2;
      var9.field1249 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("af")
   static int method1381(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1239 += var12.field1247 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var14;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var14 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
         var6 += var8;
         var14 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var14 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var14 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var14 * var6;
      }

      var12.field1240 = var5 >> 2;
      var12.field1241 = var6 >> 2;
      var12.field1249 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("at")
   boolean method1382() {
      int var1 = this.field1237;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1485(var1, this.field1238);
         var3 = method1341(var1, this.field1238);
      }

      if(this.field1239 == var1 && this.field1240 == var2 && this.field1241 == var3) {
         if(this.field1237 == Integer.MIN_VALUE) {
            this.field1237 = 0;
            this.field1241 = 0;
            this.field1240 = 0;
            this.field1239 = 0;
            this.method3965();
            return true;
         } else {
            this.method1347();
            return false;
         }
      } else {
         if(this.field1239 < var1) {
            this.field1247 = 1;
            this.field1246 = var1 - this.field1239;
         } else if(this.field1239 > var1) {
            this.field1247 = -1;
            this.field1246 = this.field1239 - var1;
         } else {
            this.field1247 = 0;
         }

         if(this.field1240 < var2) {
            this.field1236 = 1;
            if(this.field1246 == 0 || this.field1246 > var2 - this.field1240) {
               this.field1246 = var2 - this.field1240;
            }
         } else if(this.field1240 > var2) {
            this.field1236 = -1;
            if(this.field1246 == 0 || this.field1246 > this.field1240 - var2) {
               this.field1246 = this.field1240 - var2;
            }
         } else {
            this.field1236 = 0;
         }

         if(this.field1241 < var3) {
            this.field1248 = 1;
            if(this.field1246 == 0 || this.field1246 > var3 - this.field1241) {
               this.field1246 = var3 - this.field1241;
            }
         } else if(this.field1241 > var3) {
            this.field1248 = -1;
            if(this.field1246 == 0 || this.field1246 > this.field1241 - var3) {
               this.field1246 = this.field1241 - var3;
            }
         } else {
            this.field1248 = 0;
         }

         return false;
      }
   }

   class64(class62 var1, int var2, int var3) {
      super.field1253 = var1;
      this.field1235 = var1.field1220;
      this.field1244 = var1.field1218;
      this.field1245 = var1.field1222;
      this.field1243 = var2;
      this.field1237 = var3;
      this.field1238 = 8192;
      this.field1249 = 0;
      this.method1347();
   }

   @ObfuscatedName("an")
   static int method1383(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1240 -= var11.field1236 * var5;
      var11.field1241 -= var11.field1248 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var15;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var15 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var15 << 8) + (var2[var1 + 1] - var15) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var15 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var15 << 8) + (var1 - var15) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1240 += var11.field1236 * var5;
      var11.field1241 += var11.field1248 * var5;
      var11.field1239 = var6;
      var11.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   static int method1384(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1239 -= var13.field1247 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var17;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var17 = var2[var1];
         var0 = (var17 << 8) + (var2[var1 + 1] - var17) * (var4 & 255);
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
         var17 = var2[var4 >> 8];
         var0 = (var17 << 8) + (var1 - var17) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1239 += var13.field1247 * var5;
      var13.field1240 = var6;
      var13.field1241 = var7;
      var13.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1385(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1240 -= var11.field1236 * var5;
      var11.field1241 -= var11.field1248 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var15 << 8) + (var2[var1] - var15) * (var4 & 255)) * var6 >> 6;
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

      var11.field1240 += var11.field1236 * var5;
      var11.field1241 += var11.field1248 * var5;
      var11.field1239 = var6;
      var11.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("al")
   static int method1387(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1249 = var2 << 8;
      return var3;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1253 = var1;
      this.field1235 = var1.field1220;
      this.field1244 = var1.field1218;
      this.field1245 = var1.field1222;
      this.field1243 = var2;
      this.field1237 = var3;
      this.field1238 = var4;
      this.field1249 = 0;
      this.method1347();
   }

   @ObfuscatedName("x")
   public synchronized void method1402(int var1) {
      if(var1 == 0) {
         this.method1350(0);
         this.method3965();
      } else if(this.field1240 == 0 && this.field1241 == 0) {
         this.field1246 = 0;
         this.field1237 = 0;
         this.field1239 = 0;
         this.method3965();
      } else {
         int var2 = -this.field1239;
         if(this.field1239 > var2) {
            var2 = this.field1239;
         }

         if(-this.field1240 > var2) {
            var2 = -this.field1240;
         }

         if(this.field1240 > var2) {
            var2 = this.field1240;
         }

         if(-this.field1241 > var2) {
            var2 = -this.field1241;
         }

         if(this.field1241 > var2) {
            var2 = this.field1241;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1246 = var1;
         this.field1237 = Integer.MIN_VALUE;
         this.field1247 = -this.field1239 / var1;
         this.field1236 = -this.field1240 / var1;
         this.field1248 = -this.field1241 / var1;
      }
   }

   @ObfuscatedName("bf")
   static int method1403(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1239 -= var13.field1247 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var17 = var2[var1 - 1];
         var0 = (var17 << 8) + (var2[var1] - var17) * (var4 & 255);
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
      var13.field1239 += var13.field1247 * var5;
      var13.field1240 = var6;
      var13.field1241 = var7;
      var13.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("l")
   public static class64 method1421(class62 var0, int var1, int var2, int var3) {
      return var0.field1219 != null && var0.field1219.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("n")
   public synchronized void method1427() {
      this.field1243 = (this.field1243 ^ this.field1243 >> 31) + (this.field1243 >>> 31);
      this.field1243 = -this.field1243;
   }

   @ObfuscatedName("s")
   public synchronized void vmethod3787(int var1) {
      if(this.field1246 > 0) {
         if(var1 >= this.field1246) {
            if(this.field1237 == Integer.MIN_VALUE) {
               this.field1237 = 0;
               this.field1241 = 0;
               this.field1240 = 0;
               this.field1239 = 0;
               this.method3965();
               var1 = this.field1246;
            }

            this.field1246 = 0;
            this.method1347();
         } else {
            this.field1239 += this.field1247 * var1;
            this.field1240 += this.field1236 * var1;
            this.field1241 += this.field1248 * var1;
            this.field1246 -= var1;
         }
      }

      class62 var2 = (class62)super.field1253;
      int var3 = this.field1235 << 8;
      int var4 = this.field1244 << 8;
      int var5 = var2.field1219.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1242 = 0;
      }

      if(this.field1249 < 0) {
         if(this.field1243 <= 0) {
            this.method1450();
            this.method3965();
            return;
         }

         this.field1249 = 0;
      }

      if(this.field1249 >= var5) {
         if(this.field1243 >= 0) {
            this.method1450();
            this.method3965();
            return;
         }

         this.field1249 = var5 - 1;
      }

      this.field1249 += this.field1243 * var1;
      if(this.field1242 < 0) {
         if(!this.field1245) {
            if(this.field1243 < 0) {
               if(this.field1249 >= var3) {
                  return;
               }

               this.field1249 = var4 - 1 - (var4 - 1 - this.field1249) % var6;
            } else {
               if(this.field1249 < var4) {
                  return;
               }

               this.field1249 = var3 + (this.field1249 - var3) % var6;
            }

         } else {
            if(this.field1243 < 0) {
               if(this.field1249 >= var3) {
                  return;
               }

               this.field1249 = var3 + var3 - 1 - this.field1249;
               this.field1243 = -this.field1243;
            }

            while(this.field1249 >= var4) {
               this.field1249 = var4 + var4 - 1 - this.field1249;
               this.field1243 = -this.field1243;
               if(this.field1249 >= var3) {
                  return;
               }

               this.field1249 = var3 + var3 - 1 - this.field1249;
               this.field1243 = -this.field1243;
            }

         }
      } else {
         if(this.field1242 > 0) {
            if(this.field1245) {
               label171: {
                  if(this.field1243 < 0) {
                     if(this.field1249 >= var3) {
                        return;
                     }

                     this.field1249 = var3 + var3 - 1 - this.field1249;
                     this.field1243 = -this.field1243;
                     if(--this.field1242 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1249 < var4) {
                        return;
                     }

                     this.field1249 = var4 + var4 - 1 - this.field1249;
                     this.field1243 = -this.field1243;
                     if(--this.field1242 == 0) {
                        break;
                     }

                     if(this.field1249 >= var3) {
                        return;
                     }

                     this.field1249 = var3 + var3 - 1 - this.field1249;
                     this.field1243 = -this.field1243;
                  } while(--this.field1242 != 0);
               }
            } else {
               label203: {
                  int var7;
                  if(this.field1243 < 0) {
                     if(this.field1249 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1249) / var6;
                     if(var7 >= this.field1242) {
                        this.field1249 += var6 * this.field1242;
                        this.field1242 = 0;
                        break label203;
                     }

                     this.field1249 += var6 * var7;
                     this.field1242 -= var7;
                  } else {
                     if(this.field1249 < var4) {
                        return;
                     }

                     var7 = (this.field1249 - var3) / var6;
                     if(var7 >= this.field1242) {
                        this.field1249 -= var6 * this.field1242;
                        this.field1242 = 0;
                        break label203;
                     }

                     this.field1249 -= var6 * var7;
                     this.field1242 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1243 < 0) {
            if(this.field1249 < 0) {
               this.field1249 = -1;
               this.method1450();
               this.method3965();
            }
         } else if(this.field1249 >= var5) {
            this.field1249 = var5;
            this.method1450();
            this.method3965();
         }

      }
   }

   @ObfuscatedName("ac")
   static int method1445(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var10001] += var12 * var6) {
         var12 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
         var2[var10001] += var12 * var6;
         var12 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var12 * var6) {
         var12 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var12 * var5;
         var10001 = var4++;
      }

      var10.field1249 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   static int method1449(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
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

      var10.field1249 = var4;
      return var5;
   }

   @ObfuscatedName("y")
   void method1450() {
      if(this.field1246 != 0) {
         if(this.field1237 == Integer.MIN_VALUE) {
            this.field1237 = 0;
         }

         this.field1246 = 0;
         this.method1347();
      }

   }

   @ObfuscatedName("f")
   public static class64 method1473(class62 var0, int var1, int var2) {
      return var0.field1219 != null && var0.field1219.length != 0?new class64(var0, (int)((long)var0.field1221 * 256L * (long)var1 / (long)(class56.field1183 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("o")
   public synchronized int method1476() {
      return this.field1243 < 0?-this.field1243:this.field1243;
   }

   @ObfuscatedName("az")
   int method1481(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1246 > 0) {
            int var6 = var2 + this.field1246;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1246 += var2;
            if(this.field1243 == 256 && (this.field1249 & 255) == 0) {
               if(class228.field3215) {
                  var2 = method1381(0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, this.field1236, this.field1248, 0, var6, var3, this);
               } else {
                  var2 = method1380(((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, this.field1247, 0, var6, var3, this);
               }
            } else if(class228.field3215) {
               var2 = method1384(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, this.field1236, this.field1248, 0, var6, var3, this, this.field1243, var5);
            } else {
               var2 = method1383(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, this.field1247, 0, var6, var3, this, this.field1243, var5);
            }

            this.field1246 -= var2;
            if(this.field1246 != 0) {
               return var2;
            }

            if(!this.method1382()) {
               continue;
            }

            return var4;
         }

         if(this.field1243 == 256 && (this.field1249 & 255) == 0) {
            if(class228.field3215) {
               return method1445(0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, 0, var4, var3, this);
            }

            return method1387(((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, 0, var4, var3, this);
         }

         if(class228.field3215) {
            return method1377(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1240, this.field1241, 0, var4, var3, this, this.field1243, var5);
         }

         return method1376(0, 0, ((class62)super.field1253).field1219, var1, this.field1249, var2, this.field1239, 0, var4, var3, this, this.field1243, var5);
      }
   }

   @ObfuscatedName("j")
   static int method1485(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("z")
   synchronized void method1486(int var1, int var2) {
      this.field1237 = var1;
      this.field1238 = var2;
      this.field1246 = 0;
      this.method1347();
   }
}
