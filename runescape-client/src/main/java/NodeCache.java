import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("p")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("d")
   int field1869;
   @ObfuscatedName("h")
   int field1870;
   @ObfuscatedName("q")
   CacheableNode field1871 = new CacheableNode();
   @ObfuscatedName("j")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("d")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2399(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2484();
         ++this.field1870;
      }

   }

   @ObfuscatedName("h")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1870 == 0) {
         CacheableNode var4 = this.list.method2347();
         var4.unlink();
         var4.method2484();
         if(var4 == this.field1871) {
            var4 = this.list.method2347();
            var4.unlink();
            var4.method2484();
         }
      } else {
         --this.field1870;
      }

      this.table.method2400(var1, var2);
      this.list.method2357(var1);
   }

   @ObfuscatedName("p")
   @Export("reset")
   public void reset() {
      this.list.method2349();
      this.table.method2401();
      this.field1871 = new CacheableNode();
      this.field1870 = this.field1869;
   }

   public NodeCache(int var1) {
      this.field1869 = var1;
      this.field1870 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("q")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2399(var1);
      if(var3 != null) {
         this.list.method2357(var3);
      }

      return var3;
   }
}
