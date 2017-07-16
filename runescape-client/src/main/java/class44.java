import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class44 extends WorldMapData {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   static Buffer field568;
   @ObfuscatedName("oa")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("t")
   List field567;
   @ObfuscatedName("g")
   HashSet field566;
   @ObfuscatedName("k")
   HashSet field565;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lfe;ZI)V",
      garbageValue = "-1577245512"
   )
   void method632(Buffer var1, boolean var2) {
      this.field567 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3221();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field567.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lfe;Lfe;Lfe;IZI)V",
      garbageValue = "230365169"
   )
   void method633(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field566 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method159(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field566.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field565 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method660(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field565.add(var9);
      }

      this.method632(var2, var5);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-744456704"
   )
   public static final void method640(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.field226.method3563(new class8(var7, var9, var8, var10, -49088));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "467512237"
   )
   public static void method641(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }
}
