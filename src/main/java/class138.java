import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public final class class138 extends Canvas {
   @ObfuscatedName("az")
   static class167 field2129;
   @ObfuscatedName("a")
   Component field2131;

   public final void paint(Graphics var1) {
      this.field2131.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field2131.update(var1);
   }

   class138(Component var1) {
      this.field2131 = var1;
   }

   @ObfuscatedName("n")
   public static String method2949(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("r")
   public static class223 method2951(class166 var0, class166 var1, int var2, int var3) {
      if(!class12.method176(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3263(var2, var3);
         class223 var4;
         if(null == var5) {
            var4 = null;
         } else {
            class223 var6 = new class223(var5, class76.field1386, class76.field1382, class102.field1764, class76.field1383, class115.field1968, class30.field708);
            class1.method7();
            var4 = var6;
         }

         return var4;
      }
   }
}
