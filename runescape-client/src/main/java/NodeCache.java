import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("e")
   int field1864;
   @ObfuscatedName("i")
   CacheableNode field1865 = new CacheableNode();
   @ObfuscatedName("f")
   int field1866;
   @ObfuscatedName("k")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("g")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("i")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2311(var1);
      if(var3 != null) {
         this.list.method2258(var3);
      }

      return var3;
   }

   @ObfuscatedName("e")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2311(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2388();
         ++this.field1866;
      }

   }

   @ObfuscatedName("f")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1866 == 0) {
         CacheableNode var4 = this.list.method2257();
         var4.unlink();
         var4.method2388();
         if(var4 == this.field1865) {
            var4 = this.list.method2257();
            var4.unlink();
            var4.method2388();
         }
      } else {
         --this.field1866;
      }

      this.table.method2312(var1, var2);
      this.list.method2258(var1);
   }

   @ObfuscatedName("k")
   @Export("reset")
   public void reset() {
      this.list.method2263();
      this.table.method2310();
      this.field1865 = new CacheableNode();
      this.field1866 = this.field1864;
   }

   public NodeCache(int var1) {
      this.field1864 = var1;
      this.field1866 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
