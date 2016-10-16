import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class54 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1140705037
   )
   public int field1127 = 0;
   @ObfuscatedName("z")
   static NodeCache field1128 = new NodeCache(64);
   @ObfuscatedName("ap")
   static class149 field1129;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -832829371
   )
   static int field1132;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1275925005
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("s")
   static class170 field1136;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 291601795
   )
   static int field1138;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "-29"
   )
   static String method1063(Buffer var0, int var1) {
      try {
         int var2 = var0.method2654();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class225.field3230.method2415(var0.payload, var0.offset, var3, 0, var2);
         String var4 = TextureProvider.method2163(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "2"
   )
   void method1064(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1127 = var1.method2668();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1793108678"
   )
   public static void method1067() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         ++class140.keyboardIdleTicks;
         class140.field2165 = class140.field2167;
         class140.field2164 = 0;
         int var1;
         if(class140.field2150 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class140.field2157[var1] = false;
            }

            class140.field2150 = class140.field2159;
         } else {
            while(class140.field2159 != class140.field2150) {
               var1 = class140.field2158[class140.field2159];
               class140.field2159 = class140.field2159 + 1 & 127;
               if(var1 < 0) {
                  class140.field2157[~var1] = false;
               } else {
                  if(!class140.field2157[var1] && class140.field2164 < class140.field2168.length - 1) {
                     class140.field2168[++class140.field2164 - 1] = var1;
                  }

                  class140.field2157[var1] = true;
               }
            }
         }

         class140.field2167 = class140.field2166;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-61"
   )
   void method1074(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method1064(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-735079689"
   )
   public static int method1075(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
