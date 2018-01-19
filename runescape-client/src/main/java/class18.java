import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class18 implements Comparator {
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;B)I",
      garbageValue = "-71"
   )
   int method128(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method83().compareTo(var2.method83());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method128((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;Lgb;I)Lgb;",
      garbageValue = "-1697261002"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class234.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static final void method129(int var0) {
      if(FontName.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2884 = 0;
               var3.field2885 = 0;
            }
         }

      }
   }
}
