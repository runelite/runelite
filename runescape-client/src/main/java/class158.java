import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public enum class158 implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   field2157(1, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   field2150(2, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   field2153(3, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   field2156(0, 3);

   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   @Export("varcs")
   static Varcs varcs;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1881341611
   )
   public final int field2154;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1077563813
   )
   final int field2155;

   class158(int var3, int var4) {
      this.field2154 = var3;
      this.field2155 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field2155;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljo;",
      garbageValue = "-944432178"
   )
   public static CombatInfo2 method3188(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3525.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class33.field441.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         CombatInfo2.field3525.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjm;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-248685038"
   )
   public static void method3185(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      CacheFile.method2509(var0, var1, var6, var7, var4, var5);
   }
}
