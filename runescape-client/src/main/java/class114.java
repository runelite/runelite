import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class114 extends TaskDataNode {
   @ObfuscatedName("b")
   int field1575;
   @ObfuscatedName("q")
   int field1574;
   @ObfuscatedName("o")
   int field1579;
   @ObfuscatedName("p")
   int field1578;
   @ObfuscatedName("a")
   int field1576;
   @ObfuscatedName("h")
   int field1580;
   @ObfuscatedName("l")
   int field1573;
   @ObfuscatedName("y")
   int field1581;
   @ObfuscatedName("g")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("c")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("u")
   boolean field1583;
   @ObfuscatedName("r")
   int field1584;
   @ObfuscatedName("d")
   int field1585;
   @ObfuscatedName("v")
   int field1586;
   @ObfuscatedName("s")
   int field1587;

   @ObfuscatedSignature(
      signature = "(Ldb;III)V"
   )
   class114(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1583 = var1.field1497;
      this.field1574 = var2;
      this.field1579 = var3;
      this.field1578 = var4;
      this.field1575 = 0;
      this.method2317();
   }

   @ObfuscatedSignature(
      signature = "(Ldb;II)V"
   )
   class114(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1583 = var1.field1497;
      this.field1574 = var2;
      this.field1579 = var3;
      this.field1578 = 8192;
      this.field1575 = 0;
      this.method2317();
   }

   @ObfuscatedName("a")
   void method2317() {
      this.field1576 = this.field1579;
      this.field1580 = method2321(this.field1579, this.field1578);
      this.field1573 = method2350(this.field1579, this.field1578);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4324() {
      return null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4323() {
      return null;
   }

   @ObfuscatedName("y")
   protected int vmethod4326() {
      return this.field1579 == 0 && this.field1584 == 0?0:1;
   }

   @ObfuscatedName("g")
   public synchronized void vmethod4344(int[] var1, int var2, int var3) {
      if(this.field1579 == 0 && this.field1584 == 0) {
         this.vmethod4328(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1581 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1575 < 0) {
            if(this.field1574 <= 0) {
               this.method2405();
               this.unlink();
               return;
            }

            this.field1575 = 0;
         }

         if(this.field1575 >= var7) {
            if(this.field1574 >= 0) {
               this.method2405();
               this.unlink();
               return;
            }

            this.field1575 = var7 - 1;
         }

         if(this.field1581 < 0) {
            if(this.field1583) {
               if(this.field1574 < 0) {
                  var9 = this.method2340(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1575 >= var5) {
                     return;
                  }

                  this.field1575 = var5 + var5 - 1 - this.field1575;
                  this.field1574 = -this.field1574;
               }

               while(true) {
                  var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1575 < var6) {
                     return;
                  }

                  this.field1575 = var6 + var6 - 1 - this.field1575;
                  this.field1574 = -this.field1574;
                  var9 = this.method2340(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1575 >= var5) {
                     return;
                  }

                  this.field1575 = var5 + var5 - 1 - this.field1575;
                  this.field1574 = -this.field1574;
               }
            } else if(this.field1574 < 0) {
               while(true) {
                  var9 = this.method2340(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1575 >= var5) {
                     return;
                  }

                  this.field1575 = var6 - 1 - (var6 - 1 - this.field1575) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1575 < var6) {
                     return;
                  }

                  this.field1575 = var5 + (this.field1575 - var5) % var8;
               }
            }
         } else {
            if(this.field1581 > 0) {
               if(this.field1583) {
                  label138: {
                     if(this.field1574 < 0) {
                        var9 = this.method2340(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1575 >= var5) {
                           return;
                        }

                        this.field1575 = var5 + var5 - 1 - this.field1575;
                        this.field1574 = -this.field1574;
                        if(--this.field1581 == 0) {
                           break label138;
                        }
                     }

                     do {
                        var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1575 < var6) {
                           return;
                        }

                        this.field1575 = var6 + var6 - 1 - this.field1575;
                        this.field1574 = -this.field1574;
                        if(--this.field1581 == 0) {
                           break;
                        }

                        var9 = this.method2340(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1575 >= var5) {
                           return;
                        }

                        this.field1575 = var5 + var5 - 1 - this.field1575;
                        this.field1574 = -this.field1574;
                     } while(--this.field1581 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1574 < 0) {
                     while(true) {
                        var9 = this.method2340(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1575 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1575) / var8;
                        if(var10 >= this.field1581) {
                           this.field1575 += var8 * this.field1581;
                           this.field1581 = 0;
                           break;
                        }

                        this.field1575 += var8 * var10;
                        this.field1581 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1575 < var6) {
                           return;
                        }

                        var10 = (this.field1575 - var5) / var8;
                        if(var10 >= this.field1581) {
                           this.field1575 -= var8 * this.field1581;
                           this.field1581 = 0;
                           break;
                        }

                        this.field1575 -= var8 * var10;
                        this.field1581 -= var10;
                     }
                  }
               }
            }

            if(this.field1574 < 0) {
               this.method2340(var1, var9, 0, var3, 0);
               if(this.field1575 < 0) {
                  this.field1575 = -1;
                  this.method2405();
                  this.unlink();
               }
            } else {
               this.method2339(var1, var9, var7, var3, 0);
               if(this.field1575 >= var7) {
                  this.field1575 = var7;
                  this.method2405();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   public synchronized void method2318(int var1) {
      this.field1581 = var1;
   }

   @ObfuscatedName("u")
   public synchronized void vmethod4328(int var1) {
      if(this.field1584 > 0) {
         if(var1 >= this.field1584) {
            if(this.field1579 == Integer.MIN_VALUE) {
               this.field1579 = 0;
               this.field1573 = 0;
               this.field1580 = 0;
               this.field1576 = 0;
               this.unlink();
               var1 = this.field1584;
            }

            this.field1584 = 0;
            this.method2317();
         } else {
            this.field1576 += this.field1585 * var1;
            this.field1580 += this.field1586 * var1;
            this.field1573 += this.field1587 * var1;
            this.field1584 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1581 = 0;
      }

      if(this.field1575 < 0) {
         if(this.field1574 <= 0) {
            this.method2405();
            this.unlink();
            return;
         }

         this.field1575 = 0;
      }

      if(this.field1575 >= var5) {
         if(this.field1574 >= 0) {
            this.method2405();
            this.unlink();
            return;
         }

         this.field1575 = var5 - 1;
      }

      this.field1575 += this.field1574 * var1;
      if(this.field1581 < 0) {
         if(!this.field1583) {
            if(this.field1574 < 0) {
               if(this.field1575 >= var3) {
                  return;
               }

               this.field1575 = var4 - 1 - (var4 - 1 - this.field1575) % var6;
            } else {
               if(this.field1575 < var4) {
                  return;
               }

               this.field1575 = var3 + (this.field1575 - var3) % var6;
            }

         } else {
            if(this.field1574 < 0) {
               if(this.field1575 >= var3) {
                  return;
               }

               this.field1575 = var3 + var3 - 1 - this.field1575;
               this.field1574 = -this.field1574;
            }

            while(this.field1575 >= var4) {
               this.field1575 = var4 + var4 - 1 - this.field1575;
               this.field1574 = -this.field1574;
               if(this.field1575 >= var3) {
                  return;
               }

               this.field1575 = var3 + var3 - 1 - this.field1575;
               this.field1574 = -this.field1574;
            }

         }
      } else {
         if(this.field1581 > 0) {
            if(this.field1583) {
               label127: {
                  if(this.field1574 < 0) {
                     if(this.field1575 >= var3) {
                        return;
                     }

                     this.field1575 = var3 + var3 - 1 - this.field1575;
                     this.field1574 = -this.field1574;
                     if(--this.field1581 == 0) {
                        break label127;
                     }
                  }

                  do {
                     if(this.field1575 < var4) {
                        return;
                     }

                     this.field1575 = var4 + var4 - 1 - this.field1575;
                     this.field1574 = -this.field1574;
                     if(--this.field1581 == 0) {
                        break;
                     }

                     if(this.field1575 >= var3) {
                        return;
                     }

                     this.field1575 = var3 + var3 - 1 - this.field1575;
                     this.field1574 = -this.field1574;
                  } while(--this.field1581 != 0);
               }
            } else {
               int var7;
               if(this.field1574 < 0) {
                  if(this.field1575 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1575) / var6;
                  if(var7 < this.field1581) {
                     this.field1575 += var6 * var7;
                     this.field1581 -= var7;
                     return;
                  }

                  this.field1575 += var6 * this.field1581;
                  this.field1581 = 0;
               } else {
                  if(this.field1575 < var4) {
                     return;
                  }

                  var7 = (this.field1575 - var3) / var6;
                  if(var7 < this.field1581) {
                     this.field1575 -= var6 * var7;
                     this.field1581 -= var7;
                     return;
                  }

                  this.field1575 -= var6 * this.field1581;
                  this.field1581 = 0;
               }
            }
         }

         if(this.field1574 < 0) {
            if(this.field1575 < 0) {
               this.field1575 = -1;
               this.method2405();
               this.unlink();
            }
         } else if(this.field1575 >= var5) {
            this.field1575 = var5;
            this.method2405();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("t")
   public synchronized void method2319(int var1) {
      this.method2325(var1 << 6, this.method2323());
   }

   @ObfuscatedName("f")
   synchronized void method2320(int var1) {
      this.method2325(var1, this.method2323());
   }

   @ObfuscatedName("m")
   synchronized void method2325(int var1, int var2) {
      this.field1579 = var1;
      this.field1578 = var2;
      this.field1584 = 0;
      this.method2317();
   }

   @ObfuscatedName("x")
   public synchronized int method2322() {
      return this.field1579 == Integer.MIN_VALUE?0:this.field1579;
   }

   @ObfuscatedName("w")
   public synchronized int method2323() {
      return this.field1578 < 0?-1:this.field1578;
   }

   @ObfuscatedName("j")
   public synchronized void method2349(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1575 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2324() {
      this.field1574 = (this.field1574 ^ this.field1574 >> 31) + (this.field1574 >>> 31);
      this.field1574 = -this.field1574;
   }

   @ObfuscatedName("e")
   void method2405() {
      if(this.field1584 != 0) {
         if(this.field1579 == Integer.MIN_VALUE) {
            this.field1579 = 0;
         }

         this.field1584 = 0;
         this.method2317();
      }

   }

   @ObfuscatedName("k")
   public synchronized void method2454(int var1, int var2) {
      this.method2328(var1, var2, this.method2323());
   }

   @ObfuscatedName("ao")
   public synchronized void method2328(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2325(var2, var3);
      } else {
         int var4 = method2321(var2, var3);
         int var5 = method2350(var2, var3);
         if(var4 == this.field1580 && var5 == this.field1573) {
            this.field1584 = 0;
         } else {
            int var6 = var2 - this.field1576;
            if(this.field1576 - var2 > var6) {
               var6 = this.field1576 - var2;
            }

            if(var4 - this.field1580 > var6) {
               var6 = var4 - this.field1580;
            }

            if(this.field1580 - var4 > var6) {
               var6 = this.field1580 - var4;
            }

            if(var5 - this.field1573 > var6) {
               var6 = var5 - this.field1573;
            }

            if(this.field1573 - var5 > var6) {
               var6 = this.field1573 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1584 = var1;
            this.field1579 = var2;
            this.field1578 = var3;
            this.field1585 = (var2 - this.field1576) / var1;
            this.field1586 = (var4 - this.field1580) / var1;
            this.field1587 = (var5 - this.field1573) / var1;
         }
      }
   }

   @ObfuscatedName("am")
   public synchronized void method2329(int var1) {
      if(var1 == 0) {
         this.method2320(0);
         this.unlink();
      } else if(this.field1580 == 0 && this.field1573 == 0) {
         this.field1584 = 0;
         this.field1579 = 0;
         this.field1576 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1576;
         if(this.field1576 > var2) {
            var2 = this.field1576;
         }

         if(-this.field1580 > var2) {
            var2 = -this.field1580;
         }

         if(this.field1580 > var2) {
            var2 = this.field1580;
         }

         if(-this.field1573 > var2) {
            var2 = -this.field1573;
         }

         if(this.field1573 > var2) {
            var2 = this.field1573;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1584 = var1;
         this.field1579 = Integer.MIN_VALUE;
         this.field1585 = -this.field1576 / var1;
         this.field1586 = -this.field1580 / var1;
         this.field1587 = -this.field1573 / var1;
      }
   }

   @ObfuscatedName("aj")
   public synchronized void method2457(int var1) {
      if(this.field1574 < 0) {
         this.field1574 = -var1;
      } else {
         this.field1574 = var1;
      }

   }

   @ObfuscatedName("ah")
   public synchronized int method2331() {
      return this.field1574 < 0?-this.field1574:this.field1574;
   }

   @ObfuscatedName("af")
   public boolean method2332() {
      return this.field1575 < 0 || this.field1575 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("ai")
   public boolean method2333() {
      return this.field1584 != 0;
   }

   @ObfuscatedName("ad")
   int method2339(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1584 > 0) {
            int var6 = var2 + this.field1584;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1584 += var2;
            if(this.field1574 == 256 && (this.field1575 & 255) == 0) {
               if(Frames.audioHighMemory) {
                  var2 = method2393(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, this.field1586, this.field1587, 0, var6, var3, this);
               } else {
                  var2 = method2453(((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, this.field1585, 0, var6, var3, this);
               }
            } else if(Frames.audioHighMemory) {
               var2 = method2355(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, this.field1586, this.field1587, 0, var6, var3, this, this.field1574, var5);
            } else {
               var2 = method2352(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, this.field1585, 0, var6, var3, this, this.field1574, var5);
            }

            this.field1584 -= var2;
            if(this.field1584 != 0) {
               return var2;
            }

            if(!this.method2341()) {
               continue;
            }

            return var4;
         }

         if(this.field1574 == 256 && (this.field1575 & 255) == 0) {
            if(Frames.audioHighMemory) {
               return method2343(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, 0, var4, var3, this);
            }

            return method2342(((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, 0, var4, var3, this);
         }

         if(Frames.audioHighMemory) {
            return method2314(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, 0, var4, var3, this, this.field1574, var5);
         }

         return method2346(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, 0, var4, var3, this, this.field1574, var5);
      }
   }

   @ObfuscatedName("ay")
   int method2340(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1584 > 0) {
            int var6 = var2 + this.field1584;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1584 += var2;
            if(this.field1574 == -256 && (this.field1575 & 255) == 0) {
               if(Frames.audioHighMemory) {
                  var2 = method2353(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, this.field1586, this.field1587, 0, var6, var3, this);
               } else {
                  var2 = method2436(((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, this.field1585, 0, var6, var3, this);
               }
            } else if(Frames.audioHighMemory) {
               var2 = method2357(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, this.field1586, this.field1587, 0, var6, var3, this, this.field1574, var5);
            } else {
               var2 = method2356(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, this.field1585, 0, var6, var3, this, this.field1574, var5);
            }

            this.field1584 -= var2;
            if(this.field1584 != 0) {
               return var2;
            }

            if(!this.method2341()) {
               continue;
            }

            return var4;
         }

         if(this.field1574 == -256 && (this.field1575 & 255) == 0) {
            if(Frames.audioHighMemory) {
               return method2345(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, 0, var4, var3, this);
            }

            return method2344(((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, 0, var4, var3, this);
         }

         if(Frames.audioHighMemory) {
            return method2410(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1580, this.field1573, 0, var4, var3, this, this.field1574, var5);
         }

         return method2348(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1575, var2, this.field1576, 0, var4, var3, this, this.field1574, var5);
      }
   }

   @ObfuscatedName("at")
   boolean method2341() {
      int var1 = this.field1579;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2321(var1, this.field1578);
         var3 = method2350(var1, this.field1578);
      }

      if(var1 == this.field1576 && var2 == this.field1580 && var3 == this.field1573) {
         if(this.field1579 == Integer.MIN_VALUE) {
            this.field1579 = 0;
            this.field1573 = 0;
            this.field1580 = 0;
            this.field1576 = 0;
            this.unlink();
            return true;
         } else {
            this.method2317();
            return false;
         }
      } else {
         if(this.field1576 < var1) {
            this.field1585 = 1;
            this.field1584 = var1 - this.field1576;
         } else if(this.field1576 > var1) {
            this.field1585 = -1;
            this.field1584 = this.field1576 - var1;
         } else {
            this.field1585 = 0;
         }

         if(this.field1580 < var2) {
            this.field1586 = 1;
            if(this.field1584 == 0 || this.field1584 > var2 - this.field1580) {
               this.field1584 = var2 - this.field1580;
            }
         } else if(this.field1580 > var2) {
            this.field1586 = -1;
            if(this.field1584 == 0 || this.field1584 > this.field1580 - var2) {
               this.field1584 = this.field1580 - var2;
            }
         } else {
            this.field1586 = 0;
         }

         if(this.field1573 < var3) {
            this.field1587 = 1;
            if(this.field1584 == 0 || this.field1584 > var3 - this.field1573) {
               this.field1584 = var3 - this.field1573;
            }
         } else if(this.field1573 > var3) {
            this.field1587 = -1;
            if(this.field1584 == 0 || this.field1584 > this.field1573 - var3) {
               this.field1584 = this.field1573 - var3;
            }
         } else {
            this.field1587 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ae")
   int vmethod2480() {
      int var1 = this.field1576 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1581 == 0) {
         var1 -= var1 * this.field1575 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1581 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("b")
   static int method2321(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   static int method2350(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldb;II)Ldp;"
   )
   public static class114 method2315(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class114(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ldb;III)Ldp;"
   )
   public static class114 method2316(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class114(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2342(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class114 var8) {
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

      var8.field1575 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2343(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10) {
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

      var10.field1575 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2344(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class114 var8) {
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

      var8.field1575 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2345(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10) {
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

      var10.field1575 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2346(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10, int var11, int var12) {
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

      var10.field1575 = var4;
      return var5;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2314(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
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

      var11.field1575 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2348(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class114 var10, int var11, int var12) {
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

      var10.field1575 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2410(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
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

      var11.field1575 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2453(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class114 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1580 += var9.field1586 * (var6 - var3);
      var9.field1573 += var9.field1587 * (var6 - var3);

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

      var9.field1576 = var4 >> 2;
      var9.field1575 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2393(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class114 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1576 += var12.field1585 * (var9 - var4);
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

      var12.field1580 = var5 >> 2;
      var12.field1573 = var6 >> 2;
      var12.field1575 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2436(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class114 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1580 += var9.field1586 * (var6 - var3);
      var9.field1573 += var9.field1587 * (var6 - var3);

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

      var9.field1576 = var4 >> 2;
      var9.field1575 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2353(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class114 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1576 += var12.field1585 * (var9 - var4);
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

      var12.field1580 = var5 >> 2;
      var12.field1573 = var6 >> 2;
      var12.field1575 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2352(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
      var11.field1580 -= var11.field1586 * var5;
      var11.field1573 -= var11.field1587 * var5;
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

      var11.field1580 += var11.field1586 * var5;
      var11.field1573 += var11.field1587 * var5;
      var11.field1576 = var6;
      var11.field1575 = var4;
      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2355(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class114 var13, int var14, int var15) {
      var13.field1576 -= var5 * var13.field1585;
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
      var13.field1576 += var13.field1585 * var5;
      var13.field1580 = var6;
      var13.field1573 = var7;
      var13.field1575 = var4;
      return var5;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2356(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class114 var11, int var12, int var13) {
      var11.field1580 -= var11.field1586 * var5;
      var11.field1573 -= var11.field1587 * var5;
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

      var11.field1580 += var11.field1586 * var5;
      var11.field1573 += var11.field1587 * var5;
      var11.field1576 = var6;
      var11.field1575 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2357(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class114 var13, int var14, int var15) {
      var13.field1576 -= var5 * var13.field1585;
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
      var13.field1576 += var13.field1585 * var5;
      var13.field1580 = var6;
      var13.field1573 = var7;
      var13.field1575 = var4;
      return var5;
   }
}
