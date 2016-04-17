import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public final class class162 {
   @ObfuscatedName("a")
   static final char[] field2638 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "664702975"
   )
   public static void method3288(class119 var0, int var1) {
      class210 var2 = new class210();
      var2.field3130 = var0.method2613();
      var2.field3133 = var0.method2618();
      var2.field3129 = new int[var2.field3130];
      var2.field3127 = new int[var2.field3130];
      var2.field3131 = new Field[var2.field3130];
      var2.field3132 = new int[var2.field3130];
      var2.field3128 = new Method[var2.field3130];
      var2.field3134 = new byte[var2.field3130][][];

      for(int var3 = 0; var3 < var2.field3130; ++var3) {
         try {
            int var4 = var0.method2613();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && 1 != var4 && 2 != var4) {
               if(3 == var4 || var4 == 4) {
                  var5 = var0.method2621();
                  var6 = var0.method2621();
                  var7 = var0.method2613();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2621();
                  }

                  String var25 = var0.method2621();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(3 == var4) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2618();
                        var10[var11] = new byte[var12];
                        var0.method2740(var10[var11], 0, var12);
                     }
                  }

                  var2.field3129[var3] = var4;
                  Class[] var26 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var26[var12] = class12.method192(var8[var12]);
                  }

                  Class var27 = class12.method192(var25);
                  if(class12.method192(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class12.method192(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var26.length == var17.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var26.length; ++var19) {
                              if(var26[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var27 == var16.getReturnType()) {
                              var2.field3128[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3134[var3] = var10;
               }
            } else {
               var5 = var0.method2621();
               var6 = var0.method2621();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2618();
               }

               var2.field3129[var3] = var4;
               var2.field3132[var3] = var7;
               if(class12.method192(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3131[var3] = class12.method192(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var20) {
            var2.field3127[var3] = -1;
         } catch (SecurityException var21) {
            var2.field3127[var3] = -2;
         } catch (NullPointerException var22) {
            var2.field3127[var3] = -3;
         } catch (Exception var23) {
            var2.field3127[var3] = -4;
         } catch (Throwable var24) {
            var2.field3127[var3] = -5;
         }
      }

      class211.field3138.method3956(var2);
   }
}
