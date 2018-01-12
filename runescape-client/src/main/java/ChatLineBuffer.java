import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1771803705
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbv;",
      garbageValue = "1230793549"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "-2012333335"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1107799616"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   static void method1851() {
      if(class91.field1347) {
         class91.field1316 = null;
         class91.field1317 = null;
         class234.runeSprites = null;
         class91.field1315 = null;
         class91.field1319 = null;
         class91.logoSprite = null;
         class278.titlemuteSprite = null;
         CombatInfoListHolder.field1267 = null;
         class91.field1333 = null;
         FriendLoginUpdate.field760 = null;
         SpritePixels2.slFlagSprites = null;
         class7.slArrowSprites = null;
         class37.slStarSprites = null;
         class160.field2151 = null;
         class218.field2696 = null;
         class91.field1325 = null;
         class2.field11 = null;
         Item.field1386 = null;
         class36.field478 = null;
         class186.field2532 = null;
         class89.field1302 = null;
         BoundingBox.field238 = null;
         class214.field2620 = 1;
         class214.field2623 = null;
         class61.field692 = -1;
         class282.field3754 = -1;
         class214.field2625 = 0;
         IndexFile.field2181 = false;
         Timer.field2159 = 2;
         class27.sendConInfo(true);
         class91.field1347 = false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lca;B)V",
      garbageValue = "30"
   )
   public static final void method1858(TaskDataProvider var0) {
      AbstractSoundSystem.soundTaskDataProvider = var0;
   }
}
