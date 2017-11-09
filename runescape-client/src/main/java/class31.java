import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class31 {
   @ObfuscatedName("e")
   static int[] field428;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1411962921
   )
   final int field429;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1132105345
   )
   final int field423;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -486615915
   )
   final int field424;

   class31(int var1, int var2, int var3) {
      this.field429 = var1;
      this.field423 = var2;
      this.field424 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   static void method307(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-30"
   )
   static boolean method306(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "30"
   )
   static synchronized byte[] method304(int var0) {
      return class181.method3513(var0, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgi;I)V",
      garbageValue = "1628895621"
   )
   static final void method308(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
         var3 = class94.playerIndices[var2];
         if((class94.field1407[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = Overlay.method4853(var0);
                  class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
               } else {
                  class51.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
            var3 = class94.playerIndices[var2];
            if((class94.field1407[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = Overlay.method4853(var0);
                     class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                  } else {
                     class51.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class94.field1403; ++var2) {
               var3 = class94.field1402[var2];
               if((class94.field1407[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = Overlay.method4853(var0);
                        class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                     } else if(class37.decodeRegionHash(var0, var3)) {
                        class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class94.field1403; ++var2) {
                  var3 = class94.field1402[var2];
                  if((class94.field1407[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = Overlay.method4853(var0);
                           class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                        } else if(class37.decodeRegionHash(var0, var3)) {
                           class94.field1407[var3] = (byte)(class94.field1407[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1403 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class94.field1407[var2] = (byte)(class94.field1407[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class94.playerIndices[++class94.playerIndexesCount - 1] = var2;
                     } else {
                        class94.field1402[++class94.field1403 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1598733868"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class54.getSmoothNoise2D(var3, var5);
      int var8 = class54.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class54.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class54.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = class158.method3084(var7, var8, var4, var2);
      int var12 = class158.method3084(var9, var10, var4, var2);
      return class158.method3084(var11, var12, var6, var2);
   }
}
