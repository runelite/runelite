import java.awt.Canvas;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class79 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2065411321
   )
   public static int field1456;
   @ObfuscatedName("qi")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("z")
   public static int[] field1458;
   @ObfuscatedName("mh")
   static byte field1459;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1701140035
   )
   public static int field1460;
   @ObfuscatedName("n")
   public static int[] field1461;
   @ObfuscatedName("r")
   public static int[] field1462;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1321636967
   )
   static int field1464;
   @ObfuscatedName("bg")
   static ModIcon[] field1466;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-266828560"
   )
   public static void method1709(class170 var0) {
      class53.field1155 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   static void method1710() {
      FileOnDisk var0 = null;

      try {
         var0 = GameObject.method2224("", Client.field548.field2347, true);
         Buffer var1 = class116.field2039.method115();
         var0.method4175(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4197();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-1869189321"
   )
   static final void method1711(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field451) {
         Client.field427 = 32;
      } else {
         Client.field427 = 0;
      }

      Client.field451 = false;
      int var7;
      if(class143.field2220 == 1 || !class24.field626 && class143.field2220 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class53.method1101(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class53.method1101(var0);
         } else if(var5 >= var1 - Client.field427 && var5 < 16 + var1 + Client.field427 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class53.method1101(var0);
            Client.field451 = true;
         }
      }

      if(Client.field492 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field492 * 45;
            class53.method1101(var0);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "1467215271"
   )
   public static void method1712(class170 var0, class170 var1, class170 var2, class170 var3) {
      class153.field2311 = var0;
      Widget.field2809 = var1;
      class212.field3175 = var2;
      class178.field2962 = var3;
      Widget.widgets = new Widget[class153.field2311.method3320()][];
      Widget.validInterfaces = new boolean[class153.field2311.method3320()];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-261093154"
   )
   public static void method1713(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3178 = var0.method2528();
      var2.field3179 = var0.method2533();
      var2.field3177 = new int[var2.field3178];
      var2.field3183 = new int[var2.field3178];
      var2.fields = new Field[var2.field3178];
      var2.field3182 = new int[var2.field3178];
      var2.methods = new Method[var2.field3178];
      var2.args = new byte[var2.field3178][][];

      for(int var3 = 0; var3 < var2.field3178; ++var3) {
         try {
            int var4 = var0.method2528();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2530();
                  var6 = var0.method2530();
                  var7 = var0.method2528();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2530();
                  }

                  String var20 = var0.method2530();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2533();
                        var10[var11] = new byte[var12];
                        var0.method2726(var10[var11], 0, var12);
                     }
                  }

                  var2.field3177[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class24.method591(var8[var12]);
                  }

                  Class var22 = class24.method591(var20);
                  if(class24.method591(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class24.method591(var5).getDeclaredMethods();
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
               var5 = var0.method2530();
               var6 = var0.method2530();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2533();
               }

               var2.field3177[var3] = var4;
               var2.field3182[var3] = var7;
               if(class24.method591(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = class24.method591(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3183[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3183[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3183[var3] = -3;
         } catch (Exception var27) {
            var2.field3183[var3] = -4;
         } catch (Throwable var28) {
            var2.field3183[var3] = -5;
         }
      }

      class214.field3187.method3898(var2);
   }
}
