import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class141 extends class133 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 13388231
   )
   int field2185 = 1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -889026109
   )
   int field2186 = 256;
   @ObfuscatedName("ec")
   static class80[] field2187;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1137835699
   )
   int field2189 = 0;
   @ObfuscatedName("w")
   long[] field2190 = new long[10];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 475493165
   )
   int field2192;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3230432275715411793L
   )
   long field2193 = class14.method165();

   @ObfuscatedName("w")
   public void vmethod3139() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2190[var1] = 0L;
      }

   }

   @ObfuscatedName("x")
   int vmethod3132(int var1, int var2) {
      int var3 = this.field2186;
      int var4 = this.field2185;
      this.field2186 = 300;
      this.field2185 = 1;
      this.field2193 = class14.method165();
      if(this.field2190[this.field2192] == 0L) {
         this.field2186 = var3;
         this.field2185 = var4;
      } else if(this.field2193 > this.field2190[this.field2192]) {
         this.field2186 = (int)((long)(2560 * var1) / (this.field2193 - this.field2190[this.field2192]));
      }

      if(this.field2186 < 25) {
         this.field2186 = 25;
      }

      if(this.field2186 > 256) {
         this.field2186 = 256;
         this.field2185 = (int)((long)var1 - (this.field2193 - this.field2190[this.field2192]) / 10L);
      }

      if(this.field2185 > var1) {
         this.field2185 = var1;
      }

      this.field2190[this.field2192] = this.field2193;
      this.field2192 = (this.field2192 + 1) % 10;
      int var5;
      if(this.field2185 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2190[var5] != 0L) {
               this.field2190[var5] += (long)this.field2185;
            }
         }
      }

      if(this.field2185 < var2) {
         this.field2185 = var2;
      }

      class104.method2291((long)this.field2185);

      for(var5 = 0; this.field2189 < 256; this.field2189 += this.field2186) {
         ++var5;
      }

      this.field2189 &= 255;
      return var5;
   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2190[var1] = this.field2193;
      }

   }

   @ObfuscatedName("x")
   public static int method2991(CharSequence var0) {
      return class156.method3194(var0, 10);
   }

   @ObfuscatedName("w")
   public static class48 method2992(int var0) {
      class48 var1 = (class48)class48.field1088.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class48.field1087.method3335(8, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method1034(new class119(var2));
         }

         class48.field1088.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "0"
   )
   public static final class56 method2993(class136 var0, int var1, int var2) {
      if(0 == class129.field2058) {
         throw new IllegalStateException();
      } else {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class69 var6 = new class69();
            var6.field1193 = new int[256 * (class56.field1194?2:1)];
            var6.field1202 = var2;
            var6.vmethod1510();
            var6.field1198 = (var2 & -1024) + 1024;
            if(var6.field1198 > 16384) {
               var6.field1198 = 16384;
            }

            var6.vmethod1517(var6.field1198);
            if(class50.field1111 > 0 && null == class56.field1182) {
               class56.field1182 = new class72();
               class56.field1182.field1356 = var0;
               var0.method2889(class56.field1182, class50.field1111);
            }

            if(class56.field1182 != null) {
               if(null != class56.field1182.field1354[var1]) {
                  throw new IllegalArgumentException();
               }

               class56.field1182.field1354[var1] = var6;
            }

            return var6;
         } catch (Throwable var5) {
            try {
               class54 var3 = new class54(var0, var1);
               var3.field1193 = new int[(class56.field1194?2:1) * 256];
               var3.field1202 = var2;
               var3.vmethod1510();
               var3.field1198 = 16384;
               var3.vmethod1517(var3.field1198);
               if(class50.field1111 > 0 && class56.field1182 == null) {
                  class56.field1182 = new class72();
                  class56.field1182.field1356 = var0;
                  var0.method2889(class56.field1182, class50.field1111);
               }

               if(null != class56.field1182) {
                  if(class56.field1182.field1354[var1] != null) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1182.field1354[var1] = var3;
               }

               return var3;
            } catch (Throwable var4) {
               return new class56();
            }
         }
      }
   }
}
