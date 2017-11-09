import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class94 {
   @ObfuscatedName("i")
   static byte[] field1407;
   @ObfuscatedName("j")
   static byte[] field1411;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lfv;"
   )
   static Buffer[] field1404;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1607619437
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("e")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 931325799
   )
   static int field1403;
   @ObfuscatedName("b")
   static int[] field1402;
   @ObfuscatedName("n")
   static int[] field1409;
   @ObfuscatedName("c")
   static int[] field1410;
   @ObfuscatedName("a")
   static int[] field1412;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1355057963
   )
   static int field1408;
   @ObfuscatedName("w")
   static int[] field1415;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   static Buffer field1414;

   static {
      field1407 = new byte[2048];
      field1411 = new byte[2048];
      field1404 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1403 = 0;
      field1402 = new int[2048];
      field1409 = new int[2048];
      field1410 = new int[2048];
      field1412 = new int[2048];
      field1408 = 0;
      field1415 = new int[2048];
      field1414 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljc;",
      garbageValue = "1333126289"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3615.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1333489444"
   )
   public static int method1871(CharSequence var0) {
      return class246.parseInt(var0, 10, true);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1143149791"
   )
   static void method1859(int var0, int var1, int var2, int var3) {
      for(class81 var4 = (class81)class81.field1250.getFront(); var4 != null; var4 = (class81)class81.field1250.getNext()) {
         if(var4.field1238 != -1 || var4.field1248 != null) {
            int var5 = 0;
            if(var1 > var4.field1237) {
               var5 += var1 - var4.field1237;
            } else if(var1 < var4.field1239) {
               var5 += var4.field1239 - var1;
            }

            if(var2 > var4.field1242) {
               var5 += var2 - var4.field1242;
            } else if(var2 < var4.field1240) {
               var5 += var4.field1240 - var2;
            }

            if(var5 - 64 <= var4.field1241 && Client.field1067 != 0 && var0 == var4.field1244) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1241 - var5) * Client.field1067 / var4.field1241;
               if(var4.field1245 == null) {
                  if(var4.field1238 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(Tile.field1838, var4.field1238, 0);
                     if(var7 != null) {
                        class106 var8 = var7.method2038().method2080(class231.field2920);
                        class116 var9 = class116.method2235(var8, 100, var6);
                        var9.method2220(-1);
                        class268.field3675.method1972(var9);
                        var4.field1245 = var9;
                     }
                  }
               } else {
                  var4.field1245.method2221(var6);
               }

               if(var4.field1243 == null) {
                  if(var4.field1248 != null && (var4.field1249 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1248.length);
                     SoundEffect var12 = SoundEffect.getTrack(Tile.field1838, var4.field1248[var11], 0);
                     if(var12 != null) {
                        class106 var13 = var12.method2038().method2080(class231.field2920);
                        class116 var10 = class116.method2235(var13, 100, var6);
                        var10.method2220(0);
                        class268.field3675.method1972(var10);
                        var4.field1243 = var10;
                        var4.field1249 = var4.field1246 + (int)(Math.random() * (double)(var4.field1247 - var4.field1246));
                     }
                  }
               } else {
                  var4.field1243.method2221(var6);
                  if(!var4.field1243.linked()) {
                     var4.field1243 = null;
                  }
               }
            } else {
               if(var4.field1245 != null) {
                  class268.field3675.method1984(var4.field1245);
                  var4.field1245 = null;
               }

               if(var4.field1243 != null) {
                  class268.field3675.method1984(var4.field1243);
                  var4.field1243 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "65"
   )
   static final void method1867(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
