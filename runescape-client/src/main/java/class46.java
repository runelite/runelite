import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class46 extends class28 {
   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 361465771
   )
   int field562;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1270208713
   )
   int field561;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 643400923
   )
   int field559;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1483682309
   )
   int field560;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;Lgp;B)V",
      garbageValue = "7"
   )
   void method673(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field482.field483) {
         throw new IllegalStateException("");
      } else {
         super.field392 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field387 = var2.readUnsignedShort();
         this.field562 = var2.readUnsignedByte();
         this.field561 = var2.readUnsignedByte();
         super.field386 = var2.readUnsignedShort();
         super.field389 = var2.readUnsignedShort();
         this.field559 = var2.readUnsignedByte();
         this.field560 = var2.readUnsignedByte();
         super.field391 = Math.min(super.field391, 4);
         super.field388 = new short[1][64][64];
         super.field393 = new short[super.field391][64][64];
         super.field394 = new byte[super.field391][64][64];
         super.field395 = new byte[super.field391][64][64];
         super.decorations = new WorldMapDecoration[super.field391][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field475.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field386 && var5 == super.field389 && var6 == this.field559 && var7 == this.field560) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method241(var8 + this.field559 * 8, var9 + this.field560 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1759794354"
   )
   boolean method674(int var1, int var2) {
      return var1 < this.field559 * 8?false:(var2 < this.field560 * 8?false:(var1 >= this.field559 * 8 + 8?false:var2 < this.field560 * 8 + 8));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "96"
   )
   int method676() {
      return this.field562;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   int method677() {
      return this.field561;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1667850860"
   )
   int method687() {
      return this.field559;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "11"
   )
   int method679() {
      return this.field560;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         class46 var2 = (class46)var1;
         return super.field386 == var2.field386 && super.field389 == var2.field389?var2.field559 == this.field559 && this.field560 == var2.field560:false;
      }
   }

   public int hashCode() {
      return super.field386 | super.field389 << 8 | this.field559 << 16 | this.field560 << 24;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Liz;III)Lcx;",
      garbageValue = "-27192545"
   )
   static Script method688(class245 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2954;
      Script var6 = (Script)Script.field1449.get((long)(var3 << 16));
      Script var5;
      if(var6 != null) {
         var5 = var6;
      } else {
         String var7 = String.valueOf(var3);
         int var8 = MapLabel.indexScripts.getFile(var7);
         if(var8 == -1) {
            var5 = null;
         } else {
            label58: {
               byte[] var9 = MapLabel.indexScripts.takeRecordFlat(var8);
               if(var9 != null) {
                  if(var9.length <= 1) {
                     var5 = null;
                     break label58;
                  }

                  var6 = Projectile.newScript(var9);
                  if(var6 != null) {
                     Script.field1449.put(var6, (long)(var3 << 16));
                     var5 = var6;
                     break label58;
                  }
               }

               var5 = null;
            }
         }
      }

      if(var5 != null) {
         return var5;
      } else {
         int var13 = var0.field2954 + (var2 + 40000 << 8);
         Script var15 = (Script)Script.field1449.get((long)(var13 << 16));
         Script var14;
         if(var15 != null) {
            var14 = var15;
         } else {
            String var10 = String.valueOf(var13);
            int var11 = MapLabel.indexScripts.getFile(var10);
            if(var11 == -1) {
               var14 = null;
            } else {
               byte[] var12 = MapLabel.indexScripts.takeRecordFlat(var11);
               if(var12 != null) {
                  if(var12.length <= 1) {
                     var14 = null;
                     return var14 != null?var14:null;
                  }

                  var15 = Projectile.newScript(var12);
                  if(var15 != null) {
                     Script.field1449.put(var15, (long)(var13 << 16));
                     var14 = var15;
                     return var14 != null?var14:null;
                  }
               }

               var14 = null;
            }
         }

         return var14 != null?var14:null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1996295249"
   )
   public static final void method696(int var0, int var1) {
      class132.Viewport_mouseX = var0;
      class132.Viewport_mouseY = var1;
      class132.Viewport_containsMouse = true;
      class132.Viewport_entityCountAtMouse = 0;
      class132.Viewport_false0 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILfn;Lfk;I)Z",
      garbageValue = "1960360835"
   )
   static final boolean method697(int var0, int var1, int var2, class178 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class177.field2274[var7][var8] = 99;
      class177.field2275[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class177.field2272[var11] = var0;
      int var20 = var11 + 1;
      class177.field2276[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label308:
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
                     label285:
                     do {
                        if(var20 == var12) {
                           FileOnDisk.field1686 = var5;
                           class177.field2277 = var6;
                           return false;
                        }

                        var5 = class177.field2272[var12];
                        var6 = class177.field2276[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3410(var2, var5, var6, var4)) {
                           FileOnDisk.field1686 = var5;
                           class177.field2277 = var6;
                           return true;
                        }

                        var16 = class177.field2275[var18][var19] + 1;
                        if(var18 > 0 && class177.field2274[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2272[var20] = var5 - 1;
                                 class177.field2276[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18 - 1][var19] = 2;
                                 class177.field2275[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class177.field2274[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2272[var20] = var5 + 1;
                                 class177.field2276[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18 + 1][var19] = 8;
                                 class177.field2275[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class177.field2274[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2272[var20] = var5;
                                 class177.field2276[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18][var19 - 1] = 1;
                                 class177.field2275[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class177.field2274[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2272[var20] = var5;
                                 class177.field2276[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18][var19 + 1] = 4;
                                 class177.field2275[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class177.field2274[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2272[var20] = var5 - 1;
                                 class177.field2276[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18 - 1][var19 - 1] = 3;
                                 class177.field2275[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class177.field2274[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2272[var20] = var5 + 1;
                                 class177.field2276[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2274[var18 + 1][var19 - 1] = 9;
                                 class177.field2275[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class177.field2274[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label285;
                              }
                           }

                           class177.field2272[var20] = var5 - 1;
                           class177.field2276[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class177.field2274[var18 - 1][var19 + 1] = 6;
                           class177.field2275[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class177.field2274[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label308;
               }
            }

            class177.field2272[var20] = var5 + 1;
            class177.field2276[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class177.field2274[var18 + 1][var19 + 1] = 12;
            class177.field2275[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "642291735"
   )
   static void method694() {
      FileOnDisk var0 = null;

      try {
         var0 = Renderable.getPreferencesFile("", class71.field816.name, true);
         Buffer var1 = preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
