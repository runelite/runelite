import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class18 implements Comparator {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 281678973
   )
   static int field306;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-1200787787"
   )
   int method145(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method92().compareTo(var2.method92());
   }

   public int compare(Object var1, Object var2) {
      return this.method145((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILfn;Lfk;Z[I[IB)I",
      garbageValue = "0"
   )
   public static int method144(int var0, int var1, int var2, class178 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class177.field2274[var8][var9] = 0;
            class177.field2275[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class177.field2274[var12][var13] = 99;
         class177.field2275[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class177.field2272[var16] = var0;
         var33 = var16 + 1;
         class177.field2276[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               FileOnDisk.field1686 = var10;
               class177.field2277 = var11;
               var29 = false;
               break;
            }

            var10 = class177.field2272[var17];
            var11 = class177.field2276[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3410(1, var10, var11, var4)) {
               FileOnDisk.field1686 = var10;
               class177.field2277 = var11;
               var29 = true;
               break;
            }

            var21 = class177.field2275[var30][var31] + 1;
            if(var30 > 0 && class177.field2274[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31] = 2;
               class177.field2275[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class177.field2274[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31] = 8;
               class177.field2275[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class177.field2274[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class177.field2272[var33] = var10;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30][var31 - 1] = 1;
               class177.field2275[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class177.field2274[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class177.field2272[var33] = var10;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30][var31 + 1] = 4;
               class177.field2275[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class177.field2274[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31 - 1] = 3;
               class177.field2275[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class177.field2274[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31 - 1] = 9;
               class177.field2275[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class177.field2274[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31 + 1] = 6;
               class177.field2275[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class177.field2274[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31 + 1] = 12;
               class177.field2275[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class177.field2274[var12][var13] = 99;
         class177.field2275[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class177.field2272[var16] = var0;
         var33 = var16 + 1;
         class177.field2276[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               FileOnDisk.field1686 = var10;
               class177.field2277 = var11;
               var29 = false;
               break;
            }

            var10 = class177.field2272[var17];
            var11 = class177.field2276[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3410(2, var10, var11, var4)) {
               FileOnDisk.field1686 = var10;
               class177.field2277 = var11;
               var29 = true;
               break;
            }

            var21 = class177.field2275[var30][var31] + 1;
            if(var30 > 0 && class177.field2274[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31] = 2;
               class177.field2275[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class177.field2274[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31] = 8;
               class177.field2275[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class177.field2274[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class177.field2272[var33] = var10;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30][var31 - 1] = 1;
               class177.field2275[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class177.field2274[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
               class177.field2272[var33] = var10;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30][var31 + 1] = 4;
               class177.field2275[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class177.field2274[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31 - 1] = 3;
               class177.field2275[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class177.field2274[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31 - 1] = 9;
               class177.field2275[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class177.field2274[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class177.field2272[var33] = var10 - 1;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 - 1][var31 + 1] = 6;
               class177.field2275[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class177.field2274[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
               class177.field2272[var33] = var10 + 1;
               class177.field2276[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2274[var30 + 1][var31 + 1] = 12;
               class177.field2275[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = class46.method697(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = FileOnDisk.field1686;
      var30 = class177.field2277;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2283;
         var17 = var3.field2282;
         int var27 = var3.field2280;
         var19 = var3.field2281;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class177.field2275[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class177.field2275[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class177.field2275[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class177.field2272[var13] = var11;
         var31 = var13 + 1;
         class177.field2276[var13] = var30;

         for(var14 = var15 = class177.field2274[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class177.field2274[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class177.field2272[var31] = var11;
               class177.field2276[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class177.field2272[var31];
            var7[var33++] = class177.field2276[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-732981237"
   )
   static final void method155() {
      Overlay.overlays.reset();
      class81.method1763();
      class57.method859();
      ObjectComposition.objects.reset();
      ObjectComposition.field3609.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3591.reset();
      class250.method4519();
      class47.method745();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      class245.method4508();
      DecorativeObject.method3096();
      Spotanim.method4810();
      GroundObject.method2667();
      CombatInfo2.field3525.reset();
      CombatInfo2.field3518.reset();
      CombatInfo1.method1606();
      WorldMapRectangle.method272();
      Area.areaSpriteCache.reset();
      PlayerComposition.field2785.reset();
      UnitPriceComparator.method140();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1449.reset();
      class169.indexInterfaces.reset();
      class19.indexSoundEffects.reset();
      class55.indexCache3.reset();
      class44.indexCache4.reset();
      class1.indexMaps.reset();
      class1.indexTrack1.reset();
      class44.indexModels.reset();
      class44.indexSprites.reset();
      PendingSpawn.indexTextures.reset();
      Client.indexCache10.reset();
      class157.indexTrack2.reset();
      MapLabel.indexScripts.reset();
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1536846702"
   )
   static void method156(int var0, int var1, int var2, int var3) {
      Widget var4 = ClientPacket.getWidgetChild(var0, var1);
      if(var4 != null && var4.onTargetEnterListener != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.onTargetEnterListener;
         AbstractByteBuffer.method3757(var5);
      }

      Client.field1013 = var3;
      Client.spellSelected = true;
      SoundTaskDataProvider.field623 = var0;
      Client.field1012 = var1;
      class241.field2799 = var2;
      WorldMapType1.method274(var4);
   }
}
