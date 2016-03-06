package net.runelite.rs.client;
import java.io.File;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ey")
public class class141 {
   @ObfuscatedName("by")
   static String field2179;
   @ObfuscatedName("gn")
   static class172 field2181;

   @ObfuscatedName("j")
   static void method2924(File var0) {
      class134.field2083 = var0;
      if(!class134.field2083.exists()) {
         throw new RuntimeException("");
      } else {
         class134.field2087 = true;
      }
   }

   @ObfuscatedName("c")
   public static final class56 method2925(class135 var0, int var1, int var2) {
      if(0 == class102.field1780) {
         throw new IllegalStateException();
      } else {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class69 var6 = new class69();
            var6.field1200 = new int[256 * (class56.field1191?2:1)];
            var6.field1199 = var2;
            var6.vmethod1501();
            var6.field1188 = 1024 + (var2 & -1024);
            if(var6.field1188 > 16384) {
               var6.field1188 = 16384;
            }

            var6.vmethod1502(var6.field1188);
            if(class56.field1196 > 0 && null == class56.field1183) {
               class56.field1183 = new class72();
               class56.field1183.field1360 = var0;
               var0.method2833(class56.field1183, class56.field1196);
            }

            if(null != class56.field1183) {
               if(null != class56.field1183.field1359[var1]) {
                  throw new IllegalArgumentException();
               }

               class56.field1183.field1359[var1] = var6;
            }

            return var6;
         } catch (Throwable var5) {
            try {
               class54 var3 = new class54(var0, var1);
               var3.field1200 = new int[(class56.field1191?2:1) * 256];
               var3.field1199 = var2;
               var3.vmethod1501();
               var3.field1188 = 16384;
               var3.vmethod1502(var3.field1188);
               if(class56.field1196 > 0 && class56.field1183 == null) {
                  class56.field1183 = new class72();
                  class56.field1183.field1360 = var0;
                  var0.method2833(class56.field1183, class56.field1196);
               }

               if(class56.field1183 != null) {
                  if(null != class56.field1183.field1359[var1]) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1183.field1359[var1] = var3;
               }

               return var3;
            } catch (Throwable var4) {
               return new class56();
            }
         }
      }
   }

   @ObfuscatedName("cl")
   static final int method2926(class172 var0, int var1) {
      if(var0.field2869 != null && var1 < var0.field2869.length) {
         try {
            int[] var2 = var0.field2869[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(0 == var6) {
                  return var3;
               }

               if(1 == var6) {
                  var7 = client.field424[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field425[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = client.field426[var2[var4++]];
               }

               int var9;
               class172 var10;
               int var11;
               int var12;
               if(4 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class31.method698(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class22.method581(var11).field1114 || client.field291)) {
                     for(var12 = 0; var12 < var10.field2875.length; ++var12) {
                        if(var11 + 1 == var10.field2875[var12]) {
                           var7 += var10.field2876[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class175.field2906[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class154.field2301[client.field425[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class175.field2906[var2[var4++]] * 100 / '뜛';
               }

               if(8 == var6) {
                  var7 = class148.field2249.field39;
               }

               if(9 == var6) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class154.field2300[var9]) {
                        var7 += client.field425[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class31.method698(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class22.method581(var11).field1114 || client.field291)) {
                     for(var12 = 0; var12 < var10.field2875.length; ++var12) {
                        if(1 + var11 == var10.field2875[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(11 == var6) {
                  var7 = client.field335;
               }

               if(var6 == 12) {
                  var7 = client.field454;
               }

               if(13 == var6) {
                  var9 = class175.field2906[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = 0 != (var9 & 1 << var14)?1:0;
               }

               if(14 == var6) {
                  var9 = var2[var4++];
                  var7 = class109.method2380(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(16 == var6) {
                  var8 = 2;
               }

               if(17 == var6) {
                  var8 = 3;
               }

               if(18 == var6) {
                  var7 = class98.field1683 + (class148.field2249.field839 >> 7);
               }

               if(19 == var6) {
                  var7 = class92.field1598 + (class148.field2249.field848 >> 7);
               }

               if(20 == var6) {
                  var7 = var2[var4++];
               }

               if(0 == var8) {
                  if(0 == var5) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(2 == var5 && 0 != var7) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("f")
   static void method2927(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class25.field632[var6];
         class25.field632[var6] = class25.field632[var1];
         class25.field632[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class25 var11 = class25.field632[var9];
            int var12 = class88.method2053(var11, var8, var2, var3);
            int var10;
            if(0 != var12) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(-1 == var4) {
               var10 = 0;
            } else {
               int var13 = class88.method2053(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               class25 var14 = class25.field632[var9];
               class25.field632[var9] = class25.field632[var7];
               class25.field632[var7++] = var14;
            }
         }

         class25.field632[var1] = class25.field632[var7];
         class25.field632[var7] = var8;
         method2927(var0, var7 - 1, var2, var3, var4, var5);
         method2927(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
