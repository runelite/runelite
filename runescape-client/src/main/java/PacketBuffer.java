import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("a")
   static final int[] field2397;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 578535353
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2397 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1010711729"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "1"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1509104083"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-69"
   )
   public boolean method3869() {
      int var1 = super.payload[super.offset] - this.cipher.method3905() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1543296381"
   )
   public int method3883() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1420787833"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1165394850"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2397[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2397[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2397[var1];
      }

      return var4;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1035164181"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIILdt;Lfm;I)V",
      garbageValue = "-1321872512"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class50.tileSettings[0][var1][var2] & 2) != 0 || (class50.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class50.field446) {
            class50.field446 = var0;
         }

         ObjectComposition var8 = SoundTaskDataProvider.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.width;
            var10 = var8.length;
         } else {
            var9 = var8.length;
            var10 = var8.width;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class50.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         long var19 = class59.method1129(var1, var2, 2, var8.int1 == 0, var3);
         int var21 = var5 + (var4 << 6);
         if(var8.supportItems == 1) {
            var21 += 256;
         }

         if(var8.method5062()) {
            class277.method5252(var0, var1, var2, var8, var4);
         }

         Object var22;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var22 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var22, var19, var21);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3424(var1, var2);
               }

            }
         } else {
            int var23;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var22 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2911(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     MouseRecorder.field534[var0][var1][var2] |= 2340;
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var22 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, class50.field454[var4], 0, var19, var21);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class50.field449[var0][var1][var2] = 50;
                        class50.field449[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        MouseRecorder.field534[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class50.field449[var0][var1][var2 + 1] = 50;
                        class50.field449[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        MouseRecorder.field534[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class50.field449[var0][var1 + 1][var2] = 50;
                        class50.field449[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        MouseRecorder.field534[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class50.field449[var0][var1][var2] = 50;
                        class50.field449[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        MouseRecorder.field534[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.removeWall(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method3030(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var22 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, class50.field453[var4], 0, var19, var21);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class50.field449[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class50.field449[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class50.field449[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class50.field449[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.removeWall(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else {
                  int var28;
                  if(var5 == 2) {
                     var28 = var4 + 1 & 3;
                     Object var29;
                     Object var30;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var29 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var30 = var8.getModel(2, var28, var15, var17, var16, var18);
                     } else {
                        var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var29, (Renderable)var30, class50.field454[var4], class50.field454[var28], var19, var21);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           MouseRecorder.field534[var0][var1][var2] |= 585;
                           MouseRecorder.field534[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           MouseRecorder.field534[var0][var1][1 + var2] |= 1170;
                           MouseRecorder.field534[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           MouseRecorder.field534[var0][var1 + 1][var2] |= 585;
                           MouseRecorder.field534[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           MouseRecorder.field534[var0][var1][var2] |= 1170;
                           MouseRecorder.field534[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.removeWall(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method3030(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var22 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, class50.field453[var4], 0, var19, var21);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class50.field449[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class50.field449[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class50.field449[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class50.field449[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.removeWall(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var22 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2911(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
                     if(var8.clipType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method3030(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var22 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, class50.field454[var4], 0, 0, 0, var19, var21);
                  } else {
                     long var31;
                     Object var33;
                     if(var5 == 5) {
                        var28 = 16;
                        var31 = var6.method2927(var0, var1, var2);
                        if(var31 != 0L) {
                           var28 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var31)).decorDisplacement;
                        }

                        if(var8.animationId == -1 && var8.impostorIds == null) {
                           var33 = var8.getModel(4, var4, var15, var17, var16, var18);
                        } else {
                           var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        }

                        var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var33, (Renderable)null, class50.field454[var4], 0, var28 * class50.field456[var4], var28 * class50.field457[var4], var19, var21);
                     } else if(var5 == 6) {
                        var28 = 8;
                        var31 = var6.method2927(var0, var1, var2);
                        if(0L != var31) {
                           var28 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var31)).decorDisplacement / 2;
                        }

                        if(var8.animationId == -1 && var8.impostorIds == null) {
                           var33 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        } else {
                           var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        }

                        var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var33, (Renderable)null, 256, var4, var28 * class50.field458[var4], var28 * class50.field459[var4], var19, var21);
                     } else if(var5 == 7) {
                        var23 = var4 + 2 & 3;
                        if(var8.animationId == -1 && var8.impostorIds == null) {
                           var22 = var8.getModel(4, var23 + 4, var15, var17, var16, var18);
                        } else {
                           var22 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        }

                        var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var19, var21);
                     } else if(var5 == 8) {
                        var28 = 8;
                        var31 = var6.method2927(var0, var1, var2);
                        if(0L != var31) {
                           var28 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var31)).decorDisplacement / 2;
                        }

                        int var27 = var4 + 2 & 3;
                        Object var26;
                        if(var8.animationId == -1 && var8.impostorIds == null) {
                           var33 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                           var26 = var8.getModel(4, var27 + 4, var15, var17, var16, var18);
                        } else {
                           var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                           var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        }

                        var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var33, (Renderable)var26, 256, var4, var28 * class50.field458[var4], var28 * class50.field459[var4], var19, var21);
                     }
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var22 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var22 != null && var6.method2911(var0, var1, var2, var16, var9, var10, (Renderable)var22, var5 == 11?256:0, var19, var21) && var8.clipped) {
                  var23 = 15;
                  if(var22 instanceof Model) {
                     var23 = ((Model)var22).method2727() / 4;
                     if(var23 > 30) {
                        var23 = 30;
                     }
                  }

                  for(int var24 = 0; var24 <= var9; ++var24) {
                     for(int var25 = 0; var25 <= var10; ++var25) {
                        if(var23 > class50.field449[var0][var24 + var1][var25 + var2]) {
                           class50.field449[var0][var24 + var1][var25 + var2] = (byte)var23;
                        }
                     }
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            }
         }
      }
   }
}
