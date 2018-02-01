import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class114 extends TaskDataNode {
   @ObfuscatedName("p")
   int field1572;
   @ObfuscatedName("i")
   int field1581;
   @ObfuscatedName("s")
   int field1573;
   @ObfuscatedName("j")
   int field1574;
   @ObfuscatedName("a")
   int field1575;
   @ObfuscatedName("t")
   int field1576;
   @ObfuscatedName("r")
   int field1577;
   @ObfuscatedName("m")
   int field1578;
   @ObfuscatedName("h")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("o")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("x")
   boolean field1571;
   @ObfuscatedName("q")
   int field1582;
   @ObfuscatedName("v")
   int field1583;
   @ObfuscatedName("n")
   int field1584;
   @ObfuscatedName("y")
   int field1585;

   @ObfuscatedSignature(
      signature = "(Ldp;III)V"
   )
   class114(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1571 = var1.field1503;
      this.field1581 = var2;
      this.field1573 = var3;
      this.field1574 = var4;
      this.field1572 = 0;
      this.method2287();
   }

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   class114(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1571 = var1.field1503;
      this.field1581 = var2;
      this.field1573 = var3;
      this.field1574 = 8192;
      this.field1572 = 0;
      this.method2287();
   }

   @ObfuscatedName("j")
   void method2287() {
      this.field1575 = this.field1573;
      this.field1576 = method2309(this.field1573, this.field1574);
      this.field1577 = method2283(this.field1573, this.field1574);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4155() {
      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4141() {
      return null;
   }

   @ObfuscatedName("r")
   protected int vmethod4158() {
      return this.field1573 == 0 && this.field1582 == 0?0:1;
   }

   @ObfuscatedName("m")
   public synchronized void vmethod4145(int[] var1, int var2, int var3) {
      if(this.field1573 == 0 && this.field1582 == 0) {
         this.vmethod4144(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1578 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1572 < 0) {
            if(this.field1581 <= 0) {
               this.method2296();
               this.unlink();
               return;
            }

            this.field1572 = 0;
         }

         if(this.field1572 >= var7) {
            if(this.field1581 >= 0) {
               this.method2296();
               this.unlink();
               return;
            }

            this.field1572 = var7 - 1;
         }

         if(this.field1578 < 0) {
            if(this.field1571) {
               if(this.field1581 < 0) {
                  var9 = this.method2310(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1572 >= var5) {
                     return;
                  }

                  this.field1572 = var5 + var5 - 1 - this.field1572;
                  this.field1581 = -this.field1581;
               }

               while(true) {
                  var9 = this.method2363(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1572 < var6) {
                     return;
                  }

                  this.field1572 = var6 + var6 - 1 - this.field1572;
                  this.field1581 = -this.field1581;
                  var9 = this.method2310(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1572 >= var5) {
                     return;
                  }

                  this.field1572 = var5 + var5 - 1 - this.field1572;
                  this.field1581 = -this.field1581;
               }
            } else if(this.field1581 < 0) {
               while(true) {
                  var9 = this.method2310(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1572 >= var5) {
                     return;
                  }

                  this.field1572 = var6 - 1 - (var6 - 1 - this.field1572) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2363(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1572 < var6) {
                     return;
                  }

                  this.field1572 = var5 + (this.field1572 - var5) % var8;
               }
            }
         } else {
            if(this.field1578 > 0) {
               if(this.field1571) {
                  label131: {
                     if(this.field1581 < 0) {
                        var9 = this.method2310(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1572 >= var5) {
                           return;
                        }

                        this.field1572 = var5 + var5 - 1 - this.field1572;
                        this.field1581 = -this.field1581;
                        if(--this.field1578 == 0) {
                           break label131;
                        }
                     }

                     do {
                        var9 = this.method2363(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1572 < var6) {
                           return;
                        }

                        this.field1572 = var6 + var6 - 1 - this.field1572;
                        this.field1581 = -this.field1581;
                        if(--this.field1578 == 0) {
                           break;
                        }

                        var9 = this.method2310(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1572 >= var5) {
                           return;
                        }

                        this.field1572 = var5 + var5 - 1 - this.field1572;
                        this.field1581 = -this.field1581;
                     } while(--this.field1578 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1581 < 0) {
                     while(true) {
                        var9 = this.method2310(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1572 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1572) / var8;
                        if(var10 >= this.field1578) {
                           this.field1572 += var8 * this.field1578;
                           this.field1578 = 0;
                           break;
                        }

                        this.field1572 += var8 * var10;
                        this.field1578 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2363(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1572 < var6) {
                           return;
                        }

                        var10 = (this.field1572 - var5) / var8;
                        if(var10 >= this.field1578) {
                           this.field1572 -= var8 * this.field1578;
                           this.field1578 = 0;
                           break;
                        }

                        this.field1572 -= var8 * var10;
                        this.field1578 -= var10;
                     }
                  }
               }
            }

            if(this.field1581 < 0) {
               this.method2310(var1, var9, 0, var3, 0);
               if(this.field1572 < 0) {
                  this.field1572 = -1;
                  this.method2296();
                  this.unlink();
               }
            } else {
               this.method2363(var1, var9, var7, var3, 0);
               if(this.field1572 >= var7) {
                  this.field1572 = var7;
                  this.method2296();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   public synchronized void method2288(int var1) {
      this.field1578 = var1;
   }

   @ObfuscatedName("o")
   public synchronized void vmethod4144(int var1) {
      if(this.field1582 > 0) {
         if(var1 >= this.field1582) {
            if(this.field1573 == Integer.MIN_VALUE) {
               this.field1573 = 0;
               this.field1577 = 0;
               this.field1576 = 0;
               this.field1575 = 0;
               this.unlink();
               var1 = this.field1582;
            }

            this.field1582 = 0;
            this.method2287();
         } else {
            this.field1575 += this.field1583 * var1;
            this.field1576 += this.field1584 * var1;
            this.field1577 += this.field1585 * var1;
            this.field1582 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1578 = 0;
      }

      if(this.field1572 < 0) {
         if(this.field1581 <= 0) {
            this.method2296();
            this.unlink();
            return;
         }

         this.field1572 = 0;
      }

      if(this.field1572 >= var5) {
         if(this.field1581 >= 0) {
            this.method2296();
            this.unlink();
            return;
         }

         this.field1572 = var5 - 1;
      }

      this.field1572 += this.field1581 * var1;
      if(this.field1578 < 0) {
         if(!this.field1571) {
            if(this.field1581 < 0) {
               if(this.field1572 >= var3) {
                  return;
               }

               this.field1572 = var4 - 1 - (var4 - 1 - this.field1572) % var6;
            } else {
               if(this.field1572 < var4) {
                  return;
               }

               this.field1572 = var3 + (this.field1572 - var3) % var6;
            }

         } else {
            if(this.field1581 < 0) {
               if(this.field1572 >= var3) {
                  return;
               }

               this.field1572 = var3 + var3 - 1 - this.field1572;
               this.field1581 = -this.field1581;
            }

            while(this.field1572 >= var4) {
               this.field1572 = var4 + var4 - 1 - this.field1572;
               this.field1581 = -this.field1581;
               if(this.field1572 >= var3) {
                  return;
               }

               this.field1572 = var3 + var3 - 1 - this.field1572;
               this.field1581 = -this.field1581;
            }

         }
      } else {
         if(this.field1578 > 0) {
            if(this.field1571) {
               label119: {
                  if(this.field1581 < 0) {
                     if(this.field1572 >= var3) {
                        return;
                     }

                     this.field1572 = var3 + var3 - 1 - this.field1572;
                     this.field1581 = -this.field1581;
                     if(--this.field1578 == 0) {
                        break label119;
                     }
                  }

                  do {
                     if(this.field1572 < var4) {
                        return;
                     }

                     this.field1572 = var4 + var4 - 1 - this.field1572;
                     this.field1581 = -this.field1581;
                     if(--this.field1578 == 0) {
                        break;
                     }

                     if(this.field1572 >= var3) {
                        return;
                     }

                     this.field1572 = var3 + var3 - 1 - this.field1572;
                     this.field1581 = -this.field1581;
                  } while(--this.field1578 != 0);
               }
            } else {
               label151: {
                  int var7;
                  if(this.field1581 < 0) {
                     if(this.field1572 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1572) / var6;
                     if(var7 >= this.field1578) {
                        this.field1572 += var6 * this.field1578;
                        this.field1578 = 0;
                        break label151;
                     }

                     this.field1572 += var6 * var7;
                     this.field1578 -= var7;
                  } else {
                     if(this.field1572 < var4) {
                        return;
                     }

                     var7 = (this.field1572 - var3) / var6;
                     if(var7 >= this.field1578) {
                        this.field1572 -= var6 * this.field1578;
                        this.field1578 = 0;
                        break label151;
                     }

                     this.field1572 -= var6 * var7;
                     this.field1578 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1581 < 0) {
            if(this.field1572 < 0) {
               this.field1572 = -1;
               this.method2296();
               this.unlink();
            }
         } else if(this.field1572 >= var5) {
            this.field1572 = var5;
            this.method2296();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("x")
   public synchronized void method2289(int var1) {
      this.method2365(var1 << 6, this.method2293());
   }

   @ObfuscatedName("q")
   synchronized void method2290(int var1) {
      this.method2365(var1, this.method2293());
   }

   @ObfuscatedName("d")
   synchronized void method2365(int var1, int var2) {
      this.field1573 = var1;
      this.field1574 = var2;
      this.field1582 = 0;
      this.method2287();
   }

   @ObfuscatedName("l")
   public synchronized int method2414() {
      return this.field1573 == Integer.MIN_VALUE?0:this.field1573;
   }

   @ObfuscatedName("f")
   public synchronized int method2293() {
      return this.field1574 < 0?-1:this.field1574;
   }

   @ObfuscatedName("k")
   public synchronized void method2294(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1572 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2295() {
      this.field1581 = (this.field1581 ^ this.field1581 >> 31) + (this.field1581 >>> 31);
      this.field1581 = -this.field1581;
   }

   @ObfuscatedName("u")
   void method2296() {
      if(this.field1582 != 0) {
         if(this.field1573 == Integer.MIN_VALUE) {
            this.field1573 = 0;
         }

         this.field1582 = 0;
         this.method2287();
      }

   }

   @ObfuscatedName("z")
   public synchronized void method2297(int var1, int var2) {
      this.method2292(var1, var2, this.method2293());
   }

   @ObfuscatedName("ae")
   public synchronized void method2292(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2365(var2, var3);
      } else {
         int var4 = method2309(var2, var3);
         int var5 = method2283(var2, var3);
         if(var4 == this.field1576 && var5 == this.field1577) {
            this.field1582 = 0;
         } else {
            int var6 = var2 - this.field1575;
            if(this.field1575 - var2 > var6) {
               var6 = this.field1575 - var2;
            }

            if(var4 - this.field1576 > var6) {
               var6 = var4 - this.field1576;
            }

            if(this.field1576 - var4 > var6) {
               var6 = this.field1576 - var4;
            }

            if(var5 - this.field1577 > var6) {
               var6 = var5 - this.field1577;
            }

            if(this.field1577 - var5 > var6) {
               var6 = this.field1577 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1582 = var1;
            this.field1573 = var2;
            this.field1574 = var3;
            this.field1583 = (var2 - this.field1575) / var1;
            this.field1584 = (var4 - this.field1576) / var1;
            this.field1585 = (var5 - this.field1577) / var1;
         }
      }
   }

   @ObfuscatedName("ah")
   public synchronized void method2299(int var1) {
      if(var1 == 0) {
         this.method2290(0);
         this.unlink();
      } else if(this.field1576 == 0 && this.field1577 == 0) {
         this.field1582 = 0;
         this.field1573 = 0;
         this.field1575 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1575;
         if(this.field1575 > var2) {
            var2 = this.field1575;
         }

         if(-this.field1576 > var2) {
            var2 = -this.field1576;
         }

         if(this.field1576 > var2) {
            var2 = this.field1576;
         }

         if(-this.field1577 > var2) {
            var2 = -this.field1577;
         }

         if(this.field1577 > var2) {
            var2 = this.field1577;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1582 = var1;
         this.field1573 = Integer.MIN_VALUE;
         this.field1583 = -this.field1575 / var1;
         this.field1584 = -this.field1576 / var1;
         this.field1585 = -this.field1577 / var1;
      }
   }

   @ObfuscatedName("ai")
   public synchronized void method2300(int var1) {
      if(this.field1581 < 0) {
         this.field1581 = -var1;
      } else {
         this.field1581 = var1;
      }

   }

   @ObfuscatedName("au")
   public synchronized int method2301() {
      return this.field1581 < 0?-this.field1581:this.field1581;
   }

   @ObfuscatedName("am")
   public boolean method2302() {
      return this.field1572 < 0 || this.field1572 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("af")
   public boolean method2303() {
      return this.field1582 != 0;
   }

   @ObfuscatedName("av")
   int method2363(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1582 > 0) {
            int var6 = var2 + this.field1582;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1582 += var2;
            if(this.field1581 == 256 && (this.field1572 & 255) == 0) {
               if(BoundingBox3DDrawMode.highMemory) {
                  var2 = method2321(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, this.field1584, this.field1585, 0, var6, var3, this);
               } else {
                  var2 = method2320(((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, this.field1583, 0, var6, var3, this);
               }
            } else if(BoundingBox3DDrawMode.highMemory) {
               var2 = method2325(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, this.field1584, this.field1585, 0, var6, var3, this, this.field1581, var5);
            } else {
               var2 = method2324(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, this.field1583, 0, var6, var3, this, this.field1581, var5);
            }

            this.field1582 -= var2;
            if(this.field1582 != 0) {
               return var2;
            }

            if(!this.method2336()) {
               continue;
            }

            return var4;
         }

         if(this.field1581 == 256 && (this.field1572 & 255) == 0) {
            if(BoundingBox3DDrawMode.highMemory) {
               return method2358(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, 0, var4, var3, this);
            }

            return method2383(((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, 0, var4, var3, this);
         }

         if(BoundingBox3DDrawMode.highMemory) {
            return method2334(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, 0, var4, var3, this, this.field1581, var5);
         }

         return method2316(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, 0, var4, var3, this, this.field1581, var5);
      }
   }

   @ObfuscatedName("aw")
   int method2310(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1582 > 0) {
            int var6 = var2 + this.field1582;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1582 += var2;
            if(this.field1581 == -256 && (this.field1572 & 255) == 0) {
               if(BoundingBox3DDrawMode.highMemory) {
                  var2 = method2323(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, this.field1584, this.field1585, 0, var6, var3, this);
               } else {
                  var2 = method2322(((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, this.field1583, 0, var6, var3, this);
               }
            } else if(BoundingBox3DDrawMode.highMemory) {
               var2 = method2384(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, this.field1584, this.field1585, 0, var6, var3, this, this.field1581, var5);
            } else {
               var2 = method2326(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, this.field1583, 0, var6, var3, this, this.field1581, var5);
            }

            this.field1582 -= var2;
            if(this.field1582 != 0) {
               return var2;
            }

            if(!this.method2336()) {
               continue;
            }

            return var4;
         }

         if(this.field1581 == -256 && (this.field1572 & 255) == 0) {
            if(BoundingBox3DDrawMode.highMemory) {
               return method2340(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, 0, var4, var3, this);
            }

            return method2314(((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, 0, var4, var3, this);
         }

         if(BoundingBox3DDrawMode.highMemory) {
            return method2359(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1576, this.field1577, 0, var4, var3, this, this.field1581, var5);
         }

         return method2318(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1572, var2, this.field1575, 0, var4, var3, this, this.field1581, var5);
      }
   }

   @ObfuscatedName("ad")
   boolean method2336() {
      int var1 = this.field1573;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2309(var1, this.field1574);
         var3 = method2283(var1, this.field1574);
      }

      if(var1 == this.field1575 && var2 == this.field1576 && var3 == this.field1577) {
         if(this.field1573 == Integer.MIN_VALUE) {
            this.field1573 = 0;
            this.field1577 = 0;
            this.field1576 = 0;
            this.field1575 = 0;
            this.unlink();
            return true;
         } else {
            this.method2287();
            return false;
         }
      } else {
         if(this.field1575 < var1) {
            this.field1583 = 1;
            this.field1582 = var1 - this.field1575;
         } else if(this.field1575 > var1) {
            this.field1583 = -1;
            this.field1582 = this.field1575 - var1;
         } else {
            this.field1583 = 0;
         }

         if(this.field1576 < var2) {
            this.field1584 = 1;
            if(this.field1582 == 0 || this.field1582 > var2 - this.field1576) {
               this.field1582 = var2 - this.field1576;
            }
         } else if(this.field1576 > var2) {
            this.field1584 = -1;
            if(this.field1582 == 0 || this.field1582 > this.field1576 - var2) {
               this.field1582 = this.field1576 - var2;
            }
         } else {
            this.field1584 = 0;
         }

         if(this.field1577 < var3) {
            this.field1585 = 1;
            if(this.field1582 == 0 || this.field1582 > var3 - this.field1577) {
               this.field1582 = var3 - this.field1577;
            }
         } else if(this.field1577 > var3) {
            this.field1585 = -1;
            if(this.field1582 == 0 || this.field1582 > this.field1577 - var3) {
               this.field1582 = this.field1577 - var3;
            }
         } else {
            this.field1585 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aq")
   int vmethod2452() {
      int var1 = this.field1575 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1578 == 0) {
         var1 -= var1 * this.field1572 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1578 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("p")
   static int method2309(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   static int method2283(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldp;II)Ldm;"
   )
   public static class114 method2285(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class114(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(class20.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldp;III)Ldm;"
   )
   public static class114 method2420(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class114(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdm;)I"
   )
   static int method2383(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class114 var8) {
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

      var8.field1572 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdm;)I"
   )
   static int method2358(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10) {
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

      var10.field1572 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdm;)I"
   )
   static int method2314(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class114 var8) {
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

      var8.field1572 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdm;)I"
   )
   static int method2340(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10) {
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

      var10.field1572 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdm;II)I"
   )
   static int method2316(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10, int var11, int var12) {
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

      var10.field1572 = var4;
      return var5;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2334(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
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

      var11.field1572 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdm;II)I"
   )
   static int method2318(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10, int var11, int var12) {
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

      var10.field1572 = var4;
      return var5;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2359(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
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

      var11.field1572 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdm;)I"
   )
   static int method2320(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class114 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1576 += var9.field1584 * (var6 - var3);
      var9.field1577 += var9.field1585 * (var6 - var3);

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

      var9.field1575 = var4 >> 2;
      var9.field1572 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdm;)I"
   )
   static int method2321(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class114 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1575 += var12.field1583 * (var9 - var4);
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

      var12.field1576 = var5 >> 2;
      var12.field1577 = var6 >> 2;
      var12.field1572 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdm;)I"
   )
   static int method2322(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class114 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1576 += var9.field1584 * (var6 - var3);
      var9.field1577 += var9.field1585 * (var6 - var3);

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

      var9.field1575 = var4 >> 2;
      var9.field1572 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdm;)I"
   )
   static int method2323(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class114 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1575 += var12.field1583 * (var9 - var4);
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

      var12.field1576 = var5 >> 2;
      var12.field1577 = var6 >> 2;
      var12.field1572 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2324(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
      var11.field1576 -= var11.field1584 * var5;
      var11.field1577 -= var11.field1585 * var5;
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

      var11.field1576 += var11.field1584 * var5;
      var11.field1577 += var11.field1585 * var5;
      var11.field1575 = var6;
      var11.field1572 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdm;II)I"
   )
   static int method2325(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class114 var13, int var14, int var15) {
      var13.field1575 -= var5 * var13.field1583;
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
      var13.field1575 += var13.field1583 * var5;
      var13.field1576 = var6;
      var13.field1577 = var7;
      var13.field1572 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdm;II)I"
   )
   static int method2326(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
      var11.field1576 -= var11.field1584 * var5;
      var11.field1577 -= var11.field1585 * var5;
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

      var11.field1576 += var11.field1584 * var5;
      var11.field1577 += var11.field1585 * var5;
      var11.field1575 = var6;
      var11.field1572 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdm;II)I"
   )
   static int method2384(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class114 var13, int var14, int var15) {
      var13.field1575 -= var5 * var13.field1583;
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
      var13.field1575 += var13.field1583 * var5;
      var13.field1576 = var6;
      var13.field1577 = var7;
      var13.field1572 = var4;
      return var5;
   }
}
