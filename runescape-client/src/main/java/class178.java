import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class178 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1476875579
   )
   static int field2909;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1492112745"
   )
   public static void method3484(class122 var0) {
      class210 var1 = (class210)class211.field3127.method3864();
      if(null != var1) {
         int var2 = var0.field1976;
         var0.method2502(var1.field3124);

         for(int var3 = 0; var3 < var1.field3120; ++var3) {
            if(var1.field3119[var3] != 0) {
               var0.method2650(var1.field3119[var3]);
            } else {
               try {
                  int var4 = var1.field3121[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3123[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2650(0);
                     var0.method2502(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3123[var3];
                     var5.setInt((Object)null, var1.field3125[var3]);
                     var0.method2650(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3123[var3];
                     var6 = var5.getModifiers();
                     var0.method2650(0);
                     var0.method2502(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3122[var3];
                        var6 = var25.getModifiers();
                        var0.method2650(0);
                        var0.method2502(var6);
                     }
                  } else {
                     var25 = var1.field3122[var3];
                     byte[][] var10 = var1.field3126[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2650(0);
                     } else if(var11 instanceof Number) {
                        var0.method2650(1);
                        var0.method2647(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2650(2);
                        var0.method2505((String)var11);
                     } else {
                        var0.method2650(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2650(-10);
               } catch (InvalidClassException var14) {
                  var0.method2650(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2650(-12);
               } catch (OptionalDataException var16) {
                  var0.method2650(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2650(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2650(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2650(-16);
               } catch (SecurityException var20) {
                  var0.method2650(-17);
               } catch (IOException var21) {
                  var0.method2650(-18);
               } catch (NullPointerException var22) {
                  var0.method2650(-19);
               } catch (Exception var23) {
                  var0.method2650(-20);
               } catch (Throwable var24) {
                  var0.method2650(-21);
               }
            }
         }

         var0.method2535(var2);
         var1.method3916();
      }
   }
}
