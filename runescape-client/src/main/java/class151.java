import java.applet.Applet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class151 extends RuntimeException {
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 864506953
   )
   @Export("cameraX")
   static int field2282;
   @ObfuscatedName("h")
   Throwable field2283;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -8651151
   )
   static int field2284;
   @ObfuscatedName("e")
   String field2285;
   @ObfuscatedName("l")
   static Applet field2286;
   @ObfuscatedName("g")
   public static String field2287;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Lclass176;",
      garbageValue = "-778264089"
   )
   public static class176 method3265(int var0, int var1) {
      class176 var2 = class134.method2983(var0);
      return var1 == -1?var2:(var2 != null && var2.field2931 != null && var1 < var2.field2931.length?var2.field2931[var1]:null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "993746220"
   )
   static void method3269() {
      class5.field82 = null;
      class75.field1422 = null;
      class5.field88 = null;
      class5.field86 = null;
      class99.field1704 = null;
      class232.field3275 = null;
      class13.field207 = null;
      class5.field83 = null;
      class5.field87 = null;
      class5.field96 = null;
      class37.field809 = null;
      class224.field3225 = null;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "86"
   )
   static final String method3270(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class16.method205('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class16.method205(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class16.method205(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1226574359"
   )
   public static int method3272(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class33.method735(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-81"
   )
   public static void method3273(class122 var0, int var1) {
      class213 var2 = new class213();
      var2.field3177 = var0.method2633();
      var2.field3182 = var0.method2620();
      var2.field3179 = new int[var2.field3177];
      var2.field3180 = new int[var2.field3177];
      var2.field3181 = new Field[var2.field3177];
      var2.field3178 = new int[var2.field3177];
      var2.field3183 = new Method[var2.field3177];
      var2.field3184 = new byte[var2.field3177][][];

      for(int var3 = 0; var3 < var2.field3177; ++var3) {
         try {
            int var4 = var0.method2633();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2663();
                  var6 = var0.method2663();
                  var7 = var0.method2633();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2663();
                  }

                  String var20 = var0.method2663();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2620();
                        var10[var11] = new byte[var12];
                        var0.method2754(var10[var11], 0, var12);
                     }
                  }

                  var2.field3179[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class190.method3898(var8[var12]);
                  }

                  Class var22 = class190.method3898(var20);
                  if(class190.method3898(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class190.method3898(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.field3183[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3184[var3] = var10;
               }
            } else {
               var5 = var0.method2663();
               var6 = var0.method2663();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2620();
               }

               var2.field3179[var3] = var4;
               var2.field3178[var3] = var7;
               if(class190.method3898(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3181[var3] = class190.method3898(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3180[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3180[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3180[var3] = -3;
         } catch (Exception var27) {
            var2.field3180[var3] = -4;
         } catch (Throwable var28) {
            var2.field3180[var3] = -5;
         }
      }

      class214.field3189.method4008(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "692753557"
   )
   static final int method3274(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1082303703"
   )
   public static final boolean method3275() {
      class140 var0 = class140.field2157;
      synchronized(class140.field2157) {
         if(class140.field2179 == class140.field2159) {
            return false;
         } else {
            class25.field643 = class140.field2155[class140.field2179];
            class51.field1146 = class140.field2175[class140.field2179];
            class140.field2179 = class140.field2179 + 1 & 127;
            return true;
         }
      }
   }
}
