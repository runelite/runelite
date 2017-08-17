import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("f")
final class class2 implements class0 {
   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field12;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -577654507
   )
   static int field14;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 1315797103
   )
   static int field13;

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1279031696"
   )
   static void method4(int var0, int var1, int var2) {
      if(Client.field974 != 0 && var1 != 0 && Client.field1166 < 50) {
         Client.field1167[Client.field1166] = var0;
         Client.field1168[Client.field1166] = var1;
         Client.field1169[Client.field1166] = var2;
         Client.audioEffects[Client.field1166] = null;
         Client.field1170[Client.field1166] = 0;
         ++Client.field1166;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "-63"
   )
   public static void method5(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3737 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.field3734 = new int[var2.count];
      var2.methods = new Method[var2.count];
      var2.args = new byte[var2.count][][];

      for(int var3 = 0; var3 < var2.count; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.readString();
                  var6 = var0.readString();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readString();
                  }

                  String var20 = var0.readString();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.readBytes(var10[var11], 0, var12);
                     }
                  }

                  var2.type[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class61.method1118(var8[var12]);
                  }

                  Class var22 = class61.method1118(var20);
                  if(class61.method1118(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class61.method1118(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var21.length == var17.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.readString();
               var6 = var0.readString();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.type[var3] = var4;
               var2.field3734[var3] = var7;
               if(class61.method1118(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class61.method1118(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.errorIdentifiers[var3] = -1;
         } catch (SecurityException var25) {
            var2.errorIdentifiers[var3] = -2;
         } catch (NullPointerException var26) {
            var2.errorIdentifiers[var3] = -3;
         } catch (Exception var27) {
            var2.errorIdentifiers[var3] = -4;
         } catch (Throwable var28) {
            var2.errorIdentifiers[var3] = -5;
         }
      }

      class281.field3740.method3568(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILez;[Lfc;I)V",
      garbageValue = "-1171203245"
   )
   static final void method3(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class37.getObjectDefinition(var11);
               int var22 = var2 + Preferences.method1591(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.sizeX;
               int var29 = var21.sizeY;
               int var30;
               if((var20 & 1) == 1) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if(var27 == 0) {
                  var24 = var26;
               } else if(var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if(var27 == 2) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var3 + var24;
               if(var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class61.tileSettings[1][var22][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class89.addObject(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }
}
