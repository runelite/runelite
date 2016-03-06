import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class64 extends class66 {
   @ObfuscatedName("m")
   int field1255;
   @ObfuscatedName("l")
   int field1256;
   @ObfuscatedName("b")
   int field1257;
   @ObfuscatedName("i")
   int field1258;
   @ObfuscatedName("f")
   int field1259;
   @ObfuscatedName("k")
   int field1260;
   @ObfuscatedName("o")
   int field1261;
   @ObfuscatedName("a")
   int field1262;
   @ObfuscatedName("h")
   int field1263;
   @ObfuscatedName("n")
   int field1264;
   @ObfuscatedName("r")
   boolean field1265;
   @ObfuscatedName("j")
   int field1266;
   @ObfuscatedName("q")
   int field1267;
   @ObfuscatedName("u")
   int field1268;
   @ObfuscatedName("g")
   int field1269;

   @ObfuscatedName("x")
   public synchronized int method1297() {
      return this.field1256 < 0?-this.field1256:this.field1256;
   }

   @ObfuscatedName("l")
   static int method1298(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("af")
   int vmethod1466() {
      int var1 = this.field1259 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1263 == 0) {
         var1 -= var1 * this.field1266 / (((class62)super.field1272).field1239.length << 8);
      } else if(this.field1263 >= 0) {
         var1 -= var1 * this.field1264 / ((class62)super.field1272).field1239.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1272 = var1;
      this.field1264 = var1.field1240;
      this.field1260 = var1.field1238;
      this.field1265 = var1.field1242;
      this.field1256 = var2;
      this.field1262 = var3;
      this.field1258 = 8192;
      this.field1266 = 0;
      this.method1303();
   }

   @ObfuscatedName("v")
   public boolean method1302() {
      return this.field1257 != 0;
   }

   @ObfuscatedName("f")
   void method1303() {
      this.field1259 = this.field1262;
      this.field1255 = method1435(this.field1262, this.field1258);
      this.field1261 = method1298(this.field1262, this.field1258);
   }

   @ObfuscatedName("k")
   public synchronized void method1304(int var1) {
      this.field1263 = var1;
   }

   @ObfuscatedName("b")
   public synchronized void method1305(int var1) {
      this.method1307(var1 << 6, this.method1309());
   }

   @ObfuscatedName("u")
   synchronized void method1307(int var1, int var2) {
      this.field1262 = var1;
      this.field1258 = var2;
      this.field1257 = 0;
      this.method1303();
   }

   @ObfuscatedName("g")
   public synchronized int method1308() {
      return this.field1262 == Integer.MIN_VALUE?0:this.field1262;
   }

   @ObfuscatedName("y")
   public synchronized int method1309() {
      return this.field1258 < 0?-1:this.field1258;
   }

   @ObfuscatedName("s")
   public synchronized void method1310(int var1) {
      int var2 = ((class62)super.field1272).field1239.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1266 = var1;
   }

   @ObfuscatedName("d")
   public synchronized void method1311() {
      this.field1256 = (this.field1256 ^ this.field1256 >> 31) + (this.field1256 >>> 31);
      this.field1256 = -this.field1256;
   }

   @ObfuscatedName("z")
   void method1312() {
      if(this.field1257 != 0) {
         if(this.field1262 == Integer.MIN_VALUE) {
            this.field1262 = 0;
         }

         this.field1257 = 0;
         this.method1303();
      }

   }

   @ObfuscatedName("p")
   public synchronized void method1313(int var1, int var2) {
      this.method1361(var1, var2, this.method1309());
   }

   @ObfuscatedName("h")
   protected int vmethod3679() {
      return this.field1262 == 0 && this.field1257 == 0?0:1;
   }

   @ObfuscatedName("t")
   public synchronized void method1315(int var1) {
      if(var1 == 0) {
         this.method1420(0);
         this.method3853();
      } else if(this.field1255 == 0 && this.field1261 == 0) {
         this.field1257 = 0;
         this.field1262 = 0;
         this.field1259 = 0;
         this.method3853();
      } else {
         int var2 = -this.field1259;
         if(this.field1259 > var2) {
            var2 = this.field1259;
         }

         if(-this.field1255 > var2) {
            var2 = -this.field1255;
         }

         if(this.field1255 > var2) {
            var2 = this.field1255;
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

         this.field1257 = var1;
         this.field1262 = Integer.MIN_VALUE;
         this.field1267 = -this.field1259 / var1;
         this.field1268 = -this.field1255 / var1;
         this.field1269 = -this.field1261 / var1;
      }
   }

   @ObfuscatedName("c")
   public synchronized void method1316(int var1) {
      if(this.field1256 < 0) {
         this.field1256 = -var1;
      } else {
         this.field1256 = var1;
      }

   }

   @ObfuscatedName("e")
   public boolean method1318() {
      return this.field1266 < 0 || this.field1266 >= ((class62)super.field1272).field1239.length << 8;
   }

   @ObfuscatedName("n")
   public synchronized void vmethod3680(int[] var1, int var2, int var3) {
      if(this.field1262 == 0 && this.field1257 == 0) {
         this.vmethod3676(var3);
      } else {
         class62 var4 = (class62)super.field1272;
         int var5 = this.field1264 << 8;
         int var6 = this.field1260 << 8;
         int var7 = var4.field1239.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1263 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1266 < 0) {
            if(this.field1256 <= 0) {
               this.method1312();
               this.method3853();
               return;
            }

            this.field1266 = 0;
         }

         if(this.field1266 >= var7) {
            if(this.field1256 >= 0) {
               this.method1312();
               this.method3853();
               return;
            }

            this.field1266 = var7 - 1;
         }

         if(this.field1263 < 0) {
            if(this.field1265) {
               if(this.field1256 < 0) {
                  var9 = this.method1326(var1, var2, var5, var3, var4.field1239[this.field1264]);
                  if(this.field1266 >= var5) {
                     return;
                  }

                  this.field1266 = var5 + var5 - 1 - this.field1266;
                  this.field1256 = -this.field1256;
               }

               while(true) {
                  var9 = this.method1337(var1, var9, var6, var3, var4.field1239[this.field1260 - 1]);
                  if(this.field1266 < var6) {
                     return;
                  }

                  this.field1266 = var6 + var6 - 1 - this.field1266;
                  this.field1256 = -this.field1256;
                  var9 = this.method1326(var1, var9, var5, var3, var4.field1239[this.field1264]);
                  if(this.field1266 >= var5) {
                     return;
                  }

                  this.field1266 = var5 + var5 - 1 - this.field1266;
                  this.field1256 = -this.field1256;
               }
            } else if(this.field1256 < 0) {
               while(true) {
                  var9 = this.method1326(var1, var9, var5, var3, var4.field1239[this.field1260 - 1]);
                  if(this.field1266 >= var5) {
                     return;
                  }

                  this.field1266 = var6 - 1 - (var6 - 1 - this.field1266) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1337(var1, var9, var6, var3, var4.field1239[this.field1264]);
                  if(this.field1266 < var6) {
                     return;
                  }

                  this.field1266 = var5 + (this.field1266 - var5) % var8;
               }
            }
         } else {
            if(this.field1263 > 0) {
               if(this.field1265) {
                  label178: {
                     if(this.field1256 < 0) {
                        var9 = this.method1326(var1, var2, var5, var3, var4.field1239[this.field1264]);
                        if(this.field1266 >= var5) {
                           return;
                        }

                        this.field1266 = var5 + var5 - 1 - this.field1266;
                        this.field1256 = -this.field1256;
                        if(--this.field1263 == 0) {
                           break label178;
                        }
                     }

                     do {
                        var9 = this.method1337(var1, var9, var6, var3, var4.field1239[this.field1260 - 1]);
                        if(this.field1266 < var6) {
                           return;
                        }

                        this.field1266 = var6 + var6 - 1 - this.field1266;
                        this.field1256 = -this.field1256;
                        if(--this.field1263 == 0) {
                           break;
                        }

                        var9 = this.method1326(var1, var9, var5, var3, var4.field1239[this.field1264]);
                        if(this.field1266 >= var5) {
                           return;
                        }

                        this.field1266 = var5 + var5 - 1 - this.field1266;
                        this.field1256 = -this.field1256;
                     } while(--this.field1263 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1256 < 0) {
                     while(true) {
                        var9 = this.method1326(var1, var9, var5, var3, var4.field1239[this.field1260 - 1]);
                        if(this.field1266 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1266) / var8;
                        if(var10 >= this.field1263) {
                           this.field1266 += var8 * this.field1263;
                           this.field1263 = 0;
                           break;
                        }

                        this.field1266 += var8 * var10;
                        this.field1263 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1337(var1, var9, var6, var3, var4.field1239[this.field1264]);
                        if(this.field1266 < var6) {
                           return;
                        }

                        var10 = (this.field1266 - var5) / var8;
                        if(var10 >= this.field1263) {
                           this.field1266 -= var8 * this.field1263;
                           this.field1263 = 0;
                           break;
                        }

                        this.field1266 -= var8 * var10;
                        this.field1263 -= var10;
                     }
                  }
               }
            }

            if(this.field1256 < 0) {
               this.method1326(var1, var9, 0, var3, 0);
               if(this.field1266 < 0) {
                  this.field1266 = -1;
                  this.method1312();
                  this.method3853();
               }
            } else {
               this.method1337(var1, var9, var7, var3, 0);
               if(this.field1266 >= var7) {
                  this.field1266 = var7;
                  this.method1312();
                  this.method3853();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3676(int var1) {
      if(this.field1257 > 0) {
         if(var1 >= this.field1257) {
            if(this.field1262 == Integer.MIN_VALUE) {
               this.field1262 = 0;
               this.field1261 = 0;
               this.field1255 = 0;
               this.field1259 = 0;
               this.method3853();
               var1 = this.field1257;
            }

            this.field1257 = 0;
            this.method1303();
         } else {
            this.field1259 += this.field1267 * var1;
            this.field1255 += this.field1268 * var1;
            this.field1261 += this.field1269 * var1;
            this.field1257 -= var1;
         }
      }

      class62 var2 = (class62)super.field1272;
      int var3 = this.field1264 << 8;
      int var4 = this.field1260 << 8;
      int var5 = var2.field1239.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1263 = 0;
      }

      if(this.field1266 < 0) {
         if(this.field1256 <= 0) {
            this.method1312();
            this.method3853();
            return;
         }

         this.field1266 = 0;
      }

      if(this.field1266 >= var5) {
         if(this.field1256 >= 0) {
            this.method1312();
            this.method3853();
            return;
         }

         this.field1266 = var5 - 1;
      }

      this.field1266 += this.field1256 * var1;
      if(this.field1263 < 0) {
         if(!this.field1265) {
            if(this.field1256 < 0) {
               if(this.field1266 >= var3) {
                  return;
               }

               this.field1266 = var4 - 1 - (var4 - 1 - this.field1266) % var6;
            } else {
               if(this.field1266 < var4) {
                  return;
               }

               this.field1266 = var3 + (this.field1266 - var3) % var6;
            }

         } else {
            if(this.field1256 < 0) {
               if(this.field1266 >= var3) {
                  return;
               }

               this.field1266 = var3 + var3 - 1 - this.field1266;
               this.field1256 = -this.field1256;
            }

            while(this.field1266 >= var4) {
               this.field1266 = var4 + var4 - 1 - this.field1266;
               this.field1256 = -this.field1256;
               if(this.field1266 >= var3) {
                  return;
               }

               this.field1266 = var3 + var3 - 1 - this.field1266;
               this.field1256 = -this.field1256;
            }

         }
      } else {
         if(this.field1263 > 0) {
            if(this.field1265) {
               label178: {
                  if(this.field1256 < 0) {
                     if(this.field1266 >= var3) {
                        return;
                     }

                     this.field1266 = var3 + var3 - 1 - this.field1266;
                     this.field1256 = -this.field1256;
                     if(--this.field1263 == 0) {
                        break label178;
                     }
                  }

                  do {
                     if(this.field1266 < var4) {
                        return;
                     }

                     this.field1266 = var4 + var4 - 1 - this.field1266;
                     this.field1256 = -this.field1256;
                     if(--this.field1263 == 0) {
                        break;
                     }

                     if(this.field1266 >= var3) {
                        return;
                     }

                     this.field1266 = var3 + var3 - 1 - this.field1266;
                     this.field1256 = -this.field1256;
                  } while(--this.field1263 != 0);
               }
            } else {
               label210: {
                  int var7;
                  if(this.field1256 < 0) {
                     if(this.field1266 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1266) / var6;
                     if(var7 >= this.field1263) {
                        this.field1266 += var6 * this.field1263;
                        this.field1263 = 0;
                        break label210;
                     }

                     this.field1266 += var6 * var7;
                     this.field1263 -= var7;
                  } else {
                     if(this.field1266 < var4) {
                        return;
                     }

                     var7 = (this.field1266 - var3) / var6;
                     if(var7 >= this.field1263) {
                        this.field1266 -= var6 * this.field1263;
                        this.field1263 = 0;
                        break label210;
                     }

                     this.field1266 -= var6 * var7;
                     this.field1263 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1256 < 0) {
            if(this.field1266 < 0) {
               this.field1266 = -1;
               this.method1312();
               this.method3853();
            }
         } else if(this.field1266 >= var5) {
            this.field1266 = var5;
            this.method1312();
            this.method3853();
         }

      }
   }

   @ObfuscatedName("aa")
   int method1326(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1257 > 0) {
            int var6 = var2 + this.field1257;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1257 += var2;
            if(this.field1256 == -256 && (this.field1266 & 255) == 0) {
               if(class56.field1191) {
                  var2 = method1339(0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, this.field1268, this.field1269, 0, var6, var3, this);
               } else {
                  var2 = method1338(((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, this.field1267, 0, var6, var3, this);
               }
            } else if(class56.field1191) {
               var2 = method1343(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, this.field1268, this.field1269, 0, var6, var3, this, this.field1256, var5);
            } else {
               var2 = method1342(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, this.field1267, 0, var6, var3, this, this.field1256, var5);
            }

            this.field1257 -= var2;
            if(this.field1257 != 0) {
               return var2;
            }

            if(!this.method1341()) {
               continue;
            }

            return var4;
         }

         if(this.field1256 == -256 && (this.field1266 & 255) == 0) {
            if(class56.field1191) {
               return method1331(0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, 0, var4, var3, this);
            }

            return method1335(((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, 0, var4, var3, this);
         }

         if(class56.field1191) {
            return method1441(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, 0, var4, var3, this, this.field1256, var5);
         }

         return method1369(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, 0, var4, var3, this, this.field1256, var5);
      }
   }

   @ObfuscatedName("an")
   static int method1329(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1266 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ao")
   static int method1330(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1266 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("al")
   static int method1331(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1266 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aq")
   static int method1332(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("at")
   static int method1335(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1266 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   static int method1336(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1255 += var9.field1268 * (var6 - var3);
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

      var9.field1259 = var4 >> 2;
      var9.field1266 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   int method1337(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1257 > 0) {
            int var6 = var2 + this.field1257;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1257 += var2;
            if(this.field1256 == 256 && (this.field1266 & 255) == 0) {
               if(class56.field1191) {
                  var2 = method1372(0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, this.field1268, this.field1269, 0, var6, var3, this);
               } else {
                  var2 = method1336(((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, this.field1267, 0, var6, var3, this);
               }
            } else if(class56.field1191) {
               var2 = method1405(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, this.field1268, this.field1269, 0, var6, var3, this, this.field1256, var5);
            } else {
               var2 = method1340(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, this.field1267, 0, var6, var3, this, this.field1256, var5);
            }

            this.field1257 -= var2;
            if(this.field1257 != 0) {
               return var2;
            }

            if(!this.method1341()) {
               continue;
            }

            return var4;
         }

         if(this.field1256 == 256 && (this.field1266 & 255) == 0) {
            if(class56.field1191) {
               return method1329(0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, 0, var4, var3, this);
            }

            return method1330(((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, 0, var4, var3, this);
         }

         if(class56.field1191) {
            return method1406(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1255, this.field1261, 0, var4, var3, this, this.field1256, var5);
         }

         return method1332(0, 0, ((class62)super.field1272).field1239, var1, this.field1266, var2, this.field1259, 0, var4, var3, this, this.field1256, var5);
      }
   }

   @ObfuscatedName("av")
   static int method1338(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1255 += var9.field1268 * (var6 - var3);
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

      var9.field1259 = var4 >> 2;
      var9.field1266 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ah")
   static int method1339(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1259 += var12.field1267 * (var9 - var4);
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

      var12.field1255 = var5 >> 2;
      var12.field1261 = var6 >> 2;
      var12.field1266 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   static int method1340(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1255 -= var11.field1268 * var5;
      var11.field1261 -= var11.field1269 * var5;
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

      var11.field1255 += var11.field1268 * var5;
      var11.field1261 += var11.field1269 * var5;
      var11.field1259 = var6;
      var11.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("ag")
   boolean method1341() {
      int var1 = this.field1262;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1435(var1, this.field1258);
         var3 = method1298(var1, this.field1258);
      }

      if(this.field1259 == var1 && this.field1255 == var2 && this.field1261 == var3) {
         if(this.field1262 == Integer.MIN_VALUE) {
            this.field1262 = 0;
            this.field1261 = 0;
            this.field1255 = 0;
            this.field1259 = 0;
            this.method3853();
            return true;
         } else {
            this.method1303();
            return false;
         }
      } else {
         if(this.field1259 < var1) {
            this.field1267 = 1;
            this.field1257 = var1 - this.field1259;
         } else if(this.field1259 > var1) {
            this.field1267 = -1;
            this.field1257 = this.field1259 - var1;
         } else {
            this.field1267 = 0;
         }

         if(this.field1255 < var2) {
            this.field1268 = 1;
            if(this.field1257 == 0 || this.field1257 > var2 - this.field1255) {
               this.field1257 = var2 - this.field1255;
            }
         } else if(this.field1255 > var2) {
            this.field1268 = -1;
            if(this.field1257 == 0 || this.field1257 > this.field1255 - var2) {
               this.field1257 = this.field1255 - var2;
            }
         } else {
            this.field1268 = 0;
         }

         if(this.field1261 < var3) {
            this.field1269 = 1;
            if(this.field1257 == 0 || this.field1257 > var3 - this.field1261) {
               this.field1257 = var3 - this.field1261;
            }
         } else if(this.field1261 > var3) {
            this.field1269 = -1;
            if(this.field1257 == 0 || this.field1257 > this.field1261 - var3) {
               this.field1257 = this.field1261 - var3;
            }
         } else {
            this.field1269 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("bv")
   static int method1342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1255 -= var11.field1268 * var5;
      var11.field1261 -= var11.field1269 * var5;
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

      var11.field1255 += var11.field1268 * var5;
      var11.field1261 += var11.field1269 * var5;
      var11.field1259 = var6;
      var11.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method1343(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1259 -= var13.field1267 * var5;
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
      var13.field1259 += var13.field1267 * var5;
      var13.field1255 = var6;
      var13.field1261 = var7;
      var13.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("i")
   public static class64 method1355(class62 var0, int var1, int var2, int var3) {
      return var0.field1239 != null && var0.field1239.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("w")
   public synchronized void method1361(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1307(var2, var3);
      } else {
         int var4 = method1435(var2, var3);
         int var5 = method1298(var2, var3);
         if(this.field1255 == var4 && this.field1261 == var5) {
            this.field1257 = 0;
         } else {
            int var6 = var2 - this.field1259;
            if(this.field1259 - var2 > var6) {
               var6 = this.field1259 - var2;
            }

            if(var4 - this.field1255 > var6) {
               var6 = var4 - this.field1255;
            }

            if(this.field1255 - var4 > var6) {
               var6 = this.field1255 - var4;
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

            this.field1257 = var1;
            this.field1262 = var2;
            this.field1258 = var3;
            this.field1267 = (var2 - this.field1259) / var1;
            this.field1268 = (var4 - this.field1255) / var1;
            this.field1269 = (var5 - this.field1261) / var1;
         }
      }
   }

   @ObfuscatedName("ap")
   static int method1369(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("ay")
   static int method1372(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1259 += var12.field1267 * (var9 - var4);
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

      var12.field1255 = var5 >> 2;
      var12.field1261 = var6 >> 2;
      var12.field1266 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("m")
   protected class66 vmethod3677() {
      return null;
   }

   @ObfuscatedName("bs")
   static int method1405(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1259 -= var13.field1267 * var5;
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
      var13.field1259 += var13.field1267 * var5;
      var13.field1255 = var6;
      var13.field1261 = var7;
      var13.field1266 = var4;
      return var5;
   }

   @ObfuscatedName("ae")
   static int method1406(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1266 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("a")
   public static class64 method1415(class62 var0, int var1, int var2) {
      return var0.field1239 != null && var0.field1239.length != 0?new class64(var0, (int)((long)var0.field1241 * 256L * (long)var1 / (long)(class102.field1780 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("q")
   synchronized void method1420(int var1) {
      this.method1307(var1, this.method1309());
   }

   @ObfuscatedName("o")
   protected class66 vmethod3678() {
      return null;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1272 = var1;
      this.field1264 = var1.field1240;
      this.field1260 = var1.field1238;
      this.field1265 = var1.field1242;
      this.field1256 = var2;
      this.field1262 = var3;
      this.field1258 = var4;
      this.field1266 = 0;
      this.method1303();
   }

   @ObfuscatedName("j")
   static int method1435(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ad")
   static int method1441(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1266 = var4;
      return var5 >> 1;
   }
}
