import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("a")
   int field2460;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CacheableNode field2462;
   @ObfuscatedName("j")
   int field2461;

   public NodeCache(int var1) {
      this.field2462 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2461 = var1;
      this.field2460 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(J)Lgo;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgo;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2460 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2462) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2460;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("r")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3623();
      this.field2462 = new CacheableNode();
      this.field2460 = this.field2461;
   }

   @ObfuscatedName("j")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2460;
      }

   }
}
