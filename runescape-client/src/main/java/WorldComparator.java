import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -336544671
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static JagexGame field261;
   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   static TextureProvider field259;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -424778965
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ln;Ln;I)I",
      garbageValue = "1139276061"
   )
   int method75(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method75((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1410063367"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILjv;II)V",
      garbageValue = "754875677"
   )
   static void method83(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class79 var5 = new class79();
      var5.field1201 = var0;
      var5.field1210 = var1 * 128;
      var5.field1205 = var2 * 128;
      int var6 = var3.width;
      int var7 = var3.length;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.length;
         var7 = var3.width;
      }

      var5.field1202 = (var6 + var1) * 128;
      var5.field1206 = (var7 + var2) * 128;
      var5.field1207 = var3.ambientSoundId;
      var5.field1204 = var3.int4 * 128;
      var5.field1203 = var3.int5;
      var5.field1211 = var3.int6;
      var5.field1212 = var3.field3543;
      if(var3.impostorIds != null) {
         var5.field1215 = var3;
         var5.method1741();
      }

      class79.field1208.addFront(var5);
      if(var5.field1212 != null) {
         var5.field1213 = var5.field1203 + (int)(Math.random() * (double)(var5.field1211 - var5.field1203));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "7"
   )
   static final int method84(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
   }
}
