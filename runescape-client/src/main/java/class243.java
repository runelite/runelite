import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class243 extends CacheableNode {
   @ObfuscatedName("w")
   public static NodeCache field3317;
   @ObfuscatedName("i")
   public static IndexDataBase field3319;
   @ObfuscatedName("a")
   public boolean field3318;

   static {
      field3317 = new NodeCache(64);
   }

   public class243() {
      this.field3318 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "16"
   )
   void method4318(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3318 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1146509481"
   )
   public void method4315(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4318(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1637927214"
   )
   @Export("resetItemTable")
   static void resetItemTable(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }
}
