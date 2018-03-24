import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cq")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -202852229
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-104386321"
   )
   public static void method1924(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3946 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.field3951 = new int[var2.count];
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
                     var21[var12] = GameEngine.loadClassFromDescriptor(var8[var12]);
                  }

                  Class var22 = GameEngine.loadClassFromDescriptor(var20);
                  if(GameEngine.loadClassFromDescriptor(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = GameEngine.loadClassFromDescriptor(var5).getDeclaredMethods();
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
               var2.field3951[var3] = var7;
               if(GameEngine.loadClassFromDescriptor(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(GameEngine.loadClassFromDescriptor(var5), var6);
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

      class326.classInfos.addFirst(var2);
   }
}
