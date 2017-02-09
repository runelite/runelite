import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class66 extends class68 {
   @ObfuscatedName("o")
   int field1115;
   @ObfuscatedName("y")
   int field1116;
   @ObfuscatedName("v")
   int field1117;
   @ObfuscatedName("r")
   int field1118;
   @ObfuscatedName("i")
   int field1119;
   @ObfuscatedName("q")
   int field1120;
   @ObfuscatedName("d")
   int field1121;
   @ObfuscatedName("n")
   int field1122;
   @ObfuscatedName("c")
   int field1123;
   @ObfuscatedName("s")
   int field1124;
   @ObfuscatedName("g")
   boolean field1125;
   @ObfuscatedName("k")
   int field1126;
   @ObfuscatedName("j")
   int field1127;
   @ObfuscatedName("a")
   int field1128;
   @ObfuscatedName("h")
   int field1129;

   @ObfuscatedName("ac")
   public boolean method1189() {
      return this.field1119 != 0;
   }

   @ObfuscatedName("az")
   int vmethod1354() {
      int var1 = this.field1127 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1122 == 0) {
         var1 -= var1 * this.field1126 / (((class55)super.field1145).field1023.length << 8);
      } else if(this.field1122 >= 0) {
         var1 -= var1 * this.field1123 / ((class55)super.field1145).field1023.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("bc")
   static int method1192(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1127 += var12.field1117 * (var9 - var4);
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

      var12.field1120 = var5 >> 2;
      var12.field1121 = var6 >> 2;
      var12.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("w")
   void method1195() {
      this.field1127 = this.field1115;
      this.field1120 = method1259(this.field1115, this.field1118);
      this.field1121 = method1338(this.field1115, this.field1118);
   }

   @ObfuscatedName("v")
   public synchronized void method1196(int var1) {
      this.field1122 = var1;
   }

   @ObfuscatedName("h")
   public synchronized void method1197(int var1) {
      this.method1254(var1 << 6, this.method1303());
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1198(int var1) {
      this.method1254(var1, this.method1303());
   }

   class66(class55 var1, int var2, int var3) {
      super.field1145 = var1;
      this.field1123 = var1.field1025;
      this.field1124 = var1.field1026;
      this.field1125 = var1.field1027;
      this.field1116 = var2;
      this.field1115 = var3;
      this.field1118 = 8192;
      this.field1126 = 0;
      this.method1195();
   }

   @ObfuscatedName("f")
   public synchronized int method1199() {
      return this.field1115 == Integer.MIN_VALUE?0:this.field1115;
   }

   @ObfuscatedName("u")
   public synchronized void method1201(int var1) {
      int var2 = ((class55)super.field1145).field1023.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1126 = var1;
   }

   @ObfuscatedName("e")
   public synchronized void method1204(int var1, int var2) {
      this.method1205(var1, var2, this.method1303());
   }

   @ObfuscatedName("l")
   public synchronized void method1205(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1254(var2, var3);
      } else {
         int var4 = method1259(var2, var3);
         int var5 = method1338(var2, var3);
         if(this.field1120 == var4 && this.field1121 == var5) {
            this.field1119 = 0;
         } else {
            int var6 = var2 - this.field1127;
            if(this.field1127 - var2 > var6) {
               var6 = this.field1127 - var2;
            }

            if(var4 - this.field1120 > var6) {
               var6 = var4 - this.field1120;
            }

            if(this.field1120 - var4 > var6) {
               var6 = this.field1120 - var4;
            }

            if(var5 - this.field1121 > var6) {
               var6 = var5 - this.field1121;
            }

            if(this.field1121 - var5 > var6) {
               var6 = this.field1121 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1119 = var1;
            this.field1115 = var2;
            this.field1118 = var3;
            this.field1117 = (var2 - this.field1127) / var1;
            this.field1128 = (var4 - this.field1120) / var1;
            this.field1129 = (var5 - this.field1121) / var1;
         }
      }
   }

   @ObfuscatedName("x")
   public synchronized void method1206(int var1) {
      if(var1 == 0) {
         this.method1198(0);
         this.unlink();
      } else if(this.field1120 == 0 && this.field1121 == 0) {
         this.field1119 = 0;
         this.field1115 = 0;
         this.field1127 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1127;
         if(this.field1127 > var2) {
            var2 = this.field1127;
         }

         if(-this.field1120 > var2) {
            var2 = -this.field1120;
         }

         if(this.field1120 > var2) {
            var2 = this.field1120;
         }

         if(-this.field1121 > var2) {
            var2 = -this.field1121;
         }

         if(this.field1121 > var2) {
            var2 = this.field1121;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1119 = var1;
         this.field1115 = Integer.MIN_VALUE;
         this.field1117 = -this.field1127 / var1;
         this.field1128 = -this.field1120 / var1;
         this.field1129 = -this.field1121 / var1;
      }
   }

   @ObfuscatedName("ap")
   public synchronized void method1207(int var1) {
      if(this.field1116 < 0) {
         this.field1116 = -var1;
      } else {
         this.field1116 = var1;
      }

   }

   @ObfuscatedName("aq")
   public synchronized int method1208() {
      return this.field1116 < 0?-this.field1116:this.field1116;
   }

   @ObfuscatedName("j")
   protected class68 vmethod2708() {
      return null;
   }

   @ObfuscatedName("i")
   public synchronized void vmethod2689(int[] var1, int var2, int var3) {
      if(this.field1115 == 0 && this.field1119 == 0) {
         this.vmethod2690(var3);
      } else {
         class55 var4 = (class55)super.field1145;
         int var5 = this.field1123 << 8;
         int var6 = this.field1124 << 8;
         int var7 = var4.field1023.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1122 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1126 < 0) {
            if(this.field1116 <= 0) {
               this.method1243();
               this.unlink();
               return;
            }

            this.field1126 = 0;
         }

         if(this.field1126 >= var7) {
            if(this.field1116 >= 0) {
               this.method1243();
               this.unlink();
               return;
            }

            this.field1126 = var7 - 1;
         }

         if(this.field1122 < 0) {
            if(this.field1125) {
               if(this.field1116 < 0) {
                  var9 = this.method1217(var1, var2, var5, var3, var4.field1023[this.field1123]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var5 + var5 - 1 - this.field1126;
                  this.field1116 = -this.field1116;
               }

               while(true) {
                  var9 = this.method1231(var1, var9, var6, var3, var4.field1023[this.field1124 - 1]);
                  if(this.field1126 < var6) {
                     return;
                  }

                  this.field1126 = var6 + var6 - 1 - this.field1126;
                  this.field1116 = -this.field1116;
                  var9 = this.method1217(var1, var9, var5, var3, var4.field1023[this.field1123]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var5 + var5 - 1 - this.field1126;
                  this.field1116 = -this.field1116;
               }
            } else if(this.field1116 < 0) {
               while(true) {
                  var9 = this.method1217(var1, var9, var5, var3, var4.field1023[this.field1124 - 1]);
                  if(this.field1126 >= var5) {
                     return;
                  }

                  this.field1126 = var6 - 1 - (var6 - 1 - this.field1126) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1231(var1, var9, var6, var3, var4.field1023[this.field1123]);
                  if(this.field1126 < var6) {
                     return;
                  }

                  this.field1126 = var5 + (this.field1126 - var5) % var8;
               }
            }
         } else {
            if(this.field1122 > 0) {
               if(this.field1125) {
                  label176: {
                     if(this.field1116 < 0) {
                        var9 = this.method1217(var1, var2, var5, var3, var4.field1023[this.field1123]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        this.field1126 = var5 + var5 - 1 - this.field1126;
                        this.field1116 = -this.field1116;
                        if(--this.field1122 == 0) {
                           break label176;
                        }
                     }

                     do {
                        var9 = this.method1231(var1, var9, var6, var3, var4.field1023[this.field1124 - 1]);
                        if(this.field1126 < var6) {
                           return;
                        }

                        this.field1126 = var6 + var6 - 1 - this.field1126;
                        this.field1116 = -this.field1116;
                        if(--this.field1122 == 0) {
                           break;
                        }

                        var9 = this.method1217(var1, var9, var5, var3, var4.field1023[this.field1123]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        this.field1126 = var5 + var5 - 1 - this.field1126;
                        this.field1116 = -this.field1116;
                     } while(--this.field1122 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1116 < 0) {
                     while(true) {
                        var9 = this.method1217(var1, var9, var5, var3, var4.field1023[this.field1124 - 1]);
                        if(this.field1126 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1126) / var8;
                        if(var10 >= this.field1122) {
                           this.field1126 += var8 * this.field1122;
                           this.field1122 = 0;
                           break;
                        }

                        this.field1126 += var8 * var10;
                        this.field1122 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1231(var1, var9, var6, var3, var4.field1023[this.field1123]);
                        if(this.field1126 < var6) {
                           return;
                        }

                        var10 = (this.field1126 - var5) / var8;
                        if(var10 >= this.field1122) {
                           this.field1126 -= var8 * this.field1122;
                           this.field1122 = 0;
                           break;
                        }

                        this.field1126 -= var8 * var10;
                        this.field1122 -= var10;
                     }
                  }
               }
            }

            if(this.field1116 < 0) {
               this.method1217(var1, var9, 0, var3, 0);
               if(this.field1126 < 0) {
                  this.field1126 = -1;
                  this.method1243();
                  this.unlink();
               }
            } else {
               this.method1231(var1, var9, var7, var3, 0);
               if(this.field1126 >= var7) {
                  this.field1126 = var7;
                  this.method1243();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   public synchronized void vmethod2690(int var1) {
      if(this.field1119 > 0) {
         if(var1 >= this.field1119) {
            if(this.field1115 == Integer.MIN_VALUE) {
               this.field1115 = 0;
               this.field1121 = 0;
               this.field1120 = 0;
               this.field1127 = 0;
               this.unlink();
               var1 = this.field1119;
            }

            this.field1119 = 0;
            this.method1195();
         } else {
            this.field1127 += this.field1117 * var1;
            this.field1120 += this.field1128 * var1;
            this.field1121 += this.field1129 * var1;
            this.field1119 -= var1;
         }
      }

      class55 var2 = (class55)super.field1145;
      int var3 = this.field1123 << 8;
      int var4 = this.field1124 << 8;
      int var5 = var2.field1023.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1122 = 0;
      }

      if(this.field1126 < 0) {
         if(this.field1116 <= 0) {
            this.method1243();
            this.unlink();
            return;
         }

         this.field1126 = 0;
      }

      if(this.field1126 >= var5) {
         if(this.field1116 >= 0) {
            this.method1243();
            this.unlink();
            return;
         }

         this.field1126 = var5 - 1;
      }

      this.field1126 += this.field1116 * var1;
      if(this.field1122 < 0) {
         if(!this.field1125) {
            if(this.field1116 < 0) {
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
            if(this.field1116 < 0) {
               if(this.field1126 >= var3) {
                  return;
               }

               this.field1126 = var3 + var3 - 1 - this.field1126;
               this.field1116 = -this.field1116;
            }

            while(this.field1126 >= var4) {
               this.field1126 = var4 + var4 - 1 - this.field1126;
               this.field1116 = -this.field1116;
               if(this.field1126 >= var3) {
                  return;
               }

               this.field1126 = var3 + var3 - 1 - this.field1126;
               this.field1116 = -this.field1116;
            }

         }
      } else {
         if(this.field1122 > 0) {
            if(this.field1125) {
               label177: {
                  if(this.field1116 < 0) {
                     if(this.field1126 >= var3) {
                        return;
                     }

                     this.field1126 = var3 + var3 - 1 - this.field1126;
                     this.field1116 = -this.field1116;
                     if(--this.field1122 == 0) {
                        break label177;
                     }
                  }

                  do {
                     if(this.field1126 < var4) {
                        return;
                     }

                     this.field1126 = var4 + var4 - 1 - this.field1126;
                     this.field1116 = -this.field1116;
                     if(--this.field1122 == 0) {
                        break;
                     }

                     if(this.field1126 >= var3) {
                        return;
                     }

                     this.field1126 = var3 + var3 - 1 - this.field1126;
                     this.field1116 = -this.field1116;
                  } while(--this.field1122 != 0);
               }
            } else {
               label209: {
                  int var7;
                  if(this.field1116 < 0) {
                     if(this.field1126 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1126) / var6;
                     if(var7 >= this.field1122) {
                        this.field1126 += var6 * this.field1122;
                        this.field1122 = 0;
                        break label209;
                     }

                     this.field1126 += var6 * var7;
                     this.field1122 -= var7;
                  } else {
                     if(this.field1126 < var4) {
                        return;
                     }

                     var7 = (this.field1126 - var3) / var6;
                     if(var7 >= this.field1122) {
                        this.field1126 -= var6 * this.field1122;
                        this.field1122 = 0;
                        break label209;
                     }

                     this.field1126 -= var6 * var7;
                     this.field1122 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1116 < 0) {
            if(this.field1126 < 0) {
               this.field1126 = -1;
               this.method1243();
               this.unlink();
            }
         } else if(this.field1126 >= var5) {
            this.field1126 = var5;
            this.method1243();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("at")
   int method1217(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1119 > 0) {
            int var6 = var2 + this.field1119;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1119 += var2;
            if(this.field1116 == -256 && (this.field1126 & 255) == 0) {
               if(class57.field1057) {
                  var2 = method1192(0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, this.field1128, this.field1129, 0, var6, var3, this);
               } else {
                  var2 = method1249(((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, this.field1117, 0, var6, var3, this);
               }
            } else if(class57.field1057) {
               var2 = method1233(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, this.field1128, this.field1129, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1227(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, this.field1117, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1119 -= var2;
            if(this.field1119 != 0) {
               return var2;
            }

            if(!this.method1236()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == -256 && (this.field1126 & 255) == 0) {
            if(class57.field1057) {
               return method1328(0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, 0, var4, var3, this);
            }

            return method1221(((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, 0, var4, var3, this);
         }

         if(class57.field1057) {
            return method1225(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, 0, var4, var3, this, this.field1116, var5);
         }

         return method1287(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("ae")
   static int method1219(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

   @ObfuscatedName("ab")
   static int method1220(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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
   static int method1221(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1145 = var1;
      this.field1123 = var1.field1025;
      this.field1124 = var1.field1026;
      this.field1125 = var1.field1027;
      this.field1116 = var2;
      this.field1115 = var3;
      this.field1118 = var4;
      this.field1126 = 0;
      this.method1195();
   }

   @ObfuscatedName("ak")
   static int method1222(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

   @ObfuscatedName("an")
   static int method1223(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

   @ObfuscatedName("bm")
   static int method1225(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

   @ObfuscatedName("bz")
   static int method1226(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1120 += var9.field1128 * (var6 - var3);
      var9.field1121 += var9.field1129 * (var6 - var3);

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

      var9.field1127 = var4 >> 2;
      var9.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bf")
   static int method1227(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1120 -= var11.field1128 * var5;
      var11.field1121 -= var11.field1129 * var5;
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

      var11.field1120 += var11.field1128 * var5;
      var11.field1121 += var11.field1129 * var5;
      var11.field1127 = var6;
      var11.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   static int method1230(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1120 -= var11.field1128 * var5;
      var11.field1121 -= var11.field1129 * var5;
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

      var11.field1120 += var11.field1128 * var5;
      var11.field1121 += var11.field1129 * var5;
      var11.field1127 = var6;
      var11.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("ag")
   int method1231(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1119 > 0) {
            int var6 = var2 + this.field1119;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1119 += var2;
            if(this.field1116 == 256 && (this.field1126 & 255) == 0) {
               if(class57.field1057) {
                  var2 = method1321(0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, this.field1128, this.field1129, 0, var6, var3, this);
               } else {
                  var2 = method1226(((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, this.field1117, 0, var6, var3, this);
               }
            } else if(class57.field1057) {
               var2 = method1317(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, this.field1128, this.field1129, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1230(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, this.field1117, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1119 -= var2;
            if(this.field1119 != 0) {
               return var2;
            }

            if(!this.method1236()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == 256 && (this.field1126 & 255) == 0) {
            if(class57.field1057) {
               return method1220(0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, 0, var4, var3, this);
            }

            return method1219(((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, 0, var4, var3, this);
         }

         if(class57.field1057) {
            return method1223(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1120, this.field1121, 0, var4, var3, this, this.field1116, var5);
         }

         return method1222(0, 0, ((class55)super.field1145).field1023, var1, this.field1126, var2, this.field1127, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("bk")
   static int method1233(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1127 -= var13.field1117 * var5;
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
      var13.field1127 += var13.field1117 * var5;
      var13.field1120 = var6;
      var13.field1121 = var7;
      var13.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("au")
   boolean method1236() {
      int var1 = this.field1115;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1259(var1, this.field1118);
         var3 = method1338(var1, this.field1118);
      }

      if(this.field1127 == var1 && this.field1120 == var2 && this.field1121 == var3) {
         if(this.field1115 == Integer.MIN_VALUE) {
            this.field1115 = 0;
            this.field1121 = 0;
            this.field1120 = 0;
            this.field1127 = 0;
            this.unlink();
            return true;
         } else {
            this.method1195();
            return false;
         }
      } else {
         if(this.field1127 < var1) {
            this.field1117 = 1;
            this.field1119 = var1 - this.field1127;
         } else if(this.field1127 > var1) {
            this.field1117 = -1;
            this.field1119 = this.field1127 - var1;
         } else {
            this.field1117 = 0;
         }

         if(this.field1120 < var2) {
            this.field1128 = 1;
            if(this.field1119 == 0 || this.field1119 > var2 - this.field1120) {
               this.field1119 = var2 - this.field1120;
            }
         } else if(this.field1120 > var2) {
            this.field1128 = -1;
            if(this.field1119 == 0 || this.field1119 > this.field1120 - var2) {
               this.field1119 = this.field1120 - var2;
            }
         } else {
            this.field1128 = 0;
         }

         if(this.field1121 < var3) {
            this.field1129 = 1;
            if(this.field1119 == 0 || this.field1119 > var3 - this.field1121) {
               this.field1119 = var3 - this.field1121;
            }
         } else if(this.field1121 > var3) {
            this.field1129 = -1;
            if(this.field1119 == 0 || this.field1119 > this.field1121 - var3) {
               this.field1119 = this.field1121 - var3;
            }
         } else {
            this.field1129 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   protected class68 vmethod2687() {
      return null;
   }

   @ObfuscatedName("m")
   void method1243() {
      if(this.field1119 != 0) {
         if(this.field1115 == Integer.MIN_VALUE) {
            this.field1115 = 0;
         }

         this.field1119 = 0;
         this.method1195();
      }

   }

   @ObfuscatedName("bh")
   static int method1249(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1120 += var9.field1128 * (var6 - var3);
      var9.field1121 += var9.field1129 * (var6 - var3);

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

      var9.field1127 = var4 >> 2;
      var9.field1126 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("t")
   synchronized void method1254(int var1, int var2) {
      this.field1115 = var1;
      this.field1118 = var2;
      this.field1119 = 0;
      this.method1195();
   }

   @ObfuscatedName("k")
   static int method1259(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("g")
   protected int vmethod2688() {
      return this.field1115 == 0 && this.field1119 == 0?0:1;
   }

   @ObfuscatedName("r")
   public static class66 method1266(class55 var0, int var1, int var2, int var3) {
      return var0.field1023 != null && var0.field1023.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("bb")
   static int method1287(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

   @ObfuscatedName("aw")
   public boolean method1291() {
      return this.field1126 < 0 || this.field1126 >= ((class55)super.field1145).field1023.length << 8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1296() {
      this.field1116 = (this.field1116 ^ this.field1116 >> 31) + (this.field1116 >>> 31);
      this.field1116 = -this.field1116;
   }

   @ObfuscatedName("z")
   public synchronized int method1303() {
      return this.field1118 < 0?-1:this.field1118;
   }

   @ObfuscatedName("o")
   public static class66 method1304(class55 var0, int var1, int var2) {
      return var0.field1023 != null && var0.field1023.length != 0?new class66(var0, (int)((long)var0.field1024 * 256L * (long)var1 / (long)(class57.field1045 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bi")
   static int method1317(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1127 -= var13.field1117 * var5;
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
      var13.field1127 += var13.field1117 * var5;
      var13.field1120 = var6;
      var13.field1121 = var7;
      var13.field1126 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1321(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1127 += var12.field1117 * (var9 - var4);
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

      var12.field1120 = var5 >> 2;
      var12.field1121 = var6 >> 2;
      var12.field1126 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("av")
   static int method1328(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

   @ObfuscatedName("y")
   static int method1338(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }
}
