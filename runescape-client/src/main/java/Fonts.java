import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   IndexDataBase field3760;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   IndexDataBase field3761;
   @ObfuscatedName("o")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lie;Lie;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3760 = var1;
      this.field3761 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lki;I)Ljava/util/HashMap;",
      garbageValue = "-557428408"
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
            IndexDataBase var7 = this.field3760;
            IndexDataBase var8 = this.field3761;
            String var9 = var5.field3759;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var6 = GameSocket.method3379(var7, var8, var10, var11);
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
