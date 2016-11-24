import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("d")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("j")
   static String field211;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "75"
   )
   static void method207(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field686[var5]) {
            var2[var4] = World.field686[var5];
            var3[var4] = World.field674[var5];
            ++var4;
         }
      }

      World.field686 = var2;
      World.field674 = var3;
      FaceNormal.method1924(World.worldList, 0, World.worldList.length - 1, World.field686, World.field674);
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-94"
   )
   static final void method208(String var0) {
      if(class164.clanMembers != null) {
         Client.field330.method3234(227);
         Client.field330.method2975(RSCanvas.method2132(var0));
         Client.field330.method2981(var0);
      }
   }
}
