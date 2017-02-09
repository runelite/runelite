import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("y")
   int field1860;
   @ObfuscatedName("k")
   CacheableNode field1861 = new CacheableNode();
   @ObfuscatedName("o")
   int field1862;
   @ObfuscatedName("r")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("w")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("k")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2331(var1);
      if(var3 != null) {
         this.list.method2282(var3);
      }

      return var3;
   }

   @ObfuscatedName("y")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2331(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2411();
         ++this.field1862;
      }

   }

   @ObfuscatedName("r")
   @Export("reset")
   public void reset() {
      this.list.method2286();
      this.table.method2340();
      this.field1861 = new CacheableNode();
      this.field1862 = this.field1860;
   }

   @ObfuscatedName("o")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1862 == 0) {
         CacheableNode var4 = this.list.method2281();
         var4.unlink();
         var4.method2411();
         if(var4 == this.field1861) {
            var4 = this.list.method2281();
            var4.unlink();
            var4.method2411();
         }
      } else {
         --this.field1862;
      }

      this.table.method2333(var1, var2);
      this.list.method2282(var1);
   }

   public NodeCache(int var1) {
      this.field1860 = var1;
      this.field1862 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
