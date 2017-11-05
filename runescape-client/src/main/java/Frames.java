import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1900192155
   )
   static int field2124;
   @ObfuscatedName("af")
   static int[] field2125;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -219223207
   )
   static int field2120;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ldb;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.getChild(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1214470154"
   )
   public boolean method2906(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2052519168"
   )
   static final void method2907(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         int var2 = Client.menuOptionCount - 1;
         String var4;
         if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
            var4 = "Use" + " " + Client.field1068 + " " + "->";
         } else if(Client.spellSelected && Client.menuOptionCount < 2) {
            var4 = Client.field1072 + " " + Client.field1087 + " " + "->";
         } else {
            String var5;
            if(var2 < 0) {
               var5 = "";
            } else if(Client.menuTargets[var2].length() > 0) {
               var5 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
            } else {
               var5 = Client.menuOptions[var2];
            }

            var4 = var5;
         }

         if(Client.menuOptionCount > 2) {
            var4 = var4 + class24.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class155.field2238.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
