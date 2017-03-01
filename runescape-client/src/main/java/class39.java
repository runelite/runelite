import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class39 {
   @ObfuscatedName("n")
   static final BigInteger field803 = new BigInteger("a7da3c4d8d0472d526b2037fdc8b914254a845021e43735ed7ed3f51543484c64854755047bd4124c8376a3c1a9c4d7d5537a29a06a6d1da70c40db0f5176b257990b74422eb48ca095427f6c959385b76204e612622ac0619c3e7273b52a5db0c726a055d47305e475de4929114a51a7ad6129ec2ec40748db7b7db47312227", 16);
   @ObfuscatedName("e")
   public static String field804;
   @ObfuscatedName("x")
   static final BigInteger field805 = new BigInteger("10001", 16);
   @ObfuscatedName("by")
   static ModIcon[] field806;
   @ObfuscatedName("bx")
   static class184 field808;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static int method821(int var0, int var1, int var2) {
      return (class10.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class10.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1683176247"
   )
   static final void method822(class159 var0) {
      int var1 = 0;
      var0.method3165();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field916; ++var2) {
         var3 = class45.field913[var2];
         if((class45.field909[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field909[var3] = (byte)(class45.field909[var3] | 2);
            } else {
               var4 = var0.method3147(1);
               if(var4 == 0) {
                  var1 = class20.method208(var0);
                  class45.field909[var3] = (byte)(class45.field909[var3] | 2);
               } else {
                  MessageNode.method221(var0, var3);
               }
            }
         }
      }

      var0.method3148();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3165();

         for(var2 = 0; var2 < class45.field916; ++var2) {
            var3 = class45.field913[var2];
            if((class45.field909[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field909[var3] = (byte)(class45.field909[var3] | 2);
               } else {
                  var4 = var0.method3147(1);
                  if(var4 == 0) {
                     var1 = class20.method208(var0);
                     class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                  } else {
                     MessageNode.method221(var0, var3);
                  }
               }
            }
         }

         var0.method3148();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3165();

            for(var2 = 0; var2 < class45.field914; ++var2) {
               var3 = class45.field915[var2];
               if((class45.field909[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                  } else {
                     var4 = var0.method3147(1);
                     if(var4 == 0) {
                        var1 = class20.method208(var0);
                        class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                     } else if(class8.method105(var0, var3)) {
                        class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                     }
                  }
               }
            }

            var0.method3148();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3165();

               for(var2 = 0; var2 < class45.field914; ++var2) {
                  var3 = class45.field915[var2];
                  if((class45.field909[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                     } else {
                        var4 = var0.method3147(1);
                        if(var4 == 0) {
                           var1 = class20.method208(var0);
                           class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                        } else if(class8.method105(var0, var3)) {
                           class45.field909[var3] = (byte)(class45.field909[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3148();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field916 = 0;
                  class45.field914 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field909[var2] = (byte)(class45.field909[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class45.field913[++class45.field916 - 1] = var2;
                     } else {
                        class45.field915[++class45.field914 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "965864350"
   )
   static final void method823(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class25.method615(var0, var1, CollisionData.plane) - var2;
         var0 -= FaceNormal.cameraX;
         var3 -= class45.cameraZ;
         var1 -= ChatLineBuffer.cameraY;
         int var4 = class84.field1460[class10.cameraPitch];
         int var5 = class84.field1446[class10.cameraPitch];
         int var6 = class84.field1460[Projectile.cameraYaw];
         int var7 = class84.field1446[Projectile.cameraYaw];
         int var8 = var1 * var6 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var1 * var5 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field447 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field469 = Client.camera3 / 2 + var8 * Client.scale / var1;
         } else {
            Client.field447 = -1;
            Client.field469 = -1;
         }

      } else {
         Client.field447 = -1;
         Client.field469 = -1;
      }
   }

   class39() throws Throwable {
      throw new Error();
   }
}
