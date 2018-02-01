import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class283 extends class207 {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = -551775619
   )
   static int field3718;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1390311161
   )
   public int field3719;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public Name field3715;
   @ObfuscatedName("j")
   public short field3717;

   @ObfuscatedSignature(
      signature = "(Ljr;I)V"
   )
   class283(Name var1, int var2) {
      this.field3719 = (int)(ScriptVarType.currentTimeMs() / 1000L);
      this.field3715 = var1;
      this.field3717 = (short)var2;
   }
}
