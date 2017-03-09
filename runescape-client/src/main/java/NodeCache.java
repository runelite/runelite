import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("d")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("j")
   int field1871;
   @ObfuscatedName("x")
   CacheableNode field1872 = new CacheableNode();
   @ObfuscatedName("c")
   int field1873;
   @ObfuscatedName("w")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("x")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2405(var1);
      if(var3 != null) {
         this.list.method2335(var3);
      }

      return var3;
   }

   @ObfuscatedName("j")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2405(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2476();
         ++this.field1873;
      }

   }

   @ObfuscatedName("c")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1873 == 0) {
         CacheableNode var4 = this.list.method2337();
         var4.unlink();
         var4.method2476();
         if(var4 == this.field1872) {
            var4 = this.list.method2337();
            var4.unlink();
            var4.method2476();
         }
      } else {
         --this.field1873;
      }

      this.table.method2403(var1, var2);
      this.list.method2335(var1);
   }

   @ObfuscatedName("d")
   @Export("reset")
   public void reset() {
      this.list.method2354();
      this.table.method2390();
      this.field1872 = new CacheableNode();
      this.field1873 = this.field1871;
   }

   public NodeCache(int var1) {
      this.field1871 = var1;
      this.field1873 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
