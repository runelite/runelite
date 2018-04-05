import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class46 extends class28 {
   @ObfuscatedName("nc")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   static class320 field579;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 58927195
   )
   static int field578;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1350569053
   )
   int field580;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -936659953
   )
   int field575;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1420502861
   )
   int field576;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 258433273
   )
   int field577;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;Lgc;I)V",
      garbageValue = "1443898774"
   )
   void method677(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field498.field500) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedByte();
         super.field406 = var2.readUnsignedShort();
         super.field407 = var2.readUnsignedShort();
         this.field580 = var2.readUnsignedByte();
         this.field575 = var2.readUnsignedByte();
         super.field420 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         this.field576 = var2.readUnsignedByte();
         this.field577 = var2.readUnsignedByte();
         super.field411 = Math.min(super.field411, 4);
         super.field414 = new short[1][64][64];
         super.field413 = new short[super.field411][64][64];
         super.field408 = new byte[super.field411][64][64];
         super.field415 = new byte[super.field411][64][64];
         super.decorations = new WorldMapDecoration[super.field411][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field493.field496) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field420 && var5 == super.field409 && var6 == this.field576 && var7 == this.field577) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method251(var8 + this.field576 * 8, var9 + this.field577 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "102"
   )
   boolean method678(int var1, int var2) {
      return var1 < this.field576 * 8?false:(var2 < this.field577 * 8?false:(var1 >= this.field576 * 8 + 8?false:var2 < this.field577 * 8 + 8));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "928570610"
   )
   int method679() {
      return this.field580;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-321626771"
   )
   int method680() {
      return this.field575;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1816025576"
   )
   int method681() {
      return this.field576;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method682() {
      return this.field577;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         class46 var2 = (class46)var1;
         return var2.field420 == super.field420 && super.field409 == var2.field409?this.field576 == var2.field576 && this.field577 == var2.field577:false;
      }
   }

   public int hashCode() {
      return super.field420 | super.field409 << 8 | this.field576 << 16 | this.field577 << 24;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILfr;Lfb;I)Z",
      garbageValue = "1922300861"
   )
   static final boolean method705(int var0, int var1, int var2, class178 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class177.field2285[var7][var8] = 99;
      class177.field2286[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class177.field2290[var11] = var0;
      int var20 = var11 + 1;
      class177.field2287[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label304:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label281:
                     do {
                        if(var20 == var12) {
                           class177.field2283 = var5;
                           class177.field2289 = var6;
                           return false;
                        }

                        var5 = class177.field2290[var12];
                        var6 = class177.field2287[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3428(var2, var5, var6, var4)) {
                           class177.field2283 = var5;
                           class177.field2289 = var6;
                           return true;
                        }

                        var16 = class177.field2286[var18][var19] + 1;
                        if(var18 > 0 && class177.field2285[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5 - 1;
                                 class177.field2287[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 - 1][var19] = 2;
                                 class177.field2286[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class177.field2285[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5 + 1;
                                 class177.field2287[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 + 1][var19] = 8;
                                 class177.field2286[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class177.field2285[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18][var19 - 1] = 1;
                                 class177.field2286[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class177.field2285[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5;
                                 class177.field2287[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18][var19 + 1] = 4;
                                 class177.field2286[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class177.field2285[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2290[var20] = var5 - 1;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 - 1][var19 - 1] = 3;
                                 class177.field2286[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class177.field2285[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2290[var20] = var5 + 1;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 + 1][var19 - 1] = 9;
                                 class177.field2286[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class177.field2285[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label281;
                              }
                           }

                           class177.field2290[var20] = var5 - 1;
                           class177.field2287[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class177.field2285[var18 - 1][var19 + 1] = 6;
                           class177.field2286[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class177.field2285[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label304;
               }
            }

            class177.field2290[var20] = var5 + 1;
            class177.field2287[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class177.field2285[var18 + 1][var19 + 1] = 12;
            class177.field2286[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lba;B)V",
      garbageValue = "8"
   )
   static final void method685(Actor var0) {
      if(var0.field1205 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1156) {
               var0.interacting = -1;
               var0.field1156 = false;
            }
         }

         if(var0.field1185 != -1 && (var0.queueSize == 0 || var0.field1158 > 0)) {
            var0.orientation = var0.field1185;
            var0.field1185 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1156) {
            var0.interacting = -1;
            var0.field1156 = false;
         }

         if(var4 != 0) {
            ++var0.field1184;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1205;
               var6 = true;
               if(var4 < var0.field1205 || var4 > 2048 - var0.field1205) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1184 > 25 || var6)) {
                  if(var0.field1163 != -1) {
                     var0.poseAnimation = var0.field1163;
                  } else {
                     var0.poseAnimation = var0.field1165;
                  }
               }
            } else {
               var0.angle += var0.field1205;
               var6 = true;
               if(var4 < var0.field1205 || var4 > 2048 - var0.field1205) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1184 > 25 || var6)) {
                  if(var0.field1164 != -1) {
                     var0.poseAnimation = var0.field1164;
                  } else {
                     var0.poseAnimation = var0.field1165;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1184 = 0;
         }

      }
   }
}
