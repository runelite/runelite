import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class118 extends class120 {
   @ObfuscatedName("y")
   int field1680;
   @ObfuscatedName("g")
   int field1679;
   @ObfuscatedName("k")
   int field1684;
   @ObfuscatedName("r")
   int field1677;
   @ObfuscatedName("l")
   int field1688;
   @ObfuscatedName("n")
   int field1678;
   @ObfuscatedName("e")
   int field1682;
   @ObfuscatedName("v")
   int field1691;
   @ObfuscatedName("u")
   int field1685;
   @ObfuscatedName("z")
   int field1683;
   @ObfuscatedName("d")
   int field1686;
   @ObfuscatedName("h")
   int field1689;
   @ObfuscatedName("s")
   int field1687;
   @ObfuscatedName("o")
   boolean field1681;
   @ObfuscatedName("c")
   int field1690;

   @ObfuscatedSignature(
      signature = "(Ldb;III)V"
   )
   class118(class108 var1, int var2, int var3, int var4) {
      super.field1704 = var1;
      this.field1685 = var1.field1602;
      this.field1686 = var1.field1599;
      this.field1681 = var1.field1603;
      this.field1678 = var2;
      this.field1679 = var3;
      this.field1680 = var4;
      this.field1682 = 0;
      this.method2149();
   }

   @ObfuscatedSignature(
      signature = "(Ldb;II)V"
   )
   class118(class108 var1, int var2, int var3) {
      super.field1704 = var1;
      this.field1685 = var1.field1602;
      this.field1686 = var1.field1599;
      this.field1681 = var1.field1603;
      this.field1678 = var2;
      this.field1679 = var3;
      this.field1680 = 8192;
      this.field1682 = 0;
      this.method2149();
   }

   @ObfuscatedName("a")
   public synchronized int method2192() {
      return this.field1680 < 0?-1:this.field1680;
   }

   @ObfuscatedName("s")
   synchronized void method2152(int var1) {
      this.method2143(var1, this.method2192());
   }

   @ObfuscatedName("c")
   synchronized void method2143(int var1, int var2) {
      this.field1679 = var1;
      this.field1680 = var2;
      this.field1688 = 0;
      this.method2149();
   }

   @ObfuscatedName("q")
   public synchronized void method2160(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2143(var2, var3);
      } else {
         int var4 = method2200(var2, var3);
         int var5 = method2148(var2, var3);
         if(var4 == this.field1691 && var5 == this.field1683) {
            this.field1688 = 0;
         } else {
            int var6 = var2 - this.field1684;
            if(this.field1684 - var2 > var6) {
               var6 = this.field1684 - var2;
            }

            if(var4 - this.field1691 > var6) {
               var6 = var4 - this.field1691;
            }

            if(this.field1691 - var4 > var6) {
               var6 = this.field1691 - var4;
            }

            if(var5 - this.field1683 > var6) {
               var6 = var5 - this.field1683;
            }

            if(this.field1683 - var5 > var6) {
               var6 = this.field1683 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1688 = var1;
            this.field1679 = var2;
            this.field1680 = var3;
            this.field1689 = (var2 - this.field1684) / var1;
            this.field1687 = (var4 - this.field1691) / var1;
            this.field1690 = (var5 - this.field1683) / var1;
         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3889(int[] var1, int var2, int var3) {
      if(this.field1679 == 0 && this.field1688 == 0) {
         this.vmethod3890(var3);
      } else {
         class108 var4 = (class108)super.field1704;
         int var5 = this.field1685 << 8;
         int var6 = this.field1686 << 8;
         int var7 = var4.field1600.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1677 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1682 < 0) {
            if(this.field1678 <= 0) {
               this.method2158();
               this.unlink();
               return;
            }

            this.field1682 = 0;
         }

         if(this.field1682 >= var7) {
            if(this.field1678 >= 0) {
               this.method2158();
               this.unlink();
               return;
            }

            this.field1682 = var7 - 1;
         }

         if(this.field1677 < 0) {
            if(this.field1681) {
               if(this.field1678 < 0) {
                  var9 = this.method2172(var1, var2, var5, var3, var4.field1600[this.field1685]);
                  if(this.field1682 >= var5) {
                     return;
                  }

                  this.field1682 = var5 + var5 - 1 - this.field1682;
                  this.field1678 = -this.field1678;
               }

               while(true) {
                  var9 = this.method2195(var1, var9, var6, var3, var4.field1600[this.field1686 - 1]);
                  if(this.field1682 < var6) {
                     return;
                  }

                  this.field1682 = var6 + var6 - 1 - this.field1682;
                  this.field1678 = -this.field1678;
                  var9 = this.method2172(var1, var9, var5, var3, var4.field1600[this.field1685]);
                  if(this.field1682 >= var5) {
                     return;
                  }

                  this.field1682 = var5 + var5 - 1 - this.field1682;
                  this.field1678 = -this.field1678;
               }
            } else if(this.field1678 < 0) {
               while(true) {
                  var9 = this.method2172(var1, var9, var5, var3, var4.field1600[this.field1686 - 1]);
                  if(this.field1682 >= var5) {
                     return;
                  }

                  this.field1682 = var6 - 1 - (var6 - 1 - this.field1682) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2195(var1, var9, var6, var3, var4.field1600[this.field1685]);
                  if(this.field1682 < var6) {
                     return;
                  }

                  this.field1682 = var5 + (this.field1682 - var5) % var8;
               }
            }
         } else {
            if(this.field1677 > 0) {
               if(this.field1681) {
                  label130: {
                     if(this.field1678 < 0) {
                        var9 = this.method2172(var1, var2, var5, var3, var4.field1600[this.field1685]);
                        if(this.field1682 >= var5) {
                           return;
                        }

                        this.field1682 = var5 + var5 - 1 - this.field1682;
                        this.field1678 = -this.field1678;
                        if(--this.field1677 == 0) {
                           break label130;
                        }
                     }

                     do {
                        var9 = this.method2195(var1, var9, var6, var3, var4.field1600[this.field1686 - 1]);
                        if(this.field1682 < var6) {
                           return;
                        }

                        this.field1682 = var6 + var6 - 1 - this.field1682;
                        this.field1678 = -this.field1678;
                        if(--this.field1677 == 0) {
                           break;
                        }

                        var9 = this.method2172(var1, var9, var5, var3, var4.field1600[this.field1685]);
                        if(this.field1682 >= var5) {
                           return;
                        }

                        this.field1682 = var5 + var5 - 1 - this.field1682;
                        this.field1678 = -this.field1678;
                     } while(--this.field1677 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1678 < 0) {
                     while(true) {
                        var9 = this.method2172(var1, var9, var5, var3, var4.field1600[this.field1686 - 1]);
                        if(this.field1682 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1682) / var8;
                        if(var10 >= this.field1677) {
                           this.field1682 += var8 * this.field1677;
                           this.field1677 = 0;
                           break;
                        }

                        this.field1682 += var8 * var10;
                        this.field1677 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2195(var1, var9, var6, var3, var4.field1600[this.field1685]);
                        if(this.field1682 < var6) {
                           return;
                        }

                        var10 = (this.field1682 - var5) / var8;
                        if(var10 >= this.field1677) {
                           this.field1682 -= var8 * this.field1677;
                           this.field1677 = 0;
                           break;
                        }

                        this.field1682 -= var8 * var10;
                        this.field1677 -= var10;
                     }
                  }
               }
            }

            if(this.field1678 < 0) {
               this.method2172(var1, var9, 0, var3, 0);
               if(this.field1682 < 0) {
                  this.field1682 = -1;
                  this.method2158();
                  this.unlink();
               }
            } else {
               this.method2195(var1, var9, var7, var3, 0);
               if(this.field1682 >= var7) {
                  this.field1682 = var7;
                  this.method2158();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   public synchronized void vmethod3890(int var1) {
      if(this.field1688 > 0) {
         if(var1 >= this.field1688) {
            if(this.field1679 == Integer.MIN_VALUE) {
               this.field1679 = 0;
               this.field1683 = 0;
               this.field1691 = 0;
               this.field1684 = 0;
               this.unlink();
               var1 = this.field1688;
            }

            this.field1688 = 0;
            this.method2149();
         } else {
            this.field1684 += this.field1689 * var1;
            this.field1691 += this.field1687 * var1;
            this.field1683 += this.field1690 * var1;
            this.field1688 -= var1;
         }
      }

      class108 var2 = (class108)super.field1704;
      int var3 = this.field1685 << 8;
      int var4 = this.field1686 << 8;
      int var5 = var2.field1600.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1677 = 0;
      }

      if(this.field1682 < 0) {
         if(this.field1678 <= 0) {
            this.method2158();
            this.unlink();
            return;
         }

         this.field1682 = 0;
      }

      if(this.field1682 >= var5) {
         if(this.field1678 >= 0) {
            this.method2158();
            this.unlink();
            return;
         }

         this.field1682 = var5 - 1;
      }

      this.field1682 += this.field1678 * var1;
      if(this.field1677 < 0) {
         if(!this.field1681) {
            if(this.field1678 < 0) {
               if(this.field1682 >= var3) {
                  return;
               }

               this.field1682 = var4 - 1 - (var4 - 1 - this.field1682) % var6;
            } else {
               if(this.field1682 < var4) {
                  return;
               }

               this.field1682 = var3 + (this.field1682 - var3) % var6;
            }

         } else {
            if(this.field1678 < 0) {
               if(this.field1682 >= var3) {
                  return;
               }

               this.field1682 = var3 + var3 - 1 - this.field1682;
               this.field1678 = -this.field1678;
            }

            while(this.field1682 >= var4) {
               this.field1682 = var4 + var4 - 1 - this.field1682;
               this.field1678 = -this.field1678;
               if(this.field1682 >= var3) {
                  return;
               }

               this.field1682 = var3 + var3 - 1 - this.field1682;
               this.field1678 = -this.field1678;
            }

         }
      } else {
         if(this.field1677 > 0) {
            if(this.field1681) {
               label133: {
                  if(this.field1678 < 0) {
                     if(this.field1682 >= var3) {
                        return;
                     }

                     this.field1682 = var3 + var3 - 1 - this.field1682;
                     this.field1678 = -this.field1678;
                     if(--this.field1677 == 0) {
                        break label133;
                     }
                  }

                  do {
                     if(this.field1682 < var4) {
                        return;
                     }

                     this.field1682 = var4 + var4 - 1 - this.field1682;
                     this.field1678 = -this.field1678;
                     if(--this.field1677 == 0) {
                        break;
                     }

                     if(this.field1682 >= var3) {
                        return;
                     }

                     this.field1682 = var3 + var3 - 1 - this.field1682;
                     this.field1678 = -this.field1678;
                  } while(--this.field1677 != 0);
               }
            } else {
               int var7;
               if(this.field1678 < 0) {
                  if(this.field1682 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1682) / var6;
                  if(var7 < this.field1677) {
                     this.field1682 += var6 * var7;
                     this.field1677 -= var7;
                     return;
                  }

                  this.field1682 += var6 * this.field1677;
                  this.field1677 = 0;
               } else {
                  if(this.field1682 < var4) {
                     return;
                  }

                  var7 = (this.field1682 - var3) / var6;
                  if(var7 < this.field1677) {
                     this.field1682 -= var6 * var7;
                     this.field1677 -= var7;
                     return;
                  }

                  this.field1682 -= var6 * this.field1677;
                  this.field1677 = 0;
               }
            }
         }

         if(this.field1678 < 0) {
            if(this.field1682 < 0) {
               this.field1682 = -1;
               this.method2158();
               this.unlink();
            }
         } else if(this.field1682 >= var5) {
            this.field1682 = var5;
            this.method2158();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("t")
   public synchronized void method2156(int var1) {
      int var2 = ((class108)super.field1704).field1600.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1682 = var1;
   }

   @ObfuscatedName("w")
   void method2149() {
      this.field1684 = this.field1679;
      this.field1691 = method2200(this.field1679, this.field1680);
      this.field1683 = method2148(this.field1679, this.field1680);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3908() {
      return null;
   }

   @ObfuscatedName("ak")
   public boolean method2164() {
      return this.field1682 < 0 || this.field1682 >= ((class108)super.field1704).field1600.length << 8;
   }

   @ObfuscatedName("aw")
   public synchronized void method2162(int var1) {
      if(this.field1678 < 0) {
         this.field1678 = -var1;
      } else {
         this.field1678 = var1;
      }

   }

   @ObfuscatedName("az")
   public synchronized void method2161(int var1) {
      if(var1 == 0) {
         this.method2152(0);
         this.unlink();
      } else if(this.field1691 == 0 && this.field1683 == 0) {
         this.field1688 = 0;
         this.field1679 = 0;
         this.field1684 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1684;
         if(this.field1684 > var2) {
            var2 = this.field1684;
         }

         if(-this.field1691 > var2) {
            var2 = -this.field1691;
         }

         if(this.field1691 > var2) {
            var2 = this.field1691;
         }

         if(-this.field1683 > var2) {
            var2 = -this.field1683;
         }

         if(this.field1683 > var2) {
            var2 = this.field1683;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1688 = var1;
         this.field1679 = Integer.MIN_VALUE;
         this.field1689 = -this.field1684 / var1;
         this.field1687 = -this.field1691 / var1;
         this.field1690 = -this.field1683 / var1;
      }
   }

   @ObfuscatedName("f")
   void method2158() {
      if(this.field1688 != 0) {
         if(this.field1679 == Integer.MIN_VALUE) {
            this.field1679 = 0;
         }

         this.field1688 = 0;
         this.method2149();
      }

   }

   @ObfuscatedName("ad")
   public boolean method2165() {
      return this.field1688 != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2230() {
      this.field1678 = (this.field1678 ^ this.field1678 >> 31) + (this.field1678 >>> 31);
      this.field1678 = -this.field1678;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3906() {
      return null;
   }

   @ObfuscatedName("af")
   int vmethod2312() {
      int var1 = this.field1684 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1677 == 0) {
         var1 -= var1 * this.field1682 / (((class108)super.field1704).field1600.length << 8);
      } else if(this.field1677 >= 0) {
         var1 -= var1 * this.field1685 / ((class108)super.field1704).field1600.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ac")
   public synchronized int method2289() {
      return this.field1678 < 0?-this.field1678:this.field1678;
   }

   @ObfuscatedName("am")
   int method2172(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1688 > 0) {
            int var6 = var2 + this.field1688;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1688 += var2;
            if(this.field1678 == -256 && (this.field1682 & 255) == 0) {
               if(class25.highMemory) {
                  var2 = method2188(0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, this.field1687, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2184(((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, this.field1689, 0, var6, var3, this);
               }
            } else if(class25.highMemory) {
               var2 = method2189(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, this.field1687, this.field1690, 0, var6, var3, this, this.field1678, var5);
            } else {
               var2 = method2146(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, this.field1689, 0, var6, var3, this, this.field1678, var5);
            }

            this.field1688 -= var2;
            if(this.field1688 != 0) {
               return var2;
            }

            if(!this.method2185()) {
               continue;
            }

            return var4;
         }

         if(this.field1678 == -256 && (this.field1682 & 255) == 0) {
            if(class25.highMemory) {
               return method2177(0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, 0, var4, var3, this);
            }

            return method2176(((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, 0, var4, var3, this);
         }

         if(class25.highMemory) {
            return method2181(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, 0, var4, var3, this, this.field1678, var5);
         }

         return method2180(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, 0, var4, var3, this, this.field1678, var5);
      }
   }

   @ObfuscatedName("m")
   public synchronized int method2278() {
      return this.field1679 == Integer.MIN_VALUE?0:this.field1679;
   }

   @ObfuscatedName("aq")
   boolean method2185() {
      int var1 = this.field1679;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2200(var1, this.field1680);
         var3 = method2148(var1, this.field1680);
      }

      if(var1 == this.field1684 && var2 == this.field1691 && var3 == this.field1683) {
         if(this.field1679 == Integer.MIN_VALUE) {
            this.field1679 = 0;
            this.field1683 = 0;
            this.field1691 = 0;
            this.field1684 = 0;
            this.unlink();
            return true;
         } else {
            this.method2149();
            return false;
         }
      } else {
         if(this.field1684 < var1) {
            this.field1689 = 1;
            this.field1688 = var1 - this.field1684;
         } else if(this.field1684 > var1) {
            this.field1689 = -1;
            this.field1688 = this.field1684 - var1;
         } else {
            this.field1689 = 0;
         }

         if(this.field1691 < var2) {
            this.field1687 = 1;
            if(this.field1688 == 0 || this.field1688 > var2 - this.field1691) {
               this.field1688 = var2 - this.field1691;
            }
         } else if(this.field1691 > var2) {
            this.field1687 = -1;
            if(this.field1688 == 0 || this.field1688 > this.field1691 - var2) {
               this.field1688 = this.field1691 - var2;
            }
         } else {
            this.field1687 = 0;
         }

         if(this.field1683 < var3) {
            this.field1690 = 1;
            if(this.field1688 == 0 || this.field1688 > var3 - this.field1683) {
               this.field1688 = var3 - this.field1683;
            }
         } else if(this.field1683 > var3) {
            this.field1690 = -1;
            if(this.field1688 == 0 || this.field1688 > this.field1683 - var3) {
               this.field1688 = this.field1683 - var3;
            }
         } else {
            this.field1690 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("at")
   int method2195(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1688 > 0) {
            int var6 = var2 + this.field1688;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1688 += var2;
            if(this.field1678 == 256 && (this.field1682 & 255) == 0) {
               if(class25.highMemory) {
                  var2 = method2183(0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, this.field1687, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2182(((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, this.field1689, 0, var6, var3, this);
               }
            } else if(class25.highMemory) {
               var2 = method2187(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, this.field1687, this.field1690, 0, var6, var3, this, this.field1678, var5);
            } else {
               var2 = method2186(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, this.field1689, 0, var6, var3, this, this.field1678, var5);
            }

            this.field1688 -= var2;
            if(this.field1688 != 0) {
               return var2;
            }

            if(!this.method2185()) {
               continue;
            }

            return var4;
         }

         if(this.field1678 == 256 && (this.field1682 & 255) == 0) {
            if(class25.highMemory) {
               return method2175(0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, 0, var4, var3, this);
            }

            return method2174(((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, 0, var4, var3, this);
         }

         if(class25.highMemory) {
            return method2250(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1691, this.field1683, 0, var4, var3, this, this.field1678, var5);
         }

         return method2293(0, 0, ((class108)super.field1704).field1600, var1, this.field1682, var2, this.field1684, 0, var4, var3, this, this.field1678, var5);
      }
   }

   @ObfuscatedName("u")
   public synchronized void method2286(int var1) {
      this.field1677 = var1;
   }

   @ObfuscatedName("z")
   protected int vmethod3904() {
      return this.field1679 == 0 && this.field1688 == 0?0:1;
   }

   @ObfuscatedName("x")
   public synchronized void method2159(int var1, int var2) {
      this.method2160(var1, var2, this.method2192());
   }

   @ObfuscatedName("o")
   public synchronized void method2252(int var1) {
      this.method2143(var1 << 6, this.method2192());
   }

   @ObfuscatedName("e")
   static int method2200(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("n")
   static int method2148(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdq;II)I"
   )
   static int method2293(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var4 & 255) * (var2[var1 + 1] - var13)) * var6 >> 6;
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

      var10.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdq;II)I"
   )
   static int method2180(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10, int var11, int var12) {
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

      var10.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdq;)I"
   )
   static int method2174(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class118 var8) {
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

      var8.field1682 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2250(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
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

      var11.field1682 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdq;)I"
   )
   static int method2176(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class118 var8) {
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

      var8.field1682 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2181(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
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

      var11.field1682 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdq;)I"
   )
   static int method2175(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10) {
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

      var10.field1682 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdq;)I"
   )
   static int method2177(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10) {
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

      var10.field1682 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2186(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
      var11.field1691 -= var11.field1687 * var5;
      var11.field1683 -= var11.field1690 * var5;
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

      var11.field1691 += var11.field1687 * var5;
      var11.field1683 += var11.field1690 * var5;
      var11.field1684 = var6;
      var11.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2146(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
      var11.field1691 -= var11.field1687 * var5;
      var11.field1683 -= var11.field1690 * var5;
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

      var11.field1691 += var11.field1687 * var5;
      var11.field1683 += var11.field1690 * var5;
      var11.field1684 = var6;
      var11.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdq;)I"
   )
   static int method2182(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class118 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1691 += var9.field1687 * (var6 - var3);
      var9.field1683 += var9.field1690 * (var6 - var3);

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

      var9.field1684 = var4 >> 2;
      var9.field1682 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdq;)I"
   )
   static int method2184(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class118 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1691 += var9.field1687 * (var6 - var3);
      var9.field1683 += var9.field1690 * (var6 - var3);

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

      var9.field1684 = var4 >> 2;
      var9.field1682 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdq;II)I"
   )
   static int method2187(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class118 var13, int var14, int var15) {
      var13.field1684 -= var5 * var13.field1689;
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
      var13.field1684 += var5 * var13.field1689;
      var13.field1691 = var6;
      var13.field1683 = var7;
      var13.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdq;II)I"
   )
   static int method2189(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class118 var13, int var14, int var15) {
      var13.field1684 -= var5 * var13.field1689;
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
      var13.field1684 += var5 * var13.field1689;
      var13.field1691 = var6;
      var13.field1683 = var7;
      var13.field1682 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdq;)I"
   )
   static int method2183(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class118 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1684 += (var9 - var4) * var12.field1689;
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

      var12.field1691 = var5 >> 2;
      var12.field1683 = var6 >> 2;
      var12.field1682 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdq;)I"
   )
   static int method2188(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class118 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1684 += (var9 - var4) * var12.field1689;
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

      var12.field1691 = var5 >> 2;
      var12.field1683 = var6 >> 2;
      var12.field1682 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ldb;III)Ldq;"
   )
   public static class118 method2224(class108 var0, int var1, int var2, int var3) {
      return var0.field1600 != null && var0.field1600.length != 0?new class118(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldb;II)Ldq;"
   )
   public static class118 method2147(class108 var0, int var1, int var2) {
      return var0.field1600 != null && var0.field1600.length != 0?new class118(var0, (int)((long)var0.field1601 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }
}
