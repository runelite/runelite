import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class115 extends TaskDataNode {
   @ObfuscatedName("t")
   int field1605;
   @ObfuscatedName("q")
   int field1599;
   @ObfuscatedName("i")
   int field1600;
   @ObfuscatedName("a")
   int field1601;
   @ObfuscatedName("l")
   int field1602;
   @ObfuscatedName("b")
   int field1603;
   @ObfuscatedName("e")
   int field1604;
   @ObfuscatedName("x")
   int field1610;
   @ObfuscatedName("p")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("g")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("n")
   boolean field1612;
   @ObfuscatedName("o")
   int field1609;
   @ObfuscatedName("c")
   int field1608;
   @ObfuscatedName("v")
   int field1611;
   @ObfuscatedName("u")
   int field1598;

   @ObfuscatedSignature(
      signature = "(Ldp;III)V"
   )
   class115(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1612 = var1.field1522;
      this.field1599 = var2;
      this.field1600 = var3;
      this.field1601 = var4;
      this.field1605 = 0;
      this.method2414();
   }

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   class115(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1612 = var1.field1522;
      this.field1599 = var2;
      this.field1600 = var3;
      this.field1601 = 8192;
      this.field1605 = 0;
      this.method2414();
   }

   @ObfuscatedName("l")
   void method2414() {
      this.field1602 = this.field1600;
      this.field1603 = method2344(this.field1600, this.field1601);
      this.field1604 = method2340(this.field1600, this.field1601);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4354() {
      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4356() {
      return null;
   }

   @ObfuscatedName("x")
   protected int vmethod4363() {
      return this.field1600 == 0 && this.field1609 == 0?0:1;
   }

   @ObfuscatedName("p")
   public synchronized void vmethod4357(int[] var1, int var2, int var3) {
      if(this.field1600 == 0 && this.field1609 == 0) {
         this.vmethod4367(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1610 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1605 < 0) {
            if(this.field1599 <= 0) {
               this.method2327();
               this.unlink();
               return;
            }

            this.field1605 = 0;
         }

         if(this.field1605 >= var7) {
            if(this.field1599 >= 0) {
               this.method2327();
               this.unlink();
               return;
            }

            this.field1605 = var7 - 1;
         }

         if(this.field1610 < 0) {
            if(this.field1612) {
               if(this.field1599 < 0) {
                  var9 = this.method2341(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var5 + var5 - 1 - this.field1605;
                  this.field1599 = -this.field1599;
               }

               while(true) {
                  var9 = this.method2369(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1605 < var6) {
                     return;
                  }

                  this.field1605 = var6 + var6 - 1 - this.field1605;
                  this.field1599 = -this.field1599;
                  var9 = this.method2341(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var5 + var5 - 1 - this.field1605;
                  this.field1599 = -this.field1599;
               }
            } else if(this.field1599 < 0) {
               while(true) {
                  var9 = this.method2341(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var6 - 1 - (var6 - 1 - this.field1605) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2369(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 < var6) {
                     return;
                  }

                  this.field1605 = var5 + (this.field1605 - var5) % var8;
               }
            }
         } else {
            if(this.field1610 > 0) {
               if(this.field1612) {
                  label120: {
                     if(this.field1599 < 0) {
                        var9 = this.method2341(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        this.field1605 = var5 + var5 - 1 - this.field1605;
                        this.field1599 = -this.field1599;
                        if(--this.field1610 == 0) {
                           break label120;
                        }
                     }

                     do {
                        var9 = this.method2369(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1605 < var6) {
                           return;
                        }

                        this.field1605 = var6 + var6 - 1 - this.field1605;
                        this.field1599 = -this.field1599;
                        if(--this.field1610 == 0) {
                           break;
                        }

                        var9 = this.method2341(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        this.field1605 = var5 + var5 - 1 - this.field1605;
                        this.field1599 = -this.field1599;
                     } while(--this.field1610 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1599 < 0) {
                     while(true) {
                        var9 = this.method2341(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1605) / var8;
                        if(var10 >= this.field1610) {
                           this.field1605 += var8 * this.field1610;
                           this.field1610 = 0;
                           break;
                        }

                        this.field1605 += var8 * var10;
                        this.field1610 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2369(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 < var6) {
                           return;
                        }

                        var10 = (this.field1605 - var5) / var8;
                        if(var10 >= this.field1610) {
                           this.field1605 -= var8 * this.field1610;
                           this.field1610 = 0;
                           break;
                        }

                        this.field1605 -= var8 * var10;
                        this.field1610 -= var10;
                     }
                  }
               }
            }

            if(this.field1599 < 0) {
               this.method2341(var1, var9, 0, var3, 0);
               if(this.field1605 < 0) {
                  this.field1605 = -1;
                  this.method2327();
                  this.unlink();
               }
            } else {
               this.method2369(var1, var9, var7, var3, 0);
               if(this.field1605 >= var7) {
                  this.field1605 = var7;
                  this.method2327();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   public synchronized void method2383(int var1) {
      this.field1610 = var1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod4367(int var1) {
      if(this.field1609 > 0) {
         if(var1 >= this.field1609) {
            if(this.field1600 == Integer.MIN_VALUE) {
               this.field1600 = 0;
               this.field1604 = 0;
               this.field1603 = 0;
               this.field1602 = 0;
               this.unlink();
               var1 = this.field1609;
            }

            this.field1609 = 0;
            this.method2414();
         } else {
            this.field1602 += this.field1608 * var1;
            this.field1603 += this.field1611 * var1;
            this.field1604 += this.field1598 * var1;
            this.field1609 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1610 = 0;
      }

      if(this.field1605 < 0) {
         if(this.field1599 <= 0) {
            this.method2327();
            this.unlink();
            return;
         }

         this.field1605 = 0;
      }

      if(this.field1605 >= var5) {
         if(this.field1599 >= 0) {
            this.method2327();
            this.unlink();
            return;
         }

         this.field1605 = var5 - 1;
      }

      this.field1605 += this.field1599 * var1;
      if(this.field1610 < 0) {
         if(!this.field1612) {
            if(this.field1599 < 0) {
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var4 - 1 - (var4 - 1 - this.field1605) % var6;
            } else {
               if(this.field1605 < var4) {
                  return;
               }

               this.field1605 = var3 + (this.field1605 - var3) % var6;
            }

         } else {
            if(this.field1599 < 0) {
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var3 + var3 - 1 - this.field1605;
               this.field1599 = -this.field1599;
            }

            while(this.field1605 >= var4) {
               this.field1605 = var4 + var4 - 1 - this.field1605;
               this.field1599 = -this.field1599;
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var3 + var3 - 1 - this.field1605;
               this.field1599 = -this.field1599;
            }

         }
      } else {
         if(this.field1610 > 0) {
            if(this.field1612) {
               label126: {
                  if(this.field1599 < 0) {
                     if(this.field1605 >= var3) {
                        return;
                     }

                     this.field1605 = var3 + var3 - 1 - this.field1605;
                     this.field1599 = -this.field1599;
                     if(--this.field1610 == 0) {
                        break label126;
                     }
                  }

                  do {
                     if(this.field1605 < var4) {
                        return;
                     }

                     this.field1605 = var4 + var4 - 1 - this.field1605;
                     this.field1599 = -this.field1599;
                     if(--this.field1610 == 0) {
                        break;
                     }

                     if(this.field1605 >= var3) {
                        return;
                     }

                     this.field1605 = var3 + var3 - 1 - this.field1605;
                     this.field1599 = -this.field1599;
                  } while(--this.field1610 != 0);
               }
            } else {
               label158: {
                  int var7;
                  if(this.field1599 < 0) {
                     if(this.field1605 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1605) / var6;
                     if(var7 >= this.field1610) {
                        this.field1605 += var6 * this.field1610;
                        this.field1610 = 0;
                        break label158;
                     }

                     this.field1605 += var6 * var7;
                     this.field1610 -= var7;
                  } else {
                     if(this.field1605 < var4) {
                        return;
                     }

                     var7 = (this.field1605 - var3) / var6;
                     if(var7 >= this.field1610) {
                        this.field1605 -= var6 * this.field1610;
                        this.field1610 = 0;
                        break label158;
                     }

                     this.field1605 -= var6 * var7;
                     this.field1610 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1599 < 0) {
            if(this.field1605 < 0) {
               this.field1605 = -1;
               this.method2327();
               this.unlink();
            }
         } else if(this.field1605 >= var5) {
            this.field1605 = var5;
            this.method2327();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("u")
   public synchronized void method2320(int var1) {
      this.method2322(var1 << 6, this.method2324());
   }

   @ObfuscatedName("k")
   synchronized void method2321(int var1) {
      this.method2322(var1, this.method2324());
   }

   @ObfuscatedName("z")
   synchronized void method2322(int var1, int var2) {
      this.field1600 = var1;
      this.field1601 = var2;
      this.field1609 = 0;
      this.method2414();
   }

   @ObfuscatedName("w")
   public synchronized int method2323() {
      return this.field1600 == Integer.MIN_VALUE?0:this.field1600;
   }

   @ObfuscatedName("s")
   public synchronized int method2324() {
      return this.field1601 < 0?-1:this.field1601;
   }

   @ObfuscatedName("d")
   public synchronized void method2325(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1605 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2326() {
      this.field1599 = (this.field1599 ^ this.field1599 >> 31) + (this.field1599 >>> 31);
      this.field1599 = -this.field1599;
   }

   @ObfuscatedName("r")
   void method2327() {
      if(this.field1609 != 0) {
         if(this.field1600 == Integer.MIN_VALUE) {
            this.field1600 = 0;
         }

         this.field1609 = 0;
         this.method2414();
      }

   }

   @ObfuscatedName("y")
   public synchronized void method2328(int var1, int var2) {
      this.method2329(var1, var2, this.method2324());
   }

   @ObfuscatedName("h")
   public synchronized void method2329(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2322(var2, var3);
      } else {
         int var4 = method2344(var2, var3);
         int var5 = method2340(var2, var3);
         if(var4 == this.field1603 && var5 == this.field1604) {
            this.field1609 = 0;
         } else {
            int var6 = var2 - this.field1602;
            if(this.field1602 - var2 > var6) {
               var6 = this.field1602 - var2;
            }

            if(var4 - this.field1603 > var6) {
               var6 = var4 - this.field1603;
            }

            if(this.field1603 - var4 > var6) {
               var6 = this.field1603 - var4;
            }

            if(var5 - this.field1604 > var6) {
               var6 = var5 - this.field1604;
            }

            if(this.field1604 - var5 > var6) {
               var6 = this.field1604 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1609 = var1;
            this.field1600 = var2;
            this.field1601 = var3;
            this.field1608 = (var2 - this.field1602) / var1;
            this.field1611 = (var4 - this.field1603) / var1;
            this.field1598 = (var5 - this.field1604) / var1;
         }
      }
   }

   @ObfuscatedName("av")
   public synchronized void method2330(int var1) {
      if(var1 == 0) {
         this.method2321(0);
         this.unlink();
      } else if(this.field1603 == 0 && this.field1604 == 0) {
         this.field1609 = 0;
         this.field1600 = 0;
         this.field1602 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1602;
         if(this.field1602 > var2) {
            var2 = this.field1602;
         }

         if(-this.field1603 > var2) {
            var2 = -this.field1603;
         }

         if(this.field1603 > var2) {
            var2 = this.field1603;
         }

         if(-this.field1604 > var2) {
            var2 = -this.field1604;
         }

         if(this.field1604 > var2) {
            var2 = this.field1604;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1609 = var1;
         this.field1600 = Integer.MIN_VALUE;
         this.field1608 = -this.field1602 / var1;
         this.field1611 = -this.field1603 / var1;
         this.field1598 = -this.field1604 / var1;
      }
   }

   @ObfuscatedName("an")
   public synchronized void method2427(int var1) {
      if(this.field1599 < 0) {
         this.field1599 = -var1;
      } else {
         this.field1599 = var1;
      }

   }

   @ObfuscatedName("ai")
   public synchronized int method2332() {
      return this.field1599 < 0?-this.field1599:this.field1599;
   }

   @ObfuscatedName("ag")
   public boolean method2392() {
      return this.field1605 < 0 || this.field1605 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("as")
   public boolean method2334() {
      return this.field1609 != 0;
   }

   @ObfuscatedName("aw")
   int vmethod2489() {
      int var1 = this.field1602 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1610 == 0) {
         var1 -= var1 * this.field1605 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1610 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("aq")
   int method2369(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1609 > 0) {
            int var6 = var2 + this.field1609;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1609 += var2;
            if(this.field1599 == 256 && (this.field1605 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2397(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, this.field1611, this.field1598, 0, var6, var3, this);
               } else {
                  var2 = method2351(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, this.field1608, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2356(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, this.field1611, this.field1598, 0, var6, var3, this, this.field1599, var5);
            } else {
               var2 = method2355(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, this.field1608, 0, var6, var3, this, this.field1599, var5);
            }

            this.field1609 -= var2;
            if(this.field1609 != 0) {
               return var2;
            }

            if(!this.method2342()) {
               continue;
            }

            return var4;
         }

         if(this.field1599 == 256 && (this.field1605 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2399(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, 0, var4, var3, this);
            }

            return method2343(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2413(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, 0, var4, var3, this, this.field1599, var5);
         }

         return method2347(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, 0, var4, var3, this, this.field1599, var5);
      }
   }

   @ObfuscatedName("aa")
   int method2341(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1609 > 0) {
            int var6 = var2 + this.field1609;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1609 += var2;
            if(this.field1599 == -256 && (this.field1605 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2353(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, this.field1611, this.field1598, 0, var6, var3, this);
               } else {
                  var2 = method2378(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, this.field1608, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2358(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, this.field1611, this.field1598, 0, var6, var3, this, this.field1599, var5);
            } else {
               var2 = method2357(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, this.field1608, 0, var6, var3, this, this.field1599, var5);
            }

            this.field1609 -= var2;
            if(this.field1609 != 0) {
               return var2;
            }

            if(!this.method2342()) {
               continue;
            }

            return var4;
         }

         if(this.field1599 == -256 && (this.field1605 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2346(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, 0, var4, var3, this);
            }

            return method2423(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2350(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1603, this.field1604, 0, var4, var3, this, this.field1599, var5);
         }

         return method2424(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1602, 0, var4, var3, this, this.field1599, var5);
      }
   }

   @ObfuscatedName("af")
   boolean method2342() {
      int var1 = this.field1600;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2344(var1, this.field1601);
         var3 = method2340(var1, this.field1601);
      }

      if(var1 == this.field1602 && var2 == this.field1603 && var3 == this.field1604) {
         if(this.field1600 == Integer.MIN_VALUE) {
            this.field1600 = 0;
            this.field1604 = 0;
            this.field1603 = 0;
            this.field1602 = 0;
            this.unlink();
            return true;
         } else {
            this.method2414();
            return false;
         }
      } else {
         if(this.field1602 < var1) {
            this.field1608 = 1;
            this.field1609 = var1 - this.field1602;
         } else if(this.field1602 > var1) {
            this.field1608 = -1;
            this.field1609 = this.field1602 - var1;
         } else {
            this.field1608 = 0;
         }

         if(this.field1603 < var2) {
            this.field1611 = 1;
            if(this.field1609 == 0 || this.field1609 > var2 - this.field1603) {
               this.field1609 = var2 - this.field1603;
            }
         } else if(this.field1603 > var2) {
            this.field1611 = -1;
            if(this.field1609 == 0 || this.field1609 > this.field1603 - var2) {
               this.field1609 = this.field1603 - var2;
            }
         } else {
            this.field1611 = 0;
         }

         if(this.field1604 < var3) {
            this.field1598 = 1;
            if(this.field1609 == 0 || this.field1609 > var3 - this.field1604) {
               this.field1609 = var3 - this.field1604;
            }
         } else if(this.field1604 > var3) {
            this.field1598 = -1;
            if(this.field1609 == 0 || this.field1609 > this.field1604 - var3) {
               this.field1609 = this.field1604 - var3;
            }
         } else {
            this.field1598 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("t")
   static int method2344(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   static int method2340(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldp;II)Ldy;"
   )
   public static class115 method2316(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldp;III)Ldy;"
   )
   public static class115 method2317(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdy;)I"
   )
   static int method2343(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdy;)I"
   )
   static int method2399(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdy;)I"
   )
   static int method2423(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdy;)I"
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

      var10.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdy;II)I"
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

      var10.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdy;II)I"
   )
   static int method2413(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1605 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdy;II)I"
   )
   static int method2424(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdy;II)I"
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

      var11.field1605 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdy;)I"
   )
   static int method2351(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1603 += var9.field1611 * (var6 - var3);
      var9.field1604 += var9.field1598 * (var6 - var3);

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

      var9.field1602 = var4 >> 2;
      var9.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdy;)I"
   )
   static int method2397(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1602 += var12.field1608 * (var9 - var4);
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

      var12.field1603 = var5 >> 2;
      var12.field1604 = var6 >> 2;
      var12.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdy;)I"
   )
   static int method2378(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1603 += var9.field1611 * (var6 - var3);
      var9.field1604 += var9.field1598 * (var6 - var3);

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

      var9.field1602 = var4 >> 2;
      var9.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdy;)I"
   )
   static int method2353(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1602 += var12.field1608 * (var9 - var4);
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

      var12.field1603 = var5 >> 2;
      var12.field1604 = var6 >> 2;
      var12.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdy;II)I"
   )
   static int method2355(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1603 -= var11.field1611 * var5;
      var11.field1604 -= var11.field1598 * var5;
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

      var11.field1603 += var11.field1611 * var5;
      var11.field1604 += var11.field1598 * var5;
      var11.field1602 = var6;
      var11.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdy;II)I"
   )
   static int method2356(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1602 -= var5 * var13.field1608;
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
      var13.field1602 += var13.field1608 * var5;
      var13.field1603 = var6;
      var13.field1604 = var7;
      var13.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdy;II)I"
   )
   static int method2357(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1603 -= var11.field1611 * var5;
      var11.field1604 -= var11.field1598 * var5;
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

      var11.field1603 += var11.field1611 * var5;
      var11.field1604 += var11.field1598 * var5;
      var11.field1602 = var6;
      var11.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdy;II)I"
   )
   static int method2358(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1602 -= var5 * var13.field1608;
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
      var13.field1602 += var13.field1608 * var5;
      var13.field1603 = var6;
      var13.field1604 = var7;
      var13.field1605 = var4;
      return var5;
   }
}
