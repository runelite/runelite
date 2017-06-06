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
import net.runelite.rs.Reflection;

@ObfuscatedName("io")
public class class257 implements class178 {
   @ObfuscatedName("c")
   static final class257 field3538;
   @ObfuscatedName("i")
   static final class257 field3539;
   @ObfuscatedName("e")
   static final class257 field3540;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -100202383
   )
   public final int field3541;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1049180811
   )
   final int field3542;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3542;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class257(int var1, int var2) {
      this.field3541 = var1;
      this.field3542 = var2;
   }

   static {
      field3539 = new class257(1, 0);
      field3538 = new class257(0, 1);
      field3540 = new class257(2, 2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-991962441"
   )
   public static void method4641(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class280.field3751.method3530();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3742);

         for(int var3 = 0; var3 < var1.field3749; ++var3) {
            if(var1.field3744[var3] != 0) {
               var0.putByte(var1.field3744[var3]);
            } else {
               try {
                  int var4 = var1.field3743[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3741[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
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
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.method3150((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.method3163(var2);
         var1.unlink();
      }
   }
}
