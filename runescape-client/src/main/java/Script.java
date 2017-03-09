import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ag")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -390957817
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("j")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("c")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("d")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -728869169
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("x")
   static NodeCache field964 = new NodeCache(128);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -782272095
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -192076641
   )
   @Export("intStackCount")
   int intStackCount;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "1"
   )
   public static void method971(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3248.method2411();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2819(var1.field3238);

         for(int var3 = 0; var3 < var1.field3240; ++var3) {
            if(var1.field3241[var3] != 0) {
               var0.method2843(var1.field3241[var3]);
            } else {
               try {
                  int var4 = var1.field3239[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method2843(0);
                     var0.method2819(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3243[var3]);
                     var0.method2843(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2843(0);
                     var0.method2819(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2843(0);
                        var0.method2819(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(null == var11) {
                        var0.method2843(0);
                     } else if(var11 instanceof Number) {
                        var0.method2843(1);
                        var0.method2856(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2843(2);
                        var0.method2822((String)var11);
                     } else {
                        var0.method2843(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2843(-10);
               } catch (InvalidClassException var14) {
                  var0.method2843(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2843(-12);
               } catch (OptionalDataException var16) {
                  var0.method2843(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2843(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2843(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2843(-16);
               } catch (SecurityException var20) {
                  var0.method2843(-17);
               } catch (IOException var21) {
                  var0.method2843(-18);
               } catch (NullPointerException var22) {
                  var0.method2843(-19);
               } catch (Exception var23) {
                  var0.method2843(-20);
               } catch (Throwable var24) {
                  var0.method2843(-21);
               }
            }
         }

         var0.method2996(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "764334611"
   )
   static void method972(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1697, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2843(3);
         var3.method2843(null != var1?1:0);
         var3.method2824(var0.getPath());
         if(var1 != null) {
            var3.method2824("");
         }

         var2.method1481(var3.payload, 0, var3.offset);
         var2.method1479();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "505978318"
   )
   static class109 method973() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }
}
