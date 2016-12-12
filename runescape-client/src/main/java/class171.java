import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class171 {
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1227404093
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "-1043370692"
   )
   static final void method3175(class159 var0) {
      int var1 = 0;
      var0.method2977();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field908; ++var2) {
         var3 = class45.field903[var2];
         if((class45.field905[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field905[var3] = (byte)(class45.field905[var3] | 2);
            } else {
               var4 = var0.method2978(1);
               if(var4 == 0) {
                  var1 = class40.method717(var0);
                  class45.field905[var3] = (byte)(class45.field905[var3] | 2);
               } else {
                  class63.method1137(var0, var3);
               }
            }
         }
      }

      var0.method2982();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2977();

         for(var2 = 0; var2 < class45.field908; ++var2) {
            var3 = class45.field903[var2];
            if((class45.field905[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field905[var3] = (byte)(class45.field905[var3] | 2);
               } else {
                  var4 = var0.method2978(1);
                  if(var4 == 0) {
                     var1 = class40.method717(var0);
                     class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                  } else {
                     class63.method1137(var0, var3);
                  }
               }
            }
         }

         var0.method2982();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2977();

            for(var2 = 0; var2 < class45.field910; ++var2) {
               var3 = class45.field911[var2];
               if((class45.field905[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                  } else {
                     var4 = var0.method2978(1);
                     if(var4 == 0) {
                        var1 = class40.method717(var0);
                        class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                     } else if(class118.method2250(var0, var3)) {
                        class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                     }
                  }
               }
            }

            var0.method2982();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2977();

               for(var2 = 0; var2 < class45.field910; ++var2) {
                  var3 = class45.field911[var2];
                  if((class45.field905[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                     } else {
                        var4 = var0.method2978(1);
                        if(var4 == 0) {
                           var1 = class40.method717(var0);
                           class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                        } else if(class118.method2250(var0, var3)) {
                           class45.field905[var3] = (byte)(class45.field905[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2982();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field908 = 0;
                  class45.field910 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field905[var2] = (byte)(class45.field905[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class45.field903[++class45.field908 - 1] = var2;
                     } else {
                        class45.field911[++class45.field910 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1426773056"
   )
   static void method3176() {
      class47.chatLineMap.clear();
      class47.field944.method2277();
      class47.field940.method2428();
      class47.field939 = 0;
   }
}
