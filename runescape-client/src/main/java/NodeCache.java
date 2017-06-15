import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("e")
   int field2469;
   @ObfuscatedName("m")
   int field2470;
   @ObfuscatedName("p")
   CacheableNode field2471;
   @ObfuscatedName("t")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("w")
   @Export("list")
   Node2LinkedList list;

   public NodeCache(int var1) {
      this.field2471 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2470 = var1;
      this.field2469 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("m")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3425(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3520();
         ++this.field2469;
      }

   }

   @ObfuscatedName("e")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2469 == 0) {
         CacheableNode var4 = this.list.method3371();
         var4.unlink();
         var4.method3520();
         if(var4 == this.field2471) {
            var4 = this.list.method3371();
            var4.unlink();
            var4.method3520();
         }
      } else {
         --this.field2469;
      }

      this.table.method3426(var1, var2);
      this.list.method3387(var1);
   }

   @ObfuscatedName("t")
   @Export("reset")
   public void reset() {
      this.list.method3383();
      this.table.method3427();
      this.field2471 = new CacheableNode();
      this.field2469 = this.field2470;
   }

   @ObfuscatedName("p")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3425(var1);
      if(var3 != null) {
         this.list.method3387(var3);
      }

      return var3;
   }
}
