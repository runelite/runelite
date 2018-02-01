import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3735;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3736;
   @ObfuscatedName("w")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3735 = var1;
      this.field3736 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljo;B)Ljava/util/HashMap;",
      garbageValue = "-4"
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
            IndexDataBase var7 = this.field3735;
            IndexDataBase var8 = this.field3736;
            String var9 = var5.field3727;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var6 = ScriptVarType.method35(var7, var8, var10, var11);
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lko;",
      garbageValue = "56"
   )
   static SpritePixels[] method5199() {
      SpritePixels[] var0 = new SpritePixels[class310.field3894];

      for(int var1 = 0; var1 < class310.field3894; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class310.field3891;
         var2.maxHeight = class310.field3898;
         var2.offsetX = class310.field3892[var1];
         var2.offsetY = class310.offsetsY[var1];
         var2.width = class310.field3895[var1];
         var2.height = class310.field3896[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class160.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class310.field3897[var4[var5] & 255];
         }
      }

      class47.method698();
      return var0;
   }
}
