import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("fx")
public enum class158 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   field2138(1, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   field2137(0, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   field2141(2, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   field2139(3, 3);

   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1561228315
   )
   public final int field2140;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 427783845
   )
   final int field2142;

   class158(int var3, int var4) {
      this.field2140 = var3;
      this.field2142 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field2142;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1805954882"
   )
   public static void method3259(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3956 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.field3955 = new int[var2.count];
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
                     var21[var12] = GameObject.loadClassFromDescriptor(var8[var12]);
                  }

                  Class var22 = GameObject.loadClassFromDescriptor(var20);
                  if(GameObject.loadClassFromDescriptor(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = GameObject.loadClassFromDescriptor(var5).getDeclaredMethods();
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
               var2.field3955[var3] = var7;
               if(GameObject.loadClassFromDescriptor(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(GameObject.loadClassFromDescriptor(var5), var6);
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
