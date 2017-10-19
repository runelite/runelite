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

@ObfuscatedName("hq")
public enum class232 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3188("runescape", "RuneScape", 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3186("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3187("game3", "Game 3", 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3189("game4", "Game 4", 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3190("game5", "Game 5", 4),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   field3191("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("p")
   public final String field3192;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -76893317
   )
   final int field3193;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   static class47 field3194;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;

   class232(String var3, String var4, int var5) {
      this.field3192 = var3;
      this.field3193 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3193;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "366962723"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class281.field3766.method3655();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3758);

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
                     Reflection.setInt(var5, (Object)null, var1.field3762[var3]);
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
                        var0.putString((String)var11);
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

         var0.putCrc(var2);
         var1.unlink();
      }
   }
}
