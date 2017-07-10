import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("im")
public enum class239 implements RSEnum {
   @ObfuscatedName("i")
   field3283(1, 0),
   @ObfuscatedName("w")
   field3280(0, 1),
   @ObfuscatedName("a")
   field3279(2, 2);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1115212523
   )
   final int field3281;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 683549763
   )
   public final int field3282;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3281;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "808405277"
   )
   static long method4263() {
      try {
         URL var0 = new URL(WorldMapType1.method263("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "306404671"
   )
   public static void method4268(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3748 = var0.readUnsignedByte();
      var2.field3750 = var0.readInt();
      var2.field3749 = new int[var2.field3748];
      var2.field3752 = new int[var2.field3748];
      var2.fields = new Field[var2.field3748];
      var2.field3754 = new int[var2.field3748];
      var2.methods = new Method[var2.field3748];
      var2.args = new byte[var2.field3748][][];

      for(int var3 = 0; var3 < var2.field3748; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.readString();
                  var6 = var0.readString();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readString();
                  }

                  String var20 = var0.readString();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.readBytes(var10[var11], 0, var12);
                     }
                  }

                  var2.field3749[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class230.method4095(var8[var12]);
                  }

                  Class var22 = class230.method4095(var20);
                  if(class230.method4095(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class230.method4095(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.readString();
               var6 = var0.readString();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.field3749[var3] = var4;
               var2.field3754[var3] = var7;
               if(class230.method4095(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class230.method4095(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3752[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3752[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3752[var3] = -3;
         } catch (Exception var27) {
            var2.field3752[var3] = -4;
         } catch (Throwable var28) {
            var2.field3752[var3] = -5;
         }
      }

      class280.field3755.method3543(var2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class239(int var3, int var4) {
      this.field3282 = var3;
      this.field3281 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   static final void method4269() {
      short var0 = 256;
      int var1;
      if(class92.field1457 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1457 > 768) {
               WorldMapType3.field375[var1] = class175.method3348(class41.field586[var1], class244.field3326[var1], 1024 - class92.field1457);
            } else if(class92.field1457 > 256) {
               WorldMapType3.field375[var1] = class244.field3326[var1];
            } else {
               WorldMapType3.field375[var1] = class175.method3348(class244.field3326[var1], class41.field586[var1], 256 - class92.field1457);
            }
         }
      } else if(class92.field1458 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1458 > 768) {
               WorldMapType3.field375[var1] = class175.method3348(class41.field586[var1], class83.field1370[var1], 1024 - class92.field1458);
            } else if(class92.field1458 > 256) {
               WorldMapType3.field375[var1] = class83.field1370[var1];
            } else {
               WorldMapType3.field375[var1] = class175.method3348(class83.field1370[var1], class41.field586[var1], 256 - class92.field1458);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            WorldMapType3.field375[var1] = class41.field586[var1];
         }
      }

      Rasterizer2D.method4999(class92.field1470, 9, class92.field1470 + 128, var0 + 7);
      class92.field1451.method5074(class92.field1470, 0);
      Rasterizer2D.method4923();
      var1 = 0;
      int var2 = class43.field602.width * 9 + class92.field1470;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class92.field1459[var3] / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class12.field270[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = WorldMapType3.field375[var7];
               var10 = class43.field602.pixels[var2];
               class43.field602.pixels[var2++] = (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class43.field602.width - 128;
      }

      Rasterizer2D.method4999(class92.field1470 + 765 - 128, 9, class92.field1470 + 765, var0 + 7);
      class3.field19.method5074(class92.field1470 + 382, 0);
      Rasterizer2D.method4923();
      var1 = 0;
      var2 = class43.field602.width * 9 + 24 + 637 + class92.field1470;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class92.field1459[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class12.field270[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = WorldMapType3.field375[var7];
               var10 = class43.field602.pixels[var2];
               class43.field602.pixels[var2++] = (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class43.field602.width - var5 - var4;
      }

   }
}
