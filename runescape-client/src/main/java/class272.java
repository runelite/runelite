import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class272 extends class273 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1257186361
   )
   public int field3673;
   @ObfuscatedName("i")
   public byte field3674;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field3675;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field3676;

   class272() {
      this.field3675 = class278.field3690;
      this.field3676 = class278.field3690;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "333423527"
   )
   void method4993() {
      this.field3675 = class278.field3690;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-49"
   )
   public final boolean method4996() {
      if(this.field3675 == class278.field3690) {
         this.method4973();
      }

      return this.field3675 == class278.field3691;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1539376846"
   )
   void method4973() {
      this.field3675 = ServerPacket.field2281.field1191.method5038(super.field3678)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1863472074"
   )
   void method4976() {
      this.field3676 = class278.field3690;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "382541364"
   )
   public final boolean method4990() {
      if(this.field3676 == class278.field3690) {
         this.method4978();
      }

      return this.field3676 == class278.field3691;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1185334931"
   )
   void method4978() {
      this.field3676 = ServerPacket.field2281.field1196.method5038(super.field3678)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Lgp;II)Lgp;",
      garbageValue = "58795036"
   )
   @Export("forOrdinal")
   public static MouseWheel forOrdinal(MouseWheel[] var0, int var1) {
      MouseWheel[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         MouseWheel var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }
}
