import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class36 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class36 field491;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class36 field492;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static ModIcon[] field493;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 10128781
   )
   final int field500;

   static {
      field491 = new class36(0);
      field492 = new class36(1);
   }

   class36(int var1) {
      this.field500 = var1;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "147010417"
   )
   static int method487() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Lfi;IB)Lfi;",
      garbageValue = "-37"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "259641310"
   )
   public static final boolean method486() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field646 == KeyFocusListener.field638) {
            return false;
         } else {
            class219.field2771 = KeyFocusListener.field641[KeyFocusListener.field638];
            class227.field3118 = KeyFocusListener.field629[KeyFocusListener.field638];
            KeyFocusListener.field638 = KeyFocusListener.field638 + 1 & 127;
            return true;
         }
      }
   }
}
