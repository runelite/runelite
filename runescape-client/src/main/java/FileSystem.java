import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   static Resampler field3166;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 642153213
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   public byte[] field3165;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-94"
   )
   public static boolean method4620(int var0) {
      return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lge;I)V",
      garbageValue = "358617615"
   )
   static final void method4619(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class81.playerIndexesCount; ++var2) {
         var3 = class81.playerIndices[var2];
         if((class81.field1183[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = class73.method1843(var0);
                  class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
               } else {
                  GrandExchangeEvents.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class81.playerIndexesCount; ++var2) {
            var3 = class81.playerIndices[var2];
            if((class81.field1183[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = class73.method1843(var0);
                     class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                  } else {
                     GrandExchangeEvents.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class81.field1182; ++var2) {
               var3 = class81.field1175[var2];
               if((class81.field1183[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = class73.method1843(var0);
                        class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                     } else if(Widget.decodeRegionHash(var0, var3)) {
                        class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class81.field1182; ++var2) {
                  var3 = class81.field1175[var2];
                  if((class81.field1183[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = class73.method1843(var0);
                           class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                        } else if(Widget.decodeRegionHash(var0, var3)) {
                           class81.field1183[var3] = (byte)(class81.field1183[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class81.playerIndexesCount = 0;
                  class81.field1182 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class81.field1183[var2] = (byte)(class81.field1183[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class81.playerIndices[++class81.playerIndexesCount - 1] = var2;
                     } else {
                        class81.field1175[++class81.field1182 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1680267972"
   )
   static void method4617(boolean var0) {
      class78.loginMessage1 = "";
      class78.loginMessage2 = "Enter your username/email & password.";
      class78.loginMessage3 = "";
      class78.loginIndex = 2;
      if(var0) {
         class78.password = "";
      }

      Occluder.method3110();
      class274.method5248();
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhl;IIIIIII)V",
      garbageValue = "1715888302"
   )
   static final void method4618(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field659) {
         Client.field736 = 32;
      } else {
         Client.field736 = 0;
      }

      Client.field659 = false;
      int var7;
      if(MouseInput.mouseCurrentButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            DState.method3548(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            DState.method3548(var0);
         } else if(var5 >= var1 - Client.field736 && var5 < Client.field736 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            DState.method3548(var0);
            Client.field659 = true;
         }
      }

      if(Client.mouseWheelRotation != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.mouseWheelRotation * 45;
            DState.method3548(var0);
         }
      }

   }
}
