import java.awt.datatransfer.Clipboard;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("l")
   @Export("previousName")
   String field131;
   @ObfuscatedName("ab")
   static class146 field132;
   @ObfuscatedName("pu")
   static Clipboard field133;
   @ObfuscatedName("pv")
   static GarbageCollectorMXBean field134;
   @ObfuscatedName("ns")
   static class77 field135;
   @ObfuscatedName("e")
   @Export("name")
   String field141;
   @ObfuscatedName("mx")
   static byte field142;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "2136160317"
   )
   public static void method93(class125 var0) {
      class213 var1 = (class213)class214.field3177.method3938();
      if(null != var1) {
         int var2 = var0.field2061;
         var0.method2598(var1.field3176);

         for(int var3 = 0; var3 < var1.field3169; ++var3) {
            if(var1.field3172[var3] != 0) {
               var0.method2795(var1.field3172[var3]);
            } else {
               try {
                  int var4 = var1.field3171[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3173[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2795(0);
                     var0.method2598(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3173[var3];
                     var5.setInt((Object)null, var1.field3174[var3]);
                     var0.method2795(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3173[var3];
                     var6 = var5.getModifiers();
                     var0.method2795(0);
                     var0.method2598(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3175[var3];
                        var6 = var25.getModifiers();
                        var0.method2795(0);
                        var0.method2598(var6);
                     }
                  } else {
                     var25 = var1.field3175[var3];
                     byte[][] var10 = var1.field3170[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2795(0);
                     } else if(var11 instanceof Number) {
                        var0.method2795(1);
                        var0.method2709(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2795(2);
                        var0.method2601((String)var11);
                     } else {
                        var0.method2795(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2795(-10);
               } catch (InvalidClassException var14) {
                  var0.method2795(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2795(-12);
               } catch (OptionalDataException var16) {
                  var0.method2795(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2795(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2795(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2795(-16);
               } catch (SecurityException var20) {
                  var0.method2795(-17);
               } catch (IOException var21) {
                  var0.method2795(-18);
               } catch (NullPointerException var22) {
                  var0.method2795(-19);
               } catch (Exception var23) {
                  var0.method2795(-20);
               } catch (Throwable var24) {
                  var0.method2795(-21);
               }
            }
         }

         var0.method2631(var2);
         var1.method4000();
      }
   }
}
