import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("q")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("t")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("n")
   int field2021;
   @ObfuscatedName("c")
   int field2022;
   @ObfuscatedName("d")
   CacheableNode field2023 = new CacheableNode();

   @ObfuscatedName("d")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2773(var1);
      if(var3 != null) {
         this.list.method2712(var3);
      }

      return var3;
   }

   @ObfuscatedName("q")
   @Export("reset")
   public void reset() {
      this.list.method2723();
      this.table.method2775();
      this.field2023 = new CacheableNode();
      this.field2021 = this.field2022;
   }

   @ObfuscatedName("n")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2021 == 0) {
         CacheableNode var4 = this.list.method2715();
         var4.unlink();
         var4.method2851();
         if(var4 == this.field2023) {
            var4 = this.list.method2715();
            var4.unlink();
            var4.method2851();
         }
      } else {
         --this.field2021;
      }

      this.table.method2774(var1, var2);
      this.list.method2712(var1);
   }

   public NodeCache(int var1) {
      this.field2022 = var1;
      this.field2021 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("c")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method2773(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method2851();
         ++this.field2021;
      }

   }
}
