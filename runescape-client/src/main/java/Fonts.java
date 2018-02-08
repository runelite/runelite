import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   IndexDataBase field3758;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   IndexDataBase field3757;
   @ObfuscatedName("m")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3758 = var1;
      this.field3757 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljx;B)Ljava/util/HashMap;",
      garbageValue = "-34"
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
            IndexDataBase var7 = this.field3758;
            IndexDataBase var8 = this.field3757;
            String var9 = var5.field3749;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var12;
            if(!class35.method484(var7, var10, var11)) {
               var12 = null;
            } else {
               byte[] var14 = var8.getConfigData(var10, var11);
               Font var13;
               if(var14 == null) {
                  var13 = null;
               } else {
                  Font var15 = new Font(var14, class219.field2698, class263.offsetsY, class60.field708, class310.field3911, class289.field3786, class310.spritePixels);
                  Name.method5282();
                  var13 = var15;
               }

               var12 = var13;
            }

            if(var12 != null) {
               this.map.put(var5, var12);
               var2.put(var5, var12);
            }
         }
      }

      return var2;
   }
}
