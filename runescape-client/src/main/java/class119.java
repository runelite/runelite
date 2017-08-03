import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class119 extends class121 {
   @ObfuscatedName("y")
   int field1682;
   @ObfuscatedName("x")
   int field1681;
   @ObfuscatedName("e")
   int field1679;
   @ObfuscatedName("t")
   int field1686;
   @ObfuscatedName("s")
   int field1690;
   @ObfuscatedName("q")
   int field1683;
   @ObfuscatedName("d")
   int field1680;
   @ObfuscatedName("f")
   int field1684;
   @ObfuscatedName("i")
   int field1687;
   @ObfuscatedName("v")
   int field1685;
   @ObfuscatedName("r")
   int field1688;
   @ObfuscatedName("o")
   int field1693;
   @ObfuscatedName("p")
   int field1692;
   @ObfuscatedName("g")
   boolean field1689;
   @ObfuscatedName("u")
   int field1691;

   @ObfuscatedSignature(
      signature = "(Ldv;III)V"
   )
   class119(class109 var1, int var2, int var3, int var4) {
      super.field1706 = var1;
      this.field1687 = var1.field1597;
      this.field1688 = var1.field1600;
      this.field1689 = var1.field1601;
      this.field1683 = var2;
      this.field1681 = var3;
      this.field1682 = var4;
      this.field1680 = 0;
      this.method2303();
   }

   @ObfuscatedSignature(
      signature = "(Ldv;II)V"
   )
   class119(class109 var1, int var2, int var3) {
      super.field1706 = var1;
      this.field1687 = var1.field1597;
      this.field1688 = var1.field1600;
      this.field1689 = var1.field1601;
      this.field1683 = var2;
      this.field1681 = var3;
      this.field1682 = 8192;
      this.field1680 = 0;
      this.method2303();
   }

   @ObfuscatedName("b")
   public synchronized int method2265() {
      return this.field1682 < 0?-1:this.field1682;
   }

   @ObfuscatedName("o")
   synchronized void method2295(int var1) {
      this.method2282(var1, this.method2265());
   }

   @ObfuscatedName("p")
   synchronized void method2282(int var1, int var2) {
      this.field1681 = var1;
      this.field1682 = var2;
      this.field1690 = 0;
      this.method2303();
   }

   @ObfuscatedName("z")
   public synchronized void method2270(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2282(var2, var3);
      } else {
         int var4 = method2317(var2, var3);
         int var5 = method2226(var2, var3);
         if(var4 == this.field1684 && var5 == this.field1685) {
            this.field1690 = 0;
         } else {
            int var6 = var2 - this.field1679;
            if(this.field1679 - var2 > var6) {
               var6 = this.field1679 - var2;
            }

            if(var4 - this.field1684 > var6) {
               var6 = var4 - this.field1684;
            }

            if(this.field1684 - var4 > var6) {
               var6 = this.field1684 - var4;
            }

            if(var5 - this.field1685 > var6) {
               var6 = var5 - this.field1685;
            }

            if(this.field1685 - var5 > var6) {
               var6 = this.field1685 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1690 = var1;
            this.field1681 = var2;
            this.field1682 = var3;
            this.field1693 = (var2 - this.field1679) / var1;
            this.field1692 = (var4 - this.field1684) / var1;
            this.field1691 = (var5 - this.field1685) / var1;
         }
      }
   }

   @ObfuscatedName("i")
   public synchronized void vmethod3897(int[] var1, int var2, int var3) {
      if(this.field1681 == 0 && this.field1690 == 0) {
         this.vmethod3898(var3);
      } else {
         class109 var4 = (class109)super.field1706;
         int var5 = this.field1687 << 8;
         int var6 = this.field1688 << 8;
         int var7 = var4.field1598.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1686 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1680 < 0) {
            if(this.field1683 <= 0) {
               this.method2251();
               this.unlink();
               return;
            }

            this.field1680 = 0;
         }

         if(this.field1680 >= var7) {
            if(this.field1683 >= 0) {
               this.method2251();
               this.unlink();
               return;
            }

            this.field1680 = var7 - 1;
         }

         if(this.field1686 < 0) {
            if(this.field1689) {
               if(this.field1683 < 0) {
                  var9 = this.method2220(var1, var2, var5, var3, var4.field1598[this.field1687]);
                  if(this.field1680 >= var5) {
                     return;
                  }

                  this.field1680 = var5 + var5 - 1 - this.field1680;
                  this.field1683 = -this.field1683;
               }

               while(true) {
                  var9 = this.method2219(var1, var9, var6, var3, var4.field1598[this.field1688 - 1]);
                  if(this.field1680 < var6) {
                     return;
                  }

                  this.field1680 = var6 + var6 - 1 - this.field1680;
                  this.field1683 = -this.field1683;
                  var9 = this.method2220(var1, var9, var5, var3, var4.field1598[this.field1687]);
                  if(this.field1680 >= var5) {
                     return;
                  }

                  this.field1680 = var5 + var5 - 1 - this.field1680;
                  this.field1683 = -this.field1683;
               }
            } else if(this.field1683 < 0) {
               while(true) {
                  var9 = this.method2220(var1, var9, var5, var3, var4.field1598[this.field1688 - 1]);
                  if(this.field1680 >= var5) {
                     return;
                  }

                  this.field1680 = var6 - 1 - (var6 - 1 - this.field1680) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2219(var1, var9, var6, var3, var4.field1598[this.field1687]);
                  if(this.field1680 < var6) {
                     return;
                  }

                  this.field1680 = var5 + (this.field1680 - var5) % var8;
               }
            }
         } else {
            if(this.field1686 > 0) {
               if(this.field1689) {
                  label135: {
                     if(this.field1683 < 0) {
                        var9 = this.method2220(var1, var2, var5, var3, var4.field1598[this.field1687]);
                        if(this.field1680 >= var5) {
                           return;
                        }

                        this.field1680 = var5 + var5 - 1 - this.field1680;
                        this.field1683 = -this.field1683;
                        if(--this.field1686 == 0) {
                           break label135;
                        }
                     }

                     do {
                        var9 = this.method2219(var1, var9, var6, var3, var4.field1598[this.field1688 - 1]);
                        if(this.field1680 < var6) {
                           return;
                        }

                        this.field1680 = var6 + var6 - 1 - this.field1680;
                        this.field1683 = -this.field1683;
                        if(--this.field1686 == 0) {
                           break;
                        }

                        var9 = this.method2220(var1, var9, var5, var3, var4.field1598[this.field1687]);
                        if(this.field1680 >= var5) {
                           return;
                        }

                        this.field1680 = var5 + var5 - 1 - this.field1680;
                        this.field1683 = -this.field1683;
                     } while(--this.field1686 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1683 < 0) {
                     while(true) {
                        var9 = this.method2220(var1, var9, var5, var3, var4.field1598[this.field1688 - 1]);
                        if(this.field1680 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1680) / var8;
                        if(var10 >= this.field1686) {
                           this.field1680 += var8 * this.field1686;
                           this.field1686 = 0;
                           break;
                        }

                        this.field1680 += var8 * var10;
                        this.field1686 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2219(var1, var9, var6, var3, var4.field1598[this.field1687]);
                        if(this.field1680 < var6) {
                           return;
                        }

                        var10 = (this.field1680 - var5) / var8;
                        if(var10 >= this.field1686) {
                           this.field1680 -= var8 * this.field1686;
                           this.field1686 = 0;
                           break;
                        }

                        this.field1680 -= var8 * var10;
                        this.field1686 -= var10;
                     }
                  }
               }
            }

            if(this.field1683 < 0) {
               this.method2220(var1, var9, 0, var3, 0);
               if(this.field1680 < 0) {
                  this.field1680 = -1;
                  this.method2251();
                  this.unlink();
               }
            } else {
               this.method2219(var1, var9, var7, var3, 0);
               if(this.field1680 >= var7) {
                  this.field1680 = var7;
                  this.method2251();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("g")
   public synchronized void vmethod3898(int var1) {
      if(this.field1690 > 0) {
         if(var1 >= this.field1690) {
            if(this.field1681 == Integer.MIN_VALUE) {
               this.field1681 = 0;
               this.field1685 = 0;
               this.field1684 = 0;
               this.field1679 = 0;
               this.unlink();
               var1 = this.field1690;
            }

            this.field1690 = 0;
            this.method2303();
         } else {
            this.field1679 += this.field1693 * var1;
            this.field1684 += this.field1692 * var1;
            this.field1685 += this.field1691 * var1;
            this.field1690 -= var1;
         }
      }

      class109 var2 = (class109)super.field1706;
      int var3 = this.field1687 << 8;
      int var4 = this.field1688 << 8;
      int var5 = var2.field1598.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1686 = 0;
      }

      if(this.field1680 < 0) {
         if(this.field1683 <= 0) {
            this.method2251();
            this.unlink();
            return;
         }

         this.field1680 = 0;
      }

      if(this.field1680 >= var5) {
         if(this.field1683 >= 0) {
            this.method2251();
            this.unlink();
            return;
         }

         this.field1680 = var5 - 1;
      }

      this.field1680 += this.field1683 * var1;
      if(this.field1686 < 0) {
         if(!this.field1689) {
            if(this.field1683 < 0) {
               if(this.field1680 >= var3) {
                  return;
               }

               this.field1680 = var4 - 1 - (var4 - 1 - this.field1680) % var6;
            } else {
               if(this.field1680 < var4) {
                  return;
               }

               this.field1680 = var3 + (this.field1680 - var3) % var6;
            }

         } else {
            if(this.field1683 < 0) {
               if(this.field1680 >= var3) {
                  return;
               }

               this.field1680 = var3 + var3 - 1 - this.field1680;
               this.field1683 = -this.field1683;
            }

            while(this.field1680 >= var4) {
               this.field1680 = var4 + var4 - 1 - this.field1680;
               this.field1683 = -this.field1683;
               if(this.field1680 >= var3) {
                  return;
               }

               this.field1680 = var3 + var3 - 1 - this.field1680;
               this.field1683 = -this.field1683;
            }

         }
      } else {
         if(this.field1686 > 0) {
            if(this.field1689) {
               label135: {
                  if(this.field1683 < 0) {
                     if(this.field1680 >= var3) {
                        return;
                     }

                     this.field1680 = var3 + var3 - 1 - this.field1680;
                     this.field1683 = -this.field1683;
                     if(--this.field1686 == 0) {
                        break label135;
                     }
                  }

                  do {
                     if(this.field1680 < var4) {
                        return;
                     }

                     this.field1680 = var4 + var4 - 1 - this.field1680;
                     this.field1683 = -this.field1683;
                     if(--this.field1686 == 0) {
                        break;
                     }

                     if(this.field1680 >= var3) {
                        return;
                     }

                     this.field1680 = var3 + var3 - 1 - this.field1680;
                     this.field1683 = -this.field1683;
                  } while(--this.field1686 != 0);
               }
            } else {
               label167: {
                  int var7;
                  if(this.field1683 < 0) {
                     if(this.field1680 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1680) / var6;
                     if(var7 >= this.field1686) {
                        this.field1680 += var6 * this.field1686;
                        this.field1686 = 0;
                        break label167;
                     }

                     this.field1680 += var6 * var7;
                     this.field1686 -= var7;
                  } else {
                     if(this.field1680 < var4) {
                        return;
                     }

                     var7 = (this.field1680 - var3) / var6;
                     if(var7 >= this.field1686) {
                        this.field1680 -= var6 * this.field1686;
                        this.field1686 = 0;
                        break label167;
                     }

                     this.field1680 -= var6 * var7;
                     this.field1686 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1683 < 0) {
            if(this.field1680 < 0) {
               this.field1680 = -1;
               this.method2251();
               this.unlink();
            }
         } else if(this.field1680 >= var5) {
            this.field1680 = var5;
            this.method2251();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("w")
   public synchronized void method2204(int var1) {
      int var2 = ((class109)super.field1706).field1598.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1680 = var1;
   }

   @ObfuscatedName("e")
   void method2303() {
      this.field1679 = this.field1681;
      this.field1684 = method2317(this.field1681, this.field1682);
      this.field1685 = method2226(this.field1681, this.field1682);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3895() {
      return null;
   }

   @ObfuscatedName("ax")
   public boolean method2212() {
      return this.field1680 < 0 || this.field1680 >= ((class109)super.field1706).field1598.length << 8;
   }

   @ObfuscatedName("am")
   public synchronized void method2206(int var1) {
      if(this.field1683 < 0) {
         this.field1683 = -var1;
      } else {
         this.field1683 = var1;
      }

   }

   @ObfuscatedName("j")
   public synchronized void method2237(int var1) {
      if(var1 == 0) {
         this.method2295(0);
         this.unlink();
      } else if(this.field1684 == 0 && this.field1685 == 0) {
         this.field1690 = 0;
         this.field1681 = 0;
         this.field1679 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1679;
         if(this.field1679 > var2) {
            var2 = this.field1679;
         }

         if(-this.field1684 > var2) {
            var2 = -this.field1684;
         }

         if(this.field1684 > var2) {
            var2 = this.field1684;
         }

         if(-this.field1685 > var2) {
            var2 = -this.field1685;
         }

         if(this.field1685 > var2) {
            var2 = this.field1685;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1690 = var1;
         this.field1681 = Integer.MIN_VALUE;
         this.field1693 = -this.field1679 / var1;
         this.field1692 = -this.field1684 / var1;
         this.field1691 = -this.field1685 / var1;
      }
   }

   @ObfuscatedName("c")
   void method2251() {
      if(this.field1690 != 0) {
         if(this.field1681 == Integer.MIN_VALUE) {
            this.field1681 = 0;
         }

         this.field1690 = 0;
         this.method2303();
      }

   }

   @ObfuscatedName("at")
   public boolean method2213() {
      return this.field1690 != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2205() {
      this.field1683 = (this.field1683 ^ this.field1683 >> 31) + (this.field1683 >>> 31);
      this.field1683 = -this.field1683;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3913() {
      return null;
   }

   @ObfuscatedName("bi")
   int vmethod2352() {
      int var1 = this.field1679 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1686 == 0) {
         var1 -= var1 * this.field1680 / (((class109)super.field1706).field1598.length << 8);
      } else if(this.field1686 >= 0) {
         var1 -= var1 * this.field1687 / ((class109)super.field1706).field1598.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ac")
   public synchronized int method2211() {
      return this.field1683 < 0?-this.field1683:this.field1683;
   }

   @ObfuscatedName("ak")
   int method2220(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1690 > 0) {
            int var6 = var2 + this.field1690;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1690 += var2;
            if(this.field1683 == -256 && (this.field1680 & 255) == 0) {
               if(XClanMember.highMemory) {
                  var2 = method2329(0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, this.field1692, this.field1691, 0, var6, var3, this);
               } else {
                  var2 = method2232(((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, this.field1693, 0, var6, var3, this);
               }
            } else if(XClanMember.highMemory) {
               var2 = method2192(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, this.field1692, this.field1691, 0, var6, var3, this, this.field1683, var5);
            } else {
               var2 = method2320(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, this.field1693, 0, var6, var3, this, this.field1683, var5);
            }

            this.field1690 -= var2;
            if(this.field1690 != 0) {
               return var2;
            }

            if(!this.method2291()) {
               continue;
            }

            return var4;
         }

         if(this.field1683 == -256 && (this.field1680 & 255) == 0) {
            if(XClanMember.highMemory) {
               return method2279(0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, 0, var4, var3, this);
            }

            return method2224(((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, 0, var4, var3, this);
         }

         if(XClanMember.highMemory) {
            return method2229(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, 0, var4, var3, this, this.field1683, var5);
         }

         return method2208(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, 0, var4, var3, this, this.field1683, var5);
      }
   }

   @ObfuscatedName("u")
   public synchronized int method2193() {
      return this.field1681 == Integer.MIN_VALUE?0:this.field1681;
   }

   @ObfuscatedName("as")
   boolean method2291() {
      int var1 = this.field1681;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2317(var1, this.field1682);
         var3 = method2226(var1, this.field1682);
      }

      if(var1 == this.field1679 && var2 == this.field1684 && var3 == this.field1685) {
         if(this.field1681 == Integer.MIN_VALUE) {
            this.field1681 = 0;
            this.field1685 = 0;
            this.field1684 = 0;
            this.field1679 = 0;
            this.unlink();
            return true;
         } else {
            this.method2303();
            return false;
         }
      } else {
         if(this.field1679 < var1) {
            this.field1693 = 1;
            this.field1690 = var1 - this.field1679;
         } else if(this.field1679 > var1) {
            this.field1693 = -1;
            this.field1690 = this.field1679 - var1;
         } else {
            this.field1693 = 0;
         }

         if(this.field1684 < var2) {
            this.field1692 = 1;
            if(this.field1690 == 0 || this.field1690 > var2 - this.field1684) {
               this.field1690 = var2 - this.field1684;
            }
         } else if(this.field1684 > var2) {
            this.field1692 = -1;
            if(this.field1690 == 0 || this.field1690 > this.field1684 - var2) {
               this.field1690 = this.field1684 - var2;
            }
         } else {
            this.field1692 = 0;
         }

         if(this.field1685 < var3) {
            this.field1691 = 1;
            if(this.field1690 == 0 || this.field1690 > var3 - this.field1685) {
               this.field1690 = var3 - this.field1685;
            }
         } else if(this.field1685 > var3) {
            this.field1691 = -1;
            if(this.field1690 == 0 || this.field1690 > this.field1685 - var3) {
               this.field1690 = this.field1685 - var3;
            }
         } else {
            this.field1691 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ag")
   int method2219(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1690 > 0) {
            int var6 = var2 + this.field1690;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1690 += var2;
            if(this.field1683 == 256 && (this.field1680 & 255) == 0) {
               if(XClanMember.highMemory) {
                  var2 = method2231(0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, this.field1692, this.field1691, 0, var6, var3, this);
               } else {
                  var2 = method2215(((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, this.field1693, 0, var6, var3, this);
               }
            } else if(XClanMember.highMemory) {
               var2 = method2305(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, this.field1692, this.field1691, 0, var6, var3, this, this.field1683, var5);
            } else {
               var2 = method2234(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, this.field1693, 0, var6, var3, this, this.field1683, var5);
            }

            this.field1690 -= var2;
            if(this.field1690 != 0) {
               return var2;
            }

            if(!this.method2291()) {
               continue;
            }

            return var4;
         }

         if(this.field1683 == 256 && (this.field1680 & 255) == 0) {
            if(XClanMember.highMemory) {
               return method2223(0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, 0, var4, var3, this);
            }

            return method2222(((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, 0, var4, var3, this);
         }

         if(XClanMember.highMemory) {
            return method2227(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1684, this.field1685, 0, var4, var3, this, this.field1683, var5);
         }

         return method2334(0, 0, ((class109)super.field1706).field1598, var1, this.field1680, var2, this.field1679, 0, var4, var3, this, this.field1683, var5);
      }
   }

   @ObfuscatedName("r")
   public synchronized void method2198(int var1) {
      this.field1686 = var1;
   }

   @ObfuscatedName("t")
   protected int vmethod3916() {
      return this.field1681 == 0 && this.field1690 == 0?0:1;
   }

   @ObfuscatedName("h")
   public synchronized void method2201(int var1, int var2) {
      this.method2270(var1, var2, this.method2265());
   }

   @ObfuscatedName("s")
   public synchronized void method2199(int var1) {
      this.method2282(var1 << 6, this.method2265());
   }

   @ObfuscatedName("d")
   static int method2317(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   static int method2226(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdn;II)I"
   )
   static int method2334(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class119 var10, int var11, int var12) {
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

      var10.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdn;II)I"
   )
   static int method2208(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class119 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
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

      var10.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdn;)I"
   )
   static int method2222(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class119 var8) {
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

      var8.field1680 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdn;)I"
   )
   static int method2224(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class119 var8) {
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

      var8.field1680 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2227(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class119 var11, int var12, int var13) {
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

      var11.field1680 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2229(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class119 var11, int var12, int var13) {
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

      var11.field1680 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdn;)I"
   )
   static int method2223(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class119 var10) {
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

      var10.field1680 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdn;)I"
   )
   static int method2279(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class119 var10) {
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

      var10.field1680 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2234(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class119 var11, int var12, int var13) {
      var11.field1684 -= var11.field1692 * var5;
      var11.field1685 -= var11.field1691 * var5;
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

      var11.field1684 += var11.field1692 * var5;
      var11.field1685 += var11.field1691 * var5;
      var11.field1679 = var6;
      var11.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2320(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class119 var11, int var12, int var13) {
      var11.field1684 -= var11.field1692 * var5;
      var11.field1685 -= var11.field1691 * var5;
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

      var11.field1684 += var11.field1692 * var5;
      var11.field1685 += var11.field1691 * var5;
      var11.field1679 = var6;
      var11.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdn;)I"
   )
   static int method2215(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class119 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1684 += var9.field1692 * (var6 - var3);
      var9.field1685 += var9.field1691 * (var6 - var3);

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

      var9.field1679 = var4 >> 2;
      var9.field1680 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdn;)I"
   )
   static int method2232(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class119 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1684 += var9.field1692 * (var6 - var3);
      var9.field1685 += var9.field1691 * (var6 - var3);

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

      var9.field1679 = var4 >> 2;
      var9.field1680 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdn;II)I"
   )
   static int method2305(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class119 var13, int var14, int var15) {
      var13.field1679 -= var5 * var13.field1693;
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
      var13.field1679 += var5 * var13.field1693;
      var13.field1684 = var6;
      var13.field1685 = var7;
      var13.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdn;II)I"
   )
   static int method2192(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class119 var13, int var14, int var15) {
      var13.field1679 -= var5 * var13.field1693;
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
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1679 += var5 * var13.field1693;
      var13.field1684 = var6;
      var13.field1685 = var7;
      var13.field1680 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdn;)I"
   )
   static int method2231(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class119 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1679 += (var9 - var4) * var12.field1693;
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

      var12.field1684 = var5 >> 2;
      var12.field1685 = var6 >> 2;
      var12.field1680 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdn;)I"
   )
   static int method2329(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class119 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1679 += (var9 - var4) * var12.field1693;
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

      var12.field1684 = var5 >> 2;
      var12.field1685 = var6 >> 2;
      var12.field1680 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ldv;III)Ldn;"
   )
   public static class119 method2196(class109 var0, int var1, int var2, int var3) {
      return var0.field1598 != null && var0.field1598.length != 0?new class119(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldv;II)Ldn;"
   )
   public static class119 method2195(class109 var0, int var1, int var2) {
      return var0.field1598 != null && var0.field1598.length != 0?new class119(var0, (int)((long)var0.field1599 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }
}
