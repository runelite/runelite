import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class76 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2038557729
   )
   static int field1384;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 968910939
   )
   static int field1385;
   @ObfuscatedName("y")
   static int[] field1387;
   @ObfuscatedName("q")
   static byte[][] field1388;
   @ObfuscatedName("c")
   static int[] field1389;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-54"
   )
   static int method1762(int var0) {
      class35 var1 = (class35)class11.field181.method3889((long)var0);
      return null == var1?-1:(var1.field3114 == class11.field182.field3109?-1:((class35)var1.field3114).field797);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "42"
   )
   static String method1764(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-753433331"
   )
   static final void method1765(class122 var0) {
      int var1 = 0;
      var0.method2866();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field771; ++var2) {
         var3 = class32.field762[var2];
         if((class32.field768[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class32.field768[var3] = (byte)(class32.field768[var3] | 2);
            } else {
               var4 = var0.method2863(1);
               if(var4 == 0) {
                  var1 = class179.method3568(var0);
                  class32.field768[var3] = (byte)(class32.field768[var3] | 2);
               } else {
                  class131.method2962(var0, var3);
               }
            }
         }
      }

      var0.method2868();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2866();

         for(var2 = 0; var2 < class32.field771; ++var2) {
            var3 = class32.field762[var2];
            if(0 != (class32.field768[var3] & 1)) {
               if(var1 > 0) {
                  --var1;
                  class32.field768[var3] = (byte)(class32.field768[var3] | 2);
               } else {
                  var4 = var0.method2863(1);
                  if(var4 == 0) {
                     var1 = class179.method3568(var0);
                     class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                  } else {
                     class131.method2962(var0, var3);
                  }
               }
            }
         }

         var0.method2868();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2866();

            for(var2 = 0; var2 < class32.field764; ++var2) {
               var3 = class32.field765[var2];
               if(0 != (class32.field768[var3] & 1)) {
                  if(var1 > 0) {
                     --var1;
                     class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                  } else {
                     var4 = var0.method2863(1);
                     if(0 == var4) {
                        var1 = class179.method3568(var0);
                        class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                     } else if(class175.method3529(var0, var3)) {
                        class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                     }
                  }
               }
            }

            var0.method2868();
            if(0 != var1) {
               throw new RuntimeException();
            } else {
               var0.method2866();

               for(var2 = 0; var2 < class32.field764; ++var2) {
                  var3 = class32.field765[var2];
                  if((class32.field768[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                     } else {
                        var4 = var0.method2863(1);
                        if(var4 == 0) {
                           var1 = class179.method3568(var0);
                           class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                        } else if(class175.method3529(var0, var3)) {
                           class32.field768[var3] = (byte)(class32.field768[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2868();
               if(0 != var1) {
                  throw new RuntimeException();
               } else {
                  class32.field771 = 0;
                  class32.field764 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field768[var2] = (byte)(class32.field768[var2] >> 1);
                     class2 var5 = client.field550[var2];
                     if(null != var5) {
                        class32.field762[++class32.field771 - 1] = var2;
                     } else {
                        class32.field765[++class32.field764 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
