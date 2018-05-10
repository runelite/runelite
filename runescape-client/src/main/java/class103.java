import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class103 extends TaskDataNode {
   @ObfuscatedName("m")
   int field1381;
   @ObfuscatedName("q")
   int field1380;
   @ObfuscatedName("b")
   int field1392;
   @ObfuscatedName("f")
   int field1382;
   @ObfuscatedName("n")
   int field1383;
   @ObfuscatedName("h")
   int field1384;
   @ObfuscatedName("x")
   int field1388;
   @ObfuscatedName("j")
   int field1386;
   @ObfuscatedName("a")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("l")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("d")
   boolean field1389;
   @ObfuscatedName("s")
   int field1379;
   @ObfuscatedName("p")
   int field1391;
   @ObfuscatedName("g")
   int field1393;
   @ObfuscatedName("y")
   int field1390;

   @ObfuscatedSignature(
      signature = "(Lcg;III)V"
   )
   class103(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1389 = var1.field1304;
      this.field1380 = var2;
      this.field1392 = var3;
      this.field1382 = var4;
      this.field1381 = 0;
      this.method2352();
   }

   @ObfuscatedSignature(
      signature = "(Lcg;II)V"
   )
   class103(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1389 = var1.field1304;
      this.field1380 = var2;
      this.field1392 = var3;
      this.field1382 = 8192;
      this.field1381 = 0;
      this.method2352();
   }

   @ObfuscatedName("j")
   void method2352() {
      this.field1383 = this.field1392;
      this.field1384 = method2375(this.field1392, this.field1382);
      this.field1388 = method2392(this.field1392, this.field1382);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4421() {
      return null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4422() {
      return null;
   }

   @ObfuscatedName("d")
   protected int vmethod4423() {
      return this.field1392 == 0 && this.field1379 == 0?0:1;
   }

   @ObfuscatedName("s")
   public synchronized void vmethod4424(int[] var1, int var2, int var3) {
      if(this.field1392 == 0 && this.field1379 == 0) {
         this.vmethod4425(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1386 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1381 < 0) {
            if(this.field1380 <= 0) {
               this.method2326();
               this.unlink();
               return;
            }

            this.field1381 = 0;
         }

         if(this.field1381 >= var7) {
            if(this.field1380 >= 0) {
               this.method2326();
               this.unlink();
               return;
            }

            this.field1381 = var7 - 1;
         }

         if(this.field1386 < 0) {
            if(this.field1389) {
               if(this.field1380 < 0) {
                  var9 = this.method2391(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1381 >= var5) {
                     return;
                  }

                  this.field1381 = var5 + var5 - 1 - this.field1381;
                  this.field1380 = -this.field1380;
               }

               while(true) {
                  var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1381 < var6) {
                     return;
                  }

                  this.field1381 = var6 + var6 - 1 - this.field1381;
                  this.field1380 = -this.field1380;
                  var9 = this.method2391(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1381 >= var5) {
                     return;
                  }

                  this.field1381 = var5 + var5 - 1 - this.field1381;
                  this.field1380 = -this.field1380;
               }
            } else if(this.field1380 < 0) {
               while(true) {
                  var9 = this.method2391(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1381 >= var5) {
                     return;
                  }

                  this.field1381 = var6 - 1 - (var6 - 1 - this.field1381) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1381 < var6) {
                     return;
                  }

                  this.field1381 = var5 + (this.field1381 - var5) % var8;
               }
            }
         } else {
            if(this.field1386 > 0) {
               if(this.field1389) {
                  label145: {
                     if(this.field1380 < 0) {
                        var9 = this.method2391(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1381 >= var5) {
                           return;
                        }

                        this.field1381 = var5 + var5 - 1 - this.field1381;
                        this.field1380 = -this.field1380;
                        if(--this.field1386 == 0) {
                           break label145;
                        }
                     }

                     do {
                        var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1381 < var6) {
                           return;
                        }

                        this.field1381 = var6 + var6 - 1 - this.field1381;
                        this.field1380 = -this.field1380;
                        if(--this.field1386 == 0) {
                           break;
                        }

                        var9 = this.method2391(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1381 >= var5) {
                           return;
                        }

                        this.field1381 = var5 + var5 - 1 - this.field1381;
                        this.field1380 = -this.field1380;
                     } while(--this.field1386 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1380 < 0) {
                     while(true) {
                        var9 = this.method2391(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1381 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1381) / var8;
                        if(var10 >= this.field1386) {
                           this.field1381 += var8 * this.field1386;
                           this.field1386 = 0;
                           break;
                        }

                        this.field1381 += var8 * var10;
                        this.field1386 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2339(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1381 < var6) {
                           return;
                        }

                        var10 = (this.field1381 - var5) / var8;
                        if(var10 >= this.field1386) {
                           this.field1381 -= var8 * this.field1386;
                           this.field1386 = 0;
                           break;
                        }

                        this.field1381 -= var8 * var10;
                        this.field1386 -= var10;
                     }
                  }
               }
            }

            if(this.field1380 < 0) {
               this.method2391(var1, var9, 0, var3, 0);
               if(this.field1381 < 0) {
                  this.field1381 = -1;
                  this.method2326();
                  this.unlink();
               }
            } else {
               this.method2339(var1, var9, var7, var3, 0);
               if(this.field1381 >= var7) {
                  this.field1381 = var7;
                  this.method2326();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   public synchronized void method2318(int var1) {
      this.field1386 = var1;
   }

   @ObfuscatedName("g")
   public synchronized void vmethod4425(int var1) {
      if(this.field1379 > 0) {
         if(var1 >= this.field1379) {
            if(this.field1392 == Integer.MIN_VALUE) {
               this.field1392 = 0;
               this.field1388 = 0;
               this.field1384 = 0;
               this.field1383 = 0;
               this.unlink();
               var1 = this.field1379;
            }

            this.field1379 = 0;
            this.method2352();
         } else {
            this.field1383 += this.field1391 * var1;
            this.field1384 += this.field1393 * var1;
            this.field1388 += this.field1390 * var1;
            this.field1379 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1386 = 0;
      }

      if(this.field1381 < 0) {
         if(this.field1380 <= 0) {
            this.method2326();
            this.unlink();
            return;
         }

         this.field1381 = 0;
      }

      if(this.field1381 >= var5) {
         if(this.field1380 >= 0) {
            this.method2326();
            this.unlink();
            return;
         }

         this.field1381 = var5 - 1;
      }

      this.field1381 += this.field1380 * var1;
      if(this.field1386 < 0) {
         if(!this.field1389) {
            if(this.field1380 < 0) {
               if(this.field1381 >= var3) {
                  return;
               }

               this.field1381 = var4 - 1 - (var4 - 1 - this.field1381) % var6;
            } else {
               if(this.field1381 < var4) {
                  return;
               }

               this.field1381 = var3 + (this.field1381 - var3) % var6;
            }

         } else {
            if(this.field1380 < 0) {
               if(this.field1381 >= var3) {
                  return;
               }

               this.field1381 = var3 + var3 - 1 - this.field1381;
               this.field1380 = -this.field1380;
            }

            while(this.field1381 >= var4) {
               this.field1381 = var4 + var4 - 1 - this.field1381;
               this.field1380 = -this.field1380;
               if(this.field1381 >= var3) {
                  return;
               }

               this.field1381 = var3 + var3 - 1 - this.field1381;
               this.field1380 = -this.field1380;
            }

         }
      } else {
         if(this.field1386 > 0) {
            if(this.field1389) {
               label132: {
                  if(this.field1380 < 0) {
                     if(this.field1381 >= var3) {
                        return;
                     }

                     this.field1381 = var3 + var3 - 1 - this.field1381;
                     this.field1380 = -this.field1380;
                     if(--this.field1386 == 0) {
                        break label132;
                     }
                  }

                  do {
                     if(this.field1381 < var4) {
                        return;
                     }

                     this.field1381 = var4 + var4 - 1 - this.field1381;
                     this.field1380 = -this.field1380;
                     if(--this.field1386 == 0) {
                        break;
                     }

                     if(this.field1381 >= var3) {
                        return;
                     }

                     this.field1381 = var3 + var3 - 1 - this.field1381;
                     this.field1380 = -this.field1380;
                  } while(--this.field1386 != 0);
               }
            } else {
               label164: {
                  int var7;
                  if(this.field1380 < 0) {
                     if(this.field1381 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1381) / var6;
                     if(var7 >= this.field1386) {
                        this.field1381 += var6 * this.field1386;
                        this.field1386 = 0;
                        break label164;
                     }

                     this.field1381 += var6 * var7;
                     this.field1386 -= var7;
                  } else {
                     if(this.field1381 < var4) {
                        return;
                     }

                     var7 = (this.field1381 - var3) / var6;
                     if(var7 >= this.field1386) {
                        this.field1381 -= var6 * this.field1386;
                        this.field1386 = 0;
                        break label164;
                     }

                     this.field1381 -= var6 * var7;
                     this.field1386 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1380 < 0) {
            if(this.field1381 < 0) {
               this.field1381 = -1;
               this.method2326();
               this.unlink();
            }
         } else if(this.field1381 >= var5) {
            this.field1381 = var5;
            this.method2326();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("y")
   public synchronized void method2319(int var1) {
      this.method2321(var1 << 6, this.method2323());
   }

   @ObfuscatedName("c")
   synchronized void method2320(int var1) {
      this.method2321(var1, this.method2323());
   }

   @ObfuscatedName("e")
   synchronized void method2321(int var1, int var2) {
      this.field1392 = var1;
      this.field1382 = var2;
      this.field1379 = 0;
      this.method2352();
   }

   @ObfuscatedName("t")
   public synchronized int method2322() {
      return this.field1392 == Integer.MIN_VALUE?0:this.field1392;
   }

   @ObfuscatedName("u")
   public synchronized int method2323() {
      return this.field1382 < 0?-1:this.field1382;
   }

   @ObfuscatedName("i")
   public synchronized void method2324(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1381 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2325() {
      this.field1380 = (this.field1380 ^ this.field1380 >> 31) + (this.field1380 >>> 31);
      this.field1380 = -this.field1380;
   }

   @ObfuscatedName("v")
   void method2326() {
      if(this.field1379 != 0) {
         if(this.field1392 == Integer.MIN_VALUE) {
            this.field1392 = 0;
         }

         this.field1379 = 0;
         this.method2352();
      }

   }

   @ObfuscatedName("o")
   public synchronized void method2327(int var1, int var2) {
      this.method2328(var1, var2, this.method2323());
   }

   @ObfuscatedName("ai")
   public synchronized void method2328(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2321(var2, var3);
      } else {
         int var4 = method2375(var2, var3);
         int var5 = method2392(var2, var3);
         if(var4 == this.field1384 && var5 == this.field1388) {
            this.field1379 = 0;
         } else {
            int var6 = var2 - this.field1383;
            if(this.field1383 - var2 > var6) {
               var6 = this.field1383 - var2;
            }

            if(var4 - this.field1384 > var6) {
               var6 = var4 - this.field1384;
            }

            if(this.field1384 - var4 > var6) {
               var6 = this.field1384 - var4;
            }

            if(var5 - this.field1388 > var6) {
               var6 = var5 - this.field1388;
            }

            if(this.field1388 - var5 > var6) {
               var6 = this.field1388 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1379 = var1;
            this.field1392 = var2;
            this.field1382 = var3;
            this.field1391 = (var2 - this.field1383) / var1;
            this.field1393 = (var4 - this.field1384) / var1;
            this.field1390 = (var5 - this.field1388) / var1;
         }
      }
   }

   @ObfuscatedName("at")
   public synchronized void method2329(int var1) {
      if(var1 == 0) {
         this.method2320(0);
         this.unlink();
      } else if(this.field1384 == 0 && this.field1388 == 0) {
         this.field1379 = 0;
         this.field1392 = 0;
         this.field1383 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1383;
         if(this.field1383 > var2) {
            var2 = this.field1383;
         }

         if(-this.field1384 > var2) {
            var2 = -this.field1384;
         }

         if(this.field1384 > var2) {
            var2 = this.field1384;
         }

         if(-this.field1388 > var2) {
            var2 = -this.field1388;
         }

         if(this.field1388 > var2) {
            var2 = this.field1388;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1379 = var1;
         this.field1392 = Integer.MIN_VALUE;
         this.field1391 = -this.field1383 / var1;
         this.field1393 = -this.field1384 / var1;
         this.field1390 = -this.field1388 / var1;
      }
   }

   @ObfuscatedName("ad")
   public synchronized void method2330(int var1) {
      if(this.field1380 < 0) {
         this.field1380 = -var1;
      } else {
         this.field1380 = var1;
      }

   }

   @ObfuscatedName("ac")
   public synchronized int method2331() {
      return this.field1380 < 0?-this.field1380:this.field1380;
   }

   @ObfuscatedName("ay")
   public boolean method2441() {
      return this.field1381 < 0 || this.field1381 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("an")
   public boolean method2333() {
      return this.field1379 != 0;
   }

   @ObfuscatedName("ae")
   int method2339(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1379 > 0) {
            int var6 = var2 + this.field1379;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1379 += var2;
            if(this.field1380 == 256 && (this.field1381 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2350(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, this.field1393, this.field1390, 0, var6, var3, this);
               } else {
                  var2 = method2422(((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, this.field1391, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2455(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, this.field1393, this.field1390, 0, var6, var3, this, this.field1380, var5);
            } else {
               var2 = method2446(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, this.field1391, 0, var6, var3, this, this.field1380, var5);
            }

            this.field1379 -= var2;
            if(this.field1379 != 0) {
               return var2;
            }

            if(!this.method2426()) {
               continue;
            }

            return var4;
         }

         if(this.field1380 == 256 && (this.field1381 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2360(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, 0, var4, var3, this);
            }

            return method2342(((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2347(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, 0, var4, var3, this, this.field1380, var5);
         }

         return method2346(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, 0, var4, var3, this, this.field1380, var5);
      }
   }

   @ObfuscatedName("au")
   int method2391(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1379 > 0) {
            int var6 = var2 + this.field1379;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1379 += var2;
            if(this.field1380 == -256 && (this.field1381 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2388(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, this.field1393, this.field1390, 0, var6, var3, this);
               } else {
                  var2 = method2461(((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, this.field1391, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2356(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, this.field1393, this.field1390, 0, var6, var3, this, this.field1380, var5);
            } else {
               var2 = method2355(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, this.field1391, 0, var6, var3, this, this.field1380, var5);
            }

            this.field1379 -= var2;
            if(this.field1379 != 0) {
               return var2;
            }

            if(!this.method2426()) {
               continue;
            }

            return var4;
         }

         if(this.field1380 == -256 && (this.field1381 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2345(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, 0, var4, var3, this);
            }

            return method2344(((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2429(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1384, this.field1388, 0, var4, var3, this, this.field1380, var5);
         }

         return method2348(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1381, var2, this.field1383, 0, var4, var3, this, this.field1380, var5);
      }
   }

   @ObfuscatedName("av")
   boolean method2426() {
      int var1 = this.field1392;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2375(var1, this.field1382);
         var3 = method2392(var1, this.field1382);
      }

      if(var1 == this.field1383 && var2 == this.field1384 && var3 == this.field1388) {
         if(this.field1392 == Integer.MIN_VALUE) {
            this.field1392 = 0;
            this.field1388 = 0;
            this.field1384 = 0;
            this.field1383 = 0;
            this.unlink();
            return true;
         } else {
            this.method2352();
            return false;
         }
      } else {
         if(this.field1383 < var1) {
            this.field1391 = 1;
            this.field1379 = var1 - this.field1383;
         } else if(this.field1383 > var1) {
            this.field1391 = -1;
            this.field1379 = this.field1383 - var1;
         } else {
            this.field1391 = 0;
         }

         if(this.field1384 < var2) {
            this.field1393 = 1;
            if(this.field1379 == 0 || this.field1379 > var2 - this.field1384) {
               this.field1379 = var2 - this.field1384;
            }
         } else if(this.field1384 > var2) {
            this.field1393 = -1;
            if(this.field1379 == 0 || this.field1379 > this.field1384 - var2) {
               this.field1379 = this.field1384 - var2;
            }
         } else {
            this.field1393 = 0;
         }

         if(this.field1388 < var3) {
            this.field1390 = 1;
            if(this.field1379 == 0 || this.field1379 > var3 - this.field1388) {
               this.field1379 = var3 - this.field1388;
            }
         } else if(this.field1388 > var3) {
            this.field1390 = -1;
            if(this.field1379 == 0 || this.field1379 > this.field1388 - var3) {
               this.field1379 = this.field1388 - var3;
            }
         } else {
            this.field1390 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ak")
   int vmethod2484() {
      int var1 = this.field1383 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1386 == 0) {
         var1 -= var1 * this.field1381 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1386 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("w")
   static int method2375(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("m")
   static int method2392(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lcg;II)Lcd;"
   )
   public static class103 method2370(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class103(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lcg;III)Lcd;"
   )
   public static class103 method2316(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class103(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILcd;)I"
   )
   static int method2342(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class103 var8) {
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

      var8.field1381 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILcd;)I"
   )
   static int method2360(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10) {
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

      var10.field1381 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILcd;)I"
   )
   static int method2344(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class103 var8) {
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

      var8.field1381 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILcd;)I"
   )
   static int method2345(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10) {
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

      var10.field1381 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILcd;II)I"
   )
   static int method2346(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10, int var11, int var12) {
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

      var10.field1381 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILcd;II)I"
   )
   static int method2347(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
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

      var11.field1381 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILcd;II)I"
   )
   static int method2348(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10, int var11, int var12) {
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

      var10.field1381 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILcd;II)I"
   )
   static int method2429(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
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

      var11.field1381 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILcd;)I"
   )
   static int method2422(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class103 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1384 += var9.field1393 * (var6 - var3);
      var9.field1388 += var9.field1390 * (var6 - var3);

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

      var9.field1383 = var4 >> 2;
      var9.field1381 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILcd;)I"
   )
   static int method2350(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class103 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1383 += var12.field1391 * (var9 - var4);
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

      var12.field1384 = var5 >> 2;
      var12.field1388 = var6 >> 2;
      var12.field1381 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILcd;)I"
   )
   static int method2461(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class103 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1384 += var9.field1393 * (var6 - var3);
      var9.field1388 += var9.field1390 * (var6 - var3);

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

      var9.field1383 = var4 >> 2;
      var9.field1381 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILcd;)I"
   )
   static int method2388(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class103 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1383 += var12.field1391 * (var9 - var4);
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

      var12.field1384 = var5 >> 2;
      var12.field1388 = var6 >> 2;
      var12.field1381 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILcd;II)I"
   )
   static int method2446(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      var11.field1384 -= var11.field1393 * var5;
      var11.field1388 -= var11.field1390 * var5;
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

      var11.field1384 += var11.field1393 * var5;
      var11.field1388 += var11.field1390 * var5;
      var11.field1383 = var6;
      var11.field1381 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILcd;II)I"
   )
   static int method2455(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class103 var13, int var14, int var15) {
      var13.field1383 -= var5 * var13.field1391;
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
      var13.field1383 += var13.field1391 * var5;
      var13.field1384 = var6;
      var13.field1388 = var7;
      var13.field1381 = var4;
      return var5;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILcd;II)I"
   )
   static int method2355(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      var11.field1384 -= var11.field1393 * var5;
      var11.field1388 -= var11.field1390 * var5;
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

      var11.field1384 += var11.field1393 * var5;
      var11.field1388 += var11.field1390 * var5;
      var11.field1383 = var6;
      var11.field1381 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILcd;II)I"
   )
   static int method2356(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class103 var13, int var14, int var15) {
      var13.field1383 -= var5 * var13.field1391;
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
      var13.field1383 += var13.field1391 * var5;
      var13.field1384 = var6;
      var13.field1388 = var7;
      var13.field1381 = var4;
      return var5;
   }
}
