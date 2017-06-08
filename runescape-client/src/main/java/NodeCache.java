import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("n")
   CacheableNode field2469;
   @ObfuscatedName("p")
   int field2470;
   @ObfuscatedName("i")
   int field2471;
   @ObfuscatedName("j")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("f")
   @Export("list")
   Node2LinkedList list;

   @ObfuscatedName("p")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3545(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3641();
         ++this.field2471;
      }

   }

   @ObfuscatedName("n")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3545(var1);
      if(var3 != null) {
         this.list.method3472(var3);
      }

      return var3;
   }

   @ObfuscatedName("i")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2471 == 0) {
         CacheableNode var4 = this.list.method3476();
         var4.unlink();
         var4.method3641();
         if(var4 == this.field2469) {
            var4 = this.list.method3476();
            var4.unlink();
            var4.method3641();
         }
      } else {
         --this.field2471;
      }

      this.table.method3546(var1, var2);
      this.list.method3472(var1);
   }

   @ObfuscatedName("j")
   @Export("reset")
   public void reset() {
      this.list.method3490();
      this.table.method3563();
      this.field2469 = new CacheableNode();
      this.field2471 = this.field2470;
   }

   public NodeCache(int var1) {
      this.field2469 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2470 = var1;
      this.field2471 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
