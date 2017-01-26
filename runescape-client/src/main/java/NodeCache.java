import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("q")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("g")
   int field1871;
   @ObfuscatedName("x")
   int field1872;
   @ObfuscatedName("p")
   CacheableNode field1873 = new CacheableNode();
   @ObfuscatedName("d")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   public NodeCache(int var1) {
      this.field1871 = var1;
      this.field1872 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("p")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2374(var1);
      if(var3 != null) {
         this.list.method2304(var3);
      }

      return var3;
   }

   @ObfuscatedName("q")
   @Export("reset")
   public void reset() {
      this.list.method2305();
      this.table.method2358();
      this.field1873 = new CacheableNode();
      this.field1872 = this.field1871;
   }

   @ObfuscatedName("g")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2374(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2440();
         ++this.field1872;
      }

   }

   @ObfuscatedName("x")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1872 == 0) {
         CacheableNode var4 = this.list.method2302();
         var4.unlink();
         var4.method2440();
         if(var4 == this.field1873) {
            var4 = this.list.method2302();
            var4.unlink();
            var4.method2440();
         }
      } else {
         --this.field1872;
      }

      this.table.method2364(var1, var2);
      this.list.method2304(var1);
   }
}
