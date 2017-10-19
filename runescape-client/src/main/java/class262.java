import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class262 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3636;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3638;
   @ObfuscatedName("q")
   HashMap field3637;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;)V"
   )
   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3636 = var1;
      this.field3638 = var2;
      this.field3637 = new HashMap();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljz;I)Ljava/util/HashMap;",
      garbageValue = "-2099682264"
   )
   public HashMap method4823(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3637.containsKey(var5)) {
            var2.put(var5, this.field3637.get(var5));
         } else {
            Font var6 = class14.method86(this.field3636, this.field3638, var5.field3629, "");
            if(var6 != null) {
               this.field3637.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
