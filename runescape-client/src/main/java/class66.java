import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class66 extends class68 {
   @ObfuscatedName("l")
   boolean field1106;
   @ObfuscatedName("y")
   int field1107;
   @ObfuscatedName("n")
   int field1108;
   @ObfuscatedName("e")
   int field1109;
   @ObfuscatedName("r")
   int field1110;
   @ObfuscatedName("c")
   int field1111;
   @ObfuscatedName("p")
   int field1112;
   @ObfuscatedName("g")
   int field1113;
   @ObfuscatedName("z")
   int field1114;
   @ObfuscatedName("q")
   int field1115;
   @ObfuscatedName("d")
   int field1116;
   @ObfuscatedName("h")
   int field1117;
   @ObfuscatedName("m")
   int field1118;
   @ObfuscatedName("x")
   int field1119;
   @ObfuscatedName("f")
   int field1120;

   @ObfuscatedName("d")
   static int method1172(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ax")
   int vmethod1370() {
      int var1 = this.field1110 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1113 == 0) {
         var1 -= var1 * this.field1108 / (((class55)super.field1135).field1014.length << 8);
      } else if(this.field1113 >= 0) {
         var1 -= var1 * this.field1114 / ((class55)super.field1135).field1014.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1135 = var1;
      this.field1114 = var1.field1013;
      this.field1115 = var1.field1016;
      this.field1106 = var1.field1017;
      this.field1116 = var2;
      this.field1118 = var3;
      this.field1117 = 8192;
      this.field1108 = 0;
      this.method1176();
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1135 = var1;
      this.field1114 = var1.field1013;
      this.field1115 = var1.field1016;
      this.field1106 = var1.field1017;
      this.field1116 = var2;
      this.field1118 = var3;
      this.field1117 = var4;
      this.field1108 = 0;
      this.method1176();
   }

   @ObfuscatedName("m")
   public static class66 method1174(class55 var0, int var1, int var2) {
      return var0.field1014 != null && var0.field1014.length != 0?new class66(var0, (int)((long)var0.field1015 * 256L * (long)var1 / (long)(class57.field1031 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("w")
   void method1176() {
      this.field1110 = this.field1118;
      this.field1111 = method1245(this.field1118, this.field1117);
      this.field1112 = method1172(this.field1118, this.field1117);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1179(int var1) {
      this.method1338(var1, this.method1247());
   }

   @ObfuscatedName("i")
   public synchronized void method1183(int var1) {
      int var2 = ((class55)super.field1135).field1014.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1108 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1184() {
      this.field1116 = (this.field1116 ^ this.field1116 >> 31) + (this.field1116 >>> 31);
      this.field1116 = -this.field1116;
   }

   @ObfuscatedName("b")
   void method1185() {
      if(this.field1107 != 0) {
         if(this.field1118 == Integer.MIN_VALUE) {
            this.field1118 = 0;
         }

         this.field1107 = 0;
         this.method1176();
      }

   }

   @ObfuscatedName("aq")
   public synchronized void method1186(int var1, int var2) {
      this.method1187(var1, var2, this.method1247());
   }

   @ObfuscatedName("ac")
   public synchronized void method1187(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1338(var2, var3);
      } else {
         int var4 = method1245(var2, var3);
         int var5 = method1172(var2, var3);
         if(this.field1111 == var4 && this.field1112 == var5) {
            this.field1107 = 0;
         } else {
            int var6 = var2 - this.field1110;
            if(this.field1110 - var2 > var6) {
               var6 = this.field1110 - var2;
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

            this.field1107 = var1;
            this.field1118 = var2;
            this.field1117 = var3;
            this.field1109 = (var2 - this.field1110) / var1;
            this.field1119 = (var4 - this.field1111) / var1;
            this.field1120 = (var5 - this.field1112) / var1;
         }
      }
   }

   @ObfuscatedName("ae")
   public synchronized void method1188(int var1) {
      if(var1 == 0) {
         this.method1179(0);
         this.unlink();
      } else if(this.field1111 == 0 && this.field1112 == 0) {
         this.field1107 = 0;
         this.field1118 = 0;
         this.field1110 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1110;
         if(this.field1110 > var2) {
            var2 = this.field1110;
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

         this.field1107 = var1;
         this.field1118 = Integer.MIN_VALUE;
         this.field1109 = -this.field1110 / var1;
         this.field1119 = -this.field1111 / var1;
         this.field1120 = -this.field1112 / var1;
      }
   }

   @ObfuscatedName("ag")
   public synchronized void method1189(int var1) {
      if(this.field1116 < 0) {
         this.field1116 = -var1;
      } else {
         this.field1116 = var1;
      }

   }

   @ObfuscatedName("ap")
   public synchronized int method1190() {
      return this.field1116 < 0?-this.field1116:this.field1116;
   }

   @ObfuscatedName("l")
   public synchronized void method1192(int var1) {
      this.field1113 = var1;
   }

   @ObfuscatedName("r")
   protected class68 vmethod2748() {
      return null;
   }

   @ObfuscatedName("c")
   protected class68 vmethod2750() {
      return null;
   }

   @ObfuscatedName("q")
   public synchronized void vmethod2764(int[] var1, int var2, int var3) {
      if(this.field1118 == 0 && this.field1107 == 0) {
         this.vmethod2752(var3);
      } else {
         class55 var4 = (class55)super.field1135;
         int var5 = this.field1114 << 8;
         int var6 = this.field1115 << 8;
         int var7 = var4.field1014.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1113 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1108 < 0) {
            if(this.field1116 <= 0) {
               this.method1185();
               this.unlink();
               return;
            }

            this.field1108 = 0;
         }

         if(this.field1108 >= var7) {
            if(this.field1116 >= 0) {
               this.method1185();
               this.unlink();
               return;
            }

            this.field1108 = var7 - 1;
         }

         if(this.field1113 < 0) {
            if(this.field1106) {
               if(this.field1116 < 0) {
                  var9 = this.method1233(var1, var2, var5, var3, var4.field1014[this.field1114]);
                  if(this.field1108 >= var5) {
                     return;
                  }

                  this.field1108 = var5 + var5 - 1 - this.field1108;
                  this.field1116 = -this.field1116;
               }

               while(true) {
                  var9 = this.method1198(var1, var9, var6, var3, var4.field1014[this.field1115 - 1]);
                  if(this.field1108 < var6) {
                     return;
                  }

                  this.field1108 = var6 + var6 - 1 - this.field1108;
                  this.field1116 = -this.field1116;
                  var9 = this.method1233(var1, var9, var5, var3, var4.field1014[this.field1114]);
                  if(this.field1108 >= var5) {
                     return;
                  }

                  this.field1108 = var5 + var5 - 1 - this.field1108;
                  this.field1116 = -this.field1116;
               }
            } else if(this.field1116 < 0) {
               while(true) {
                  var9 = this.method1233(var1, var9, var5, var3, var4.field1014[this.field1115 - 1]);
                  if(this.field1108 >= var5) {
                     return;
                  }

                  this.field1108 = var6 - 1 - (var6 - 1 - this.field1108) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1198(var1, var9, var6, var3, var4.field1014[this.field1114]);
                  if(this.field1108 < var6) {
                     return;
                  }

                  this.field1108 = var5 + (this.field1108 - var5) % var8;
               }
            }
         } else {
            if(this.field1113 > 0) {
               if(this.field1106) {
                  label182: {
                     if(this.field1116 < 0) {
                        var9 = this.method1233(var1, var2, var5, var3, var4.field1014[this.field1114]);
                        if(this.field1108 >= var5) {
                           return;
                        }

                        this.field1108 = var5 + var5 - 1 - this.field1108;
                        this.field1116 = -this.field1116;
                        if(--this.field1113 == 0) {
                           break label182;
                        }
                     }

                     do {
                        var9 = this.method1198(var1, var9, var6, var3, var4.field1014[this.field1115 - 1]);
                        if(this.field1108 < var6) {
                           return;
                        }

                        this.field1108 = var6 + var6 - 1 - this.field1108;
                        this.field1116 = -this.field1116;
                        if(--this.field1113 == 0) {
                           break;
                        }

                        var9 = this.method1233(var1, var9, var5, var3, var4.field1014[this.field1114]);
                        if(this.field1108 >= var5) {
                           return;
                        }

                        this.field1108 = var5 + var5 - 1 - this.field1108;
                        this.field1116 = -this.field1116;
                     } while(--this.field1113 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1116 < 0) {
                     while(true) {
                        var9 = this.method1233(var1, var9, var5, var3, var4.field1014[this.field1115 - 1]);
                        if(this.field1108 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1108) / var8;
                        if(var10 >= this.field1113) {
                           this.field1108 += var8 * this.field1113;
                           this.field1113 = 0;
                           break;
                        }

                        this.field1108 += var8 * var10;
                        this.field1113 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1198(var1, var9, var6, var3, var4.field1014[this.field1114]);
                        if(this.field1108 < var6) {
                           return;
                        }

                        var10 = (this.field1108 - var5) / var8;
                        if(var10 >= this.field1113) {
                           this.field1108 -= var8 * this.field1113;
                           this.field1113 = 0;
                           break;
                        }

                        this.field1108 -= var8 * var10;
                        this.field1113 -= var10;
                     }
                  }
               }
            }

            if(this.field1116 < 0) {
               this.method1233(var1, var9, 0, var3, 0);
               if(this.field1108 < 0) {
                  this.field1108 = -1;
                  this.method1185();
                  this.unlink();
               }
            } else {
               this.method1198(var1, var9, var7, var3, 0);
               if(this.field1108 >= var7) {
                  this.field1108 = var7;
                  this.method1185();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   public synchronized void vmethod2752(int var1) {
      if(this.field1107 > 0) {
         if(var1 >= this.field1107) {
            if(this.field1118 == Integer.MIN_VALUE) {
               this.field1118 = 0;
               this.field1112 = 0;
               this.field1111 = 0;
               this.field1110 = 0;
               this.unlink();
               var1 = this.field1107;
            }

            this.field1107 = 0;
            this.method1176();
         } else {
            this.field1110 += this.field1109 * var1;
            this.field1111 += this.field1119 * var1;
            this.field1112 += this.field1120 * var1;
            this.field1107 -= var1;
         }
      }

      class55 var2 = (class55)super.field1135;
      int var3 = this.field1114 << 8;
      int var4 = this.field1115 << 8;
      int var5 = var2.field1014.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1113 = 0;
      }

      if(this.field1108 < 0) {
         if(this.field1116 <= 0) {
            this.method1185();
            this.unlink();
            return;
         }

         this.field1108 = 0;
      }

      if(this.field1108 >= var5) {
         if(this.field1116 >= 0) {
            this.method1185();
            this.unlink();
            return;
         }

         this.field1108 = var5 - 1;
      }

      this.field1108 += this.field1116 * var1;
      if(this.field1113 < 0) {
         if(!this.field1106) {
            if(this.field1116 < 0) {
               if(this.field1108 >= var3) {
                  return;
               }

               this.field1108 = var4 - 1 - (var4 - 1 - this.field1108) % var6;
            } else {
               if(this.field1108 < var4) {
                  return;
               }

               this.field1108 = var3 + (this.field1108 - var3) % var6;
            }

         } else {
            if(this.field1116 < 0) {
               if(this.field1108 >= var3) {
                  return;
               }

               this.field1108 = var3 + var3 - 1 - this.field1108;
               this.field1116 = -this.field1116;
            }

            while(this.field1108 >= var4) {
               this.field1108 = var4 + var4 - 1 - this.field1108;
               this.field1116 = -this.field1116;
               if(this.field1108 >= var3) {
                  return;
               }

               this.field1108 = var3 + var3 - 1 - this.field1108;
               this.field1116 = -this.field1116;
            }

         }
      } else {
         if(this.field1113 > 0) {
            if(this.field1106) {
               label169: {
                  if(this.field1116 < 0) {
                     if(this.field1108 >= var3) {
                        return;
                     }

                     this.field1108 = var3 + var3 - 1 - this.field1108;
                     this.field1116 = -this.field1116;
                     if(--this.field1113 == 0) {
                        break label169;
                     }
                  }

                  do {
                     if(this.field1108 < var4) {
                        return;
                     }

                     this.field1108 = var4 + var4 - 1 - this.field1108;
                     this.field1116 = -this.field1116;
                     if(--this.field1113 == 0) {
                        break;
                     }

                     if(this.field1108 >= var3) {
                        return;
                     }

                     this.field1108 = var3 + var3 - 1 - this.field1108;
                     this.field1116 = -this.field1116;
                  } while(--this.field1113 != 0);
               }
            } else {
               label201: {
                  int var7;
                  if(this.field1116 < 0) {
                     if(this.field1108 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1108) / var6;
                     if(var7 >= this.field1113) {
                        this.field1108 += var6 * this.field1113;
                        this.field1113 = 0;
                        break label201;
                     }

                     this.field1108 += var6 * var7;
                     this.field1113 -= var7;
                  } else {
                     if(this.field1108 < var4) {
                        return;
                     }

                     var7 = (this.field1108 - var3) / var6;
                     if(var7 >= this.field1113) {
                        this.field1108 -= var6 * this.field1113;
                        this.field1113 = 0;
                        break label201;
                     }

                     this.field1108 -= var6 * var7;
                     this.field1113 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1116 < 0) {
            if(this.field1108 < 0) {
               this.field1108 = -1;
               this.method1185();
               this.unlink();
            }
         } else if(this.field1108 >= var5) {
            this.field1108 = var5;
            this.method1185();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("ad")
   int method1198(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1107 > 0) {
            int var6 = var2 + this.field1107;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1107 += var2;
            if(this.field1116 == 256 && (this.field1108 & 255) == 0) {
               if(class57.field1046) {
                  var2 = method1200(0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, this.field1119, this.field1120, 0, var6, var3, this);
               } else {
                  var2 = method1322(((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, this.field1109, 0, var6, var3, this);
               }
            } else if(class57.field1046) {
               var2 = method1214(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, this.field1119, this.field1120, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1213(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, this.field1109, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1107 -= var2;
            if(this.field1107 != 0) {
               return var2;
            }

            if(!this.method1266()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == 256 && (this.field1108 & 255) == 0) {
            if(class57.field1046) {
               return method1202(0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, 0, var4, var3, this);
            }

            return method1201(((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, 0, var4, var3, this);
         }

         if(class57.field1046) {
            return method1344(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, 0, var4, var3, this, this.field1116, var5);
         }

         return method1205(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("bt")
   static int method1200(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1110 += var12.field1109 * (var9 - var4);
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
      var12.field1108 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aa")
   static int method1201(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1108 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   static int method1202(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1108 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("at")
   static int method1203(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1108 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   static int method1204(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1108 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ak")
   static int method1205(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1108 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   static int method1207(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1108 = var4;
      return var5;
   }

   @ObfuscatedName("ao")
   static int method1208(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1108 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bd")
   static int method1212(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1110 += var12.field1109 * (var9 - var4);
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
      var12.field1108 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   static int method1213(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1119 * var5;
      var11.field1112 -= var11.field1120 * var5;
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
      var11.field1112 += var11.field1120 * var5;
      var11.field1110 = var6;
      var11.field1108 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1214(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1110 -= var13.field1109 * var5;
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
      var13.field1110 += var13.field1109 * var5;
      var13.field1111 = var6;
      var13.field1112 = var7;
      var13.field1108 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   static int method1219(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1110 -= var13.field1109 * var5;
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
      var13.field1110 += var13.field1109 * var5;
      var13.field1111 = var6;
      var13.field1112 = var7;
      var13.field1108 = var4;
      return var5;
   }

   @ObfuscatedName("h")
   public static class66 method1220(class55 var0, int var1, int var2, int var3) {
      return var0.field1014 != null && var0.field1014.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("s")
   public synchronized int method1226() {
      return this.field1118 == Integer.MIN_VALUE?0:this.field1118;
   }

   @ObfuscatedName("ah")
   int method1233(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1107 > 0) {
            int var6 = var2 + this.field1107;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1107 += var2;
            if(this.field1116 == -256 && (this.field1108 & 255) == 0) {
               if(class57.field1046) {
                  var2 = method1212(0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, this.field1119, this.field1120, 0, var6, var3, this);
               } else {
                  var2 = method1262(((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, this.field1109, 0, var6, var3, this);
               }
            } else if(class57.field1046) {
               var2 = method1219(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, this.field1119, this.field1120, 0, var6, var3, this, this.field1116, var5);
            } else {
               var2 = method1348(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, this.field1109, 0, var6, var3, this, this.field1116, var5);
            }

            this.field1107 -= var2;
            if(this.field1107 != 0) {
               return var2;
            }

            if(!this.method1266()) {
               continue;
            }

            return var4;
         }

         if(this.field1116 == -256 && (this.field1108 & 255) == 0) {
            if(class57.field1046) {
               return method1204(0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, 0, var4, var3, this);
            }

            return method1203(((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, 0, var4, var3, this);
         }

         if(class57.field1046) {
            return method1208(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1111, this.field1112, 0, var4, var3, this, this.field1116, var5);
         }

         return method1207(0, 0, ((class55)super.field1135).field1014, var1, this.field1108, var2, this.field1110, 0, var4, var3, this, this.field1116, var5);
      }
   }

   @ObfuscatedName("az")
   public boolean method1235() {
      return this.field1108 < 0 || this.field1108 >= ((class55)super.field1135).field1014.length << 8;
   }

   @ObfuscatedName("e")
   public synchronized void method1242(int var1) {
      this.method1338(var1 << 6, this.method1247());
   }

   @ObfuscatedName("n")
   static int method1245(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ab")
   public boolean method1246() {
      return this.field1107 != 0;
   }

   @ObfuscatedName("o")
   public synchronized int method1247() {
      return this.field1117 < 0?-1:this.field1117;
   }

   @ObfuscatedName("bv")
   static int method1262(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1119 * (var6 - var3);
      var9.field1112 += var9.field1120 * (var6 - var3);

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

      var9.field1110 = var4 >> 2;
      var9.field1108 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("al")
   boolean method1266() {
      int var1 = this.field1118;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1245(var1, this.field1117);
         var3 = method1172(var1, this.field1117);
      }

      if(this.field1110 == var1 && this.field1111 == var2 && this.field1112 == var3) {
         if(this.field1118 == Integer.MIN_VALUE) {
            this.field1118 = 0;
            this.field1112 = 0;
            this.field1111 = 0;
            this.field1110 = 0;
            this.unlink();
            return true;
         } else {
            this.method1176();
            return false;
         }
      } else {
         if(this.field1110 < var1) {
            this.field1109 = 1;
            this.field1107 = var1 - this.field1110;
         } else if(this.field1110 > var1) {
            this.field1109 = -1;
            this.field1107 = this.field1110 - var1;
         } else {
            this.field1109 = 0;
         }

         if(this.field1111 < var2) {
            this.field1119 = 1;
            if(this.field1107 == 0 || this.field1107 > var2 - this.field1111) {
               this.field1107 = var2 - this.field1111;
            }
         } else if(this.field1111 > var2) {
            this.field1119 = -1;
            if(this.field1107 == 0 || this.field1107 > this.field1111 - var2) {
               this.field1107 = this.field1111 - var2;
            }
         } else {
            this.field1119 = 0;
         }

         if(this.field1112 < var3) {
            this.field1120 = 1;
            if(this.field1107 == 0 || this.field1107 > var3 - this.field1112) {
               this.field1107 = var3 - this.field1112;
            }
         } else if(this.field1112 > var3) {
            this.field1120 = -1;
            if(this.field1107 == 0 || this.field1107 > this.field1112 - var3) {
               this.field1107 = this.field1112 - var3;
            }
         } else {
            this.field1120 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("z")
   protected int vmethod2751() {
      return this.field1118 == 0 && this.field1107 == 0?0:1;
   }

   @ObfuscatedName("bn")
   static int method1322(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1119 * (var6 - var3);
      var9.field1112 += var9.field1120 * (var6 - var3);

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

      var9.field1110 = var4 >> 2;
      var9.field1108 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("f")
   synchronized void method1338(int var1, int var2) {
      this.field1118 = var1;
      this.field1117 = var2;
      this.field1107 = 0;
      this.method1176();
   }

   @ObfuscatedName("ar")
   static int method1344(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1108 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bo")
   static int method1348(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1119 * var5;
      var11.field1112 -= var11.field1120 * var5;
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
      var11.field1112 += var11.field1120 * var5;
      var11.field1110 = var6;
      var11.field1108 = var4;
      return var5;
   }
}
