import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class2 implements class0 {
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1025540231
   )
   static int field15;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -355445119
   )
   public static int field13;
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "[Lig;"
   )
   static Widget[] field14;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;Lhq;I)Lhq;",
      garbageValue = "2056780711"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         int var4 = var2 - 1;
         var4 |= var4 >>> 1;
         var4 |= var4 >>> 2;
         var4 |= var4 >>> 4;
         var4 |= var4 >>> 8;
         var4 |= var4 >>> 16;
         var3 = var4 + 1;
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var7 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var7) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-269067806"
   )
   static final void method4(String var0) {
      MapIconReference.method757("Please remove " + var0 + " from your ignore list first");
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1408401932"
   )
   static final void method3() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1206();
      }

   }
}
