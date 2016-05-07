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

@ObfuscatedName("ei")
public class class130 {
   @ObfuscatedName("s")
   static final class130 field2068 = new class130(0);
   @ObfuscatedName("j")
   public static final class130 field2069 = new class130(1);
   @ObfuscatedName("p")
   static final class130 field2070 = new class130(2);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1552443513
   )
   public final int field2073;
   @ObfuscatedName("i")
   static int[] field2077;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1175089781"
   )
   public static String method2811(CharSequence var0) {
      return class121.method2734('*', var0.length());
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-78"
   )
   static final String method2815(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "64"
   )
   static final void method2818(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field411.method3812(); var10 != null; var10 = (class16)client.field411.method3817()) {
         if(var10.field227 == var0 && var1 == var10.field221 && var2 == var10.field232 && var3 == var10.field220) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field227 = var0;
         var9.field220 = var3;
         var9.field221 = var1;
         var9.field232 = var2;
         class148.method3114(var9);
         client.field411.method3807(var9);
      }

      var9.field223 = var4;
      var9.field219 = var5;
      var9.field224 = var6;
      var9.field228 = var7;
      var9.field230 = var8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2073 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-384958629"
   )
   public static void method2819(class122 var0) {
      class210 var1 = (class210)class211.field3143.method3856();
      if(var1 != null) {
         int var2 = var0.field2005;
         var0.method2480(var1.field3136);

         for(int var3 = 0; var3 < var1.field3140; ++var3) {
            if(0 != var1.field3135[var3]) {
               var0.method2477(var1.field3135[var3]);
            } else {
               try {
                  int var4 = var1.field3134[var3];
                  Field var5;
                  int var6;
                  if(0 == var4) {
                     var5 = var1.field3133[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2477(0);
                     var0.method2480(var6);
                  } else if(1 == var4) {
                     var5 = var1.field3133[var3];
                     var5.setInt((Object)null, var1.field3137[var3]);
                     var0.method2477(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3133[var3];
                     var6 = var5.getModifiers();
                     var0.method2477(0);
                     var0.method2480(var6);
                  }

                  Method var22;
                  if(3 != var4) {
                     if(4 == var4) {
                        var22 = var1.field3138[var3];
                        var6 = var22.getModifiers();
                        var0.method2477(0);
                        var0.method2480(var6);
                     }
                  } else {
                     var22 = var1.field3138[var3];
                     byte[][] var23 = var1.field3139[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2477(0);
                     } else if(var24 instanceof Number) {
                        var0.method2477(1);
                        var0.method2482(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2477(2);
                        var0.method2483((String)var24);
                     } else {
                        var0.method2477(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2477(-10);
               } catch (InvalidClassException var11) {
                  var0.method2477(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2477(-12);
               } catch (OptionalDataException var13) {
                  var0.method2477(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2477(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2477(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2477(-16);
               } catch (SecurityException var17) {
                  var0.method2477(-17);
               } catch (IOException var18) {
                  var0.method2477(-18);
               } catch (NullPointerException var19) {
                  var0.method2477(-19);
               } catch (Exception var20) {
                  var0.method2477(-20);
               } catch (Throwable var21) {
                  var0.method2477(-21);
               }
            }
         }

         var0.method2651(var2);
         var1.method3898();
      }
   }
}
