import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("hy")
public class class211 {
   @ObfuscatedName("l")
   static int[] field3132;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1978979149"
   )
   public static void method3996(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3239 = var0.readUnsignedByte();
      var2.field3243 = var0.readInt();
      var2.field3238 = new int[var2.field3239];
      var2.field3241 = new int[var2.field3239];
      var2.fields = new Field[var2.field3239];
      var2.field3244 = new int[var2.field3239];
      var2.methods = new Method[var2.field3239];
      var2.args = new byte[var2.field3239][][];

      for(int var3 = 0; var3 < var2.field3239; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.readString();
                  var6 = var0.readString();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readString();
                  }

                  String var20 = var0.readString();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.method2897(var10[var11], 0, var12);
                     }
                  }

                  var2.field3238[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class105.method2094(var8[var12]);
                  }

                  Class var22 = class105.method2094(var20);
                  if(class105.method2094(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class105.method2094(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
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
               var5 = var0.readString();
               var6 = var0.readString();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.field3238[var3] = var4;
               var2.field3244[var3] = var7;
               if(class105.method2094(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class105.method2094(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3241[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3241[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3241[var3] = -3;
         } catch (Exception var27) {
            var2.field3241[var3] = -4;
         } catch (Throwable var28) {
            var2.field3241[var3] = -5;
         }
      }

      class227.field3246.method2454(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass221;",
      garbageValue = "1569856154"
   )
   public static class221[] method3997() {
      return new class221[]{class221.field3202, class221.field3206, class221.field3205, class221.field3204, class221.field3203};
   }

   class211() throws Throwable {
      throw new Error();
   }
}
