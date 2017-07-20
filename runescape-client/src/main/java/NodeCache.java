import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("i")
   int field2428;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("table")
   XHashTable table;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2426;
   @ObfuscatedName("o")
   int field2425;

   public NodeCache(int var1) {
      this.field2426 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2425 = var1;
      this.field2428 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(J)Lgc;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgc;J)V"
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

   @ObfuscatedName("u")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3497();
      this.field2426 = new CacheableNode();
      this.field2428 = this.field2425;
   }

   @ObfuscatedName("o")
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
