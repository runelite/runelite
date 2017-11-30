import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   IndexDataBase field3703;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   IndexDataBase field3701;
   @ObfuscatedName("e")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lib;Lib;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3703 = var1;
      this.field3701 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljl;I)Ljava/util/HashMap;",
      garbageValue = "1016658752"
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
            Font var6 = class280.method5002(this.field3703, this.field3701, var5.field3695, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
