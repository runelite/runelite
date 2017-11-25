import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class269 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field3694;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static class70 field3696;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3695;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3693;
   @ObfuscatedName("k")
   HashMap field3692;

   @ObfuscatedSignature(
      signature = "(Lid;Lid;)V"
   )
   public class269(IndexDataBase var1, IndexDataBase var2) {
      this.field3695 = var1;
      this.field3693 = var2;
      this.field3692 = new HashMap();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljk;I)Ljava/util/HashMap;",
      garbageValue = "149882621"
   )
   public HashMap method4914(class268[] var1) {
      HashMap var2 = new HashMap();
      class268[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class268 var5 = var3[var4];
         if(this.field3692.containsKey(var5)) {
            var2.put(var5, this.field3692.get(var5));
         } else {
            Font var6 = Actor.method1576(this.field3695, this.field3693, var5.field3689, "");
            if(var6 != null) {
               this.field3692.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
