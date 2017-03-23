import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("r")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("f")
   CacheableNode field1892 = new CacheableNode();
   @ObfuscatedName("u")
   int field1893;
   @ObfuscatedName("i")
   int field1894;
   @ObfuscatedName("h")
   @Export("table")
   XHashTable table;

   @ObfuscatedName("f")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2417(var1);
      if(var3 != null) {
         this.list.method2368(var3);
      }

      return var3;
   }

   @ObfuscatedName("i")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2417(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2495();
         ++this.field1893;
      }

   }

   @ObfuscatedName("r")
   @Export("reset")
   public void reset() {
      this.list.method2366();
      this.table.method2419();
      this.field1892 = new CacheableNode();
      this.field1893 = this.field1894;
   }

   @ObfuscatedName("u")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field1893 == 0) {
         CacheableNode var4 = this.list.method2365();
         var4.unlink();
         var4.method2495();
         if(var4 == this.field1892) {
            var4 = this.list.method2365();
            var4.unlink();
            var4.method2495();
         }
      } else {
         --this.field1893;
      }

      this.table.method2418(var1, var2);
      this.list.method2368(var1);
   }

   public NodeCache(int var1) {
      this.field1894 = var1;
      this.field1893 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
