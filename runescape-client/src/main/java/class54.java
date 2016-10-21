import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class54 extends CacheableNode {
   @ObfuscatedName("f")
   public static class170 field1142;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2000730565
   )
   public int field1143 = 0;
   @ObfuscatedName("t")
   static byte[][][] field1144;
   @ObfuscatedName("pk")
   public static class139 field1146;
   @ObfuscatedName("qn")
   protected static class136 field1148;
   @ObfuscatedName("e")
   static NodeCache field1149 = new NodeCache(64);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "31"
   )
   void method1088(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1143 = var1.method2535();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1725641732"
   )
   static final void method1092() {
      Region.field1537 = false;
      Client.field286 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1208363017"
   )
   void method1099(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method1088(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   static final void method1100() {
      short var0 = 256;
      int var1;
      if(class33.field734 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field734 > 768) {
               class33.field733[var1] = class216.method4025(class79.field1435[var1], class14.field211[var1], 1024 - class33.field734);
            } else if(class33.field734 > 256) {
               class33.field733[var1] = class14.field211[var1];
            } else {
               class33.field733[var1] = class216.method4025(class14.field211[var1], class79.field1435[var1], 256 - class33.field734);
            }
         }
      } else if(class33.field735 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field735 > 768) {
               class33.field733[var1] = class216.method4025(class79.field1435[var1], class4.field70[var1], 1024 - class33.field735);
            } else if(class33.field735 > 256) {
               class33.field733[var1] = class4.field70[var1];
            } else {
               class33.field733[var1] = class216.method4025(class4.field70[var1], class79.field1435[var1], 256 - class33.field735);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class33.field733[var1] = class79.field1435[var1];
         }
      }

      class82.method1895(class33.field720, 9, class33.field720 + 128, var0 + 7);
      class33.field731.method1761(class33.field720, 0);
      class82.method1839();
      var1 = 0;
      int var2 = XClanMember.bufferProvider.width * 9 + class33.field720;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class33.field737[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class33.field736[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class33.field733[var7];
               var10 = XClanMember.bufferProvider.pixels[var2];
               XClanMember.bufferProvider.pixels[var2++] = (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += XClanMember.bufferProvider.width + var5 - 128;
      }

      class82.method1895(765 + class33.field720 - 128, 9, class33.field720 + 765, 7 + var0);
      class33.field725.method1761(class33.field720 + 382, 0);
      class82.method1839();
      var1 = 0;
      var2 = class33.field720 + 24 + XClanMember.bufferProvider.width * 9 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class33.field737[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class33.field736[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class33.field733[var7];
               var10 = XClanMember.bufferProvider.pixels[var2];
               XClanMember.bufferProvider.pixels[var2++] = ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) + (var8 * (var7 & 16711935) + var9 * (var10 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += XClanMember.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "57"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field991.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class33.method704(Sequence.field988, Sequence.field989, var0, false);
         if(var1 != null) {
            Sequence.field991.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
