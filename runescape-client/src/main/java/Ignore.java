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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("x")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("c")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -384217135
   )
   protected static int field210;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)LSpritePixels;",
      garbageValue = "18"
   )
   public static SpritePixels method203(IndexDataBase var0, int var1, int var2) {
      if(!class199.method3620(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class229.field3255;
         var4.maxHeight = class229.field3251;
         var4.offsetX = class199.field2877[0];
         var4.offsetY = class229.field3252[0];
         var4.width = class229.field3254[0];
         var4.height = class36.field772[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class229.field3253[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class229.field3249[var6[var7] & 255];
         }

         class199.field2877 = null;
         class229.field3252 = null;
         class229.field3254 = null;
         class36.field772 = null;
         class229.field3249 = null;
         class229.field3253 = null;
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;I)V",
      garbageValue = "-579843349"
   )
   public static void method204(CipherBuffer var0) {
      ClassInfo var1 = (ClassInfo)class231.field3265.method2790();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3258);

         for(int var3 = 0; var3 < var1.field3257; ++var3) {
            if(var1.field3259[var3] != 0) {
               var0.putByte(var1.field3259[var3]);
            } else {
               try {
                  int var4 = var1.field3263[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3261[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
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
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.method2504((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.method2404(var2);
         var1.unlink();
      }
   }
}
