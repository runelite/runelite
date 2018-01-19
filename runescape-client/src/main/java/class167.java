import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class167 {
   @ObfuscatedName("y")
   public static int[][] field2236;
   @ObfuscatedName("r")
   public static int[][] field2238;
   @ObfuscatedName("b")
   public static int[] field2241;
   @ObfuscatedName("e")
   public static int[] field2240;

   static {
      field2236 = new int[128][128];
      field2238 = new int[128][128];
      field2241 = new int[4096];
      field2240 = new int[4096];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;I)V",
      garbageValue = "878734503"
   )
   public static void method3235(IndexDataBase var0) {
      class228.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1064240801"
   )
   public static boolean method3234(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Ljs;IIII)V",
      garbageValue = "-819383232"
   )
   static void method3229(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1025 < 50 && Client.field1094 != 0) {
         if(var0.field3690 != null && var1 < var0.field3690.length) {
            int var4 = var0.field3690[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1096[Client.field1025] = var5;
               Client.field1027[Client.field1025] = var6;
               Client.field1098[Client.field1025] = 0;
               Client.audioEffects[Client.field1025] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1099[Client.field1025] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1025;
            }
         }
      }
   }
}
