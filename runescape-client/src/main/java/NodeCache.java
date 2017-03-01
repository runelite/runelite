import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("x")
   CacheableNode field1871 = new CacheableNode();
   @ObfuscatedName("n")
   int field1872;
   @ObfuscatedName("g")
   int field1873;
   @ObfuscatedName("v")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("y")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("x")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2437(var1);
      if(var3 != null) {
         this.list.method2391(var3);
      }

      return var3;
   }

   @ObfuscatedName("n")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2437(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2513();
         ++this.field1873;
      }

   }

   @ObfuscatedName("v")
   @Export("reset")
   public void reset() {
      this.list.method2394();
      this.table.method2439();
      this.field1871 = new CacheableNode();
      this.field1873 = this.field1872;
   }

   public NodeCache(int var1) {
      this.field1872 = var1;
      this.field1873 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("g")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1873 == 0) {
         CacheableNode var4 = this.list.method2393();
         var4.unlink();
         var4.method2513();
         if(var4 == this.field1871) {
            var4 = this.list.method2393();
            var4.unlink();
            var4.method2513();
         }
      } else {
         --this.field1873;
      }

      this.table.method2438(var1, var2);
      this.list.method2391(var1);
   }
}
