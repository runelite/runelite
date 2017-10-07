import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class64 {
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field816;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;B)Lkr;",
      garbageValue = "85"
   )
   public static SpritePixels method1132(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return AbstractSoundSystem.method2136(var0, var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIS)V",
      garbageValue = "-9809"
   )
   static void method1131(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1131(var0, var1, var2, var5 - 1);
         method1131(var0, var1, var5 + 1, var3);
      }

   }
}
