import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class116 extends class118 {
   @ObfuscatedName("r")
   int field1705;
   @ObfuscatedName("a")
   int field1701;
   @ObfuscatedName("o")
   int field1709;
   @ObfuscatedName("b")
   int field1706;
   @ObfuscatedName("l")
   int field1710;
   @ObfuscatedName("j")
   int field1700;
   @ObfuscatedName("i")
   int field1711;
   @ObfuscatedName("n")
   int field1704;
   @ObfuscatedName("k")
   int field1707;
   @ObfuscatedName("q")
   int field1699;
   @ObfuscatedName("s")
   int field1712;
   @ObfuscatedName("t")
   int field1703;
   @ObfuscatedName("y")
   int field1708;
   @ObfuscatedName("d")
   boolean field1702;
   @ObfuscatedName("v")
   int field1713;

   @ObfuscatedSignature(
      signature = "(Ldp;III)V"
   )
   class116(class106 var1, int var2, int var3, int var4) {
      super.field1728 = var1;
      this.field1707 = var1.field1617;
      this.field1712 = var1.field1615;
      this.field1702 = var1.field1619;
      this.field1700 = var2;
      this.field1701 = var3;
      this.field1705 = var4;
      this.field1711 = 0;
      this.method2128();
   }

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   class116(class106 var1, int var2, int var3) {
      super.field1728 = var1;
      this.field1707 = var1.field1617;
      this.field1712 = var1.field1615;
      this.field1702 = var1.field1619;
      this.field1700 = var2;
      this.field1701 = var3;
      this.field1705 = 8192;
      this.field1711 = 0;
      this.method2128();
   }

   @ObfuscatedName("p")
   public synchronized int method2221() {
      return this.field1705 < 0?-1:this.field1705;
   }

   @ObfuscatedName("c")
   synchronized void method2241(int var1) {
      this.method2136(var1, this.method2221());
   }

   @ObfuscatedName("u")
   synchronized void method2136(int var1, int var2) {
      this.field1701 = var1;
      this.field1705 = var2;
      this.field1710 = 0;
      this.method2128();
   }

   @ObfuscatedName("ar")
   public synchronized void method2143(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2136(var2, var3);
      } else {
         int var4 = method2269(var2, var3);
         int var5 = method2199(var2, var3);
         if(var4 == this.field1704 && var5 == this.field1699) {
            this.field1710 = 0;
         } else {
            int var6 = var2 - this.field1709;
            if(this.field1709 - var2 > var6) {
               var6 = this.field1709 - var2;
            }

            if(var4 - this.field1704 > var6) {
               var6 = var4 - this.field1704;
            }

            if(this.field1704 - var4 > var6) {
               var6 = this.field1704 - var4;
            }

            if(var5 - this.field1699 > var6) {
               var6 = var5 - this.field1699;
            }

            if(this.field1699 - var5 > var6) {
               var6 = this.field1699 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1710 = var1;
            this.field1701 = var2;
            this.field1705 = var3;
            this.field1703 = (var2 - this.field1709) / var1;
            this.field1708 = (var4 - this.field1704) / var1;
            this.field1713 = (var5 - this.field1699) / var1;
         }
      }
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3936(int[] var1, int var2, int var3) {
      if(this.field1701 == 0 && this.field1710 == 0) {
         this.vmethod3937(var3);
      } else {
         class106 var4 = (class106)super.field1728;
         int var5 = this.field1707 << 8;
         int var6 = this.field1712 << 8;
         int var7 = var4.field1616.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1706 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1711 < 0) {
            if(this.field1700 <= 0) {
               this.method2141();
               this.unlink();
               return;
            }

            this.field1711 = 0;
         }

         if(this.field1711 >= var7) {
            if(this.field1700 >= 0) {
               this.method2141();
               this.unlink();
               return;
            }

            this.field1711 = var7 - 1;
         }

         if(this.field1706 < 0) {
            if(this.field1702) {
               if(this.field1700 < 0) {
                  var9 = this.method2155(var1, var2, var5, var3, var4.field1616[this.field1707]);
                  if(this.field1711 >= var5) {
                     return;
                  }

                  this.field1711 = var5 + var5 - 1 - this.field1711;
                  this.field1700 = -this.field1700;
               }

               while(true) {
                  var9 = this.method2194(var1, var9, var6, var3, var4.field1616[this.field1712 - 1]);
                  if(this.field1711 < var6) {
                     return;
                  }

                  this.field1711 = var6 + var6 - 1 - this.field1711;
                  this.field1700 = -this.field1700;
                  var9 = this.method2155(var1, var9, var5, var3, var4.field1616[this.field1707]);
                  if(this.field1711 >= var5) {
                     return;
                  }

                  this.field1711 = var5 + var5 - 1 - this.field1711;
                  this.field1700 = -this.field1700;
               }
            } else if(this.field1700 < 0) {
               while(true) {
                  var9 = this.method2155(var1, var9, var5, var3, var4.field1616[this.field1712 - 1]);
                  if(this.field1711 >= var5) {
                     return;
                  }

                  this.field1711 = var6 - 1 - (var6 - 1 - this.field1711) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2194(var1, var9, var6, var3, var4.field1616[this.field1707]);
                  if(this.field1711 < var6) {
                     return;
                  }

                  this.field1711 = var5 + (this.field1711 - var5) % var8;
               }
            }
         } else {
            if(this.field1706 > 0) {
               if(this.field1702) {
                  label142: {
                     if(this.field1700 < 0) {
                        var9 = this.method2155(var1, var2, var5, var3, var4.field1616[this.field1707]);
                        if(this.field1711 >= var5) {
                           return;
                        }

                        this.field1711 = var5 + var5 - 1 - this.field1711;
                        this.field1700 = -this.field1700;
                        if(--this.field1706 == 0) {
                           break label142;
                        }
                     }

                     do {
                        var9 = this.method2194(var1, var9, var6, var3, var4.field1616[this.field1712 - 1]);
                        if(this.field1711 < var6) {
                           return;
                        }

                        this.field1711 = var6 + var6 - 1 - this.field1711;
                        this.field1700 = -this.field1700;
                        if(--this.field1706 == 0) {
                           break;
                        }

                        var9 = this.method2155(var1, var9, var5, var3, var4.field1616[this.field1707]);
                        if(this.field1711 >= var5) {
                           return;
                        }

                        this.field1711 = var5 + var5 - 1 - this.field1711;
                        this.field1700 = -this.field1700;
                     } while(--this.field1706 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1700 < 0) {
                     while(true) {
                        var9 = this.method2155(var1, var9, var5, var3, var4.field1616[this.field1712 - 1]);
                        if(this.field1711 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1711) / var8;
                        if(var10 >= this.field1706) {
                           this.field1711 += var8 * this.field1706;
                           this.field1706 = 0;
                           break;
                        }

                        this.field1711 += var8 * var10;
                        this.field1706 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2194(var1, var9, var6, var3, var4.field1616[this.field1707]);
                        if(this.field1711 < var6) {
                           return;
                        }

                        var10 = (this.field1711 - var5) / var8;
                        if(var10 >= this.field1706) {
                           this.field1711 -= var8 * this.field1706;
                           this.field1706 = 0;
                           break;
                        }

                        this.field1711 -= var8 * var10;
                        this.field1706 -= var10;
                     }
                  }
               }
            }

            if(this.field1700 < 0) {
               this.method2155(var1, var9, 0, var3, 0);
               if(this.field1711 < 0) {
                  this.field1711 = -1;
                  this.method2141();
                  this.unlink();
               }
            } else {
               this.method2194(var1, var9, var7, var3, 0);
               if(this.field1711 >= var7) {
                  this.field1711 = var7;
                  this.method2141();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   public synchronized void vmethod3937(int var1) {
      if(this.field1710 > 0) {
         if(var1 >= this.field1710) {
            if(this.field1701 == Integer.MIN_VALUE) {
               this.field1701 = 0;
               this.field1699 = 0;
               this.field1704 = 0;
               this.field1709 = 0;
               this.unlink();
               var1 = this.field1710;
            }

            this.field1710 = 0;
            this.method2128();
         } else {
            this.field1709 += this.field1703 * var1;
            this.field1704 += this.field1708 * var1;
            this.field1699 += this.field1713 * var1;
            this.field1710 -= var1;
         }
      }

      class106 var2 = (class106)super.field1728;
      int var3 = this.field1707 << 8;
      int var4 = this.field1712 << 8;
      int var5 = var2.field1616.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1706 = 0;
      }

      if(this.field1711 < 0) {
         if(this.field1700 <= 0) {
            this.method2141();
            this.unlink();
            return;
         }

         this.field1711 = 0;
      }

      if(this.field1711 >= var5) {
         if(this.field1700 >= 0) {
            this.method2141();
            this.unlink();
            return;
         }

         this.field1711 = var5 - 1;
      }

      this.field1711 += this.field1700 * var1;
      if(this.field1706 < 0) {
         if(!this.field1702) {
            if(this.field1700 < 0) {
               if(this.field1711 >= var3) {
                  return;
               }

               this.field1711 = var4 - 1 - (var4 - 1 - this.field1711) % var6;
            } else {
               if(this.field1711 < var4) {
                  return;
               }

               this.field1711 = var3 + (this.field1711 - var3) % var6;
            }

         } else {
            if(this.field1700 < 0) {
               if(this.field1711 >= var3) {
                  return;
               }

               this.field1711 = var3 + var3 - 1 - this.field1711;
               this.field1700 = -this.field1700;
            }

            while(this.field1711 >= var4) {
               this.field1711 = var4 + var4 - 1 - this.field1711;
               this.field1700 = -this.field1700;
               if(this.field1711 >= var3) {
                  return;
               }

               this.field1711 = var3 + var3 - 1 - this.field1711;
               this.field1700 = -this.field1700;
            }

         }
      } else {
         if(this.field1706 > 0) {
            if(this.field1702) {
               label127: {
                  if(this.field1700 < 0) {
                     if(this.field1711 >= var3) {
                        return;
                     }

                     this.field1711 = var3 + var3 - 1 - this.field1711;
                     this.field1700 = -this.field1700;
                     if(--this.field1706 == 0) {
                        break label127;
                     }
                  }

                  do {
                     if(this.field1711 < var4) {
                        return;
                     }

                     this.field1711 = var4 + var4 - 1 - this.field1711;
                     this.field1700 = -this.field1700;
                     if(--this.field1706 == 0) {
                        break;
                     }

                     if(this.field1711 >= var3) {
                        return;
                     }

                     this.field1711 = var3 + var3 - 1 - this.field1711;
                     this.field1700 = -this.field1700;
                  } while(--this.field1706 != 0);
               }
            } else {
               int var7;
               if(this.field1700 < 0) {
                  if(this.field1711 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1711) / var6;
                  if(var7 < this.field1706) {
                     this.field1711 += var6 * var7;
                     this.field1706 -= var7;
                     return;
                  }

                  this.field1711 += var6 * this.field1706;
                  this.field1706 = 0;
               } else {
                  if(this.field1711 < var4) {
                     return;
                  }

                  var7 = (this.field1711 - var3) / var6;
                  if(var7 < this.field1706) {
                     this.field1711 -= var6 * var7;
                     this.field1706 -= var7;
                     return;
                  }

                  this.field1711 -= var6 * this.field1706;
                  this.field1706 = 0;
               }
            }
         }

         if(this.field1700 < 0) {
            if(this.field1711 < 0) {
               this.field1711 = -1;
               this.method2141();
               this.unlink();
            }
         } else if(this.field1711 >= var5) {
            this.field1711 = var5;
            this.method2141();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("m")
   public synchronized void method2139(int var1) {
      int var2 = ((class106)super.field1728).field1616.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1711 = var1;
   }

   @ObfuscatedName("o")
   void method2128() {
      this.field1709 = this.field1701;
      this.field1704 = method2269(this.field1701, this.field1705);
      this.field1699 = method2199(this.field1701, this.field1705);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3934() {
      return null;
   }

   @ObfuscatedName("ad")
   public boolean method2147() {
      return this.field1711 < 0 || this.field1711 >= ((class106)super.field1728).field1616.length << 8;
   }

   @ObfuscatedName("al")
   public synchronized void method2162(int var1) {
      if(this.field1700 < 0) {
         this.field1700 = -var1;
      } else {
         this.field1700 = var1;
      }

   }

   @ObfuscatedName("ax")
   public synchronized void method2157(int var1) {
      if(var1 == 0) {
         this.method2241(0);
         this.unlink();
      } else if(this.field1704 == 0 && this.field1699 == 0) {
         this.field1710 = 0;
         this.field1701 = 0;
         this.field1709 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1709;
         if(this.field1709 > var2) {
            var2 = this.field1709;
         }

         if(-this.field1704 > var2) {
            var2 = -this.field1704;
         }

         if(this.field1704 > var2) {
            var2 = this.field1704;
         }

         if(-this.field1699 > var2) {
            var2 = -this.field1699;
         }

         if(this.field1699 > var2) {
            var2 = this.field1699;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1710 = var1;
         this.field1701 = Integer.MIN_VALUE;
         this.field1703 = -this.field1709 / var1;
         this.field1708 = -this.field1704 / var1;
         this.field1713 = -this.field1699 / var1;
      }
   }

   @ObfuscatedName("g")
   void method2141() {
      if(this.field1710 != 0) {
         if(this.field1701 == Integer.MIN_VALUE) {
            this.field1701 = 0;
         }

         this.field1710 = 0;
         this.method2128();
      }

   }

   @ObfuscatedName("ab")
   public boolean method2148() {
      return this.field1710 != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2140() {
      this.field1700 = (this.field1700 ^ this.field1700 >> 31) + (this.field1700 >>> 31);
      this.field1700 = -this.field1700;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3943() {
      return null;
   }

   @ObfuscatedName("bd")
   int vmethod2317() {
      int var1 = this.field1709 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1706 == 0) {
         var1 -= var1 * this.field1711 / (((class106)super.field1728).field1616.length << 8);
      } else if(this.field1706 >= 0) {
         var1 -= var1 * this.field1707 / ((class106)super.field1728).field1616.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ag")
   public synchronized int method2146() {
      return this.field1700 < 0?-this.field1700:this.field1700;
   }

   @ObfuscatedName("e")
   public synchronized int method2233() {
      return this.field1701 == Integer.MIN_VALUE?0:this.field1701;
   }

   @ObfuscatedName("at")
   boolean method2189() {
      int var1 = this.field1701;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2269(var1, this.field1705);
         var3 = method2199(var1, this.field1705);
      }

      if(var1 == this.field1709 && var2 == this.field1704 && var3 == this.field1699) {
         if(this.field1701 == Integer.MIN_VALUE) {
            this.field1701 = 0;
            this.field1699 = 0;
            this.field1704 = 0;
            this.field1709 = 0;
            this.unlink();
            return true;
         } else {
            this.method2128();
            return false;
         }
      } else {
         if(this.field1709 < var1) {
            this.field1703 = 1;
            this.field1710 = var1 - this.field1709;
         } else if(this.field1709 > var1) {
            this.field1703 = -1;
            this.field1710 = this.field1709 - var1;
         } else {
            this.field1703 = 0;
         }

         if(this.field1704 < var2) {
            this.field1708 = 1;
            if(this.field1710 == 0 || this.field1710 > var2 - this.field1704) {
               this.field1710 = var2 - this.field1704;
            }
         } else if(this.field1704 > var2) {
            this.field1708 = -1;
            if(this.field1710 == 0 || this.field1710 > this.field1704 - var2) {
               this.field1710 = this.field1704 - var2;
            }
         } else {
            this.field1708 = 0;
         }

         if(this.field1699 < var3) {
            this.field1713 = 1;
            if(this.field1710 == 0 || this.field1710 > var3 - this.field1699) {
               this.field1710 = var3 - this.field1699;
            }
         } else if(this.field1699 > var3) {
            this.field1713 = -1;
            if(this.field1710 == 0 || this.field1710 > this.field1699 - var3) {
               this.field1710 = this.field1699 - var3;
            }
         } else {
            this.field1713 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aq")
   int method2155(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1710 > 0) {
            int var6 = var2 + this.field1710;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1710 += var2;
            if(this.field1700 == -256 && (this.field1711 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2158(0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, this.field1708, this.field1713, 0, var6, var3, this);
               } else {
                  var2 = method2167(((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, this.field1703, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2172(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, this.field1708, this.field1713, 0, var6, var3, this, this.field1700, var5);
            } else {
               var2 = method2171(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, this.field1703, 0, var6, var3, this, this.field1700, var5);
            }

            this.field1710 -= var2;
            if(this.field1710 != 0) {
               return var2;
            }

            if(!this.method2189()) {
               continue;
            }

            return var4;
         }

         if(this.field1700 == -256 && (this.field1711 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2277(0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, 0, var4, var3, this);
            }

            return method2159(((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2164(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, 0, var4, var3, this, this.field1700, var5);
         }

         return method2163(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, 0, var4, var3, this, this.field1700, var5);
      }
   }

   @ObfuscatedName("am")
   int method2194(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1710 > 0) {
            int var6 = var2 + this.field1710;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1710 += var2;
            if(this.field1700 == 256 && (this.field1711 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2175(0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, this.field1708, this.field1713, 0, var6, var3, this);
               } else {
                  var2 = method2165(((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, this.field1703, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2170(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, this.field1708, this.field1713, 0, var6, var3, this, this.field1700, var5);
            } else {
               var2 = method2205(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, this.field1703, 0, var6, var3, this, this.field1700, var5);
            }

            this.field1710 -= var2;
            if(this.field1710 != 0) {
               return var2;
            }

            if(!this.method2189()) {
               continue;
            }

            return var4;
         }

         if(this.field1700 == 256 && (this.field1711 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2273(0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, 0, var4, var3, this);
            }

            return method2138(((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2229(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1704, this.field1699, 0, var4, var3, this, this.field1700, var5);
         }

         return method2223(0, 0, ((class106)super.field1728).field1616, var1, this.field1711, var2, this.field1709, 0, var4, var3, this, this.field1700, var5);
      }
   }

   @ObfuscatedName("s")
   public synchronized void method2133(int var1) {
      this.field1706 = var1;
   }

   @ObfuscatedName("b")
   protected int vmethod3950() {
      return this.field1701 == 0 && this.field1710 == 0?0:1;
   }

   @ObfuscatedName("w")
   public synchronized void method2142(int var1, int var2) {
      this.method2143(var1, var2, this.method2221());
   }

   @ObfuscatedName("l")
   public synchronized void method2134(int var1) {
      this.method2136(var1 << 6, this.method2221());
   }

   @ObfuscatedName("i")
   static int method2269(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("j")
   static int method2199(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdm;II)I"
   )
   static int method2223(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdm;II)I"
   )
   static int method2163(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var2[var1] - var13) * (var4 & 255) + (var13 << 8)) * var6 >> 6;
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

      var10.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdm;)I"
   )
   static int method2138(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1711 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdm;)I"
   )
   static int method2159(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1711 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2229(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1711 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2164(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1711 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdm;)I"
   )
   static int method2273(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      var10.field1711 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdm;)I"
   )
   static int method2277(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      var10.field1711 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2205(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1704 -= var11.field1708 * var5;
      var11.field1699 -= var11.field1713 * var5;
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

      var11.field1704 += var11.field1708 * var5;
      var11.field1699 += var11.field1713 * var5;
      var11.field1709 = var6;
      var11.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2171(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1704 -= var11.field1708 * var5;
      var11.field1699 -= var11.field1713 * var5;
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

      var11.field1704 += var11.field1708 * var5;
      var11.field1699 += var11.field1713 * var5;
      var11.field1709 = var6;
      var11.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdm;)I"
   )
   static int method2165(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1704 += var9.field1708 * (var6 - var3);
      var9.field1699 += var9.field1713 * (var6 - var3);

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

      var9.field1709 = var4 >> 2;
      var9.field1711 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdm;)I"
   )
   static int method2167(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1704 += var9.field1708 * (var6 - var3);
      var9.field1699 += var9.field1713 * (var6 - var3);

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

      var9.field1709 = var4 >> 2;
      var9.field1711 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdm;II)I"
   )
   static int method2170(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1709 -= var5 * var13.field1703;
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
      var13.field1709 += var5 * var13.field1703;
      var13.field1704 = var6;
      var13.field1699 = var7;
      var13.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdm;II)I"
   )
   static int method2172(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1709 -= var5 * var13.field1703;
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
      var13.field1709 += var5 * var13.field1703;
      var13.field1704 = var6;
      var13.field1699 = var7;
      var13.field1711 = var4;
      return var5;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdm;)I"
   )
   static int method2175(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1709 += (var9 - var4) * var12.field1703;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1704 = var5 >> 2;
      var12.field1699 = var6 >> 2;
      var12.field1711 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdm;)I"
   )
   static int method2158(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1709 += (var9 - var4) * var12.field1703;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1704 = var5 >> 2;
      var12.field1699 = var6 >> 2;
      var12.field1711 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ldp;III)Ldm;"
   )
   public static class116 method2156(class106 var0, int var1, int var2, int var3) {
      return var0.field1616 != null && var0.field1616.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldp;II)Ldm;"
   )
   public static class116 method2130(class106 var0, int var1, int var2) {
      return var0.field1616 != null && var0.field1616.length != 0?new class116(var0, (int)((long)var0.field1618 * 256L * (long)var1 / (long)(class73.sampleRate * 100)), var2 << 6):null;
   }
}
