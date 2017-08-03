import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class262 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3614;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   IndexDataBase field3610;
   @ObfuscatedName("x")
   HashMap field3612;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   IndexDataBase field3611;

   @ObfuscatedSignature(
      signature = "(Lim;Lim;)V"
   )
   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3610 = var1;
      this.field3611 = var2;
      this.field3612 = new HashMap();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljf;B)Ljava/util/HashMap;",
      garbageValue = "0"
   )
   public HashMap method4718(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3612.containsKey(var5)) {
            var2.put(var5, this.field3612.get(var5));
         } else {
            Font var6 = class276.method4910(this.field3610, this.field3611, var5.field3606, "");
            if(var6 != null) {
               this.field3612.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
