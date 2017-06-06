import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("c")
   int field2467;
   @ObfuscatedName("e")
   int field2468;
   @ObfuscatedName("i")
   CacheableNode field2469;
   @ObfuscatedName("v")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("b")
   @Export("list")
   Node2LinkedList list;

   @ObfuscatedName("i")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3520(var1);
      if(var3 != null) {
         this.list.method3472(var3);
      }

      return var3;
   }

   @ObfuscatedName("v")
   @Export("reset")
   public void reset() {
      this.list.method3465();
      this.table.method3517();
      this.field2469 = new CacheableNode();
      this.field2468 = this.field2467;
   }

   @ObfuscatedName("e")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2468 == 0) {
         CacheableNode var4 = this.list.method3463();
         var4.unlink();
         var4.method3600();
         if(var4 == this.field2469) {
            var4 = this.list.method3463();
            var4.unlink();
            var4.method3600();
         }
      } else {
         --this.field2468;
      }

      this.table.method3516(var1, var2);
      this.list.method3472(var1);
   }

   @ObfuscatedName("c")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3520(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3600();
         ++this.field2468;
      }

   }

   public NodeCache(int var1) {
      this.field2469 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2467 = var1;
      this.field2468 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
