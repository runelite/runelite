import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("n")
   int field2454;
   @ObfuscatedName("r")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("v")
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("a")
   CacheableNode field2455;
   @ObfuscatedName("j")
   int field2453;

   public NodeCache(int var1) {
      this.field2455 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2453 = var1;
      this.field2454 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("a")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("n")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2454 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2455) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2454;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("r")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3537();
      this.field2455 = new CacheableNode();
      this.field2454 = this.field2453;
   }

   @ObfuscatedName("j")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2454;
      }

   }
}
