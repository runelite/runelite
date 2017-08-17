import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static class157 field3197;
   @ObfuscatedName("f")
   @Export("padding")
   public byte padding;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1563152283
   )
   @Export("crc")
   public int crc;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;Lgd;I)Lgd;",
      garbageValue = "-267092706"
   )
   static final IterableHashTable method4109(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = IndexFile.method3032(var2);
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
