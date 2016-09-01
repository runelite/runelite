import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class31 extends Renderable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 352283563
   )
   int field697;
   @ObfuscatedName("f")
   boolean field698 = false;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1287122067
   )
   int field699;
   @ObfuscatedName("l")
   Sequence field700;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 931224285
   )
   int field701;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1724653181
   )
   int field702;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -459388847
   )
   int field703 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1209353985
   )
   int field704 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1069134937
   )
   int field705;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1312335471
   )
   int field707;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1350579397"
   )
   final void method660(int var1) {
      if(!this.field698) {
         this.field704 += var1;

         while(this.field704 > this.field700.field999[this.field703]) {
            this.field704 -= this.field700.field999[this.field703];
            ++this.field703;
            if(this.field703 >= this.field700.field1001.length) {
               this.field698 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      class45 var1 = Renderable.method1946(this.field705);
      Model var2;
      if(!this.field698) {
         var2 = var1.method906(this.field703);
      } else {
         var2 = var1.method906(-1);
      }

      return var2 == null?null:var2;
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field705 = var1;
      this.field702 = var2;
      this.field699 = var3;
      this.field701 = var4;
      this.field707 = var5;
      this.field697 = var7 + var6;
      int var8 = Renderable.method1946(this.field705).field1017;
      if(var8 != -1) {
         this.field698 = false;
         this.field700 = class113.getAnimation(var8);
      } else {
         this.field698 = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1657622368"
   )
   public static byte method663(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1737865368"
   )
   public static void method666() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         ++class140.keyboardIdleTicks;
         class140.field2150 = class140.field2164;
         class140.field2174 = 0;
         int var1;
         if(class140.field2170 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class140.field2167[var1] = false;
            }

            class140.field2170 = class140.field2163;
         } else {
            while(class140.field2170 != class140.field2163) {
               var1 = class140.field2168[class140.field2163];
               class140.field2163 = class140.field2163 + 1 & 127;
               if(var1 < 0) {
                  class140.field2167[~var1] = false;
               } else {
                  if(!class140.field2167[var1] && class140.field2174 < class140.field2173.length - 1) {
                     class140.field2173[++class140.field2174 - 1] = var1;
                  }

                  class140.field2167[var1] = true;
               }
            }
         }

         class140.field2164 = class140.field2176;
      }
   }
}
