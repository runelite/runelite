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

@ObfuscatedName("fr")
public class class169 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 483523945
   )
   public static int field2712;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1190079281
   )
   static int field2713;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1443118017"
   )
   public static void method3279(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3187.method3881();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2709(var1.field3184);

         for(int var3 = 0; var3 < var1.field3179; ++var3) {
            if(var1.field3181[var3] != 0) {
               var0.method2529(var1.field3181[var3]);
            } else {
               try {
                  int var4 = var1.field3178[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2529(0);
                     var0.method2709(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3183[var3]);
                     var0.method2529(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2529(0);
                     var0.method2709(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2529(0);
                        var0.method2709(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2529(0);
                     } else if(var11 instanceof Number) {
                        var0.method2529(1);
                        var0.method2678(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2529(2);
                        var0.method2535((String)var11);
                     } else {
                        var0.method2529(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2529(-10);
               } catch (InvalidClassException var14) {
                  var0.method2529(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2529(-12);
               } catch (OptionalDataException var16) {
                  var0.method2529(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2529(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2529(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2529(-16);
               } catch (SecurityException var20) {
                  var0.method2529(-17);
               } catch (IOException var21) {
                  var0.method2529(-18);
               } catch (NullPointerException var22) {
                  var0.method2529(-19);
               } catch (Exception var23) {
                  var0.method2529(-20);
               } catch (Throwable var24) {
                  var0.method2529(-21);
               }
            }
         }

         var0.method2578(var2);
         var1.unlink();
      }
   }
}
