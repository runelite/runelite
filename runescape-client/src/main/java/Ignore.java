import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static Font field852;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexData field855;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("e")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljd;",
      garbageValue = "-908586764"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;B)V",
      garbageValue = "1"
   )
   static final void method1116(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class97.field1493; ++var2) {
         var3 = class97.field1494[var2];
         if((class97.field1490[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = class163.method3092(var0);
                  class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
               } else {
                  decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class97.field1493; ++var2) {
            var3 = class97.field1494[var2];
            if((class97.field1490[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = class163.method3092(var0);
                     class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                  } else {
                     decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class97.field1495; ++var2) {
               var3 = class97.field1498[var2];
               if((class97.field1490[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = class163.method3092(var0);
                        class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                     } else if(class46.decodeRegionHash(var0, var3)) {
                        class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class97.field1495; ++var2) {
                  var3 = class97.field1498[var2];
                  if((class97.field1490[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = class163.method3092(var0);
                           class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                        } else if(class46.decodeRegionHash(var0, var3)) {
                           class97.field1490[var3] = (byte)(class97.field1490[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class97.field1493 = 0;
                  class97.field1495 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class97.field1490[var2] = (byte)(class97.field1490[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class97.field1494[++class97.field1493 - 1] = var2;
                     } else {
                        class97.field1498[++class97.field1495 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;Lit;Lgl;I)Z",
      garbageValue = "1976362689"
   )
   public static boolean method1114(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class205 var3) {
      class204.field2492 = var0;
      class204.field2483 = var1;
      class204.field2484 = var2;
      class204.field2486 = var3;
      return true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "32768"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class97.field1501[++class97.field1500 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field902 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class97.field1497[var1] = (class25.baseX + var4.pathX[0] >> 13 << 14) + (var4.field900 << 28) + (ScriptEvent.baseY + var4.pathY[0] >> 13);
            if(var4.field1205 != -1) {
               class97.field1496[var1] = var4.field1205;
            } else {
               class97.field1496[var1] = var4.orientation;
            }

            class97.field1499[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class46.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
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

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1168(var6, var7);
               var4.field902 = false;
            } else if(var2) {
               var4.field902 = true;
               var4.field896 = var6;
               var4.field888 = var7;
            } else {
               var4.field902 = false;
               var4.method1147(var6, var7, class97.field1491[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
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

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1168(var6, var7);
               var4.field902 = false;
            } else if(var2) {
               var4.field902 = true;
               var4.field896 = var6;
               var4.field888 = var7;
            } else {
               var4.field902 = false;
               var4.method1147(var6, var7, class97.field1491[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
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
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1168(var10, var11);
                  var4.field902 = false;
               } else if(var2) {
                  var4.field902 = true;
                  var4.field896 = var10;
                  var4.field888 = var11;
               } else {
                  var4.field902 = false;
                  var4.method1147(var10, var11, class97.field1491[var1]);
               }

               var4.field900 = (byte)(var7 + var4.field900 & 3);
               if(Client.localInteractingIndex == var1) {
                  class29.plane = var4.field900;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class25.baseX + var4.pathX[0] & 16383) - class25.baseX;
               var11 = (var9 + ScriptEvent.baseY + var4.pathY[0] & 16383) - ScriptEvent.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1168(var10, var11);
                  var4.field902 = false;
               } else if(var2) {
                  var4.field902 = true;
                  var4.field896 = var10;
                  var4.field888 = var11;
               } else {
                  var4.field902 = false;
                  var4.method1147(var10, var11, class97.field1491[var1]);
               }

               var4.field900 = (byte)(var7 + var4.field900 & 3);
               if(Client.localInteractingIndex == var1) {
                  class29.plane = var4.field900;
               }

            }
         }
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lhg;I)Lhg;",
      garbageValue = "1164592069"
   )
   static Widget method1115(Widget var0) {
      int var2 = class15.getWidgetConfig(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class266.method4862(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "969673366"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class60.getSmoothNoise2D(var3, var5);
      int var8 = class60.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class60.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class60.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = (var8 * var12 >> 16) + ((65536 - var12) * var7 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = (var13 * var16 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }
}
