import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public final class class82 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field1311;
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   static SpritePixels[] field1319;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1715295307
   )
   int field1312;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   ObjectComposition field1310;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1849353305
   )
   int field1309;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 866935711
   )
   int field1305;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1435561953
   )
   int field1313;
   @ObfuscatedName("v")
   int[] field1314;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   class117 field1308;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   class117 field1316;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1914194949
   )
   int field1307;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1388756265
   )
   int field1315;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 895382871
   )
   int field1317;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -436345971
   )
   int field1306;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -132023299
   )
   int field1304;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1289676285
   )
   int field1303;

   static {
      field1311 = new Deque();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-638775996"
   )
   void method1560() {
      int var1 = this.field1312;
      ObjectComposition var2 = this.field1310.getImpostor();
      if(var2 != null) {
         this.field1312 = var2.ambientSoundId;
         this.field1309 = var2.field3455 * 128;
         this.field1305 = var2.field3456;
         this.field1313 = var2.field3418;
         this.field1314 = var2.field3458;
      } else {
         this.field1312 = -1;
         this.field1309 = 0;
         this.field1305 = 0;
         this.field1313 = 0;
         this.field1314 = null;
      }

      if(var1 != this.field1312 && this.field1308 != null) {
         class1.field4.method1809(this.field1308);
         this.field1308 = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lhg;III)Lcv;",
      garbageValue = "2056426391"
   )
   static Script method1562(class219 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2769;
      Script var6 = (Script)Script.field1506.get((long)(var3 << 16));
      Script var5;
      if(var6 != null) {
         var5 = var6;
      } else {
         String var7 = String.valueOf(var3);
         int var8 = class13.indexScripts.getFile(var7);
         if(var8 == -1) {
            var5 = null;
         } else {
            label56: {
               byte[] var9 = class13.indexScripts.method4014(var8);
               if(var9 != null) {
                  if(var9.length <= 1) {
                     var5 = null;
                     break label56;
                  }

                  var6 = Friend.method1037(var9);
                  if(var6 != null) {
                     Script.field1506.put(var6, (long)(var3 << 16));
                     var5 = var6;
                     break label56;
                  }
               }

               var5 = null;
            }
         }
      }

      if(var5 != null) {
         return var5;
      } else {
         int var13 = (var2 + '鱀' << 8) + var0.field2769;
         Script var15 = (Script)Script.field1506.get((long)(var13 << 16));
         Script var14;
         if(var15 != null) {
            var14 = var15;
         } else {
            String var10 = String.valueOf(var13);
            int var11 = class13.indexScripts.getFile(var10);
            if(var11 == -1) {
               var14 = null;
            } else {
               byte[] var12 = class13.indexScripts.method4014(var11);
               if(var12 != null) {
                  if(var12.length <= 1) {
                     var14 = null;
                     return var14 != null?var14:null;
                  }

                  var15 = Friend.method1037(var12);
                  if(var15 != null) {
                     Script.field1506.put(var15, (long)(var13 << 16));
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

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lcm;IB)V",
      garbageValue = "41"
   )
   static final void method1554(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1255 > Client.gameCycle) {
         var2 = var0.field1255 - Client.gameCycle;
         var3 = var0.field1236 * 128 + var0.field1213 * 64;
         var4 = var0.field1253 * 128 + var0.field1213 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1267 = 0;
         var0.orientation = var0.field1257;
      } else if(var0.field1268 >= Client.gameCycle) {
         class261.method4618(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1267 = 0;
         } else {
            label281: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  Sequence var11 = class31.getAnimation(var0.animation);
                  if(var0.field1219 > 0 && var11.precedenceAnimating == 0) {
                     ++var0.field1267;
                     break label281;
                  }

                  if(var0.field1219 <= 0 && var11.priority == 0) {
                     ++var0.field1267;
                     break label281;
                  }
               }

               var2 = var0.x;
               var3 = var0.y;
               var4 = var0.field1213 * 64 + var0.pathX[var0.queueSize - 1] * 128;
               int var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1213 * 64;
               if(var2 < var4) {
                  if(var3 < var5) {
                     var0.orientation = 1280;
                  } else if(var3 > var5) {
                     var0.orientation = 1792;
                  } else {
                     var0.orientation = 1536;
                  }
               } else if(var2 > var4) {
                  if(var3 < var5) {
                     var0.orientation = 768;
                  } else if(var3 > var5) {
                     var0.orientation = 256;
                  } else {
                     var0.orientation = 512;
                  }
               } else if(var3 < var5) {
                  var0.orientation = 1024;
               } else if(var3 > var5) {
                  var0.orientation = 0;
               }

               byte var6 = var0.field1266[var0.queueSize - 1];
               if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1264;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1217;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1220;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1244;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1217;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1232 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1267 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1267;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1267 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1267;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field1217 == var0.poseAnimation && var0.field1221 != -1) {
                     var0.poseAnimation = var0.field1221;
                  }

                  if(var4 != var2 || var3 != var5) {
                     if(var2 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var2 > var4) {
                        var0.x -= var9;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.y += var9;
                        if(var0.y > var5) {
                           var0.y = var5;
                        }
                     } else if(var3 > var5) {
                        var0.y -= var9;
                        if(var0.y < var5) {
                           var0.y = var5;
                        }
                     }
                  }

                  if(var4 == var0.x && var5 == var0.y) {
                     --var0.queueSize;
                     if(var0.field1219 > 0) {
                        --var0.field1219;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1219 > 0) {
                     --var0.field1219;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1255 = 0;
         var0.field1268 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1213 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1213 * 64;
         var0.method1474();
      }

      if(class226.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1255 = 0;
         var0.field1268 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1213 * 64;
         var0.y = var0.field1213 * 64 + var0.pathY[0] * 128;
         var0.method1474();
      }

      class21.method154(var0);
      class261.method4619(var0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-816616676"
   )
   public static void method1564(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }
}
