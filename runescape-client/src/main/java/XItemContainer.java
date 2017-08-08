import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("itemContainers")
   static XHashTable itemContainers;
   @ObfuscatedName("n")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("g")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;Lgw;B)Lgw;",
      garbageValue = "1"
   )
   static final IterableHashTable method1083(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class14.method81(var2);
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
}
