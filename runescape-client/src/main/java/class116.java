import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class116 extends class118 {
   @ObfuscatedName("m")
   int field1619;
   @ObfuscatedName("p")
   int field1607;
   @ObfuscatedName("i")
   int field1608;
   @ObfuscatedName("j")
   int field1609;
   @ObfuscatedName("v")
   int field1606;
   @ObfuscatedName("x")
   int field1611;
   @ObfuscatedName("e")
   int field1612;
   @ObfuscatedName("l")
   int field1613;
   @ObfuscatedName("b")
   int field1614;
   @ObfuscatedName("n")
   int field1615;
   @ObfuscatedName("c")
   boolean field1618;
   @ObfuscatedName("a")
   int field1617;
   @ObfuscatedName("y")
   int field1616;
   @ObfuscatedName("k")
   int field1610;
   @ObfuscatedName("t")
   int field1620;

   @ObfuscatedSignature(
      signature = "(Lde;III)V"
   )
   class116(class106 var1, int var2, int var3, int var4) {
      super.field1635 = var1;
      this.field1614 = var1.field1529;
      this.field1615 = var1.field1530;
      this.field1618 = var1.field1531;
      this.field1607 = var2;
      this.field1608 = var3;
      this.field1609 = var4;
      this.field1619 = 0;
      this.method2376();
   }

   @ObfuscatedSignature(
      signature = "(Lde;II)V"
   )
   class116(class106 var1, int var2, int var3) {
      super.field1635 = var1;
      this.field1614 = var1.field1529;
      this.field1615 = var1.field1530;
      this.field1618 = var1.field1531;
      this.field1607 = var2;
      this.field1608 = var3;
      this.field1609 = 8192;
      this.field1619 = 0;
      this.method2376();
   }

   @ObfuscatedName("v")
   void method2376() {
      this.field1606 = this.field1608;
      this.field1611 = method2370(this.field1608, this.field1609);
      this.field1612 = method2213(this.field1608, this.field1609);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4047() {
      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4048() {
      return null;
   }

   @ObfuscatedName("l")
   protected int vmethod4068() {
      return this.field1608 == 0 && this.field1617 == 0?0:1;
   }

   @ObfuscatedName("b")
   public synchronized void vmethod4050(int[] var1, int var2, int var3) {
      if(this.field1608 == 0 && this.field1617 == 0) {
         this.vmethod4051(var3);
      } else {
         class106 var4 = (class106)super.field1635;
         int var5 = this.field1614 << 8;
         int var6 = this.field1615 << 8;
         int var7 = var4.field1527.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1613 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1619 < 0) {
            if(this.field1607 <= 0) {
               this.method2228();
               this.unlink();
               return;
            }

            this.field1619 = 0;
         }

         if(this.field1619 >= var7) {
            if(this.field1607 >= 0) {
               this.method2228();
               this.unlink();
               return;
            }

            this.field1619 = var7 - 1;
         }

         if(this.field1613 < 0) {
            if(this.field1618) {
               if(this.field1607 < 0) {
                  var9 = this.method2272(var1, var2, var5, var3, var4.field1527[this.field1614]);
                  if(this.field1619 >= var5) {
                     return;
                  }

                  this.field1619 = var5 + var5 - 1 - this.field1619;
                  this.field1607 = -this.field1607;
               }

               while(true) {
                  var9 = this.method2275(var1, var9, var6, var3, var4.field1527[this.field1615 - 1]);
                  if(this.field1619 < var6) {
                     return;
                  }

                  this.field1619 = var6 + var6 - 1 - this.field1619;
                  this.field1607 = -this.field1607;
                  var9 = this.method2272(var1, var9, var5, var3, var4.field1527[this.field1614]);
                  if(this.field1619 >= var5) {
                     return;
                  }

                  this.field1619 = var5 + var5 - 1 - this.field1619;
                  this.field1607 = -this.field1607;
               }
            } else if(this.field1607 < 0) {
               while(true) {
                  var9 = this.method2272(var1, var9, var5, var3, var4.field1527[this.field1615 - 1]);
                  if(this.field1619 >= var5) {
                     return;
                  }

                  this.field1619 = var6 - 1 - (var6 - 1 - this.field1619) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2275(var1, var9, var6, var3, var4.field1527[this.field1614]);
                  if(this.field1619 < var6) {
                     return;
                  }

                  this.field1619 = var5 + (this.field1619 - var5) % var8;
               }
            }
         } else {
            if(this.field1613 > 0) {
               if(this.field1618) {
                  label134: {
                     if(this.field1607 < 0) {
                        var9 = this.method2272(var1, var2, var5, var3, var4.field1527[this.field1614]);
                        if(this.field1619 >= var5) {
                           return;
                        }

                        this.field1619 = var5 + var5 - 1 - this.field1619;
                        this.field1607 = -this.field1607;
                        if(--this.field1613 == 0) {
                           break label134;
                        }
                     }

                     do {
                        var9 = this.method2275(var1, var9, var6, var3, var4.field1527[this.field1615 - 1]);
                        if(this.field1619 < var6) {
                           return;
                        }

                        this.field1619 = var6 + var6 - 1 - this.field1619;
                        this.field1607 = -this.field1607;
                        if(--this.field1613 == 0) {
                           break;
                        }

                        var9 = this.method2272(var1, var9, var5, var3, var4.field1527[this.field1614]);
                        if(this.field1619 >= var5) {
                           return;
                        }

                        this.field1619 = var5 + var5 - 1 - this.field1619;
                        this.field1607 = -this.field1607;
                     } while(--this.field1613 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1607 < 0) {
                     while(true) {
                        var9 = this.method2272(var1, var9, var5, var3, var4.field1527[this.field1615 - 1]);
                        if(this.field1619 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1619) / var8;
                        if(var10 >= this.field1613) {
                           this.field1619 += var8 * this.field1613;
                           this.field1613 = 0;
                           break;
                        }

                        this.field1619 += var8 * var10;
                        this.field1613 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2275(var1, var9, var6, var3, var4.field1527[this.field1614]);
                        if(this.field1619 < var6) {
                           return;
                        }

                        var10 = (this.field1619 - var5) / var8;
                        if(var10 >= this.field1613) {
                           this.field1619 -= var8 * this.field1613;
                           this.field1613 = 0;
                           break;
                        }

                        this.field1619 -= var8 * var10;
                        this.field1613 -= var10;
                     }
                  }
               }
            }

            if(this.field1607 < 0) {
               this.method2272(var1, var9, 0, var3, 0);
               if(this.field1619 < 0) {
                  this.field1619 = -1;
                  this.method2228();
                  this.unlink();
               }
            } else {
               this.method2275(var1, var9, var7, var3, 0);
               if(this.field1619 >= var7) {
                  this.field1619 = var7;
                  this.method2228();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   public synchronized void method2220(int var1) {
      this.field1613 = var1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod4051(int var1) {
      if(this.field1617 > 0) {
         if(var1 >= this.field1617) {
            if(this.field1608 == Integer.MIN_VALUE) {
               this.field1608 = 0;
               this.field1612 = 0;
               this.field1611 = 0;
               this.field1606 = 0;
               this.unlink();
               var1 = this.field1617;
            }

            this.field1617 = 0;
            this.method2376();
         } else {
            this.field1606 += this.field1616 * var1;
            this.field1611 += this.field1610 * var1;
            this.field1612 += this.field1620 * var1;
            this.field1617 -= var1;
         }
      }

      class106 var2 = (class106)super.field1635;
      int var3 = this.field1614 << 8;
      int var4 = this.field1615 << 8;
      int var5 = var2.field1527.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1613 = 0;
      }

      if(this.field1619 < 0) {
         if(this.field1607 <= 0) {
            this.method2228();
            this.unlink();
            return;
         }

         this.field1619 = 0;
      }

      if(this.field1619 >= var5) {
         if(this.field1607 >= 0) {
            this.method2228();
            this.unlink();
            return;
         }

         this.field1619 = var5 - 1;
      }

      this.field1619 += this.field1607 * var1;
      if(this.field1613 < 0) {
         if(!this.field1618) {
            if(this.field1607 < 0) {
               if(this.field1619 >= var3) {
                  return;
               }

               this.field1619 = var4 - 1 - (var4 - 1 - this.field1619) % var6;
            } else {
               if(this.field1619 < var4) {
                  return;
               }

               this.field1619 = var3 + (this.field1619 - var3) % var6;
            }

         } else {
            if(this.field1607 < 0) {
               if(this.field1619 >= var3) {
                  return;
               }

               this.field1619 = var3 + var3 - 1 - this.field1619;
               this.field1607 = -this.field1607;
            }

            while(this.field1619 >= var4) {
               this.field1619 = var4 + var4 - 1 - this.field1619;
               this.field1607 = -this.field1607;
               if(this.field1619 >= var3) {
                  return;
               }

               this.field1619 = var3 + var3 - 1 - this.field1619;
               this.field1607 = -this.field1607;
            }

         }
      } else {
         if(this.field1613 > 0) {
            if(this.field1618) {
               label123: {
                  if(this.field1607 < 0) {
                     if(this.field1619 >= var3) {
                        return;
                     }

                     this.field1619 = var3 + var3 - 1 - this.field1619;
                     this.field1607 = -this.field1607;
                     if(--this.field1613 == 0) {
                        break label123;
                     }
                  }

                  do {
                     if(this.field1619 < var4) {
                        return;
                     }

                     this.field1619 = var4 + var4 - 1 - this.field1619;
                     this.field1607 = -this.field1607;
                     if(--this.field1613 == 0) {
                        break;
                     }

                     if(this.field1619 >= var3) {
                        return;
                     }

                     this.field1619 = var3 + var3 - 1 - this.field1619;
                     this.field1607 = -this.field1607;
                  } while(--this.field1613 != 0);
               }
            } else {
               label155: {
                  int var7;
                  if(this.field1607 < 0) {
                     if(this.field1619 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1619) / var6;
                     if(var7 >= this.field1613) {
                        this.field1619 += var6 * this.field1613;
                        this.field1613 = 0;
                        break label155;
                     }

                     this.field1619 += var6 * var7;
                     this.field1613 -= var7;
                  } else {
                     if(this.field1619 < var4) {
                        return;
                     }

                     var7 = (this.field1619 - var3) / var6;
                     if(var7 >= this.field1613) {
                        this.field1619 -= var6 * this.field1613;
                        this.field1613 = 0;
                        break label155;
                     }

                     this.field1619 -= var6 * var7;
                     this.field1613 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1607 < 0) {
            if(this.field1619 < 0) {
               this.field1619 = -1;
               this.method2228();
               this.unlink();
            }
         } else if(this.field1619 >= var5) {
            this.field1619 = var5;
            this.method2228();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("a")
   public synchronized void method2221(int var1) {
      this.method2223(var1 << 6, this.method2225());
   }

   @ObfuscatedName("y")
   synchronized void method2219(int var1) {
      this.method2223(var1, this.method2225());
   }

   @ObfuscatedName("w")
   synchronized void method2223(int var1, int var2) {
      this.field1608 = var1;
      this.field1609 = var2;
      this.field1617 = 0;
      this.method2376();
   }

   @ObfuscatedName("k")
   public synchronized int method2229() {
      return this.field1608 == Integer.MIN_VALUE?0:this.field1608;
   }

   @ObfuscatedName("t")
   public synchronized int method2225() {
      return this.field1609 < 0?-1:this.field1609;
   }

   @ObfuscatedName("h")
   public synchronized void method2226(int var1) {
      int var2 = ((class106)super.field1635).field1527.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1619 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2227() {
      this.field1607 = (this.field1607 ^ this.field1607 >> 31) + (this.field1607 >>> 31);
      this.field1607 = -this.field1607;
   }

   @ObfuscatedName("r")
   void method2228() {
      if(this.field1617 != 0) {
         if(this.field1608 == Integer.MIN_VALUE) {
            this.field1608 = 0;
         }

         this.field1617 = 0;
         this.method2376();
      }

   }

   @ObfuscatedName("o")
   public synchronized void method2331(int var1, int var2) {
      this.method2327(var1, var2, this.method2225());
   }

   @ObfuscatedName("q")
   public synchronized void method2327(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2223(var2, var3);
      } else {
         int var4 = method2370(var2, var3);
         int var5 = method2213(var2, var3);
         if(var4 == this.field1611 && var5 == this.field1612) {
            this.field1617 = 0;
         } else {
            int var6 = var2 - this.field1606;
            if(this.field1606 - var2 > var6) {
               var6 = this.field1606 - var2;
            }

            if(var4 - this.field1611 > var6) {
               var6 = var4 - this.field1611;
            }

            if(this.field1611 - var4 > var6) {
               var6 = this.field1611 - var4;
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

            this.field1617 = var1;
            this.field1608 = var2;
            this.field1609 = var3;
            this.field1616 = (var2 - this.field1606) / var1;
            this.field1610 = (var4 - this.field1611) / var1;
            this.field1620 = (var5 - this.field1612) / var1;
         }
      }
   }

   @ObfuscatedName("al")
   public synchronized void method2231(int var1) {
      if(var1 == 0) {
         this.method2219(0);
         this.unlink();
      } else if(this.field1611 == 0 && this.field1612 == 0) {
         this.field1617 = 0;
         this.field1608 = 0;
         this.field1606 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1606;
         if(this.field1606 > var2) {
            var2 = this.field1606;
         }

         if(-this.field1611 > var2) {
            var2 = -this.field1611;
         }

         if(this.field1611 > var2) {
            var2 = this.field1611;
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

         this.field1617 = var1;
         this.field1608 = Integer.MIN_VALUE;
         this.field1616 = -this.field1606 / var1;
         this.field1610 = -this.field1611 / var1;
         this.field1620 = -this.field1612 / var1;
      }
   }

   @ObfuscatedName("ay")
   public synchronized void method2242(int var1) {
      if(this.field1607 < 0) {
         this.field1607 = -var1;
      } else {
         this.field1607 = var1;
      }

   }

   @ObfuscatedName("az")
   public synchronized int method2233() {
      return this.field1607 < 0?-this.field1607:this.field1607;
   }

   @ObfuscatedName("aw")
   public boolean method2212() {
      return this.field1619 < 0 || this.field1619 >= ((class106)super.field1635).field1527.length << 8;
   }

   @ObfuscatedName("au")
   public boolean method2280() {
      return this.field1617 != 0;
   }

   @ObfuscatedName("ai")
   int method2275(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1617 > 0) {
            int var6 = var2 + this.field1617;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1617 += var2;
            if(this.field1607 == 256 && (this.field1619 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2253(0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, this.field1610, this.field1620, 0, var6, var3, this);
               } else {
                  var2 = method2252(((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, this.field1616, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2257(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, this.field1610, this.field1620, 0, var6, var3, this, this.field1607, var5);
            } else {
               var2 = method2256(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, this.field1616, 0, var6, var3, this, this.field1607, var5);
            }

            this.field1617 -= var2;
            if(this.field1617 != 0) {
               return var2;
            }

            if(!this.method2321()) {
               continue;
            }

            return var4;
         }

         if(this.field1607 == 256 && (this.field1619 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2239(0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, 0, var4, var3, this);
            }

            return method2313(((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2249(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, 0, var4, var3, this, this.field1607, var5);
         }

         return method2245(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, 0, var4, var3, this, this.field1607, var5);
      }
   }

   @ObfuscatedName("ax")
   int method2272(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1617 > 0) {
            int var6 = var2 + this.field1617;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1617 += var2;
            if(this.field1607 == -256 && (this.field1619 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2255(0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, this.field1610, this.field1620, 0, var6, var3, this);
               } else {
                  var2 = method2254(((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, this.field1616, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2259(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, this.field1610, this.field1620, 0, var6, var3, this, this.field1607, var5);
            } else {
               var2 = method2346(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, this.field1616, 0, var6, var3, this, this.field1607, var5);
            }

            this.field1617 -= var2;
            if(this.field1617 != 0) {
               return var2;
            }

            if(!this.method2321()) {
               continue;
            }

            return var4;
         }

         if(this.field1607 == -256 && (this.field1619 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2240(0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, 0, var4, var3, this);
            }

            return method2246(((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2289(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1611, this.field1612, 0, var4, var3, this, this.field1607, var5);
         }

         return method2250(0, 0, ((class106)super.field1635).field1527, var1, this.field1619, var2, this.field1606, 0, var4, var3, this, this.field1607, var5);
      }
   }

   @ObfuscatedName("af")
   boolean method2321() {
      int var1 = this.field1608;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2370(var1, this.field1609);
         var3 = method2213(var1, this.field1609);
      }

      if(var1 == this.field1606 && var2 == this.field1611 && var3 == this.field1612) {
         if(this.field1608 == Integer.MIN_VALUE) {
            this.field1608 = 0;
            this.field1612 = 0;
            this.field1611 = 0;
            this.field1606 = 0;
            this.unlink();
            return true;
         } else {
            this.method2376();
            return false;
         }
      } else {
         if(this.field1606 < var1) {
            this.field1616 = 1;
            this.field1617 = var1 - this.field1606;
         } else if(this.field1606 > var1) {
            this.field1616 = -1;
            this.field1617 = this.field1606 - var1;
         } else {
            this.field1616 = 0;
         }

         if(this.field1611 < var2) {
            this.field1610 = 1;
            if(this.field1617 == 0 || this.field1617 > var2 - this.field1611) {
               this.field1617 = var2 - this.field1611;
            }
         } else if(this.field1611 > var2) {
            this.field1610 = -1;
            if(this.field1617 == 0 || this.field1617 > this.field1611 - var2) {
               this.field1617 = this.field1611 - var2;
            }
         } else {
            this.field1610 = 0;
         }

         if(this.field1612 < var3) {
            this.field1620 = 1;
            if(this.field1617 == 0 || this.field1617 > var3 - this.field1612) {
               this.field1617 = var3 - this.field1612;
            }
         } else if(this.field1612 > var3) {
            this.field1620 = -1;
            if(this.field1617 == 0 || this.field1617 > this.field1612 - var3) {
               this.field1617 = this.field1612 - var3;
            }
         } else {
            this.field1620 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aa")
   int vmethod2407() {
      int var1 = this.field1606 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1613 == 0) {
         var1 -= var1 * this.field1619 / (((class106)super.field1635).field1527.length << 8);
      } else if(this.field1613 >= 0) {
         var1 -= var1 * this.field1614 / ((class106)super.field1635).field1527.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("m")
   static int method2370(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("p")
   static int method2213(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lde;II)Ldp;"
   )
   public static class116 method2235(class106 var0, int var1, int var2) {
      return var0.field1527 != null && var0.field1527.length != 0?new class116(var0, (int)((long)var0.field1528 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lde;III)Ldp;"
   )
   public static class116 method2330(class106 var0, int var1, int var2, int var3) {
      return var0.field1527 != null && var0.field1527.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2313(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1619 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2239(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1619 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2246(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1619 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2240(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1619 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2245(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1619 = var4;
      return var5;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2249(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1619 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2250(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1619 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2289(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1619 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2252(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1611 += var9.field1610 * (var6 - var3);
      var9.field1612 += var9.field1620 * (var6 - var3);

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

      var9.field1606 = var4 >> 2;
      var9.field1619 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2253(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1606 += var12.field1616 * (var9 - var4);
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

      var12.field1611 = var5 >> 2;
      var12.field1612 = var6 >> 2;
      var12.field1619 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2254(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1611 += var9.field1610 * (var6 - var3);
      var9.field1612 += var9.field1620 * (var6 - var3);

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

      var9.field1606 = var4 >> 2;
      var9.field1619 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2255(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1606 += var12.field1616 * (var9 - var4);
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

      var12.field1611 = var5 >> 2;
      var12.field1612 = var6 >> 2;
      var12.field1619 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2256(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1611 -= var11.field1610 * var5;
      var11.field1612 -= var11.field1620 * var5;
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

      var11.field1611 += var11.field1610 * var5;
      var11.field1612 += var11.field1620 * var5;
      var11.field1606 = var6;
      var11.field1619 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2257(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1606 -= var5 * var13.field1616;
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
      var13.field1606 += var13.field1616 * var5;
      var13.field1611 = var6;
      var13.field1612 = var7;
      var13.field1619 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2346(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1611 -= var11.field1610 * var5;
      var11.field1612 -= var11.field1620 * var5;
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

      var11.field1611 += var11.field1610 * var5;
      var11.field1612 += var11.field1620 * var5;
      var11.field1606 = var6;
      var11.field1619 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2259(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1606 -= var5 * var13.field1616;
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
      var13.field1606 += var13.field1616 * var5;
      var13.field1611 = var6;
      var13.field1612 = var7;
      var13.field1619 = var4;
      return var5;
   }
}
