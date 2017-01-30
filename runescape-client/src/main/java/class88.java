import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class88 {
   @ObfuscatedName("y")
   public static String field1534;
   @ObfuscatedName("g")
   static Client field1536;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -1005585117395808553L
   )
   static long field1539;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "77"
   )
   static final void method1884(class159 var0) {
      int var1 = 0;
      var0.method3054();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field898; ++var2) {
         var3 = class45.field895[var2];
         if((class45.field908[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field908[var3] = (byte)(class45.field908[var3] | 2);
            } else {
               var4 = var0.method3061(1);
               if(var4 == 0) {
                  var1 = NPC.method701(var0);
                  class45.field908[var3] = (byte)(class45.field908[var3] | 2);
               } else {
                  Ignore.method193(var0, var3);
               }
            }
         }
      }

      var0.method3043();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3054();

         for(var2 = 0; var2 < class45.field898; ++var2) {
            var3 = class45.field895[var2];
            if((class45.field908[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field908[var3] = (byte)(class45.field908[var3] | 2);
               } else {
                  var4 = var0.method3061(1);
                  if(var4 == 0) {
                     var1 = NPC.method701(var0);
                     class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                  } else {
                     Ignore.method193(var0, var3);
                  }
               }
            }
         }

         var0.method3043();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3054();

            for(var2 = 0; var2 < class45.field900; ++var2) {
               var3 = class45.field905[var2];
               if((class45.field908[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                  } else {
                     var4 = var0.method3061(1);
                     if(var4 == 0) {
                        var1 = NPC.method701(var0);
                        class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                     } else if(class104.method1989(var0, var3)) {
                        class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                     }
                  }
               }
            }

            var0.method3043();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3054();

               for(var2 = 0; var2 < class45.field900; ++var2) {
                  var3 = class45.field905[var2];
                  if((class45.field908[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                     } else {
                        var4 = var0.method3061(1);
                        if(var4 == 0) {
                           var1 = NPC.method701(var0);
                           class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                        } else if(class104.method1989(var0, var3)) {
                           class45.field908[var3] = (byte)(class45.field908[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3043();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field898 = 0;
                  class45.field900 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field908[var2] = (byte)(class45.field908[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(null != var5) {
                        class45.field895[++class45.field898 - 1] = var2;
                     } else {
                        class45.field905[++class45.field900 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
