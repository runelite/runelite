import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   static IndexFile field2125;
   @ObfuscatedName("dq")
   @Export("host")
   static String host;
   @ObfuscatedName("m")
   long[] field2123;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1790996925
   )
   int field2124;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1165597693
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 2804597818258558931L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1791229027
   )
   int field2127;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 111599639
   )
   int field2128;

   public MilliTimer() {
      this.field2123 = new long[10];
      this.field2124 = 256;
      this.sleepTime = 1;
      this.field2127 = 0;
      this.milliTime = class268.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2123[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   public void vmethod3096() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2123[var1] = 0L;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-553632509"
   )
   public int vmethod3095(int var1, int var2) {
      int var3 = this.field2124;
      int var4 = this.sleepTime;
      this.field2124 = 300;
      this.sleepTime = 1;
      this.milliTime = class268.currentTimeMs();
      if(0L == this.field2123[this.field2128]) {
         this.field2124 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2123[this.field2128]) {
         this.field2124 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2123[this.field2128]));
      }

      if(this.field2124 < 25) {
         this.field2124 = 25;
      }

      if(this.field2124 > 256) {
         this.field2124 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2123[this.field2128]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2123[this.field2128] = this.milliTime;
      this.field2128 = (this.field2128 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2123[var5]) {
               this.field2123[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class61.method1130((long)this.sleepTime);

      for(var5 = 0; this.field2127 < 256; this.field2127 += this.field2124) {
         ++var5;
      }

      this.field2127 &= 255;
      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2132736204"
   )
   public static int method3043(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-25"
   )
   static char method3036(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lhk;IIZI)V",
      garbageValue = "1114662171"
   )
   static void method3042(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2834 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2834 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2834 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2738;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2738;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2738 >> 14;
      }

      if(var0.field2834 == 4) {
         var0.width = var0.height * var0.field2802 / var0.field2744;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2744 * var0.width / var0.field2802;
      }

      if(Client.field1081 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field923 = var0;
      }

      if(var3 && var0.field2835 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field791 = var0.field2835;
         Client.field1048.addFront(var6);
      }

   }
}
