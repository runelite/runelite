import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class263 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   IndexDataBase field3624;
   @ObfuscatedName("f")
   HashMap field3623;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   IndexDataBase field3621;

   @ObfuscatedSignature(
      signature = "(Lia;Lia;)V"
   )
   public class263(IndexDataBase var1, IndexDataBase var2) {
      this.field3624 = var1;
      this.field3621 = var2;
      this.field3623 = new HashMap();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Ljy;I)Ljava/util/HashMap;",
      garbageValue = "1446874562"
   )
   public HashMap method4760(class262[] var1) {
      HashMap var2 = new HashMap();
      class262[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class262 var5 = var3[var4];
         if(this.field3623.containsKey(var5)) {
            var2.put(var5, this.field3623.get(var5));
         } else {
            Font var6 = class33.method375(this.field3624, this.field3621, var5.field3608, "");
            if(var6 != null) {
               this.field3623.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
