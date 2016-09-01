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

@ObfuscatedName("al")
public class class49 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -844067461
   )
   int field1071 = -1;
   @ObfuscatedName("r")
   static class170 field1072;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 660897389
   )
   public int field1073 = -1;
   @ObfuscatedName("z")
   static NodeCache field1074 = new NodeCache(64);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1263798667
   )
   public int field1075;
   @ObfuscatedName("j")
   static NodeCache field1076 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1702040395
   )
   public int field1077 = 255;
   @ObfuscatedName("x")
   static class170 field1078;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -367335957
   )
   public int field1079 = 1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 84086287
   )
   public int field1080 = 70;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 254150783
   )
   public int field1081 = 255;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 191820097
   )
   int field1082 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1688595219
   )
   public int field1083 = 30;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 232129143
   )
   public int field1084 = 0;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-560289167"
   )
   public SpritePixels method995() {
      if(this.field1082 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1074.get((long)this.field1082);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class43.method856(field1072, this.field1082, 0);
            if(var1 != null) {
               field1074.put(var1, (long)this.field1082);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1675721976"
   )
   void method996(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1008(var1, var2);
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "224183714"
   )
   static final void method1001(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field413.method3850(); var10 != null; var10 = (class16)Client.field413.method3852()) {
         if(var0 == var10.field243 && var1 == var10.field244 && var2 == var10.field235 && var10.field231 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field243 = var0;
         var9.field231 = var3;
         var9.field244 = var1;
         var9.field235 = var2;
         Actor.method759(var9);
         Client.field413.method3844(var9);
      }

      var9.field233 = var4;
      var9.field239 = var5;
      var9.field238 = var6;
      var9.field240 = var7;
      var9.field241 = var8;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1404216336"
   )
   void method1008(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2551();
      } else if(var2 == 2) {
         this.field1081 = var1.method2556();
      } else if(var2 == 3) {
         this.field1077 = var1.method2556();
      } else if(var2 == 4) {
         this.field1073 = 0;
      } else if(var2 == 5) {
         this.field1080 = var1.method2551();
      } else if(var2 == 6) {
         var1.method2556();
      } else if(var2 == 7) {
         this.field1071 = var1.method2571();
      } else if(var2 == 8) {
         this.field1082 = var1.method2571();
      } else if(var2 == 11) {
         this.field1073 = var1.method2551();
      } else if(var2 == 14) {
         this.field1083 = var1.method2556();
      } else if(var2 == 15) {
         this.field1084 = var1.method2556();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-213701829"
   )
   public SpritePixels method1010() {
      if(this.field1071 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1074.get((long)this.field1071);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class43.method856(field1072, this.field1071, 0);
            if(null != var1) {
               field1074.put(var1, (long)this.field1071);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1464022432"
   )
   public static void method1011(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3187.method3897();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2544(var1.field3184);

         for(int var3 = 0; var3 < var1.field3182; ++var3) {
            if(var1.field3179[var3] != 0) {
               var0.method2715(var1.field3179[var3]);
            } else {
               try {
                  int var4 = var1.field3177[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2715(0);
                     var0.method2544(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3181[var3]);
                     var0.method2715(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2715(0);
                     var0.method2544(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2715(0);
                        var0.method2544(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(null == var11) {
                        var0.method2715(0);
                     } else if(var11 instanceof Number) {
                        var0.method2715(1);
                        var0.method2546(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2715(2);
                        var0.method2616((String)var11);
                     } else {
                        var0.method2715(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2715(-10);
               } catch (InvalidClassException var14) {
                  var0.method2715(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2715(-12);
               } catch (OptionalDataException var16) {
                  var0.method2715(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2715(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2715(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2715(-16);
               } catch (SecurityException var20) {
                  var0.method2715(-17);
               } catch (IOException var21) {
                  var0.method2715(-18);
               } catch (NullPointerException var22) {
                  var0.method2715(-19);
               } catch (Exception var23) {
                  var0.method2715(-20);
               } catch (Throwable var24) {
                  var0.method2715(-21);
               }
            }
         }

         var0.method2578(var2);
         var1.unlink();
      }
   }
}
