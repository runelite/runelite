import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("jf")
public class class261 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3602;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3603;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3609;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3604;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3605;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final class261 field3600;
   @ObfuscatedName("v")
   final String field3601;
   @ObfuscatedName("t")
   String field3606;

   static {
      field3603 = new class261("PLAIN11", "p11_full");
      field3605 = new class261("PLAIN12", "p12_full");
      field3600 = new class261("BOLD12", "b12_full");
      field3602 = new class261("VERDANA11", "verdana_11pt_regular");
      field3609 = new class261("VERDANA13", "verdana_13pt_regular");
      field3604 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3601 = var1;
      this.field3606 = var2;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(III)Lfu;",
      garbageValue = "1686400108"
   )
   static class163 method4715(int var0, int var1) {
      Client.field1159.field2288 = var0;
      Client.field1159.field2284 = var1;
      Client.field1159.field2287 = 1;
      Client.field1159.field2286 = 1;
      return Client.field1159;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljf;",
      garbageValue = "1118027707"
   )
   public static class261[] method4716() {
      return new class261[]{field3603, field3604, field3600, field3609, field3605, field3602};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)V",
      garbageValue = "1"
   )
   @Export("decodeClassVerifier")
   public static void decodeClassVerifier(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3730 = var0.readInt();
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
                     var21[var12] = class92.method1761(var8[var12]);
                  }

                  Class var22 = class92.method1761(var20);
                  if(class92.method1761(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class92.method1761(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var21.length == var17.length) {
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
               if(class92.method1761(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class92.method1761(var5), var6);
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

      class280.field3735.method3577(var2);
   }
}
