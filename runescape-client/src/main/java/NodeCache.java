import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("w")
   int field2460;
   @ObfuscatedName("i")
   CacheableNode field2461;
   @ObfuscatedName("a")
   int field2462;
   @ObfuscatedName("t")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("s")
   @Export("list")
   Node2LinkedList list;

   @ObfuscatedName("t")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3532();
      this.field2461 = new CacheableNode();
      this.field2462 = this.field2460;
   }

   @ObfuscatedName("w")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2462;
      }

   }

   @ObfuscatedName("a")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2462 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(this.field2461 == var4) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2462;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   public NodeCache(int var1) {
      this.field2461 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2460 = var1;
      this.field2462 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("i")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }
}
