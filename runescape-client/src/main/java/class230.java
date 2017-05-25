import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class230 implements class178 {
   @ObfuscatedName("a")
   public final boolean field3158;
   @ObfuscatedName("h")
   static final class230 field3159;
   @ObfuscatedName("u")
   static final class230 field3160;
   @ObfuscatedName("l")
   public final boolean field3161;
   @ObfuscatedName("g")
   static final class230 field3162;
   @ObfuscatedName("v")
   static final class230 field3163;
   @ObfuscatedName("q")
   static final class230 field3164;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1387213203
   )
   public final int field3166;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 418346445
   )
   final int field3167;
   @ObfuscatedName("at")
   protected static String field3168;
   @ObfuscatedName("i")
   static final class230 field3170;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "776439827"
   )
   static World method4156() {
      return World.field1274 < World.field1267?World.worldList[++World.field1274 - 1]:null;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class230(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field3167 = var1;
      this.field3166 = var2;
      this.field3161 = var4;
      this.field3158 = var5;
   }

   static {
      field3170 = new class230(0, -1, true, false, true);
      field3159 = new class230(1, 0, true, true, true);
      field3160 = new class230(2, 1, true, true, false);
      field3164 = new class230(3, 2, false, false, true);
      field3162 = new class230(4, 3, false, false, true);
      field3163 = new class230(5, 10, false, false, true);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3167;
   }
}
