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

@ObfuscatedName("kr")
public class class299 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 1063878955751186843L
   )
   long field3846;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4496943503926822093L
   )
   long field3843;
   @ObfuscatedName("m")
   public boolean field3844;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 5557071410212211601L
   )
   long field3845;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2729037419693662685L
   )
   long field3850;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8756089242254021191L
   )
   long field3851;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -877133147
   )
   int field3848;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1292430349
   )
   int field3849;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1633235051
   )
   int field3847;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1887009929
   )
   int field3842;

   public class299() {
      this.field3846 = -1L;
      this.field3843 = -1L;
      this.field3844 = false;
      this.field3845 = 0L;
      this.field3850 = 0L;
      this.field3851 = 0L;
      this.field3848 = 0;
      this.field3849 = 0;
      this.field3847 = 0;
      this.field3842 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-747835459"
   )
   public void method5516() {
      this.field3846 = SceneTilePaint.currentTimeMs();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-797293004"
   )
   public void method5517() {
      if(-1L != this.field3846) {
         this.field3850 = SceneTilePaint.currentTimeMs() - this.field3846;
         this.field3846 = -1L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "91"
   )
   public void method5530(int var1) {
      this.field3843 = SceneTilePaint.currentTimeMs();
      this.field3848 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1640301144"
   )
   public void method5519() {
      if(this.field3843 != -1L) {
         this.field3845 = SceneTilePaint.currentTimeMs() - this.field3843;
         this.field3843 = -1L;
      }

      ++this.field3847;
      this.field3844 = true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "690795276"
   )
   public void method5520() {
      this.field3844 = false;
      this.field3849 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-404870913"
   )
   public void method5521() {
      this.method5519();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "2010748356"
   )
   public void method5529(Buffer var1) {
      MouseRecorder.method1075(var1, this.field3850);
      MouseRecorder.method1075(var1, this.field3845);
      MouseRecorder.method1075(var1, this.field3851);
      var1.putShort(this.field3848);
      var1.putShort(this.field3849);
      var1.putShort(this.field3847);
      var1.putShort(this.field3842);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgt;I)V",
      garbageValue = "1878847415"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class304.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3865);

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
                     Reflection.setInt(var5, (Object)null, var1.field3866[var3]);
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
