import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class66 extends class68 {
   @ObfuscatedName("n")
   int field1095;
   @ObfuscatedName("d")
   int field1096;
   @ObfuscatedName("g")
   boolean field1097;
   @ObfuscatedName("q")
   int field1098;
   @ObfuscatedName("t")
   int field1099;
   @ObfuscatedName("p")
   int field1100;
   @ObfuscatedName("u")
   int field1101;
   @ObfuscatedName("z")
   int field1102;
   @ObfuscatedName("l")
   int field1103;
   @ObfuscatedName("v")
   int field1104;
   @ObfuscatedName("k")
   int field1105;
   @ObfuscatedName("r")
   int field1106;
   @ObfuscatedName("s")
   int field1107;
   @ObfuscatedName("c")
   int field1108;
   @ObfuscatedName("e")
   int field1109;

   @ObfuscatedName("ax")
   public synchronized int method1197() {
      return this.field1108 < 0?-this.field1108:this.field1108;
   }

   @ObfuscatedName("al")
   int vmethod1361() {
      int var1 = this.field1099 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1102 == 0) {
         var1 -= var1 * this.field1096 / (((class55)super.field1122).field1012.length << 8);
      } else if(this.field1102 >= 0) {
         var1 -= var1 * this.field1103 / ((class55)super.field1122).field1012.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1122 = var1;
      this.field1103 = var1.field1014;
      this.field1104 = var1.field1013;
      this.field1097 = var1.field1015;
      this.field1108 = var2;
      this.field1095 = var3;
      this.field1098 = 8192;
      this.field1096 = 0;
      this.method1201();
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1122 = var1;
      this.field1103 = var1.field1014;
      this.field1104 = var1.field1013;
      this.field1097 = var1.field1015;
      this.field1108 = var2;
      this.field1095 = var3;
      this.field1098 = var4;
      this.field1096 = 0;
      this.method1201();
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3093(int[] var1, int var2, int var3) {
      if(this.field1095 == 0 && this.field1106 == 0) {
         this.vmethod3094(var3);
      } else {
         class55 var4 = (class55)super.field1122;
         int var5 = this.field1103 << 8;
         int var6 = this.field1104 << 8;
         int var7 = var4.field1012.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1102 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1096 < 0) {
            if(this.field1108 <= 0) {
               this.method1217();
               this.unlink();
               return;
            }

            this.field1096 = 0;
         }

         if(this.field1096 >= var7) {
            if(this.field1108 >= 0) {
               this.method1217();
               this.unlink();
               return;
            }

            this.field1096 = var7 - 1;
         }

         if(this.field1102 < 0) {
            if(this.field1097) {
               if(this.field1108 < 0) {
                  var9 = this.method1224(var1, var2, var5, var3, var4.field1012[this.field1103]);
                  if(this.field1096 >= var5) {
                     return;
                  }

                  this.field1096 = var5 + var5 - 1 - this.field1096;
                  this.field1108 = -this.field1108;
               }

               while(true) {
                  var9 = this.method1318(var1, var9, var6, var3, var4.field1012[this.field1104 - 1]);
                  if(this.field1096 < var6) {
                     return;
                  }

                  this.field1096 = var6 + var6 - 1 - this.field1096;
                  this.field1108 = -this.field1108;
                  var9 = this.method1224(var1, var9, var5, var3, var4.field1012[this.field1103]);
                  if(this.field1096 >= var5) {
                     return;
                  }

                  this.field1096 = var5 + var5 - 1 - this.field1096;
                  this.field1108 = -this.field1108;
               }
            } else if(this.field1108 < 0) {
               while(true) {
                  var9 = this.method1224(var1, var9, var5, var3, var4.field1012[this.field1104 - 1]);
                  if(this.field1096 >= var5) {
                     return;
                  }

                  this.field1096 = var6 - 1 - (var6 - 1 - this.field1096) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1318(var1, var9, var6, var3, var4.field1012[this.field1103]);
                  if(this.field1096 < var6) {
                     return;
                  }

                  this.field1096 = var5 + (this.field1096 - var5) % var8;
               }
            }
         } else {
            if(this.field1102 > 0) {
               if(this.field1097) {
                  label171: {
                     if(this.field1108 < 0) {
                        var9 = this.method1224(var1, var2, var5, var3, var4.field1012[this.field1103]);
                        if(this.field1096 >= var5) {
                           return;
                        }

                        this.field1096 = var5 + var5 - 1 - this.field1096;
                        this.field1108 = -this.field1108;
                        if(--this.field1102 == 0) {
                           break label171;
                        }
                     }

                     do {
                        var9 = this.method1318(var1, var9, var6, var3, var4.field1012[this.field1104 - 1]);
                        if(this.field1096 < var6) {
                           return;
                        }

                        this.field1096 = var6 + var6 - 1 - this.field1096;
                        this.field1108 = -this.field1108;
                        if(--this.field1102 == 0) {
                           break;
                        }

                        var9 = this.method1224(var1, var9, var5, var3, var4.field1012[this.field1103]);
                        if(this.field1096 >= var5) {
                           return;
                        }

                        this.field1096 = var5 + var5 - 1 - this.field1096;
                        this.field1108 = -this.field1108;
                     } while(--this.field1102 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1108 < 0) {
                     while(true) {
                        var9 = this.method1224(var1, var9, var5, var3, var4.field1012[this.field1104 - 1]);
                        if(this.field1096 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1096) / var8;
                        if(var10 >= this.field1102) {
                           this.field1096 += var8 * this.field1102;
                           this.field1102 = 0;
                           break;
                        }

                        this.field1096 += var8 * var10;
                        this.field1102 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1318(var1, var9, var6, var3, var4.field1012[this.field1103]);
                        if(this.field1096 < var6) {
                           return;
                        }

                        var10 = (this.field1096 - var5) / var8;
                        if(var10 >= this.field1102) {
                           this.field1096 -= var8 * this.field1102;
                           this.field1102 = 0;
                           break;
                        }

                        this.field1096 -= var8 * var10;
                        this.field1102 -= var10;
                     }
                  }
               }
            }

            if(this.field1108 < 0) {
               this.method1224(var1, var9, 0, var3, 0);
               if(this.field1096 < 0) {
                  this.field1096 = -1;
                  this.method1217();
                  this.unlink();
               }
            } else {
               this.method1318(var1, var9, var7, var3, 0);
               if(this.field1096 >= var7) {
                  this.field1096 = var7;
                  this.method1217();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("q")
   public static class66 method1200(class55 var0, int var1, int var2, int var3) {
      return var0.field1012 != null && var0.field1012.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("t")
   void method1201() {
      this.field1099 = this.field1095;
      this.field1100 = method1327(this.field1095, this.field1098);
      this.field1101 = method1333(this.field1095, this.field1098);
   }

   @ObfuscatedName("e")
   public synchronized void method1203(int var1) {
      this.method1205(var1 << 6, this.method1207());
   }

   @ObfuscatedName("i")
   synchronized void method1205(int var1, int var2) {
      this.field1095 = var1;
      this.field1098 = var2;
      this.field1106 = 0;
      this.method1201();
   }

   @ObfuscatedName("a")
   public synchronized int method1206() {
      return this.field1095 == Integer.MIN_VALUE?0:this.field1095;
   }

   @ObfuscatedName("x")
   public synchronized int method1207() {
      return this.field1098 < 0?-1:this.field1098;
   }

   @ObfuscatedName("h")
   public synchronized void method1208(int var1) {
      int var2 = ((class55)super.field1122).field1012.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1096 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1209() {
      this.field1108 = (this.field1108 ^ this.field1108 >> 31) + (this.field1108 >>> 31);
      this.field1108 = -this.field1108;
   }

   @ObfuscatedName("o")
   public synchronized void method1211(int var1, int var2) {
      this.method1251(var1, var2, this.method1207());
   }

   @ObfuscatedName("y")
   public synchronized void method1213(int var1) {
      if(var1 == 0) {
         this.method1319(0);
         this.unlink();
      } else if(this.field1100 == 0 && this.field1101 == 0) {
         this.field1106 = 0;
         this.field1095 = 0;
         this.field1099 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1099;
         if(this.field1099 > var2) {
            var2 = this.field1099;
         }

         if(-this.field1100 > var2) {
            var2 = -this.field1100;
         }

         if(this.field1100 > var2) {
            var2 = this.field1100;
         }

         if(-this.field1101 > var2) {
            var2 = -this.field1101;
         }

         if(this.field1101 > var2) {
            var2 = this.field1101;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1106 = var1;
         this.field1095 = Integer.MIN_VALUE;
         this.field1107 = -this.field1099 / var1;
         this.field1105 = -this.field1100 / var1;
         this.field1109 = -this.field1101 / var1;
      }
   }

   @ObfuscatedName("am")
   public synchronized void method1214(int var1) {
      if(this.field1108 < 0) {
         this.field1108 = -var1;
      } else {
         this.field1108 = var1;
      }

   }

   @ObfuscatedName("ag")
   public boolean method1216() {
      return this.field1096 < 0 || this.field1096 >= ((class55)super.field1122).field1012.length << 8;
   }

   @ObfuscatedName("f")
   void method1217() {
      if(this.field1106 != 0) {
         if(this.field1095 == Integer.MIN_VALUE) {
            this.field1095 = 0;
         }

         this.field1106 = 0;
         this.method1201();
      }

   }

   @ObfuscatedName("p")
   protected class68 vmethod3102() {
      return null;
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3094(int var1) {
      if(this.field1106 > 0) {
         if(var1 >= this.field1106) {
            if(this.field1095 == Integer.MIN_VALUE) {
               this.field1095 = 0;
               this.field1101 = 0;
               this.field1100 = 0;
               this.field1099 = 0;
               this.unlink();
               var1 = this.field1106;
            }

            this.field1106 = 0;
            this.method1201();
         } else {
            this.field1099 += this.field1107 * var1;
            this.field1100 += this.field1105 * var1;
            this.field1101 += this.field1109 * var1;
            this.field1106 -= var1;
         }
      }

      class55 var2 = (class55)super.field1122;
      int var3 = this.field1103 << 8;
      int var4 = this.field1104 << 8;
      int var5 = var2.field1012.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1102 = 0;
      }

      if(this.field1096 < 0) {
         if(this.field1108 <= 0) {
            this.method1217();
            this.unlink();
            return;
         }

         this.field1096 = 0;
      }

      if(this.field1096 >= var5) {
         if(this.field1108 >= 0) {
            this.method1217();
            this.unlink();
            return;
         }

         this.field1096 = var5 - 1;
      }

      this.field1096 += this.field1108 * var1;
      if(this.field1102 < 0) {
         if(!this.field1097) {
            if(this.field1108 < 0) {
               if(this.field1096 >= var3) {
                  return;
               }

               this.field1096 = var4 - 1 - (var4 - 1 - this.field1096) % var6;
            } else {
               if(this.field1096 < var4) {
                  return;
               }

               this.field1096 = var3 + (this.field1096 - var3) % var6;
            }

         } else {
            if(this.field1108 < 0) {
               if(this.field1096 >= var3) {
                  return;
               }

               this.field1096 = var3 + var3 - 1 - this.field1096;
               this.field1108 = -this.field1108;
            }

            while(this.field1096 >= var4) {
               this.field1096 = var4 + var4 - 1 - this.field1096;
               this.field1108 = -this.field1108;
               if(this.field1096 >= var3) {
                  return;
               }

               this.field1096 = var3 + var3 - 1 - this.field1096;
               this.field1108 = -this.field1108;
            }

         }
      } else {
         if(this.field1102 > 0) {
            if(this.field1097) {
               label173: {
                  if(this.field1108 < 0) {
                     if(this.field1096 >= var3) {
                        return;
                     }

                     this.field1096 = var3 + var3 - 1 - this.field1096;
                     this.field1108 = -this.field1108;
                     if(--this.field1102 == 0) {
                        break label173;
                     }
                  }

                  do {
                     if(this.field1096 < var4) {
                        return;
                     }

                     this.field1096 = var4 + var4 - 1 - this.field1096;
                     this.field1108 = -this.field1108;
                     if(--this.field1102 == 0) {
                        break;
                     }

                     if(this.field1096 >= var3) {
                        return;
                     }

                     this.field1096 = var3 + var3 - 1 - this.field1096;
                     this.field1108 = -this.field1108;
                  } while(--this.field1102 != 0);
               }
            } else {
               label205: {
                  int var7;
                  if(this.field1108 < 0) {
                     if(this.field1096 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1096) / var6;
                     if(var7 >= this.field1102) {
                        this.field1096 += var6 * this.field1102;
                        this.field1102 = 0;
                        break label205;
                     }

                     this.field1096 += var6 * var7;
                     this.field1102 -= var7;
                  } else {
                     if(this.field1096 < var4) {
                        return;
                     }

                     var7 = (this.field1096 - var3) / var6;
                     if(var7 >= this.field1102) {
                        this.field1096 -= var6 * this.field1102;
                        this.field1102 = 0;
                        break label205;
                     }

                     this.field1096 -= var6 * var7;
                     this.field1102 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1108 < 0) {
            if(this.field1096 < 0) {
               this.field1096 = -1;
               this.method1217();
               this.unlink();
            }
         } else if(this.field1096 >= var5) {
            this.field1096 = var5;
            this.method1217();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("as")
   int method1224(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1106 > 0) {
            int var6 = var2 + this.field1106;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1106 += var2;
            if(this.field1108 == -256 && (this.field1096 & 255) == 0) {
               if(class57.field1047) {
                  var2 = method1237(0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, this.field1105, this.field1109, 0, var6, var3, this);
               } else {
                  var2 = method1266(((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, this.field1107, 0, var6, var3, this);
               }
            } else if(class57.field1047) {
               var2 = method1241(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, this.field1105, this.field1109, 0, var6, var3, this, this.field1108, var5);
            } else {
               var2 = method1240(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, this.field1107, 0, var6, var3, this, this.field1108, var5);
            }

            this.field1106 -= var2;
            if(this.field1106 != 0) {
               return var2;
            }

            if(!this.method1225()) {
               continue;
            }

            return var4;
         }

         if(this.field1108 == -256 && (this.field1096 & 255) == 0) {
            if(class57.field1047) {
               return method1329(0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, 0, var4, var3, this);
            }

            return method1342(((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, 0, var4, var3, this);
         }

         if(class57.field1047) {
            return method1233(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, 0, var4, var3, this, this.field1108, var5);
         }

         return method1232(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, 0, var4, var3, this, this.field1108, var5);
      }
   }

   @ObfuscatedName("ai")
   boolean method1225() {
      int var1 = this.field1095;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1327(var1, this.field1098);
         var3 = method1333(var1, this.field1098);
      }

      if(this.field1099 == var1 && this.field1100 == var2 && this.field1101 == var3) {
         if(this.field1095 == Integer.MIN_VALUE) {
            this.field1095 = 0;
            this.field1101 = 0;
            this.field1100 = 0;
            this.field1099 = 0;
            this.unlink();
            return true;
         } else {
            this.method1201();
            return false;
         }
      } else {
         if(this.field1099 < var1) {
            this.field1107 = 1;
            this.field1106 = var1 - this.field1099;
         } else if(this.field1099 > var1) {
            this.field1107 = -1;
            this.field1106 = this.field1099 - var1;
         } else {
            this.field1107 = 0;
         }

         if(this.field1100 < var2) {
            this.field1105 = 1;
            if(this.field1106 == 0 || this.field1106 > var2 - this.field1100) {
               this.field1106 = var2 - this.field1100;
            }
         } else if(this.field1100 > var2) {
            this.field1105 = -1;
            if(this.field1106 == 0 || this.field1106 > this.field1100 - var2) {
               this.field1106 = this.field1100 - var2;
            }
         } else {
            this.field1105 = 0;
         }

         if(this.field1101 < var3) {
            this.field1109 = 1;
            if(this.field1106 == 0 || this.field1106 > var3 - this.field1101) {
               this.field1106 = var3 - this.field1101;
            }
         } else if(this.field1101 > var3) {
            this.field1109 = -1;
            if(this.field1106 == 0 || this.field1106 > this.field1101 - var3) {
               this.field1106 = this.field1101 - var3;
            }
         } else {
            this.field1109 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("at")
   static int method1226(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1096 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("br")
   static int method1231(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1096 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bk")
   static int method1232(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method1233(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1096 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   static int method1234(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1100 += var9.field1105 * (var6 - var3);
      var9.field1101 += var9.field1109 * (var6 - var3);

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

      var9.field1099 = var4 >> 2;
      var9.field1096 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bi")
   static int method1235(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1099 += var12.field1107 * (var9 - var4);
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

      var12.field1100 = var5 >> 2;
      var12.field1101 = var6 >> 2;
      var12.field1096 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("by")
   static int method1237(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1099 += var12.field1107 * (var9 - var4);
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

      var12.field1100 = var5 >> 2;
      var12.field1101 = var6 >> 2;
      var12.field1096 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   static int method1239(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1099 -= var13.field1107 * var5;
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
      var13.field1099 += var13.field1107 * var5;
      var13.field1100 = var6;
      var13.field1101 = var7;
      var13.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   static int method1240(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1100 -= var11.field1105 * var5;
      var11.field1101 -= var11.field1109 * var5;
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

      var11.field1100 += var11.field1105 * var5;
      var11.field1101 += var11.field1109 * var5;
      var11.field1099 = var6;
      var11.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   static int method1241(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1099 -= var13.field1107 * var5;
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
      var13.field1099 += var13.field1107 * var5;
      var13.field1100 = var6;
      var13.field1101 = var7;
      var13.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("w")
   protected int vmethod3097() {
      return this.field1095 == 0 && this.field1106 == 0?0:1;
   }

   @ObfuscatedName("ah")
   static int method1250(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1096 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("m")
   public synchronized void method1251(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1205(var2, var3);
      } else {
         int var4 = method1327(var2, var3);
         int var5 = method1333(var2, var3);
         if(this.field1100 == var4 && this.field1101 == var5) {
            this.field1106 = 0;
         } else {
            int var6 = var2 - this.field1099;
            if(this.field1099 - var2 > var6) {
               var6 = this.field1099 - var2;
            }

            if(var4 - this.field1100 > var6) {
               var6 = var4 - this.field1100;
            }

            if(this.field1100 - var4 > var6) {
               var6 = this.field1100 - var4;
            }

            if(var5 - this.field1101 > var6) {
               var6 = var5 - this.field1101;
            }

            if(this.field1101 - var5 > var6) {
               var6 = this.field1101 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1106 = var1;
            this.field1095 = var2;
            this.field1098 = var3;
            this.field1107 = (var2 - this.field1099) / var1;
            this.field1105 = (var4 - this.field1100) / var1;
            this.field1109 = (var5 - this.field1101) / var1;
         }
      }
   }

   @ObfuscatedName("af")
   public boolean method1259() {
      return this.field1106 != 0;
   }

   @ObfuscatedName("bl")
   static int method1266(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1100 += var9.field1105 * (var6 - var3);
      var9.field1101 += var9.field1109 * (var6 - var3);

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

      var9.field1099 = var4 >> 2;
      var9.field1096 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("s")
   public synchronized void method1281(int var1) {
      this.field1102 = var1;
   }

   @ObfuscatedName("bv")
   static int method1284(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1100 -= var11.field1105 * var5;
      var11.field1101 -= var11.field1109 * var5;
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

      var11.field1100 += var11.field1105 * var5;
      var11.field1101 += var11.field1109 * var5;
      var11.field1099 = var6;
      var11.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("n")
   public static class66 method1286(class55 var0, int var1, int var2) {
      return var0.field1012 != null && var0.field1012.length != 0?new class66(var0, (int)((long)var0.field1011 * 256L * (long)var1 / (long)(class57.field1032 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("u")
   protected class68 vmethod3091() {
      return null;
   }

   @ObfuscatedName("ab")
   int method1318(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1106 > 0) {
            int var6 = var2 + this.field1106;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1106 += var2;
            if(this.field1108 == 256 && (this.field1096 & 255) == 0) {
               if(class57.field1047) {
                  var2 = method1235(0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, this.field1105, this.field1109, 0, var6, var3, this);
               } else {
                  var2 = method1234(((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, this.field1107, 0, var6, var3, this);
               }
            } else if(class57.field1047) {
               var2 = method1239(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, this.field1105, this.field1109, 0, var6, var3, this, this.field1108, var5);
            } else {
               var2 = method1284(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, this.field1107, 0, var6, var3, this, this.field1108, var5);
            }

            this.field1106 -= var2;
            if(this.field1106 != 0) {
               return var2;
            }

            if(!this.method1225()) {
               continue;
            }

            return var4;
         }

         if(this.field1108 == 256 && (this.field1096 & 255) == 0) {
            if(class57.field1047) {
               return method1250(0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, 0, var4, var3, this);
            }

            return method1226(((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, 0, var4, var3, this);
         }

         if(class57.field1047) {
            return method1231(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1100, this.field1101, 0, var4, var3, this, this.field1108, var5);
         }

         return method1338(0, 0, ((class55)super.field1122).field1012, var1, this.field1096, var2, this.field1099, 0, var4, var3, this, this.field1108, var5);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1319(int var1) {
      this.method1205(var1, this.method1207());
   }

   @ObfuscatedName("d")
   static int method1327(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   static int method1329(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1096 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("c")
   static int method1333(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bu")
   static int method1338(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1096 = var4;
      return var5;
   }

   @ObfuscatedName("ap")
   static int method1342(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1096 = var2 << 8;
      return var3;
   }
}
