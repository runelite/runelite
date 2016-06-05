import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -438963429
   )
   @Export("modelHeight")
   public int field1466 = 1000;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   @Export("getModel")
   protected class105 vmethod1862() {
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "1"
   )
   static final void method1864(class122 var0) {
      int var1 = 0;
      var0.method2726();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field741; ++var2) {
         var3 = class32.field742[var2];
         if((class32.field738[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class32.field738[var3] = (byte)(class32.field738[var3] | 2);
            } else {
               var4 = var0.method2713(1);
               if(var4 == 0) {
                  var1 = class155.method3136(var0);
                  class32.field738[var3] = (byte)(class32.field738[var3] | 2);
               } else {
                  class142.method2957(var0, var3);
               }
            }
         }
      }

      var0.method2714();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2726();

         for(var2 = 0; var2 < class32.field741; ++var2) {
            var3 = class32.field742[var2];
            if((class32.field738[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class32.field738[var3] = (byte)(class32.field738[var3] | 2);
               } else {
                  var4 = var0.method2713(1);
                  if(var4 == 0) {
                     var1 = class155.method3136(var0);
                     class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                  } else {
                     class142.method2957(var0, var3);
                  }
               }
            }
         }

         var0.method2714();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2726();

            for(var2 = 0; var2 < class32.field743; ++var2) {
               var3 = class32.field744[var2];
               if((class32.field738[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                  } else {
                     var4 = var0.method2713(1);
                     if(var4 == 0) {
                        var1 = class155.method3136(var0);
                        class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                     } else if(class114.method2406(var0, var3)) {
                        class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                     }
                  }
               }
            }

            var0.method2714();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2726();

               for(var2 = 0; var2 < class32.field743; ++var2) {
                  var3 = class32.field744[var2];
                  if((class32.field738[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                     } else {
                        var4 = var0.method2713(1);
                        if(var4 == 0) {
                           var1 = class155.method3136(var0);
                           class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                        } else if(class114.method2406(var0, var3)) {
                           class32.field738[var3] = (byte)(class32.field738[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2714();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field741 = 0;
                  class32.field743 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field738[var2] = (byte)(class32.field738[var2] >> 1);
                     class2 var5 = client.field405[var2];
                     if(var5 != null) {
                        class32.field742[++class32.field741 - 1] = var2;
                     } else {
                        class32.field744[++class32.field743 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ag")
   void vmethod2317(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1862();
      if(var10 != null) {
         this.field1466 = var10.field1466;
         var10.vmethod2317(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1765919807"
   )
   static int method1868(int var0, int var1, int var2) {
      return (class5.field83[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class5.field83[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
