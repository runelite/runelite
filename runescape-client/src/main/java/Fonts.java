import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field3694;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3695;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3693;
   @ObfuscatedName("k")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lid;Lid;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3695 = var1;
      this.field3693 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljk;I)Ljava/util/HashMap;",
      garbageValue = "149882621"
   )
   @Export("createMap")
   public HashMap createMap(FontName[] var1) {
      HashMap var2 = new HashMap();
      FontName[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         FontName var5 = var3[var4];
         if(this.map.containsKey(var5)) {
            var2.put(var5, this.map.get(var5));
         } else {
            Font var6 = Actor.method1576(this.field3695, this.field3693, var5.field3689, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
