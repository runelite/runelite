import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("i")
   int field1854;
   @ObfuscatedName("f")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("x")
   int field1856;
   @ObfuscatedName("a")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("u")
   CacheableNode field1858 = new CacheableNode();

   @ObfuscatedName("a")
   @Export("reset")
   public void reset() {
      this.list.method2296();
      this.table.method2341();
      this.field1858 = new CacheableNode();
      this.field1854 = this.field1856;
   }

   @ObfuscatedName("x")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2339(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2413();
         ++this.field1854;
      }

   }

   @ObfuscatedName("i")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1854 == 0) {
         CacheableNode var4 = this.list.method2283();
         var4.unlink();
         var4.method2413();
         if(var4 == this.field1858) {
            var4 = this.list.method2283();
            var4.unlink();
            var4.method2413();
         }
      } else {
         --this.field1854;
      }

      this.table.method2340(var1, var2);
      this.list.method2292(var1);
   }

   public NodeCache(int var1) {
      this.field1856 = var1;
      this.field1854 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("u")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2339(var1);
      if(var3 != null) {
         this.list.method2292(var3);
      }

      return var3;
   }
}
