import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("he")
public class class211 {
   @ObfuscatedName("c")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -766423175
   )
   static int field2607;
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("h")
   static SpritePixels field2609;
   @ObfuscatedName("j")
   public static class123[] field2610;
   @ObfuscatedName("i")
   public static int[] field2612;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   public static void method3906() {
      KitDefinition.field3354.reset();
   }

   static {
      field2612 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2612[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-113"
   )
   static int method3909(CharSequence var0, int var1, boolean var2) {
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

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
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

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1254258393"
   )
   static boolean method3910(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class154.method2955(var0, World.field1331);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class154.method2955(var3.name, World.field1331))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class154.method2955(var3.previousName, World.field1331))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass163;",
      garbageValue = "0"
   )
   static class163 method3911(int var0, int var1) {
      Client.field933.field2335 = var0;
      Client.field933.field2333 = var1;
      Client.field933.field2334 = 1;
      Client.field933.field2332 = 1;
      return Client.field933;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-57"
   )
   public static void method3912(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3749 = var0.readUnsignedByte();
      var2.field3742 = var0.readInt();
      var2.field3743 = new int[var2.field3749];
      var2.field3744 = new int[var2.field3749];
      var2.fields = new Field[var2.field3749];
      var2.field3741 = new int[var2.field3749];
      var2.methods = new Method[var2.field3749];
      var2.args = new byte[var2.field3749][][];

      for(int var3 = 0; var3 < var2.field3749; ++var3) {
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

                  var2.field3743[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class9.method42(var8[var12]);
                  }

                  Class var22 = class9.method42(var20);
                  if(class9.method42(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class9.method42(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
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

               var2.field3743[var3] = var4;
               var2.field3741[var3] = var7;
               if(class9.method42(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class9.method42(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3744[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3744[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3744[var3] = -3;
         } catch (Exception var27) {
            var2.field3744[var3] = -4;
         } catch (Throwable var28) {
            var2.field3744[var3] = -5;
         }
      }

      class280.field3751.method3531(var2);
   }
}
