import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("fc")
public class class156 {
   @ObfuscatedName("j")
   static SpritePixels field2209;
   @ObfuscatedName("o")
   public static class182 field2213;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass166;I)V",
      garbageValue = "53742234"
   )
   public static void method2896(class166 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3232.method2351();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method3057(var1.field3224);

         for(int var3 = 0; var3 < var1.field3220; ++var3) {
            if(var1.field3223[var3] != 0) {
               var0.method2912(var1.field3223[var3]);
            } else {
               try {
                  int var4 = var1.field3226[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method2912(0);
                     var0.method3057(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3225[var3]);
                     var0.method2912(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2912(0);
                     var0.method3057(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2912(0);
                        var0.method3057(var6);
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
                        var0.method2912(0);
                     } else if(var11 instanceof Number) {
                        var0.method2912(1);
                        var0.method2917(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2912(2);
                        var0.method3097((String)var11);
                     } else {
                        var0.method2912(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2912(-10);
               } catch (InvalidClassException var14) {
                  var0.method2912(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2912(-12);
               } catch (OptionalDataException var16) {
                  var0.method2912(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2912(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2912(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2912(-16);
               } catch (SecurityException var20) {
                  var0.method2912(-17);
               } catch (IOException var21) {
                  var0.method2912(-18);
               } catch (NullPointerException var22) {
                  var0.method2912(-19);
               } catch (Exception var23) {
                  var0.method2912(-20);
               } catch (Throwable var24) {
                  var0.method2912(-21);
               }
            }
         }

         var0.method2948(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)LObjectComposition;",
      garbageValue = "12"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2882.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2875.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2881 = var0;
         if(var2 != null) {
            var1.method3638(new Buffer(var2));
         }

         var1.method3599();
         if(var1.isSolid) {
            var1.field2901 = 0;
            var1.field2876 = false;
         }

         ObjectComposition.field2882.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(LActor;IS)V",
      garbageValue = "672"
   )
   static final void method2898(Actor var0, int var1) {
      class18.method203(var0.x, var0.y, var1);
   }

   class156() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "2036155371"
   )
   public static int method2899(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
