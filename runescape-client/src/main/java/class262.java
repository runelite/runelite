import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class262 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3617;
   @ObfuscatedName("i")
   HashMap field3614;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3615;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;)V"
   )
   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3617 = var1;
      this.field3615 = var2;
      this.field3614 = new HashMap();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljp;I)Ljava/util/HashMap;",
      garbageValue = "1656473001"
   )
   public HashMap method4620(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3614.containsKey(var5)) {
            var2.put(var5, this.field3614.get(var5));
         } else {
            IndexDataBase var7 = this.field3617;
            IndexDataBase var8 = this.field3615;
            String var9 = var5.field3606;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var6 = class254.method4396(var7, var8, var10, var11);
            if(var6 != null) {
               this.field3614.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
