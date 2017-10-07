import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("e")
   int field2474;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   CacheableNode field2475;
   @ObfuscatedName("k")
   int field2472;

   public NodeCache(int var1) {
      this.field2475 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2472 = var1;
      this.field2474 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgg;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2474 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2475) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2474;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("p")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3645();
      this.field2475 = new CacheableNode();
      this.field2474 = this.field2472;
   }

   @ObfuscatedName("k")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2474;
      }

   }
}
