import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("f")
   int field3128;
   @ObfuscatedName("q")
   int field3129;
   @ObfuscatedName("k")
   CacheableNode field3130 = new CacheableNode();
   @ObfuscatedName("c")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("v")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("k")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3828(var1);
      if(var3 != null) {
         this.list.method3920(var3);
      }

      return var3;
   }

   @ObfuscatedName("q")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3828(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3932();
         ++this.field3128;
      }

   }

   @ObfuscatedName("f")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3128 == 0) {
         CacheableNode var4 = this.list.method3917();
         var4.unlink();
         var4.method3932();
         if(var4 == this.field3130) {
            var4 = this.list.method3917();
            var4.unlink();
            var4.method3932();
         }
      } else {
         --this.field3128;
      }

      this.table.method3822(var1, var2);
      this.list.method3920(var1);
   }

   @ObfuscatedName("c")
   @Export("reset")
   public void reset() {
      this.list.method3919();
      this.table.method3824();
      this.field3130 = new CacheableNode();
      this.field3128 = this.field3129;
   }

   public NodeCache(int var1) {
      this.field3129 = var1;
      this.field3128 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
