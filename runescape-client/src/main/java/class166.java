import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class166 {
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1604638969
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("gk")
   static SpritePixels field2304;
   @ObfuscatedName("i")
   Inflater field2305;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class166(int var1, int var2, int var3) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "2119241598"
   )
   public void method3127(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2305 == null) {
            this.field2305 = new Inflater(true);
         }

         try {
            this.field2305.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2305.inflate(var2);
         } catch (Exception var4) {
            this.field2305.reset();
            throw new RuntimeException("");
         }

         this.field2305.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2126233490"
   )
   static void method3129(int var0) {
      for(class198 var1 = (class198)Client.widgetFlags.method3606(); var1 != null; var1 = (class198)Client.widgetFlags.method3607()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "26"
   )
   static void method3131(int var0, int var1, int var2, int var3) {
      for(class82 var4 = (class82)class82.field1299.method3660(); var4 != null; var4 = (class82)class82.field1299.method3661()) {
         if(var4.field1297 != -1 || var4.field1301 != null) {
            int var5 = 0;
            if(var1 > var4.field1304) {
               var5 += var1 - var4.field1304;
            } else if(var1 < var4.field1305) {
               var5 += var4.field1305 - var1;
            }

            if(var2 > var4.field1295) {
               var5 += var2 - var4.field1295;
            } else if(var2 < var4.field1300) {
               var5 += var4.field1300 - var2;
            }

            if(var5 - 64 <= var4.field1296 && Client.field1130 != 0 && var4.field1291 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1296 - var5) * Client.field1130 / var4.field1296;
               if(var4.field1298 == null) {
                  if(var4.field1297 >= 0) {
                     SoundEffect var7 = SoundEffect.method1970(class43.field559, var4.field1297, 0);
                     if(var7 != null) {
                        class107 var8 = var7.method1966().method2017(class154.field2216);
                        class117 var9 = class117.method2249(var8, 100, var6);
                        var9.method2160(-1);
                        class164.field2291.method1936(var9);
                        var4.field1298 = var9;
                     }
                  }
               } else {
                  var4.field1298.method2248(var6);
               }

               if(var4.field1303 == null) {
                  if(var4.field1301 != null && (var4.field1293 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1301.length);
                     SoundEffect var12 = SoundEffect.method1970(class43.field559, var4.field1301[var11], 0);
                     if(var12 != null) {
                        class107 var13 = var12.method1966().method2017(class154.field2216);
                        class117 var10 = class117.method2249(var13, 100, var6);
                        var10.method2160(0);
                        class164.field2291.method1936(var10);
                        var4.field1303 = var10;
                        var4.field1293 = var4.field1292 + (int)(Math.random() * (double)(var4.field1290 - var4.field1292));
                     }
                  }
               } else {
                  var4.field1303.method2248(var6);
                  if(!var4.field1303.linked()) {
                     var4.field1303 = null;
                  }
               }
            } else {
               if(var4.field1298 != null) {
                  class164.field2291.method1910(var4.field1298);
                  var4.field1298 = null;
               }

               if(var4.field1303 != null) {
                  class164.field2291.method1910(var4.field1303);
                  var4.field1303 = null;
               }
            }
         }
      }

   }

   public class166() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   public static void method3132() {
      if(class59.mouse != null) {
         class59 var0 = class59.mouse;
         synchronized(class59.mouse) {
            class59.mouse = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-25"
   )
   static int method3133(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
