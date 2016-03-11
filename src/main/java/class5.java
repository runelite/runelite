import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public final class class5 {
   @ObfuscatedName("p")
   static final int[] field80 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("l")
   @Export("tileSettings")
   static byte[][][] field81 = new byte[4][104][104];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1993848913
   )
   static int field82 = 99;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1362428543
   )
   static int field83 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("m")
   static byte[][][] field84;
   @ObfuscatedName("o")
   static byte[][][] field85;
   @ObfuscatedName("b")
   static int[] field86;
   @ObfuscatedName("q")
   static int[] field87;
   @ObfuscatedName("z")
   static final int[] field88 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("t")
   static final int[] field89 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("i")
   static byte[][][] field90;
   @ObfuscatedName("c")
   static final int[] field92 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("j")
   @Export("tileHeights")
   static int[][][] field93 = new int[4][105][105];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1186454203
   )
   static int field94 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("h")
   static byte[][][] field97;
   @ObfuscatedName("x")
   static final int[] field101 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("w")
   static final int[] field103 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("ec")
   static class80[] field104;

   @ObfuscatedName("n")
   public static class223 method52(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class223 var1 = new class223(var0, class76.field1392, class106.field1884, class215.field3153, class147.field2230, class126.field2048, class41.field977);
         class76.field1392 = null;
         class106.field1884 = null;
         class215.field3153 = null;
         class147.field2230 = null;
         class126.field2048 = null;
         class41.field977 = (byte[][])null;
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "1054365682"
   )
   public static void method57(class118 var0) {
      class209 var1 = new class209();
      var1.field3124 = var0.method2453();
      var1.field3123 = var0.method2458();
      var1.field3117 = new int[var1.field3124];
      var1.field3116 = new int[var1.field3124];
      var1.field3119 = new Field[var1.field3124];
      var1.field3120 = new int[var1.field3124];
      var1.field3121 = new Method[var1.field3124];
      var1.field3122 = new byte[var1.field3124][][];

      for(int var2 = 0; var2 < var1.field3124; ++var2) {
         try {
            int var3 = var0.method2453();
            String var4;
            String var5;
            int var6;
            if(0 != var3 && var3 != 1 && 2 != var3) {
               if(var3 == 3 || var3 == 4) {
                  var4 = var0.method2461();
                  var5 = var0.method2461();
                  var6 = var0.method2453();
                  String[] var7 = new String[var6];

                  for(int var8 = 0; var8 < var6; ++var8) {
                     var7[var8] = var0.method2461();
                  }

                  String var24 = var0.method2461();
                  byte[][] var9 = new byte[var6][];
                  int var11;
                  if(3 == var3) {
                     for(int var10 = 0; var10 < var6; ++var10) {
                        var11 = var0.method2458();
                        var9[var10] = new byte[var11];
                        var0.method2534(var9[var10], 0, var11);
                     }
                  }

                  var1.field3117[var2] = var3;
                  Class[] var25 = new Class[var6];

                  for(var11 = 0; var11 < var6; ++var11) {
                     var25[var11] = class148.method3099(var7[var11]);
                  }

                  Class var26 = class148.method3099(var24);
                  if(class148.method3099(var4).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var12 = class148.method3099(var4).getDeclaredMethods();
                  Method[] var13 = var12;

                  for(int var14 = 0; var14 < var13.length; ++var14) {
                     Method var15 = var13[var14];
                     if(var15.getName().equals(var5)) {
                        Class[] var16 = var15.getParameterTypes();
                        if(var25.length == var16.length) {
                           boolean var17 = true;

                           for(int var18 = 0; var18 < var25.length; ++var18) {
                              if(var25[var18] != var16[var18]) {
                                 var17 = false;
                                 break;
                              }
                           }

                           if(var17 && var26 == var15.getReturnType()) {
                              var1.field3121[var2] = var15;
                           }
                        }
                     }
                  }

                  var1.field3122[var2] = var9;
               }
            } else {
               var4 = var0.method2461();
               var5 = var0.method2461();
               var6 = 0;
               if(1 == var3) {
                  var6 = var0.method2458();
               }

               var1.field3117[var2] = var3;
               var1.field3120[var2] = var6;
               if(class148.method3099(var4).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var1.field3119[var2] = class148.method3099(var4).getDeclaredField(var5);
            }
         } catch (ClassNotFoundException var19) {
            var1.field3116[var2] = -1;
         } catch (SecurityException var20) {
            var1.field3116[var2] = -2;
         } catch (NullPointerException var21) {
            var1.field3116[var2] = -3;
         } catch (Exception var22) {
            var1.field3116[var2] = -4;
         } catch (Throwable var23) {
            var1.field3116[var2] = -5;
         }
      }

      class210.field3125.method3806(var1);
   }

   @ObfuscatedName("l")
   static int method77(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3744((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.field229.length?var2.field229[var1]:0);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass107;I)V",
      garbageValue = "-234429232"
   )
   static final void method79(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class107[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].field1904[var2 + var9][var10 + var3] &= -16777217;
            }
         }
      }

      class118 var20 = new class118(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < 8 + var6) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(0 == var19) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  class40.method807(var20, var1, var2 + var16, var3 + class93.method2139(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class40.method807(var20, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("qz")
   protected static final void method80() {
      class30.field703.vmethod3066();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2206[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2207[var0] = 0L;
      }

      class136.field2109 = 0;
   }
}
