import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class19 implements Comparator {
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   static class13 field330;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lb;Lb;B)I",
      garbageValue = "-61"
   )
   int method138(class14 var1, class14 var2) {
      return var1.field289 < var2.field289?-1:(var2.field289 == var1.field289?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method138((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;IZI)Lei;",
      garbageValue = "1939392564"
   )
   public static Frames method144(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "37"
   )
   static int method142() {
      return Client.isResized?2:1;
   }
}
