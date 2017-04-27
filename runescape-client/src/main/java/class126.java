import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class126 {
   @ObfuscatedName("t")
   static ModIcon[] field1909;

   class126() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;I)V",
      garbageValue = "-1495237127"
   )
   static final void method2358(PacketBuffer var0) {
      int var1 = 0;
      var0.method2644();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field891; ++var2) {
         var3 = class45.field894[var2];
         if((class45.field888[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field888[var3] = (byte)(class45.field888[var3] | 2);
            } else {
               var4 = var0.readBits(1);
               if(var4 == 0) {
                  var1 = VertexNormal.method1647(var0);
                  class45.field888[var3] = (byte)(class45.field888[var3] | 2);
               } else {
                  class37.method762(var0, var3);
               }
            }
         }
      }

      var0.method2647();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2644();

         for(var2 = 0; var2 < class45.field891; ++var2) {
            var3 = class45.field894[var2];
            if((class45.field888[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field888[var3] = (byte)(class45.field888[var3] | 2);
               } else {
                  var4 = var0.readBits(1);
                  if(var4 == 0) {
                     var1 = VertexNormal.method1647(var0);
                     class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                  } else {
                     class37.method762(var0, var3);
                  }
               }
            }
         }

         var0.method2647();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2644();

            for(var2 = 0; var2 < class45.field893; ++var2) {
               var3 = class45.field886[var2];
               if((class45.field888[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                  } else {
                     var4 = var0.readBits(1);
                     if(var4 == 0) {
                        var1 = VertexNormal.method1647(var0);
                        class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                     } else if(IndexFile.method2245(var0, var3)) {
                        class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                     }
                  }
               }
            }

            var0.method2647();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2644();

               for(var2 = 0; var2 < class45.field893; ++var2) {
                  var3 = class45.field886[var2];
                  if((class45.field888[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                     } else {
                        var4 = var0.readBits(1);
                        if(var4 == 0) {
                           var1 = VertexNormal.method1647(var0);
                           class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                        } else if(IndexFile.method2245(var0, var3)) {
                           class45.field888[var3] = (byte)(class45.field888[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2647();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field891 = 0;
                  class45.field893 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field888[var2] = (byte)(class45.field888[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class45.field894[++class45.field891 - 1] = var2;
                     } else {
                        class45.field886[++class45.field893 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
