import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class38 extends class206 {
   @ObfuscatedName("r")
   String field872;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 23610401
   )
   static int field873;
   @ObfuscatedName("f")
   short field874;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1274259445
   )
   int field875 = (int)(class18.method214() / 1000L);
   @ObfuscatedName("cg")
   static class223 field876;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -1759410561
   )
   static int field879;
   @ObfuscatedName("ae")
   static class80[] field880;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   static void method767() {
      int var0 = class143.field2179;
      int var1 = class143.field2189;
      int var2 = class218.field3161 - class6.field107 - var0;
      int var3 = class42.field1005 - class31.field749 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field540.method3036();
            int var5 = 0;
            int var6 = 0;
            if(class59.field1217 == var4) {
               Insets var7 = class59.field1217.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class42.field1005);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class218.field3161, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class218.field3161 + var5 - var2, var6, var2, class42.field1005);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class42.field1005 - var3, class218.field3161, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   class38(String var1, int var2) {
      this.field872 = var1;
      this.field874 = (short)var2;
   }
}
