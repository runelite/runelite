import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class262 {
   @ObfuscatedName("p")
   IndexDataBase field3641;
   @ObfuscatedName("i")
   HashMap field3642;
   @ObfuscatedName("n")
   IndexDataBase field3644;

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3644 = var1;
      this.field3641 = var2;
      this.field3642 = new HashMap();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Lclass261;I)Ljava/util/HashMap;",
      garbageValue = "-208711385"
   )
   public HashMap method4768(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3642.containsKey(var5)) {
            var2.put(var5, this.field3642.get(var5));
         } else {
            Font var6 = class230.method4113(this.field3644, this.field3641, var5.field3633, "");
            if(var6 != null) {
               this.field3642.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
