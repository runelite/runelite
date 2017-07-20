import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1047946689
   )
   public static int field1524;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1807384723
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbv;",
      garbageValue = "2009429665"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "47843630"
   )
   MessageNode method1803(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1794682367"
   )
   int method1796() {
      return this.length;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-115"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class10.plane][var0][var1];
      if(var2 == null) {
         class19.region.method2754(class10.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class10.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class19.region.method2754(class10.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class19.region.addItemPile(class10.plane, var0, var1, class23.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class10.plane), var5, var9, var11, var10);
         }
      }
   }
}
