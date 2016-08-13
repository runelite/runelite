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
      ClassInfo var1 = (ClassInfo)class214.field3189.method4011();
      if(var1 != null) {
         int var2 = var0.offset;
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
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2783(0);
                     var0.method2728(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3178[var3]);
                     var0.method2783(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2783(0);
                     var0.method2728(var6);
                  }

                  Method var7;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var7 = var1.methods[var3];
                        var6 = var7.getModifiers();
                        var0.method2783(0);
                        var0.method2728(var6);
                     }
                  } else {
                     var7 = var1.methods[var3];
                     byte[][] var8 = var1.args[var3];
                     Object[] var9 = new Object[var8.length];

                     for(int var10 = 0; var10 < var8.length; ++var10) {
                        ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                        var9[var10] = var11.readObject();
                     }

                     Object var24 = var7.invoke((Object)null, var9);
                     if(var24 == null) {
                        var0.method2783(0);
                     } else if(var24 instanceof Number) {
                        var0.method2783(1);
                        var0.method2623(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2783(2);
                        var0.method2703((String)var24);
                     } else {
                        var0.method2783(4);
                     }
                  }
               } catch (ClassNotFoundException var12) {
                  var0.method2783(-10);
               } catch (InvalidClassException var13) {
                  var0.method2783(-11);
               } catch (StreamCorruptedException var14) {
                  var0.method2783(-12);
               } catch (OptionalDataException var15) {
                  var0.method2783(-13);
               } catch (IllegalAccessException var16) {
                  var0.method2783(-14);
               } catch (IllegalArgumentException var17) {
                  var0.method2783(-15);
               } catch (InvocationTargetException var18) {
                  var0.method2783(-16);
               } catch (SecurityException var19) {
                  var0.method2783(-17);
               } catch (IOException var20) {
                  var0.method2783(-18);
               } catch (NullPointerException var21) {
                  var0.method2783(-19);
               } catch (Exception var22) {
                  var0.method2783(-20);
               } catch (Throwable var23) {
                  var0.method2783(-21);
               }
            }
         }

         var0.method2773(var2);
         var1.unlink();
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "82"
   )
   static final void method3372(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field568 == -1) {
            Client.field568 = var0.textureId;
            Client.field569 = var0.field2843;
         }

         if(Client.field567.isFemale) {
            var0.textureId = Client.field568;
         } else {
            var0.textureId = Client.field569;
         }
      } else if(var1 == 325) {
         if(Client.field568 == -1) {
            Client.field568 = var0.textureId;
            Client.field569 = var0.field2843;
         }

         if(Client.field567.isFemale) {
            var0.textureId = Client.field569;
         } else {
            var0.textureId = Client.field568;
         }
      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
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
      CollisionData.field1970 = var1;
      class140.field2184 = var2;
      class186.field3009 = var3;
      class11.field176 = var4;
      MessageNode.field814 = var5;
      class144.field2222 = var0;
   }
}
