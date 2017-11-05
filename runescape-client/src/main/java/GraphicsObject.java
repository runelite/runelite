import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("ng")
   @ObfuscatedSignature(
      signature = "[Lbh;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("k")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1091697919
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1761706863
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -696049155
   )
   @Export("level")
   int level;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1623273965
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1787111417
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1771908919
   )
   @Export("height")
   int height;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   Sequence field1341;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1514763711
   )
   int field1346;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1318309111
   )
   int field1342;
   @ObfuscatedName("x")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1346 = 0;
      this.field1342 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class244.getSpotAnimType(this.id).field3325;
      if(var8 != -1) {
         this.finished = false;
         this.field1341 = NPCComposition.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "336145472"
   )
   final void method1675(int var1) {
      if(!this.finished) {
         this.field1342 += var1;

         while(this.field1342 > this.field1341.frameLenghts[this.field1346]) {
            this.field1342 -= this.field1341.frameLenghts[this.field1346];
            ++this.field1346;
            if(this.field1346 >= this.field1341.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Leh;",
      garbageValue = "0"
   )
   protected final Model getModel() {
      Spotanim var1 = class244.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4404(this.field1346);
      } else {
         var2 = var1.method4404(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;ZI)V",
      garbageValue = "1898450877"
   )
   public static void method1670(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3436 = var1;
      ObjectComposition.field3455 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2135631064"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class28.method244(var0 - 1, var1 - 1) + class28.method244(var0 + 1, var1 - 1) + class28.method244(var0 - 1, 1 + var1) + class28.method244(1 + var0, 1 + var1);
      int var3 = class28.method244(var0 - 1, var1) + class28.method244(1 + var0, var1) + class28.method244(var0, var1 - 1) + class28.method244(var0, 1 + var1);
      int var4 = class28.method244(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
