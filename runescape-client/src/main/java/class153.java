import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public final class class153 {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 422512973
   )
   public static int field2296;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass116;I)V",
      garbageValue = "1106569038"
   )
   public static void method3169(class116 var0) {
      class225.field3231 = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-436432389"
   )
   public static Widget method3170(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || null == Widget.widgets[var1][var2]) {
         boolean var3 = class171.method3404(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "114"
   )
   public static void method3171(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3169 = var0.method2656();
      var2.field3175 = var0.method2538();
      var2.field3170 = new int[var2.field3169];
      var2.field3168 = new int[var2.field3169];
      var2.fields = new Field[var2.field3169];
      var2.field3173 = new int[var2.field3169];
      var2.methods = new Method[var2.field3169];
      var2.args = new byte[var2.field3169][][];

      for(int var3 = 0; var3 < var2.field3169; ++var3) {
         try {
            int var4 = var0.method2656();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2541();
                  var6 = var0.method2541();
                  var7 = var0.method2656();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2541();
                  }

                  String var20 = var0.method2541();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2538();
                        var10[var11] = new byte[var12];
                        var0.method2698(var10[var11], 0, var12);
                     }
                  }

                  var2.field3170[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class109.method2398(var8[var12]);
                  }

                  Class var22 = class109.method2398(var20);
                  if(class109.method2398(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class109.method2398(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var21.length == var17.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.method2541();
               var6 = var0.method2541();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2538();
               }

               var2.field3170[var3] = var4;
               var2.field3173[var3] = var7;
               if(class109.method2398(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = class109.method2398(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3168[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3168[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3168[var3] = -3;
         } catch (Exception var27) {
            var2.field3168[var3] = -4;
         } catch (Throwable var28) {
            var2.field3168[var3] = -5;
         }
      }

      class214.field3177.method3929(var2);
   }
}
