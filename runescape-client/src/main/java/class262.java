import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class262 {
   @ObfuscatedName("h")
   IndexDataBase field3629;
   @ObfuscatedName("i")
   IndexDataBase field3630;
   @ObfuscatedName("u")
   HashMap field3631;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass261;I)Ljava/util/HashMap;",
      garbageValue = "-728597144"
   )
   public HashMap method4796(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3631.containsKey(var5)) {
            var2.put(var5, this.field3631.get(var5));
         } else {
            IndexDataBase var7 = this.field3630;
            IndexDataBase var8 = this.field3629;
            String var9 = var5.field3621;
            int var10 = var7.method4189(var9);
            int var11 = var7.method4190(var10, "");
            Font var6 = class30.method265(var7, var8, var10, var11);
            if(var6 != null) {
               this.field3631.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3630 = var1;
      this.field3629 = var2;
      this.field3631 = new HashMap();
   }
}
