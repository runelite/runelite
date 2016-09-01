import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 510465421
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -308591445
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("cq")
   static class146 field694;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-2085364034"
   )
   public static ModIcon method650(class170 var0, String var1, String var2) {
      int var3 = var0.method3359(var1);
      int var4 = var0.method3305(var3, var2);
      ModIcon var5;
      if(!NPCComposition.method775(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class79.field1422;
         var7.originalHeight = class79.field1419;
         var7.offsetX = class79.field1421[0];
         var7.offsetY = class79.field1423[0];
         var7.originalWidth = class20.field567[0];
         var7.height = class79.field1424[0];
         var7.palette = class79.field1425;
         var7.pixels = class13.field191[0];
         Friend.method193();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      return MessageNode.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Lclass50;",
      garbageValue = "44"
   )
   public static class50 method654(int var0) {
      class50 var1 = (class50)class50.field1089.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class50.field1091.method3290(14, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1017(new Buffer(var2));
         }

         class50.field1089.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass171;II)V",
      garbageValue = "-1415988544"
   )
   static void method655(class171 var0, int var1) {
      if(null != class28.field677) {
         class28.field677.offset = 8 * var1 + 5;
         int var2 = class28.field677.method2561();
         int var3 = class28.field677.method2561();
         var0.method3366(var2, var3);
      } else {
         DecorativeObject.method2221((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2781[var1] = var0;
      }
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "240410791"
   )
   static String method656(Widget var0) {
      return class77.method1637(class132.method2880(var0)) == 0?null:(null != var0.field2889 && var0.field2889.trim().length() != 0?var0.field2889:null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "48"
   )
   static void method657(Sequence var0, int var1, int var2, int var3) {
      if(Client.field521 < 50 && Client.field520 != 0) {
         if(var0.field1000 != null && var1 < var0.field1000.length) {
            int var4 = var0.field1000[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field325[Client.field521] = var5;
               Client.field523[Client.field521] = var6;
               Client.field286[Client.field521] = 0;
               Client.field526[Client.field521] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field434[Client.field521] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field521;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2050087431"
   )
   public static void method658() {
      while(true) {
         Deque var1 = class173.field2769;
         class172 var0;
         synchronized(class173.field2769) {
            var0 = (class172)class173.field2768.method3848();
         }

         if(var0 == null) {
            return;
         }

         var0.field2765.method3368(var0.field2762, (int)var0.hash, var0.field2763, false);
      }
   }
}
