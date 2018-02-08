import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-753275339"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var1 = IndexFile.method3336(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class222.varpsMasks[var4 - var3];
      return class222.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;I)V",
      garbageValue = "1328938210"
   )
   public static void method57(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;I)V",
      garbageValue = "777144971"
   )
   public static void method55(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class265.field3500 = var0;
      class294.field3803 = var1;
      class2.field9 = var2;
   }
}
