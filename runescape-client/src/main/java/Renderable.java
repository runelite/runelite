import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -405865165
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("ci")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lhi;I)Z",
      garbageValue = "-1730668489"
   )
   static boolean method2896(Widget var0) {
      if(Client.field1096) {
         if(class262.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-927381729"
   )
   public static void method2894(File var0) {
      class158.field2262 = var0;
      if(!class158.field2262.exists()) {
         throw new RuntimeException("");
      } else {
         class158.field2267 = true;
      }
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Lhi;I)Ljava/lang/String;",
      garbageValue = "-359677229"
   )
   static String method2895(Widget var0) {
      int var2 = class262.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
