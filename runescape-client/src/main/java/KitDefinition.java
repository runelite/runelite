import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("m")
   short[] field1050;
   @ObfuscatedName("q")
   public static class170 field1051;
   @ObfuscatedName("c")
   public static NodeCache field1052 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1464681725
   )
   public int field1053 = -1;
   @ObfuscatedName("k")
   public static class170 field1054;
   @ObfuscatedName("h")
   short[] field1055;
   @ObfuscatedName("y")
   short[] field1056;
   @ObfuscatedName("u")
   short[] field1057;
   @ObfuscatedName("b")
   public boolean field1058 = false;
   @ObfuscatedName("l")
   int[] field1059 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("dy")
   static int[] field1060;
   @ObfuscatedName("j")
   int[] field1062;
   @ObfuscatedName("bf")
   protected static FontMetrics field1064;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1911598539"
   )
   void method952(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method953(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "520016817"
   )
   void method953(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1053 = var1.method2571();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2571();
            this.field1062 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1062[var4] = var1.method2691();
            }
         } else if(var2 == 3) {
            this.field1058 = true;
         } else if(var2 == 40) {
            var3 = var1.method2571();
            this.field1050 = new short[var3];
            this.field1056 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1050[var4] = (short)var1.method2691();
               this.field1056[var4] = (short)var1.method2691();
            }
         } else if(var2 == 41) {
            var3 = var1.method2571();
            this.field1057 = new short[var3];
            this.field1055 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1057[var4] = (short)var1.method2691();
               this.field1055[var4] = (short)var1.method2691();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1059[var2 - 60] = var1.method2691();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1027860045"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1062 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1062.length];

         for(int var4 = 0; var4 < this.field1062.length; ++var4) {
            var1[var4] = ModelData.method2274(field1051, this.field1062[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field1050 != null) {
            for(var3 = 0; var3 < this.field1050.length; ++var3) {
               var2.method2285(this.field1050[var3], this.field1056[var3]);
            }
         }

         if(null != this.field1057) {
            for(var3 = 0; var3 < this.field1057.length; ++var3) {
               var2.method2286(this.field1057[var3], this.field1055[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "947272114"
   )
   static void method955(class125 var0, int var1) {
      boolean var2 = var0.method2807(1) == 1;
      if(var2) {
         class34.field767[++class34.field779 - 1] = var1;
      }

      int var3 = var0.method2807(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field52 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class34.field776[var1] = (class21.baseY + var4.pathY[0] >> 6) + (class47.baseX + var4.pathX[0] >> 6 << 14) + (var4.field55 << 28);
            if(var4.field845 != -1) {
               class34.field772[var1] = var4.field845;
            } else {
               class34.field772[var1] = var4.field876;
            }

            class34.field778[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2807(1) != 0) {
               class77.method1651(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2807(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field52 = true;
                  var4.field53 = var6;
                  var4.field35 = var7;
               } else {
                  var4.field52 = false;
                  var4.method14(var6, var7, class34.field770[var1]);
               }
            } else {
               var4.method10(var6, var7);
               var4.field52 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2807(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method10(var6, var7);
               var4.field52 = false;
            } else if(var2) {
               var4.field52 = true;
               var4.field53 = var6;
               var4.field35 = var7;
            } else {
               var4.field52 = false;
               var4.method14(var6, var7, class34.field770[var1]);
            }

         } else {
            var5 = var0.method2807(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2807(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field52 = true;
                     var4.field53 = var10;
                     var4.field35 = var11;
                  } else {
                     var4.field52 = false;
                     var4.method14(var10, var11, class34.field770[var1]);
                  }
               } else {
                  var4.method10(var10, var11);
                  var4.field52 = false;
               }

               var4.field55 = (byte)(var4.field55 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class145.plane = var4.field55;
               }

            } else {
               var6 = var0.method2807(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class47.baseX & 16383) - class47.baseX;
               var11 = (class21.baseY + var4.pathY[0] + var9 & 16383) - class21.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field52 = true;
                     var4.field53 = var10;
                     var4.field35 = var11;
                  } else {
                     var4.field52 = false;
                     var4.method14(var10, var11, class34.field770[var1]);
                  }
               } else {
                  var4.method10(var10, var11);
                  var4.field52 = false;
               }

               var4.field55 = (byte)(var4.field55 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class145.plane = var4.field55;
               }

            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-31"
   )
   public boolean method956() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1059[var2] != -1 && !field1051.method3282(this.field1059[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-6"
   )
   public ModelData method957() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1059[var3] != -1) {
            var1[var2++] = ModelData.method2274(field1051, this.field1059[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field1050 != null) {
         for(var4 = 0; var4 < this.field1050.length; ++var4) {
            var5.method2285(this.field1050[var4], this.field1056[var4]);
         }
      }

      if(this.field1057 != null) {
         for(var4 = 0; var4 < this.field1057.length; ++var4) {
            var5.method2286(this.field1057[var4], this.field1055[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1488489792"
   )
   public static String method962(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1065398178"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1062 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1062.length; ++var2) {
            if(!field1051.method3282(this.field1062[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1557212660"
   )
   public static int method974(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
