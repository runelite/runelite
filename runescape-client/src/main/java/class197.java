import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class197 {
   @ObfuscatedName("g")
   static final int[] field2577;
   @ObfuscatedName("n")
   static final int[] field2578;

   static {
      field2577 = new int[2048];
      field2578 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2577[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
         field2578[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1900230428"
   )
   public static void method3775() {
      PlayerComposition.field2791.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-1942448621"
   )
   static int method3776(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      } else {
         var3 = var2?class233.field2755:class81.field1260;
      }

      if(var0 == 1927) {
         if(class81.field1263 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2926 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2926;
            var4.field786 = class81.field1263 + 1;
            Client.field1045.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
