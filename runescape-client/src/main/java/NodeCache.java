import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("x")
   int field2428;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("table")
   XHashTable table;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   CacheableNode field2426;
   @ObfuscatedName("q")
   int field2430;

   public NodeCache(int var1) {
      this.field2426 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2430 = var1;
      this.field2428 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgq;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgq;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2428 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2426) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2428;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("y")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3563();
      this.field2426 = new CacheableNode();
      this.field2428 = this.field2430;
   }

   @ObfuscatedName("q")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2428;
      }

   }
}
