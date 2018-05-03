import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;
   @ObfuscatedName("p")
   static int[][][] field271;
   @ObfuscatedName("ac")
   static java.awt.Font field265;
   @ObfuscatedName("fv")
   static byte[][] field270;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("g")
   public static final void method59(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            GameEngine.method949(var0 - 1L);
            GameEngine.method949(1L);
         } else {
            GameEngine.method949(var0);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1647325483"
   )
   public static void method58() {
      class326.classInfos = new CombatInfoList();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "827590057"
   )
   static final void method60(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
         var3 = class93.playerIndices[var2];
         if((class93.field1415[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = Script.method2103(var0);
                  class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
               } else {
                  ISAACCipher.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
            var3 = class93.playerIndices[var2];
            if((class93.field1415[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = Script.method2103(var0);
                     class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                  } else {
                     ISAACCipher.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class93.field1409; ++var2) {
               var3 = class93.field1410[var2];
               if((class93.field1415[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = Script.method2103(var0);
                        class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                     } else if(Preferences.decodeRegionHash(var0, var3)) {
                        class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class93.field1409; ++var2) {
                  var3 = class93.field1410[var2];
                  if((class93.field1415[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = Script.method2103(var0);
                           class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                        } else if(Preferences.decodeRegionHash(var0, var3)) {
                           class93.field1415[var3] = (byte)(class93.field1415[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class93.playerIndexesCount = 0;
                  class93.field1409 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class93.field1415[var2] = (byte)(class93.field1415[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class93.playerIndices[++class93.playerIndexesCount - 1] = var2;
                     } else {
                        class93.field1410[++class93.field1409 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1021597585"
   )
   public static boolean method61(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
