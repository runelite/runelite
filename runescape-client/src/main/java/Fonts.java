import java.applet.Applet;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   IndexDataBase field3894;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   IndexDataBase field3891;
   @ObfuscatedName("b")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3894 = var1;
      this.field3891 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Lkv;I)Ljava/util/HashMap;",
      garbageValue = "787875018"
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
            IndexDataBase var7 = this.field3894;
            IndexDataBase var8 = this.field3891;
            String var9 = var5.field3889;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var12;
            if(!class326.method5792(var7, var10, var11)) {
               var12 = null;
            } else {
               var12 = AbstractByteBuffer.method3837(var8.getConfigData(var10, var11));
            }

            if(var12 != null) {
               this.map.put(var5, var12);
               var2.put(var5, var12);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-631481600"
   )
   public static void method5551(Applet var0, String var1) {
      class57.field661 = var0;
      if(var1 != null) {
         class57.field655 = var1;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "349070007"
   )
   static final int method5548(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
