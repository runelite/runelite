import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3276;
   @ObfuscatedName("nx")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1626334629
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "0"
   )
   void method4344(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-2081374581"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4344(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)Ljo;",
      garbageValue = "-271401086"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class261.method4822(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class175.method3460();
      }

      return var5;
   }
}
