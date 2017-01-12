import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class164 extends CacheableNode {
   @ObfuscatedName("a")
   public final int[] field2138;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 535553009
   )
   public final int field2139;
   @ObfuscatedName("i")
   public final int[] field2141;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -980987803
   )
   public final int field2143;

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2143 = var1;
      this.field2139 = var2;
      this.field2141 = var3;
      this.field2138 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-786194423"
   )
   static final void method3112(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = Tile.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field2895;
         var11 = var9.field2931;
      } else {
         var10 = var9.field2931;
         var11 = var9.field2895;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = var3 + (1 + var11 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class10.tileHeights[var1];
      int var17 = var16[var13][var15] + var16[var12][var14] + var16[var13][var14] + var16[var12][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = 1073741824 + (var3 << 7) + var2 + (var4 << 14);
      if(var9.field2899 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(var9.field2920 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.field2903 == -1 && null == var9.impostorIds) {
            var22 = var9.method3593(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 22, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field2923 == 1) {
            var8.method2233(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field2903 == -1 && var9.impostorIds == null) {
               var22 = var9.method3593(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, var6, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
            }

            var7.method1680(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field2923 != 0) {
               var8.method2231(var2, var3, var10, var11, var9.field2898);
            }

         } else if(var6 == 0) {
            if(var9.field2903 == -1 && null == var9.impostorIds) {
               var22 = var9.method3593(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 0, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
            }

            var7.method1678(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field96[var5], 0, var20, var21);
            if(var9.field2923 != 0) {
               var8.method2252(var2, var3, var6, var5, var9.field2898);
            }

         } else if(var6 == 1) {
            if(var9.field2903 == -1 && null == var9.impostorIds) {
               var22 = var9.method3593(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 1, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
            }

            var7.method1678(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field101[var5], 0, var20, var21);
            if(var9.field2923 != 0) {
               var8.method2252(var2, var3, var6, var5, var9.field2898);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = 1 + var5 & 3;
               Object var28;
               if(var9.field2903 == -1 && null == var9.impostorIds) {
                  var28 = var9.method3593(2, 4 + var5, var16, var18, var17, var19);
                  var24 = var9.method3593(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class49(var4, 2, 4 + var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
                  var24 = new class49(var4, 2, var27, var1, var2, var3, var9.field2903, true, (Renderable)null);
               }

               var7.method1678(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class10.field96[var5], class10.field96[var27], var20, var21);
               if(var9.field2923 != 0) {
                  var8.method2252(var2, var3, var6, var5, var9.field2898);
               }

            } else if(var6 == 3) {
               if(var9.field2903 == -1 && var9.impostorIds == null) {
                  var22 = var9.method3593(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 3, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
               }

               var7.method1678(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field101[var5], 0, var20, var21);
               if(var9.field2923 != 0) {
                  var8.method2252(var2, var3, var6, var5, var9.field2898);
               }

            } else if(var6 == 9) {
               if(var9.field2903 == -1 && var9.impostorIds == null) {
                  var22 = var9.method3593(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, var6, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
               }

               var7.method1680(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field2923 != 0) {
                  var8.method2231(var2, var3, var10, var11, var9.field2898);
               }

            } else if(var6 == 4) {
               if(var9.field2903 == -1 && null == var9.impostorIds) {
                  var22 = var9.method3593(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 4, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
               }

               var7.method1807(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field96[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1696(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = Tile.getObjectDefinition(var23 >> 14 & 32767).field2905;
                  }

                  if(var9.field2903 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3593(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
                  }

                  var7.method1807(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class10.field96[var5], 0, class10.field102[var5] * var27, class10.field106[var5] * var27, var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method1696(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = Tile.getObjectDefinition(var23 >> 14 & 32767).field2905 / 2;
                  }

                  if(var9.field2903 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3593(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, 4 + var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
                  }

                  var7.method1807(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class10.field104[var5], var27 * class10.field105[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field2903 == -1 && var9.impostorIds == null) {
                     var22 = var9.method3593(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class49(var4, 4, 4 + var23, var1, var2, var3, var9.field2903, true, (Renderable)null);
                  }

                  var7.method1807(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1696(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = Tile.getObjectDefinition(var23 >> 14 & 32767).field2905 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.field2903 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3593(4, 4 + var5, var16, var18, var17, var19);
                     var25 = var9.method3593(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5 + 4, var1, var2, var3, var9.field2903, true, (Renderable)null);
                     var25 = new class49(var4, 4, var26 + 4, var1, var2, var3, var9.field2903, true, (Renderable)null);
                  }

                  var7.method1807(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class10.field104[var5], var27 * class10.field105[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field2903 == -1 && var9.impostorIds == null) {
            var22 = var9.method3593(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 10, var5, var1, var2, var3, var9.field2903, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method1680(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field2923 != 0) {
            var8.method2231(var2, var3, var10, var11, var9.field2898);
         }

      }
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "38"
   )
   static String method3113(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field416 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field416 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field416 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field416 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field416 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class217.field3167) {
         var3 = "/p=" + class217.field3167;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field472 + "/a=" + class171.field2331 + var3 + "/";
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "16711935"
   )
   public boolean method3114(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2138.length) {
         int var3 = this.field2138[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2141[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "938126871"
   )
   static boolean method3115(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class139.method2601(var0, Ignore.field209);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class139.method2601(var3.name, Ignore.field209))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class139.method2601(var3.previousName, Ignore.field209))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-129297895"
   )
   static void method3116(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3215 = var1.readUnsignedShort();
      class225.field3213 = new int[class225.field3215];
      class225.field3216 = new int[class225.field3215];
      class225.field3217 = new int[class225.field3215];
      class178.field2653 = new int[class225.field3215];
      class119.field1845 = new byte[class225.field3215][];
      var1.offset = var0.length - 7 - class225.field3215 * 8;
      class225.field3214 = var1.readUnsignedShort();
      class202.field3060 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3215; ++var3) {
         class225.field3213[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3215; ++var3) {
         class225.field3216[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3215; ++var3) {
         class225.field3217[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3215; ++var3) {
         class178.field2653[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3215 * 8 - 3 * (var2 - 1);
      class225.field3218 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3218[var3] = var1.read24BitInt();
         if(class225.field3218[var3] == 0) {
            class225.field3218[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3215; ++var3) {
         int var4 = class225.field3217[var3];
         int var5 = class178.field2653[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class119.field1845[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
