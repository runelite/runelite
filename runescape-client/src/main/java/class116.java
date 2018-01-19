import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class116 extends TaskDataNode {
   @ObfuscatedName("n")
   int field1602;
   @ObfuscatedName("v")
   int field1611;
   @ObfuscatedName("y")
   int field1603;
   @ObfuscatedName("r")
   int field1604;
   @ObfuscatedName("h")
   int field1605;
   @ObfuscatedName("d")
   int field1601;
   @ObfuscatedName("s")
   int field1612;
   @ObfuscatedName("b")
   int field1608;
   @ObfuscatedName("e")
   int field1607;
   @ObfuscatedName("f")
   int field1610;
   @ObfuscatedName("z")
   boolean field1609;
   @ObfuscatedName("u")
   int field1606;
   @ObfuscatedName("p")
   int field1613;
   @ObfuscatedName("t")
   int field1614;
   @ObfuscatedName("o")
   int field1615;

   @ObfuscatedSignature(
      signature = "(Ldp;III)V"
   )
   class116(class106 var1, int var2, int var3, int var4) {
      super.field1631 = var1;
      this.field1607 = var1.field1521;
      this.field1610 = var1.field1524;
      this.field1609 = var1.field1525;
      this.field1611 = var2;
      this.field1603 = var3;
      this.field1604 = var4;
      this.field1602 = 0;
      this.method2170();
   }

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   class116(class106 var1, int var2, int var3) {
      super.field1631 = var1;
      this.field1607 = var1.field1521;
      this.field1610 = var1.field1524;
      this.field1609 = var1.field1525;
      this.field1611 = var2;
      this.field1603 = var3;
      this.field1604 = 8192;
      this.field1602 = 0;
      this.method2170();
   }

   @ObfuscatedName("h")
   void method2170() {
      this.field1605 = this.field1603;
      this.field1601 = method2235(this.field1603, this.field1604);
      this.field1612 = method2171(this.field1603, this.field1604);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4096() {
      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4097() {
      return null;
   }

   @ObfuscatedName("b")
   protected int vmethod4109() {
      return this.field1603 == 0 && this.field1606 == 0?0:1;
   }

   @ObfuscatedName("e")
   public synchronized void vmethod4099(int[] var1, int var2, int var3) {
      if(this.field1603 == 0 && this.field1606 == 0) {
         this.vmethod4100(var3);
      } else {
         class106 var4 = (class106)super.field1631;
         int var5 = this.field1607 << 8;
         int var6 = this.field1610 << 8;
         int var7 = var4.field1522.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1608 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1602 < 0) {
            if(this.field1611 <= 0) {
               this.method2303();
               this.unlink();
               return;
            }

            this.field1602 = 0;
         }

         if(this.field1602 >= var7) {
            if(this.field1611 >= 0) {
               this.method2303();
               this.unlink();
               return;
            }

            this.field1602 = var7 - 1;
         }

         if(this.field1608 < 0) {
            if(this.field1609) {
               if(this.field1611 < 0) {
                  var9 = this.method2199(var1, var2, var5, var3, var4.field1522[this.field1607]);
                  if(this.field1602 >= var5) {
                     return;
                  }

                  this.field1602 = var5 + var5 - 1 - this.field1602;
                  this.field1611 = -this.field1611;
               }

               while(true) {
                  var9 = this.method2198(var1, var9, var6, var3, var4.field1522[this.field1610 - 1]);
                  if(this.field1602 < var6) {
                     return;
                  }

                  this.field1602 = var6 + var6 - 1 - this.field1602;
                  this.field1611 = -this.field1611;
                  var9 = this.method2199(var1, var9, var5, var3, var4.field1522[this.field1607]);
                  if(this.field1602 >= var5) {
                     return;
                  }

                  this.field1602 = var5 + var5 - 1 - this.field1602;
                  this.field1611 = -this.field1611;
               }
            } else if(this.field1611 < 0) {
               while(true) {
                  var9 = this.method2199(var1, var9, var5, var3, var4.field1522[this.field1610 - 1]);
                  if(this.field1602 >= var5) {
                     return;
                  }

                  this.field1602 = var6 - 1 - (var6 - 1 - this.field1602) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2198(var1, var9, var6, var3, var4.field1522[this.field1607]);
                  if(this.field1602 < var6) {
                     return;
                  }

                  this.field1602 = var5 + (this.field1602 - var5) % var8;
               }
            }
         } else {
            if(this.field1608 > 0) {
               if(this.field1609) {
                  label143: {
                     if(this.field1611 < 0) {
                        var9 = this.method2199(var1, var2, var5, var3, var4.field1522[this.field1607]);
                        if(this.field1602 >= var5) {
                           return;
                        }

                        this.field1602 = var5 + var5 - 1 - this.field1602;
                        this.field1611 = -this.field1611;
                        if(--this.field1608 == 0) {
                           break label143;
                        }
                     }

                     do {
                        var9 = this.method2198(var1, var9, var6, var3, var4.field1522[this.field1610 - 1]);
                        if(this.field1602 < var6) {
                           return;
                        }

                        this.field1602 = var6 + var6 - 1 - this.field1602;
                        this.field1611 = -this.field1611;
                        if(--this.field1608 == 0) {
                           break;
                        }

                        var9 = this.method2199(var1, var9, var5, var3, var4.field1522[this.field1607]);
                        if(this.field1602 >= var5) {
                           return;
                        }

                        this.field1602 = var5 + var5 - 1 - this.field1602;
                        this.field1611 = -this.field1611;
                     } while(--this.field1608 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1611 < 0) {
                     while(true) {
                        var9 = this.method2199(var1, var9, var5, var3, var4.field1522[this.field1610 - 1]);
                        if(this.field1602 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1602) / var8;
                        if(var10 >= this.field1608) {
                           this.field1602 += var8 * this.field1608;
                           this.field1608 = 0;
                           break;
                        }

                        this.field1602 += var8 * var10;
                        this.field1608 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2198(var1, var9, var6, var3, var4.field1522[this.field1607]);
                        if(this.field1602 < var6) {
                           return;
                        }

                        var10 = (this.field1602 - var5) / var8;
                        if(var10 >= this.field1608) {
                           this.field1602 -= var8 * this.field1608;
                           this.field1608 = 0;
                           break;
                        }

                        this.field1602 -= var8 * var10;
                        this.field1608 -= var10;
                     }
                  }
               }
            }

            if(this.field1611 < 0) {
               this.method2199(var1, var9, 0, var3, 0);
               if(this.field1602 < 0) {
                  this.field1602 = -1;
                  this.method2303();
                  this.unlink();
               }
            } else {
               this.method2198(var1, var9, var7, var3, 0);
               if(this.field1602 >= var7) {
                  this.field1602 = var7;
                  this.method2303();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   public synchronized void method2177(int var1) {
      this.field1608 = var1;
   }

   @ObfuscatedName("u")
   public synchronized void vmethod4100(int var1) {
      if(this.field1606 > 0) {
         if(var1 >= this.field1606) {
            if(this.field1603 == Integer.MIN_VALUE) {
               this.field1603 = 0;
               this.field1612 = 0;
               this.field1601 = 0;
               this.field1605 = 0;
               this.unlink();
               var1 = this.field1606;
            }

            this.field1606 = 0;
            this.method2170();
         } else {
            this.field1605 += this.field1613 * var1;
            this.field1601 += this.field1614 * var1;
            this.field1612 += this.field1615 * var1;
            this.field1606 -= var1;
         }
      }

      class106 var2 = (class106)super.field1631;
      int var3 = this.field1607 << 8;
      int var4 = this.field1610 << 8;
      int var5 = var2.field1522.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1608 = 0;
      }

      if(this.field1602 < 0) {
         if(this.field1611 <= 0) {
            this.method2303();
            this.unlink();
            return;
         }

         this.field1602 = 0;
      }

      if(this.field1602 >= var5) {
         if(this.field1611 >= 0) {
            this.method2303();
            this.unlink();
            return;
         }

         this.field1602 = var5 - 1;
      }

      this.field1602 += this.field1611 * var1;
      if(this.field1608 < 0) {
         if(!this.field1609) {
            if(this.field1611 < 0) {
               if(this.field1602 >= var3) {
                  return;
               }

               this.field1602 = var4 - 1 - (var4 - 1 - this.field1602) % var6;
            } else {
               if(this.field1602 < var4) {
                  return;
               }

               this.field1602 = var3 + (this.field1602 - var3) % var6;
            }

         } else {
            if(this.field1611 < 0) {
               if(this.field1602 >= var3) {
                  return;
               }

               this.field1602 = var3 + var3 - 1 - this.field1602;
               this.field1611 = -this.field1611;
            }

            while(this.field1602 >= var4) {
               this.field1602 = var4 + var4 - 1 - this.field1602;
               this.field1611 = -this.field1611;
               if(this.field1602 >= var3) {
                  return;
               }

               this.field1602 = var3 + var3 - 1 - this.field1602;
               this.field1611 = -this.field1611;
            }

         }
      } else {
         if(this.field1608 > 0) {
            if(this.field1609) {
               label137: {
                  if(this.field1611 < 0) {
                     if(this.field1602 >= var3) {
                        return;
                     }

                     this.field1602 = var3 + var3 - 1 - this.field1602;
                     this.field1611 = -this.field1611;
                     if(--this.field1608 == 0) {
                        break label137;
                     }
                  }

                  do {
                     if(this.field1602 < var4) {
                        return;
                     }

                     this.field1602 = var4 + var4 - 1 - this.field1602;
                     this.field1611 = -this.field1611;
                     if(--this.field1608 == 0) {
                        break;
                     }

                     if(this.field1602 >= var3) {
                        return;
                     }

                     this.field1602 = var3 + var3 - 1 - this.field1602;
                     this.field1611 = -this.field1611;
                  } while(--this.field1608 != 0);
               }
            } else {
               int var7;
               if(this.field1611 < 0) {
                  if(this.field1602 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1602) / var6;
                  if(var7 < this.field1608) {
                     this.field1602 += var6 * var7;
                     this.field1608 -= var7;
                     return;
                  }

                  this.field1602 += var6 * this.field1608;
                  this.field1608 = 0;
               } else {
                  if(this.field1602 < var4) {
                     return;
                  }

                  var7 = (this.field1602 - var3) / var6;
                  if(var7 < this.field1608) {
                     this.field1602 -= var6 * var7;
                     this.field1608 -= var7;
                     return;
                  }

                  this.field1602 -= var6 * this.field1608;
                  this.field1608 = 0;
               }
            }
         }

         if(this.field1611 < 0) {
            if(this.field1602 < 0) {
               this.field1602 = -1;
               this.method2303();
               this.unlink();
            }
         } else if(this.field1602 >= var5) {
            this.field1602 = var5;
            this.method2303();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("t")
   public synchronized void method2178(int var1) {
      this.method2180(var1 << 6, this.method2182());
   }

   @ObfuscatedName("o")
   synchronized void method2179(int var1) {
      this.method2180(var1, this.method2182());
   }

   @ObfuscatedName("a")
   synchronized void method2180(int var1, int var2) {
      this.field1603 = var1;
      this.field1604 = var2;
      this.field1606 = 0;
      this.method2170();
   }

   @ObfuscatedName("i")
   public synchronized int method2191() {
      return this.field1603 == Integer.MIN_VALUE?0:this.field1603;
   }

   @ObfuscatedName("m")
   public synchronized int method2182() {
      return this.field1604 < 0?-1:this.field1604;
   }

   @ObfuscatedName("x")
   public synchronized void method2248(int var1) {
      int var2 = ((class106)super.field1631).field1522.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1602 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2184() {
      this.field1611 = (this.field1611 ^ this.field1611 >> 31) + (this.field1611 >>> 31);
      this.field1611 = -this.field1611;
   }

   @ObfuscatedName("g")
   void method2303() {
      if(this.field1606 != 0) {
         if(this.field1603 == Integer.MIN_VALUE) {
            this.field1603 = 0;
         }

         this.field1606 = 0;
         this.method2170();
      }

   }

   @ObfuscatedName("c")
   public synchronized void method2186(int var1, int var2) {
      this.method2272(var1, var2, this.method2182());
   }

   @ObfuscatedName("k")
   public synchronized void method2272(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2180(var2, var3);
      } else {
         int var4 = method2235(var2, var3);
         int var5 = method2171(var2, var3);
         if(var4 == this.field1601 && var5 == this.field1612) {
            this.field1606 = 0;
         } else {
            int var6 = var2 - this.field1605;
            if(this.field1605 - var2 > var6) {
               var6 = this.field1605 - var2;
            }

            if(var4 - this.field1601 > var6) {
               var6 = var4 - this.field1601;
            }

            if(this.field1601 - var4 > var6) {
               var6 = this.field1601 - var4;
            }

            if(var5 - this.field1612 > var6) {
               var6 = var5 - this.field1612;
            }

            if(this.field1612 - var5 > var6) {
               var6 = this.field1612 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1606 = var1;
            this.field1603 = var2;
            this.field1604 = var3;
            this.field1613 = (var2 - this.field1605) / var1;
            this.field1614 = (var4 - this.field1601) / var1;
            this.field1615 = (var5 - this.field1612) / var1;
         }
      }
   }

   @ObfuscatedName("q")
   public synchronized void method2188(int var1) {
      if(var1 == 0) {
         this.method2179(0);
         this.unlink();
      } else if(this.field1601 == 0 && this.field1612 == 0) {
         this.field1606 = 0;
         this.field1603 = 0;
         this.field1605 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1605;
         if(this.field1605 > var2) {
            var2 = this.field1605;
         }

         if(-this.field1601 > var2) {
            var2 = -this.field1601;
         }

         if(this.field1601 > var2) {
            var2 = this.field1601;
         }

         if(-this.field1612 > var2) {
            var2 = -this.field1612;
         }

         if(this.field1612 > var2) {
            var2 = this.field1612;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1606 = var1;
         this.field1603 = Integer.MIN_VALUE;
         this.field1613 = -this.field1605 / var1;
         this.field1614 = -this.field1601 / var1;
         this.field1615 = -this.field1612 / var1;
      }
   }

   @ObfuscatedName("ac")
   public synchronized void method2201(int var1) {
      if(this.field1611 < 0) {
         this.field1611 = -var1;
      } else {
         this.field1611 = var1;
      }

   }

   @ObfuscatedName("aw")
   public synchronized int method2195() {
      return this.field1611 < 0?-this.field1611:this.field1611;
   }

   @ObfuscatedName("at")
   public boolean method2172() {
      return this.field1602 < 0 || this.field1602 >= ((class106)super.field1631).field1522.length << 8;
   }

   @ObfuscatedName("ag")
   public boolean method2189() {
      return this.field1606 != 0;
   }

   @ObfuscatedName("ad")
   int method2198(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1606 > 0) {
            int var6 = var2 + this.field1606;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1606 += var2;
            if(this.field1611 == 256 && (this.field1602 & 255) == 0) {
               if(class2.highMemory) {
                  var2 = method2284(0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, this.field1614, this.field1615, 0, var6, var3, this);
               } else {
                  var2 = method2209(((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, this.field1613, 0, var6, var3, this);
               }
            } else if(class2.highMemory) {
               var2 = method2214(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, this.field1614, this.field1615, 0, var6, var3, this, this.field1611, var5);
            } else {
               var2 = method2176(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, this.field1613, 0, var6, var3, this, this.field1611, var5);
            }

            this.field1606 -= var2;
            if(this.field1606 != 0) {
               return var2;
            }

            if(!this.method2200()) {
               continue;
            }

            return var4;
         }

         if(this.field1611 == 256 && (this.field1602 & 255) == 0) {
            if(class2.highMemory) {
               return method2285(0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, 0, var4, var3, this);
            }

            return method2332(((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, 0, var4, var3, this);
         }

         if(class2.highMemory) {
            return method2206(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, 0, var4, var3, this, this.field1611, var5);
         }

         return method2205(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, 0, var4, var3, this, this.field1611, var5);
      }
   }

   @ObfuscatedName("ak")
   int method2199(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1606 > 0) {
            int var6 = var2 + this.field1606;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1606 += var2;
            if(this.field1611 == -256 && (this.field1602 & 255) == 0) {
               if(class2.highMemory) {
                  var2 = method2212(0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, this.field1614, this.field1615, 0, var6, var3, this);
               } else {
                  var2 = method2211(((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, this.field1613, 0, var6, var3, this);
               }
            } else if(class2.highMemory) {
               var2 = method2216(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, this.field1614, this.field1615, 0, var6, var3, this, this.field1611, var5);
            } else {
               var2 = method2215(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, this.field1613, 0, var6, var3, this, this.field1611, var5);
            }

            this.field1606 -= var2;
            if(this.field1606 != 0) {
               return var2;
            }

            if(!this.method2200()) {
               continue;
            }

            return var4;
         }

         if(this.field1611 == -256 && (this.field1602 & 255) == 0) {
            if(class2.highMemory) {
               return method2193(0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, 0, var4, var3, this);
            }

            return method2203(((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, 0, var4, var3, this);
         }

         if(class2.highMemory) {
            return method2208(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1601, this.field1612, 0, var4, var3, this, this.field1611, var5);
         }

         return method2207(0, 0, ((class106)super.field1631).field1522, var1, this.field1602, var2, this.field1605, 0, var4, var3, this, this.field1611, var5);
      }
   }

   @ObfuscatedName("as")
   boolean method2200() {
      int var1 = this.field1603;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2235(var1, this.field1604);
         var3 = method2171(var1, this.field1604);
      }

      if(var1 == this.field1605 && var2 == this.field1601 && var3 == this.field1612) {
         if(this.field1603 == Integer.MIN_VALUE) {
            this.field1603 = 0;
            this.field1612 = 0;
            this.field1601 = 0;
            this.field1605 = 0;
            this.unlink();
            return true;
         } else {
            this.method2170();
            return false;
         }
      } else {
         if(this.field1605 < var1) {
            this.field1613 = 1;
            this.field1606 = var1 - this.field1605;
         } else if(this.field1605 > var1) {
            this.field1613 = -1;
            this.field1606 = this.field1605 - var1;
         } else {
            this.field1613 = 0;
         }

         if(this.field1601 < var2) {
            this.field1614 = 1;
            if(this.field1606 == 0 || this.field1606 > var2 - this.field1601) {
               this.field1606 = var2 - this.field1601;
            }
         } else if(this.field1601 > var2) {
            this.field1614 = -1;
            if(this.field1606 == 0 || this.field1606 > this.field1601 - var2) {
               this.field1606 = this.field1601 - var2;
            }
         } else {
            this.field1614 = 0;
         }

         if(this.field1612 < var3) {
            this.field1615 = 1;
            if(this.field1606 == 0 || this.field1606 > var3 - this.field1612) {
               this.field1606 = var3 - this.field1612;
            }
         } else if(this.field1612 > var3) {
            this.field1615 = -1;
            if(this.field1606 == 0 || this.field1606 > this.field1612 - var3) {
               this.field1606 = this.field1612 - var3;
            }
         } else {
            this.field1615 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("bq")
   int vmethod2352() {
      int var1 = this.field1605 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1608 == 0) {
         var1 -= var1 * this.field1602 / (((class106)super.field1631).field1522.length << 8);
      } else if(this.field1608 >= 0) {
         var1 -= var1 * this.field1607 / ((class106)super.field1631).field1522.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("n")
   static int method2235(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("v")
   static int method2171(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ldp;II)Ldt;"
   )
   public static class116 method2286(class106 var0, int var1, int var2) {
      return var0.field1522 != null && var0.field1522.length != 0?new class116(var0, (int)((long)var0.field1523 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ldp;III)Ldt;"
   )
   public static class116 method2301(class106 var0, int var1, int var2, int var3) {
      return var0.field1522 != null && var0.field1522.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdt;)I"
   )
   static int method2332(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1602 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdt;)I"
   )
   static int method2285(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1602 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdt;)I"
   )
   static int method2203(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1602 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdt;)I"
   )
   static int method2193(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var3 + var4 - (var9 - 1)) > var8) {
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

      var10.field1602 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdt;II)I"
   )
   static int method2205(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
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

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1602 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2206(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
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

      var11.field1602 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdt;II)I"
   )
   static int method2207(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
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

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1602 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2208(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
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
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1602 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdt;)I"
   )
   static int method2209(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1601 += var9.field1614 * (var6 - var3);
      var9.field1612 += var9.field1615 * (var6 - var3);

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

      var9.field1605 = var4 >> 2;
      var9.field1602 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdt;)I"
   )
   static int method2284(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1605 += var12.field1613 * (var9 - var4);
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

      var12.field1601 = var5 >> 2;
      var12.field1612 = var6 >> 2;
      var12.field1602 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdt;)I"
   )
   static int method2211(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1601 += var9.field1614 * (var6 - var3);
      var9.field1612 += var9.field1615 * (var6 - var3);

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

      var9.field1605 = var4 >> 2;
      var9.field1602 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdt;)I"
   )
   static int method2212(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1605 += var12.field1613 * (var9 - var4);
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

      var12.field1601 = var5 >> 2;
      var12.field1612 = var6 >> 2;
      var12.field1602 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2176(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1601 -= var11.field1614 * var5;
      var11.field1612 -= var11.field1615 * var5;
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

      var11.field1601 += var11.field1614 * var5;
      var11.field1612 += var11.field1615 * var5;
      var11.field1605 = var6;
      var11.field1602 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdt;II)I"
   )
   static int method2214(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1605 -= var5 * var13.field1613;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
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
      var13.field1605 += var13.field1613 * var5;
      var13.field1601 = var6;
      var13.field1612 = var7;
      var13.field1602 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2215(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1601 -= var11.field1614 * var5;
      var11.field1612 -= var11.field1615 * var5;
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

      var11.field1601 += var11.field1614 * var5;
      var11.field1612 += var11.field1615 * var5;
      var11.field1605 = var6;
      var11.field1602 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdt;II)I"
   )
   static int method2216(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1605 -= var5 * var13.field1613;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
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
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1605 += var13.field1613 * var5;
      var13.field1601 = var6;
      var13.field1612 = var7;
      var13.field1602 = var4;
      return var5;
   }
}
