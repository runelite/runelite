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

@ObfuscatedName("fz")
public class class159 implements class112 {
   @ObfuscatedName("s")
   public static final class159 field2597 = new class159(2, 3);
   @ObfuscatedName("w")
   public static final class159 field2598 = new class159(1, 1);
   @ObfuscatedName("f")
   public static final class159 field2599 = new class159(3, 2);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 934085975
   )
   final int field2600;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 530132215
   )
   public final int field2601;
   @ObfuscatedName("e")
   public static final class159 field2602 = new class159(0, 0);

   @ObfuscatedName("w")
   public static String method3171(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2648[(int)(var6 - 37L * var0)];
               if(95 == var8) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   public int vmethod3172() {
      return this.field2600;
   }

   class159(int var1, int var2) {
      this.field2601 = var1;
      this.field2600 = var2;
   }

   @ObfuscatedName("i")
   static class168 method3175(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(null != class149.field2227) {
         var4 = new class134(var0, class149.field2227, class149.field2230[var0], 1000000);
      }

      return new class168(var4, class169.field2698, var0, var1, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-590422145"
   )
   public static void method3176(class122 var0) {
      class210 var1 = (class210)class211.field3129.method3866();
      if(null != var1) {
         int var2 = var0.field1976;
         var0.method2617(var1.field3121);

         for(int var3 = 0; var3 < var1.field3120; ++var3) {
            if(0 != var1.field3122[var3]) {
               var0.method2565(var1.field3122[var3]);
            } else {
               try {
                  int var4 = var1.field3119[var3];
                  Field var5;
                  int var6;
                  if(0 == var4) {
                     var5 = var1.field3123[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2565(0);
                     var0.method2617(var6);
                  } else if(1 == var4) {
                     var5 = var1.field3123[var3];
                     var5.setInt((Object)null, var1.field3124[var3]);
                     var0.method2565(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3123[var3];
                     var6 = var5.getModifiers();
                     var0.method2565(0);
                     var0.method2617(var6);
                  }

                  Method var22;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var22 = var1.field3125[var3];
                        var6 = var22.getModifiers();
                        var0.method2565(0);
                        var0.method2617(var6);
                     }
                  } else {
                     var22 = var1.field3125[var3];
                     byte[][] var23 = var1.field3126[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2565(0);
                     } else if(var24 instanceof Number) {
                        var0.method2565(1);
                        var0.method2580(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2565(2);
                        var0.method2514((String)var24);
                     } else {
                        var0.method2565(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2565(-10);
               } catch (InvalidClassException var11) {
                  var0.method2565(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2565(-12);
               } catch (OptionalDataException var13) {
                  var0.method2565(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2565(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2565(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2565(-16);
               } catch (SecurityException var17) {
                  var0.method2565(-17);
               } catch (IOException var18) {
                  var0.method2565(-18);
               } catch (NullPointerException var19) {
                  var0.method2565(-19);
               } catch (Exception var20) {
                  var0.method2565(-20);
               } catch (Throwable var21) {
                  var0.method2565(-21);
               }
            }
         }

         var0.method2627(var2);
         var1.method3913();
      }
   }
}
