import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("b")
   CacheableNode field1864 = new CacheableNode();
   @ObfuscatedName("l")
   int field1865;
   @ObfuscatedName("i")
   int field1866;
   @ObfuscatedName("t")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("k")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("b")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2428(var1);
      if(var3 != null) {
         this.list.method2367(var3);
      }

      return var3;
   }

   @ObfuscatedName("t")
   @Export("reset")
   public void reset() {
      this.list.method2379();
      this.table.method2422();
      this.field1864 = new CacheableNode();
      this.field1866 = this.field1865;
   }

   @ObfuscatedName("i")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1866 == 0) {
         CacheableNode var4 = this.list.method2366();
         var4.unlink();
         var4.method2497();
         if(var4 == this.field1864) {
            var4 = this.list.method2366();
            var4.unlink();
            var4.method2497();
         }
      } else {
         --this.field1866;
      }

      this.table.method2425(var1, var2);
      this.list.method2367(var1);
   }

   @ObfuscatedName("l")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2428(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2497();
         ++this.field1866;
      }

   }

   public NodeCache(int var1) {
      this.field1865 = var1;
      this.field1866 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
