import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class115 extends TaskDataNode {
   @ObfuscatedName("o")
   int field1638;
   @ObfuscatedName("k")
   int field1631;
   @ObfuscatedName("t")
   int field1630;
   @ObfuscatedName("d")
   int field1633;
   @ObfuscatedName("h")
   int field1634;
   @ObfuscatedName("m")
   int field1635;
   @ObfuscatedName("z")
   int field1641;
   @ObfuscatedName("i")
   int field1637;
   @ObfuscatedName("u")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("x")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("y")
   boolean field1640;
   @ObfuscatedName("a")
   int field1639;
   @ObfuscatedName("n")
   int field1636;
   @ObfuscatedName("l")
   int field1643;
   @ObfuscatedName("s")
   int field1644;

   @ObfuscatedSignature(
      signature = "(Ldp;III)V"
   )
   class115(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1640 = var1.field1548;
      this.field1631 = var2;
      this.field1630 = var3;
      this.field1633 = var4;
      this.field1638 = 0;
      this.method2319();
   }

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   class115(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1640 = var1.field1548;
      this.field1631 = var2;
      this.field1630 = var3;
      this.field1633 = 8192;
      this.field1638 = 0;
      this.method2319();
   }

   @ObfuscatedName("h")
   void method2319() {
      this.field1634 = this.field1630;
      this.field1635 = method2441(this.field1630, this.field1633);
      this.field1641 = method2314(this.field1630, this.field1633);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4330() {
      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4321() {
      return null;
   }

   @ObfuscatedName("i")
   protected int vmethod4314() {
      return this.field1630 == 0 && this.field1639 == 0?0:1;
   }

   @ObfuscatedName("u")
   public synchronized void vmethod4317(int[] var1, int var2, int var3) {
      if(this.field1630 == 0 && this.field1639 == 0) {
         this.vmethod4319(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1637 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1638 < 0) {
            if(this.field1631 <= 0) {
               this.method2328();
               this.unlink();
               return;
            }

            this.field1638 = 0;
         }

         if(this.field1638 >= var7) {
            if(this.field1631 >= 0) {
               this.method2328();
               this.unlink();
               return;
            }

            this.field1638 = var7 - 1;
         }

         if(this.field1637 < 0) {
            if(this.field1640) {
               if(this.field1631 < 0) {
                  var9 = this.method2408(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1638 >= var5) {
                     return;
                  }

                  this.field1638 = var5 + var5 - 1 - this.field1638;
                  this.field1631 = -this.field1631;
               }

               while(true) {
                  var9 = this.method2340(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1638 < var6) {
                     return;
                  }

                  this.field1638 = var6 + var6 - 1 - this.field1638;
                  this.field1631 = -this.field1631;
                  var9 = this.method2408(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1638 >= var5) {
                     return;
                  }

                  this.field1638 = var5 + var5 - 1 - this.field1638;
                  this.field1631 = -this.field1631;
               }
            } else if(this.field1631 < 0) {
               while(true) {
                  var9 = this.method2408(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1638 >= var5) {
                     return;
                  }

                  this.field1638 = var6 - 1 - (var6 - 1 - this.field1638) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2340(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1638 < var6) {
                     return;
                  }

                  this.field1638 = var5 + (this.field1638 - var5) % var8;
               }
            }
         } else {
            if(this.field1637 > 0) {
               if(this.field1640) {
                  label139: {
                     if(this.field1631 < 0) {
                        var9 = this.method2408(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1638 >= var5) {
                           return;
                        }

                        this.field1638 = var5 + var5 - 1 - this.field1638;
                        this.field1631 = -this.field1631;
                        if(--this.field1637 == 0) {
                           break label139;
                        }
                     }

                     do {
                        var9 = this.method2340(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1638 < var6) {
                           return;
                        }

                        this.field1638 = var6 + var6 - 1 - this.field1638;
                        this.field1631 = -this.field1631;
                        if(--this.field1637 == 0) {
                           break;
                        }

                        var9 = this.method2408(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1638 >= var5) {
                           return;
                        }

                        this.field1638 = var5 + var5 - 1 - this.field1638;
                        this.field1631 = -this.field1631;
                     } while(--this.field1637 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1631 < 0) {
                     while(true) {
                        var9 = this.method2408(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1638 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1638) / var8;
                        if(var10 >= this.field1637) {
                           this.field1638 += var8 * this.field1637;
                           this.field1637 = 0;
                           break;
                        }

                        this.field1638 += var8 * var10;
                        this.field1637 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2340(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1638 < var6) {
                           return;
                        }

                        var10 = (this.field1638 - var5) / var8;
                        if(var10 >= this.field1637) {
                           this.field1638 -= var8 * this.field1637;
                           this.field1637 = 0;
                           break;
                        }

                        this.field1638 -= var8 * var10;
                        this.field1637 -= var10;
                     }
                  }
               }
            }

            if(this.field1631 < 0) {
               this.method2408(var1, var9, 0, var3, 0);
               if(this.field1638 < 0) {
                  this.field1638 = -1;
                  this.method2328();
                  this.unlink();
               }
            } else {
               this.method2340(var1, var9, var7, var3, 0);
               if(this.field1638 >= var7) {
                  this.field1638 = var7;
                  this.method2328();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   public synchronized void method2320(int var1) {
      this.field1637 = var1;
   }

   @ObfuscatedName("y")
   public synchronized void vmethod4319(int var1) {
      if(this.field1639 > 0) {
         if(var1 >= this.field1639) {
            if(this.field1630 == Integer.MIN_VALUE) {
               this.field1630 = 0;
               this.field1641 = 0;
               this.field1635 = 0;
               this.field1634 = 0;
               this.unlink();
               var1 = this.field1639;
            }

            this.field1639 = 0;
            this.method2319();
         } else {
            this.field1634 += this.field1636 * var1;
            this.field1635 += this.field1643 * var1;
            this.field1641 += this.field1644 * var1;
            this.field1639 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1637 = 0;
      }

      if(this.field1638 < 0) {
         if(this.field1631 <= 0) {
            this.method2328();
            this.unlink();
            return;
         }

         this.field1638 = 0;
      }

      if(this.field1638 >= var5) {
         if(this.field1631 >= 0) {
            this.method2328();
            this.unlink();
            return;
         }

         this.field1638 = var5 - 1;
      }

      this.field1638 += this.field1631 * var1;
      if(this.field1637 < 0) {
         if(!this.field1640) {
            if(this.field1631 < 0) {
               if(this.field1638 >= var3) {
                  return;
               }

               this.field1638 = var4 - 1 - (var4 - 1 - this.field1638) % var6;
            } else {
               if(this.field1638 < var4) {
                  return;
               }

               this.field1638 = var3 + (this.field1638 - var3) % var6;
            }

         } else {
            if(this.field1631 < 0) {
               if(this.field1638 >= var3) {
                  return;
               }

               this.field1638 = var3 + var3 - 1 - this.field1638;
               this.field1631 = -this.field1631;
            }

            while(this.field1638 >= var4) {
               this.field1638 = var4 + var4 - 1 - this.field1638;
               this.field1631 = -this.field1631;
               if(this.field1638 >= var3) {
                  return;
               }

               this.field1638 = var3 + var3 - 1 - this.field1638;
               this.field1631 = -this.field1631;
            }

         }
      } else {
         if(this.field1637 > 0) {
            if(this.field1640) {
               label127: {
                  if(this.field1631 < 0) {
                     if(this.field1638 >= var3) {
                        return;
                     }

                     this.field1638 = var3 + var3 - 1 - this.field1638;
                     this.field1631 = -this.field1631;
                     if(--this.field1637 == 0) {
                        break label127;
                     }
                  }

                  do {
                     if(this.field1638 < var4) {
                        return;
                     }

                     this.field1638 = var4 + var4 - 1 - this.field1638;
                     this.field1631 = -this.field1631;
                     if(--this.field1637 == 0) {
                        break;
                     }

                     if(this.field1638 >= var3) {
                        return;
                     }

                     this.field1638 = var3 + var3 - 1 - this.field1638;
                     this.field1631 = -this.field1631;
                  } while(--this.field1637 != 0);
               }
            } else {
               int var7;
               if(this.field1631 < 0) {
                  if(this.field1638 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1638) / var6;
                  if(var7 < this.field1637) {
                     this.field1638 += var6 * var7;
                     this.field1637 -= var7;
                     return;
                  }

                  this.field1638 += var6 * this.field1637;
                  this.field1637 = 0;
               } else {
                  if(this.field1638 < var4) {
                     return;
                  }

                  var7 = (this.field1638 - var3) / var6;
                  if(var7 < this.field1637) {
                     this.field1638 -= var6 * var7;
                     this.field1637 -= var7;
                     return;
                  }

                  this.field1638 -= var6 * this.field1637;
                  this.field1637 = 0;
               }
            }
         }

         if(this.field1631 < 0) {
            if(this.field1638 < 0) {
               this.field1638 = -1;
               this.method2328();
               this.unlink();
            }
         } else if(this.field1638 >= var5) {
            this.field1638 = var5;
            this.method2328();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("a")
   public synchronized void method2321(int var1) {
      this.method2323(var1 << 6, this.method2336());
   }

   @ObfuscatedName("v")
   synchronized void method2322(int var1) {
      this.method2323(var1, this.method2336());
   }

   @ObfuscatedName("q")
   synchronized void method2323(int var1, int var2) {
      this.field1630 = var1;
      this.field1633 = var2;
      this.field1639 = 0;
      this.method2319();
   }

   @ObfuscatedName("r")
   public synchronized int method2392() {
      return this.field1630 == Integer.MIN_VALUE?0:this.field1630;
   }

   @ObfuscatedName("j")
   public synchronized int method2336() {
      return this.field1633 < 0?-1:this.field1633;
   }

   @ObfuscatedName("b")
   public synchronized void method2315(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1638 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2327() {
      this.field1631 = (this.field1631 ^ this.field1631 >> 31) + (this.field1631 >>> 31);
      this.field1631 = -this.field1631;
   }

   @ObfuscatedName("f")
   void method2328() {
      if(this.field1639 != 0) {
         if(this.field1630 == Integer.MIN_VALUE) {
            this.field1630 = 0;
         }

         this.field1639 = 0;
         this.method2319();
      }

   }

   @ObfuscatedName("p")
   public synchronized void method2352(int var1, int var2) {
      this.method2330(var1, var2, this.method2336());
   }

   @ObfuscatedName("e")
   public synchronized void method2330(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2323(var2, var3);
      } else {
         int var4 = method2441(var2, var3);
         int var5 = method2314(var2, var3);
         if(var4 == this.field1635 && var5 == this.field1641) {
            this.field1639 = 0;
         } else {
            int var6 = var2 - this.field1634;
            if(this.field1634 - var2 > var6) {
               var6 = this.field1634 - var2;
            }

            if(var4 - this.field1635 > var6) {
               var6 = var4 - this.field1635;
            }

            if(this.field1635 - var4 > var6) {
               var6 = this.field1635 - var4;
            }

            if(var5 - this.field1641 > var6) {
               var6 = var5 - this.field1641;
            }

            if(this.field1641 - var5 > var6) {
               var6 = this.field1641 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1639 = var1;
            this.field1630 = var2;
            this.field1633 = var3;
            this.field1636 = (var2 - this.field1634) / var1;
            this.field1643 = (var4 - this.field1635) / var1;
            this.field1644 = (var5 - this.field1641) / var1;
         }
      }
   }

   @ObfuscatedName("c")
   public synchronized void method2363(int var1) {
      if(var1 == 0) {
         this.method2322(0);
         this.unlink();
      } else if(this.field1635 == 0 && this.field1641 == 0) {
         this.field1639 = 0;
         this.field1630 = 0;
         this.field1634 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1634;
         if(this.field1634 > var2) {
            var2 = this.field1634;
         }

         if(-this.field1635 > var2) {
            var2 = -this.field1635;
         }

         if(this.field1635 > var2) {
            var2 = this.field1635;
         }

         if(-this.field1641 > var2) {
            var2 = -this.field1641;
         }

         if(this.field1641 > var2) {
            var2 = this.field1641;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1639 = var1;
         this.field1630 = Integer.MIN_VALUE;
         this.field1636 = -this.field1634 / var1;
         this.field1643 = -this.field1635 / var1;
         this.field1644 = -this.field1641 / var1;
      }
   }

   @ObfuscatedName("ag")
   public synchronized void method2332(int var1) {
      if(this.field1631 < 0) {
         this.field1631 = -var1;
      } else {
         this.field1631 = var1;
      }

   }

   @ObfuscatedName("at")
   public synchronized int method2374() {
      return this.field1631 < 0?-this.field1631:this.field1631;
   }

   @ObfuscatedName("av")
   public boolean method2399() {
      return this.field1638 < 0 || this.field1638 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("am")
   public boolean method2335() {
      return this.field1639 != 0;
   }

   @ObfuscatedName("ao")
   int method2340(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1639 > 0) {
            int var6 = var2 + this.field1639;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1639 += var2;
            if(this.field1631 == 256 && (this.field1638 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2396(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, this.field1643, this.field1644, 0, var6, var3, this);
               } else {
                  var2 = method2376(((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, this.field1636, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2356(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, this.field1643, this.field1644, 0, var6, var3, this, this.field1631, var5);
            } else {
               var2 = method2355(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, this.field1636, 0, var6, var3, this, this.field1631, var5);
            }

            this.field1639 -= var2;
            if(this.field1639 != 0) {
               return var2;
            }

            if(!this.method2343()) {
               continue;
            }

            return var4;
         }

         if(this.field1631 == 256 && (this.field1638 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2331(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, 0, var4, var3, this);
            }

            return method2344(((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2348(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, 0, var4, var3, this, this.field1631, var5);
         }

         return method2347(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, 0, var4, var3, this, this.field1631, var5);
      }
   }

   @ObfuscatedName("ax")
   int method2408(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1639 > 0) {
            int var6 = var2 + this.field1639;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1639 += var2;
            if(this.field1631 == -256 && (this.field1638 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2354(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, this.field1643, this.field1644, 0, var6, var3, this);
               } else {
                  var2 = method2342(((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, this.field1636, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2463(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, this.field1643, this.field1644, 0, var6, var3, this, this.field1631, var5);
            } else {
               var2 = method2357(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, this.field1636, 0, var6, var3, this, this.field1631, var5);
            }

            this.field1639 -= var2;
            if(this.field1639 != 0) {
               return var2;
            }

            if(!this.method2343()) {
               continue;
            }

            return var4;
         }

         if(this.field1631 == -256 && (this.field1638 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2346(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, 0, var4, var3, this);
            }

            return method2345(((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2350(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1635, this.field1641, 0, var4, var3, this, this.field1631, var5);
         }

         return method2349(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1638, var2, this.field1634, 0, var4, var3, this, this.field1631, var5);
      }
   }

   @ObfuscatedName("au")
   boolean method2343() {
      int var1 = this.field1630;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2441(var1, this.field1633);
         var3 = method2314(var1, this.field1633);
      }

      if(var1 == this.field1634 && var2 == this.field1635 && var3 == this.field1641) {
         if(this.field1630 == Integer.MIN_VALUE) {
            this.field1630 = 0;
            this.field1641 = 0;
            this.field1635 = 0;
            this.field1634 = 0;
            this.unlink();
            return true;
         } else {
            this.method2319();
            return false;
         }
      } else {
         if(this.field1634 < var1) {
            this.field1636 = 1;
            this.field1639 = var1 - this.field1634;
         } else if(this.field1634 > var1) {
            this.field1636 = -1;
            this.field1639 = this.field1634 - var1;
         } else {
            this.field1636 = 0;
         }

         if(this.field1635 < var2) {
            this.field1643 = 1;
            if(this.field1639 == 0 || this.field1639 > var2 - this.field1635) {
               this.field1639 = var2 - this.field1635;
            }
         } else if(this.field1635 > var2) {
            this.field1643 = -1;
            if(this.field1639 == 0 || this.field1639 > this.field1635 - var2) {
               this.field1639 = this.field1635 - var2;
            }
         } else {
            this.field1643 = 0;
         }

         if(this.field1641 < var3) {
            this.field1644 = 1;
            if(this.field1639 == 0 || this.field1639 > var3 - this.field1641) {
               this.field1639 = var3 - this.field1641;
            }
         } else if(this.field1641 > var3) {
            this.field1644 = -1;
            if(this.field1639 == 0 || this.field1639 > this.field1641 - var3) {
               this.field1639 = this.field1641 - var3;
            }
         } else {
            this.field1644 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ae")
   int vmethod2491() {
      int var1 = this.field1634 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1637 == 0) {
         var1 -= var1 * this.field1638 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1637 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("o")
   static int method2441(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("k")
   static int method2314(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ldp;II)Lda;"
   )
   public static class115 method2317(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldp;III)Lda;"
   )
   public static class115 method2318(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILda;)I"
   )
   static int method2344(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1638 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILda;)I"
   )
   static int method2331(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1638 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILda;)I"
   )
   static int method2345(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1638 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILda;)I"
   )
   static int method2346(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1638 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILda;II)I"
   )
   static int method2347(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1638 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method2348(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1638 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILda;II)I"
   )
   static int method2349(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1638 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method2350(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1638 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILda;)I"
   )
   static int method2376(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1635 += var9.field1643 * (var6 - var3);
      var9.field1641 += var9.field1644 * (var6 - var3);

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

      var9.field1634 = var4 >> 2;
      var9.field1638 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILda;)I"
   )
   static int method2396(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1634 += var12.field1636 * (var9 - var4);
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

      var12.field1635 = var5 >> 2;
      var12.field1641 = var6 >> 2;
      var12.field1638 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILda;)I"
   )
   static int method2342(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1635 += var9.field1643 * (var6 - var3);
      var9.field1641 += var9.field1644 * (var6 - var3);

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

      var9.field1634 = var4 >> 2;
      var9.field1638 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILda;)I"
   )
   static int method2354(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1634 += var12.field1636 * (var9 - var4);
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

      var12.field1635 = var5 >> 2;
      var12.field1641 = var6 >> 2;
      var12.field1638 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method2355(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1635 -= var11.field1643 * var5;
      var11.field1641 -= var11.field1644 * var5;
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

      var11.field1635 += var11.field1643 * var5;
      var11.field1641 += var11.field1644 * var5;
      var11.field1634 = var6;
      var11.field1638 = var4;
      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILda;II)I"
   )
   static int method2356(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1634 -= var5 * var13.field1636;
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
      var13.field1634 += var13.field1636 * var5;
      var13.field1635 = var6;
      var13.field1641 = var7;
      var13.field1638 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method2357(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1635 -= var11.field1643 * var5;
      var11.field1641 -= var11.field1644 * var5;
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

      var11.field1635 += var11.field1643 * var5;
      var11.field1641 += var11.field1644 * var5;
      var11.field1634 = var6;
      var11.field1638 = var4;
      return var5;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILda;II)I"
   )
   static int method2463(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1634 -= var5 * var13.field1636;
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
      var13.field1634 += var13.field1636 * var5;
      var13.field1635 = var6;
      var13.field1641 = var7;
      var13.field1638 = var4;
      return var5;
   }
}
