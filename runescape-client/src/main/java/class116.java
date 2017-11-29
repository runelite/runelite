import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class116 extends TaskDataNode {
   @ObfuscatedName("d")
   int field1613;
   @ObfuscatedName("x")
   int field1606;
   @ObfuscatedName("k")
   int field1607;
   @ObfuscatedName("z")
   int field1608;
   @ObfuscatedName("v")
   int field1618;
   @ObfuscatedName("m")
   int field1615;
   @ObfuscatedName("b")
   int field1611;
   @ObfuscatedName("t")
   int field1612;
   @ObfuscatedName("p")
   int field1610;
   @ObfuscatedName("r")
   int field1614;
   @ObfuscatedName("l")
   boolean field1619;
   @ObfuscatedName("u")
   int field1616;
   @ObfuscatedName("n")
   int field1617;
   @ObfuscatedName("c")
   int field1609;
   @ObfuscatedName("y")
   int field1605;

   @ObfuscatedSignature(
      signature = "(Lda;III)V"
   )
   class116(class106 var1, int var2, int var3, int var4) {
      super.field1634 = var1;
      this.field1610 = var1.field1529;
      this.field1614 = var1.field1528;
      this.field1619 = var1.field1530;
      this.field1606 = var2;
      this.field1607 = var3;
      this.field1608 = var4;
      this.field1613 = 0;
      this.method2327();
   }

   @ObfuscatedSignature(
      signature = "(Lda;II)V"
   )
   class116(class106 var1, int var2, int var3) {
      super.field1634 = var1;
      this.field1610 = var1.field1529;
      this.field1614 = var1.field1528;
      this.field1619 = var1.field1530;
      this.field1606 = var2;
      this.field1607 = var3;
      this.field1608 = 8192;
      this.field1613 = 0;
      this.method2327();
   }

   @ObfuscatedName("v")
   void method2327() {
      this.field1618 = this.field1607;
      this.field1615 = method2243(this.field1607, this.field1608);
      this.field1611 = method2260(this.field1607, this.field1608);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4054() {
      return null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4055() {
      return null;
   }

   @ObfuscatedName("t")
   protected int vmethod4056() {
      return this.field1607 == 0 && this.field1616 == 0?0:1;
   }

   @ObfuscatedName("p")
   public synchronized void vmethod4057(int[] var1, int var2, int var3) {
      if(this.field1607 == 0 && this.field1616 == 0) {
         this.vmethod4058(var3);
      } else {
         class106 var4 = (class106)super.field1634;
         int var5 = this.field1610 << 8;
         int var6 = this.field1614 << 8;
         int var7 = var4.field1527.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1612 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1613 < 0) {
            if(this.field1606 <= 0) {
               this.method2238();
               this.unlink();
               return;
            }

            this.field1613 = 0;
         }

         if(this.field1613 >= var7) {
            if(this.field1606 >= 0) {
               this.method2238();
               this.unlink();
               return;
            }

            this.field1613 = var7 - 1;
         }

         if(this.field1612 < 0) {
            if(this.field1619) {
               if(this.field1606 < 0) {
                  var9 = this.method2252(var1, var2, var5, var3, var4.field1527[this.field1610]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var5 + var5 - 1 - this.field1613;
                  this.field1606 = -this.field1606;
               }

               while(true) {
                  var9 = this.method2251(var1, var9, var6, var3, var4.field1527[this.field1614 - 1]);
                  if(this.field1613 < var6) {
                     return;
                  }

                  this.field1613 = var6 + var6 - 1 - this.field1613;
                  this.field1606 = -this.field1606;
                  var9 = this.method2252(var1, var9, var5, var3, var4.field1527[this.field1610]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var5 + var5 - 1 - this.field1613;
                  this.field1606 = -this.field1606;
               }
            } else if(this.field1606 < 0) {
               while(true) {
                  var9 = this.method2252(var1, var9, var5, var3, var4.field1527[this.field1614 - 1]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var6 - 1 - (var6 - 1 - this.field1613) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2251(var1, var9, var6, var3, var4.field1527[this.field1610]);
                  if(this.field1613 < var6) {
                     return;
                  }

                  this.field1613 = var5 + (this.field1613 - var5) % var8;
               }
            }
         } else {
            if(this.field1612 > 0) {
               if(this.field1619) {
                  label133: {
                     if(this.field1606 < 0) {
                        var9 = this.method2252(var1, var2, var5, var3, var4.field1527[this.field1610]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        this.field1613 = var5 + var5 - 1 - this.field1613;
                        this.field1606 = -this.field1606;
                        if(--this.field1612 == 0) {
                           break label133;
                        }
                     }

                     do {
                        var9 = this.method2251(var1, var9, var6, var3, var4.field1527[this.field1614 - 1]);
                        if(this.field1613 < var6) {
                           return;
                        }

                        this.field1613 = var6 + var6 - 1 - this.field1613;
                        this.field1606 = -this.field1606;
                        if(--this.field1612 == 0) {
                           break;
                        }

                        var9 = this.method2252(var1, var9, var5, var3, var4.field1527[this.field1610]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        this.field1613 = var5 + var5 - 1 - this.field1613;
                        this.field1606 = -this.field1606;
                     } while(--this.field1612 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1606 < 0) {
                     while(true) {
                        var9 = this.method2252(var1, var9, var5, var3, var4.field1527[this.field1614 - 1]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1613) / var8;
                        if(var10 >= this.field1612) {
                           this.field1613 += var8 * this.field1612;
                           this.field1612 = 0;
                           break;
                        }

                        this.field1613 += var8 * var10;
                        this.field1612 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2251(var1, var9, var6, var3, var4.field1527[this.field1610]);
                        if(this.field1613 < var6) {
                           return;
                        }

                        var10 = (this.field1613 - var5) / var8;
                        if(var10 >= this.field1612) {
                           this.field1613 -= var8 * this.field1612;
                           this.field1612 = 0;
                           break;
                        }

                        this.field1613 -= var8 * var10;
                        this.field1612 -= var10;
                     }
                  }
               }
            }

            if(this.field1606 < 0) {
               this.method2252(var1, var9, 0, var3, 0);
               if(this.field1613 < 0) {
                  this.field1613 = -1;
                  this.method2238();
                  this.unlink();
               }
            } else {
               this.method2251(var1, var9, var7, var3, 0);
               if(this.field1613 >= var7) {
                  this.field1613 = var7;
                  this.method2238();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void method2230(int var1) {
      this.field1612 = var1;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod4058(int var1) {
      if(this.field1616 > 0) {
         if(var1 >= this.field1616) {
            if(this.field1607 == Integer.MIN_VALUE) {
               this.field1607 = 0;
               this.field1611 = 0;
               this.field1615 = 0;
               this.field1618 = 0;
               this.unlink();
               var1 = this.field1616;
            }

            this.field1616 = 0;
            this.method2327();
         } else {
            this.field1618 += this.field1617 * var1;
            this.field1615 += this.field1609 * var1;
            this.field1611 += this.field1605 * var1;
            this.field1616 -= var1;
         }
      }

      class106 var2 = (class106)super.field1634;
      int var3 = this.field1610 << 8;
      int var4 = this.field1614 << 8;
      int var5 = var2.field1527.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1612 = 0;
      }

      if(this.field1613 < 0) {
         if(this.field1606 <= 0) {
            this.method2238();
            this.unlink();
            return;
         }

         this.field1613 = 0;
      }

      if(this.field1613 >= var5) {
         if(this.field1606 >= 0) {
            this.method2238();
            this.unlink();
            return;
         }

         this.field1613 = var5 - 1;
      }

      this.field1613 += this.field1606 * var1;
      if(this.field1612 < 0) {
         if(!this.field1619) {
            if(this.field1606 < 0) {
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var4 - 1 - (var4 - 1 - this.field1613) % var6;
            } else {
               if(this.field1613 < var4) {
                  return;
               }

               this.field1613 = var3 + (this.field1613 - var3) % var6;
            }

         } else {
            if(this.field1606 < 0) {
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var3 + var3 - 1 - this.field1613;
               this.field1606 = -this.field1606;
            }

            while(this.field1613 >= var4) {
               this.field1613 = var4 + var4 - 1 - this.field1613;
               this.field1606 = -this.field1606;
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var3 + var3 - 1 - this.field1613;
               this.field1606 = -this.field1606;
            }

         }
      } else {
         if(this.field1612 > 0) {
            if(this.field1619) {
               label128: {
                  if(this.field1606 < 0) {
                     if(this.field1613 >= var3) {
                        return;
                     }

                     this.field1613 = var3 + var3 - 1 - this.field1613;
                     this.field1606 = -this.field1606;
                     if(--this.field1612 == 0) {
                        break label128;
                     }
                  }

                  do {
                     if(this.field1613 < var4) {
                        return;
                     }

                     this.field1613 = var4 + var4 - 1 - this.field1613;
                     this.field1606 = -this.field1606;
                     if(--this.field1612 == 0) {
                        break;
                     }

                     if(this.field1613 >= var3) {
                        return;
                     }

                     this.field1613 = var3 + var3 - 1 - this.field1613;
                     this.field1606 = -this.field1606;
                  } while(--this.field1612 != 0);
               }
            } else {
               int var7;
               if(this.field1606 < 0) {
                  if(this.field1613 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1613) / var6;
                  if(var7 < this.field1612) {
                     this.field1613 += var6 * var7;
                     this.field1612 -= var7;
                     return;
                  }

                  this.field1613 += var6 * this.field1612;
                  this.field1612 = 0;
               } else {
                  if(this.field1613 < var4) {
                     return;
                  }

                  var7 = (this.field1613 - var3) / var6;
                  if(var7 < this.field1612) {
                     this.field1613 -= var6 * var7;
                     this.field1612 -= var7;
                     return;
                  }

                  this.field1613 -= var6 * this.field1612;
                  this.field1612 = 0;
               }
            }
         }

         if(this.field1606 < 0) {
            if(this.field1613 < 0) {
               this.field1613 = -1;
               this.method2238();
               this.unlink();
            }
         } else if(this.field1613 >= var5) {
            this.field1613 = var5;
            this.method2238();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("u")
   public synchronized void method2231(int var1) {
      this.method2233(var1 << 6, this.method2235());
   }

   @ObfuscatedName("c")
   synchronized void method2232(int var1) {
      this.method2233(var1, this.method2235());
   }

   @ObfuscatedName("j")
   synchronized void method2233(int var1, int var2) {
      this.field1607 = var1;
      this.field1608 = var2;
      this.field1616 = 0;
      this.method2327();
   }

   @ObfuscatedName("f")
   public synchronized int method2234() {
      return this.field1607 == Integer.MIN_VALUE?0:this.field1607;
   }

   @ObfuscatedName("s")
   public synchronized int method2235() {
      return this.field1608 < 0?-1:this.field1608;
   }

   @ObfuscatedName("e")
   public synchronized void method2236(int var1) {
      int var2 = ((class106)super.field1634).field1527.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1613 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2237() {
      this.field1606 = (this.field1606 ^ this.field1606 >> 31) + (this.field1606 >>> 31);
      this.field1606 = -this.field1606;
   }

   @ObfuscatedName("h")
   void method2238() {
      if(this.field1616 != 0) {
         if(this.field1607 == Integer.MIN_VALUE) {
            this.field1607 = 0;
         }

         this.field1616 = 0;
         this.method2327();
      }

   }

   @ObfuscatedName("i")
   public synchronized void method2239(int var1, int var2) {
      this.method2314(var1, var2, this.method2235());
   }

   @ObfuscatedName("o")
   public synchronized void method2314(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2233(var2, var3);
      } else {
         int var4 = method2243(var2, var3);
         int var5 = method2260(var2, var3);
         if(var4 == this.field1615 && var5 == this.field1611) {
            this.field1616 = 0;
         } else {
            int var6 = var2 - this.field1618;
            if(this.field1618 - var2 > var6) {
               var6 = this.field1618 - var2;
            }

            if(var4 - this.field1615 > var6) {
               var6 = var4 - this.field1615;
            }

            if(this.field1615 - var4 > var6) {
               var6 = this.field1615 - var4;
            }

            if(var5 - this.field1611 > var6) {
               var6 = var5 - this.field1611;
            }

            if(this.field1611 - var5 > var6) {
               var6 = this.field1611 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1616 = var1;
            this.field1607 = var2;
            this.field1608 = var3;
            this.field1617 = (var2 - this.field1618) / var1;
            this.field1609 = (var4 - this.field1615) / var1;
            this.field1605 = (var5 - this.field1611) / var1;
         }
      }
   }

   @ObfuscatedName("w")
   public synchronized void method2229(int var1) {
      if(var1 == 0) {
         this.method2232(0);
         this.unlink();
      } else if(this.field1615 == 0 && this.field1611 == 0) {
         this.field1616 = 0;
         this.field1607 = 0;
         this.field1618 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1618;
         if(this.field1618 > var2) {
            var2 = this.field1618;
         }

         if(-this.field1615 > var2) {
            var2 = -this.field1615;
         }

         if(this.field1615 > var2) {
            var2 = this.field1615;
         }

         if(-this.field1611 > var2) {
            var2 = -this.field1611;
         }

         if(this.field1611 > var2) {
            var2 = this.field1611;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1616 = var1;
         this.field1607 = Integer.MIN_VALUE;
         this.field1617 = -this.field1618 / var1;
         this.field1609 = -this.field1615 / var1;
         this.field1605 = -this.field1611 / var1;
      }
   }

   @ObfuscatedName("ah")
   public synchronized void method2242(int var1) {
      if(this.field1606 < 0) {
         this.field1606 = -var1;
      } else {
         this.field1606 = var1;
      }

   }

   @ObfuscatedName("an")
   public synchronized int method2284() {
      return this.field1606 < 0?-this.field1606:this.field1606;
   }

   @ObfuscatedName("ai")
   public boolean method2244() {
      return this.field1613 < 0 || this.field1613 >= ((class106)super.field1634).field1527.length << 8;
   }

   @ObfuscatedName("ar")
   public boolean method2300() {
      return this.field1616 != 0;
   }

   @ObfuscatedName("ac")
   int method2251(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1616 > 0) {
            int var6 = var2 + this.field1616;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1616 += var2;
            if(this.field1606 == 256 && (this.field1613 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2344(0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, this.field1609, this.field1605, 0, var6, var3, this);
               } else {
                  var2 = method2262(((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, this.field1617, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2274(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, this.field1609, this.field1605, 0, var6, var3, this, this.field1606, var5);
            } else {
               var2 = method2266(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, this.field1617, 0, var6, var3, this, this.field1606, var5);
            }

            this.field1616 -= var2;
            if(this.field1616 != 0) {
               return var2;
            }

            if(!this.method2322()) {
               continue;
            }

            return var4;
         }

         if(this.field1606 == 256 && (this.field1613 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2255(0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, 0, var4, var3, this);
            }

            return method2254(((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2263(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, 0, var4, var3, this, this.field1606, var5);
         }

         return method2258(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, 0, var4, var3, this, this.field1606, var5);
      }
   }

   @ObfuscatedName("af")
   int method2252(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1616 > 0) {
            int var6 = var2 + this.field1616;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1616 += var2;
            if(this.field1606 == -256 && (this.field1613 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2265(0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, this.field1609, this.field1605, 0, var6, var3, this);
               } else {
                  var2 = method2317(((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, this.field1617, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2253(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, this.field1609, this.field1605, 0, var6, var3, this, this.field1606, var5);
            } else {
               var2 = method2268(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, this.field1617, 0, var6, var3, this, this.field1606, var5);
            }

            this.field1616 -= var2;
            if(this.field1616 != 0) {
               return var2;
            }

            if(!this.method2322()) {
               continue;
            }

            return var4;
         }

         if(this.field1606 == -256 && (this.field1613 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2223(0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, 0, var4, var3, this);
            }

            return method2256(((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2312(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1615, this.field1611, 0, var4, var3, this, this.field1606, var5);
         }

         return method2333(0, 0, ((class106)super.field1634).field1527, var1, this.field1613, var2, this.field1618, 0, var4, var3, this, this.field1606, var5);
      }
   }

   @ObfuscatedName("ao")
   boolean method2322() {
      int var1 = this.field1607;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2243(var1, this.field1608);
         var3 = method2260(var1, this.field1608);
      }

      if(var1 == this.field1618 && var2 == this.field1615 && var3 == this.field1611) {
         if(this.field1607 == Integer.MIN_VALUE) {
            this.field1607 = 0;
            this.field1611 = 0;
            this.field1615 = 0;
            this.field1618 = 0;
            this.unlink();
            return true;
         } else {
            this.method2327();
            return false;
         }
      } else {
         if(this.field1618 < var1) {
            this.field1617 = 1;
            this.field1616 = var1 - this.field1618;
         } else if(this.field1618 > var1) {
            this.field1617 = -1;
            this.field1616 = this.field1618 - var1;
         } else {
            this.field1617 = 0;
         }

         if(this.field1615 < var2) {
            this.field1609 = 1;
            if(this.field1616 == 0 || this.field1616 > var2 - this.field1615) {
               this.field1616 = var2 - this.field1615;
            }
         } else if(this.field1615 > var2) {
            this.field1609 = -1;
            if(this.field1616 == 0 || this.field1616 > this.field1615 - var2) {
               this.field1616 = this.field1615 - var2;
            }
         } else {
            this.field1609 = 0;
         }

         if(this.field1611 < var3) {
            this.field1605 = 1;
            if(this.field1616 == 0 || this.field1616 > var3 - this.field1611) {
               this.field1616 = var3 - this.field1611;
            }
         } else if(this.field1611 > var3) {
            this.field1605 = -1;
            if(this.field1616 == 0 || this.field1616 > this.field1611 - var3) {
               this.field1616 = this.field1611 - var3;
            }
         } else {
            this.field1605 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("av")
   int vmethod2413() {
      int var1 = this.field1618 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1612 == 0) {
         var1 -= var1 * this.field1613 / (((class106)super.field1634).field1527.length << 8);
      } else if(this.field1612 >= 0) {
         var1 -= var1 * this.field1610 / ((class106)super.field1634).field1527.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("d")
   static int method2243(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("x")
   static int method2260(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lda;II)Ldv;"
   )
   public static class116 method2227(class106 var0, int var1, int var2) {
      return var0.field1527 != null && var0.field1527.length != 0?new class116(var0, (int)((long)var0.field1531 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lda;III)Ldv;"
   )
   public static class116 method2228(class106 var0, int var1, int var2, int var3) {
      return var0.field1527 != null && var0.field1527.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdv;)I"
   )
   static int method2254(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdv;)I"
   )
   static int method2255(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdv;)I"
   )
   static int method2256(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdv;)I"
   )
   static int method2223(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdv;II)I"
   )
   static int method2258(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdv;II)I"
   )
   static int method2263(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1613 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdv;II)I"
   )
   static int method2333(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdv;II)I"
   )
   static int method2312(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1613 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdv;)I"
   )
   static int method2262(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1615 += var9.field1609 * (var6 - var3);
      var9.field1611 += var9.field1605 * (var6 - var3);

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

      var9.field1618 = var4 >> 2;
      var9.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdv;)I"
   )
   static int method2344(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1618 += var12.field1617 * (var9 - var4);
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

      var12.field1615 = var5 >> 2;
      var12.field1611 = var6 >> 2;
      var12.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdv;)I"
   )
   static int method2317(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1615 += var9.field1609 * (var6 - var3);
      var9.field1611 += var9.field1605 * (var6 - var3);

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

      var9.field1618 = var4 >> 2;
      var9.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdv;)I"
   )
   static int method2265(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1618 += var12.field1617 * (var9 - var4);
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

      var12.field1615 = var5 >> 2;
      var12.field1611 = var6 >> 2;
      var12.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdv;II)I"
   )
   static int method2266(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1615 -= var11.field1609 * var5;
      var11.field1611 -= var11.field1605 * var5;
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

      var11.field1615 += var11.field1609 * var5;
      var11.field1611 += var11.field1605 * var5;
      var11.field1618 = var6;
      var11.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdv;II)I"
   )
   static int method2274(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1618 -= var5 * var13.field1617;
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
      var13.field1618 += var13.field1617 * var5;
      var13.field1615 = var6;
      var13.field1611 = var7;
      var13.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdv;II)I"
   )
   static int method2268(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1615 -= var11.field1609 * var5;
      var11.field1611 -= var11.field1605 * var5;
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

      var11.field1615 += var11.field1609 * var5;
      var11.field1611 += var11.field1605 * var5;
      var11.field1618 = var6;
      var11.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdv;II)I"
   )
   static int method2253(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1618 -= var5 * var13.field1617;
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
      var13.field1618 += var13.field1617 * var5;
      var13.field1615 = var6;
      var13.field1611 = var7;
      var13.field1613 = var4;
      return var5;
   }
}
