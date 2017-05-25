import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("id")
public class class240 extends CacheableNode {
   @ObfuscatedName("h")
   static NodeCache field3266;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 381699281
   )
   public int field3267;
   @ObfuscatedName("i")
   public static IndexDataBase field3268;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-139679259"
   )
   void method4345(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3267 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "190336498"
   )
   void method4346(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4345(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-111052785"
   )
   public static void method4347(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3737 = var0.readUnsignedByte();
      var2.field3741 = var0.readInt();
      var2.field3736 = new int[var2.field3737];
      var2.field3739 = new int[var2.field3737];
      var2.fields = new Field[var2.field3737];
      var2.field3744 = new int[var2.field3737];
      var2.methods = new Method[var2.field3737];
      var2.args = new byte[var2.field3737][][];

      for(int var3 = 0; var3 < var2.field3737; ++var3) {
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

                  var2.field3736[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class89.method1745(var8[var12]);
                  }

                  Class var22 = class89.method1745(var20);
                  if(class89.method1745(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class89.method1745(var5).getDeclaredMethods();
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

               var2.field3736[var3] = var4;
               var2.field3744[var3] = var7;
               if(class89.method1745(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class89.method1745(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3739[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3739[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3739[var3] = -3;
         } catch (Exception var27) {
            var2.field3739[var3] = -4;
         } catch (Throwable var28) {
            var2.field3739[var3] = -5;
         }
      }

      class280.field3745.method3634(var2);
   }

   static {
      field3266 = new NodeCache(64);
   }

   class240() {
      this.field3267 = 0;
   }
}
