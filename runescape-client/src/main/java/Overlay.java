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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gi")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("q")
   public static class182 field3038;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 993273207
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("j")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("d")
   public static NodeCache field3041 = new NodeCache(64);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1634319747
   )
   public int field3043 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1314677823
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1037871505
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1972893147
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 707825185
   )
   public int field3047;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1630000375
   )
   public int field3048;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1451555751
   )
   public int field3049;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1795549627
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -1543893137
   )
   static int field3051;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-494478091"
   )
   public void method3753() {
      if(this.field3043 != -1) {
         this.method3759(this.field3043);
         this.field3047 = this.hue;
         this.field3048 = this.saturation;
         this.field3049 = this.lightness;
      }

      this.method3759(this.color);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-961773490"
   )
   public void method3754(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3755(var1, var3, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-1439563978"
   )
   void method3755(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3043 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1701358438"
   )
   void method3759(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1324220557"
   )
   public static void method3774(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3245.method2420();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2821(var1.field3237);

         for(int var3 = 0; var3 < var1.field3242; ++var3) {
            if(var1.field3238[var3] != 0) {
               var0.method2918(var1.field3238[var3]);
            } else {
               try {
                  int var4 = var1.field3235[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method2918(0);
                     var0.method2821(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3240[var3]);
                     var0.method2918(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2918(0);
                     var0.method2821(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2918(0);
                        var0.method2821(var6);
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
                        var0.method2918(0);
                     } else if(var11 instanceof Number) {
                        var0.method2918(1);
                        var0.method2993(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2918(2);
                        var0.method2824((String)var11);
                     } else {
                        var0.method2918(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2918(-10);
               } catch (InvalidClassException var14) {
                  var0.method2918(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2918(-12);
               } catch (OptionalDataException var16) {
                  var0.method2918(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2918(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2918(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2918(-16);
               } catch (SecurityException var20) {
                  var0.method2918(-17);
               } catch (IOException var21) {
                  var0.method2918(-18);
               } catch (NullPointerException var22) {
                  var0.method2918(-19);
               } catch (Exception var23) {
                  var0.method2918(-20);
               } catch (Throwable var24) {
                  var0.method2918(-21);
               }
            }
         }

         var0.method2854(var2);
         var1.unlink();
      }
   }
}
