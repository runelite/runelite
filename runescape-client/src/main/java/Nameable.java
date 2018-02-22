import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field3702;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   Name field3700;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "1904568211"
   )
   public Name method5183() {
      return this.name;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "97177831"
   )
   public String method5184() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1445506235"
   )
   public String method5182() {
      return this.field3700 == null?"":this.field3700.getName();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)V",
      garbageValue = "-1510593339"
   )
   void method5199(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3700 = var2;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljw;I)I",
      garbageValue = "-1639507459"
   )
   public int vmethod5385(Nameable var1) {
      return this.name.method5360(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5385((Nameable)var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIILev;Lfq;I)V",
      garbageValue = "-1986968763"
   )
   static final void method5187(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = Preferences.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.width;
         var11 = var9.length;
      } else {
         var10 = var9.length;
         var11 = var9.width;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class61.tileHeights[var1];
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.int1 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.supportItems == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4957(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.clipType == 1) {
            var8.method3409(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4957(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2893(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.clipType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4957(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field690[var5], 0, var20, var21);
            if(var9.clipType != 0) {
               var8.method3382(var2, var3, var6, var5, var9.blocksProjectile);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4957(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field691[var5], 0, var20, var21);
            if(var9.clipType != 0) {
               var8.method3382(var2, var3, var6, var5, var9.blocksProjectile);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4957(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4957(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class61.field690[var5], class61.field690[var27], var20, var21);
               if(var9.clipType != 0) {
                  var8.method3382(var2, var3, var6, var5, var9.blocksProjectile);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4957(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field691[var5], 0, var20, var21);
               if(var9.clipType != 0) {
                  var8.method3382(var2, var3, var6, var5, var9.blocksProjectile);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4957(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2893(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.clipType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4957(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field690[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2941(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = Preferences.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4957(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field690[var5], 0, var27 * class61.field694[var5], var27 * class61.field693[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2941(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = Preferences.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4957(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field689[var5], var27 * class61.field695[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4957(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2941(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = Preferences.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4957(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4957(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field689[var5], var27 * class61.field695[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4957(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2893(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.clipType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
         }

      }
   }
}
