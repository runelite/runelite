import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("x")
public class class7 {
   @ObfuscatedName("c")
   public static boolean field225;
   @ObfuscatedName("o")
   public static boolean field220;
   @ObfuscatedName("i")
   public static boolean field221;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   public static class11 field224;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static CombatInfoList field219;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 924488713
   )
   public static int field223;

   static {
      field225 = false;
      field220 = false;
      field221 = false;
      field224 = class11.field255;
      field219 = new CombatInfoList();
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-486693699"
   )
   static void method37() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class163.method2999(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.field984[var1] = Client.field984[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "0"
   )
   @Export("decodeClassVerifier")
   public static void decodeClassVerifier(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3737 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.fieldValues = new int[var2.count];
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
                     var21[var12] = CombatInfo1.method1498(var8[var12]);
                  }

                  Class var22 = CombatInfo1.method1498(var20);
                  if(CombatInfo1.method1498(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = CombatInfo1.method1498(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
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
               var2.fieldValues[var3] = var7;
               if(CombatInfo1.method1498(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(CombatInfo1.method1498(var5), var6);
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

      class280.field3739.method3509(var2);
   }
}
