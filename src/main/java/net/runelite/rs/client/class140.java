package net.runelite.rs.client;

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

@ObfuscatedName("ej")
public class class140 extends class132 {
   @ObfuscatedName("j")
   long[] field2148 = new long[10];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2080588307
   )
   int field2149 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1079529541
   )
   int field2150 = 1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 7477109981299196205L
   )
   long field2151 = class92.method2177();
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1848188753
   )
   int field2152 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -917693957
   )
   int field2153;

   class140() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2148[var1] = this.field2151;
      }

   }

   @ObfuscatedName("j")
   public void vmethod3155() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2148[var1] = 0L;
      }

   }

   @ObfuscatedName("m")
   int vmethod3158(int var1, int var2) {
      int var3 = this.field2149;
      int var4 = this.field2150;
      this.field2149 = 300;
      this.field2150 = 1;
      this.field2151 = class92.method2177();
      if(0L == this.field2148[this.field2153]) {
         this.field2149 = var3;
         this.field2150 = var4;
      } else if(this.field2151 > this.field2148[this.field2153]) {
         this.field2149 = (int)((long)(2560 * var1) / (this.field2151 - this.field2148[this.field2153]));
      }

      if(this.field2149 < 25) {
         this.field2149 = 25;
      }

      if(this.field2149 > 256) {
         this.field2149 = 256;
         this.field2150 = (int)((long)var1 - (this.field2151 - this.field2148[this.field2153]) / 10L);
      }

      if(this.field2150 > var1) {
         this.field2150 = var1;
      }

      this.field2148[this.field2153] = this.field2151;
      this.field2153 = (1 + this.field2153) % 10;
      int var5;
      if(this.field2150 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2148[var5]) {
               this.field2148[var5] += (long)this.field2150;
            }
         }
      }

      if(this.field2150 < var2) {
         this.field2150 = var2;
      }

      class29.method711((long)this.field2150);

      for(var5 = 0; this.field2152 < 256; this.field2152 += this.field2149) {
         ++var5;
      }

      this.field2152 &= 255;
      return var5;
   }

   @ObfuscatedName("f")
   public static String method3010(CharSequence var0, class211 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class84.method1920(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class84.method1920(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3126) {
               case 0:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var5 = new StringBuilder(var4);

               for(int var9 = var2; var9 < var3; ++var9) {
                  char var7 = var0.charAt(var9);
                  if(method3011(var7)) {
                     char var8 = class153.method3199(var7);
                     if(var8 != 0) {
                        var5.append(var8);
                     }
                  }
               }

               if(var5.length() == 0) {
                  return null;
               }

               return var5.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("j")
   static final boolean method3011(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class3.method46(var0)) {
         return true;
      } else {
         char[] var1 = class163.field2638;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var3 == var0) {
               return true;
            }
         }

         var1 = class163.field2639;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   public static void method3013(class118 var0, int var1) {
      if(null != class148.field2220) {
         try {
            class148.field2220.method4188(0L);
            class148.field2220.method4195(var0.field1980, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("df")
   static void method3014(String var0) {
      class11.field165 = var0;

      try {
         String var1 = client.field274.getParameter(class189.field3044.field3055);
         String var2 = client.field274.getParameter(class189.field3051.field3055);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class19.method264(class92.method2177() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class131.method2878(client.field274, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("m")
   public static void method3017(class121 var0) {
      class209 var1 = (class209)class210.field3116.method3907();
      if(null != var1) {
         int var2 = var0.field1981;
         var0.method2524(var1.field3108);

         for(int var3 = 0; var3 < var1.field3113; ++var3) {
            if(0 != var1.field3111[var3]) {
               var0.method2521(var1.field3111[var3]);
            } else {
               try {
                  int var4 = var1.field3109[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3110[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2521(0);
                     var0.method2524(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3110[var3];
                     var5.setInt((Object)null, var1.field3112[var3]);
                     var0.method2521(0);
                  } else if(2 == var4) {
                     var5 = var1.field3110[var3];
                     var6 = var5.getModifiers();
                     var0.method2521(0);
                     var0.method2524(var6);
                  }

                  Method var22;
                  if(3 != var4) {
                     if(var4 == 4) {
                        var22 = var1.field3107[var3];
                        var6 = var22.getModifiers();
                        var0.method2521(0);
                        var0.method2524(var6);
                     }
                  } else {
                     var22 = var1.field3107[var3];
                     byte[][] var23 = var1.field3114[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2521(0);
                     } else if(var24 instanceof Number) {
                        var0.method2521(1);
                        var0.method2690(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2521(2);
                        var0.method2527((String)var24);
                     } else {
                        var0.method2521(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2521(-10);
               } catch (InvalidClassException var11) {
                  var0.method2521(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2521(-12);
               } catch (OptionalDataException var13) {
                  var0.method2521(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2521(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2521(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2521(-16);
               } catch (SecurityException var17) {
                  var0.method2521(-17);
               } catch (IOException var18) {
                  var0.method2521(-18);
               } catch (NullPointerException var19) {
                  var0.method2521(-19);
               } catch (Exception var20) {
                  var0.method2521(-20);
               } catch (Throwable var21) {
                  var0.method2521(-21);
               }
            }
         }

         var0.method2556(var2);
         var1.method3965();
      }
   }
}
