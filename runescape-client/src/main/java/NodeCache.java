import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("m")
   int field1881;
   @ObfuscatedName("h")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("b")
   int field1883;
   @ObfuscatedName("g")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("o")
   CacheableNode field1885 = new CacheableNode();

   @ObfuscatedName("o")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2299(var1);
      if(var3 != null) {
         this.list.method2241(var3);
      }

      return var3;
   }

   @ObfuscatedName("m")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2299(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2380();
         ++this.field1883;
      }

   }

   @ObfuscatedName("b")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1883 == 0) {
         CacheableNode var4 = this.list.method2250();
         var4.unlink();
         var4.method2380();
         if(var4 == this.field1885) {
            var4 = this.list.method2250();
            var4.unlink();
            var4.method2380();
         }
      } else {
         --this.field1883;
      }

      this.table.method2291(var1, var2);
      this.list.method2241(var1);
   }

   public NodeCache(int var1) {
      this.field1881 = var1;
      this.field1883 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("g")
   @Export("reset")
   public void reset() {
      this.list.method2251();
      this.table.method2292();
      this.field1885 = new CacheableNode();
      this.field1883 = this.field1881;
   }
}
