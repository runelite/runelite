import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class11 {
   @ObfuscatedName("a")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("d")
   static final class201 field166 = new class201(1024);
   @ObfuscatedName("v")
   static final class203 field167 = new class203();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1481351903
   )
   static int field168 = 0;

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "358920806"
   )
   static final void method145(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field285 && Item.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class16.region.method2022(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class16.region.method2066(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class16.region.method1976(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class16.region.method1977(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class16.region.method2033(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class16.region.method1965(var0, var2, var3);
               var12 = class165.getObjectDefinition(var13);
               if(var12.field965 != 0) {
                  Client.collisionMaps[var0].method2416(var2, var3, var14, var15, var12.field966);
               }
            }

            if(var1 == 1) {
               class16.region.method1968(var0, var2, var3);
            }

            if(var1 == 2) {
               class16.region.method1948(var0, var2, var3);
               var12 = class165.getObjectDefinition(var13);
               if(var12.field963 + var2 > 103 || var12.field963 + var3 > 103 || var2 + var12.field964 > 103 || var3 + var12.field964 > 103) {
                  return;
               }

               if(var12.field965 != 0) {
                  Client.collisionMaps[var0].method2423(var2, var3, var12.field963, var12.field964, var15, var12.field966);
               }
            }

            if(var1 == 3) {
               class16.region.method2000(var0, var2, var3);
               var12 = class165.getObjectDefinition(var13);
               if(var12.field965 == 1) {
                  Client.collisionMaps[var0].method2419(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            SecondaryBufferProvider.method1679(var0, var11, var2, var3, var4, var5, var6, class16.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "33"
   )
   static boolean method154(Widget var0) {
      if(Client.field558) {
         if(GameEngine.method3133(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "101"
   )
   static final int method156(int var0, int var1) {
      int var2 = class117.method2466(var0 - 1, var1 - 1) + class117.method2466(var0 + 1, var1 - 1) + class117.method2466(var0 - 1, var1 + 1) + class117.method2466(1 + var0, 1 + var1);
      int var3 = class117.method2466(var0 - 1, var1) + class117.method2466(var0 + 1, var1) + class117.method2466(var0, var1 - 1) + class117.method2466(var0, 1 + var1);
      int var4 = class117.method2466(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-17"
   )
   public static void method157() {
      class214.field3187 = new class205();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1585045436"
   )
   public static void method158(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3187.method3901();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2600(var1.field3179);

         for(int var3 = 0; var3 < var1.field3178; ++var3) {
            if(var1.field3183[var3] != 0) {
               var0.method2513(var1.field3183[var3]);
            } else {
               try {
                  int var4 = var1.field3177[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2513(0);
                     var0.method2600(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3182[var3]);
                     var0.method2513(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2513(0);
                     var0.method2600(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2513(0);
                        var0.method2600(var6);
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
                     if(null == var11) {
                        var0.method2513(0);
                     } else if(var11 instanceof Number) {
                        var0.method2513(1);
                        var0.method2527(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2513(2);
                        var0.method2519((String)var11);
                     } else {
                        var0.method2513(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2513(-10);
               } catch (InvalidClassException var14) {
                  var0.method2513(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2513(-12);
               } catch (OptionalDataException var16) {
                  var0.method2513(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2513(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2513(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2513(-16);
               } catch (SecurityException var20) {
                  var0.method2513(-17);
               } catch (IOException var21) {
                  var0.method2513(-18);
               } catch (NullPointerException var22) {
                  var0.method2513(-19);
               } catch (Exception var23) {
                  var0.method2513(-20);
               } catch (Throwable var24) {
                  var0.method2513(-21);
               }
            }
         }

         var0.method2550(var2);
         var1.unlink();
      }
   }
}
