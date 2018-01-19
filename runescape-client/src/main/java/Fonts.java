import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = 4959584225593366419L
   )
   static long field3716;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   IndexDataBase field3713;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   IndexDataBase field3714;
   @ObfuscatedName("y")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lil;Lil;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3713 = var1;
      this.field3714 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljf;I)Ljava/util/HashMap;",
      garbageValue = "-110666595"
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
            Font var6 = FileSystem.method4299(this.field3713, this.field3714, var5.field3705, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
