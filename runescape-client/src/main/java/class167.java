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

@ObfuscatedName("fn")
public class class167 {
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -385821669
   )
   static int field2710;
   @ObfuscatedName("e")
   static final char[] field2712 = new char[]{'[', ']', '#'};
   @ObfuscatedName("r")
   static final char[] field2713 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "1410938763"
   )
   public static void method3370(class125 var0) {
      class213 var1 = (class213)class214.field3189.method4011();
      if(var1 != null) {
         int var2 = var0.field2050;
         var0.method2728(var1.field3182);

         for(int var3 = 0; var3 < var1.field3177; ++var3) {
            if(var1.field3180[var3] != 0) {
               var0.method2783(var1.field3180[var3]);
            } else {
               try {
                  int var4 = var1.field3179[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3181[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2783(0);
                     var0.method2728(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3181[var3];
                     var5.setInt((Object)null, var1.field3178[var3]);
                     var0.method2783(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3181[var3];
                     var6 = var5.getModifiers();
                     var0.method2783(0);
                     var0.method2728(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3183[var3];
                        var6 = var25.getModifiers();
                        var0.method2783(0);
                        var0.method2728(var6);
                     }
                  } else {
                     var25 = var1.field3183[var3];
                     byte[][] var10 = var1.field3184[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2783(0);
                     } else if(var11 instanceof Number) {
                        var0.method2783(1);
                        var0.method2623(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2783(2);
                        var0.method2703((String)var11);
                     } else {
                        var0.method2783(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2783(-10);
               } catch (InvalidClassException var14) {
                  var0.method2783(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2783(-12);
               } catch (OptionalDataException var16) {
                  var0.method2783(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2783(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2783(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2783(-16);
               } catch (SecurityException var20) {
                  var0.method2783(-17);
               } catch (IOException var21) {
                  var0.method2783(-18);
               } catch (NullPointerException var22) {
                  var0.method2783(-19);
               } catch (Exception var23) {
                  var0.method2783(-20);
               } catch (Throwable var24) {
                  var0.method2783(-21);
               }
            }
         }

         var0.method2773(var2);
         var1.method4067();
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)V",
      garbageValue = "82"
   )
   static final void method3372(class176 var0) {
      int var1 = var0.field2811;
      if(var1 == 324) {
         if(client.field568 == -1) {
            client.field568 = var0.field2842;
            client.field569 = var0.field2843;
         }

         if(client.field567.field2971) {
            var0.field2842 = client.field568;
         } else {
            var0.field2842 = client.field569;
         }

      } else if(var1 == 325) {
         if(client.field568 == -1) {
            client.field568 = var0.field2842;
            client.field569 = var0.field2843;
         }

         if(client.field567.field2971) {
            var0.field2842 = client.field569;
         } else {
            var0.field2842 = client.field568;
         }

      } else if(var1 == 327) {
         var0.field2927 = 150;
         var0.field2859 = (int)(Math.sin((double)client.field305 / 40.0D) * 256.0D) & 2047;
         var0.field2800 = 5;
         var0.field2851 = 0;
      } else if(var1 == 328) {
         var0.field2927 = 150;
         var0.field2859 = (int)(Math.sin((double)client.field305 / 40.0D) * 256.0D) & 2047;
         var0.field2800 = 5;
         var0.field2851 = 1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-581969032"
   )
   public static boolean method3373(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILclass170;IIIZI)V",
      garbageValue = "562665678"
   )
   public static void method3374(int var0, class170 var1, int var2, int var3, int var4, boolean var5) {
      class186.field3010 = 1;
      class111.field1970 = var1;
      class140.field2184 = var2;
      class186.field3009 = var3;
      class11.field176 = var4;
      class37.field814 = var5;
      class144.field2222 = var0;
   }
}
