import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("BufferProvider")
public abstract class class77 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 965379097
   )
   @Export("width")
   public int field1402;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1625528651
   )
   @Export("height")
   int field1404;
   @ObfuscatedName("d")
   @Export("image")
   public Image field1405;
   @ObfuscatedName("x")
   @Export("pixels")
   public int[] field1406;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-41"
   )
   public abstract void vmethod1929(int var1, int var2, Component var3);

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   public final void method1733() {
      class79.method1846(this.field1406, this.field1402, this.field1404);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1142358962"
   )
   public abstract void vmethod1939(Graphics var1, int var2, int var3);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1276226507"
   )
   public abstract void vmethod1931(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-774039378"
   )
   public static void method1742(class119 var0, int var1) {
      class210 var2 = new class210();
      var2.field3118 = var0.method2554();
      var2.field3119 = var0.method2696();
      var2.field3120 = new int[var2.field3118];
      var2.field3126 = new int[var2.field3118];
      var2.field3121 = new Field[var2.field3118];
      var2.field3123 = new int[var2.field3118];
      var2.field3124 = new Method[var2.field3118];
      var2.field3125 = new byte[var2.field3118][][];

      for(int var3 = 0; var3 < var2.field3118; ++var3) {
         try {
            int var4 = var0.method2554();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2668();
                  var6 = var0.method2668();
                  var7 = var0.method2554();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2668();
                  }

                  String var20 = var0.method2668();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2696();
                        var10[var11] = new byte[var12];
                        var0.method2565(var10[var11], 0, var12);
                     }
                  }

                  var2.field3120[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class39.method829(var8[var12]);
                  }

                  Class var22 = class39.method829(var20);
                  if(class39.method829(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class39.method829(var5).getDeclaredMethods();
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
                              var2.field3124[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3125[var3] = var10;
               }
            } else {
               var5 = var0.method2668();
               var6 = var0.method2668();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2696();
               }

               var2.field3120[var3] = var4;
               var2.field3123[var3] = var7;
               if(class39.method829(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3121[var3] = class39.method829(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3126[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3126[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3126[var3] = -3;
         } catch (Exception var27) {
            var2.field3126[var3] = -4;
         } catch (Throwable var28) {
            var2.field3126[var3] = -5;
         }
      }

      class211.field3128.method3898(var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass78;",
      garbageValue = "-1258263625"
   )
   static class78 method1748() {
      class78 var0 = new class78();
      var0.field1412 = class76.field1396;
      var0.field1415 = class76.field1398;
      var0.field1410 = class76.field1397[0];
      var0.field1411 = class52.field1178[0];
      var0.field1408 = class28.field690[0];
      var0.field1414 = class31.field744[0];
      int var1 = var0.field1414 * var0.field1408;
      byte[] var2 = class76.field1400[0];
      var0.field1409 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1409[var3] = class7.field135[var2[var3] & 255];
      }

      class33.method749();
      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "13849"
   )
   static int method1749(int var0, int var1) {
      class15 var2 = (class15)class15.field229.method3822((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.field221.length?var2.field221[var1]:-1);
   }
}
