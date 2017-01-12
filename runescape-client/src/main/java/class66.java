import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class66 extends class68 {
   @ObfuscatedName("i")
   int field1106;
   @ObfuscatedName("x")
   int field1107;
   @ObfuscatedName("z")
   int field1108;
   @ObfuscatedName("a")
   int field1109;
   @ObfuscatedName("t")
   boolean field1110;
   @ObfuscatedName("c")
   int field1111;
   @ObfuscatedName("d")
   int field1112;
   @ObfuscatedName("l")
   int field1113;
   @ObfuscatedName("g")
   int field1114;
   @ObfuscatedName("v")
   int field1115;
   @ObfuscatedName("f")
   int field1116;
   @ObfuscatedName("m")
   int field1117;
   @ObfuscatedName("q")
   int field1118;
   @ObfuscatedName("e")
   int field1119;
   @ObfuscatedName("u")
   int field1120;

   @ObfuscatedName("x")
   static int method1127(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ar")
   int vmethod1300() {
      int var1 = this.field1116 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1113 == 0) {
         var1 -= var1 * this.field1120 / (((class55)super.field1136).field1015.length << 8);
      } else if(this.field1113 >= 0) {
         var1 -= var1 * this.field1114 / ((class55)super.field1136).field1015.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("am")
   int method1129(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1117 > 0) {
            int var6 = var2 + this.field1117;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1117 += var2;
            if(this.field1107 == 256 && (this.field1120 & 255) == 0) {
               if(class57.field1055) {
                  var2 = method1166(0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, this.field1119, this.field1115, 0, var6, var3, this);
               } else {
                  var2 = method1193(((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, this.field1118, 0, var6, var3, this);
               }
            } else if(class57.field1055) {
               var2 = method1171(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, this.field1119, this.field1115, 0, var6, var3, this, this.field1107, var5);
            } else {
               var2 = method1187(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, this.field1118, 0, var6, var3, this, this.field1107, var5);
            }

            this.field1117 -= var2;
            if(this.field1117 != 0) {
               return var2;
            }

            if(!this.method1143()) {
               continue;
            }

            return var4;
         }

         if(this.field1107 == 256 && (this.field1120 & 255) == 0) {
            if(class57.field1055) {
               return method1158(0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, 0, var4, var3, this);
            }

            return method1236(((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, 0, var4, var3, this);
         }

         if(class57.field1055) {
            return method1162(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, 0, var4, var3, this, this.field1107, var5);
         }

         return method1161(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, 0, var4, var3, this, this.field1107, var5);
      }
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1136 = var1;
      this.field1114 = var1.field1016;
      this.field1108 = var1.field1014;
      this.field1110 = var1.field1018;
      this.field1107 = var2;
      this.field1106 = var3;
      this.field1109 = var4;
      this.field1120 = 0;
      this.method1132();
   }

   @ObfuscatedName("i")
   public static class66 method1130(class55 var0, int var1, int var2) {
      return var0.field1015 != null && var0.field1015.length != 0?new class66(var0, (int)((long)var0.field1017 * 256L * (long)var1 / (long)(class7.field65 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("a")
   public static class66 method1131(class55 var0, int var1, int var2, int var3) {
      return var0.field1015 != null && var0.field1015.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("c")
   void method1132() {
      this.field1116 = this.field1106;
      this.field1111 = method1182(this.field1106, this.field1109);
      this.field1112 = method1127(this.field1106, this.field1109);
   }

   @ObfuscatedName("q")
   public synchronized void method1133(int var1) {
      this.field1113 = var1;
   }

   @ObfuscatedName("v")
   public synchronized void method1134(int var1) {
      this.method1136(var1 << 6, this.method1183());
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1135(int var1) {
      this.method1136(var1, this.method1183());
   }

   @ObfuscatedName("p")
   synchronized void method1136(int var1, int var2) {
      this.field1106 = var1;
      this.field1109 = var2;
      this.field1117 = 0;
      this.method1132();
   }

   @ObfuscatedName("k")
   public synchronized int method1137() {
      return this.field1106 == Integer.MIN_VALUE?0:this.field1106;
   }

   @ObfuscatedName("y")
   public synchronized void method1139(int var1) {
      int var2 = ((class55)super.field1136).field1015.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1120 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1140() {
      this.field1107 = (this.field1107 ^ this.field1107 >> 31) + (this.field1107 >>> 31);
      this.field1107 = -this.field1107;
   }

   @ObfuscatedName("ae")
   static int method1142(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1120 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ab")
   boolean method1143() {
      int var1 = this.field1106;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1182(var1, this.field1109);
         var3 = method1127(var1, this.field1109);
      }

      if(this.field1116 == var1 && this.field1111 == var2 && this.field1112 == var3) {
         if(this.field1106 == Integer.MIN_VALUE) {
            this.field1106 = 0;
            this.field1112 = 0;
            this.field1111 = 0;
            this.field1116 = 0;
            this.unlink();
            return true;
         } else {
            this.method1132();
            return false;
         }
      } else {
         if(this.field1116 < var1) {
            this.field1118 = 1;
            this.field1117 = var1 - this.field1116;
         } else if(this.field1116 > var1) {
            this.field1118 = -1;
            this.field1117 = this.field1116 - var1;
         } else {
            this.field1118 = 0;
         }

         if(this.field1111 < var2) {
            this.field1119 = 1;
            if(this.field1117 == 0 || this.field1117 > var2 - this.field1111) {
               this.field1117 = var2 - this.field1111;
            }
         } else if(this.field1111 > var2) {
            this.field1119 = -1;
            if(this.field1117 == 0 || this.field1117 > this.field1111 - var2) {
               this.field1117 = this.field1111 - var2;
            }
         } else {
            this.field1119 = 0;
         }

         if(this.field1112 < var3) {
            this.field1115 = 1;
            if(this.field1117 == 0 || this.field1117 > var3 - this.field1112) {
               this.field1117 = var3 - this.field1112;
            }
         } else if(this.field1112 > var3) {
            this.field1115 = -1;
            if(this.field1117 == 0 || this.field1117 > this.field1112 - var3) {
               this.field1117 = this.field1112 - var3;
            }
         } else {
            this.field1115 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("o")
   public synchronized void method1144(int var1) {
      if(var1 == 0) {
         this.method1135(0);
         this.unlink();
      } else if(this.field1111 == 0 && this.field1112 == 0) {
         this.field1117 = 0;
         this.field1106 = 0;
         this.field1116 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1116;
         if(this.field1116 > var2) {
            var2 = this.field1116;
         }

         if(-this.field1111 > var2) {
            var2 = -this.field1111;
         }

         if(this.field1111 > var2) {
            var2 = this.field1111;
         }

         if(-this.field1112 > var2) {
            var2 = -this.field1112;
         }

         if(this.field1112 > var2) {
            var2 = this.field1112;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1117 = var1;
         this.field1106 = Integer.MIN_VALUE;
         this.field1118 = -this.field1116 / var1;
         this.field1119 = -this.field1111 / var1;
         this.field1115 = -this.field1112 / var1;
      }
   }

   @ObfuscatedName("b")
   public synchronized void method1145(int var1) {
      if(this.field1107 < 0) {
         this.field1107 = -var1;
      } else {
         this.field1107 = var1;
      }

   }

   @ObfuscatedName("ad")
   public boolean method1147() {
      return this.field1120 < 0 || this.field1120 >= ((class55)super.field1136).field1015.length << 8;
   }

   @ObfuscatedName("aw")
   public boolean method1148() {
      return this.field1117 != 0;
   }

   @ObfuscatedName("g")
   protected class68 vmethod2671() {
      return null;
   }

   @ObfuscatedName("z")
   protected class68 vmethod2672() {
      return null;
   }

   @ObfuscatedName("t")
   protected int vmethod2673() {
      return this.field1106 == 0 && this.field1117 == 0?0:1;
   }

   @ObfuscatedName("m")
   public synchronized void vmethod2674(int[] var1, int var2, int var3) {
      if(this.field1106 == 0 && this.field1117 == 0) {
         this.vmethod2675(var3);
      } else {
         class55 var4 = (class55)super.field1136;
         int var5 = this.field1114 << 8;
         int var6 = this.field1108 << 8;
         int var7 = var4.field1015.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1113 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1120 < 0) {
            if(this.field1107 <= 0) {
               this.method1189();
               this.unlink();
               return;
            }

            this.field1120 = 0;
         }

         if(this.field1120 >= var7) {
            if(this.field1107 >= 0) {
               this.method1189();
               this.unlink();
               return;
            }

            this.field1120 = var7 - 1;
         }

         if(this.field1113 < 0) {
            if(this.field1110) {
               if(this.field1107 < 0) {
                  var9 = this.method1155(var1, var2, var5, var3, var4.field1015[this.field1114]);
                  if(this.field1120 >= var5) {
                     return;
                  }

                  this.field1120 = var5 + var5 - 1 - this.field1120;
                  this.field1107 = -this.field1107;
               }

               while(true) {
                  var9 = this.method1129(var1, var9, var6, var3, var4.field1015[this.field1108 - 1]);
                  if(this.field1120 < var6) {
                     return;
                  }

                  this.field1120 = var6 + var6 - 1 - this.field1120;
                  this.field1107 = -this.field1107;
                  var9 = this.method1155(var1, var9, var5, var3, var4.field1015[this.field1114]);
                  if(this.field1120 >= var5) {
                     return;
                  }

                  this.field1120 = var5 + var5 - 1 - this.field1120;
                  this.field1107 = -this.field1107;
               }
            } else if(this.field1107 < 0) {
               while(true) {
                  var9 = this.method1155(var1, var9, var5, var3, var4.field1015[this.field1108 - 1]);
                  if(this.field1120 >= var5) {
                     return;
                  }

                  this.field1120 = var6 - 1 - (var6 - 1 - this.field1120) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1129(var1, var9, var6, var3, var4.field1015[this.field1114]);
                  if(this.field1120 < var6) {
                     return;
                  }

                  this.field1120 = var5 + (this.field1120 - var5) % var8;
               }
            }
         } else {
            if(this.field1113 > 0) {
               if(this.field1110) {
                  label187: {
                     if(this.field1107 < 0) {
                        var9 = this.method1155(var1, var2, var5, var3, var4.field1015[this.field1114]);
                        if(this.field1120 >= var5) {
                           return;
                        }

                        this.field1120 = var5 + var5 - 1 - this.field1120;
                        this.field1107 = -this.field1107;
                        if(--this.field1113 == 0) {
                           break label187;
                        }
                     }

                     do {
                        var9 = this.method1129(var1, var9, var6, var3, var4.field1015[this.field1108 - 1]);
                        if(this.field1120 < var6) {
                           return;
                        }

                        this.field1120 = var6 + var6 - 1 - this.field1120;
                        this.field1107 = -this.field1107;
                        if(--this.field1113 == 0) {
                           break;
                        }

                        var9 = this.method1155(var1, var9, var5, var3, var4.field1015[this.field1114]);
                        if(this.field1120 >= var5) {
                           return;
                        }

                        this.field1120 = var5 + var5 - 1 - this.field1120;
                        this.field1107 = -this.field1107;
                     } while(--this.field1113 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1107 < 0) {
                     while(true) {
                        var9 = this.method1155(var1, var9, var5, var3, var4.field1015[this.field1108 - 1]);
                        if(this.field1120 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1120) / var8;
                        if(var10 >= this.field1113) {
                           this.field1120 += var8 * this.field1113;
                           this.field1113 = 0;
                           break;
                        }

                        this.field1120 += var8 * var10;
                        this.field1113 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1129(var1, var9, var6, var3, var4.field1015[this.field1114]);
                        if(this.field1120 < var6) {
                           return;
                        }

                        var10 = (this.field1120 - var5) / var8;
                        if(var10 >= this.field1113) {
                           this.field1120 -= var8 * this.field1113;
                           this.field1113 = 0;
                           break;
                        }

                        this.field1120 -= var8 * var10;
                        this.field1113 -= var10;
                     }
                  }
               }
            }

            if(this.field1107 < 0) {
               this.method1155(var1, var9, 0, var3, 0);
               if(this.field1120 < 0) {
                  this.field1120 = -1;
                  this.method1189();
                  this.unlink();
               }
            } else {
               this.method1129(var1, var9, var7, var3, 0);
               if(this.field1120 >= var7) {
                  this.field1120 = var7;
                  this.method1189();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   public synchronized void vmethod2675(int var1) {
      if(this.field1117 > 0) {
         if(var1 >= this.field1117) {
            if(this.field1106 == Integer.MIN_VALUE) {
               this.field1106 = 0;
               this.field1112 = 0;
               this.field1111 = 0;
               this.field1116 = 0;
               this.unlink();
               var1 = this.field1117;
            }

            this.field1117 = 0;
            this.method1132();
         } else {
            this.field1116 += this.field1118 * var1;
            this.field1111 += this.field1119 * var1;
            this.field1112 += this.field1115 * var1;
            this.field1117 -= var1;
         }
      }

      class55 var2 = (class55)super.field1136;
      int var3 = this.field1114 << 8;
      int var4 = this.field1108 << 8;
      int var5 = var2.field1015.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1113 = 0;
      }

      if(this.field1120 < 0) {
         if(this.field1107 <= 0) {
            this.method1189();
            this.unlink();
            return;
         }

         this.field1120 = 0;
      }

      if(this.field1120 >= var5) {
         if(this.field1107 >= 0) {
            this.method1189();
            this.unlink();
            return;
         }

         this.field1120 = var5 - 1;
      }

      this.field1120 += this.field1107 * var1;
      if(this.field1113 < 0) {
         if(!this.field1110) {
            if(this.field1107 < 0) {
               if(this.field1120 >= var3) {
                  return;
               }

               this.field1120 = var4 - 1 - (var4 - 1 - this.field1120) % var6;
            } else {
               if(this.field1120 < var4) {
                  return;
               }

               this.field1120 = var3 + (this.field1120 - var3) % var6;
            }

         } else {
            if(this.field1107 < 0) {
               if(this.field1120 >= var3) {
                  return;
               }

               this.field1120 = var3 + var3 - 1 - this.field1120;
               this.field1107 = -this.field1107;
            }

            while(this.field1120 >= var4) {
               this.field1120 = var4 + var4 - 1 - this.field1120;
               this.field1107 = -this.field1107;
               if(this.field1120 >= var3) {
                  return;
               }

               this.field1120 = var3 + var3 - 1 - this.field1120;
               this.field1107 = -this.field1107;
            }

         }
      } else {
         if(this.field1113 > 0) {
            if(this.field1110) {
               label171: {
                  if(this.field1107 < 0) {
                     if(this.field1120 >= var3) {
                        return;
                     }

                     this.field1120 = var3 + var3 - 1 - this.field1120;
                     this.field1107 = -this.field1107;
                     if(--this.field1113 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1120 < var4) {
                        return;
                     }

                     this.field1120 = var4 + var4 - 1 - this.field1120;
                     this.field1107 = -this.field1107;
                     if(--this.field1113 == 0) {
                        break;
                     }

                     if(this.field1120 >= var3) {
                        return;
                     }

                     this.field1120 = var3 + var3 - 1 - this.field1120;
                     this.field1107 = -this.field1107;
                  } while(--this.field1113 != 0);
               }
            } else {
               label203: {
                  int var7;
                  if(this.field1107 < 0) {
                     if(this.field1120 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1120) / var6;
                     if(var7 >= this.field1113) {
                        this.field1120 += var6 * this.field1113;
                        this.field1113 = 0;
                        break label203;
                     }

                     this.field1120 += var6 * var7;
                     this.field1113 -= var7;
                  } else {
                     if(this.field1120 < var4) {
                        return;
                     }

                     var7 = (this.field1120 - var3) / var6;
                     if(var7 >= this.field1113) {
                        this.field1120 -= var6 * this.field1113;
                        this.field1113 = 0;
                        break label203;
                     }

                     this.field1120 -= var6 * var7;
                     this.field1113 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1107 < 0) {
            if(this.field1120 < 0) {
               this.field1120 = -1;
               this.method1189();
               this.unlink();
            }
         } else if(this.field1120 >= var5) {
            this.field1120 = var5;
            this.method1189();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("ay")
   int method1155(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1117 > 0) {
            int var6 = var2 + this.field1117;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1117 += var2;
            if(this.field1107 == -256 && (this.field1120 & 255) == 0) {
               if(class57.field1055) {
                  var2 = method1168(0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, this.field1119, this.field1115, 0, var6, var3, this);
               } else {
                  var2 = method1167(((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, this.field1118, 0, var6, var3, this);
               }
            } else if(class57.field1055) {
               var2 = method1172(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, this.field1119, this.field1115, 0, var6, var3, this, this.field1107, var5);
            } else {
               var2 = method1208(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, this.field1118, 0, var6, var3, this, this.field1107, var5);
            }

            this.field1117 -= var2;
            if(this.field1117 != 0) {
               return var2;
            }

            if(!this.method1143()) {
               continue;
            }

            return var4;
         }

         if(this.field1107 == -256 && (this.field1120 & 255) == 0) {
            if(class57.field1055) {
               return method1160(0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, 0, var4, var3, this);
            }

            return method1142(((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, 0, var4, var3, this);
         }

         if(class57.field1055) {
            return method1164(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1111, this.field1112, 0, var4, var3, this, this.field1107, var5);
         }

         return method1163(0, 0, ((class55)super.field1136).field1015, var1, this.field1120, var2, this.field1116, 0, var4, var3, this, this.field1107, var5);
      }
   }

   @ObfuscatedName("ap")
   static int method1158(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1120 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ao")
   static int method1160(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1120 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   static int method1161(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method1162(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1120 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bv")
   static int method1163(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("bz")
   static int method1164(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1120 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1166(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1116 += var12.field1118 * (var9 - var4);
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

      var12.field1111 = var5 >> 2;
      var12.field1112 = var6 >> 2;
      var12.field1120 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   static int method1167(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1119 * (var6 - var3);
      var9.field1112 += var9.field1115 * (var6 - var3);

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
      var9.field1120 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bb")
   static int method1168(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1116 += var12.field1118 * (var9 - var4);
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

      var12.field1111 = var5 >> 2;
      var12.field1112 = var6 >> 2;
      var12.field1120 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   static int method1171(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1116 -= var13.field1118 * var5;
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
      var13.field1116 += var13.field1118 * var5;
      var13.field1111 = var6;
      var13.field1112 = var7;
      var13.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1172(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1116 -= var13.field1118 * var5;
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
      var13.field1116 += var13.field1118 * var5;
      var13.field1111 = var6;
      var13.field1112 = var7;
      var13.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("u")
   static int method1182(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("r")
   public synchronized int method1183() {
      return this.field1109 < 0?-1:this.field1109;
   }

   @ObfuscatedName("bu")
   static int method1187(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1119 * var5;
      var11.field1112 -= var11.field1115 * var5;
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

      var11.field1111 += var11.field1119 * var5;
      var11.field1112 += var11.field1115 * var5;
      var11.field1116 = var6;
      var11.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("s")
   void method1189() {
      if(this.field1117 != 0) {
         if(this.field1106 == Integer.MIN_VALUE) {
            this.field1106 = 0;
         }

         this.field1117 = 0;
         this.method1132();
      }

   }

   @ObfuscatedName("be")
   static int method1193(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1119 * (var6 - var3);
      var9.field1112 += var9.field1115 * (var6 - var3);

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
      var9.field1120 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("by")
   static int method1208(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1119 * var5;
      var11.field1112 -= var11.field1115 * var5;
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

      var11.field1111 += var11.field1119 * var5;
      var11.field1112 += var11.field1115 * var5;
      var11.field1116 = var6;
      var11.field1120 = var4;
      return var5;
   }

   @ObfuscatedName("n")
   public synchronized void method1221(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1136(var2, var3);
      } else {
         int var4 = method1182(var2, var3);
         int var5 = method1127(var2, var3);
         if(this.field1111 == var4 && this.field1112 == var5) {
            this.field1117 = 0;
         } else {
            int var6 = var2 - this.field1116;
            if(this.field1116 - var2 > var6) {
               var6 = this.field1116 - var2;
            }

            if(var4 - this.field1111 > var6) {
               var6 = var4 - this.field1111;
            }

            if(this.field1111 - var4 > var6) {
               var6 = this.field1111 - var4;
            }

            if(var5 - this.field1112 > var6) {
               var6 = var5 - this.field1112;
            }

            if(this.field1112 - var5 > var6) {
               var6 = this.field1112 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1117 = var1;
            this.field1106 = var2;
            this.field1109 = var3;
            this.field1118 = (var2 - this.field1116) / var1;
            this.field1119 = (var4 - this.field1111) / var1;
            this.field1115 = (var5 - this.field1112) / var1;
         }
      }
   }

   @ObfuscatedName("az")
   public synchronized int method1223() {
      return this.field1107 < 0?-this.field1107:this.field1107;
   }

   @ObfuscatedName("as")
   static int method1236(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1120 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("w")
   public synchronized void method1259(int var1, int var2) {
      this.method1221(var1, var2, this.method1183());
   }

   class66(class55 var1, int var2, int var3) {
      super.field1136 = var1;
      this.field1114 = var1.field1016;
      this.field1108 = var1.field1014;
      this.field1110 = var1.field1018;
      this.field1107 = var2;
      this.field1106 = var3;
      this.field1109 = 8192;
      this.field1120 = 0;
      this.method1132();
   }
}
