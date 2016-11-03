import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class13 implements Runnable {
   @ObfuscatedName("k")
   boolean field189 = true;
   @ObfuscatedName("q")
   Object field190 = new Object();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -859289177
   )
   int field191 = 0;
   @ObfuscatedName("c")
   int[] field192 = new int[500];
   @ObfuscatedName("v")
   int[] field193 = new int[500];
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 963096097
   )
   static int field194;
   @ObfuscatedName("bl")
   static class171 field195;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 289148801
   )
   static int field196;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1850105503
   )
   public static int field197;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -1429029335
   )
   protected static int field198;
   @ObfuscatedName("m")
   static byte[][][] field199;
   @ObfuscatedName("ab")
   static class171 field200;
   @ObfuscatedName("ke")
   static class134 field201;

   public void run() {
      for(; this.field189; class127.method2846(50L)) {
         Object var1 = this.field190;
         synchronized(this.field190) {
            if(this.field191 < 500) {
               this.field192[this.field191] = class143.field2200;
               this.field193[this.field191] = class143.field2204;
               ++this.field191;
            }
         }
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1808256446"
   )
   static void method149(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2838 == 0) {
         var0.width = var0.field2798;
      } else if(var0.field2838 == 1) {
         var0.width = var1 - var0.field2798;
      } else if(var0.field2838 == 2) {
         var0.width = var0.field2798 * var1 >> 14;
      }

      if(var0.field2893 == 0) {
         var0.height = var0.field2854;
      } else if(var0.field2893 == 1) {
         var0.height = var2 - var0.field2854;
      } else if(var0.field2893 == 2) {
         var0.height = var0.field2854 * var2 >> 14;
      }

      if(var0.field2838 == 4) {
         var0.width = var0.field2882 * var0.height / var0.field2872;
      }

      if(var0.field2893 == 4) {
         var0.height = var0.field2872 * var0.width / var0.field2882;
      }

      if(Client.field316 && var0.type == 0) {
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
         Client.field452 = var0;
      }

      if(var3 && var0.field2787 != null && (var4 != var0.width || var0.height != var5)) {
         class0 var6 = new class0();
         var6.field11 = var0;
         var6.field0 = var0.field2787;
         Client.field532.method3844(var6);
      }

   }
}
