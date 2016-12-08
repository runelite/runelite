import java.awt.Canvas;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class36 {
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 108626349
   )
   static int field774;
   @ObfuscatedName("h")
   static final BigInteger field775 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("v")
   static final BigInteger field778 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("qw")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -981203627
   )
   static int field787;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "250378369"
   )
   static final void method707(class159 var0) {
      int var1 = 0;
      var0.method2969();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field900; ++var2) {
         var3 = class45.field902[var2];
         if((class45.field898[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field898[var3] = (byte)(class45.field898[var3] | 2);
            } else {
               var4 = var0.method2986(1);
               if(var4 == 0) {
                  var1 = class156.method2948(var0);
                  class45.field898[var3] = (byte)(class45.field898[var3] | 2);
               } else {
                  ChatLineBuffer.method895(var0, var3);
               }
            }
         }
      }

      var0.method2992();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2969();

         for(var2 = 0; var2 < class45.field900; ++var2) {
            var3 = class45.field902[var2];
            if((class45.field898[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field898[var3] = (byte)(class45.field898[var3] | 2);
               } else {
                  var4 = var0.method2986(1);
                  if(var4 == 0) {
                     var1 = class156.method2948(var0);
                     class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                  } else {
                     ChatLineBuffer.method895(var0, var3);
                  }
               }
            }
         }

         var0.method2992();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2969();

            for(var2 = 0; var2 < class45.field903; ++var2) {
               var3 = class45.field905[var2];
               if((class45.field898[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                  } else {
                     var4 = var0.method2986(1);
                     if(var4 == 0) {
                        var1 = class156.method2948(var0);
                        class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                     } else if(class165.method3058(var0, var3)) {
                        class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                     }
                  }
               }
            }

            var0.method2992();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2969();

               for(var2 = 0; var2 < class45.field903; ++var2) {
                  var3 = class45.field905[var2];
                  if((class45.field898[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                     } else {
                        var4 = var0.method2986(1);
                        if(var4 == 0) {
                           var1 = class156.method2948(var0);
                           class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                        } else if(class165.method3058(var0, var3)) {
                           class45.field898[var3] = (byte)(class45.field898[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2992();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field900 = 0;
                  class45.field903 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field898[var2] = (byte)(class45.field898[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(null != var5) {
                        class45.field902[++class45.field900 - 1] = var2;
                     } else {
                        class45.field905[++class45.field903 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "-1611564209"
   )
   public static class189 method712(int var0) {
      class189 var1 = (class189)class189.field2789.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class189.field2791.method3203(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3364(new Buffer(var2));
         }

         class189.field2789.put(var1, (long)var0);
         return var1;
      }
   }
}
