import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field768;
   @ObfuscatedName("m")
   @Export("name")
   String name;
   @ObfuscatedName("p")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1444684541
   )
   @Export("world")
   int world;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2011993031
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("v")
   boolean field770;
   @ObfuscatedName("x")
   boolean field771;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;Lik;S)V",
      garbageValue = "-17180"
   )
   public static void method1150(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class261.field3479 = var0;
      class261.field3462 = var1;
      class261.field3463 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2138513828"
   )
   public static int method1151(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1224952031"
   )
   static final String[] method1149(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
