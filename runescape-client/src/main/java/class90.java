import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class90 {
   @ObfuscatedName("w")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("i")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-1689035948"
   )
   @Export("decodeLocationUpdates")
   static final void decodeLocationUpdates(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class96.field1521; ++var2) {
         var3 = class96.field1531[var2];
         if((class96.field1516[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = Huffman.method3070(var0);
                  class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
               } else {
                  class34.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class96.field1521; ++var2) {
            var3 = class96.field1531[var2];
            if((class96.field1516[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = Huffman.method3070(var0);
                     class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                  } else {
                     class34.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class96.field1523; ++var2) {
               var3 = class96.field1524[var2];
               if((class96.field1516[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = Huffman.method3070(var0);
                        class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                     } else if(class149.decodeRegionHash(var0, var3)) {
                        class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class96.field1523; ++var2) {
                  var3 = class96.field1524[var2];
                  if((class96.field1516[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = Huffman.method3070(var0);
                           class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                        } else if(class149.decodeRegionHash(var0, var3)) {
                           class96.field1516[var3] = (byte)(class96.field1516[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1521 = 0;
                  class96.field1523 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class96.field1516[var2] = (byte)(class96.field1516[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class96.field1531[++class96.field1521 - 1] = var2;
                     } else {
                        class96.field1524[++class96.field1523 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9ac266a7a987cc36991e3300d13ae9482581a53cbf9444bc396e5a1823f7b3d19312c803d8c3fb964c8c47c5aea99aac55267773f9b11d7a7e3a9a27601e0bc5691db90c1b7e3e9d1c4af3b6f56662377da780535fd83c4dd6f5aeda68c976ef853de8d1737e6df52b03763e4486537781d7589c0815f9b2bc28b238f46b1bfd", 16);
   }
}
