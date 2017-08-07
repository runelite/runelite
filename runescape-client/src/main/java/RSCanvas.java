import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   static IndexFile field650;
   @ObfuscatedName("e")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "-13969"
   )
   public static int method788(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "1804659498"
   )
   static int method787(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class269.field3661:DecorativeObject.field2164;
      }

      if(var0 == 1927) {
         if(class84.field1339 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2732 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field849 = var3.field2732;
            var4.field848 = class84.field1339 + 1;
            Client.field1101.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
