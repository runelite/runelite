import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class26 {
   @ObfuscatedName("ak")
   static String field668;
   @ObfuscatedName("p")
   public static class167 field672;

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "120"
   )
   static final void method644(boolean var0) {
      client.field354 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field354) {
         var1 = client.field528.method2508();
         var2 = client.field528.method2542();
         var3 = client.field528.method2508();
         class104.field1786 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class104.field1786[var4][var5] = client.field528.method2511();
            }
         }

         class101.field1756 = new int[var3];
         class108.field1909 = new int[var3];
         class140.field2180 = new int[var3];
         class41.field987 = new byte[var3][];
         class190.field3080 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && 48 == var2 / 8) {
            var13 = true;
         }

         if(48 == var1 / 8 && 148 == var2 / 8) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && 149 != var6 && 147 != var6 && var5 != 50 && (49 != var5 || 47 != var6)) {
                  class101.field1756[var3] = var7;
                  class108.field1909[var3] = class18.field271.method3303("m" + var5 + "_" + var6);
                  class140.field2180[var3] = class18.field271.method3303("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class11.method141(var1, var2);
      } else {
         var1 = client.field528.method2600();
         var2 = client.field528.method2541();
         var3 = client.field528.method2508();
         client.field528.method2748();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field528.method2777(1);
                  if(var7 == 1) {
                     client.field446[var4][var5][var6] = client.field528.method2777(26);
                  } else {
                     client.field446[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field528.method2752();
         class104.field1786 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class104.field1786[var4][var5] = client.field528.method2511();
            }
         }

         class101.field1756 = new int[var3];
         class108.field1909 = new int[var3];
         class140.field2180 = new int[var3];
         class41.field987 = new byte[var3][];
         class190.field3080 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field446[var4][var5][var6];
                  if(-1 != var7) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class101.field1756[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class101.field1756[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class108.field1909[var3] = class18.field271.method3303("m" + var11 + "_" + var12);
                        class140.field2180[var3] = class18.field271.method3303("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class11.method141(var1, var2);
      }

   }

   @ObfuscatedName("p")
   static class35 method645(int var0, int var1) {
      class27 var2 = (class27)class11.field188.get(Integer.valueOf(var0));
      return var2.method649(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "2"
   )
   static final void method646(class122 var0, int var1) {
      int var2 = var0.field2011;
      class32.field758 = 0;
      int var3 = 0;
      var0.method2748();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class32.field751; ++var4) {
         var5 = class32.field757[var4];
         if((class32.field747[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class32.field747[var5] = (byte)(class32.field747[var5] | 2);
            } else {
               var6 = var0.method2777(1);
               if(0 == var6) {
                  var3 = class135.method2881(var0);
                  class32.field747[var5] = (byte)(class32.field747[var5] | 2);
               } else {
                  class111.method2436(var0, var5);
               }
            }
         }
      }

      var0.method2752();
      if(0 != var3) {
         throw new RuntimeException();
      } else {
         var0.method2748();

         for(var4 = 0; var4 < class32.field751; ++var4) {
            var5 = class32.field757[var4];
            if((class32.field747[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class32.field747[var5] = (byte)(class32.field747[var5] | 2);
               } else {
                  var6 = var0.method2777(1);
                  if(0 == var6) {
                     var3 = class135.method2881(var0);
                     class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                  } else {
                     class111.method2436(var0, var5);
                  }
               }
            }
         }

         var0.method2752();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2748();

            for(var4 = 0; var4 < class32.field753; ++var4) {
               var5 = class32.field759[var4];
               if((class32.field747[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                  } else {
                     var6 = var0.method2777(1);
                     if(0 == var6) {
                        var3 = class135.method2881(var0);
                        class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                     } else if(class14.method166(var0, var5)) {
                        class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                     }
                  }
               }
            }

            var0.method2752();
            if(0 != var3) {
               throw new RuntimeException();
            } else {
               var0.method2748();

               for(var4 = 0; var4 < class32.field753; ++var4) {
                  var5 = class32.field759[var4];
                  if((class32.field747[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                     } else {
                        var6 = var0.method2777(1);
                        if(var6 == 0) {
                           var3 = class135.method2881(var0);
                           class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                        } else if(class14.method166(var0, var5)) {
                           class32.field747[var5] = (byte)(class32.field747[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2752();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field751 = 0;
                  class32.field753 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class32.field747[var4] = (byte)(class32.field747[var4] >> 1);
                     class2 var7 = client.field415[var4];
                     if(var7 != null) {
                        class32.field757[++class32.field751 - 1] = var4;
                     } else {
                        class32.field759[++class32.field753 - 1] = var4;
                     }
                  }

                  class72.method1576(var0);
                  if(var1 != var0.field2011 - var2) {
                     throw new RuntimeException(var0.field2011 - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
