import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("er")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("n")
   Frame[] field2148;
   @ObfuscatedName("em")
   static RSSocket field2149;
   @ObfuscatedName("gs")
   static SpritePixels[] field2151;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 544659375
   )
   static int field2152;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-323398394"
   )
   public boolean method2879(int var1) {
      return this.field2148[var1].showing;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;IIIB)Z",
      garbageValue = "-59"
   )
   static final boolean method2882(Model var0, int var1, int var2, int var3) {
      if(!class168.method3121()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class134.field2004) {
            var4 = Region.field2086;
            var5 = Region.field2114;
            var6 = Region.field2088;
            var7 = Region.field2099;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class134.field2001 - class136.field2029) * var8 / class136.field2028;
            var11 = (class134.field2003 - class136.field2030) * var8 / class136.field2028;
            var12 = (class134.field2001 - class136.field2029) * var9 / class136.field2028;
            int var13 = (class134.field2003 - class136.field2030) * var9 / class136.field2028;
            int var14 = class136.method2640(var11, var8, var5, var4);
            var15 = class136.method2667(var11, var8, var5, var4);
            var11 = var14;
            var14 = class136.method2640(var13, var9, var5, var4);
            var16 = class136.method2667(var13, var9, var5, var4);
            var13 = var14;
            var14 = class136.method2668(var10, var15, var7, var6);
            var15 = class136.method2614(var10, var15, var7, var6);
            var10 = var14;
            var14 = class136.method2668(var12, var16, var7, var6);
            var16 = class136.method2614(var12, var16, var7, var6);
            class98.field1526 = (var10 + var14) / 2;
            class134.field2010 = (var11 + var13) / 2;
            class134.field2005 = (var15 + var16) / 2;
            class134.field2011 = (var14 - var10) / 2;
            class9.field253 = (var13 - var11) / 2;
            XItemContainer.field768 = (var16 - var15) / 2;
            class2.field22 = Math.abs(class134.field2011);
            TextureProvider.field1786 = Math.abs(class9.field253);
            class134.field2008 = Math.abs(XItemContainer.field768);
         }

         var4 = var1 + var0.field1992;
         var5 = var2 + var0.field1932;
         var6 = var0.field1933 + var3;
         var7 = var0.field1966;
         var15 = var0.field1967;
         var16 = var0.field1953;
         var10 = class98.field1526 - var4;
         var11 = class134.field2010 - var5;
         var12 = class134.field2005 - var6;
         return Math.abs(var10) > class2.field22 + var7?false:(Math.abs(var11) > TextureProvider.field1786 + var15?false:(Math.abs(var12) > class134.field2008 + var16?false:(Math.abs(var12 * class9.field253 - XItemContainer.field768 * var11) > TextureProvider.field1786 * var16 + class134.field2008 * var15?false:(Math.abs(var10 * XItemContainer.field768 - var12 * class134.field2011) > var7 * class134.field2008 + class2.field22 * var16?false:Math.abs(var11 * class134.field2011 - class9.field253 * var10) <= var7 * TextureProvider.field1786 + var15 * class2.field22))));
      }
   }

   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method4174(var3);
      this.field2148 = new Frame[var6];
      int[] var7 = var1.method4156(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3622(); var12 != null; var12 = (FrameMap)var5.method3608()) {
            if(var12.field2053 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method4149(0, var11);
            } else {
               var13 = var2.method4149(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3634(var10);
         }

         this.field2148[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "956823001"
   )
   public static void method2885(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class280.field3749.method3571();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3741);

         for(int var3 = 0; var3 < var1.field3740; ++var3) {
            if(var1.field3743[var3] != 0) {
               var0.putByte(var1.field3743[var3]);
            } else {
               try {
                  int var4 = var1.field3742[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3745[var3]);
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

         var0.method3297(var2);
         var1.unlink();
      }
   }
}
