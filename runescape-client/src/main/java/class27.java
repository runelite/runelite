import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("World")
public class class27 {
   @ObfuscatedName("h")
   @Export("worldList")
   static class27[] field662;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 976329511
   )
   static int field663 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 272234179
   )
   static int field664 = 0;
   @ObfuscatedName("u")
   static int[] field665 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("n")
   static int[] field666 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2015588423
   )
   @Export("id")
   int field667;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2118690697
   )
   @Export("mask")
   int field668;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -701554265
   )
   @Export("playerCount")
   int field669;
   @ObfuscatedName("w")
   @Export("address")
   String field670;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 155600739
   )
   @Export("location")
   int field672;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2043298423
   )
   @Export("index")
   int field673;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 1215174217
   )
   static int field675;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = 853487120824154031L
   )
   static long field677;
   @ObfuscatedName("o")
   @Export("activity")
   String field680;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-50"
   )
   boolean method632() {
      return (1 & this.field668) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "3"
   )
   boolean method633() {
      return (2 & this.field668) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "13"
   )
   boolean method634() {
      return (4 & this.field668) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "335241831"
   )
   boolean method635() {
      return (8 & this.field668) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "79"
   )
   boolean method636() {
      return (536870912 & this.field668) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "255"
   )
   boolean method637() {
      return (33554432 & this.field668) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "47354604"
   )
   static String method645() {
      String var0 = "";

      class37 var2;
      for(Iterator var1 = class11.field174.iterator(); var1.hasNext(); var0 = var0 + var2.field810 + ':' + var2.field807 + '\n') {
         var2 = (class37)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-12"
   )
   static final boolean method655(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)V",
      garbageValue = "0"
   )
   static final void method664(class125 var0) {
      int var1 = 0;
      var0.method2899();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class34.field783; ++var2) {
         var3 = class34.field784[var2];
         if((class34.field782[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class34.field782[var3] = (byte)(class34.field782[var3] | 2);
            } else {
               var4 = var0.method2907(1);
               if(var4 == 0) {
                  var1 = class24.method613(var0);
                  class34.field782[var3] = (byte)(class34.field782[var3] | 2);
               } else {
                  class154.method3287(var0, var3);
               }
            }
         }
      }

      var0.method2900();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2899();

         for(var2 = 0; var2 < class34.field783; ++var2) {
            var3 = class34.field784[var2];
            if((class34.field782[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class34.field782[var3] = (byte)(class34.field782[var3] | 2);
               } else {
                  var4 = var0.method2907(1);
                  if(var4 == 0) {
                     var1 = class24.method613(var0);
                     class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                  } else {
                     class154.method3287(var0, var3);
                  }
               }
            }
         }

         var0.method2900();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2899();

            for(var2 = 0; var2 < class34.field789; ++var2) {
               var3 = class34.field786[var2];
               if((class34.field782[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                  } else {
                     var4 = var0.method2907(1);
                     if(var4 == 0) {
                        var1 = class24.method613(var0);
                        class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                     } else if(class50.method1076(var0, var3)) {
                        class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                     }
                  }
               }
            }

            var0.method2900();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2899();

               for(var2 = 0; var2 < class34.field789; ++var2) {
                  var3 = class34.field786[var2];
                  if((class34.field782[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                     } else {
                        var4 = var0.method2907(1);
                        if(var4 == 0) {
                           var1 = class24.method613(var0);
                           class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                        } else if(class50.method1076(var0, var3)) {
                           class34.field782[var3] = (byte)(class34.field782[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2900();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field783 = 0;
                  class34.field789 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class34.field782[var2] = (byte)(class34.field782[var2] >> 1);
                     class2 var5 = client.field302[var2];
                     if(null != var5) {
                        class34.field784[++class34.field783 - 1] = var2;
                     } else {
                        class34.field786[++class34.field789 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
