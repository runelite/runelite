import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class64 extends class66 {
   @ObfuscatedName("g")
   int field1215;
   @ObfuscatedName("k")
   int field1216;
   @ObfuscatedName("j")
   int field1217;
   @ObfuscatedName("c")
   int field1218;
   @ObfuscatedName("x")
   int field1219;
   @ObfuscatedName("d")
   int field1220;
   @ObfuscatedName("r")
   int field1221;
   @ObfuscatedName("y")
   int field1222;
   @ObfuscatedName("l")
   int field1223;
   @ObfuscatedName("u")
   int field1224;
   @ObfuscatedName("p")
   boolean field1225;
   @ObfuscatedName("n")
   int field1226;
   @ObfuscatedName("z")
   int field1227;
   @ObfuscatedName("b")
   int field1228;
   @ObfuscatedName("o")
   int field1229;

   @ObfuscatedName("g")
   static int method1308(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("as")
   int vmethod1468() {
      int var1 = this.field1219 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1218 == 0) {
         var1 -= var1 * this.field1228 / (((class62)super.field1233).field1198.length << 8);
      } else if(this.field1218 >= 0) {
         var1 -= var1 * this.field1223 / ((class62)super.field1233).field1198.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("y")
   protected class66 vmethod3722() {
      return null;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1233 = var1;
      this.field1223 = var1.field1200;
      this.field1224 = var1.field1201;
      this.field1225 = var1.field1202;
      this.field1215 = var2;
      this.field1217 = var3;
      this.field1220 = var4;
      this.field1228 = 0;
      this.method1313();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass62;II)Lclass64;",
      garbageValue = "100"
   )
   public static class64 method1311(class62 var0, int var1, int var2) {
      return var0.field1198 != null && var0.field1198.length != 0?new class64(var0, (int)((long)var0.field1199 * 256L * (long)var1 / (long)(class56.field1153 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("d")
   public static class64 method1312(class62 var0, int var1, int var2, int var3) {
      return var0.field1198 != null && var0.field1198.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("x")
   void method1313() {
      this.field1219 = this.field1217;
      this.field1222 = method1441(this.field1217, this.field1220);
      this.field1221 = method1308(this.field1217, this.field1220);
   }

   @ObfuscatedName("u")
   public synchronized void method1314(int var1) {
      this.field1218 = var1;
   }

   @ObfuscatedName("n")
   public synchronized void method1315(int var1) {
      this.method1317(var1 << 6, this.method1319());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1316(int var1) {
      this.method1317(var1, this.method1319());
   }

   @ObfuscatedName("z")
   synchronized void method1317(int var1, int var2) {
      this.field1217 = var1;
      this.field1220 = var2;
      this.field1226 = 0;
      this.method1313();
   }

   @ObfuscatedName("k")
   public synchronized int method1318() {
      return this.field1217 == Integer.MIN_VALUE?0:this.field1217;
   }

   @ObfuscatedName("o")
   public synchronized int method1319() {
      return this.field1220 < 0?-1:this.field1220;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1321() {
      this.field1215 = (this.field1215 ^ this.field1215 >> 31) + (this.field1215 >>> 31);
      this.field1215 = -this.field1215;
   }

   @ObfuscatedName("v")
   void method1322() {
      if(this.field1226 != 0) {
         if(this.field1217 == Integer.MIN_VALUE) {
            this.field1217 = 0;
         }

         this.field1226 = 0;
         this.method1313();
      }

   }

   @ObfuscatedName("a")
   public synchronized void method1323(int var1, int var2) {
      this.method1324(var1, var2, this.method1319());
   }

   @ObfuscatedName("f")
   public synchronized void method1324(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1317(var2, var3);
      } else {
         int var4 = method1441(var2, var3);
         int var5 = method1308(var2, var3);
         if(this.field1222 == var4 && this.field1221 == var5) {
            this.field1226 = 0;
         } else {
            int var6 = var2 - this.field1219;
            if(this.field1219 - var2 > var6) {
               var6 = this.field1219 - var2;
            }

            if(var4 - this.field1222 > var6) {
               var6 = var4 - this.field1222;
            }

            if(this.field1222 - var4 > var6) {
               var6 = this.field1222 - var4;
            }

            if(var5 - this.field1221 > var6) {
               var6 = var5 - this.field1221;
            }

            if(this.field1221 - var5 > var6) {
               var6 = this.field1221 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1226 = var1;
            this.field1217 = var2;
            this.field1220 = var3;
            this.field1227 = (var2 - this.field1219) / var1;
            this.field1216 = (var4 - this.field1222) / var1;
            this.field1229 = (var5 - this.field1221) / var1;
         }
      }
   }

   @ObfuscatedName("m")
   public synchronized void method1326(int var1) {
      if(this.field1215 < 0) {
         this.field1215 = -var1;
      } else {
         this.field1215 = var1;
      }

   }

   @ObfuscatedName("ac")
   public boolean method1329() {
      return this.field1226 != 0;
   }

   @ObfuscatedName("ba")
   static int method1330(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1219 -= var13.field1227 * var5;
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
      var13.field1219 += var13.field1227 * var5;
      var13.field1222 = var6;
      var13.field1221 = var7;
      var13.field1228 = var4;
      return var5;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3721(int[] var1, int var2, int var3) {
      if(this.field1217 == 0 && this.field1226 == 0) {
         this.vmethod3725(var3);
      } else {
         class62 var4 = (class62)super.field1233;
         int var5 = this.field1223 << 8;
         int var6 = this.field1224 << 8;
         int var7 = var4.field1198.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1218 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1228 < 0) {
            if(this.field1215 <= 0) {
               this.method1322();
               this.method3916();
               return;
            }

            this.field1228 = 0;
         }

         if(this.field1228 >= var7) {
            if(this.field1215 >= 0) {
               this.method1322();
               this.method3916();
               return;
            }

            this.field1228 = var7 - 1;
         }

         if(this.field1218 < 0) {
            if(this.field1225) {
               if(this.field1215 < 0) {
                  var9 = this.method1462(var1, var2, var5, var3, var4.field1198[this.field1223]);
                  if(this.field1228 >= var5) {
                     return;
                  }

                  this.field1228 = var5 + var5 - 1 - this.field1228;
                  this.field1215 = -this.field1215;
               }

               while(true) {
                  var9 = this.method1458(var1, var9, var6, var3, var4.field1198[this.field1224 - 1]);
                  if(this.field1228 < var6) {
                     return;
                  }

                  this.field1228 = var6 + var6 - 1 - this.field1228;
                  this.field1215 = -this.field1215;
                  var9 = this.method1462(var1, var9, var5, var3, var4.field1198[this.field1223]);
                  if(this.field1228 >= var5) {
                     return;
                  }

                  this.field1228 = var5 + var5 - 1 - this.field1228;
                  this.field1215 = -this.field1215;
               }
            } else if(this.field1215 < 0) {
               while(true) {
                  var9 = this.method1462(var1, var9, var5, var3, var4.field1198[this.field1224 - 1]);
                  if(this.field1228 >= var5) {
                     return;
                  }

                  this.field1228 = var6 - 1 - (var6 - 1 - this.field1228) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1458(var1, var9, var6, var3, var4.field1198[this.field1223]);
                  if(this.field1228 < var6) {
                     return;
                  }

                  this.field1228 = var5 + (this.field1228 - var5) % var8;
               }
            }
         } else {
            if(this.field1218 > 0) {
               if(this.field1225) {
                  label183: {
                     if(this.field1215 < 0) {
                        var9 = this.method1462(var1, var2, var5, var3, var4.field1198[this.field1223]);
                        if(this.field1228 >= var5) {
                           return;
                        }

                        this.field1228 = var5 + var5 - 1 - this.field1228;
                        this.field1215 = -this.field1215;
                        if(--this.field1218 == 0) {
                           break label183;
                        }
                     }

                     do {
                        var9 = this.method1458(var1, var9, var6, var3, var4.field1198[this.field1224 - 1]);
                        if(this.field1228 < var6) {
                           return;
                        }

                        this.field1228 = var6 + var6 - 1 - this.field1228;
                        this.field1215 = -this.field1215;
                        if(--this.field1218 == 0) {
                           break;
                        }

                        var9 = this.method1462(var1, var9, var5, var3, var4.field1198[this.field1223]);
                        if(this.field1228 >= var5) {
                           return;
                        }

                        this.field1228 = var5 + var5 - 1 - this.field1228;
                        this.field1215 = -this.field1215;
                     } while(--this.field1218 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1215 < 0) {
                     while(true) {
                        var9 = this.method1462(var1, var9, var5, var3, var4.field1198[this.field1224 - 1]);
                        if(this.field1228 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1228) / var8;
                        if(var10 >= this.field1218) {
                           this.field1228 += var8 * this.field1218;
                           this.field1218 = 0;
                           break;
                        }

                        this.field1228 += var8 * var10;
                        this.field1218 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1458(var1, var9, var6, var3, var4.field1198[this.field1223]);
                        if(this.field1228 < var6) {
                           return;
                        }

                        var10 = (this.field1228 - var5) / var8;
                        if(var10 >= this.field1218) {
                           this.field1228 -= var8 * this.field1218;
                           this.field1218 = 0;
                           break;
                        }

                        this.field1228 -= var8 * var10;
                        this.field1218 -= var10;
                     }
                  }
               }
            }

            if(this.field1215 < 0) {
               this.method1462(var1, var9, 0, var3, 0);
               if(this.field1228 < 0) {
                  this.field1228 = -1;
                  this.method1322();
                  this.method3916();
               }
            } else {
               this.method1458(var1, var9, var7, var3, 0);
               if(this.field1228 >= var7) {
                  this.field1228 = var7;
                  this.method1322();
                  this.method3916();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   protected class66 vmethod3736() {
      return null;
   }

   @ObfuscatedName("au")
   static int method1337(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1228 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   static int method1339(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1228 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("am")
   static int method1341(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1228 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   static int method1343(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1228 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ao")
   static int method1345(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1228 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("al")
   static int method1346(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1222 += var9.field1216 * (var6 - var3);
      var9.field1221 += var9.field1229 * (var6 - var3);

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

      var9.field1219 = var4 >> 2;
      var9.field1228 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ap")
   static int method1347(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1219 += var12.field1227 * (var9 - var4);
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

      var12.field1222 = var5 >> 2;
      var12.field1221 = var6 >> 2;
      var12.field1228 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   static int method1348(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1222 += var9.field1216 * (var6 - var3);
      var9.field1221 += var9.field1229 * (var6 - var3);

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

      var9.field1219 = var4 >> 2;
      var9.field1228 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   static int method1349(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1219 += var12.field1227 * (var9 - var4);
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

      var12.field1222 = var5 >> 2;
      var12.field1221 = var6 >> 2;
      var12.field1228 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("be")
   static int method1351(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1219 -= var13.field1227 * var5;
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
      var13.field1219 += var13.field1227 * var5;
      var13.field1222 = var6;
      var13.field1221 = var7;
      var13.field1228 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   static int method1352(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1222 -= var11.field1216 * var5;
      var11.field1221 -= var11.field1229 * var5;
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

      var11.field1222 += var11.field1216 * var5;
      var11.field1221 += var11.field1229 * var5;
      var11.field1219 = var6;
      var11.field1228 = var4;
      return var5;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1233 = var1;
      this.field1223 = var1.field1200;
      this.field1224 = var1.field1201;
      this.field1225 = var1.field1202;
      this.field1215 = var2;
      this.field1217 = var3;
      this.field1220 = 8192;
      this.field1228 = 0;
      this.method1313();
   }

   @ObfuscatedName("q")
   public synchronized void method1362(int var1) {
      if(var1 == 0) {
         this.method1316(0);
         this.method3916();
      } else if(this.field1222 == 0 && this.field1221 == 0) {
         this.field1226 = 0;
         this.field1217 = 0;
         this.field1219 = 0;
         this.method3916();
      } else {
         int var2 = -this.field1219;
         if(this.field1219 > var2) {
            var2 = this.field1219;
         }

         if(-this.field1222 > var2) {
            var2 = -this.field1222;
         }

         if(this.field1222 > var2) {
            var2 = this.field1222;
         }

         if(-this.field1221 > var2) {
            var2 = -this.field1221;
         }

         if(this.field1221 > var2) {
            var2 = this.field1221;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1226 = var1;
         this.field1217 = Integer.MIN_VALUE;
         this.field1227 = -this.field1219 / var1;
         this.field1216 = -this.field1222 / var1;
         this.field1229 = -this.field1221 / var1;
      }
   }

   @ObfuscatedName("ax")
   public boolean method1391() {
      return this.field1228 < 0 || this.field1228 >= ((class62)super.field1233).field1198.length << 8;
   }

   @ObfuscatedName("bs")
   static int method1396(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1222 -= var11.field1216 * var5;
      var11.field1221 -= var11.field1229 * var5;
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

      var11.field1222 += var11.field1216 * var5;
      var11.field1221 += var11.field1229 * var5;
      var11.field1219 = var6;
      var11.field1228 = var4;
      return var5;
   }

   @ObfuscatedName("p")
   public synchronized void vmethod3725(int var1) {
      if(this.field1226 > 0) {
         if(var1 >= this.field1226) {
            if(this.field1217 == Integer.MIN_VALUE) {
               this.field1217 = 0;
               this.field1221 = 0;
               this.field1222 = 0;
               this.field1219 = 0;
               this.method3916();
               var1 = this.field1226;
            }

            this.field1226 = 0;
            this.method1313();
         } else {
            this.field1219 += this.field1227 * var1;
            this.field1222 += this.field1216 * var1;
            this.field1221 += this.field1229 * var1;
            this.field1226 -= var1;
         }
      }

      class62 var2 = (class62)super.field1233;
      int var3 = this.field1223 << 8;
      int var4 = this.field1224 << 8;
      int var5 = var2.field1198.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1218 = 0;
      }

      if(this.field1228 < 0) {
         if(this.field1215 <= 0) {
            this.method1322();
            this.method3916();
            return;
         }

         this.field1228 = 0;
      }

      if(this.field1228 >= var5) {
         if(this.field1215 >= 0) {
            this.method1322();
            this.method3916();
            return;
         }

         this.field1228 = var5 - 1;
      }

      this.field1228 += this.field1215 * var1;
      if(this.field1218 < 0) {
         if(!this.field1225) {
            if(this.field1215 < 0) {
               if(this.field1228 >= var3) {
                  return;
               }

               this.field1228 = var4 - 1 - (var4 - 1 - this.field1228) % var6;
            } else {
               if(this.field1228 < var4) {
                  return;
               }

               this.field1228 = var3 + (this.field1228 - var3) % var6;
            }

         } else {
            if(this.field1215 < 0) {
               if(this.field1228 >= var3) {
                  return;
               }

               this.field1228 = var3 + var3 - 1 - this.field1228;
               this.field1215 = -this.field1215;
            }

            while(this.field1228 >= var4) {
               this.field1228 = var4 + var4 - 1 - this.field1228;
               this.field1215 = -this.field1215;
               if(this.field1228 >= var3) {
                  return;
               }

               this.field1228 = var3 + var3 - 1 - this.field1228;
               this.field1215 = -this.field1215;
            }

         }
      } else {
         if(this.field1218 > 0) {
            if(this.field1225) {
               label172: {
                  if(this.field1215 < 0) {
                     if(this.field1228 >= var3) {
                        return;
                     }

                     this.field1228 = var3 + var3 - 1 - this.field1228;
                     this.field1215 = -this.field1215;
                     if(--this.field1218 == 0) {
                        break label172;
                     }
                  }

                  do {
                     if(this.field1228 < var4) {
                        return;
                     }

                     this.field1228 = var4 + var4 - 1 - this.field1228;
                     this.field1215 = -this.field1215;
                     if(--this.field1218 == 0) {
                        break;
                     }

                     if(this.field1228 >= var3) {
                        return;
                     }

                     this.field1228 = var3 + var3 - 1 - this.field1228;
                     this.field1215 = -this.field1215;
                  } while(--this.field1218 != 0);
               }
            } else {
               int var7;
               if(this.field1215 < 0) {
                  if(this.field1228 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1228) / var6;
                  if(var7 < this.field1218) {
                     this.field1228 += var6 * var7;
                     this.field1218 -= var7;
                     return;
                  }

                  this.field1228 += var6 * this.field1218;
                  this.field1218 = 0;
               } else {
                  if(this.field1228 < var4) {
                     return;
                  }

                  var7 = (this.field1228 - var3) / var6;
                  if(var7 < this.field1218) {
                     this.field1228 -= var6 * var7;
                     this.field1218 -= var7;
                     return;
                  }

                  this.field1228 -= var6 * this.field1218;
                  this.field1218 = 0;
               }
            }
         }

         if(this.field1215 < 0) {
            if(this.field1228 < 0) {
               this.field1228 = -1;
               this.method1322();
               this.method3916();
            }
         } else if(this.field1228 >= var5) {
            this.field1228 = var5;
            this.method1322();
            this.method3916();
         }

      }
   }

   @ObfuscatedName("at")
   static int method1404(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1228 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("t")
   public synchronized void method1411(int var1) {
      int var2 = ((class62)super.field1233).field1198.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1228 = var1;
   }

   @ObfuscatedName("az")
   public synchronized int method1418() {
      return this.field1215 < 0?-this.field1215:this.field1215;
   }

   @ObfuscatedName("ad")
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

      var10.field1228 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   boolean method1436() {
      int var1 = this.field1217;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1441(var1, this.field1220);
         var3 = method1308(var1, this.field1220);
      }

      if(this.field1219 == var1 && this.field1222 == var2 && this.field1221 == var3) {
         if(this.field1217 == Integer.MIN_VALUE) {
            this.field1217 = 0;
            this.field1221 = 0;
            this.field1222 = 0;
            this.field1219 = 0;
            this.method3916();
            return true;
         } else {
            this.method1313();
            return false;
         }
      } else {
         if(this.field1219 < var1) {
            this.field1227 = 1;
            this.field1226 = var1 - this.field1219;
         } else if(this.field1219 > var1) {
            this.field1227 = -1;
            this.field1226 = this.field1219 - var1;
         } else {
            this.field1227 = 0;
         }

         if(this.field1222 < var2) {
            this.field1216 = 1;
            if(this.field1226 == 0 || this.field1226 > var2 - this.field1222) {
               this.field1226 = var2 - this.field1222;
            }
         } else if(this.field1222 > var2) {
            this.field1216 = -1;
            if(this.field1226 == 0 || this.field1226 > this.field1222 - var2) {
               this.field1226 = this.field1222 - var2;
            }
         } else {
            this.field1216 = 0;
         }

         if(this.field1221 < var3) {
            this.field1229 = 1;
            if(this.field1226 == 0 || this.field1226 > var3 - this.field1221) {
               this.field1226 = var3 - this.field1221;
            }
         } else if(this.field1221 > var3) {
            this.field1229 = -1;
            if(this.field1226 == 0 || this.field1226 > this.field1221 - var3) {
               this.field1226 = this.field1221 - var3;
            }
         } else {
            this.field1229 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   protected int vmethod3724() {
      return this.field1217 == 0 && this.field1226 == 0?0:1;
   }

   @ObfuscatedName("b")
   static int method1441(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ab")
   static int method1446(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1228 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   int method1458(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1226 > 0) {
            int var6 = var2 + this.field1226;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1226 += var2;
            if(this.field1215 == 256 && (this.field1228 & 255) == 0) {
               if(class21.field581) {
                  var2 = method1347(0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, this.field1216, this.field1229, 0, var6, var3, this);
               } else {
                  var2 = method1346(((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, this.field1227, 0, var6, var3, this);
               }
            } else if(class21.field581) {
               var2 = method1351(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, this.field1216, this.field1229, 0, var6, var3, this, this.field1215, var5);
            } else {
               var2 = method1396(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, this.field1227, 0, var6, var3, this, this.field1215, var5);
            }

            this.field1226 -= var2;
            if(this.field1226 != 0) {
               return var2;
            }

            if(!this.method1436()) {
               continue;
            }

            return var4;
         }

         if(this.field1215 == 256 && (this.field1228 & 255) == 0) {
            if(class21.field581) {
               return method1339(0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, 0, var4, var3, this);
            }

            return method1337(((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, 0, var4, var3, this);
         }

         if(class21.field581) {
            return method1343(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, 0, var4, var3, this, this.field1215, var5);
         }

         return method1446(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, 0, var4, var3, this, this.field1215, var5);
      }
   }

   @ObfuscatedName("ay")
   int method1462(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1226 > 0) {
            int var6 = var2 + this.field1226;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1226 += var2;
            if(this.field1215 == -256 && (this.field1228 & 255) == 0) {
               if(class21.field581) {
                  var2 = method1349(0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, this.field1216, this.field1229, 0, var6, var3, this);
               } else {
                  var2 = method1348(((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, this.field1227, 0, var6, var3, this);
               }
            } else if(class21.field581) {
               var2 = method1330(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, this.field1216, this.field1229, 0, var6, var3, this, this.field1215, var5);
            } else {
               var2 = method1352(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, this.field1227, 0, var6, var3, this, this.field1215, var5);
            }

            this.field1226 -= var2;
            if(this.field1226 != 0) {
               return var2;
            }

            if(!this.method1436()) {
               continue;
            }

            return var4;
         }

         if(this.field1215 == -256 && (this.field1228 & 255) == 0) {
            if(class21.field581) {
               return method1341(0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, 0, var4, var3, this);
            }

            return method1404(((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, 0, var4, var3, this);
         }

         if(class21.field581) {
            return method1345(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1222, this.field1221, 0, var4, var3, this, this.field1215, var5);
         }

         return method1429(0, 0, ((class62)super.field1233).field1198, var1, this.field1228, var2, this.field1219, 0, var4, var3, this, this.field1215, var5);
      }
   }
}
