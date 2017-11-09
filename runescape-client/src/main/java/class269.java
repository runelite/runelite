import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class269 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3693;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3688;
   @ObfuscatedName("i")
   HashMap field3690;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;)V"
   )
   public class269(IndexDataBase var1, IndexDataBase var2) {
      this.field3693 = var1;
      this.field3688 = var2;
      this.field3690 = new HashMap();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljd;I)Ljava/util/HashMap;",
      garbageValue = "2124380261"
   )
   public HashMap method4915(class268[] var1) {
      HashMap var2 = new HashMap();
      class268[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class268 var5 = var3[var4];
         if(this.field3690.containsKey(var5)) {
            var2.put(var5, this.field3690.get(var5));
         } else {
            Font var6 = class279.method5095(this.field3693, this.field3688, var5.field3680, "");
            if(var6 != null) {
               this.field3690.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
