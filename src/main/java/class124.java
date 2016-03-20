import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public abstract class class124 {
   @ObfuscatedName("e")
   public static class166 field2032;
   @ObfuscatedName("r")
   static boolean field2034 = false;
   @ObfuscatedName("bn")
   static class167 field2035;

   @ObfuscatedName("a")
   abstract byte[] vmethod2792();

   @ObfuscatedName("s")
   static int method2802(int var0) {
      class27 var1 = (class27)class11.field169.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method639();
   }

   @ObfuscatedName("r")
   abstract void vmethod2803(byte[] var1);

   @ObfuscatedName("l")
   public static boolean method2805(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("a")
   public static int method2806(CharSequence var0, CharSequence var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      int var4 = 0;
      int var5 = 0;
      char var6 = 0;
      char var7 = 0;

      while(var4 - var6 < var2 || var5 - var7 < var3) {
         if(var4 - var6 >= var2) {
            return -1;
         }

         if(var5 - var7 >= var3) {
            return 1;
         }

         char var8;
         if(0 != var6) {
            var8 = var6;
            boolean var13 = false;
         } else {
            var8 = var0.charAt(var4++);
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var1.charAt(var5++);
         }

         var6 = class115.method2452(var8);
         var7 = class115.method2452(var9);
         var8 = class164.method3253(var8);
         var9 = class164.method3253(var9);
         if(var8 != var9 && Character.toUpperCase(var8) != Character.toUpperCase(var9)) {
            var8 = Character.toLowerCase(var8);
            var9 = Character.toLowerCase(var9);
            if(var9 != var8) {
               return class27.method640(var8) - class27.method640(var9);
            }
         }
      }

      int var15 = Math.min(var2, var3);

      char var11;
      int var16;
      for(var16 = 0; var16 < var15; ++var16) {
         char var10 = var0.charAt(var16);
         var11 = var1.charAt(var16);
         if(var10 != var11 && Character.toUpperCase(var10) != Character.toUpperCase(var11)) {
            var10 = Character.toLowerCase(var10);
            var11 = Character.toLowerCase(var11);
            if(var10 != var11) {
               return class27.method640(var10) - class27.method640(var11);
            }
         }
      }

      var16 = var2 - var3;
      if(0 != var16) {
         return var16;
      } else {
         for(int var17 = 0; var17 < var15; ++var17) {
            var11 = var0.charAt(var17);
            char var12 = var1.charAt(var17);
            if(var11 != var12) {
               return class27.method640(var11) - class27.method640(var12);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "560534822"
   )
   public static void method2807(class118 var0) {
      class209 var1 = new class209();
      var1.field3117 = var0.method2579();
      var1.field3121 = var0.method2517();
      var1.field3124 = new int[var1.field3117];
      var1.field3116 = new int[var1.field3117];
      var1.field3120 = new Field[var1.field3117];
      var1.field3118 = new int[var1.field3117];
      var1.field3122 = new Method[var1.field3117];
      var1.field3123 = new byte[var1.field3117][][];

      for(int var2 = 0; var2 < var1.field3117; ++var2) {
         try {
            int var3 = var0.method2579();
            String var4;
            String var5;
            int var6;
            if(var3 != 0 && var3 != 1 && var3 != 2) {
               if(3 == var3 || var3 == 4) {
                  var4 = var0.method2520();
                  var5 = var0.method2520();
                  var6 = var0.method2579();
                  String[] var7 = new String[var6];

                  for(int var8 = 0; var8 < var6; ++var8) {
                     var7[var8] = var0.method2520();
                  }

                  String var24 = var0.method2520();
                  byte[][] var9 = new byte[var6][];
                  int var11;
                  if(3 == var3) {
                     for(int var10 = 0; var10 < var6; ++var10) {
                        var11 = var0.method2517();
                        var9[var10] = new byte[var11];
                        var0.method2506(var9[var10], 0, var11);
                     }
                  }

                  var1.field3124[var2] = var3;
                  Class[] var25 = new Class[var6];

                  for(var11 = 0; var11 < var6; ++var11) {
                     var25[var11] = class28.method655(var7[var11]);
                  }

                  Class var26 = class28.method655(var24);
                  if(class28.method655(var4).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var12 = class28.method655(var4).getDeclaredMethods();
                  Method[] var13 = var12;

                  for(int var14 = 0; var14 < var13.length; ++var14) {
                     Method var15 = var13[var14];
                     if(var15.getName().equals(var5)) {
                        Class[] var16 = var15.getParameterTypes();
                        if(var16.length == var25.length) {
                           boolean var17 = true;

                           for(int var18 = 0; var18 < var25.length; ++var18) {
                              if(var16[var18] != var25[var18]) {
                                 var17 = false;
                                 break;
                              }
                           }

                           if(var17 && var26 == var15.getReturnType()) {
                              var1.field3122[var2] = var15;
                           }
                        }
                     }
                  }

                  var1.field3123[var2] = var9;
               }
            } else {
               var4 = var0.method2520();
               var5 = var0.method2520();
               var6 = 0;
               if(var3 == 1) {
                  var6 = var0.method2517();
               }

               var1.field3124[var2] = var3;
               var1.field3118[var2] = var6;
               if(class28.method655(var4).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var1.field3120[var2] = class28.method655(var4).getDeclaredField(var5);
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

      class210.field3125.method3895(var1);
   }
}
