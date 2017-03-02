import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gp")
public final class class207 {
   class207() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "907411011"
   )
   public static void method3954(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3246.method2455();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2844(var1.field3240);

         for(int var3 = 0; var3 < var1.field3235; ++var3) {
            if(var1.field3236[var3] != 0) {
               var0.method3010(var1.field3236[var3]);
            } else {
               try {
                  int var4 = var1.field3237[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method3010(0);
                     var0.method2844(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3238[var3]);
                     var0.method3010(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method3010(0);
                     var0.method2844(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method3010(0);
                        var0.method2844(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(null == var11) {
                        var0.method3010(0);
                     } else if(var11 instanceof Number) {
                        var0.method3010(1);
                        var0.method2845(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method3010(2);
                        var0.method2893((String)var11);
                     } else {
                        var0.method3010(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method3010(-10);
               } catch (InvalidClassException var14) {
                  var0.method3010(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method3010(-12);
               } catch (OptionalDataException var16) {
                  var0.method3010(-13);
               } catch (IllegalAccessException var17) {
                  var0.method3010(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method3010(-15);
               } catch (InvocationTargetException var19) {
                  var0.method3010(-16);
               } catch (SecurityException var20) {
                  var0.method3010(-17);
               } catch (IOException var21) {
                  var0.method3010(-18);
               } catch (NullPointerException var22) {
                  var0.method3010(-19);
               } catch (Exception var23) {
                  var0.method3010(-20);
               } catch (Throwable var24) {
                  var0.method3010(-21);
               }
            }
         }

         var0.method2878(var2);
         var1.unlink();
      }
   }
}
