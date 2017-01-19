import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dq")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("c")
   int field1874;
   @ObfuscatedName("h")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("f")
   int field1876;
   @ObfuscatedName("s")
   CacheableNode field1877 = new CacheableNode();
   @ObfuscatedName("a")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("c")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2274(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2361();
         ++this.field1876;
      }

   }

   @ObfuscatedName("s")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2274(var1);
      if(var3 != null) {
         this.list.method2226(var3);
      }

      return var3;
   }

   @ObfuscatedName("f")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1876 == 0) {
         CacheableNode var4 = this.list.method2228();
         var4.unlink();
         var4.method2361();
         if(var4 == this.field1877) {
            var4 = this.list.method2228();
            var4.unlink();
            var4.method2361();
         }
      } else {
         --this.field1876;
      }

      this.table.method2282(var1, var2);
      this.list.method2226(var1);
   }

   @ObfuscatedName("g")
   @Export("reset")
   public void reset() {
      this.list.method2230();
      this.table.method2275();
      this.field1877 = new CacheableNode();
      this.field1876 = this.field1874;
   }

   public NodeCache(int var1) {
      this.field1874 = var1;
      this.field1876 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
