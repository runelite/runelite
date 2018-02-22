import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("INTEGER")
   INTEGER(1, 0, Integer.class, new class2()),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("LONG")
   LONG(0, 1, Long.class, new class3()),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("h")
   static int[] field28;
   @ObfuscatedName("l")
   static byte[][][] field27;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 987972763
   )
   static int field25;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1227815721
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 487097409
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lb;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lee;IIII)Z",
      garbageValue = "1348067505"
   )
   @Export("boundingBox3DContainsMouse")
   public static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class131.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         class29.method273();
         int var5 = var0.centerX + var1;
         int var6 = var2 + var0.centerY;
         int var7 = var3 + var0.centerZ;
         int var8 = var0.extremeX;
         int var9 = var0.extremeY;
         int var10 = var0.extremeZ;
         int var11 = class177.field2251 - var5;
         int var12 = class153.field2091 - var6;
         int var13 = UnitPriceComparator.field294 - var7;
         return Math.abs(var11) > var8 + OwnWorldComparator.field813?false:(Math.abs(var12) > var9 + class18.field300?false:(Math.abs(var13) > var10 + GrandExchangeEvent.field274?false:(Math.abs(var13 * SoundTaskDataProvider.field599 - var12 * class131.field1872) > var9 * GrandExchangeEvent.field274 + var10 * class18.field300?false:(Math.abs(var11 * class131.field1872 - var13 * class131.field1875) > var8 * GrandExchangeEvent.field274 + var10 * OwnWorldComparator.field813?false:Math.abs(var12 * class131.field1875 - var11 * SoundTaskDataProvider.field599) <= var8 * class18.field300 + var9 * OwnWorldComparator.field813))));
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Lbd;",
      garbageValue = "-1192119952"
   )
   static MessageNode method10(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }
}
