package net.runelite.rs.client;

import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ab")
public class class50 extends class203 {
   @ObfuscatedName("m")
   static class192 field1078 = new class192(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 198065783
   )
   public int field1079 = 0;
   @ObfuscatedName("j")
   public static class166 field1081;
   @ObfuscatedName("ak")
   static String field1083;
   @ObfuscatedName("qa")
   protected static Font field1084;
   @ObfuscatedName("pc")
   static Clipboard field1085;
   @ObfuscatedName("an")
   static class167 field1087;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -1575304213
   )
   static int field1088;

   @ObfuscatedName("m")
   void method1054(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method1062(var1, var2);
      }
   }

   @ObfuscatedName("u")
   static void method1059(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field590.method3871(); null != var4; var4 = (class23)class23.field590.method3873()) {
         if(-1 != var4.field594 || var4.field587 != null) {
            int var5 = 0;
            if(var1 > var4.field591) {
               var5 += var1 - var4.field591;
            } else if(var1 < var4.field589) {
               var5 += var4.field589 - var1;
            }

            if(var2 > var4.field603) {
               var5 += var2 - var4.field603;
            } else if(var2 < var4.field592) {
               var5 += var4.field592 - var2;
            }

            if(var5 - 64 <= var4.field596 && 0 != client.field515 && var4.field588 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = client.field515 * (var4.field596 - var5) / var4.field596;
               if(null == var4.field595) {
                  if(var4.field594 >= 0) {
                     class58 var7 = class58.method1285(class158.field2583, var4.field594, 0);
                     if(null != var7) {
                        class62 var8 = var7.method1283().method1320(class103.field1774);
                        class64 var9 = class64.method1473(var8, 100, var6);
                        var9.method1348(-1);
                        class16.field235.method1200(var9);
                        var4.field595 = var9;
                     }
                  }
               } else {
                  var4.field595.method1349(var6);
               }

               if(var4.field600 == null) {
                  if(null != var4.field587 && (var4.field599 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field587.length);
                     class58 var12 = class58.method1285(class158.field2583, var4.field587[var11], 0);
                     if(var12 != null) {
                        class62 var13 = var12.method1283().method1320(class103.field1774);
                        class64 var10 = class64.method1473(var13, 100, var6);
                        var10.method1348(0);
                        class16.field235.method1200(var10);
                        var4.field600 = var10;
                        var4.field599 = var4.field598 + (int)(Math.random() * (double)(var4.field597 - var4.field598));
                     }
                  }
               } else {
                  var4.field600.method1349(var6);
                  if(!var4.field600.method3968()) {
                     var4.field600 = null;
                  }
               }
            } else {
               if(var4.field595 != null) {
                  class16.field235.method1177(var4.field595);
                  var4.field595 = null;
               }

               if(var4.field600 != null) {
                  class16.field235.method1177(var4.field600);
                  var4.field600 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   static void method1061(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field216.method3836((long)var0);
      if(var4 == null) {
         var4 = new class15();
         class15.field216.method3839(var4, (long)var0);
      }

      if(var4.field217.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field217.length; ++var7) {
            var5[var7] = var4.field217[var7];
            var6[var7] = var4.field214[var7];
         }

         for(var7 = var4.field217.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field217 = var5;
         var4.field214 = var6;
      }

      var4.field217[var1] = var2;
      var4.field214[var1] = var3;
   }

   @ObfuscatedName("f")
   void method1062(class118 var1, int var2) {
      if(2 == var2) {
         this.field1079 = var1.method2538();
      }

   }

   @ObfuscatedName("j")
   static void method1063(int var0, String var1, String var2) {
      class86.method2096(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("l")
   public static int method1064() {
      byte var0 = 0;
      int var1 = var0 + class170.field2701 + class170.field2699;
      return var1;
   }

   @ObfuscatedName("m")
   static final void method1065(class121 var0) {
      int var1 = 0;
      var0.method2787();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field733; ++var2) {
         var3 = class32.field730[var2];
         if((class32.field728[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class32.field728[var3] = (byte)(class32.field728[var3] | 2);
            } else {
               var4 = var0.method2786(1);
               if(var4 == 0) {
                  var1 = class6.method120(var0);
                  class32.field728[var3] = (byte)(class32.field728[var3] | 2);
               } else {
                  class27.method686(var0, var3);
               }
            }
         }
      }

      var0.method2800();
      if(0 != var1) {
         throw new RuntimeException();
      } else {
         var0.method2787();

         for(var2 = 0; var2 < class32.field733; ++var2) {
            var3 = class32.field730[var2];
            if((class32.field728[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class32.field728[var3] = (byte)(class32.field728[var3] | 2);
               } else {
                  var4 = var0.method2786(1);
                  if(0 == var4) {
                     var1 = class6.method120(var0);
                     class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                  } else {
                     class27.method686(var0, var3);
                  }
               }
            }
         }

         var0.method2800();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2787();

            for(var2 = 0; var2 < class32.field742; ++var2) {
               var3 = class32.field736[var2];
               if(0 != (class32.field728[var3] & 1)) {
                  if(var1 > 0) {
                     --var1;
                     class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                  } else {
                     var4 = var0.method2786(1);
                     if(0 == var4) {
                        var1 = class6.method120(var0);
                        class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                     } else if(class12.method184(var0, var3)) {
                        class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                     }
                  }
               }
            }

            var0.method2800();
            if(0 != var1) {
               throw new RuntimeException();
            } else {
               var0.method2787();

               for(var2 = 0; var2 < class32.field742; ++var2) {
                  var3 = class32.field736[var2];
                  if(0 == (class32.field728[var3] & 1)) {
                     if(var1 > 0) {
                        --var1;
                        class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                     } else {
                        var4 = var0.method2786(1);
                        if(var4 == 0) {
                           var1 = class6.method120(var0);
                           class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                        } else if(class12.method184(var0, var3)) {
                           class32.field728[var3] = (byte)(class32.field728[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2800();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field733 = 0;
                  class32.field742 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field728[var2] = (byte)(class32.field728[var2] >> 1);
                     class2 var5 = client.field397[var2];
                     if(null != var5) {
                        class32.field730[++class32.field733 - 1] = var2;
                     } else {
                        class32.field736[++class32.field742 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
