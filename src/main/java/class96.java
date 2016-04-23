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

@ObfuscatedName("ct")
public class class96 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -884386167
   )
   int field1608;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -306025881
   )
   int field1609;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1020265931
   )
   int field1610;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1202106717
   )
   int field1612;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "-48"
   )
   static void method2190(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2190(var0, var1, var2, var5 - 1);
         method2190(var0, var1, var5 + 1, var3);
      }

   }

   class96() {
   }

   class96(class96 var1) {
      this.field1612 = var1.field1612;
      this.field1608 = var1.field1608;
      this.field1609 = var1.field1609;
      this.field1610 = var1.field1610;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-853249416"
   )
   static int method2191() {
      return 9;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-1165918527"
   )
   public static void method2192(class122 var0) {
      class210 var1 = (class210)class211.field3140.method3826();
      if(var1 != null) {
         int var2 = var0.field1971;
         var0.method2488(var1.field3138);

         for(int var3 = 0; var3 < var1.field3130; ++var3) {
            if(0 != var1.field3132[var3]) {
               var0.method2503(var1.field3132[var3]);
            } else {
               try {
                  int var4 = var1.field3131[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3129[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2503(0);
                     var0.method2488(var6);
                  } else if(1 == var4) {
                     var5 = var1.field3129[var3];
                     var5.setInt((Object)null, var1.field3134[var3]);
                     var0.method2503(0);
                  } else if(2 == var4) {
                     var5 = var1.field3129[var3];
                     var6 = var5.getModifiers();
                     var0.method2503(0);
                     var0.method2488(var6);
                  }

                  Method var22;
                  if(var4 != 3) {
                     if(4 == var4) {
                        var22 = var1.field3135[var3];
                        var6 = var22.getModifiers();
                        var0.method2503(0);
                        var0.method2488(var6);
                     }
                  } else {
                     var22 = var1.field3135[var3];
                     byte[][] var23 = var1.field3136[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2503(0);
                     } else if(var24 instanceof Number) {
                        var0.method2503(1);
                        var0.method2490(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2503(2);
                        var0.method2491((String)var24);
                     } else {
                        var0.method2503(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2503(-10);
               } catch (InvalidClassException var11) {
                  var0.method2503(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2503(-12);
               } catch (OptionalDataException var13) {
                  var0.method2503(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2503(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2503(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2503(-16);
               } catch (SecurityException var17) {
                  var0.method2503(-17);
               } catch (IOException var18) {
                  var0.method2503(-18);
               } catch (NullPointerException var19) {
                  var0.method2503(-19);
               } catch (Exception var20) {
                  var0.method2503(-20);
               } catch (Throwable var21) {
                  var0.method2503(-21);
               }
            }
         }

         var0.method2520(var2);
         var1.method3883();
      }
   }
}
