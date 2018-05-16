import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1286566079
   )
   static int field3692;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   IndexDataBase field3694;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   IndexDataBase field3689;
   @ObfuscatedName("q")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Liv;Liv;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3694 = var1;
      this.field3689 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Lkt;I)Ljava/util/HashMap;",
      garbageValue = "959623838"
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
            Font var6 = class313.method5759(this.field3694, this.field3689, var5.field3686, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
