import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("g")
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("i")
   CacheableNode field2454;
   @ObfuscatedName("u")
   int field2455;
   @ObfuscatedName("h")
   int field2456;
   @ObfuscatedName("q")
   @Export("table")
   XHashTable table;

   @ObfuscatedName("h")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3615(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3687();
         ++this.field2455;
      }

   }

   @ObfuscatedName("i")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3615(var1);
      if(var3 != null) {
         this.list.method3539(var3);
      }

      return var3;
   }

   @ObfuscatedName("q")
   @Export("reset")
   public void reset() {
      this.list.method3543();
      this.table.method3605();
      this.field2454 = new CacheableNode();
      this.field2455 = this.field2456;
   }

   @ObfuscatedName("u")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2455 == 0) {
         CacheableNode var4 = this.list.method3541();
         var4.unlink();
         var4.method3687();
         if(var4 == this.field2454) {
            var4 = this.list.method3541();
            var4.unlink();
            var4.method3687();
         }
      } else {
         --this.field2455;
      }

      this.table.method3617(var1, var2);
      this.list.method3539(var1);
   }

   public NodeCache(int var1) {
      this.field2454 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2456 = var1;
      this.field2455 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
