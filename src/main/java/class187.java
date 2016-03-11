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

@ObfuscatedName("gm")
public class class187 {
   @ObfuscatedName("gi")
   public static final int[] field3044 = new int[]{6, 4, 0, 0, 0, 0, 0, 0, -2, 1, 0, -2, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8, 0, 2, 0, 0, 0, 0, 6, 0, 2, 0, 0, 12, -1, 0, 6, -2, 0, 0, 0, 0, 4, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, 0, -2, 0, 3, 6, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 5, -2, 5, 0, -2, 0, -2, 0, 10, 0, -1, 0, 0, -2, 0, 0, 4, 0, 0, 0, 0, 2, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 0, 0, 0, 5, 7, 7, 0, 0, 6, 6, -2, 0, 0, 4, 0, 0, 0, -2, -2, -2, 0, 0, 0, 8, 0, 8, -1, 0, 0, 2, -2, 0, 0, 0, 0, 6, 0, 0, -2, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 6, 3, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 6, 14, 0, 0, 1, 0, 6, 15, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 8, 0, -1, 0, 0, 0, 0, 28, 2, 0, 0, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0};

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass121;I)V",
      garbageValue = "1198230787"
   )
   public static void method3700(class121 var0) {
      class209 var1 = (class209)class210.field3125.method3807();
      if(null != var1) {
         int var2 = var0.field1998;
         var0.method2441(var1.field3123);

         for(int var3 = 0; var3 < var1.field3124; ++var3) {
            if(0 != var1.field3116[var3]) {
               var0.method2438(var1.field3116[var3]);
            } else {
               try {
                  int var4 = var1.field3117[var3];
                  Field var5;
                  int var6;
                  if(0 == var4) {
                     var5 = var1.field3119[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2438(0);
                     var0.method2441(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3119[var3];
                     var5.setInt((Object)null, var1.field3120[var3]);
                     var0.method2438(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3119[var3];
                     var6 = var5.getModifiers();
                     var0.method2438(0);
                     var0.method2441(var6);
                  }

                  Method var22;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var22 = var1.field3121[var3];
                        var6 = var22.getModifiers();
                        var0.method2438(0);
                        var0.method2441(var6);
                     }
                  } else {
                     var22 = var1.field3121[var3];
                     byte[][] var23 = var1.field3122[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2438(0);
                     } else if(var24 instanceof Number) {
                        var0.method2438(1);
                        var0.method2570(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2438(2);
                        var0.method2444((String)var24);
                     } else {
                        var0.method2438(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2438(-10);
               } catch (InvalidClassException var11) {
                  var0.method2438(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2438(-12);
               } catch (OptionalDataException var13) {
                  var0.method2438(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2438(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2438(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2438(-16);
               } catch (SecurityException var17) {
                  var0.method2438(-17);
               } catch (IOException var18) {
                  var0.method2438(-18);
               } catch (NullPointerException var19) {
                  var0.method2438(-19);
               } catch (Exception var20) {
                  var0.method2438(-20);
               } catch (Throwable var21) {
                  var0.method2438(-21);
               }
            }
         }

         var0.method2474(var2);
         var1.method3853();
      }
   }
}
