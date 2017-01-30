import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class66 extends class68 {
   @ObfuscatedName("x")
   int field1114;
   @ObfuscatedName("r")
   int field1115;
   @ObfuscatedName("g")
   int field1116;
   @ObfuscatedName("q")
   int field1117;
   @ObfuscatedName("d")
   int field1118;
   @ObfuscatedName("k")
   int field1119;
   @ObfuscatedName("j")
   int field1120;
   @ObfuscatedName("s")
   int field1121;
   @ObfuscatedName("p")
   int field1122;
   @ObfuscatedName("a")
   int field1123;
   @ObfuscatedName("h")
   int field1124;
   @ObfuscatedName("m")
   int field1125;
   @ObfuscatedName("o")
   int field1126;
   @ObfuscatedName("c")
   boolean field1127;
   @ObfuscatedName("u")
   int field1128;

   @ObfuscatedName("g")
   static int method1156(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1143 = var1;
      this.field1126 = var1.field1023;
      this.field1123 = var1.field1026;
      this.field1127 = var1.field1027;
      this.field1116 = var2;
      this.field1114 = var3;
      this.field1117 = var4;
      this.field1122 = 0;
      this.method1261();
   }

   @ObfuscatedName("q")
   public static class66 method1160(class55 var0, int var1, int var2, int var3) {
      return var0.field1024 != null && var0.field1024.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("a")
   public synchronized void method1162(int var1) {
      this.field1121 = var1;
   }

   @ObfuscatedName("u")
   public synchronized void method1163(int var1) {
      this.method1259(var1 << 6, this.method1271());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1164(int var1) {
      this.method1259(var1, this.method1271());
   }

   @ObfuscatedName("p")
   static int method1165(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("n")
   public synchronized int method1166() {
      return this.field1114 == Integer.MIN_VALUE?0:this.field1114;
   }

   @ObfuscatedName("y")
   public synchronized void method1168(int var1) {
      int var2 = ((class55)super.field1143).field1024.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1122 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1169() {
      this.field1116 = (this.field1116 ^ this.field1116 >> 31) + (this.field1116 >>> 31);
      this.field1116 = -this.field1116;
   }

   @ObfuscatedName("f")
   void method1170() {
      if(this.field1125 != 0) {
         if(this.field1114 == Integer.MIN_VALUE) {
            this.field1114 = 0;
         }

         this.field1125 = 0;
         this.method1261();
      }

   }

   @ObfuscatedName("b")
   public synchronized void method1173(int var1) {
      if(var1 == 0) {
         this.method1164(0);
         this.unlink();
      } else if(this.field1119 == 0 && this.field1120 == 0) {
         this.field1125 = 0;
         this.field1114 = 0;
         this.field1118 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1118;
         if(this.field1118 > var2) {
            var2 = this.field1118;
         }

         if(-this.field1119 > var2) {
            var2 = -this.field1119;
         }

         if(this.field1119 > var2) {
            var2 = this.field1119;
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

         this.field1125 = var1;
         this.field1114 = Integer.MIN_VALUE;
         this.field1124 = -this.field1118 / var1;
         this.field1115 = -this.field1119 / var1;
         this.field1128 = -this.field1120 / var1;
      }
   }

   @ObfuscatedName("ag")
   public synchronized void method1174(int var1) {
      if(this.field1116 < 0) {
         this.field1116 = -var1;
      } else {
         this.field1116 = var1;
      }

   }

   @ObfuscatedName("ab")
   public boolean method1176() {
      return this.field1122 < 0 || this.field1122 >= ((class55)super.field1143).field1024.length << 8;
   }

   @ObfuscatedName("an")
   public boolean method1177() {
      return this.field1125 != 0;
   }

   @ObfuscatedName("k")
   protected class68 vmethod2701() {
      return null;
   }

   @ObfuscatedName("o")
   public synchronized void vmethod2704(int[] var1, int var2, int var3) {
      if(this.field1114 == 0 && this.field1125 == 0) {
         this.vmethod2705(var3);
      } else {
         class55 var4 = (class55)super.field1143;
         int var5 = this.field1126 << 8;
         int var6 = this.field1123 << 8;
         int var7 = var4.field1024.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1121 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1122 < 0) {
            if(this.field1116 <= 0) {
               this.method1170();
               this.unlink();
               return;
            }

            this.field1122 = 0;
         }

         if(this.field1122 >= var7) {
            if(this.field1116 >= 0) {
               this.method1170();
               this.unlink();
               return;
            }

            this.field1122 = var7 - 1;
         }

         if(this.field1121 < 0) {
            if(this.field1127) {
               if(this.field1116 < 0) {
                  var9 = this.method1184(var1, var2, var5, var3, var4.field1024[this.field1126]);
                  if(this.field1122 >= var5) {
                     return;
                  }

                  this.field1122 = var5 + var5 - 1 - this.field1122;
                  this.field1116 = -this.field1116;
               }

               while(true) {
                  var9 = this.method1265(var1, var9, var6, var3, var4.field1024[this.field1123 - 1]);
                  if(this.field1122 < var6) {
                     return;
                  }

                  this.field1122 = var6 + var6 - 1 - this.field1122;
                  this.field1116 = -this.field1116;
                  var9 = this.method1184(var1, var9, var5, var3, var4.field1024[this.field1126]);
                  if(this.field1122 >= var5) {
                     return;
                  }

                  this.field1122 = var5 + var5 - 1 - this.field1122;
                  this.field1116 = -this.field1116;
               }
            } else if(this.field1116 < 0) {
               while(true) {
                  var9 = this.method1184(var1, var9, var5, var3, var4.field1024[this.field1123 - 1]);
                  if(this.field1122 >= var5) {
                     return;
                  }

                  this.field1122 = var6 - 1 - (var6 - 1 - this.field1122) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1265(var1, var9, var6, var3, var4.field1024[this.field1126]);
                  if(this.field1122 < var6) {
                     return;
                  }

                  this.field1122 = var5 + (this.field1122 - var5) % var8;
               }
            }
         } else {
            if(this.field1121 > 0) {
               if(this.field1127) {
                  label189: {
                     if(this.field1116 < 0) {
                        var9 = this.method1184(var1, var2, var5, var3, var4.field1024[this.field1126]);
                        if(this.field1122 >= var5) {
                           return;
                        }

                        this.field1122 = var5 + var5 - 1 - this.field1122;
                        this.field1116 = -this.field1116;
                        if(--this.field1121 == 0) {
                           break label189;
                        }
                     }

                     do {
                        var9 = this.method1265(var1, var9, var6, var3, var4.field1024[this.field1123 - 1]);
                        if(this.field1122 < var6) {
                           return;
                        }

                        this.field1122 = var6 + var6 - 1 - this.field1122;
                        this.field1116 = -this.field1116;
                        if(--this.field1121 == 0) {
                           break;
                        }

                        var9 = this.method1184(var1, var9, var5, var3, var4.field1024[this.field1126]);
                        if(this.field1122 >= var5) {
                           return;
                        }

                        this.field1122 = var5 + var5 - 1 - this.field1122;
                        this.field1116 = -this.field1116;
                     } while(--this.field1121 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1116 < 0) {
                     while(true) {
                        var9 = this.method1184(var1, var9, var5, var3, var4.field1024[this.field1123 - 1]);
                        if(this.field1122 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1122) / var8;
                        if(var10 >= this.field1121) {
                           this.field1122 += var8 * this.field1121;
                           this.field1121 = 0;
                           break;
                        }

                        this.field1122 += var8 * var10;
                        this.field1121 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1265(var1, var9, var6, var3, var4.field1024[this.field1126]);
                        if(this.field1122 < var6) {
                           return;
                        }

                        var10 = (this.field1122 - var5) / var8;
                        if(var10 >= this.field1121) {
                           this.field1122 -= var8 * this.field1121;
                           this.field1121 = 0;
                           break;
                        }

                        this.field1122 -= var8 * var10;
                        this.field1121 -= var10;
                     }
                  }
               }
            }

            if(this.field1116 < 0) {
               this.method1184(var1, var9, 0, var3, 0);
               if(this.field1122 < 0) {
                  this.field1122 = -1;
                  this.method1170();
                  this.unlink();
               }
            } else {
               this.method1265(var1, var9, var7, var3, 0);
               if(this.field1122 >= var7) {
                  this.field1122 = var7;
                  this.method1170();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   public synchronized void vmethod2705(int var1) {
      if(this.field1125 > 0) {
         if(var1 >= this.field1125) {
            if(this.field1114 == Integer.MIN_VALUE) {
               this.field1114 = 0;
               this.field1120 = 0;
               this.field1119 = 0;
               this.field1118 = 0;
               this.unlink();
               var1 = this.field1125;
            }

            this.field1125 = 0;
            this.method1261();
         } else {
            this.field1118 += this.field1124 * var1;
            this.field1119 += this.field1115 * var1;
            this.field1120 += this.field1128 * var1;
            this.field1125 -= var1;
         }
      }

      class55 var2 = (class55)super.field1143;
      int var3 = this.field1126 << 8;
      int var4 = this.field1123 << 8;
      int var5 = var2.field1024.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1121 = 0;
      }

      if(this.field1122 < 0) {
         if(this.field1116 <= 0) {
            this.method1170();
            this.unlink();
            return;
         }

         this.field1122 = 0;
      }

      if(this.field1122 >= var5) {
         if(this.field1116 >= 0) {
            this.method1170();
            this.unlink();
            return;
         }

         this.field1122 = var5 - 1;
      }

      this.field1122 += this.field1116 * var1;
      if(this.field1121 < 0) {
         if(!this.field1127) {
            if(this.field1116 < 0) {
               if(this.field1122 >= var3) {
                  return;
               }

               this.field1122 = var4 - 1 - (var4 - 1 - this.field1122) % var6;
            } else {
               if(this.field1122 < var4) {
                  return;
               }

               this.field1122 = var3 + (this.field1122 - var3) % var6;
            }

         } else {
            if(this.field1116 < 0) {
               if(this.field1122 >= var3) {
                  return;
               }

               this.field1122 = var3 + var3 - 1 - this.field1122;
               this.field1116 = -this.field1116;
            }

            while(this.field1122 >= var4) {
               this.field1122 = var4 + var4 - 1 - this.field1122;
               this.field1116 = -this.field1116;
               if(this.field1122 >= var3) {
                  return;
               }

               this.field1122 = var3 + var3 - 1 - this.field1122;
               this.field1116 = -this.field1116;
            }

         }
      } else {
         if(this.field1121 > 0) {
            if(this.field1127) {
               label167: {
                  if(this.field1116 < 0) {
                     if(this.field1122 >= var3) {
                        return;
                     }

                     this.field1122 = var3 + var3 - 1 - this.field1122;
                     this.field1116 = -this.field1116;
                     if(--this.field1121 == 0) {
                        break label167;
                     }
                  }

                  do {
                     if(this.field1122 < var4) {
                        return;
                     }

                     this.field1122 = var4 + var4 - 1 - this.field1122;
                     this.field1116 = -this.field1116;
                     if(--this.field1121 == 0) {
                        break;
                     }

                     if(this.field1122 >= var3) {
                        return;
                     }

                     this.field1122 = var3 + var3 - 1 - this.field1122;
                     this.field1116 = -this.field1116;
                  } while(--this.field1121 != 0);
               }
            } else {
               int var7;
               if(this.field1116 < 0) {
                  if(this.field1122 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1122) / var6;
                  if(var7 < this.field1121) {
                     this.field1122 += var6 * var7;
                     this.field1121 -= var7;
                     return;
                  }

                  this.field1122 += var6 * this.field1121;
                  this.field1121 = 0;
               } else {
                  if(this.field1122 < var4) {
                     return;
                  }

                  var7 = (this.field1122 - var3) / var6;
                  if(var7 < this.field1121) {
                     this.field1122 -= var6 * var7;
                     this.field1121 -= var7;
                     return;
                  }

                  this.field1122 -= var6 * this.field1121;
                  this.field1121 = 0;
               }
            }
         }

         if(this.field1116 < 0) {
            if(this.field1122 < 0) {
               this.field1122 = -1;
               this.method1170();
               this.unlink();
            }
         } else if(this.field1122 >= var5) {
            this.field1122 = var5;
            this.method1170();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("at")
   int method1184(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1125 > 0) {
            int var6 = var2 + this.field1125;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1125 += var2;
            if(this.field1116 == -256 && (this.field1122 & 255) == 0) {
               if(class57.field1042) {
                  var2 = method1197(0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, this.field1115, this.field1128, 0, var6, var3, this);
               } else {
                  var2 = method1196(((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, this.field1124, 0, var6, var3, this);
               }
            } else if(class57.field1042) {
               var2 = method1201(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, this.field1115, this.field1128, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1200(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, this.field1124, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1125 -= var2;
            if(this.field1125 != 0) {
               return var2;
            }

            if(!this.method1185()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == -256 && (this.field1122 & 255) == 0) {
            if(class57.field1042) {
               return method1235(0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, 0, var4, var3, this);
            }

            return method1205(((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, 0, var4, var3, this);
         }

         if(class57.field1042) {
            return method1280(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, 0, var4, var3, this, this.field1116, var5);
         }

         return method1192(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("az")
   boolean method1185() {
      int var1 = this.field1114;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1165(var1, this.field1117);
         var3 = method1156(var1, this.field1117);
      }

      if(this.field1118 == var1 && this.field1119 == var2 && this.field1120 == var3) {
         if(this.field1114 == Integer.MIN_VALUE) {
            this.field1114 = 0;
            this.field1120 = 0;
            this.field1119 = 0;
            this.field1118 = 0;
            this.unlink();
            return true;
         } else {
            this.method1261();
            return false;
         }
      } else {
         if(this.field1118 < var1) {
            this.field1124 = 1;
            this.field1125 = var1 - this.field1118;
         } else if(this.field1118 > var1) {
            this.field1124 = -1;
            this.field1125 = this.field1118 - var1;
         } else {
            this.field1124 = 0;
         }

         if(this.field1119 < var2) {
            this.field1115 = 1;
            if(this.field1125 == 0 || this.field1125 > var2 - this.field1119) {
               this.field1125 = var2 - this.field1119;
            }
         } else if(this.field1119 > var2) {
            this.field1115 = -1;
            if(this.field1125 == 0 || this.field1125 > this.field1119 - var2) {
               this.field1125 = this.field1119 - var2;
            }
         } else {
            this.field1115 = 0;
         }

         if(this.field1120 < var3) {
            this.field1128 = 1;
            if(this.field1125 == 0 || this.field1125 > var3 - this.field1120) {
               this.field1125 = var3 - this.field1120;
            }
         } else if(this.field1120 > var3) {
            this.field1128 = -1;
            if(this.field1125 == 0 || this.field1125 > this.field1120 - var3) {
               this.field1125 = this.field1120 - var3;
            }
         } else {
            this.field1128 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("as")
   static int method1186(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1122 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("be")
   static int method1187(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1122 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("br")
   static int method1190(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1192(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("l")
   public synchronized void method1194(int var1, int var2) {
      this.method1295(var1, var2, this.method1271());
   }

   @ObfuscatedName("bp")
   static int method1196(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1119 += var9.field1115 * (var6 - var3);
      var9.field1120 += var9.field1128 * (var6 - var3);

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

      var9.field1118 = var4 >> 2;
      var9.field1122 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   static int method1197(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1118 += var12.field1124 * (var9 - var4);
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

      var12.field1119 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1122 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bx")
   static int method1198(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1119 -= var11.field1115 * var5;
      var11.field1120 -= var11.field1128 * var5;
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

      var11.field1119 += var11.field1115 * var5;
      var11.field1120 += var11.field1128 * var5;
      var11.field1118 = var6;
      var11.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1199(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1118 -= var13.field1124 * var5;
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
      var13.field1118 += var13.field1124 * var5;
      var13.field1119 = var6;
      var13.field1120 = var7;
      var13.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("ba")
   static int method1200(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1119 -= var11.field1115 * var5;
      var11.field1120 -= var11.field1128 * var5;
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

      var11.field1119 += var11.field1115 * var5;
      var11.field1120 += var11.field1128 * var5;
      var11.field1118 = var6;
      var11.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   static int method1201(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1118 -= var13.field1124 * var5;
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
      var13.field1118 += var13.field1124 * var5;
      var13.field1119 = var6;
      var13.field1120 = var7;
      var13.field1122 = var4;
      return var5;
   }

   @ObfuscatedName("s")
   protected int vmethod2703() {
      return this.field1114 == 0 && this.field1125 == 0?0:1;
   }

   @ObfuscatedName("bu")
   static int method1205(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1122 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("x")
   public static class66 method1214(class55 var0, int var1, int var2) {
      return var0.field1024 != null && var0.field1024.length != 0?new class66(var0, (int)((long)var0.field1025 * 256L * (long)var1 / (long)(class57.field1047 * 100)), var2 << 6):null;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1143 = var1;
      this.field1126 = var1.field1023;
      this.field1123 = var1.field1026;
      this.field1127 = var1.field1027;
      this.field1116 = var2;
      this.field1114 = var3;
      this.field1117 = 8192;
      this.field1122 = 0;
      this.method1261();
   }

   @ObfuscatedName("bf")
   static int method1217(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1119 += var9.field1115 * (var6 - var3);
      var9.field1120 += var9.field1128 * (var6 - var3);

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

      var9.field1118 = var4 >> 2;
      var9.field1122 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bo")
   static int method1235(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1122 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("z")
   synchronized void method1259(int var1, int var2) {
      this.field1114 = var1;
      this.field1117 = var2;
      this.field1125 = 0;
      this.method1261();
   }

   @ObfuscatedName("d")
   void method1261() {
      this.field1118 = this.field1114;
      this.field1119 = method1165(this.field1114, this.field1117);
      this.field1120 = method1156(this.field1114, this.field1117);
   }

   @ObfuscatedName("aq")
   int method1265(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1125 > 0) {
            int var6 = var2 + this.field1125;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1125 += var2;
            if(this.field1116 == 256 && (this.field1122 & 255) == 0) {
               if(class57.field1042) {
                  var2 = method1281(0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, this.field1115, this.field1128, 0, var6, var3, this);
               } else {
                  var2 = method1217(((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, this.field1124, 0, var6, var3, this);
               }
            } else if(class57.field1042) {
               var2 = method1199(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, this.field1115, this.field1128, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1198(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, this.field1124, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1125 -= var2;
            if(this.field1125 != 0) {
               return var2;
            }

            if(!this.method1185()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == 256 && (this.field1122 & 255) == 0) {
            if(class57.field1042) {
               return method1187(0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, 0, var4, var3, this);
            }

            return method1186(((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, 0, var4, var3, this);
         }

         if(class57.field1042) {
            return method1297(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1119, this.field1120, 0, var4, var3, this, this.field1116, var5);
         }

         return method1190(0, 0, ((class55)super.field1143).field1024, var1, this.field1122, var2, this.field1118, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("au")
   int vmethod1331() {
      int var1 = this.field1118 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1121 == 0) {
         var1 -= var1 * this.field1122 / (((class55)super.field1143).field1024.length << 8);
      } else if(this.field1121 >= 0) {
         var1 -= var1 * this.field1126 / ((class55)super.field1143).field1024.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("w")
   public synchronized int method1271() {
      return this.field1117 < 0?-1:this.field1117;
   }

   @ObfuscatedName("j")
   protected class68 vmethod2702() {
      return null;
   }

   @ObfuscatedName("bm")
   static int method1280(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1122 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bg")
   static int method1281(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1118 += var12.field1124 * (var9 - var4);
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

      var12.field1119 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1122 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("t")
   public synchronized void method1295(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1259(var2, var3);
      } else {
         int var4 = method1165(var2, var3);
         int var5 = method1156(var2, var3);
         if(this.field1119 == var4 && this.field1120 == var5) {
            this.field1125 = 0;
         } else {
            int var6 = var2 - this.field1118;
            if(this.field1118 - var2 > var6) {
               var6 = this.field1118 - var2;
            }

            if(var4 - this.field1119 > var6) {
               var6 = var4 - this.field1119;
            }

            if(this.field1119 - var4 > var6) {
               var6 = this.field1119 - var4;
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

            this.field1125 = var1;
            this.field1114 = var2;
            this.field1117 = var3;
            this.field1124 = (var2 - this.field1118) / var1;
            this.field1115 = (var4 - this.field1119) / var1;
            this.field1128 = (var5 - this.field1120) / var1;
         }
      }
   }

   @ObfuscatedName("ao")
   public synchronized int method1296() {
      return this.field1116 < 0?-this.field1116:this.field1116;
   }

   @ObfuscatedName("bb")
   static int method1297(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1122 = var4;
      return var5 >> 1;
   }
}
