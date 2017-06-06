import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class262 {
   @ObfuscatedName("e")
   HashMap field3629;
   @ObfuscatedName("i")
   IndexDataBase field3630;
   @ObfuscatedName("c")
   IndexDataBase field3631;

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3630 = var1;
      this.field3631 = var2;
      this.field3629 = new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass261;I)Ljava/util/HashMap;",
      garbageValue = "-875992918"
   )
   public HashMap method4714(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3629.containsKey(var5)) {
            var2.put(var5, this.field3629.get(var5));
         } else {
            Font var6 = class35.method478(this.field3630, this.field3631, var5.field3624, "");
            if(var6 != null) {
               this.field3629.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
