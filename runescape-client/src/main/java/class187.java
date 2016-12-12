import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class187 extends CacheableNode {
   @ObfuscatedName("i")
   public static class182 field2775;
   @ObfuscatedName("f")
   static NodeCache field2777 = new NodeCache(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1442075273
   )
   public int field2778 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1482182349
   )
   public static int field2779;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 762926391
   )
   static int field2780;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-175023120"
   )
   void method3371(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3373(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "-1809189040"
   )
   static class178[] method3372() {
      return new class178[]{class178.field2674, class178.field2679, class178.field2673, class178.field2675};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-14485171"
   )
   void method3373(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2778 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-54"
   )
   public static void method3381(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3226 = var0.readUnsignedByte();
      var2.field3219 = var0.method2844();
      var2.field3221 = new int[var2.field3226];
      var2.field3220 = new int[var2.field3226];
      var2.fields = new Field[var2.field3226];
      var2.field3224 = new int[var2.field3226];
      var2.methods = new Method[var2.field3226];
      var2.args = new byte[var2.field3226][][];

      for(int var3 = 0; var3 < var2.field3226; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2767();
                  var6 = var0.method2767();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2767();
                  }

                  String var20 = var0.method2767();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2844();
                        var10[var11] = new byte[var12];
                        var0.method2770(var10[var11], 0, var12);
                     }
                  }

                  var2.field3221[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class215.method3871(var8[var12]);
                  }

                  Class var22 = class215.method3871(var20);
                  if(class215.method3871(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class215.method3871(var5).getDeclaredMethods();
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
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.method2767();
               var6 = var0.method2767();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2844();
               }

               var2.field3221[var3] = var4;
               var2.field3224[var3] = var7;
               if(class215.method3871(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = class215.method3871(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3220[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3220[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3220[var3] = -3;
         } catch (Exception var27) {
            var2.field3220[var3] = -4;
         } catch (Throwable var28) {
            var2.field3220[var3] = -5;
         }
      }

      class227.field3228.method2325(var2);
   }
}
