import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class51 extends CacheableNode {
   @ObfuscatedName("z")
   public static class170 field1073;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1261000633
   )
   int field1074 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 897539959
   )
   int field1075 = -1;
   @ObfuscatedName("y")
   public static NodeCache field1076 = new NodeCache(64);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 326817081
   )
   public int field1077 = 16777215;
   @ObfuscatedName("g")
   public static NodeCache field1078 = new NodeCache(20);
   @ObfuscatedName("x")
   String field1081 = "";
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1386383075
   )
   public int field1082 = -1;
   @ObfuscatedName("p")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1474826423
   )
   public int field1084 = 70;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1955070651
   )
   int field1085 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -961474825
   )
   int field1087 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1538701013
   )
   public int field1089 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1328183643
   )
   public int field1090 = 0;
   @ObfuscatedName("t")
   public static class170 field1091;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -435610917
   )
   int field1092 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1050875371
   )
   public int field1093 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1757224817
   )
   public int field1094 = 0;
   @ObfuscatedName("e")
   public int[] field1095;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1126374161
   )
   int field1096 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -42814549
   )
   int field1097 = -1;
   @ObfuscatedName("az")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 722147735
   )
   static int field1099;
   @ObfuscatedName("s")
   public static class170 field1101;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "-30998"
   )
   public SpritePixels method1002() {
      if(this.field1075 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1075);
         if(null != var1) {
            return var1;
         } else {
            var1 = class157.method3154(field1073, this.field1075, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1075);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   void method1003(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method1004(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "714466175"
   )
   void method1004(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1092 = var1.method2496();
      } else if(var2 == 2) {
         this.field1077 = var1.method2485();
      } else if(var2 == 3) {
         this.field1085 = var1.method2496();
      } else if(var2 == 4) {
         this.field1087 = var1.method2496();
      } else if(var2 == 5) {
         this.field1075 = var1.method2496();
      } else if(var2 == 6) {
         this.field1097 = var1.method2496();
      } else if(var2 == 7) {
         this.field1089 = var1.method2474();
      } else if(var2 == 8) {
         this.field1081 = var1.method2490();
      } else if(var2 == 9) {
         this.field1084 = var1.method2668();
      } else if(var2 == 10) {
         this.field1090 = var1.method2474();
      } else if(var2 == 11) {
         this.field1082 = 0;
      } else if(var2 == 12) {
         this.field1093 = var1.method2481();
      } else if(var2 == 13) {
         this.field1094 = var1.method2474();
      } else if(var2 == 14) {
         this.field1082 = var1.method2668();
      } else if(var2 == 17 || var2 == 18) {
         this.field1096 = var1.method2668();
         if(this.field1096 == '\uffff') {
            this.field1096 = -1;
         }

         this.field1074 = var1.method2668();
         if(this.field1074 == '\uffff') {
            this.field1074 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.method2668();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.method2481();
         this.field1095 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field1095[var5] = var1.method2668();
            if(this.field1095[var5] == '\uffff') {
               this.field1095[var5] = -1;
            }
         }

         this.field1095[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lclass51;",
      garbageValue = "1030701383"
   )
   public final class51 method1005() {
      int var1 = -1;
      if(this.field1096 != -1) {
         var1 = class173.method3381(this.field1096);
      } else if(this.field1074 != -1) {
         var1 = class179.widgetSettings[this.field1074];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field1095.length - 1) {
         var2 = this.field1095[var1];
      } else {
         var2 = this.field1095[this.field1095.length - 1];
      }

      return var2 != -1?class9.method119(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "10"
   )
   public String method1006(int var1) {
      String var2 = this.field1081;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + RSCanvas.method2929(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "199698458"
   )
   public SpritePixels method1007() {
      if(this.field1085 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1085);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class157.method3154(field1073, this.field1085, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1085);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1210092092"
   )
   public SpritePixels method1009() {
      if(this.field1087 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1087);
         if(null != var1) {
            return var1;
         } else {
            var1 = class157.method3154(field1073, this.field1087, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1087);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "526130941"
   )
   public SpritePixels method1010() {
      if(this.field1097 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1097);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class157.method3154(field1073, this.field1097, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1097);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Lclass227;",
      garbageValue = "-9"
   )
   public class227 method1030() {
      if(this.field1092 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1078.get((long)this.field1092);
         if(var1 != null) {
            return var1;
         } else {
            class170 var3 = field1073;
            class170 var4 = field1091;
            int var5 = this.field1092;
            class227 var2;
            if(!class35.method729(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = class190.method3732(var4.method3272(var5, 0));
            }

            if(null != var2) {
               field1078.put(var2, (long)this.field1092);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1935374643"
   )
   public static void method1031(class170 var0) {
      class50.field1065 = var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1149254817"
   )
   static final void method1032(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field271 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field66) {
            class5.field66 = var0;
         }

         ObjectComposition var8 = class40.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field923;
            var10 = var8.field924;
         } else {
            var9 = var8.field924;
            var10 = var8.field923;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + var1 + (var2 << 7) + 1073741824;
         if(var8.field927 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field948 == 1) {
            var20 += 256;
         }

         int var22;
         int var28;
         if(var8.method823()) {
            class24 var21 = new class24();
            var21.field591 = var0;
            var21.field594 = var1 * 128;
            var21.field593 = var2 * 128;
            var22 = var8.field923;
            var28 = var8.field924;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field924;
               var28 = var8.field923;
            }

            var21.field601 = (var22 + var1) * 128;
            var21.field595 = (var28 + var2) * 128;
            var21.field597 = var8.field952;
            var21.field596 = var8.field953 * 128;
            var21.field592 = var8.field954;
            var21.field600 = var8.field955;
            var21.field605 = var8.field956;
            if(var8.impostorIds != null) {
               var21.field604 = var8;
               var21.method584();
            }

            class24.field590.method3801(var21);
            if(var21.field605 != null) {
               var21.field602 = var21.field592 + (int)(Math.random() * (double)(var21.field600 - var21.field592));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field271 || var8.field927 != 0 || var8.field914 == 1 || var8.field946) {
               if(var8.field932 == -1 && null == var8.impostorIds) {
                  var30 = var8.method818(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 22, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field914 == 1 && var7 != null) {
                  var7.method2377(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field932 == -1 && null == var8.impostorIds) {
                  var30 = var8.method818(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
               }

               var6.method2007(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class16.field216[var0][var1][var2] |= 2340;
               }

               if(var8.field914 != 0 && null != var7) {
                  var7.method2362(var1, var2, var9, var10, var8.field951);
               }

            } else if(var5 == 0) {
               if(var8.field932 == -1 && var8.impostorIds == null) {
                  var30 = var8.method818(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 0, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
               }

               var6.method2020(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field74[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field939) {
                     class217.field3197[var0][var1][var2] = 50;
                     class217.field3197[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field930) {
                     class16.field216[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field939) {
                     class217.field3197[var0][var1][1 + var2] = 50;
                     class217.field3197[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field930) {
                     class16.field216[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field939) {
                     class217.field3197[var0][1 + var1][var2] = 50;
                     class217.field3197[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field930) {
                     class16.field216[var0][1 + var1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field939) {
                     class217.field3197[var0][var1][var2] = 50;
                     class217.field3197[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field930) {
                     class16.field216[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field914 != 0 && null != var7) {
                  var7.method2361(var1, var2, var5, var4, var8.field951);
               }

               if(var8.field915 != 16) {
                  var6.method1931(var0, var1, var2, var8.field915);
               }

            } else if(var5 == 1) {
               if(var8.field932 == -1 && null == var8.impostorIds) {
                  var30 = var8.method818(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 1, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
               }

               var6.method2020(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field84[var4], 0, var19, var20);
               if(var8.field939) {
                  if(var4 == 0) {
                     class217.field3197[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class217.field3197[var0][1 + var1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class217.field3197[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class217.field3197[var0][var1][var2] = 50;
                  }
               }

               if(var8.field914 != 0 && null != var7) {
                  var7.method2361(var1, var2, var5, var4, var8.field951);
               }

            } else {
               Object var23;
               int var27;
               if(var5 == 2) {
                  var27 = var4 + 1 & 3;
                  Object var29;
                  if(var8.field932 == -1 && null == var8.impostorIds) {
                     var29 = var8.method818(2, 4 + var4, var15, var17, var16, var18);
                     var23 = var8.method818(2, var27, var15, var17, var16, var18);
                  } else {
                     var29 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                     var23 = new class12(var3, 2, var27, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method2020(var0, var1, var2, var16, (Renderable)var29, (Renderable)var23, class5.field74[var4], class5.field74[var27], var19, var20);
                  if(var8.field930) {
                     if(var4 == 0) {
                        class16.field216[var0][var1][var2] |= 585;
                        class16.field216[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class16.field216[var0][var1][var2 + 1] |= 1170;
                        class16.field216[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class16.field216[var0][var1 + 1][var2] |= 585;
                        class16.field216[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class16.field216[var0][var1][var2] |= 1170;
                        class16.field216[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field914 != 0 && null != var7) {
                     var7.method2361(var1, var2, var5, var4, var8.field951);
                  }

                  if(var8.field915 != 16) {
                     var6.method1931(var0, var1, var2, var8.field915);
                  }

               } else if(var5 == 3) {
                  if(var8.field932 == -1 && var8.impostorIds == null) {
                     var30 = var8.method818(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 3, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method2020(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field84[var4], 0, var19, var20);
                  if(var8.field939) {
                     if(var4 == 0) {
                        class217.field3197[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class217.field3197[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class217.field3197[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class217.field3197[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field914 != 0 && null != var7) {
                     var7.method2361(var1, var2, var5, var4, var8.field951);
                  }

               } else if(var5 == 9) {
                  if(var8.field932 == -1 && var8.impostorIds == null) {
                     var30 = var8.method818(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method2007(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field914 != 0 && var7 != null) {
                     var7.method2362(var1, var2, var9, var10, var8.field951);
                  }

                  if(var8.field915 != 16) {
                     var6.method1931(var0, var1, var2, var8.field915);
                  }

               } else if(var5 == 4) {
                  if(var8.field932 == -1 && var8.impostorIds == null) {
                     var30 = var8.method818(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method1924(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field74[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method2004(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class40.getObjectDefinition(var22 >> 14 & 32767).field915;
                  }

                  if(var8.field932 == -1 && null == var8.impostorIds) {
                     var23 = var8.method818(4, var4, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method1924(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class5.field74[var4], 0, var27 * class5.field76[var4], var27 * class5.field77[var4], var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method2004(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class40.getObjectDefinition(var22 >> 14 & 32767).field915 / 2;
                  }

                  if(var8.field932 == -1 && var8.impostorIds == null) {
                     var23 = var8.method818(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method1924(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var27 * class5.field78[var4], class5.field71[var4] * var27, var19, var20);
               } else if(var5 == 7) {
                  var22 = 2 + var4 & 3;
                  if(var8.field932 == -1 && var8.impostorIds == null) {
                     var30 = var8.method818(4, 4 + var22, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method1924(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method2004(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class40.getObjectDefinition(var22 >> 14 & 32767).field915 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var26;
                  if(var8.field932 == -1 && null == var8.impostorIds) {
                     var23 = var8.method818(4, 4 + var4, var15, var17, var16, var18);
                     var26 = var8.method818(4, 4 + var25, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field932, true, (Renderable)null);
                     var26 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field932, true, (Renderable)null);
                  }

                  var6.method1924(var0, var1, var2, var16, (Renderable)var23, (Renderable)var26, 256, var4, var27 * class5.field78[var4], class5.field71[var4] * var27, var19, var20);
               }
            }
         } else {
            if(var8.field932 == -1 && null == var8.impostorIds) {
               var30 = var8.method818(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class12(var3, 10, var4, var0, var1, var2, var8.field932, true, (Renderable)null);
            }

            if(var30 != null && var6.method2007(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field939) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2347() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var28 = 0; var28 <= var9; ++var28) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class217.field3197[var0][var1 + var28][var2 + var24]) {
                        class217.field3197[var0][var28 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field914 != 0 && var7 != null) {
               var7.method2362(var1, var2, var9, var10, var8.field951);
            }

         }
      }
   }
}
