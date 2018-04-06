import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   IndexDataBase field3892;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   IndexDataBase field3890;
   @ObfuscatedName("t")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3892 = var1;
      this.field3890 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lkp;I)Ljava/util/HashMap;",
      garbageValue = "-1359608733"
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
            IndexDataBase var7 = this.field3892;
            IndexDataBase var8 = this.field3890;
            String var9 = var5.field3885;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var6 = FontName.method5488(var7, var8, var10, var11);
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
