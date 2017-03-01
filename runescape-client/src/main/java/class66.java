import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class66 extends class68 {
   @ObfuscatedName("x")
   int field1129;
   @ObfuscatedName("s")
   boolean field1130;
   @ObfuscatedName("g")
   int field1131;
   @ObfuscatedName("v")
   int field1132;
   @ObfuscatedName("i")
   int field1133;
   @ObfuscatedName("p")
   int field1134;
   @ObfuscatedName("n")
   int field1135;
   @ObfuscatedName("m")
   int field1136;
   @ObfuscatedName("a")
   int field1137;
   @ObfuscatedName("k")
   int field1138;
   @ObfuscatedName("y")
   int field1139;
   @ObfuscatedName("q")
   int field1140;
   @ObfuscatedName("f")
   int field1141;
   @ObfuscatedName("o")
   int field1142;
   @ObfuscatedName("j")
   int field1143;

   @ObfuscatedName("g")
   public static class66 method1256(class55 var0, int var1, int var2) {
      return var0.field1034 != null && var0.field1034.length != 0?new class66(var0, (int)((long)var0.field1035 * 256L * (long)var1 / (long)(class57.field1053 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("v")
   public static class66 method1257(class55 var0, int var1, int var2, int var3) {
      return var0.field1034 != null && var0.field1034.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("y")
   void method1258() {
      this.field1139 = this.field1131;
      this.field1134 = method1275(this.field1131, this.field1132);
      this.field1143 = method1356(this.field1131, this.field1132);
   }

   @ObfuscatedName("f")
   public synchronized void method1259(int var1) {
      this.field1136 = var1;
   }

   @ObfuscatedName("q")
   public synchronized void method1260(int var1) {
      this.method1262(var1 << 6, this.method1264());
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1261(int var1) {
      this.method1262(var1, this.method1264());
   }

   @ObfuscatedName("b")
   synchronized void method1262(int var1, int var2) {
      this.field1131 = var1;
      this.field1132 = var2;
      this.field1138 = 0;
      this.method1258();
   }

   @ObfuscatedName("l")
   public synchronized int method1264() {
      return this.field1132 < 0?-1:this.field1132;
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1159 = var1;
      this.field1137 = var1.field1036;
      this.field1133 = var1.field1033;
      this.field1130 = var1.field1037;
      this.field1135 = var2;
      this.field1131 = var3;
      this.field1132 = var4;
      this.field1129 = 0;
      this.method1258();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1265() {
      this.field1135 = (this.field1135 ^ this.field1135 >> 31) + (this.field1135 >>> 31);
      this.field1135 = -this.field1135;
   }

   @ObfuscatedName("e")
   void method1266() {
      if(this.field1138 != 0) {
         if(this.field1131 == Integer.MIN_VALUE) {
            this.field1131 = 0;
         }

         this.field1138 = 0;
         this.method1258();
      }

   }

   @ObfuscatedName("h")
   public synchronized void method1267(int var1, int var2) {
      this.method1268(var1, var2, this.method1264());
   }

   @ObfuscatedName("d")
   public synchronized void method1268(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1262(var2, var3);
      } else {
         int var4 = method1275(var2, var3);
         int var5 = method1356(var2, var3);
         if(this.field1134 == var4 && this.field1143 == var5) {
            this.field1138 = 0;
         } else {
            int var6 = var2 - this.field1139;
            if(this.field1139 - var2 > var6) {
               var6 = this.field1139 - var2;
            }

            if(var4 - this.field1134 > var6) {
               var6 = var4 - this.field1134;
            }

            if(this.field1134 - var4 > var6) {
               var6 = this.field1134 - var4;
            }

            if(var5 - this.field1143 > var6) {
               var6 = var5 - this.field1143;
            }

            if(this.field1143 - var5 > var6) {
               var6 = this.field1143 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1138 = var1;
            this.field1131 = var2;
            this.field1132 = var3;
            this.field1141 = (var2 - this.field1139) / var1;
            this.field1142 = (var4 - this.field1134) / var1;
            this.field1140 = (var5 - this.field1143) / var1;
         }
      }
   }

   @ObfuscatedName("as")
   public synchronized void method1269(int var1) {
      if(var1 == 0) {
         this.method1261(0);
         this.unlink();
      } else if(this.field1134 == 0 && this.field1143 == 0) {
         this.field1138 = 0;
         this.field1131 = 0;
         this.field1139 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1139;
         if(this.field1139 > var2) {
            var2 = this.field1139;
         }

         if(-this.field1134 > var2) {
            var2 = -this.field1134;
         }

         if(this.field1134 > var2) {
            var2 = this.field1134;
         }

         if(-this.field1143 > var2) {
            var2 = -this.field1143;
         }

         if(this.field1143 > var2) {
            var2 = this.field1143;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1138 = var1;
         this.field1131 = Integer.MIN_VALUE;
         this.field1141 = -this.field1139 / var1;
         this.field1142 = -this.field1134 / var1;
         this.field1140 = -this.field1143 / var1;
      }
   }

   @ObfuscatedName("ao")
   public synchronized void method1270(int var1) {
      if(this.field1135 < 0) {
         this.field1135 = -var1;
      } else {
         this.field1135 = var1;
      }

   }

   @ObfuscatedName("ax")
   public synchronized int method1271() {
      return this.field1135 < 0?-this.field1135:this.field1135;
   }

   @ObfuscatedName("an")
   public boolean method1272() {
      return this.field1129 < 0 || this.field1129 >= ((class55)super.field1159).field1034.length << 8;
   }

   @ObfuscatedName("aj")
   public boolean method1273() {
      return this.field1138 != 0;
   }

   @ObfuscatedName("av")
   int vmethod1436() {
      int var1 = this.field1139 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1136 == 0) {
         var1 -= var1 * this.field1129 / (((class55)super.field1159).field1034.length << 8);
      } else if(this.field1136 >= 0) {
         var1 -= var1 * this.field1137 / ((class55)super.field1159).field1034.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("x")
   static int method1275(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("s")
   protected int vmethod2767() {
      return this.field1131 == 0 && this.field1138 == 0?0:1;
   }

   @ObfuscatedName("k")
   public synchronized void vmethod2780(int[] var1, int var2, int var3) {
      if(this.field1131 == 0 && this.field1138 == 0) {
         this.vmethod2769(var3);
      } else {
         class55 var4 = (class55)super.field1159;
         int var5 = this.field1137 << 8;
         int var6 = this.field1133 << 8;
         int var7 = var4.field1034.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1136 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1129 < 0) {
            if(this.field1135 <= 0) {
               this.method1266();
               this.unlink();
               return;
            }

            this.field1129 = 0;
         }

         if(this.field1129 >= var7) {
            if(this.field1135 >= 0) {
               this.method1266();
               this.unlink();
               return;
            }

            this.field1129 = var7 - 1;
         }

         if(this.field1136 < 0) {
            if(this.field1130) {
               if(this.field1135 < 0) {
                  var9 = this.method1301(var1, var2, var5, var3, var4.field1034[this.field1137]);
                  if(this.field1129 >= var5) {
                     return;
                  }

                  this.field1129 = var5 + var5 - 1 - this.field1129;
                  this.field1135 = -this.field1135;
               }

               while(true) {
                  var9 = this.method1291(var1, var9, var6, var3, var4.field1034[this.field1133 - 1]);
                  if(this.field1129 < var6) {
                     return;
                  }

                  this.field1129 = var6 + var6 - 1 - this.field1129;
                  this.field1135 = -this.field1135;
                  var9 = this.method1301(var1, var9, var5, var3, var4.field1034[this.field1137]);
                  if(this.field1129 >= var5) {
                     return;
                  }

                  this.field1129 = var5 + var5 - 1 - this.field1129;
                  this.field1135 = -this.field1135;
               }
            } else if(this.field1135 < 0) {
               while(true) {
                  var9 = this.method1301(var1, var9, var5, var3, var4.field1034[this.field1133 - 1]);
                  if(this.field1129 >= var5) {
                     return;
                  }

                  this.field1129 = var6 - 1 - (var6 - 1 - this.field1129) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1291(var1, var9, var6, var3, var4.field1034[this.field1137]);
                  if(this.field1129 < var6) {
                     return;
                  }

                  this.field1129 = var5 + (this.field1129 - var5) % var8;
               }
            }
         } else {
            if(this.field1136 > 0) {
               if(this.field1130) {
                  label188: {
                     if(this.field1135 < 0) {
                        var9 = this.method1301(var1, var2, var5, var3, var4.field1034[this.field1137]);
                        if(this.field1129 >= var5) {
                           return;
                        }

                        this.field1129 = var5 + var5 - 1 - this.field1129;
                        this.field1135 = -this.field1135;
                        if(--this.field1136 == 0) {
                           break label188;
                        }
                     }

                     do {
                        var9 = this.method1291(var1, var9, var6, var3, var4.field1034[this.field1133 - 1]);
                        if(this.field1129 < var6) {
                           return;
                        }

                        this.field1129 = var6 + var6 - 1 - this.field1129;
                        this.field1135 = -this.field1135;
                        if(--this.field1136 == 0) {
                           break;
                        }

                        var9 = this.method1301(var1, var9, var5, var3, var4.field1034[this.field1137]);
                        if(this.field1129 >= var5) {
                           return;
                        }

                        this.field1129 = var5 + var5 - 1 - this.field1129;
                        this.field1135 = -this.field1135;
                     } while(--this.field1136 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1135 < 0) {
                     while(true) {
                        var9 = this.method1301(var1, var9, var5, var3, var4.field1034[this.field1133 - 1]);
                        if(this.field1129 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1129) / var8;
                        if(var10 >= this.field1136) {
                           this.field1129 += var8 * this.field1136;
                           this.field1136 = 0;
                           break;
                        }

                        this.field1129 += var8 * var10;
                        this.field1136 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1291(var1, var9, var6, var3, var4.field1034[this.field1137]);
                        if(this.field1129 < var6) {
                           return;
                        }

                        var10 = (this.field1129 - var5) / var8;
                        if(var10 >= this.field1136) {
                           this.field1129 -= var8 * this.field1136;
                           this.field1136 = 0;
                           break;
                        }

                        this.field1129 -= var8 * var10;
                        this.field1136 -= var10;
                     }
                  }
               }
            }

            if(this.field1135 < 0) {
               this.method1301(var1, var9, 0, var3, 0);
               if(this.field1129 < 0) {
                  this.field1129 = -1;
                  this.method1266();
                  this.unlink();
               }
            } else {
               this.method1291(var1, var9, var7, var3, 0);
               if(this.field1129 >= var7) {
                  this.field1129 = var7;
                  this.method1266();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("ay")
   static int method1278(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1129 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ap")
   boolean method1281() {
      int var1 = this.field1131;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1275(var1, this.field1132);
         var3 = method1356(var1, this.field1132);
      }

      if(this.field1139 == var1 && this.field1134 == var2 && this.field1143 == var3) {
         if(this.field1131 == Integer.MIN_VALUE) {
            this.field1131 = 0;
            this.field1143 = 0;
            this.field1134 = 0;
            this.field1139 = 0;
            this.unlink();
            return true;
         } else {
            this.method1258();
            return false;
         }
      } else {
         if(this.field1139 < var1) {
            this.field1141 = 1;
            this.field1138 = var1 - this.field1139;
         } else if(this.field1139 > var1) {
            this.field1141 = -1;
            this.field1138 = this.field1139 - var1;
         } else {
            this.field1141 = 0;
         }

         if(this.field1134 < var2) {
            this.field1142 = 1;
            if(this.field1138 == 0 || this.field1138 > var2 - this.field1134) {
               this.field1138 = var2 - this.field1134;
            }
         } else if(this.field1134 > var2) {
            this.field1142 = -1;
            if(this.field1138 == 0 || this.field1138 > this.field1134 - var2) {
               this.field1138 = this.field1134 - var2;
            }
         } else {
            this.field1142 = 0;
         }

         if(this.field1143 < var3) {
            this.field1140 = 1;
            if(this.field1138 == 0 || this.field1138 > var3 - this.field1143) {
               this.field1138 = var3 - this.field1143;
            }
         } else if(this.field1143 > var3) {
            this.field1140 = -1;
            if(this.field1138 == 0 || this.field1138 > this.field1143 - var3) {
               this.field1138 = this.field1143 - var3;
            }
         } else {
            this.field1140 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ai")
   static int method1284(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1129 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("at")
   static int method1285(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1129 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("am")
   static int method1287(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1129 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   static int method1289(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1139 += var12.field1141 * (var9 - var4);
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

      var12.field1134 = var5 >> 2;
      var12.field1143 = var6 >> 2;
      var12.field1129 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   static int method1290(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1134 += var9.field1142 * (var6 - var3);
      var9.field1143 += var9.field1140 * (var6 - var3);

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

      var9.field1139 = var4 >> 2;
      var9.field1129 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   int method1291(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1138 > 0) {
            int var6 = var2 + this.field1138;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1138 += var2;
            if(this.field1135 == 256 && (this.field1129 & 255) == 0) {
               if(class57.field1059) {
                  var2 = method1289(0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, this.field1142, this.field1140, 0, var6, var3, this);
               } else {
                  var2 = method1290(((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, this.field1141, 0, var6, var3, this);
               }
            } else if(class57.field1059) {
               var2 = method1295(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, this.field1142, this.field1140, 0, var6, var3, this, this.field1135, var5);
            } else {
               var2 = method1401(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, this.field1141, 0, var6, var3, this, this.field1135, var5);
            }

            this.field1138 -= var2;
            if(this.field1138 != 0) {
               return var2;
            }

            if(!this.method1281()) {
               continue;
            }

            return var4;
         }

         if(this.field1135 == 256 && (this.field1129 & 255) == 0) {
            if(class57.field1059) {
               return method1278(0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, 0, var4, var3, this);
            }

            return method1374(((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, 0, var4, var3, this);
         }

         if(class57.field1059) {
            return method1287(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, 0, var4, var3, this, this.field1135, var5);
         }

         return method1395(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, 0, var4, var3, this, this.field1135, var5);
      }
   }

   @ObfuscatedName("br")
   static int method1293(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1139 += var12.field1141 * (var9 - var4);
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

      var12.field1134 = var5 >> 2;
      var12.field1143 = var6 >> 2;
      var12.field1129 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bx")
   static int method1295(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1139 -= var13.field1141 * var5;
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
      var13.field1139 += var13.field1141 * var5;
      var13.field1134 = var6;
      var13.field1143 = var7;
      var13.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1296(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1134 -= var11.field1142 * var5;
      var11.field1143 -= var11.field1140 * var5;
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

      var11.field1134 += var11.field1142 * var5;
      var11.field1143 += var11.field1140 * var5;
      var11.field1139 = var6;
      var11.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   static int method1297(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1139 -= var13.field1141 * var5;
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
      var13.field1139 += var13.field1141 * var5;
      var13.field1134 = var6;
      var13.field1143 = var7;
      var13.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   int method1301(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1138 > 0) {
            int var6 = var2 + this.field1138;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1138 += var2;
            if(this.field1135 == -256 && (this.field1129 & 255) == 0) {
               if(class57.field1059) {
                  var2 = method1293(0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, this.field1142, this.field1140, 0, var6, var3, this);
               } else {
                  var2 = method1366(((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, this.field1141, 0, var6, var3, this);
               }
            } else if(class57.field1059) {
               var2 = method1297(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, this.field1142, this.field1140, 0, var6, var3, this, this.field1135, var5);
            } else {
               var2 = method1296(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, this.field1141, 0, var6, var3, this, this.field1135, var5);
            }

            this.field1138 -= var2;
            if(this.field1138 != 0) {
               return var2;
            }

            if(!this.method1281()) {
               continue;
            }

            return var4;
         }

         if(this.field1135 == -256 && (this.field1129 & 255) == 0) {
            if(class57.field1059) {
               return method1285(0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, 0, var4, var3, this);
            }

            return method1284(((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, 0, var4, var3, this);
         }

         if(class57.field1059) {
            return method1402(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1134, this.field1143, 0, var4, var3, this, this.field1135, var5);
         }

         return method1400(0, 0, ((class55)super.field1159).field1034, var1, this.field1129, var2, this.field1139, 0, var4, var3, this, this.field1135, var5);
      }
   }

   @ObfuscatedName("j")
   protected class68 vmethod2775() {
      return null;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1159 = var1;
      this.field1137 = var1.field1036;
      this.field1133 = var1.field1033;
      this.field1130 = var1.field1037;
      this.field1135 = var2;
      this.field1131 = var3;
      this.field1132 = 8192;
      this.field1129 = 0;
      this.method1258();
   }

   @ObfuscatedName("r")
   public synchronized void method1333(int var1) {
      int var2 = ((class55)super.field1159).field1034.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1129 = var1;
   }

   @ObfuscatedName("p")
   protected class68 vmethod2765() {
      return null;
   }

   @ObfuscatedName("n")
   static int method1356(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("o")
   public synchronized void vmethod2769(int var1) {
      if(this.field1138 > 0) {
         if(var1 >= this.field1138) {
            if(this.field1131 == Integer.MIN_VALUE) {
               this.field1131 = 0;
               this.field1143 = 0;
               this.field1134 = 0;
               this.field1139 = 0;
               this.unlink();
               var1 = this.field1138;
            }

            this.field1138 = 0;
            this.method1258();
         } else {
            this.field1139 += this.field1141 * var1;
            this.field1134 += this.field1142 * var1;
            this.field1143 += this.field1140 * var1;
            this.field1138 -= var1;
         }
      }

      class55 var2 = (class55)super.field1159;
      int var3 = this.field1137 << 8;
      int var4 = this.field1133 << 8;
      int var5 = var2.field1034.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1136 = 0;
      }

      if(this.field1129 < 0) {
         if(this.field1135 <= 0) {
            this.method1266();
            this.unlink();
            return;
         }

         this.field1129 = 0;
      }

      if(this.field1129 >= var5) {
         if(this.field1135 >= 0) {
            this.method1266();
            this.unlink();
            return;
         }

         this.field1129 = var5 - 1;
      }

      this.field1129 += this.field1135 * var1;
      if(this.field1136 < 0) {
         if(!this.field1130) {
            if(this.field1135 < 0) {
               if(this.field1129 >= var3) {
                  return;
               }

               this.field1129 = var4 - 1 - (var4 - 1 - this.field1129) % var6;
            } else {
               if(this.field1129 < var4) {
                  return;
               }

               this.field1129 = var3 + (this.field1129 - var3) % var6;
            }

         } else {
            if(this.field1135 < 0) {
               if(this.field1129 >= var3) {
                  return;
               }

               this.field1129 = var3 + var3 - 1 - this.field1129;
               this.field1135 = -this.field1135;
            }

            while(this.field1129 >= var4) {
               this.field1129 = var4 + var4 - 1 - this.field1129;
               this.field1135 = -this.field1135;
               if(this.field1129 >= var3) {
                  return;
               }

               this.field1129 = var3 + var3 - 1 - this.field1129;
               this.field1135 = -this.field1135;
            }

         }
      } else {
         if(this.field1136 > 0) {
            if(this.field1130) {
               label171: {
                  if(this.field1135 < 0) {
                     if(this.field1129 >= var3) {
                        return;
                     }

                     this.field1129 = var3 + var3 - 1 - this.field1129;
                     this.field1135 = -this.field1135;
                     if(--this.field1136 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1129 < var4) {
                        return;
                     }

                     this.field1129 = var4 + var4 - 1 - this.field1129;
                     this.field1135 = -this.field1135;
                     if(--this.field1136 == 0) {
                        break;
                     }

                     if(this.field1129 >= var3) {
                        return;
                     }

                     this.field1129 = var3 + var3 - 1 - this.field1129;
                     this.field1135 = -this.field1135;
                  } while(--this.field1136 != 0);
               }
            } else {
               int var7;
               if(this.field1135 < 0) {
                  if(this.field1129 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1129) / var6;
                  if(var7 < this.field1136) {
                     this.field1129 += var6 * var7;
                     this.field1136 -= var7;
                     return;
                  }

                  this.field1129 += var6 * this.field1136;
                  this.field1136 = 0;
               } else {
                  if(this.field1129 < var4) {
                     return;
                  }

                  var7 = (this.field1129 - var3) / var6;
                  if(var7 < this.field1136) {
                     this.field1129 -= var6 * var7;
                     this.field1136 -= var7;
                     return;
                  }

                  this.field1129 -= var6 * this.field1136;
                  this.field1136 = 0;
               }
            }
         }

         if(this.field1135 < 0) {
            if(this.field1129 < 0) {
               this.field1129 = -1;
               this.method1266();
               this.unlink();
            }
         } else if(this.field1129 >= var5) {
            this.field1129 = var5;
            this.method1266();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("bi")
   static int method1366(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1134 += var9.field1142 * (var6 - var3);
      var9.field1143 += var9.field1140 * (var6 - var3);

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

      var9.field1139 = var4 >> 2;
      var9.field1129 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("w")
   public synchronized int method1367() {
      return this.field1131 == Integer.MIN_VALUE?0:this.field1131;
   }

   @ObfuscatedName("aw")
   static int method1374(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1129 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ah")
   static int method1395(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   static int method1400(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1401(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1134 -= var11.field1142 * var5;
      var11.field1143 -= var11.field1140 * var5;
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

      var11.field1134 += var11.field1142 * var5;
      var11.field1143 += var11.field1140 * var5;
      var11.field1139 = var6;
      var11.field1129 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   static int method1402(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1129 = var4;
      return var5 >> 1;
   }
}
