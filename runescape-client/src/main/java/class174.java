import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class174 {
   @ObfuscatedName("v")
   public static class199 field2760 = new class199(4096);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -849535667
   )
   public static int field2761 = 0;
   @ObfuscatedName("o")
   public static class199 field2762 = new class199(4096);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1424422785
   )
   public static int field2763 = 0;
   @ObfuscatedName("r")
   public static class206 field2764 = new class206();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1650783289
   )
   public static int field2765 = 0;
   @ObfuscatedName("m")
   public static class146 field2766;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1809657577
   )
   public static int field2767 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1215328901
   )
   public static int field2768 = 0;
   @ObfuscatedName("c")
   public static class171[] field2769 = new class171[256];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1444191147
   )
   public static int field2770 = 0;
   @ObfuscatedName("y")
   public static class175 field2771;
   @ObfuscatedName("p")
   public static class122 field2772 = new class122(8);
   @ObfuscatedName("x")
   static class199 field2773 = new class199(4096);
   @ObfuscatedName("d")
   public static CRC32 field2774 = new CRC32();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1058407813
   )
   public static int field2775 = 0;
   @ObfuscatedName("z")
   public static byte field2776 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 17312337
   )
   public static int field2777 = 0;
   @ObfuscatedName("l")
   public static class199 field2778 = new class199(32);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "274018844"
   )
   public static class49 method3438(int var0) {
      class49 var1 = (class49)class49.field1088.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1089.method3304(33, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method1020(new class122(var2));
         }

         class49.field1088.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1328551"
   )
   public static void method3439(class122 var0, int var1) {
      class213 var2 = new class213();
      var2.field3173 = var0.method2556();
      var2.field3177 = var0.method2577();
      var2.field3174 = new int[var2.field3173];
      var2.field3176 = new int[var2.field3173];
      var2.field3178 = new Field[var2.field3173];
      var2.field3179 = new int[var2.field3173];
      var2.field3172 = new Method[var2.field3173];
      var2.field3175 = new byte[var2.field3173][][];

      for(int var3 = 0; var3 < var2.field3173; ++var3) {
         try {
            int var4 = var0.method2556();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2580();
                  var6 = var0.method2580();
                  var7 = var0.method2556();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2580();
                  }

                  String var20 = var0.method2580();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2577();
                        var10[var11] = new byte[var12];
                        var0.method2583(var10[var11], 0, var12);
                     }
                  }

                  var2.field3174[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class21.method567(var8[var12]);
                  }

                  Class var22 = class21.method567(var20);
                  if(class21.method567(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class21.method567(var5).getDeclaredMethods();
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
                              var2.field3172[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3175[var3] = var10;
               }
            } else {
               var5 = var0.method2580();
               var6 = var0.method2580();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2577();
               }

               var2.field3174[var3] = var4;
               var2.field3179[var3] = var7;
               if(class21.method567(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3178[var3] = class21.method567(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3176[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3176[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3176[var3] = -3;
         } catch (Exception var27) {
            var2.field3176[var3] = -4;
         } catch (Throwable var28) {
            var2.field3176[var3] = -5;
         }
      }

      class214.field3180.method3928(var2);
   }
}
