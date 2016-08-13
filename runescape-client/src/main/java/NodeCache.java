import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("g")
   int field3136;
   @ObfuscatedName("r")
   int field3137;
   @ObfuscatedName("h")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("e")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("l")
   CacheableNode field3140 = new CacheableNode();

   @ObfuscatedName("l")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3936(var1);
      if(var3 != null) {
         this.list.method4033(var3);
      }

      return var3;
   }

   @ObfuscatedName("g")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3936(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method4045();
         ++this.field3137;
      }

   }

   @ObfuscatedName("r")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3137 == 0) {
         CacheableNode var4 = this.list.method4032();
         var4.unlink();
         var4.method4045();
         if(var4 == this.field3140) {
            var4 = this.list.method4032();
            var4.unlink();
            var4.method4045();
         }
      } else {
         --this.field3137;
      }

      this.table.method3940(var1, var2);
      this.list.method4033(var1);
   }

   @ObfuscatedName("e")
   @Export("reset")
   public void reset() {
      this.list.method4034();
      this.table.method3938();
      this.field3140 = new CacheableNode();
      this.field3137 = this.field3136;
   }

   public NodeCache(int var1) {
      this.field3136 = var1;
      this.field3137 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
