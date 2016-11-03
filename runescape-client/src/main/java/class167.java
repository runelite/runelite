import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class167 {
   @ObfuscatedName("f")
   static final char[] field2702 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("c")
   static final char[] field2703 = new char[]{'[', ']', '#'};

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   static void method3258() {
      int var0 = GameEngine.field2251;
      int var1 = GameEngine.field2242;
      int var2 = class13.field198 - GroundObject.field1652 - var0;
      int var3 = class11.field169 - VertexNormal.field1689 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field480.method3061();
            int var5 = 0;
            int var6 = 0;
            if(class12.field188 == var4) {
               Insets var7 = class12.field188.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class11.field169);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class13.field198, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class13.field198 - var2, var6, var2, class11.field169);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class11.field169 + var6 - var3, class13.field198, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
