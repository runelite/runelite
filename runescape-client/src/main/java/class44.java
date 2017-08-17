import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ad")
public class class44 extends WorldMapData {
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1401713743
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexedSprite field590;
   @ObfuscatedName("r")
   List field585;
   @ObfuscatedName("i")
   HashSet field588;
   @ObfuscatedName("s")
   HashSet field587;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lfb;ZI)V",
      garbageValue = "-924881082"
   )
   void method662(Buffer var1, boolean var2) {
      this.field585 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3189();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field585.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Lfb;Lfb;Lfb;IZB)V",
      garbageValue = "-48"
   )
   void method659(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field588 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method171(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field588.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field587 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method674(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field587.add(var9);
      }

      this.method662(var2, var5);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfo;I)V",
      garbageValue = "-2034698525"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class281.field3740.method3572();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3737);

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
                     Reflection.setInt(var5, (Object)null, var1.field3734[var3]);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljr;S)V",
      garbageValue = "-5891"
   )
   static final void method654(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class93.field1456.length; ++var2) {
         class93.field1456[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class93.field1456[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class228.field3136[var5] = (class93.field1456[var5 + 128] + class93.field1456[var5 - 128] + class93.field1456[var5 + 1] + class93.field1456[var5 - 1]) / 4;
            }
         }

         int[] var8 = class93.field1456;
         class93.field1456 = class228.field3136;
         class228.field3136 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class93.field1456[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IIIILkp;Lhf;I)V",
      garbageValue = "-1990737027"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5101(var10 + var5.field2599 / 2 - var4.maxWidth / 2, var5.field2597 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2599, var5.field2597, var5.field2595, var5.field2596);
            } else {
               var4.method5172(var0 + var10 + var5.field2599 / 2 - var4.maxWidth / 2, var5.field2597 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
