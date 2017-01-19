import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class66 extends class68 {
   @ObfuscatedName("x")
   int field1112;
   @ObfuscatedName("c")
   int field1113;
   @ObfuscatedName("f")
   int field1114;
   @ObfuscatedName("h")
   int field1115;
   @ObfuscatedName("a")
   int field1116;
   @ObfuscatedName("g")
   int field1117;
   @ObfuscatedName("r")
   boolean field1118;
   @ObfuscatedName("u")
   int field1119;
   @ObfuscatedName("k")
   int field1120;
   @ObfuscatedName("p")
   int field1121;
   @ObfuscatedName("n")
   int field1122;
   @ObfuscatedName("s")
   int field1123;
   @ObfuscatedName("m")
   int field1124;
   @ObfuscatedName("j")
   int field1125;
   @ObfuscatedName("b")
   int field1126;

   @ObfuscatedName("bb")
   static int method1124(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1116 -= var13.field1124 * var5;
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
      var13.field1116 += var13.field1124 * var5;
      var13.field1117 = var6;
      var13.field1120 = var7;
      var13.field1123 = var4;
      return var5;
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1141 = var1;
      this.field1126 = var1.field1019;
      this.field1112 = var1.field1022;
      this.field1118 = var1.field1023;
      this.field1113 = var2;
      this.field1114 = var3;
      this.field1115 = var4;
      this.field1123 = 0;
      this.method1128();
   }

   @ObfuscatedName("f")
   public static class66 method1126(class55 var0, int var1, int var2) {
      return var0.field1020 != null && var0.field1020.length != 0?new class66(var0, (int)((long)var0.field1021 * 256L * (long)var1 / (long)(class57.field1057 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("g")
   public static class66 method1127(class55 var0, int var1, int var2, int var3) {
      return var0.field1020 != null && var0.field1020.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("k")
   void method1128() {
      this.field1116 = this.field1114;
      this.field1117 = method1138(this.field1114, this.field1115);
      this.field1120 = method1267(this.field1114, this.field1115);
   }

   @ObfuscatedName("ac")
   static int method1129(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1123 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("j")
   public synchronized void method1130(int var1) {
      this.method1132(var1 << 6, this.method1228());
   }

   @ObfuscatedName("q")
   public synchronized void method1131(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1132(var2, var3);
      } else {
         int var4 = method1138(var2, var3);
         int var5 = method1267(var2, var3);
         if(this.field1117 == var4 && this.field1120 == var5) {
            this.field1122 = 0;
         } else {
            int var6 = var2 - this.field1116;
            if(this.field1116 - var2 > var6) {
               var6 = this.field1116 - var2;
            }

            if(var4 - this.field1117 > var6) {
               var6 = var4 - this.field1117;
            }

            if(this.field1117 - var4 > var6) {
               var6 = this.field1117 - var4;
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

            this.field1122 = var1;
            this.field1114 = var2;
            this.field1115 = var3;
            this.field1124 = (var2 - this.field1116) / var1;
            this.field1125 = (var4 - this.field1117) / var1;
            this.field1121 = (var5 - this.field1120) / var1;
         }
      }
   }

   @ObfuscatedName("p")
   synchronized void method1132(int var1, int var2) {
      this.field1114 = var1;
      this.field1115 = var2;
      this.field1122 = 0;
      this.method1128();
   }

   @ObfuscatedName("o")
   public synchronized int method1133() {
      return this.field1114 == Integer.MIN_VALUE?0:this.field1114;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1136() {
      this.field1113 = (this.field1113 ^ this.field1113 >> 31) + (this.field1113 >>> 31);
      this.field1113 = -this.field1113;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1141 = var1;
      this.field1126 = var1.field1019;
      this.field1112 = var1.field1022;
      this.field1118 = var1.field1023;
      this.field1113 = var2;
      this.field1114 = var3;
      this.field1115 = 8192;
      this.field1123 = 0;
      this.method1128();
   }

   @ObfuscatedName("s")
   static int method1138(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("y")
   public synchronized void method1139(int var1) {
      if(var1 == 0) {
         this.method1251(0);
         this.unlink();
      } else if(this.field1117 == 0 && this.field1120 == 0) {
         this.field1122 = 0;
         this.field1114 = 0;
         this.field1116 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1116;
         if(this.field1116 > var2) {
            var2 = this.field1116;
         }

         if(-this.field1117 > var2) {
            var2 = -this.field1117;
         }

         if(this.field1117 > var2) {
            var2 = this.field1117;
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

         this.field1122 = var1;
         this.field1114 = Integer.MIN_VALUE;
         this.field1124 = -this.field1116 / var1;
         this.field1125 = -this.field1117 / var1;
         this.field1121 = -this.field1120 / var1;
      }
   }

   @ObfuscatedName("ar")
   public synchronized int method1141() {
      return this.field1113 < 0?-this.field1113:this.field1113;
   }

   @ObfuscatedName("aq")
   public boolean method1143() {
      return this.field1122 != 0;
   }

   @ObfuscatedName("u")
   protected class68 vmethod2611() {
      return null;
   }

   @ObfuscatedName("b")
   protected class68 vmethod2612() {
      return null;
   }

   @ObfuscatedName("r")
   public synchronized void vmethod2614(int[] var1, int var2, int var3) {
      if(this.field1114 == 0 && this.field1122 == 0) {
         this.vmethod2615(var3);
      } else {
         class55 var4 = (class55)super.field1141;
         int var5 = this.field1126 << 8;
         int var6 = this.field1112 << 8;
         int var7 = var4.field1020.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1119 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1123 < 0) {
            if(this.field1113 <= 0) {
               this.method1215();
               this.unlink();
               return;
            }

            this.field1123 = 0;
         }

         if(this.field1123 >= var7) {
            if(this.field1113 >= 0) {
               this.method1215();
               this.unlink();
               return;
            }

            this.field1123 = var7 - 1;
         }

         if(this.field1119 < 0) {
            if(this.field1118) {
               if(this.field1113 < 0) {
                  var9 = this.method1196(var1, var2, var5, var3, var4.field1020[this.field1126]);
                  if(this.field1123 >= var5) {
                     return;
                  }

                  this.field1123 = var5 + var5 - 1 - this.field1123;
                  this.field1113 = -this.field1113;
               }

               while(true) {
                  var9 = this.method1149(var1, var9, var6, var3, var4.field1020[this.field1112 - 1]);
                  if(this.field1123 < var6) {
                     return;
                  }

                  this.field1123 = var6 + var6 - 1 - this.field1123;
                  this.field1113 = -this.field1113;
                  var9 = this.method1196(var1, var9, var5, var3, var4.field1020[this.field1126]);
                  if(this.field1123 >= var5) {
                     return;
                  }

                  this.field1123 = var5 + var5 - 1 - this.field1123;
                  this.field1113 = -this.field1113;
               }
            } else if(this.field1113 < 0) {
               while(true) {
                  var9 = this.method1196(var1, var9, var5, var3, var4.field1020[this.field1112 - 1]);
                  if(this.field1123 >= var5) {
                     return;
                  }

                  this.field1123 = var6 - 1 - (var6 - 1 - this.field1123) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1149(var1, var9, var6, var3, var4.field1020[this.field1126]);
                  if(this.field1123 < var6) {
                     return;
                  }

                  this.field1123 = var5 + (this.field1123 - var5) % var8;
               }
            }
         } else {
            if(this.field1119 > 0) {
               if(this.field1118) {
                  label183: {
                     if(this.field1113 < 0) {
                        var9 = this.method1196(var1, var2, var5, var3, var4.field1020[this.field1126]);
                        if(this.field1123 >= var5) {
                           return;
                        }

                        this.field1123 = var5 + var5 - 1 - this.field1123;
                        this.field1113 = -this.field1113;
                        if(--this.field1119 == 0) {
                           break label183;
                        }
                     }

                     do {
                        var9 = this.method1149(var1, var9, var6, var3, var4.field1020[this.field1112 - 1]);
                        if(this.field1123 < var6) {
                           return;
                        }

                        this.field1123 = var6 + var6 - 1 - this.field1123;
                        this.field1113 = -this.field1113;
                        if(--this.field1119 == 0) {
                           break;
                        }

                        var9 = this.method1196(var1, var9, var5, var3, var4.field1020[this.field1126]);
                        if(this.field1123 >= var5) {
                           return;
                        }

                        this.field1123 = var5 + var5 - 1 - this.field1123;
                        this.field1113 = -this.field1113;
                     } while(--this.field1119 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1113 < 0) {
                     while(true) {
                        var9 = this.method1196(var1, var9, var5, var3, var4.field1020[this.field1112 - 1]);
                        if(this.field1123 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1123) / var8;
                        if(var10 >= this.field1119) {
                           this.field1123 += var8 * this.field1119;
                           this.field1119 = 0;
                           break;
                        }

                        this.field1123 += var8 * var10;
                        this.field1119 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1149(var1, var9, var6, var3, var4.field1020[this.field1126]);
                        if(this.field1123 < var6) {
                           return;
                        }

                        var10 = (this.field1123 - var5) / var8;
                        if(var10 >= this.field1119) {
                           this.field1123 -= var8 * this.field1119;
                           this.field1119 = 0;
                           break;
                        }

                        this.field1123 -= var8 * var10;
                        this.field1119 -= var10;
                     }
                  }
               }
            }

            if(this.field1113 < 0) {
               this.method1196(var1, var9, 0, var3, 0);
               if(this.field1123 < 0) {
                  this.field1123 = -1;
                  this.method1215();
                  this.unlink();
               }
            } else {
               this.method1149(var1, var9, var7, var3, 0);
               if(this.field1123 >= var7) {
                  this.field1123 = var7;
                  this.method1215();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   public synchronized void vmethod2615(int var1) {
      if(this.field1122 > 0) {
         if(var1 >= this.field1122) {
            if(this.field1114 == Integer.MIN_VALUE) {
               this.field1114 = 0;
               this.field1120 = 0;
               this.field1117 = 0;
               this.field1116 = 0;
               this.unlink();
               var1 = this.field1122;
            }

            this.field1122 = 0;
            this.method1128();
         } else {
            this.field1116 += this.field1124 * var1;
            this.field1117 += this.field1125 * var1;
            this.field1120 += this.field1121 * var1;
            this.field1122 -= var1;
         }
      }

      class55 var2 = (class55)super.field1141;
      int var3 = this.field1126 << 8;
      int var4 = this.field1112 << 8;
      int var5 = var2.field1020.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1119 = 0;
      }

      if(this.field1123 < 0) {
         if(this.field1113 <= 0) {
            this.method1215();
            this.unlink();
            return;
         }

         this.field1123 = 0;
      }

      if(this.field1123 >= var5) {
         if(this.field1113 >= 0) {
            this.method1215();
            this.unlink();
            return;
         }

         this.field1123 = var5 - 1;
      }

      this.field1123 += this.field1113 * var1;
      if(this.field1119 < 0) {
         if(!this.field1118) {
            if(this.field1113 < 0) {
               if(this.field1123 >= var3) {
                  return;
               }

               this.field1123 = var4 - 1 - (var4 - 1 - this.field1123) % var6;
            } else {
               if(this.field1123 < var4) {
                  return;
               }

               this.field1123 = var3 + (this.field1123 - var3) % var6;
            }

         } else {
            if(this.field1113 < 0) {
               if(this.field1123 >= var3) {
                  return;
               }

               this.field1123 = var3 + var3 - 1 - this.field1123;
               this.field1113 = -this.field1113;
            }

            while(this.field1123 >= var4) {
               this.field1123 = var4 + var4 - 1 - this.field1123;
               this.field1113 = -this.field1113;
               if(this.field1123 >= var3) {
                  return;
               }

               this.field1123 = var3 + var3 - 1 - this.field1123;
               this.field1113 = -this.field1113;
            }

         }
      } else {
         if(this.field1119 > 0) {
            if(this.field1118) {
               label172: {
                  if(this.field1113 < 0) {
                     if(this.field1123 >= var3) {
                        return;
                     }

                     this.field1123 = var3 + var3 - 1 - this.field1123;
                     this.field1113 = -this.field1113;
                     if(--this.field1119 == 0) {
                        break label172;
                     }
                  }

                  do {
                     if(this.field1123 < var4) {
                        return;
                     }

                     this.field1123 = var4 + var4 - 1 - this.field1123;
                     this.field1113 = -this.field1113;
                     if(--this.field1119 == 0) {
                        break;
                     }

                     if(this.field1123 >= var3) {
                        return;
                     }

                     this.field1123 = var3 + var3 - 1 - this.field1123;
                     this.field1113 = -this.field1113;
                  } while(--this.field1119 != 0);
               }
            } else {
               label204: {
                  int var7;
                  if(this.field1113 < 0) {
                     if(this.field1123 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1123) / var6;
                     if(var7 >= this.field1119) {
                        this.field1123 += var6 * this.field1119;
                        this.field1119 = 0;
                        break label204;
                     }

                     this.field1123 += var6 * var7;
                     this.field1119 -= var7;
                  } else {
                     if(this.field1123 < var4) {
                        return;
                     }

                     var7 = (this.field1123 - var3) / var6;
                     if(var7 >= this.field1119) {
                        this.field1123 -= var6 * this.field1119;
                        this.field1119 = 0;
                        break label204;
                     }

                     this.field1123 -= var6 * var7;
                     this.field1119 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1113 < 0) {
            if(this.field1123 < 0) {
               this.field1123 = -1;
               this.method1215();
               this.unlink();
            }
         } else if(this.field1123 >= var5) {
            this.field1123 = var5;
            this.method1215();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("af")
   int method1149(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1122 > 0) {
            int var6 = var2 + this.field1122;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1122 += var2;
            if(this.field1113 == 256 && (this.field1123 & 255) == 0) {
               if(class57.field1052) {
                  var2 = method1161(0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, this.field1125, this.field1121, 0, var6, var3, this);
               } else {
                  var2 = method1195(((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, this.field1124, 0, var6, var3, this);
               }
            } else if(class57.field1052) {
               var2 = method1124(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, this.field1125, this.field1121, 0, var6, var3, this, this.field1113, var5);
            } else {
               var2 = method1164(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, this.field1124, 0, var6, var3, this, this.field1113, var5);
            }

            this.field1122 -= var2;
            if(this.field1122 != 0) {
               return var2;
            }

            if(!this.method1151()) {
               continue;
            }

            return var4;
         }

         if(this.field1113 == 256 && (this.field1123 & 255) == 0) {
            if(class57.field1052) {
               return method1153(0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, 0, var4, var3, this);
            }

            return method1129(((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, 0, var4, var3, this);
         }

         if(class57.field1052) {
            return method1157(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, 0, var4, var3, this, this.field1113, var5);
         }

         return method1156(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, 0, var4, var3, this, this.field1113, var5);
      }
   }

   @ObfuscatedName("ap")
   boolean method1151() {
      int var1 = this.field1114;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1138(var1, this.field1115);
         var3 = method1267(var1, this.field1115);
      }

      if(this.field1116 == var1 && this.field1117 == var2 && this.field1120 == var3) {
         if(this.field1114 == Integer.MIN_VALUE) {
            this.field1114 = 0;
            this.field1120 = 0;
            this.field1117 = 0;
            this.field1116 = 0;
            this.unlink();
            return true;
         } else {
            this.method1128();
            return false;
         }
      } else {
         if(this.field1116 < var1) {
            this.field1124 = 1;
            this.field1122 = var1 - this.field1116;
         } else if(this.field1116 > var1) {
            this.field1124 = -1;
            this.field1122 = this.field1116 - var1;
         } else {
            this.field1124 = 0;
         }

         if(this.field1117 < var2) {
            this.field1125 = 1;
            if(this.field1122 == 0 || this.field1122 > var2 - this.field1117) {
               this.field1122 = var2 - this.field1117;
            }
         } else if(this.field1117 > var2) {
            this.field1125 = -1;
            if(this.field1122 == 0 || this.field1122 > this.field1117 - var2) {
               this.field1122 = this.field1117 - var2;
            }
         } else {
            this.field1125 = 0;
         }

         if(this.field1120 < var3) {
            this.field1121 = 1;
            if(this.field1122 == 0 || this.field1122 > var3 - this.field1120) {
               this.field1122 = var3 - this.field1120;
            }
         } else if(this.field1120 > var3) {
            this.field1121 = -1;
            if(this.field1122 == 0 || this.field1122 > this.field1120 - var3) {
               this.field1122 = this.field1120 - var3;
            }
         } else {
            this.field1121 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("at")
   static int method1153(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1123 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("av")
   static int method1154(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1123 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aw")
   public synchronized void method1155(int var1) {
      if(this.field1113 < 0) {
         this.field1113 = -var1;
      } else {
         this.field1113 = var1;
      }

   }

   @ObfuscatedName("ak")
   static int method1156(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1123 = var4;
      return var5;
   }

   @ObfuscatedName("au")
   static int method1157(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1123 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("z")
   public synchronized void method1158(int var1) {
      int var2 = ((class55)super.field1141).field1020.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1123 = var1;
   }

   @ObfuscatedName("ab")
   static int method1159(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1123 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   static int method1161(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1116 += var12.field1124 * (var9 - var4);
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

      var12.field1117 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1123 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   int vmethod1331() {
      int var1 = this.field1116 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1119 == 0) {
         var1 -= var1 * this.field1123 / (((class55)super.field1141).field1020.length << 8);
      } else if(this.field1119 >= 0) {
         var1 -= var1 * this.field1126 / ((class55)super.field1141).field1020.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("bs")
   static int method1163(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1116 += var12.field1124 * (var9 - var4);
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

      var12.field1117 = var5 >> 2;
      var12.field1120 = var6 >> 2;
      var12.field1123 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   static int method1164(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1117 -= var11.field1125 * var5;
      var11.field1120 -= var11.field1121 * var5;
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

      var11.field1117 += var11.field1125 * var5;
      var11.field1120 += var11.field1121 * var5;
      var11.field1116 = var6;
      var11.field1123 = var4;
      return var5;
   }

   @ObfuscatedName("n")
   public synchronized void method1165(int var1) {
      this.field1119 = var1;
   }

   @ObfuscatedName("ay")
   public boolean method1169() {
      return this.field1123 < 0 || this.field1123 >= ((class55)super.field1141).field1020.length << 8;
   }

   @ObfuscatedName("t")
   public synchronized void method1186(int var1, int var2) {
      this.method1131(var1, var2, this.method1228());
   }

   @ObfuscatedName("bt")
   static int method1195(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1117 += var9.field1125 * (var6 - var3);
      var9.field1120 += var9.field1121 * (var6 - var3);

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

      var9.field1116 = var4 >> 2;
      var9.field1123 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aj")
   int method1196(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1122 > 0) {
            int var6 = var2 + this.field1122;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1122 += var2;
            if(this.field1113 == -256 && (this.field1123 & 255) == 0) {
               if(class57.field1052) {
                  var2 = method1163(0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, this.field1125, this.field1121, 0, var6, var3, this);
               } else {
                  var2 = method1227(((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, this.field1124, 0, var6, var3, this);
               }
            } else if(class57.field1052) {
               var2 = method1208(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, this.field1125, this.field1121, 0, var6, var3, this, this.field1113, var5);
            } else {
               var2 = method1260(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, this.field1124, 0, var6, var3, this, this.field1113, var5);
            }

            this.field1122 -= var2;
            if(this.field1122 != 0) {
               return var2;
            }

            if(!this.method1151()) {
               continue;
            }

            return var4;
         }

         if(this.field1113 == -256 && (this.field1123 & 255) == 0) {
            if(class57.field1052) {
               return method1269(0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, 0, var4, var3, this);
            }

            return method1154(((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, 0, var4, var3, this);
         }

         if(class57.field1052) {
            return method1159(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1117, this.field1120, 0, var4, var3, this, this.field1113, var5);
         }

         return method1204(0, 0, ((class55)super.field1141).field1020, var1, this.field1123, var2, this.field1116, 0, var4, var3, this, this.field1113, var5);
      }
   }

   @ObfuscatedName("ag")
   static int method1204(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1123 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   static int method1208(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1116 -= var13.field1124 * var5;
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
      var13.field1116 += var13.field1124 * var5;
      var13.field1117 = var6;
      var13.field1120 = var7;
      var13.field1123 = var4;
      return var5;
   }

   @ObfuscatedName("d")
   void method1215() {
      if(this.field1122 != 0) {
         if(this.field1114 == Integer.MIN_VALUE) {
            this.field1114 = 0;
         }

         this.field1122 = 0;
         this.method1128();
      }

   }

   @ObfuscatedName("bd")
   static int method1227(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1117 += var9.field1125 * (var6 - var3);
      var9.field1120 += var9.field1121 * (var6 - var3);

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

      var9.field1116 = var4 >> 2;
      var9.field1123 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("i")
   public synchronized int method1228() {
      return this.field1115 < 0?-1:this.field1115;
   }

   @ObfuscatedName("x")
   protected int vmethod2632() {
      return this.field1114 == 0 && this.field1122 == 0?0:1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1251(int var1) {
      this.method1132(var1, this.method1228());
   }

   @ObfuscatedName("bl")
   static int method1260(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1117 -= var11.field1125 * var5;
      var11.field1120 -= var11.field1121 * var5;
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

      var11.field1117 += var11.field1125 * var5;
      var11.field1120 += var11.field1121 * var5;
      var11.field1116 = var6;
      var11.field1123 = var4;
      return var5;
   }

   @ObfuscatedName("c")
   static int method1267(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("am")
   static int method1269(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1123 = var3 << 8;
      return var4 >> 1;
   }
}
