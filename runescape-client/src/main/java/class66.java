import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class66 extends class68 {
   @ObfuscatedName("k")
   int field1120;
   @ObfuscatedName("j")
   int field1121;
   @ObfuscatedName("u")
   int field1122;
   @ObfuscatedName("c")
   int field1123;
   @ObfuscatedName("h")
   int field1124;
   @ObfuscatedName("l")
   int field1125;
   @ObfuscatedName("x")
   int field1126;
   @ObfuscatedName("g")
   int field1127;
   @ObfuscatedName("y")
   int field1128;
   @ObfuscatedName("e")
   int field1129;
   @ObfuscatedName("q")
   boolean field1130;
   @ObfuscatedName("v")
   int field1131;
   @ObfuscatedName("d")
   int field1132;
   @ObfuscatedName("s")
   int field1133;
   @ObfuscatedName("r")
   int field1134;

   @ObfuscatedName("as")
   int vmethod1412() {
      int var1 = this.field1124 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1127 == 0) {
         var1 -= var1 * this.field1126 / (((class55)super.field1147).field1035.length << 8);
      } else if(this.field1127 >= 0) {
         var1 -= var1 * this.field1128 / ((class55)super.field1147).field1035.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1147 = var1;
      this.field1128 = var1.field1033;
      this.field1129 = var1.field1036;
      this.field1130 = var1.field1034;
      this.field1121 = var2;
      this.field1123 = var3;
      this.field1132 = 8192;
      this.field1126 = 0;
      this.method1382();
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1147 = var1;
      this.field1128 = var1.field1033;
      this.field1129 = var1.field1036;
      this.field1130 = var1.field1034;
      this.field1121 = var2;
      this.field1123 = var3;
      this.field1132 = var4;
      this.field1126 = 0;
      this.method1382();
   }

   @ObfuscatedName("z")
   void method1251() {
      if(this.field1131 != 0) {
         if(this.field1123 == Integer.MIN_VALUE) {
            this.field1123 = 0;
         }

         this.field1131 = 0;
         this.method1382();
      }

   }

   @ObfuscatedName("d")
   public static class66 method1252(class55 var0, int var1, int var2, int var3) {
      return var0.field1035 != null && var0.field1035.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1255() {
      this.field1121 = (this.field1121 ^ this.field1121 >> 31) + (this.field1121 >>> 31);
      this.field1121 = -this.field1121;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1256(int var1) {
      this.method1257(var1, this.method1259());
   }

   @ObfuscatedName("m")
   synchronized void method1257(int var1, int var2) {
      this.field1123 = var1;
      this.field1132 = var2;
      this.field1131 = 0;
      this.method1382();
   }

   @ObfuscatedName("i")
   public synchronized int method1258() {
      return this.field1123 == Integer.MIN_VALUE?0:this.field1123;
   }

   @ObfuscatedName("f")
   public synchronized int method1259() {
      return this.field1132 < 0?-1:this.field1132;
   }

   @ObfuscatedName("b")
   public synchronized void method1260(int var1) {
      int var2 = ((class55)super.field1147).field1035.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1126 = var1;
   }

   @ObfuscatedName("c")
   public static class66 method1261(class55 var0, int var1, int var2) {
      return var0.field1035 != null && var0.field1035.length != 0?new class66(var0, (int)((long)var0.field1037 * 256L * (long)var1 / (long)(class148.field2033 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("s")
   public synchronized void method1262(int var1) {
      this.method1257(var1 << 6, this.method1259());
   }

   @ObfuscatedName("p")
   public synchronized void method1263(int var1, int var2) {
      this.method1264(var1, var2, this.method1259());
   }

   @ObfuscatedName("n")
   public synchronized void method1264(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1257(var2, var3);
      } else {
         int var4 = method1317(var2, var3);
         int var5 = method1388(var2, var3);
         if(this.field1122 == var4 && this.field1120 == var5) {
            this.field1131 = 0;
         } else {
            int var6 = var2 - this.field1124;
            if(this.field1124 - var2 > var6) {
               var6 = this.field1124 - var2;
            }

            if(var4 - this.field1122 > var6) {
               var6 = var4 - this.field1122;
            }

            if(this.field1122 - var4 > var6) {
               var6 = this.field1122 - var4;
            }

            if(var5 - this.field1120 > var6) {
               var6 = var5 - this.field1120;
            }

            if(this.field1120 - var5 > var6) {
               var6 = this.field1120 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1131 = var1;
            this.field1123 = var2;
            this.field1132 = var3;
            this.field1125 = (var2 - this.field1124) / var1;
            this.field1133 = (var4 - this.field1122) / var1;
            this.field1134 = (var5 - this.field1120) / var1;
         }
      }
   }

   @ObfuscatedName("a")
   public synchronized void method1265(int var1) {
      if(var1 == 0) {
         this.method1256(0);
         this.unlink();
      } else if(this.field1122 == 0 && this.field1120 == 0) {
         this.field1131 = 0;
         this.field1123 = 0;
         this.field1124 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1124;
         if(this.field1124 > var2) {
            var2 = this.field1124;
         }

         if(-this.field1122 > var2) {
            var2 = -this.field1122;
         }

         if(this.field1122 > var2) {
            var2 = this.field1122;
         }

         if(-this.field1120 > var2) {
            var2 = -this.field1120;
         }

         if(this.field1120 > var2) {
            var2 = this.field1120;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1131 = var1;
         this.field1123 = Integer.MIN_VALUE;
         this.field1125 = -this.field1124 / var1;
         this.field1133 = -this.field1122 / var1;
         this.field1134 = -this.field1120 / var1;
      }
   }

   @ObfuscatedName("o")
   public synchronized void method1266(int var1) {
      if(this.field1121 < 0) {
         this.field1121 = -var1;
      } else {
         this.field1121 = var1;
      }

   }

   @ObfuscatedName("an")
   public synchronized int method1267() {
      return this.field1121 < 0?-this.field1121:this.field1121;
   }

   @ObfuscatedName("aj")
   boolean method1268() {
      int var1 = this.field1123;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1317(var1, this.field1132);
         var3 = method1388(var1, this.field1132);
      }

      if(this.field1124 == var1 && this.field1122 == var2 && this.field1120 == var3) {
         if(this.field1123 == Integer.MIN_VALUE) {
            this.field1123 = 0;
            this.field1120 = 0;
            this.field1122 = 0;
            this.field1124 = 0;
            this.unlink();
            return true;
         } else {
            this.method1382();
            return false;
         }
      } else {
         if(this.field1124 < var1) {
            this.field1125 = 1;
            this.field1131 = var1 - this.field1124;
         } else if(this.field1124 > var1) {
            this.field1125 = -1;
            this.field1131 = this.field1124 - var1;
         } else {
            this.field1125 = 0;
         }

         if(this.field1122 < var2) {
            this.field1133 = 1;
            if(this.field1131 == 0 || this.field1131 > var2 - this.field1122) {
               this.field1131 = var2 - this.field1122;
            }
         } else if(this.field1122 > var2) {
            this.field1133 = -1;
            if(this.field1131 == 0 || this.field1131 > this.field1122 - var2) {
               this.field1131 = this.field1122 - var2;
            }
         } else {
            this.field1133 = 0;
         }

         if(this.field1120 < var3) {
            this.field1134 = 1;
            if(this.field1131 == 0 || this.field1131 > var3 - this.field1120) {
               this.field1131 = var3 - this.field1120;
            }
         } else if(this.field1120 > var3) {
            this.field1134 = -1;
            if(this.field1131 == 0 || this.field1131 > this.field1120 - var3) {
               this.field1131 = this.field1120 - var3;
            }
         } else {
            this.field1134 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aa")
   public boolean method1269() {
      return this.field1131 != 0;
   }

   @ObfuscatedName("u")
   protected class68 vmethod2723() {
      return null;
   }

   @ObfuscatedName("y")
   protected class68 vmethod2724() {
      return null;
   }

   @ObfuscatedName("e")
   protected int vmethod2725() {
      return this.field1123 == 0 && this.field1131 == 0?0:1;
   }

   @ObfuscatedName("q")
   public synchronized void vmethod2726(int[] var1, int var2, int var3) {
      if(this.field1123 == 0 && this.field1131 == 0) {
         this.vmethod2729(var3);
      } else {
         class55 var4 = (class55)super.field1147;
         int var5 = this.field1128 << 8;
         int var6 = this.field1129 << 8;
         int var7 = var4.field1035.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1127 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1126 < 0) {
            if(this.field1121 <= 0) {
               this.method1251();
               this.unlink();
               return;
            }

            this.field1126 = 0;
         }

         if(this.field1126 >= var7) {
            if(this.field1121 >= 0) {
               this.method1251();
               this.unlink();
               return;
            }

            this.field1126 = var7 - 1;
         }

         if(this.field1127 < 0) {
            if(this.field1130) {
               if(this.field1121 < 0) {
                  var9 = this.method1276(var1, var2, var5, var3, var4.field1035[this.field1128]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var5 + var5 - 1 - this.field1126;
                  this.field1121 = -this.field1121;
               }

               while(true) {
                  var9 = this.method1275(var1, var9, var6, var3, var4.field1035[this.field1129 - 1]);
                  if(this.field1126 < var6) {
                     return;
                  }

                  this.field1126 = var6 + var6 - 1 - this.field1126;
                  this.field1121 = -this.field1121;
                  var9 = this.method1276(var1, var9, var5, var3, var4.field1035[this.field1128]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var5 + var5 - 1 - this.field1126;
                  this.field1121 = -this.field1121;
               }
            } else if(this.field1121 < 0) {
               while(true) {
                  var9 = this.method1276(var1, var9, var5, var3, var4.field1035[this.field1129 - 1]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var6 - 1 - (var6 - 1 - this.field1126) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1275(var1, var9, var6, var3, var4.field1035[this.field1128]);
                  if(this.field1126 < var6) {
                     return;
                  }

                  this.field1126 = var5 + (this.field1126 - var5) % var8;
               }
            }
         } else {
            if(this.field1127 > 0) {
               if(this.field1130) {
                  label165: {
                     if(this.field1121 < 0) {
                        var9 = this.method1276(var1, var2, var5, var3, var4.field1035[this.field1128]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        this.field1126 = var5 + var5 - 1 - this.field1126;
                        this.field1121 = -this.field1121;
                        if(--this.field1127 == 0) {
                           break label165;
                        }
                     }

                     do {
                        var9 = this.method1275(var1, var9, var6, var3, var4.field1035[this.field1129 - 1]);
                        if(this.field1126 < var6) {
                           return;
                        }

                        this.field1126 = var6 + var6 - 1 - this.field1126;
                        this.field1121 = -this.field1121;
                        if(--this.field1127 == 0) {
                           break;
                        }

                        var9 = this.method1276(var1, var9, var5, var3, var4.field1035[this.field1128]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        this.field1126 = var5 + var5 - 1 - this.field1126;
                        this.field1121 = -this.field1121;
                     } while(--this.field1127 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1121 < 0) {
                     while(true) {
                        var9 = this.method1276(var1, var9, var5, var3, var4.field1035[this.field1129 - 1]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1126) / var8;
                        if(var10 >= this.field1127) {
                           this.field1126 += var8 * this.field1127;
                           this.field1127 = 0;
                           break;
                        }

                        this.field1126 += var8 * var10;
                        this.field1127 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1275(var1, var9, var6, var3, var4.field1035[this.field1128]);
                        if(this.field1126 < var6) {
                           return;
                        }

                        var10 = (this.field1126 - var5) / var8;
                        if(var10 >= this.field1127) {
                           this.field1126 -= var8 * this.field1127;
                           this.field1127 = 0;
                           break;
                        }

                        this.field1126 -= var8 * var10;
                        this.field1127 -= var10;
                     }
                  }
               }
            }

            if(this.field1121 < 0) {
               this.method1276(var1, var9, 0, var3, 0);
               if(this.field1126 < 0) {
                  this.field1126 = -1;
                  this.method1251();
                  this.unlink();
               }
            } else {
               this.method1275(var1, var9, var7, var3, 0);
               if(this.field1126 >= var7) {
                  this.field1126 = var7;
                  this.method1251();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("ay")
   int method1275(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1131 > 0) {
            int var6 = var2 + this.field1131;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1131 += var2;
            if(this.field1121 == 256 && (this.field1126 & 255) == 0) {
               if(class57.field1058) {
                  var2 = method1287(0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, this.field1133, this.field1134, 0, var6, var3, this);
               } else {
                  var2 = method1381(((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, this.field1125, 0, var6, var3, this);
               }
            } else if(class57.field1058) {
               var2 = method1291(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, this.field1133, this.field1134, 0, var6, var3, this, this.field1121, var5);
            } else {
               var2 = method1290(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, this.field1125, 0, var6, var3, this, this.field1121, var5);
            }

            this.field1131 -= var2;
            if(this.field1131 != 0) {
               return var2;
            }

            if(!this.method1268()) {
               continue;
            }

            return var4;
         }

         if(this.field1121 == 256 && (this.field1126 & 255) == 0) {
            if(class57.field1058) {
               return method1279(0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, 0, var4, var3, this);
            }

            return method1278(((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, 0, var4, var3, this);
         }

         if(class57.field1058) {
            return method1283(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, 0, var4, var3, this, this.field1121, var5);
         }

         return method1299(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, 0, var4, var3, this, this.field1121, var5);
      }
   }

   @ObfuscatedName("aq")
   int method1276(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1131 > 0) {
            int var6 = var2 + this.field1131;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1131 += var2;
            if(this.field1121 == -256 && (this.field1126 & 255) == 0) {
               if(class57.field1058) {
                  var2 = method1289(0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, this.field1133, this.field1134, 0, var6, var3, this);
               } else {
                  var2 = method1288(((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, this.field1125, 0, var6, var3, this);
               }
            } else if(class57.field1058) {
               var2 = method1293(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, this.field1133, this.field1134, 0, var6, var3, this, this.field1121, var5);
            } else {
               var2 = method1292(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, this.field1125, 0, var6, var3, this, this.field1121, var5);
            }

            this.field1131 -= var2;
            if(this.field1131 != 0) {
               return var2;
            }

            if(!this.method1268()) {
               continue;
            }

            return var4;
         }

         if(this.field1121 == -256 && (this.field1126 & 255) == 0) {
            if(class57.field1058) {
               return method1286(0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, 0, var4, var3, this);
            }

            return method1280(((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, 0, var4, var3, this);
         }

         if(class57.field1058) {
            return method1285(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1122, this.field1120, 0, var4, var3, this, this.field1121, var5);
         }

         return method1342(0, 0, ((class55)super.field1147).field1035, var1, this.field1126, var2, this.field1124, 0, var4, var3, this, this.field1121, var5);
      }
   }

   @ObfuscatedName("ac")
   static int method1278(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   static int method1279(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("al")
   static int method1280(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ad")
   static int method1283(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1126 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   static int method1285(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1126 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ag")
   static int method1286(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   static int method1287(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1124 += var12.field1125 * (var9 - var4);
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

      var12.field1122 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1288(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1122 += var9.field1133 * (var6 - var3);
      var9.field1120 += var9.field1134 * (var6 - var3);

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

      var9.field1124 = var4 >> 2;
      var9.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   static int method1289(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1124 += var12.field1125 * (var9 - var4);
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

      var12.field1122 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bv")
   static int method1290(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1122 -= var11.field1133 * var5;
      var11.field1120 -= var11.field1134 * var5;
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

      var11.field1122 += var11.field1133 * var5;
      var11.field1120 += var11.field1134 * var5;
      var11.field1124 = var6;
      var11.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   static int method1291(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1124 -= var13.field1125 * var5;
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
      var13.field1124 += var13.field1125 * var5;
      var13.field1122 = var6;
      var13.field1120 = var7;
      var13.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   static int method1292(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1122 -= var11.field1133 * var5;
      var11.field1120 -= var11.field1134 * var5;
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

      var11.field1122 += var11.field1133 * var5;
      var11.field1120 += var11.field1134 * var5;
      var11.field1124 = var6;
      var11.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   static int method1293(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1124 -= var13.field1125 * var5;
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
      var13.field1124 += var13.field1125 * var5;
      var13.field1122 = var6;
      var13.field1120 = var7;
      var13.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("aw")
   static int method1299(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod2729(int var1) {
      if(this.field1131 > 0) {
         if(var1 >= this.field1131) {
            if(this.field1123 == Integer.MIN_VALUE) {
               this.field1123 = 0;
               this.field1120 = 0;
               this.field1122 = 0;
               this.field1124 = 0;
               this.unlink();
               var1 = this.field1131;
            }

            this.field1131 = 0;
            this.method1382();
         } else {
            this.field1124 += this.field1125 * var1;
            this.field1122 += this.field1133 * var1;
            this.field1120 += this.field1134 * var1;
            this.field1131 -= var1;
         }
      }

      class55 var2 = (class55)super.field1147;
      int var3 = this.field1128 << 8;
      int var4 = this.field1129 << 8;
      int var5 = var2.field1035.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1127 = 0;
      }

      if(this.field1126 < 0) {
         if(this.field1121 <= 0) {
            this.method1251();
            this.unlink();
            return;
         }

         this.field1126 = 0;
      }

      if(this.field1126 >= var5) {
         if(this.field1121 >= 0) {
            this.method1251();
            this.unlink();
            return;
         }

         this.field1126 = var5 - 1;
      }

      this.field1126 += this.field1121 * var1;
      if(this.field1127 < 0) {
         if(!this.field1130) {
            if(this.field1121 < 0) {
               if(this.field1126 >= var3) {
                  return;
               }

               this.field1126 = var4 - 1 - (var4 - 1 - this.field1126) % var6;
            } else {
               if(this.field1126 < var4) {
                  return;
               }

               this.field1126 = var3 + (this.field1126 - var3) % var6;
            }

         } else {
            if(this.field1121 < 0) {
               if(this.field1126 >= var3) {
                  return;
               }

               this.field1126 = var3 + var3 - 1 - this.field1126;
               this.field1121 = -this.field1121;
            }

            while(this.field1126 >= var4) {
               this.field1126 = var4 + var4 - 1 - this.field1126;
               this.field1121 = -this.field1121;
               if(this.field1126 >= var3) {
                  return;
               }

               this.field1126 = var3 + var3 - 1 - this.field1126;
               this.field1121 = -this.field1121;
            }

         }
      } else {
         if(this.field1127 > 0) {
            if(this.field1130) {
               label170: {
                  if(this.field1121 < 0) {
                     if(this.field1126 >= var3) {
                        return;
                     }

                     this.field1126 = var3 + var3 - 1 - this.field1126;
                     this.field1121 = -this.field1121;
                     if(--this.field1127 == 0) {
                        break label170;
                     }
                  }

                  do {
                     if(this.field1126 < var4) {
                        return;
                     }

                     this.field1126 = var4 + var4 - 1 - this.field1126;
                     this.field1121 = -this.field1121;
                     if(--this.field1127 == 0) {
                        break;
                     }

                     if(this.field1126 >= var3) {
                        return;
                     }

                     this.field1126 = var3 + var3 - 1 - this.field1126;
                     this.field1121 = -this.field1121;
                  } while(--this.field1127 != 0);
               }
            } else {
               label202: {
                  int var7;
                  if(this.field1121 < 0) {
                     if(this.field1126 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1126) / var6;
                     if(var7 >= this.field1127) {
                        this.field1126 += var6 * this.field1127;
                        this.field1127 = 0;
                        break label202;
                     }

                     this.field1126 += var6 * var7;
                     this.field1127 -= var7;
                  } else {
                     if(this.field1126 < var4) {
                        return;
                     }

                     var7 = (this.field1126 - var3) / var6;
                     if(var7 >= this.field1127) {
                        this.field1126 -= var6 * this.field1127;
                        this.field1127 = 0;
                        break label202;
                     }

                     this.field1126 -= var6 * var7;
                     this.field1127 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1121 < 0) {
            if(this.field1126 < 0) {
               this.field1126 = -1;
               this.method1251();
               this.unlink();
            }
         } else if(this.field1126 >= var5) {
            this.field1126 = var5;
            this.method1251();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("x")
   static int method1317(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("v")
   public synchronized void method1339(int var1) {
      this.field1127 = var1;
   }

   @ObfuscatedName("au")
   static int method1342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("ar")
   public boolean method1346() {
      return this.field1126 < 0 || this.field1126 >= ((class55)super.field1147).field1035.length << 8;
   }

   @ObfuscatedName("bd")
   static int method1381(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1122 += var9.field1133 * (var6 - var3);
      var9.field1120 += var9.field1134 * (var6 - var3);

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

      var9.field1124 = var4 >> 2;
      var9.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("w")
   void method1382() {
      this.field1124 = this.field1123;
      this.field1122 = method1317(this.field1123, this.field1132);
      this.field1120 = method1388(this.field1123, this.field1132);
   }

   @ObfuscatedName("j")
   static int method1388(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }
}
