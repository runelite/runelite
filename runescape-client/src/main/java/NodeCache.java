import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("w")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("n")
   CacheableNode field1866 = new CacheableNode();
   @ObfuscatedName("m")
   int field1867;
   @ObfuscatedName("d")
   int field1868;
   @ObfuscatedName("h")
   @Export("table")
   XHashTable table;

   @ObfuscatedName("d")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2405(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2483();
         ++this.field1867;
      }

   }

   @ObfuscatedName("m")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1867 == 0) {
         CacheableNode var4 = this.list.method2354();
         var4.unlink();
         var4.method2483();
         if(var4 == this.field1866) {
            var4 = this.list.method2354();
            var4.unlink();
            var4.method2483();
         }
      } else {
         --this.field1867;
      }

      this.table.method2406(var1, var2);
      this.list.method2352(var1);
   }

   @ObfuscatedName("h")
   @Export("reset")
   public void reset() {
      this.list.method2356();
      this.table.method2407();
      this.field1866 = new CacheableNode();
      this.field1867 = this.field1868;
   }

   @ObfuscatedName("n")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2405(var1);
      if(var3 != null) {
         this.list.method2352(var3);
      }

      return var3;
   }

   public NodeCache(int var1) {
      this.field1868 = var1;
      this.field1867 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
