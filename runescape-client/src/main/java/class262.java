import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class262 {
   @ObfuscatedName("p")
   IndexDataBase field3633;
   @ObfuscatedName("m")
   IndexDataBase field3634;
   @ObfuscatedName("e")
   HashMap field3635;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Lclass261;I)Ljava/util/HashMap;",
      garbageValue = "-1455620912"
   )
   public HashMap method4611(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3635.containsKey(var5)) {
            var2.put(var5, this.field3635.get(var5));
         } else {
            Font var6 = class220.method3950(this.field3633, this.field3634, var5.field3629, "");
            if(var6 != null) {
               this.field3635.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)LSpritePixels;",
      garbageValue = "25042700"
   )
   public static SpritePixels method4613(IndexDataBase var0, int var1, int var2) {
      return !class1.method3(var0, var1, var2)?null:XClanMember.method1098();
   }

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3633 = var1;
      this.field3634 = var2;
      this.field3635 = new HashMap();
   }
}
