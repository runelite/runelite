import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public class class262 {
   @ObfuscatedName("i")
   IndexDataBase field3636;
   @ObfuscatedName("w")
   IndexDataBase field3637;
   @ObfuscatedName("a")
   HashMap field3638;
   @ObfuscatedName("gc")
   static ModIcon[] field3639;
   @ObfuscatedName("lp")
   static Widget[] field3641;

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3636 = var1;
      this.field3637 = var2;
      this.field3638 = new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass261;B)Ljava/util/HashMap;",
      garbageValue = "65"
   )
   public HashMap method4737(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3638.containsKey(var5)) {
            var2.put(var5, this.field3638.get(var5));
         } else {
            IndexDataBase var6 = this.field3636;
            IndexDataBase var7 = this.field3637;
            String var8 = var5.field3631;
            int var9 = var6.getFile(var8);
            int var10 = var6.getChild(var9, "");
            Font var11;
            if(!class223.method4073(var6, var9, var10)) {
               var11 = null;
            } else {
               byte[] var12 = var7.getConfigData(var9, var10);
               Font var13;
               if(var12 == null) {
                  var13 = null;
               } else {
                  Font var14 = new Font(var12, class286.field3799, class286.offsetsY, class7.field239, class226.field3146, class278.field3745, class210.spritePixels);
                  XGrandExchangeOffer.method113();
                  var13 = var14;
               }

               var11 = var13;
            }

            if(var11 != null) {
               this.field3638.put(var5, var11);
               var2.put(var5, var11);
            }
         }
      }

      return var2;
   }
}
