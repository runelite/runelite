import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class134 {
   @ObfuscatedName("c")
   public static boolean field1957;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1772774401
   )
   public static int field1953;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -726767917
   )
   public static int field1948;
   @ObfuscatedName("u")
   public static boolean field1951;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1279648285
   )
   public static int field1954;
   @ObfuscatedName("t")
   public static int[] field1955;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 332248537
   )
   static int field1952;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 298386455
   )
   static int field1950;
   @ObfuscatedName("x")
   static byte[][][] field1949;

   static {
      field1957 = false;
      field1953 = 0;
      field1948 = 0;
      field1951 = false;
      field1954 = 0;
      field1955 = new int[1000];
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(Lho;IIZB)V",
      garbageValue = "3"
   )
   static void method2520(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2624 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2624 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2624 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2629;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2629;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2629 >> 14;
      }

      if(var0.field2624 == 4) {
         var0.width = var0.height * var0.field2634 / var0.field2749;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2749 / var0.field2634;
      }

      if(Client.field1074 && var0.type == 0) {
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
         Client.field977 = var0;
      }

      if(var3 && var0.field2672 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field831 = var0.field2672;
         Client.field1103.addFront(var6);
      }

   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(Lho;III)V",
      garbageValue = "-887447286"
   )
   static void method2521(Widget var0, int var1, int var2) {
      if(var0.field2714 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2714 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2714 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2714 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2714 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2623 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2623 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2623 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2623 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2623 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1074 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lfm;",
      garbageValue = "657474099"
   )
   public static Timer method2507() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILip;IIIZI)V",
      garbageValue = "-1469777312"
   )
   public static void method2519(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2471 = 1;
      class222.field2815 = var1;
      class203.field2468 = var2;
      class203.field2473 = var3;
      WorldMapType2.field513 = var4;
      class203.field2474 = var5;
      ChatLineBuffer.field1524 = var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2039216149"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
