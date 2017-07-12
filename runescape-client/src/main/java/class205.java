import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gl")
public class class205 extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -837779237
   )
   int field2546;
   @ObfuscatedName("a")
   class207 field2547;
   @ObfuscatedName("t")
   class107 field2548;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -237639853
   )
   int field2549;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -755631907
   )
   int field2550;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 463333081
   )
   int field2551;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1359167121
   )
   int field2552;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2011734413
   )
   int field2553;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 28268075
   )
   int field2554;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1828918217
   )
   int field2555;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1446529713
   )
   int field2556;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2008137635
   )
   int field2557;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -941902761
   )
   int field2558;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1206528403
   )
   int field2559;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -378149433
   )
   int field2560;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1531283323
   )
   int field2561;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -837445589
   )
   int field2562;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2033054195
   )
   int field2563;
   @ObfuscatedName("n")
   class117 field2564;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 295922261
   )
   int field2565;
   @ObfuscatedName("w")
   class202 field2566;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1084482843"
   )
   @Export("hsl24to16")
   static final int hsl24to16(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1698456847"
   )
   void method3802() {
      this.field2547 = null;
      this.field2548 = null;
      this.field2566 = null;
      this.field2564 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass244;",
      garbageValue = "0"
   )
   @Export("getVarClientStringType")
   public static class244 getVarClientStringType(int var0) {
      class244 var1 = (class244)class244.field3322.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3324.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4323(new Buffer(var2));
         }

         class244.field3322.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-7"
   )
   static void method3804(int var0) {
      for(WidgetConfig var1 = (WidgetConfig)Client.widgetFlags.method3533(); var1 != null; var1 = (WidgetConfig)Client.widgetFlags.method3538()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-707775963"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class280.field3755.method3547();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3750);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.fieldValues[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var7;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var7 = var1.methods[var3];
                        var6 = var7.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var7 = var1.methods[var3];
                     byte[][] var8 = var1.args[var3];
                     Object[] var9 = new Object[var8.length];

                     for(int var10 = 0; var10 < var8.length; ++var10) {
                        ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                        var9[var10] = var11.readObject();
                     }

                     Object var24 = Reflection.invoke(var7, (Object)null, var9);
                     if(var24 == null) {
                        var0.putByte(0);
                     } else if(var24 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var24);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var12) {
                  var0.putByte(-10);
               } catch (InvalidClassException var13) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var14) {
                  var0.putByte(-12);
               } catch (OptionalDataException var15) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var16) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var17) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var18) {
                  var0.putByte(-16);
               } catch (SecurityException var19) {
                  var0.putByte(-17);
               } catch (IOException var20) {
                  var0.putByte(-18);
               } catch (NullPointerException var21) {
                  var0.putByte(-19);
               } catch (Exception var22) {
                  var0.putByte(-20);
               } catch (Throwable var23) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }

   }
}
