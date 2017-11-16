import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class116 extends class118 {
   @ObfuscatedName("b")
   int field1614;
   @ObfuscatedName("s")
   int field1602;
   @ObfuscatedName("r")
   int field1603;
   @ObfuscatedName("g")
   int field1604;
   @ObfuscatedName("x")
   int field1605;
   @ObfuscatedName("f")
   int field1606;
   @ObfuscatedName("u")
   int field1607;
   @ObfuscatedName("t")
   int field1608;
   @ObfuscatedName("k")
   int field1601;
   @ObfuscatedName("n")
   int field1610;
   @ObfuscatedName("d")
   boolean field1611;
   @ObfuscatedName("o")
   int field1613;
   @ObfuscatedName("a")
   int field1609;
   @ObfuscatedName("q")
   int field1612;
   @ObfuscatedName("j")
   int field1615;

   @ObfuscatedSignature(
      signature = "(Ldn;III)V"
   )
   class116(class106 var1, int var2, int var3, int var4) {
      super.field1630 = var1;
      this.field1601 = var1.field1520;
      this.field1610 = var1.field1521;
      this.field1611 = var1.field1518;
      this.field1602 = var2;
      this.field1603 = var3;
      this.field1604 = var4;
      this.field1614 = 0;
      this.method2184();
   }

   @ObfuscatedSignature(
      signature = "(Ldn;II)V"
   )
   class116(class106 var1, int var2, int var3) {
      super.field1630 = var1;
      this.field1601 = var1.field1520;
      this.field1610 = var1.field1521;
      this.field1611 = var1.field1518;
      this.field1602 = var2;
      this.field1603 = var3;
      this.field1604 = 8192;
      this.field1614 = 0;
      this.method2184();
   }

   @ObfuscatedName("x")
   void method2184() {
      this.field1605 = this.field1603;
      this.field1606 = method2137(this.field1603, this.field1604);
      this.field1607 = method2128(this.field1603, this.field1604);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3931() {
      return null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3946() {
      return null;
   }

   @ObfuscatedName("t")
   protected int vmethod3925() {
      return this.field1603 == 0 && this.field1613 == 0?0:1;
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3926(int[] var1, int var2, int var3) {
      if(this.field1603 == 0 && this.field1613 == 0) {
         this.vmethod3927(var3);
      } else {
         class106 var4 = (class106)super.field1630;
         int var5 = this.field1601 << 8;
         int var6 = this.field1610 << 8;
         int var7 = var4.field1519.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1608 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1614 < 0) {
            if(this.field1602 <= 0) {
               this.method2209();
               this.unlink();
               return;
            }

            this.field1614 = 0;
         }

         if(this.field1614 >= var7) {
            if(this.field1602 >= 0) {
               this.method2209();
               this.unlink();
               return;
            }

            this.field1614 = var7 - 1;
         }

         if(this.field1608 < 0) {
            if(this.field1611) {
               if(this.field1602 < 0) {
                  var9 = this.method2156(var1, var2, var5, var3, var4.field1519[this.field1601]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var5 + var5 - 1 - this.field1614;
                  this.field1602 = -this.field1602;
               }

               while(true) {
                  var9 = this.method2155(var1, var9, var6, var3, var4.field1519[this.field1610 - 1]);
                  if(this.field1614 < var6) {
                     return;
                  }

                  this.field1614 = var6 + var6 - 1 - this.field1614;
                  this.field1602 = -this.field1602;
                  var9 = this.method2156(var1, var9, var5, var3, var4.field1519[this.field1601]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var5 + var5 - 1 - this.field1614;
                  this.field1602 = -this.field1602;
               }
            } else if(this.field1602 < 0) {
               while(true) {
                  var9 = this.method2156(var1, var9, var5, var3, var4.field1519[this.field1610 - 1]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var6 - 1 - (var6 - 1 - this.field1614) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2155(var1, var9, var6, var3, var4.field1519[this.field1601]);
                  if(this.field1614 < var6) {
                     return;
                  }

                  this.field1614 = var5 + (this.field1614 - var5) % var8;
               }
            }
         } else {
            if(this.field1608 > 0) {
               if(this.field1611) {
                  label133: {
                     if(this.field1602 < 0) {
                        var9 = this.method2156(var1, var2, var5, var3, var4.field1519[this.field1601]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        this.field1614 = var5 + var5 - 1 - this.field1614;
                        this.field1602 = -this.field1602;
                        if(--this.field1608 == 0) {
                           break label133;
                        }
                     }

                     do {
                        var9 = this.method2155(var1, var9, var6, var3, var4.field1519[this.field1610 - 1]);
                        if(this.field1614 < var6) {
                           return;
                        }

                        this.field1614 = var6 + var6 - 1 - this.field1614;
                        this.field1602 = -this.field1602;
                        if(--this.field1608 == 0) {
                           break;
                        }

                        var9 = this.method2156(var1, var9, var5, var3, var4.field1519[this.field1601]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        this.field1614 = var5 + var5 - 1 - this.field1614;
                        this.field1602 = -this.field1602;
                     } while(--this.field1608 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1602 < 0) {
                     while(true) {
                        var9 = this.method2156(var1, var9, var5, var3, var4.field1519[this.field1610 - 1]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1614) / var8;
                        if(var10 >= this.field1608) {
                           this.field1614 += var8 * this.field1608;
                           this.field1608 = 0;
                           break;
                        }

                        this.field1614 += var8 * var10;
                        this.field1608 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2155(var1, var9, var6, var3, var4.field1519[this.field1601]);
                        if(this.field1614 < var6) {
                           return;
                        }

                        var10 = (this.field1614 - var5) / var8;
                        if(var10 >= this.field1608) {
                           this.field1614 -= var8 * this.field1608;
                           this.field1608 = 0;
                           break;
                        }

                        this.field1614 -= var8 * var10;
                        this.field1608 -= var10;
                     }
                  }
               }
            }

            if(this.field1602 < 0) {
               this.method2156(var1, var9, 0, var3, 0);
               if(this.field1614 < 0) {
                  this.field1614 = -1;
                  this.method2209();
                  this.unlink();
               }
            } else {
               this.method2155(var1, var9, var7, var3, 0);
               if(this.field1614 >= var7) {
                  this.field1614 = var7;
                  this.method2209();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   public synchronized void method2191(int var1) {
      this.field1608 = var1;
   }

   @ObfuscatedName("d")
   public synchronized void vmethod3927(int var1) {
      if(this.field1613 > 0) {
         if(var1 >= this.field1613) {
            if(this.field1603 == Integer.MIN_VALUE) {
               this.field1603 = 0;
               this.field1607 = 0;
               this.field1606 = 0;
               this.field1605 = 0;
               this.unlink();
               var1 = this.field1613;
            }

            this.field1613 = 0;
            this.method2184();
         } else {
            this.field1605 += this.field1609 * var1;
            this.field1606 += this.field1612 * var1;
            this.field1607 += this.field1615 * var1;
            this.field1613 -= var1;
         }
      }

      class106 var2 = (class106)super.field1630;
      int var3 = this.field1601 << 8;
      int var4 = this.field1610 << 8;
      int var5 = var2.field1519.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1608 = 0;
      }

      if(this.field1614 < 0) {
         if(this.field1602 <= 0) {
            this.method2209();
            this.unlink();
            return;
         }

         this.field1614 = 0;
      }

      if(this.field1614 >= var5) {
         if(this.field1602 >= 0) {
            this.method2209();
            this.unlink();
            return;
         }

         this.field1614 = var5 - 1;
      }

      this.field1614 += this.field1602 * var1;
      if(this.field1608 < 0) {
         if(!this.field1611) {
            if(this.field1602 < 0) {
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var4 - 1 - (var4 - 1 - this.field1614) % var6;
            } else {
               if(this.field1614 < var4) {
                  return;
               }

               this.field1614 = var3 + (this.field1614 - var3) % var6;
            }

         } else {
            if(this.field1602 < 0) {
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var3 + var3 - 1 - this.field1614;
               this.field1602 = -this.field1602;
            }

            while(this.field1614 >= var4) {
               this.field1614 = var4 + var4 - 1 - this.field1614;
               this.field1602 = -this.field1602;
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var3 + var3 - 1 - this.field1614;
               this.field1602 = -this.field1602;
            }

         }
      } else {
         if(this.field1608 > 0) {
            if(this.field1611) {
               label135: {
                  if(this.field1602 < 0) {
                     if(this.field1614 >= var3) {
                        return;
                     }

                     this.field1614 = var3 + var3 - 1 - this.field1614;
                     this.field1602 = -this.field1602;
                     if(--this.field1608 == 0) {
                        break label135;
                     }
                  }

                  do {
                     if(this.field1614 < var4) {
                        return;
                     }

                     this.field1614 = var4 + var4 - 1 - this.field1614;
                     this.field1602 = -this.field1602;
                     if(--this.field1608 == 0) {
                        break;
                     }

                     if(this.field1614 >= var3) {
                        return;
                     }

                     this.field1614 = var3 + var3 - 1 - this.field1614;
                     this.field1602 = -this.field1602;
                  } while(--this.field1608 != 0);
               }
            } else {
               int var7;
               if(this.field1602 < 0) {
                  if(this.field1614 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1614) / var6;
                  if(var7 < this.field1608) {
                     this.field1614 += var6 * var7;
                     this.field1608 -= var7;
                     return;
                  }

                  this.field1614 += var6 * this.field1608;
                  this.field1608 = 0;
               } else {
                  if(this.field1614 < var4) {
                     return;
                  }

                  var7 = (this.field1614 - var3) / var6;
                  if(var7 < this.field1608) {
                     this.field1614 -= var6 * var7;
                     this.field1608 -= var7;
                     return;
                  }

                  this.field1614 -= var6 * this.field1608;
                  this.field1608 = 0;
               }
            }
         }

         if(this.field1602 < 0) {
            if(this.field1614 < 0) {
               this.field1614 = -1;
               this.method2209();
               this.unlink();
            }
         } else if(this.field1614 >= var5) {
            this.field1614 = var5;
            this.method2209();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("o")
   public synchronized void method2135(int var1) {
      this.method2141(var1 << 6, this.method2247());
   }

   @ObfuscatedName("a")
   synchronized void method2136(int var1) {
      this.method2141(var1, this.method2247());
   }

   @ObfuscatedName("q")
   synchronized void method2141(int var1, int var2) {
      this.field1603 = var1;
      this.field1604 = var2;
      this.field1613 = 0;
      this.method2184();
   }

   @ObfuscatedName("j")
   public synchronized int method2153() {
      return this.field1603 == Integer.MIN_VALUE?0:this.field1603;
   }

   @ObfuscatedName("c")
   public synchronized int method2247() {
      return this.field1604 < 0?-1:this.field1604;
   }

   @ObfuscatedName("i")
   public synchronized void method2140(int var1) {
      int var2 = ((class106)super.field1630).field1519.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1614 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2175() {
      this.field1602 = (this.field1602 ^ this.field1602 >> 31) + (this.field1602 >>> 31);
      this.field1602 = -this.field1602;
   }

   @ObfuscatedName("z")
   void method2209() {
      if(this.field1613 != 0) {
         if(this.field1603 == Integer.MIN_VALUE) {
            this.field1603 = 0;
         }

         this.field1613 = 0;
         this.method2184();
      }

   }

   @ObfuscatedName("e")
   public synchronized void method2264(int var1, int var2) {
      this.method2144(var1, var2, this.method2247());
   }

   @ObfuscatedName("v")
   public synchronized void method2144(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2141(var2, var3);
      } else {
         int var4 = method2137(var2, var3);
         int var5 = method2128(var2, var3);
         if(var4 == this.field1606 && var5 == this.field1607) {
            this.field1613 = 0;
         } else {
            int var6 = var2 - this.field1605;
            if(this.field1605 - var2 > var6) {
               var6 = this.field1605 - var2;
            }

            if(var4 - this.field1606 > var6) {
               var6 = var4 - this.field1606;
            }

            if(this.field1606 - var4 > var6) {
               var6 = this.field1606 - var4;
            }

            if(var5 - this.field1607 > var6) {
               var6 = var5 - this.field1607;
            }

            if(this.field1607 - var5 > var6) {
               var6 = this.field1607 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1613 = var1;
            this.field1603 = var2;
            this.field1604 = var3;
            this.field1609 = (var2 - this.field1605) / var1;
            this.field1612 = (var4 - this.field1606) / var1;
            this.field1615 = (var5 - this.field1607) / var1;
         }
      }
   }

   @ObfuscatedName("w")
   public synchronized void method2170(int var1) {
      if(var1 == 0) {
         this.method2136(0);
         this.unlink();
      } else if(this.field1606 == 0 && this.field1607 == 0) {
         this.field1613 = 0;
         this.field1603 = 0;
         this.field1605 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1605;
         if(this.field1605 > var2) {
            var2 = this.field1605;
         }

         if(-this.field1606 > var2) {
            var2 = -this.field1606;
         }

         if(this.field1606 > var2) {
            var2 = this.field1606;
         }

         if(-this.field1607 > var2) {
            var2 = -this.field1607;
         }

         if(this.field1607 > var2) {
            var2 = this.field1607;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1613 = var1;
         this.field1603 = Integer.MIN_VALUE;
         this.field1609 = -this.field1605 / var1;
         this.field1612 = -this.field1606 / var1;
         this.field1615 = -this.field1607 / var1;
      }
   }

   @ObfuscatedName("ac")
   public synchronized void method2127(int var1) {
      if(this.field1602 < 0) {
         this.field1602 = -var1;
      } else {
         this.field1602 = var1;
      }

   }

   @ObfuscatedName("as")
   public synchronized int method2147() {
      return this.field1602 < 0?-this.field1602:this.field1602;
   }

   @ObfuscatedName("aw")
   public boolean method2150() {
      return this.field1614 < 0 || this.field1614 >= ((class106)super.field1630).field1519.length << 8;
   }

   @ObfuscatedName("al")
   public boolean method2180() {
      return this.field1613 != 0;
   }

   @ObfuscatedName("aj")
   int method2155(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1613 > 0) {
            int var6 = var2 + this.field1613;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1613 += var2;
            if(this.field1602 == 256 && (this.field1614 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2167(0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, this.field1612, this.field1615, 0, var6, var3, this);
               } else {
                  var2 = method2133(((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, this.field1609, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2171(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, this.field1612, this.field1615, 0, var6, var3, this, this.field1602, var5);
            } else {
               var2 = method2251(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, this.field1609, 0, var6, var3, this, this.field1602, var5);
            }

            this.field1613 -= var2;
            if(this.field1613 != 0) {
               return var2;
            }

            if(!this.method2157()) {
               continue;
            }

            return var4;
         }

         if(this.field1602 == 256 && (this.field1614 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2130(0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, 0, var4, var3, this);
            }

            return method2158(((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2163(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, 0, var4, var3, this, this.field1602, var5);
         }

         return method2162(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, 0, var4, var3, this, this.field1602, var5);
      }
   }

   @ObfuscatedName("ap")
   int vmethod2311() {
      int var1 = this.field1605 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1608 == 0) {
         var1 -= var1 * this.field1614 / (((class106)super.field1630).field1519.length << 8);
      } else if(this.field1608 >= 0) {
         var1 -= var1 * this.field1601 / ((class106)super.field1630).field1519.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ag")
   int method2156(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1613 > 0) {
            int var6 = var2 + this.field1613;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1613 += var2;
            if(this.field1602 == -256 && (this.field1614 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2169(0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, this.field1612, this.field1615, 0, var6, var3, this);
               } else {
                  var2 = method2168(((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, this.field1609, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2273(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, this.field1612, this.field1615, 0, var6, var3, this, this.field1602, var5);
            } else {
               var2 = method2172(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, this.field1609, 0, var6, var3, this, this.field1602, var5);
            }

            this.field1613 -= var2;
            if(this.field1613 != 0) {
               return var2;
            }

            if(!this.method2157()) {
               continue;
            }

            return var4;
         }

         if(this.field1602 == -256 && (this.field1614 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2236(0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, 0, var4, var3, this);
            }

            return method2199(((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2165(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1606, this.field1607, 0, var4, var3, this, this.field1602, var5);
         }

         return method2164(0, 0, ((class106)super.field1630).field1519, var1, this.field1614, var2, this.field1605, 0, var4, var3, this, this.field1602, var5);
      }
   }

   @ObfuscatedName("af")
   boolean method2157() {
      int var1 = this.field1603;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2137(var1, this.field1604);
         var3 = method2128(var1, this.field1604);
      }

      if(var1 == this.field1605 && var2 == this.field1606 && var3 == this.field1607) {
         if(this.field1603 == Integer.MIN_VALUE) {
            this.field1603 = 0;
            this.field1607 = 0;
            this.field1606 = 0;
            this.field1605 = 0;
            this.unlink();
            return true;
         } else {
            this.method2184();
            return false;
         }
      } else {
         if(this.field1605 < var1) {
            this.field1609 = 1;
            this.field1613 = var1 - this.field1605;
         } else if(this.field1605 > var1) {
            this.field1609 = -1;
            this.field1613 = this.field1605 - var1;
         } else {
            this.field1609 = 0;
         }

         if(this.field1606 < var2) {
            this.field1612 = 1;
            if(this.field1613 == 0 || this.field1613 > var2 - this.field1606) {
               this.field1613 = var2 - this.field1606;
            }
         } else if(this.field1606 > var2) {
            this.field1612 = -1;
            if(this.field1613 == 0 || this.field1613 > this.field1606 - var2) {
               this.field1613 = this.field1606 - var2;
            }
         } else {
            this.field1612 = 0;
         }

         if(this.field1607 < var3) {
            this.field1615 = 1;
            if(this.field1613 == 0 || this.field1613 > var3 - this.field1607) {
               this.field1613 = var3 - this.field1607;
            }
         } else if(this.field1607 > var3) {
            this.field1615 = -1;
            if(this.field1613 == 0 || this.field1613 > this.field1607 - var3) {
               this.field1613 = this.field1607 - var3;
            }
         } else {
            this.field1615 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("b")
   static int method2137(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("s")
   static int method2128(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ldn;II)Ldd;"
   )
   public static class116 method2145(class106 var0, int var1, int var2) {
      return var0.field1519 != null && var0.field1519.length != 0?new class116(var0, (int)((long)var0.field1522 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldn;III)Ldd;"
   )
   public static class116 method2132(class106 var0, int var1, int var2, int var3) {
      return var0.field1519 != null && var0.field1519.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdd;)I"
   )
   static int method2158(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdd;)I"
   )
   static int method2130(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdd;)I"
   )
   static int method2199(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdd;)I"
   )
   static int method2236(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdd;II)I"
   )
   static int method2162(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdd;II)I"
   )
   static int method2163(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1614 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdd;II)I"
   )
   static int method2164(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdd;II)I"
   )
   static int method2165(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1614 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdd;)I"
   )
   static int method2133(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1606 += var9.field1612 * (var6 - var3);
      var9.field1607 += var9.field1615 * (var6 - var3);

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
      var9.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdd;)I"
   )
   static int method2167(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1605 += var12.field1609 * (var9 - var4);
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

      var12.field1606 = var5 >> 2;
      var12.field1607 = var6 >> 2;
      var12.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdd;)I"
   )
   static int method2168(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1606 += var9.field1612 * (var6 - var3);
      var9.field1607 += var9.field1615 * (var6 - var3);

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
      var9.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdd;)I"
   )
   static int method2169(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1605 += var12.field1609 * (var9 - var4);
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

      var12.field1606 = var5 >> 2;
      var12.field1607 = var6 >> 2;
      var12.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdd;II)I"
   )
   static int method2251(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1606 -= var11.field1612 * var5;
      var11.field1607 -= var11.field1615 * var5;
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

      var11.field1606 += var11.field1612 * var5;
      var11.field1607 += var11.field1615 * var5;
      var11.field1605 = var6;
      var11.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdd;II)I"
   )
   static int method2171(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1605 -= var5 * var13.field1609;
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
      var13.field1605 += var13.field1609 * var5;
      var13.field1606 = var6;
      var13.field1607 = var7;
      var13.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdd;II)I"
   )
   static int method2172(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1606 -= var11.field1612 * var5;
      var11.field1607 -= var11.field1615 * var5;
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

      var11.field1606 += var11.field1612 * var5;
      var11.field1607 += var11.field1615 * var5;
      var11.field1605 = var6;
      var11.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdd;II)I"
   )
   static int method2273(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1605 -= var5 * var13.field1609;
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
      var13.field1605 += var13.field1609 * var5;
      var13.field1606 = var6;
      var13.field1607 = var7;
      var13.field1614 = var4;
      return var5;
   }
}
