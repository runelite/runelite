import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class140 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field2081;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1182865225
   )
   static int field2080;

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   static final void method2791() {
      if(MessageNode.soundSystem1 != null) {
         MessageNode.soundSystem1.method1941();
      }

      if(VertexNormal.soundSystem0 != null) {
         VertexNormal.soundSystem0.method1941();
      }

   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2095837533"
   )
   static final void method2793(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1107; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1109[var4] = true;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "19136782"
   )
   static final void method2790(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class96.field1480 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class96.field1469; ++var4) {
         var5 = class96.field1470[var4];
         if((class96.field1466[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = class60.method979(var0);
                  class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
               } else {
                  Varcs.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class96.field1469; ++var4) {
            var5 = class96.field1470[var4];
            if((class96.field1466[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = class60.method979(var0);
                     class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                  } else {
                     Varcs.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class96.field1476; ++var4) {
               var5 = class96.field1472[var4];
               if((class96.field1466[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = class60.method979(var0);
                        class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                     } else if(class23.decodeRegionHash(var0, var5)) {
                        class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class96.field1476; ++var4) {
                  var5 = class96.field1472[var4];
                  if((class96.field1466[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = class60.method979(var0);
                           class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                        } else if(class23.decodeRegionHash(var0, var5)) {
                           class96.field1466[var5] = (byte)(class96.field1466[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1469 = 0;
                  class96.field1476 = 0;

                  Player var7;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class96.field1466[var4] = (byte)(class96.field1466[var4] >> 1);
                     var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class96.field1470[++class96.field1469 - 1] = var4;
                     } else {
                        class96.field1472[++class96.field1476 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class96.field1480; ++var3) {
                     var4 = class96.field1465[var3];
                     var7 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 1) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     class73.method1068(var0, var4, var7, var6);
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1146742780"
   )
   static final int method2792(int var0, int var1) {
      int var2 = class37.getSmoothNoise(var0 + '넵', var1 + 91923, 4) - 128 + (class37.getSmoothNoise(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class37.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
