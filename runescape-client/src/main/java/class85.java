import java.awt.Frame;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("qb")
   protected static Frame field1464;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1476455023
   )
   @Export("modelHeight")
   public int field1465 = 1000;

   @ObfuscatedName("v")
   void vmethod2318(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1888();
      if(null != var10) {
         this.field1465 = var10.field1465;
         var10.vmethod2318(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("s")
   public static String method1886(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class162.field2652[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected class105 vmethod1888() {
      return null;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Z",
      garbageValue = "74"
   )
   static boolean method1892(class173 var0) {
      if(client.field535) {
         if(class48.method962(var0) != 0) {
            return false;
         }

         if(var0.field2767 == 0) {
            return false;
         }
      }

      return var0.field2773;
   }
}
