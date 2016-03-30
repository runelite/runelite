import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class64 extends class66 {
   @ObfuscatedName("l")
   int field1253;
   @ObfuscatedName("t")
   int field1254;
   @ObfuscatedName("j")
   int field1255;
   @ObfuscatedName("x")
   int field1256;
   @ObfuscatedName("y")
   int field1257;
   @ObfuscatedName("m")
   int field1258;
   @ObfuscatedName("c")
   int field1259;
   @ObfuscatedName("v")
   int field1260;
   @ObfuscatedName("p")
   int field1261;
   @ObfuscatedName("z")
   int field1262;
   @ObfuscatedName("s")
   boolean field1263;
   @ObfuscatedName("e")
   int field1264;
   @ObfuscatedName("q")
   int field1265;
   @ObfuscatedName("a")
   int field1266;
   @ObfuscatedName("d")
   int field1267;

   @ObfuscatedName("au")
   int vmethod1463() {
      int var1 = this.field1257 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1260 == 0) {
         var1 -= var1 * this.field1256 / (((class62)super.field1271).field1238.length << 8);
      } else if(this.field1260 >= 0) {
         var1 -= var1 * this.field1253 / ((class62)super.field1271).field1238.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1271 = var1;
      this.field1253 = var1.field1236;
      this.field1262 = var1.field1239;
      this.field1263 = var1.field1240;
      this.field1254 = var2;
      this.field1261 = var3;
      this.field1264 = var4;
      this.field1256 = 0;
      this.method1320();
   }

   @ObfuscatedName("t")
   public static class64 method1318(class62 var0, int var1, int var2) {
      return var0.field1238 != null && var0.field1238.length != 0?new class64(var0, (int)((long)var0.field1237 * 256L * (long)var1 / (long)(class129.field2058 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("p")
   public static class64 method1319(class62 var0, int var1, int var2, int var3) {
      return var0.field1238 != null && var0.field1238.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("e")
   void method1320() {
      this.field1257 = this.field1261;
      this.field1258 = method1388(this.field1261, this.field1264);
      this.field1259 = method1456(this.field1261, this.field1264);
   }

   @ObfuscatedName("as")
   static int method1321(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("l")
   public synchronized void method1322(int var1) {
      this.field1260 = var1;
   }

   @ObfuscatedName("j")
   synchronized void method1323(int var1) {
      this.method1380(var1, this.method1326());
   }

   @ObfuscatedName("a")
   public synchronized int method1325() {
      return this.field1261 == Integer.MIN_VALUE?0:this.field1261;
   }

   @ObfuscatedName("d")
   public synchronized int method1326() {
      return this.field1264 < 0?-1:this.field1264;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1328() {
      this.field1254 = (this.field1254 ^ this.field1254 >> 31) + (this.field1254 >>> 31);
      this.field1254 = -this.field1254;
   }

   @ObfuscatedName("o")
   void method1329() {
      if(this.field1255 != 0) {
         if(this.field1261 == Integer.MIN_VALUE) {
            this.field1261 = 0;
         }

         this.field1255 = 0;
         this.method1320();
      }

   }

   @ObfuscatedName("h")
   public synchronized void method1330(int var1, int var2) {
      this.method1331(var1, var2, this.method1326());
   }

   @ObfuscatedName("k")
   public synchronized void method1331(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1380(var2, var3);
      } else {
         int var4 = method1388(var2, var3);
         int var5 = method1456(var2, var3);
         if(this.field1258 == var4 && this.field1259 == var5) {
            this.field1255 = 0;
         } else {
            int var6 = var2 - this.field1257;
            if(this.field1257 - var2 > var6) {
               var6 = this.field1257 - var2;
            }

            if(var4 - this.field1258 > var6) {
               var6 = var4 - this.field1258;
            }

            if(this.field1258 - var4 > var6) {
               var6 = this.field1258 - var4;
            }

            if(var5 - this.field1259 > var6) {
               var6 = var5 - this.field1259;
            }

            if(this.field1259 - var5 > var6) {
               var6 = this.field1259 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1255 = var1;
            this.field1261 = var2;
            this.field1264 = var3;
            this.field1265 = (var2 - this.field1257) / var1;
            this.field1266 = (var4 - this.field1258) / var1;
            this.field1267 = (var5 - this.field1259) / var1;
         }
      }
   }

   @ObfuscatedName("f")
   public synchronized void method1332(int var1) {
      if(var1 == 0) {
         this.method1323(0);
         this.method3935();
      } else if(this.field1258 == 0 && this.field1259 == 0) {
         this.field1255 = 0;
         this.field1261 = 0;
         this.field1257 = 0;
         this.method3935();
      } else {
         int var2 = -this.field1257;
         if(this.field1257 > var2) {
            var2 = this.field1257;
         }

         if(-this.field1258 > var2) {
            var2 = -this.field1258;
         }

         if(this.field1258 > var2) {
            var2 = this.field1258;
         }

         if(-this.field1259 > var2) {
            var2 = -this.field1259;
         }

         if(this.field1259 > var2) {
            var2 = this.field1259;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1255 = var1;
         this.field1261 = Integer.MIN_VALUE;
         this.field1265 = -this.field1257 / var1;
         this.field1266 = -this.field1258 / var1;
         this.field1267 = -this.field1259 / var1;
      }
   }

   class64(class62 var1, int var2, int var3) {
      super.field1271 = var1;
      this.field1253 = var1.field1236;
      this.field1262 = var1.field1239;
      this.field1263 = var1.field1240;
      this.field1254 = var2;
      this.field1261 = var3;
      this.field1264 = 8192;
      this.field1256 = 0;
      this.method1320();
   }

   @ObfuscatedName("az")
   public boolean method1334() {
      return this.field1256 < 0 || this.field1256 >= ((class62)super.field1271).field1238.length << 8;
   }

   @ObfuscatedName("al")
   public boolean method1335() {
      return this.field1255 != 0;
   }

   @ObfuscatedName("m")
   protected class66 vmethod3749() {
      return null;
   }

   @ObfuscatedName("v")
   public synchronized void vmethod3733(int[] var1, int var2, int var3) {
      if(this.field1261 == 0 && this.field1255 == 0) {
         this.vmethod3734(var3);
      } else {
         class62 var4 = (class62)super.field1271;
         int var5 = this.field1253 << 8;
         int var6 = this.field1262 << 8;
         int var7 = var4.field1238.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1260 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1256 < 0) {
            if(this.field1254 <= 0) {
               this.method1329();
               this.method3935();
               return;
            }

            this.field1256 = 0;
         }

         if(this.field1256 >= var7) {
            if(this.field1254 >= 0) {
               this.method1329();
               this.method3935();
               return;
            }

            this.field1256 = var7 - 1;
         }

         if(this.field1260 < 0) {
            if(this.field1263) {
               if(this.field1254 < 0) {
                  var9 = this.method1342(var1, var2, var5, var3, var4.field1238[this.field1253]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var5 + var5 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
               }

               while(true) {
                  var9 = this.method1430(var1, var9, var6, var3, var4.field1238[this.field1262 - 1]);
                  if(this.field1256 < var6) {
                     return;
                  }

                  this.field1256 = var6 + var6 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
                  var9 = this.method1342(var1, var9, var5, var3, var4.field1238[this.field1253]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var5 + var5 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
               }
            } else if(this.field1254 < 0) {
               while(true) {
                  var9 = this.method1342(var1, var9, var5, var3, var4.field1238[this.field1262 - 1]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var6 - 1 - (var6 - 1 - this.field1256) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1430(var1, var9, var6, var3, var4.field1238[this.field1253]);
                  if(this.field1256 < var6) {
                     return;
                  }

                  this.field1256 = var5 + (this.field1256 - var5) % var8;
               }
            }
         } else {
            if(this.field1260 > 0) {
               if(this.field1263) {
                  label187: {
                     if(this.field1254 < 0) {
                        var9 = this.method1342(var1, var2, var5, var3, var4.field1238[this.field1253]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        this.field1256 = var5 + var5 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                        if(--this.field1260 == 0) {
                           break label187;
                        }
                     }

                     do {
                        var9 = this.method1430(var1, var9, var6, var3, var4.field1238[this.field1262 - 1]);
                        if(this.field1256 < var6) {
                           return;
                        }

                        this.field1256 = var6 + var6 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                        if(--this.field1260 == 0) {
                           break;
                        }

                        var9 = this.method1342(var1, var9, var5, var3, var4.field1238[this.field1253]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        this.field1256 = var5 + var5 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                     } while(--this.field1260 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1254 < 0) {
                     while(true) {
                        var9 = this.method1342(var1, var9, var5, var3, var4.field1238[this.field1262 - 1]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1256) / var8;
                        if(var10 >= this.field1260) {
                           this.field1256 += var8 * this.field1260;
                           this.field1260 = 0;
                           break;
                        }

                        this.field1256 += var8 * var10;
                        this.field1260 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1430(var1, var9, var6, var3, var4.field1238[this.field1253]);
                        if(this.field1256 < var6) {
                           return;
                        }

                        var10 = (this.field1256 - var5) / var8;
                        if(var10 >= this.field1260) {
                           this.field1256 -= var8 * this.field1260;
                           this.field1260 = 0;
                           break;
                        }

                        this.field1256 -= var8 * var10;
                        this.field1260 -= var10;
                     }
                  }
               }
            }

            if(this.field1254 < 0) {
               this.method1342(var1, var9, 0, var3, 0);
               if(this.field1256 < 0) {
                  this.field1256 = -1;
                  this.method1329();
                  this.method3935();
               }
            } else {
               this.method1430(var1, var9, var7, var3, 0);
               if(this.field1256 >= var7) {
                  this.field1256 = var7;
                  this.method1329();
                  this.method3935();
               }
            }

         }
      }
   }

   @ObfuscatedName("z")
   public synchronized void vmethod3734(int var1) {
      if(this.field1255 > 0) {
         if(var1 >= this.field1255) {
            if(this.field1261 == Integer.MIN_VALUE) {
               this.field1261 = 0;
               this.field1259 = 0;
               this.field1258 = 0;
               this.field1257 = 0;
               this.method3935();
               var1 = this.field1255;
            }

            this.field1255 = 0;
            this.method1320();
         } else {
            this.field1257 += this.field1265 * var1;
            this.field1258 += this.field1266 * var1;
            this.field1259 += this.field1267 * var1;
            this.field1255 -= var1;
         }
      }

      class62 var2 = (class62)super.field1271;
      int var3 = this.field1253 << 8;
      int var4 = this.field1262 << 8;
      int var5 = var2.field1238.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1260 = 0;
      }

      if(this.field1256 < 0) {
         if(this.field1254 <= 0) {
            this.method1329();
            this.method3935();
            return;
         }

         this.field1256 = 0;
      }

      if(this.field1256 >= var5) {
         if(this.field1254 >= 0) {
            this.method1329();
            this.method3935();
            return;
         }

         this.field1256 = var5 - 1;
      }

      this.field1256 += this.field1254 * var1;
      if(this.field1260 < 0) {
         if(!this.field1263) {
            if(this.field1254 < 0) {
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var4 - 1 - (var4 - 1 - this.field1256) % var6;
            } else {
               if(this.field1256 < var4) {
                  return;
               }

               this.field1256 = var3 + (this.field1256 - var3) % var6;
            }

         } else {
            if(this.field1254 < 0) {
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var3 + var3 - 1 - this.field1256;
               this.field1254 = -this.field1254;
            }

            while(this.field1256 >= var4) {
               this.field1256 = var4 + var4 - 1 - this.field1256;
               this.field1254 = -this.field1254;
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var3 + var3 - 1 - this.field1256;
               this.field1254 = -this.field1254;
            }

         }
      } else {
         if(this.field1260 > 0) {
            if(this.field1263) {
               label162: {
                  if(this.field1254 < 0) {
                     if(this.field1256 >= var3) {
                        return;
                     }

                     this.field1256 = var3 + var3 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                     if(--this.field1260 == 0) {
                        break label162;
                     }
                  }

                  do {
                     if(this.field1256 < var4) {
                        return;
                     }

                     this.field1256 = var4 + var4 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                     if(--this.field1260 == 0) {
                        break;
                     }

                     if(this.field1256 >= var3) {
                        return;
                     }

                     this.field1256 = var3 + var3 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                  } while(--this.field1260 != 0);
               }
            } else {
               label194: {
                  int var7;
                  if(this.field1254 < 0) {
                     if(this.field1256 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1256) / var6;
                     if(var7 >= this.field1260) {
                        this.field1256 += var6 * this.field1260;
                        this.field1260 = 0;
                        break label194;
                     }

                     this.field1256 += var6 * var7;
                     this.field1260 -= var7;
                  } else {
                     if(this.field1256 < var4) {
                        return;
                     }

                     var7 = (this.field1256 - var3) / var6;
                     if(var7 >= this.field1260) {
                        this.field1256 -= var6 * this.field1260;
                        this.field1260 = 0;
                        break label194;
                     }

                     this.field1256 -= var6 * var7;
                     this.field1260 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1254 < 0) {
            if(this.field1256 < 0) {
               this.field1256 = -1;
               this.method1329();
               this.method3935();
            }
         } else if(this.field1256 >= var5) {
            this.field1256 = var5;
            this.method1329();
            this.method3935();
         }

      }
   }

   @ObfuscatedName("ad")
   int method1342(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1255 > 0) {
            int var6 = var2 + this.field1255;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1255 += var2;
            if(this.field1254 == -256 && (this.field1256 & 255) == 0) {
               if(class56.field1194) {
                  var2 = method1355(0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, this.field1266, this.field1267, 0, var6, var3, this);
               } else {
                  var2 = method1396(((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, this.field1265, 0, var6, var3, this);
               }
            } else if(class56.field1194) {
               var2 = method1359(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, this.field1266, this.field1267, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1446(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, this.field1265, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1255 -= var2;
            if(this.field1255 != 0) {
               return var2;
            }

            if(!this.method1366()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == -256 && (this.field1256 & 255) == 0) {
            if(class56.field1194) {
               return method1321(0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, 0, var4, var3, this);
            }

            return method1346(((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, 0, var4, var3, this);
         }

         if(class56.field1194) {
            return method1351(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, 0, var4, var3, this, this.field1254, var5);
         }

         return method1350(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("at")
   static int method1345(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aw")
   static int method1346(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   static int method1348(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ax")
   static int method1349(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1256 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("an")
   static int method1350(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   static int method1351(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1256 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ap")
   static int method1352(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1258 += var9.field1266 * (var6 - var3);
      var9.field1259 += var9.field1267 * (var6 - var3);

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

      var9.field1257 = var4 >> 2;
      var9.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bo")
   static int method1355(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1257 += var12.field1265 * (var9 - var4);
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

      var12.field1258 = var5 >> 2;
      var12.field1259 = var6 >> 2;
      var12.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   static int method1356(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1258 -= var11.field1266 * var5;
      var11.field1259 -= var11.field1267 * var5;
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

      var11.field1258 += var11.field1266 * var5;
      var11.field1259 += var11.field1267 * var5;
      var11.field1257 = var6;
      var11.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("bg")
   static int method1359(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1257 -= var13.field1265 * var5;
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
      var13.field1257 += var13.field1265 * var5;
      var13.field1258 = var6;
      var13.field1259 = var7;
      var13.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("ao")
   boolean method1366() {
      int var1 = this.field1261;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1388(var1, this.field1264);
         var3 = method1456(var1, this.field1264);
      }

      if(this.field1257 == var1 && this.field1258 == var2 && this.field1259 == var3) {
         if(this.field1261 == Integer.MIN_VALUE) {
            this.field1261 = 0;
            this.field1259 = 0;
            this.field1258 = 0;
            this.field1257 = 0;
            this.method3935();
            return true;
         } else {
            this.method1320();
            return false;
         }
      } else {
         if(this.field1257 < var1) {
            this.field1265 = 1;
            this.field1255 = var1 - this.field1257;
         } else if(this.field1257 > var1) {
            this.field1265 = -1;
            this.field1255 = this.field1257 - var1;
         } else {
            this.field1265 = 0;
         }

         if(this.field1258 < var2) {
            this.field1266 = 1;
            if(this.field1255 == 0 || this.field1255 > var2 - this.field1258) {
               this.field1255 = var2 - this.field1258;
            }
         } else if(this.field1258 > var2) {
            this.field1266 = -1;
            if(this.field1255 == 0 || this.field1255 > this.field1258 - var2) {
               this.field1255 = this.field1258 - var2;
            }
         } else {
            this.field1266 = 0;
         }

         if(this.field1259 < var3) {
            this.field1267 = 1;
            if(this.field1255 == 0 || this.field1255 > var3 - this.field1259) {
               this.field1255 = var3 - this.field1259;
            }
         } else if(this.field1259 > var3) {
            this.field1267 = -1;
            if(this.field1255 == 0 || this.field1255 > this.field1259 - var3) {
               this.field1255 = this.field1259 - var3;
            }
         } else {
            this.field1267 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   public synchronized void method1373(int var1) {
      int var2 = ((class62)super.field1271).field1238.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1256 = var1;
   }

   @ObfuscatedName("q")
   synchronized void method1380(int var1, int var2) {
      this.field1261 = var1;
      this.field1264 = var2;
      this.field1255 = 0;
      this.method1320();
   }

   @ObfuscatedName("bd")
   static int method1383(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1257 += var12.field1265 * (var9 - var4);
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

      var12.field1258 = var5 >> 2;
      var12.field1259 = var6 >> 2;
      var12.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("s")
   public synchronized void method1386(int var1) {
      this.method1380(var1 << 6, this.method1326());
   }

   @ObfuscatedName("w")
   static int method1388(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bb")
   static int method1396(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1258 += var9.field1266 * (var6 - var3);
      var9.field1259 += var9.field1267 * (var6 - var3);

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

      var9.field1257 = var4 >> 2;
      var9.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("y")
   protected class66 vmethod3729() {
      return null;
   }

   @ObfuscatedName("aq")
   static int method1414(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("ah")
   public synchronized void method1428(int var1) {
      if(this.field1254 < 0) {
         this.field1254 = -var1;
      } else {
         this.field1254 = var1;
      }

   }

   @ObfuscatedName("ag")
   int method1430(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1255 > 0) {
            int var6 = var2 + this.field1255;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1255 += var2;
            if(this.field1254 == 256 && (this.field1256 & 255) == 0) {
               if(class56.field1194) {
                  var2 = method1383(0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, this.field1266, this.field1267, 0, var6, var3, this);
               } else {
                  var2 = method1352(((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, this.field1265, 0, var6, var3, this);
               }
            } else if(class56.field1194) {
               var2 = method1445(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, this.field1266, this.field1267, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1356(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, this.field1265, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1255 -= var2;
            if(this.field1255 != 0) {
               return var2;
            }

            if(!this.method1366()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == 256 && (this.field1256 & 255) == 0) {
            if(class56.field1194) {
               return method1345(0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, 0, var4, var3, this);
            }

            return method1348(((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, 0, var4, var3, this);
         }

         if(class56.field1194) {
            return method1349(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1258, this.field1259, 0, var4, var3, this, this.field1254, var5);
         }

         return method1414(0, 0, ((class62)super.field1271).field1238, var1, this.field1256, var2, this.field1257, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("ae")
   public synchronized int method1442() {
      return this.field1254 < 0?-this.field1254:this.field1254;
   }

   @ObfuscatedName("bp")
   static int method1445(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1257 -= var13.field1265 * var5;
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
      var13.field1257 += var13.field1265 * var5;
      var13.field1258 = var6;
      var13.field1259 = var7;
      var13.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1446(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1258 -= var11.field1266 * var5;
      var11.field1259 -= var11.field1267 * var5;
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

      var11.field1258 += var11.field1266 * var5;
      var11.field1259 += var11.field1267 * var5;
      var11.field1257 = var6;
      var11.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("c")
   protected int vmethod3745() {
      return this.field1261 == 0 && this.field1255 == 0?0:1;
   }

   @ObfuscatedName("x")
   static int method1456(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }
}
