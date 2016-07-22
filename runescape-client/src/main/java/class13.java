import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class13 implements Runnable {
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -117373977
   )
   protected static int field176;
   @ObfuscatedName("g")
   int[] field178 = new int[500];
   @ObfuscatedName("o")
   int[] field179 = new int[500];
   @ObfuscatedName("w")
   Object field180 = new Object();
   @ObfuscatedName("mx")
   static byte field181;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1745996799
   )
   @Export("baseY")
   static int field184;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1351987453
   )
   int field185 = 0;
   @ObfuscatedName("m")
   boolean field186 = true;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2098964374"
   )
   public static void method156(boolean var0) {
      if(class174.field2766 != null) {
         try {
            class122 var1 = new class122(4);
            var1.method2557(var0?2:3);
            var1.method2559(0);
            class174.field2766.method3045(var1.field2047, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2766.method3050();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2767;
            class174.field2766 = null;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;B)V",
      garbageValue = "14"
   )
   public static void method157(class170 var0, class170 var1) {
      class49.field1089 = var0;
      class49.field1103 = var1;
   }

   public void run() {
      for(; this.field186; class141.method2993(50L)) {
         Object var1 = this.field180;
         synchronized(this.field180) {
            if(this.field185 < 500) {
               this.field179[this.field185] = class143.field2213;
               this.field178[this.field185] = class143.field2214;
               ++this.field185;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)V",
      garbageValue = "-103"
   )
   static final void method159(class125 var0, int var1) {
      int var2 = var0.field2045;
      class34.field782 = 0;
      int var3 = 0;
      var0.method2799();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class34.field777; ++var4) {
         var5 = class34.field780[var4];
         if((class34.field772[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class34.field772[var5] = (byte)(class34.field772[var5] | 2);
            } else {
               var6 = var0.method2813(1);
               if(var6 == 0) {
                  var3 = class21.method566(var0);
                  class34.field772[var5] = (byte)(class34.field772[var5] | 2);
               } else {
                  class32.method675(var0, var5);
               }
            }
         }
      }

      var0.method2800();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2799();

         for(var4 = 0; var4 < class34.field777; ++var4) {
            var5 = class34.field780[var4];
            if((class34.field772[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class34.field772[var5] = (byte)(class34.field772[var5] | 2);
               } else {
                  var6 = var0.method2813(1);
                  if(var6 == 0) {
                     var3 = class21.method566(var0);
                     class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                  } else {
                     class32.method675(var0, var5);
                  }
               }
            }
         }

         var0.method2800();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2799();

            for(var4 = 0; var4 < class34.field770; ++var4) {
               var5 = class34.field774[var4];
               if((class34.field772[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                  } else {
                     var6 = var0.method2813(1);
                     if(var6 == 0) {
                        var3 = class21.method566(var0);
                        class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                     } else if(class42.method880(var0, var5)) {
                        class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                     }
                  }
               }
            }

            var0.method2800();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2799();

               for(var4 = 0; var4 < class34.field770; ++var4) {
                  var5 = class34.field774[var4];
                  if((class34.field772[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                     } else {
                        var6 = var0.method2813(1);
                        if(var6 == 0) {
                           var3 = class21.method566(var0);
                           class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                        } else if(class42.method880(var0, var5)) {
                           class34.field772[var5] = (byte)(class34.field772[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2800();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field777 = 0;
                  class34.field770 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class34.field772[var4] = (byte)(class34.field772[var4] >> 1);
                     class2 var7 = client.field393[var4];
                     if(null != var7) {
                        class34.field780[++class34.field777 - 1] = var4;
                     } else {
                        class34.field774[++class34.field770 - 1] = var4;
                     }
                  }

                  class168.method3294(var0);
                  if(var1 != var0.field2045 - var2) {
                     throw new RuntimeException(var0.field2045 - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
