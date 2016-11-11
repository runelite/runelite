import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 395215635
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1368099579
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("mm")
   static byte field713;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "90694052"
   )
   static void method653(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class24 var5 = new class24();
      var5.field625 = var0;
      var5.field626 = var1 * 128;
      var5.field627 = var2 * 128;
      int var6 = var3.field959;
      int var7 = var3.field960;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field960;
         var7 = var3.field959;
      }

      var5.field628 = (var1 + var6) * 128;
      var5.field636 = (var2 + var7) * 128;
      var5.field637 = var3.field988;
      var5.field629 = var3.field952 * 128;
      var5.field633 = var3.field990;
      var5.field630 = var3.field991;
      var5.field624 = var3.field943;
      if(var3.impostorIds != null) {
         var5.field638 = var3;
         var5.method566();
      }

      class24.field634.method3865(var5);
      if(null != var5.field624) {
         var5.field631 = var5.field633 + (int)(Math.random() * (double)(var5.field630 - var5.field633));
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1334865548"
   )
   static final void method657(class125 var0) {
      for(int var1 = 0; var1 < class34.field775; ++var1) {
         int var2 = class34.field787[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2544();
         if((var4 & 32) != 0) {
            var4 += var0.method2544() << 8;
         }

         class20.method532(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "1"
   )
   public static ModIcon method658(class170 var0, String var1, String var2) {
      int var3 = var0.method3304(var1);
      int var4 = var0.method3305(var3, var2);
      ModIcon var5;
      if(!class22.method559(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class12.method157();
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2115720168"
   )
   public static void method659() {
      class186.field3013.method3725();
      class186.field3010 = 1;
      class35.field800 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      return class92.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1589609109"
   )
   static int method661(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CS)B",
      garbageValue = "-6452"
   )
   public static byte method662(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
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
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }
}
